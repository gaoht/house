package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import com.ziroom.commonlib.ziroomhttp.d.c;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class v<T>
  extends k<T>
{
  public v(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  public T parseResponse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    l.d("ServiceModelParser", "=====url:" + paramResponse.request().url().toString());
    l.d("ServiceModelParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      paramResponse = a.parseObject(str);
      if (1 == paramResponse.getInteger("status").intValue())
      {
        if (this.d == null) {
          return null;
        }
        return (T)a.parseObject(paramResponse.getString("data"), this.d);
      }
      throw new c(0, paramResponse.getString("message"));
    }
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */