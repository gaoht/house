package com.ziroom.datacenter.remote.c;

import com.ziroom.commonlib.utils.g;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.d.b;
import com.ziroom.commonlib.ziroomhttp.d.c;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class a<T>
  extends k<List<T>>
{
  private Class c;
  private boolean e;
  private String f;
  
  public a(Class paramClass)
  {
    this(paramClass, false, null);
  }
  
  public a(Class paramClass, boolean paramBoolean)
  {
    this(paramClass, paramBoolean, null);
  }
  
  public a(Class paramClass, boolean paramBoolean, String paramString)
  {
    super(paramClass);
    this.e = paramBoolean;
    this.c = paramClass;
    this.f = paramString;
  }
  
  protected List<T> a(Response paramResponse)
    throws Exception
  {
    l.d("HandlerParser", "=====url:" + paramResponse.request().url().toString());
    Object localObject1;
    if (paramResponse.isSuccessful())
    {
      localObject1 = paramResponse.body().string();
      l.d("internalRepair", "======= 接口返回--->" + (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null) {
        throw new IOException();
      }
      Object localObject2 = localObject1;
      if (this.e) {
        localObject2 = g.desDecrypt((String)localObject1);
      }
      localObject1 = com.alibaba.fastjson.a.parseObject((String)localObject2);
      localObject2 = ((Map)localObject1).get("status");
      localObject2 = localObject2 + "";
      if (("0".equals(localObject2)) || ("success".equals(localObject2)))
      {
        if (((Map)localObject1).get("data") != null)
        {
          if (this.c == null) {
            return null;
          }
          if (this.f == null) {
            return com.alibaba.fastjson.a.parseArray(((Map)localObject1).get("data").toString(), this.c);
          }
          return com.alibaba.fastjson.a.parseArray(com.alibaba.fastjson.a.parseObject(((Map)localObject1).get("data").toString()).get(this.f).toString(), this.c);
        }
        if (((Map)localObject1).get("message") != null) {
          throw new c(0, ((Map)localObject1).get("message").toString());
        }
        throw new c(0, "请求数据失败");
      }
      throw new b(paramResponse.code());
      localObject1 = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */