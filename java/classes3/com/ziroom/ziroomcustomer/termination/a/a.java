package com.ziroom.ziroomcustomer.termination.a;

import com.ziroom.ziroomcustomer.model.GiftList;
import java.io.Serializable;
import java.util.List;

public class a
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  private String d;
  private double e;
  private double f;
  private double g;
  private double h;
  private List<Integer> i;
  private List<GiftList> j;
  
  public double getAccountBalance()
  {
    return this.h;
  }
  
  public String getAddress()
  {
    return this.d;
  }
  
  public String getCheckoutDate()
  {
    return this.b;
  }
  
  public String getContractCode()
  {
    return this.c;
  }
  
  public double getFee()
  {
    return this.e;
  }
  
  public List<GiftList> getGiftList()
  {
    return this.j;
  }
  
  public String getMoveAwayDate()
  {
    return this.a;
  }
  
  public double getPayFee()
  {
    return this.f;
  }
  
  public List<Integer> getPayTypeList()
  {
    return this.i;
  }
  
  public double getShouldPay()
  {
    return this.g;
  }
  
  public void setAccountBalance(double paramDouble)
  {
    this.h = paramDouble;
  }
  
  public void setAddress(String paramString)
  {
    this.d = paramString;
  }
  
  public void setCheckoutDate(String paramString)
  {
    this.b = paramString;
  }
  
  public void setContractCode(String paramString)
  {
    this.c = paramString;
  }
  
  public void setFee(double paramDouble)
  {
    this.e = paramDouble;
  }
  
  public void setGiftList(List<GiftList> paramList)
  {
    this.j = paramList;
  }
  
  public void setMoveAwayDate(String paramString)
  {
    this.a = paramString;
  }
  
  public void setPayFee(double paramDouble)
  {
    this.f = paramDouble;
  }
  
  public void setPayTypeList(List<Integer> paramList)
  {
    this.i = paramList;
  }
  
  public void setShouldPay(double paramDouble)
  {
    this.g = paramDouble;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */