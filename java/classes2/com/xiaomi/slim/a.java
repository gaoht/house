package com.xiaomi.slim;

import android.text.TextUtils;
import com.xiaomi.push.protobuf.b.c;
import com.xiaomi.push.service.ak.b;
import java.util.HashMap;
import java.util.Map;

class a
{
  public static void a(ak.b paramb, String paramString, com.xiaomi.smack.a parama)
  {
    b.c localc = new b.c();
    if (!TextUtils.isEmpty(paramb.c)) {
      localc.a(paramb.c);
    }
    if (!TextUtils.isEmpty(paramb.f)) {
      localc.d(paramb.f);
    }
    if (!TextUtils.isEmpty(paramb.g)) {
      localc.e(paramb.g);
    }
    Object localObject;
    label106:
    HashMap localHashMap;
    if (paramb.e)
    {
      localObject = "1";
      localc.b((String)localObject);
      if (TextUtils.isEmpty(paramb.d)) {
        break label404;
      }
      localc.c(paramb.d);
      localObject = new b();
      ((b)localObject).c(paramb.b);
      ((b)localObject).a(Integer.parseInt(paramb.h));
      ((b)localObject).b(paramb.a);
      ((b)localObject).a("BIND", null);
      ((b)localObject).a(((b)localObject).h());
      com.xiaomi.channel.commonutils.logger.b.a("[Slim]: bind id=" + ((b)localObject).h());
      localHashMap = new HashMap();
      localHashMap.put("challenge", paramString);
      localHashMap.put("token", paramb.c);
      localHashMap.put("chid", paramb.h);
      localHashMap.put("from", paramb.b);
      localHashMap.put("id", ((b)localObject).h());
      localHashMap.put("to", "xiaomi.com");
      if (!paramb.e) {
        break label415;
      }
      localHashMap.put("kick", "1");
      label288:
      if (TextUtils.isEmpty(paramb.f)) {
        break label430;
      }
      localHashMap.put("client_attrs", paramb.f);
      label312:
      if (TextUtils.isEmpty(paramb.g)) {
        break label445;
      }
      localHashMap.put("cloud_attrs", paramb.g);
      label336:
      if ((!paramb.d.equals("XIAOMI-PASS")) && (!paramb.d.equals("XMPUSH-PASS"))) {
        break label460;
      }
    }
    for (paramb = com.xiaomi.channel.commonutils.string.b.a(paramb.d, null, localHashMap, paramb.i);; paramb = null)
    {
      localc.f(paramb);
      ((b)localObject).a(localc.c(), null);
      parama.b((b)localObject);
      return;
      localObject = "0";
      break;
      label404:
      localc.c("XIAOMI-SASL");
      break label106;
      label415:
      localHashMap.put("kick", "0");
      break label288;
      label430:
      localHashMap.put("client_attrs", "");
      break label312;
      label445:
      localHashMap.put("cloud_attrs", "");
      break label336;
      label460:
      if (!paramb.d.equals("XIAOMI-SASL")) {}
    }
  }
  
  public static void a(String paramString1, String paramString2, com.xiaomi.smack.a parama)
  {
    b localb = new b();
    localb.c(paramString2);
    localb.a(Integer.parseInt(paramString1));
    localb.a("UBND", null);
    parama.b(localb);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/slim/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */