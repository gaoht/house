package com.g.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class bf
{
  private static String a = "v1";
  private static String b = "utf-8";
  private static final CRC32 c = new CRC32();
  private static volatile bf f = null;
  private static HandlerThread g;
  private long d = 0L;
  private boolean e = false;
  private Handler h = null;
  
  static
  {
    try
    {
      ad.a().register(b());
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private bf()
  {
    g = new HandlerThread("ModuleDataForward");
    g.start();
    this.h = new bh(this, g.getLooper());
    e();
    a();
  }
  
  private static String a(List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append((String)paramList.next());
      localStringBuilder.append(",");
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private void a(a parama)
  {
    for (;;)
    {
      try
      {
        bk.a().getFileLock(parama);
        Object localObject1 = bi.b().a(parama);
        if ((localObject1 == null) || (((List)localObject1).size() <= 0))
        {
          a("No new data found!", parama, false);
          return;
        }
        a("New data found, Submitting...", parama, true);
        localObject1 = z.e(a((List)localObject1));
        c.reset();
        c.update((byte[])localObject1);
        localStringBuilder = new StringBuilder(parama.f());
        if (!parama.b().equals("TRACKING")) {
          continue;
        }
        localStringBuilder.append("/" + Long.toHexString(c.getValue()));
        localStringBuilder.append("/1");
        if (j.a(c.e, parama.e(), "", localStringBuilder.toString(), parama.d(), (byte[])localObject1).a() != 200) {
          continue;
        }
        this.d = SystemClock.elapsedRealtime();
        this.e = true;
        bi.b().sendMessageSuccess(parama);
        a("Data submitted successfully!", parama, true);
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder;
        av.postSDKError(localThrowable);
        return;
        this.e = false;
        a("Failed to submit data!", parama, true);
        continue;
      }
      finally
      {
        bk.a().releaseFileLock(parama);
      }
      bk.a().releaseFileLock(parama);
      return;
      localStringBuilder.append("/" + a);
      localStringBuilder.append("/" + Long.toHexString(c.getValue()));
    }
  }
  
  private void a(String paramString, a parama, boolean paramBoolean)
  {
    switch (parama.c())
    {
    case 2: 
    case 5: 
    case 6: 
    default: 
      h.iForInternal(new String[] { paramString });
    }
    do
    {
      return;
      h.iForDeveloper(paramString);
      return;
      h.iForDeveloper(paramString);
      return;
    } while (!paramBoolean);
    h.iForDeveloper("Push " + paramString);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte['ࠀ'];
    for (;;)
    {
      try
      {
        paramArrayOfByte = new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte), new Inflater(false)));
        try
        {
          localByteArrayOutputStream = new ByteArrayOutputStream();
          int i = paramArrayOfByte.read(arrayOfByte1);
          if (i != -1)
          {
            localByteArrayOutputStream.write(arrayOfByte1, 0, i);
            continue;
            if (paramArrayOfByte == null) {}
          }
        }
        catch (Exception localException) {}
      }
      catch (Exception paramArrayOfByte)
      {
        ByteArrayOutputStream localByteArrayOutputStream;
        byte[] arrayOfByte2;
        paramArrayOfByte = null;
        continue;
      }
      try
      {
        paramArrayOfByte.close();
        return null;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
    }
    localByteArrayOutputStream.close();
    paramArrayOfByte.close();
    arrayOfByte2 = localByteArrayOutputStream.toByteArray();
    return arrayOfByte2;
  }
  
  public static bf b()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new bf();
      }
      return f;
    }
    finally {}
  }
  
  private static boolean d()
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      long l1 = localCalendar.get(6) * 1000 + localCalendar.get(3);
      localCalendar.setTimeInMillis(i.e());
      int i = localCalendar.get(6);
      long l2 = localCalendar.get(3) + i * 1000;
      long l3 = v.b(c.e, "TD_app_pefercen_profile", "TD_sdk_last_send_time", 0L);
      if ((System.currentTimeMillis() - i.e() >= 5000L) && (Math.abs(l2 / 1000L - l1 / 1000L) != 1L))
      {
        l1 = Math.abs(l1 % 100L - l3 % 100L);
        if (l1 < 1L) {}
      }
      else
      {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
    return false;
  }
  
  private static void e()
  {
    if (!r.c(c.e)) {
      return;
    }
    new Thread(new bg()).start();
  }
  
  public void a()
  {
    int i = 30000;
    if (!this.h.hasMessages(5))
    {
      Object localObject = new Random();
      if (r.g(c.e))
      {
        if (!this.e) {
          i = ((Random)localObject).nextInt(30000) + 30000;
        }
        localObject = bp.b().a().iterator();
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          this.h.sendMessageDelayed(Message.obtain(this.h, 5, locala), i);
        }
      }
      if (!this.e) {}
      for (i = ((Random)localObject).nextInt(60000) - 30000 + 120000;; i = 120000) {
        break;
      }
    }
  }
  
  public final void onTDEBEventForwardRequest(bd parambd)
  {
    long l1 = 30000L;
    if ((parambd == null) || (c.e == null)) {}
    do
    {
      return;
      if (!r.c(c.e))
      {
        a();
        return;
      }
      if (parambd.b.equals(bd.a.a))
      {
        if (this.h.hasMessages(5, parambd.a)) {
          this.h.removeMessages(5);
        }
        Message.obtain(this.h, 5, parambd.a).sendToTarget();
        return;
      }
    } while (!parambd.b.equals(bd.a.b));
    if (this.h.hasMessages(5)) {
      this.h.removeMessages(5);
    }
    long l2 = Math.abs(SystemClock.elapsedRealtime() - this.d - 30000L);
    if (l2 > 30000L) {}
    for (;;)
    {
      parambd = Message.obtain(this.h, 5, parambd.a);
      this.h.sendMessageDelayed(parambd, l1);
      return;
      l1 = l2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */