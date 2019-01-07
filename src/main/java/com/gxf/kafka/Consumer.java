package com.gxf.kafka;

import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/7 8:55 PM
 **/
public class Consumer {
  private static Logger logger = LoggerFactory.getLogger(Consumer.class);
  private static KafkaConsumer<String, String> consumer;
  private static KafkaListener kafkaListener;
  private static String topic = "test";

  static {
    init();
  }

  private static void init(){
    Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "1000");
    props.put("session.timeout.ms", "30000");
    props.put("max.poll.records", 1000);
    props.put("auto.offset.reset", "earliest");
    props.put("key.deserializer", StringDeserializer.class.getName());
    props.put("value.deserializer", StringDeserializer.class.getName());
    props.put("group.id", "test-consumer-group");//这里是GroupA或者GroupB
    consumer = new KafkaConsumer<String, String>(props);
  }

  public KafkaListener getKafkaListener() {
    return kafkaListener;
  }

  public void setKafkaListener(KafkaListener kafkaListener) {
    this.kafkaListener = kafkaListener;
    startListen();
  }

  public static void startListen(){
      consumer.subscribe(Arrays.asList(topic));
      while (true) {
        ConsumerRecords<String, String> records = consumer.poll(100);
        if(kafkaListener == null)
          continue;
        for (ConsumerRecord<String, String> record : records){
          kafkaListener.onListener(record.value());
        }
      }

  }

  public static void main(String[] args) {
//    String topic = "test";
//    Properties props = new Properties();
//    props.put("bootstrap.servers", "localhost:9092");
//    props.put("enable.auto.commit", "true");
//    props.put("auto.commit.interval.ms", "1000");
//    props.put("session.timeout.ms", "30000");
//    props.put("max.poll.records", 1000);
//    props.put("auto.offset.reset", "earliest");
//    props.put("key.deserializer", StringDeserializer.class.getName());
//    props.put("value.deserializer", StringDeserializer.class.getName());
//    props.put("group.id", "test-consumer-group");//这里是GroupA或者GroupB
//    try(KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);){
//      consumer.subscribe(Arrays.asList(topic));
//      while (true) {
//        ConsumerRecords<String, String> records = consumer.poll(100);
//        for (ConsumerRecord<String, String> record : records)
//          //　正常这里应该使用线程池处理，不应该在这里处理
//          System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value()+"\n");
//
//      }
//    } catch (Exception e){
//      logger.error(e.getMessage(), e);
//    }
  }

}
