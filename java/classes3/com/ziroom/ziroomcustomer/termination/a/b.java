package com.ziroom.ziroomcustomer.termination.a;

import java.io.Serializable;

public class b
  implements Serializable
{
  private String a;
  private int b;
  private int c;
  
  public b() {}
  
  public b(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public String getDate()
  {
    return this.a;
  }
  
  public int getState()
  {
    return this.b;
  }
  
  public int getWhichPosInAfter3()
  {
    return this.c;
  }
  
  public void setDate(String paramString)
  {
    this.a = paramString;
  }
  
  public void setState(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setWhichPosInAfter3(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */