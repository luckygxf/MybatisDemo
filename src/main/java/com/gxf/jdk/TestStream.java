package com.gxf.jdk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/24 10:29 AM
 **/
public class TestStream {

  public static void main(String[] args) {
    testOOM();
  }


  private static void testOOM() {
    int size = 1024 * 1024;
    byte[] bytes = new byte[size];
    Map<Integer, byte[]> map = new HashMap<>();
    for (Integer i = 0; i < Integer.MAX_VALUE; i++) {
      map.put(i, bytes);
      bytes = new byte[size];
    }
  }

  private static int returnCalculate(){
    System.out.println("in return calculate");
    return 1;
  }


  private static int testFinally(){
    try{
      return returnCalculate();
    }finally {
      System.out.println("do finally");
    }
  }

  private static void testStream(){
    Integer[] sixNums = {1, 2, 3, 4, 5, 6};
//    Integer[] evens = Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);
//    Arrays.stream(sixNums).forEach(System.out::println);
    Stream intStream = Stream.of(sixNums).filter(n -> n % 2 == 1);
    intStream.forEach((n) -> System.out.print(n + " "));
  }
}
