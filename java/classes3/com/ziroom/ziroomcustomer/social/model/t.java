package com.ziroom.ziroomcustomer.social.model;

import java.io.Serializable;
import java.util.List;

public class t
  implements Serializable
{
  private int a;
  private int b;
  private List<p> c;
  
  public List<p> getList()
  {
    return this.c;
  }
  
  public int getTimes()
  {
    return this.b;
  }
  
  public int getTotal()
  {
    return this.a;
  }
  
  public void setList(List<p> paramList)
  {
    this.c = paramList;
  }
  
  public void setTimes(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setTotal(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/model/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */