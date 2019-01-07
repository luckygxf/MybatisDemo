package com.gxf.kafka;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/7 9:26 PM
 **/
public interface KafkaListener {

  void onListener(String kafkaMessage);

}
