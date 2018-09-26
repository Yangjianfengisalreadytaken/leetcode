package com.jianfeng;

import java.util.Arrays;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 19, 2018 15:37
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int[] ans = new int[amount+1];
        for(int i=1;i<ans.length;i++){
            for(int coin:coins){
                if(i-coin==0){
                    ans[i]=1;
                    continue;
                }
                if(i-coin<0||ans[i-coin]==0){
                    continue;
                }
                ans[i] = ans[i]==0?ans[i-coin]+1:Math.min(ans[i],ans[i-coin]+1);
            }
        }
        return ans[amount]==0?-1:ans[amount];
    }

}
