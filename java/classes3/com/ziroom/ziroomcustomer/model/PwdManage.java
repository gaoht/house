package com.ziroom.ziroomcustomer.model;

public class PwdManage
{
  private String begin;
  private String createTime;
  private String createTimeL;
  private String end;
  private int passwordId;
  private int passwordType;
  private String status;
  private String statusI;
  private String userId;
  private String userName;
  private String userPhone;
  
  public String getBegin()
  {
    return this.begin;
  }
  
  public String getCreateTime()
  {
    return this.createTime;
  }
  
  public String getCreateTimeL()
  {
    return this.createTimeL;
  }
  
  public String getEnd()
  {
    return this.end;
  }
  
  public int getPasswordId()
  {
    return this.passwordId;
  }
  
  public int getPasswordType()
  {
    return this.passwordType;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public String getStatusI()
  {
    return this.statusI;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public String getUserPhone()
  {
    return this.userPhone;
  }
  
  public void setBegin(String paramString)
  {
    this.begin = paramString;
  }
  
  public void setCreateTime(String paramString)
  {
    this.createTime = paramString;
  }
  
  public void setCreateTimeL(String paramString)
  {
    this.createTimeL = paramString;
  }
  
  public void setEnd(String paramString)
  {
    this.end = paramString;
  }
  
  public void setPasswordId(int paramInt)
  {
    this.passwordId = paramInt;
  }
  
  public void setPasswordType(int paramInt)
  {
    this.passwordType = paramInt;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public void setStatusI(String paramString)
  {
    this.statusI = paramString;
  }
  
  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public void setUserPhone(String paramString)
  {
    this.userPhone = paramString;
  }
  
  public String toString()
  {
    return "PwdManage [passwordId=" + this.passwordId + ", createTime=" + this.createTime + ", status=" + this.status + ", userName=" + this.userName + ", userPhone=" + this.userPhone + ", passwordType=" + this.passwordType + ", userId=" + this.userId + ", begin=" + this.begin + ", end=" + this.end + ", createTimeL=" + this.createTimeL + ", statusI=" + this.statusI + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/PwdManage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */