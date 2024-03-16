import java.io.File;
import java.io.IOException;
import java.lang.module.ResolvedModule;
import java.net.URL;
import java.util.*;

public class ShowMeStar {

    public static void main(String[] args) throws IOException {
        ModuleLayer layer = ModuleLayer.boot();
        ClassLoader backtracking = layer.findLoader("utils");
        List<File> dirs = new ArrayList<>();
        Enumeration<URL> resources = backtracking.getResources("");
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            System.out.println(resource.getPath());
            dirs.add(new File(resource.getFile()));
        }

    }
    public static void main_(String[] args) throws IOException {


        String moduleName = "backtracking";
        String packageName = "review.backtracking";
        String packagePath = packageName.replace('.', '/');
//        String path = "./" + moduleName + "/src/main/java/" + packagePath;
        String path = moduleName + "/target/main/java/" + packagePath;
        System.out.println(path);
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        List<String> allClassFile = getAllClassFile(path);

        System.out.println(allClassFile.size());
        System.out.println(allClassFile);
    }

    public static List<String> getAllClassFile(String path) {
        List<String> classFiles = new ArrayList<>();
        File dirs = new File(path);
        for (File file : dirs.listFiles()) {
            if (file.isDirectory()) {
                classFiles.addAll(getAllClassFile(file.getPath()));
            } else if (file.isFile() && file.getName().endsWith(".class")) {
                classFiles.add(file.getPath());
            }
        }
        return classFiles;
    }
}
