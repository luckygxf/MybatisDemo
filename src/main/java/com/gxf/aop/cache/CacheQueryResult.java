package com.gxf.aop.cache;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/24 11:40 PM
 **/
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class CacheQueryResult
{
  private Map<String, Object> buffer = new HashMap<String, Object>();

  public Object around(ProceedingJoinPoint point) throws Throwable
  {
    String key = uniqueKey(point);

    Object returnValue = buffer.get(key);
    if(returnValue != null)
    {
      return returnValue;
    }

    Object object = point.proceed();
    buffer.put(key, object);
    return object;
  }

  private String uniqueKey(ProceedingJoinPoint point)
  {
    Object target = point.getTarget();

    Signature signature = point.getSignature();
    String methodSignature = signature.toString();

    String key = target.hashCode() + methodSignature;

    return key;
  }

}
