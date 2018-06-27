package com.ziroom.ziroomcustomer.e.c;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.ziroom.commonlibrary.a.b;
import com.ziroom.ziroomcustomer.e.c.a.f;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class k
  extends com.freelxl.baselibrary.d.f.a<e>
{
  protected f a;
  
  public k(f paramf)
  {
    this.a = paramf;
  }
  
  protected e a(Response paramResponse)
    throws Exception
  {
    com.freelxl.baselibrary.f.a.a locala = new com.freelxl.baselibrary.f.a.a();
    String str = paramResponse.body().string();
    d.d("JsonObjectHandlerParser", "=====url:" + paramResponse.request().url().toString());
    d.d("JsonObjectHandlerParser", "=====resp:" + str);
    d.d("JsonObjectHandlerParser", "=====resp:" + locala.decrypt(str, "EbpU4WtY", "vpRZ1kmU"));
    if (paramResponse.isSuccessful())
    {
      this.a.decode(str);
      if (this.a.isSuccess()) {
        return com.alibaba.fastjson.a.parseObject(this.a.getData());
      }
      throw new b(this.a.getCode(), this.a.getMessage());
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */