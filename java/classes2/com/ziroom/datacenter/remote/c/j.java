package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.a;
import com.ziroom.commonlib.utils.g;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import com.ziroom.commonlib.ziroomhttp.d.c;
import com.ziroom.datacenter.remote.c.a.f;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class j<T>
  extends k<T>
{
  protected f c;
  
  public j(Class<T> paramClass, f paramf)
  {
    super(paramClass);
    this.c = paramf;
  }
  
  public T parseResponse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    l.d("ModelHandlerParser", "=====url:" + paramResponse.request().url().toString());
    l.d("ModelHandlerParser", "=====resp:" + str);
    l.d("ModelHandlerParser", "=====des resp:" + g.desDecrypt(str));
    if (paramResponse.isSuccessful())
    {
      this.c.decode(str);
      if (this.c.isSuccess())
      {
        if (this.d == null) {
          return null;
        }
        if (this.d == String.class) {
          return this.c.getData();
        }
        return (T)a.parseObject(this.c.getData(), this.d);
      }
      throw new c(this.c.getCode(), this.c.getMessage());
    }
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */