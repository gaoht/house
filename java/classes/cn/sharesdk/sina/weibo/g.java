package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.e;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import java.util.Iterator;
import java.util.List;

public class g
{
  private static final Uri a = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");
  private static g b;
  private static a c = null;
  
  public static g a()
  {
    try
    {
      if (b == null) {
        b = new g();
      }
      g localg = b;
      return localg;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = MobSDK.getContext().getPackageManager().getPackageInfo(paramString, 64);
      return a(paramString.signatures, "18da2bf10352443a00a5e046d9fca6bd");
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
  
  private static boolean a(Signature[] paramArrayOfSignature, String paramString)
  {
    if ((paramArrayOfSignature == null) || (paramString == null)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfSignature.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(Data.MD5(paramArrayOfSignature[i].toByteArray())))
        {
          e.b().d("check pass", new Object[0]);
          return true;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  private a b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: invokestatic 49	com/mob/MobSDK:getContext	()Landroid/content/Context;
    //   12: aload_1
    //   13: iconst_2
    //   14: invokevirtual 112	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   17: astore 4
    //   19: sipush 4096
    //   22: newarray <illegal type>
    //   24: astore 6
    //   26: aload 4
    //   28: invokevirtual 116	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   31: ldc 118
    //   33: invokevirtual 124	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore 5
    //   38: aload 5
    //   40: astore 4
    //   42: new 126	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   49: astore 7
    //   51: aload 5
    //   53: astore 4
    //   55: aload 5
    //   57: aload 6
    //   59: iconst_0
    //   60: sipush 4096
    //   63: invokevirtual 133	java/io/InputStream:read	([BII)I
    //   66: istore_2
    //   67: iload_2
    //   68: iconst_m1
    //   69: if_icmpeq +77 -> 146
    //   72: aload 5
    //   74: astore 4
    //   76: aload 7
    //   78: new 86	java/lang/String
    //   81: dup
    //   82: aload 6
    //   84: iconst_0
    //   85: iload_2
    //   86: invokespecial 136	java/lang/String:<init>	([BII)V
    //   89: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: goto -42 -> 51
    //   96: astore_1
    //   97: aload 5
    //   99: astore 4
    //   101: invokestatic 95	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   104: aload_1
    //   105: invokevirtual 144	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   108: iconst_0
    //   109: anewarray 4	java/lang/Object
    //   112: invokevirtual 147	com/mob/tools/log/NLog:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   115: pop
    //   116: aload 5
    //   118: ifnull -111 -> 7
    //   121: aload 5
    //   123: invokevirtual 150	java/io/InputStream:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_1
    //   129: invokestatic 95	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   132: aload_1
    //   133: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
    //   136: iconst_0
    //   137: anewarray 4	java/lang/Object
    //   140: invokevirtual 147	com/mob/tools/log/NLog:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   143: pop
    //   144: aconst_null
    //   145: areturn
    //   146: aload 5
    //   148: astore 4
    //   150: aload 7
    //   152: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne +16 -> 174
    //   161: aload 5
    //   163: astore 4
    //   165: aload_1
    //   166: invokestatic 156	cn/sharesdk/sina/weibo/g:a	(Ljava/lang/String;)Z
    //   169: istore_3
    //   170: iload_3
    //   171: ifne +33 -> 204
    //   174: aload 5
    //   176: ifnull -169 -> 7
    //   179: aload 5
    //   181: invokevirtual 150	java/io/InputStream:close	()V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_1
    //   187: invokestatic 95	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   190: aload_1
    //   191: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
    //   194: iconst_0
    //   195: anewarray 4	java/lang/Object
    //   198: invokevirtual 147	com/mob/tools/log/NLog:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   201: pop
    //   202: aconst_null
    //   203: areturn
    //   204: aload 5
    //   206: astore 4
    //   208: new 158	org/json/JSONObject
    //   211: dup
    //   212: aload 7
    //   214: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokespecial 161	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   220: ldc -93
    //   222: iconst_m1
    //   223: invokevirtual 167	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   226: istore_2
    //   227: aload 5
    //   229: astore 4
    //   231: new 6	cn/sharesdk/sina/weibo/g$a
    //   234: dup
    //   235: invokespecial 168	cn/sharesdk/sina/weibo/g$a:<init>	()V
    //   238: astore 6
    //   240: aload 5
    //   242: astore 4
    //   244: aload 6
    //   246: aload_1
    //   247: invokestatic 171	cn/sharesdk/sina/weibo/g$a:a	(Lcn/sharesdk/sina/weibo/g$a;Ljava/lang/String;)V
    //   250: aload 5
    //   252: astore 4
    //   254: aload 6
    //   256: iload_2
    //   257: invokestatic 174	cn/sharesdk/sina/weibo/g$a:a	(Lcn/sharesdk/sina/weibo/g$a;I)V
    //   260: aload 5
    //   262: ifnull +8 -> 270
    //   265: aload 5
    //   267: invokevirtual 150	java/io/InputStream:close	()V
    //   270: aload 6
    //   272: areturn
    //   273: astore_1
    //   274: invokestatic 95	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   277: aload_1
    //   278: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
    //   281: iconst_0
    //   282: anewarray 4	java/lang/Object
    //   285: invokevirtual 147	com/mob/tools/log/NLog:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   288: pop
    //   289: goto -19 -> 270
    //   292: astore_1
    //   293: aconst_null
    //   294: astore 5
    //   296: aload 5
    //   298: astore 4
    //   300: invokestatic 95	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   303: aload_1
    //   304: invokevirtual 175	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   307: iconst_0
    //   308: anewarray 4	java/lang/Object
    //   311: invokevirtual 147	com/mob/tools/log/NLog:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   314: pop
    //   315: aload 5
    //   317: ifnull -310 -> 7
    //   320: aload 5
    //   322: invokevirtual 150	java/io/InputStream:close	()V
    //   325: aconst_null
    //   326: areturn
    //   327: astore_1
    //   328: invokestatic 95	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   331: aload_1
    //   332: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
    //   335: iconst_0
    //   336: anewarray 4	java/lang/Object
    //   339: invokevirtual 147	com/mob/tools/log/NLog:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   342: pop
    //   343: aconst_null
    //   344: areturn
    //   345: astore_1
    //   346: aconst_null
    //   347: astore 4
    //   349: aload 4
    //   351: ifnull +8 -> 359
    //   354: aload 4
    //   356: invokevirtual 150	java/io/InputStream:close	()V
    //   359: aload_1
    //   360: athrow
    //   361: astore 4
    //   363: invokestatic 95	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   366: aload 4
    //   368: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
    //   371: iconst_0
    //   372: anewarray 4	java/lang/Object
    //   375: invokevirtual 147	com/mob/tools/log/NLog:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   378: pop
    //   379: goto -20 -> 359
    //   382: astore_1
    //   383: goto -34 -> 349
    //   386: astore_1
    //   387: goto -91 -> 296
    //   390: astore_1
    //   391: aconst_null
    //   392: astore 5
    //   394: goto -297 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	g
    //   0	397	1	paramString	String
    //   66	191	2	i	int
    //   169	2	3	bool	boolean
    //   17	338	4	localObject1	Object
    //   361	6	4	localIOException	java.io.IOException
    //   36	357	5	localInputStream	java.io.InputStream
    //   24	247	6	localObject2	Object
    //   49	164	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   42	51	96	android/content/pm/PackageManager$NameNotFoundException
    //   55	67	96	android/content/pm/PackageManager$NameNotFoundException
    //   76	93	96	android/content/pm/PackageManager$NameNotFoundException
    //   150	161	96	android/content/pm/PackageManager$NameNotFoundException
    //   165	170	96	android/content/pm/PackageManager$NameNotFoundException
    //   208	227	96	android/content/pm/PackageManager$NameNotFoundException
    //   231	240	96	android/content/pm/PackageManager$NameNotFoundException
    //   244	250	96	android/content/pm/PackageManager$NameNotFoundException
    //   254	260	96	android/content/pm/PackageManager$NameNotFoundException
    //   121	126	128	java/io/IOException
    //   179	184	186	java/io/IOException
    //   265	270	273	java/io/IOException
    //   9	38	292	java/lang/Exception
    //   320	325	327	java/io/IOException
    //   9	38	345	finally
    //   354	359	361	java/io/IOException
    //   42	51	382	finally
    //   55	67	382	finally
    //   76	93	382	finally
    //   101	116	382	finally
    //   150	161	382	finally
    //   165	170	382	finally
    //   208	227	382	finally
    //   231	240	382	finally
    //   244	250	382	finally
    //   254	260	382	finally
    //   300	315	382	finally
    //   42	51	386	java/lang/Exception
    //   55	67	386	java/lang/Exception
    //   76	93	386	java/lang/Exception
    //   150	161	386	java/lang/Exception
    //   165	170	386	java/lang/Exception
    //   208	227	386	java/lang/Exception
    //   231	240	386	java/lang/Exception
    //   244	250	386	java/lang/Exception
    //   254	260	386	java/lang/Exception
    //   9	38	390	android/content/pm/PackageManager$NameNotFoundException
  }
  
  private a c()
  {
    int j = 1;
    a locala1 = d();
    a locala2 = e();
    int i;
    if (locala1 != null)
    {
      i = 1;
      if (locala2 == null) {
        break label51;
      }
      label24:
      if ((i == 0) || (j == 0)) {
        break label59;
      }
      if (locala1.b() < locala2.b()) {
        break label56;
      }
    }
    label51:
    label56:
    label59:
    while (i != 0)
    {
      return locala1;
      i = 0;
      break;
      j = 0;
      break label24;
      return locala2;
    }
    if (j != 0) {
      return locala2;
    }
    return null;
  }
  
  /* Error */
  private a d()
  {
    // Byte code:
    //   0: invokestatic 49	com/mob/MobSDK:getContext	()Landroid/content/Context;
    //   3: invokevirtual 189	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore 4
    //   8: aload 4
    //   10: getstatic 24	cn/sharesdk/sina/weibo/g:a	Landroid/net/Uri;
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: invokevirtual 195	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnonnull +21 -> 45
    //   27: aload 5
    //   29: ifnull +10 -> 39
    //   32: aload 5
    //   34: invokeinterface 198 1 0
    //   39: aconst_null
    //   40: astore 4
    //   42: aload 4
    //   44: areturn
    //   45: aload 5
    //   47: astore 4
    //   49: aload 5
    //   51: ldc -93
    //   53: invokeinterface 202 2 0
    //   58: istore_1
    //   59: aload 5
    //   61: astore 4
    //   63: aload 5
    //   65: ldc -52
    //   67: invokeinterface 202 2 0
    //   72: istore_2
    //   73: aload 5
    //   75: astore 4
    //   77: aload 5
    //   79: ldc -50
    //   81: invokeinterface 202 2 0
    //   86: istore_3
    //   87: aload 5
    //   89: astore 4
    //   91: aload 5
    //   93: invokeinterface 210 1 0
    //   98: ifeq +155 -> 253
    //   101: aload 5
    //   103: astore 4
    //   105: aload 5
    //   107: iload_1
    //   108: invokeinterface 214 2 0
    //   113: astore 6
    //   115: aload 5
    //   117: astore 4
    //   119: aload 6
    //   121: invokestatic 219	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: istore_1
    //   125: aload 5
    //   127: astore 4
    //   129: aload 5
    //   131: iload_2
    //   132: invokeinterface 214 2 0
    //   137: astore 7
    //   139: iload_3
    //   140: ifle +16 -> 156
    //   143: aload 5
    //   145: astore 4
    //   147: aload 5
    //   149: iload_3
    //   150: invokeinterface 214 2 0
    //   155: pop
    //   156: aload 5
    //   158: astore 4
    //   160: aload 7
    //   162: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifne +88 -> 253
    //   168: aload 5
    //   170: astore 4
    //   172: aload 7
    //   174: invokestatic 156	cn/sharesdk/sina/weibo/g:a	(Ljava/lang/String;)Z
    //   177: ifeq +76 -> 253
    //   180: aload 5
    //   182: astore 4
    //   184: new 6	cn/sharesdk/sina/weibo/g$a
    //   187: dup
    //   188: invokespecial 168	cn/sharesdk/sina/weibo/g$a:<init>	()V
    //   191: astore 6
    //   193: aload 5
    //   195: astore 4
    //   197: aload 6
    //   199: aload 7
    //   201: invokestatic 171	cn/sharesdk/sina/weibo/g$a:a	(Lcn/sharesdk/sina/weibo/g$a;Ljava/lang/String;)V
    //   204: aload 5
    //   206: astore 4
    //   208: aload 6
    //   210: iload_1
    //   211: invokestatic 174	cn/sharesdk/sina/weibo/g$a:a	(Lcn/sharesdk/sina/weibo/g$a;I)V
    //   214: aload 6
    //   216: astore 4
    //   218: aload 5
    //   220: ifnull -178 -> 42
    //   223: aload 5
    //   225: invokeinterface 198 1 0
    //   230: aload 6
    //   232: areturn
    //   233: astore 6
    //   235: aload 5
    //   237: astore 4
    //   239: invokestatic 95	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   242: aload 6
    //   244: invokevirtual 222	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   247: pop
    //   248: iconst_m1
    //   249: istore_1
    //   250: goto -125 -> 125
    //   253: aload 5
    //   255: ifnull +10 -> 265
    //   258: aload 5
    //   260: invokeinterface 198 1 0
    //   265: aconst_null
    //   266: areturn
    //   267: astore 6
    //   269: aconst_null
    //   270: astore 5
    //   272: aload 5
    //   274: astore 4
    //   276: invokestatic 95	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   279: aload 6
    //   281: invokevirtual 175	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   284: iconst_0
    //   285: anewarray 4	java/lang/Object
    //   288: invokevirtual 147	com/mob/tools/log/NLog:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   291: pop
    //   292: aload 5
    //   294: ifnull -29 -> 265
    //   297: aload 5
    //   299: invokeinterface 198 1 0
    //   304: goto -39 -> 265
    //   307: astore 5
    //   309: aconst_null
    //   310: astore 4
    //   312: aload 4
    //   314: ifnull +10 -> 324
    //   317: aload 4
    //   319: invokeinterface 198 1 0
    //   324: aload 5
    //   326: athrow
    //   327: astore 5
    //   329: goto -17 -> 312
    //   332: astore 6
    //   334: goto -62 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	g
    //   58	192	1	i	int
    //   72	60	2	j	int
    //   86	64	3	k	int
    //   6	312	4	localObject1	Object
    //   20	278	5	localCursor	android.database.Cursor
    //   307	18	5	localObject2	Object
    //   327	1	5	localObject3	Object
    //   113	118	6	localObject4	Object
    //   233	10	6	localNumberFormatException	NumberFormatException
    //   267	13	6	localException1	Exception
    //   332	1	6	localException2	Exception
    //   137	63	7	str	String
    // Exception table:
    //   from	to	target	type
    //   119	125	233	java/lang/NumberFormatException
    //   8	22	267	java/lang/Exception
    //   8	22	307	finally
    //   49	59	327	finally
    //   63	73	327	finally
    //   77	87	327	finally
    //   91	101	327	finally
    //   105	115	327	finally
    //   119	125	327	finally
    //   129	139	327	finally
    //   147	156	327	finally
    //   160	168	327	finally
    //   172	180	327	finally
    //   184	193	327	finally
    //   197	204	327	finally
    //   208	214	327	finally
    //   239	248	327	finally
    //   276	292	327	finally
    //   49	59	332	java/lang/Exception
    //   63	73	332	java/lang/Exception
    //   77	87	332	java/lang/Exception
    //   91	101	332	java/lang/Exception
    //   105	115	332	java/lang/Exception
    //   119	125	332	java/lang/Exception
    //   129	139	332	java/lang/Exception
    //   147	156	332	java/lang/Exception
    //   160	168	332	java/lang/Exception
    //   172	180	332	java/lang/Exception
    //   184	193	332	java/lang/Exception
    //   197	204	332	java/lang/Exception
    //   208	214	332	java/lang/Exception
    //   239	248	332	java/lang/Exception
  }
  
  private a e()
  {
    Object localObject1 = null;
    a locala = null;
    Object localObject2 = new Intent("com.sina.weibo.action.sdkidentity");
    ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
    Object localObject3 = MobSDK.getContext().getPackageManager().queryIntentServices((Intent)localObject2, 0);
    localObject2 = locala;
    if (localObject3 != null)
    {
      if (!((List)localObject3).isEmpty()) {
        break label55;
      }
      localObject2 = locala;
    }
    label55:
    do
    {
      return (a)localObject2;
      localObject3 = ((List)localObject3).iterator();
      localObject2 = localObject1;
    } while (!((Iterator)localObject3).hasNext());
    localObject2 = (ResolveInfo)((Iterator)localObject3).next();
    if ((((ResolveInfo)localObject2).serviceInfo != null) && (((ResolveInfo)localObject2).serviceInfo.applicationInfo != null) && (!TextUtils.isEmpty(((ResolveInfo)localObject2).serviceInfo.applicationInfo.packageName)))
    {
      locala = b(((ResolveInfo)localObject2).serviceInfo.applicationInfo.packageName);
      if (locala != null) {
        if (localObject1 == null) {
          localObject2 = locala;
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      break;
      localObject2 = locala;
      if (((a)localObject1).b() >= locala.b()) {
        localObject2 = localObject1;
      }
    }
  }
  
  public String b()
  {
    try
    {
      if (c == null) {
        c = c();
      }
      String str = c.a();
      return str;
    }
    finally {}
  }
  
  public static class a
  {
    private String a = "com.sina.weibo";
    private String b = "com.sina.weibo.SSOActivity";
    private int c;
    
    private void a(int paramInt)
    {
      this.c = paramInt;
    }
    
    private void a(String paramString)
    {
      this.a = paramString;
    }
    
    public String a()
    {
      return this.a;
    }
    
    public int b()
    {
      return this.c;
    }
    
    public String toString()
    {
      return "WeiboInfo: PackageName = " + this.a + ", supportApi = " + this.c;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/sina/weibo/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */