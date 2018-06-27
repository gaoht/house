package com.megvii.zhimasdk.b.a.g;

import com.megvii.zhimasdk.b.a.n.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class g
  extends a
  implements Cloneable
{
  protected final byte[] d;
  
  public g(String paramString, e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramString, "Source string");
    if (parame != null) {}
    for (Charset localCharset1 = parame.a();; localCharset1 = null)
    {
      Charset localCharset2 = localCharset1;
      if (localCharset1 == null) {
        localCharset2 = d.a;
      }
      try
      {
        this.d = paramString.getBytes(localCharset2.name());
        if (parame != null) {
          a(parame.toString());
        }
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new UnsupportedCharsetException(localCharset2.name());
      }
    }
  }
  
  public InputStream a()
  {
    return new ByteArrayInputStream(this.d);
  }
  
  public void a(OutputStream paramOutputStream)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramOutputStream, "Output stream");
    paramOutputStream.write(this.d);
    paramOutputStream.flush();
  }
  
  public long b()
  {
    return this.d.length;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public boolean d()
  {
    return true;
  }
  
  public boolean f()
  {
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/g/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */