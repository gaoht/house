package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.e;
import com.ziroom.commonlib.utils.g;
import com.ziroom.commonlib.utils.l;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class b
  extends com.ziroom.commonlib.ziroomhttp.f.a<e>
{
  protected e a(Response paramResponse)
    throws Exception
  {
    String str1 = paramResponse.body().string();
    l.d("MinsuGatewayJsonObjectParser", "=====url:" + paramResponse.request().url().toString());
    l.d("MinsuGatewayJsonObjectParser", "=====resp:" + str1);
    if (paramResponse.isSuccessful())
    {
      paramResponse = g.desDecrypt(str1);
      l.d("MinsuGatewayJsonObjectParser", "=====respDecode:" + paramResponse);
      paramResponse = com.alibaba.fastjson.a.parseObject(paramResponse);
      str1 = paramResponse.getString("status");
      String str2 = paramResponse.getString("code");
      if (("success".equals(str1)) && ("200".equals(str2))) {
        return paramResponse.getJSONObject("data");
      }
      throw new com.ziroom.commonlib.ziroomhttp.d.a(str2, paramResponse.getString("message"));
    }
    l.d("MinsuGatewayJsonObjectParser", "===" + paramResponse.code());
    throw new com.ziroom.commonlib.ziroomhttp.d.b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */