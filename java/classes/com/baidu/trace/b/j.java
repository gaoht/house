package com.baidu.trace.b;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public final class j
  implements b
{
  private Socket a = null;
  private DataOutputStream b = null;
  
  protected static j e()
  {
    return new j();
  }
  
  public final void a()
  {
    try
    {
      if (this.b != null) {
        this.b.close();
      }
      if ((this.a != null) && (!this.a.isClosed())) {
        this.a.close();
      }
      return;
    }
    catch (Exception localException) {}finally
    {
      this.b = null;
      this.a = null;
    }
  }
  
  public final void a(e parame)
  {
    try
    {
      this.a = new Socket();
      this.a.connect(new InetSocketAddress("gateway.yingyan.baidu.com", 8300), 8000);
      this.a.setKeepAlive(true);
      if (b())
      {
        parame.a();
        return;
      }
      parame.b();
      return;
    }
    catch (Exception localException)
    {
      if (a.a.a == a.a())
      {
        parame.b();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (a.a.a == a.a()) {
        parame.b();
      }
    }
  }
  
  public final void a(byte[] paramArrayOfByte)
    throws IOException
  {
    if (this.b == null) {
      this.b = new DataOutputStream(this.a.getOutputStream());
    }
    if (paramArrayOfByte != null)
    {
      this.b.write(paramArrayOfByte);
      this.b.flush();
    }
  }
  
  public final boolean b()
  {
    if (this.a == null) {}
    while ((!this.a.isConnected()) || (this.a.isClosed()) || (this.a.isInputShutdown()) || (this.a.isOutputShutdown())) {
      return false;
    }
    return true;
  }
  
  public final int c()
  {
    if (this.a != null) {
      return this.a.getLocalPort();
    }
    return 0;
  }
  
  public final InputStream d()
    throws IOException
  {
    return this.a.getInputStream();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */