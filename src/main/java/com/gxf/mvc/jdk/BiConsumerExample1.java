package com.gxf.mvc.jdk;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/20 3:23 PM
 **/
public class BiConsumerExample1 {
  public static void main(String[] args) {
    testMapBiConsumer();
  }

  private static void testBiConsumer(){
    BiConsumer<Integer, String> consumer = (a, b) -> {
      System.out.println(a + b);
    };
    consumer.accept(5, " Chapters");
  }

  private static void testMapBiConsumer(){
    BiConsumer<String, Integer> consumer = (a, b) ->{
      System.out.println(a + " age is: " + b);
    };
    Map<String, Integer> name2Age = new HashMap<>();
    name2Age.put("guanxianseng", 18);
    name2Age.put("guanxianseng1", 17);
    name2Age.forEach(consumer);
  }
}
