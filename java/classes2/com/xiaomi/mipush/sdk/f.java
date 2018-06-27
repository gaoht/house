package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.service.e;
import com.xiaomi.push.service.h;
import com.xiaomi.xmpush.thrift.a;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.aq;
import com.xiaomi.xmpush.thrift.j;
import com.xiaomi.xmpush.thrift.o;
import com.xiaomi.xmpush.thrift.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class f
{
  private static volatile f a;
  private final String b = "GeoFenceRegMessageProcessor.";
  private Context c;
  
  private f(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static f a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new f(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  private s a()
  {
    Object localObject = e.a(this.c).a();
    s locals = new s();
    TreeSet localTreeSet = new TreeSet();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localTreeSet.add((j)((Iterator)localObject).next());
    }
    locals.a(localTreeSet);
    return locals;
  }
  
  private void a(j paramj)
  {
    byte[] arrayOfByte = aq.a(paramj);
    ae localae = new ae("-1", false);
    localae.c(o.J.N);
    localae.a(arrayOfByte);
    u.a(this.c).a(localae, a.i, true, null);
    com.xiaomi.channel.commonutils.logger.b.a("GeoFenceRegMessageProcessor.report package not exist geo_fencing id:" + paramj.a());
  }
  
  private void a(j paramj, boolean paramBoolean)
  {
    byte[] arrayOfByte = aq.a(paramj);
    ae localae = new ae("-1", false);
    Object localObject;
    if (paramBoolean)
    {
      localObject = o.E.N;
      localae.c((String)localObject);
      localae.a(arrayOfByte);
      u.a(this.c).a(localae, a.i, true, null);
      localObject = new StringBuilder().append("GeoFenceRegMessageProcessor.report geo_fencing id:").append(paramj.a()).append(" ");
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (paramj = "geo_reg";; paramj = "geo_unreg")
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramj);
      return;
      localObject = o.G.N;
      break;
    }
  }
  
  private j d(ae paramae)
  {
    if (!h.a(this.c)) {}
    while (!h.b(this.c)) {
      return null;
    }
    try
    {
      j localj = new j();
      aq.a(localj, paramae.m());
      return localj;
    }
    catch (org.apache.thrift.f paramae)
    {
      paramae.printStackTrace();
    }
    return null;
  }
  
  public void a(ae paramae)
  {
    j localj = d(paramae);
    if (localj == null)
    {
      com.xiaomi.channel.commonutils.logger.b.d("registration convert geofence object failed notification_id:" + paramae.c());
      return;
    }
    if (!com.xiaomi.channel.commonutils.android.b.f(this.c, localj.g()))
    {
      a(localj);
      return;
    }
    if (e.a(this.c).a(localj) == -1L) {
      com.xiaomi.channel.commonutils.logger.b.a("GeoFenceRegMessageProcessor. insert a new geofence failed about geo_id:" + localj.a());
    }
    new g(this.c).a(localj);
    a(localj, true);
    com.xiaomi.channel.commonutils.logger.b.a("receive geo reg notification");
  }
  
  public void b(ae paramae)
  {
    j localj = d(paramae);
    if (localj == null)
    {
      com.xiaomi.channel.commonutils.logger.b.d("unregistration convert geofence object failed notification_id:" + paramae.c());
      return;
    }
    if (!com.xiaomi.channel.commonutils.android.b.f(this.c, localj.g()))
    {
      a(localj);
      return;
    }
    if (e.a(this.c).d(localj.a()) == 0) {
      com.xiaomi.channel.commonutils.logger.b.a("GeoFenceRegMessageProcessor. delete a geofence about geo_id:" + localj.a() + " falied");
    }
    if (com.xiaomi.push.service.g.a(this.c).b(localj.a()) == 0) {
      com.xiaomi.channel.commonutils.logger.b.a("GeoFenceRegMessageProcessor. delete all geofence messages about geo_id:" + localj.a() + " failed");
    }
    new g(this.c).a(localj.a());
    a(localj, false);
    com.xiaomi.channel.commonutils.logger.b.a("receive geo unreg notification");
  }
  
  public void c(ae paramae)
  {
    if (!h.a(this.c)) {}
    while ((!h.b(this.c)) || (!com.xiaomi.channel.commonutils.android.b.f(this.c, paramae.i))) {
      return;
    }
    paramae = a();
    byte[] arrayOfByte = aq.a(paramae);
    ae localae = new ae("-1", false);
    localae.c(o.I.N);
    localae.a(arrayOfByte);
    u.a(this.c).a(localae, a.i, true, null);
    com.xiaomi.channel.commonutils.logger.b.c("GeoFenceRegMessageProcessor.sync_geo_data. geos size:" + paramae.a().size());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */