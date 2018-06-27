package com.ziroom.ziroomcustomer.e.c;

import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.util.k;
import com.ziroom.ziroomcustomer.util.u;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class c
  extends com.freelxl.baselibrary.d.f.a<b>
{
  protected b a(Response paramResponse)
    throws Exception
  {
    String str1 = paramResponse.body().string();
    d.d("GatewayJsonArrayParser", "=====url:" + paramResponse.request().url().toString());
    d.d("GatewayJsonArrayParser", "=====resp:" + str1);
    if (paramResponse.isSuccessful())
    {
      paramResponse = k.decrypt(str1);
      u.logBigData("GatewayJsonArrayParser", "=====respDecode:" + paramResponse);
      paramResponse = com.alibaba.fastjson.a.parseObject(paramResponse);
      str1 = paramResponse.getString("status");
      String str2 = paramResponse.getString("code");
      if (("success".equals(str1)) && ("200".equals(str2))) {
        return paramResponse.getJSONArray("data");
      }
      throw new com.ziroom.ziroomcustomer.e.b.a(str2, paramResponse.getString("message"));
    }
    d.d("GatewayJsonArrayParser", "===" + paramResponse.code());
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */