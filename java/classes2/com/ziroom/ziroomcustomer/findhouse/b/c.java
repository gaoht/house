package com.ziroom.ziroomcustomer.findhouse.b;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class c
  extends com.freelxl.baselibrary.d.f.a<e>
{
  protected e a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    d.d("FindHouseNullParser", "=====url:" + paramResponse.request().url().toString());
    d.d("FindHouseNullParser", "=====resp:" + str);
    if (paramResponse.isSuccessful()) {
      return com.alibaba.fastjson.a.parseObject(str);
    }
    d.d("FindHouseNullParser", "===" + paramResponse.code());
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */