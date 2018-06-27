package com.unionpay.mobile.android.pro.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.upviews.a.b;
import com.unionpay.mobile.android.upwidget.UPRadiationView;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.uppay.PayActivity;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
  extends com.unionpay.mobile.android.nocard.views.b
  implements Handler.Callback, a.b
{
  private static Date Z = new Date(System.currentTimeMillis());
  private static String aa = new SimpleDateFormat("yyyyMMddhhmmss").format(Z);
  private LinearLayout A = null;
  private LinearLayout B = null;
  private RelativeLayout C = null;
  private LinearLayout D = null;
  private LinearLayout E = null;
  private ay F;
  private UPRadiationView G;
  private ImageView H;
  private String I;
  private String J;
  private com.unionpay.mobile.android.upwidget.a K = null;
  private com.unionpay.mobile.android.upwidget.a L = null;
  private boolean M = true;
  private boolean N = false;
  private com.unionpay.mobile.android.upviews.a O = null;
  private String P;
  private int Q = 5;
  private View.OnClickListener R = new l(this);
  private View.OnClickListener S = new m(this);
  private View.OnClickListener T = new n(this);
  private View.OnClickListener U = new o(this);
  private View.OnClickListener V = new p(this);
  private View.OnClickListener W = new q(this);
  private String ab = null;
  private HashMap<String, String> ac = new HashMap();
  public String r = "1.8";
  UPPayEngine s;
  com.unionpay.mobile.android.pboctransaction.nfc.a t;
  private int u = 20;
  private int v = 100;
  private TextView w = null;
  private boolean x = false;
  private com.unionpay.mobile.android.upviews.a y = null;
  private Handler z = null;
  
  public k(Context paramContext, com.unionpay.mobile.android.model.e parame, UPPayEngine paramUPPayEngine)
  {
    super(paramContext, parame);
    this.f = 6;
    this.q = "nfcpay";
    this.s = paramUPPayEngine;
    this.z = new Handler(this);
    this.x = this.a.K;
    setBackgroundColor(-11495169);
    e();
  }
  
  private void a(String paramString, StringBuffer paramStringBuffer)
  {
    String str = (String)this.ac.get(paramString);
    Object localObject = new byte[1];
    localObject[0] = ((byte)(str.length() / 2));
    localObject = com.unionpay.mobile.android.pboctransaction.e.a((byte[])localObject, localObject.length);
    paramStringBuffer.append(paramString);
    paramStringBuffer.append((String)localObject);
    paramStringBuffer.append(str);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = ((PayActivity)this.d).a(com.unionpay.mobile.android.pro.pboc.engine.b.class.toString());
    if (localObject != null) {}
    for (localObject = (com.unionpay.mobile.android.pro.pboc.engine.b)localObject; localObject == null; localObject = null)
    {
      b(5);
      return;
    }
    new Thread(new r(this, paramString, paramHashMap)).start();
  }
  
  /* Error */
  private Bundle c(String paramString, HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 307	com/unionpay/mobile/android/pro/views/k:w	()Landroid/os/Bundle;
    //   5: astore_3
    //   6: aload_0
    //   7: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   10: ldc_w 309
    //   13: aload_1
    //   14: invokevirtual 313	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   17: pop
    //   18: new 256	java/lang/StringBuffer
    //   21: dup
    //   22: invokespecial 314	java/lang/StringBuffer:<init>	()V
    //   25: astore_1
    //   26: aload_0
    //   27: ldc_w 316
    //   30: aload_1
    //   31: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   34: aload_0
    //   35: ldc_w 320
    //   38: aload_1
    //   39: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   42: aload_0
    //   43: ldc_w 322
    //   46: aload_1
    //   47: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   50: aload_0
    //   51: ldc_w 324
    //   54: aload_1
    //   55: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   58: aload_0
    //   59: ldc_w 326
    //   62: aload_1
    //   63: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   66: aload_0
    //   67: ldc_w 328
    //   70: aload_1
    //   71: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   74: aload_0
    //   75: ldc_w 330
    //   78: aload_1
    //   79: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   82: aload_0
    //   83: ldc_w 332
    //   86: aload_1
    //   87: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   90: aload_0
    //   91: ldc_w 334
    //   94: aload_1
    //   95: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   98: aload_0
    //   99: ldc_w 336
    //   102: aload_1
    //   103: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   106: aload_0
    //   107: ldc_w 338
    //   110: aload_1
    //   111: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   114: aload_0
    //   115: ldc_w 340
    //   118: aload_1
    //   119: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   122: aload_0
    //   123: ldc_w 342
    //   126: aload_1
    //   127: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   130: aload_0
    //   131: ldc_w 344
    //   134: aload_1
    //   135: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   138: aload_0
    //   139: ldc_w 346
    //   142: aload_1
    //   143: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   146: aload_0
    //   147: ldc_w 348
    //   150: aload_1
    //   151: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   154: aload_0
    //   155: ldc_w 350
    //   158: aload_1
    //   159: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   162: aload_0
    //   163: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   166: ldc_w 352
    //   169: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   172: ifnull +30 -> 202
    //   175: aload_0
    //   176: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   179: ldc_w 352
    //   182: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   185: checkcast 354	java/lang/CharSequence
    //   188: invokestatic 360	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +11 -> 202
    //   194: aload_0
    //   195: ldc_w 352
    //   198: aload_1
    //   199: invokespecial 318	com/unionpay/mobile/android/pro/views/k:a	(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   202: aload_1
    //   203: invokevirtual 361	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   206: astore_1
    //   207: aload_0
    //   208: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   211: ldc_w 363
    //   214: aload_1
    //   215: invokevirtual 313	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   218: pop
    //   219: aload_0
    //   220: aload_0
    //   221: getfield 365	com/unionpay/mobile/android/pro/views/k:I	Ljava/lang/String;
    //   224: aload_0
    //   225: getfield 182	com/unionpay/mobile/android/pro/views/k:s	Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   228: invokevirtual 367	com/unionpay/mobile/android/nocard/utils/UPPayEngine:b	()Ljava/lang/String;
    //   231: invokestatic 370	com/unionpay/mobile/android/pro/views/k:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   234: putfield 365	com/unionpay/mobile/android/pro/views/k:I	Ljava/lang/String;
    //   237: new 372	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 375
    //   247: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 380
    //   253: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   260: ldc_w 382
    //   263: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   266: checkcast 245	java/lang/String
    //   269: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: astore_1
    //   276: new 372	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   283: aload_1
    //   284: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 385
    //   290: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   297: ldc_w 309
    //   300: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   303: checkcast 245	java/lang/String
    //   306: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: astore_1
    //   313: new 372	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   320: aload_1
    //   321: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc_w 387
    //   327: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   334: ldc_w 363
    //   337: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   340: checkcast 245	java/lang/String
    //   343: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: astore_1
    //   350: new 372	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   357: aload_1
    //   358: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc_w 389
    //   364: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   371: ldc_w 391
    //   374: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   377: checkcast 245	java/lang/String
    //   380: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: astore_1
    //   387: new 372	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   394: aload_1
    //   395: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc_w 393
    //   401: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_0
    //   405: getfield 395	com/unionpay/mobile/android/pro/views/k:J	Ljava/lang/String;
    //   408: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: astore 4
    //   416: ldc_w 397
    //   419: aload 4
    //   421: invokestatic 402	com/unionpay/mobile/android/utils/j:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   424: pop
    //   425: aload 4
    //   427: invokestatic 405	com/unionpay/mobile/android/pro/views/k:d	(Ljava/lang/String;)Ljava/lang/String;
    //   430: astore_1
    //   431: ldc_w 407
    //   434: aload_1
    //   435: invokestatic 402	com/unionpay/mobile/android/utils/j:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   438: pop
    //   439: aload_0
    //   440: getfield 228	com/unionpay/mobile/android/pro/views/k:e	Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   443: aload_1
    //   444: invokevirtual 410	com/unionpay/mobile/android/nocard/utils/UPPayEngine:h	(Ljava/lang/String;)Ljava/lang/String;
    //   447: astore_1
    //   448: ldc_w 412
    //   451: aload_1
    //   452: invokestatic 402	com/unionpay/mobile/android/utils/j:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   455: pop
    //   456: new 372	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   463: aload 4
    //   465: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: ldc_w 414
    //   471: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload_1
    //   475: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: astore 4
    //   483: aload_0
    //   484: getfield 228	com/unionpay/mobile/android/pro/views/k:e	Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   487: aload 4
    //   489: aload_0
    //   490: getfield 365	com/unionpay/mobile/android/pro/views/k:I	Ljava/lang/String;
    //   493: invokevirtual 416	com/unionpay/mobile/android/nocard/utils/UPPayEngine:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   496: astore 6
    //   498: new 418	org/json/JSONObject
    //   501: dup
    //   502: invokespecial 419	org/json/JSONObject:<init>	()V
    //   505: astore 4
    //   507: aload 4
    //   509: ldc_w 420
    //   512: aload_0
    //   513: getfield 102	com/unionpay/mobile/android/pro/views/k:r	Ljava/lang/String;
    //   516: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   519: pop
    //   520: aload 4
    //   522: ldc_w 425
    //   525: ldc_w 427
    //   528: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   531: pop
    //   532: new 418	org/json/JSONObject
    //   535: dup
    //   536: invokespecial 419	org/json/JSONObject:<init>	()V
    //   539: astore 5
    //   541: aload 4
    //   543: ldc_w 429
    //   546: aload 5
    //   548: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   551: pop
    //   552: aload 5
    //   554: ldc_w 431
    //   557: aload 6
    //   559: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   562: pop
    //   563: aload 5
    //   565: ldc_w 433
    //   568: ldc_w 435
    //   571: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   574: pop
    //   575: aload 5
    //   577: ldc_w 437
    //   580: ldc_w 439
    //   583: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   586: pop
    //   587: aload 5
    //   589: ldc_w 441
    //   592: ldc_w 443
    //   595: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   598: pop
    //   599: aload 5
    //   601: ldc_w 445
    //   604: ldc_w 447
    //   607: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   610: pop
    //   611: aload 5
    //   613: ldc_w 449
    //   616: ldc_w 451
    //   619: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   622: pop
    //   623: aload 5
    //   625: ldc_w 453
    //   628: aload_1
    //   629: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   632: pop
    //   633: aload 5
    //   635: ldc_w 455
    //   638: aload_0
    //   639: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   642: ldc_w 382
    //   645: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   648: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   651: pop
    //   652: aload_0
    //   653: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   656: ldc_w 457
    //   659: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   662: ifnull +22 -> 684
    //   665: aload 5
    //   667: ldc_w 459
    //   670: aload_0
    //   671: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   674: ldc_w 457
    //   677: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   680: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   683: pop
    //   684: aload_0
    //   685: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   688: ldc_w 461
    //   691: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   694: ifnull +22 -> 716
    //   697: aload 5
    //   699: ldc_w 463
    //   702: aload_0
    //   703: getfield 172	com/unionpay/mobile/android/pro/views/k:ac	Ljava/util/HashMap;
    //   706: ldc_w 461
    //   709: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   712: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   715: pop
    //   716: aload_2
    //   717: ifnull +100 -> 817
    //   720: aload_2
    //   721: invokevirtual 467	java/util/HashMap:keySet	()Ljava/util/Set;
    //   724: ifnull +93 -> 817
    //   727: aload_2
    //   728: invokevirtual 467	java/util/HashMap:keySet	()Ljava/util/Set;
    //   731: invokeinterface 472 1 0
    //   736: ifle +81 -> 817
    //   739: aload_2
    //   740: ldc_w 455
    //   743: invokevirtual 475	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   746: pop
    //   747: aload_2
    //   748: ldc_w 477
    //   751: invokevirtual 475	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   754: pop
    //   755: aload_2
    //   756: invokevirtual 467	java/util/HashMap:keySet	()Ljava/util/Set;
    //   759: invokeinterface 481 1 0
    //   764: astore_1
    //   765: aload_1
    //   766: invokeinterface 486 1 0
    //   771: ifeq +46 -> 817
    //   774: aload_1
    //   775: invokeinterface 490 1 0
    //   780: checkcast 245	java/lang/String
    //   783: astore 6
    //   785: aload 5
    //   787: aload 6
    //   789: aload_2
    //   790: aload 6
    //   792: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   795: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   798: pop
    //   799: goto -34 -> 765
    //   802: astore_1
    //   803: aload_3
    //   804: ldc_w 492
    //   807: ldc_w 494
    //   810: invokevirtual 499	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   813: aload_0
    //   814: monitorexit
    //   815: aload_3
    //   816: areturn
    //   817: aload 4
    //   819: invokevirtual 500	org/json/JSONObject:toString	()Ljava/lang/String;
    //   822: astore_1
    //   823: aload_3
    //   824: ldc_w 502
    //   827: aload_0
    //   828: getfield 182	com/unionpay/mobile/android/pro/views/k:s	Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   831: aload_1
    //   832: invokevirtual 504	com/unionpay/mobile/android/nocard/utils/UPPayEngine:a	(Ljava/lang/String;)Ljava/lang/String;
    //   835: invokevirtual 499	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   838: goto -25 -> 813
    //   841: astore_1
    //   842: aload_0
    //   843: monitorexit
    //   844: aload_1
    //   845: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	846	0	this	k
    //   0	846	1	paramString	String
    //   0	846	2	paramHashMap	HashMap<String, String>
    //   5	819	3	localBundle	Bundle
    //   414	404	4	localObject	Object
    //   539	247	5	localJSONObject	JSONObject
    //   496	295	6	str	String
    // Exception table:
    //   from	to	target	type
    //   498	684	802	org/json/JSONException
    //   684	716	802	org/json/JSONException
    //   720	765	802	org/json/JSONException
    //   765	799	802	org/json/JSONException
    //   817	823	802	org/json/JSONException
    //   2	202	841	finally
    //   202	498	841	finally
    //   498	684	841	finally
    //   684	716	841	finally
    //   720	765	841	finally
    //   765	799	841	finally
    //   803	813	841	finally
    //   817	823	841	finally
    //   823	838	841	finally
  }
  
  private static final String d(String paramString)
  {
    try
    {
      paramString = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString);
      paramString = com.unionpay.mobile.android.pboctransaction.e.a(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void d(String paramString1, String paramString2)
  {
    this.v = 8;
    if (TextUtils.isEmpty(paramString2)) {
      this.e.c(paramString1, "");
    }
    for (;;)
    {
      this.Q -= 1;
      return;
      paramString2 = "\"uuid\":\"" + paramString2 + "\"";
      this.e.a(paramString1, paramString2, 10);
    }
  }
  
  private static String e(String paramString1, String paramString2)
  {
    paramString1 = com.unionpay.mobile.android.pboctransaction.e.a(paramString1);
    paramString2 = com.unionpay.mobile.android.pboctransaction.e.a(paramString2);
    int i = 0;
    while (i < paramString1.length)
    {
      paramString1[i] = ((byte)(paramString1[i] ^ paramString2[i]));
      i += 1;
    }
    return com.unionpay.mobile.android.pboctransaction.e.a(paramString1);
  }
  
  private void u()
  {
    this.v = 103;
    int i = this.u;
    this.e.a("query", this.a.aj, 3);
    this.u -= 1;
  }
  
  private HashMap<String, String> v()
  {
    HashMap localHashMap1 = new HashMap();
    if (this.y != null) {
      localHashMap1 = this.y.c();
    }
    HashMap localHashMap2;
    if (this.O != null)
    {
      localHashMap2 = this.O.c();
      if ((localHashMap2 == null) || (localHashMap1 == null)) {
        break label53;
      }
      localHashMap1.putAll(localHashMap2);
    }
    label53:
    while ((localHashMap2 == null) || (localHashMap1 != null)) {
      return localHashMap1;
    }
    return localHashMap2;
  }
  
  private static Bundle w()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("action_resp_code", "0000");
    return localBundle;
  }
  
  private int x()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.d).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels;
  }
  
  public final Bundle a(String paramString, HashMap<String, String> paramHashMap)
  {
    return c(paramString, paramHashMap);
  }
  
  public final void a(com.unionpay.mobile.android.pboctransaction.nfc.a parama)
  {
    this.t = parama;
    Object localObject1 = this.a.p;
    Object localObject2 = aa.substring(2, 8);
    long l = new Date(System.currentTimeMillis()).getTime();
    parama = String.valueOf(l);
    if (parama.length() < 8)
    {
      parama = String.format("%08d", new Object[] { Long.valueOf(l) });
      this.ac.put("9F26", "");
      this.ac.put("9F27", "80");
      this.ac.put("9F10", "");
      this.ac.put("9F37", parama);
      this.ac.put("9F36", "");
      this.ac.put("95", "0000000800");
      this.ac.put("9A", localObject2);
      this.ac.put("9C", "45");
      this.ac.put("9F02", "000000000000");
      this.ac.put("5F2A", "0156");
      this.ac.put("82", "");
      this.ac.put("9F1A", "0156");
      this.ac.put("9F03", "000000000000");
      this.ac.put("9F33", "A04000");
      this.ac.put("9F34", "420300");
      this.ac.put("9F35", "34");
      this.ac.put("9F1E", "3030303030303030");
      this.ac.put("84", "");
      this.ac.put("9F09", "0001");
      this.ac.put("9F74", "");
      this.ac.put("9F63", "");
      this.ac.put("9F7A", "00");
      this.ac.put("9F21", aa.substring(8));
      this.ac.put("9F4E", "0000000000000000000000000000000000000000");
      this.ac.put("DF31", "0100000000");
      this.ac.put("9F66", "36800000");
      this.ac.put("DF60", "00");
      this.ac.put("9F02", ((HashMap)localObject1).get("trans_amt"));
      this.ac.put("9F1A", "0156");
      this.ac.put("5F2A", ((HashMap)localObject1).get("trans currcy code"));
      this.ac.put("9C", ((HashMap)localObject1).get("trans_type"));
      this.ac.put("CUR", this.ac.get("5F2A"));
      parama = w();
      Z = new Date(System.currentTimeMillis());
      aa = new SimpleDateFormat("yyyyMMddHHmmss").format(Z);
      this.ab = new String(aa);
      localObject1 = this.t.a();
      if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
        break label773;
      }
      parama.putString("action_resp_code", "10019");
      label625:
      if (parama.getString("action_resp_code") == "0000") {
        break label861;
      }
      localObject1 = this.z;
      localObject2 = this.z;
      if (parama == null) {
        break label856;
      }
      label654:
      ((Handler)localObject1).sendMessage(((Handler)localObject2).obtainMessage(0, parama));
    }
    label773:
    label856:
    label861:
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (this.M))
      {
        this.v = 102;
        this.j = false;
        this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
        parama = (String)this.ac.get("AN1");
        parama = "\"pan\":\"" + parama + "\",\"carrier_tp\":\"7\"";
        this.e.c("cardrules", parama);
      }
      return;
      parama = parama.substring(parama.length() - 8, parama.length());
      break;
      if ("noSupUnionpay".equals(localObject1))
      {
        parama.putString("action_resp_code", "10024");
        break label625;
      }
      localObject1 = this.t.a((String)localObject1, this.ac);
      if ((localObject1 == null) || (((String)localObject1).length() == 0))
      {
        parama.putString("action_resp_code", "10020");
        break label625;
      }
      localObject2 = this.t;
      com.unionpay.mobile.android.pboctransaction.nfc.a.b((String)localObject1, this.ac);
      break label625;
      parama = null;
      break label654;
    }
  }
  
  public final void a(a.a parama) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    switch (this.v)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              this.b.c();
              for (;;)
              {
                try
                {
                  this.I = ((String)paramJSONObject.get("encrypt_key"));
                  this.J = ((String)paramJSONObject.get("auth_id"));
                  i = com.unionpay.mobile.android.nocard.utils.f.a(this.a, paramJSONObject, false);
                  this.p = com.unionpay.mobile.android.nocard.utils.f.a(paramJSONObject);
                  if (i != 0)
                  {
                    b(i);
                    return;
                  }
                }
                catch (JSONException localJSONException)
                {
                  int i;
                  localJSONException.printStackTrace();
                  continue;
                  this.M = false;
                  setBackgroundColor(-1052684);
                  this.F.setBackgroundColor(com.unionpay.mobile.android.global.a.M);
                  this.F.a(8);
                  this.A.removeAllViews();
                  this.B.setVisibility(8);
                  this.m.setBackgroundColor(-1052684);
                  this.l.setVisibility(0);
                  this.H.setVisibility(8);
                  this.D.setVisibility(8);
                  new LinearLayout.LayoutParams(-1, -2);
                  paramJSONObject = new JSONArray();
                  if (this.p != null)
                  {
                    localObject = (com.unionpay.mobile.android.model.f)this.p;
                    paramJSONObject.put(((com.unionpay.mobile.android.model.f)localObject).a("promotion"));
                    paramJSONObject.put(((com.unionpay.mobile.android.model.f)localObject).a("instalment"));
                    this.a.aU = ((com.unionpay.mobile.android.model.f)localObject).a("promotion_instalment_msgbox");
                  }
                  if (paramJSONObject.length() > 0)
                  {
                    this.O = new com.unionpay.mobile.android.upviews.a(this.d, paramJSONObject, this, this.q);
                    this.O.a(this.b, this.a.aU);
                    this.O.a(this.S);
                    this.O.b(this.T);
                    this.O.c(this.U);
                    paramJSONObject = new LinearLayout.LayoutParams(-1, -2);
                    paramJSONObject.topMargin = com.unionpay.mobile.android.global.a.f;
                    this.A.addView(this.O, paramJSONObject);
                  }
                  if (this.O != null) {
                    this.O.c("instalment");
                  }
                  this.y = new com.unionpay.mobile.android.upviews.a(this.d, this.a.z, this.e.c(), this, (String)this.ac.get("AN1"), true, this.q);
                  paramJSONObject = new LinearLayout.LayoutParams(-1, -2);
                  paramJSONObject.topMargin = com.unionpay.mobile.android.global.a.f;
                  this.A.addView(this.y, paramJSONObject);
                  paramJSONObject = new LinearLayout(this.d);
                  paramJSONObject.setOrientation(1);
                  paramJSONObject.setId(paramJSONObject.hashCode());
                  new LinearLayout.LayoutParams(-1, -2);
                  localObject = new LinearLayout.LayoutParams(-1, -2);
                  ((LinearLayout.LayoutParams)localObject).topMargin = com.unionpay.mobile.android.global.a.f;
                  ((LinearLayout.LayoutParams)localObject).leftMargin = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
                  this.A.addView(paramJSONObject, (ViewGroup.LayoutParams)localObject);
                  if ((i()) || (this.a.al != null) || (this.a.am != null))
                  {
                    if (this.a.al != null)
                    {
                      this.L = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.al, this.W, this.q + "_agree_user_protocol");
                      paramJSONObject.addView(this.L);
                    }
                    if (this.a.am != null)
                    {
                      this.K = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.am, null, this.q + "_remember_bankNO");
                      localObject = new LinearLayout.LayoutParams(-2, -2);
                      ((LinearLayout.LayoutParams)localObject).topMargin = com.unionpay.mobile.android.global.a.f;
                      paramJSONObject.addView(this.K, (ViewGroup.LayoutParams)localObject);
                    }
                  }
                  new LinearLayout.LayoutParams(-1, -2);
                  this.w = new TextView(this.d);
                  this.w.setText(i.a(this.a.C, "label"));
                  this.w.setTextSize(com.unionpay.mobile.android.global.b.i);
                  this.w.setTextColor(p());
                  this.w.setGravity(17);
                  paramJSONObject = this.w;
                  bool1 = bool2;
                  if (this.y != null)
                  {
                    if (this.y.e()) {
                      bool1 = bool2;
                    }
                  }
                  else
                  {
                    paramJSONObject.setEnabled(bool1);
                    i = com.unionpay.mobile.android.global.a.n;
                    paramJSONObject = this.c.a(2008);
                    this.w.setBackgroundDrawable(paramJSONObject);
                    this.w.setOnClickListener(this.R);
                    paramJSONObject = new LinearLayout.LayoutParams(-1, i);
                    paramJSONObject.topMargin = com.unionpay.mobile.android.global.a.f;
                    i = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
                    paramJSONObject.rightMargin = i;
                    paramJSONObject.leftMargin = i;
                    this.A.addView(this.w, paramJSONObject);
                    return;
                  }
                }
                boolean bool1 = false;
              }
              try
              {
                this.I = ((String)paramJSONObject.get("encrypt_key"));
                this.J = ((String)paramJSONObject.get("auth_id"));
                if (this.a.p != null)
                {
                  paramJSONObject = this.y.a();
                  if (!paramJSONObject.a())
                  {
                    this.N = true;
                    a(paramJSONObject.b);
                    return;
                  }
                }
              }
              catch (JSONException paramJSONObject)
              {
                for (;;)
                {
                  paramJSONObject.printStackTrace();
                }
                this.v = 101;
                b(this.y.a().b, v());
                return;
              }
            }
            this.a.aj = h.a(paramJSONObject.toString());
            paramJSONObject = i.a(paramJSONObject, "qn");
            if (!TextUtils.isEmpty(paramJSONObject)) {
              this.a.n = this.e.i(com.unionpay.mobile.android.utils.c.b(paramJSONObject));
            }
            if ((this.a.aj == null) || (this.a.aj.length() <= 0))
            {
              b(2);
              return;
            }
            this.u = 20;
            u();
            return;
            localObject = i.a(paramJSONObject, "status");
            String str = i.a(paramJSONObject, "fail_msg");
            if ((this.u > 0) && (((String)localObject).equalsIgnoreCase("01")))
            {
              u();
              return;
            }
            this.v = 100;
            if (((String)localObject).equalsIgnoreCase("00"))
            {
              j();
              this.v = 100;
              this.a.H = i.d(paramJSONObject, "result");
              this.a.P = i.a(paramJSONObject, "openupgrade_flag");
              this.a.Q = i.a(paramJSONObject, "temporary_pay_flag");
              this.a.R = i.a(paramJSONObject, "temporary_pay_info");
              this.a.V = i.a(paramJSONObject, "front_url");
              this.a.W = i.a(paramJSONObject, "front_request");
              this.a.A = i.a(paramJSONObject, "title");
              this.a.B = i.a(paramJSONObject, "succ_info");
              com.unionpay.mobile.android.nocard.utils.b.b(paramJSONObject, this.a);
              com.unionpay.mobile.android.nocard.utils.b.a(paramJSONObject, this.a);
              if (this.y != null) {
                this.y.f();
              }
              a(this.d, this.q + "_succeed");
              if (this.a.f)
              {
                this.a.I.f = "success";
                k();
                return;
              }
              d(8);
              return;
            }
            j();
            this.N = true;
            if (((String)localObject).equalsIgnoreCase("03"))
            {
              a(this.d, this.q + "_fail", com.unionpay.mobile.android.utils.o.j, new String[] { localObject, str });
              a(str);
              return;
            }
          } while (this.u > 0);
          a(this.a.ak);
          return;
          j();
          paramJSONObject = i.d(paramJSONObject, "options");
        } while (this.O == null);
        this.O.a(paramJSONObject);
        return;
        localObject = i.a(paramJSONObject, "status");
        if ((localObject == null) || (!"01".equals(localObject))) {
          break;
        }
        paramJSONObject = i.a(paramJSONObject, "uuid");
        if (this.Q >= 0)
        {
          d(this.P, paramJSONObject);
          return;
        }
        paramJSONObject = com.unionpay.mobile.android.languages.c.bD.D;
      } while (this.O == null);
      this.O.a(null, paramJSONObject);
      return;
      localObject = i.d(paramJSONObject, "options");
      paramJSONObject = i.a(paramJSONObject, "empty_info");
    } while (this.O == null);
    this.O.a((JSONArray)localObject, paramJSONObject);
  }
  
  public final void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.w != null)
    {
      localTextView = this.w;
      if (paramBoolean) {
        break label24;
      }
    }
    label24:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
    }
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    if (this.a.aD) {}
    for (this.F = new ay(this.d, com.unionpay.mobile.android.languages.c.bD.bo, this.c.a(1030), com.unionpay.mobile.android.utils.f.a(this.d, 20.0F), this);; this.F = new ay(getContext(), com.unionpay.mobile.android.languages.c.bD.bo, this))
    {
      this.F.setBackgroundColor(-16686660);
      this.F.a(0);
      localLayoutParams.addRule(13, -1);
      this.k.addView(this.F, localLayoutParams);
      return;
    }
  }
  
  public final void b(int paramInt)
  {
    switch (this.v)
    {
    }
    for (;;)
    {
      super.b(paramInt);
      return;
      this.N = true;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.B.setVisibility(8);
      if (this.M) {
        this.D.setVisibility(0);
      }
      this.E.setVisibility(8);
      if (this.G != null) {
        this.G.setVisibility(0);
      }
    }
    do
    {
      return;
      this.B.setVisibility(0);
      this.D.setVisibility(8);
      this.E.setVisibility(0);
    } while (this.G == null);
    this.G.setVisibility(4);
  }
  
  protected final void c()
  {
    this.l.setVisibility(8);
    Object localObject1 = new FrameLayout(this.d);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.m.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new FrameLayout.LayoutParams(-1, x() - com.unionpay.mobile.android.global.b.n - com.unionpay.mobile.android.global.b.n / 2);
    this.A = new LinearLayout(this.d);
    this.A.setId(this.A.hashCode());
    this.A.setOrientation(1);
    ((FrameLayout)localObject1).addView(this.A, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new FrameLayout.LayoutParams(com.unionpay.mobile.android.global.b.n * 2, com.unionpay.mobile.android.global.b.n * 2);
    Object localObject3 = new DisplayMetrics();
    ((Activity)this.d).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject3);
    ((FrameLayout.LayoutParams)localObject2).leftMargin = (((DisplayMetrics)localObject3).widthPixels / 2 - com.unionpay.mobile.android.global.b.n);
    ((FrameLayout.LayoutParams)localObject2).topMargin = (x() / 2 - com.unionpay.mobile.android.global.b.n * 2);
    this.H = new ImageView(this.d);
    this.H.setBackgroundDrawable(this.c.a(1032));
    ((FrameLayout)localObject1).addView(this.H, (ViewGroup.LayoutParams)localObject2);
    this.E = new LinearLayout(this.d);
    this.E.setBackgroundColor(-1342177280);
    localObject2 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout)localObject1).addView(this.E, (ViewGroup.LayoutParams)localObject2);
    this.C = new RelativeLayout(this.d);
    localObject2 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout)localObject1).addView(this.C, (ViewGroup.LayoutParams)localObject2);
    this.m.setBackgroundColor(-11495169);
    localObject1 = this.A;
    this.A.removeAllViews();
    this.G = new UPRadiationView(this.d);
    localObject2 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout)localObject1).addView(this.G, (ViewGroup.LayoutParams)localObject2);
    localObject1 = this.C;
    ((RelativeLayout)localObject1).setGravity(1);
    int i = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
    this.B = new LinearLayout(this.d);
    this.B.setId(this.B.hashCode());
    this.B.setOrientation(0);
    this.B.setPadding(i * 2, i, i * 2, i);
    localObject2 = this.c.a(1033);
    this.B.setBackgroundDrawable((Drawable)localObject2);
    localObject3 = com.unionpay.mobile.android.languages.c.bD.bl;
    TextView localTextView = new TextView(this.d);
    localTextView.setTextColor(-1);
    localTextView.setText((CharSequence)localObject3);
    localTextView.setTextSize(com.unionpay.mobile.android.global.b.k);
    this.B.addView(localTextView);
    localObject3 = com.unionpay.mobile.android.languages.c.bD.bm;
    localTextView = new TextView(this.d);
    localTextView.setTextColor(-16729682);
    localTextView.setText((CharSequence)localObject3);
    localTextView.setTextSize(com.unionpay.mobile.android.global.b.k);
    localTextView.setOnClickListener(this.V);
    this.B.addView(localTextView);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = com.unionpay.mobile.android.global.b.n;
    ((RelativeLayout)localObject1).addView(this.B, (ViewGroup.LayoutParams)localObject3);
    this.D = new LinearLayout(this.d);
    this.D.setId(this.D.hashCode());
    this.D.setOrientation(0);
    this.D.setGravity(17);
    this.D.setPadding(i * 2, i, i * 2, i);
    this.D.setBackgroundDrawable((Drawable)localObject2);
    localObject2 = com.unionpay.mobile.android.languages.c.bD.bn;
    localObject3 = new TextView(this.d);
    ((TextView)localObject3).setTextColor(-1);
    ((TextView)localObject3).setText((CharSequence)localObject2);
    ((TextView)localObject3).setTextSize(com.unionpay.mobile.android.global.b.k);
    this.D.addView((View)localObject3);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.unionpay.mobile.android.global.b.n;
    ((RelativeLayout)localObject1).addView(this.D, (ViewGroup.LayoutParams)localObject2);
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.obj != null)
    {
      Object localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("action_resp_code");
      localObject = ((Bundle)localObject).getString("action_resp_message");
      if (!"0000".equalsIgnoreCase(paramMessage)) {
        break label53;
      }
      if (localObject != null) {
        a(0, (String)localObject);
      }
    }
    for (;;)
    {
      return true;
      label53:
      "10024".equalsIgnoreCase(paramMessage);
      a(this.a.ap, false);
    }
  }
  
  public final void l()
  {
    if (this.a.aD)
    {
      locals = new s(this);
      localt = new t(this);
      this.b.a(locals, localt);
      this.b.a(com.unionpay.mobile.android.languages.c.bD.Y, com.unionpay.mobile.android.languages.c.bD.av, com.unionpay.mobile.android.languages.c.bD.W, com.unionpay.mobile.android.languages.c.bD.X);
    }
    while ((this.y != null) && (this.y.d()))
    {
      s locals;
      t localt;
      return;
    }
    if ((this.a.K) && (this.x))
    {
      this.a.K = false;
      n();
      return;
    }
    this.a.K = false;
    this.M = false;
    a(2);
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.y != null) {
      this.y.d();
    }
    if (this.G != null) {
      this.G.a();
    }
    this.G = null;
    this.b = null;
  }
  
  public final void t() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */