package com.ziroom.ziroomcustomer.e.c;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.util.k;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class g
  extends com.freelxl.baselibrary.d.f.a<e>
{
  protected e a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    d.d("PhpServerModelParser", "=====respOri:" + str);
    str = k.decrypt(str);
    d.d("GatewayObjectParserDirectly", "=====url:" + paramResponse.request().url().toString());
    d.d("GatewayObjectParserDirectly", "=====resp:" + str);
    if (paramResponse.isSuccessful()) {
      return com.alibaba.fastjson.a.parseObject(str);
    }
    d.d("GatewayObjectParserDirectly", "===" + paramResponse.code());
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */