package com.gxf.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/21 7:47 PM
 **/
public class FormSevlet extends HttpServlet {
  private Logger logger = LoggerFactory.getLogger(FormSevlet.class);

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String userName = req.getParameter("username");
    String password = req.getParameter("password");
    logger.info("userName: {}, password:{}", userName, password);
  }
}
