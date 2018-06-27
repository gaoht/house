package cn.jiguang.c.c;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class o
{
  private static o d;
  private static final String[] z;
  private String[] a = null;
  private j[] b = null;
  private int c = -1;
  
  static
  {
    String[] arrayOfString = new String[38];
    int j = 0;
    Object localObject3 = "%\004?I0d\004%\t\020E \005B&}\026$";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject3).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject3 = arrayOfChar;
    int i4 = j;
    Object localObject4 = localObject1;
    int n = k;
    Object localObject5;
    int i2;
    if (k <= 1)
    {
      localObject5 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject3 = localObject1;
      i1 = localObject3[m];
      switch (n % 5)
      {
      default: 
        i = 84;
      }
    }
    for (;;)
    {
      localObject3[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject4 = localObject5;
      i4 = j;
      localObject3 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject3;
      j = i4;
      localObject5 = localObject4;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject3).intern();
      switch (i3)
      {
      default: 
        localObject4[i4] = localObject1;
        j = 1;
        localObject3 = "o\035%x'n\001 B&x";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject4[i4] = localObject1;
        j = 2;
        localObject3 = "c\034%S\013e\022;B";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject4[i4] = localObject1;
        j = 3;
        localObject3 = "{\001?J5y\n\tC:x,%R2m\032.";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject4[i4] = localObject1;
        j = 4;
        localObject3 = "o\035%x'~\0250N,";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject4[i4] = localObject1;
        j = 5;
        localObject3 = "x\0267U7c";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject4[i4] = localObject1;
        j = 6;
        localObject3 = "e\0279S'1";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject4[i4] = localObject1;
        j = 7;
        localObject3 = "o\034;F=e";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject4[i4] = localObject1;
        j = 8;
        localObject3 = "d\003\"N;e\000";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject4[i4] = localObject1;
        j = 9;
        localObject3 = "e\022;B'n\001 B&";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject4[i4] = localObject1;
        j = 10;
        localObject3 = "J\0352U;b\027";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject4[i4] = localObject1;
        j = 11;
        localObject3 = "E\026\"p5y\026";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject4[i4] = localObject1;
        j = 12;
        localObject3 = "a\022 Fz}\0268C;y";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject4[i4] = localObject1;
        j = 13;
        localObject3 = "$\026\"D{y\026%H8}]5H:m";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject4[i4] = localObject1;
        j = 14;
        localObject3 = "d\000xI5f\026";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject4[i4] = localObject1;
        j = 15;
        localObject3 = "|\0328N$h\0251\t;~\007";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject4[i4] = localObject1;
        j = 16;
        localObject3 = "2F";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject4[i4] = localObject1;
        j = 17;
        localObject3 = "|\0328N$h\0251\007{j\037:\007{i\022\"D<+";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject4[i4] = localObject1;
        j = 18;
        localObject3 = "b\0035H:m\0321\007{j\037:";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject4[i4] = localObject1;
        j = 19;
        localObject3 = "F6";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject4[i4] = localObject1;
        j = 20;
        localObject3 = "x\n%\035{n\0075\b&n\0009K\"%\0200@";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject4[i4] = localObject1;
        j = 21;
        localObject3 = "\\\0328C;|\000";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject4[i4] = localObject1;
        j = 22;
        localObject3 = "2K";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject4[i4] = localObject1;
        j = 23;
        localObject3 = "o\035%\t'n\022$D<";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject4[i4] = localObject1;
        j = 24;
        localObject3 = "o\035%\t'n\001 B&";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject4[i4] = localObject1;
        j = 25;
        localObject3 = "U/2\f|W]\nC\"\beZp";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject4[i4] = localObject1;
        j = 26;
        localObject3 = "e\026\"\t0e\000b";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject4[i4] = localObject1;
        j = 27;
        localObject3 = "e\026\"\t0e\000d";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject4[i4] = localObject1;
        j = 28;
        localObject3 = "U(f\nmj^0z#I\r\027y2\022{A\t!Z}\035\017;^oFym.}\003";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject4[i4] = localObject1;
        j = 29;
        localObject3 = "e\026\"\t0e\000g";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject4[i4] = localObject1;
        j = 30;
        localObject3 = "j\0352U;b\027xH'% /T n\036\006U;{\026$S=n\000";
        i = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject4[i4] = localObject1;
        j = 31;
        localObject3 = "l\026\"";
        i = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject4[i4] = localObject1;
        j = 32;
        localObject3 = "e\026\"\t0e\000e";
        i = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject4[i4] = localObject1;
        j = 33;
        localObject3 = "e\022;B'n\001 B&x";
        i = 32;
        localObject1 = arrayOfString;
        break;
      case 32: 
        localObject4[i4] = localObject1;
        j = 34;
        localObject3 = "x\0068\t:n\007xC:x]\004B'd\037 B&H\0348A=l\006$F b\0348";
        i = 33;
        localObject1 = arrayOfString;
        break;
      case 33: 
        localObject4[i4] = localObject1;
        j = 35;
        localObject3 = "d\0033I";
        i = 34;
        localObject1 = arrayOfString;
        break;
      case 34: 
        localObject4[i4] = localObject1;
        j = 36;
        localObject3 = "x\0267U7c\037?T ";
        i = 35;
        localObject1 = arrayOfString;
        break;
      case 35: 
        localObject4[i4] = localObject1;
        j = 37;
        localObject3 = "d\0011\t,i\032:KzO=\005\t#b\0352H#x]&F&x\026xE!m\0253U";
        i = 36;
        localObject1 = arrayOfString;
        break;
      case 36: 
        localObject4[i4] = localObject1;
        z = arrayOfString;
        localObject1 = new o();
        try
        {
          d = (o)localObject1;
          return;
        }
        finally {}
        i = 11;
        continue;
        i = 115;
        continue;
        i = 86;
        continue;
        i = 39;
      }
    }
  }
  
  public o()
  {
    if (c()) {}
    while ((d()) || ((this.a != null) && (this.b != null))) {
      return;
    }
    String str1 = System.getProperty(z[14]);
    String str2 = System.getProperty(z[12]);
    if (str1.indexOf(z[21]) != -1)
    {
      if ((str1.indexOf(z[16]) != -1) || (str1.indexOf(z[22]) != -1) || (str1.indexOf(z[19]) != -1))
      {
        str1 = z[15];
        try
        {
          Runtime.getRuntime().exec(z[17] + str1).waitFor();
          a(new FileInputStream(new File(str1)));
          new File(str1).delete();
          return;
        }
        catch (Exception localException1)
        {
          return;
        }
      }
      try
      {
        Process localProcess = Runtime.getRuntime().exec(z[18]);
        a(localProcess.getInputStream());
        localProcess.destroy();
        return;
      }
      catch (Exception localException2)
      {
        return;
      }
    }
    if (localException2.indexOf(z[11]) != -1)
    {
      b(z[20]);
      return;
    }
    if (str2.indexOf(z[10]) != -1)
    {
      e();
      return;
    }
    b(z[13]);
  }
  
  private static int a(String paramString)
  {
    paramString = paramString.substring(6);
    try
    {
      int i = Integer.parseInt(paramString);
      if (i >= 0) {
        return i;
      }
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  private void a(InputStream paramInputStream)
  {
    int i = Integer.getInteger(z[37], 8192).intValue();
    paramInputStream = new BufferedInputStream(paramInputStream, i);
    paramInputStream.mark(i);
    a(paramInputStream, null);
    if (this.a == null) {}
    try
    {
      paramInputStream.reset();
      a(paramInputStream, new Locale("", ""));
      return;
    }
    catch (IOException paramInputStream) {}
  }
  
  /* Error */
  private void a(InputStream paramInputStream, Locale paramLocale)
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokevirtual 240	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   5: invokevirtual 245	java/lang/Package:getName	()Ljava/lang/String;
    //   8: astore 7
    //   10: new 144	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   17: aload 7
    //   19: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: getstatic 107	cn/jiguang/c/c/o:z	[Ljava/lang/String;
    //   25: iconst_0
    //   26: aaload
    //   27: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 7
    //   35: aload_2
    //   36: ifnull +137 -> 173
    //   39: aload 7
    //   41: aload_2
    //   42: invokestatic 252	java/util/ResourceBundle:getBundle	(Ljava/lang/String;Ljava/util/Locale;)Ljava/util/ResourceBundle;
    //   45: astore_2
    //   46: aload_2
    //   47: getstatic 107	cn/jiguang/c/c/o:z	[Ljava/lang/String;
    //   50: iconst_2
    //   51: aaload
    //   52: invokevirtual 255	java/util/ResourceBundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore 7
    //   57: aload_2
    //   58: getstatic 107	cn/jiguang/c/c/o:z	[Ljava/lang/String;
    //   61: iconst_3
    //   62: aaload
    //   63: invokevirtual 255	java/util/ResourceBundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 8
    //   68: aload_2
    //   69: getstatic 107	cn/jiguang/c/c/o:z	[Ljava/lang/String;
    //   72: iconst_4
    //   73: aaload
    //   74: invokevirtual 255	java/util/ResourceBundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 9
    //   79: aload_2
    //   80: getstatic 107	cn/jiguang/c/c/o:z	[Ljava/lang/String;
    //   83: iconst_1
    //   84: aaload
    //   85: invokevirtual 255	java/util/ResourceBundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   88: astore 10
    //   90: new 257	java/io/BufferedReader
    //   93: dup
    //   94: new 259	java/io/InputStreamReader
    //   97: dup
    //   98: aload_1
    //   99: invokespecial 261	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   102: invokespecial 264	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   105: astore 11
    //   107: new 266	java/util/ArrayList
    //   110: dup
    //   111: invokespecial 267	java/util/ArrayList:<init>	()V
    //   114: astore 12
    //   116: new 266	java/util/ArrayList
    //   119: dup
    //   120: invokespecial 267	java/util/ArrayList:<init>	()V
    //   123: astore 13
    //   125: iconst_0
    //   126: istore 4
    //   128: iconst_0
    //   129: istore_3
    //   130: aload 11
    //   132: invokevirtual 270	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: astore 15
    //   137: aload 15
    //   139: ifnull +301 -> 440
    //   142: new 272	java/util/StringTokenizer
    //   145: dup
    //   146: aload 15
    //   148: invokespecial 273	java/util/StringTokenizer:<init>	(Ljava/lang/String;)V
    //   151: astore 14
    //   153: aload 14
    //   155: invokevirtual 276	java/util/StringTokenizer:hasMoreTokens	()Z
    //   158: istore 6
    //   160: iload 6
    //   162: ifne +20 -> 182
    //   165: iconst_0
    //   166: istore 4
    //   168: iconst_0
    //   169: istore_3
    //   170: goto -40 -> 130
    //   173: aload 7
    //   175: invokestatic 279	java/util/ResourceBundle:getBundle	(Ljava/lang/String;)Ljava/util/ResourceBundle;
    //   178: astore_2
    //   179: goto -133 -> 46
    //   182: aload 14
    //   184: invokevirtual 282	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   187: astore_1
    //   188: aload 15
    //   190: ldc_w 284
    //   193: invokevirtual 136	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   196: iconst_m1
    //   197: if_icmpeq +267 -> 464
    //   200: iconst_0
    //   201: istore_3
    //   202: iconst_0
    //   203: istore 4
    //   205: aload 15
    //   207: aload 7
    //   209: invokevirtual 136	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   212: iconst_m1
    //   213: if_icmpeq +53 -> 266
    //   216: aload 14
    //   218: invokevirtual 276	java/util/StringTokenizer:hasMoreTokens	()Z
    //   221: ifeq +12 -> 233
    //   224: aload 14
    //   226: invokevirtual 282	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   229: astore_1
    //   230: goto -14 -> 216
    //   233: aload_1
    //   234: aconst_null
    //   235: invokestatic 289	cn/jiguang/c/c/j:a	(Ljava/lang/String;Lcn/jiguang/c/c/j;)Lcn/jiguang/c/c/j;
    //   238: astore_2
    //   239: aload_2
    //   240: invokevirtual 291	cn/jiguang/c/c/j:b	()I
    //   243: iconst_1
    //   244: if_icmpeq +207 -> 451
    //   247: aload_1
    //   248: aload 13
    //   250: invokestatic 294	cn/jiguang/c/c/o:b	(Ljava/lang/String;Ljava/util/List;)V
    //   253: iload_3
    //   254: istore 5
    //   256: iload 4
    //   258: istore_3
    //   259: iload 5
    //   261: istore 4
    //   263: goto -133 -> 130
    //   266: aload 15
    //   268: aload 8
    //   270: invokevirtual 136	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   273: iconst_m1
    //   274: if_icmpeq +44 -> 318
    //   277: aload 14
    //   279: invokevirtual 276	java/util/StringTokenizer:hasMoreTokens	()Z
    //   282: ifeq +12 -> 294
    //   285: aload 14
    //   287: invokevirtual 282	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   290: astore_1
    //   291: goto -14 -> 277
    //   294: aload_1
    //   295: ldc_w 284
    //   298: invokevirtual 298	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: ifne +150 -> 451
    //   304: aload_1
    //   305: aload 13
    //   307: invokestatic 294	cn/jiguang/c/c/o:b	(Ljava/lang/String;Ljava/util/List;)V
    //   310: iload_3
    //   311: istore 4
    //   313: iconst_1
    //   314: istore_3
    //   315: goto -185 -> 130
    //   318: aload_1
    //   319: astore_2
    //   320: iload 4
    //   322: ifne +16 -> 338
    //   325: aload 15
    //   327: aload 9
    //   329: invokevirtual 136	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   332: iconst_m1
    //   333: if_icmpeq +46 -> 379
    //   336: aload_1
    //   337: astore_2
    //   338: aload 14
    //   340: invokevirtual 276	java/util/StringTokenizer:hasMoreTokens	()Z
    //   343: ifeq +12 -> 355
    //   346: aload 14
    //   348: invokevirtual 282	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   351: astore_2
    //   352: goto -14 -> 338
    //   355: aload_2
    //   356: ldc_w 284
    //   359: invokevirtual 298	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   362: ifne +89 -> 451
    //   365: aload_2
    //   366: aload 13
    //   368: invokestatic 294	cn/jiguang/c/c/o:b	(Ljava/lang/String;Ljava/util/List;)V
    //   371: iload_3
    //   372: istore 4
    //   374: iconst_1
    //   375: istore_3
    //   376: goto -246 -> 130
    //   379: aload_1
    //   380: astore_2
    //   381: iload_3
    //   382: ifne +19 -> 401
    //   385: iload_3
    //   386: istore 5
    //   388: aload 15
    //   390: aload 10
    //   392: invokevirtual 136	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   395: iconst_m1
    //   396: if_icmpeq +95 -> 491
    //   399: aload_1
    //   400: astore_2
    //   401: aload 14
    //   403: invokevirtual 276	java/util/StringTokenizer:hasMoreTokens	()Z
    //   406: ifeq +12 -> 418
    //   409: aload 14
    //   411: invokevirtual 282	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   414: astore_2
    //   415: goto -14 -> 401
    //   418: aload_2
    //   419: ldc_w 284
    //   422: invokevirtual 298	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   425: ifne +26 -> 451
    //   428: aload_2
    //   429: aload 12
    //   431: invokestatic 300	cn/jiguang/c/c/o:a	(Ljava/lang/String;Ljava/util/List;)V
    //   434: iconst_1
    //   435: istore 5
    //   437: goto +54 -> 491
    //   440: aload_0
    //   441: aload 12
    //   443: aload 13
    //   445: invokespecial 303	cn/jiguang/c/c/o:a	(Ljava/util/List;Ljava/util/List;)V
    //   448: return
    //   449: astore_1
    //   450: return
    //   451: iload_3
    //   452: istore 5
    //   454: iload 4
    //   456: istore_3
    //   457: iload 5
    //   459: istore 4
    //   461: goto -331 -> 130
    //   464: iload_3
    //   465: istore 5
    //   467: iload 4
    //   469: istore_3
    //   470: iload 5
    //   472: istore 4
    //   474: goto -269 -> 205
    //   477: astore_1
    //   478: iload_3
    //   479: istore 5
    //   481: iload 4
    //   483: istore_3
    //   484: iload 5
    //   486: istore 4
    //   488: goto -358 -> 130
    //   491: iload 4
    //   493: istore_3
    //   494: iload 5
    //   496: istore 4
    //   498: goto -368 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	this	o
    //   0	501	1	paramInputStream	InputStream
    //   0	501	2	paramLocale	Locale
    //   129	365	3	i	int
    //   126	371	4	j	int
    //   254	241	5	k	int
    //   158	3	6	bool	boolean
    //   8	200	7	str1	String
    //   66	203	8	str2	String
    //   77	251	9	str3	String
    //   88	303	10	str4	String
    //   105	26	11	localBufferedReader	BufferedReader
    //   114	328	12	localArrayList1	ArrayList
    //   123	321	13	localArrayList2	ArrayList
    //   151	259	14	localStringTokenizer	StringTokenizer
    //   135	254	15	str5	String
    // Exception table:
    //   from	to	target	type
    //   107	125	449	java/io/IOException
    //   130	137	449	java/io/IOException
    //   142	160	449	java/io/IOException
    //   182	200	449	java/io/IOException
    //   205	216	449	java/io/IOException
    //   216	230	449	java/io/IOException
    //   233	239	449	java/io/IOException
    //   239	253	449	java/io/IOException
    //   266	277	449	java/io/IOException
    //   277	291	449	java/io/IOException
    //   294	310	449	java/io/IOException
    //   325	336	449	java/io/IOException
    //   338	352	449	java/io/IOException
    //   355	371	449	java/io/IOException
    //   388	399	449	java/io/IOException
    //   401	415	449	java/io/IOException
    //   418	434	449	java/io/IOException
    //   440	448	449	java/io/IOException
    //   233	239	477	cn/jiguang/c/c/s
  }
  
  private static void a(String paramString, List paramList)
  {
    if (paramList.contains(paramString)) {
      return;
    }
    paramList.add(paramString);
  }
  
  private void a(List paramList1, List paramList2)
  {
    if ((this.a == null) && (paramList1.size() > 0)) {
      this.a = ((String[])paramList1.toArray(new String[0]));
    }
    if ((this.b == null) && (paramList2.size() > 0)) {
      this.b = ((j[])paramList2.toArray(new j[0]));
    }
  }
  
  public static o b()
  {
    try
    {
      o localo = d;
      return localo;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramString));
      paramString = new ArrayList(0);
      ArrayList localArrayList = new ArrayList(0);
      int i = -1;
      int j = i;
      for (;;)
      {
        try
        {
          localObject = localBufferedReader.readLine();
          if (localObject == null) {
            break label390;
          }
          j = i;
          if (((String)localObject).startsWith(z[9]))
          {
            j = i;
            localObject = new StringTokenizer((String)localObject);
            j = i;
            ((StringTokenizer)localObject).nextToken();
            j = i;
            a(((StringTokenizer)localObject).nextToken(), paramString);
          }
        }
        catch (IOException localIOException)
        {
          i = j;
          a(paramString, localArrayList);
          if ((this.c < 0) && (i > 0)) {
            this.c = i;
          }
          return;
        }
        j = i;
        if (((String)localObject).startsWith(z[7]))
        {
          j = i;
          localObject = new StringTokenizer((String)localObject);
          j = i;
          ((StringTokenizer)localObject).nextToken();
          j = i;
          if (!((StringTokenizer)localObject).hasMoreTokens()) {
            break;
          }
          j = i;
          if (!localArrayList.isEmpty()) {
            break;
          }
          j = i;
          b(((StringTokenizer)localObject).nextToken(), localArrayList);
          break;
        }
        j = i;
        if (((String)localObject).startsWith(z[5]))
        {
          j = i;
          if (!localArrayList.isEmpty())
          {
            j = i;
            localArrayList.clear();
          }
          j = i;
          localObject = new StringTokenizer((String)localObject);
          j = i;
          ((StringTokenizer)localObject).nextToken();
          for (;;)
          {
            j = i;
            if (!((StringTokenizer)localObject).hasMoreTokens()) {
              break;
            }
            j = i;
            b(((StringTokenizer)localObject).nextToken(), localArrayList);
          }
        }
        j = i;
        if (!((String)localObject).startsWith(z[8])) {
          break;
        }
        j = i;
        Object localObject = new StringTokenizer((String)localObject);
        j = i;
        ((StringTokenizer)localObject).nextToken();
        int k = i;
        for (;;)
        {
          i = k;
          j = k;
          if (!((StringTokenizer)localObject).hasMoreTokens()) {
            break;
          }
          j = k;
          String str = ((StringTokenizer)localObject).nextToken();
          j = k;
          if (str.startsWith(z[6]))
          {
            j = k;
            k = a(str);
          }
        }
        label390:
        j = i;
        localIOException.close();
      }
      return;
    }
    catch (FileNotFoundException paramString) {}
  }
  
  private static void b(String paramString, List paramList)
  {
    try
    {
      paramString = j.a(paramString, j.a);
      if (paramList.contains(paramString)) {
        return;
      }
      paramList.add(paramString);
      return;
    }
    catch (s paramString) {}
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    ArrayList localArrayList1 = new ArrayList(0);
    ArrayList localArrayList2 = new ArrayList(0);
    Object localObject = System.getProperty(z[24]);
    if (localObject != null)
    {
      localObject = new StringTokenizer((String)localObject, ",");
      while (((StringTokenizer)localObject).hasMoreTokens()) {
        a(((StringTokenizer)localObject).nextToken(), localArrayList1);
      }
    }
    localObject = System.getProperty(z[23]);
    if (localObject != null)
    {
      localObject = new StringTokenizer((String)localObject, ",");
      while (((StringTokenizer)localObject).hasMoreTokens()) {
        b(((StringTokenizer)localObject).nextToken(), localArrayList2);
      }
    }
    a(localArrayList1, localArrayList2);
    boolean bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.b != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean d()
  {
    ArrayList localArrayList1 = new ArrayList(0);
    ArrayList localArrayList2 = new ArrayList(0);
    Object localObject2;
    Object localObject1;
    try
    {
      localObject2 = new Class[0];
      Object[] arrayOfObject = new Object[0];
      Class localClass = Class.forName(z[34]);
      Object localObject3 = localClass.getDeclaredMethod(z[35], (Class[])localObject2).invoke(null, arrayOfObject);
      localObject1 = (List)localClass.getMethod(z[33], (Class[])localObject2).invoke(localObject3, arrayOfObject);
      localObject2 = (List)localClass.getMethod(z[36], (Class[])localObject2).invoke(localObject3, arrayOfObject);
      if (((List)localObject1).size() == 0) {
        return false;
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((String)((Iterator)localObject1).next(), localException);
      }
    }
    if (((List)localObject2).size() > 0)
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        b((String)((Iterator)localObject1).next(), localArrayList2);
      }
    }
    a(localException, localArrayList2);
    return true;
  }
  
  private void e()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      Method localMethod = Class.forName(z[30]).getMethod(z[31], new Class[] { String.class });
      String str1 = z[29];
      String str2 = z[27];
      String str3 = z[32];
      String str4 = z[26];
      int i = 0;
      while (i < 4)
      {
        String str5 = (String)localMethod.invoke(null, new Object[] { new String[] { str1, str2, str3, str4 }[i] });
        if ((str5 != null) && ((str5.matches(z[25])) || (str5.matches(z[28]))) && (!localArrayList1.contains(str5))) {
          localArrayList1.add(str5);
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      a(localArrayList1, localArrayList2);
    }
  }
  
  public final String[] a()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */