package com.gxf.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/1 1:41 PM
 **/
class Solution {

  public static void main(String[] args) {
    Solution sol = new Solution();
    String str = "al&phaBET";
    System.out.println(sol.toLowerCase(str));
  }

  public String toLowerCase(String str) {
    StringBuilder res = new StringBuilder();
    for(char ch : str.toCharArray()){
      if(97 <= ch && ch <= 122)
        res.append(ch);
      else if(65 <= ch && ch <= 90)
        res.append((char)(ch + 32));
      else
        res.append(ch);
    }
    return res.toString();
  }


  public int numUniqueEmails(String[] emails) {
    Set<String> mailSet = new HashSet<>();
    for(String mail : emails){
      int indexOfAt = mail.indexOf("@");
      String local = mail.substring(0, indexOfAt);
      String domain = mail.substring(indexOfAt, mail.length());
      //process local
      int indexOfPlus = local.indexOf('+');
      local = indexOfPlus > 0 ? local.substring(0, indexOfPlus) : local;
      StringBuilder filterDot = new StringBuilder();
      for(char ch : local.toCharArray()){
        if(ch == '.')
          continue;
        filterDot.append(ch);
      } //for
      mailSet.add(filterDot + domain);
    } //for
    return mailSet.size();
  }
}
