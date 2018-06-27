package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;
import com.xiaomi.push.service.am;
import com.xiaomi.xmpush.thrift.aa;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.ad;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.ag;
import com.xiaomi.xmpush.thrift.aj;
import com.xiaomi.xmpush.thrift.al;
import com.xiaomi.xmpush.thrift.an;
import com.xiaomi.xmpush.thrift.ap;
import com.xiaomi.xmpush.thrift.aq;
import com.xiaomi.xmpush.thrift.o;
import com.xiaomi.xmpush.thrift.r;
import com.xiaomi.xmpush.thrift.t;
import com.xiaomi.xmpush.thrift.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

public class s
{
  private static s a = null;
  private static Queue<String> c;
  private static Object d = new Object();
  private Context b;
  
  private s(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    if (this.b == null) {
      this.b = paramContext;
    }
  }
  
  /* Error */
  public static Intent a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +14 -> 15
    //   4: aload_2
    //   5: ldc 43
    //   7: invokeinterface 49 2 0
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: aload_2
    //   18: ldc 43
    //   20: invokeinterface 53 2 0
    //   25: checkcast 55	java/lang/String
    //   28: astore_3
    //   29: getstatic 60	com/xiaomi/push/service/am:a	Ljava/lang/String;
    //   32: aload_3
    //   33: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +71 -> 107
    //   39: aload_0
    //   40: invokevirtual 67	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   43: aload_1
    //   44: invokevirtual 73	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull -34 -> 15
    //   52: aload_1
    //   53: ldc 74
    //   55: invokevirtual 80	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   58: pop
    //   59: aload_0
    //   60: invokevirtual 67	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   63: aload_1
    //   64: ldc 81
    //   66: invokevirtual 85	android/content/pm/PackageManager:resolveActivity	(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull -56 -> 15
    //   74: aload_1
    //   75: areturn
    //   76: astore_1
    //   77: new 87	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   84: ldc 90
    //   86: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 98	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   93: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 106	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   102: aconst_null
    //   103: astore_1
    //   104: goto -56 -> 48
    //   107: getstatic 108	com/xiaomi/push/service/am:b	Ljava/lang/String;
    //   110: aload_3
    //   111: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: ifeq +189 -> 303
    //   117: aload_2
    //   118: ldc 110
    //   120: invokeinterface 49 2 0
    //   125: ifeq +67 -> 192
    //   128: aload_2
    //   129: ldc 110
    //   131: invokeinterface 53 2 0
    //   136: checkcast 55	java/lang/String
    //   139: astore_2
    //   140: aload_2
    //   141: ifnull +371 -> 512
    //   144: aload_2
    //   145: iconst_1
    //   146: invokestatic 114	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   149: astore_2
    //   150: aload_2
    //   151: aload_1
    //   152: invokevirtual 117	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: aload_2
    //   157: astore_1
    //   158: goto -110 -> 48
    //   161: astore_3
    //   162: aload_2
    //   163: astore_1
    //   164: new 87	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   171: ldc 90
    //   173: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_3
    //   177: invokevirtual 118	java/net/URISyntaxException:getMessage	()Ljava/lang/String;
    //   180: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 106	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   189: goto -141 -> 48
    //   192: aload_2
    //   193: ldc 120
    //   195: invokeinterface 49 2 0
    //   200: ifeq +307 -> 507
    //   203: aload_2
    //   204: ldc 120
    //   206: invokeinterface 53 2 0
    //   211: checkcast 55	java/lang/String
    //   214: astore 4
    //   216: new 76	android/content/Intent
    //   219: dup
    //   220: invokespecial 121	android/content/Intent:<init>	()V
    //   223: astore_3
    //   224: aload_3
    //   225: new 123	android/content/ComponentName
    //   228: dup
    //   229: aload_1
    //   230: aload 4
    //   232: invokespecial 126	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: invokevirtual 130	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   238: pop
    //   239: aload_2
    //   240: ldc -124
    //   242: invokeinterface 49 2 0
    //   247: ifeq +22 -> 269
    //   250: aload_3
    //   251: aload_2
    //   252: ldc -124
    //   254: invokeinterface 53 2 0
    //   259: checkcast 55	java/lang/String
    //   262: invokestatic 138	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   265: invokevirtual 141	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   268: pop
    //   269: aload_3
    //   270: astore_1
    //   271: goto -223 -> 48
    //   274: astore_1
    //   275: new 87	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   282: ldc -113
    //   284: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_1
    //   288: invokevirtual 144	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 106	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   300: goto -31 -> 269
    //   303: getstatic 146	com/xiaomi/push/service/am:c	Ljava/lang/String;
    //   306: aload_3
    //   307: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   310: ifeq +197 -> 507
    //   313: aload_2
    //   314: ldc -108
    //   316: invokeinterface 53 2 0
    //   321: checkcast 55	java/lang/String
    //   324: astore_1
    //   325: aload_1
    //   326: ifnull +181 -> 507
    //   329: aload_1
    //   330: invokevirtual 151	java/lang/String:trim	()Ljava/lang/String;
    //   333: astore_1
    //   334: aload_1
    //   335: ldc -103
    //   337: invokevirtual 157	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   340: ifne +164 -> 504
    //   343: aload_1
    //   344: ldc -97
    //   346: invokevirtual 157	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   349: ifne +155 -> 504
    //   352: new 87	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   359: ldc -103
    //   361: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload_1
    //   365: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: astore_1
    //   372: new 161	java/net/URL
    //   375: dup
    //   376: aload_1
    //   377: invokespecial 163	java/net/URL:<init>	(Ljava/lang/String;)V
    //   380: invokevirtual 166	java/net/URL:getProtocol	()Ljava/lang/String;
    //   383: astore_2
    //   384: ldc -88
    //   386: aload_2
    //   387: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   390: ifne +12 -> 402
    //   393: ldc -86
    //   395: aload_2
    //   396: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   399: ifeq +100 -> 499
    //   402: new 76	android/content/Intent
    //   405: dup
    //   406: ldc -84
    //   408: invokespecial 173	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   411: astore_2
    //   412: aload_2
    //   413: aload_1
    //   414: invokestatic 179	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   417: invokevirtual 183	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   420: pop
    //   421: aload_2
    //   422: astore_1
    //   423: goto -375 -> 48
    //   426: astore_3
    //   427: aload_2
    //   428: astore_1
    //   429: aload_3
    //   430: astore_2
    //   431: new 87	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   438: ldc 90
    //   440: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload_2
    //   444: invokevirtual 184	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   447: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 106	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   456: goto -408 -> 48
    //   459: astore_0
    //   460: new 87	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   467: ldc 90
    //   469: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_0
    //   473: invokevirtual 98	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   476: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 106	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   485: aconst_null
    //   486: areturn
    //   487: astore_2
    //   488: aconst_null
    //   489: astore_1
    //   490: goto -59 -> 431
    //   493: astore_3
    //   494: aconst_null
    //   495: astore_1
    //   496: goto -332 -> 164
    //   499: aconst_null
    //   500: astore_1
    //   501: goto -453 -> 48
    //   504: goto -132 -> 372
    //   507: aconst_null
    //   508: astore_1
    //   509: goto -461 -> 48
    //   512: aconst_null
    //   513: astore_1
    //   514: goto -466 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	paramContext	Context
    //   0	517	1	paramString	String
    //   0	517	2	paramMap	Map<String, String>
    //   28	83	3	str1	String
    //   161	16	3	localURISyntaxException1	java.net.URISyntaxException
    //   223	84	3	localIntent	Intent
    //   426	4	3	localMalformedURLException	java.net.MalformedURLException
    //   493	1	3	localURISyntaxException2	java.net.URISyntaxException
    //   214	17	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   39	48	76	java/lang/Exception
    //   150	156	161	java/net/URISyntaxException
    //   239	269	274	java/lang/NumberFormatException
    //   412	421	426	java/net/MalformedURLException
    //   59	70	459	java/lang/Exception
    //   372	402	487	java/net/MalformedURLException
    //   402	412	487	java/net/MalformedURLException
    //   144	150	493	java/net/URISyntaxException
  }
  
  private PushMessageHandler.a a(ab paramab, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    MiPushMessage localMiPushMessage = null;
    Object localObject3;
    Object localObject1;
    try
    {
      localObject3 = q.a(this.b, paramab);
      if (localObject3 == null)
      {
        b.d("receiving an un-recognized message. " + paramab.a);
        return null;
      }
      b.c("receive a message." + localObject3);
      localObject1 = paramab.a();
      b.a("processing a message, action=" + localObject1);
      switch (t.a[localObject1.ordinal()])
      {
      default: 
        return null;
      }
    }
    catch (c paramArrayOfByte)
    {
      b.a(paramArrayOfByte);
      a(paramab);
      return null;
    }
    catch (org.apache.thrift.f paramab)
    {
      b.a(paramab);
      b.d("receive a message which action string is not valid. is the reg expired?");
      return null;
    }
    if ((a.a(this.b).l()) && (!paramBoolean))
    {
      b.a("receive a message in pause state. drop it");
      return null;
      paramArrayOfByte = (ag)localObject3;
      if (paramArrayOfByte.f == 0L) {
        a.a(this.b).b(paramArrayOfByte.h, paramArrayOfByte.i);
      }
      if (TextUtils.isEmpty(paramArrayOfByte.h)) {
        break label2520;
      }
      paramab = new ArrayList();
      paramab.add(paramArrayOfByte.h);
    }
    for (;;)
    {
      paramab = PushMessageHelper.generateCommandMessage("register", paramab, paramArrayOfByte.f, paramArrayOfByte.g, null);
      u.a(this.b).e();
      return paramab;
      if (((an)localObject3).f == 0L)
      {
        a.a(this.b).h();
        MiPushClient.clearExtras(this.b);
      }
      PushMessageHandler.a();
      return null;
      localObject3 = (aj)localObject3;
      com.xiaomi.xmpush.thrift.q localq = ((aj)localObject3).l();
      if (localq == null)
      {
        b.d("receive an empty message without push content, drop it");
        return null;
      }
      if (paramBoolean)
      {
        if (com.xiaomi.push.service.ac.b(paramab)) {
          MiPushClient.reportIgnoreRegMessageClicked(this.b, localq.b(), paramab.m(), paramab.f, localq.d());
        }
      }
      else
      {
        if (!paramBoolean)
        {
          if ((TextUtils.isEmpty(((aj)localObject3).j())) || (MiPushClient.aliasSetTime(this.b, ((aj)localObject3).j()) >= 0L)) {
            break label580;
          }
          MiPushClient.addAlias(this.b, ((aj)localObject3).j());
        }
        label435:
        if ((paramab.h == null) || (paramab.h.s() == null)) {
          break label2514;
        }
      }
      label580:
      label2514:
      for (localObject1 = (String)paramab.h.j.get("jobkey");; localObject1 = null)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject1 = localq.b();
        }
        for (;;)
        {
          if ((!paramBoolean) && (a(this.b, (String)localObject1))) {
            b.a("drop a duplicate message, key=" + (String)localObject1);
          }
          for (paramArrayOfByte = localMiPushMessage;; paramArrayOfByte = localMiPushMessage)
          {
            localObject1 = paramArrayOfByte;
            if (paramab.m() != null) {
              break label2525;
            }
            localObject1 = paramArrayOfByte;
            if (paramBoolean) {
              break label2525;
            }
            a((aj)localObject3, paramab);
            return paramArrayOfByte;
            MiPushClient.reportMessageClicked(this.b, localq.b(), paramab.m(), localq.d());
            break;
            if ((TextUtils.isEmpty(((aj)localObject3).h())) || (MiPushClient.topicSubscribedTime(this.b, ((aj)localObject3).h()) >= 0L)) {
              break label435;
            }
            MiPushClient.addTopic(this.b, ((aj)localObject3).h());
            break label435;
            localMiPushMessage = PushMessageHelper.generateMessage((aj)localObject3, paramab.m(), paramBoolean);
            if ((localMiPushMessage.getPassThrough() == 0) && (!paramBoolean) && (com.xiaomi.push.service.ac.a(localMiPushMessage.getExtra())))
            {
              com.xiaomi.push.service.ac.a(this.b, paramab, paramArrayOfByte);
              return null;
            }
            b.a("receive a message, msgid=" + localq.b() + ", jobkey=" + (String)localObject1);
            if ((paramBoolean) && (localMiPushMessage.getExtra() != null) && (localMiPushMessage.getExtra().containsKey("notify_effect")))
            {
              localObject1 = localMiPushMessage.getExtra();
              paramArrayOfByte = (String)((Map)localObject1).get("notify_effect");
              if (com.xiaomi.push.service.ac.b(paramab))
              {
                paramab = a(this.b, paramab.f, (Map)localObject1);
                if (paramab == null)
                {
                  b.a("Getting Intent fail from ignore reg message. ");
                  return null;
                }
                paramArrayOfByte = localq.f();
                if (!TextUtils.isEmpty(paramArrayOfByte)) {
                  paramab.putExtra("payload", paramArrayOfByte);
                }
                this.b.startActivity(paramab);
                return null;
              }
              paramab = a(this.b, this.b.getPackageName(), (Map)localObject1);
              localObject1 = localObject2;
              if (paramab == null) {
                break label2525;
              }
              if (!paramArrayOfByte.equals(am.c)) {
                paramab.putExtra("key_message", localMiPushMessage);
              }
              this.b.startActivity(paramab);
              return null;
              paramArrayOfByte = (al)localObject3;
              if (paramArrayOfByte.f == 0L) {
                MiPushClient.addTopic(this.b, paramArrayOfByte.h());
              }
              if (!TextUtils.isEmpty(paramArrayOfByte.h()))
              {
                paramab = new ArrayList();
                paramab.add(paramArrayOfByte.h());
              }
              for (;;)
              {
                return PushMessageHelper.generateCommandMessage("subscribe-topic", paramab, paramArrayOfByte.f, paramArrayOfByte.g, paramArrayOfByte.k());
                paramArrayOfByte = (ap)localObject3;
                if (paramArrayOfByte.f == 0L) {
                  MiPushClient.removeTopic(this.b, paramArrayOfByte.h());
                }
                if (!TextUtils.isEmpty(paramArrayOfByte.h()))
                {
                  paramab = new ArrayList();
                  paramab.add(paramArrayOfByte.h());
                }
                for (;;)
                {
                  return PushMessageHelper.generateCommandMessage("unsubscibe-topic", paramab, paramArrayOfByte.f, paramArrayOfByte.g, paramArrayOfByte.k());
                  paramArrayOfByte = (aa)localObject3;
                  localObject1 = paramArrayOfByte.e();
                  paramab = paramArrayOfByte.k();
                  if (paramArrayOfByte.g == 0L) {
                    if ((TextUtils.equals((CharSequence)localObject1, "accept-time")) && (paramab != null) && (paramab.size() > 1))
                    {
                      MiPushClient.addAcceptTime(this.b, (String)paramab.get(0), (String)paramab.get(1));
                      if (("00:00".equals(paramab.get(0))) && ("00:00".equals(paramab.get(1))))
                      {
                        a.a(this.b).a(true);
                        paramab = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), paramab);
                      }
                    }
                  }
                  for (;;)
                  {
                    return PushMessageHelper.generateCommandMessage((String)localObject1, paramab, paramArrayOfByte.g, paramArrayOfByte.h, paramArrayOfByte.m());
                    a.a(this.b).a(false);
                    break;
                    if ((TextUtils.equals((CharSequence)localObject1, "set-alias")) && (paramab != null) && (paramab.size() > 0)) {
                      MiPushClient.addAlias(this.b, (String)paramab.get(0));
                    } else if ((TextUtils.equals((CharSequence)localObject1, "unset-alias")) && (paramab != null) && (paramab.size() > 0)) {
                      MiPushClient.removeAlias(this.b, (String)paramab.get(0));
                    } else if ((TextUtils.equals((CharSequence)localObject1, "set-account")) && (paramab != null) && (paramab.size() > 0)) {
                      MiPushClient.addAccount(this.b, (String)paramab.get(0));
                    } else if ((TextUtils.equals((CharSequence)localObject1, "unset-account")) && (paramab != null) && (paramab.size() > 0)) {
                      MiPushClient.removeAccount(this.b, (String)paramab.get(0));
                    }
                  }
                  if ((localObject3 instanceof com.xiaomi.xmpush.thrift.x))
                  {
                    paramab = (com.xiaomi.xmpush.thrift.x)localObject3;
                    paramArrayOfByte = paramab.c();
                    if (o.L.N.equalsIgnoreCase(paramab.e))
                    {
                      if (paramab.g == 0L) {
                        try
                        {
                          if (p.a(this.b).e(paramArrayOfByte))
                          {
                            p.a(this.b).d(paramArrayOfByte);
                            if ("disable_syncing".equals(p.a(this.b).a()))
                            {
                              p.a(this.b).f("disable_synced");
                              MiPushClient.clearNotification(this.b);
                              MiPushClient.clearLocalNotificationType(this.b);
                              PushMessageHandler.a();
                              u.a(this.b).b();
                            }
                          }
                          return null;
                        }
                        finally {}
                      }
                      if ("disable_syncing".equals(p.a(this.b).a())) {
                        for (;;)
                        {
                          try
                          {
                            if (p.a(this.b).e(paramArrayOfByte))
                            {
                              if (p.a(this.b).c(paramArrayOfByte) < 10)
                              {
                                p.a(this.b).b(paramArrayOfByte);
                                u.a(this.b).a(true, paramArrayOfByte);
                              }
                            }
                            else {
                              return null;
                            }
                          }
                          finally {}
                          p.a(this.b).d(paramArrayOfByte);
                        }
                      }
                      p.a(this.b).d(paramArrayOfByte);
                      return null;
                    }
                    localObject1 = localObject2;
                    if (!o.M.N.equalsIgnoreCase(paramab.e)) {
                      break;
                    }
                    if (paramab.g == 0L) {
                      try
                      {
                        if (p.a(this.b).e(paramArrayOfByte))
                        {
                          p.a(this.b).d(paramArrayOfByte);
                          if ("enable_syncing".equals(p.a(this.b).a()))
                          {
                            p.a(this.b).f("enable_synced");
                            p.a(this.b).d(paramArrayOfByte);
                          }
                        }
                        return null;
                      }
                      finally {}
                    }
                    if ("enable_syncing".equals(p.a(this.b).a())) {
                      for (;;)
                      {
                        try
                        {
                          if (p.a(this.b).e(paramArrayOfByte))
                          {
                            if (p.a(this.b).c(paramArrayOfByte) < 10)
                            {
                              p.a(this.b).b(paramArrayOfByte);
                              u.a(this.b).a(false, paramArrayOfByte);
                            }
                          }
                          else {
                            return null;
                          }
                        }
                        finally {}
                        p.a(this.b).d(paramArrayOfByte);
                      }
                    }
                    p.a(this.b).d(paramArrayOfByte);
                    return null;
                  }
                  localObject1 = localObject2;
                  if (!(localObject3 instanceof ae)) {
                    break;
                  }
                  paramArrayOfByte = (ae)localObject3;
                  if ("registration id expired".equalsIgnoreCase(paramArrayOfByte.e))
                  {
                    MiPushClient.reInitialize(this.b, t.a);
                    return null;
                  }
                  if ("client_info_update_ok".equalsIgnoreCase(paramArrayOfByte.e))
                  {
                    localObject1 = localObject2;
                    if (paramArrayOfByte.i() == null) {
                      break;
                    }
                    localObject1 = localObject2;
                    if (!paramArrayOfByte.i().containsKey("app_version")) {
                      break;
                    }
                    paramab = (String)paramArrayOfByte.i().get("app_version");
                    a.a(this.b).a(paramab);
                    return null;
                  }
                  if ("awake_app".equalsIgnoreCase(paramArrayOfByte.e))
                  {
                    localObject1 = localObject2;
                    if (paramArrayOfByte.i() == null) {
                      break;
                    }
                    localObject1 = localObject2;
                    if (!paramArrayOfByte.i().containsKey("packages")) {
                      break;
                    }
                    paramab = ((String)paramArrayOfByte.i().get("packages")).split(",");
                    MiPushClient.awakeApps(this.b, paramab);
                    return null;
                  }
                  if (o.n.N.equalsIgnoreCase(paramArrayOfByte.e))
                  {
                    paramab = new ad();
                    try
                    {
                      aq.a(paramab, paramArrayOfByte.m());
                      ai.a(ah.a(this.b), paramab);
                      return null;
                    }
                    catch (org.apache.thrift.f paramab)
                    {
                      b.a(paramab);
                      return null;
                    }
                  }
                  if (o.o.N.equalsIgnoreCase(paramArrayOfByte.e))
                  {
                    paramab = new com.xiaomi.xmpush.thrift.ac();
                    try
                    {
                      aq.a(paramab, paramArrayOfByte.m());
                      ai.a(ah.a(this.b), paramab);
                      return null;
                    }
                    catch (org.apache.thrift.f paramab)
                    {
                      b.a(paramab);
                      return null;
                    }
                  }
                  if (o.w.N.equalsIgnoreCase(paramArrayOfByte.e))
                  {
                    x.a(this.b, paramArrayOfByte);
                    return null;
                  }
                  if (o.x.N.equalsIgnoreCase(paramArrayOfByte.e))
                  {
                    b.a("receive force sync notification");
                    x.a(this.b, false);
                    return null;
                  }
                  if (o.D.N.equalsIgnoreCase(paramArrayOfByte.e))
                  {
                    f.a(this.b).a(paramArrayOfByte);
                    return null;
                  }
                  if (o.F.N.equalsIgnoreCase(paramArrayOfByte.e))
                  {
                    f.a(this.b).b(paramArrayOfByte);
                    return null;
                  }
                  if (o.H.N.equalsIgnoreCase(paramArrayOfByte.e))
                  {
                    f.a(this.b).c(paramArrayOfByte);
                    return null;
                  }
                  localObject1 = localObject2;
                  if (!o.K.N.equals(paramArrayOfByte.e)) {
                    break;
                  }
                  localObject1 = localObject2;
                  if (paramArrayOfByte.i() == null) {
                    break;
                  }
                  if (paramArrayOfByte.i().containsKey(am.H))
                  {
                    paramab = (String)paramArrayOfByte.i().get(am.H);
                    if (TextUtils.isEmpty(paramab)) {}
                  }
                  for (;;)
                  {
                    try
                    {
                      i = Integer.parseInt(paramab);
                      if (i >= -1)
                      {
                        MiPushClient.clearNotification(this.b, i);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramab)
                    {
                      paramab.printStackTrace();
                      i = -2;
                      continue;
                      paramab = "";
                      if (paramArrayOfByte.i().containsKey(am.F)) {
                        paramab = (String)paramArrayOfByte.i().get(am.F);
                      }
                      if (!paramArrayOfByte.i().containsKey(am.G)) {}
                    }
                    for (paramArrayOfByte = (String)paramArrayOfByte.i().get(am.G);; paramArrayOfByte = "")
                    {
                      MiPushClient.clearNotification(this.b, paramab, paramArrayOfByte);
                      return null;
                    }
                    int i = -2;
                  }
                  paramab = null;
                }
                paramab = null;
              }
            }
          }
        }
      }
      label2520:
      paramab = null;
    }
    label2525:
    return (PushMessageHandler.a)localObject1;
  }
  
  private PushMessageHandler.a a(ab paramab, byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    Object localObject2;
    aj localaj;
    try
    {
      paramArrayOfByte = q.a(this.b, paramab);
      if (paramArrayOfByte == null)
      {
        b.d("message arrived: receiving an un-recognized message. " + paramab.a);
        return null;
      }
      b.c("message arrived: receive a message." + paramArrayOfByte);
      localObject2 = paramab.a();
      b.a("message arrived: processing an arrived message, action=" + localObject2);
      switch (t.a[localObject2.ordinal()])
      {
      default: 
        return null;
      }
      localaj = (aj)paramArrayOfByte;
      localObject2 = localaj.l();
      if (localObject2 == null)
      {
        b.d("message arrived: receive an empty message without push content, drop it");
        return null;
      }
    }
    catch (c paramab)
    {
      b.a(paramab);
      b.d("message arrived: receive a message but decrypt failed. report when click.");
      return null;
    }
    catch (org.apache.thrift.f paramab)
    {
      b.a(paramab);
      b.d("message arrived: receive a message which action string is not valid. is the reg expired?");
      return null;
    }
    paramArrayOfByte = (byte[])localObject1;
    if (paramab.h != null)
    {
      paramArrayOfByte = (byte[])localObject1;
      if (paramab.h.s() != null) {
        paramArrayOfByte = (String)paramab.h.j.get("jobkey");
      }
    }
    paramab = PushMessageHelper.generateMessage(localaj, paramab.m(), false);
    paramab.setArrivedMessage(true);
    b.a("message arrived: receive a message, msgid=" + ((com.xiaomi.xmpush.thrift.q)localObject2).b() + ", jobkey=" + paramArrayOfByte);
    return paramab;
  }
  
  public static s a(Context paramContext)
  {
    if (a == null) {
      a = new s(paramContext);
    }
    return a;
  }
  
  private void a()
  {
    SharedPreferences localSharedPreferences = this.b.getSharedPreferences("mipush_extra", 0);
    long l = System.currentTimeMillis();
    if (Math.abs(l - localSharedPreferences.getLong("last_reinitialize", 0L)) > 1800000L)
    {
      MiPushClient.reInitialize(this.b, t.b);
      localSharedPreferences.edit().putLong("last_reinitialize", l).commit();
    }
  }
  
  private void a(ab paramab)
  {
    b.a("receive a message but decrypt failed. report now.");
    ae localae = new ae(paramab.m().a, false);
    localae.c(o.u.N);
    localae.b(paramab.h());
    localae.d(paramab.f);
    localae.h = new HashMap();
    localae.h.put("regid", MiPushClient.getRegId(this.b));
    u.a(this.b).a(localae, com.xiaomi.xmpush.thrift.a.i, false, null);
  }
  
  private void a(aj paramaj, ab paramab)
  {
    r localr = paramab.m();
    w localw = new w();
    localw.b(paramaj.e());
    localw.a(paramaj.c());
    localw.a(paramaj.l().h());
    if (!TextUtils.isEmpty(paramaj.h())) {
      localw.c(paramaj.h());
    }
    if (!TextUtils.isEmpty(paramaj.j())) {
      localw.d(paramaj.j());
    }
    localw.a(aq.a(this.b, paramab));
    u.a(this.b).a(localw, com.xiaomi.xmpush.thrift.a.f, localr);
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    synchronized (d)
    {
      paramContext = a.a(paramContext).j();
      if (c == null)
      {
        String[] arrayOfString = paramContext.getString("pref_msg_ids", "").split(",");
        c = new LinkedList();
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          c.add(str);
          i += 1;
        }
      }
      if (c.contains(paramString)) {
        return true;
      }
      c.add(paramString);
      if (c.size() > 25) {
        c.poll();
      }
      paramString = d.a(c, ",");
      paramContext = paramContext.edit();
      paramContext.putString("pref_msg_ids", paramString);
      paramContext.commit();
      return false;
    }
  }
  
  private void b(ab paramab)
  {
    r localr = paramab.m();
    w localw = new w();
    localw.b(paramab.h());
    localw.a(localr.b());
    localw.a(localr.d());
    if (!TextUtils.isEmpty(localr.f())) {
      localw.c(localr.f());
    }
    localw.a(aq.a(this.b, paramab));
    u.a(this.b).a(localw, com.xiaomi.xmpush.thrift.a.f, false, paramab.m());
  }
  
  public PushMessageHandler.a a(Intent paramIntent)
  {
    Object localObject3 = paramIntent.getAction();
    b.a("receive an intent from server, action=" + (String)localObject3);
    Object localObject2 = paramIntent.getStringExtra("mrt");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.toString(System.currentTimeMillis());
    }
    boolean bool;
    if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(localObject3))
    {
      localObject2 = paramIntent.getByteArrayExtra("mipush_payload");
      bool = paramIntent.getBooleanExtra("mipush_notified", false);
      if (localObject2 == null)
      {
        b.d("receiving an empty message, drop");
        return null;
      }
      localObject3 = new ab();
    }
    for (;;)
    {
      try
      {
        aq.a((org.apache.thrift.a)localObject3, (byte[])localObject2);
        a locala = a.a(this.b);
        paramIntent = ((ab)localObject3).m();
        if ((((ab)localObject3).a() == com.xiaomi.xmpush.thrift.a.e) && (paramIntent != null) && (!locala.l()) && (!bool))
        {
          if (paramIntent != null)
          {
            ((ab)localObject3).m().a("mrt", (String)localObject1);
            ((ab)localObject3).m().a("mat", Long.toString(System.currentTimeMillis()));
          }
          b((ab)localObject3);
        }
        if ((((ab)localObject3).a() == com.xiaomi.xmpush.thrift.a.e) && (!((ab)localObject3).c()))
        {
          if (!com.xiaomi.push.service.ac.b((ab)localObject3))
          {
            localObject1 = ((ab)localObject3).j();
            if (paramIntent == null) {
              break label720;
            }
            paramIntent = paramIntent.b();
            b.a(String.format("drop an un-encrypted messages. %1$s, %2$s", new Object[] { localObject1, paramIntent }));
            return null;
          }
          if ((!bool) || (paramIntent.s() == null) || (!paramIntent.s().containsKey("notify_effect"))) {}
        }
        else
        {
          if ((locala.i()) || (((ab)localObject3).a == com.xiaomi.xmpush.thrift.a.a)) {
            continue;
          }
          if (!com.xiaomi.push.service.ac.b((ab)localObject3)) {
            continue;
          }
          return a((ab)localObject3, bool, (byte[])localObject2);
        }
        b.a(String.format("drop an un-encrypted messages. %1$s, %2$s", new Object[] { ((ab)localObject3).j(), paramIntent.b() }));
        return null;
        b.d("receive message without registration. need re-register!");
        a();
        break;
        if ((locala.i()) && (locala.n())) {
          if (((ab)localObject3).a == com.xiaomi.xmpush.thrift.a.b)
          {
            locala.h();
            MiPushClient.clearExtras(this.b);
            PushMessageHandler.a();
          }
        }
      }
      catch (org.apache.thrift.f paramIntent)
      {
        b.a(paramIntent);
        break;
        MiPushClient.unregisterPush(this.b);
      }
      catch (Exception paramIntent)
      {
        b.a(paramIntent);
      }
      paramIntent = a((ab)localObject3, bool, (byte[])localObject2);
      return paramIntent;
      if ("com.xiaomi.mipush.ERROR".equals(localObject3))
      {
        localObject1 = new MiPushCommandMessage();
        localObject2 = new ab();
      }
      try
      {
        localObject3 = paramIntent.getByteArrayExtra("mipush_payload");
        if (localObject3 != null) {
          aq.a((org.apache.thrift.a)localObject2, (byte[])localObject3);
        }
      }
      catch (org.apache.thrift.f localf)
      {
        for (;;) {}
      }
      ((MiPushCommandMessage)localObject1).setCommand(String.valueOf(((ab)localObject2).a()));
      ((MiPushCommandMessage)localObject1).setResultCode(paramIntent.getIntExtra("mipush_error_code", 0));
      ((MiPushCommandMessage)localObject1).setReason(paramIntent.getStringExtra("mipush_error_msg"));
      b.d("receive a error message. code = " + paramIntent.getIntExtra("mipush_error_code", 0) + ", msg= " + paramIntent.getStringExtra("mipush_error_msg"));
      return (PushMessageHandler.a)localObject1;
      if (!"com.xiaomi.mipush.MESSAGE_ARRIVED".equals(localObject3)) {
        break;
      }
      paramIntent = paramIntent.getByteArrayExtra("mipush_payload");
      if (paramIntent == null)
      {
        b.d("message arrived: receiving an empty message, drop");
        return null;
      }
      localObject1 = new ab();
      try
      {
        aq.a((org.apache.thrift.a)localObject1, paramIntent);
        localObject2 = a.a(this.b);
        if (com.xiaomi.push.service.ac.b((ab)localObject1)) {
          b.d("message arrived: receive ignore reg message, ignore!");
        }
      }
      catch (org.apache.thrift.f paramIntent)
      {
        b.a(paramIntent);
        break;
        if (!((a)localObject2).i()) {
          b.d("message arrived: receive message without registration. need unregister or re-register!");
        }
      }
      catch (Exception paramIntent)
      {
        b.a(paramIntent);
      }
      if ((((a)localObject2).i()) && (((a)localObject2).n()))
      {
        b.d("message arrived: app info is invalidated");
        break;
      }
      paramIntent = a((ab)localObject1, paramIntent);
      return paramIntent;
      label720:
      paramIntent = "";
    }
    return null;
  }
  
  public List<String> a(TimeZone paramTimeZone1, TimeZone paramTimeZone2, List<String> paramList)
  {
    if (paramTimeZone1.equals(paramTimeZone2)) {
      return paramList;
    }
    long l1 = (paramTimeZone1.getRawOffset() - paramTimeZone2.getRawOffset()) / 1000 / 60;
    long l4 = Long.parseLong(((String)paramList.get(0)).split(":")[0]);
    long l5 = Long.parseLong(((String)paramList.get(0)).split(":")[1]);
    long l2 = Long.parseLong(((String)paramList.get(1)).split(":")[0]);
    long l3 = Long.parseLong(((String)paramList.get(1)).split(":")[1]);
    l4 = (l4 * 60L + l5 - l1 + 1440L) % 1440L;
    l1 = (l3 + 60L * l2 - l1 + 1440L) % 1440L;
    paramTimeZone1 = new ArrayList();
    paramTimeZone1.add(String.format("%1$02d:%2$02d", new Object[] { Long.valueOf(l4 / 60L), Long.valueOf(l4 % 60L) }));
    paramTimeZone1.add(String.format("%1$02d:%2$02d", new Object[] { Long.valueOf(l1 / 60L), Long.valueOf(l1 % 60L) }));
    return paramTimeZone1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */