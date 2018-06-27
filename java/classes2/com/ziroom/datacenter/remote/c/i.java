package com.ziroom.datacenter.remote.c;

import com.ziroom.commonlib.utils.g;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import com.ziroom.commonlib.ziroomhttp.d.c;
import com.ziroom.datacenter.remote.c.a.f;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class i<T>
  extends com.ziroom.commonlib.ziroomhttp.f.a<List<T>>
{
  protected Class<T> c;
  protected f d;
  
  public i(Class<T> paramClass, f paramf)
  {
    this.c = paramClass;
    this.d = paramf;
  }
  
  public List<T> parse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    l.d("ModelArrayHandlerParser", "=====url:" + paramResponse.request().url().toString());
    l.d("ModelArrayHandlerParser", "=====resp:" + str);
    l.d("ModelArrayHandlerParser", "=====resp:" + g.desDecrypt(str));
    if (paramResponse.isSuccessful())
    {
      this.d.decode(str);
      if (this.d.isSuccess())
      {
        if (this.c == null) {
          return null;
        }
        return com.alibaba.fastjson.a.parseArray(this.d.getData(), this.c);
      }
      throw new c(this.d.getCode(), this.d.getMessage());
    }
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */