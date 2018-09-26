package com.jianfeng;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 14, 2018 11:06
 */
public class LemonadeChange {
    public static void main(String [] sd){
        int[] bills = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        LemonadeChange change = new LemonadeChange();
        change.lemonadeChange(bills);
    }
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int i:bills){
            if(i == 5){
                five++;
            }else if(i == 10){
                five--;
                ten++;
            }else{
                if(ten == 0){
                    five = five - 3;
                }else {
                    five--;
                    ten--;
                }
            }

            if(five < 0 || ten < 0){
                return false;
            }
        }
        return true;
    }
}
