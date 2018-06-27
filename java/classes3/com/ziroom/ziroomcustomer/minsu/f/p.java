package com.ziroom.ziroomcustomer.minsu.f;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.a.c;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.commonlibrary.a.b;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class p<T>
  extends com.freelxl.baselibrary.d.f.d<T>
{
  private Class<T> b;
  private final String c = getClass().getSimpleName();
  
  public p(Class paramClass)
  {
    super(paramClass);
    this.b = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful()) {}
    label131:
    label169:
    label194:
    for (String str = paramResponse.body().string();; str = null)
    {
      for (;;)
      {
        try
        {
          com.freelxl.baselibrary.f.a.d locald = c.createEncryption("DES");
          if (locald == null) {
            break label194;
          }
          str = locald.decrypt(str, SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
          paramResponse.printStackTrace();
        }
        catch (Exception paramResponse)
        {
          try
          {
            com.freelxl.baselibrary.f.d.e(this.c, paramResponse.request().url() + "  接口返回====" + str);
            paramResponse = com.alibaba.fastjson.a.parseObject(str);
            if (paramResponse == null) {
              break label169;
            }
            if (!"0".equals(paramResponse.getString("status"))) {
              break label131;
            }
            if (this.b != null) {
              break;
            }
            return null;
          }
          catch (Exception paramResponse)
          {
            for (;;) {}
          }
          paramResponse = paramResponse;
          str = null;
        }
      }
      return (T)com.alibaba.fastjson.a.parseObject(paramResponse.getString("data"), this.b);
      if ("-1".equals(paramResponse.getString("status"))) {
        throw new b(-1);
      }
      throw new b(0, paramResponse.getString("message"));
      throw new b(0);
      throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */