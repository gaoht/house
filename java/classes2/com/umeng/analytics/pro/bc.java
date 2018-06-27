package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.AnalyticsConfig;
import java.io.File;
import org.json.JSONObject;

public class bc
{
  private static final int a = 1;
  private static final int b = 2;
  private static final int c = 3;
  private static Context g;
  private ad d;
  private af e;
  private final int f = 1;
  private be h;
  private aw i;
  private JSONObject j;
  private boolean k = false;
  private boolean l;
  
  public bc(Context paramContext, be parambe)
  {
    this.d = ad.a(paramContext);
    this.e = af.a(paramContext);
    g = paramContext;
    this.h = parambe;
    this.i = new aw(paramContext);
    this.i.a(this.h);
  }
  
  private int a(byte[] paramArrayOfByte)
  {
    bp localbp = new bp();
    cj localcj = new cj(new cy.a());
    try
    {
      localcj.a(localbp, paramArrayOfByte);
      if (localbp.a == 1)
      {
        this.e.b(localbp.i());
        this.e.d();
      }
      by.c("send log:" + localbp.f());
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;) {}
    }
    if (localbp.a == 1) {
      return 2;
    }
    return 3;
  }
  
  private void b()
  {
    cc.a(g).i().a(new cc.b()
    {
      public void a(File paramAnonymousFile) {}
      
      /* Error */
      public boolean b(File paramAnonymousFile)
      {
        // Byte code:
        //   0: new 26	java/io/FileInputStream
        //   3: dup
        //   4: aload_1
        //   5: invokespecial 28	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   8: astore_3
        //   9: aload_3
        //   10: invokestatic 33	com/umeng/analytics/pro/bw:b	(Ljava/io/InputStream;)[B
        //   13: astore_1
        //   14: aload_3
        //   15: invokestatic 37	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
        //   18: aload_0
        //   19: getfield 17	com/umeng/analytics/pro/bc$1:a	Lcom/umeng/analytics/pro/bc;
        //   22: invokestatic 40	com/umeng/analytics/pro/bc:a	(Lcom/umeng/analytics/pro/bc;)Lcom/umeng/analytics/pro/aw;
        //   25: aload_1
        //   26: invokevirtual 45	com/umeng/analytics/pro/aw:a	([B)[B
        //   29: astore_1
        //   30: aload_1
        //   31: ifnonnull +23 -> 54
        //   34: iconst_1
        //   35: istore_2
        //   36: aload_0
        //   37: getfield 17	com/umeng/analytics/pro/bc$1:a	Lcom/umeng/analytics/pro/bc;
        //   40: invokestatic 48	com/umeng/analytics/pro/bc:b	(Lcom/umeng/analytics/pro/bc;)Z
        //   43: ifeq +23 -> 66
        //   46: iconst_1
        //   47: ireturn
        //   48: aload_3
        //   49: invokestatic 37	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
        //   52: aload_1
        //   53: athrow
        //   54: aload_0
        //   55: getfield 17	com/umeng/analytics/pro/bc$1:a	Lcom/umeng/analytics/pro/bc;
        //   58: aload_1
        //   59: invokestatic 51	com/umeng/analytics/pro/bc:a	(Lcom/umeng/analytics/pro/bc;[B)I
        //   62: istore_2
        //   63: goto -27 -> 36
        //   66: iload_2
        //   67: iconst_1
        //   68: if_icmpne +9 -> 77
        //   71: iconst_0
        //   72: ireturn
        //   73: astore_1
        //   74: goto -26 -> 48
        //   77: iconst_1
        //   78: ireturn
        //   79: astore_1
        //   80: aconst_null
        //   81: astore_3
        //   82: goto -34 -> 48
        //   85: astore_1
        //   86: iconst_0
        //   87: ireturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	1
        //   0	88	1	paramAnonymousFile	File
        //   35	34	2	i	int
        //   8	74	3	localFileInputStream	java.io.FileInputStream
        // Exception table:
        //   from	to	target	type
        //   9	14	73	finally
        //   0	9	79	finally
        //   14	30	85	java/lang/Exception
        //   36	46	85	java/lang/Exception
        //   48	54	85	java/lang/Exception
        //   54	63	85	java/lang/Exception
      }
      
      public void c(File paramAnonymousFile)
      {
        bc.c(bc.this).k();
      }
    });
  }
  
  private void c()
  {
    int m;
    label217:
    label218:
    try
    {
      this.d.a();
      try
      {
        Object localObject1 = this.d.b();
        localObject1 = Base64.encodeToString(new cp().a((cg)localObject1), 0);
        Object localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = this.j.getJSONObject("header");
          ((JSONObject)localObject2).put("id_tracking", localObject1);
          this.j.put("header", localObject2);
        }
        localObject1 = String.valueOf(this.j).getBytes();
        if (localObject1 == null) {
          return;
        }
        if (!bt.a(g, (byte[])localObject1))
        {
          if (!this.k) {}
          for (localObject1 = aa.a(g, AnalyticsConfig.getAppkey(g), (byte[])localObject1);; localObject1 = aa.b(g, AnalyticsConfig.getAppkey(g), (byte[])localObject1))
          {
            localObject1 = ((aa)localObject1).c();
            cc.a(g).g();
            localObject2 = this.i.a((byte[])localObject1);
            if (localObject2 != null) {
              break;
            }
            m = 1;
            break label218;
            if (this.l) {
              break label217;
            }
            cc.a(g).a((byte[])localObject1);
            return;
          }
          m = a((byte[])localObject2);
          break label218;
          this.d.d();
          this.h.k();
          return;
          this.h.k();
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      return;
    }
    catch (Throwable localThrowable) {}
    switch (m)
    {
    }
    return;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 165	com/umeng/analytics/pro/bc:j	Lorg/json/JSONObject;
    //   4: ifnull +147 -> 151
    //   7: aload_0
    //   8: invokespecial 224	com/umeng/analytics/pro/bc:c	()V
    //   11: getstatic 54	com/umeng/analytics/pro/bc:g	Landroid/content/Context;
    //   14: invokestatic 229	com/umeng/analytics/pro/bv:k	(Landroid/content/Context;)Z
    //   17: ifeq +133 -> 150
    //   20: getstatic 54	com/umeng/analytics/pro/bc:g	Landroid/content/Context;
    //   23: invokestatic 234	com/umeng/analytics/pro/ba:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   26: astore 6
    //   28: aload 6
    //   30: ifnull +211 -> 241
    //   33: aload 6
    //   35: ldc -20
    //   37: ldc -18
    //   39: invokeinterface 244 3 0
    //   44: astore 7
    //   46: invokestatic 250	java/lang/System:currentTimeMillis	()J
    //   49: invokestatic 255	com/umeng/analytics/pro/q:b	(J)J
    //   52: lstore_2
    //   53: aload 7
    //   55: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +92 -> 150
    //   61: aload 6
    //   63: ldc_w 257
    //   66: ldc2_w 258
    //   69: invokeinterface 263 4 0
    //   74: lstore 4
    //   76: aload 6
    //   78: ldc_w 265
    //   81: iconst_0
    //   82: invokeinterface 269 3 0
    //   87: istore_1
    //   88: lload 4
    //   90: ldc2_w 258
    //   93: lcmp
    //   94: ifne +69 -> 163
    //   97: aload 6
    //   99: invokeinterface 273 1 0
    //   104: ldc_w 265
    //   107: iload_1
    //   108: iconst_1
    //   109: iadd
    //   110: invokeinterface 279 3 0
    //   115: invokeinterface 283 1 0
    //   120: pop
    //   121: aload_0
    //   122: getfield 63	com/umeng/analytics/pro/bc:i	Lcom/umeng/analytics/pro/aw;
    //   125: invokevirtual 284	com/umeng/analytics/pro/aw:a	()V
    //   128: aload 6
    //   130: invokeinterface 273 1 0
    //   135: ldc_w 257
    //   138: lload_2
    //   139: invokeinterface 288 4 0
    //   144: invokeinterface 283 1 0
    //   149: pop
    //   150: return
    //   151: aload_0
    //   152: invokespecial 290	com/umeng/analytics/pro/bc:b	()V
    //   155: goto -144 -> 11
    //   158: astore 6
    //   160: goto -149 -> 11
    //   163: lload_2
    //   164: lload 4
    //   166: lcmp
    //   167: ifeq +35 -> 202
    //   170: aload 6
    //   172: invokeinterface 273 1 0
    //   177: ldc_w 265
    //   180: iconst_1
    //   181: invokeinterface 279 3 0
    //   186: invokeinterface 283 1 0
    //   191: pop
    //   192: aload_0
    //   193: getfield 63	com/umeng/analytics/pro/bc:i	Lcom/umeng/analytics/pro/aw;
    //   196: invokevirtual 284	com/umeng/analytics/pro/aw:a	()V
    //   199: goto -71 -> 128
    //   202: iload_1
    //   203: iconst_2
    //   204: if_icmpge -76 -> 128
    //   207: aload 6
    //   209: invokeinterface 273 1 0
    //   214: ldc_w 265
    //   217: iload_1
    //   218: iconst_1
    //   219: iadd
    //   220: invokeinterface 279 3 0
    //   225: invokeinterface 283 1 0
    //   230: pop
    //   231: aload_0
    //   232: getfield 63	com/umeng/analytics/pro/bc:i	Lcom/umeng/analytics/pro/aw;
    //   235: invokevirtual 284	com/umeng/analytics/pro/aw:a	()V
    //   238: goto -110 -> 128
    //   241: aload_0
    //   242: getfield 63	com/umeng/analytics/pro/bc:i	Lcom/umeng/analytics/pro/aw;
    //   245: invokevirtual 284	com/umeng/analytics/pro/aw:a	()V
    //   248: return
    //   249: astore 6
    //   251: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	bc
    //   87	133	1	m	int
    //   52	112	2	l1	long
    //   74	91	4	l2	long
    //   26	103	6	localSharedPreferences	android.content.SharedPreferences
    //   158	50	6	localThrowable1	Throwable
    //   249	1	6	localThrowable2	Throwable
    //   44	10	7	str	String
    // Exception table:
    //   from	to	target	type
    //   0	11	158	java/lang/Throwable
    //   151	155	158	java/lang/Throwable
    //   11	28	249	java/lang/Throwable
    //   33	88	249	java/lang/Throwable
    //   97	128	249	java/lang/Throwable
    //   128	150	249	java/lang/Throwable
    //   170	199	249	java/lang/Throwable
    //   207	238	249	java/lang/Throwable
    //   241	248	249	java/lang/Throwable
  }
  
  public void a(az paramaz)
  {
    this.e.a(paramaz);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.j = paramJSONObject;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */