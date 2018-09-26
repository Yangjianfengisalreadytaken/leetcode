package com.jianfeng;

import java.util.*;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 14, 2018 11:21
 */
public class DistanceK {
    TreeNode target = null;
    int K;
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.target = target;
        this.K = K;
        dfs(null, root);
        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> checked = new HashSet<>();
        bianli(ans, checked, target, 0);
        return ans;
    }
    public void bianli(List<Integer> ans, Set<TreeNode> checked, TreeNode now, int m){
        if(now == null||checked.contains(now)){
            return;
        }
        if(K == m){
            ans.add(now.val);
        }
        checked.add(now);
        bianli(ans, checked, now.left, m+1);
        bianli(ans, checked, now.right, m+1);
        bianli(ans, checked, parentMap.get(now), m+1);
    }
    public void dfs(TreeNode parent, TreeNode node){
        if(node==null){
            return;
        }
        if(parent!=null){
            parentMap.put(node, parent);
        }
        dfs(node, node.left);
        dfs(node, node.right);
    }
}
