package com.alipay.android.a.a.a;

public class a
  extends Exception
{
  private int a;
  private String b;
  
  public a(Integer paramInteger, String paramString)
  {
    super(a(paramInteger, paramString));
    this.a = paramInteger.intValue();
    this.b = paramString;
  }
  
  public a(String paramString)
  {
    super(paramString);
    this.a = 0;
    this.b = paramString;
  }
  
  private static String a(Integer paramInteger, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Http Transport error");
    if (paramInteger != null) {
      localStringBuilder.append("[").append(paramInteger).append("]");
    }
    localStringBuilder.append(" : ");
    if (paramString != null) {
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  public int getCode()
  {
    return this.a;
  }
  
  public String getMsg()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/android/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */