package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 25, 2018 16:43
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        TreeNode parent = new TreeNode(0);
        parent.left = root;
        dfs(parent, root, true);
        return parent.left;
    }
    public void dfs(TreeNode parent, TreeNode node, boolean left){
        if (node==null){
            return;
        }
        dfs(node, node.left, true);
        dfs(node, node.right, false);
        if(node.left==null&&node.right==null&&node.val==0){
            if (left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
    }

}
