package com.ziroom.ziroomcustomer.living;

import java.io.Serializable;
import java.util.List;

public class b
  implements Serializable
{
  private String a;
  private List<c> b;
  
  public List<c> getChillBillList()
  {
    return this.b;
  }
  
  public String getPayMonth()
  {
    return this.a;
  }
  
  public void setChillBillList(List<c> paramList)
  {
    this.b = paramList;
  }
  
  public void setPayMonth(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */