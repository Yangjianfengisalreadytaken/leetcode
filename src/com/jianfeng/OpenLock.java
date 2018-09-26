package com.jianfeng;

import java.util.Date;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 19, 2018 09:24
 */
public class OpenLock {
    static int dt = 0;
    public static void main(String [] asd){
        Date start = new Date();
        String [] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        OpenLock lock = new OpenLock();
        System.out.println(lock.openLock(deadends, target));
        Date end = new Date();
        System.out.println("begin:"+start+"  end:"+end+"  used:" + dt);
    }
    public int openLock(String[] deadends, String target) {
        boolean [] deads = new boolean[10000];
        int [] reached = new int[10000];
        for(int i=0; i<deads.length; i++){
            reached[i]=21;
        }
        for(String d:deadends){
            deads[Integer.parseInt(d)] = true;
        }
        dfs(deads, reached, Integer.parseInt(target), 0, 0);
        return reached[Integer.parseInt(target)]>=21?-1:reached[Integer.parseInt(target)];
    }
    public void dfs(boolean[] deads, int []reached, int target, int now, int steps){
        if(now<0||now>9999||deads[now]||reached[now]<=steps){
            return;
        }
        reached[now] = steps;
        if(target == now){
            return;
        }
//        dt++;
//        System.out.println(now+"--"+steps);
        dfs(deads, reached, target, (now+1)%10+now/10*10, steps+1);
        dfs(deads, reached, target, (now+9)%10+now/10*10, steps+1);

        dfs(deads, reached, target, (now+10)%100+now/100*100, steps+1);
        dfs(deads, reached, target, (now+90)%100+now/100*100, steps+1);

        dfs(deads, reached, target, (now+100)%1000+now/1000*1000, steps+1);
        dfs(deads, reached, target, (now+900)%1000+now/1000*1000, steps+1);

        dfs(deads, reached, target, (now+1000)%10000, steps+1);
        dfs(deads, reached, target, (now+9000)%10000, steps+1);
    }
}
