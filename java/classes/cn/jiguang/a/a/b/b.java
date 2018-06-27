package cn.jiguang.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.jiguang.c.a.a;
import cn.jiguang.c.d.l;
import cn.jiguang.d.d;
import cn.jiguang.f.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static final String a;
  private static Map<String, String> b;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[14];
    int j = 0;
    Object localObject2 = "{O%m\016N[5h\017rZ\017w\bwP";
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
        i = 102;
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
        localObject2 = "xK9s\003";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "rO%A\017Y?";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "|P4{\n";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "b\\\"{\003L9d\003";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "eV={\034~Q5";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "p\\$w\t\005\"{\026~M$Z\003gV3{/Y?";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "~L\017h\003cL9q\b";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "cZ#q\ndK9q\b";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "eF {";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "}^>y\023pX5";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "uZ&w\005t`9p\000~";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "b[;A\020tM#w\t";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "2\021`";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = b.class.getSimpleName();
        b = null;
        return;
        i = 17;
        continue;
        i = 63;
        continue;
        i = 80;
        continue;
        i = 30;
      }
    }
  }
  
  /* Error */
  public static Map<String, String> a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: new 74	java/util/HashMap
    //   6: dup
    //   7: invokespecial 75	java/util/HashMap:<init>	()V
    //   10: astore 12
    //   12: invokestatic 79	cn/jiguang/f/a:b	()Ljava/lang/String;
    //   15: astore 4
    //   17: aload_0
    //   18: invokestatic 82	cn/jiguang/f/a:a	(Landroid/content/Context;)Ljava/lang/String;
    //   21: astore 7
    //   23: new 84	java/text/DecimalFormat
    //   26: dup
    //   27: getstatic 57	cn/jiguang/a/a/b/b:z	[Ljava/lang/String;
    //   30: bipush 13
    //   32: aaload
    //   33: invokespecial 87	java/text/DecimalFormat:<init>	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: invokestatic 91	cn/jiguang/f/a:o	(Landroid/content/Context;)D
    //   40: invokevirtual 95	java/text/DecimalFormat:format	(D)Ljava/lang/String;
    //   43: astore 6
    //   45: new 97	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   52: getstatic 103	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   55: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 5
    //   63: getstatic 115	android/os/Build:MODEL	Ljava/lang/String;
    //   66: astore 8
    //   68: aload_0
    //   69: invokevirtual 121	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   72: invokevirtual 127	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   75: getfield 133	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   78: invokevirtual 136	java/util/Locale:toString	()Ljava/lang/String;
    //   81: astore_0
    //   82: invokestatic 142	java/util/TimeZone:getDefault	()Ljava/util/TimeZone;
    //   85: invokevirtual 146	java/util/TimeZone:getRawOffset	()I
    //   88: ldc -109
    //   90: idiv
    //   91: i2l
    //   92: lstore_1
    //   93: lload_1
    //   94: lconst_0
    //   95: lcmp
    //   96: ifle +254 -> 350
    //   99: new 97	java/lang/StringBuilder
    //   102: dup
    //   103: ldc -107
    //   105: invokespecial 150	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: lload_1
    //   109: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_3
    //   116: getstatic 57	cn/jiguang/a/a/b/b:z	[Ljava/lang/String;
    //   119: iconst_2
    //   120: aaload
    //   121: astore 10
    //   123: aload 4
    //   125: astore 9
    //   127: aload 4
    //   129: invokestatic 158	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   132: ifeq +7 -> 139
    //   135: ldc -96
    //   137: astore 9
    //   139: aload 12
    //   141: aload 10
    //   143: aload 9
    //   145: invokeinterface 166 3 0
    //   150: pop
    //   151: getstatic 57	cn/jiguang/a/a/b/b:z	[Ljava/lang/String;
    //   154: bipush 8
    //   156: aaload
    //   157: astore 9
    //   159: aload 7
    //   161: astore 4
    //   163: aload 7
    //   165: invokestatic 158	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   168: ifeq +7 -> 175
    //   171: ldc -96
    //   173: astore 4
    //   175: aload 12
    //   177: aload 9
    //   179: aload 4
    //   181: invokeinterface 166 3 0
    //   186: pop
    //   187: getstatic 57	cn/jiguang/a/a/b/b:z	[Ljava/lang/String;
    //   190: bipush 7
    //   192: aaload
    //   193: astore 7
    //   195: aload 5
    //   197: astore 4
    //   199: aload 5
    //   201: invokestatic 158	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   204: ifeq +7 -> 211
    //   207: ldc -96
    //   209: astore 4
    //   211: aload 12
    //   213: aload 7
    //   215: aload 4
    //   217: invokeinterface 166 3 0
    //   222: pop
    //   223: getstatic 57	cn/jiguang/a/a/b/b:z	[Ljava/lang/String;
    //   226: bipush 10
    //   228: aaload
    //   229: astore 5
    //   231: aload_0
    //   232: astore 4
    //   234: aload_0
    //   235: invokestatic 158	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   238: ifeq +7 -> 245
    //   241: ldc -96
    //   243: astore 4
    //   245: aload 12
    //   247: aload 5
    //   249: aload 4
    //   251: invokeinterface 166 3 0
    //   256: pop
    //   257: getstatic 57	cn/jiguang/a/a/b/b:z	[Ljava/lang/String;
    //   260: iconst_5
    //   261: aaload
    //   262: astore 4
    //   264: aload_3
    //   265: astore_0
    //   266: aload_3
    //   267: invokestatic 158	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   270: ifeq +6 -> 276
    //   273: ldc -96
    //   275: astore_0
    //   276: aload 12
    //   278: aload 4
    //   280: aload_0
    //   281: invokeinterface 166 3 0
    //   286: pop
    //   287: getstatic 57	cn/jiguang/a/a/b/b:z	[Ljava/lang/String;
    //   290: iconst_3
    //   291: aaload
    //   292: astore_3
    //   293: aload 8
    //   295: astore_0
    //   296: aload 8
    //   298: invokestatic 158	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   301: ifeq +6 -> 307
    //   304: ldc -96
    //   306: astore_0
    //   307: aload 12
    //   309: aload_3
    //   310: aload_0
    //   311: invokeinterface 166 3 0
    //   316: pop
    //   317: getstatic 57	cn/jiguang/a/a/b/b:z	[Ljava/lang/String;
    //   320: iconst_4
    //   321: aaload
    //   322: astore_3
    //   323: aload 6
    //   325: astore_0
    //   326: aload 6
    //   328: invokestatic 158	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   331: ifeq +6 -> 337
    //   334: ldc -96
    //   336: astore_0
    //   337: aload 12
    //   339: aload_3
    //   340: aload_0
    //   341: invokeinterface 166 3 0
    //   346: pop
    //   347: aload 12
    //   349: areturn
    //   350: lload_1
    //   351: lconst_0
    //   352: lcmp
    //   353: ifge +23 -> 376
    //   356: new 97	java/lang/StringBuilder
    //   359: dup
    //   360: ldc -88
    //   362: invokespecial 150	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   365: lload_1
    //   366: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   369: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: astore_3
    //   373: goto -257 -> 116
    //   376: new 97	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   383: lload_1
    //   384: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   387: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: astore_3
    //   391: goto -275 -> 116
    //   394: astore 4
    //   396: aconst_null
    //   397: astore_3
    //   398: aconst_null
    //   399: astore_0
    //   400: aconst_null
    //   401: astore 5
    //   403: aconst_null
    //   404: astore 7
    //   406: aconst_null
    //   407: astore 9
    //   409: aconst_null
    //   410: astore 6
    //   412: getstatic 64	cn/jiguang/a/a/b/b:a	Ljava/lang/String;
    //   415: aload 4
    //   417: invokevirtual 171	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   420: invokestatic 177	cn/jiguang/d/d:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: aload_3
    //   424: astore 8
    //   426: aload 11
    //   428: astore_3
    //   429: aload 9
    //   431: astore 4
    //   433: goto -317 -> 116
    //   436: astore 8
    //   438: aconst_null
    //   439: astore_3
    //   440: aconst_null
    //   441: astore_0
    //   442: aconst_null
    //   443: astore 5
    //   445: aconst_null
    //   446: astore 7
    //   448: aconst_null
    //   449: astore 6
    //   451: aload 4
    //   453: astore 9
    //   455: aload 8
    //   457: astore 4
    //   459: goto -47 -> 412
    //   462: astore 8
    //   464: aconst_null
    //   465: astore_3
    //   466: aconst_null
    //   467: astore_0
    //   468: aconst_null
    //   469: astore 5
    //   471: aconst_null
    //   472: astore 6
    //   474: aload 4
    //   476: astore 9
    //   478: aload 8
    //   480: astore 4
    //   482: goto -70 -> 412
    //   485: astore 8
    //   487: aconst_null
    //   488: astore_0
    //   489: aconst_null
    //   490: astore 5
    //   492: aconst_null
    //   493: astore_3
    //   494: aload 4
    //   496: astore 9
    //   498: aload 8
    //   500: astore 4
    //   502: goto -90 -> 412
    //   505: astore 8
    //   507: aconst_null
    //   508: astore_0
    //   509: aconst_null
    //   510: astore_3
    //   511: aload 4
    //   513: astore 9
    //   515: aload 8
    //   517: astore 4
    //   519: goto -107 -> 412
    //   522: astore 10
    //   524: aconst_null
    //   525: astore_0
    //   526: aload 8
    //   528: astore_3
    //   529: aload 4
    //   531: astore 9
    //   533: aload 10
    //   535: astore 4
    //   537: goto -125 -> 412
    //   540: astore 10
    //   542: aload 8
    //   544: astore_3
    //   545: aload 4
    //   547: astore 9
    //   549: aload 10
    //   551: astore 4
    //   553: goto -141 -> 412
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	paramContext	Context
    //   92	292	1	l	long
    //   115	430	3	localObject1	Object
    //   15	264	4	localObject2	Object
    //   394	22	4	localException1	Exception
    //   431	121	4	localObject3	Object
    //   61	430	5	str1	String
    //   43	430	6	str2	String
    //   21	426	7	str3	String
    //   66	359	8	localObject4	Object
    //   436	20	8	localException2	Exception
    //   462	17	8	localException3	Exception
    //   485	14	8	localException4	Exception
    //   505	38	8	localException5	Exception
    //   125	423	9	localObject5	Object
    //   121	21	10	str4	String
    //   522	12	10	localException6	Exception
    //   540	10	10	localException7	Exception
    //   1	426	11	localObject6	Object
    //   10	338	12	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   12	17	394	java/lang/Exception
    //   17	23	436	java/lang/Exception
    //   23	45	462	java/lang/Exception
    //   45	63	485	java/lang/Exception
    //   63	68	505	java/lang/Exception
    //   68	82	522	java/lang/Exception
    //   82	93	540	java/lang/Exception
    //   99	116	540	java/lang/Exception
    //   356	373	540	java/lang/Exception
    //   376	391	540	java/lang/Exception
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences(z[0], 0).edit();
    paramContext.putString(z[12], paramString);
    paramContext.commit();
  }
  
  private static void a(Context paramContext, Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    do
    {
      return;
      localObject = paramMap.keySet();
    } while ((localObject == null) || (((Set)localObject).size() <= 0));
    paramContext = paramContext.getSharedPreferences(z[0], 0).edit();
    Object localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      paramContext.putString(str, (String)paramMap.get(str));
    }
    paramContext.commit();
  }
  
  public static String b(Context paramContext)
  {
    return paramContext.getSharedPreferences(z[0], 0).getString(z[12], null);
  }
  
  public static void c(Context paramContext)
  {
    d.c(a, z[6]);
    if (!a.s()) {}
    label247:
    label277:
    label306:
    label335:
    label363:
    label477:
    label483:
    label489:
    label495:
    label501:
    label506:
    label525:
    for (;;)
    {
      return;
      Map localMap = a(paramContext);
      if ((localMap != null) && (!localMap.isEmpty()))
      {
        Object localObject;
        String str6;
        String str4;
        String str5;
        String str3;
        String str2;
        String str1;
        int i;
        if (b == null)
        {
          HashMap localHashMap = new HashMap();
          localObject = paramContext.getSharedPreferences(z[0], 0);
          String str7 = ((SharedPreferences)localObject).getString(z[2], null);
          str6 = ((SharedPreferences)localObject).getString(z[8], null);
          str4 = ((SharedPreferences)localObject).getString(z[10], null);
          str5 = ((SharedPreferences)localObject).getString(z[7], null);
          str3 = ((SharedPreferences)localObject).getString(z[5], null);
          str2 = ((SharedPreferences)localObject).getString(z[3], null);
          str1 = ((SharedPreferences)localObject).getString(z[4], null);
          String str8 = z[2];
          localObject = str7;
          if (h.a(str7)) {
            localObject = "";
          }
          localHashMap.put(str8, localObject);
          str7 = z[8];
          if (h.a(str6))
          {
            localObject = "";
            localHashMap.put(str7, localObject);
            str6 = z[7];
            if (!h.a(str5)) {
              break label477;
            }
            localObject = "";
            localHashMap.put(str6, localObject);
            str5 = z[10];
            if (!h.a(str4)) {
              break label483;
            }
            localObject = "";
            localHashMap.put(str5, localObject);
            str4 = z[5];
            if (!h.a(str3)) {
              break label489;
            }
            localObject = "";
            localHashMap.put(str4, localObject);
            str3 = z[3];
            if (!h.a(str2)) {
              break label495;
            }
            localObject = "";
            localHashMap.put(str3, localObject);
            str2 = z[4];
            if (!h.a(str1)) {
              break label501;
            }
            localObject = "";
            localHashMap.put(str2, localObject);
            b = localHashMap;
          }
        }
        else
        {
          localObject = b;
          if ((localObject != null) && (!((Map)localObject).isEmpty())) {
            break label506;
          }
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label525;
          }
          b = localMap;
          a(paramContext, localMap);
          try
          {
            localObject = new JSONObject(localMap);
            ((JSONObject)localObject).put(z[1], a.g());
            ((JSONObject)localObject).put(z[9], z[11]);
            l.a(paramContext, (JSONObject)localObject);
            return;
          }
          catch (JSONException paramContext)
          {
            d.i(a, paramContext.getMessage());
            return;
          }
          localObject = str6;
          break;
          localObject = str5;
          break label247;
          localObject = str4;
          break label277;
          localObject = str3;
          break label306;
          localObject = str2;
          break label335;
          localObject = str1;
          break label363;
          if (!localMap.equals(localObject)) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */