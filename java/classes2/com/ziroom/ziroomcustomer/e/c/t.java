package com.ziroom.ziroomcustomer.e.c;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.ziroom.commonlibrary.a.b;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class t
  extends com.freelxl.baselibrary.d.f.a<e>
{
  protected e a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    d.d("ServiceJsonObjectParser", "=====url:" + paramResponse.request().url().toString());
    d.d("ServiceJsonObjectParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      paramResponse = com.alibaba.fastjson.a.parseObject(str);
      if (1 == paramResponse.getInteger("status").intValue()) {
        return paramResponse.getJSONObject("data");
      }
      throw new b(0, paramResponse.getString("message"));
    }
    d.d("ServiceJsonObjectParser", "===" + paramResponse.code());
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */