package com.megvii.zhimasdk.a;

import java.util.HashMap;
import java.util.Map;

public class a
{
  Map<String, Object> a = new HashMap();
  
  public a()
  {
    this.a.put("__time__", Integer.valueOf(new Long(System.currentTimeMillis() / 1000L).intValue()));
  }
  
  public Map<String, Object> a()
  {
    return this.a;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.isEmpty())) {
      return;
    }
    if (paramString2 == null)
    {
      this.a.put(paramString1, "");
      return;
    }
    this.a.put(paramString1, paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */