package com.gxf.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/7 8:45 PM
 **/
public class Producer {
  private static Logger logger = LoggerFactory.getLogger(Producer.class);

  public static void main(String[] args) {
    String topic = "test";
    String key = "key";
    String value = "guan";
    Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("key.serializer", StringSerializer.class.getName());
    props.put("value.serializer", StringSerializer.class.getName());
    try(KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);){
      int count = 0;
      while(count ++ < Integer.MAX_VALUE){
        value = value + count;
        producer.send(new ProducerRecord<String, String>(topic, key, value));
        Thread.sleep(1000);
        logger.info("send record: {}", value);
        value = "guan";
      }
    } catch (Exception e){
      logger.error(e.getMessage(), e);
    }
  }
}
