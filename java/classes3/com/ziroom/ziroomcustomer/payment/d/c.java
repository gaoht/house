package com.ziroom.ziroomcustomer.payment.d;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.ziroom.commonlibrary.a.b;
import java.util.List;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class c<T>
  extends com.freelxl.baselibrary.d.f.a<List<T>>
{
  protected Class<T> a;
  
  public c(Class<T> paramClass)
  {
    this.a = paramClass;
  }
  
  protected List<T> a(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful())
    {
      paramResponse = paramResponse.body().string();
      d.e("yangxj++++++++++++++++++", paramResponse);
      paramResponse = e.parseObject(paramResponse);
      if (paramResponse != null)
      {
        if ("0".equals(paramResponse.get("code").toString())) {
          return com.alibaba.fastjson.a.parseArray(paramResponse.getString("data"), this.a);
        }
        throw new b(0, paramResponse.get("message").toString());
      }
      throw new b(0);
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */