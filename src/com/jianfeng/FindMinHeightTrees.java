package com.jianfeng;

import java.util.*;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 25, 2018 14:38
 */
public class FindMinHeightTrees {
    public static void main(String[] ss){
        FindMinHeightTrees trees = new FindMinHeightTrees();
        List<Integer> ans = trees.findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}});
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int p = edges[i][0], q = edges[i][1];
            if(graph.get(p)==null){
                graph.put(p, new HashSet<>());
            }
            if(graph.get(q)==null){
                graph.put(q, new HashSet<>());
            }
            graph.get(p).add(q);
            graph.get(q).add(p);
        }
        while (graph.size()>2){
            List<int[]> mins1 = new ArrayList<>();
            for(int i = 0; i<n; i++){
                if(graph.get(i)!=null && graph.get(i).size()==1){
                    Iterator iterator = graph.get(i).iterator();
                    int k = (int) iterator.next();
                    mins1.add(new int[]{k,i});
                    graph.remove(i);
                }
            }
            for(int[] aa:mins1){
                graph.get(aa[0]).remove(aa[1]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Set<Integer>> entry:graph.entrySet()){
            ans.add(entry.getKey());
        }
        if(ans.size()==0){
            ans.add(0);
        }
        return ans;
    }
}
