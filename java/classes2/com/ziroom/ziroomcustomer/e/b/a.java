package com.ziroom.ziroomcustomer.e.b;

public class a
  extends Exception
{
  private String a;
  
  public a(String paramString)
  {
    this.a = paramString;
  }
  
  public a(String paramString1, String paramString2)
  {
    super(paramString2);
    this.a = paramString1;
  }
  
  public String getCode()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */