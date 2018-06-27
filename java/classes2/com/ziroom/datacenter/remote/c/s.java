package com.ziroom.datacenter.remote.c;

import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import com.ziroom.commonlib.ziroomhttp.f.a;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class s
  extends a<String>
{
  protected String a(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    l.d("ServerStringParser", "=====url:" + paramResponse.request().url().toString());
    l.d("ServerStringParser", "=====resp:" + str);
    if (paramResponse.isSuccessful()) {
      return str;
    }
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */