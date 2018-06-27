package com.ziroom.datacenter.remote.c;

import com.ziroom.commonlib.utils.g;
import com.ziroom.commonlib.utils.l;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class n<T>
  extends com.ziroom.commonlib.ziroomhttp.f.a<T>
{
  protected Class<T> c;
  
  public n(Class<T> paramClass)
  {
    this.c = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    String str = paramResponse.body().string();
    if (paramResponse.isSuccessful())
    {
      l.d("ModelWithDesParser", "=====url:" + paramResponse.request().url().toString());
      l.d("ModelWithDesParser", "=====resp:" + str);
      l.d("ModelWithDesParser", "=====resp:" + g.desDecrypt(str));
      return (T)com.alibaba.fastjson.a.parseObject(g.desDecrypt(str), this.c);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */