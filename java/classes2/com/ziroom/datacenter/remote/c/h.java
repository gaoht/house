package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.e;
import com.ziroom.commonlib.utils.g;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import com.ziroom.commonlib.ziroomhttp.d.c;
import com.ziroom.datacenter.remote.c.a.f;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class h
  extends com.ziroom.commonlib.ziroomhttp.f.a<e>
{
  protected f c;
  
  public h(f paramf)
  {
    this.c = paramf;
  }
  
  protected e a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    l.d("JsonObjectHandlerParser", "=====url:" + paramResponse.request().url().toString());
    l.d("JsonObjectHandlerParser", "=====resp:" + str);
    l.d("JsonObjectHandlerParser", "=====resp:" + g.desDecrypt(str, "EbpU4WtY", "vpRZ1kmU"));
    if (paramResponse.isSuccessful())
    {
      this.c.decode(str);
      if (this.c.isSuccess()) {
        return com.alibaba.fastjson.a.parseObject(this.c.getData());
      }
      throw new c(this.c.getCode(), this.c.getMessage());
    }
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */