package com.ziroom.commonlibrary.a;

import com.alibaba.fastjson.e;

public class b
  extends Exception
{
  private int a;
  private String b;
  private e c;
  
  public b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public b(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public b(int paramInt, String paramString, e parame)
  {
    super(paramString);
    this.a = paramInt;
    this.c = parame;
  }
  
  public b(String paramString)
  {
    this.b = paramString;
  }
  
  public b(String paramString1, String paramString2)
  {
    super(paramString2);
    this.b = paramString1;
  }
  
  public b(String paramString1, String paramString2, e parame)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/commonlibrary/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */