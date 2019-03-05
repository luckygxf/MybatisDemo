package com.gxf.lt;

import com.gxf.util.ArrayUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/1 1:41 PM
 **/
class Solution {


  public static void main(String[] args) {
    Solution sol = new Solution();
    String s1 = "1234";
    String s2 = "234";
    String res = sol.addStrings(s1, s2);
    System.out.println(res);
  }

  public String addStrings(String num1, String num2) {
    if (num1 == null || num2 == null)
      return num1 == null ? num1 : num2;
    int l1 = num1.length();
    int l2 = num2.length();
    while (l1 < l2) {
      num1 = "0" + num1;
      l1 ++;
    }
    while (l2 < l1) {
      num2 = "0" + num2;
      l2 ++;
    }
    int carry = 0;
    StringBuilder sum = new StringBuilder();
    for (l1 = l1 - 1; l1 >= 0; l1--) {
      int tempSum = num1.charAt(l1) + num2.charAt(l1) - 2 * '0' + carry;
      sum.insert(0, tempSum % 10);
      carry = tempSum / 10;
    } //for
    if (carry == 1)
      sum.insert(0, 1);
    return sum.toString();
  }

  private String getAddResult(int[] n, List<Integer> sum, int carry){
    for (int i = sum.size() - 1; i < n.length && carry != 0; i++) {
      sum.add((n[i] + carry) % 10);
      carry = (n[i] + carry) / 10;
    }
    StringBuilder res = new StringBuilder();
    for (int i = sum.size() - 1; i >= 0; i--)
      res.append(sum.get(i));
    return res.toString();
  }

  private int[] transStr2Int(String s) {
    int[] res = new int[s.length()];
    for (int i = 0; i< s.length(); i++) {
      res[i] = s.charAt(i) - '0';
    }
    return res;
  }

  public String shortestPalindrome(String s) {
    int j = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == s.charAt(j)) { j += 1; }
    }
    if (j == s.length()) { return s; }
    String suffix = s.substring(j);
    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
  }

  private boolean isPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j;i++, j--) {
      if (s.charAt(i) != s.charAt(j))
        return false;
    }
    return true;
  }

  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        StringBuilder combineRes = new StringBuilder(words[i]);
        if (i == j)
          continue;
        combineRes.append(words[j]);
        if (isPalindrome(combineRes.toString())) {
          List<Integer> oneAns = new ArrayList<>();
          oneAns.add(i);
          oneAns.add(j);
          res.add(oneAns);
        }
      } //for
    } //for
    return res;
  }



  public int integerReplacement(int n) {
    return integerReplacement1(n);
  }
  private int integerReplacement1(long n) {
    if (n <= 1)
      return 0;
    if ((n & 1) != 1)
      return integerReplacement1(n / 2) + 1;
    else {
      return Math.min(integerReplacement1(n + 1), integerReplacement1(n - 1)) + 1;
    }
  }

  public int nthSuperUglyNumber(int n, int[] primes) {
    int[] res = new int[n];
    int[] resIndex = new int[primes.length];
    res[0] =1;
    for (int i = 1; i < n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < primes.length; j++) {
        min = min < primes[j] * res[resIndex[j]] ? min : primes[j] * res[resIndex[j]];
      } //for
      res[i] = min;
      for (int j = 0; j < resIndex.length; j++) {
        while (primes[j] * res[resIndex[j]] <= min)
          resIndex[j]++;
      } //for
    }
    return res[n - 1];
  }

  public int countDigitOne(int n) {
    int res = 0;
    for (long m = 1; m <= n;m *= 10) {
      res += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
    }
    return res;
  }

  private int countDigitOne1(int n) {
    int res = 0;
    while (n > 0) {
      if (n % 10 == 1)
        res ++;
      n /= 10;
    }
    return res;
  }

  public int minMutation(String start, String end, String[] bank) {
    if (bank == null || bank.length == 0)
      return -1;
    Set<String> bankSet = new HashSet<>();
    for (String s : bank)
      bankSet.add(s);
    char[] charSet = {'A', 'C', 'G', 'T'};
    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.offer(start);
    visited.add(start);
    int level = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size -- > 0) {
        String curString = queue.poll();
        if (curString.equals(end))
          return level;
        char[] curChars = curString.toCharArray();
        for (int i = 0; i < curChars.length; i++) {
          char old = curChars[i];
          for (char ch : charSet) {
            curChars[i] = ch;
            String nextString = new String(curChars);
            if (!visited.contains(nextString) && bankSet.contains(nextString)) {
              queue.offer(nextString);
              visited.add(nextString);
            } //if
            curChars[i] = old;
          } //for
        } //for
      } //while
      level ++;
    } //while
    return -1;
  }

  private void bfsTree(TreeNode root) {
    Queue<TreeNode> levelNodes = new LinkedList<>();
    levelNodes.offer(root);
    while (!levelNodes.isEmpty()) {
      int size = levelNodes.size();
      while (size -- > 0) {
        TreeNode curNode = levelNodes.poll();
        System.out.print(curNode.val + " ");
        if (curNode.left != null)
          levelNodes.offer(curNode.left);
        if (curNode.right != null)
          levelNodes.offer(curNode.right);
      } //while
    } //while
    System.out.println();
  }

  int minCount = 1000;
  private int minMutation(char[] start, char[] end, Set<String> bank) {
    if (new String(start).equals(new String(end)))
      return 0;
    for (int i = 0; i < 8; i++) {
      if (start[i] != end[i]) {
        char tmp = start[i];
        start[i] = end[i];
        if (bank.contains(new String(start))) {
          int tmpMinCount = minMutation(start, end, bank) + 1;
          minCount = (minCount + 1) > tmpMinCount ? tmpMinCount : (minCount + 1);
        }
        start[i] = tmp;
      } //if
    } //for
    return minCount;
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)
      return root;
    if (key < root.val)
      root.left = deleteNode(root.left, key);
    else if (key > root.val)
      root.right = deleteNode(root.right, key);
    else {
      if (root.left == null)
        return root.right;
      if (root.right == null)
        return root.left;
      TreeNode minNode = findMinNode(root.right);
      root.val = minNode.val;
      root.right = deleteNode(root.right, root.val);
    }
    return root;
  }

  private TreeNode findMinNode(TreeNode root) {
    while (root.left != null)
      root = root.left;
    return root;
  }

  private void inorderTravel(TreeNode root, int key, List<Integer> valList) {
    if (root == null)
      return;
    inorderTravel(root.left, key, valList);
    if (root.val != key)
      valList.add(root.val);
    inorderTravel(root.right, key, valList);
  }

  private TreeNode buildDeleteNodeTree(List<Integer> valList) {
    if (valList.size() == 0)
      return null;
    TreeNode root = new TreeNode(valList.get(0));
    TreeNode temp = root;
    for (int i = 1; i < valList.size(); i++) {
      TreeNode node = new TreeNode(valList.get(i));
      temp.right = node;
      temp = node;
    }
    return root;
  }

  private TreeNode buildDeleteNodeTree1(){
    TreeNode root = new TreeNode(5);
    TreeNode node1 = new TreeNode(3);
    TreeNode node2 = new TreeNode(6);
    TreeNode node3 = new TreeNode(2);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(7);

    root.left = node1;
    root.right = node2;

    node1.left = node3;
    node1.right = node4;

    node2.right = node5;

    return root;
  }

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null)
      return 0;
    if (root.left != null && root.left.left == null && root.left.right == null)
      return root.left.val + sumOfLeftLeaves(root.right);
    else
      return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
  }

  private TreeNode buildSumOfLeftLeaves(){
    TreeNode root = new TreeNode(3);
    TreeNode node1 = new TreeNode(9);
    TreeNode node2 = new TreeNode(20);
    TreeNode node3 = new TreeNode(15);
    TreeNode node4 = new TreeNode(7);

    root.left = node1;
    root.right = node2;

    node2.left = node3;
    node2.right = node4;

    return root;
  }

  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 1) {
      TreeNode newRoot = new TreeNode(v);
      newRoot.left = root;
      return newRoot;
    }
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.offer(root);
    int depth = 1;
    while (!nodeQueue.isEmpty() && depth < d - 1) {
      Queue<TreeNode> curQueue = new LinkedList<>();
      while (!nodeQueue.isEmpty()) {
        TreeNode curNode = nodeQueue.poll();
        if (curNode.left != null)
          curQueue.offer(curNode.left);
        if (curNode.right != null)
          curQueue.offer(curNode.right);
      } //while
      depth ++;
      nodeQueue = curQueue;
    } //while
    while (!nodeQueue.isEmpty()) {
      TreeNode curNode = nodeQueue.poll();
      TreeNode leftNode = new TreeNode(v);
      TreeNode rightNode = new TreeNode(v);
      if (curNode.left != null)
        leftNode.left = curNode.left;
      if (curNode.right != null)
        rightNode.right = curNode.right;
      curNode.left = leftNode;
      curNode.right = rightNode;
    } //while
    return root;
  }

  private TreeNode buildAddOneRow1(){
    TreeNode root = new TreeNode(4);
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(3);
    TreeNode node3 = new TreeNode(1);

    root.left = node1;
    node1.left = node2;
    node1.right = node3;

    return root;
  }

  private TreeNode buildAddOneRow(){
    TreeNode root = new TreeNode(4);
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(6);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(1);
    TreeNode node5 = new TreeNode(5);

    root.left = node1;
    root.right = node2;

    node1.left = node3;
    node1.right = node4;

    node2.left = node5;
    return root;
  }

  public List<Integer> postorder(Node root) {
    LinkedList<Integer> res = new LinkedList<>();
    if (root == null)
      return res;
    Stack<Node> nodeStack = new Stack<>();
    nodeStack.push(root);
    while (!nodeStack.isEmpty()) {
      Node curNode = nodeStack.pop();
      res.addFirst(curNode.val);
      if (curNode.children == null)
        continue;
      for (Node node : curNode.children)
        nodeStack.push(node);
    } //while
    return res;
  }

  private void postorder1(Node root, List<Integer> res) {
    if (root == null)
      return ;
    for (Node curNode : root.children)
      postorder1(curNode, res);
    res.add(root.val);
  }

  public List<Integer> preorder(Node root) {
    List<Integer> res = new ArrayList<>();
    preorder1(root, res);
    return res;
  }

  private void preorder1(Node root, List<Integer> res) {
    if (root == null)
      return;
    res.add(root.val);
    if (root.children == null)
      return;
    for (Node curNode : root.children) {
      preorder1(curNode, res);
    }
  }



  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null)
       return res;
    Queue<Node> curLevelNodes = new LinkedList<>();
    curLevelNodes.offer(root);
    while (!curLevelNodes.isEmpty()) {
      List<Integer> curLevelInt = new ArrayList<>();
      Queue<Node> nextLevelNodes = new LinkedList<>();
      while (!curLevelNodes.isEmpty()) {
        Node curNode = curLevelNodes.poll();
        curLevelInt.add(curNode.val);
        if (curNode.children != null)
          nextLevelNodes.addAll(curNode.children);
      } //while
      if (!curLevelInt.isEmpty())
        res.add(curLevelInt);
      curLevelNodes = nextLevelNodes;
    }
    return res;
  }

  private Node buildNAryTree() {
    Node root = new Node();
    root.val = 1;
    Node node1 = new Node();
    node1.val = 3;
    Node node2 = new Node();
    node2.val = 2;
    Node node3 = new Node();
    node3.val = 4;
    Node node4 = new Node();
    node4.val = 5;
    Node node5 = new Node();
    node5.val = 6;

    List<Node> ch1 = new ArrayList<>();
    ch1.add(node1);
    ch1.add(node2);
    ch1.add(node3);

    List<Node> ch2 = new ArrayList<>();
    ch2.add(node4);
    ch2.add(node5);

    root.children = ch1;

    node1.children = ch2;
    return root;
  }

  private Integer min = Integer.MAX_VALUE;
  private Integer pre = null;
  public int minDiffInBST(TreeNode root) {
    if (root == null)
      return min;
    minDiffInBST(root.left);
    if (pre != null) {
      int tempMin = Math.abs(root.val - pre);
      min = min > tempMin ? tempMin : min;
    }
    pre = root.val;
    minDiffInBST(root.right);
    return min;
  }

  private void inorderTravel (TreeNode root, List<Integer> list) {
    if (root == null)
      return;
    inorderTravel(root.left, list);
    list.add(root.val);
    inorderTravel(root.right, list);
  }

  private TreeNode buildBSTTree() {
    TreeNode root = new TreeNode(1);
    TreeNode node1 = new TreeNode(3);
    TreeNode node2 = new TreeNode(2);
    root.right = node1;
    node1.left = node2;
    return root;
  }

  public int findPairs(int[] nums, int k) {
    int res = 0;
    Set<Integer> numsCounted = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      Set<Integer> needNums = new HashSet<>();
      if (numsCounted.contains(nums[i]))
        continue;
      needNums.add(nums[i] + k);
      needNums.add(nums[i] - k);
      for (int j = i + 1; j < nums.length; j++) {
        if (needNums.contains(nums[j])) {
          res ++;
          needNums.remove(nums[j]);
        } //if
      } //for
      numsCounted.add(nums[i]);
    } //for
    return res;
  }

  public int minFlipsMonoIncr(String S) {
    if (S == null || S.length() == 0)
      return 0;
    int oneCounter = 0;
    int flipCounter = 0;
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '1')
        oneCounter ++;
      else
        flipCounter ++;
      flipCounter = flipCounter < oneCounter ? flipCounter : oneCounter;
    }
    return flipCounter;
  }

  private String subS(String s) {
    if (s == null || s.length() == 0)
      return "";
    int startIndex = 0;
    while (startIndex < s.length() && s.charAt(startIndex) == '0')
      startIndex ++;
    if (startIndex == s.length())
      return "";
    int endIndex = s.length() - 1;
    while (endIndex >= 0 && s.charAt(endIndex) == '1')
      endIndex --;
    if (endIndex == -1)
      return "";
    return s.substring(startIndex, endIndex + 1);
  }

  public List<List<Integer>> largeGroupPositions(String S) {
    List<List<Integer>> res = new ArrayList<>();
    if (S == null || S.length() == 0)
      return res;
    for (int i = 0; i < S.length(); i++) {
      int pre = i;
      while (i + 1 < S.length() && S.charAt(i) == S.charAt(i + 1))
        i++;
      if (i - pre + 1 >= 3) {
        List<Integer> element = new ArrayList<>();
        element.add(pre);
        element.add(i);
        res.add(element);
      } //if
    }
    return res;
  }

  public int partitionDisjoint(int[] A) {
    int localMax = A[0];
    int max = localMax;
    int partionIndex = 0;
    for (int i = 1; i < A.length; i++) {
      if (localMax > A[i]) {
        localMax = max;
        partionIndex = i;
      } //if
      else
        max = max < A[i] ? A[i] : max;
    } //for
    return partionIndex + 1;
  }

  public int findUnsortedSubarray(int[] A) {
    int begin = -1;
    int end = -2;
    int max = A[0];
    int min = A[A.length - 1];
    int n = A.length;
    for (int i = 1; i < n; i++) {
      max = max < A[i] ? A[i] : max;
      min = min > A[n - i - 1] ? A[n - i - 1] : min;
      end = max > A[i] ? i : end;
      begin = min < A[n - i - 1] ? n - i - 1 : begin;
    }
    return end - begin + 1;
  }

  public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    int[] res = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int val = queries[i][0];
      int index = queries[i][1];
      A[index] += val;
      res[i] = sumEvenNums(A);
    }
    return res;
  }

  private int sumEvenNums(int[] A) {
    int sum = 0;
    for (int n : A) {
      sum += (n & 1) == 1 ? 0 : n;
    }
    return sum;
  }

  public void wiggleSort(int[] nums) {
    int[] tempNums = new int[nums.length];
    for (int i = 0; i < nums.length; i++)
      tempNums[i] = nums[i];
    Arrays.sort(tempNums);
    int numsIndex = 0;
    for (int i = 0, j = (nums.length + 1) / 2; i < nums.length / 2 && j < nums.length; i++, j++) {
      if (numsIndex > 0 && nums[numsIndex - 1] == tempNums[i]) {
        nums[numsIndex ++] = tempNums[j];
        nums[numsIndex ++] = tempNums[i];
      } else {
        nums[numsIndex ++] = tempNums[i];
        nums[numsIndex ++] = tempNums[j];
      }
    }
    if ((nums.length & 1) == 1) {
      nums[nums.length - 1] = tempNums[nums.length / 2];
    }
  }

  public int[][] flipAndInvertImage(int[][] A) {
    for (int i = 0; i < A.length; i++) {
      flipArray(A[i]);
    }
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j ++) {
        A[i][j] = (A[i][j] + 1) % 2;
      }
    }
    return A;
  }

  private void flipArray(int[] array) {
    for (int i = 0, j = array.length - 1; i < j ;i++, j--) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }

  public int maxIncreaseKeepingSkyline(int[][] grid) {
    if (grid == null) {
      return 0;
    }
    int[] rowMaxs = new int[grid.length];
    int[] colMaxs = new int[grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      int tempMax = Integer.MIN_VALUE;
      for (int j = 0; j < grid[0].length; j++) {
        tempMax = tempMax < grid[i][j] ? grid[i][j] : tempMax;
      } //for
      rowMaxs[i] = tempMax;
    } //for
    for (int i = 0; i < grid[0].length; i++) {
      int tempMax = Integer.MIN_VALUE;
      for (int j = 0; j < grid.length; j++) {
        tempMax = grid[j][i] > tempMax ? grid[j][i] : tempMax;
      } //for
      colMaxs[i] = tempMax;
    } //for
//    ArrayUtil.printIntArray(rowMaxs);
//    ArrayUtil.printIntArray(colMaxs);
    int res = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        int min = Math.min(rowMaxs[i], colMaxs[j]);
        res += (min - grid[i][j]);
      } //for
    } //for
    return res;
  }

  public int findMinDifference(List<String> timePoints) {
    boolean[] marks = new boolean[24 * 60];
    for (String timePoint : timePoints) {
      String[] hourAndMinute = timePoint.split(":");
      int hour = Integer.parseInt(hourAndMinute[0]);
      int minute = Integer.parseInt(hourAndMinute[1]);
      if (marks[hour * 60 + minute]) {
        return 0;
      }
      marks[hour * 60 + minute] = true;
    }
    int pre = 0;
    int min = Integer.MAX_VALUE;
    int first = Integer.MAX_VALUE;
    int last = Integer.MIN_VALUE;
    for (int i = 0; i < marks.length; i++) {
      if (marks[i]) {
        if (first != Integer.MAX_VALUE) {
          min = Math.min(min, i - pre);
        }
        pre = i;
        first = Math.min(first, i);
        last = Math.max(last, i);
      } //if
    } //for
    return Math.min(min, (24 * 60 + first - last));
  }

  //23:59
  private int transTimePoints2Minutes(String timePoint) {
    String[] hourAndMinute = timePoint.split(":");
    return Integer.parseInt(hourAndMinute[0]) * 60 + Integer.parseInt(hourAndMinute[1]);
  }

  public int countSegments(String s) {
    int res = 0;
    if (s == null) {
      return res;
    }
    s = s.trim();
    if (s.length() == 0) {
      return 0;
    }
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        res++;
        while (s.charAt(i) == ' ') {
          i++;
        }
      }
    }
    return res + 1;
  }


  public List<String> letterCasePermutation(String S) {
    List<String> res = new ArrayList<>();
    if (S == null || S.length() == 0) {
      res.add("");
      return res;
    }
    if (S.length() == 1) {
      String upperCase = S.toUpperCase();
      String lowerCase = S.toLowerCase();
      if (upperCase.equals(lowerCase)) {
        res.add(S);
      } else {
        res.add(upperCase);
        res.add(lowerCase);
      }
      return res;
    } //if
    String firstS = S.substring(0, 1);
    String secondS = S.substring(1, S.length());
    String upperCase = firstS.toUpperCase();
    String lowerCase = firstS.toLowerCase();
    List<String> secondList = letterCasePermutation(secondS);
    for (String secondRes : secondList) {
      if (upperCase.equals(lowerCase)) {
        res.add(lowerCase + secondRes);
      } //if
      else {
        res.add(lowerCase + secondRes);
        res.add(upperCase + secondRes);
      } //else
    } //for
    return res;
  }

  public int repeatedNTimes(int[] A) {
    if (A == null || A.length == 0) {
      return -1;
    }
    Set<Integer> preNums = new HashSet<>();
    for (int n : A) {
      if (preNums.contains(n)) {
        return n;
      }
      preNums.add(n);
    }
    return -1;
  }

  public int firstUniqChar(String s) {
    Map<Character, Integer> ch2Count = new HashMap<>();
    for (char ch : s.toCharArray()) {
      int count = ch2Count.getOrDefault(ch, 0);
      ch2Count.put(ch, count + 1);
    } //for
    for (int i = 0; i < s.length(); i++) {
      if (ch2Count.get(s.charAt(i)) == 1) {
        return i;
      }
    }
    return -1;
  }

  public int kthSmallest(int[][] matrix, int k) {
    if (null == matrix || k > matrix.length * matrix[0].length) {
      return -1;
    }
    int colPosition = (k % matrix.length);
    int rowPosition = k / matrix.length;
    rowPosition = colPosition == 0 ? rowPosition - 1 : rowPosition;
    colPosition = colPosition == 0 ? matrix[0].length - 1 : colPosition - 1;
    return matrix[rowPosition][colPosition];
  }


  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> preSum = new HashMap<>();
    preSum.put(0, 1);
    int count = 0;
    int curSum = 0;
    for (int i = 0; i < nums.length; i++) {
      curSum += nums[i];
      if (preSum.containsKey(curSum - k)) {
        count += preSum.get(curSum - k);
      }
      preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
    }
    return count;
  }

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }
    int length = prices.length;
    int[] s0 = new int[length];   //start state or after rest
    int[] s1 = new int[length];   //after buy or after rest
    int[] s2 = new int[length];   //after selling
    s0[0] = 0;
    s1[0] = -prices[0];
    s2[0] = Integer.MIN_VALUE;
    for (int i = 1; i < length; i++) {
      s0[i] = Math.max(s0[i - 1], s2[i - 1]);
      s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
      s2[i] = Math.max(s2[i - 1], s1[i - 1] + prices[i]);
    }
    return Math.max(s0[length - 1], s2[length - 1]);
  }

  public int findTargetSumWays(int[] nums, int S) {
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    return sum < S || ((sum + S) & 1) == 1 ? 0 : subsetNum(nums, (S + sum) >>> 1);
  }

  private int subsetNum(int[] nums, int s) {
    int[] dp = new int[s + 1];
    dp[0] = 1;
    for (int n : nums) {
      for (int i = s; i >= n; i--) {
        dp[i] += dp[i - n];
      }
    }
    return dp[s];
  }

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if ((sum & 1) == 1) {
      return false;
    }
    sum /= 2;
    boolean[][] dp = new boolean[nums.length + 1][sum + 1];
    dp[0][0] = true;
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], false);
    }
    for (int i = 1; i < nums.length + 1; i++) {
      dp[i][0] = true;
    }
    for (int i = 1; i < sum + 1; i++) {
      dp[0][i] = false;
    }
    for (int i = 1; i <= nums.length; i++) {
      for (int j = 1; j <= sum; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j >= nums[i - 1]) {
          dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
        }
      }
    }
    return dp[nums.length][sum];
  }

  private void printBooleanArray(boolean[][] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[0].length; j++) {
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }
  }


  private int findTargetSumWays1(int[] nums, int s, int start) {
    if (start == nums.length - 1) {
      int res = 0;
      res += (nums[start] == s) ? 1 : 0;
      res += (-nums[start] == s) ? 1 : 0;
      return res;
    }
    return findTargetSumWays1(nums, s - nums[start], start + 1) + findTargetSumWays1(nums,
        s + nums[start], start + 1);
  }


  public int countSubstrings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      res += check(s, i, i);
      res += check(s, i, i + 1);
    }
    return res;
  }

  private int check(String s, int i, int j) {
    int res = 0;
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      res++;
      i--;
      j++;
    }
    return res;
  }

  public int pathSum(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    return pathSumFromRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  private int pathSumFromRoot(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    int res = root.val == sum ? 1 : 0;
    return res + pathSumFromRoot(root.left, sum - root.val) + pathSumFromRoot(root.right,
        sum - root.val);
  }

  public int thirdMax(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    List<Integer> copyList = new ArrayList<>();
    copyList.add(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        continue;
      }
      copyList.add(nums[i]);
    }
    Integer[] numsCopy = new Integer[copyList.size()];
    copyList.toArray(numsCopy);
    Arrays.sort(numsCopy);
    if (numsCopy.length < 3) {
      return numsCopy[numsCopy.length - 1];
    }
    return numsCopy[numsCopy.length - 3];
  }

  public int[] sortArrayByParity(int[] A) {
    int left = 0, right = A.length - 1;
    while (left < right) {
      while (left < right && A[left] % 2 == 0) {
        left++;
      }
      while (left < right && A[right] % 2 != 0) {
        right--;
      }
      if (left < right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
      }
      left++;
      right--;
    }
    return A;
  }

  public int maxDistToClosest(int[] seats) {
    int i = 0, j = 0, res = 0, n = seats.length;
    for (; j < seats.length; j++) {
      if (seats[j] == 1) {
        if (i == 0) {
          res = Math.max(res, j - i);
        } else {
          res = Math.max(res, (j - i + 1) / 2);
        }
        i = j + 1;
      } //if
    } //for
    res = Math.max(res, n - i);
    return res;
  }

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    LinkedList<TreeNode> stack = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      TreeNode node = new TreeNode(nums[i]);
      while (!stack.isEmpty() && stack.peek().val < node.val) {
        node.left = stack.pop();
      } //while
      if (!stack.isEmpty()) {
        stack.peek().right = node;
      }
      stack.push(node);
    } //for
    return stack.isEmpty() ? null : stack.removeLast();
  }

  private TreeNode constructMaxBinaryTree(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    if (left == right) {
      return new TreeNode(nums[left]);
    }
    int maxNumIndex = left;
    for (int i = left + 1; i <= right; i++) {
      maxNumIndex = nums[i] > nums[maxNumIndex] ? i : maxNumIndex;
    }
    TreeNode root = new TreeNode(nums[maxNumIndex]);
    root.left = constructMaxBinaryTree(nums, left, maxNumIndex - 1);
    root.right = constructMaxBinaryTree(nums, maxNumIndex + 1, right);
    return root;
  }

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    TreeNode cur = root;
    while (true) {
      if (cur.val <= val) {
        if (cur.right != null) {
          cur = cur.right;
        } else {
          cur.right = new TreeNode(val);
          break;
        }
      } else {
        if (cur.left != null) {
          cur = cur.left;
        } else {
          cur.left = new TreeNode(val);
        } //else
      } //else
    } //while
    return root;
  }

  public int rangeSumBST(TreeNode root, int L, int R) {
    if (root == null) {
      return 0;
    }
    if (root.val > R) {
      return rangeSumBST(root.left, L, R);
    }
    if (root.val < L) {
      return rangeSumBST(root.right, L, R);
    }
    return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
  }


  private int getAllSubArray(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int size = 1; size <= nums.length; size++) {
        List<Integer> oneSizeArray = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int k = 0, j = i; i <= nums.length - size && k < size; k++, j++) {
          oneSizeArray.add(nums[j]);
          min = min > nums[j] ? nums[j] : min;
        }
        if (oneSizeArray.size() != 0) {
          res.add(oneSizeArray);
          sum += min;
        }
      } //for
    } //for
    return sum;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (null == nums || nums.length < 3) {
      return res;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length && nums[i] < 0; i++) {
      int target = -nums[i];
      int front = i + 1;
      int back = nums.length - 1;
      while (front < back) {
        if (nums[front] + nums[back] < target) {
          front++;
        } else if (nums[front] + nums[back] > target) {
          back--;
        } else {
          List<Integer> element = new ArrayList<>();
          element.add(nums[i]);
          element.add(nums[front++]);
          element.add(nums[back--]);
          res.add(element);
          while (front < back && nums[front] == nums[front - 1]) {
            front++;
          }
          while (front < back && nums[back] == nums[back + 1]) {
            back--;
          }
        } //else
      } //while
      while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
        i++;
      }
    } //for
    return res;
  }

  public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    if (numbers == null || numbers.length == 0) {
      return res;
    }
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      int sum = numbers[left] + numbers[right];
      if (sum == target) {
        res[0] = left + 1;
        res[1] = right + 1;
        return res;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return res;
  }

  public int fib(int N) {
    if (N == 0 || N == 1) {
      return N;
    }
    int[] res = new int[N + 1];
    res[0] = 0;
    res[1] = 1;
    for (int i = 2; i <= N; i++) {
      res[i] = res[i - 1] + res[i - 2];
    }
    return res[N];
  }

  public int maximumSwap(int num) {
    int res = 0;
    int[] nums = new int[10];
    int size = 0;
    for (int i = 0; num != 0; i++) {
      int remind = num % 10;
      nums[i] = remind;
      num = num / 10;
      size++;
    } //for
    int[] nums1 = new int[size];
    for (int i = 0; i < size; i++) {
      nums1[i] = nums[i];
    }
    Arrays.sort(nums1);
    nums = new int[size];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = nums1[nums.length - i - 1];
    }
    for (int i = 0; i < nums1.length; i++) {
      res *= 10;
      res += nums[i];
    }
    return res;
  }


  public int numSubarrayBoundedMax(int[] A, int L, int R) {
    int res = 0;
    if (A == null || A.length == 0) {
      return res;
    }
    for (int i = 0; i < A.length; i++) {
      for (int j = i; j < A.length; j++) {
        int subArrayMax = A[i];
        for (int k = i + 1; k <= j; k++) {
          subArrayMax = A[k] > subArrayMax ? A[k] : subArrayMax;
        } //for
        if (subArrayMax >= L && subArrayMax <= R) {
          res++;
        } //if
      } //for
    } //for
    return res;
  }

  public List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    if (nums.length == 1) {
      res.add(nums[0]);
      return res;
    }
    Arrays.sort(nums);
    boolean firstNumIsOne = false;
    firstNumIsOne = nums[0] == 1 ? true : false;
    nums = firstNumIsOne ? Arrays.copyOfRange(nums, 1, nums.length) : nums;
    for (int i = 0; i < nums.length; i++) {
      List<Integer> tempRes = new ArrayList<>();
      tempRes.add(nums[i]);
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] % nums[i] == 0 && j == i + 1) {
          tempRes.add(nums[j]);
          continue;
        } //if
        else if (tempRes.size() > 0 && nums[j] % tempRes.get(tempRes.size() - 1) == 0) {
          tempRes.add(nums[j]);
        }
      } //for
      res = res.size() < tempRes.size() ? tempRes : res;
    } //for
    if (firstNumIsOne) {
      res.add(1);
    }
    return res;
  }


  public String toLowerCase(String str) {
    StringBuilder res = new StringBuilder();
    for (char ch : str.toCharArray()) {
      if (97 <= ch && ch <= 122) {
        res.append(ch);
      } else if (65 <= ch && ch <= 90) {
        res.append((char) (ch + 32));
      } else {
        res.append(ch);
      }
    }
    return res.toString();
  }


  public int numUniqueEmails(String[] emails) {
    Set<String> mailSet = new HashSet<>();
    for (String mail : emails) {
      int indexOfAt = mail.indexOf("@");
      String local = mail.substring(0, indexOfAt);
      String domain = mail.substring(indexOfAt, mail.length());
      //process local
      int indexOfPlus = local.indexOf('+');
      local = indexOfPlus > 0 ? local.substring(0, indexOfPlus) : local;
      StringBuilder filterDot = new StringBuilder();
      for (char ch : local.toCharArray()) {
        if (ch == '.') {
          continue;
        }
        filterDot.append(ch);
      } //for
      mailSet.add(filterDot + domain);
    } //for
    return mailSet.size();
  }
}
