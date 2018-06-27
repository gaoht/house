package com.mato.sdk.proxy;

import com.mato.sdk.b.f;
import com.mato.sdk.b.h;
import com.mato.sdk.d.g;
import com.mato.sdk.d.i;
import com.mato.sdk.f.l;
import java.io.IOException;
import java.net.Socket;

public abstract class a
{
  public static a a;
  private static a b;
  private static l c = new l();
  private static com.mato.sdk.b.e d;
  
  static
  {
    c localc = new c();
    a = localc;
    b = localc;
  }
  
  public static com.mato.sdk.b.e a()
  {
    return d;
  }
  
  public static void a(com.mato.sdk.b.e parame)
  {
    d = parame;
  }
  
  public static void a(a parama)
  {
    a locala = parama;
    if (parama == null) {
      locala = a;
    }
    b = locala;
  }
  
  public static a b()
  {
    return b;
  }
  
  public static l c()
  {
    return c;
  }
  
  public static String d()
  {
    return com.mato.sdk.b.b.b(d.d());
  }
  
  public abstract Socket a(String paramString, int paramInt1, int paramInt2);
  
  public abstract void a(f paramf);
  
  public abstract void a(com.mato.sdk.e.b.b paramb, int paramInt);
  
  public abstract void a(com.mato.sdk.f.e<?> parame);
  
  public abstract void a(String paramString);
  
  public abstract void a(Socket paramSocket)
    throws IOException;
  
  public abstract void e()
    throws p;
  
  public abstract void f();
  
  public abstract Address g();
  
  public abstract h h();
  
  public abstract g i();
  
  public abstract boolean j();
  
  public abstract String k();
  
  public abstract f l();
  
  public abstract i m();
  
  public abstract int n();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */