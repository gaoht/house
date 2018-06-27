package com.ziroom.ziroomcustomer.minsu.landlord.d;

import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.util.k;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class b<T>
  extends com.freelxl.baselibrary.d.f.d<T>
{
  public b(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  public T parseResponse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    com.freelxl.baselibrary.f.d.d("MinsuGatewayModelParser", "=====url:" + paramResponse.request().url().toString());
    com.freelxl.baselibrary.f.d.d("MinsuGatewayModelParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      paramResponse = k.decrypt(str);
      com.freelxl.baselibrary.f.d.d("MinsuGatewayJsonObjectParser", "=====respDecode:" + paramResponse);
      paramResponse = com.alibaba.fastjson.a.parseObject(paramResponse);
      if ("200".equals(paramResponse.getString("code")))
      {
        if (this.a == null) {
          return null;
        }
        return (T)com.alibaba.fastjson.a.parseObject(paramResponse.getString("data"), this.a);
      }
      throw new com.ziroom.ziroomcustomer.e.b.a(paramResponse.getString("code"), paramResponse.getString("message"));
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */