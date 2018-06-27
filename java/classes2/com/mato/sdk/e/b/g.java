package com.mato.sdk.e.b;

import com.mato.sdk.e.b.a.e;
import com.mato.sdk.e.b.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  private static final String v = com.mato.sdk.b.g.b("");
  public boolean a = true;
  public boolean b = true;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "Unknown";
  public String g = "";
  public String h = "";
  public String i = "";
  public List<String> j = new ArrayList();
  public String k = "";
  public String l = "";
  public String m = "";
  public List<a> n = new ArrayList();
  public List<com.mato.sdk.e.b.b.c> o = new ArrayList();
  public List<e> p = new ArrayList();
  public int q = 0;
  public int r = 0;
  public int s = 0;
  public int t = 0;
  public c u;
  private String w = "";
  private String x = "";
  private String y = "";
  
  private static JSONArray a(List<? extends j> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      j localj = (j)paramList.next();
      try
      {
        localJSONArray.put(localj.a());
      }
      catch (Exception localException) {}
    }
    return localJSONArray;
  }
  
  private static JSONArray b(List<String> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramList == null) {
      return localJSONArray;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      try
      {
        localJSONArray.put(str);
      }
      catch (Exception localException) {}
    }
    return localJSONArray;
  }
  
  private JSONObject b()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("masp", a(this.o));
    if (!this.n.isEmpty()) {
      localJSONObject.put("node", ((a)this.n.get(0)).b.a());
    }
    return localJSONObject;
  }
  
  private JSONArray c()
    throws JSONException
  {
    Object localObject = this.p;
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localJSONArray.put(((e)((Iterator)localObject).next()).a());
    }
    return localJSONArray;
  }
  
  public final String a()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("mid", this.c);
    localJSONObject.put("imsi", this.d);
    localJSONObject.put("imei", this.e);
    localJSONObject.put("networkType", this.f);
    localJSONObject.put("dns", this.g);
    localJSONObject.put("apn", this.h);
    localJSONObject.put("localhost", this.i);
    localJSONObject.put("ifconfig", b(this.j));
    localJSONObject.put("platform", this.y);
    localJSONObject.put("model", this.x);
    localJSONObject.put("sdkVersion", this.w);
    localJSONObject.put("appVersion", this.k);
    Object localObject;
    if (this.a)
    {
      localJSONObject.put("use_maa", "yes");
      if (this.b)
      {
        localObject = "yes";
        localJSONObject.put("accelerate", localObject);
      }
    }
    for (;;)
    {
      localJSONObject.put("url_detect_info", c());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("masp", a(this.o));
      if (!this.n.isEmpty()) {
        ((JSONObject)localObject).put("node", ((a)this.n.get(0)).b.a());
      }
      localJSONObject.put("ping_info", localObject);
      return localJSONObject.toString();
      localObject = this.m;
      break;
      localJSONObject.put("use_maa", this.l);
    }
  }
  
  public final void a(c paramc)
  {
    this.u = paramc;
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 266	java/io/File
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 267	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 271	java/io/File:getParentFile	()Ljava/io/File;
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 274	java/io/File:exists	()Z
    //   22: ifne +13 -> 35
    //   25: aload 4
    //   27: invokevirtual 277	java/io/File:mkdirs	()Z
    //   30: ifne +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_1
    //   36: invokevirtual 274	java/io/File:exists	()Z
    //   39: istore_2
    //   40: iload_2
    //   41: ifne +12 -> 53
    //   44: aload_1
    //   45: invokevirtual 280	java/io/File:createNewFile	()Z
    //   48: istore_2
    //   49: iload_2
    //   50: ifeq +92 -> 142
    //   53: aload_0
    //   54: invokevirtual 282	com/mato/sdk/e/b/g:a	()Ljava/lang/String;
    //   57: astore 4
    //   59: new 284	java/io/FileOutputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 287	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore_1
    //   68: aload_1
    //   69: aload 4
    //   71: ldc_w 289
    //   74: invokevirtual 293	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   77: invokevirtual 297	java/io/FileOutputStream:write	([B)V
    //   80: aload_1
    //   81: invokevirtual 300	java/io/FileOutputStream:close	()V
    //   84: iconst_1
    //   85: ireturn
    //   86: astore 4
    //   88: iconst_0
    //   89: istore_2
    //   90: goto -41 -> 49
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: ifnull +45 -> 142
    //   100: aload_1
    //   101: invokevirtual 300	java/io/FileOutputStream:close	()V
    //   104: iconst_0
    //   105: ireturn
    //   106: astore_1
    //   107: iconst_0
    //   108: ireturn
    //   109: astore_1
    //   110: aload_3
    //   111: ifnull +7 -> 118
    //   114: aload_3
    //   115: invokevirtual 300	java/io/FileOutputStream:close	()V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: goto -37 -> 84
    //   124: astore_3
    //   125: goto -7 -> 118
    //   128: astore 4
    //   130: aload_1
    //   131: astore_3
    //   132: aload 4
    //   134: astore_1
    //   135: goto -25 -> 110
    //   138: astore_3
    //   139: goto -43 -> 96
    //   142: iconst_0
    //   143: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	g
    //   0	144	1	paramString	String
    //   39	51	2	bool	boolean
    //   1	114	3	localObject1	Object
    //   124	1	3	localIOException1	java.io.IOException
    //   131	1	3	str	String
    //   138	1	3	localThrowable	Throwable
    //   15	55	4	localObject2	Object
    //   86	1	4	localIOException2	java.io.IOException
    //   128	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   44	49	86	java/io/IOException
    //   2	33	93	java/lang/Throwable
    //   35	40	93	java/lang/Throwable
    //   44	49	93	java/lang/Throwable
    //   53	68	93	java/lang/Throwable
    //   100	104	106	java/io/IOException
    //   2	33	109	finally
    //   35	40	109	finally
    //   44	49	109	finally
    //   53	68	109	finally
    //   80	84	120	java/io/IOException
    //   114	118	124	java/io/IOException
    //   68	80	128	finally
    //   68	80	138	java/lang/Throwable
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */