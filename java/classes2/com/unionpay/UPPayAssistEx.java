package com.unionpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import android.util.Base64;
import com.growingio.android.sdk.agent.VdsAgent;
import com.unionpay.a.d;
import com.unionpay.utils.UPUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UPPayAssistEx
{
  private static String A = "";
  private static int B = 0;
  private static boolean C = false;
  private static d D = null;
  private static Handler E = null;
  private static String F = "application/vnd.android.package-archive";
  private static String G = "http://mobile.unionpay.com/getclient?platform=android&type=securepayplugin";
  private static String H = "[{\"type\":\"app\",\"sort\":100,\"package_info\":[{\"schema\":\"com.unionpay.uppay\",\"version\":\".*\",\"sign\":\"23137B5BE6AEF6682B41E6536F08367E0949A1CC\",\"sort\":101},{\"schema\":\"com.unionpay.tsmservice\",\"version\":\"^[1-9].*|^0[2-9].*|^01\\.[1-9].*|^01\\.0[1-9].*|^01\\.00\\.[1-9].*|^01\\.00\\.0[8-9].*\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":102}],\"need_install\":false,\"install_msg\":\"请先安装银联在线支付服务，安装完成后重新发起付款\",\"url\":\"https://mobile.unionpay.com/getclient?platform=android&type=securepayplugin\",\"download_app\":\"UPPayPluginEx.apk\",\"download_title\":\"银联在线支付服务\",\"download_desp\":\"正在下载银联在线支付服务…\",\"md5\":\"D75BB2802E61738A9A03BF014F927D9A\"},{\"type\":\"jar\",\"sort\":200}]";
  private static JSONArray I;
  private static IntentFilter J = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
  private static BroadcastReceiver K = new a();
  private static final Handler.Callback L = new b();
  public static final int PLUGIN_NOT_FOUND = -1;
  public static final int PLUGIN_VALID = 0;
  private static String a = "SpId";
  private static String b = "paydata";
  private static String c = "SysProvide";
  private static String d = "UseTestMode";
  private static String e = "SecurityChipType";
  private static String f = "uppayuri";
  private static String g = "resultIntentAction";
  private static String h = "reqOriginalId";
  private static String i = "wapurl";
  private static String j = "dlgstyle";
  private static String k = "com.unionpay.uppay";
  private static String l = "com.unionpay.uppay.PayActivity";
  private static String m = "ex_mode";
  private static String n = "server";
  private static String o = "source";
  private static String p = "samsung_out";
  private static String q = "";
  private static boolean r = false;
  private static int s = 10;
  private static Context t;
  private static String u = "";
  private static String v = null;
  private static String w = null;
  private static String x = "";
  private static String y = "";
  private static boolean z = false;
  
  private static int a(Activity paramActivity, String paramString1, String paramString2)
  {
    int i2 = 1;
    for (;;)
    {
      try
      {
        String[] arrayOfString = new String[27];
        arrayOfString[0] = "30820267308201d0a00302010202044";
        arrayOfString[1] = "ecb7d98300d06092a8";
        arrayOfString[2] = "64886f70d01010505003078310b30090603550";
        arrayOfString[3] = "406130238363111300f060355040813085";
        arrayOfString[4] = "368616e676";
        arrayOfString[5] = "861693111300f060355040713085368616e67686169311730";
        arrayOfString[6] = "15060355040a130e4368696e6120556e696f6e50617931173015060355040b130e4";
        arrayOfString[7] = "368696e612055";
        arrayOfString[8] = "6e696f6e5061793111300f06035504031308556e696f6e5061";
        arrayOfString[9] = "79301e170d3131313132323130343634385a170d333631313135313034";
        arrayOfString[10] = "3634385a3078310b300906035504061302383631";
        arrayOfString[11] = "11300f060355040813085368616e67686169311130";
        arrayOfString[12] = "0f060355040713085368616e676861693117";
        arrayOfString[13] = "3015060355040a130e4368696e6120556e696";
        arrayOfString[14] = "f6e50617931173015060355040b130e4368696e6120556e696";
        arrayOfString[15] = "f6e5061793111300f06035504031308556e696f6e50617930819f300d060";
        arrayOfString[16] = "92a864886f70d010101050003818d0030818902818100c42e6236d5054ffccaa";
        arrayOfString[17] = "a430ecd929d562";
        arrayOfString[18] = "b1ff56cef0e21c87260c63ce3ca868bf5974c14";
        arrayOfString[19] = "d9255940da7b6cd07483f4b4243fd1825b2705";
        arrayOfString[20] = "08eb9b5c67474d027fa03ce35109b11604083ab6bb4df2c46240f879f";
        arrayOfString[21] = "8cc1d6ed5e1b2cc00489215aec3fc2eac008e767b0215981cb5e";
        arrayOfString[22] = "e94ddc285669ec06b8a405dd4341eac4ea7030203010001300d06092a864886f70d010105050003818";
        arrayOfString[23] = "1001a3e74c601e3beb1b7ae4f9ab2872a0aaf1dbc2cba89c7528cd";
        arrayOfString[24] = "54aa526e7a37d8ba2311a1d3d2ab79b3fbeaf3ebb9e7da9e7cdd9be1ae5a53595f47";
        arrayOfString[25] = "b1fdf62b0f540fca5458b063af9354925a6c3505a18ff164b6b195f6e517eaee1fb783";
        arrayOfString[26] = "64c2f89fdffa16729c9779f99562bc189d2ce4722ba0faedb11aa22d0d9db228fda";
        Object localObject = paramActivity.getPackageManager();
        ((PackageManager)localObject).getActivityInfo(paramActivity.getComponentName(), 128);
        ((PackageManager)localObject).getApplicationInfo("com.unionpay.uppay", 8192);
        PackageInfo localPackageInfo = ((PackageManager)localObject).getPackageInfo("com.unionpay.uppay", 4160);
        String str1 = localPackageInfo.signatures[0].toCharsString();
        int i3 = arrayOfString.length;
        localObject = "";
        i1 = 0;
        if (i1 < i3)
        {
          String str2 = arrayOfString[i1];
          localObject = (String)localObject + str2;
          i1 += 1;
          continue;
        }
        if ((str1 == null) || (!str1.equals(localObject)) || (localPackageInfo.versionCode < 31)) {
          break label405;
        }
        i1 = i2;
        if (i1 != 0)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt(h, 1);
          ((Bundle)localObject).putString(f, paramString1);
          ((Bundle)localObject).putString(g, paramString2);
          paramString1 = new Intent();
          paramString1.putExtras((Bundle)localObject);
          paramString1.setClassName(k, l);
          paramActivity.startActivity(paramString1);
          return 0;
        }
      }
      catch (PackageManager.NameNotFoundException paramActivity)
      {
        return -1;
      }
      return -1;
      label405:
      int i1 = 0;
    }
  }
  
  private static String a(Context paramContext, String paramString)
  {
    InputStream localInputStream;
    String str;
    try
    {
      localInputStream = paramContext.getAssets().open(paramString);
      Object localObject = paramContext.getFilesDir().getAbsolutePath();
      if (localObject != null)
      {
        str = (String)localObject + File.separator + paramString;
        localObject = str;
        if (new File(str).exists()) {
          break label104;
        }
        paramContext = paramContext.openFileOutput(paramString, 1);
        paramString = new byte['Ѐ'];
        for (;;)
        {
          int i1 = localInputStream.read(paramString);
          if (i1 <= 0) {
            break;
          }
          paramContext.write(paramString, 0, i1);
        }
      }
      return (String)localObject;
    }
    catch (Exception paramContext)
    {
      localObject = "";
    }
    label104:
    paramContext.close();
    localInputStream.close();
    return str;
  }
  
  /* Error */
  static String a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 387	org/json/JSONObject
    //   5: dup
    //   6: invokespecial 388	org/json/JSONObject:<init>	()V
    //   9: astore 5
    //   11: getstatic 137	com/unionpay/UPPayAssistEx:x	Ljava/lang/String;
    //   14: invokestatic 394	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   17: istore_3
    //   18: iload_3
    //   19: istore_2
    //   20: iload_1
    //   21: ifne +22 -> 43
    //   24: aload 5
    //   26: ldc_w 396
    //   29: iload_2
    //   30: getstatic 131	com/unionpay/UPPayAssistEx:u	Ljava/lang/String;
    //   33: invokestatic 401	com/unionpay/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   36: invokestatic 407	com/unionpay/utils/UPUtils:forWap	(ILjava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   42: pop
    //   43: aload 5
    //   45: ldc_w 413
    //   48: aload_0
    //   49: invokestatic 418	com/unionpay/utils/d:b	(Landroid/content/Context;)Ljava/lang/String;
    //   52: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: invokestatic 424	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   59: invokevirtual 425	java/util/Locale:toString	()Ljava/lang/String;
    //   62: ldc_w 427
    //   65: invokevirtual 431	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   68: ifeq +613 -> 681
    //   71: ldc_w 433
    //   74: astore 4
    //   76: aload 5
    //   78: ldc_w 435
    //   81: aload 4
    //   83: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: pop
    //   87: aload 5
    //   89: ldc_w 437
    //   92: ldc_w 439
    //   95: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: pop
    //   99: aload_0
    //   100: invokevirtual 443	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   103: invokevirtual 449	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   106: getfield 454	android/util/DisplayMetrics:widthPixels	I
    //   109: istore_2
    //   110: aload_0
    //   111: invokevirtual 443	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   114: invokevirtual 449	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   117: getfield 457	android/util/DisplayMetrics:heightPixels	I
    //   120: istore_3
    //   121: aload 5
    //   123: ldc_w 459
    //   126: new 283	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   133: iload_2
    //   134: invokevirtual 462	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: ldc_w 464
    //   140: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: iload_3
    //   144: invokevirtual 462	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokevirtual 467	java/lang/String:trim	()Ljava/lang/String;
    //   153: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   156: pop
    //   157: aload 5
    //   159: ldc_w 469
    //   162: ldc_w 471
    //   165: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: aload 5
    //   171: ldc_w 473
    //   174: getstatic 478	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   177: invokevirtual 467	java/lang/String:trim	()Ljava/lang/String;
    //   180: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   183: pop
    //   184: getstatic 483	android/os/Build:MODEL	Ljava/lang/String;
    //   187: invokevirtual 467	java/lang/String:trim	()Ljava/lang/String;
    //   190: astore 4
    //   192: aload 4
    //   194: ifnull +14 -> 208
    //   197: aload 4
    //   199: ldc_w 485
    //   202: ldc 123
    //   204: invokevirtual 489	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   207: pop
    //   208: aload 5
    //   210: ldc_w 491
    //   213: aload 4
    //   215: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   218: pop
    //   219: aload 5
    //   221: ldc_w 493
    //   224: aload_0
    //   225: invokestatic 495	com/unionpay/utils/d:a	(Landroid/content/Context;)Ljava/lang/String;
    //   228: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   231: pop
    //   232: aload 5
    //   234: ldc_w 497
    //   237: invokestatic 502	java/util/TimeZone:getDefault	()Ljava/util/TimeZone;
    //   240: iconst_0
    //   241: iconst_0
    //   242: invokevirtual 506	java/util/TimeZone:getDisplayName	(ZI)Ljava/lang/String;
    //   245: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   248: pop
    //   249: aload_0
    //   250: ldc_w 508
    //   253: invokevirtual 512	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   256: checkcast 514	android/net/ConnectivityManager
    //   259: invokevirtual 518	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   262: astore 4
    //   264: aload 4
    //   266: ifnull +466 -> 732
    //   269: aload 4
    //   271: invokevirtual 523	android/net/NetworkInfo:isAvailable	()Z
    //   274: ifeq +458 -> 732
    //   277: aload 4
    //   279: invokevirtual 527	android/net/NetworkInfo:getType	()I
    //   282: ifne +433 -> 715
    //   285: aload 4
    //   287: invokevirtual 531	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   290: getstatic 537	android/net/NetworkInfo$State:CONNECTED	Landroid/net/NetworkInfo$State;
    //   293: if_acmpne +414 -> 707
    //   296: new 283	java/lang/StringBuilder
    //   299: dup
    //   300: ldc_w 539
    //   303: invokespecial 540	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   306: aload 4
    //   308: invokevirtual 543	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   311: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: astore 4
    //   319: aload 5
    //   321: ldc_w 545
    //   324: aload 4
    //   326: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   329: pop
    //   330: aload 5
    //   332: ldc_w 547
    //   335: aload_0
    //   336: invokestatic 549	com/unionpay/utils/d:c	(Landroid/content/Context;)Ljava/lang/String;
    //   339: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   342: pop
    //   343: aload 5
    //   345: ldc_w 551
    //   348: invokestatic 553	com/unionpay/utils/d:a	()Ljava/lang/String;
    //   351: invokestatic 555	com/unionpay/UPPayAssistEx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   354: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   357: pop
    //   358: new 345	java/io/File
    //   361: dup
    //   362: ldc_w 557
    //   365: invokespecial 352	java/io/File:<init>	(Ljava/lang/String;)V
    //   368: invokevirtual 356	java/io/File:exists	()Z
    //   371: ifeq +407 -> 778
    //   374: ldc_w 559
    //   377: astore 4
    //   379: aload 5
    //   381: ldc_w 561
    //   384: aload 4
    //   386: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   389: pop
    //   390: new 563	java/lang/StringBuffer
    //   393: dup
    //   394: ldc_w 565
    //   397: invokespecial 566	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   400: astore 4
    //   402: getstatic 569	android/os/Build$VERSION:SDK_INT	I
    //   405: bipush 10
    //   407: if_icmplt +68 -> 475
    //   410: aload_0
    //   411: ldc_w 571
    //   414: invokevirtual 512	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   417: checkcast 573	android/nfc/NfcManager
    //   420: invokevirtual 577	android/nfc/NfcManager:getDefaultAdapter	()Landroid/nfc/NfcAdapter;
    //   423: astore 6
    //   425: aload 6
    //   427: ifnull +48 -> 475
    //   430: aload 6
    //   432: invokevirtual 582	android/nfc/NfcAdapter:isEnabled	()Z
    //   435: ifeq +361 -> 796
    //   438: aload 4
    //   440: iconst_0
    //   441: bipush 49
    //   443: invokevirtual 586	java/lang/StringBuffer:setCharAt	(IC)V
    //   446: getstatic 569	android/os/Build$VERSION:SDK_INT	I
    //   449: bipush 19
    //   451: if_icmplt +24 -> 475
    //   454: aload_0
    //   455: invokevirtual 587	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   458: ldc_w 589
    //   461: invokevirtual 592	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   464: ifeq +11 -> 475
    //   467: aload 4
    //   469: iconst_1
    //   470: bipush 49
    //   472: invokevirtual 586	java/lang/StringBuffer:setCharAt	(IC)V
    //   475: aload 5
    //   477: ldc_w 594
    //   480: aload 4
    //   482: invokevirtual 595	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   485: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   488: pop
    //   489: aload 5
    //   491: ldc_w 597
    //   494: invokestatic 424	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   497: invokevirtual 600	java/util/Locale:getCountry	()Ljava/lang/String;
    //   500: invokestatic 555	com/unionpay/UPPayAssistEx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   503: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   506: pop
    //   507: aload_0
    //   508: checkcast 247	android/app/Activity
    //   511: invokevirtual 603	android/app/Activity:getPackageName	()Ljava/lang/String;
    //   514: astore 4
    //   516: aload 4
    //   518: ifnull +328 -> 846
    //   521: aload 5
    //   523: ldc_w 605
    //   526: aload 4
    //   528: invokestatic 555	com/unionpay/UPPayAssistEx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   531: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   534: pop
    //   535: aload_0
    //   536: invokestatic 608	com/unionpay/utils/d:d	(Landroid/content/Context;)Landroid/location/Location;
    //   539: astore 4
    //   541: aload 4
    //   543: ifnull +310 -> 853
    //   546: aload 4
    //   548: invokevirtual 614	android/location/Location:getLatitude	()D
    //   551: invokestatic 620	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   554: invokevirtual 621	java/lang/Double:toString	()Ljava/lang/String;
    //   557: astore 4
    //   559: aload 5
    //   561: ldc_w 623
    //   564: aload 4
    //   566: invokestatic 555	com/unionpay/UPPayAssistEx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   569: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   572: pop
    //   573: aload_0
    //   574: invokestatic 608	com/unionpay/utils/d:d	(Landroid/content/Context;)Landroid/location/Location;
    //   577: astore 4
    //   579: aload 4
    //   581: ifnull +279 -> 860
    //   584: aload 4
    //   586: invokevirtual 626	android/location/Location:getLongitude	()D
    //   589: invokestatic 620	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   592: invokevirtual 621	java/lang/Double:toString	()Ljava/lang/String;
    //   595: astore 4
    //   597: aload 5
    //   599: ldc_w 628
    //   602: aload 4
    //   604: invokestatic 555	com/unionpay/UPPayAssistEx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   607: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   610: pop
    //   611: aload 5
    //   613: ldc_w 630
    //   616: aload_0
    //   617: invokestatic 632	com/unionpay/utils/d:e	(Landroid/content/Context;)Ljava/lang/String;
    //   620: invokestatic 555	com/unionpay/UPPayAssistEx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   623: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   626: pop
    //   627: iload_1
    //   628: ifeq +21 -> 649
    //   631: ldc 103
    //   633: invokestatic 638	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   636: pop
    //   637: aload 5
    //   639: ldc_w 640
    //   642: ldc_w 559
    //   645: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   648: pop
    //   649: aload 5
    //   651: invokevirtual 641	org/json/JSONObject:toString	()Ljava/lang/String;
    //   654: astore_0
    //   655: ldc_w 643
    //   658: new 283	java/lang/StringBuilder
    //   661: dup
    //   662: ldc_w 645
    //   665: invokespecial 540	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   668: aload_0
    //   669: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 650	com/unionpay/utils/g:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   678: pop
    //   679: aload_0
    //   680: areturn
    //   681: ldc_w 652
    //   684: astore 4
    //   686: goto -610 -> 76
    //   689: astore 4
    //   691: aload 4
    //   693: invokevirtual 655	java/lang/Exception:printStackTrace	()V
    //   696: goto -447 -> 249
    //   699: astore_0
    //   700: aload_0
    //   701: invokevirtual 656	org/json/JSONException:printStackTrace	()V
    //   704: goto -55 -> 649
    //   707: ldc_w 658
    //   710: astore 4
    //   712: goto -393 -> 319
    //   715: aload 4
    //   717: invokevirtual 527	android/net/NetworkInfo:getType	()I
    //   720: iconst_1
    //   721: if_icmpne +117 -> 838
    //   724: ldc_w 660
    //   727: astore 4
    //   729: goto -410 -> 319
    //   732: ldc_w 662
    //   735: astore 4
    //   737: goto -418 -> 319
    //   740: astore 4
    //   742: aload 4
    //   744: invokevirtual 655	java/lang/Exception:printStackTrace	()V
    //   747: goto -417 -> 330
    //   750: astore_0
    //   751: aload_0
    //   752: invokevirtual 663	java/util/regex/PatternSyntaxException:printStackTrace	()V
    //   755: goto -106 -> 649
    //   758: astore 4
    //   760: aload 4
    //   762: invokevirtual 655	java/lang/Exception:printStackTrace	()V
    //   765: goto -422 -> 343
    //   768: astore 4
    //   770: aload 4
    //   772: invokevirtual 655	java/lang/Exception:printStackTrace	()V
    //   775: goto -417 -> 358
    //   778: ldc_w 665
    //   781: astore 4
    //   783: goto -404 -> 379
    //   786: astore 4
    //   788: aload 4
    //   790: invokevirtual 655	java/lang/Exception:printStackTrace	()V
    //   793: goto -403 -> 390
    //   796: aload 4
    //   798: iconst_0
    //   799: bipush 50
    //   801: invokevirtual 586	java/lang/StringBuffer:setCharAt	(IC)V
    //   804: goto -358 -> 446
    //   807: astore 4
    //   809: aload 4
    //   811: invokevirtual 655	java/lang/Exception:printStackTrace	()V
    //   814: goto -325 -> 489
    //   817: astore_0
    //   818: aload 5
    //   820: ldc_w 640
    //   823: ldc_w 665
    //   826: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   829: pop
    //   830: goto -181 -> 649
    //   833: astore 4
    //   835: goto -815 -> 20
    //   838: ldc_w 667
    //   841: astore 4
    //   843: goto -524 -> 319
    //   846: ldc 123
    //   848: astore 4
    //   850: goto -329 -> 521
    //   853: ldc 123
    //   855: astore 4
    //   857: goto -298 -> 559
    //   860: ldc 123
    //   862: astore 4
    //   864: goto -267 -> 597
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	867	0	paramContext	Context
    //   0	867	1	paramBoolean	boolean
    //   1	133	2	i1	int
    //   17	127	3	i2	int
    //   74	611	4	localObject	Object
    //   689	3	4	localException1	Exception
    //   710	26	4	str1	String
    //   740	3	4	localException2	Exception
    //   758	3	4	localException3	Exception
    //   768	3	4	localException4	Exception
    //   781	1	4	str2	String
    //   786	11	4	localException5	Exception
    //   807	3	4	localException6	Exception
    //   833	1	4	localNumberFormatException	NumberFormatException
    //   841	22	4	str3	String
    //   9	810	5	localJSONObject	JSONObject
    //   423	8	6	localNfcAdapter	android.nfc.NfcAdapter
    // Exception table:
    //   from	to	target	type
    //   232	249	689	java/lang/Exception
    //   11	18	699	org/json/JSONException
    //   24	43	699	org/json/JSONException
    //   43	71	699	org/json/JSONException
    //   76	192	699	org/json/JSONException
    //   197	208	699	org/json/JSONException
    //   208	232	699	org/json/JSONException
    //   232	249	699	org/json/JSONException
    //   249	264	699	org/json/JSONException
    //   269	319	699	org/json/JSONException
    //   319	330	699	org/json/JSONException
    //   330	343	699	org/json/JSONException
    //   343	358	699	org/json/JSONException
    //   358	374	699	org/json/JSONException
    //   379	390	699	org/json/JSONException
    //   390	425	699	org/json/JSONException
    //   430	446	699	org/json/JSONException
    //   446	475	699	org/json/JSONException
    //   475	489	699	org/json/JSONException
    //   489	516	699	org/json/JSONException
    //   521	541	699	org/json/JSONException
    //   546	559	699	org/json/JSONException
    //   559	579	699	org/json/JSONException
    //   584	597	699	org/json/JSONException
    //   597	627	699	org/json/JSONException
    //   631	649	699	org/json/JSONException
    //   691	696	699	org/json/JSONException
    //   715	724	699	org/json/JSONException
    //   742	747	699	org/json/JSONException
    //   760	765	699	org/json/JSONException
    //   770	775	699	org/json/JSONException
    //   788	793	699	org/json/JSONException
    //   796	804	699	org/json/JSONException
    //   809	814	699	org/json/JSONException
    //   818	830	699	org/json/JSONException
    //   249	264	740	java/lang/Exception
    //   269	319	740	java/lang/Exception
    //   319	330	740	java/lang/Exception
    //   715	724	740	java/lang/Exception
    //   11	18	750	java/util/regex/PatternSyntaxException
    //   24	43	750	java/util/regex/PatternSyntaxException
    //   43	71	750	java/util/regex/PatternSyntaxException
    //   76	192	750	java/util/regex/PatternSyntaxException
    //   197	208	750	java/util/regex/PatternSyntaxException
    //   208	232	750	java/util/regex/PatternSyntaxException
    //   232	249	750	java/util/regex/PatternSyntaxException
    //   249	264	750	java/util/regex/PatternSyntaxException
    //   269	319	750	java/util/regex/PatternSyntaxException
    //   319	330	750	java/util/regex/PatternSyntaxException
    //   330	343	750	java/util/regex/PatternSyntaxException
    //   343	358	750	java/util/regex/PatternSyntaxException
    //   358	374	750	java/util/regex/PatternSyntaxException
    //   379	390	750	java/util/regex/PatternSyntaxException
    //   390	425	750	java/util/regex/PatternSyntaxException
    //   430	446	750	java/util/regex/PatternSyntaxException
    //   446	475	750	java/util/regex/PatternSyntaxException
    //   475	489	750	java/util/regex/PatternSyntaxException
    //   489	516	750	java/util/regex/PatternSyntaxException
    //   521	541	750	java/util/regex/PatternSyntaxException
    //   546	559	750	java/util/regex/PatternSyntaxException
    //   559	579	750	java/util/regex/PatternSyntaxException
    //   584	597	750	java/util/regex/PatternSyntaxException
    //   597	627	750	java/util/regex/PatternSyntaxException
    //   631	649	750	java/util/regex/PatternSyntaxException
    //   691	696	750	java/util/regex/PatternSyntaxException
    //   715	724	750	java/util/regex/PatternSyntaxException
    //   742	747	750	java/util/regex/PatternSyntaxException
    //   760	765	750	java/util/regex/PatternSyntaxException
    //   770	775	750	java/util/regex/PatternSyntaxException
    //   788	793	750	java/util/regex/PatternSyntaxException
    //   796	804	750	java/util/regex/PatternSyntaxException
    //   809	814	750	java/util/regex/PatternSyntaxException
    //   818	830	750	java/util/regex/PatternSyntaxException
    //   330	343	758	java/lang/Exception
    //   343	358	768	java/lang/Exception
    //   358	374	786	java/lang/Exception
    //   379	390	786	java/lang/Exception
    //   390	425	807	java/lang/Exception
    //   430	446	807	java/lang/Exception
    //   446	475	807	java/lang/Exception
    //   475	489	807	java/lang/Exception
    //   796	804	807	java/lang/Exception
    //   631	649	817	java/lang/ClassNotFoundException
    //   11	18	833	java/lang/NumberFormatException
  }
  
  static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int i1 = 1;
    Object localObject = a(paramContext, paramString2);
    if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.parse("file:" + (String)localObject), "application/vnd.android.package-archive");
      paramContext.startActivity(localIntent);
    }
    for (;;)
    {
      if (i1 != 0) {}
      do
      {
        return;
        y = paramString5;
        A = paramString2;
      } while (z);
      try
      {
        paramContext.registerReceiver(K, J);
        paramString5 = (DownloadManager)paramContext.getSystemService("download");
        localObject = new DownloadManager.Request(Uri.parse(paramString1));
        ((DownloadManager.Request)localObject).setMimeType(F);
        ((DownloadManager.Request)localObject).setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, paramString2);
        ((DownloadManager.Request)localObject).setTitle(paramString3);
        ((DownloadManager.Request)localObject).setDescription(paramString4);
        ((DownloadManager.Request)localObject).setNotificationVisibility(1);
        UPUtils.a(paramContext, paramString5.enqueue((DownloadManager.Request)localObject), "id");
        z = true;
        return;
      }
      catch (Exception paramString2)
      {
        if ((paramString2 instanceof IllegalArgumentException))
        {
          paramString1 = new AlertDialog.Builder(paramContext);
          paramString1.setTitle(com.unionpay.utils.h.a().d);
          paramString1.setMessage(com.unionpay.utils.h.a().f);
          paramString1.setPositiveButton(com.unionpay.utils.h.a().b, new f(paramContext));
          paramString1.setNegativeButton(com.unionpay.utils.h.a().c, new g(paramContext));
          paramContext = paramString1.create();
          if (!(paramContext instanceof AlertDialog))
          {
            paramContext.show();
            return;
          }
          VdsAgent.showDialog((AlertDialog)paramContext);
          return;
        }
        paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString1)));
        return;
      }
      i1 = 0;
    }
  }
  
  static void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    a(u, localBundle, x);
    localBundle.putString(a, v);
    localBundle.putString(c, w);
    localBundle.putString(b, u);
    localBundle.putString(o, q);
    localBundle.putString(n, paramString);
    localBundle.putBoolean(j, r);
    localBundle.putInt(h, 2);
    try
    {
      paramString = Class.forName("com.unionpay.uppay.PayActivity");
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      localIntent.setClass(t, paramString);
      if ((t instanceof Activity))
      {
        ((Activity)t).startActivityForResult(localIntent, s);
        return;
      }
      localIntent.addFlags(268435456);
      t.startActivity(localIntent);
      return;
    }
    catch (ClassNotFoundException paramString) {}
  }
  
  private static void a(String paramString1, Bundle paramBundle, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.trim().length() <= 0)) {
      return;
    }
    if (paramString1.trim().charAt(0) == '<')
    {
      if ((paramString2 != null) && (paramString2.trim().equalsIgnoreCase("00")))
      {
        paramBundle.putBoolean(d, false);
        return;
      }
      paramBundle.putBoolean(d, true);
      return;
    }
    paramBundle.putString(m, paramString2);
  }
  
  private static int b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    t = paramContext;
    u = paramString3;
    v = paramString1;
    w = paramString2;
    x = paramString4;
    q = paramString5;
    if (!TextUtils.isEmpty(paramString5)) {
      r = true;
    }
    for (;;)
    {
      B = 0;
      C = false;
      System.loadLibrary("entryexpro");
      paramString2 = UPUtils.a(t, "configs");
      paramString3 = UPUtils.a(paramContext, "mode");
      paramString1 = UPUtils.a(paramContext, "or");
      if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1))) {}
      for (;;)
      {
        try
        {
          paramString4 = new JSONObject(paramString2);
          paramString2 = com.unionpay.utils.f.a(paramString4, "sign");
        }
        catch (JSONException paramString1)
        {
          int i1;
          continue;
        }
        try
        {
          i1 = Integer.parseInt(paramString3);
          paramString3 = new String(Base64.decode(paramString4.getString("configs"), 2));
          paramString1 = com.unionpay.utils.b.a(UPUtils.a(paramString3 + paramString1));
          if (UPUtils.forConfig(i1, paramString2).equals(paramString1)) {
            H = paramString3;
          }
        }
        catch (NumberFormatException paramString3)
        {
          try
          {
            I = b(new JSONArray(H), "sort");
            try
            {
              i1 = Integer.parseInt(x);
              paramString1 = UPUtils.forUrl(i1);
              com.unionpay.utils.g.b("uppay", "url: " + paramString1);
              D = new d(paramString1);
              paramContext = a(paramContext, false);
              com.unionpay.utils.g.b("uppay", "postdata: " + paramContext);
              D.a(paramContext);
              E = new Handler(L);
              new c().start();
              return 0;
              r = false;
              break;
              paramString3 = paramString3;
              i1 = 0;
            }
            catch (NumberFormatException paramString1)
            {
              i1 = 0;
            }
          }
          catch (JSONException paramString1) {}
        }
      }
    }
  }
  
  private static String b(String paramString)
  {
    if (paramString != null) {
      return Pattern.compile("[\":,\\[\\]{}]").matcher(paramString).replaceAll("").trim();
    }
    return "";
  }
  
  private static JSONArray b(JSONArray paramJSONArray, String paramString)
  {
    int i2 = 0;
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramJSONArray.length())
    {
      localArrayList.add(paramJSONArray.optJSONObject(i1));
      i1 += 1;
    }
    Collections.sort(localArrayList, new h(paramString));
    paramJSONArray = new JSONArray();
    i1 = i2;
    while (i1 < localArrayList.size())
    {
      paramJSONArray.put((JSONObject)localArrayList.get(i1));
      i1 += 1;
    }
    return paramJSONArray;
  }
  
  public static boolean checkInstalled(Context paramContext)
  {
    localObject1 = H;
    String str = UPUtils.a(paramContext, "configs");
    Object localObject5 = UPUtils.a(paramContext, "mode");
    Object localObject4 = UPUtils.a(paramContext, "or");
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty(str))
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject5))
      {
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {}
      }
    }
    for (;;)
    {
      try
      {
        System.loadLibrary("entryexpro");
        localObject2 = new JSONObject(str);
        str = com.unionpay.utils.f.a((JSONObject)localObject2, "sign");
      }
      catch (JSONException localJSONException)
      {
        int i1;
        boolean bool;
        int i3;
        int i4;
        int i2;
        Object localObject3 = localObject1;
        continue;
        continue;
      }
      try
      {
        i1 = Integer.parseInt((String)localObject5);
        localObject2 = new String(Base64.decode(((JSONObject)localObject2).getString("configs"), 2));
        localObject4 = com.unionpay.utils.b.a(UPUtils.a((String)localObject2 + (String)localObject4));
        bool = UPUtils.forConfig(i1, str).equals(localObject4);
        if (!bool) {
          continue;
        }
        localObject1 = localObject2;
        localObject2 = localObject1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        try
        {
          localObject1 = new JSONArray((String)localObject2);
          i3 = ((JSONArray)localObject1).length();
          i1 = 0;
          if (i1 >= i3) {
            continue;
          }
          localObject2 = com.unionpay.utils.f.a((JSONArray)localObject1, i1);
          if (localObject2 == null) {
            continue;
          }
          localObject2 = (JSONObject)localObject2;
          if (!"app".equals(com.unionpay.utils.f.a((JSONObject)localObject2, "type"))) {
            continue;
          }
          localObject2 = b(com.unionpay.utils.f.c((JSONObject)localObject2, "package_info"), "sort");
          if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
            continue;
          }
          i4 = ((JSONArray)localObject2).length();
          i2 = 0;
          if (i2 >= i4) {
            continue;
          }
          localObject4 = com.unionpay.utils.f.a((JSONArray)localObject2, i2);
          if (localObject4 == null) {
            continue;
          }
          localObject5 = (JSONObject)localObject4;
          localObject4 = com.unionpay.utils.f.a((JSONObject)localObject5, "schema");
          str = com.unionpay.utils.f.a((JSONObject)localObject5, "sign");
          localObject5 = com.unionpay.utils.f.a((JSONObject)localObject5, "version");
          if ((!com.unionpay.utils.b.a(paramContext, (String)localObject4)) || (!str.equalsIgnoreCase(com.unionpay.utils.b.b(paramContext, (String)localObject4))) || (!com.unionpay.utils.b.c(paramContext, (String)localObject4).matches((String)localObject5))) {
            continue;
          }
          return true;
        }
        catch (JSONException paramContext)
        {
          return false;
        }
        localNumberFormatException = localNumberFormatException;
        i1 = 0;
        continue;
      }
      i2 += 1;
      continue;
      i1 += 1;
    }
    return false;
  }
  
  public static boolean installUPPayPlugin(Context paramContext)
  {
    String str;
    FileOutputStream localFileOutputStream;
    try
    {
      localObject = paramContext.getAssets().open("UPPayPluginEx.apk");
      str = paramContext.getFilesDir().getAbsolutePath();
      if (str != null)
      {
        str = str + File.separator + "UPPayPluginEx.apk";
        if (new File(str).exists()) {
          break label120;
        }
        localFileOutputStream = paramContext.openFileOutput("UPPayPluginEx.apk", 1);
        byte[] arrayOfByte = new byte['Ѐ'];
        for (;;)
        {
          int i1 = ((InputStream)localObject).read(arrayOfByte);
          if (i1 <= 0) {
            break;
          }
          localFileOutputStream.write(arrayOfByte, 0, i1);
        }
      }
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    localFileOutputStream.close();
    ((InputStream)localObject).close();
    label120:
    Object localObject = new Intent("android.intent.action.VIEW");
    ((Intent)localObject).setDataAndType(Uri.parse("file:" + str), "application/vnd.android.package-archive");
    paramContext.startActivity((Intent)localObject);
    return true;
  }
  
  public static int startPay(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return b(paramContext, paramString1, paramString2, paramString3, paramString4, "");
  }
  
  public static void startPayByJAR(Context paramContext, Class paramClass, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    startPay(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static int startPayFromBrowser(Activity paramActivity, String paramString1, String paramString2)
  {
    return a(paramActivity, paramString1, paramString2);
  }
  
  public static void startSamsungPay(Context paramContext, Class paramClass, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    b(paramContext, paramString1, paramString2, paramString3, paramString4, p);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/UPPayAssistEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */