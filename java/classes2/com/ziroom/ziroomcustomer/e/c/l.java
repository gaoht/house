package com.ziroom.ziroomcustomer.e.c;

import com.freelxl.baselibrary.f.d;
import com.ziroom.commonlibrary.a.b;
import com.ziroom.ziroomcustomer.e.c.a.f;
import com.ziroom.ziroomcustomer.util.k;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class l<T>
  extends com.freelxl.baselibrary.d.f.a<List<T>>
{
  protected Class<T> a;
  protected f b;
  
  public l(Class<T> paramClass, f paramf)
  {
    this.a = paramClass;
    this.b = paramf;
  }
  
  public List<T> parse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    d.d("ModelArrayHandlerParser", "=====url:" + paramResponse.request().url().toString());
    d.d("ModelArrayHandlerParser", "=====resp:" + str);
    d.d("ModelArrayHandlerParser", "=====resp:" + k.decrypt(str));
    if (paramResponse.isSuccessful())
    {
      this.b.decode(str);
      if (this.b.isSuccess())
      {
        if (this.a == null) {
          return null;
        }
        return com.alibaba.fastjson.a.parseArray(this.b.getData(), this.a);
      }
      throw new b(this.b.getCode(), this.b.getMessage());
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */