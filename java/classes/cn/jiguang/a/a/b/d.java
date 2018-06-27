package cn.jiguang.a.a.b;

import android.content.Context;
import cn.jiguang.c.d.l;
import cn.jiguang.f.h;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements Thread.UncaughtExceptionHandler
{
  private static d b;
  private static final String[] z;
  public boolean a = true;
  private Lock c = new ReentrantLock();
  private FileLock d;
  private Thread.UncaughtExceptionHandler e = null;
  private Context f;
  
  static
  {
    String[] arrayOfString = new String[29];
    int j = 0;
    Object localObject2 = "&XRp*!^Rp$";
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
        i = 65;
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
        localObject2 = "\020^A|3";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "#IA`(:BP|%0";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "6^R`)!E^v";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\020TPv1!E\\}";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = ";Y_";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "#IA`(:B]r,0";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = ";IGd.'GGj10";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "8I@` 2I";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "6CF}5";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = ";IGd.'Glg8%I";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "<XZ~$";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "1IEz\"0sZ}':";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "!UCv";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "6^R`)\n@\\t";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "6^R`)9CT`";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "0BRq-0\fPa &D\023a$%CAg";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "1E@r#9I\023p34_[330\\\\a5";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "\037|F`)\026^R`)\035M]w-0^";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "?\\F`)\nY]p  K[g$-OVc5<C]L'<@V";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "'IC|3!xJc$u[R`a;Y_mu^Vg4'B";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = " B{r/1@V330\\\\a5uXJc$t";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "\024OGz.;\f\036330\\\\a5\026^R`)\031CT3\":BGv9!\fZ`a;Y_";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "\024OGz.;\f\036330\\\\a5\026^R`)\031CT3&0X\023u(9I\023~4!I@3'4E_v%u";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "uIKg34e]u.o";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "\024OGz.;\f\0363)4BW$\034BU|\0230\\\\a5u^Vc.'Xgj10\026";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "\024OGz.;\f\0363%0@Vg$\026^R`)\031CT3\":BGv9!\fZ`a;Y_";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "8YGv9";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "\024OGz.;\f\0363&0Xuz-0aFg$-\fP|/!IKga<_\023}49@";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        b = new d();
        return;
        i = 85;
        continue;
        i = 44;
        continue;
        i = 51;
        continue;
        i = 19;
      }
    }
  }
  
  public static d a()
  {
    return b;
  }
  
  /* Error */
  private JSONArray a(Context paramContext, JSONArray paramJSONArray, Throwable paramThrowable, String paramString)
  {
    // Byte code:
    //   0: new 126	java/io/StringWriter
    //   3: dup
    //   4: invokespecial 127	java/io/StringWriter:<init>	()V
    //   7: astore 7
    //   9: aload_3
    //   10: new 129	java/io/PrintWriter
    //   13: dup
    //   14: aload 7
    //   16: invokespecial 132	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   19: invokevirtual 138	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   22: aload 7
    //   24: invokevirtual 141	java/io/StringWriter:toString	()Ljava/lang/String;
    //   27: astore 9
    //   29: aload_2
    //   30: astore 7
    //   32: aload_2
    //   33: ifnonnull +12 -> 45
    //   36: new 143	org/json/JSONArray
    //   39: dup
    //   40: invokespecial 144	org/json/JSONArray:<init>	()V
    //   43: astore 7
    //   45: new 146	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   52: aload 4
    //   54: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_3
    //   58: invokevirtual 152	java/lang/Throwable:toString	()Ljava/lang/String;
    //   61: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore_2
    //   68: aload_2
    //   69: ldc -101
    //   71: invokevirtual 159	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   74: astore_3
    //   75: aload_2
    //   76: astore 4
    //   78: aload_3
    //   79: arraylength
    //   80: iconst_1
    //   81: if_icmple +53 -> 134
    //   84: aload_3
    //   85: arraylength
    //   86: iconst_1
    //   87: isub
    //   88: istore 5
    //   90: aload_2
    //   91: astore 4
    //   93: iload 5
    //   95: iflt +39 -> 134
    //   98: aload_3
    //   99: iload 5
    //   101: aaload
    //   102: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   105: iconst_4
    //   106: aaload
    //   107: invokevirtual 163	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   110: ifne +18 -> 128
    //   113: aload_3
    //   114: iload 5
    //   116: aaload
    //   117: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   120: iconst_1
    //   121: aaload
    //   122: invokevirtual 163	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   125: ifeq +489 -> 614
    //   128: aload_3
    //   129: iload 5
    //   131: aaload
    //   132: astore 4
    //   134: iconst_0
    //   135: istore 5
    //   137: aload 7
    //   139: astore_2
    //   140: aload 7
    //   142: astore_3
    //   143: iload 5
    //   145: aload 7
    //   147: invokevirtual 167	org/json/JSONArray:length	()I
    //   150: if_icmpge +455 -> 605
    //   153: aload 7
    //   155: astore_2
    //   156: aload 7
    //   158: astore_3
    //   159: aload 7
    //   161: iload 5
    //   163: invokevirtual 171	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   166: astore 8
    //   168: aload 8
    //   170: ifnull +453 -> 623
    //   173: aload 7
    //   175: astore_2
    //   176: aload 7
    //   178: astore_3
    //   179: aload 9
    //   181: aload 8
    //   183: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   186: iconst_0
    //   187: aaload
    //   188: invokevirtual 177	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   191: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifeq +429 -> 623
    //   197: aload 7
    //   199: astore_2
    //   200: aload 7
    //   202: astore_3
    //   203: aload 8
    //   205: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   208: bipush 9
    //   210: aaload
    //   211: invokevirtual 185	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   214: istore 6
    //   216: aload 7
    //   218: astore_2
    //   219: aload 7
    //   221: astore_3
    //   222: aload 8
    //   224: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   227: bipush 9
    //   229: aaload
    //   230: iload 6
    //   232: iconst_1
    //   233: iadd
    //   234: invokevirtual 189	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   237: pop
    //   238: aload 7
    //   240: astore_2
    //   241: aload 7
    //   243: astore_3
    //   244: aload 8
    //   246: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   249: iconst_3
    //   250: aaload
    //   251: invokestatic 195	cn/jiguang/c/a/a:h	()J
    //   254: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   257: pop
    //   258: aload 8
    //   260: ifnull +30 -> 290
    //   263: aload 7
    //   265: astore_2
    //   266: aload 7
    //   268: astore_3
    //   269: aload 7
    //   271: iload 5
    //   273: invokestatic 201	cn/jiguang/a/a/b/d:a	(Lorg/json/JSONArray;I)Lorg/json/JSONArray;
    //   276: astore_1
    //   277: aload_1
    //   278: astore_2
    //   279: aload_1
    //   280: astore_3
    //   281: aload_1
    //   282: aload 8
    //   284: invokevirtual 204	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   287: pop
    //   288: aload_1
    //   289: areturn
    //   290: aload 7
    //   292: astore_2
    //   293: aload 7
    //   295: astore_3
    //   296: new 173	org/json/JSONObject
    //   299: dup
    //   300: invokespecial 205	org/json/JSONObject:<init>	()V
    //   303: astore 8
    //   305: aload 7
    //   307: astore_2
    //   308: aload 7
    //   310: astore_3
    //   311: aload 8
    //   313: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   316: iconst_3
    //   317: aaload
    //   318: invokestatic 195	cn/jiguang/c/a/a:h	()J
    //   321: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   324: pop
    //   325: aload 7
    //   327: astore_2
    //   328: aload 7
    //   330: astore_3
    //   331: aload 8
    //   333: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   336: iconst_0
    //   337: aaload
    //   338: aload 9
    //   340: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   343: pop
    //   344: aload 7
    //   346: astore_2
    //   347: aload 7
    //   349: astore_3
    //   350: aload 8
    //   352: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   355: bipush 8
    //   357: aaload
    //   358: aload 4
    //   360: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   363: pop
    //   364: aload 7
    //   366: astore_2
    //   367: aload 7
    //   369: astore_3
    //   370: aload 8
    //   372: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   375: bipush 9
    //   377: aaload
    //   378: iconst_1
    //   379: invokevirtual 189	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   382: pop
    //   383: aload 7
    //   385: astore_2
    //   386: aload 7
    //   388: astore_3
    //   389: aload_0
    //   390: getfield 114	cn/jiguang/a/a/b/d:f	Landroid/content/Context;
    //   393: ifnonnull +7 -> 400
    //   396: aload_1
    //   397: ifnull +25 -> 422
    //   400: aload 7
    //   402: astore_2
    //   403: aload 7
    //   405: astore_3
    //   406: aload 8
    //   408: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   411: bipush 7
    //   413: aaload
    //   414: aload_1
    //   415: invokestatic 213	cn/jiguang/f/a:c	(Landroid/content/Context;)Ljava/lang/String;
    //   418: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   421: pop
    //   422: aload 7
    //   424: astore_2
    //   425: aload 7
    //   427: astore_3
    //   428: aload_0
    //   429: getfield 114	cn/jiguang/a/a/b/d:f	Landroid/content/Context;
    //   432: ifnull +124 -> 556
    //   435: aload 7
    //   437: astore_2
    //   438: aload 7
    //   440: astore_3
    //   441: aload_0
    //   442: getfield 114	cn/jiguang/a/a/b/d:f	Landroid/content/Context;
    //   445: invokevirtual 219	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   448: aload_0
    //   449: getfield 114	cn/jiguang/a/a/b/d:f	Landroid/content/Context;
    //   452: invokevirtual 222	android/content/Context:getPackageName	()Ljava/lang/String;
    //   455: iconst_1
    //   456: invokevirtual 228	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   459: astore 4
    //   461: aload 4
    //   463: ifnull +93 -> 556
    //   466: aload 7
    //   468: astore_2
    //   469: aload 7
    //   471: astore_3
    //   472: aload 4
    //   474: getfield 234	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   477: ifnonnull +96 -> 573
    //   480: aload 7
    //   482: astore_2
    //   483: aload 7
    //   485: astore_3
    //   486: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   489: iconst_5
    //   490: aaload
    //   491: astore_1
    //   492: aload 7
    //   494: astore_2
    //   495: aload 7
    //   497: astore_3
    //   498: new 146	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   505: aload 4
    //   507: getfield 238	android/content/pm/PackageInfo:versionCode	I
    //   510: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   513: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: astore 4
    //   518: aload 7
    //   520: astore_2
    //   521: aload 7
    //   523: astore_3
    //   524: aload 8
    //   526: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   529: bipush 6
    //   531: aaload
    //   532: aload_1
    //   533: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   536: pop
    //   537: aload 7
    //   539: astore_2
    //   540: aload 7
    //   542: astore_3
    //   543: aload 8
    //   545: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   548: iconst_2
    //   549: aaload
    //   550: aload 4
    //   552: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   555: pop
    //   556: aload 7
    //   558: astore_2
    //   559: aload 7
    //   561: astore_3
    //   562: aload 7
    //   564: aload 8
    //   566: invokevirtual 204	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   569: pop
    //   570: aload 7
    //   572: areturn
    //   573: aload 7
    //   575: astore_2
    //   576: aload 7
    //   578: astore_3
    //   579: aload 4
    //   581: getfield 234	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   584: astore_1
    //   585: goto -93 -> 492
    //   588: astore_1
    //   589: aload_2
    //   590: areturn
    //   591: astore_3
    //   592: aload_2
    //   593: astore 4
    //   595: goto -461 -> 134
    //   598: astore_3
    //   599: aload_2
    //   600: astore 4
    //   602: goto -468 -> 134
    //   605: iconst_0
    //   606: istore 5
    //   608: aconst_null
    //   609: astore 8
    //   611: goto -353 -> 258
    //   614: iload 5
    //   616: iconst_1
    //   617: isub
    //   618: istore 5
    //   620: goto -530 -> 90
    //   623: iload 5
    //   625: iconst_1
    //   626: iadd
    //   627: istore 5
    //   629: goto -492 -> 137
    //   632: astore_1
    //   633: aload_3
    //   634: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	635	0	this	d
    //   0	635	1	paramContext	Context
    //   0	635	2	paramJSONArray	JSONArray
    //   0	635	3	paramThrowable	Throwable
    //   0	635	4	paramString	String
    //   88	540	5	i	int
    //   214	20	6	j	int
    //   7	570	7	localObject	Object
    //   166	444	8	localJSONObject	JSONObject
    //   27	312	9	str	String
    // Exception table:
    //   from	to	target	type
    //   143	153	588	android/content/pm/PackageManager$NameNotFoundException
    //   159	168	588	android/content/pm/PackageManager$NameNotFoundException
    //   179	197	588	android/content/pm/PackageManager$NameNotFoundException
    //   203	216	588	android/content/pm/PackageManager$NameNotFoundException
    //   222	238	588	android/content/pm/PackageManager$NameNotFoundException
    //   244	258	588	android/content/pm/PackageManager$NameNotFoundException
    //   269	277	588	android/content/pm/PackageManager$NameNotFoundException
    //   281	288	588	android/content/pm/PackageManager$NameNotFoundException
    //   296	305	588	android/content/pm/PackageManager$NameNotFoundException
    //   311	325	588	android/content/pm/PackageManager$NameNotFoundException
    //   331	344	588	android/content/pm/PackageManager$NameNotFoundException
    //   350	364	588	android/content/pm/PackageManager$NameNotFoundException
    //   370	383	588	android/content/pm/PackageManager$NameNotFoundException
    //   389	396	588	android/content/pm/PackageManager$NameNotFoundException
    //   406	422	588	android/content/pm/PackageManager$NameNotFoundException
    //   428	435	588	android/content/pm/PackageManager$NameNotFoundException
    //   441	461	588	android/content/pm/PackageManager$NameNotFoundException
    //   472	480	588	android/content/pm/PackageManager$NameNotFoundException
    //   486	492	588	android/content/pm/PackageManager$NameNotFoundException
    //   498	518	588	android/content/pm/PackageManager$NameNotFoundException
    //   524	537	588	android/content/pm/PackageManager$NameNotFoundException
    //   543	556	588	android/content/pm/PackageManager$NameNotFoundException
    //   562	570	588	android/content/pm/PackageManager$NameNotFoundException
    //   579	585	588	android/content/pm/PackageManager$NameNotFoundException
    //   68	75	591	java/util/regex/PatternSyntaxException
    //   78	90	591	java/util/regex/PatternSyntaxException
    //   98	128	591	java/util/regex/PatternSyntaxException
    //   68	75	598	java/lang/NullPointerException
    //   78	90	598	java/lang/NullPointerException
    //   98	128	598	java/lang/NullPointerException
    //   143	153	632	org/json/JSONException
    //   159	168	632	org/json/JSONException
    //   179	197	632	org/json/JSONException
    //   203	216	632	org/json/JSONException
    //   222	238	632	org/json/JSONException
    //   244	258	632	org/json/JSONException
    //   269	277	632	org/json/JSONException
    //   281	288	632	org/json/JSONException
    //   296	305	632	org/json/JSONException
    //   311	325	632	org/json/JSONException
    //   331	344	632	org/json/JSONException
    //   350	364	632	org/json/JSONException
    //   370	383	632	org/json/JSONException
    //   389	396	632	org/json/JSONException
    //   406	422	632	org/json/JSONException
    //   428	435	632	org/json/JSONException
    //   441	461	632	org/json/JSONException
    //   472	480	632	org/json/JSONException
    //   486	492	632	org/json/JSONException
    //   498	518	632	org/json/JSONException
    //   524	537	632	org/json/JSONException
    //   543	556	632	org/json/JSONException
    //   562	570	632	org/json/JSONException
    //   579	585	632	org/json/JSONException
  }
  
  private static JSONArray a(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray == null) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if ((i >= paramJSONArray.length()) || (i != paramInt)) {}
      try
      {
        localJSONArray.put(paramJSONArray.get(i));
        i += 1;
        continue;
        return localJSONArray;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    cn.jiguang.d.d.a(z[18], z[25] + paramString1 + z[24] + paramString2);
    if (h.a(paramString1)) {
      cn.jiguang.d.d.a(z[18], z[20]);
    }
    do
    {
      return;
      if (!paramString1.equals(z[14])) {
        break;
      }
      paramString1 = b;
      if (paramContext == null)
      {
        cn.jiguang.d.d.g(z[18], z[22]);
        return;
      }
    } while (!cn.jiguang.c.a.a.s());
    if (paramString1.g(paramContext))
    {
      paramString2 = e(paramContext);
      if (paramString2 != null)
      {
        l.a(paramContext, paramString2);
        d(paramContext);
      }
      paramString1.b();
      return;
    }
    cn.jiguang.d.d.a(z[18], z[23]);
    return;
    cn.jiguang.d.d.g(z[18], z[21]);
  }
  
  private static void a(Context paramContext, JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.toString();
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0) && (paramContext != null)) {}
    try
    {
      paramContext = paramContext.openFileOutput(z[19], 0);
      paramContext.write(paramJSONArray.getBytes());
      paramContext.flush();
      paramContext.close();
      return;
    }
    catch (IOException paramContext) {}catch (FileNotFoundException paramContext) {}
  }
  
  private void b()
  {
    if (this.d != null) {}
    try
    {
      this.d.release();
      this.c.unlock();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public static void d(Context paramContext)
  {
    if (paramContext == null) {
      cn.jiguang.d.d.g(z[18], z[26]);
    }
    do
    {
      return;
      paramContext = new File(paramContext.getFilesDir(), z[19]);
    } while (!paramContext.exists());
    paramContext.delete();
  }
  
  public static JSONObject e(Context paramContext)
  {
    Object localObject = f(paramContext);
    if (localObject == null) {
      paramContext = null;
    }
    JSONObject localJSONObject;
    for (;;)
    {
      return paramContext;
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put(z[15], localObject);
        localJSONObject.put(z[11], cn.jiguang.c.a.a.g());
        localJSONObject.put(z[13], z[14]);
        localJSONObject.put(z[10], cn.jiguang.f.a.c(paramContext));
        localObject = new JSONObject(b.a(paramContext));
        paramContext = localJSONObject;
        if (((JSONObject)localObject).length() > 0)
        {
          localJSONObject.put(z[12], localObject);
          return localJSONObject;
        }
      }
      catch (JSONException paramContext)
      {
        return localJSONObject;
      }
      catch (Exception paramContext) {}
    }
    return localJSONObject;
  }
  
  /* Error */
  private static JSONArray f(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 324	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokevirtual 328	android/content/Context:getFilesDir	()Ljava/io/File;
    //   13: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   16: bipush 19
    //   18: aaload
    //   19: invokespecial 331	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: invokevirtual 334	java/io/File:exists	()Z
    //   25: ifne +8 -> 33
    //   28: aload 4
    //   30: astore_0
    //   31: aload_0
    //   32: areturn
    //   33: aload_0
    //   34: getstatic 96	cn/jiguang/a/a/b/d:z	[Ljava/lang/String;
    //   37: bipush 19
    //   39: aaload
    //   40: invokevirtual 357	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   43: astore_2
    //   44: aload_2
    //   45: astore_0
    //   46: sipush 1024
    //   49: newarray <illegal type>
    //   51: astore 6
    //   53: aload_2
    //   54: astore_0
    //   55: new 359	java/lang/StringBuffer
    //   58: dup
    //   59: invokespecial 360	java/lang/StringBuffer:<init>	()V
    //   62: astore 5
    //   64: aload_2
    //   65: astore_0
    //   66: aload_2
    //   67: aload 6
    //   69: invokevirtual 366	java/io/FileInputStream:read	([B)I
    //   72: istore_1
    //   73: iload_1
    //   74: iconst_m1
    //   75: if_icmpeq +52 -> 127
    //   78: aload_2
    //   79: astore_0
    //   80: aload 5
    //   82: new 24	java/lang/String
    //   85: dup
    //   86: aload 6
    //   88: iconst_0
    //   89: iload_1
    //   90: invokespecial 369	java/lang/String:<init>	([BII)V
    //   93: invokevirtual 372	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   96: pop
    //   97: goto -33 -> 64
    //   100: astore_3
    //   101: aload_2
    //   102: astore_0
    //   103: aload_3
    //   104: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   107: aload 4
    //   109: astore_0
    //   110: aload_2
    //   111: ifnull -80 -> 31
    //   114: aload_2
    //   115: invokevirtual 375	java/io/FileInputStream:close	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: aload_0
    //   122: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   125: aconst_null
    //   126: areturn
    //   127: aload_2
    //   128: astore_0
    //   129: aload 5
    //   131: invokevirtual 377	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   134: invokevirtual 288	java/lang/String:length	()I
    //   137: ifle +18 -> 155
    //   140: aload_2
    //   141: astore_0
    //   142: new 143	org/json/JSONArray
    //   145: dup
    //   146: aload 5
    //   148: invokevirtual 377	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   151: invokespecial 378	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   154: astore_3
    //   155: aload_3
    //   156: astore_0
    //   157: aload_2
    //   158: ifnull -127 -> 31
    //   161: aload_2
    //   162: invokevirtual 375	java/io/FileInputStream:close	()V
    //   165: aload_3
    //   166: areturn
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   172: aload_3
    //   173: areturn
    //   174: astore_2
    //   175: aconst_null
    //   176: astore_0
    //   177: aload_0
    //   178: ifnull +7 -> 185
    //   181: aload_0
    //   182: invokevirtual 375	java/io/FileInputStream:close	()V
    //   185: aload_2
    //   186: athrow
    //   187: astore_0
    //   188: aload_0
    //   189: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   192: goto -7 -> 185
    //   195: astore_2
    //   196: goto -19 -> 177
    //   199: astore_3
    //   200: aconst_null
    //   201: astore_2
    //   202: goto -101 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramContext	Context
    //   72	18	1	i	int
    //   43	119	2	localFileInputStream	java.io.FileInputStream
    //   174	12	2	localObject1	Object
    //   195	1	2	localObject2	Object
    //   201	1	2	localObject3	Object
    //   1	1	3	localObject4	Object
    //   100	4	3	localException1	Exception
    //   154	19	3	localJSONArray	JSONArray
    //   199	1	3	localException2	Exception
    //   3	105	4	localObject5	Object
    //   62	85	5	localStringBuffer	StringBuffer
    //   51	36	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   46	53	100	java/lang/Exception
    //   55	64	100	java/lang/Exception
    //   66	73	100	java/lang/Exception
    //   80	97	100	java/lang/Exception
    //   129	140	100	java/lang/Exception
    //   142	155	100	java/lang/Exception
    //   114	118	120	java/io/IOException
    //   161	165	167	java/io/IOException
    //   33	44	174	finally
    //   181	185	187	java/io/IOException
    //   46	53	195	finally
    //   55	64	195	finally
    //   66	73	195	finally
    //   80	97	195	finally
    //   103	107	195	finally
    //   129	140	195	finally
    //   142	155	195	finally
    //   33	44	199	java/lang/Exception
  }
  
  private boolean g(Context paramContext)
  {
    if (paramContext == null) {
      cn.jiguang.d.d.g(z[18], z[28]);
    }
    for (;;)
    {
      return false;
      if (this.c.tryLock()) {
        try
        {
          this.d = paramContext.openFileOutput(z[27], 0).getChannel().tryLock();
          paramContext = this.d;
          if (paramContext != null) {
            return true;
          }
        }
        catch (IOException paramContext) {}
      }
    }
    return false;
  }
  
  public final void a(Context paramContext)
  {
    this.f = paramContext;
    if (this.e == null) {
      this.e = Thread.getDefaultUncaughtExceptionHandler();
    }
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  public final void b(Context paramContext)
  {
    this.f = paramContext;
    this.a = true;
  }
  
  public final void c(Context paramContext)
  {
    this.f = paramContext;
    this.a = false;
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject;
    if (this.a)
    {
      cn.jiguang.d.d.a(z[18], z[16]);
      localObject = this.f;
      localObject = a((Context)localObject, f((Context)localObject), paramThrowable, "");
      d(this.f);
      a(this.f, (JSONArray)localObject);
      localObject = new e(this);
      ((e)localObject).start();
    }
    try
    {
      ((e)localObject).join(2000L);
      for (;;)
      {
        if (this.e != this) {
          this.e.uncaughtException(paramThread, paramThrowable);
        }
        throw new RuntimeException(paramThrowable);
        cn.jiguang.d.d.a(z[18], z[17]);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */