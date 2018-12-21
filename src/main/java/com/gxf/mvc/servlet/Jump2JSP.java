package com.gxf.mvc.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/21 9:56 AM
 **/
public class Jump2JSP extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    jump2InnnerJsp(req, resp);
    jump2OutterWeb(req, resp);
  }

  private void jump2OutterWeb(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    System.out.println("into servlet");
    resp.sendRedirect("http://www.baidu.com");
    super.service(req, resp);
  }


  private void jump2InnnerJsp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/jumped.jsp");
    requestDispatcher.forward(req, resp);
  }
}
