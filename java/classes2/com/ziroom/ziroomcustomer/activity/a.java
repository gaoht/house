package com.ziroom.ziroomcustomer.activity;

import java.io.Serializable;
import java.util.ArrayList;

public class a
  implements Serializable
{
  private int a;
  private float b;
  private int c;
  private int d;
  private int e;
  private String f;
  private int g;
  private ArrayList<String> h;
  
  public int getCanPayPenalty()
  {
    return this.g;
  }
  
  public int getPenaltyNum()
  {
    return this.c;
  }
  
  public int getPeriods()
  {
    return this.e;
  }
  
  public float getReceivableMoney()
  {
    return this.b;
  }
  
  public String getStatus()
  {
    return this.f;
  }
  
  public int getSysContractId()
  {
    return this.d;
  }
  
  public int getSysPenaltyId()
  {
    return this.a;
  }
  
  public ArrayList<String> getWyjPayTypeList()
  {
    return this.h;
  }
  
  public void setCanPayPenalty(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setPenaltyNum(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setPeriods(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setReceivableMoney(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void setStatus(String paramString)
  {
    this.f = paramString;
  }
  
  public void setSysContractId(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setSysPenaltyId(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setWyjPayTypeList(ArrayList<String> paramArrayList)
  {
    this.h = paramArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */