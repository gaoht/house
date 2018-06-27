package com.mato.sdk.c.d;

import android.os.Build.VERSION;
import com.mato.sdk.d.k;
import com.mato.sdk.proxy.g;
import com.mato.sdk.proxy.p;
import java.util.Locale;

public class e
{
  private static final int a = 1;
  private static final int b = 2;
  private static final int c = 3;
  private static final int d = 4;
  private static final int e = 5;
  private static final int f = 6;
  private static final int g = 7;
  private static final int h = -1;
  private final Throwable i;
  private final g j;
  
  private e()
  {
    throw new AssertionError();
  }
  
  e(Throwable paramThrowable, g paramg)
  {
    this.i = paramThrowable;
    this.j = paramg;
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException("The length of source array must be greater than 0.");
    }
    return ((Integer)a(k.a(paramArrayOfInt), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramBoolean)).intValue();
  }
  
  private static long a(long[] paramArrayOfLong, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramArrayOfLong.length == 0) {
      throw new IllegalArgumentException("The length of source array must be greater than 0.");
    }
    return ((Long)a(k.a(paramArrayOfLong), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramBoolean)).longValue();
  }
  
  private a.a a(p paramp)
  {
    int k = 2;
    Object localObject;
    switch (paramp.a())
    {
    case -9: 
    case -3: 
    default: 
      localObject = paramp.getMessage();
      k = paramp.a();
      String str = String.format(Locale.US, "Unknown error(%d;%s)", new Object[] { Integer.valueOf(k), localObject });
      paramp = (p)localObject;
      localObject = str;
    }
    for (;;)
    {
      this.j.a((String)localObject);
      return new a.a().a(1).b(k).a(paramp);
      paramp = String.valueOf(Build.VERSION.SDK_INT);
      localObject = String.format(Locale.US, "Android bleow 2.2, current is %s", new Object[] { paramp });
      k = 1;
      continue;
      paramp = "";
      localObject = "Network is 3gwap";
      continue;
      paramp = paramp.getMessage();
      k = 3;
      localObject = String.format(Locale.US, "Load libcom.maa.wspxld.so error(%s)", new Object[] { paramp });
      continue;
      paramp = paramp.getMessage();
      k = 4;
      localObject = String.format(Locale.US, "Wspx start failure(%s)", new Object[] { paramp });
      continue;
      paramp = "";
      k = 5;
      localObject = "Wspx start timeout";
      continue;
      paramp = paramp.getMessage();
      k = 6;
      localObject = String.format(Locale.US, "Wspx native method error(%s)", new Object[] { paramp });
      continue;
      paramp = paramp.getMessage();
      k = -1;
      localObject = String.format(Locale.US, "Unknown error(%s)", new Object[] { paramp });
      continue;
      paramp = b();
      k = 7;
      localObject = String.format(Locale.US, "Invalid localhost(%s)", new Object[] { paramp });
    }
  }
  
  public static <V> V a(V[] paramArrayOfV, V paramV1, V paramV2, boolean paramBoolean)
  {
    if (a(paramArrayOfV)) {}
    label12:
    label72:
    for (;;)
    {
      return paramV2;
      int k = 0;
      if (k < paramArrayOfV.length) {
        if (!k.a(paramV1, paramArrayOfV[k])) {}
      }
      for (;;)
      {
        if (k == -1) {
          break label72;
        }
        if (k == 0)
        {
          if (!paramBoolean) {
            break;
          }
          return paramArrayOfV[(paramArrayOfV.length - 1)];
          k += 1;
          break label12;
        }
        return paramArrayOfV[(k - 1)];
        k = -1;
      }
    }
  }
  
  public static <V> V a(V[] paramArrayOfV, V paramV, boolean paramBoolean)
  {
    return (V)a(paramArrayOfV, paramV, null, true);
  }
  
  public static <V> boolean a(V[] paramArrayOfV)
  {
    return (paramArrayOfV == null) || (paramArrayOfV.length == 0);
  }
  
  private static int b(int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException("The length of source array must be greater than 0.");
    }
    return ((Integer)b(k.a(paramArrayOfInt), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramBoolean)).intValue();
  }
  
  private static long b(long[] paramArrayOfLong, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramArrayOfLong.length == 0) {
      throw new IllegalArgumentException("The length of source array must be greater than 0.");
    }
    return ((Long)b(k.a(paramArrayOfLong), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramBoolean)).longValue();
  }
  
  public static <V> V b(V[] paramArrayOfV, V paramV1, V paramV2, boolean paramBoolean)
  {
    if (a(paramArrayOfV)) {}
    label12:
    label73:
    for (;;)
    {
      return paramV2;
      int k = 0;
      if (k < paramArrayOfV.length) {
        if (!k.a(paramV1, paramArrayOfV[k])) {}
      }
      for (;;)
      {
        if (k == -1) {
          break label73;
        }
        if (k == paramArrayOfV.length - 1)
        {
          if (!paramBoolean) {
            break;
          }
          return paramArrayOfV[0];
          k += 1;
          break label12;
        }
        return paramArrayOfV[(k + 1)];
        k = -1;
      }
    }
  }
  
  public static <V> V b(V[] paramArrayOfV, V paramV, boolean paramBoolean)
  {
    return (V)b(paramArrayOfV, paramV, null, true);
  }
  
  /* Error */
  private static String b()
  {
    // Byte code:
    //   0: new 162	java/io/BufferedReader
    //   3: dup
    //   4: new 164	java/io/FileReader
    //   7: dup
    //   8: ldc -90
    //   10: invokespecial 167	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: sipush 1024
    //   16: invokespecial 170	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   19: astore_0
    //   20: new 172	java/lang/StringBuilder
    //   23: dup
    //   24: ldc 127
    //   26: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_0
    //   31: invokevirtual 176	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnull +38 -> 74
    //   39: aload_2
    //   40: ldc -78
    //   42: invokevirtual 182	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   45: ifeq -15 -> 30
    //   48: aload_1
    //   49: aload_2
    //   50: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc -68
    //   55: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: goto -29 -> 30
    //   62: astore_1
    //   63: aload_0
    //   64: ifnull +7 -> 71
    //   67: aload_0
    //   68: invokevirtual 191	java/io/BufferedReader:close	()V
    //   71: ldc 127
    //   73: areturn
    //   74: aload_1
    //   75: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_1
    //   79: aload_0
    //   80: invokevirtual 191	java/io/BufferedReader:close	()V
    //   83: aload_1
    //   84: areturn
    //   85: astore_0
    //   86: aload_1
    //   87: areturn
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 191	java/io/BufferedReader:close	()V
    //   99: aload_1
    //   100: athrow
    //   101: astore_0
    //   102: ldc 127
    //   104: areturn
    //   105: astore_0
    //   106: goto -7 -> 99
    //   109: astore_1
    //   110: goto -19 -> 91
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_0
    //   116: goto -53 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	61	0	localBufferedReader	java.io.BufferedReader
    //   85	1	0	localIOException1	java.io.IOException
    //   90	6	0	localObject1	Object
    //   101	1	0	localIOException2	java.io.IOException
    //   105	1	0	localIOException3	java.io.IOException
    //   113	1	0	localException1	Exception
    //   115	1	0	localObject2	Object
    //   29	20	1	localStringBuilder	StringBuilder
    //   62	13	1	localException2	Exception
    //   78	9	1	str1	String
    //   88	12	1	localObject3	Object
    //   109	1	1	localObject4	Object
    //   34	16	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   20	30	62	java/lang/Exception
    //   30	35	62	java/lang/Exception
    //   39	59	62	java/lang/Exception
    //   74	79	62	java/lang/Exception
    //   79	83	85	java/io/IOException
    //   0	20	88	finally
    //   67	71	101	java/io/IOException
    //   95	99	105	java/io/IOException
    //   20	30	109	finally
    //   30	35	109	finally
    //   39	59	109	finally
    //   74	79	109	finally
    //   0	20	113	java/lang/Exception
  }
  
  public final a.a a()
  {
    if ((this.i instanceof p))
    {
      localObject = (p)this.i;
      int k;
      switch (((p)localObject).a())
      {
      case -9: 
      case -3: 
      default: 
        str = ((p)localObject).getMessage();
        k = ((p)localObject).a();
        localObject = String.format(Locale.US, "Unknown error(%d;%s)", new Object[] { Integer.valueOf(k), str });
      }
      for (;;)
      {
        this.j.a((String)localObject);
        return new a.a().a(1).b(k).a(str);
        str = String.valueOf(Build.VERSION.SDK_INT);
        localObject = String.format(Locale.US, "Android bleow 2.2, current is %s", new Object[] { str });
        k = 1;
        continue;
        localObject = "Network is 3gwap";
        str = "";
        k = 2;
        continue;
        str = ((p)localObject).getMessage();
        k = 3;
        localObject = String.format(Locale.US, "Load libcom.maa.wspxld.so error(%s)", new Object[] { str });
        continue;
        str = ((p)localObject).getMessage();
        k = 4;
        localObject = String.format(Locale.US, "Wspx start failure(%s)", new Object[] { str });
        continue;
        str = "";
        k = 5;
        localObject = "Wspx start timeout";
        continue;
        str = ((p)localObject).getMessage();
        k = 6;
        localObject = String.format(Locale.US, "Wspx native method error(%s)", new Object[] { str });
        continue;
        str = ((p)localObject).getMessage();
        localObject = String.format(Locale.US, "Unknown error(%s)", new Object[] { str });
        k = -1;
        continue;
        str = b();
        k = 7;
        localObject = String.format(Locale.US, "Invalid localhost(%s)", new Object[] { str });
      }
    }
    String str = this.i.getMessage();
    Object localObject = new a.a().a(1).b(-1).a(str);
    this.j.a(String.format(Locale.US, "Unknown error(%s)", new Object[] { str }));
    return (a.a)localObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */