package com.ziroom.datacenter.remote.c;

import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.c;
import com.ziroom.commonlib.ziroomhttp.f.a;
import com.ziroom.datacenter.remote.c.a.f;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class g
  extends a<com.alibaba.fastjson.b>
{
  protected f c;
  
  public g(f paramf)
  {
    this.c = paramf;
  }
  
  protected com.alibaba.fastjson.b a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    l.d("JsonArrayHandlerParser", "=====url:" + paramResponse.request().url().toString());
    l.d("JsonArrayHandlerParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      this.c.decode(str);
      if (this.c.isSuccess()) {
        return com.alibaba.fastjson.b.parseArray(this.c.getData());
      }
      throw new c(this.c.getCode(), this.c.getMessage());
    }
    throw new com.ziroom.commonlib.ziroomhttp.d.b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */