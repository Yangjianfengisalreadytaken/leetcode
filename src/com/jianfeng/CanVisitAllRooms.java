package com.jianfeng;

import java.util.List;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 17, 2018 11:39
 */
public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for(boolean b:visited){
            if(!b){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms, int key, boolean []visited){
        if(visited[key]){
            return;
        }
        visited[key] = true;
        for(int i:rooms.get(key)){
            dfs(rooms, i, visited);
        }
    }
}
