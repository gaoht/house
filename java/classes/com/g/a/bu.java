package com.g.a;

import org.json.JSONArray;

public class bu
  extends br
{
  public bu()
  {
    a("manufacture", n.b());
    a("brand", n.c());
    a("model", n.d());
    JSONArray localJSONArray = new JSONArray();
    Object localObject = n.k();
    int i = 0;
    while (i < localObject.length)
    {
      localJSONArray.put(localObject[i]);
      i += 1;
    }
    a("cpuInfo", localJSONArray);
    new JSONArray();
    localJSONArray = new JSONArray();
    localObject = n.m();
    i = j;
    while (i < localObject.length)
    {
      localJSONArray.put(localObject[i]);
      i += 1;
    }
    a("memoryInfo", localJSONArray);
    n.a(c.e, this.b);
    a("totalDiskSpace", Integer.valueOf(a()));
  }
  
  private int a()
  {
    try
    {
      int[] arrayOfInt = n.n();
      int i = arrayOfInt[0];
      int j = arrayOfInt[2];
      return j + i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public void setSlots(int paramInt)
  {
    a("slots", Integer.valueOf(paramInt));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */