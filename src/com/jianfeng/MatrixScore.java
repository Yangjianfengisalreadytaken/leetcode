package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 14, 2018 12:10
 */
public class MatrixScore {
    public static void main(String [] arg){
        MatrixScore score = new MatrixScore();
        int [][]A={{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.print(score.matrixScore(A));
    }

    public int matrixScore(int[][] A) {
        for(int i = 0; i < A.length; i++){
            if(A[i][0]==0){
                crossReversal(A, i);
            }
        }
        for(int i=1; i<A[0].length; i++){
            int zero = 0;
            for(int j=0; j<A.length; j++){
                if(A[j][i]==0){
                    zero++;
                }
            }
            if(zero>A.length>>1){
                lineReversal(A, i);
            }
        }
        return countAdd(A);
    }
    public void crossReversal(int [][] A, int k){
        for(int i = 0; i < A[k].length; i++){
            A[k][i] = (1+A[k][i])&1;
        }
    }
    public void lineReversal(int [][] A, int k){
        for(int i = 0; i < A.length; i++){
            A[i][k] = (1+A[i][k])&1;
        }
    }
    public int countAdd(int [][] A){
        int ans = 0;
        for(int i=0; i<A.length; i++){
            int line = 0;
            for(int j=0; j<A[i].length; j++){
                line = (line<<1) + A[i][j];
            }
            ans += line;
        }
        return ans;
    }
}
