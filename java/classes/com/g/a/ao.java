package com.g.a;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class ao
{
  private static volatile ao a = null;
  private static String b;
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static String j;
  private static JSONObject p;
  private String i;
  private a k = a.c;
  private String l;
  private int m;
  private String n;
  private JSONObject o;
  
  static
  {
    try
    {
      ad.a().register(a());
      b = "account";
      c = "accountId";
      d = "name";
      e = "gender";
      f = "age";
      g = "type";
      h = "accountCus";
      j = "default";
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public static ao a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ao();
      }
      return a;
    }
    finally {}
  }
  
  private void a(a parama)
  {
    try
    {
      bd localbd = new bd();
      localbd.b = bd.a.a;
      localbd.a = parama;
      ad.a().post(localbd);
      return;
    }
    catch (Throwable parama) {}
  }
  
  protected static void a(Object paramObject1, Object paramObject2, Object paramObject3, a parama)
  {
    if (parama == null) {}
    while ((paramObject1 == null) || (paramObject2 == null) || (!(paramObject1 instanceof String)) || (!(paramObject2 instanceof String))) {
      return;
    }
    be localbe = new be();
    localbe.b = String.valueOf(paramObject1);
    localbe.c = String.valueOf(paramObject2);
    if ((paramObject3 != null) && ((paramObject3 instanceof Map))) {
      localbe.d = ((Map)paramObject3);
    }
    localbe.a = parama;
    ad.a().post(localbe);
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 124	com/g/a/ao:i	Ljava/lang/String;
    //   5: aload_0
    //   6: getfield 124	com/g/a/ao:i	Ljava/lang/String;
    //   9: invokestatic 129	com/g/a/i:a	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +120 -> 134
    //   17: new 131	org/json/JSONObject
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 133	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_1
    //   27: getstatic 57	com/g/a/ao:d	Ljava/lang/String;
    //   30: invokevirtual 137	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   33: ifeq +14 -> 47
    //   36: aload_0
    //   37: aload_1
    //   38: getstatic 57	com/g/a/ao:d	Ljava/lang/String;
    //   41: invokevirtual 140	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: putfield 142	com/g/a/ao:l	Ljava/lang/String;
    //   47: aload_1
    //   48: getstatic 61	com/g/a/ao:e	Ljava/lang/String;
    //   51: invokevirtual 137	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   54: ifeq +17 -> 71
    //   57: aload_0
    //   58: aload_1
    //   59: getstatic 61	com/g/a/ao:e	Ljava/lang/String;
    //   62: invokevirtual 140	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic 145	com/g/a/ao$a:valueOf	(Ljava/lang/String;)Lcom/g/a/ao$a;
    //   68: putfield 85	com/g/a/ao:k	Lcom/g/a/ao$a;
    //   71: aload_1
    //   72: getstatic 65	com/g/a/ao:f	Ljava/lang/String;
    //   75: invokevirtual 137	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   78: ifeq +14 -> 92
    //   81: aload_0
    //   82: aload_1
    //   83: getstatic 65	com/g/a/ao:f	Ljava/lang/String;
    //   86: invokevirtual 149	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   89: putfield 151	com/g/a/ao:m	I
    //   92: aload_1
    //   93: getstatic 69	com/g/a/ao:g	Ljava/lang/String;
    //   96: invokevirtual 137	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   99: ifeq +14 -> 113
    //   102: aload_0
    //   103: aload_1
    //   104: getstatic 69	com/g/a/ao:g	Ljava/lang/String;
    //   107: invokevirtual 140	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: putfield 153	com/g/a/ao:n	Ljava/lang/String;
    //   113: aload_1
    //   114: getstatic 73	com/g/a/ao:h	Ljava/lang/String;
    //   117: invokevirtual 137	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   120: ifeq +14 -> 134
    //   123: aload_0
    //   124: aload_1
    //   125: getstatic 73	com/g/a/ao:h	Ljava/lang/String;
    //   128: invokevirtual 157	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   131: putfield 159	com/g/a/ao:o	Lorg/json/JSONObject;
    //   134: return
    //   135: astore_1
    //   136: aload_1
    //   137: invokestatic 165	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   140: return
    //   141: astore_1
    //   142: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	ao
    //   0	143	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   0	13	135	java/lang/Throwable
    //   17	47	141	java/lang/Throwable
    //   47	71	141	java/lang/Throwable
    //   71	92	141	java/lang/Throwable
    //   92	113	141	java/lang/Throwable
    //   113	134	141	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString, a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 171	com/g/a/i:setLastRoleName	(Ljava/lang/String;)V
    //   7: aconst_null
    //   8: putstatic 173	com/g/a/ao:p	Lorg/json/JSONObject;
    //   11: aload_0
    //   12: putstatic 77	com/g/a/ao:j	Ljava/lang/String;
    //   15: aload_0
    //   16: invokestatic 175	com/g/a/i:b	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_0
    //   20: aload_0
    //   21: ifnull +40 -> 61
    //   24: new 131	org/json/JSONObject
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 133	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   32: putstatic 173	com/g/a/ao:p	Lorg/json/JSONObject;
    //   35: aload_1
    //   36: invokestatic 177	com/g/a/ao:b	(Lcom/g/a/a;)V
    //   39: ldc 2
    //   41: monitorexit
    //   42: return
    //   43: astore_0
    //   44: iconst_1
    //   45: anewarray 106	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: aload_0
    //   51: invokevirtual 181	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   54: aastore
    //   55: invokestatic 187	com/g/a/h:dForInternal	([Ljava/lang/String;)V
    //   58: goto -19 -> 39
    //   61: new 131	org/json/JSONObject
    //   64: dup
    //   65: invokespecial 188	org/json/JSONObject:<init>	()V
    //   68: putstatic 173	com/g/a/ao:p	Lorg/json/JSONObject;
    //   71: invokestatic 190	com/g/a/ao:c	()V
    //   74: invokestatic 193	com/g/a/ao:e	()Ljava/util/Map;
    //   77: astore_0
    //   78: getstatic 49	com/g/a/ao:b	Ljava/lang/String;
    //   81: ldc -61
    //   83: aload_0
    //   84: aload_1
    //   85: invokestatic 197	com/g/a/ao:a	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lcom/g/a/a;)V
    //   88: invokestatic 202	com/g/a/bm:a	()Lcom/g/a/bm;
    //   91: new 131	org/json/JSONObject
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 205	org/json/JSONObject:<init>	(Ljava/util/Map;)V
    //   99: invokevirtual 209	com/g/a/bm:setSubaccount	(Lorg/json/JSONObject;)V
    //   102: goto -63 -> 39
    //   105: astore_0
    //   106: ldc 2
    //   108: monitorexit
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: goto -73 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramString	String
    //   0	115	1	parama	a
    // Exception table:
    //   from	to	target	type
    //   24	39	43	org/json/JSONException
    //   3	20	105	finally
    //   24	39	105	finally
    //   44	58	105	finally
    //   61	102	105	finally
    //   3	20	111	java/lang/Throwable
    //   24	39	111	java/lang/Throwable
    //   44	58	111	java/lang/Throwable
    //   61	102	111	java/lang/Throwable
  }
  
  private boolean a(Object paramObject)
  {
    if (paramObject != null) {
      try
      {
        boolean bool = ((Boolean)paramObject).booleanValue();
        return bool;
      }
      catch (Throwable paramObject) {}
    }
    return false;
  }
  
  private void b()
  {
    try
    {
      Map localMap = d();
      db.a locala = new db.a();
      locala.a.put("apiType", Integer.valueOf(9));
      locala.a.put("domain", b);
      locala.a.put("action", "update");
      locala.a.put("data", localMap);
      db.c().obtainMessage(102, locala).sendToTarget();
      bm.a().setAccount(new JSONObject(localMap));
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  private static void b(a parama)
  {
    try
    {
      Map localMap = e();
      bm.a().setSubaccount(new JSONObject(localMap));
      a(b, "roleUpdate", localMap, parama);
      return;
    }
    catch (Throwable parama)
    {
      av.postSDKError(parama);
    }
  }
  
  private static void c()
  {
    i.setLastRoleName(j);
    i.b(j, p.toString());
  }
  
  private Map d()
  {
    TreeMap localTreeMap = new TreeMap();
    try
    {
      localTreeMap.put(c, this.i);
      localTreeMap.put(f, Integer.valueOf(this.m));
      localTreeMap.put(e, this.k.name());
      if (this.l != null) {
        localTreeMap.put(d, this.l);
      }
      if (this.n != null) {
        localTreeMap.put(g, this.n);
      }
      if ((this.o != null) && (this.o.length() > 0)) {
        localTreeMap.put("custom", this.o);
      }
      return localTreeMap;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
    return localTreeMap;
  }
  
  private static Map e()
  {
    TreeMap localTreeMap = new TreeMap();
    try
    {
      localTreeMap.put("name", j);
      if ((p != null) && (p.length() > 0)) {
        localTreeMap.put("custom", p);
      }
      return localTreeMap;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
    return localTreeMap;
  }
  
  private static void f()
  {
    try
    {
      Map localMap = e();
      bm.a().setSubaccount(new JSONObject(localMap));
      b(null);
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 173	com/g/a/ao:p	Lorg/json/JSONObject;
    //   5: ifnonnull +13 -> 18
    //   8: new 131	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 188	org/json/JSONObject:<init>	()V
    //   15: putstatic 173	com/g/a/ao:p	Lorg/json/JSONObject;
    //   18: getstatic 173	com/g/a/ao:p	Lorg/json/JSONObject;
    //   21: aload_1
    //   22: iload_2
    //   23: invokevirtual 288	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   26: pop
    //   27: invokestatic 190	com/g/a/ao:c	()V
    //   30: invokestatic 290	com/g/a/ao:f	()V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    //   41: astore_1
    //   42: goto -9 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	ao
    //   0	45	1	paramString	String
    //   0	45	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	18	36	finally
    //   18	33	36	finally
    //   18	33	41	java/lang/Throwable
  }
  
  public void a(String paramString, Object paramObject1, Object paramObject2, a parama)
  {
    try
    {
      if ((a == null) || (a.i == null)) {
        a = new ao();
      }
      a.a(paramString);
      paramString = a.d();
      bm.a().setAccount(new JSONObject(paramString));
      a(paramObject2, paramObject1, paramString, parama);
      return;
    }
    catch (Throwable paramString)
    {
      av.postSDKError(paramString);
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 173	com/g/a/ao:p	Lorg/json/JSONObject;
    //   5: ifnonnull +13 -> 18
    //   8: new 131	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 188	org/json/JSONObject:<init>	()V
    //   15: putstatic 173	com/g/a/ao:p	Lorg/json/JSONObject;
    //   18: getstatic 173	com/g/a/ao:p	Lorg/json/JSONObject;
    //   21: aload_1
    //   22: aload_2
    //   23: invokevirtual 296	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   26: pop
    //   27: invokestatic 190	com/g/a/ao:c	()V
    //   30: invokestatic 290	com/g/a/ao:f	()V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    //   41: astore_1
    //   42: goto -9 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	ao
    //   0	45	1	paramString1	String
    //   0	45	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	18	36	finally
    //   18	33	36	finally
    //   18	33	41	java/lang/Throwable
  }
  
  /* Error */
  public void b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 159	com/g/a/ao:o	Lorg/json/JSONObject;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 131	org/json/JSONObject
    //   13: dup
    //   14: invokespecial 188	org/json/JSONObject:<init>	()V
    //   17: putfield 159	com/g/a/ao:o	Lorg/json/JSONObject;
    //   20: aload_0
    //   21: getfield 159	com/g/a/ao:o	Lorg/json/JSONObject;
    //   24: aload_1
    //   25: iload_2
    //   26: invokevirtual 288	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_0
    //   31: invokespecial 298	com/g/a/ao:b	()V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: goto -9 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	ao
    //   0	46	1	paramString	String
    //   0	46	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	20	37	finally
    //   20	34	37	finally
    //   20	34	42	java/lang/Throwable
  }
  
  /* Error */
  public void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 159	com/g/a/ao:o	Lorg/json/JSONObject;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 131	org/json/JSONObject
    //   13: dup
    //   14: invokespecial 188	org/json/JSONObject:<init>	()V
    //   17: putfield 159	com/g/a/ao:o	Lorg/json/JSONObject;
    //   20: aload_0
    //   21: getfield 159	com/g/a/ao:o	Lorg/json/JSONObject;
    //   24: aload_1
    //   25: aload_2
    //   26: invokevirtual 296	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_0
    //   31: invokespecial 298	com/g/a/ao:b	()V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: goto -9 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	ao
    //   0	46	1	paramString1	String
    //   0	46	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	20	37	finally
    //   20	34	37	finally
    //   20	34	42	java/lang/Throwable
  }
  
  public final void onTDEBEventAccount(db.a parama)
  {
    if (parama != null)
    {
      a locala;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      try
      {
        if (parama.a == null) {
          return;
        }
        if (Integer.parseInt(String.valueOf(parama.a.get("apiType"))) != 9) {
          return;
        }
        parama.a.get("account");
        locala = (a)parama.a.get("service");
        localObject1 = parama.a.get("data");
        localObject2 = parama.a.get("domain");
        localObject3 = parama.a.get("action");
        localObject4 = parama.a.get("immediate");
        if (localObject3 == null) {
          return;
        }
        if ((localObject3.equals("login")) || (localObject3.equals("register")) || (localObject3.equals("logout")))
        {
          a(String.valueOf(parama.a.get("accountId")), localObject3, localObject2, locala);
          return;
        }
      }
      catch (Throwable parama)
      {
        av.postSDKError(parama);
        return;
      }
      if (localObject3.equals("roleCreate"))
      {
        a(String.valueOf(parama.a.get("parameter")), locala);
        return;
      }
      a(localObject2, localObject3, localObject1, locala);
      if (a(localObject4)) {
        a(locala);
      }
    }
  }
  
  public void setAccountType(String paramString)
  {
    try
    {
      if ((this.n == null) || (!this.n.equalsIgnoreCase(paramString)))
      {
        this.n = paramString;
        b();
      }
      return;
    }
    catch (Throwable paramString)
    {
      av.postSDKError(paramString);
    }
  }
  
  public void setAge(int paramInt)
  {
    try
    {
      if (this.m != paramInt)
      {
        this.m = paramInt;
        b();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  public void setGender(a parama)
  {
    try
    {
      if (this.k != parama)
      {
        this.k = parama;
        b();
      }
      return;
    }
    catch (Throwable parama)
    {
      av.postSDKError(parama);
    }
  }
  
  public void setName(String paramString)
  {
    try
    {
      if ((this.l == null) || (!this.l.equalsIgnoreCase(paramString)))
      {
        this.l = paramString;
        b();
      }
      return;
    }
    catch (Throwable paramString)
    {
      av.postSDKError(paramString);
    }
  }
  
  public static enum a {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */