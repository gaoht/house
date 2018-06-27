package com.ziroom.ziroomcustomer.minsu.c;

import java.util.HashMap;

public class b
{
  private static b a;
  private static final Object b = new Object();
  private HashMap<Integer, String> c = new HashMap(9);
  
  public static b getInstance()
  {
    if (a == null) {}
    synchronized (b)
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
  }
  
  public String getMonthTitle(int paramInt)
  {
    return (String)this.c.get(Integer.valueOf(paramInt));
  }
  
  public void initData(HashMap<Integer, String> paramHashMap)
  {
    this.c.clear();
    this.c.putAll(paramHashMap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */