package com.ziroom.ziroomcustomer.e.c;

import com.freelxl.baselibrary.f.d;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class s
  extends com.freelxl.baselibrary.d.f.a<String>
{
  protected String a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    d.d("ServerStringParser", "=====url:" + paramResponse.request().url().toString());
    d.d("ServerStringParser", "=====resp:" + str);
    if (paramResponse.isSuccessful()) {
      return str;
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */