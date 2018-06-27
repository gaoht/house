package com.ziroom.ziroomcustomer.pay.common.b;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class b<T>
  extends com.freelxl.baselibrary.d.f.a<T>
{
  protected Class<T> a;
  
  public b(Class<T> paramClass)
  {
    this.a = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful())
    {
      paramResponse = paramResponse.body().string();
      d.e("yangxj++++++++++++++++++", paramResponse);
      e locale = e.parseObject(paramResponse);
      if (locale != null)
      {
        if (locale.get("status").toString().equals("success")) {
          return (T)com.alibaba.fastjson.a.parseObject(paramResponse, this.a);
        }
        throw new com.ziroom.commonlibrary.a.b(0, locale.get("error_message").toString());
      }
      throw new com.ziroom.commonlibrary.a.b(0);
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/common/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */