package com.xiaomi.smack;

import com.xiaomi.channel.commonutils.misc.c;
import java.util.Map;

public class b
  implements Cloneable
{
  public static String b = "wcc-ml-test10.bj";
  public static final String c = c.b;
  public static String d = null;
  private String a;
  private String e;
  private int f;
  private boolean g = a.a;
  private boolean h = true;
  private String i;
  private e j;
  
  public b(Map<String, Integer> paramMap, int paramInt, String paramString, e parame)
  {
    a(paramMap, paramInt, paramString, parame);
  }
  
  private void a(Map<String, Integer> paramMap, int paramInt, String paramString, e parame)
  {
    this.e = b();
    this.f = paramInt;
    this.a = paramString;
    this.j = parame;
  }
  
  public static final String b()
  {
    if (d != null) {
      return d;
    }
    if (com.xiaomi.channel.commonutils.misc.a.a()) {
      return "sandbox.xmpush.xiaomi.com";
    }
    if (com.xiaomi.channel.commonutils.misc.a.b()) {
      return c;
    }
    return "app.chat.xiaomi.net";
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public byte[] a()
  {
    return null;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public String c()
  {
    return this.i;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.g;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */