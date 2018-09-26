package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 19, 2018 09:10
 */
public class NumberOfLines {
    public int[] numberOfLines(int[] widths, String S) {
        int lines = 1, lastWidth = 0;
        for(int i = 0; i < S.length(); i++){
            if((lastWidth + widths[S.charAt(i)-'a']) > 100){
                lines ++;
                lastWidth = widths[S.charAt(i)-'a'];
            }else {
                lastWidth += widths[S.charAt(i)-'a'];
            }
        }
        return new int[]{lines, lastWidth};
    }
}
