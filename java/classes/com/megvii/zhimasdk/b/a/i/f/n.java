package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.j.b;
import com.megvii.zhimasdk.b.a.l.e;
import com.megvii.zhimasdk.b.a.o.a;
import java.net.Socket;

@Deprecated
public class n
  extends c
  implements b
{
  private final Socket a;
  private boolean b;
  
  public n(Socket paramSocket, int paramInt, e parame)
  {
    a.a(paramSocket, "Socket");
    this.a = paramSocket;
    this.b = false;
    if (paramInt < 0) {
      paramInt = paramSocket.getReceiveBufferSize();
    }
    for (;;)
    {
      if (paramInt < 1024) {
        paramInt = i;
      }
      for (;;)
      {
        a(paramSocket.getInputStream(), paramInt, parame);
        return;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = g();
    boolean bool1 = bool2;
    int i;
    if (!bool2) {
      i = this.a.getSoTimeout();
    }
    try
    {
      this.a.setSoTimeout(paramInt);
      f();
      bool1 = g();
      return bool1;
    }
    finally
    {
      this.a.setSoTimeout(i);
    }
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  protected int f()
  {
    int i = super.f();
    if (i == -1) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      return i;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */