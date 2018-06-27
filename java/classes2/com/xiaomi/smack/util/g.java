package com.xiaomi.smack.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.providers.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class g
{
  private static com.xiaomi.channel.commonutils.misc.h a = new com.xiaomi.channel.commonutils.misc.h(true);
  private static int b = -1;
  private static final Object c = new Object();
  private static List<a> d = Collections.synchronizedList(new ArrayList());
  private static String e = "";
  private static a f = null;
  
  private static int a(Context paramContext)
  {
    if (b == -1) {
      b = b(paramContext);
    }
    return b;
  }
  
  public static int a(String paramString)
  {
    try
    {
      int i = paramString.getBytes("UTF-8").length;
      return i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString.getBytes().length;
  }
  
  private static long a(int paramInt, long paramLong)
  {
    if (paramInt == 0) {}
    for (paramInt = 13;; paramInt = 11) {
      return paramInt * paramLong / 10L;
    }
  }
  
  public static void a(Context paramContext, String paramString, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (!"com.xiaomi.xmsf".equals(paramContext.getPackageName())) || ("com.xiaomi.xmsf".equals(paramString))) {}
    for (;;)
    {
      return;
      int j = a(paramContext);
      if (-1 == j) {
        continue;
      }
      synchronized (c)
      {
        boolean bool = d.isEmpty();
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          if (j != 0) {
            break label139;
          }
          str = c(paramContext);
          a(new a(paramString, paramLong2, j, i, str, a(j, paramLong1)));
          if (!bool) {
            break;
          }
          a.a(new h(paramContext), 5000L);
          return;
        }
        label139:
        String str = "";
      }
    }
  }
  
  private static void a(a parama)
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a(parama))
      {
        locala.f += parama.f;
        return;
      }
    }
    d.add(parama);
  }
  
  private static int b(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return -1;
      }
    }
    catch (Exception paramContext)
    {
      return -1;
    }
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return -1;
      }
    }
    catch (Exception paramContext)
    {
      return -1;
    }
    return paramContext.getType();
  }
  
  private static void b(Context paramContext, List<a> paramList)
  {
    try
    {
      synchronized (a.a)
      {
        paramContext = d(paramContext).getWritableDatabase();
        paramContext.beginTransaction();
        try
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            a locala = (a)paramList.next();
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("package_name", locala.a);
            localContentValues.put("message_ts", Long.valueOf(locala.b));
            localContentValues.put("network_type", Integer.valueOf(locala.c));
            localContentValues.put("bytes", Long.valueOf(locala.f));
            localContentValues.put("rcv", Integer.valueOf(locala.d));
            localContentValues.put("imsi", locala.e);
            paramContext.insert("traffic", null, localContentValues);
            continue;
            paramContext = finally;
          }
        }
        finally
        {
          paramContext.endTransaction();
        }
      }
      paramContext.setTransactionSuccessful();
    }
    catch (SQLiteException paramContext)
    {
      b.a(paramContext);
      return;
    }
    paramContext.endTransaction();
  }
  
  private static String c(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(e))
        {
          paramContext = e;
          return paramContext;
        }
      }
      finally {}
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null) {
          e = paramContext.getSubscriberId();
        }
      }
      catch (Exception paramContext)
      {
        continue;
      }
      paramContext = e;
    }
  }
  
  private static a d(Context paramContext)
  {
    if (f != null) {
      return f;
    }
    f = new a(paramContext);
    return f;
  }
  
  static class a
  {
    public String a = "";
    public long b = 0L;
    public int c = -1;
    public int d = -1;
    public String e = "";
    public long f = 0L;
    
    public a(String paramString1, long paramLong1, int paramInt1, int paramInt2, String paramString2, long paramLong2)
    {
      this.a = paramString1;
      this.b = paramLong1;
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramString2;
      this.f = paramLong2;
    }
    
    public boolean a(a parama)
    {
      return (TextUtils.equals(parama.a, this.a)) && (TextUtils.equals(parama.e, this.e)) && (parama.c == this.c) && (parama.d == this.d) && (Math.abs(parama.b - this.b) <= 5000L);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/util/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */