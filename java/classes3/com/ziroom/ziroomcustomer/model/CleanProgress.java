package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class CleanProgress
  implements Serializable
{
  private String JIEDANTIME;
  private String SHANGMENTIME;
  private String SHOULITIME;
  private String WANCHENGTIME;
  private String workBillId;
  
  public String getJIEDANTIME()
  {
    return this.JIEDANTIME;
  }
  
  public String getSHANGMENTIME()
  {
    return this.SHANGMENTIME;
  }
  
  public String getSHOULITIME()
  {
    return this.SHOULITIME;
  }
  
  public String getWANCHENGTIME()
  {
    return this.WANCHENGTIME;
  }
  
  public String getWorkBillId()
  {
    return this.workBillId;
  }
  
  public void setJIEDANTIME(String paramString)
  {
    this.JIEDANTIME = paramString;
  }
  
  public void setSHANGMENTIME(String paramString)
  {
    this.SHANGMENTIME = paramString;
  }
  
  public void setSHOULITIME(String paramString)
  {
    this.SHOULITIME = paramString;
  }
  
  public void setWANCHENGTIME(String paramString)
  {
    this.WANCHENGTIME = paramString;
  }
  
  public void setWorkBillId(String paramString)
  {
    this.workBillId = paramString;
  }
  
  public String toString()
  {
    return "CleanProgress [workBillId=" + this.workBillId + ", SHOULITIME=" + this.SHOULITIME + ", SHANGMENTIME=" + this.SHANGMENTIME + ", WANCHENGTIME=" + this.WANCHENGTIME + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */