package com.freelxl.baselibrary.d.f;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class d<T>
  extends a<T>
{
  protected Class<T> a;
  
  public d(Class<T> paramClass)
  {
    this.a = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    com.freelxl.baselibrary.f.d.d("ModelParser", "=====url:" + paramResponse.request().url().toString());
    com.freelxl.baselibrary.f.d.d("ModelParser", "=====resp:" + str);
    if (paramResponse.isSuccessful()) {
      return (T)com.alibaba.fastjson.a.parseObject(str, this.a);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */