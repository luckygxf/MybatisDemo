package com.gxf.mvc.controller;

import com.gxf.mvc.editor.DateEditor;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/21 9:24 PM
 **/
@Controller
public class BaseController {

  @InitBinder
  public void initBinder(WebDataBinder binder){
    binder.registerCustomEditor(Date.class, new DateEditor());
  }

}
