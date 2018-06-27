package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.e;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import com.ziroom.commonlib.ziroomhttp.d.c;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class u<T>
  extends com.ziroom.commonlib.ziroomhttp.f.a<List<T>>
{
  protected Class<T> c;
  
  public u(Class<T> paramClass)
  {
    this.c = paramClass;
  }
  
  public List<T> parse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    l.d("ServiceModelParser", "=====url:" + paramResponse.request().url().toString());
    l.d("ServiceModelParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      paramResponse = com.alibaba.fastjson.a.parseObject(str);
      if (1 == paramResponse.getInteger("status").intValue())
      {
        if (this.c == null) {
          return null;
        }
        return com.alibaba.fastjson.a.parseArray(paramResponse.getString("data"), this.c);
      }
      throw new c(0, paramResponse.getString("message"));
    }
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */