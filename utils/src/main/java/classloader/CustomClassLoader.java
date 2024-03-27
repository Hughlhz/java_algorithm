package classloader;
import annotations.Star;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class CustomClassLoader extends ClassLoader {

    private String baseDir;

    public CustomClassLoader(String baseDir) {
        this.baseDir = baseDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String classFilePath = baseDir + File.separator + name.replace('.', File.separatorChar) + ".class";
            System.out.println(classFilePath);

            byte[] classBytes = readClassBytes(classFilePath);
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Failed to load class " + name, e);
        }
    }

    private byte[] readClassBytes(String classFilePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(classFilePath);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            return bos.toByteArray();
        }
    }

    public static void main(String[] args) {
        // 创建自定义类加载器实例，指定类文件所在的基础目录
        CustomClassLoader classLoader = new CustomClassLoader("LeetcodeHot100\\target\\classes");
//        System.out.println(System.getProperty("user.dir"));

        try {
            // 使用自定义类加载器加载指定类
            Class<?> clazz = classLoader.loadClass("hot100.linkedlist.Leetcode002");
            // 进行操作，比如实例化对象等
            Object instance = clazz.newInstance();
            Star annotation = clazz.getAnnotation(Star.class);
            System.out.println(annotation.value());
            // 调用对象的方法
            // ...
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

