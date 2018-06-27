package com.alipay.android.a.a.a;

public class b
  extends RuntimeException
{
  private String a;
  private int b;
  private String c;
  
  public b(Integer paramInteger, String paramString)
  {
    super(a(paramInteger, paramString));
    this.b = paramInteger.intValue();
    this.c = paramString;
  }
  
  public b(Integer paramInteger, String paramString, Throwable paramThrowable)
  {
    super(a(paramInteger, paramString), paramThrowable);
    this.b = paramInteger.intValue();
    this.c = paramString;
  }
  
  public b(Integer paramInteger, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.b = paramInteger.intValue();
  }
  
  public b(String paramString)
  {
    super(paramString);
    this.b = 0;
    this.c = paramString;
  }
  
  protected static String a(Integer paramInteger, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RPCException: ");
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
    return this.b;
  }
  
  public String getMsg()
  {
    return this.c;
  }
  
  public String getOperationType()
  {
    return this.a;
  }
  
  public void setOperationType(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/android/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */