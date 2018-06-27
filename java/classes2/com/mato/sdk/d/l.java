package com.mato.sdk.d;

import com.mato.sdk.b.g;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
{
  private static final String a = g.b("");
  private static int b = 0;
  private static int c = 1;
  private static final String g = "nodeList";
  private static final String h = "probeType";
  private static final String i = "probeUrlList";
  private List<String> d;
  private int e;
  private List<String> f;
  
  private l(List<String> paramList1, int paramInt, List<String> paramList2) {}
  
  public static l a(JSONObject paramJSONObject)
  {
    int m = 0;
    Object localObject = paramJSONObject.optJSONArray("nodeList");
    int j;
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      localObject = c.a((JSONArray)localObject);
      j = paramJSONObject.optInt("probeType", 0);
      paramJSONObject = paramJSONObject.optJSONArray("probeUrlList");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
        paramJSONObject = c.a(paramJSONObject);
      }
    }
    for (;;)
    {
      int k;
      if (localObject == null) {
        k = m;
      }
      while (k == 0)
      {
        return null;
        k = m;
        if (paramJSONObject != null)
        {
          k = m;
          if (!paramJSONObject.isEmpty()) {
            if (j != 0)
            {
              k = m;
              if (j != 1) {}
            }
            else
            {
              k = 1;
            }
          }
        }
      }
      return new l((List)localObject, j, paramJSONObject);
      paramJSONObject = null;
      continue;
      paramJSONObject = null;
      j = 0;
      localObject = null;
    }
  }
  
  private static boolean a(List<String> paramList1, int paramInt, List<String> paramList2)
  {
    if (paramList1 == null) {}
    while ((paramList2 == null) || (paramList2.isEmpty()) || ((paramInt != 0) && (paramInt != 1))) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */