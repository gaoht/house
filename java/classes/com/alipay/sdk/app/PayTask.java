package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.c.c;
import com.alipay.sdk.j.e;
import com.alipay.sdk.j.h;
import com.alipay.sdk.j.k;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class PayTask
{
  static final Object a = e.class;
  private Activity b;
  private com.alipay.sdk.k.a c;
  private String d = "wappaygw.alipay.com/service/rest.htm";
  private String e = "mclient.alipay.com/service/rest.htm";
  private String f = "mclient.alipay.com/home/exterfaceAssign.htm";
  private Map<String, a> g = new HashMap();
  
  public PayTask(Activity paramActivity)
  {
    this.b = paramActivity;
    com.alipay.sdk.h.b localb = com.alipay.sdk.h.b.a();
    Activity localActivity = this.b;
    c.a();
    localb.a(localActivity);
    com.alipay.sdk.app.a.a.a(paramActivity);
    this.c = new com.alipay.sdk.k.a(paramActivity, "去支付宝付款");
  }
  
  private String a(com.alipay.sdk.g.b arg1)
  {
    ??? = ???.b;
    Object localObject1 = new Intent(this.b, H5PayActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("url", ???[0]);
    if (???.length == 2) {
      localBundle.putString("cookie", ???[1]);
    }
    ((Intent)localObject1).putExtras(localBundle);
    this.b.startActivity((Intent)localObject1);
    synchronized (a)
    {
      try
      {
        a.wait();
        localObject1 = i.a;
        ??? = (com.alipay.sdk.g.b)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          ??? = i.a();
        }
        return (String)???;
      }
      catch (InterruptedException localInterruptedException)
      {
        String str = i.a();
        return str;
      }
    }
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: invokespecial 135	com/alipay/sdk/app/PayTask:a	()V
    //   6: new 137	com/alipay/sdk/f/a/d
    //   9: dup
    //   10: invokespecial 138	com/alipay/sdk/f/a/d:<init>	()V
    //   13: aload_0
    //   14: getfield 49	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   17: invokevirtual 142	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   20: aload_1
    //   21: invokevirtual 145	com/alipay/sdk/f/a/d:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/alipay/sdk/f/b;
    //   24: invokevirtual 150	com/alipay/sdk/f/b:a	()Lorg/json/JSONObject;
    //   27: ldc -104
    //   29: invokevirtual 158	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   32: ldc -96
    //   34: invokevirtual 158	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   37: invokestatic 163	com/alipay/sdk/g/b:a	(Lorg/json/JSONObject;)Ljava/util/List;
    //   40: astore_1
    //   41: iconst_0
    //   42: istore_2
    //   43: iload_2
    //   44: aload_1
    //   45: invokeinterface 169 1 0
    //   50: if_icmpge +260 -> 310
    //   53: aload_1
    //   54: iload_2
    //   55: invokeinterface 173 2 0
    //   60: checkcast 79	com/alipay/sdk/g/b
    //   63: getfield 176	com/alipay/sdk/g/b:a	Lcom/alipay/sdk/g/a;
    //   66: getstatic 180	com/alipay/sdk/g/a:c	Lcom/alipay/sdk/g/a;
    //   69: if_acmpne +313 -> 382
    //   72: aload_1
    //   73: iload_2
    //   74: invokeinterface 173 2 0
    //   79: checkcast 79	com/alipay/sdk/g/b
    //   82: getfield 82	com/alipay/sdk/g/b:b	[Ljava/lang/String;
    //   85: astore 4
    //   87: aload 4
    //   89: arraylength
    //   90: iconst_3
    //   91: if_icmpne +291 -> 382
    //   94: ldc -74
    //   96: aload 4
    //   98: iconst_0
    //   99: aaload
    //   100: invokestatic 186	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   103: ifeq +279 -> 382
    //   106: invokestatic 54	com/alipay/sdk/h/b:a	()Lcom/alipay/sdk/h/b;
    //   109: getfield 189	com/alipay/sdk/h/b:a	Landroid/content/Context;
    //   112: astore 5
    //   114: invokestatic 194	com/alipay/sdk/i/b:a	()Lcom/alipay/sdk/i/b;
    //   117: astore 6
    //   119: aload 4
    //   121: iconst_1
    //   122: aaload
    //   123: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: ifne +256 -> 382
    //   129: aload 4
    //   131: iconst_2
    //   132: aaload
    //   133: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   136: ifeq +6 -> 142
    //   139: goto +243 -> 382
    //   142: aload 6
    //   144: aload 4
    //   146: iconst_1
    //   147: aaload
    //   148: putfield 195	com/alipay/sdk/i/b:a	Ljava/lang/String;
    //   151: aload 6
    //   153: aload 4
    //   155: iconst_2
    //   156: aaload
    //   157: putfield 197	com/alipay/sdk/i/b:b	Ljava/lang/String;
    //   160: new 199	com/alipay/sdk/i/a
    //   163: dup
    //   164: aload 5
    //   166: invokespecial 201	com/alipay/sdk/i/a:<init>	(Landroid/content/Context;)V
    //   169: astore 4
    //   171: aload 4
    //   173: aload 5
    //   175: invokestatic 206	com/alipay/sdk/j/b:a	(Landroid/content/Context;)Lcom/alipay/sdk/j/b;
    //   178: invokevirtual 207	com/alipay/sdk/j/b:a	()Ljava/lang/String;
    //   181: aload 5
    //   183: invokestatic 206	com/alipay/sdk/j/b:a	(Landroid/content/Context;)Lcom/alipay/sdk/j/b;
    //   186: invokevirtual 209	com/alipay/sdk/j/b:b	()Ljava/lang/String;
    //   189: aload 6
    //   191: getfield 195	com/alipay/sdk/i/b:a	Ljava/lang/String;
    //   194: aload 6
    //   196: getfield 197	com/alipay/sdk/i/b:b	Ljava/lang/String;
    //   199: invokevirtual 212	com/alipay/sdk/i/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload 4
    //   204: invokevirtual 215	com/alipay/sdk/i/a:close	()V
    //   207: goto +175 -> 382
    //   210: astore 4
    //   212: getstatic 220	com/alipay/sdk/app/j:d	Lcom/alipay/sdk/app/j;
    //   215: getfield 224	com/alipay/sdk/app/j:h	I
    //   218: invokestatic 227	com/alipay/sdk/app/j:a	(I)Lcom/alipay/sdk/app/j;
    //   221: astore_1
    //   222: ldc -27
    //   224: aload 4
    //   226: invokestatic 232	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   229: aload_0
    //   230: invokespecial 234	com/alipay/sdk/app/PayTask:b	()V
    //   233: aload_1
    //   234: astore 4
    //   236: aload_1
    //   237: ifnonnull +14 -> 251
    //   240: getstatic 236	com/alipay/sdk/app/j:b	Lcom/alipay/sdk/app/j;
    //   243: getfield 224	com/alipay/sdk/app/j:h	I
    //   246: invokestatic 227	com/alipay/sdk/app/j:a	(I)Lcom/alipay/sdk/app/j;
    //   249: astore 4
    //   251: aload 4
    //   253: getfield 224	com/alipay/sdk/app/j:h	I
    //   256: aload 4
    //   258: getfield 239	com/alipay/sdk/app/j:i	Ljava/lang/String;
    //   261: ldc -15
    //   263: invokestatic 244	com/alipay/sdk/app/i:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   266: areturn
    //   267: astore 5
    //   269: aload 4
    //   271: invokevirtual 215	com/alipay/sdk/i/a:close	()V
    //   274: goto +108 -> 382
    //   277: astore_1
    //   278: ldc -10
    //   280: ldc -8
    //   282: aload_1
    //   283: invokestatic 251	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   286: aload_0
    //   287: invokespecial 234	com/alipay/sdk/app/PayTask:b	()V
    //   290: aconst_null
    //   291: astore_1
    //   292: goto -59 -> 233
    //   295: astore_1
    //   296: aload 4
    //   298: invokevirtual 215	com/alipay/sdk/i/a:close	()V
    //   301: aload_1
    //   302: athrow
    //   303: astore_1
    //   304: aload_0
    //   305: invokespecial 234	com/alipay/sdk/app/PayTask:b	()V
    //   308: aload_1
    //   309: athrow
    //   310: aload_0
    //   311: invokespecial 234	com/alipay/sdk/app/PayTask:b	()V
    //   314: iload_3
    //   315: istore_2
    //   316: iload_2
    //   317: aload_1
    //   318: invokeinterface 169 1 0
    //   323: if_icmpge +50 -> 373
    //   326: aload_1
    //   327: iload_2
    //   328: invokeinterface 173 2 0
    //   333: checkcast 79	com/alipay/sdk/g/b
    //   336: getfield 176	com/alipay/sdk/g/b:a	Lcom/alipay/sdk/g/a;
    //   339: getstatic 253	com/alipay/sdk/g/a:b	Lcom/alipay/sdk/g/a;
    //   342: if_acmpne +24 -> 366
    //   345: aload_0
    //   346: aload_1
    //   347: iload_2
    //   348: invokeinterface 173 2 0
    //   353: checkcast 79	com/alipay/sdk/g/b
    //   356: invokespecial 255	com/alipay/sdk/app/PayTask:a	(Lcom/alipay/sdk/g/b;)Ljava/lang/String;
    //   359: astore_1
    //   360: aload_0
    //   361: invokespecial 234	com/alipay/sdk/app/PayTask:b	()V
    //   364: aload_1
    //   365: areturn
    //   366: iload_2
    //   367: iconst_1
    //   368: iadd
    //   369: istore_2
    //   370: goto -54 -> 316
    //   373: aload_0
    //   374: invokespecial 234	com/alipay/sdk/app/PayTask:b	()V
    //   377: aconst_null
    //   378: astore_1
    //   379: goto -146 -> 233
    //   382: iload_2
    //   383: iconst_1
    //   384: iadd
    //   385: istore_2
    //   386: goto -343 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	PayTask
    //   0	389	1	paramString	String
    //   42	344	2	i	int
    //   1	314	3	j	int
    //   85	118	4	localObject1	Object
    //   210	15	4	localIOException	java.io.IOException
    //   234	63	4	localObject2	Object
    //   112	70	5	localContext	android.content.Context
    //   267	1	5	localException	Exception
    //   117	78	6	localb	com.alipay.sdk.i.b
    // Exception table:
    //   from	to	target	type
    //   6	41	210	java/io/IOException
    //   43	139	210	java/io/IOException
    //   142	171	210	java/io/IOException
    //   202	207	210	java/io/IOException
    //   269	274	210	java/io/IOException
    //   296	303	210	java/io/IOException
    //   310	314	210	java/io/IOException
    //   316	360	210	java/io/IOException
    //   171	202	267	java/lang/Exception
    //   6	41	277	java/lang/Throwable
    //   43	139	277	java/lang/Throwable
    //   142	171	277	java/lang/Throwable
    //   202	207	277	java/lang/Throwable
    //   269	274	277	java/lang/Throwable
    //   296	303	277	java/lang/Throwable
    //   310	314	277	java/lang/Throwable
    //   316	360	277	java/lang/Throwable
    //   171	202	295	finally
    //   6	41	303	finally
    //   43	139	303	finally
    //   142	171	303	finally
    //   202	207	303	finally
    //   212	229	303	finally
    //   269	274	303	finally
    //   278	286	303	finally
    //   296	303	303	finally
    //   310	314	303	finally
    //   316	360	303	finally
  }
  
  private void a()
  {
    if (this.c != null) {
      this.c.a();
    }
  }
  
  private static boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString, StringBuilder paramStringBuilder, Map<String, String> paramMap, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    String str;
    if (i < j)
    {
      str = paramVarArgs[i];
      if (TextUtils.isEmpty((CharSequence)paramMap.get(str))) {}
    }
    for (paramMap = (String)paramMap.get(str);; paramMap = "")
    {
      if (TextUtils.isEmpty(paramMap))
      {
        if (!paramBoolean2) {
          break label110;
        }
        return false;
        i += 1;
        break;
      }
      if (paramBoolean1) {
        paramStringBuilder.append("&").append(paramString).append("=\"").append(paramMap).append("\"");
      }
      for (;;)
      {
        label110:
        return true;
        paramStringBuilder.append(paramString).append("=\"").append(paramMap).append("\"");
      }
    }
  }
  
  private void b()
  {
    if (this.c != null)
    {
      this.c.b();
      this.c = null;
    }
  }
  
  public String fetchOrderInfoFromH5PayUrl(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        str = paramString.trim();
        if ((!str.startsWith("https://" + this.d)) && (!str.startsWith("http://" + this.d))) {
          continue;
        }
        localObject1 = str.replaceFirst("(http|https)://" + this.d + "\\?", "").trim();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        paramString = k.a("<request_token>", "</request_token>", (String)k.a((String)localObject1).get("req_data"));
        paramString = "_input_charset=\"utf-8\"&ordertoken=\"" + paramString + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new com.alipay.sdk.h.a(this.b).a("sc", "h5tonative") + "\"";
      }
      catch (Throwable paramString)
      {
        String str;
        Object localObject1;
        boolean bool;
        Map localMap;
        StringBuilder localStringBuilder;
        paramString = "";
        continue;
        if ((!str.contains("mclient.alipay.com/cashier/mobilepay.htm")) && ((!a.isSandBox()) || (!str.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm")))) {
          continue;
        }
        paramString = new com.alipay.sdk.h.a(this.b).a("sc", "h5tonative");
        Object localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("url", str);
        ((JSONObject)localObject2).put("bizcontext", paramString);
        paramString = String.format("new_external_info==%s", new Object[] { ((JSONObject)localObject2).toString() });
        continue;
      }
      finally {}
      return paramString;
      if ((str.startsWith("https://" + this.e)) || (str.startsWith("http://" + this.e)))
      {
        localObject1 = str.replaceFirst("(http|https)://" + this.e + "\\?", "").trim();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramString = k.a("<request_token>", "</request_token>", (String)k.a((String)localObject1).get("req_data"));
          paramString = "_input_charset=\"utf-8\"&ordertoken=\"" + paramString + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new com.alipay.sdk.h.a(this.b).a("sc", "h5tonative") + "\"";
          continue;
        }
      }
      if (((str.startsWith("https://" + this.f)) || (str.startsWith("http://" + this.f))) && (str.contains("alipay.wap.create.direct.pay.by.user")))
      {
        bool = TextUtils.isEmpty(str.replaceFirst("(http|https)://" + this.f + "\\?", "").trim());
        if (!bool) {
          try
          {
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("url", paramString);
            ((JSONObject)localObject1).put("bizcontext", new com.alipay.sdk.h.a(this.b).a("sc", "h5tonative"));
            localObject1 = "new_external_info==" + ((JSONObject)localObject1).toString();
            paramString = (String)localObject1;
          }
          catch (Throwable localThrowable) {}
        }
      }
    }
    if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com\\/w\\/trade_pay\\.do.?|mali\\.alipay\\.com\\/w\\/trade_pay\\.do.?|mclient\\.alipay\\.com\\/w\\/trade_pay\\.do.?)").matcher(paramString).find())
    {
      paramString = k.a("?", "", paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        localMap = k.a(paramString);
        localStringBuilder = new StringBuilder();
        if (a(false, true, "trade_no", localStringBuilder, localMap, new String[] { "trade_no", "alipay_trade_no" }))
        {
          a(true, false, "pay_phase_id", localStringBuilder, localMap, new String[] { "payPhaseId", "pay_phase_id", "out_relation_id" });
          localStringBuilder.append("&biz_sub_type=\"TRADE\"");
          localStringBuilder.append("&biz_type=\"trade\"");
          localObject2 = (String)localMap.get("app_name");
          if ((TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localMap.get("cid")))) {
            paramString = "ali1688";
          }
        }
      }
    }
    for (;;)
    {
      localStringBuilder.append("&app_name=\"" + paramString + "\"");
      if (!a(true, true, "extern_token", localStringBuilder, localMap, new String[] { "extern_token", "cid", "sid", "s_id" }))
      {
        paramString = "";
        break;
        paramString = (String)localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        if (!TextUtils.isEmpty((CharSequence)localMap.get("sid"))) {
          break label1119;
        }
        paramString = (String)localObject2;
        if (TextUtils.isEmpty((CharSequence)localMap.get("s_id"))) {
          continue;
        }
        break label1119;
      }
      a(true, false, "appenv", localStringBuilder, localMap, new String[] { "appenv" });
      localStringBuilder.append("&pay_channel_id=\"alipay_sdk\"");
      localObject2 = new a((byte)0);
      ((a)localObject2).a = ((String)localMap.get("return_url"));
      ((a)localObject2).b = ((String)localMap.get("pay_order_id"));
      paramString = localStringBuilder.toString() + "&bizcontext=\"" + new com.alipay.sdk.h.a(this.b).a("sc", "h5tonative") + "\"";
      this.g.put(paramString, localObject2);
      break;
      label1119:
      paramString = "tb";
    }
  }
  
  public String fetchTradeToken()
  {
    try
    {
      String str = h.b(this.b.getApplicationContext(), "pref_trade_token", "");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getVersion()
  {
    return "15.3.9";
  }
  
  /* Error */
  public com.alipay.sdk.j.a h5Pay(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: new 451	com/alipay/sdk/j/a
    //   7: dup
    //   8: invokespecial 452	com/alipay/sdk/j/a:<init>	()V
    //   11: astore 7
    //   13: aload_1
    //   14: invokevirtual 286	java/lang/String:trim	()Ljava/lang/String;
    //   17: pop
    //   18: aload_0
    //   19: aload_1
    //   20: iload_2
    //   21: invokevirtual 456	com/alipay/sdk/app/PayTask:pay	(Ljava/lang/String;Z)Ljava/lang/String;
    //   24: ldc_w 458
    //   27: invokevirtual 462	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   30: astore 6
    //   32: new 44	java/util/HashMap
    //   35: dup
    //   36: invokespecial 45	java/util/HashMap:<init>	()V
    //   39: astore 8
    //   41: aload 6
    //   43: arraylength
    //   44: istore 4
    //   46: iload_3
    //   47: iload 4
    //   49: if_icmpge +95 -> 144
    //   52: aload 6
    //   54: iload_3
    //   55: aaload
    //   56: astore 9
    //   58: aload 9
    //   60: iconst_0
    //   61: aload 9
    //   63: ldc_w 464
    //   66: invokevirtual 468	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   69: invokevirtual 472	java/lang/String:substring	(II)Ljava/lang/String;
    //   72: astore 10
    //   74: new 271	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 371	java/lang/StringBuilder:<init>	()V
    //   81: aload 10
    //   83: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc_w 464
    //   89: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore 11
    //   97: aload 9
    //   99: aload 11
    //   101: invokevirtual 468	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   104: istore 5
    //   106: aload 8
    //   108: aload 10
    //   110: aload 9
    //   112: aload 11
    //   114: invokevirtual 475	java/lang/String:length	()I
    //   117: iload 5
    //   119: iadd
    //   120: aload 9
    //   122: ldc_w 477
    //   125: invokevirtual 480	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   128: invokevirtual 472	java/lang/String:substring	(II)Ljava/lang/String;
    //   131: invokeinterface 419 3 0
    //   136: pop
    //   137: iload_3
    //   138: iconst_1
    //   139: iadd
    //   140: istore_3
    //   141: goto -95 -> 46
    //   144: aload 8
    //   146: ldc_w 482
    //   149: invokeinterface 486 2 0
    //   154: ifeq +21 -> 175
    //   157: aload 7
    //   159: aload 8
    //   161: ldc_w 482
    //   164: invokeinterface 263 2 0
    //   169: checkcast 267	java/lang/String
    //   172: invokevirtual 489	com/alipay/sdk/j/a:setResultCode	(Ljava/lang/String;)V
    //   175: aload 8
    //   177: ldc_w 491
    //   180: invokeinterface 486 2 0
    //   185: ifeq +26 -> 211
    //   188: aload 7
    //   190: aload 8
    //   192: ldc_w 491
    //   195: invokeinterface 263 2 0
    //   200: checkcast 267	java/lang/String
    //   203: invokevirtual 494	com/alipay/sdk/j/a:setReturnUrl	(Ljava/lang/String;)V
    //   206: aload_0
    //   207: monitorexit
    //   208: aload 7
    //   210: areturn
    //   211: aload 8
    //   213: ldc_w 496
    //   216: invokeinterface 486 2 0
    //   221: istore_2
    //   222: iload_2
    //   223: ifeq -17 -> 206
    //   226: aload 8
    //   228: ldc_w 496
    //   231: invokeinterface 263 2 0
    //   236: checkcast 267	java/lang/String
    //   239: astore 8
    //   241: aload 8
    //   243: invokevirtual 475	java/lang/String:length	()I
    //   246: bipush 15
    //   248: if_icmple +274 -> 522
    //   251: aload_0
    //   252: getfield 47	com/alipay/sdk/app/PayTask:g	Ljava/util/Map;
    //   255: aload_1
    //   256: invokeinterface 263 2 0
    //   261: checkcast 6	com/alipay/sdk/app/PayTask$a
    //   264: astore 6
    //   266: aload 6
    //   268: ifnull +63 -> 331
    //   271: aload 6
    //   273: getfield 414	com/alipay/sdk/app/PayTask$a:b	Ljava/lang/String;
    //   276: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   279: ifeq +27 -> 306
    //   282: aload 7
    //   284: aload 6
    //   286: getfield 411	com/alipay/sdk/app/PayTask$a:a	Ljava/lang/String;
    //   289: invokevirtual 494	com/alipay/sdk/j/a:setReturnUrl	(Ljava/lang/String;)V
    //   292: aload_0
    //   293: getfield 47	com/alipay/sdk/app/PayTask:g	Ljava/util/Map;
    //   296: aload_1
    //   297: invokeinterface 499 2 0
    //   302: pop
    //   303: goto -97 -> 206
    //   306: aload 7
    //   308: invokestatic 504	com/alipay/sdk/c/a:b	()Lcom/alipay/sdk/c/a;
    //   311: getfield 505	com/alipay/sdk/c/a:b	Ljava/lang/String;
    //   314: ldc_w 507
    //   317: aload 6
    //   319: getfield 414	com/alipay/sdk/app/PayTask$a:b	Ljava/lang/String;
    //   322: invokevirtual 511	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   325: invokevirtual 494	com/alipay/sdk/j/a:setReturnUrl	(Ljava/lang/String;)V
    //   328: goto -36 -> 292
    //   331: ldc_w 513
    //   334: ldc_w 279
    //   337: aload 8
    //   339: invokestatic 322	com/alipay/sdk/j/k:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   342: astore 6
    //   344: aload 6
    //   346: astore_1
    //   347: aload 6
    //   349: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifeq +99 -> 451
    //   355: ldc_w 515
    //   358: ldc_w 279
    //   361: aload 8
    //   363: invokestatic 322	com/alipay/sdk/j/k:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   366: astore 6
    //   368: aload 6
    //   370: astore_1
    //   371: aload 6
    //   373: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   376: ifeq +75 -> 451
    //   379: ldc_w 517
    //   382: ldc_w 279
    //   385: aload 8
    //   387: invokestatic 322	com/alipay/sdk/j/k:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   390: astore 6
    //   392: aload 6
    //   394: astore_1
    //   395: aload 6
    //   397: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   400: ifeq +51 -> 451
    //   403: ldc_w 519
    //   406: ldc_w 269
    //   409: aload 8
    //   411: invokestatic 322	com/alipay/sdk/j/k:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   414: ldc_w 521
    //   417: invokestatic 526	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   420: astore 6
    //   422: aload 6
    //   424: astore_1
    //   425: aload 6
    //   427: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   430: ifeq +21 -> 451
    //   433: ldc_w 528
    //   436: ldc_w 269
    //   439: aload 8
    //   441: invokestatic 322	com/alipay/sdk/j/k:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   444: ldc_w 521
    //   447: invokestatic 526	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   450: astore_1
    //   451: aload_1
    //   452: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   455: ifeq +115 -> 570
    //   458: aload 8
    //   460: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   463: ifne +107 -> 570
    //   466: aload 8
    //   468: ldc_w 530
    //   471: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   474: ifeq +96 -> 570
    //   477: ldc_w 532
    //   480: ldc_w 279
    //   483: aload 8
    //   485: invokestatic 534	com/alipay/sdk/j/k:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   488: astore_1
    //   489: aload_1
    //   490: astore 6
    //   492: aload_1
    //   493: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifeq +11 -> 507
    //   499: invokestatic 504	com/alipay/sdk/c/a:b	()Lcom/alipay/sdk/c/a;
    //   502: getfield 505	com/alipay/sdk/c/a:b	Ljava/lang/String;
    //   505: astore 6
    //   507: aload 7
    //   509: aload 6
    //   511: invokevirtual 494	com/alipay/sdk/j/a:setReturnUrl	(Ljava/lang/String;)V
    //   514: goto -308 -> 206
    //   517: astore_1
    //   518: aload_0
    //   519: monitorexit
    //   520: aload_1
    //   521: athrow
    //   522: aload_0
    //   523: getfield 47	com/alipay/sdk/app/PayTask:g	Ljava/util/Map;
    //   526: aload_1
    //   527: invokeinterface 263 2 0
    //   532: checkcast 6	com/alipay/sdk/app/PayTask$a
    //   535: astore 6
    //   537: aload 6
    //   539: ifnull -333 -> 206
    //   542: aload 7
    //   544: aload 6
    //   546: getfield 411	com/alipay/sdk/app/PayTask$a:a	Ljava/lang/String;
    //   549: invokevirtual 494	com/alipay/sdk/j/a:setReturnUrl	(Ljava/lang/String;)V
    //   552: aload_0
    //   553: getfield 47	com/alipay/sdk/app/PayTask:g	Ljava/util/Map;
    //   556: aload_1
    //   557: invokeinterface 499 2 0
    //   562: pop
    //   563: goto -357 -> 206
    //   566: astore_1
    //   567: goto -361 -> 206
    //   570: goto -81 -> 489
    //   573: astore_1
    //   574: goto -368 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	577	0	this	PayTask
    //   0	577	1	paramString	String
    //   0	577	2	paramBoolean	boolean
    //   1	140	3	i	int
    //   44	6	4	j	int
    //   104	16	5	k	int
    //   30	515	6	localObject1	Object
    //   11	532	7	locala	com.alipay.sdk.j.a
    //   39	445	8	localObject2	Object
    //   56	65	9	localObject3	Object
    //   72	37	10	str1	String
    //   95	18	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	13	517	finally
    //   13	46	517	finally
    //   58	137	517	finally
    //   144	175	517	finally
    //   175	206	517	finally
    //   211	222	517	finally
    //   226	266	517	finally
    //   271	292	517	finally
    //   292	303	517	finally
    //   306	328	517	finally
    //   331	344	517	finally
    //   347	368	517	finally
    //   371	392	517	finally
    //   395	422	517	finally
    //   425	451	517	finally
    //   451	489	517	finally
    //   492	507	517	finally
    //   507	514	517	finally
    //   522	537	517	finally
    //   542	563	517	finally
    //   13	46	566	java/lang/Throwable
    //   58	137	566	java/lang/Throwable
    //   144	175	566	java/lang/Throwable
    //   175	206	566	java/lang/Throwable
    //   211	222	566	java/lang/Throwable
    //   226	266	573	java/lang/Throwable
    //   271	292	573	java/lang/Throwable
    //   292	303	573	java/lang/Throwable
    //   306	328	573	java/lang/Throwable
    //   331	344	573	java/lang/Throwable
    //   347	368	573	java/lang/Throwable
    //   371	392	573	java/lang/Throwable
    //   395	422	573	java/lang/Throwable
    //   425	451	573	java/lang/Throwable
    //   451	489	573	java/lang/Throwable
    //   492	507	573	java/lang/Throwable
    //   507	514	573	java/lang/Throwable
    //   522	537	573	java/lang/Throwable
    //   542	563	573	java/lang/Throwable
  }
  
  /* Error */
  public String pay(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: monitorenter
    //   8: iload_2
    //   9: ifeq +7 -> 16
    //   12: aload_0
    //   13: invokespecial 135	com/alipay/sdk/app/PayTask:a	()V
    //   16: aload_1
    //   17: ldc_w 536
    //   20: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +7 -> 30
    //   26: iconst_1
    //   27: putstatic 541	com/alipay/sdk/b/a:c	Z
    //   30: aload_1
    //   31: astore 5
    //   33: getstatic 541	com/alipay/sdk/b/a:c	Z
    //   36: ifeq +29 -> 65
    //   39: aload_1
    //   40: ldc_w 543
    //   43: invokevirtual 298	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   46: ifeq +184 -> 230
    //   49: aload_1
    //   50: aload_1
    //   51: ldc_w 543
    //   54: invokevirtual 468	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   57: bipush 53
    //   59: iadd
    //   60: invokevirtual 546	java/lang/String:substring	(I)Ljava/lang/String;
    //   63: astore 5
    //   65: new 328	com/alipay/sdk/h/a
    //   68: dup
    //   69: aload_0
    //   70: getfield 49	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   73: invokespecial 329	com/alipay/sdk/h/a:<init>	(Landroid/content/Context;)V
    //   76: aload 5
    //   78: invokevirtual 548	com/alipay/sdk/h/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_1
    //   82: aload_1
    //   83: ldc_w 550
    //   86: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: ifne +173 -> 262
    //   92: aload_0
    //   93: getfield 49	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   96: invokestatic 553	com/alipay/sdk/j/k:c	(Landroid/content/Context;)Z
    //   99: ifeq +163 -> 262
    //   102: new 23	com/alipay/sdk/j/e
    //   105: dup
    //   106: aload_0
    //   107: getfield 49	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   110: new 555	com/alipay/sdk/app/h
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 557	com/alipay/sdk/app/h:<init>	(Lcom/alipay/sdk/app/PayTask;)V
    //   118: invokespecial 560	com/alipay/sdk/j/e:<init>	(Landroid/app/Activity;Lcom/alipay/sdk/j/e$a;)V
    //   121: astore 9
    //   123: aload 9
    //   125: aload_1
    //   126: invokevirtual 561	com/alipay/sdk/j/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore 8
    //   131: aload 9
    //   133: aconst_null
    //   134: putfield 563	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   137: aload 8
    //   139: ldc_w 565
    //   142: invokestatic 186	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   145: ifne +117 -> 262
    //   148: aload 8
    //   150: astore_1
    //   151: aload 8
    //   153: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifeq +7 -> 163
    //   159: invokestatic 126	com/alipay/sdk/app/i:a	()Ljava/lang/String;
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 49	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   167: invokevirtual 142	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   170: astore 8
    //   172: aload_1
    //   173: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifeq +95 -> 271
    //   179: aload 7
    //   181: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   184: ifne +13 -> 197
    //   187: aload 8
    //   189: ldc_w 439
    //   192: aload 7
    //   194: invokestatic 568	com/alipay/sdk/j/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   197: invokestatic 504	com/alipay/sdk/c/a:b	()Lcom/alipay/sdk/c/a;
    //   200: aload_0
    //   201: getfield 49	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   204: invokevirtual 142	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   207: invokevirtual 569	com/alipay/sdk/c/a:a	(Landroid/content/Context;)V
    //   210: aload_0
    //   211: invokespecial 234	com/alipay/sdk/app/PayTask:b	()V
    //   214: aload_0
    //   215: getfield 49	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   218: invokevirtual 142	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   221: aload 5
    //   223: invokestatic 572	com/alipay/sdk/app/a/a:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   226: aload_0
    //   227: monitorexit
    //   228: aload_1
    //   229: areturn
    //   230: aload_1
    //   231: astore 5
    //   233: aload_1
    //   234: ldc_w 574
    //   237: invokevirtual 298	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   240: ifeq -175 -> 65
    //   243: aload_1
    //   244: aload_1
    //   245: ldc_w 574
    //   248: invokevirtual 468	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   251: bipush 52
    //   253: iadd
    //   254: invokevirtual 546	java/lang/String:substring	(I)Ljava/lang/String;
    //   257: astore 5
    //   259: goto -194 -> 65
    //   262: aload_0
    //   263: aload_1
    //   264: invokespecial 575	com/alipay/sdk/app/PayTask:a	(Ljava/lang/String;)Ljava/lang/String;
    //   267: astore_1
    //   268: goto -105 -> 163
    //   271: aload_1
    //   272: ldc_w 458
    //   275: invokevirtual 462	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   278: astore 9
    //   280: iconst_0
    //   281: istore_3
    //   282: aload 6
    //   284: astore 7
    //   286: iload_3
    //   287: aload 9
    //   289: arraylength
    //   290: if_icmpge -111 -> 179
    //   293: aload 6
    //   295: astore 7
    //   297: aload 9
    //   299: iload_3
    //   300: aaload
    //   301: ldc_w 577
    //   304: invokevirtual 298	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   307: ifeq +241 -> 548
    //   310: aload 6
    //   312: astore 7
    //   314: aload 9
    //   316: iload_3
    //   317: aaload
    //   318: ldc_w 477
    //   321: invokevirtual 580	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   324: ifeq +224 -> 548
    //   327: aload 9
    //   329: iload_3
    //   330: aaload
    //   331: bipush 8
    //   333: aload 9
    //   335: iload_3
    //   336: aaload
    //   337: invokevirtual 475	java/lang/String:length	()I
    //   340: iconst_1
    //   341: isub
    //   342: invokevirtual 472	java/lang/String:substring	(II)Ljava/lang/String;
    //   345: ldc_w 269
    //   348: invokevirtual 462	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   351: astore 10
    //   353: iconst_0
    //   354: istore 4
    //   356: aload 6
    //   358: astore 7
    //   360: iload 4
    //   362: aload 10
    //   364: arraylength
    //   365: if_icmpge +183 -> 548
    //   368: aload 10
    //   370: iload 4
    //   372: aaload
    //   373: ldc_w 582
    //   376: invokevirtual 298	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   379: ifeq +42 -> 421
    //   382: aload 10
    //   384: iload 4
    //   386: aaload
    //   387: ldc_w 279
    //   390: invokevirtual 580	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   393: ifeq +28 -> 421
    //   396: aload 10
    //   398: iload 4
    //   400: aaload
    //   401: bipush 13
    //   403: aload 10
    //   405: iload 4
    //   407: aaload
    //   408: invokevirtual 475	java/lang/String:length	()I
    //   411: iconst_1
    //   412: isub
    //   413: invokevirtual 472	java/lang/String:substring	(II)Ljava/lang/String;
    //   416: astore 7
    //   418: goto +130 -> 548
    //   421: aload 10
    //   423: iload 4
    //   425: aaload
    //   426: ldc_w 584
    //   429: invokevirtual 298	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   432: ifeq +18 -> 450
    //   435: aload 10
    //   437: iload 4
    //   439: aaload
    //   440: bipush 12
    //   442: invokevirtual 546	java/lang/String:substring	(I)Ljava/lang/String;
    //   445: astore 7
    //   447: goto +101 -> 548
    //   450: iload 4
    //   452: iconst_1
    //   453: iadd
    //   454: istore 4
    //   456: goto -100 -> 356
    //   459: astore 6
    //   461: ldc -10
    //   463: ldc_w 586
    //   466: aload 6
    //   468: invokestatic 251	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   471: goto -274 -> 197
    //   474: astore_1
    //   475: invokestatic 126	com/alipay/sdk/app/i:a	()Ljava/lang/String;
    //   478: astore_1
    //   479: invokestatic 504	com/alipay/sdk/c/a:b	()Lcom/alipay/sdk/c/a;
    //   482: aload_0
    //   483: getfield 49	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   486: invokevirtual 142	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   489: invokevirtual 569	com/alipay/sdk/c/a:a	(Landroid/content/Context;)V
    //   492: aload_0
    //   493: invokespecial 234	com/alipay/sdk/app/PayTask:b	()V
    //   496: aload_0
    //   497: getfield 49	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   500: invokevirtual 142	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   503: aload 5
    //   505: invokestatic 572	com/alipay/sdk/app/a/a:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   508: goto -282 -> 226
    //   511: astore_1
    //   512: aload_0
    //   513: monitorexit
    //   514: aload_1
    //   515: athrow
    //   516: astore_1
    //   517: invokestatic 504	com/alipay/sdk/c/a:b	()Lcom/alipay/sdk/c/a;
    //   520: aload_0
    //   521: getfield 49	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   524: invokevirtual 142	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   527: invokevirtual 569	com/alipay/sdk/c/a:a	(Landroid/content/Context;)V
    //   530: aload_0
    //   531: invokespecial 234	com/alipay/sdk/app/PayTask:b	()V
    //   534: aload_0
    //   535: getfield 49	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   538: invokevirtual 142	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   541: aload 5
    //   543: invokestatic 572	com/alipay/sdk/app/a/a:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   546: aload_1
    //   547: athrow
    //   548: iload_3
    //   549: iconst_1
    //   550: iadd
    //   551: istore_3
    //   552: aload 7
    //   554: astore 6
    //   556: goto -274 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	559	0	this	PayTask
    //   0	559	1	paramString	String
    //   0	559	2	paramBoolean	boolean
    //   281	271	3	i	int
    //   354	101	4	j	int
    //   31	511	5	str	String
    //   1	356	6	localObject1	Object
    //   459	8	6	localThrowable	Throwable
    //   554	1	6	localObject2	Object
    //   4	549	7	localObject3	Object
    //   129	59	8	localObject4	Object
    //   121	213	9	localObject5	Object
    //   351	85	10	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   172	179	459	java/lang/Throwable
    //   179	197	459	java/lang/Throwable
    //   271	280	459	java/lang/Throwable
    //   286	293	459	java/lang/Throwable
    //   297	310	459	java/lang/Throwable
    //   314	353	459	java/lang/Throwable
    //   360	418	459	java/lang/Throwable
    //   421	447	459	java/lang/Throwable
    //   65	148	474	java/lang/Throwable
    //   151	163	474	java/lang/Throwable
    //   163	172	474	java/lang/Throwable
    //   262	268	474	java/lang/Throwable
    //   461	471	474	java/lang/Throwable
    //   12	16	511	finally
    //   16	30	511	finally
    //   33	65	511	finally
    //   197	226	511	finally
    //   233	259	511	finally
    //   479	508	511	finally
    //   517	548	511	finally
    //   65	148	516	finally
    //   151	163	516	finally
    //   163	172	516	finally
    //   172	179	516	finally
    //   179	197	516	finally
    //   262	268	516	finally
    //   271	280	516	finally
    //   286	293	516	finally
    //   297	310	516	finally
    //   314	353	516	finally
    //   360	418	516	finally
    //   421	447	516	finally
    //   461	471	516	finally
    //   475	479	516	finally
  }
  
  public Map<String, String> payV2(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = com.alipay.sdk.j.i.a(pay(paramString, paramBoolean));
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private final class a
  {
    String a = "";
    String b = "";
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/app/PayTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */