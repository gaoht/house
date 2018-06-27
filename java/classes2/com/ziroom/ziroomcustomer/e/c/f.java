package com.ziroom.ziroomcustomer.e.c;

import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.util.k;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class f<T>
  extends com.freelxl.baselibrary.d.f.d<T>
{
  public f(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  public T parseResponse(Response paramResponse)
    throws Exception
  {
    String str1 = paramResponse.body().string();
    com.freelxl.baselibrary.f.d.d("GatewayModelParser", "=====url:" + paramResponse.request().url().toString());
    com.freelxl.baselibrary.f.d.d("GatewayModelParser", "=====resp:" + str1);
    if (paramResponse.isSuccessful())
    {
      paramResponse = k.decrypt(str1);
      com.freelxl.baselibrary.f.d.d("GatewayModelParser", "=====respDecode:" + paramResponse);
      paramResponse = com.alibaba.fastjson.a.parseObject(paramResponse);
      str1 = paramResponse.getString("status");
      String str2 = paramResponse.getString("code");
      if (("success".equals(str1)) && ("200".equals(str2)))
      {
        if ((this.a == null) || (paramResponse.getString("data") == null)) {
          return null;
        }
        return (T)com.alibaba.fastjson.a.parseObject(paramResponse.getString("data"), this.a);
      }
      throw new com.ziroom.ziroomcustomer.e.b.a(str2, paramResponse.getString("message"));
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */