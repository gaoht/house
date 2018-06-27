package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.e;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import com.ziroom.commonlib.ziroomhttp.d.c;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class r
  extends com.ziroom.commonlib.ziroomhttp.f.a<e>
{
  protected e a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    l.d("ServerJsonObjectParser", "=====url:" + paramResponse.request().url().toString());
    l.d("ServerJsonObjectParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      e locale = com.alibaba.fastjson.a.parseObject(str);
      if ("success".equals(locale.getString("message"))) {
        return locale.getJSONObject("resp");
      }
      paramResponse = locale.getString("code");
      str = locale.getString("message");
      if (locale.containsKey("resp"))
      {
        locale = locale.getJSONObject("resp");
        if (locale != null) {
          throw new c(paramResponse, str, locale);
        }
      }
      throw new c(paramResponse, str);
    }
    l.d("ServerJsonObjectParser", "===" + paramResponse.code());
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */