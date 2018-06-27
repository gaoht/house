package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class CleanRecord
  implements Serializable
{
  private String DESP;
  private String ID;
  private String OPTIME;
  private String OPTNAME;
  
  public String getDESP()
  {
    return this.DESP;
  }
  
  public String getID()
  {
    return this.ID;
  }
  
  public String getOPTIME()
  {
    return this.OPTIME;
  }
  
  public String getOPTNAME()
  {
    return this.OPTNAME;
  }
  
  public void setDESP(String paramString)
  {
    this.DESP = paramString;
  }
  
  public void setID(String paramString)
  {
    this.ID = paramString;
  }
  
  public void setOPTIME(String paramString)
  {
    this.OPTIME = paramString;
  }
  
  public void setOPTNAME(String paramString)
  {
    this.OPTNAME = paramString;
  }
  
  public String toString()
  {
    return "CleanRecord [workBillId=" + this.ID + ", OPTNAME=" + this.OPTNAME + ", OPTIME=" + this.OPTIME + ", DESP=" + this.DESP + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */