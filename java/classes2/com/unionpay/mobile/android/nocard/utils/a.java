package com.unionpay.mobile.android.nocard.utils;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.plugin.c;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class a
{
  private static String a(Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("paydata")) {
        break label35;
      }
      localObject1 = paramBundle.getString("paydata");
    }
    for (;;)
    {
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      return paramBundle;
      label35:
      localObject1 = localObject2;
      if (paramBundle.containsKey("tn")) {
        localObject1 = paramBundle.getString("tn");
      }
    }
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 29
    //   4: ldc 31
    //   6: invokestatic 36	com/unionpay/mobile/android/utils/j:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: ifnull +113 -> 124
    //   14: aload_0
    //   15: invokestatic 41	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_0
    //   19: ldc 29
    //   21: new 43	java/lang/StringBuilder
    //   24: dup
    //   25: ldc 45
    //   27: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 60	com/unionpay/mobile/android/utils/j:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aload_0
    //   42: ifnull +67 -> 109
    //   45: aload_0
    //   46: invokestatic 65	com/unionpay/mobile/android/utils/a:a	(Ljava/lang/String;)[B
    //   49: astore_0
    //   50: aload_2
    //   51: astore_1
    //   52: aload_0
    //   53: ifnull +14 -> 67
    //   56: new 67	java/lang/String
    //   59: dup
    //   60: aload_0
    //   61: ldc 69
    //   63: invokespecial 72	java/lang/String:<init>	([BLjava/lang/String;)V
    //   66: astore_1
    //   67: ldc 29
    //   69: new 43	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 74
    //   75: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_1
    //   79: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 76
    //   84: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 36	com/unionpay/mobile/android/utils/j:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: ldc 29
    //   96: ldc 78
    //   98: invokestatic 36	com/unionpay/mobile/android/utils/j:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   101: pop
    //   102: aload_1
    //   103: areturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   109: aconst_null
    //   110: astore_0
    //   111: goto -61 -> 50
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 83	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   119: aload_2
    //   120: astore_1
    //   121: goto -54 -> 67
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -107 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramString	String
    //   51	70	1	localObject1	Object
    //   1	119	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   45	50	104	java/io/IOException
    //   56	67	114	java/io/UnsupportedEncodingException
  }
  
  public static boolean a(Intent paramIntent, b paramb)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    if (paramIntent == null) {
      return false;
    }
    j.c("uppay", " ===>" + paramIntent.toString());
    String str1 = paramIntent.getDataString();
    paramIntent = paramIntent.getExtras();
    label142:
    label236:
    boolean bool1;
    if ((paramIntent != null) && (paramIntent.containsKey("reqOriginalId")))
    {
      j.c("uppay", " bundle===>" + paramIntent.toString());
      paramb.I.a = paramIntent.getInt("reqOriginalId");
      j.b("uppay", "reqID:" + paramb.I.a);
      paramb.I.e = paramIntent.getBoolean("invokedbyplugin");
      if (paramIntent == null) {
        break label446;
      }
      paramb.aM = paramIntent.getBoolean("dlgstyle", false);
      String str2 = paramIntent.getString("url_index");
      if ((str2 != null) && (h.c(str2))) {
        paramb.aO = Integer.parseInt(str2);
      }
      str2 = paramIntent.getString("server");
      if ((str2 != null) && (!TextUtils.isEmpty(str2))) {
        paramb.bj = str2;
      }
      com.unionpay.mobile.android.global.a.M = paramIntent.getInt("navbargb", -10705958);
      com.unionpay.mobile.android.global.a.N = paramIntent.getInt("divlinecolor", -13268007);
      switch (paramb.I.a)
      {
      default: 
        bool1 = bool4;
        label311:
        if ((paramb.aM) && (!b.bl))
        {
          com.unionpay.mobile.android.global.b.b = -1;
          com.unionpay.mobile.android.global.b.c = -2513882;
          com.unionpay.mobile.android.global.b.d = 58791;
        }
        if ((paramb.I.a == 2) || (paramb.I.a == 5) || (paramb.I.a == 3)) {
          paramb.I.d = true;
        }
        if (!paramb.c) {
          break;
        }
      }
    }
    for (paramIntent = "1.9";; paramIntent = "1.4")
    {
      paramb.a = paramIntent;
      return bool1;
      if ((str1 == null) || (str1.length() <= 0)) {
        break;
      }
      paramb.I.a = 1000;
      j.b("uppay", "nativeBrowser data:" + str1);
      break label142;
      label446:
      paramb.aM = false;
      com.unionpay.mobile.android.global.a.M = -10705958;
      com.unionpay.mobile.android.global.a.N = -13268007;
      break label236;
      paramb.I.c = paramIntent.getString("ex_mode");
      j.a("uppay", "mServerIdentifier = " + paramb.I.c);
      paramb.b = a(paramIntent);
      paramb.g = paramIntent.getString("appID");
      if (paramb.g == null) {
        paramb.g = "";
      }
      str1 = paramIntent.getString("source");
      if (str1 != null) {
        b.bl = str1.equals("samsung_out");
      }
      str1 = paramIntent.getString("frontNotifyByPlugin");
      if ((str1 == null) || (str1.length() == 0)) {}
      for (bool1 = true;; bool1 = false)
      {
        paramb.U = bool1;
        bool1 = bool3;
        if (!paramb.f)
        {
          bool1 = bool3;
          if (paramb.b != null)
          {
            bool1 = bool3;
            if (paramb.b.trim().length() > 0)
            {
              j.a("uppay", "tn from bundle:" + paramb.b);
              bool1 = bool2;
              if (!"2".equalsIgnoreCase(paramb.b.substring(paramb.b.length() - 1))) {
                bool1 = true;
              }
              paramb.c = bool1;
              j.a("uppay", "dw.isNewTypeTn=" + paramb.c);
              bool1 = true;
            }
          }
        }
        paramb.r = paramIntent.getString("ResultURL");
        j.a("uppay", "result URL:" + paramb.r);
        break;
      }
      str1 = paramIntent.getString("uppayuri");
      paramb.I.b = paramIntent.getString("resultIntentAction");
      j.a("uppay", " result Action=" + paramb.I.b);
      bool1 = a(str1, paramb);
      break label311;
      paramb.I.c = paramIntent.getString("ex_mode");
      paramb.I.g = paramIntent.getString("tencentUID");
      paramb.I.h = paramIntent.getString("tencentWID");
      paramb.b = a(paramIntent);
      bool1 = bool4;
      if (paramb.b == null) {
        break label311;
      }
      bool1 = bool4;
      if (paramb.b.trim().length() <= 0) {
        break label311;
      }
      bool1 = bool4;
      if (paramb.I.h == null) {
        break label311;
      }
      bool1 = bool4;
      if (paramb.I.h.trim().length() <= 0) {
        break label311;
      }
      bool1 = true;
      break label311;
      paramIntent = paramIntent.getString("paydata");
      j.b("PluginEx", " paydata=" + paramIntent);
      bool1 = b(a(paramIntent), paramb);
      break label311;
      bool1 = a(str1, paramb);
      break label311;
      paramb.I.c = paramIntent.getString("ex_mode");
      j.a("uppay", "mServerIdentifier = " + paramb.I.c);
      paramb.g = paramIntent.getString("appID");
      if (paramb.g == null) {
        paramb.g = "";
      }
      paramb.e = paramIntent.getString("amt");
      paramb.d = paramIntent.getString("aid");
      paramb.f = true;
      paramb.c = true;
      bool1 = bool4;
      if (TextUtils.isEmpty(paramb.e)) {
        break label311;
      }
      bool1 = bool4;
      if (TextUtils.isEmpty(paramb.d)) {
        break label311;
      }
      bool1 = true;
      break label311;
    }
  }
  
  private static boolean a(String paramString, b paramb)
  {
    Object localObject1 = null;
    if (paramString != null)
    {
      paramString = paramString.split("\\?");
      if (paramString.length < 2) {
        j.c("uppay", "uppay protocol params error!");
      }
    }
    else
    {
      return false;
    }
    paramString = paramString[1];
    j.a("uppay", "parseUPPayURIParams() +++ ");
    j.a("uppay", paramString);
    String[] arrayOfString1 = paramString.split("&");
    int j = arrayOfString1.length;
    int i = 0;
    paramString = null;
    if (i < j)
    {
      String[] arrayOfString2 = arrayOfString1[i].split("=");
      Object localObject2 = localObject1;
      String str = paramString;
      if (arrayOfString2.length >= 2)
      {
        if (!arrayOfString2[0].equalsIgnoreCase("style")) {
          break label137;
        }
        str = arrayOfString2[1];
        localObject2 = localObject1;
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        paramString = str;
        break;
        label137:
        localObject2 = localObject1;
        str = paramString;
        if (arrayOfString2[0].equalsIgnoreCase("paydata"))
        {
          localObject2 = arrayOfString2[1];
          str = paramString;
        }
      }
    }
    if ((paramString != null) && (paramString.equalsIgnoreCase("token")) && (localObject1 != null)) {
      j.a("uppay", "paydata=" + (String)localObject1);
    }
    for (boolean bool = b(a((String)localObject1), paramb);; bool = false)
    {
      j.a("uppay", "parseUPPayURIParams() ---");
      return bool;
    }
  }
  
  private static boolean b(String paramString, b paramb)
  {
    boolean bool = false;
    if ((paramString == null) || (paramString.length() == 0)) {}
    label98:
    do
    {
      return false;
      paramb.I.c = "00";
      paramString = paramString.split(",");
      int j = paramString.length;
      int i = 0;
      if (i < j)
      {
        String[] arrayOfString = paramString[i].trim().split("=");
        if (arrayOfString.length >= 2)
        {
          if (!arrayOfString[0].trim().equalsIgnoreCase("tn")) {
            break label98;
          }
          paramb.b = arrayOfString[1].trim();
        }
        for (;;)
        {
          i += 1;
          break;
          if (arrayOfString[0].trim().equalsIgnoreCase("usetestmode"))
          {
            if (arrayOfString[1].trim().equalsIgnoreCase("true")) {
              paramb.I.c = "01";
            } else if (arrayOfString[1].trim().equalsIgnoreCase("test")) {
              paramb.I.c = "02";
            } else if (arrayOfString[1].trim().equalsIgnoreCase("inner")) {
              paramb.I.c = "98";
            }
          }
          else if (arrayOfString[0].trim().equalsIgnoreCase("ResultURL")) {
            try
            {
              paramb.r = URLDecoder.decode(arrayOfString[1].trim(), "UTF-8");
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              localUnsupportedEncodingException.printStackTrace();
            }
          }
        }
      }
    } while ((paramb.b == null) || (paramb.b.length() <= 0) || (paramb.r == null) || (paramb.r.length() <= 0));
    if (!"2".equalsIgnoreCase(paramb.b.substring(paramb.b.length() - 1))) {
      bool = true;
    }
    paramb.c = bool;
    j.a("uppay", "dw.isNewTypeTn=" + paramb.c);
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */