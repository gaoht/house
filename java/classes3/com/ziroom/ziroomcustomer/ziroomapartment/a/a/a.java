package com.ziroom.ziroomcustomer.ziroomapartment.a.a;

import com.alibaba.fastjson.e;
import com.ziroom.commonlibrary.a.b;
import com.ziroom.ziroomcustomer.util.u;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class a
  extends com.freelxl.baselibrary.d.f.a<e>
{
  protected e a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    u.d("ZryuServerJsonObjectParser", "=====url:" + paramResponse.request().url().toString());
    u.logBigData("ZryuServerJsonObjectParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      paramResponse = com.alibaba.fastjson.a.parseObject(str);
      if ("success".equals(paramResponse.getString("status"))) {
        return paramResponse.getJSONObject("data");
      }
      throw new b(paramResponse.getInteger("error_code").intValue(), paramResponse.getString("error_message"));
    }
    u.d("ZryuServerJsonObjectParser", "===" + paramResponse.code());
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */