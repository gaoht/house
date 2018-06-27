package com.ziroom.ziroomcustomer.base.update;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.util.k;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class UpdateParser<T>
  extends com.freelxl.baselibrary.d.f.a<T>
{
  protected Class<T> clazz;
  
  public UpdateParser(Class<T> paramClass)
  {
    this.clazz = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    d.d("GatewayModelParser", "=====url:" + paramResponse.request().url().toString());
    d.d("GatewayModelParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      paramResponse = k.decrypt(str);
      d.d("GatewayJsonObjectParser", "=====respDecode:" + paramResponse);
      paramResponse = com.alibaba.fastjson.a.parseObject(paramResponse);
      if ("200".equals(paramResponse.getString("code")))
      {
        if ((this.clazz == null) || (paramResponse.getString("data") == null)) {
          return null;
        }
        return (T)com.alibaba.fastjson.a.parseObject(paramResponse.getString("data"), this.clazz);
      }
      throw new com.ziroom.ziroomcustomer.e.b.a(paramResponse.getString("code"), paramResponse.getString("message"));
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/base/update/UpdateParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */