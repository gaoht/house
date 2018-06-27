package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class CleanServiceDetail
  implements Serializable
{
  private String LEASECONTRACT;
  private int PAYSTATE;
  private String ROOMNUM;
  private String VASBCONTENT;
  private String VASBID;
  private double VASBPRICE;
  private String VASNAME;
  private String VASPHONE;
  private int VASSCORE;
  private int VASSTATE;
  
  public String getLEASECONTRACT()
  {
    return this.LEASECONTRACT;
  }
  
  public int getPAYSTATE()
  {
    return this.PAYSTATE;
  }
  
  public String getROOMNUM()
  {
    return this.ROOMNUM;
  }
  
  public String getVASBCONTENT()
  {
    return this.VASBCONTENT;
  }
  
  public String getVASBID()
  {
    return this.VASBID;
  }
  
  public double getVASBPRICE()
  {
    return this.VASBPRICE;
  }
  
  public String getVASNAME()
  {
    return this.VASNAME;
  }
  
  public String getVASPHONE()
  {
    return this.VASPHONE;
  }
  
  public int getVASSCORE()
  {
    return this.VASSCORE;
  }
  
  public int getVASSTATE()
  {
    return this.VASSTATE;
  }
  
  public void setLEASECONTRACT(String paramString)
  {
    this.LEASECONTRACT = paramString;
  }
  
  public void setPAYSTATE(int paramInt)
  {
    this.PAYSTATE = paramInt;
  }
  
  public void setROOMNUM(String paramString)
  {
    this.ROOMNUM = paramString;
  }
  
  public void setVASBCONTENT(String paramString)
  {
    this.VASBCONTENT = paramString;
  }
  
  public void setVASBID(String paramString)
  {
    this.VASBID = paramString;
  }
  
  public void setVASBPRICE(double paramDouble)
  {
    this.VASBPRICE = paramDouble;
  }
  
  public void setVASNAME(String paramString)
  {
    this.VASNAME = paramString;
  }
  
  public void setVASPHONE(String paramString)
  {
    this.VASPHONE = paramString;
  }
  
  public void setVASSCORE(int paramInt)
  {
    this.VASSCORE = paramInt;
  }
  
  public void setVASSTATE(int paramInt)
  {
    this.VASSTATE = paramInt;
  }
  
  public String toString()
  {
    return "CleanServiceDetail [VASNAME=" + this.VASNAME + ", VASBCONTENT=" + this.VASBCONTENT + ", ROOMNUM=" + this.ROOMNUM + ", VASPHONE=" + this.VASPHONE + ", VASBID=" + this.VASBID + ", LEASECONTRACT=" + this.LEASECONTRACT + ", VASBPRICE=" + this.VASBPRICE + ", VASSTATE=" + this.VASSTATE + ", PAYSTATE=" + this.PAYSTATE + ", VASSCORE=" + this.VASSCORE + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanServiceDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */