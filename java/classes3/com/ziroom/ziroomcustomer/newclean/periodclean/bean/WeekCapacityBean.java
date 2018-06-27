package com.ziroom.ziroomcustomer.newclean.periodclean.bean;

import java.util.List;

public class WeekCapacityBean
{
  private String dataLab;
  private Long datePlan;
  private List<DatePlanListBean> datePlanList;
  private String flag;
  private String timePoint;
  
  public String getDataLab()
  {
    return this.dataLab;
  }
  
  public Long getDatePlan()
  {
    return this.datePlan;
  }
  
  public List<DatePlanListBean> getDatePlanList()
  {
    return this.datePlanList;
  }
  
  public String getFlag()
  {
    return this.flag;
  }
  
  public String getTimePoint()
  {
    return this.timePoint;
  }
  
  public void setDataLab(String paramString)
  {
    this.dataLab = paramString;
  }
  
  public void setDatePlan(Long paramLong)
  {
    this.datePlan = paramLong;
  }
  
  public void setDatePlanList(List<DatePlanListBean> paramList)
  {
    this.datePlanList = paramList;
  }
  
  public void setFlag(String paramString)
  {
    this.flag = paramString;
  }
  
  public void setTimePoint(String paramString)
  {
    this.timePoint = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/bean/WeekCapacityBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */