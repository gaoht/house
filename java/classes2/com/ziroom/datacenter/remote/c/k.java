package com.ziroom.datacenter.remote.c;

import com.ziroom.commonlib.utils.l;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class k<T>
  extends com.ziroom.commonlib.ziroomhttp.f.a<T>
{
  protected Class<T> d;
  
  public k(Class<T> paramClass)
  {
    this.d = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    l.d("ModelParser", "=====url:" + paramResponse.request().url().toString());
    l.d("ModelParser", "=====resp:" + str);
    if (paramResponse.isSuccessful()) {
      return (T)com.alibaba.fastjson.a.parseObject(str, this.d);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */