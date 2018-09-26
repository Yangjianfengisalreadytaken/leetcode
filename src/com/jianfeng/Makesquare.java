package com.jianfeng;

import java.util.Arrays;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 20, 2018 16:41
 */
public class Makesquare {
    public boolean makesquare(int[] nums) {
        int target = 0;
        if(nums.length<4){
            return false;
        }
        Arrays.parallelSort(nums);
        int j = nums.length;
        int []newNums = new int[j];
        for(int num:nums){
            target+=num;
            newNums[--j] = num;
        }
        return target%4==0?dfs(newNums, 0, new int[4], target/4):false;
    }
    public boolean dfs(int [] nums, int now ,int []bian, int target){
        if(bian[0]>target||bian[1]>target||bian[2]>target||bian[3]>target){
            return false;
        }
        if(now>=nums.length){
            return true;
        }
        return dfs(nums, now+1, new int[]{bian[0]+nums[now], bian[1], bian[2], bian[3]}, target)
                ||dfs(nums, now+1, new int[]{bian[0], bian[1]+nums[now], bian[2], bian[3]}, target)
                ||dfs(nums, now+1, new int[]{bian[0], bian[1], bian[2]+nums[now], bian[3]}, target)
                ||dfs(nums, now+1, new int[]{bian[0], bian[1], bian[2], bian[3]+nums[now]}, target);
    }
}
