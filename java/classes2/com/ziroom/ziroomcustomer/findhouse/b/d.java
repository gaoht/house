package com.ziroom.ziroomcustomer.findhouse.b;

import com.alibaba.fastjson.e;
import com.ziroom.commonlibrary.a.b;
import java.util.List;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class d
  extends com.freelxl.baselibrary.d.f.a<List>
{
  private Class a;
  
  public d(Class paramClass)
  {
    this.a = paramClass;
  }
  
  protected List a(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful())
    {
      paramResponse = com.alibaba.fastjson.a.parseObject(paramResponse.body().string());
      if (paramResponse == null)
      {
        com.freelxl.baselibrary.f.d.e("findHouse", "Json is Null !!! " + this.a.getSimpleName());
        throw new b(0);
      }
      if ("success".equals(paramResponse.getString("status")))
      {
        if (this.a == null)
        {
          com.freelxl.baselibrary.f.d.e("findHouse", "Class is Null !!! " + this.a.getSimpleName());
          return null;
        }
        paramResponse = paramResponse.getString("data");
        com.freelxl.baselibrary.f.d.d("findHouse", "JsonData = " + paramResponse);
        return com.alibaba.fastjson.a.parseArray(paramResponse, this.a);
      }
      paramResponse = paramResponse.getString("error_message");
      com.freelxl.baselibrary.f.d.e("findHouse", "Json Failure !!! " + paramResponse + "  " + this.a.getSimpleName());
      throw new b(-1, paramResponse);
    }
    com.freelxl.baselibrary.f.d.e("findHouse", "httpException !!! " + this.a.getSimpleName());
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */