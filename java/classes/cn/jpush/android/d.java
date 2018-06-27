package cn.jpush.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import cn.jiguang.api.SdkType;
import cn.jpush.android.c.f;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
{
  public static final String a;
  public static int b;
  public static String c;
  public static String d;
  public static Context e;
  public static boolean f;
  private static AtomicBoolean g;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[6];
    int j = 0;
    Object localObject2 = "!+'h2!!4),=+?`0/iqy2-$\"l~+-4j5h<>|,h(0g7. \"}~+*?o7/6";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 94;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "\002\025$z6\017)>k?$";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = ")&%`1&8g7<e|)\r-7'`=-";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "% %h:)103~\013$?)0'1qn;<e\020y.$,2h*!*?)7+*?%~1*$))!)=)<-e?f*h$3e;h1>)- *&)0'18o7+$%`1&e5|;h1>)*  qh.8)8j?<,>g~!&>g~!6qg+$)";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\002\025$z6h&0g0'1qk;h,?`*!$=`$-!qj1%5=l*-)():= q}1h\013\004E\022h$!y\027&#>'";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\035+4q.-&%l:re7h7$ 5)*'e6l*h&${,-+%)?85=`=)18f0h,?o1";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = SdkType.JPUSH.name();
        g = new AtomicBoolean(false);
        f = false;
        return;
        i = 72;
        continue;
        i = 69;
        continue;
        i = 81;
        continue;
        i = 9;
      }
    }
  }
  
  /* Error */
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 66	cn/jpush/android/d:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   8: invokevirtual 74	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +8 -> 21
    //   16: ldc 2
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: aload_0
    //   22: invokestatic 78	cn/jpush/android/c/a:e	(Landroid/content/Context;)Z
    //   25: ifne +21 -> 46
    //   28: getstatic 48	cn/jpush/android/d:z	[Ljava/lang/String;
    //   31: iconst_1
    //   32: aaload
    //   33: getstatic 48	cn/jpush/android/d:z	[Ljava/lang/String;
    //   36: iconst_0
    //   37: aaload
    //   38: invokestatic 83	cn/jpush/android/c/f:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iconst_0
    //   42: istore_1
    //   43: goto -27 -> 16
    //   46: getstatic 48	cn/jpush/android/d:z	[Ljava/lang/String;
    //   49: iconst_1
    //   50: aaload
    //   51: getstatic 48	cn/jpush/android/d:z	[Ljava/lang/String;
    //   54: iconst_2
    //   55: aaload
    //   56: invokestatic 85	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: invokevirtual 90	android/content/Context:getPackageName	()Ljava/lang/String;
    //   63: putstatic 92	cn/jpush/android/d:c	Ljava/lang/String;
    //   66: aload_0
    //   67: invokevirtual 96	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   70: putstatic 98	cn/jpush/android/d:e	Landroid/content/Context;
    //   73: aload_0
    //   74: invokestatic 101	cn/jpush/android/d:b	(Landroid/content/Context;)Landroid/content/pm/ApplicationInfo;
    //   77: astore_3
    //   78: aload_3
    //   79: ifnonnull +21 -> 100
    //   82: getstatic 48	cn/jpush/android/d:z	[Ljava/lang/String;
    //   85: iconst_1
    //   86: aaload
    //   87: getstatic 48	cn/jpush/android/d:z	[Ljava/lang/String;
    //   90: iconst_4
    //   91: aaload
    //   92: invokestatic 104	cn/jpush/android/c/f:j	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: iconst_0
    //   96: istore_1
    //   97: goto -81 -> 16
    //   100: aload_3
    //   101: getfield 109	android/content/pm/ApplicationInfo:icon	I
    //   104: putstatic 111	cn/jpush/android/d:b	I
    //   107: getstatic 111	cn/jpush/android/d:b	I
    //   110: ifne +16 -> 126
    //   113: getstatic 48	cn/jpush/android/d:z	[Ljava/lang/String;
    //   116: iconst_1
    //   117: aaload
    //   118: getstatic 48	cn/jpush/android/d:z	[Ljava/lang/String;
    //   121: iconst_3
    //   122: aaload
    //   123: invokestatic 104	cn/jpush/android/c/f:j	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_0
    //   127: invokevirtual 115	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   130: aload_3
    //   131: invokevirtual 121	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   134: invokeinterface 126 1 0
    //   139: putstatic 128	cn/jpush/android/d:d	Ljava/lang/String;
    //   142: aload_0
    //   143: iconst_0
    //   144: invokestatic 134	cn/jiguang/api/JCoreInterface:init	(Landroid/content/Context;Z)Z
    //   147: ifne +8 -> 155
    //   150: iconst_0
    //   151: istore_1
    //   152: goto -136 -> 16
    //   155: getstatic 66	cn/jpush/android/d:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   158: iconst_1
    //   159: invokevirtual 137	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   162: goto -146 -> 16
    //   165: astore_0
    //   166: ldc 2
    //   168: monitorexit
    //   169: aload_0
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramContext	Context
    //   1	151	1	bool1	boolean
    //   11	2	2	bool2	boolean
    //   77	54	3	localApplicationInfo	ApplicationInfo
    // Exception table:
    //   from	to	target	type
    //   5	12	165	finally
    //   21	41	165	finally
    //   46	78	165	finally
    //   82	95	165	finally
    //   100	126	165	finally
    //   126	150	165	finally
    //   155	162	165	finally
  }
  
  private static ApplicationInfo b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      f.e(z[1], z[5], paramContext);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */