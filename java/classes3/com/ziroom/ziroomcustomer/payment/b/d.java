package com.ziroom.ziroomcustomer.payment.b;

import java.io.Serializable;
import java.util.List;

public class d
  implements Serializable
{
  private String a;
  private List<c> b;
  private int c;
  private int d;
  
  public int getAmount()
  {
    return this.c;
  }
  
  public List<c> getCards()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public int getOrderType()
  {
    return this.d;
  }
  
  public void setAmount(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setCards(List<c> paramList)
  {
    this.b = paramList;
  }
  
  public void setName(String paramString)
  {
    this.a = paramString;
  }
  
  public void setOrderType(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */