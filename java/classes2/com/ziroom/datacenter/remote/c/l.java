package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import com.ziroom.commonlib.ziroomhttp.d.b;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class l<T>
  extends com.ziroom.commonlib.ziroomhttp.f.c<T>
{
  public l(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful())
    {
      paramResponse = paramResponse.body().string();
      e locale = e.parseObject(paramResponse);
      if (locale != null)
      {
        if ("success".equals(locale.get("status").toString())) {
          return (T)a.parseObject(paramResponse, this.c);
        }
        if (locale.get("message") != null) {
          throw new com.ziroom.commonlib.ziroomhttp.d.c(0, locale.get("message").toString());
        }
        throw new com.ziroom.commonlib.ziroomhttp.d.c(0, "请求数据失败");
      }
      throw new com.ziroom.commonlib.ziroomhttp.d.c(0);
    }
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */