package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat.Builder;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.util.EMLog;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class b
{
  protected static final String[] b = { "sent a message", "sent a picture", "sent a voice", "sent location message", "sent a video", "sent a file", "%1 contacts sent %2 messages" };
  protected static final String[] c = { "发来一条消息", "发来一张图片", "发来一段语音", "发来位置信息", "发来一个视频", "发来一个文件", "%1个联系人发来%2条消息" };
  protected static int d = 341;
  protected static int e = 365;
  Ringtone a = null;
  protected NotificationManager f = null;
  protected HashSet<String> g = new HashSet();
  protected int h = 0;
  protected Context i;
  protected String j;
  protected String[] k;
  protected long l;
  protected AudioManager m;
  protected Vibrator n;
  protected a o;
  
  void a()
  {
    this.h = 0;
    this.g.clear();
  }
  
  protected void a(EMMessage paramEMMessage, boolean paramBoolean)
  {
    u.d("jgkfdljhklh", "======== backgroud  333" + paramBoolean);
    a(paramEMMessage, paramBoolean, true);
  }
  
  protected void a(EMMessage paramEMMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramEMMessage.getFrom();
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = (String)localObject1 + " ";
        switch (b.2.a[paramEMMessage.getType().ordinal()])
        {
        case 1: 
          localObject4 = (String)this.i.getPackageManager().getApplicationLabel(this.i.getApplicationInfo());
          localObject2 = localObject1;
          if (this.o == null) {
            break label629;
          }
          localObject2 = this.o.getDisplayedText(paramEMMessage);
          localObject3 = this.o.getTitle(paramEMMessage);
          if (localObject2 == null) {
            break label643;
          }
          localObject1 = localObject2;
        }
      }
      catch (Exception paramEMMessage)
      {
        label145:
        NotificationCompat.Builder localBuilder;
        PendingIntent localPendingIntent;
        int i1;
        paramEMMessage.printStackTrace();
        return;
      }
      localBuilder = new NotificationCompat.Builder(this.i).setSmallIcon(this.i.getApplicationInfo().icon).setWhen(System.currentTimeMillis()).setAutoCancel(true);
      Object localObject4 = this.i.getPackageManager().getLaunchIntentForPackage(this.j);
      localObject1 = localObject4;
      if (this.o != null)
      {
        localObject1 = localObject4;
        if (this.o.getLaunchIntent(paramEMMessage) != null) {
          localObject1 = this.o.getLaunchIntent(paramEMMessage);
        }
      }
      localPendingIntent = PendingIntent.getActivity(this.i, d, (Intent)localObject1, 134217728);
      if ((paramBoolean2) && (!paramBoolean1))
      {
        this.h += 1;
        this.g.add(paramEMMessage.getFrom());
      }
      i1 = this.g.size();
      localObject1 = this.k[6].replaceFirst("%1", Integer.toString(i1)).replaceFirst("%2", Integer.toString(this.h));
      localObject4 = localObject1;
      if (this.o != null)
      {
        localObject4 = this.o.getLatestText(paramEMMessage, i1, this.h);
        if (localObject4 != null) {
          localObject1 = localObject4;
        }
        i1 = this.o.getSmallIcon(paramEMMessage);
        localObject4 = localObject1;
        if (i1 != 0)
        {
          localBuilder.setSmallIcon(i1);
          localObject4 = localObject1;
        }
      }
      localBuilder.setContentTitle((CharSequence)localObject2);
      localBuilder.setTicker((CharSequence)localObject3);
      localBuilder.setContentText((CharSequence)localObject4);
      localBuilder.setContentIntent(localPendingIntent);
      paramEMMessage = localBuilder.build();
      if (paramBoolean1)
      {
        return;
        localObject1 = (String)localObject1 + this.k[0];
        continue;
        localObject1 = (String)localObject1 + this.k[1];
        continue;
        localObject1 = (String)localObject1 + this.k[2];
        continue;
        localObject1 = (String)localObject1 + this.k[3];
        continue;
        localObject1 = (String)localObject1 + this.k[4];
        continue;
        localObject1 = (String)localObject1 + this.k[5];
      }
      else
      {
        this.f.notify(d, paramEMMessage);
        return;
        label629:
        label643:
        do
        {
          localObject3 = localObject2;
          localObject2 = localObject4;
          break label145;
          break;
          localObject2 = localObject1;
        } while (localObject3 == null);
        localObject2 = localObject3;
        localObject3 = localObject1;
      }
    }
  }
  
  protected void a(List<EMMessage> paramList, boolean paramBoolean)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      EMMessage localEMMessage = (EMMessage)localIterator.next();
      if (!paramBoolean)
      {
        this.h += 1;
        this.g.add(localEMMessage.getFrom());
      }
    }
    a((EMMessage)paramList.get(paramList.size() - 1), paramBoolean, false);
  }
  
  void b()
  {
    if (this.f != null) {
      this.f.cancel(d);
    }
  }
  
  public b init(Context paramContext)
  {
    this.i = paramContext;
    this.f = ((NotificationManager)paramContext.getSystemService("notification"));
    this.j = this.i.getApplicationInfo().packageName;
    if (Locale.getDefault().getLanguage().equals("zh")) {}
    for (this.k = c;; this.k = b)
    {
      this.m = ((AudioManager)this.i.getSystemService("audio"));
      this.n = ((Vibrator)this.i.getSystemService("vibrator"));
      return this;
    }
  }
  
  /* Error */
  public void onNewMesg(List<EMMessage> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 144	com/ziroom/ziroomcustomer/minsu/chat/b:i	Landroid/content/Context;
    //   6: invokestatic 344	com/hyphenate/util/EasyUtils:isAppRunningForeground	(Landroid/content/Context;)Z
    //   9: ifne +42 -> 51
    //   12: ldc_w 345
    //   15: ldc_w 347
    //   18: invokestatic 350	com/hyphenate/util/EMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: aload_1
    //   23: iconst_0
    //   24: invokevirtual 352	com/ziroom/ziroomcustomer/minsu/chat/b:a	(Ljava/util/List;Z)V
    //   27: aload_0
    //   28: aload_1
    //   29: aload_1
    //   30: invokeinterface 289 1 0
    //   35: iconst_1
    //   36: isub
    //   37: invokeinterface 293 2 0
    //   42: checkcast 122	com/hyphenate/chat/EMMessage
    //   45: invokevirtual 356	com/ziroom/ziroomcustomer/minsu/chat/b:viberateAndPlayTone	(Lcom/hyphenate/chat/EMMessage;)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: aload_1
    //   53: iconst_1
    //   54: invokevirtual 352	com/ziroom/ziroomcustomer/minsu/chat/b:a	(Ljava/util/List;Z)V
    //   57: goto -30 -> 27
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	b
    //   0	65	1	paramList	List<EMMessage>
    // Exception table:
    //   from	to	target	type
    //   2	27	60	finally
    //   27	48	60	finally
    //   51	57	60	finally
  }
  
  /* Error */
  public void onNewMsg(EMMessage paramEMMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 361	com/hyphenate/chat/EMMessage:getMsgId	()Ljava/lang/String;
    //   6: astore_2
    //   7: ldc_w 363
    //   10: new 96	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 365
    //   20: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 369	com/ziroom/ziroomcustomer/home/view/recyclerview2gallery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_2
    //   34: invokestatic 375	com/ziroom/ziroomcustomer/minsu/d/e:getOfflineMsgId	(Ljava/lang/String;)Z
    //   37: ifeq +32 -> 69
    //   40: ldc_w 363
    //   43: new 96	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 365
    //   53: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_2
    //   57: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 369	com/ziroom/ziroomcustomer/home/view/recyclerview2gallery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: aload_0
    //   70: aload_1
    //   71: iconst_0
    //   72: invokevirtual 377	com/ziroom/ziroomcustomer/minsu/chat/b:a	(Lcom/hyphenate/chat/EMMessage;Z)V
    //   75: aload_0
    //   76: aload_1
    //   77: invokevirtual 356	com/ziroom/ziroomcustomer/minsu/chat/b:viberateAndPlayTone	(Lcom/hyphenate/chat/EMMessage;)V
    //   80: goto -14 -> 66
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	b
    //   0	88	1	paramEMMessage	EMMessage
    //   6	51	2	str	String
    // Exception table:
    //   from	to	target	type
    //   2	66	83	finally
    //   69	80	83	finally
  }
  
  public void reset()
  {
    a();
    b();
  }
  
  public void setNotificationInfoProvider(a parama)
  {
    this.o = parama;
  }
  
  public void viberateAndPlayTone(EMMessage paramEMMessage)
  {
    if (System.currentTimeMillis() - this.l < 1000L) {}
    do
    {
      do
      {
        return;
        try
        {
          this.l = System.currentTimeMillis();
          if (this.m.getRingerMode() == 0)
          {
            EMLog.e("notify", "in slient mode now");
            return;
          }
        }
        catch (Exception paramEMMessage)
        {
          paramEMMessage.printStackTrace();
          return;
        }
        this.n.vibrate(new long[] { 0L, 180L, 80L, 120L }, -1);
        if (this.a == null)
        {
          RingtoneManager.getDefaultUri(2);
          paramEMMessage = Uri.parse("android.resource://" + ApplicationEx.c.getPackageName() + "/" + 2131165184);
          this.a = RingtoneManager.getRingtone(this.i, paramEMMessage);
          if (this.a == null)
          {
            EMLog.d("notify", "cant find ringtone at:" + paramEMMessage.getPath());
            return;
          }
        }
      } while (this.a.isPlaying());
      paramEMMessage = Build.MANUFACTURER;
      this.a.play();
    } while ((paramEMMessage == null) || (!paramEMMessage.toLowerCase().contains("samsung")));
    new b.1(this).run();
  }
  
  public static abstract interface a
  {
    public abstract String getDisplayedText(EMMessage paramEMMessage);
    
    public abstract String getLatestText(EMMessage paramEMMessage, int paramInt1, int paramInt2);
    
    public abstract Intent getLaunchIntent(EMMessage paramEMMessage);
    
    public abstract int getSmallIcon(EMMessage paramEMMessage);
    
    public abstract String getTitle(EMMessage paramEMMessage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */