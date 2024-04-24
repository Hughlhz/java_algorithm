package multiSort;

import annotations.Star;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Star("多维度排序的题目，可以通过重写compare()")
public class Q2 {

//    4 5
//    11100 00111 10111 01111
//    2 10
//    1011100111 1011101101

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] params = br.readLine().split(" ");
        Integer n = Integer.valueOf(params[0]);
        Integer m = Integer.valueOf(params[1]);
        String[] pratice = br.readLine().split(" ");
        // 进球总数
        // 连续进球数
        // 0 的位置
        // 编号更小

        int[] goals = new int[n];
        int[] continuous = new int[n];
        List<Integer> candiate = IntStream.range(0, n).boxed().collect(Collectors.toList());
        List<List<Integer>> zeroIndex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int conGoal=0;
            for (int j = 0; j < m; j++) {
                if (pratice[i].charAt(j) == '1') {
                    goals[i]++;
                    conGoal++;
                    continuous[i] = Math.max(continuous[i], conGoal);
                } else {
                    conGoal=0;
                    list.add(j);
                }
            }
            zeroIndex.add(new ArrayList<>(list));
        }
        Collections.sort(candiate, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (goals[o1] != goals[o2]) {
                    return goals[o1] - goals[o2];
                }
                else if (continuous[o1] != continuous[o2]) {
                    return continuous[o1] - continuous[o2];
                }else{
                    for (int i = 0; i < zeroIndex.size(); i++) {
                        if (zeroIndex.get(o1).get(i) != zeroIndex.get(o2).get(i)) {
                            return zeroIndex.get(o1).get(i) - zeroIndex.get(o2).get(i);
                        }
                    }
                    return o1-o2;
                }
            }
        });
        Collections.reverse(candiate);
        System.out.println(candiate.stream().map(e -> String.valueOf(e+1)).collect(Collectors.joining(" ")));

    }



    //这样比太费脑子了。。。
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] params = br.readLine().split(" ");
//        Integer n = Integer.valueOf(params[0]);
//        Integer m = Integer.valueOf(params[1]);
//        String[] pratice = br.readLine().split(" ");
//        // 进球总数
//        // 连续进球数
//        // 0 的位置
//        // 编号更小
//
//        int[] goals = new int[n];
//        int[] continuous = new int[n];
//        List<Integer> maxCandiate = new ArrayList<>();
//        int max=0;
//
//        List<List<Integer>> zeroIndex = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int j = 0; j < m; j++) {
//                int conGoal=0;
//                if (pratice[i].charAt(j) == '1') {
//                    goals[i]++;
//                    conGoal++;
//                    continuous[i] = Math.max(continuous[i], conGoal);
//                } else {
//                    conGoal=0;
//                    list.add(j);
//                }
//            }
//            if (max > goals[i]) {
//                continue;
//            } else if (max == goals[i]) {
//                maxCandiate.add(i);
//            }else {
//                list.clear();
//                list.add(i);
//            }
//
//
//            zeroIndex.add(new ArrayList<>(list));
//        }
//        if (maxCandiate.size() == 1) {
//            System.out.println(maxCandiate.get(0));
//            return;
//        }
//        int conMax=0;
//        Iterator<Integer> iterator = maxCandiate.iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            if (conMax > continuous[next]) {
//                conMax = continuous[next];
//            } else if (conMax == continuous[next]) {
//                continue;
//            }else {
//                iterator.remove();
//
//            }
//        }
//        if (maxCandiate.size() == 1) {
//            System.out.println(maxCandiate.get(0));
//        }
//
//        //比较第一次丢球、第二次丢球
//        while (maxCandiate.size()>1)
//
//
//
//
//    }
}
