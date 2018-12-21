package com.gxf.mvc.controller;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/17 9:36 PM
 **/
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;


@Controller
@RequestMapping({"/hello"})
public class HelloController {
  private static Logger logger = LoggerFactory.getLogger(HelloController.class);

//  @RequestMapping(method = RequestMethod.GET)
//  public String printHello(ModelMap model) {
//    model.addAttribute("message", "Hello Spring MVC Framework!");
//    return "hello";
//  }

//  @RequestMapping(method = RequestMethod.GET)
//  public ModelAndView printHello(ModelMap modelMap, HttpServletRequest request, String name) {
////    name = request.getParameter("name");
//    logger.info("name: {}", name);
//    logger.info("modelMap: {}", modelMap);
//    ModelAndView modelAndView = new ModelAndView();
//    modelAndView.getModelMap().addAttribute("message", "Hello Spring MVC Framework!");
//    modelAndView.setViewName("hello");
//    return modelAndView;
//  }

  @RequestMapping(method = RequestMethod.GET)
  public View printHello(ModelMap modelMap, HttpServletRequest request, String name) {
//    name = request.getParameter("name");
    logger.info("name: {}", name);
    logger.info("modelMap: {}", modelMap);
    modelMap.put("message", "Hello Spring MVC Framework!");
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.getModelMap().addAttribute("message", "Hello Spring MVC Framework!");
    modelAndView.setViewName("hello");
    return modelAndView.getView();
  }
}