package com.ziroom.ziroomcustomer.newrepair.utils;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.e.l;
import java.io.IOException;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class b<T>
  extends com.freelxl.baselibrary.d.f.d<l>
{
  private Class<T> b;
  
  public b(Class paramClass)
  {
    super(paramClass);
    this.b = paramClass;
  }
  
  protected l a(Response paramResponse)
    throws IOException
  {
    Object localObject = null;
    com.freelxl.baselibrary.f.d.d("ModelHandlerParser", "=====url:" + paramResponse.request().url().toString());
    l locall = new l();
    if (paramResponse.isSuccessful())
    {
      paramResponse = paramResponse.body().string();
      com.freelxl.baselibrary.f.d.d("internalRepair", "=======  接口返回--->" + paramResponse);
    }
    for (;;)
    {
      if (paramResponse == null) {
        throw new IOException();
      }
      e locale = a.parseObject(paramResponse);
      paramResponse = locale.get("status");
      paramResponse = paramResponse + "";
      if (("0".equals(paramResponse)) || ("success".equals(paramResponse)))
      {
        if (locale.get("data") != null)
        {
          paramResponse = (Response)localObject;
          if (this.b != null) {
            paramResponse = a.parseObject(locale.get("data").toString(), this.b);
          }
          locall.setObject(paramResponse);
        }
        if (locale.get("message") != null) {
          locall.setMessage((String)locale.get("message"));
        }
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (locale.get("message") != null)
      {
        locall.setMessage((String)locale.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
      paramResponse = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */