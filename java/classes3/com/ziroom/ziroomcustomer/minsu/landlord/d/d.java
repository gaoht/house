package com.ziroom.ziroomcustomer.minsu.landlord.d;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.a.c;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.commonlibrary.a.b;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class d<T>
  extends com.freelxl.baselibrary.d.f.d<T>
{
  private Class<T> b;
  
  public d(Class paramClass)
  {
    super(paramClass);
    this.b = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful())
    {
      String str = paramResponse.body().string();
      paramResponse = null;
      try
      {
        str = c.createEncryption("DES").decrypt(str, SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
        paramResponse = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      paramResponse = com.alibaba.fastjson.a.parseObject(paramResponse);
      if ("0".equals(paramResponse.getString("status"))) {
        return (T)com.alibaba.fastjson.a.parseObject(paramResponse.getString("data"), this.b);
      }
      throw new b(0, paramResponse.getString("message"));
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */