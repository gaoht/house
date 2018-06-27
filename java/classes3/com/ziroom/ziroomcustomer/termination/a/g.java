package com.ziroom.ziroomcustomer.termination.a;

import java.io.Serializable;
import java.util.List;

public class g
  implements Serializable
{
  private String a;
  private float b;
  private List<h> c;
  
  public String getContractCode()
  {
    return this.a;
  }
  
  public List<h> getExpendsList()
  {
    return this.c;
  }
  
  public float getTotalAccount()
  {
    return this.b;
  }
  
  public void setContractCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setExpendsList(List<h> paramList)
  {
    this.c = paramList;
  }
  
  public void setTotalAccount(float paramFloat)
  {
    this.b = paramFloat;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */