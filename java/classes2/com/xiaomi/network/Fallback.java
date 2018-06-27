package com.xiaomi.network;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class Fallback
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  protected String h;
  private long i;
  private ArrayList<c> j = new ArrayList();
  private String k;
  private double l = 0.1D;
  private String m = "s.mi1.cc";
  private long n = 86400000L;
  
  public Fallback(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("the host is empty");
    }
    this.i = System.currentTimeMillis();
    this.j.add(new c(paramString, -1));
    this.a = HostManager.getInstance().getActiveNetworkLabel();
    this.b = paramString;
  }
  
  private void c(String paramString)
  {
    try
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext()) {
        if (TextUtils.equals(((c)localIterator.next()).a, paramString)) {
          localIterator.remove();
        }
      }
    }
    finally {}
  }
  
  public Fallback a(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.optString("net");
      this.n = paramJSONObject.getLong("ttl");
      this.l = paramJSONObject.getDouble("pct");
      this.i = paramJSONObject.getLong("ts");
      this.d = paramJSONObject.optString("city");
      this.c = paramJSONObject.optString("prv");
      this.g = paramJSONObject.optString("cty");
      this.e = paramJSONObject.optString("isp");
      this.f = paramJSONObject.optString("ip");
      this.b = paramJSONObject.optString("host");
      this.h = paramJSONObject.optString("xf");
      paramJSONObject = paramJSONObject.getJSONArray("fbs");
      int i1 = 0;
      while (i1 < paramJSONObject.length())
      {
        a(new c().a(paramJSONObject.getJSONObject(i1)));
        i1 += 1;
      }
      return this;
    }
    finally {}
  }
  
  public ArrayList<String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("the url is empty.");
    }
    paramString = new URL(paramString);
    ArrayList localArrayList;
    if (TextUtils.equals(paramString.getHost(), this.b))
    {
      localArrayList = new ArrayList();
      Iterator localIterator = a(true).iterator();
      while (localIterator.hasNext())
      {
        Host localHost = Host.a((String)localIterator.next(), paramString.getPort());
        localArrayList.add(new URL(paramString.getProtocol(), localHost.b(), localHost.a(), paramString.getFile()).toString());
      }
    }
    throw new IllegalArgumentException("the url is not supported by the fallback");
    return localArrayList;
  }
  
  public ArrayList<String> a(boolean paramBoolean)
  {
    int i1 = 0;
    for (;;)
    {
      ArrayList localArrayList;
      c localc;
      try
      {
        c[] arrayOfc = new c[this.j.size()];
        this.j.toArray(arrayOfc);
        Arrays.sort(arrayOfc);
        localArrayList = new ArrayList();
        int i2 = arrayOfc.length;
        if (i1 >= i2) {
          break label132;
        }
        localc = arrayOfc[i1];
        if (paramBoolean)
        {
          localArrayList.add(localc.a);
        }
        else
        {
          int i3 = localc.a.indexOf(":");
          if (i3 != -1) {
            localArrayList.add(localc.a.substring(0, i3));
          }
        }
      }
      finally {}
      localArrayList.add(localc.a);
      break label137;
      label132:
      return localArrayList;
      label137:
      i1 += 1;
    }
  }
  
  public void a(double paramDouble)
  {
    this.l = paramDouble;
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("the duration is invalid " + paramLong);
    }
    this.n = paramLong;
  }
  
  void a(c paramc)
  {
    try
    {
      c(paramc.a);
      this.j.add(paramc);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, Exception paramException)
  {
    a(paramString, new AccessHistory(paramInt, paramLong1, paramLong2, paramException));
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      b(new URL(paramString).getHost(), paramLong1, paramLong2);
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, Exception paramException)
  {
    try
    {
      b(new URL(paramString).getHost(), paramLong1, paramLong2, paramException);
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  public void a(String paramString, AccessHistory paramAccessHistory)
  {
    try
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (TextUtils.equals(paramString, localc.a)) {
          localc.a(paramAccessHistory);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String[] paramArrayOfString)
  {
    for (;;)
    {
      int i1;
      int i2;
      try
      {
        i1 = this.j.size() - 1;
        if (i1 >= 0)
        {
          int i3 = paramArrayOfString.length;
          i2 = 0;
          if (i2 >= i3) {
            break label162;
          }
          localObject = paramArrayOfString[i2];
          if (!TextUtils.equals(((c)this.j.get(i1)).a, (CharSequence)localObject)) {
            break label169;
          }
          this.j.remove(i1);
          break label162;
        }
        Object localObject = this.j.iterator();
        i1 = 0;
        if (!((Iterator)localObject).hasNext()) {
          break label179;
        }
        c localc = (c)((Iterator)localObject).next();
        if (localc.b <= i1) {
          break label159;
        }
        i1 = localc.b;
      }
      finally {}
      if (i2 < paramArrayOfString.length)
      {
        a(new c(paramArrayOfString[i2], paramArrayOfString.length + i1 - i2));
        i2 += 1;
      }
      else
      {
        return;
        label159:
        break label176;
        label162:
        i1 -= 1;
        continue;
        label169:
        i2 += 1;
        continue;
        label176:
        continue;
        label179:
        i2 = 0;
      }
    }
  }
  
  public boolean a()
  {
    return TextUtils.equals(this.a, HostManager.getInstance().getActiveNetworkLabel());
  }
  
  public boolean a(Fallback paramFallback)
  {
    return TextUtils.equals(this.a, paramFallback.a);
  }
  
  public void b(String paramString)
  {
    this.m = paramString;
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    a(paramString, 0, paramLong1, paramLong2, null);
  }
  
  public void b(String paramString, long paramLong1, long paramLong2, Exception paramException)
  {
    a(paramString, -1, paramLong1, paramLong2, paramException);
  }
  
  public boolean b()
  {
    return System.currentTimeMillis() - this.i < this.n;
  }
  
  boolean c()
  {
    long l1 = 864000000L;
    if (864000000L < this.n) {
      l1 = this.n;
    }
    long l2 = System.currentTimeMillis();
    return (l2 - this.i > l1) || ((l2 - this.i > this.n) && (this.a.startsWith("WIFI-")));
  }
  
  public ArrayList<String> d()
  {
    try
    {
      ArrayList localArrayList = a(false);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public String e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 311	com/xiaomi/network/Fallback:k	Ljava/lang/String;
    //   6: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +12 -> 21
    //   12: aload_0
    //   13: getfield 311	com/xiaomi/network/Fallback:k	Ljava/lang/String;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aload_0
    //   22: getfield 150	com/xiaomi/network/Fallback:e	Ljava/lang/String;
    //   25: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +10 -> 38
    //   31: ldc_w 313
    //   34: astore_1
    //   35: goto -18 -> 17
    //   38: aload_0
    //   39: iconst_5
    //   40: anewarray 197	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: aload_0
    //   46: getfield 150	com/xiaomi/network/Fallback:e	Ljava/lang/String;
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload_0
    //   53: getfield 142	com/xiaomi/network/Fallback:c	Ljava/lang/String;
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: aload_0
    //   60: getfield 138	com/xiaomi/network/Fallback:d	Ljava/lang/String;
    //   63: aastore
    //   64: dup
    //   65: iconst_3
    //   66: aload_0
    //   67: getfield 146	com/xiaomi/network/Fallback:g	Ljava/lang/String;
    //   70: aastore
    //   71: dup
    //   72: iconst_4
    //   73: aload_0
    //   74: getfield 154	com/xiaomi/network/Fallback:f	Ljava/lang/String;
    //   77: aastore
    //   78: ldc_w 315
    //   81: invokestatic 319	com/xiaomi/network/HostManager:join	([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: putfield 311	com/xiaomi/network/Fallback:k	Ljava/lang/String;
    //   87: aload_0
    //   88: getfield 311	com/xiaomi/network/Fallback:k	Ljava/lang/String;
    //   91: astore_1
    //   92: goto -75 -> 17
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	Fallback
    //   16	76	1	str	String
    //   95	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	95	finally
    //   21	31	95	finally
    //   38	92	95	finally
  }
  
  public JSONObject f()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("net", this.a);
      localJSONObject1.put("ttl", this.n);
      localJSONObject1.put("pct", this.l);
      localJSONObject1.put("ts", this.i);
      localJSONObject1.put("city", this.d);
      localJSONObject1.put("prv", this.c);
      localJSONObject1.put("cty", this.g);
      localJSONObject1.put("isp", this.e);
      localJSONObject1.put("ip", this.f);
      localJSONObject1.put("host", this.b);
      localJSONObject1.put("xf", this.h);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((c)localIterator.next()).a());
      }
      localJSONObject2.put("fbs", localJSONArray);
    }
    finally {}
    return localJSONObject2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    localStringBuilder.append(e());
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      localStringBuilder.append("\n");
      localStringBuilder.append(localc.toString());
    }
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/network/Fallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */