package com.mato.sdk.proxy;

import android.util.Log;
import com.mato.sdk.b.f;
import com.mato.sdk.b.h;
import com.mato.sdk.d.g;
import com.mato.sdk.d.i;
import com.mato.sdk.e.b.b;
import com.mato.sdk.f.e;
import com.mato.sdk.f.l;
import java.io.IOException;
import java.net.Socket;

public final class c
  extends a
{
  private static final String b = "MAA";
  
  public final Socket a(String paramString, int paramInt1, int paramInt2)
  {
    Log.w("MAA", "[default-agent]: connect");
    return null;
  }
  
  public final void a(f paramf) {}
  
  public final void a(b paramb, int paramInt) {}
  
  public final void a(e<?> parame)
  {
    c().a(parame);
  }
  
  public final void a(String paramString) {}
  
  public final void a(Socket paramSocket)
    throws IOException
  {
    Log.w("MAA", "[default-agent]: close");
  }
  
  public final void e()
    throws p
  {}
  
  public final void f()
  {
    Log.w("MAA", "[default-agent]: setWebviewProxy");
  }
  
  public final Address g()
  {
    Log.w("MAA", "[default-agent]: getAddress");
    return null;
  }
  
  public final h h()
  {
    Log.w("MAA", "[default-agent]: getNetworkType");
    return new h();
  }
  
  public final g i()
  {
    return new g();
  }
  
  public final boolean j()
  {
    return false;
  }
  
  public final String k()
  {
    return null;
  }
  
  public final f l()
  {
    return null;
  }
  
  public final i m()
  {
    return null;
  }
  
  public final int n()
  {
    return 8;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */