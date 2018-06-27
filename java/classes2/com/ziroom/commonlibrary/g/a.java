package com.ziroom.commonlibrary.g;

public class a
{
  private static a b = new a();
  private com.ziroom.commonlibrary.receiver.a a;
  
  public static a getInstance()
  {
    return b;
  }
  
  public com.ziroom.commonlibrary.receiver.a getjPushListener()
  {
    return this.a;
  }
  
  public void setjPushListener(com.ziroom.commonlibrary.receiver.a parama)
  {
    b.a = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */