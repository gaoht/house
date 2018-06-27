package com.ziroom.commonlib.ziroomhttp.f;

import com.alibaba.fastjson.e;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class b
  extends a<e>
{
  protected e a(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful()) {
      return com.alibaba.fastjson.a.parseObject(paramResponse.body().string());
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/ziroomhttp/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */