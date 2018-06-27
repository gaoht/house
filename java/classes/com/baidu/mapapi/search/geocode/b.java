package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static ReverseGeoCodeResult.AddressComponent a(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || ("".equals(paramString))) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.optJSONObject(paramString);
    } while (paramJSONObject == null);
    paramString = new ReverseGeoCodeResult.AddressComponent();
    paramString.city = paramJSONObject.optString("city");
    paramString.district = paramJSONObject.optString("district");
    paramString.province = paramJSONObject.optString("province");
    paramString.street = paramJSONObject.optString("street");
    paramString.streetNumber = paramJSONObject.optString("street_number");
    return paramString;
  }
  
  public static ReverseGeoCodeResult a(String paramString)
  {
    ReverseGeoCodeResult localReverseGeoCodeResult = new ReverseGeoCodeResult();
    if ((paramString == null) || ("".equals(paramString)))
    {
      localReverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localReverseGeoCodeResult;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localReverseGeoCodeResult.b(paramString.optString("address"));
      localReverseGeoCodeResult.a(paramString.optString("business"));
      localReverseGeoCodeResult.a(a(paramString, "addr_detail"));
      localReverseGeoCodeResult.a(b(paramString, "point"));
      localReverseGeoCodeResult.a(c(paramString, "surround_poi"));
      return localReverseGeoCodeResult;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      localReverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
    return localReverseGeoCodeResult;
  }
  
  private static LatLng b(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || ("".equals(paramString))) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.optJSONObject(paramString);
    } while (paramJSONObject == null);
    int i = paramJSONObject.optInt("x");
    return CoordUtil.mc2ll(new GeoPoint(paramJSONObject.optInt("y"), i));
  }
  
  public static GeoCodeResult b(String paramString)
  {
    GeoCodeResult localGeoCodeResult = new GeoCodeResult();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.optInt("error") != 0)
      {
        localGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localGeoCodeResult;
      }
      localGeoCodeResult.a(CoordUtil.mc2ll(new GeoPoint(paramString.optInt("y"), paramString.optInt("x"))));
      localGeoCodeResult.setAddress(paramString.optString("addr"));
      return localGeoCodeResult;
    }
    catch (JSONException paramString)
    {
      localGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      paramString.printStackTrace();
    }
    return localGeoCodeResult;
  }
  
  private static List<PoiInfo> c(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || ("".equals(paramString))) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.optJSONArray(paramString);
    } while (paramJSONObject == null);
    paramString = new ArrayList();
    int i = 0;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      if (localJSONObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        PoiInfo localPoiInfo = new PoiInfo();
        localPoiInfo.address = localJSONObject.optString("addr");
        localPoiInfo.phoneNum = localJSONObject.optString("tel");
        localPoiInfo.uid = localJSONObject.optString("uid");
        localPoiInfo.postCode = localJSONObject.optString("zip");
        localPoiInfo.name = localJSONObject.optString("name");
        localPoiInfo.location = b(localJSONObject, "point");
        paramString.add(localPoiInfo);
      }
    }
    return paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/geocode/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */