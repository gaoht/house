package cn.jiguang.c.d;

import android.content.Context;
import cn.jiguang.a.a.b.b;
import cn.jiguang.c.a.a;
import cn.jiguang.d.d;
import cn.jiguang.f.h;

public final class p
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[12];
    int j = 0;
    Object localObject2 = "G\020p7;oD9!l.\005'47.\002>6hzD>*hz\005;(~j";
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
        i = 27;
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
        localObject2 = "?J";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "X\001%7ra\n\037!w~\001%";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "o\007#-t`Dzdt`1'#io\0002";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "?Jfj+";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "o\007#-t`Dzdso\n3(~[\02406zj\001";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\"\013; Mk\026$-t`^";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "}\000<dmk\026$-t`Dzdx{\026\001!i}\r8*!";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "@\013w\026~i\r$0io\020>+uG y";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "@\013w7zx\0013dn}\001%dr`\0028j";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "O\007#-t`Dzdxa\024.\026~i\r$0~|1$!iG\n1+";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "^\0262\"hH\r;!";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 14;
        continue;
        i = 100;
        continue;
        i = 87;
        continue;
        i = 68;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    d.c(z[2], z[5]);
    String str3 = z[4];
    String str2 = b.b(paramContext);
    String str1 = str2;
    if (h.a(str2)) {
      str1 = a.C();
    }
    d.a(z[2], z[7] + str3 + z[6] + str1);
    if (h.a(str1)) {
      d.c(z[2], z[0]);
    }
    for (;;)
    {
      a.m(str3);
      return;
      if ((!str3.equals(str1)) && (!str3.startsWith(z[1])) && (str1.startsWith(z[1])))
      {
        b.a(paramContext, str3);
        d.c(z[2], z[3]);
        b(paramContext);
        a.d(paramContext);
      }
    }
  }
  
  /* Error */
  private static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 48	cn/jiguang/c/d/p:z	[Ljava/lang/String;
    //   6: iconst_2
    //   7: aaload
    //   8: getstatic 48	cn/jiguang/c/d/p:z	[Ljava/lang/String;
    //   11: bipush 10
    //   13: aaload
    //   14: invokestatic 57	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: bipush 8
    //   19: newarray <illegal type>
    //   21: astore 6
    //   23: aload_0
    //   24: getstatic 48	cn/jiguang/c/d/p:z	[Ljava/lang/String;
    //   27: bipush 11
    //   29: aaload
    //   30: invokevirtual 116	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   33: astore 5
    //   35: aload 5
    //   37: aload 6
    //   39: iconst_0
    //   40: bipush 8
    //   42: invokevirtual 122	java/io/FileInputStream:read	([BII)I
    //   45: pop
    //   46: iconst_0
    //   47: istore_1
    //   48: lconst_0
    //   49: lstore_2
    //   50: iload_1
    //   51: bipush 8
    //   53: if_icmpge +25 -> 78
    //   56: aload 6
    //   58: iload_1
    //   59: baload
    //   60: sipush 255
    //   63: iand
    //   64: i2l
    //   65: lload_2
    //   66: bipush 8
    //   68: lshl
    //   69: ladd
    //   70: lstore_2
    //   71: iload_1
    //   72: iconst_1
    //   73: iadd
    //   74: istore_1
    //   75: goto -25 -> 50
    //   78: new 75	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   85: astore 6
    //   87: aload 5
    //   89: invokevirtual 127	java/io/FileInputStream:read	()I
    //   92: istore_1
    //   93: iload_1
    //   94: iconst_m1
    //   95: if_icmpeq +51 -> 146
    //   98: aload 6
    //   100: iload_1
    //   101: i2c
    //   102: invokevirtual 130	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: goto -19 -> 87
    //   109: astore 5
    //   111: getstatic 48	cn/jiguang/c/d/p:z	[Ljava/lang/String;
    //   114: iconst_2
    //   115: aaload
    //   116: getstatic 48	cn/jiguang/c/d/p:z	[Ljava/lang/String;
    //   119: bipush 9
    //   121: aaload
    //   122: invokestatic 57	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: ldc -124
    //   127: astore 5
    //   129: lconst_0
    //   130: lstore_2
    //   131: lload_2
    //   132: lconst_0
    //   133: lcmp
    //   134: ifne +50 -> 184
    //   137: iconst_0
    //   138: istore 4
    //   140: ldc 2
    //   142: monitorexit
    //   143: iload 4
    //   145: ireturn
    //   146: aload 5
    //   148: invokevirtual 135	java/io/FileInputStream:close	()V
    //   151: aload 6
    //   153: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: astore 5
    //   158: goto -27 -> 131
    //   161: astore 5
    //   163: lconst_0
    //   164: lstore_2
    //   165: getstatic 48	cn/jiguang/c/d/p:z	[Ljava/lang/String;
    //   168: iconst_2
    //   169: aaload
    //   170: ldc -124
    //   172: aload 5
    //   174: invokestatic 138	cn/jiguang/d/d:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: ldc -124
    //   179: astore 5
    //   181: goto -50 -> 131
    //   184: ldc -124
    //   186: invokestatic 68	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   189: ifeq +68 -> 257
    //   192: invokestatic 141	cn/jiguang/c/a/a:v	()Ljava/lang/String;
    //   195: astore 6
    //   197: aload 6
    //   199: invokestatic 68	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   202: ifeq +23 -> 225
    //   205: getstatic 48	cn/jiguang/c/d/p:z	[Ljava/lang/String;
    //   208: iconst_2
    //   209: aaload
    //   210: getstatic 48	cn/jiguang/c/d/p:z	[Ljava/lang/String;
    //   213: bipush 8
    //   215: aaload
    //   216: invokestatic 57	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: iconst_0
    //   220: istore 4
    //   222: goto -82 -> 140
    //   225: lload_2
    //   226: aload 5
    //   228: aload 6
    //   230: aload_0
    //   231: invokestatic 146	cn/jiguang/f/a:g	(Landroid/content/Context;)Ljava/lang/String;
    //   234: getstatic 152	cn/jiguang/c/a:f	Ljava/lang/String;
    //   237: invokestatic 155	cn/jiguang/c/a/a:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   240: iconst_1
    //   241: istore 4
    //   243: goto -103 -> 140
    //   246: astore_0
    //   247: ldc 2
    //   249: monitorexit
    //   250: aload_0
    //   251: athrow
    //   252: astore 5
    //   254: goto -89 -> 165
    //   257: ldc -124
    //   259: astore 6
    //   261: goto -64 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramContext	Context
    //   47	54	1	i	int
    //   49	177	2	l	long
    //   138	104	4	bool	boolean
    //   33	55	5	localFileInputStream	java.io.FileInputStream
    //   109	1	5	localFileNotFoundException	java.io.FileNotFoundException
    //   127	30	5	str1	String
    //   161	12	5	localIOException1	java.io.IOException
    //   179	48	5	str2	String
    //   252	1	5	localIOException2	java.io.IOException
    //   21	239	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	46	109	java/io/FileNotFoundException
    //   78	87	109	java/io/FileNotFoundException
    //   87	93	109	java/io/FileNotFoundException
    //   98	106	109	java/io/FileNotFoundException
    //   146	158	109	java/io/FileNotFoundException
    //   17	46	161	java/io/IOException
    //   3	17	246	finally
    //   17	46	246	finally
    //   78	87	246	finally
    //   87	93	246	finally
    //   98	106	246	finally
    //   111	125	246	finally
    //   146	158	246	finally
    //   165	177	246	finally
    //   184	197	246	finally
    //   197	219	246	finally
    //   225	240	246	finally
    //   78	87	252	java/io/IOException
    //   87	93	252	java/io/IOException
    //   98	106	252	java/io/IOException
    //   146	158	252	java/io/IOException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */