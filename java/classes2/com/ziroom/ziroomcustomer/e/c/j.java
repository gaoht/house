package com.ziroom.ziroomcustomer.e.c;

import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.e.c.a.f;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class j
  extends com.freelxl.baselibrary.d.f.a<com.alibaba.fastjson.b>
{
  protected f a;
  
  public j(f paramf)
  {
    this.a = paramf;
  }
  
  protected com.alibaba.fastjson.b a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    d.d("JsonArrayHandlerParser", "=====url:" + paramResponse.request().url().toString());
    d.d("JsonArrayHandlerParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      this.a.decode(str);
      if (this.a.isSuccess()) {
        return com.alibaba.fastjson.b.parseArray(this.a.getData());
      }
      throw new com.ziroom.commonlibrary.a.b(this.a.getCode(), this.a.getMessage());
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */