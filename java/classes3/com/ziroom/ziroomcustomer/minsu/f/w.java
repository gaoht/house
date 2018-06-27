package com.ziroom.ziroomcustomer.minsu.f;

import com.freelxl.baselibrary.f.a.c;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.commonlibrary.a.b;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class w
  extends com.freelxl.baselibrary.d.f.e
{
  private final String a = getClass().getSimpleName();
  
  protected String a(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful()) {}
    label148:
    label173:
    for (String str = paramResponse.body().string();; str = null)
    {
      for (;;)
      {
        try
        {
          com.freelxl.baselibrary.f.a.d locald = c.createEncryption("DES");
          if (locald == null) {
            break label173;
          }
          str = locald.decrypt(str, SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
          paramResponse.printStackTrace();
        }
        catch (Exception paramResponse)
        {
          try
          {
            com.freelxl.baselibrary.f.d.i(this.a, paramResponse.request().url() + "  接口返回====" + str);
            paramResponse = com.alibaba.fastjson.a.parseObject(str);
            if (paramResponse == null) {
              break label148;
            }
            if (!"0".equals(paramResponse.getString("status"))) {
              break;
            }
            return str;
          }
          catch (Exception paramResponse)
          {
            for (;;) {}
          }
          paramResponse = paramResponse;
          str = null;
        }
      }
      if ("-1".equals(paramResponse.getString("status"))) {
        throw new b(-1);
      }
      throw new b(0, paramResponse.getString("message"));
      throw new b(0);
      throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */