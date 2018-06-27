package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.e;
import com.ziroom.commonlib.utils.g;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import com.ziroom.commonlib.ziroomhttp.f.c;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class d<T>
  extends c<T>
{
  public d(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  public T parseResponse(Response paramResponse)
    throws Exception
  {
    String str1 = paramResponse.body().string();
    l.d("GatewayModelParser", "=====url:" + paramResponse.request().url().toString());
    l.d("GatewayModelParser", "=====resp:" + str1);
    if (paramResponse.isSuccessful())
    {
      paramResponse = g.desDecrypt(str1);
      l.d("GatewayModelParser", "=====respDecode:" + paramResponse);
      paramResponse = com.alibaba.fastjson.a.parseObject(paramResponse);
      str1 = paramResponse.getString("status");
      String str2 = paramResponse.getString("code");
      if (("success".equals(str1)) && ("200".equals(str2)))
      {
        if ((this.c == null) || (paramResponse.getString("data") == null)) {
          return null;
        }
        return (T)com.alibaba.fastjson.a.parseObject(paramResponse.getString("data"), this.c);
      }
      throw new com.ziroom.commonlib.ziroomhttp.d.a(str2, paramResponse.getString("message"));
    }
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */