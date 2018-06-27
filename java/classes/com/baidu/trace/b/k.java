package com.baidu.trace.b;

import com.baidu.trace.a;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class k
  implements b
{
  private DatagramSocket a = null;
  private DatagramPacket b = null;
  private InetAddress c = null;
  private int d = 8300;
  
  private k(int paramInt)
  {
    this.d = paramInt;
  }
  
  protected static k a(int paramInt)
  {
    return new k(paramInt);
  }
  
  public final void a()
  {
    try
    {
      this.b = null;
      this.c = null;
      if ((this.a != null) && (!this.a.isClosed())) {
        this.a.close();
      }
      this.a = null;
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      this.a = null;
      return;
    }
    finally
    {
      localObject = finally;
      this.a = null;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(e parame)
  {
    try
    {
      this.a = new DatagramSocket(this.d);
      this.c = InetAddress.getByName("gateway.yingyan.baidu.com");
      this.b = new DatagramPacket(null, 0, this.c, 8300);
      return;
    }
    catch (IOException parame)
    {
      a.a("udp socket connect failed");
    }
  }
  
  public final void a(byte[] paramArrayOfByte)
    throws IOException
  {
    if (this.b == null) {
      this.b = new DatagramPacket(paramArrayOfByte, paramArrayOfByte.length, this.c, 8300);
    }
    for (;;)
    {
      this.a.send(this.b);
      return;
      this.b.setData(paramArrayOfByte);
      this.b.setLength(paramArrayOfByte.length);
    }
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final InputStream d()
    throws IOException
  {
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */