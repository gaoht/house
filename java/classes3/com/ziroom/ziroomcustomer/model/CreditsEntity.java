package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class CreditsEntity
  implements Serializable
{
  private int authStatus;
  private int educationStatus;
  private int linkedinStatus;
  private int realNameStatus;
  private int workStatus;
  private int zhimaScore;
  private int ziroomScore;
  
  public int getAuthStatus()
  {
    return this.authStatus;
  }
  
  public int getEducationStatus()
  {
    return this.educationStatus;
  }
  
  public int getLinkedinStatus()
  {
    return this.linkedinStatus;
  }
  
  public int getRealNameStatus()
  {
    return this.realNameStatus;
  }
  
  public int getWorkStatus()
  {
    return this.workStatus;
  }
  
  public int getZhimaScore()
  {
    return this.zhimaScore;
  }
  
  public int getZiroomScore()
  {
    return this.ziroomScore;
  }
  
  public void setAuthStatus(int paramInt)
  {
    this.authStatus = paramInt;
  }
  
  public void setEducationStatus(int paramInt)
  {
    this.educationStatus = paramInt;
  }
  
  public void setLinkedinStatus(int paramInt)
  {
    this.linkedinStatus = paramInt;
  }
  
  public void setRealNameStatus(int paramInt)
  {
    this.realNameStatus = paramInt;
  }
  
  public void setWorkStatus(int paramInt)
  {
    this.workStatus = paramInt;
  }
  
  public void setZhimaScore(int paramInt)
  {
    this.zhimaScore = paramInt;
  }
  
  public void setZiroomScore(int paramInt)
  {
    this.ziroomScore = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CreditsEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */