package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smack.packet.c;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.packet.f;
import java.util.Collection;
import java.util.Iterator;

public class b
{
  private s a = new s();
  
  public static String a(String paramString)
  {
    return paramString + ".permission.MIPUSH_RECEIVE";
  }
  
  private static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    if ("com.xiaomi.xmsf".equals(paramContext.getPackageName()))
    {
      paramContext.sendBroadcast(paramIntent);
      return;
    }
    paramContext.sendBroadcast(paramIntent, a(paramString));
  }
  
  ak.b a(com.xiaomi.slim.b paramb)
  {
    Object localObject = ak.a().c(Integer.toString(paramb.c()));
    if (((Collection)localObject).isEmpty()) {
      return null;
    }
    Iterator localIterator = ((Collection)localObject).iterator();
    if (((Collection)localObject).size() == 1) {
      return (ak.b)localIterator.next();
    }
    paramb = paramb.j();
    while (localIterator.hasNext())
    {
      localObject = (ak.b)localIterator.next();
      if (TextUtils.equals(paramb, ((ak.b)localObject).b)) {
        return (ak.b)localObject;
      }
    }
    return null;
  }
  
  ak.b a(d paramd)
  {
    Object localObject = ak.a().c(paramd.l());
    if (((Collection)localObject).isEmpty())
    {
      paramd = null;
      return paramd;
    }
    Iterator localIterator = ((Collection)localObject).iterator();
    if (((Collection)localObject).size() == 1) {
      return (ak.b)localIterator.next();
    }
    String str1 = paramd.n();
    String str2 = paramd.m();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (ak.b)localIterator.next();
        paramd = (d)localObject;
        if (TextUtils.equals(str1, ((ak.b)localObject).b)) {
          break;
        }
        if (TextUtils.equals(str2, ((ak.b)localObject).b)) {
          return (ak.b)localObject;
        }
      }
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.push.service_started");
    paramContext.sendBroadcast(localIntent);
  }
  
  public void a(Context paramContext, ak.b paramb, int paramInt)
  {
    if ("5".equalsIgnoreCase(paramb.h)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.push.channel_closed");
    localIntent.setPackage(paramb.a);
    localIntent.putExtra(am.q, paramb.h);
    localIntent.putExtra("ext_reason", paramInt);
    localIntent.putExtra(am.p, paramb.b);
    localIntent.putExtra(am.B, paramb.j);
    a(paramContext, localIntent, paramb.a);
  }
  
  public void a(Context paramContext, ak.b paramb, String paramString1, String paramString2)
  {
    if ("5".equalsIgnoreCase(paramb.h))
    {
      com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.push.kicked");
    localIntent.setPackage(paramb.a);
    localIntent.putExtra("ext_kick_type", paramString1);
    localIntent.putExtra("ext_kick_reason", paramString2);
    localIntent.putExtra("ext_chid", paramb.h);
    localIntent.putExtra(am.p, paramb.b);
    localIntent.putExtra(am.B, paramb.j);
    a(paramContext, localIntent, paramb.a);
  }
  
  public void a(Context paramContext, ak.b paramb, boolean paramBoolean, int paramInt, String paramString)
  {
    if ("5".equalsIgnoreCase(paramb.h))
    {
      this.a.a(paramContext, paramb, paramBoolean, paramInt, paramString);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.push.channel_opened");
    localIntent.setPackage(paramb.a);
    localIntent.putExtra("ext_succeeded", paramBoolean);
    if (!paramBoolean) {
      localIntent.putExtra("ext_reason", paramInt);
    }
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("ext_reason_msg", paramString);
    }
    localIntent.putExtra("ext_chid", paramb.h);
    localIntent.putExtra(am.p, paramb.b);
    localIntent.putExtra(am.B, paramb.j);
    a(paramContext, localIntent, paramb.a);
  }
  
  public void a(XMPushService paramXMPushService, String paramString, com.xiaomi.slim.b paramb)
  {
    ak.b localb = a(paramb);
    if (localb == null)
    {
      com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + paramString + " not registered");
      return;
    }
    if ("5".equalsIgnoreCase(paramString))
    {
      this.a.a(paramXMPushService, paramb, localb);
      return;
    }
    com.xiaomi.channel.commonutils.logger.b.a("don't support binary yet");
  }
  
  public void a(XMPushService paramXMPushService, String paramString, d paramd)
  {
    ak.b localb = a(paramd);
    if (localb == null)
    {
      com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + paramString + " not registered");
      return;
    }
    if ("5".equalsIgnoreCase(paramString))
    {
      this.a.a(paramXMPushService, paramd, localb);
      return;
    }
    String str2 = localb.a;
    String str1;
    if ((paramd instanceof c)) {
      str1 = "com.xiaomi.push.new_msg";
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(str1);
      localIntent.setPackage(str2);
      localIntent.putExtra("ext_chid", paramString);
      localIntent.putExtra("ext_packet", paramd.b());
      localIntent.putExtra(am.B, localb.j);
      localIntent.putExtra(am.u, localb.i);
      a(paramXMPushService, localIntent, str2);
      return;
      if ((paramd instanceof com.xiaomi.smack.packet.b))
      {
        str1 = "com.xiaomi.push.new_iq";
      }
      else
      {
        if (!(paramd instanceof f)) {
          break;
        }
        str1 = "com.xiaomi.push.new_pres";
      }
    }
    com.xiaomi.channel.commonutils.logger.b.d("unknown packet type, drop it");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */