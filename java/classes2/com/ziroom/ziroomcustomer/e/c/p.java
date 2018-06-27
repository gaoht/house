package com.ziroom.ziroomcustomer.e.c;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.ziroom.commonlibrary.a.b;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class p<T>
  extends com.freelxl.baselibrary.d.f.a<List<T>>
{
  protected Class<T> a;
  
  public p(Class<T> paramClass)
  {
    this.a = paramClass;
  }
  
  public List<T> parse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    d.d("PhpServerModelParser", "=====url:" + paramResponse.request().url().toString());
    d.d("PhpServerModelParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      paramResponse = com.alibaba.fastjson.a.parseObject(str);
      if ("success".equals(paramResponse.getString("status")))
      {
        if (this.a == null) {
          return null;
        }
        return com.alibaba.fastjson.a.parseArray(paramResponse.getString("data"), this.a);
      }
      throw new b(paramResponse.getInteger("error_code").intValue(), paramResponse.getString("error_message"));
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */