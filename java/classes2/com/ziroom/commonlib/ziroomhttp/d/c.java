package com.ziroom.commonlib.ziroomhttp.d;

import com.alibaba.fastjson.e;

public class c
  extends Exception
{
  private int a;
  private String b;
  private e c;
  
  public c(int paramInt)
  {
    this.a = paramInt;
  }
  
  public c(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public c(int paramInt, String paramString, e parame)
  {
    super(paramString);
    this.a = paramInt;
    this.c = parame;
  }
  
  public c(String paramString)
  {
    this.b = paramString;
  }
  
  public c(String paramString1, String paramString2)
  {
    super(paramString2);
    this.b = paramString1;
  }
  
  public c(String paramString1, String paramString2, e parame)
  {
    super(paramString2);
    this.b = paramString1;
    this.c = parame;
  }
  
  public int getCode()
  {
    return this.a;
  }
  
  public e getData()
  {
    return this.c;
  }
  
  public String getStrCode()
  {
    if (this.b == null) {
      return this.a + "";
    }
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/ziroomhttp/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */