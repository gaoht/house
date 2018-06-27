package com.ziroom.datacenter.remote.c;

import com.alibaba.fastjson.m;
import com.alibaba.fastjson.parser.Feature;
import com.ziroom.commonlib.utils.g;
import java.lang.reflect.Type;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class f<T>
  extends com.ziroom.commonlib.ziroomhttp.f.a<T>
{
  private m c;
  private Class d;
  
  public f() {}
  
  public f(m paramm)
  {
    this.c = paramm;
  }
  
  public f(Class paramClass)
  {
    this.d = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    String str1 = paramResponse.body().string();
    if (paramResponse.isSuccessful())
    {
      paramResponse = g.desDecrypt(str1);
      if (this.d != null) {
        paramResponse = (com.ziroom.datacenter.remote.responsebody.b)com.alibaba.fastjson.a.parseObject(paramResponse, new m(new Type[] { this.d }) {}, new Feature[0]);
      }
      String str2;
      for (;;)
      {
        str1 = paramResponse.getStatus();
        str2 = paramResponse.getCode();
        if ((!"success".equals(str1)) || (!"200".equals(str2))) {
          break;
        }
        return (T)paramResponse.getData();
        if (this.c != null) {
          paramResponse = (com.ziroom.datacenter.remote.responsebody.b)com.alibaba.fastjson.a.parseObject(paramResponse, this.c, new Feature[0]);
        } else {
          paramResponse = (com.ziroom.datacenter.remote.responsebody.b)com.alibaba.fastjson.a.parseObject(paramResponse, com.ziroom.datacenter.remote.responsebody.b.class);
        }
      }
      throw new com.ziroom.commonlib.ziroomhttp.d.a(str2, paramResponse.getMessage());
    }
    throw new com.ziroom.commonlib.ziroomhttp.d.b(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */