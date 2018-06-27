package com.megvii.zhimasdk.a;

public class d
  extends Exception
{
  private String a;
  private String b;
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    super(paramString2);
    this.a = paramString1;
    this.b = paramString3;
  }
  
  public d(String paramString1, String paramString2, Throwable paramThrowable, String paramString3)
  {
    super(paramString2, paramThrowable);
    this.a = paramString1;
    this.b = paramString3;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */