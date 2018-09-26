package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 25, 2018 11:25
 */
public class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int h = matrix.length, w = matrix[0].length;
        int [][]ans = new int[h][w];
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(matrix[i][j] != 0){
                    ans[i][j] = pointLen(matrix, i, j);
                }
            }
        }
        return ans;
    }
    public int pointLen(int [][]matrix, int x, int y){
        if(matrix[x][y] == 0){
            return 0;
        }
        for(int i = 1; i < matrix.length+matrix[0].length; i++){
            if(pointL(matrix, x, y, i)){
                return i;
            }
        }
        return matrix.length+matrix[0].length;

    }
    public boolean pointL(int [][]matrix, int x, int y, int l){
        int h = matrix.length, w = matrix[0].length;
        for(int i = 0; i <= l; i++){
            int x0 = x-l+i, y0 = y+i;
            int x1 = x+i, y1 = y+l-i;
            int x2 = x+l-i, y2 = y-i;
            int x3 = x-i, y3 = y-l+i;
            if(x0>=0&&x0<h&&y0>=0&&y0<w&&matrix[x0][y0]==0){
                return true;
            }
            if(x1>=0&&x1<h&&y1>=0&&y1<w&&matrix[x1][y1]==0){
                return true;
            }
            if(x2>=0&&x2<h&&y2>=0&&y2<w&&matrix[x2][y2]==0){
                return true;
            }
            if(x3>=0&&x3<h&&y3>=0&&y3<w&&matrix[x3][y3]==0){
                return true;
            }
        }
        return false;
    }


}
