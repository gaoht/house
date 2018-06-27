package com.mato.sdk.e.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.mato.sdk.e.b.a.e;
import com.mato.sdk.e.b.b.a;
import com.mato.sdk.e.b.b.c;
import com.mato.sdk.g.i;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class m
{
  private static final String a = com.mato.sdk.b.g.b("");
  private final f b;
  private final Context c;
  private String d;
  
  public m(Context paramContext, f paramf)
  {
    this.c = paramContext;
    this.b = paramf;
    this.d = "";
  }
  
  private String a(int paramInt)
  {
    this.d = this.d.replace("${load_percent}", String.valueOf(paramInt));
    return this.d;
  }
  
  /* Error */
  private static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: invokevirtual 54	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   9: aload_1
    //   10: invokevirtual 60	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_0
    //   14: aload_0
    //   15: astore_3
    //   16: aload_0
    //   17: astore 4
    //   19: new 62	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   26: astore_1
    //   27: aload_0
    //   28: astore_3
    //   29: aload_0
    //   30: astore 4
    //   32: sipush 1024
    //   35: newarray <illegal type>
    //   37: astore 5
    //   39: aload_0
    //   40: astore_3
    //   41: aload_0
    //   42: astore 4
    //   44: aload_0
    //   45: aload 5
    //   47: invokevirtual 69	java/io/InputStream:read	([B)I
    //   50: istore_2
    //   51: iload_2
    //   52: iconst_m1
    //   53: if_icmpeq +43 -> 96
    //   56: aload_0
    //   57: astore_3
    //   58: aload_0
    //   59: astore 4
    //   61: aload_1
    //   62: new 38	java/lang/String
    //   65: dup
    //   66: aload 5
    //   68: iconst_0
    //   69: iload_2
    //   70: ldc 71
    //   72: invokespecial 74	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   75: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: goto -40 -> 39
    //   82: astore_0
    //   83: aload_3
    //   84: ifnull +7 -> 91
    //   87: aload_3
    //   88: invokevirtual 81	java/io/InputStream:close	()V
    //   91: ldc 15
    //   93: astore_3
    //   94: aload_3
    //   95: areturn
    //   96: aload_0
    //   97: astore_3
    //   98: aload_0
    //   99: astore 4
    //   101: aload_1
    //   102: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore_1
    //   106: aload_1
    //   107: astore_3
    //   108: aload_0
    //   109: ifnull -15 -> 94
    //   112: aload_0
    //   113: invokevirtual 81	java/io/InputStream:close	()V
    //   116: aload_1
    //   117: areturn
    //   118: astore_0
    //   119: aload_1
    //   120: areturn
    //   121: astore_0
    //   122: aload 4
    //   124: ifnull +8 -> 132
    //   127: aload 4
    //   129: invokevirtual 81	java/io/InputStream:close	()V
    //   132: aload_0
    //   133: athrow
    //   134: astore_0
    //   135: goto -44 -> 91
    //   138: astore_1
    //   139: goto -7 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramContext	Context
    //   0	142	1	paramString	String
    //   50	20	2	i	int
    //   4	104	3	localObject	Object
    //   1	127	4	localContext	Context
    //   37	30	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   5	14	82	java/io/IOException
    //   19	27	82	java/io/IOException
    //   32	39	82	java/io/IOException
    //   44	51	82	java/io/IOException
    //   61	79	82	java/io/IOException
    //   101	106	82	java/io/IOException
    //   112	116	118	java/io/IOException
    //   5	14	121	finally
    //   19	27	121	finally
    //   32	39	121	finally
    //   44	51	121	finally
    //   61	79	121	finally
    //   101	106	121	finally
    //   87	91	134	java/io/IOException
    //   127	132	138	java/io/IOException
  }
  
  private static String a(com.mato.sdk.e.b.a.b paramb)
  {
    String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(paramb.b));
    if (com.mato.sdk.e.b.c.b.a(paramb.e)) {}
    for (String str1 = "normal";; str1 = "abnormal") {
      return String.format(Locale.US, "<tr class=\"%s\"><td>%s</td><td>%s</td><td>%d</td><td>%dms</td><td>%dms</td></tr>", new Object[] { str1, paramb.a, str2, Integer.valueOf(paramb.e), Integer.valueOf(paramb.g), Integer.valueOf(paramb.h) });
    }
  }
  
  private static String a(c paramc, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      if (paramc.b != 0) {
        str = "tb_item_bg_color_abnormal";
      }
    }
    for (;;)
    {
      return String.format(Locale.US, "<tr class=\"%s\"><td>%s</td>" + "<td>%d%s</td><td>%dms</td>" + "<td>%dms</td><td>%dms</td>" + "</tr>", new Object[] { str, paramc.a, Integer.valueOf(paramc.b), "%", Integer.valueOf(paramc.e), Integer.valueOf(paramc.c), Integer.valueOf(paramc.d) });
      str = "tb_item_bg_color_normal";
      continue;
      if (paramc.b != 0) {
        str = "abnormal";
      } else {
        str = "normal";
      }
    }
  }
  
  private static String a(String paramString)
  {
    try
    {
      String str = new String(paramString.getBytes("UTF-8"));
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  private String a(String paramString, com.mato.sdk.e.b.a.b paramb1, com.mato.sdk.e.b.a.b paramb2)
  {
    paramString = paramString.replace("${url}", paramb1.c).replace("${bypass_data_1}", a(paramb1)).replace("${bypass_data_2}", b(paramb1));
    if (paramb2 != null) {
      return paramString.replace("${acce_display}", "").replace("${acce_data_1}", a(paramb2)).replace("${acce_data_2}", b(paramb2));
    }
    return paramString.replace("${acce_display}", "style=\"display:none\"");
  }
  
  private static void a(StringBuilder paramStringBuilder, f.a parama)
  {
    paramStringBuilder.append("<table class=\"bcontent\">");
    paramStringBuilder.append("<tr>");
    Locale localLocale = Locale.US;
    if (parama.a)
    {
      str = "right";
      paramStringBuilder.append(String.format(localLocale, "<td class=\"ti\"><img src=\"image/img5/%s.png\"></td>", new Object[] { str }));
      paramStringBuilder.append("<td class=\"cont\"><span class=\"tmsg\">");
      paramStringBuilder.append(parama.b);
      paramStringBuilder.append("</span></td>");
      localLocale = Locale.US;
      if (!parama.a) {
        break label219;
      }
    }
    label219:
    for (String str = "msg_normal";; str = "msg_abnormal")
    {
      paramStringBuilder.append(String.format(localLocale, "<td class=\"long\"><span class=\"%s\">%s</span></td>", new Object[] { str, parama.c.get(0) }));
      paramStringBuilder.append("</tr>");
      if (parama.c.size() <= 1) {
        break label225;
      }
      int i = 1;
      while (i < parama.c.size())
      {
        paramStringBuilder.append("<tr>");
        paramStringBuilder.append("<td colspan=\"2\"></td>");
        paramStringBuilder.append(String.format(Locale.US, "<td class=\"long\"><div class=\"msg_abnormal\">%s</div></td>", new Object[] { parama.c.get(i) }));
        paramStringBuilder.append("</tr>");
        i += 1;
      }
      str = "wrong";
      break;
    }
    label225:
    paramStringBuilder.append("</table>");
  }
  
  private static String b()
  {
    return "style=\"display:none\"";
  }
  
  private static String b(com.mato.sdk.e.b.a.b paramb)
  {
    String str1;
    int i;
    label55:
    String str2;
    if (com.mato.sdk.e.b.c.b.a(paramb.e))
    {
      str1 = "normal";
      if ((paramb.g != -1) && (paramb.h != -1) && (paramb.i != -1) && (paramb.j != -1) && (paramb.k != -1)) {
        break label141;
      }
      i = -1;
      if (i != -1) {
        break label169;
      }
      str2 = "-";
      label64:
      if (paramb.m != -1) {
        break label193;
      }
    }
    label141:
    label169:
    label193:
    for (String str3 = "-";; str3 = String.format(Locale.US, "%dKB/s", new Object[] { Integer.valueOf(paramb.m) }))
    {
      return String.format(Locale.US, "<tr class=\"%s\"><td>%dms</td><td>%dms</td><td>%dms</td><td>%s</td><td>%s</td></tr>", new Object[] { str1, Integer.valueOf(paramb.i), Integer.valueOf(paramb.j), Integer.valueOf(paramb.k), str2, str3 });
      str1 = "abnormal";
      break;
      i = paramb.g + paramb.h + paramb.i + paramb.j + paramb.k;
      break label55;
      str2 = String.format(Locale.US, "%dms", new Object[] { Integer.valueOf(i) });
      break label64;
    }
  }
  
  private String c()
  {
    String str = this.b.h();
    Object localObject;
    if (!this.b.j())
    {
      localObject = this.b.i();
      if (localObject == null) {
        localObject = "";
      }
    }
    for (;;)
    {
      this.d = this.d.replace("${diagnosis_title}", a(str));
      return this.d.replace("${diagnosis_body}", a((String)localObject));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<ul>");
      a(localStringBuilder, (f.a)localObject);
      localStringBuilder.append("</ul>");
      localObject = localStringBuilder.toString();
      continue;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<ul>");
      if (i.a(this.b.d(), 1)) {
        a((StringBuilder)localObject, this.b.e());
      }
      if (i.a(this.b.d(), 4)) {
        a((StringBuilder)localObject, this.b.g());
      }
      if (i.a(this.b.d(), 2)) {
        a((StringBuilder)localObject, this.b.f());
      }
      ((StringBuilder)localObject).append("</ul>");
      localObject = ((StringBuilder)localObject).toString();
    }
  }
  
  private String d()
  {
    if (!this.b.j())
    {
      localObject = this.b.i();
      if (localObject == null) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<ul>");
      a(localStringBuilder, (f.a)localObject);
      localStringBuilder.append("</ul>");
      return localStringBuilder.toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<ul>");
    if (i.a(this.b.d(), 1)) {
      a((StringBuilder)localObject, this.b.e());
    }
    if (i.a(this.b.d(), 4)) {
      a((StringBuilder)localObject, this.b.g());
    }
    if (i.a(this.b.d(), 2)) {
      a((StringBuilder)localObject, this.b.f());
    }
    ((StringBuilder)localObject).append("</ul>");
    return ((StringBuilder)localObject).toString();
  }
  
  private String e()
  {
    g localg = this.b.a();
    String str = localg.f;
    int i;
    if (!str.equalsIgnoreCase("wifi"))
    {
      i = com.mato.sdk.b.b.a(localg.d);
      if (i == 3) {
        str = String.format(Locale.US, "%s", new Object[] { str });
      }
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      localStringBuilder = new StringBuilder("");
      Iterator localIterator = localg.j.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append(";");
      }
      str = String.format(Locale.US, "%s-%s", new Object[] { com.mato.sdk.b.b.a(i), str });
      continue;
      str = String.format(Locale.US, "%s", new Object[] { str });
    }
    this.d = this.d.replace("${networktype}", a(str));
    this.d = this.d.replace("${model}", a(Build.MODEL));
    this.d = this.d.replace("${android_version}", a(Build.VERSION.RELEASE));
    this.d = this.d.replace("${app_version}", a(i.f(this.c)));
    this.d = this.d.replace("${imei}", a(localg.e));
    this.d = this.d.replace("${mid}", a(localg.c));
    this.d = this.d.replace("${localhost}", a(localg.i));
    this.d = this.d.replace("${apn}", a(localg.h));
    this.d = this.d.replace("${dns_list}", a(localg.g));
    this.d = this.d.replace("${ifconfig}", a(localStringBuilder.toString()));
    return this.d;
  }
  
  private String f()
  {
    Object localObject2 = this.b.a();
    if ((!((g)localObject2).a) || ((this.b.d() & 0x2) != 2)) {
      return this.d.replace("${ping_info_display}", "style=\"display:none\"");
    }
    Object localObject1 = new StringBuilder("");
    Object localObject3 = ((g)localObject2).o.iterator();
    float f = 0.0F;
    int i = 0;
    c localc;
    boolean bool;
    if (((Iterator)localObject3).hasNext())
    {
      localc = (c)((Iterator)localObject3).next();
      if (i % 2 == 0) {}
      for (bool = true;; bool = false)
      {
        ((StringBuilder)localObject1).append(a(localc, bool));
        f = localc.b + f;
        i += 1;
        break;
      }
    }
    localObject2 = ((g)localObject2).n.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (a)((Iterator)localObject2).next();
      if (((a)localObject3).b != null)
      {
        localc = ((a)localObject3).b;
        if (i % 2 == 0) {}
        for (bool = true;; bool = false)
        {
          ((StringBuilder)localObject1).append(a(localc, bool));
          f += ((a)localObject3).b.b;
          i += 1;
          break;
        }
      }
    }
    this.d = this.d.replace("${ping_data}", ((StringBuilder)localObject1).toString());
    if (i > 0) {}
    for (f /= i;; f = 0.0F)
    {
      this.d = this.d.replace("${packet_loss}", String.valueOf(f));
      localObject2 = this.d;
      if (f > 0.0F) {}
      for (localObject1 = "abnormal";; localObject1 = "normal")
      {
        this.d = ((String)localObject2).replace("${packetloss_color}", (CharSequence)localObject1);
        return this.d.replace("${ping_info_display}", "");
      }
    }
  }
  
  private String g()
  {
    Object localObject1 = this.b.a();
    if ((!((g)localObject1).a) || ((this.b.d() & 0x4) != 4)) {
      return this.d.replace("${download_info_display}", "style=\"display:none\"");
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    String str = a(this.c, "singlehostdownloadinfo.xml");
    if (str == null) {
      return this.d;
    }
    Iterator localIterator = ((g)localObject1).p.iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (e)localIterator.next();
      localObject1 = new String(str);
      com.mato.sdk.e.b.a.b localb = ((e)localObject2).b;
      localObject2 = ((e)localObject2).c;
      localObject1 = ((String)localObject1).replace("${url}", localb.c).replace("${bypass_data_1}", a(localb)).replace("${bypass_data_2}", b(localb));
      if (localObject2 != null) {}
      for (localObject1 = ((String)localObject1).replace("${acce_display}", "").replace("${acce_data_1}", a((com.mato.sdk.e.b.a.b)localObject2)).replace("${acce_data_2}", b((com.mato.sdk.e.b.a.b)localObject2));; localObject1 = ((String)localObject1).replace("${acce_display}", "style=\"display:none\""))
      {
        localStringBuilder.append((String)localObject1);
        break;
      }
    }
    this.d = this.d.replace("${download_data}", localStringBuilder.toString());
    return this.d.replace("${download_info_display}", "");
  }
  
  public final String a()
  {
    for (;;)
    {
      try
      {
        this.d = a(this.c, "diagnose_report.html");
        int i = this.b.c();
        this.d = this.d.replace("${load_percent}", String.valueOf(i));
        this.d = this.d;
        String str = this.b.h();
        if (this.b.j()) {
          continue;
        }
        localObject = this.b.i();
        if (localObject != null) {
          continue;
        }
        localObject = "";
        this.d = this.d.replace("${diagnosis_title}", a(str));
        this.d = this.d.replace("${diagnosis_body}", a((String)localObject));
        this.d = e();
        this.d = g();
        this.d = f();
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        StringBuilder localStringBuilder;
        continue;
      }
      return this.d;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<ul>");
      a(localStringBuilder, (f.a)localObject);
      localStringBuilder.append("</ul>");
      localObject = localStringBuilder.toString();
      continue;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<ul>");
      if (i.a(this.b.d(), 1)) {
        a((StringBuilder)localObject, this.b.e());
      }
      if (i.a(this.b.d(), 4)) {
        a((StringBuilder)localObject, this.b.g());
      }
      if (i.a(this.b.d(), 2)) {
        a((StringBuilder)localObject, this.b.f());
      }
      ((StringBuilder)localObject).append("</ul>");
      localObject = ((StringBuilder)localObject).toString();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */