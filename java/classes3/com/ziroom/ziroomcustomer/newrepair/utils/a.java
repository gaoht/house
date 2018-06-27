package com.ziroom.ziroomcustomer.newrepair.utils;

import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.util.k;
import java.io.IOException;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class a<T>
  extends com.freelxl.baselibrary.d.f.d<l>
{
  private Class b;
  private boolean c;
  private String d;
  
  public a(Class paramClass, boolean paramBoolean)
  {
    this(paramClass, paramBoolean, null);
  }
  
  public a(Class paramClass, boolean paramBoolean, String paramString)
  {
    super(l.class);
    this.c = paramBoolean;
    this.b = paramClass;
    this.d = paramString;
  }
  
  protected l a(Response paramResponse)
    throws IOException
  {
    com.freelxl.baselibrary.f.d.d("HandlerParser", "=====url:" + paramResponse.request().url().toString());
    Object localObject = null;
    if (paramResponse.isSuccessful())
    {
      localObject = paramResponse.body().string();
      com.freelxl.baselibrary.f.d.d("internalRepair", "======= 接口返回--->" + (String)localObject);
    }
    l locall = new l();
    if (localObject == null) {
      throw new IOException();
    }
    paramResponse = (Response)localObject;
    if (this.c) {
      paramResponse = k.decrypt((String)localObject);
    }
    paramResponse = com.alibaba.fastjson.a.parseObject(paramResponse);
    localObject = paramResponse.get("status");
    localObject = localObject + "";
    if (("0".equals(localObject)) || ("success".equals(localObject)))
    {
      if (paramResponse.get("data") != null) {
        if (this.d != null) {
          break label212;
        }
      }
      label212:
      for (paramResponse = com.alibaba.fastjson.a.parseArray(paramResponse.get("data").toString(), this.b);; paramResponse = com.alibaba.fastjson.a.parseArray(com.alibaba.fastjson.a.parseObject(paramResponse.get("data").toString()).get(this.d).toString(), this.b))
      {
        locall.setObject(paramResponse);
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
    }
    locall.setSuccess(Boolean.valueOf(false));
    if (paramResponse.get("message") != null)
    {
      locall.setMessage((String)paramResponse.get("message"));
      return locall;
    }
    locall.setMessage("请求数据失败！");
    return locall;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */