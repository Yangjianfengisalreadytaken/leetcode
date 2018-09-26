package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 20, 2018 17:18
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, summary = 1, left= 0;
        for(int right= 0; right < nums.length; right++){
            summary *= nums[right];
            while (summary>=k&&left<=right)summary /= nums[left++];
            ans += right-left+1;
        }
        return ans;
    }
}
