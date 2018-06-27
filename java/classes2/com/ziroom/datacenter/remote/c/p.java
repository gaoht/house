package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.e;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import com.ziroom.commonlib.ziroomhttp.d.c;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class p<T>
  extends com.ziroom.commonlib.ziroomhttp.f.a<T>
{
  protected Class<T> c;
  
  public p(Class<T> paramClass)
  {
    this.c = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful())
    {
      paramResponse = paramResponse.body().string();
      l.e("+++++", paramResponse);
      paramResponse = e.parseObject(paramResponse);
      if (paramResponse != null)
      {
        if ("0".equals(paramResponse.get("code").toString()))
        {
          if (paramResponse.getString("data") == null) {}
          for (paramResponse = "";; paramResponse = paramResponse.get("data").toString()) {
            return (T)com.alibaba.fastjson.a.parseObject(paramResponse, this.c);
          }
        }
        throw new c(0, paramResponse.get("message").toString());
      }
      throw new c(0);
    }
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */