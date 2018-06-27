package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

public class ZryuSignPaymentInfo
{
  private ZryuSignKvLItem activityInfo;
  private ZryuSignKvItem billInfo;
  private ZryuSignKvLItem payInfo;
  private ZryuSignProject projectInfo;
  private ZryuSignKvItem totalPayInfo;
  
  public ZryuSignKvLItem getActivityInfo()
  {
    return this.activityInfo;
  }
  
  public ZryuSignKvItem getBillInfo()
  {
    return this.billInfo;
  }
  
  public ZryuSignKvLItem getPayInfo()
  {
    return this.payInfo;
  }
  
  public ZryuSignProject getProjectInfo()
  {
    return this.projectInfo;
  }
  
  public ZryuSignKvItem getTotalPayInfo()
  {
    return this.totalPayInfo;
  }
  
  public void setActivityInfo(ZryuSignKvLItem paramZryuSignKvLItem)
  {
    this.activityInfo = paramZryuSignKvLItem;
  }
  
  public void setBillInfo(ZryuSignKvItem paramZryuSignKvItem)
  {
    this.billInfo = paramZryuSignKvItem;
  }
  
  public void setPayInfo(ZryuSignKvLItem paramZryuSignKvLItem)
  {
    this.payInfo = paramZryuSignKvLItem;
  }
  
  public void setProjectInfo(ZryuSignProject paramZryuSignProject)
  {
    this.projectInfo = paramZryuSignProject;
  }
  
  public void setTotalPayInfo(ZryuSignKvItem paramZryuSignKvItem)
  {
    this.totalPayInfo = paramZryuSignKvItem;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignPaymentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */