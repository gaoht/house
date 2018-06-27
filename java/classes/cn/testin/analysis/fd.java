package cn.testin.analysis;

import java.io.BufferedOutputStream;
import java.net.URI;
import java.nio.ByteBuffer;

public class fd
{
  private static final ByteBuffer e = ByteBuffer.allocate(0);
  private final ff a;
  private final fh b;
  private final fg c;
  private final URI d;
  
  public fd(URI paramURI, ff paramff, fh paramfh)
  {
    this.b = paramfh;
    this.a = paramff;
    this.d = paramURI;
    try
    {
      this.c = new fg(this, paramURI, 10000);
      this.c.c();
      return;
    }
    catch (InterruptedException paramURI)
    {
      throw new di(paramURI);
    }
  }
  
  public void a()
  {
    if (b()) {
      this.c.d();
    }
  }
  
  public boolean b()
  {
    return (!this.c.f()) && (!this.c.g()) && (!this.c.e());
  }
  
  public BufferedOutputStream c()
  {
    return new BufferedOutputStream(new fi(this, null));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */