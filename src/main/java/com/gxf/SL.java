package com.gxf;

import com.gxf.test.TreeNode;
import com.gxf.util.ArrayUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/28 10:27 AM
 **/
public class SL {

  public static void main(String[] args) {
    SL sl = new SL();
    TreeNode root = new TreeNode(5);
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(13);
    root.left = node1;
    root.right = node2;
    sl.preTraver(root);
    System.out.println();
    sl.convertBST(root);
    sl.preTraver(root);
  }

  public TreeNode convertBST (TreeNode root) {
    if (root == null)
      return root;
    List<TreeNode> treeNodeList = new ArrayList<>();
    suffixTraver(root, treeNodeList);
    int preSum = treeNodeList.get(0).val;
    for (int i = 1; i < treeNodeList.size(); i++) {
      TreeNode curTreeNode = treeNodeList.get(i);
      int tmpVal = curTreeNode.val;
      curTreeNode.val += preSum;
      preSum += tmpVal;
    }
//    treeNodeList.get(treeNodeList.size() - 1).val += preSum;
    return root;
  }

  private void suffixTraver(TreeNode root, List<TreeNode> treeNodeList) {
    if (root == null)
      return ;
    suffixTraver(root.right, treeNodeList);
    treeNodeList.add(root);
    suffixTraver(root.left, treeNodeList);
  }

  private void preTraver(TreeNode root) {
    if (root == null)
      return;
    preTraver(root.left);
    System.out.print(root.val + " ");
    preTraver(root.right);
  }

  public  int numIslands(char[][] grid) {
    char index = '2';
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j, index ++);
        } //if
      } //for
    } //for
    System.out.println();
    return index - '0'- 1;
  }

  private  void dfs(char[][] nums, int i, int j, char index){
    if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length)
      return;
    nums[i][j] = index;
    //上、右、下、左
    if (i - 1 >= 0 && nums[i - 1][j] == '1')
      dfs(nums, i - 1, j, index);
    if (j + 1 < nums[0].length && nums[i][j + 1] == '1')
      dfs(nums, i, j + 1, index);
    if (i + 1 < nums.length && nums[i + 1][j] == '1')
      dfs(nums, i + 1, j, index);
    if (j - 1 >= 0 && nums[i][j - 1] == '1')
      dfs(nums, i, j - 1, index);
  }

  public int[] sortedSquares(int[] A) {
    for (int i = 0; i < A.length; i++) {
      A[i] *= A[i];
    }
    Arrays.sort(A);
    return A;
  }

  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      int j = 1;
      while (i - j * j >= 0){
        min = Math.min(min, dp[i - j * j] + 1);
        j ++;
      }
      dp[i] = min;
    }
    return dp[n];
  }

  private int getLeastNs(int[] elements, int n) {
    int length = elements.length;
    for (int i = length - 1; i >= 0; i--) {
      if (n == elements[i])
        return 1;
      else if (n > elements[i])
        return 1 + getLeastNs(elements, n - elements[i]);
      else
        continue;
    }
    return 0;
  }
}
