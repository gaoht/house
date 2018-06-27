package com.ziroom.ziroomcustomer.e.c;

import com.alibaba.fastjson.e;
import com.ziroom.commonlibrary.a.b;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class a<T>
  extends com.freelxl.baselibrary.d.f.d<T>
{
  public a(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  public T parseResponse(Response paramResponse)
    throws Exception
  {
    Object localObject = paramResponse.body().string();
    com.freelxl.baselibrary.f.d.d("CrmModelParser", "=====url:" + paramResponse.request().url().toString());
    com.freelxl.baselibrary.f.d.d("CrmModelParser", "=====resp:" + (String)localObject);
    if (paramResponse.isSuccessful())
    {
      localObject = com.alibaba.fastjson.a.parseObject((String)localObject);
      String str = ((e)localObject).getString("status");
      paramResponse = ((e)localObject).getInteger("error_code");
      if ("success".equals(str))
      {
        if (this.a == null) {
          return null;
        }
        return (T)com.alibaba.fastjson.a.parseObject(((e)localObject).getString("data"), this.a);
      }
      localObject = ((e)localObject).getString("error_message");
      throw new b(paramResponse.intValue(), (String)localObject);
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */