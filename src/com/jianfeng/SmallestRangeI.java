package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 25, 2018 09:58
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        int max = A[0], min = A[0];
        for(int i:A){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int t = (max - min) - K * 2;
        return t>0?t:0;
    }
}
