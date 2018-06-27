package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuLimitRulesBean
{
  public DataBean data;
  public String message;
  public String status;
  
  public static class DataBean
  {
    public int heightPixel;
    public int heightScale;
    public double lowerLimitRate;
    public int maxSize;
    public int minDpi;
    public int minPixel;
    public double upperLimitRate;
    public int widthPixel;
    public int widthScale;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuLimitRulesBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */