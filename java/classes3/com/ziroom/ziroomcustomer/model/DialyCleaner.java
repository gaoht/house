package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class DialyCleaner
  implements Serializable
{
  private String cleanNum;
  private String cleanScore;
  private String clrName;
  private String clrPhone;
  private String clrPic;
  
  public String getCleanNum()
  {
    return this.cleanNum;
  }
  
  public String getCleanScore()
  {
    return this.cleanScore;
  }
  
  public String getClrName()
  {
    return this.clrName;
  }
  
  public String getClrPhone()
  {
    return this.clrPhone;
  }
  
  public String getClrPic()
  {
    return this.clrPic;
  }
  
  public void setCleanNum(String paramString)
  {
    this.cleanNum = paramString;
  }
  
  public void setCleanScore(String paramString)
  {
    this.cleanScore = paramString;
  }
  
  public void setClrName(String paramString)
  {
    this.clrName = paramString;
  }
  
  public void setClrPhone(String paramString)
  {
    this.clrPhone = paramString;
  }
  
  public void setClrPic(String paramString)
  {
    this.clrPic = paramString;
  }
  
  public String toString()
  {
    return "DialyCleaner [clrName=" + this.clrName + ", clrPhone=" + this.clrPhone + ", cleanNum=" + this.cleanNum + ", cleanScore=" + this.cleanScore + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/DialyCleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */