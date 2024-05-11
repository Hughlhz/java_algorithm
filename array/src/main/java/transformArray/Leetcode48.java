package transformArray;

import annotations.Star;

@Star("旋转矩阵，可以通过对称变换、中心对称变换得到，这样编写代码更高效")
public class Leetcode48 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //对称变换
        //注意java的复制传参
        for (int i = 0; i < n/2; i++) {
            int temp[]=matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n-1-i]=temp;
        }
        //主对角线对称变换
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }
//        //副对角线对称变换
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n - i; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
//                matrix[n - 1 - j][n - 1 - i]=temp;
//            }
//        }
//        //中心对称变换
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                if (i == j && i > n / 2) {
//                    continue;
//                }
//                int temp;
//                temp = matrix[i][j];
//                matrix[i][j] = matrix[n - 1 - i][n - 1 - j];
//                matrix[n - 1 - i][n - 1 - j] = temp;
//            }
//        }
    }
}
