package children;

import annotations.Star;

import java.lang.reflect.Array;
import java.util.*;

@Star("注意map的几个方法包括computeIfAbsent，merge，compute，非常灵活&&注意字符串比较用equals&&注意set和list的选用&&深度搜索的写法")
public class CloudService {
    static Set<String> roots = new HashSet<>();
    static HashMap<String, Integer> severeMap = new HashMap<>();
    static HashMap<String, Integer> mediumMap = new HashMap<>();
    static HashMap<String, HashSet<String>> childrenMap = new HashMap<>();
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] params = s.split(" ");
            if (params[1].equals("*")) {
                // 如果是根节点
                roots.add(params[0]);

            } else {
                //如果不是根节点

//                if (childrenMap.containsKey(params[1])) {
//                    childrenMap.get(params[1]).add(params[0]);
//                }else {
//                    childrenMap.put(params[1], new HashSet<>(Arrays.asList(params[0])));
//                }
                childrenMap.computeIfAbsent(params[1], k -> new HashSet<>()).add(params[0]);

            }
            if(params[2].equals("0"))
                severeMap.put(params[0], Integer.valueOf(params[3]));
            else
                mediumMap.put(params[0], Integer.valueOf(params[3]));
        }
        int count = 0;
        for (String root : roots) {
            int sum = 0;
            sum = dfs(root);
            if (sum > m) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int dfs(String node) {
        int sum = severeMap.getOrDefault(node,0) * 5 + mediumMap.getOrDefault(node,0) * 2; // Include the score of the node itself
        Set<String> children = childrenMap.get(node);
        if (children != null) {
            for (String n : children) {
                sum += dfs(n);
            }
        }
        return sum;
    }

    //    private static int dfs(Node node) {
//        if (node.children.size() == 0) {
//            return 0;
//        }
//        int sum=0;
//        for (Node n : node.children) {
//            sum+= dfs(n) + node.medium * 2 + node.severe * 5;
//        }
//        return sum;
//    }


}
