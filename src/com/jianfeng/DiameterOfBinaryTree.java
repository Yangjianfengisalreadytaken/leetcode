package com.jianfeng;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 25, 2018 14:19
 */
public class DiameterOfBinaryTree {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans == 0?0:ans-1;
    }

    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        ans = Math.max(ans, left+right+1);
        return Math.max(left, right)+1;
    }
}
