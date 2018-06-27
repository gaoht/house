package com.mato.sdk.c.d;

import android.content.Context;
import com.mato.sdk.c.c.b;
import com.mato.sdk.g.i;
import java.io.File;
import java.util.Locale;

public final class b
{
  private static final String a = com.mato.sdk.b.g.b("");
  private d b;
  private String c;
  private com.mato.sdk.proxy.g d;
  private boolean e = false;
  private String f;
  private Context g;
  
  public static b a()
  {
    return a.a();
  }
  
  public final void a(Context paramContext)
  {
    if (this.e) {
      return;
    }
    this.g = i.m(paramContext);
    this.c = i.k(this.g);
    this.f = i.f(this.g);
    if (this.c == null) {
      this.c = "unknown";
    }
    paramContext = new File(this.g.getFilesDir(), "com.maa.sdk");
    paramContext.mkdirs();
    paramContext = new File(paramContext, String.format(Locale.US, "event_%s.log", new Object[] { this.c }));
    paramContext.getAbsolutePath();
    this.d = com.mato.sdk.proxy.g.a(this.g);
    this.b = new d(paramContext);
    this.e = true;
  }
  
  public final void a(Throwable paramThrowable)
  {
    if (!this.e) {
      return;
    }
    paramThrowable = new e(paramThrowable, this.d).a().b(this.f).a();
    this.b.a(paramThrowable.a());
  }
  
  public final void b()
  {
    if (!this.e) {}
    byte[] arrayOfByte;
    do
    {
      return;
      arrayOfByte = this.b.a();
    } while (arrayOfByte == null);
    new c();
    c.a(arrayOfByte, new c.b()
    {
      public final void a()
      {
        b.a(b.this).b();
        b.c();
      }
      
      public final void b()
      {
        b.c();
      }
    });
  }
  
  static final class a
  {
    private static b a = new b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */