package com.alipay.android.a.a.a.a;

import com.alipay.a.a.e;
import com.alipay.android.a.a.a.b;
import java.lang.reflect.Type;
import org.json.JSONObject;

public final class d
  extends a
{
  public d(Type paramType, byte[] paramArrayOfByte)
  {
    super(paramType, paramArrayOfByte);
  }
  
  public final Object a()
  {
    try
    {
      Object localObject1 = new String(this.b);
      new StringBuilder("threadid = ").append(Thread.currentThread().getId()).append("; rpc response:  ").append((String)localObject1);
      localObject1 = new JSONObject((String)localObject1);
      int i = ((JSONObject)localObject1).getInt("resultStatus");
      if (i != 1000) {
        throw new b(Integer.valueOf(i), ((JSONObject)localObject1).optString("tips"));
      }
    }
    catch (Exception localException)
    {
      if ("response  =" + new String(this.b) + ":" + localException != null) {}
    }
    for (Object localObject2 = "";; localObject2 = ((Exception)localObject2).getMessage())
    {
      throw new b(Integer.valueOf(10), (String)localObject2);
      if (this.a == String.class) {
        return ((JSONObject)localObject2).optString("result");
      }
      localObject2 = e.a(((JSONObject)localObject2).optString("result"), this.a);
      return localObject2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/android/a/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */