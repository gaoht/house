package com.ziroom.ziroomcustomer.minsu.landlord.d;

import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.util.k;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class c<T>
  extends com.freelxl.baselibrary.d.f.d<T>
{
  public c(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  public T parseResponse(Response paramResponse)
    throws Exception
  {
    Object localObject = paramResponse.body().string();
    com.freelxl.baselibrary.f.d.d("MinsuGatewayModelParser", "=====url:" + paramResponse.request().url().toString());
    com.freelxl.baselibrary.f.d.d("MinsuGatewayModelParser", "=====resp:" + (String)localObject);
    if (paramResponse.isSuccessful())
    {
      paramResponse = k.decrypt((String)localObject);
      com.freelxl.baselibrary.f.d.d("MinsuGatewayJsonObjectParser", "=====respDecode:" + paramResponse);
      localObject = com.alibaba.fastjson.a.parseObject(paramResponse);
      if ("200".equals(((e)localObject).getString("code")))
      {
        if (this.a == null) {
          return null;
        }
        return (T)com.alibaba.fastjson.a.parseObject(paramResponse, this.a);
      }
      throw new com.ziroom.ziroomcustomer.e.b.a(((e)localObject).getString("code"), ((e)localObject).getString("message"));
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */