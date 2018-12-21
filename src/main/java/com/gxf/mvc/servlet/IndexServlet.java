package com.gxf.mvc.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/21 7:45 PM
 **/
public class IndexServlet  extends HttpServlet {
  private static Logger logger = LoggerFactory.getLogger(IndexServlet.class);

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/index.html");
    requestDispatcher.forward(request, response);
  }
}
