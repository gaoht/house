package com.ziroom.ziroomcustomer.findhouse.b;

import com.freelxl.baselibrary.f.d;
import com.ziroom.commonlibrary.a.b;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class e<T>
  extends com.freelxl.baselibrary.d.f.a<T>
{
  private Class<T> a;
  
  public e(Class paramClass)
  {
    this.a = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful())
    {
      paramResponse = com.alibaba.fastjson.a.parseObject(paramResponse.body().string());
      if (paramResponse != null)
      {
        if ("success".equals(paramResponse.getString("status")))
        {
          if (this.a == null) {
            return null;
          }
          paramResponse = paramResponse.getString("data");
          d.d("findHouse", "JsonData = " + paramResponse);
          return (T)com.alibaba.fastjson.a.parseObject(paramResponse, this.a);
        }
        paramResponse = paramResponse.getString("error_message");
        d.e("findHouse", "Json Failure !!! " + paramResponse + "  " + this.a.getSimpleName());
        throw new b(-1, paramResponse);
      }
      d.e("findHouse", "Json is Null !!! " + this.a.getSimpleName());
      throw new b(0);
    }
    d.e("findHouse", "HttpException !!!" + this.a.getSimpleName());
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */