package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.c.f;
import cn.jpush.android.d;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.data.e;
import cn.jpush.android.data.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{
  private static a a;
  private static ExecutorService b;
  private static e f;
  private static g g;
  private static Object h;
  private static final String[] z;
  private Handler c = null;
  private Context d = null;
  private String e = "";
  
  static
  {
    String[] arrayOfString = new String[30];
    int j = 0;
    Object localObject2 = "[&oD\t\\*zD\000[\026oT\037P";
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
        i = 111;
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
        localObject2 = "V'5G\037@:s\003\016[-iB\006QgrC\033P'o\003!z\035Rk&v\bOd {\026Ih,p\000Mh+j\031Ib7l";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\031n^\007y&xL\003{&oD\t\\*zY\006Z'XH\001A,i";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "X,h^\016R,";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "T9kd\013";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "F,uI\nG\000";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "P'\r#Z*zA!Z=rK\006V(oD\000[iy_\000T-XL\034A\035t}\032F!IH\fP mH\035";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\0339~_\002\\:hD\000[gQ}:f\001D`*f\032Zj*";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "F=z_\033\025\005tN\016Y\007tY\006S xL\033\\&u\r\rG&zI,T:oy\000e<hE=P*~D\031P;";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "A;rJ\bP;Wc$\\%w}\035Z*~^\034";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "A;rJ\bP;Wc$\\%w}\035Z*~^\034\017i";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "Y&xL\003j'tY\006S xL\033\\&u";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "V'5G\037@:s\003\016[-iB\006QgrC\033P'o\003\"`\005Od0e\033Tn*f\032";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "T*oD\000[";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "X<wY\006j=b]\n";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "E&hYOG |E\033\025'tZO";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "E&hYOQ,wL\026P-;\027O";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "[&oD\t\\*zY\006Z';D\034\025'nA\003";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "y&xL\003{&oD\t\\*zY\006Z';^\f],X\003P\033~L\013\\,a!";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "y&xL\003{&oD\t\\*zY\006Z';B\001},z_\033w,zY";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "\\'rYOy&xL\003{&oD\t\\*zY\006Z';N\016F=;H\027E=!";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "\\'rYOy&xL\003{&oD\t\\*zY\006Z'";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "G,vB\031PiWB\fT%UB\033\\/rN\016A tCO";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "G,vB\031PiwB\fT%;N\000@'o\rU\025";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "\025:nN\fP:h";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "V%~L\035\025(wAOY&xL\003\025'tY\006S xL\033\\&u\r";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "v&u^\033G<xY\000Gi!\r%e<hE#Z*zA!Z=rK\006V(oD\000[\n~C\033P;";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "E<hEO](h\r\034A&k]\nQ";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "T-\r#Z*zA!Z=rK\006V(oD\000[";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        j = 29;
        localObject2 = "R,od\001F=zC\fP";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = null;
        b = Executors.newSingleThreadExecutor();
        f = null;
        g = new g();
        h = new Object();
        return;
        i = 53;
        continue;
        i = 73;
        continue;
        i = 27;
        continue;
        i = 45;
      }
    }
  }
  
  private a(Context paramContext)
  {
    f.c(z[2], z[26]);
    this.c = new Handler(Looper.getMainLooper());
    this.d = paramContext;
    this.e = this.d.getPackageName();
  }
  
  public static a a(Context paramContext)
  {
    f.c(z[2], z[29]);
    synchronized (h)
    {
      if (a == null) {
        a = new a(paramContext);
      }
      return a;
    }
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        f.c(z[2], z[18]);
        if (paramLong1 < 0L)
        {
          f.i(z[2], z[17]);
          return;
        }
        if (this.c == null) {
          continue;
        }
        c localc = new c(this, paramLong1);
        if (paramLong2 <= 0L)
        {
          f.c(z[2], z[15]);
          this.c.post(localc);
          continue;
        }
        f.c(z[2], z[16] + paramLong2);
      }
      finally {}
      this.c.postDelayed(localRunnable, paramLong2);
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    f.c(z[2], z[8]);
    Intent localIntent = new Intent(z[1]);
    localIntent.putExtra(z[5], paramString3);
    localIntent.putExtra(z[4], paramString2);
    localIntent.putExtra(z[3], paramString1);
    localIntent.putExtra(z[0], 1);
    localIntent.addCategory(paramString2);
    paramContext.sendOrderedBroadcast(localIntent, paramString2 + z[7]);
    f.c(z[2], z[6]);
  }
  
  /* Error */
  private boolean a(Context paramContext, JPushLocalNotification paramJPushLocalNotification)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   5: iconst_2
    //   6: aaload
    //   7: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   10: bipush 28
    //   12: aaload
    //   13: invokestatic 221	cn/jpush/android/c/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   19: lstore_3
    //   20: aload_2
    //   21: invokevirtual 232	cn/jpush/android/data/JPushLocalNotification:getBroadcastTime	()J
    //   24: lload_3
    //   25: lsub
    //   26: lstore 5
    //   28: aload_1
    //   29: invokestatic 237	cn/jpush/android/service/ServiceInterface:d	(Landroid/content/Context;)Z
    //   32: ifeq +17 -> 49
    //   35: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   38: iconst_2
    //   39: aaload
    //   40: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   43: bipush 27
    //   45: aaload
    //   46: invokestatic 136	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   52: ifnonnull +14 -> 66
    //   55: new 239	cn/jpush/android/data/e
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 240	cn/jpush/android/data/e:<init>	(Landroid/content/Context;)V
    //   63: putstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   66: aconst_null
    //   67: astore_1
    //   68: aload_1
    //   69: astore 7
    //   71: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   74: iconst_1
    //   75: invokevirtual 243	cn/jpush/android/data/e:a	(Z)Z
    //   78: pop
    //   79: aload_1
    //   80: astore 7
    //   82: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   85: aload_2
    //   86: invokevirtual 246	cn/jpush/android/data/JPushLocalNotification:getNotificationId	()J
    //   89: iconst_0
    //   90: invokevirtual 249	cn/jpush/android/data/e:a	(JI)Landroid/database/Cursor;
    //   93: astore_1
    //   94: aload_1
    //   95: astore 7
    //   97: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   100: aload_1
    //   101: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   104: invokevirtual 252	cn/jpush/android/data/e:a	(Landroid/database/Cursor;Lcn/jpush/android/data/g;)V
    //   107: aload_1
    //   108: astore 7
    //   110: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   113: invokevirtual 254	cn/jpush/android/data/g:a	()J
    //   116: aload_2
    //   117: invokevirtual 246	cn/jpush/android/data/JPushLocalNotification:getNotificationId	()J
    //   120: lcmp
    //   121: ifeq +71 -> 192
    //   124: aload_1
    //   125: astore 7
    //   127: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   130: aload_2
    //   131: invokevirtual 246	cn/jpush/android/data/JPushLocalNotification:getNotificationId	()J
    //   134: iconst_1
    //   135: iconst_0
    //   136: iconst_0
    //   137: aload_2
    //   138: invokevirtual 257	cn/jpush/android/data/JPushLocalNotification:toJSON	()Ljava/lang/String;
    //   141: aload_2
    //   142: invokevirtual 232	cn/jpush/android/data/JPushLocalNotification:getBroadcastTime	()J
    //   145: lload_3
    //   146: invokevirtual 260	cn/jpush/android/data/e:a	(JIIILjava/lang/String;JJ)J
    //   149: pop2
    //   150: aload_1
    //   151: astore 7
    //   153: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   156: invokevirtual 262	cn/jpush/android/data/e:a	()V
    //   159: aload_1
    //   160: ifnull +9 -> 169
    //   163: aload_1
    //   164: invokeinterface 267 1 0
    //   169: lload 5
    //   171: ldc2_w 268
    //   174: lcmp
    //   175: ifge +87 -> 262
    //   178: aload_0
    //   179: aload_2
    //   180: invokevirtual 246	cn/jpush/android/data/JPushLocalNotification:getNotificationId	()J
    //   183: lload 5
    //   185: invokespecial 271	cn/jpush/android/service/a:a	(JJ)V
    //   188: aload_0
    //   189: monitorexit
    //   190: iconst_1
    //   191: ireturn
    //   192: aload_1
    //   193: astore 7
    //   195: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   198: aload_2
    //   199: invokevirtual 246	cn/jpush/android/data/JPushLocalNotification:getNotificationId	()J
    //   202: iconst_1
    //   203: iconst_0
    //   204: iconst_0
    //   205: aload_2
    //   206: invokevirtual 257	cn/jpush/android/data/JPushLocalNotification:toJSON	()Ljava/lang/String;
    //   209: aload_2
    //   210: invokevirtual 232	cn/jpush/android/data/JPushLocalNotification:getBroadcastTime	()J
    //   213: lload_3
    //   214: invokevirtual 274	cn/jpush/android/data/e:b	(JIIILjava/lang/String;JJ)Z
    //   217: pop
    //   218: goto -68 -> 150
    //   221: astore_1
    //   222: aload 7
    //   224: ifnull -55 -> 169
    //   227: aload 7
    //   229: invokeinterface 267 1 0
    //   234: goto -65 -> 169
    //   237: astore_1
    //   238: aload_0
    //   239: monitorexit
    //   240: aload_1
    //   241: athrow
    //   242: astore_1
    //   243: aconst_null
    //   244: astore 7
    //   246: aload_1
    //   247: astore_2
    //   248: aload 7
    //   250: ifnull +10 -> 260
    //   253: aload 7
    //   255: invokeinterface 267 1 0
    //   260: aload_2
    //   261: athrow
    //   262: goto -74 -> 188
    //   265: astore_2
    //   266: aload_1
    //   267: astore 7
    //   269: goto -21 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	a
    //   0	272	1	paramContext	Context
    //   0	272	2	paramJPushLocalNotification	JPushLocalNotification
    //   19	195	3	l1	long
    //   26	158	5	l2	long
    //   69	199	7	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   71	79	221	java/lang/Exception
    //   82	94	221	java/lang/Exception
    //   97	107	221	java/lang/Exception
    //   110	124	221	java/lang/Exception
    //   127	150	221	java/lang/Exception
    //   153	159	221	java/lang/Exception
    //   195	218	221	java/lang/Exception
    //   2	49	237	finally
    //   49	66	237	finally
    //   163	169	237	finally
    //   178	188	237	finally
    //   227	234	237	finally
    //   253	260	237	finally
    //   260	262	237	finally
    //   71	79	242	finally
    //   82	94	242	finally
    //   97	107	265	finally
    //   110	124	265	finally
    //   127	150	265	finally
    //   153	159	265	finally
    //   195	218	265	finally
  }
  
  /* Error */
  private void e(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   5: iconst_2
    //   6: aaload
    //   7: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   10: bipush 9
    //   12: aaload
    //   13: invokestatic 136	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aconst_null
    //   17: astore 4
    //   19: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   22: ifnonnull +14 -> 36
    //   25: new 239	cn/jpush/android/data/e
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 240	cn/jpush/android/data/e:<init>	(Landroid/content/Context;)V
    //   33: putstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   36: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   39: iconst_1
    //   40: invokevirtual 243	cn/jpush/android/data/e:a	(Z)Z
    //   43: pop
    //   44: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   47: lstore_2
    //   48: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   51: iconst_1
    //   52: lload_2
    //   53: invokevirtual 279	cn/jpush/android/data/e:a	(IJ)Landroid/database/Cursor;
    //   56: astore 5
    //   58: aload 5
    //   60: astore 4
    //   62: aload 4
    //   64: invokeinterface 283 1 0
    //   69: ifeq +75 -> 144
    //   72: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   75: aload 4
    //   77: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   80: invokevirtual 252	cn/jpush/android/data/e:a	(Landroid/database/Cursor;Lcn/jpush/android/data/g;)V
    //   83: aload_0
    //   84: aload_1
    //   85: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   88: invokevirtual 285	cn/jpush/android/data/g:d	()Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 131	cn/jpush/android/service/a:e	Ljava/lang/String;
    //   95: ldc -127
    //   97: invokespecial 216	cn/jpush/android/service/a:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   100: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   103: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   106: invokevirtual 254	cn/jpush/android/data/g:a	()J
    //   109: iconst_0
    //   110: iconst_0
    //   111: iconst_0
    //   112: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   115: invokevirtual 285	cn/jpush/android/data/g:d	()Ljava/lang/String;
    //   118: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   121: invokevirtual 287	cn/jpush/android/data/g:f	()J
    //   124: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   127: invokevirtual 289	cn/jpush/android/data/g:e	()J
    //   130: invokevirtual 274	cn/jpush/android/data/e:b	(JIIILjava/lang/String;JJ)Z
    //   133: pop
    //   134: aload 4
    //   136: invokeinterface 292 1 0
    //   141: ifne -69 -> 72
    //   144: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   147: invokevirtual 262	cn/jpush/android/data/e:a	()V
    //   150: aload 4
    //   152: ifnull +10 -> 162
    //   155: aload 4
    //   157: invokeinterface 267 1 0
    //   162: aload_0
    //   163: monitorexit
    //   164: return
    //   165: astore 5
    //   167: aload 4
    //   169: astore_1
    //   170: aload 5
    //   172: astore 4
    //   174: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   177: iconst_2
    //   178: aaload
    //   179: new 173	java/lang/StringBuilder
    //   182: dup
    //   183: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   186: bipush 10
    //   188: aaload
    //   189: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   192: aload 4
    //   194: invokevirtual 295	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   197: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 297	cn/jpush/android/c/f:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload 4
    //   208: invokevirtual 300	java/lang/Exception:printStackTrace	()V
    //   211: aload_1
    //   212: ifnull -50 -> 162
    //   215: aload_1
    //   216: invokeinterface 267 1 0
    //   221: goto -59 -> 162
    //   224: astore_1
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_1
    //   228: athrow
    //   229: astore_1
    //   230: aconst_null
    //   231: astore 4
    //   233: aload 4
    //   235: ifnull +10 -> 245
    //   238: aload 4
    //   240: invokeinterface 267 1 0
    //   245: aload_1
    //   246: athrow
    //   247: astore_1
    //   248: goto -15 -> 233
    //   251: astore 5
    //   253: aload_1
    //   254: astore 4
    //   256: aload 5
    //   258: astore_1
    //   259: goto -26 -> 233
    //   262: astore 5
    //   264: aload 4
    //   266: astore_1
    //   267: aload 5
    //   269: astore 4
    //   271: goto -97 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	a
    //   0	274	1	paramContext	Context
    //   47	6	2	l	long
    //   17	253	4	localObject1	Object
    //   56	3	5	localCursor	android.database.Cursor
    //   165	6	5	localException1	Exception
    //   251	6	5	localObject2	Object
    //   262	6	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   19	36	165	java/lang/Exception
    //   36	58	165	java/lang/Exception
    //   2	16	224	finally
    //   155	162	224	finally
    //   215	221	224	finally
    //   238	245	224	finally
    //   245	247	224	finally
    //   19	36	229	finally
    //   36	58	229	finally
    //   62	72	247	finally
    //   72	144	247	finally
    //   144	150	247	finally
    //   174	211	251	finally
    //   62	72	262	java/lang/Exception
    //   72	144	262	java/lang/Exception
    //   144	150	262	java/lang/Exception
  }
  
  /* Error */
  public final boolean a(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   5: iconst_2
    //   6: aaload
    //   7: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   10: bipush 22
    //   12: aaload
    //   13: invokestatic 221	cn/jpush/android/c/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   19: ifnonnull +14 -> 33
    //   22: new 239	cn/jpush/android/data/e
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 240	cn/jpush/android/data/e:<init>	(Landroid/content/Context;)V
    //   30: putstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_1
    //   36: astore 4
    //   38: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   41: iconst_1
    //   42: invokevirtual 243	cn/jpush/android/data/e:a	(Z)Z
    //   45: pop
    //   46: aload_1
    //   47: astore 4
    //   49: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   52: lload_2
    //   53: iconst_0
    //   54: invokevirtual 249	cn/jpush/android/data/e:a	(JI)Landroid/database/Cursor;
    //   57: astore_1
    //   58: aload_1
    //   59: astore 4
    //   61: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   64: aload_1
    //   65: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   68: invokevirtual 252	cn/jpush/android/data/e:a	(Landroid/database/Cursor;Lcn/jpush/android/data/g;)V
    //   71: aload_1
    //   72: astore 4
    //   74: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   77: invokevirtual 304	cn/jpush/android/data/g:b	()I
    //   80: ifle +71 -> 151
    //   83: aload_1
    //   84: astore 4
    //   86: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   89: iconst_2
    //   90: aaload
    //   91: new 173	java/lang/StringBuilder
    //   94: dup
    //   95: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   98: bipush 23
    //   100: aaload
    //   101: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   107: invokevirtual 304	cn/jpush/android/data/g:b	()I
    //   110: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 136	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_1
    //   120: astore 4
    //   122: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   125: lload_2
    //   126: iconst_0
    //   127: iconst_1
    //   128: iconst_0
    //   129: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   132: invokevirtual 285	cn/jpush/android/data/g:d	()Ljava/lang/String;
    //   135: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   138: invokevirtual 287	cn/jpush/android/data/g:f	()J
    //   141: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   144: invokevirtual 289	cn/jpush/android/data/g:e	()J
    //   147: invokevirtual 274	cn/jpush/android/data/e:b	(JIIILjava/lang/String;JJ)Z
    //   150: pop
    //   151: aload_1
    //   152: astore 4
    //   154: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   157: invokevirtual 262	cn/jpush/android/data/e:a	()V
    //   160: aload_1
    //   161: ifnull +9 -> 170
    //   164: aload_1
    //   165: invokeinterface 267 1 0
    //   170: aload_0
    //   171: monitorexit
    //   172: iconst_1
    //   173: ireturn
    //   174: astore_1
    //   175: aload 4
    //   177: ifnull -7 -> 170
    //   180: aload 4
    //   182: invokeinterface 267 1 0
    //   187: goto -17 -> 170
    //   190: astore_1
    //   191: aload_0
    //   192: monitorexit
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: aconst_null
    //   197: astore 5
    //   199: aload_1
    //   200: astore 4
    //   202: aload 5
    //   204: ifnull +10 -> 214
    //   207: aload 5
    //   209: invokeinterface 267 1 0
    //   214: aload 4
    //   216: athrow
    //   217: astore 4
    //   219: aload_1
    //   220: astore 5
    //   222: goto -20 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	a
    //   0	225	1	paramContext	Context
    //   0	225	2	paramLong	long
    //   36	179	4	localContext1	Context
    //   217	1	4	localObject	Object
    //   197	24	5	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   38	46	174	java/lang/Exception
    //   49	58	174	java/lang/Exception
    //   61	71	174	java/lang/Exception
    //   74	83	174	java/lang/Exception
    //   86	119	174	java/lang/Exception
    //   122	151	174	java/lang/Exception
    //   154	160	174	java/lang/Exception
    //   2	33	190	finally
    //   164	170	190	finally
    //   180	187	190	finally
    //   207	214	190	finally
    //   214	217	190	finally
    //   38	46	195	finally
    //   49	58	195	finally
    //   61	71	217	finally
    //   74	83	217	finally
    //   86	119	217	finally
    //   122	151	217	finally
    //   154	160	217	finally
  }
  
  public final boolean a(Context paramContext, JPushLocalNotification paramJPushLocalNotification, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        a(paramContext, paramJPushLocalNotification);
        return true;
      }
      finally {}
      Bundle localBundle = new Bundle();
      localBundle.putString(z[13], z[12]);
      localBundle.putInt(z[14], 6);
      localBundle.putSerializable(z[11], paramJPushLocalNotification);
      JCoreInterface.sendAction(paramContext, d.a, localBundle);
    }
  }
  
  public final void b(Context paramContext)
  {
    try
    {
      f.d(z[2], z[25]);
      if (f == null) {
        f = new e(paramContext);
      }
      f.a(true);
      if (f.b()) {
        f.c(z[2], z[24]);
      }
      f.a();
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   5: iconst_2
    //   6: aaload
    //   7: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   10: bipush 21
    //   12: aaload
    //   13: invokestatic 136	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   19: ifnonnull +14 -> 33
    //   22: new 239	cn/jpush/android/data/e
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 240	cn/jpush/android/data/e:<init>	(Landroid/content/Context;)V
    //   30: putstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_1
    //   36: astore 4
    //   38: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   41: iconst_0
    //   42: invokevirtual 243	cn/jpush/android/data/e:a	(Z)Z
    //   45: pop
    //   46: aload_1
    //   47: astore 4
    //   49: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   52: lstore_2
    //   53: aload_1
    //   54: astore 4
    //   56: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   59: lload_2
    //   60: ldc2_w 268
    //   63: invokevirtual 339	cn/jpush/android/data/e:a	(JJ)Landroid/database/Cursor;
    //   66: astore_1
    //   67: aload_1
    //   68: astore 4
    //   70: aload_1
    //   71: invokeinterface 283 1 0
    //   76: ifeq +49 -> 125
    //   79: aload_1
    //   80: astore 4
    //   82: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   85: aload_1
    //   86: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   89: invokevirtual 252	cn/jpush/android/data/e:a	(Landroid/database/Cursor;Lcn/jpush/android/data/g;)V
    //   92: aload_1
    //   93: astore 4
    //   95: aload_0
    //   96: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   99: invokevirtual 254	cn/jpush/android/data/g:a	()J
    //   102: getstatic 118	cn/jpush/android/service/a:g	Lcn/jpush/android/data/g;
    //   105: invokevirtual 287	cn/jpush/android/data/g:f	()J
    //   108: lload_2
    //   109: lsub
    //   110: invokespecial 271	cn/jpush/android/service/a:a	(JJ)V
    //   113: aload_1
    //   114: astore 4
    //   116: aload_1
    //   117: invokeinterface 292 1 0
    //   122: ifne -43 -> 79
    //   125: aload_1
    //   126: astore 4
    //   128: getstatic 112	cn/jpush/android/service/a:f	Lcn/jpush/android/data/e;
    //   131: invokevirtual 262	cn/jpush/android/data/e:a	()V
    //   134: aload_1
    //   135: ifnull +9 -> 144
    //   138: aload_1
    //   139: invokeinterface 267 1 0
    //   144: aload_0
    //   145: monitorexit
    //   146: return
    //   147: astore_1
    //   148: aload 4
    //   150: ifnull -6 -> 144
    //   153: aload 4
    //   155: invokeinterface 267 1 0
    //   160: goto -16 -> 144
    //   163: astore_1
    //   164: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   167: iconst_2
    //   168: aaload
    //   169: new 173	java/lang/StringBuilder
    //   172: dup
    //   173: getstatic 100	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   176: bipush 20
    //   178: aaload
    //   179: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload_1
    //   183: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 136	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_1
    //   193: invokevirtual 300	java/lang/Exception:printStackTrace	()V
    //   196: goto -52 -> 144
    //   199: astore_1
    //   200: aload_0
    //   201: monitorexit
    //   202: aload_1
    //   203: athrow
    //   204: astore_1
    //   205: aconst_null
    //   206: astore 5
    //   208: aload_1
    //   209: astore 4
    //   211: aload 5
    //   213: ifnull +10 -> 223
    //   216: aload 5
    //   218: invokeinterface 267 1 0
    //   223: aload 4
    //   225: athrow
    //   226: astore 4
    //   228: aload_1
    //   229: astore 5
    //   231: goto -20 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	a
    //   0	234	1	paramContext	Context
    //   52	57	2	l	long
    //   36	188	4	localContext1	Context
    //   226	1	4	localObject	Object
    //   206	24	5	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   38	46	147	java/lang/Exception
    //   49	53	147	java/lang/Exception
    //   56	67	147	java/lang/Exception
    //   70	79	147	java/lang/Exception
    //   82	92	147	java/lang/Exception
    //   95	113	147	java/lang/Exception
    //   116	125	147	java/lang/Exception
    //   128	134	147	java/lang/Exception
    //   16	33	163	java/lang/Exception
    //   138	144	163	java/lang/Exception
    //   153	160	163	java/lang/Exception
    //   216	223	163	java/lang/Exception
    //   223	226	163	java/lang/Exception
    //   2	16	199	finally
    //   16	33	199	finally
    //   138	144	199	finally
    //   153	160	199	finally
    //   164	196	199	finally
    //   216	223	199	finally
    //   223	226	199	finally
    //   38	46	204	finally
    //   49	53	204	finally
    //   56	67	204	finally
    //   70	79	226	finally
    //   82	92	226	finally
    //   95	113	226	finally
    //   116	125	226	finally
    //   128	134	226	finally
  }
  
  public final void d(Context paramContext)
  {
    f.c(z[2], z[19]);
    b.execute(new b(this, paramContext));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/service/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */