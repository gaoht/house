package com.tencent.smtt.sdk.a;

import a.a;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.v;
import com.tencent.smtt.utils.w;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class b
{
  public static byte[] a = null;
  
  static
  {
    try
    {
      a = "65dRa93L".getBytes("utf-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
  
  private static String a(Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray();
      if (paramContext != null)
      {
        Object localObject = MessageDigest.getInstance("SHA-1");
        ((MessageDigest)localObject).update(paramContext);
        paramContext = ((MessageDigest)localObject).digest();
        if (paramContext != null)
        {
          localObject = new StringBuilder("");
          if (paramContext != null)
          {
            if (paramContext.length <= 0) {
              return null;
            }
            while (i < paramContext.length)
            {
              String str = Integer.toHexString(paramContext[i] & 0xFF).toUpperCase();
              if (i > 0) {
                ((StringBuilder)localObject).append(":");
              }
              if (str.length() < 2) {
                ((StringBuilder)localObject).append(0);
              }
              ((StringBuilder)localObject).append(str);
              i += 1;
            }
            paramContext = ((StringBuilder)localObject).toString();
            return paramContext;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(a parama, Context paramContext)
  {
    new c("HttpUtils", paramContext, parama).start();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, long paramLong)
  {
    Object localObject3 = "";
    Object localObject2 = localObject3;
    for (;;)
    {
      try
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
        Object localObject1 = localObject3;
        localObject2 = localObject3;
        if ("com.tencent.mobileqq".equals(localApplicationInfo.packageName))
        {
          localObject2 = localObject3;
          localObject3 = paramContext.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0).versionName;
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber()))
          {
            localObject2 = localObject3;
            localObject1 = (String)localObject3 + "." + QbSdk.getQQBuildNumber();
          }
        }
        continue;
      }
      catch (Exception localException)
      {
        try
        {
          localObject2 = new a();
          ((a)localObject2).a = paramContext.getApplicationContext().getApplicationInfo().packageName;
          w.a(paramContext);
          localObject3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
          ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+08"));
          ((a)localObject2).b = ((SimpleDateFormat)localObject3).format(Calendar.getInstance().getTime());
          ((a)localObject2).e = paramString1;
          if (paramBoolean)
          {
            ((a)localObject2).c = paramString2;
            ((a)localObject2).d = paramString3;
            paramString1 = com.tencent.smtt.utils.b.e(paramContext);
            paramString2 = com.tencent.smtt.utils.b.c(paramContext);
            paramString3 = com.tencent.smtt.utils.b.d(paramContext);
            localObject3 = com.tencent.smtt.utils.b.f(paramContext);
            if ((paramString2 != null) && (!"".equals(paramString2))) {
              ((a)localObject2).f = paramString2;
            }
            if ((paramString3 != null) && (!"".equals(paramString3))) {
              ((a)localObject2).g = paramString3;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              ((a)localObject2).m = ((String)localObject3);
            }
            if ((paramString1 != null) && (!"".equals(paramString1))) {
              ((a)localObject2).h = paramString1;
            }
            ((a)localObject2).i = paramInt;
            if (!TbsShareManager.isThirdPartyApp(paramContext)) {
              break;
            }
            if (!paramBoolean) {
              break label405;
            }
            if (TbsShareManager.getCoreFormOwn())
            {
              ((a)localObject2).j = 2;
              ((a)localObject2).k = ((String)localObject1);
              ((a)localObject2).l = a(paramContext);
              if (!paramBoolean)
              {
                ((a)localObject2).n = paramLong;
                ((a)localObject2).o = QbSdk.getTbsVersion(paramContext);
              }
              a((a)localObject2, paramContext);
              return;
              localException = localException;
              localObject1 = localObject2;
              localException.printStackTrace();
            }
          }
          else
          {
            ((a)localObject2).c = v.a(paramContext);
            continue;
          }
          ((a)localObject2).j = 1;
        }
        catch (Throwable paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
      }
      label405:
      ((a)localObject2).j = 0;
    }
    for (;;)
    {
      ((a)localObject2).j = paramInt;
      break;
      do
      {
        paramInt = 0;
        break;
      } while (!paramBoolean);
      paramInt = 1;
    }
  }
  
  /* Error */
  private static org.json.JSONObject c(a parama, Context paramContext)
  {
    // Byte code:
    //   0: new 278	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 279	org/json/JSONObject:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc_w 281
    //   12: aload_0
    //   13: getfield 162	a/a:a	Ljava/lang/String;
    //   16: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   19: pop
    //   20: aload_3
    //   21: ldc_w 287
    //   24: aload_0
    //   25: getfield 200	a/a:b	Ljava/lang/String;
    //   28: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   31: pop
    //   32: aload_3
    //   33: ldc_w 289
    //   36: aload_0
    //   37: getfield 206	a/a:c	Ljava/lang/String;
    //   40: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_3
    //   45: ldc_w 291
    //   48: aload_0
    //   49: getfield 209	a/a:d	Ljava/lang/String;
    //   52: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload_3
    //   57: ldc_w 293
    //   60: aload_0
    //   61: getfield 203	a/a:e	Ljava/lang/String;
    //   64: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload_3
    //   69: ldc_w 295
    //   72: aload_0
    //   73: getfield 222	a/a:f	Ljava/lang/String;
    //   76: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload_3
    //   81: ldc_w 297
    //   84: aload_0
    //   85: getfield 225	a/a:g	Ljava/lang/String;
    //   88: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   91: pop
    //   92: aload_3
    //   93: ldc_w 299
    //   96: aload_0
    //   97: getfield 231	a/a:h	Ljava/lang/String;
    //   100: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   103: pop
    //   104: aload_3
    //   105: ldc_w 301
    //   108: aload_0
    //   109: getfield 235	a/a:i	J
    //   112: invokevirtual 304	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload_3
    //   117: ldc_w 306
    //   120: aload_0
    //   121: getfield 249	a/a:j	I
    //   124: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   127: pop
    //   128: aload_3
    //   129: ldc_w 311
    //   132: aload_0
    //   133: getfield 252	a/a:k	Ljava/lang/String;
    //   136: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload_0
    //   141: getfield 257	a/a:l	Ljava/lang/String;
    //   144: ifnonnull +171 -> 315
    //   147: aload_3
    //   148: ldc_w 313
    //   151: ldc_w 315
    //   154: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload_3
    //   159: ldc_w 317
    //   162: iconst_3
    //   163: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   166: pop
    //   167: aload_3
    //   168: ldc_w 319
    //   171: aload_0
    //   172: getfield 228	a/a:m	Ljava/lang/String;
    //   175: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload_1
    //   180: invokestatic 241	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   183: ifeq +15 -> 198
    //   186: aload_3
    //   187: ldc_w 321
    //   190: aload_1
    //   191: invokestatic 325	com/tencent/smtt/sdk/TbsShareManager:getHostCoreVersions	(Landroid/content/Context;)J
    //   194: invokevirtual 304	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   197: pop
    //   198: aload_0
    //   199: getfield 249	a/a:j	I
    //   202: ifne +67 -> 269
    //   205: aload_3
    //   206: ldc_w 327
    //   209: aload_0
    //   210: getfield 260	a/a:n	J
    //   213: invokevirtual 304	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   216: pop
    //   217: aload_3
    //   218: ldc_w 329
    //   221: aload_0
    //   222: getfield 267	a/a:o	I
    //   225: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   228: pop
    //   229: getstatic 334	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   232: istore_2
    //   233: aload_0
    //   234: getfield 267	a/a:o	I
    //   237: ifgt +105 -> 342
    //   240: aload_3
    //   241: ldc_w 336
    //   244: aload_1
    //   245: invokestatic 341	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   248: invokevirtual 344	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadInterruptCode	()I
    //   251: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   254: pop
    //   255: iload_2
    //   256: iconst_m1
    //   257: if_icmpne +12 -> 269
    //   260: ldc_w 346
    //   263: ldc_w 348
    //   266: invokestatic 353	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: invokestatic 356	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   272: ifnull +41 -> 313
    //   275: aload_0
    //   276: getfield 162	a/a:a	Ljava/lang/String;
    //   279: ldc 125
    //   281: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   284: ifeq +70 -> 354
    //   287: aload_3
    //   288: ldc_w 358
    //   291: invokestatic 363	com/tencent/smtt/utils/p:a	()Lcom/tencent/smtt/utils/p;
    //   294: invokestatic 356	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   297: invokevirtual 366	com/tencent/smtt/utils/p:a	(Ljava/lang/String;)Ljava/lang/String;
    //   300: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload_3
    //   305: ldc_w 368
    //   308: iconst_1
    //   309: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   312: pop
    //   313: aload_3
    //   314: areturn
    //   315: aload_3
    //   316: ldc_w 313
    //   319: aload_0
    //   320: getfield 257	a/a:l	Ljava/lang/String;
    //   323: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   326: pop
    //   327: goto -169 -> 158
    //   330: astore_0
    //   331: ldc_w 346
    //   334: ldc_w 370
    //   337: invokestatic 353	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: aconst_null
    //   341: areturn
    //   342: aload_3
    //   343: ldc_w 336
    //   346: iload_2
    //   347: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   350: pop
    //   351: goto -96 -> 255
    //   354: aload_0
    //   355: getfield 162	a/a:a	Ljava/lang/String;
    //   358: ldc_w 372
    //   361: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   364: ifeq -51 -> 313
    //   367: aload_3
    //   368: ldc_w 358
    //   371: invokestatic 356	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   374: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   377: pop
    //   378: aload_3
    //   379: ldc_w 368
    //   382: iconst_0
    //   383: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   386: pop
    //   387: aload_3
    //   388: areturn
    //   389: astore_0
    //   390: aload_3
    //   391: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	parama	a
    //   0	392	1	paramContext	Context
    //   232	115	2	i	int
    //   7	384	3	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	158	330	java/lang/Exception
    //   158	198	330	java/lang/Exception
    //   198	255	330	java/lang/Exception
    //   260	269	330	java/lang/Exception
    //   315	327	330	java/lang/Exception
    //   342	351	330	java/lang/Exception
    //   269	313	389	java/lang/Exception
    //   354	387	389	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */