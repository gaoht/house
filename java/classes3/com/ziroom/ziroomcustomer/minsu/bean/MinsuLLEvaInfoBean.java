package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuLLEvaInfoBean
{
  public String endTimeStr;
  public int evaStatus;
  public String houseName;
  public int housingDay;
  public LanEvaInfoBean lanEvaInfo;
  public LanRepInfoBean lanRepInfo;
  public String landlordName;
  public String orderDetailUrl;
  public String orderSn;
  public int peopleNum;
  public String picUrl;
  public String pjButton;
  public int pjStatus;
  public String startTimeStr;
  public String titleName;
  public String titleTime;
  public String titleTips;
  public UserEvaInfoBean userEvaInfo;
  public String userName;
  
  public static class LanEvaInfoBean
  {
    public String content;
    public String createTime;
    public int landlordSatisfied;
  }
  
  public static class LanRepInfoBean
  {
    public String content;
    public String createTime;
  }
  
  public static class UserEvaInfoBean
  {
    public String content;
    public int costPerformance;
    public String createTime;
    public int descriptionMatch;
    public int houseClean;
    public int safetyDegree;
    public int trafficPosition;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuLLEvaInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */