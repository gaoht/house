package com.megvii.zhimasdk.c;

import android.content.Context;
import com.megvii.zhimasdk.b.a;
import com.megvii.zhimasdk.b.c;
import com.megvii.zhimasdk.b.q;
import com.megvii.zhimasdk.d.g;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class b
{
  private static b a;
  private static String b;
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  
  public static b a()
  {
    if (a == null) {
      a = new b();
    }
    return a;
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      d = "http://11.28.51.42/sdk/zhima/auth/v1_1";
      b = "https://bj-faceid-test-asset.oss-cn-beijing.aliyuncs.com/zhimasdk-static/v1.0.1/home.html";
    }
    for (c = "https://bj-faceid-test-asset.oss-cn-beijing.aliyuncs.com/zhimasdk-static/v1.0.1/result.html";; c = "https://bj-faceid-prod-asset.oss-cn-beijing.aliyuncs.com/zhimasdk-static/v1.0.1/result.html")
    {
      e = d + "/initialize";
      f = d + "/verify";
      g = d + "/check_user_agreement";
      h = d + "/record_user_agreement";
      return;
      d = "https://api.megvii.com/sdk/zhima/auth/v1_1";
      b = "https://bj-faceid-prod-asset.oss-cn-beijing.aliyuncs.com/zhimasdk-static/v1.0.1/home.html";
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3, Map<String, byte[]> paramMap, c paramc)
  {
    paramContext = new q();
    paramContext.b("biz_no", paramString1);
    paramContext.b("user_agreement_hash", paramString2);
    if (paramBoolean) {
      paramContext.b("liveness_result", "True");
    }
    for (;;)
    {
      paramContext.a("delta", paramString3);
      paramString1 = paramMap.keySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        paramContext.a(paramString2, new ByteArrayInputStream((byte[])paramMap.get(paramString2)));
      }
      paramContext.b("liveness_result", "False");
    }
    paramString1 = new a();
    paramString1.b(10000);
    paramString1.c(10000);
    paramString1.a(10000);
    g.a("verify: VERIFY_URL", f);
    paramString1.b(f, paramContext, paramc);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, byte[] paramArrayOfByte, c paramc)
  {
    paramContext = new q();
    paramContext.a("biz_no", paramString1);
    paramContext.a("merchant_id", paramString2);
    paramContext.a("agreement_content", new ByteArrayInputStream(paramArrayOfByte), "zhima", "application/octet-stream");
    paramString1 = new a();
    paramString1.b(10000);
    paramString1.c(10000);
    paramString1.a(10000);
    paramString1.b(h, paramContext, paramc);
  }
  
  public void a(c paramc)
  {
    a locala = new a();
    locala.b(10000);
    locala.c(10000);
    locala.a(10000);
    g.a("html: HOME_URL", b);
    locala.a(b, null, paramc);
  }
  
  public void a(String paramString, c paramc)
  {
    a locala = new a();
    locala.b(10000);
    locala.c(10000);
    locala.a(10000);
    locala.a(paramString, null, paramc);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, c paramc)
  {
    q localq = new q();
    localq.a("biz_no", paramString1);
    localq.a("merchant_id", paramString2);
    localq.a("auth_msg", paramString3);
    localq.a("version_id", "ZMCert 1.0.4A");
    paramString1 = new a();
    paramString1.b(10000);
    paramString1.c(10000);
    paramString1.a(10000);
    g.a("initialize: INITIALIZE_URL", e);
    paramString1.b(e, localq, paramc);
  }
  
  public void b(c paramc)
  {
    a locala = new a();
    locala.b(10000);
    locala.c(10000);
    locala.a(10000);
    g.a("html: RESULT_URL", c);
    locala.a(c, null, paramc);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, c paramc)
  {
    q localq = new q();
    localq.a("biz_no", paramString1);
    localq.a("merchant_id", paramString2);
    localq.a("hash", paramString3);
    paramString1 = new a();
    paramString1.b(10000);
    paramString1.c(10000);
    paramString1.a(10000);
    paramString1.b(g, localq, paramc);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */