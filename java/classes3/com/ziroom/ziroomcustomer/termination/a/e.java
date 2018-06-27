package com.ziroom.ziroomcustomer.termination.a;

import java.io.Serializable;
import java.util.List;

public class e
  implements Serializable
{
  private String a;
  private float b;
  private List<f> c;
  
  public String getContractCode()
  {
    return this.a;
  }
  
  public List<f> getGoodsList()
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
  
  public void setGoodsList(List<f> paramList)
  {
    this.c = paramList;
  }
  
  public void setTotalAccount(float paramFloat)
  {
    this.b = paramFloat;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */