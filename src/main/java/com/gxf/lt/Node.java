package com.gxf.lt;

import java.util.List;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/2/10 3:32 PM
 **/
public class Node {
  public int val;
  public List<Node> children;

  public Node() {}

  public Node(int _val,List<Node> _children) {
    val = _val;
    children = _children;
  }
}
