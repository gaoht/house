package com.xiaomi.smack;

import com.maa.android.agent.instrumentation.Instrumented;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;

@Instrumented
public final class g
{
  private static int a = 5000;
  private static int b = 330000;
  private static int c = 300000;
  private static int d = 330000;
  private static Vector<String> e = new Vector();
  
  /* Error */
  static
  {
    // Byte code:
    //   0: sipush 5000
    //   3: putstatic 19	com/xiaomi/smack/g:a	I
    //   6: ldc 20
    //   8: putstatic 22	com/xiaomi/smack/g:b	I
    //   11: ldc 23
    //   13: putstatic 25	com/xiaomi/smack/g:c	I
    //   16: ldc 20
    //   18: putstatic 27	com/xiaomi/smack/g:d	I
    //   21: new 29	java/util/Vector
    //   24: dup
    //   25: invokespecial 32	java/util/Vector:<init>	()V
    //   28: putstatic 34	com/xiaomi/smack/g:e	Ljava/util/Vector;
    //   31: invokestatic 37	com/xiaomi/smack/g:d	()[Ljava/lang/ClassLoader;
    //   34: astore 8
    //   36: aload 8
    //   38: arraylength
    //   39: istore_3
    //   40: iconst_0
    //   41: istore_0
    //   42: iload_0
    //   43: iload_3
    //   44: if_icmpge +371 -> 415
    //   47: aload 8
    //   49: iload_0
    //   50: aaload
    //   51: ldc 39
    //   53: invokevirtual 45	java/lang/ClassLoader:getResources	(Ljava/lang/String;)Ljava/util/Enumeration;
    //   56: astore 9
    //   58: aload 9
    //   60: invokeinterface 51 1 0
    //   65: ifeq +399 -> 464
    //   68: aload 9
    //   70: invokeinterface 55 1 0
    //   75: checkcast 57	java/net/URL
    //   78: astore 10
    //   80: aconst_null
    //   81: astore 7
    //   83: aconst_null
    //   84: astore 4
    //   86: aload 4
    //   88: astore 6
    //   90: aload 7
    //   92: astore 5
    //   94: aload 10
    //   96: instanceof 57
    //   99: ifne +164 -> 263
    //   102: aload 4
    //   104: astore 6
    //   106: aload 7
    //   108: astore 5
    //   110: aload 10
    //   112: invokevirtual 61	java/net/URL:openStream	()Ljava/io/InputStream;
    //   115: astore 4
    //   117: aload 4
    //   119: astore 6
    //   121: aload 4
    //   123: astore 5
    //   125: invokestatic 67	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   128: invokevirtual 71	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   131: astore 7
    //   133: aload 4
    //   135: astore 6
    //   137: aload 4
    //   139: astore 5
    //   141: aload 7
    //   143: ldc 73
    //   145: iconst_1
    //   146: invokeinterface 79 3 0
    //   151: aload 4
    //   153: astore 6
    //   155: aload 4
    //   157: astore 5
    //   159: aload 7
    //   161: aload 4
    //   163: ldc 81
    //   165: invokeinterface 85 3 0
    //   170: aload 4
    //   172: astore 6
    //   174: aload 4
    //   176: astore 5
    //   178: aload 7
    //   180: invokeinterface 89 1 0
    //   185: istore_1
    //   186: iload_1
    //   187: iconst_2
    //   188: if_icmpne +39 -> 227
    //   191: aload 4
    //   193: astore 6
    //   195: aload 4
    //   197: astore 5
    //   199: aload 7
    //   201: invokeinterface 93 1 0
    //   206: ldc 95
    //   208: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifeq +73 -> 284
    //   214: aload 4
    //   216: astore 6
    //   218: aload 4
    //   220: astore 5
    //   222: aload 7
    //   224: invokestatic 104	com/xiaomi/smack/g:a	(Lorg/xmlpull/v1/XmlPullParser;)V
    //   227: aload 4
    //   229: astore 6
    //   231: aload 4
    //   233: astore 5
    //   235: aload 7
    //   237: invokeinterface 107 1 0
    //   242: istore_2
    //   243: iload_2
    //   244: istore_1
    //   245: iload_2
    //   246: iconst_1
    //   247: if_icmpne -61 -> 186
    //   250: aload 4
    //   252: invokevirtual 112	java/io/InputStream:close	()V
    //   255: goto -197 -> 58
    //   258: astore 4
    //   260: goto -202 -> 58
    //   263: aload 4
    //   265: astore 6
    //   267: aload 7
    //   269: astore 5
    //   271: aload 10
    //   273: checkcast 57	java/net/URL
    //   276: invokestatic 117	com/mato/sdk/instrumentation/HttpInstrumentation:openStream	(Ljava/net/URL;)Ljava/io/InputStream;
    //   279: astore 4
    //   281: goto -164 -> 117
    //   284: aload 4
    //   286: astore 6
    //   288: aload 4
    //   290: astore 5
    //   292: aload 7
    //   294: invokeinterface 93 1 0
    //   299: ldc 119
    //   301: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   304: ifeq +49 -> 353
    //   307: aload 4
    //   309: astore 6
    //   311: aload 4
    //   313: astore 5
    //   315: aload 7
    //   317: getstatic 19	com/xiaomi/smack/g:a	I
    //   320: invokestatic 122	com/xiaomi/smack/g:a	(Lorg/xmlpull/v1/XmlPullParser;I)I
    //   323: putstatic 19	com/xiaomi/smack/g:a	I
    //   326: goto -99 -> 227
    //   329: astore 4
    //   331: aload 6
    //   333: astore 5
    //   335: aload 4
    //   337: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   340: aload 6
    //   342: invokevirtual 112	java/io/InputStream:close	()V
    //   345: goto -287 -> 58
    //   348: astore 4
    //   350: goto -292 -> 58
    //   353: aload 4
    //   355: astore 6
    //   357: aload 4
    //   359: astore 5
    //   361: aload 7
    //   363: invokeinterface 93 1 0
    //   368: ldc 127
    //   370: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   373: ifeq +43 -> 416
    //   376: aload 4
    //   378: astore 6
    //   380: aload 4
    //   382: astore 5
    //   384: aload 7
    //   386: getstatic 22	com/xiaomi/smack/g:b	I
    //   389: invokestatic 122	com/xiaomi/smack/g:a	(Lorg/xmlpull/v1/XmlPullParser;I)I
    //   392: putstatic 22	com/xiaomi/smack/g:b	I
    //   395: goto -168 -> 227
    //   398: astore 4
    //   400: aload 5
    //   402: invokevirtual 112	java/io/InputStream:close	()V
    //   405: aload 4
    //   407: athrow
    //   408: astore 4
    //   410: aload 4
    //   412: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   415: return
    //   416: aload 4
    //   418: astore 6
    //   420: aload 4
    //   422: astore 5
    //   424: aload 7
    //   426: invokeinterface 93 1 0
    //   431: ldc -127
    //   433: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   436: ifeq -209 -> 227
    //   439: aload 4
    //   441: astore 6
    //   443: aload 4
    //   445: astore 5
    //   447: getstatic 34	com/xiaomi/smack/g:e	Ljava/util/Vector;
    //   450: aload 7
    //   452: invokeinterface 132 1 0
    //   457: invokevirtual 135	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   460: pop
    //   461: goto -234 -> 227
    //   464: iload_0
    //   465: iconst_1
    //   466: iadd
    //   467: istore_0
    //   468: goto -426 -> 42
    //   471: astore 5
    //   473: goto -68 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	427	0	i	int
    //   185	60	1	j	int
    //   242	6	2	k	int
    //   39	6	3	m	int
    //   84	167	4	localInputStream1	java.io.InputStream
    //   258	6	4	localException1	Exception
    //   279	33	4	localInputStream2	java.io.InputStream
    //   329	7	4	localException2	Exception
    //   348	33	4	localException3	Exception
    //   398	8	4	localObject1	Object
    //   408	36	4	localException4	Exception
    //   92	354	5	localObject2	Object
    //   471	1	5	localException5	Exception
    //   88	354	6	localObject3	Object
    //   81	370	7	localXmlPullParser	XmlPullParser
    //   34	14	8	arrayOfClassLoader	ClassLoader[]
    //   56	13	9	localEnumeration	java.util.Enumeration
    //   78	194	10	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   250	255	258	java/lang/Exception
    //   94	102	329	java/lang/Exception
    //   110	117	329	java/lang/Exception
    //   125	133	329	java/lang/Exception
    //   141	151	329	java/lang/Exception
    //   159	170	329	java/lang/Exception
    //   178	186	329	java/lang/Exception
    //   199	214	329	java/lang/Exception
    //   222	227	329	java/lang/Exception
    //   235	243	329	java/lang/Exception
    //   271	281	329	java/lang/Exception
    //   292	307	329	java/lang/Exception
    //   315	326	329	java/lang/Exception
    //   361	376	329	java/lang/Exception
    //   384	395	329	java/lang/Exception
    //   424	439	329	java/lang/Exception
    //   447	461	329	java/lang/Exception
    //   340	345	348	java/lang/Exception
    //   94	102	398	finally
    //   110	117	398	finally
    //   125	133	398	finally
    //   141	151	398	finally
    //   159	170	398	finally
    //   178	186	398	finally
    //   199	214	398	finally
    //   222	227	398	finally
    //   235	243	398	finally
    //   271	281	398	finally
    //   292	307	398	finally
    //   315	326	398	finally
    //   335	340	398	finally
    //   361	376	398	finally
    //   384	395	398	finally
    //   424	439	398	finally
    //   447	461	398	finally
    //   31	40	408	java/lang/Exception
    //   47	58	408	java/lang/Exception
    //   58	80	408	java/lang/Exception
    //   405	408	408	java/lang/Exception
    //   400	405	471	java/lang/Exception
  }
  
  private static int a(XmlPullParser paramXmlPullParser, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramXmlPullParser.nextText());
      return i;
    }
    catch (NumberFormatException paramXmlPullParser)
    {
      paramXmlPullParser.printStackTrace();
    }
    return paramInt;
  }
  
  public static String a()
  {
    return "3.1.0";
  }
  
  private static void a(XmlPullParser paramXmlPullParser)
  {
    paramXmlPullParser = paramXmlPullParser.nextText();
    try
    {
      Class.forName(paramXmlPullParser);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + paramXmlPullParser);
    }
  }
  
  public static int b()
  {
    return b;
  }
  
  public static int c()
  {
    return c;
  }
  
  private static ClassLoader[] d()
  {
    int i = 0;
    ClassLoader[] arrayOfClassLoader = new ClassLoader[2];
    arrayOfClassLoader[0] = g.class.getClassLoader();
    arrayOfClassLoader[1] = Thread.currentThread().getContextClassLoader();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfClassLoader.length;
    while (i < j)
    {
      ClassLoader localClassLoader = arrayOfClassLoader[i];
      if (localClassLoader != null) {
        localArrayList.add(localClassLoader);
      }
      i += 1;
    }
    return (ClassLoader[])localArrayList.toArray(new ClassLoader[localArrayList.size()]);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */