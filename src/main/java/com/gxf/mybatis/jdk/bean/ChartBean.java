package com.gxf.mybatis.jdk.bean;

import static javax.swing.SwingConstants.CENTER;

import javax.swing.JPanel;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/12/10 11:39 PM
 **/
public class ChartBean extends JPanel {
  private int titlePosition = CENTER;
  private boolean inverse;

  public int getTitlePosition() {
    return titlePosition;
  }

  public void setTitlePosition(int titlePosition) {
    this.titlePosition = titlePosition;
  }

  public boolean isInverse() {
    return inverse;
  }

  public void setInverse(boolean inverse) {
    this.inverse = inverse;
  }
}
