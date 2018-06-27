package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.io.Serializable;

public class MHServiceBookTime
  implements Serializable
{
  private String fid;
  private String peroidEndPoint;
  private int peroidIndex;
  private String peroidName;
  private String peroidStartPoint;
  
  public MHServiceBookTime() {}
  
  public MHServiceBookTime(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.fid = paramString1;
    this.peroidName = paramString2;
    this.peroidIndex = paramInt;
    this.peroidStartPoint = paramString3;
    this.peroidEndPoint = paramString4;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public String getPeroidEndPoint()
  {
    return this.peroidEndPoint;
  }
  
  public int getPeroidIndex()
  {
    return this.peroidIndex;
  }
  
  public String getPeroidName()
  {
    return this.peroidName;
  }
  
  public String getPeroidStartPoint()
  {
    return this.peroidStartPoint;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setPeroidEndPoint(String paramString)
  {
    this.peroidEndPoint = paramString;
  }
  
  public void setPeroidIndex(int paramInt)
  {
    this.peroidIndex = paramInt;
  }
  
  public void setPeroidName(String paramString)
  {
    this.peroidName = paramString;
  }
  
  public void setPeroidStartPoint(String paramString)
  {
    this.peroidStartPoint = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MHServiceBookTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */