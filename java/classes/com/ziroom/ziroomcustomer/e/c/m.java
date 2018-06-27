package com.ziroom.ziroomcustomer.e.c;

import com.ziroom.commonlibrary.a.b;
import com.ziroom.ziroomcustomer.e.c.a.f;
import com.ziroom.ziroomcustomer.util.k;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class m<T>
  extends com.freelxl.baselibrary.d.f.d<T>
{
  protected f b;
  
  public m(Class<T> paramClass, f paramf)
  {
    super(paramClass);
    this.b = paramf;
  }
  
  public T parseResponse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    com.freelxl.baselibrary.f.d.d("ModelHandlerParser", "=====url:" + paramResponse.request().url().toString());
    com.freelxl.baselibrary.f.d.d("ModelHandlerParser", "=====resp:" + str);
    com.freelxl.baselibrary.f.d.logBigData("ModelHandlerParser", "=====des resp:" + k.decrypt(str));
    if (paramResponse.isSuccessful())
    {
      this.b.decode(str);
      if (this.b.isSuccess())
      {
        if (this.a == null) {
          return null;
        }
        if (this.a == String.class) {
          return this.b.getData();
        }
        return (T)com.alibaba.fastjson.a.parseObject(this.b.getData(), this.a);
      }
      throw new b(this.b.getCode(), this.b.getMessage());
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */