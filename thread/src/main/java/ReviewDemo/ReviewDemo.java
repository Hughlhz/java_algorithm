package ReviewDemo;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ReviewDemo.sort.HeapSort.heapSort;

public class ReviewDemo {

    public static void main(String[] args) {
        ReviewDemo reviewDemo = new ReviewDemo();
        //1、复习排序 快速排序 归并排序 堆排序 利用快排找第k大的数字
        int nums[]={5,2,7,3,2,1,6,9,0};
//        quickSort(nums,0,nums.length-1);
//        mergeSort(nums, 0, nums.length - 1);
        heapSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
        //2、复习stream
//        //2.1数组转stream 并收集
//          //2.1.1 基本类型流 提供了一些额外的计算方法 和 转引用类型的方法
        String s1 = Arrays.stream(nums).boxed().map(e -> String.valueOf(e)).collect(Collectors.joining(",","[","]"));
        String s2 = Arrays.stream(nums).mapToObj(e -> String.valueOf(e)).collect(Collectors.joining(",","[","]"));
        OptionalDouble average = Arrays.stream(nums).average();
        int i = Arrays.stream(nums).max().orElse(0);
        IntStream sorted = Arrays.stream(nums).sorted();
            //2.1.2 引用类型流 提供了通用的stream的方法 和 转基本类型的方法
        Integer ints[]=new Integer[]{1,2,3,4,5,6,7,8};
        IntStream intStream = Arrays.stream(nums);
        Stream<Integer> stream = Arrays.stream(ints);
//        IntStream intStream1 = stream.mapToInt(Integer::intValue);
        stream.sorted(((o1, o2) -> o2 - o1)).forEach(System.out::println);
        Integer[] array = Arrays.stream(ints).toArray(Integer[]::new);
//        List<Integer> list = Arrays.stream(ints).collect(Collectors.toList());
        Map<Integer, Integer> collect = Arrays.stream(ints).collect(Collectors.toMap(e -> e, e -> 2 * e));
          //2.2集合转stream并收集 双列集合也只能先转成单列
        List<String> stringList = new ArrayList<>(Arrays.asList("123", "21312", "kk213"));
        stringList.stream().forEach(System.out::println);
        collect.entrySet().stream().forEach(System.out::println);
        System.out.println(s1.equals(s2));
        //3、复习容器
            //3.1 map
        collect.compute(0,(k,v)->k+1);
        collect.computeIfAbsent(-1, e->e*2);
        collect.computeIfPresent(1,(k,v)->k+v);
            //3.2 priorityQueue 基于堆排序实现
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        priorityQueue.add(new int[]{1, 10});
        priorityQueue.add(new int[]{2, 1});
        priorityQueue.add(new int[]{2, 10});
        priorityQueue.add(new int[]{1, 1});
        priorityQueue.add(new int[]{1, 15});
        priorityQueue.offer(new int[]{13, 10});
        for (int i1 : priorityQueue.peek()) {
            System.out.println(i1);
        }
            //3.3 LinkedList 方法区分
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);//尾插
        linkedList.offer(2);//尾插 队尾插入
        linkedList.push(0);//头插
        linkedList.addFirst(-1);//头插
        System.out.println(linkedList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        Integer peek = linkedList.peek();// 查看栈顶 也即队列头部
        linkedList.getFirst();
        linkedList.getLast();
        Integer pop = linkedList.pop();//移除栈顶 也即队列头部
        System.out.println(pop);
        Integer poll = linkedList.poll();//移除队头 也即队列头部
        System.out.println(poll);
        linkedList.removeLast();
        linkedList.removeFirst();
        //4、复习比较器
        CompareDemo[] compareDemos=new CompareDemo[5];
        compareDemos[0] = new CompareDemo(20, "aaa", 1);
        compareDemos[1] = new CompareDemo(21, "aaa", 1);
        compareDemos[2] = new CompareDemo(20, "bb", 0);
        compareDemos[3] = new CompareDemo(18, "ccc", 0);
        compareDemos[4] = new CompareDemo(20, "cc", 0);
        Arrays.sort(compareDemos);
        Arrays.stream(compareDemos).forEach(System.out::println);
        List<CompareDemo> list=new ArrayList<>();
        list.add(new CompareDemo(20, "aaa", 1));
        list.add( new CompareDemo(21, "aaa", 1));
        list.add( new CompareDemo(20, "bb", 0));
        list.add( new CompareDemo(18, "ccc", 0));
        list.add( new CompareDemo(20, "cc", 0));
        Collections.sort(list);
        list.stream().forEach(System.out::println);

    }

    private void testNio() throws IOException {
        Selector selector = Selector.open();
        ServerSocket serverSocket = new ServerSocket(7890);
        ServerSocketChannel serverSocketChannel = serverSocket.getChannel();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                    SocketChannel accept = ((ServerSocketChannel) key.channel()).accept();
                    accept.configureBlocking(false);
                    accept.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {

                }
            }
        }
    }


}
