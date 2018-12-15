package com.gxf.mybatis.ioc_annotation;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/16 12:40 AM
 **/
public class MagicExistCondition implements Condition {

  /**
   * 如果返回true，Bean将会被创建并注册到Spring容器中；否则不会创建Bean
   */
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    Environment env = context.getEnvironment();
    // 当定义了magic属性的时候返回true
//    return env.containsProperty("magic");
    return true;
  }
}