package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.l.e;
import com.megvii.zhimasdk.b.a.o.a;
import java.net.Socket;

@Deprecated
public class o
  extends d
{
  public o(Socket paramSocket, int paramInt, e parame)
  {
    a.a(paramSocket, "Socket");
    if (paramInt < 0) {
      paramInt = paramSocket.getSendBufferSize();
    }
    for (;;)
    {
      if (paramInt < 1024) {
        paramInt = i;
      }
      for (;;)
      {
        a(paramSocket.getOutputStream(), paramInt, parame);
        return;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */