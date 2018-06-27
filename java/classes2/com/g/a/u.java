package com.g.a;

import java.util.Comparator;
import org.json.JSONObject;

final class u
  implements Comparator
{
  public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    try
    {
      int i = paramJSONObject2.getInt("level");
      int j = paramJSONObject1.getInt("level");
      return i - j;
    }
    catch (Throwable paramJSONObject1) {}
    return 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/g/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */