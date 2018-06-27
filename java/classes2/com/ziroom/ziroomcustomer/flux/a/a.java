package com.ziroom.ziroomcustomer.flux.a;

public class a
{
  protected final String a;
  protected final String b;
  
  public a(String paramString)
  {
    this(paramString, null, null);
  }
  
  public a(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public a(String paramString1, String paramString2, Object paramObject)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String getTarget()
  {
    return this.b;
  }
  
  public String getType()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/flux/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */