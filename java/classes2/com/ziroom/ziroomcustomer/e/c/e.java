package com.ziroom.ziroomcustomer.e.c;

import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.util.k;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class e<T>
  extends com.freelxl.baselibrary.d.f.a<List<T>>
{
  protected Class<T> a;
  
  public e(Class<T> paramClass)
  {
    this.a = paramClass;
  }
  
  public List<T> parse(Response paramResponse)
    throws Exception
  {
    String str1 = paramResponse.body().string();
    d.d("GatewayModelArrayParser", "=====url:" + paramResponse.request().url().toString());
    d.d("GatewayModelArrayParser", "=====resp:" + str1);
    if (paramResponse.isSuccessful())
    {
      paramResponse = k.decrypt(str1);
      d.d("GatewayModelArrayParser", "=====respDecode:" + paramResponse);
      paramResponse = com.alibaba.fastjson.a.parseObject(paramResponse);
      str1 = paramResponse.getString("status");
      String str2 = paramResponse.getString("code");
      if (("success".equals(str1)) && ("200".equals(str2)))
      {
        if (this.a == null) {
          return null;
        }
        return com.alibaba.fastjson.a.parseArray(paramResponse.getString("data"), this.a);
      }
      throw new com.ziroom.ziroomcustomer.e.b.a(str2, paramResponse.getString("message"));
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */