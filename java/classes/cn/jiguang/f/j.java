package cn.jiguang.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import cn.jiguang.d.d;

public final class j
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[11];
    int j = 0;
    Object localObject2 = "__";
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
        i = 48;
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
        localObject2 = "\034Q\\Q";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "?]V]_\005AwY^\n__Je\037QVK";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "\f]N{E\031J_VD%]NlI\033]\032\025\020\037AJ]\n";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "Y_";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\bWTVU\bLSNY\037A";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "X_";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\f]NvU\037OUJ[(T[KCKV_LG\004JQlI\033]\000";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "\036VQV_\034V";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\f]NvU\037OUJ[(T[KC";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\030L_H\002K\025\032LI\033]\000";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 107;
        continue;
        i = 56;
        continue;
        i = 58;
        continue;
        i = 56;
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService(z[5])).getActiveNetworkInfo();
        if (paramContext != null) {
          continue;
        }
        paramContext = z[8];
      }
      catch (Exception paramContext)
      {
        int i;
        paramContext.printStackTrace();
        paramContext = "";
        continue;
        continue;
      }
      d.a(z[2], z[3] + paramContext);
      return paramContext;
      if (paramContext.getType() == 1)
      {
        paramContext = z[1];
      }
      else
      {
        if (paramContext.getType() != 0) {
          continue;
        }
        i = paramContext.getSubtype();
        d.a(z[2], z[7] + i);
        switch (i)
        {
        case 1: 
          if (i == 16) {
            paramContext = z[4];
          }
          break;
        case 2: 
        case 4: 
        case 7: 
        case 11: 
          paramContext = z[4];
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
          paramContext = z[6];
          break;
        case 13: 
          paramContext = z[0];
          continue;
          if (i == 17) {
            paramContext = z[6];
          } else if (i == 18) {
            paramContext = z[0];
          } else {
            paramContext = z[8];
          }
          break;
        }
      }
    }
  }
  
  /* Error */
  public static String a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 106	cn/jiguang/f/j:a	(Landroid/content/Context;)Ljava/lang/String;
    //   4: astore_0
    //   5: getstatic 46	cn/jiguang/f/j:z	[Ljava/lang/String;
    //   8: iconst_2
    //   9: aaload
    //   10: new 65	java/lang/StringBuilder
    //   13: dup
    //   14: getstatic 46	cn/jiguang/f/j:z	[Ljava/lang/String;
    //   17: iconst_3
    //   18: aaload
    //   19: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 80	cn/jiguang/d/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +193 -> 229
    //   39: ldc 114
    //   41: getstatic 46	cn/jiguang/f/j:z	[Ljava/lang/String;
    //   44: bipush 9
    //   46: aaload
    //   47: iconst_1
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: iload_1
    //   54: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 125	cn/jiguang/e/c:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   61: astore_2
    //   62: aload_2
    //   63: checkcast 116	java/lang/Integer
    //   66: invokevirtual 128	java/lang/Integer:intValue	()I
    //   69: ifne +58 -> 127
    //   72: getstatic 46	cn/jiguang/f/j:z	[Ljava/lang/String;
    //   75: bipush 8
    //   77: aaload
    //   78: astore_2
    //   79: aload_2
    //   80: astore_0
    //   81: getstatic 46	cn/jiguang/f/j:z	[Ljava/lang/String;
    //   84: iconst_2
    //   85: aaload
    //   86: new 65	java/lang/StringBuilder
    //   89: dup
    //   90: getstatic 46	cn/jiguang/f/j:z	[Ljava/lang/String;
    //   93: bipush 10
    //   95: aaload
    //   96: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 131	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: astore_2
    //   111: aload_0
    //   112: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifeq +10 -> 125
    //   118: getstatic 46	cn/jiguang/f/j:z	[Ljava/lang/String;
    //   121: bipush 8
    //   123: aaload
    //   124: astore_2
    //   125: aload_2
    //   126: areturn
    //   127: aload_2
    //   128: checkcast 116	java/lang/Integer
    //   131: invokevirtual 128	java/lang/Integer:intValue	()I
    //   134: iconst_1
    //   135: if_icmpne +14 -> 149
    //   138: getstatic 46	cn/jiguang/f/j:z	[Ljava/lang/String;
    //   141: iconst_4
    //   142: aaload
    //   143: astore_2
    //   144: aload_2
    //   145: astore_0
    //   146: goto -65 -> 81
    //   149: aload_2
    //   150: checkcast 116	java/lang/Integer
    //   153: invokevirtual 128	java/lang/Integer:intValue	()I
    //   156: iconst_2
    //   157: if_icmpne +15 -> 172
    //   160: getstatic 46	cn/jiguang/f/j:z	[Ljava/lang/String;
    //   163: bipush 6
    //   165: aaload
    //   166: astore_2
    //   167: aload_2
    //   168: astore_0
    //   169: goto -88 -> 81
    //   172: aload_2
    //   173: checkcast 116	java/lang/Integer
    //   176: invokevirtual 128	java/lang/Integer:intValue	()I
    //   179: iconst_3
    //   180: if_icmpne +46 -> 226
    //   183: getstatic 46	cn/jiguang/f/j:z	[Ljava/lang/String;
    //   186: iconst_0
    //   187: aaload
    //   188: astore_2
    //   189: aload_2
    //   190: astore_0
    //   191: goto -110 -> 81
    //   194: astore_2
    //   195: goto -86 -> 109
    //   198: astore_2
    //   199: goto -90 -> 109
    //   202: astore_2
    //   203: goto -94 -> 109
    //   206: astore_2
    //   207: goto -98 -> 109
    //   210: astore_2
    //   211: goto -102 -> 109
    //   214: astore_2
    //   215: goto -106 -> 109
    //   218: astore_2
    //   219: goto -110 -> 109
    //   222: astore_2
    //   223: goto -114 -> 109
    //   226: goto -145 -> 81
    //   229: goto -120 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramContext	Context
    //   0	232	1	paramInt	int
    //   61	129	2	localObject	Object
    //   194	1	2	localException1	Exception
    //   198	1	2	localException2	Exception
    //   202	1	2	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   206	1	2	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   210	1	2	localIllegalAccessException1	IllegalAccessException
    //   214	1	2	localIllegalAccessException2	IllegalAccessException
    //   218	1	2	localNoSuchMethodException1	NoSuchMethodException
    //   222	1	2	localNoSuchMethodException2	NoSuchMethodException
    // Exception table:
    //   from	to	target	type
    //   39	79	194	java/lang/Exception
    //   127	144	194	java/lang/Exception
    //   149	167	194	java/lang/Exception
    //   172	189	194	java/lang/Exception
    //   81	109	198	java/lang/Exception
    //   39	79	202	java/lang/reflect/InvocationTargetException
    //   127	144	202	java/lang/reflect/InvocationTargetException
    //   149	167	202	java/lang/reflect/InvocationTargetException
    //   172	189	202	java/lang/reflect/InvocationTargetException
    //   81	109	206	java/lang/reflect/InvocationTargetException
    //   39	79	210	java/lang/IllegalAccessException
    //   127	144	210	java/lang/IllegalAccessException
    //   149	167	210	java/lang/IllegalAccessException
    //   172	189	210	java/lang/IllegalAccessException
    //   81	109	214	java/lang/IllegalAccessException
    //   39	79	218	java/lang/NoSuchMethodException
    //   127	144	218	java/lang/NoSuchMethodException
    //   149	167	218	java/lang/NoSuchMethodException
    //   172	189	218	java/lang/NoSuchMethodException
    //   81	109	222	java/lang/NoSuchMethodException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/f/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */