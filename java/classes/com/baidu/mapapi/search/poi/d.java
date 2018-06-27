package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.PoiInfo.POITYPE;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class d
{
  public static PoiResult a(String paramString)
  {
    PoiResult localPoiResult = new PoiResult();
    if ((paramString == null) || ("".equals(paramString)))
    {
      localPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localPoiResult;
    }
    ArrayList localArrayList;
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        paramString = new JSONObject(paramString);
        paramString = paramString.optJSONArray("citys");
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label179;
        }
        localArrayList = new ArrayList();
        int i = 0;
        if (i >= paramString.length()) {
          break;
        }
        localJSONObject = (JSONObject)paramString.opt(i);
        if (localJSONObject == null)
        {
          i += 1;
          continue;
        }
        localCityInfo = new CityInfo();
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localPoiResult;
      }
      CityInfo localCityInfo;
      localCityInfo.num = localJSONObject.optInt("num");
      localCityInfo.city = localJSONObject.optString("name");
      localArrayList.add(localCityInfo);
    }
    if (localArrayList.size() > 0) {
      localPoiResult.c(localArrayList);
    }
    localPoiResult.error = SearchResult.ERRORNO.AMBIGUOUS_KEYWORD;
    return localPoiResult;
    label179:
    localPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return localPoiResult;
  }
  
  public static PoiResult a(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    PoiResult localPoiResult = new PoiResult();
    if ((paramString == null) || (paramString.equals("")))
    {
      localPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localPoiResult;
    }
    int k;
    int j;
    try
    {
      localObject1 = new JSONObject(paramString);
      k = ((JSONObject)localObject1).optInt("total");
      j = ((JSONObject)localObject1).optInt("count");
      if (j == 0)
      {
        localPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localPoiResult;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      localPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localPoiResult;
    }
    localPoiResult.b(k);
    localPoiResult.d(k);
    localPoiResult.c(j);
    localPoiResult.a(paramInt1);
    if (j != 0)
    {
      j = k / paramInt2;
      if (k % paramInt2 <= 0) {
        break label238;
      }
    }
    Object localObject2;
    Object localObject3;
    JSONObject localJSONObject1;
    PoiInfo localPoiInfo;
    label238:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localPoiResult.b(paramInt1 + j);
      localObject2 = ((JSONObject)localObject1).optJSONObject("current_city");
      paramString = null;
      if (localObject2 != null) {
        paramString = ((JSONObject)localObject2).optString("name");
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("pois");
      localObject3 = new ArrayList();
      if (localObject2 == null) {
        break label432;
      }
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= ((JSONArray)localObject2).length()) {
          break label432;
        }
        localJSONObject1 = ((JSONArray)localObject2).optJSONObject(paramInt1);
        localPoiInfo = new PoiInfo();
        if (localJSONObject1 != null) {
          break;
        }
        paramInt1 += 1;
      }
    }
    localPoiInfo.name = localJSONObject1.optString("name");
    localPoiInfo.address = localJSONObject1.optString("addr");
    localPoiInfo.uid = localJSONObject1.optString("uid");
    localPoiInfo.phoneNum = localJSONObject1.optString("tel");
    localPoiInfo.type = PoiInfo.POITYPE.fromInt(localJSONObject1.optInt("type"));
    if (localJSONObject1.optInt("pano") == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localPoiInfo.isPano = bool;
      if ((localPoiInfo.type != PoiInfo.POITYPE.BUS_LINE) && (localPoiInfo.type != PoiInfo.POITYPE.SUBWAY_LINE)) {
        localPoiInfo.location = CoordUtil.decodeLocation(localJSONObject1.optString("geo"));
      }
      localPoiInfo.city = paramString;
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("place");
      if ((localJSONObject2 != null) && ("cater".equals(localJSONObject2.optString("src_name"))) && (localJSONObject1.optBoolean("detail"))) {
        localPoiInfo.hasCaterDetails = true;
      }
      ((ArrayList)localObject3).add(localPoiInfo);
      break;
    }
    label432:
    if (((ArrayList)localObject3).size() > 0) {
      localPoiResult.a((List)localObject3);
    }
    paramString = ((JSONObject)localObject1).optJSONArray("addrs");
    Object localObject1 = new ArrayList();
    if (paramString != null)
    {
      paramInt1 = i;
      if (paramInt1 < paramString.length())
      {
        localObject2 = paramString.optJSONObject(paramInt1);
        localObject3 = new PoiAddrInfo();
        if (localObject2 == null) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          ((PoiAddrInfo)localObject3).name = ((JSONObject)localObject2).optString("name");
          ((PoiAddrInfo)localObject3).address = ((JSONObject)localObject2).optString("addr");
          ((PoiAddrInfo)localObject3).location = CoordUtil.decodeLocation(((JSONObject)localObject2).optString("geo"));
          ((ArrayList)localObject1).add(localObject3);
        }
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localPoiResult.b((List)localObject1);
      localPoiResult.a(true);
    }
    return localPoiResult;
  }
  
  public static PoiIndoorResult b(String paramString)
  {
    PoiIndoorResult localPoiIndoorResult = new PoiIndoorResult();
    if ((paramString == null) || ("".equals(paramString)))
    {
      localPoiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localPoiIndoorResult;
    }
    ArrayList localArrayList;
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        paramString = new JSONObject(paramString);
        JSONArray localJSONArray = paramString.optJSONArray("poi_list");
        if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
          break label388;
        }
        localArrayList = new ArrayList();
        int i = 0;
        if (i >= localJSONArray.length()) {
          break;
        }
        localJSONObject = (JSONObject)localJSONArray.opt(i);
        if (localJSONObject == null)
        {
          i += 1;
          continue;
        }
        localPoiIndoorInfo = new PoiIndoorInfo();
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localPoiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localPoiIndoorResult;
      }
      PoiIndoorInfo localPoiIndoorInfo;
      localPoiIndoorInfo.address = localJSONObject.optString("address");
      localPoiIndoorInfo.bid = localJSONObject.optString("bd_id");
      localPoiIndoorInfo.cid = localJSONObject.optInt("cid");
      localPoiIndoorInfo.discount = localJSONObject.optInt("discount");
      localPoiIndoorInfo.floor = localJSONObject.optString("floor");
      localPoiIndoorInfo.name = localJSONObject.optString("name");
      localPoiIndoorInfo.phone = localJSONObject.optString("phone");
      localPoiIndoorInfo.price = localJSONObject.optInt("price");
      localPoiIndoorInfo.starLevel = localJSONObject.optInt("star_level");
      localPoiIndoorInfo.tag = localJSONObject.optString("tag");
      localPoiIndoorInfo.uid = localJSONObject.optString("uid");
      localPoiIndoorInfo.groupNum = localJSONObject.optInt("tuan_nums");
      localPoiIndoorInfo.isGroup = localJSONObject.optBoolean("t_flag");
      localPoiIndoorInfo.isTakeOut = localJSONObject.optBoolean("w_flag");
      localPoiIndoorInfo.isWaited = localJSONObject.optBoolean("p_flag");
      localPoiIndoorInfo.latLng = CoordUtil.mc2ll(new GeoPoint(localJSONObject.optDouble("pt_y"), localJSONObject.optDouble("pt_x")));
      localArrayList.add(localPoiIndoorInfo);
    }
    localPoiIndoorResult.error = SearchResult.ERRORNO.NO_ERROR;
    localPoiIndoorResult.setmArrayPoiInfo(localArrayList);
    for (;;)
    {
      localPoiIndoorResult.b = paramString.optInt("page_num");
      localPoiIndoorResult.a = paramString.optInt("poi_num");
      return localPoiIndoorResult;
      label388:
      localPoiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/poi/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */