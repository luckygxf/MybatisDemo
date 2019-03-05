package com.gxf.aop.jmx;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/2/18 10:45 AM
 **/
import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class Main {
  /* For simplicity, we declare "throws Exception".
     Real programs will usually want finer-grained exception handling. */
  public static void main(String[] args) throws Exception {
    // Get the Platform MBean Server
    MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

    // Construct the ObjectName for the Hello MBean we will register
    ObjectName mbeanName = new ObjectName("com.example:type=Hello");

    // Create the Hello World MBean
    Hello mbean = new Hello();

    // Register the Hello World MBean
    mbs.registerMBean(mbean, mbeanName);

    // Wait forever
    System.out.println("Waiting for incoming requests...");
    Thread.sleep(Long.MAX_VALUE);
  }
}