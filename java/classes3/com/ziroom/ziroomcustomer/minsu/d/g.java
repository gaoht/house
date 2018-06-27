package com.ziroom.ziroomcustomer.minsu.d;

import java.util.HashMap;
import java.util.Map;

public class g
{
  public static final Map<String, Object> a = new HashMap();
  
  public static Object get(String paramString)
  {
    return a.remove(paramString);
  }
  
  public static void put(String paramString, Object paramObject)
  {
    a.put(paramString, paramObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */