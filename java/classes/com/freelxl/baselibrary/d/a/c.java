package com.freelxl.baselibrary.d.a;

import com.freelxl.baselibrary.d.c.b;
import d.e;
import d.h;
import d.l;
import d.t;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

public class c
  extends ResponseBody
{
  private final ResponseBody a;
  private final b b;
  private e c;
  
  public c(ResponseBody paramResponseBody, b paramb)
  {
    this.a = paramResponseBody;
    this.b = paramb;
  }
  
  private t a(t paramt)
  {
    new h(paramt)
    {
      long a;
      
      public long read(d.c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        long l1 = super.read(paramAnonymousc, paramAnonymousLong);
        long l2 = this.a;
        if (l1 != -1L) {}
        for (paramAnonymousLong = l1;; paramAnonymousLong = 0L)
        {
          this.a = (paramAnonymousLong + l2);
          if (c.a(c.this) != null) {
            c.a(c.this).onOKProgress(this.a, c.b(c.this).contentLength());
          }
          return l1;
        }
      }
    };
  }
  
  public long contentLength()
  {
    return this.a.contentLength();
  }
  
  public MediaType contentType()
  {
    return this.a.contentType();
  }
  
  public e source()
  {
    if (this.c == null) {
      this.c = l.buffer(a(this.a.source()));
    }
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */