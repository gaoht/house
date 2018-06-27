package com.baidu.trace;

import com.baidu.lbsapi.auth.tracesdk.LBSAuthManager;
import com.baidu.trace.c.f;
import java.util.Hashtable;

public final class d
{
  protected static String a;
  protected static LBSAuthManager b = null;
  
  protected static void a()
  {
    if (b == null) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    localHashtable.put("from", "trace");
    localHashtable.put("mb", f.a);
    localHashtable.put("os", "android");
    localHashtable.put("sv", "3.0.7");
    localHashtable.put("imt", b.getIMEI());
    localHashtable.put("net", com.baidu.trace.c.e.a);
    localHashtable.put("cpu", f.b);
    localHashtable.put("resid", "02");
    localHashtable.put("appid", "-1");
    localHashtable.put("ver", "1");
    localHashtable.put("pcn", com.baidu.trace.c.e.c);
    localHashtable.put("cuid", b.getCUID());
    localHashtable.put("name", com.baidu.trace.c.e.b);
    b.authenticate(true, "lbs_tracesdk", localHashtable, new e());
  }
  
  protected static void b()
  {
    b = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */