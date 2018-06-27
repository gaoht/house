package com.ziroom.commonlib.ziroomhttp.d;

public class b
  extends Exception
{
  private int a;
  
  public b() {}
  
  public b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public b(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public int getStatusCode()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/ziroomhttp/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */