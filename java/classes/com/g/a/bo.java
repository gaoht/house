package com.g.a;

import java.util.Map;
import org.json.JSONObject;

public class bo
  extends br
{
  public bo(String paramString1, String paramString2)
  {
    a("domain", paramString1);
    a("name", paramString2);
  }
  
  public void setData(Map paramMap)
  {
    if (paramMap != null) {
      a("data", new JSONObject(paramMap));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */