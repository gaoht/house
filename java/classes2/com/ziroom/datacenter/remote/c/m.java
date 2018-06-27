package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import com.ziroom.commonlib.ziroomhttp.d.b;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class m<T>
  extends com.ziroom.commonlib.ziroomhttp.f.c<T>
{
  public m(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful())
    {
      paramResponse = e.parseObject(paramResponse.body().string());
      if (paramResponse != null)
      {
        String str = paramResponse.get("status").toString();
        if (("success".equals(str)) || ("0".equals(str)))
        {
          if (paramResponse.getString("data") == null) {}
          for (paramResponse = ""; this.c == null; paramResponse = paramResponse.get("data").toString()) {
            return null;
          }
          return (T)a.parseObject(paramResponse, this.c);
        }
        if (paramResponse.get("message") != null) {
          throw new com.ziroom.commonlib.ziroomhttp.d.c(0, paramResponse.get("message").toString());
        }
        throw new com.ziroom.commonlib.ziroomhttp.d.c(0, "请求数据失败");
      }
      throw new com.ziroom.commonlib.ziroomhttp.d.c(0);
    }
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */