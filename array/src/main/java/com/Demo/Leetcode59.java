package com.Demo;

import annotations.Star;

@Star("仔细观察矩阵生成的过程，找到规律并模拟")
public class Leetcode59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int circle_nums = (n + 1) / 2;
        int circle_count = 0;
        int count = 1;
        int width = n;
        int x = 0, y = 0;
        for (; circle_count < circle_nums; circle_count++) {
            for (int i = 0; i < width - 1; i++) {
                result[x][y] = count++;
                y++;
            }
            for (int i = 0; i < width - 1; i++) {
                result[x][y] = count++;
                x++;
            }

            for (int i = 0; i < width - 1; i++) {
                result[x][y] = count++;
                y--;
            }
            for (int i = 0; i < width - 1; i++) {
                result[x][y] = count++;
                x--;
            }
            x++;
            y++;
            width -= 2;
        }
        if (n % 2 == 1) result[n / 2][n / 2] = n * n;
        return result;
    }
}
