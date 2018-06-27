package com.unionpay.sdk;

final class o
{
  static String a()
  {
    if (d.c == null) {
      return null;
    }
    return l.b(d.c, "UPpref_longtime", "UPaes_key", null);
  }
  
  static void a(long paramLong)
  {
    if (d.c == null) {
      return;
    }
    l.a(d.c, "UPpref_shorttime", "UPpref.end.key", paramLong);
  }
  
  static void a(String paramString)
  {
    if (d.c == null) {
      return;
    }
    l.a(d.c, "UPpref_shorttime", "UPpref.lastactivity.key", paramString);
  }
  
  static String b()
  {
    if (d.c == null) {
      return null;
    }
    return l.b(d.c, "UPpref_longtime", "UPpref.session.key", null);
  }
  
  static void b(String paramString)
  {
    if (d.c == null) {
      return;
    }
    l.a(d.c, "UPpref_longtime", "UPisAppQuiting", paramString);
  }
  
  static long c()
  {
    if (d.c == null) {
      return 0L;
    }
    return l.b(d.c, "UPpref_longtime", "UPpref.start.key", 0L);
  }
  
  static long d()
  {
    if (d.c == null) {
      return 0L;
    }
    return l.b(d.c, "UPpref_longtime", "UPpref.init.key", 0L);
  }
  
  static long e()
  {
    if (d.c == null) {
      return 0L;
    }
    return l.b(d.c, "UPpref_shorttime", "UPpref.end.key", 0L);
  }
  
  static String f()
  {
    if (d.c == null) {
      return null;
    }
    return l.b(d.c, "UPpref_longtime", "UPisAppQuiting", null);
  }
  
  static int g()
  {
    try
    {
      if (j() != -1L) {
        return Integer.parseInt(String.valueOf(j()));
      }
      int i = a.a().b(d.c);
      return i;
    }
    catch (Throwable localThrowable)
    {
      if (ag.a) {
        localThrowable.printStackTrace();
      }
    }
    return -1;
  }
  
  static String h()
  {
    try
    {
      if (i() != null) {
        return i();
      }
      String str = a.a().c(d.c);
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (ag.a) {
        localThrowable.printStackTrace();
      }
    }
    return "unknown";
  }
  
  private static String i()
  {
    if (d.c == null) {
      return null;
    }
    return l.b(d.c, "UPpref_longtime", "UPadditionalVersionName", null);
  }
  
  private static long j()
  {
    if (d.c == null) {
      return -1L;
    }
    return l.b(d.c, "UPpref_longtime", "UPadditionalVersionCode", -1L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */