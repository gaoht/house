package com.ziroom.ziroomcustomer.e.c;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.ziroom.commonlibrary.a.b;
import com.ziroom.ziroomcustomer.util.k;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class h
  extends com.freelxl.baselibrary.d.f.a<e>
{
  protected e a(Response paramResponse)
    throws Exception
  {
    String str1 = paramResponse.body().string();
    d.d("PhpServerModelParser", "=====respOri:" + str1);
    str1 = k.decrypt(str1);
    d.d("PhpServerModelParser", "=====url:" + paramResponse.request().url().toString());
    d.d("PhpServerModelParser", "=====resp:" + str1);
    if (paramResponse.isSuccessful())
    {
      paramResponse = com.alibaba.fastjson.a.parseObject(str1);
      str1 = paramResponse.getString("status");
      String str2 = paramResponse.getString("code");
      if (("success".equals(str1)) && ("200".equals(str2))) {
        return paramResponse.getJSONObject("data");
      }
      throw new b(paramResponse.getInteger("code").intValue(), paramResponse.getString("message"));
    }
    d.d("PhpServerJsonObjectParser", "===" + paramResponse.code());
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */