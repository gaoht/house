package com.ziroom.ziroomcustomer.minsu.f;

import org.greenrobot.eventbus.c;

public class g<T>
{
  private int a;
  private String b;
  private String c;
  private T d;
  
  public g(int paramInt)
  {
    this.a = paramInt;
  }
  
  public g(int paramInt, T paramT, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.d = paramT;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public static void sendFailEvent()
  {
    g localg = new g(0);
    c.getDefault().post(localg);
  }
  
  public T getData()
  {
    return (T)this.d;
  }
  
  public String getFilePath()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.c;
  }
  
  public int getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */