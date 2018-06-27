package com.freelxl.baselibrary.d.a;

import d.c;
import d.d;
import d.g;
import d.l;
import d.s;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class b
  extends RequestBody
{
  private final RequestBody a;
  private final com.freelxl.baselibrary.d.c.b b;
  private d c;
  
  public b(RequestBody paramRequestBody, com.freelxl.baselibrary.d.c.b paramb)
  {
    this.a = paramRequestBody;
    this.b = paramb;
  }
  
  private s a(s params)
  {
    new g(params)
    {
      long a = 0L;
      long b = 0L;
      
      public void write(c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        super.write(paramAnonymousc, paramAnonymousLong);
        if (this.b == 0L) {
          this.b = b.this.contentLength();
        }
        this.a += paramAnonymousLong;
        if ((b.a(b.this) != null) && (this.b > 0L)) {
          b.a(b.this).onOKProgress(this.a, this.b);
        }
      }
    };
  }
  
  public long contentLength()
    throws IOException
  {
    return this.a.contentLength();
  }
  
  public MediaType contentType()
  {
    return this.a.contentType();
  }
  
  public void writeTo(d paramd)
    throws IOException
  {
    if (this.c == null) {
      this.c = l.buffer(a(paramd));
    }
    this.a.writeTo(this.c);
    this.c.flush();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */