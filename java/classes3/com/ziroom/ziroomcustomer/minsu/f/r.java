package com.ziroom.ziroomcustomer.minsu.f;

import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.f.a.c;
import com.ziroom.commonlib.utils.SignKeyUtil;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class r<T>
  extends com.freelxl.baselibrary.d.f.d<T>
{
  private Class<T> b;
  private final String c = getClass().getSimpleName();
  
  public r(Class paramClass)
  {
    super(paramClass);
    this.b = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws IOException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramResponse.isSuccessful())
    {
      localObject1 = paramResponse.body().string();
      paramResponse = (Response)localObject2;
    }
    try
    {
      localObject1 = c.createEncryption("DES").decrypt((String)localObject1, SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
      paramResponse = (Response)localObject1;
      com.freelxl.baselibrary.f.d.logBigData(this.c, "---------MinsuModelParser------------ " + (String)localObject1);
      paramResponse = (Response)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    localObject1 = a.parseObject(paramResponse, this.b);
    return (T)localObject1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */