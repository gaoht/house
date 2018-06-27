package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.widgets.ad;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bh
{
  public static LinearLayout a(Context paramContext, JSONArray paramJSONArray, int paramInt1, int paramInt2)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setBackgroundColor(-1);
    localLinearLayout.setOrientation(1);
    new LinearLayout.LayoutParams(-1, -2).topMargin = a.d;
    Object localObject = null;
    for (;;)
    {
      if ((paramInt1 >= paramInt2) || (paramInt1 >= paramJSONArray.length())) {
        break label102;
      }
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(paramInt1);
        localObject = localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      localLinearLayout.addView(new ad(paramContext, a.I, (JSONObject)localObject, ""));
      paramInt1 += 1;
    }
    label102:
    return localLinearLayout;
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: new 70	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 72	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc 74
    //   13: aload_1
    //   14: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   17: pop
    //   18: aload 6
    //   20: ldc 80
    //   22: aload_0
    //   23: invokestatic 85	com/unionpay/mobile/android/utils/e:d	(Landroid/content/Context;)Ljava/lang/String;
    //   26: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload 6
    //   32: ldc 87
    //   34: invokestatic 90	com/unionpay/mobile/android/utils/e:a	()Ljava/lang/String;
    //   37: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload 6
    //   46: ldc 95
    //   48: aload_0
    //   49: invokestatic 97	com/unionpay/mobile/android/utils/e:a	(Landroid/content/Context;)Ljava/lang/String;
    //   52: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload 6
    //   58: ldc 99
    //   60: invokestatic 101	com/unionpay/mobile/android/utils/e:d	()Ljava/lang/String;
    //   63: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   66: pop
    //   67: aload 6
    //   69: ldc 103
    //   71: aload_2
    //   72: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   75: pop
    //   76: aload 6
    //   78: ldc 105
    //   80: getstatic 111	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   83: invokevirtual 116	java/lang/String:trim	()Ljava/lang/String;
    //   86: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   89: pop
    //   90: aload 6
    //   92: ldc 118
    //   94: invokestatic 121	com/unionpay/mobile/android/utils/e:c	()Ljava/lang/String;
    //   97: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   100: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   103: pop
    //   104: aload 6
    //   106: ldc 123
    //   108: aload_3
    //   109: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload 6
    //   115: ldc 125
    //   117: aload 4
    //   119: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: aload 6
    //   125: ldc 127
    //   127: aload_0
    //   128: invokestatic 130	com/unionpay/mobile/android/utils/PreferenceUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   131: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   134: pop
    //   135: aload 6
    //   137: ldc -124
    //   139: aload_0
    //   140: invokestatic 134	com/unionpay/mobile/android/utils/e:c	(Landroid/content/Context;)Ljava/lang/String;
    //   143: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   146: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   149: pop
    //   150: aload 6
    //   152: ldc -120
    //   154: invokestatic 139	com/unionpay/mobile/android/utils/e:f	()Ljava/lang/String;
    //   157: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   160: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload 6
    //   166: ldc -115
    //   168: aload_0
    //   169: invokestatic 143	com/unionpay/mobile/android/utils/e:f	(Landroid/content/Context;)Ljava/lang/String;
    //   172: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   175: pop
    //   176: aload 6
    //   178: ldc -111
    //   180: aload_0
    //   181: invokestatic 148	com/unionpay/mobile/android/utils/e:e	(Landroid/content/Context;)Ljava/lang/String;
    //   184: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   187: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload 6
    //   193: ldc -106
    //   195: invokestatic 152	com/unionpay/mobile/android/utils/e:e	()Ljava/lang/String;
    //   198: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   201: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   204: pop
    //   205: new 154	java/lang/StringBuffer
    //   208: dup
    //   209: ldc -100
    //   211: invokespecial 159	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   214: astore_1
    //   215: ldc -100
    //   217: aload 5
    //   219: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   222: ifne +10 -> 232
    //   225: aload_1
    //   226: iconst_2
    //   227: bipush 49
    //   229: invokevirtual 167	java/lang/StringBuffer:setCharAt	(IC)V
    //   232: getstatic 170	android/os/Build$VERSION:SDK_INT	I
    //   235: bipush 10
    //   237: if_icmplt +61 -> 298
    //   240: aload_0
    //   241: ldc -84
    //   243: invokevirtual 178	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   246: checkcast 180	android/nfc/NfcManager
    //   249: invokevirtual 184	android/nfc/NfcManager:getDefaultAdapter	()Landroid/nfc/NfcAdapter;
    //   252: astore_2
    //   253: aload_2
    //   254: ifnull +44 -> 298
    //   257: aload_2
    //   258: invokevirtual 190	android/nfc/NfcAdapter:isEnabled	()Z
    //   261: ifeq +273 -> 534
    //   264: aload_1
    //   265: iconst_0
    //   266: bipush 49
    //   268: invokevirtual 167	java/lang/StringBuffer:setCharAt	(IC)V
    //   271: getstatic 170	android/os/Build$VERSION:SDK_INT	I
    //   274: bipush 19
    //   276: if_icmplt +22 -> 298
    //   279: aload_0
    //   280: invokevirtual 194	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   283: ldc -60
    //   285: invokevirtual 202	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   288: ifeq +10 -> 298
    //   291: aload_1
    //   292: iconst_1
    //   293: bipush 49
    //   295: invokevirtual 167	java/lang/StringBuffer:setCharAt	(IC)V
    //   298: aload 6
    //   300: ldc -52
    //   302: aload_1
    //   303: invokevirtual 207	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   306: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   309: pop
    //   310: aload 6
    //   312: ldc -47
    //   314: aload 5
    //   316: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   319: pop
    //   320: aload 6
    //   322: ldc -45
    //   324: invokestatic 214	com/unionpay/mobile/android/utils/e:b	()Ljava/lang/String;
    //   327: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   330: pop
    //   331: aload 6
    //   333: ldc -40
    //   335: invokestatic 222	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   338: invokevirtual 225	java/util/Locale:getCountry	()Ljava/lang/String;
    //   341: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   344: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   347: pop
    //   348: aload 6
    //   350: ldc -29
    //   352: aload_0
    //   353: invokestatic 229	com/unionpay/mobile/android/utils/e:b	(Landroid/content/Context;)Ljava/lang/String;
    //   356: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   359: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   362: pop
    //   363: aload_0
    //   364: invokestatic 233	com/unionpay/mobile/android/utils/e:g	(Landroid/content/Context;)Landroid/location/Location;
    //   367: astore_1
    //   368: aload_1
    //   369: ifnull +197 -> 566
    //   372: aload_1
    //   373: invokevirtual 239	android/location/Location:getLatitude	()D
    //   376: invokestatic 245	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   379: invokevirtual 246	java/lang/Double:toString	()Ljava/lang/String;
    //   382: astore_1
    //   383: aload 6
    //   385: ldc -8
    //   387: aload_1
    //   388: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   391: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   394: pop
    //   395: aload_0
    //   396: invokestatic 233	com/unionpay/mobile/android/utils/e:g	(Landroid/content/Context;)Landroid/location/Location;
    //   399: astore_1
    //   400: aload_1
    //   401: ifnull +159 -> 560
    //   404: aload_1
    //   405: invokevirtual 251	android/location/Location:getLongitude	()D
    //   408: invokestatic 245	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   411: invokevirtual 246	java/lang/Double:toString	()Ljava/lang/String;
    //   414: astore_1
    //   415: aload 6
    //   417: ldc -3
    //   419: aload_1
    //   420: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   423: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   426: pop
    //   427: aload 6
    //   429: ldc -1
    //   431: aload_0
    //   432: invokestatic 258	com/unionpay/mobile/android/utils/e:h	(Landroid/content/Context;)Ljava/lang/String;
    //   435: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   438: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   441: pop
    //   442: aload 6
    //   444: invokevirtual 259	org/json/JSONObject:toString	()Ljava/lang/String;
    //   447: astore_0
    //   448: aload_0
    //   449: iconst_1
    //   450: aload_0
    //   451: invokevirtual 260	java/lang/String:length	()I
    //   454: iconst_1
    //   455: isub
    //   456: invokevirtual 264	java/lang/String:substring	(II)Ljava/lang/String;
    //   459: astore_0
    //   460: ldc_w 266
    //   463: new 268	java/lang/StringBuilder
    //   466: dup
    //   467: ldc_w 270
    //   470: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   473: aload_0
    //   474: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 281	com/unionpay/mobile/android/utils/j:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   483: pop
    //   484: aload_0
    //   485: areturn
    //   486: astore_1
    //   487: aload_1
    //   488: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   491: goto -327 -> 164
    //   494: astore_0
    //   495: aload_0
    //   496: invokevirtual 62	org/json/JSONException:printStackTrace	()V
    //   499: goto -57 -> 442
    //   502: astore_1
    //   503: aload_1
    //   504: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   507: goto -331 -> 176
    //   510: astore_0
    //   511: aload_0
    //   512: invokevirtual 283	java/util/regex/PatternSyntaxException:printStackTrace	()V
    //   515: goto -73 -> 442
    //   518: astore_1
    //   519: aload_1
    //   520: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   523: goto -332 -> 191
    //   526: astore_1
    //   527: aload_1
    //   528: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   531: goto -326 -> 205
    //   534: aload_1
    //   535: iconst_0
    //   536: bipush 50
    //   538: invokevirtual 167	java/lang/StringBuffer:setCharAt	(IC)V
    //   541: goto -270 -> 271
    //   544: astore_1
    //   545: aload_1
    //   546: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   549: goto -239 -> 310
    //   552: astore_1
    //   553: aload_1
    //   554: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   557: goto -237 -> 320
    //   560: ldc 51
    //   562: astore_1
    //   563: goto -148 -> 415
    //   566: ldc 51
    //   568: astore_1
    //   569: goto -186 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	paramContext	Context
    //   0	572	1	paramString1	String
    //   0	572	2	paramString2	String
    //   0	572	3	paramString3	String
    //   0	572	4	paramString4	String
    //   0	572	5	paramString5	String
    //   7	436	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   150	164	486	java/lang/Exception
    //   9	150	494	org/json/JSONException
    //   150	164	494	org/json/JSONException
    //   164	176	494	org/json/JSONException
    //   176	191	494	org/json/JSONException
    //   191	205	494	org/json/JSONException
    //   205	232	494	org/json/JSONException
    //   232	253	494	org/json/JSONException
    //   257	271	494	org/json/JSONException
    //   271	298	494	org/json/JSONException
    //   298	310	494	org/json/JSONException
    //   310	320	494	org/json/JSONException
    //   320	368	494	org/json/JSONException
    //   372	383	494	org/json/JSONException
    //   383	400	494	org/json/JSONException
    //   404	415	494	org/json/JSONException
    //   415	442	494	org/json/JSONException
    //   487	491	494	org/json/JSONException
    //   503	507	494	org/json/JSONException
    //   519	523	494	org/json/JSONException
    //   527	531	494	org/json/JSONException
    //   534	541	494	org/json/JSONException
    //   545	549	494	org/json/JSONException
    //   553	557	494	org/json/JSONException
    //   164	176	502	java/lang/Exception
    //   9	150	510	java/util/regex/PatternSyntaxException
    //   150	164	510	java/util/regex/PatternSyntaxException
    //   164	176	510	java/util/regex/PatternSyntaxException
    //   176	191	510	java/util/regex/PatternSyntaxException
    //   191	205	510	java/util/regex/PatternSyntaxException
    //   205	232	510	java/util/regex/PatternSyntaxException
    //   232	253	510	java/util/regex/PatternSyntaxException
    //   257	271	510	java/util/regex/PatternSyntaxException
    //   271	298	510	java/util/regex/PatternSyntaxException
    //   298	310	510	java/util/regex/PatternSyntaxException
    //   310	320	510	java/util/regex/PatternSyntaxException
    //   320	368	510	java/util/regex/PatternSyntaxException
    //   372	383	510	java/util/regex/PatternSyntaxException
    //   383	400	510	java/util/regex/PatternSyntaxException
    //   404	415	510	java/util/regex/PatternSyntaxException
    //   415	442	510	java/util/regex/PatternSyntaxException
    //   487	491	510	java/util/regex/PatternSyntaxException
    //   503	507	510	java/util/regex/PatternSyntaxException
    //   519	523	510	java/util/regex/PatternSyntaxException
    //   527	531	510	java/util/regex/PatternSyntaxException
    //   534	541	510	java/util/regex/PatternSyntaxException
    //   545	549	510	java/util/regex/PatternSyntaxException
    //   553	557	510	java/util/regex/PatternSyntaxException
    //   176	191	518	java/lang/Exception
    //   191	205	526	java/lang/Exception
    //   205	232	544	java/lang/Exception
    //   232	253	544	java/lang/Exception
    //   257	271	544	java/lang/Exception
    //   271	298	544	java/lang/Exception
    //   298	310	544	java/lang/Exception
    //   534	541	544	java/lang/Exception
    //   310	320	552	java/lang/Exception
  }
  
  private static String a(String paramString)
    throws PatternSyntaxException
  {
    if (paramString != null) {
      return Pattern.compile("[\":,\\[\\]{}]").matcher(paramString).replaceAll("").trim();
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return String.format("\"first_pay_flag\":\"%s\",\"card\":\"%s\",\"pay_type\":\"%s\",\"pay_mode\":\"%s\"", new Object[] { paramString1, paramString2, paramString3, paramString4 });
  }
  
  public static String a(JSONObject paramJSONObject)
  {
    j.a("uppay", "action:" + i.a(paramJSONObject, "action"));
    return i.a(paramJSONObject, "action");
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: new 70	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 72	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 320
    //   14: aload_1
    //   15: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   18: pop
    //   19: aload 6
    //   21: ldc_w 322
    //   24: aload 5
    //   26: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload 6
    //   32: ldc 80
    //   34: aload_0
    //   35: invokestatic 85	com/unionpay/mobile/android/utils/e:d	(Landroid/content/Context;)Ljava/lang/String;
    //   38: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   41: pop
    //   42: aload 6
    //   44: ldc 87
    //   46: invokestatic 90	com/unionpay/mobile/android/utils/e:a	()Ljava/lang/String;
    //   49: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   52: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload 6
    //   58: ldc 95
    //   60: aload_0
    //   61: invokestatic 97	com/unionpay/mobile/android/utils/e:a	(Landroid/content/Context;)Ljava/lang/String;
    //   64: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload 6
    //   70: ldc 99
    //   72: invokestatic 101	com/unionpay/mobile/android/utils/e:d	()Ljava/lang/String;
    //   75: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: aload 6
    //   81: ldc 103
    //   83: aload_2
    //   84: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   87: pop
    //   88: aload 6
    //   90: ldc 105
    //   92: getstatic 111	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   95: invokevirtual 116	java/lang/String:trim	()Ljava/lang/String;
    //   98: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   101: pop
    //   102: aload 6
    //   104: ldc 118
    //   106: invokestatic 121	com/unionpay/mobile/android/utils/e:c	()Ljava/lang/String;
    //   109: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   112: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload 6
    //   118: ldc 123
    //   120: aload_3
    //   121: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   124: pop
    //   125: aload 6
    //   127: ldc 125
    //   129: aload 4
    //   131: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   134: pop
    //   135: aload 6
    //   137: ldc 127
    //   139: aload_0
    //   140: invokestatic 130	com/unionpay/mobile/android/utils/PreferenceUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   143: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   146: pop
    //   147: aload 6
    //   149: ldc -124
    //   151: aload_0
    //   152: invokestatic 134	com/unionpay/mobile/android/utils/e:c	(Landroid/content/Context;)Ljava/lang/String;
    //   155: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   158: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   161: pop
    //   162: aload 6
    //   164: ldc -120
    //   166: invokestatic 139	com/unionpay/mobile/android/utils/e:f	()Ljava/lang/String;
    //   169: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   175: pop
    //   176: aload 6
    //   178: ldc -115
    //   180: aload_0
    //   181: invokestatic 143	com/unionpay/mobile/android/utils/e:f	(Landroid/content/Context;)Ljava/lang/String;
    //   184: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   187: pop
    //   188: aload 6
    //   190: ldc -111
    //   192: aload_0
    //   193: invokestatic 148	com/unionpay/mobile/android/utils/e:e	(Landroid/content/Context;)Ljava/lang/String;
    //   196: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   199: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   202: pop
    //   203: aload 6
    //   205: ldc -106
    //   207: invokestatic 152	com/unionpay/mobile/android/utils/e:e	()Ljava/lang/String;
    //   210: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   213: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   216: pop
    //   217: aload 6
    //   219: ldc -45
    //   221: invokestatic 214	com/unionpay/mobile/android/utils/e:b	()Ljava/lang/String;
    //   224: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   227: pop
    //   228: aload 6
    //   230: ldc -40
    //   232: invokestatic 222	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   235: invokevirtual 225	java/util/Locale:getCountry	()Ljava/lang/String;
    //   238: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   241: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   244: pop
    //   245: aload 6
    //   247: ldc -29
    //   249: aload_0
    //   250: invokestatic 229	com/unionpay/mobile/android/utils/e:b	(Landroid/content/Context;)Ljava/lang/String;
    //   253: invokestatic 93	com/unionpay/mobile/android/nocard/views/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   256: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   259: pop
    //   260: aload 6
    //   262: invokevirtual 259	org/json/JSONObject:toString	()Ljava/lang/String;
    //   265: astore_0
    //   266: aload_0
    //   267: iconst_1
    //   268: aload_0
    //   269: invokevirtual 260	java/lang/String:length	()I
    //   272: iconst_1
    //   273: isub
    //   274: invokevirtual 264	java/lang/String:substring	(II)Ljava/lang/String;
    //   277: astore_0
    //   278: ldc_w 266
    //   281: new 268	java/lang/StringBuilder
    //   284: dup
    //   285: ldc_w 270
    //   288: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   291: aload_0
    //   292: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 324	com/unionpay/mobile/android/utils/j:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   301: pop
    //   302: aload_0
    //   303: areturn
    //   304: astore_1
    //   305: aload_1
    //   306: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   309: goto -133 -> 176
    //   312: astore_0
    //   313: aload_0
    //   314: invokevirtual 62	org/json/JSONException:printStackTrace	()V
    //   317: goto -57 -> 260
    //   320: astore_1
    //   321: aload_1
    //   322: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   325: goto -137 -> 188
    //   328: astore_0
    //   329: aload_0
    //   330: invokevirtual 283	java/util/regex/PatternSyntaxException:printStackTrace	()V
    //   333: goto -73 -> 260
    //   336: astore_1
    //   337: aload_1
    //   338: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   341: goto -138 -> 203
    //   344: astore_1
    //   345: aload_1
    //   346: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   349: goto -132 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	paramContext	Context
    //   0	352	1	paramString1	String
    //   0	352	2	paramString2	String
    //   0	352	3	paramString3	String
    //   0	352	4	paramString4	String
    //   0	352	5	paramString5	String
    //   7	254	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   162	176	304	java/lang/Exception
    //   9	162	312	org/json/JSONException
    //   162	176	312	org/json/JSONException
    //   176	188	312	org/json/JSONException
    //   188	203	312	org/json/JSONException
    //   203	217	312	org/json/JSONException
    //   217	260	312	org/json/JSONException
    //   305	309	312	org/json/JSONException
    //   321	325	312	org/json/JSONException
    //   337	341	312	org/json/JSONException
    //   345	349	312	org/json/JSONException
    //   176	188	320	java/lang/Exception
    //   9	162	328	java/util/regex/PatternSyntaxException
    //   162	176	328	java/util/regex/PatternSyntaxException
    //   176	188	328	java/util/regex/PatternSyntaxException
    //   188	203	328	java/util/regex/PatternSyntaxException
    //   203	217	328	java/util/regex/PatternSyntaxException
    //   217	260	328	java/util/regex/PatternSyntaxException
    //   305	309	328	java/util/regex/PatternSyntaxException
    //   321	325	328	java/util/regex/PatternSyntaxException
    //   337	341	328	java/util/regex/PatternSyntaxException
    //   345	349	328	java/util/regex/PatternSyntaxException
    //   188	203	336	java/lang/Exception
    //   203	217	344	java/lang/Exception
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return String.format("\"first_pay_flag\":\"%s\",%s,\"pay_type\":\"%s\",\"pay_mode\":\"%s\"", new Object[] { paramString1, paramString2, paramString3, paramString4 });
  }
  
  public static String c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString3 != null) && (paramString3.length() > 0)) {
      return String.format("\"pay_type\":\"%s\",\"pay_mode\":\"%s\",%s,%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    }
    return String.format("\"pay_type\":\"%s\",\"pay_mode\":\"%s\",%s", new Object[] { paramString1, paramString2, paramString4 });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */