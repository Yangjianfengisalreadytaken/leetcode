package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 18, 2018 09:47
 */
public class SumSubarrayMins {
    public static void main(String [] sad){
        int [] A = {71,55,82,55};
        SumSubarrayMins mins = new SumSubarrayMins();
        System.out.print(mins.sumSubarrayMins(A));
    }
    int mi = 1000000007;
    public int sumSubarrayMins(int[] A) {
        int []leftBigger = new int[A.length], rightBigger = new int[A.length];
        for(int i = 0;i < A.length; i++){
            leftBigger[i] = countLeftBigger(A, i);
            rightBigger[i] = countRightBigger(A, i);
        }
        int ans = 0;
        for(int i=0;i<A.length;i++){
            int t = leftBigger[i]*rightBigger[i];
            ans = (ans+t*A[i])%mi;
        }
        return ans;
    }

    public int countLeftBigger(int[]A, int k){
        int ans = 0;
        for(int i=k;i>=0;i--){
            if(A[i]>=A[k]){
                ans++;
            }else {
                return ans;
            }
        }
        return ans;
    }

    public int countRightBigger(int []A, int k){
        int ans = 1;
        for(int i=k+1;i<A.length;i++){
            if(A[i]>A[k]){
                ans++;
            }
            else {
                return ans;
            }
        }
        return ans;
    }
}
