package com.jianfeng;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 18, 2018 11:19
 */
public class SuperpalindromesInRange {
    public static void main(String []sd){
        SuperpalindromesInRange range = new SuperpalindromesInRange();
//        System.out.print(range.superpalindromesInRange("398904669","13479046850"));
        System.out.print(range.superpalindromesInRange("4","151"));
    }

    public int superpalindromesInRange(String L, String R) {
        long left = Long.parseLong(L), right = Long.parseLong(R);
        int begin = (int) Math.sqrt(left), end = (int) Math.sqrt(right);
        int ans = 0;
        List<Integer> palin = init(end);
        for(long i : palin){
            long temp = i*i;
            if(temp>=left&&temp<right){
                ans++;
            }
        }
        return ans;
    }
    public boolean isPalindrome(String t){
        for(int i=0;i<t.length()/2;i++){
            if(t.charAt(i)!=t.charAt(t.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public List<Integer> init(int end){
        List<Integer> ans = new ArrayList<>();
        dfs(ans,"", end);
        for(int i=0;i<10;i++){
            dfs(ans,i+"", end);
        }
        return ans;
    }
    public void dfs(List<Integer> list, String a, int end){
        if(a.length()>9||(a!=""&&Integer.parseInt(a)>end)){
            return;
        }
        if(a!=""&&a.charAt(0)!='0'&&isPalindrome(Long.parseLong(a)*Long.parseLong(a)+"")){
            list.add(Integer.parseInt(a));
        }
        for(int i=0;i<10;i++){
            dfs(list,i+a+i, end);
        }
    }

    public int superpalindromesInRange1(String l, String r) {
        return calc(Long.valueOf(r)) - calc(Long.valueOf(l) - 1);
    }
    public int calc(long up) {
        if(up == 0) return 0;
        int ans = 0;
        for(int l = 1 ; l <= 9; l++) {
            long tar = l * l;
            if(tar <= up && isPali(String.valueOf(tar))) {
                ans++;
            }
        }

        for(int s = 1 ; ; s++) {
            StringBuilder r = new StringBuilder().append(s);
            String cur = r.toString() + r.reverse();
            long pali = Long.valueOf(cur);
            if(pali * pali > up) break;
            if(isPali(String.valueOf(pali * pali))) {
                ans++;
            }
        }
        for(int i = 0 ; i <= 9 ; i++) {
            for(int s = 1 ; ; s++) {
                StringBuilder r = new StringBuilder().append(s);

                String cur = r.toString()  + i + r.reverse().toString();
                if(cur.length() > 9) break;
                long pali = Long.valueOf(cur);
                if(pali * pali > up) break;
                if(isPali(String.valueOf(pali * pali))) {
                    ans++;
                }
            }
        }
        return ans;
    }

    boolean isPali(String x) {
        for(int s= 0 ; s < x.length() / 2 ; s++) {
            if(x.charAt(s) != x.charAt(x.length() - s - 1)) {
                return false;
            }
        }
//        System.out.println(x);
        return true;
    }
}
