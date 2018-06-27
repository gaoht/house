package com.ziroom.datacenter.remote.responsebody.financial.move;

import java.io.Serializable;

public class l
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  private String d;
  private int e;
  private String f;
  private int g;
  
  public String getDesc()
  {
    return this.f;
  }
  
  public String getGoodsId()
  {
    return this.a;
  }
  
  public String getLargeimgurl()
  {
    return this.c;
  }
  
  public String getName()
  {
    return this.d;
  }
  
  public int getNum()
  {
    return this.g;
  }
  
  public int getPrice()
  {
    return this.e;
  }
  
  public String getSmallimgurl()
  {
    return this.b;
  }
  
  public void setDesc(String paramString)
  {
    this.f = paramString;
  }
  
  public void setGoodsId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setLargeimgurl(String paramString)
  {
    this.c = paramString;
  }
  
  public void setName(String paramString)
  {
    this.d = paramString;
  }
  
  public void setNum(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setPrice(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setSmallimgurl(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/move/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */