package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 25, 2018 10:47
 */
public class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0||matrix[0].length == 0){
            return new int[0];
        }
        int h = matrix.length, w = matrix[0].length;
        int ans[] = new int[h*w];
        boolean up = true;
        int i = 0, j = 0, k = 0 ;
        while (true) {
            ans[k++] = matrix[i][j];
            if (i == h - 1 && j == w - 1) {
                break;
            }
            if (up) {
                if (i > 0 && j < w - 1) {
                    i--;
                    j++;
                } else if (j == w - 1) {
                    i++;
                    up = false;
                } else if (i <= 0) {
                    j++;
                    up = false;
                }
            } else {
                if (i < h - 1 && j > 0) {
                    i++;
                    j--;
                } else if (i == h - 1) {
                    j++;
                    up = true;
                } else if (j <= 0) {
                    i++;
                    up = true;
                }
            }
        }
        return ans;
    }
}
