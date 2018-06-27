package com.ziroom.ziroomcustomer.newServiceList.utils;

import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.util.k;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class h<T>
  extends com.freelxl.baselibrary.d.f.a<T>
{
  private Class<T> a;
  
  public h(Class<T> paramClass)
  {
    this.a = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    if (paramResponse.isSuccessful())
    {
      d.d("ServiceModelParser", "=====url:" + paramResponse.request().url().toString());
      d.d("ServiceModelParser", "=====resp:" + str);
      d.d("ServiceModelParser", "=====resp:" + k.decrypt(str));
      return (T)com.alibaba.fastjson.a.parseObject(k.decrypt(str), this.a);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/utils/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */