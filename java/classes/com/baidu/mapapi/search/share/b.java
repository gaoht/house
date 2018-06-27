package com.baidu.mapapi.search.share;

import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  public static ShareUrlResult a(String paramString)
  {
    ShareUrlResult localShareUrlResult = new ShareUrlResult();
    if (paramString == null) {
      localShareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
    for (;;)
    {
      return localShareUrlResult;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString != null)
        {
          localShareUrlResult.a(paramString.optString("url"));
          localShareUrlResult.a(paramString.optInt("type"));
          return localShareUrlResult;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localShareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
    }
    return localShareUrlResult;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/share/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */