package com.gxf.gxf_cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/3/5 11:19 AM
 **/
public class GxfCache {

  private Map<String, Object> cache = new HashMap<>();
  private Map<String, Long> expireTime = new HashMap<>();

  public GxfCache (){
    Thread t = new Thread(new DelExpireKey());
    t.start();
  }

  public void set(String key, Object value) {
    cache.put(key, value);
  }

  public Object get(String key) {
    return cache.get(key);
  }

  public void setExpireTime(String key, int secondExpire) {
    long curTimestamp = System.currentTimeMillis();
    expireTime.put(key, curTimestamp + secondExpire * 1000);
  }

  class DelExpireKey implements Runnable {
    public void run(){
      while (true) {
        for (Map.Entry<String, Long> timestampEntry : expireTime.entrySet()) {
          long curTimeStamp = System.currentTimeMillis();
          //时间过期 删除key
          if (curTimeStamp > timestampEntry.getValue()) {
            cache.remove(timestampEntry.getKey());
          } //if
        } //for
        try{
          Thread.sleep(1000);
        } catch (Exception e) {
          e.printStackTrace();
        }
      } //while
    } //run
  }
}
