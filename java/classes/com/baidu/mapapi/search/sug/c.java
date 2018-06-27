package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public static SuggestionResult a(String paramString)
  {
    localSuggestionResult = new SuggestionResult();
    if ((paramString == null) || (paramString.equals(""))) {
      localSuggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
    for (;;)
    {
      return localSuggestionResult;
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optJSONArray("cityname");
        JSONArray localJSONArray1 = ((JSONObject)localObject).optJSONArray("poiname");
        JSONArray localJSONArray2 = ((JSONObject)localObject).optJSONArray("districtname");
        JSONArray localJSONArray3 = ((JSONObject)localObject).optJSONArray("pt");
        localObject = ((JSONObject)localObject).optJSONArray("poiid");
        if ((localJSONArray1 == null) || (localJSONArray1.length() <= 0)) {
          continue;
        }
        ArrayList localArrayList = new ArrayList();
        localSuggestionResult.a(localArrayList);
        int j = localJSONArray1.length();
        int i = 0;
        while (i < j)
        {
          SuggestionResult.SuggestionInfo localSuggestionInfo = new SuggestionResult.SuggestionInfo();
          if (paramString != null) {
            localSuggestionInfo.city = paramString.optString(i);
          }
          if (localJSONArray1 != null) {
            localSuggestionInfo.key = localJSONArray1.optString(i);
          }
          if (localJSONArray2 != null) {
            localSuggestionInfo.district = localJSONArray2.optString(i);
          }
          JSONObject localJSONObject = localJSONArray3.optJSONObject(i);
          if ((localJSONObject.has("x")) && (localJSONObject.has("y")))
          {
            GeoPoint localGeoPoint = new GeoPoint(0.0D, 0.0D);
            localGeoPoint.setLongitudeE6((int)localJSONObject.optDouble("x"));
            localGeoPoint.setLatitudeE6((int)localJSONObject.optDouble("y"));
            localSuggestionInfo.pt = CoordUtil.mc2ll(localGeoPoint);
          }
          if (localObject != null) {
            localSuggestionInfo.uid = ((JSONArray)localObject).optString(i);
          }
          localArrayList.add(localSuggestionInfo);
          i += 1;
        }
        return localSuggestionResult;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localSuggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/sug/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */