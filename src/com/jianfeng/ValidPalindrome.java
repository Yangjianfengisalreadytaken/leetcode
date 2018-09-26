package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 18, 2018 20:11
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        return valid(s.toCharArray(), 0, s.length()-1, false);
    }
    public boolean valid(char[] s, int left, int right, boolean deleted){
        int l = left, r = right;
        while (l<r){
            if(s[l]!=s[r]){
                if(deleted){
                    return false;
                }
                return valid(s,l+1,r,true)||valid(s,l,r-1,true);
            }
            l++;
            r--;
        }
        return true;
    }
}
