package com.gxf.mybatis.spring_property_edit;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditor;
import java.util.Map;
import java.util.Set;

public class CustomEditorRegistrar implements PropertyEditorRegistrar {

  private Map<Class<?>, PropertyEditor> customEditors;

  public void registerCustomEditors(PropertyEditorRegistry registry) {
    if (customEditors != null) {
      Set<Map.Entry<Class<?>, PropertyEditor>> entries = customEditors.entrySet();
      for (Map.Entry<Class<?>, PropertyEditor> entry : entries) {
        registry.registerCustomEditor(entry.getKey(), entry.getValue());
      }
    }
  }

  public void setCustomEditors(Map<Class<?>, PropertyEditor> customEditors) {
    this.customEditors = customEditors;
  }
}