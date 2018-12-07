package com.gxf.mybatis.util;

import java.io.IOException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/6 7:43 PM
 **/
public class MapperScanner extends ClassPathBeanDefinitionScanner {

  public MapperScanner(BeanDefinitionRegistry registry){
    super(registry, false);
  }


  public void registerFilters(){
    addIncludeFilter(new TypeFilter() {
      public boolean match(MetadataReader metadataReader,
          MetadataReaderFactory metadataReaderFactory) throws IOException {
        return true;
      }
    });
  }
}
