package com.gxf.mybatis.jdk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/10 6:08 PM
 **/
public class SecurityManagerTest {

public static void main(String[] args)throws FileNotFoundException {
    System.out.println("SecurityManager: " + System.getSecurityManager());
    System.out.println("System.getSecurityManager(): " + System.getSecurityManager());
    try(FileInputStream fis = new FileInputStream("c:\\protect.txt");){
      System.out.println(System.getProperty("file.encoding"));
    } catch (Exception e) {
      e.printStackTrace();
    }
}

}