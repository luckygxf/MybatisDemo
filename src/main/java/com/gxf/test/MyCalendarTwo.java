package com.gxf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/2/6 5:50 PM
 **/
public class MyCalendarTwo {
  private List<int[]> points = new ArrayList<>();

  public MyCalendarTwo() {

  }

  public boolean book(int start, int end) {
    for (int i = 0; i < points.size(); i++) {
      int tempStart = Math.max(points.get(i)[0], start);
      int tempEnd = Math.min(points.get(i)[1], end);
      //no intersection
      if (tempStart >= tempEnd)
        continue;
      for (int j = i + 1; j < points.size(); j++) {
        int tempStart1 = Math.max(points.get(j)[0], tempStart);
        int tempEnd1 = Math.min(points.get(j)[1], tempEnd);
        if (tempStart1 < tempEnd1)
          return false;
      } //for
    } //for
    points.add(new int[]{start, end});
    return true;
  }
}
