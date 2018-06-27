package com.ziroom.ziroomcustomer.payment.b;

import java.io.Serializable;

public class c
  implements Serializable
{
  private String a;
  private String b;
  private int c;
  private String d;
  private String e;
  private int f;
  private boolean g;
  private String h;
  private int i;
  private boolean j = true;
  
  public String getCode()
  {
    return this.a;
  }
  
  public String getDesc()
  {
    return this.b;
  }
  
  public int getMoney()
  {
    return this.c;
  }
  
  public String getName()
  {
    return this.d;
  }
  
  public String getParentName()
  {
    return this.h;
  }
  
  public int getParentType()
  {
    return this.i;
  }
  
  public String getRule()
  {
    return this.e;
  }
  
  public int getUseStatus()
  {
    return this.f;
  }
  
  public boolean isCanSelect()
  {
    return this.j;
  }
  
  public boolean isChecked()
  {
    return this.g;
  }
  
  public void setCanSelect(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setDesc(String paramString)
  {
    this.b = paramString;
  }
  
  public void setMoney(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.d = paramString;
  }
  
  public void setParentName(String paramString)
  {
    this.h = paramString;
  }
  
  public void setParentType(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setRule(String paramString)
  {
    this.e = paramString;
  }
  
  public void setUseStatus(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */