package com.gxf.mvc.editor;

import com.gxf.util.DateUtil;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.util.StringUtils;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/12/21 9:25 PM
 **/
public class DateEditor extends PropertiesEditor {

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    if(StringUtils.isEmpty(text)){
      return;
    }
    setValue(DateUtil.parseStr2Date(text, "yyyyMMdd HH:mm:ss"));
  }

  @Override
  public Object getValue() {
    return getAsText().toString();
  }
}
