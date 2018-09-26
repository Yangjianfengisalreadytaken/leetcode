package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 18, 2018 09:14
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int ans[] = new int[A.length];
        int left = 0, right = A.length-1;
        for(int i:A){
            if((i&1)>0){
                ans[right--] = i;
            }else{
                ans[left++] = i;
            }
        }
        return ans;
    }
}
