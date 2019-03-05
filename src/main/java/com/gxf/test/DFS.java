package com.gxf.test;

import com.gxf.util.ArrayUtil;
import java.util.Stack;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/9 3:19 PM
 **/
public class DFS {

  public static void main(String[] args) {
    int[] array = {9, 1, 29, 30, 40, 2, 70, 5};
    ArrayUtil.printIntArray(array);
    iS(array);
//    bS(array);
//    sS(array);
    ArrayUtil.printIntArray(array);
  }

  private static void iS(int[] array){
    for(int i = 1; i < array.length; i++){
      for(int j = i; j > 0 && array[j] < array[j - 1]; j--){
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
      }
    }
  }

  private static void bS(int[] array) {
    for(int i = 0; i < array.length; i++){
      boolean isChanged = false;
      for(int j = i + 1; j < array.length - i; j++){
        if(array[j - 1] > array[j]) {
          isChanged = true;
          int temp = array[j - 1];
          array[j - 1] = array[j];
          array[j] = temp;
        }
      }
      if(!isChanged)
        break;
    }
  }

  private static void sS(int[] array){
    for(int i = 0; i < array.length; i++) {
      int maxIndex = i;
      for(int j = i + 1; j < array.length; j++){
        maxIndex = array[j] > array[maxIndex] ? j : maxIndex;
      }
      if(i != maxIndex){
        int temp = array[i];
        array[i] = array[maxIndex];
        array[maxIndex] = temp;
      }
    }
  }

  private static void qS(int array[], int s, int e){
    if(s < e){
      int l = s;
      int r = e;
      int povivate = array[l];
      while(l < r){
        while(l < r && array[r] > povivate)
          r --;
        if(l < r)
          array[l ++] = array[r];
        while(l < r && array[l] < povivate)
          l ++;
        if(l < r)
          array[r --] = array[l];
      }
      array[l] = povivate;
      ArrayUtil.printIntArray(array);
      qS(array, s, l - 1);
      qS(array, l + 1, e);
    }
  }

  private static void inOrder(TreeNode root) {
    Stack<TreeNode> treeNodeStack = new Stack<>();
    while(root != null || !treeNodeStack.isEmpty()) {
      while(root != null) {
        treeNodeStack.push(root);
        root = root.left;
      }
      if(!treeNodeStack.isEmpty()){
        root = treeNodeStack.pop();
        System.out.print(root.val + " ");
        root = root.right;
      }
    }
  }


  private static void preOrder(TreeNode root) {
    Stack<TreeNode> nodeStack = new Stack<>();
    while(root != null || !nodeStack.isEmpty()) {
      while(root != null){
        System.out.print(root.val + " ");
        nodeStack.push(root);
        root = root.left;
      }
      if(!nodeStack.isEmpty()) {
        root = nodeStack.pop().right;
      }
    }
  }

  private static void dfs(TreeNode root) {
    if(root == null)
      return;
    System.out.print(root.getValue() + " ");
    dfs(root.getLeft());
    dfs(root.getRight());
  }

  private static TreeNode buildTree () {
    TreeNode root = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);

    root.setLeft(node1);
    root.setRight(node2);

    node1.setLeft(node3);
    node1.setRight(node4);

    node2.setLeft(node5);

    return root;
  }


}
