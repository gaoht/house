package com.ziroom.ziroomcustomer.newServiceList.utils;

import okhttp3.Response;
import okhttp3.ResponseBody;

public class d<T>
  extends com.freelxl.baselibrary.d.f.a<T>
{
  private Class<T> a;
  
  public d(Class<T> paramClass)
  {
    this.a = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful()) {
      return (T)com.alibaba.fastjson.a.parseObject(paramResponse.body().string(), this.a);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */