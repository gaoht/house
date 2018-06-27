package com.ziroom.datacenter.remote.c;

import com.ziroom.commonlib.utils.g;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class e
  extends com.ziroom.commonlib.ziroomhttp.f.a<com.alibaba.fastjson.e>
{
  protected com.alibaba.fastjson.e a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    l.d("PhpServerModelParser", "=====respOri:" + str);
    str = g.desDecrypt(str);
    l.d("GatewayObjectParserDirectly", "=====url:" + paramResponse.request().url().toString());
    l.d("GatewayObjectParserDirectly", "=====resp:" + str);
    if (paramResponse.isSuccessful()) {
      return com.alibaba.fastjson.a.parseObject(str);
    }
    l.d("GatewayObjectParserDirectly", "===" + paramResponse.code());
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */