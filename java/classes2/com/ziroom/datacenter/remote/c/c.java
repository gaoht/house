package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.e;
import com.ziroom.commonlib.utils.g;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class c<T>
  extends com.ziroom.commonlib.ziroomhttp.f.a<List<T>>
{
  protected Class<T> c;
  
  public c(Class<T> paramClass)
  {
    this.c = paramClass;
  }
  
  public List<T> parse(Response paramResponse)
    throws Exception
  {
    String str1 = paramResponse.body().string();
    l.d("GatewayModelArrayParser", "=====url:" + paramResponse.request().url().toString());
    l.d("GatewayModelArrayParser", "=====resp:" + str1);
    if (paramResponse.isSuccessful())
    {
      paramResponse = g.desDecrypt(str1);
      l.d("GatewayModelArrayParser", "=====respDecode:" + paramResponse);
      paramResponse = com.alibaba.fastjson.a.parseObject(paramResponse);
      str1 = paramResponse.getString("status");
      String str2 = paramResponse.getString("code");
      if (("success".equals(str1)) && ("200".equals(str2)))
      {
        if (this.c == null) {
          return null;
        }
        return com.alibaba.fastjson.a.parseArray(paramResponse.getString("data"), this.c);
      }
      throw new com.ziroom.commonlib.ziroomhttp.d.a(str2, paramResponse.getString("message"));
    }
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */