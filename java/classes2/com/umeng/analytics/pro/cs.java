package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class cs
  implements Serializable
{
  private static Map<Class<? extends cg>, Map<? extends cn, cs>> d = new HashMap();
  public final String a;
  public final byte b;
  public final ct c;
  
  public cs(String paramString, byte paramByte, ct paramct)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramct;
  }
  
  public static Map<? extends cn, cs> a(Class<? extends cg> paramClass)
  {
    if (!d.containsKey(paramClass)) {}
    try
    {
      paramClass.newInstance();
      return (Map)d.get(paramClass);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("InstantiationException for TBase class: " + paramClass.getName() + ", message: " + localInstantiationException.getMessage());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("IllegalAccessException for TBase class: " + paramClass.getName() + ", message: " + localIllegalAccessException.getMessage());
    }
  }
  
  public static void a(Class<? extends cg> paramClass, Map<? extends cn, cs> paramMap)
  {
    d.put(paramClass, paramMap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */