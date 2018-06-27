package com.mato.sdk.proxy;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.android.matoid.service.mtunnel.HttpHandler;
import com.mato.sdk.d.k;
import com.mato.sdk.d.m;
import com.mato.sdk.g.b;
import com.mato.sdk.g.i;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.Locale;

public final class f
{
  private static final String a = com.mato.sdk.b.g.b("");
  private static int b = 0;
  private static int c = 1;
  private static int d = 2;
  private static int e = 4;
  private static int f = 8;
  private static final Handler g = new Handler(Looper.getMainLooper());
  private static int h = -1;
  private static int i = 0;
  private static int j = 1;
  private static int k = 2;
  
  public static p a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new p("Unknown Service start error", paramInt);
    case 1: 
      return new p("Invalid libcom.maa.wspxld.so", -12);
    case 2: 
      return new p("Service start failed", -7);
    case 3: 
      return new p("Service start timeout", -8);
    }
    return new p("Create service config error", -15);
  }
  
  public static void a()
  {
    try
    {
      localField = Class.forName("java.net.URL").getDeclaredField("streamHandlers");
      str = localField.getType().getName();
      localField.setAccessible(true);
      localObject1 = localField.get(null);
      if (localObject1 == null) {
        return;
      }
      localObject2 = localObject1.getClass();
      if (!((Class)localObject2).getName().contains("qihoo360")) {
        return;
      }
      Log.d(com.mato.sdk.b.g.a, "Found URL is hijacked by 360");
      localObject2 = ((Class)localObject2).getDeclaredFields();
      n = localObject2.length;
      m = 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Field localField;
        String str;
        Object localObject1;
        Object localObject2;
        int n;
        int m;
        Object localObject3;
        return;
        m += 1;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      return;
    }
    catch (IllegalAccessException localIllegalAccessException) {}
    if (m < n)
    {
      localObject3 = localObject2[m];
      if (((Field)localObject3).getType().getName().equals(str))
      {
        Log.d(com.mato.sdk.b.g.a, "Found original streamHandlers");
        ((Field)localObject3).setAccessible(true);
        localField.set(null, ((Field)localObject3).get(localObject1));
        return;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    a(new Runnable()
    {
      public final void run()
      {
        n.a(this.a);
      }
    });
  }
  
  public static void a(Context paramContext, g paramg)
  {
    int m = 0;
    int n = paramg.a("wsg_support", -1);
    if (n == -1) {}
    try
    {
      if (Build.VERSION.SDK_INT < 14) {}
      for (;;)
      {
        paramg.b("wsg_support", m);
        return;
        if (BitmapFactory.decodeStream(paramContext.getAssets().open("has_alpha.wsg")) == null)
        {
          paramContext = BitmapFactory.decodeStream(paramContext.getAssets().open("no_alpha.wsg"));
          if (paramContext != null) {
            m = 1;
          }
        }
        else
        {
          m = 2;
        }
      }
      return;
    }
    catch (IOException paramContext) {}
  }
  
  private static void a(Context paramContext, String paramString)
  {
    a(new Runnable()
    {
      public final void run()
      {
        Toast localToast = Toast.makeText(this.a, this.b, 1);
        if (!(localToast instanceof Toast))
        {
          localToast.show();
          return;
        }
        VdsAgent.showToast((Toast)localToast);
      }
    });
  }
  
  private static void a(Context paramContext, final String paramString, final int paramInt)
  {
    paramContext = new Runnable()
    {
      public final void run()
      {
        n.a(this.a, paramString, paramInt);
      }
    };
    a(paramContext);
    a(paramContext, 1000L);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
    throws p
  {
    int m = HttpHandler.a(paramContext, paramBoolean);
    if (m != 0) {
      throw new p("load wsld failed, error code: " + String.valueOf(m), -2);
    }
  }
  
  public static void a(d paramd)
  {
    a(paramd, "Authentication successful");
  }
  
  public static void a(d paramd, String paramString)
  {
    com.mato.sdk.d.g localg = paramd.i();
    if ((!localg.f()) || (localg.d()) || (localg.e())) {}
    for (int m = 0; m == 0; m = 1) {
      return;
    }
    a(new Runnable()
    {
      public final void run()
      {
        Toast localToast = Toast.makeText(this.a, this.b, 1);
        if (!(localToast instanceof Toast))
        {
          localToast.show();
          return;
        }
        VdsAgent.showToast((Toast)localToast);
      }
    });
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (i.c())
    {
      paramRunnable.run();
      return;
    }
    g.post(paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    g.postDelayed(paramRunnable, 1000L);
  }
  
  public static boolean a(Context paramContext, k paramk)
  {
    String str = i.k(paramContext);
    if (!i.g(paramContext).equals(str)) {}
    for (;;)
    {
      return false;
      if ((paramk != null) && (paramk.d())) {}
      for (int m = 1; m != 0; m = 0) {
        return true;
      }
    }
  }
  
  public static boolean a(Context paramContext, m paramm)
  {
    String str = i.k(paramContext);
    if (!i.g(paramContext).equals(str)) {}
    for (;;)
    {
      return false;
      if ((paramm != null) && (paramm.c())) {}
      for (int m = 1; m != 0; m = 0) {
        return true;
      }
    }
  }
  
  private static boolean a(com.mato.sdk.d.g paramg)
  {
    return (paramg.f()) && (!paramg.d()) && (!paramg.e());
  }
  
  public static boolean a(String paramString)
  {
    File[] arrayOfFile = new File(paramString).listFiles(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.startsWith("access.log");
      }
    });
    if (arrayOfFile == null) {
      return true;
    }
    int n = arrayOfFile.length;
    int m = 0;
    label33:
    if (m < n)
    {
      paramString = arrayOfFile[m];
      boolean bool = paramString.delete();
      paramString.getName();
      if (!bool) {
        break label68;
      }
    }
    label68:
    for (paramString = "success";; paramString = "failed")
    {
      m += 1;
      break label33;
      break;
    }
  }
  
  public static String b(Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = "";
    Object localObject3 = i.n(paramContext);
    Object localObject2 = localObject1;
    if (paramBoolean)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = (String)localObject3 + File.separator + "com.maa.sdk" + File.separator + i.g(paramContext);
      }
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = i.c(paramContext) + File.separator + "com.maa.sdk";
    }
    localObject3 = i.k(paramContext);
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = localObject3;
      if (((String)localObject3).indexOf(":") != -1) {
        localObject2 = ((String)localObject3).replace(':', '_');
      }
      localObject3 = localObject2;
      if (((String)localObject2).startsWith(".")) {
        localObject3 = ((String)localObject2).replaceFirst(".", "_");
      }
      int m = ((String)localObject3).lastIndexOf(".");
      localObject2 = localObject3;
      if (m == ((String)localObject3).length() - 1)
      {
        localObject2 = ((String)localObject3).substring(0, m);
        localObject2 = (String)localObject2 + "_";
      }
      localObject3 = localObject2;
      if (!b.a((String)localObject2)) {
        localObject3 = m.a((String)localObject2);
      }
      localObject2 = localObject1;
      if (!paramContext.getPackageName().equals(localObject3)) {
        localObject2 = (String)localObject1 + File.separator + (String)localObject3;
      }
    }
    paramContext = new File((String)localObject2);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return (String)localObject2;
  }
  
  public static void b(Context paramContext)
    throws p
  {
    if (Build.VERSION.SDK_INT < 8) {
      throw new p("Only support Android 2.2 and above", -5);
    }
    if (!b()) {
      throw new p("Invalid localhost", -11);
    }
    if (i.j(paramContext)) {
      throw new p("3gwap does not support", -4);
    }
  }
  
  public static void b(d paramd)
  {
    a(paramd, "SDK terminated");
  }
  
  public static void b(d paramd, String paramString)
  {
    a(paramd, MessageFormat.format("Authentication failure({0})", new Object[] { paramString }));
  }
  
  /* Error */
  private static boolean b()
  {
    // Byte code:
    //   0: new 401	java/io/BufferedReader
    //   3: dup
    //   4: new 403	java/io/FileReader
    //   7: dup
    //   8: ldc_w 405
    //   11: invokespecial 406	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: sipush 1024
    //   17: invokespecial 409	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: invokevirtual 412	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnull +71 -> 100
    //   32: aload_2
    //   33: astore_1
    //   34: aload_3
    //   35: ldc_w 414
    //   38: invokevirtual 347	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   41: ifne -20 -> 21
    //   44: aload_2
    //   45: astore_1
    //   46: aload_3
    //   47: ldc_w 416
    //   50: invokevirtual 347	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   53: ifne -32 -> 21
    //   56: aload_2
    //   57: astore_1
    //   58: aload_3
    //   59: ldc_w 418
    //   62: invokevirtual 347	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   65: ifne -44 -> 21
    //   68: aload_2
    //   69: astore_1
    //   70: aload_3
    //   71: ldc_w 420
    //   74: invokevirtual 127	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   77: ifeq -56 -> 21
    //   80: aload_2
    //   81: astore_1
    //   82: aload_3
    //   83: ldc_w 422
    //   86: invokevirtual 127	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: istore_0
    //   90: iload_0
    //   91: ifeq -70 -> 21
    //   94: aload_2
    //   95: invokevirtual 425	java/io/BufferedReader:close	()V
    //   98: iconst_1
    //   99: ireturn
    //   100: aload_2
    //   101: invokevirtual 425	java/io/BufferedReader:close	()V
    //   104: iconst_0
    //   105: ireturn
    //   106: astore_3
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: astore_1
    //   111: aload_3
    //   112: invokevirtual 428	java/io/IOException:getMessage	()Ljava/lang/String;
    //   115: astore_3
    //   116: aload_3
    //   117: ifnull +38 -> 155
    //   120: aload_2
    //   121: astore_1
    //   122: aload_3
    //   123: ldc_w 430
    //   126: invokevirtual 127	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   129: ifeq +26 -> 155
    //   132: aload_2
    //   133: astore_1
    //   134: getstatic 128	com/mato/sdk/b/g:a	Ljava/lang/String;
    //   137: aload_3
    //   138: invokestatic 432	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   141: pop
    //   142: aload_2
    //   143: ifnull -45 -> 98
    //   146: aload_2
    //   147: invokevirtual 425	java/io/BufferedReader:close	()V
    //   150: iconst_1
    //   151: ireturn
    //   152: astore_1
    //   153: iconst_1
    //   154: ireturn
    //   155: aload_2
    //   156: ifnull +7 -> 163
    //   159: aload_2
    //   160: invokevirtual 425	java/io/BufferedReader:close	()V
    //   163: iconst_0
    //   164: ireturn
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 425	java/io/BufferedReader:close	()V
    //   176: aload_2
    //   177: athrow
    //   178: astore_1
    //   179: iconst_1
    //   180: ireturn
    //   181: astore_1
    //   182: goto -78 -> 104
    //   185: astore_1
    //   186: goto -23 -> 163
    //   189: astore_1
    //   190: goto -14 -> 176
    //   193: astore_2
    //   194: goto -26 -> 168
    //   197: astore_3
    //   198: goto -89 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   89	2	0	bool	boolean
    //   22	112	1	localBufferedReader1	java.io.BufferedReader
    //   152	1	1	localIOException1	IOException
    //   167	6	1	localObject1	Object
    //   178	1	1	localIOException2	IOException
    //   181	1	1	localIOException3	IOException
    //   185	1	1	localIOException4	IOException
    //   189	1	1	localIOException5	IOException
    //   20	140	2	localBufferedReader2	java.io.BufferedReader
    //   165	12	2	localObject2	Object
    //   193	1	2	localObject3	Object
    //   27	56	3	str1	String
    //   106	6	3	localIOException6	IOException
    //   115	23	3	str2	String
    //   197	1	3	localIOException7	IOException
    // Exception table:
    //   from	to	target	type
    //   0	21	106	java/io/IOException
    //   146	150	152	java/io/IOException
    //   0	21	165	finally
    //   94	98	178	java/io/IOException
    //   100	104	181	java/io/IOException
    //   159	163	185	java/io/IOException
    //   172	176	189	java/io/IOException
    //   23	28	193	finally
    //   34	44	193	finally
    //   46	56	193	finally
    //   58	68	193	finally
    //   70	80	193	finally
    //   82	90	193	finally
    //   111	116	193	finally
    //   122	132	193	finally
    //   134	142	193	finally
    //   23	28	197	java/io/IOException
    //   34	44	197	java/io/IOException
    //   46	56	197	java/io/IOException
    //   58	68	197	java/io/IOException
    //   70	80	197	java/io/IOException
    //   82	90	197	java/io/IOException
  }
  
  private static int c(Context paramContext)
    throws IOException
  {
    if (Build.VERSION.SDK_INT < 14) {}
    do
    {
      return 0;
      if (BitmapFactory.decodeStream(paramContext.getAssets().open("has_alpha.wsg")) != null) {
        break;
      }
    } while (BitmapFactory.decodeStream(paramContext.getAssets().open("no_alpha.wsg")) == null);
    return 1;
    return 2;
  }
  
  public static void c(d paramd)
  {
    if (paramd.j()) {}
    for (String str = "Acceleration mode";; str = "Origin mode")
    {
      a(paramd, str);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */