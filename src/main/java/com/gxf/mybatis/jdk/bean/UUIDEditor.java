package com.gxf.mybatis.jdk.bean;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.UUID;
import org.springframework.util.StringUtils;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/10 11:50 PM
 **/
public class UUIDEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    if (StringUtils.hasText(text)) {
      setValue(UUID.fromString(text));
    }
    else {
      setValue(null);
    }
  }

  @Override
  public String getAsText() {
    UUID value = (UUID) getValue();
    return (value != null ? value.toString() : "");
  }


  public static void main(String[] args) throws ClassNotFoundException, IOException {

    //UUID对象转化为字符串
    UUIDEditor editor=new UUIDEditor();
    editor.setValue(UUID.randomUUID());
    System.out.println(editor.getAsText());//c2878055-fb49-4559-a7db-c60fc3ebee79

    //字符串转化为UUID
    UUIDEditor editor_2=new UUIDEditor();
    editor_2.setAsText("2-1-1-2-3");
    System.out.println(editor_2.getAsText());//00000002-0001-0001-0002-000000000003
    System.out.println(editor_2.getValue().getClass());//class java.util.UUID

  }
}
