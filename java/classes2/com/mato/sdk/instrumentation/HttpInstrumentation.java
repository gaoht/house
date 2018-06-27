package com.mato.sdk.instrumentation;

import android.util.Log;
import com.mato.sdk.b.g;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public final class HttpInstrumentation
{
  private static boolean a(URL paramURL)
  {
    boolean bool = InstrumentationUtils.a(paramURL);
    if (bool) {
      Log.d(g.a, "bypass");
    }
    return bool;
  }
  
  public static final Object getContent(URL paramURL)
    throws IOException
  {
    return openConnection(paramURL).getContent();
  }
  
  public static final Object getContent(URL paramURL, Class<?>[] paramArrayOfClass)
    throws IOException
  {
    return openConnection(paramURL).getContent(paramArrayOfClass);
  }
  
  public static URLConnection openConnection(URL paramURL)
    throws IOException
  {
    Object localObject = InstrumentationUtils.getHttpProxy();
    boolean bool = InstrumentationUtils.a(paramURL);
    if (bool) {
      Log.d(g.a, "bypass");
    }
    if ((!bool) && (localObject != null)) {
      try
      {
        localObject = paramURL.openConnection((Proxy)localObject);
        return (URLConnection)localObject;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        Log.d(g.a, "UnsupportedOperationException: url.openConnection(proxy)");
        return paramURL.openConnection();
      }
    }
    return paramURL.openConnection();
  }
  
  public static final InputStream openStream(URL paramURL)
    throws IOException
  {
    return openConnection(paramURL).getInputStream();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/instrumentation/HttpInstrumentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */