package com.ziroom.ziroomcustomer.e.c;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.util.k;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class w
  extends com.freelxl.baselibrary.d.f.a<List<String>>
{
  protected List<String> a(Response paramResponse)
    throws Exception
  {
    String str = k.decrypt(paramResponse.body().string());
    d.d("ServiceUploadImageParser", "=====url:" + paramResponse.request().url().toString());
    d.d("ServiceUploadImageParser", "=====resp:" + str);
    if (paramResponse.isSuccessful())
    {
      paramResponse = com.alibaba.fastjson.a.parseObject(str);
      str = paramResponse.getString("status");
      if (("0".equals(str)) || ("success".equals(str))) {
        return com.alibaba.fastjson.b.parseArray(paramResponse.getString("data"), String.class);
      }
      throw new com.ziroom.commonlibrary.a.b(0, paramResponse.getString("message"));
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */