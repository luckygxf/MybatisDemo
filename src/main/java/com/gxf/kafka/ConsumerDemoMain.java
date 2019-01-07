package com.gxf.kafka;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/7 9:33 PM
 **/
public class ConsumerDemoMain {

  public static void main(String[] args) {
    ConsumerDemo consumerDemo = new ConsumerDemo();
    Consumer consumer = new Consumer();
    consumer.setKafkaListener(consumerDemo);
  }
}
