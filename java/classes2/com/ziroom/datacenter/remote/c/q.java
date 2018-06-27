package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import com.ziroom.commonlib.ziroomhttp.d.b;
import com.ziroom.commonlib.ziroomhttp.f.c;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class q<T>
  extends c<T>
{
  public q(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  public T parseResponse(Response paramResponse)
    throws Exception
  {
    Object localObject = paramResponse.body().string();
    if (paramResponse.isSuccessful())
    {
      localObject = a.parseObject((String)localObject);
      if ("success".equals(((e)localObject).getString("status")))
      {
        if (this.c == null) {
          return null;
        }
        return (T)a.parseObject(((e)localObject).getString("data"), this.c);
      }
      ((e)localObject).getInteger("error_code").intValue();
      ((e)localObject).getString("error_message");
      throw new b(paramResponse.code());
    }
    throw new b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */