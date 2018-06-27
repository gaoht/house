package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.e;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import com.ziroom.commonlib.ziroomhttp.d.c;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class t
  extends com.ziroom.commonlib.ziroomhttp.f.a<e>
{
  protected e a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    l.d("ServiceJsonObjectParser", "=====url:" + paramResponse.request().url().toString());
    l.d("ServiceJsonObjectParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      paramResponse = com.alibaba.fastjson.a.parseObject(str);
      if (1 == paramResponse.getInteger("status").intValue()) {
        return paramResponse.getJSONObject("data");
      }
      throw new c(0, paramResponse.getString("message"));
    }
    l.d("ServiceJsonObjectParser", "===" + paramResponse.code());
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */