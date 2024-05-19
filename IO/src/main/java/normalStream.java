import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class normalStream {
    public static void main(String[] args) {

        //1、IntStream、LongStream和DoubleStream 三个特殊的流 ==========================================
        // 为了效率，避免自动拆装，直接使用基本类型
        // 不能和其他互转 要互转只能用mapToObj()(Stream<T> 没有这个方法）
        // 增加了一些统计方法 比如sum() average()
        // 区分LongStream和Stream<Long>的区别，一个是原始基本类型的流，一个是引用类型的流
        // 基本类型的流的map方法，只能转成本类型
        int[] nums1 = {1, 2, 3, 4};//基本类型流
        Long[] nums2 = {1l, 2l, 3l, 4l};
        String[] strings = {"ssss", "11111"};
        Character[] chars = {'c', 'c'};//引用类型流
//        下方代码报错
//        Arrays.stream(nums1).map(e -> String.valueOf(e)).collect(Collectors.joining(" "));
//        Arrays.stream(nums1).map(e->String.valueOf(e)).collect
        Arrays.stream(strings).forEach(System.out::println);
        Arrays.stream(chars).forEach(System.out::println);
//        Arrays.stream(nums2).map(e->String.valueOf(e)).collect(Collectors.joining(" "));

        //2、数组转stream===========================================
//        int long double -> IntStream、LongStream和DoubleStream这三种流
//        Integer Long Double ... -> Stream<Integer> Stream<Long> Stream<Double> Stream<...>
//        Arrays.stream(nums2).forEach(e -> System.out.println(e.TYPE));

        Arrays.stream(nums1).boxed();
        Arrays.stream(nums2).collect(Collectors.toList());
        List<Character> CL = Arrays.stream(chars).collect(Collectors.toList());
        for (Character c : CL) {
            System.out.print(c + " ");
        }
//        Arrays.stream(new char[]{'1', '2'});
        //基本类型流有boxed方法可以装箱成Stream<T>
        List<Integer> list = "12345".chars().boxed().toList();
        //3、流的收集
        // 基本类型流无法收集，先用boxed方法装箱
            //收集到list
        //注意 直接toList()会得到一个不可变的结果 用collect()收集才可以得到可变的结果
        List<Integer> ints = "12345".chars().boxed().collect(Collectors.toList());
        List<Integer> constInts = "12345".chars().boxed().toList();

        ints.stream().forEach(System.out::println);
            //收集到set
        Set<Integer> intsSet = "12345".chars().boxed().collect(Collectors.toSet());
        "12345".chars().boxed().collect(Collectors.toList());
            //收集到map
        Map<Integer, Character> intsMap = "12345".chars().boxed().collect(Collectors.toMap(e -> e - '0', e -> Character.valueOf((char) (int) e)));
        for (Map.Entry<Integer, Character> e : intsMap.entrySet()) {
            System.out.println(e.getKey() + "---->" + e.getValue());
        }
            //收集到数组
        Stream<String> stream = Stream.of("One", "Two", "Three", "Four", "Five");
        String[] array = stream.toArray(String[]::new);
        Stream<String> streamNums = Stream.of("12", "34", "56", "78", "90");
        Integer[] array1 = streamNums.map(Integer::valueOf).toArray(Integer[]::new);
        //4、拼接流
        //使用Collectors.join() 方法拼接，要求流对象都是String类型
        System.out.println(ints.stream().map(e -> String.valueOf(e)).collect(Collectors.joining("--->")));
        //5、String -> List<Character> List<Integer> List<Long>等 ***
        //这部分 算法题里常用
            //i. 空格隔开 较好处理
        String s = "1 2 3 4 5 6";
        Arrays.stream(s.split(" "));//这里得到的是Stream<String>
            //ii. 连续单词，拆分到list中
        String s1 = "darling";
            //这两种方式都能转成Stream<Character> 注意，前面是在简单类型转，后面是在引用类型转
        List<Character> list1 = s1.chars().mapToObj(e -> Character.valueOf((char) e)).toList();
        List<Character> list2 = s1.chars().boxed().map(e -> Character.valueOf((Character) (char) e.intValue())).toList();
    }
}
