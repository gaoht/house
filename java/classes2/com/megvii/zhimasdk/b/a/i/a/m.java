package com.megvii.zhimasdk.b.a.i.a;

import com.megvii.zhimasdk.b.a.a.o;
import com.megvii.zhimasdk.b.a.c;
import com.megvii.zhimasdk.b.a.k.r;
import com.megvii.zhimasdk.b.a.k.u;
import com.megvii.zhimasdk.b.a.l.e;
import com.megvii.zhimasdk.b.a.o.d;
import com.megvii.zhimasdk.b.a.q;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class m
  extends a
{
  private final Map<String, String> a = new HashMap();
  private final Charset b;
  
  public m(Charset paramCharset)
  {
    if (paramCharset != null) {}
    for (;;)
    {
      this.b = paramCharset;
      return;
      paramCharset = c.b;
    }
  }
  
  String a(q paramq)
  {
    String str = (String)paramq.g().a("http.auth.credential-charset");
    paramq = str;
    if (str == null) {
      paramq = g().name();
    }
    return paramq;
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (String)this.a.get(paramString.toLowerCase(Locale.ENGLISH));
  }
  
  protected void a(d paramd, int paramInt1, int paramInt2)
  {
    paramd = com.megvii.zhimasdk.b.a.k.f.b.a(paramd, new u(paramInt1, paramd.c()));
    if (paramd.length == 0) {
      throw new o("Authentication challenge is empty");
    }
    this.a.clear();
    paramInt2 = paramd.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Object localObject = paramd[paramInt1];
      this.a.put(((com.megvii.zhimasdk.b.a.f)localObject).a().toLowerCase(Locale.ENGLISH), ((com.megvii.zhimasdk.b.a.f)localObject).b());
      paramInt1 += 1;
    }
  }
  
  public String b()
  {
    return a("realm");
  }
  
  public Charset g()
  {
    return this.b;
  }
  
  protected Map<String, String> h()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */