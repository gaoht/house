package com.ziroom.ziroomcustomer.reserve;

import com.ziroom.ziroomcustomer.model.GiftList;
import java.io.Serializable;
import java.util.List;

public class e
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  private float d;
  private int e;
  private List<Integer> f;
  private List<GiftList> g;
  
  public int getAccountBalance()
  {
    return this.e;
  }
  
  public float getDeposit()
  {
    return this.d;
  }
  
  public List<GiftList> getGiftList()
  {
    return this.g;
  }
  
  public String getHouseAddress()
  {
    return this.b;
  }
  
  public String getLastPageTime()
  {
    return this.c;
  }
  
  public List<Integer> getPayTypeList()
  {
    return this.f;
  }
  
  public String getReserveCode()
  {
    return this.a;
  }
  
  public void setAccountBalance(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setDeposit(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public void setGiftList(List<GiftList> paramList)
  {
    this.g = paramList;
  }
  
  public void setHouseAddress(String paramString)
  {
    this.b = paramString;
  }
  
  public void setLastPageTime(String paramString)
  {
    this.c = paramString;
  }
  
  public void setPayTypeList(List<Integer> paramList)
  {
    this.f = paramList;
  }
  
  public void setReserveCode(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/reserve/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */