package com.g.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class w
{
  /* Error */
  public static List a()
  {
    // Byte code:
    //   0: new 12	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 16	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: new 18	java/io/File
    //   12: dup
    //   13: ldc 20
    //   15: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 27	java/io/File:listFiles	()[Ljava/io/File;
    //   21: astore 5
    //   23: aload 5
    //   25: arraylength
    //   26: istore_1
    //   27: iconst_0
    //   28: istore_0
    //   29: iload_0
    //   30: iload_1
    //   31: if_icmpge +115 -> 146
    //   34: aload 5
    //   36: iload_0
    //   37: aaload
    //   38: astore 6
    //   40: aload 6
    //   42: invokevirtual 31	java/io/File:isDirectory	()Z
    //   45: istore_3
    //   46: iload_3
    //   47: ifeq +104 -> 151
    //   50: aload 6
    //   52: invokevirtual 35	java/io/File:getName	()Ljava/lang/String;
    //   55: invokestatic 41	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   58: istore_2
    //   59: new 43	com/g/a/e
    //   62: dup
    //   63: iconst_m1
    //   64: invokespecial 46	com/g/a/e:<init>	(I)V
    //   67: astore 6
    //   69: aload 6
    //   71: getfield 50	com/g/a/e:b	I
    //   74: sipush 1000
    //   77: if_icmplt +17 -> 94
    //   80: aload 6
    //   82: getfield 50	com/g/a/e:b	I
    //   85: sipush 9999
    //   88: if_icmpgt +6 -> 94
    //   91: goto +60 -> 151
    //   94: aload 6
    //   96: getfield 54	com/g/a/e:c	Ljava/lang/String;
    //   99: ldc 56
    //   101: invokevirtual 62	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: ifne +47 -> 151
    //   107: aload 6
    //   109: getfield 54	com/g/a/e:c	Ljava/lang/String;
    //   112: ldc 64
    //   114: invokevirtual 62	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   117: ifne +34 -> 151
    //   120: aload 4
    //   122: new 43	com/g/a/e
    //   125: dup
    //   126: iload_2
    //   127: invokespecial 46	com/g/a/e:<init>	(I)V
    //   130: invokeinterface 70 2 0
    //   135: pop
    //   136: goto +15 -> 151
    //   139: astore 6
    //   141: goto +10 -> 151
    //   144: astore 5
    //   146: aload 4
    //   148: areturn
    //   149: astore 6
    //   151: iload_0
    //   152: iconst_1
    //   153: iadd
    //   154: istore_0
    //   155: goto -126 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   28	127	0	i	int
    //   26	6	1	j	int
    //   58	69	2	k	int
    //   45	2	3	bool	boolean
    //   7	140	4	localArrayList	ArrayList
    //   21	14	5	arrayOfFile	java.io.File[]
    //   144	1	5	localThrowable1	Throwable
    //   38	70	6	localObject	Object
    //   139	1	6	localThrowable2	Throwable
    //   149	1	6	localNumberFormatException	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   59	91	139	java/lang/Throwable
    //   94	136	139	java/lang/Throwable
    //   9	27	144	java/lang/Throwable
    //   40	46	144	java/lang/Throwable
    //   50	59	144	java/lang/Throwable
    //   50	59	149	java/lang/NumberFormatException
  }
  
  /* Error */
  public static List a(Context paramContext)
  {
    // Byte code:
    //   0: new 12	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 16	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: new 18	java/io/File
    //   12: dup
    //   13: ldc 20
    //   15: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 27	java/io/File:listFiles	()[Ljava/io/File;
    //   21: astore 6
    //   23: aload_0
    //   24: invokevirtual 78	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   27: pop
    //   28: aload 6
    //   30: arraylength
    //   31: istore_2
    //   32: iconst_0
    //   33: istore_1
    //   34: iload_1
    //   35: iload_2
    //   36: if_icmpge +107 -> 143
    //   39: aload 6
    //   41: iload_1
    //   42: aaload
    //   43: astore_0
    //   44: aload_0
    //   45: invokevirtual 31	java/io/File:isDirectory	()Z
    //   48: istore 4
    //   50: iload 4
    //   52: ifeq +95 -> 147
    //   55: aload_0
    //   56: invokevirtual 35	java/io/File:getName	()Ljava/lang/String;
    //   59: invokestatic 41	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: istore_3
    //   63: new 43	com/g/a/e
    //   66: dup
    //   67: iload_3
    //   68: invokespecial 46	com/g/a/e:<init>	(I)V
    //   71: astore_0
    //   72: aload_0
    //   73: getfield 81	com/g/a/e:a	Z
    //   76: ifne +6 -> 82
    //   79: goto +68 -> 147
    //   82: aload_0
    //   83: getfield 50	com/g/a/e:b	I
    //   86: sipush 1000
    //   89: if_icmplt +13 -> 102
    //   92: aload_0
    //   93: getfield 50	com/g/a/e:b	I
    //   96: sipush 9999
    //   99: if_icmple +48 -> 147
    //   102: aload_0
    //   103: getfield 54	com/g/a/e:c	Ljava/lang/String;
    //   106: ldc 56
    //   108: invokevirtual 62	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   111: ifne +36 -> 147
    //   114: aload_0
    //   115: getfield 54	com/g/a/e:c	Ljava/lang/String;
    //   118: ldc 64
    //   120: invokevirtual 62	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   123: ifne +24 -> 147
    //   126: aload 5
    //   128: aload_0
    //   129: invokeinterface 70 2 0
    //   134: pop
    //   135: goto +12 -> 147
    //   138: astore_0
    //   139: goto +8 -> 147
    //   142: astore_0
    //   143: aload 5
    //   145: areturn
    //   146: astore_0
    //   147: iload_1
    //   148: iconst_1
    //   149: iadd
    //   150: istore_1
    //   151: goto -117 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramContext	Context
    //   33	118	1	i	int
    //   31	6	2	j	int
    //   62	6	3	k	int
    //   48	3	4	bool	boolean
    //   7	137	5	localArrayList	ArrayList
    //   21	19	6	arrayOfFile	java.io.File[]
    // Exception table:
    //   from	to	target	type
    //   63	79	138	java/lang/Throwable
    //   82	102	138	java/lang/Throwable
    //   102	135	138	java/lang/Throwable
    //   9	32	142	java/lang/Throwable
    //   44	50	142	java/lang/Throwable
    //   55	63	142	java/lang/Throwable
    //   55	63	146	java/lang/NumberFormatException
  }
  
  public static List b(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 22)
      {
        Object localObject = a();
        paramContext = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          e locale = (e)((Iterator)localObject).next();
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo(locale.c, locale.d, null);
          localRunningAppProcessInfo.uid = locale.b;
          paramContext.add(localRunningAppProcessInfo);
        }
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      return null;
    }
    return paramContext;
  }
  
  public static boolean b()
  {
    try
    {
      Object localObject = a();
      int i = Process.myPid();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        e locale = (e)((Iterator)localObject).next();
        if (locale.d == i)
        {
          boolean bool = locale.a;
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/g/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */