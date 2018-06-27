package com.ziroom.commonlibrary.a.b;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class b
  extends com.freelxl.baselibrary.d.f.a<e>
{
  protected e a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    d.d("ServerJsonObjectParser", "=====url:" + paramResponse.request().url().toString());
    d.d("ServerJsonObjectParser", "=====resp:" + str);
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
          throw new com.ziroom.commonlibrary.a.b(paramResponse, str, locale);
        }
      }
      throw new com.ziroom.commonlibrary.a.b(paramResponse, str);
    }
    d.d("ServerJsonObjectParser", "===" + paramResponse.code());
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */