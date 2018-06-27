package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.h.b;
import com.xiaomi.network.HttpUtils;
import com.xiaomi.push.protobuf.a.a;
import java.util.List;

class au
  extends h.b
{
  boolean a = false;
  
  au(at paramat) {}
  
  public void b()
  {
    try
    {
      a.a locala = a.a.b(Base64.decode(HttpUtils.a(j.a(), "http://resolver.msg.xiaomi.net/psc/?t=a", null), 10));
      if (locala != null)
      {
        at.a(this.b, locala);
        this.a = true;
        at.a(this.b);
      }
      return;
    }
    catch (Exception localException)
    {
      b.a("fetch config failure: " + localException.getMessage());
    }
  }
  
  public void c()
  {
    at.a(this.b, null);
    if (this.a) {
      synchronized (this.b)
      {
        at.a[] arrayOfa = (at.a[])at.b(this.b).toArray(new at.a[at.b(this.b).size()]);
        int j = arrayOfa.length;
        int i = 0;
        if (i < j)
        {
          arrayOfa[i].a(at.c(this.b));
          i += 1;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */