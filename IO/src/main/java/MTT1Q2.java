import annotations.Star;

import java.io.*;
import java.util.*;
@Star("注意输入输出的区别：1、Scanner会多很多判断、验证，因此速度非常慢，使用BufferedReader每次读取一行，自行处理会比较快 2、System.out.print 每次有数据都会直接刷新到设备，因此效率比较低，使用BufferedWriter||PrintWriter，只在最后提交时进行刷新，可以极大地提升程序效率3、使用spilt时，避免使用正则表达式，虽然帅但是慢")

public class MTT1Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        PrintWriter pw = new PrintWriter(System.out);
//        String[] strings = br.readLine().split("\\s+");

        String[] strings = br.readLine().split(" ");

        int n = Integer.valueOf(strings[0]);
        int q = Integer.valueOf(strings[1]);
        int count = 0;
        long sum = 0;
//        String[] numsStrings = br.readLine().split("\\s+");
        String[] numsStrings = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            long temp = Long.valueOf(numsStrings[i]);
            if (temp == 0) {
                count++;
            }
            sum += temp;

        }

        while (q-- > 0) {
//            String[] lr = br.readLine().split("\\s+");
            String[] lr = br.readLine().split(" ");
            long l = Long.valueOf(lr[0]);
            long r = Long.valueOf(lr[1]);
            long min = sum + l * count;
            long max = sum + r * count;
            bw.write(min + " " + max+"\n");
//            if (q == 0) {
//                return;
//            }

        }
        bw.flush();
    }
    public static void main0(String[] args) {
//使用Scanner和System.out.print 速度非常慢

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        in.nextLine();
        int count = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long temp = in.nextLong();
            if (temp == 0) {
                count++;
            }
            sum += temp;

        }
        in.nextLine();
        while (q-- > 0) {
            long l = in.nextLong();
            long r = in.nextLong();
            long min = sum + l * count;
            long max = sum + r * count;
            System.out.println(min+" "+max);
//            if (q == 0) {
//                return;
//            }
            in.nextLine();
        }
        return;


    }
}
