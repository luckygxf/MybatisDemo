package com.gxf.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/7 9:32 PM
 **/
public class ConsumerDemo implements KafkaListener {
  private static Logger logger = LoggerFactory.getLogger(ConsumerDemo.class);

  @Override
  public void onListener(String kafkaMessage) {
    logger.info("receive message: {}", kafkaMessage);
  }
}
