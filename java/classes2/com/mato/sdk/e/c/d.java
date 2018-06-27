package com.mato.sdk.e.c;

import com.mato.sdk.d.c;
import com.mato.sdk.d.j.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static final int a = -1;
  private static final String b = "prefetchStartTime";
  private static final String c = "prefetchEndTime";
  private static final String d = "prefetchUrls";
  private static final String e = "effectStartTime";
  private static final String f = "cacheTime";
  private final long g;
  private final long h;
  private final long i;
  private final List<String> j;
  private final int k;
  
  private d(long paramLong1, long paramLong2, long paramLong3, int paramInt, List<String> paramList)
  {
    this.g = paramLong1;
    this.h = paramLong2;
    this.i = paramLong3;
    this.k = paramInt;
    this.j = paramList;
  }
  
  public static d a(JSONObject paramJSONObject)
  {
    long l1 = paramJSONObject.optLong("prefetchStartTime", -1L);
    long l2 = paramJSONObject.optLong("prefetchEndTime", -1L);
    long l3 = paramJSONObject.optLong("effectStartTime", -1L);
    int m = paramJSONObject.optInt("cacheTime", -1);
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("prefetchUrls");
    if (paramJSONObject != null) {
      a(localArrayList, paramJSONObject);
    }
    return new d(l1, l2, l3, m, localArrayList);
  }
  
  private static void a(List<String> paramList, JSONArray paramJSONArray)
  {
    int m = 0;
    for (;;)
    {
      if (m < paramJSONArray.length()) {}
      try
      {
        paramList.add(c.a(paramJSONArray.getString(m)));
        m += 1;
        continue;
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  public final long a()
  {
    return this.g;
  }
  
  public final long b()
  {
    return this.h;
  }
  
  public final long c()
  {
    return this.i;
  }
  
  public final List<String> d()
  {
    return this.j;
  }
  
  public final int e()
  {
    return this.k;
  }
  
  public final boolean f()
  {
    return (!j.a.a(this.j)) && (this.g != -1L) && (this.h != -1L) && (this.i != -1L) && (this.k != -1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */