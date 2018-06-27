package com.ziroom.commonlib.ziroomhttp.f;

import com.ziroom.commonlib.utils.l;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class c<T>
  extends a<T>
{
  protected Class<T> c;
  
  public c(Class<T> paramClass)
  {
    this.c = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    l.d("ModelParser", "=====url:" + paramResponse.request().url().toString());
    l.d("ModelParser", "=====resp:" + str);
    if (paramResponse.isSuccessful()) {
      return (T)com.alibaba.fastjson.a.parseObject(str, this.c);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/ziroomhttp/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */