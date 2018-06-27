package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.e;
import com.ziroom.commonlib.utils.g;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.c;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class w
  extends com.ziroom.commonlib.ziroomhttp.f.a<List<String>>
{
  protected List<String> a(Response paramResponse)
    throws Exception
  {
    String str = g.desDecrypt(paramResponse.body().string());
    l.d("ServiceUploadImageParser", "=====url:" + paramResponse.request().url().toString());
    l.d("ServiceUploadImageParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      paramResponse = com.alibaba.fastjson.a.parseObject(str);
      str = paramResponse.getString("status");
      if (("0".equals(str)) || ("success".equals(str))) {
        return com.alibaba.fastjson.b.parseArray(paramResponse.getString("data"), String.class);
      }
      throw new c(0, paramResponse.getString("message"));
    }
    throw new com.ziroom.commonlib.ziroomhttp.d.b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */