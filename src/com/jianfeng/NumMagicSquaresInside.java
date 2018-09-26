package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 17, 2018 11:13
 */
public class NumMagicSquaresInside {
    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length-2; i++){
            for(int j=0; j<grid[i].length-2; j++){
                ans += count(grid, i ,j);
            }
        }
        return ans;
    }
    public int count(int [][]grid, int i, int j){
        boolean[] exists = new boolean[10];
        int t = 0;
        for(int i1=i;i1<i+3;i1++){
            int line = 0;
            for(int j1=j;j1<j+3;j1++){
                line += grid[i1][j1];
                if(grid[i1][j1]>9||grid[i1][j1]<1||exists[grid[i1][j1]]){
                    return 0;
                }
                exists[grid[i1][j1]] = true;
            }
            if(t!=0&&t!=line){
                return 0;
            }
            t = line;
        }
        for(int j1 = j; j1 < j+3; j1++){
            int line = 0;
            for(int i1 = i; i1 < i+3; i1++){
                line += grid[i1][j1];
            }
            if(t!=line){
                return 0;
            }
        }
        int x = grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
        int y = grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j];
        if(t!=x||t!=y){
            return 0;
        }
        return 1;
    }
}
