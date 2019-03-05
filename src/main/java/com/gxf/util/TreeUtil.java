package com.gxf.util;

import com.gxf.lt.TreeNode;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/2/11 11:00 PM
 **/
public class TreeUtil {

  /**
   * 先序遍历二叉树 左根右
   * */
  public static void preOrderTravelBinaryTree(TreeNode root) {
    if (root == null)
      return;
    preOrderTravelBinaryTree(root.left);
    System.out.print(root.val + " ");
    preOrderTravelBinaryTree(root.right);
  }
}
