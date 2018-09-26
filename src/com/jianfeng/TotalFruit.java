package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 18, 2018 09:25
 */
public class TotalFruit {
    public static void main(String [] argv){
        TotalFruit fruit = new TotalFruit();
        int A[] = {1,2,1};
        System.out.print(fruit.totalFruit(A));
    }
    public int totalFruit(int[] tree) {
        int ans = 0;
        for(int i=0; i<tree.length; i++){
            ans = Math.max(ans, count(tree, i));
        }
        return ans;
    }
    public int count(int[] tree, int begin){
        int ans = 1, left = tree[begin], right = -1;
        for(int i = begin+1; i<tree.length; i++){
            if(tree[i] == left){
                ans ++;
            }
            else if(right<0||right==tree[i]){
                right = tree[i];
                ans ++;
            }
            else {
                return ans;
            }
        }
        return ans;
    }
}
