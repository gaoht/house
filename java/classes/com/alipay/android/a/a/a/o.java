package com.alipay.android.a.a.a;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

final class o
  extends DefaultRedirectHandler
{
  int a;
  
  o(n paramn) {}
  
  public final boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    this.a += 1;
    boolean bool2 = super.isRedirectRequested(paramHttpResponse, paramHttpContext);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.a < 5)
      {
        int i = paramHttpResponse.getStatusLine().getStatusCode();
        if (i != 301)
        {
          bool1 = bool2;
          if (i != 302) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/android/a/a/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */