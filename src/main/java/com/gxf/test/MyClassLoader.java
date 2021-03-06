package com.gxf.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class MyClassLoader extends ClassLoader {
  /**
   * 重写父类方法，返回一个Class对象
   * ClassLoader中对于这个方法的注释是:
   * This method should be overridden by class loader implementations
   */
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    Class clazz = null;
    String classFilename = name + ".class";
    File classFile = new File(classFilename);
    if (classFile.exists()) {
      try (FileChannel fileChannel = new FileInputStream(classFile)
          .getChannel();) {
        MappedByteBuffer mappedByteBuffer = fileChannel
            .map(MapMode.READ_ONLY, 0, fileChannel.size());
        byte[] b = mappedByteBuffer.array();
        clazz = defineClass(name, b, 0, b.length);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (clazz == null) {
      throw new ClassNotFoundException(name);
    }
    return clazz;
  }

  public static void main(String[] args) throws Exception{
    MyClassLoader myClassLoader = new MyClassLoader();
    String name = "com.gxf.test.Hello";
    Class clazz = myClassLoader.loadClass(name);
    Method sayHello = clazz.getMethod("sayHello");
    sayHello.invoke(null, null);

    Class hello1 = Hello.class;
    Object hello2 = clazz.newInstance();

    System.out.println(clazz);
    System.out.println(hello1);
    System.out.println(clazz == hello1);
    System.out.println(hello2 instanceof com.gxf.test.Hello);
  }
}
