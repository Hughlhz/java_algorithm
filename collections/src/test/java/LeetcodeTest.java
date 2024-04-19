import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetcodeTest {
    @Test
    public void testLeetcode921() {

        Nowcoder leetcode921 = new Nowcoder();
        leetcode921.minBrace("[(])]]]");
    }
    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1111);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);
        objects.add(6);
        objects.add(7);
        objects.add(8);
        objects.add(9);
        System.out.println(objects.stream().map(e -> String.valueOf(e)).collect(Collectors.joining(" ")));
        objects.stream().filter(e->e>5).collect(Collectors.toList()).forEach(System.out::println);

        Map<Integer, Integer> map = objects.stream().collect(Collectors.toMap(e->e, e-> e * 2));
        map.merge(5,1,(e1,e2)->e1+e2);
        System.out.println(map.compute(1, (k, v) -> v == null ? 1 : v + 1));
        System.out.println(map.compute(5, (k, v) -> null));//会导致键值对5被删除


        map.forEach((k, v) -> System.out.println(k + "--->" + v));
        System.out.println(map.entrySet().stream().map(e -> e.getKey() + "--->" + e.getValue()).collect(Collectors.joining(",", "[", "]")));
        List<String> collect = map.entrySet().stream().map(e -> e.getKey() + "--->" + e.getValue()).toList();

    }
}
