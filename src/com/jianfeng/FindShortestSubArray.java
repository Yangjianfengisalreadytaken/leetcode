package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 20, 2018 15:26
 */
public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        int size = 50000;
        int [] length = new int[size], begin = new int[size], end = new int[size];
        int maxlength = 0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(length[num] == 0){
                begin[num] = i;
            }
            length[num]++;
            end[num] = i;
            maxlength = Math.max(maxlength, length[num]);
        }
        int ans = nums.length;
        for(int i = 0;i < size; i++){
            if(length[i]==maxlength){
                ans = Math.min(ans, end[i]-begin[i]+1);
            }
        }
        return ans;
    }
}
