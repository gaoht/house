package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostFilter;
import com.xiaomi.network.HostManager;
import com.xiaomi.network.HostManager.HostManagerFactory;
import com.xiaomi.network.HostManager.HttpGet;
import com.xiaomi.network.HostManagerV2;
import com.xiaomi.push.protobuf.a.a;
import com.xiaomi.push.protobuf.b.b;
import com.xiaomi.stats.f;
import com.xiaomi.stats.h;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class an
  extends at.a
  implements HostManager.HostManagerFactory
{
  private XMPushService a;
  private long b;
  
  an(XMPushService paramXMPushService)
  {
    this.a = paramXMPushService;
  }
  
  public static void a(XMPushService paramXMPushService)
  {
    an localan = new an(paramXMPushService);
    at.a().a(localan);
    try
    {
      HostManager.setHostManagerFactory(localan);
      HostManager.init(paramXMPushService, null, new a(), "0", "push", "2.2");
      return;
    }
    finally {}
  }
  
  public HostManager a(Context paramContext, HostFilter paramHostFilter, HostManager.HttpGet paramHttpGet, String paramString)
  {
    return new b(paramContext, paramHostFilter, paramHttpGet, paramString);
  }
  
  public void a(a.a parama) {}
  
  public void a(b.b paramb)
  {
    Object localObject;
    if ((paramb.e()) && (paramb.d()) && (System.currentTimeMillis() - this.b > 3600000L))
    {
      com.xiaomi.channel.commonutils.logger.b.a("fetch bucket :" + paramb.d());
      this.b = System.currentTimeMillis();
      localObject = HostManager.getInstance();
      ((HostManager)localObject).clear();
      ((HostManager)localObject).refreshFallbacks();
      paramb = this.a.h();
      if (paramb != null)
      {
        localObject = ((HostManager)localObject).getFallbacksByHost(paramb.c().e());
        if (localObject != null)
        {
          localObject = ((Fallback)localObject).d();
          Iterator localIterator = ((ArrayList)localObject).iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!((String)localIterator.next()).equals(paramb.d()));
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (!((ArrayList)localObject).isEmpty()))
      {
        com.xiaomi.channel.commonutils.logger.b.a("bucket changed, force reconnect");
        this.a.a(0, null);
        this.a.a(false);
      }
      return;
    }
  }
  
  static class a
    implements HostManager.HttpGet
  {
    public String a(String paramString)
    {
      paramString = Uri.parse(paramString).buildUpon();
      paramString.appendQueryParameter("sdkver", String.valueOf(26));
      paramString.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
      paramString.appendQueryParameter("os", com.xiaomi.smack.util.d.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
      paramString.appendQueryParameter("mi", String.valueOf(j.c()));
      paramString = paramString.toString();
      com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + paramString);
      paramString = new URL(paramString);
      if (paramString.getPort() == -1) {}
      for (i = 80;; i = paramString.getPort()) {
        try
        {
          long l1 = System.currentTimeMillis();
          String str = com.xiaomi.channel.commonutils.network.d.a(j.a(), paramString);
          long l2 = System.currentTimeMillis();
          h.a(paramString.getHost() + ":" + i, (int)(l2 - l1), null);
          return str;
        }
        catch (IOException localIOException)
        {
          h.a(paramString.getHost() + ":" + i, -1, localIOException);
          throw localIOException;
        }
      }
    }
  }
  
  static class b
    extends HostManagerV2
  {
    protected b(Context paramContext, HostFilter paramHostFilter, HostManager.HttpGet paramHttpGet, String paramString)
    {
      super(paramHostFilter, paramHttpGet, paramString);
    }
    
    protected String getRemoteFallbackJSON(ArrayList<String> paramArrayList, String paramString1, String paramString2)
    {
      try
      {
        if (f.a().c()) {
          paramString2 = at.e();
        }
        paramArrayList = super.getRemoteFallbackJSON(paramArrayList, paramString1, paramString2);
        return paramArrayList;
      }
      catch (IOException paramArrayList)
      {
        if (!com.xiaomi.channel.commonutils.network.d.d(this.sAppContext)) {}
      }
      for (int i = 1;; i = 0)
      {
        h.a(0, com.xiaomi.push.thrift.a.r.a(), 1, null, i);
        throw paramArrayList;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */