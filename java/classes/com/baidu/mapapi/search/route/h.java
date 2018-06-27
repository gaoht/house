package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  private static SuggestAddrInfo a(JSONObject paramJSONObject)
  {
    SuggestAddrInfo localSuggestAddrInfo = new SuggestAddrInfo();
    Object localObject = paramJSONObject.optJSONObject("start_sug");
    paramJSONObject = paramJSONObject.optJSONObject("end_sug");
    int i;
    String str;
    if (localObject != null)
    {
      i = ((JSONObject)localObject).optInt("listType");
      str = ((JSONObject)localObject).optString("cityName");
      if (i == 1) {
        localSuggestAddrInfo.d(b((JSONObject)localObject, "list"));
      }
    }
    else if (paramJSONObject != null)
    {
      i = paramJSONObject.optInt("listType");
      localObject = paramJSONObject.optString("cityName");
      if (i != 1) {
        break label110;
      }
      localSuggestAddrInfo.e(b(paramJSONObject, "list"));
    }
    label110:
    while (i != 0)
    {
      return localSuggestAddrInfo;
      if (i != 0) {
        break;
      }
      localSuggestAddrInfo.a(b((JSONObject)localObject, "list", str));
      break;
    }
    localSuggestAddrInfo.b(b(paramJSONObject, "list", (String)localObject));
    return localSuggestAddrInfo;
  }
  
  public static TransitRouteResult a(String paramString)
  {
    TransitRouteResult localTransitRouteResult = new TransitRouteResult();
    if ((paramString == null) || (paramString.length() <= 0))
    {
      localTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localTransitRouteResult;
    }
    Object localObject1;
    RouteNode localRouteNode;
    try
    {
      localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).optJSONObject("taxi") != null) {
        localTransitRouteResult.a(f(((JSONObject)localObject1).optString("taxi")));
      }
      paramString = c((JSONObject)localObject1, "start_point");
      localRouteNode = c((JSONObject)localObject1, "end_point");
      localObject1 = ((JSONObject)localObject1).optJSONArray("routes");
      if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0))
      {
        localTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localTransitRouteResult;
      }
    }
    catch (JSONException paramString)
    {
      localTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      paramString.printStackTrace();
      return localTransitRouteResult;
    }
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < ((JSONArray)localObject1).length())
    {
      Object localObject2 = ((JSONObject)((JSONArray)localObject1).opt(i)).optJSONObject("legs");
      if (localObject2 == null) {}
      for (;;)
      {
        i += 1;
        break;
        TransitRouteLine localTransitRouteLine = new TransitRouteLine();
        localTransitRouteLine.setDistance(((JSONObject)localObject2).optInt("distance"));
        localTransitRouteLine.setDuration(((JSONObject)localObject2).optInt("time"));
        localTransitRouteLine.setStarting(paramString);
        localTransitRouteLine.setTerminal(localRouteNode);
        localObject2 = ((JSONObject)localObject2).optJSONArray("steps");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          ArrayList localArrayList2 = new ArrayList();
          int j = 0;
          while (j < ((JSONArray)localObject2).length())
          {
            Object localObject3 = ((JSONArray)localObject2).optJSONObject(j).optJSONArray("busline");
            if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0))
            {
              j += 1;
            }
            else
            {
              Object localObject4 = ((JSONArray)localObject3).optJSONObject(0);
              localObject3 = new TransitRouteLine.TransitStep();
              ((TransitRouteLine.TransitStep)localObject3).a(RouteNode.location(CoordUtil.decodeLocation(((JSONObject)localObject4).optString("start_location"))));
              ((TransitRouteLine.TransitStep)localObject3).b(RouteNode.location(CoordUtil.decodeLocation(((JSONObject)localObject4).optString("end_location"))));
              if (((JSONObject)localObject4).optInt("type") == 5)
              {
                ((TransitRouteLine.TransitStep)localObject3).a(TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING);
                label365:
                ((TransitRouteLine.TransitStep)localObject3).a(i(((JSONObject)localObject4).optString("instructions")));
                ((TransitRouteLine.TransitStep)localObject3).setDistance(((JSONObject)localObject4).optInt("distance"));
                ((TransitRouteLine.TransitStep)localObject3).setDuration(((JSONObject)localObject4).optInt("duration"));
                ((TransitRouteLine.TransitStep)localObject3).b(((JSONObject)localObject4).optString("path_geo"));
                if (((JSONObject)localObject4).has("vehicle"))
                {
                  ((TransitRouteLine.TransitStep)localObject3).a(g(((JSONObject)localObject4).optString("vehicle")));
                  localObject4 = ((JSONObject)localObject4).optJSONObject("vehicle");
                  ((TransitRouteLine.TransitStep)localObject3).getEntrance().setUid(((JSONObject)localObject4).optString("start_uid"));
                  ((TransitRouteLine.TransitStep)localObject3).getEntrance().setTitle(((JSONObject)localObject4).optString("start_name"));
                  ((TransitRouteLine.TransitStep)localObject3).getExit().setUid(((JSONObject)localObject4).optString("end_uid"));
                  ((TransitRouteLine.TransitStep)localObject3).getExit().setTitle(((JSONObject)localObject4).optString("end_name"));
                  localObject4 = Integer.valueOf(((JSONObject)localObject4).optInt("type"));
                  if (localObject4 == null) {
                    break label579;
                  }
                  if (((Integer)localObject4).intValue() != 1) {
                    break label568;
                  }
                  ((TransitRouteLine.TransitStep)localObject3).a(TransitRouteLine.TransitStep.TransitRouteStepType.SUBWAY);
                }
              }
              for (;;)
              {
                localArrayList2.add(localObject3);
                break;
                ((TransitRouteLine.TransitStep)localObject3).a(TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING);
                break label365;
                label568:
                ((TransitRouteLine.TransitStep)localObject3).a(TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE);
                continue;
                label579:
                ((TransitRouteLine.TransitStep)localObject3).a(TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE);
              }
            }
          }
          localTransitRouteLine.setSteps(localArrayList2);
          localArrayList1.add(localTransitRouteLine);
        }
      }
    }
    localTransitRouteResult.a(localArrayList1);
    return localTransitRouteResult;
  }
  
  public static List<CityInfo> a(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || (paramString.equals(""))) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.optJSONArray(paramString);
    } while ((paramJSONObject == null) || (paramJSONObject.length() <= 0));
    paramString = new ArrayList();
    int i = 0;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = (JSONObject)paramJSONObject.opt(i);
      if (localJSONObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        CityInfo localCityInfo = new CityInfo();
        localCityInfo.num = localJSONObject.optInt("num");
        localCityInfo.city = localJSONObject.optString("name");
        paramString.add(localCityInfo);
      }
    }
    paramString.trimToSize();
    return paramString;
  }
  
  private static List<PoiInfo> a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((paramJSONObject == null) || (paramString1 == null) || ("".equals(paramString1))) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONArray(paramString1);
    if (paramJSONObject != null)
    {
      paramString1 = new ArrayList();
      int i = 0;
      if (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONObject.opt(i);
        if (localJSONObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          PoiInfo localPoiInfo = new PoiInfo();
          PlanNode.withCityNameAndPlaceName(paramString2, localJSONObject.optString("name"));
          localPoiInfo.address = localJSONObject.optString("addr");
          localPoiInfo.uid = localJSONObject.optString("uid");
          localPoiInfo.name = localJSONObject.optString("name");
          localPoiInfo.location = CoordUtil.decodeLocation(localJSONObject.optString("geo"));
          localPoiInfo.city = paramString2;
          paramString1.add(localPoiInfo);
        }
      }
      if (paramString1.size() > 0) {
        return paramString1;
      }
    }
    return null;
  }
  
  public static DrivingRouteResult b(String paramString)
  {
    DrivingRouteResult localDrivingRouteResult = new DrivingRouteResult();
    if ((paramString == null) || ("".equals(paramString)))
    {
      localDrivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localDrivingRouteResult;
    }
    ArrayList localArrayList1;
    JSONArray localJSONArray1;
    try
    {
      paramString = new JSONObject(paramString);
      localArrayList1 = new ArrayList();
      localJSONArray1 = paramString.optJSONArray("routes");
      if (localJSONArray1 == null) {
        return localDrivingRouteResult;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      localDrivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localDrivingRouteResult;
    }
    int i = 0;
    if (i < localJSONArray1.length())
    {
      DrivingRouteLine localDrivingRouteLine = new DrivingRouteLine();
      localDrivingRouteLine.setStarting(e(paramString, "start_point"));
      localDrivingRouteLine.setTerminal(e(paramString, "end_point"));
      localDrivingRouteLine.a(f(paramString, "waypoints"));
      Object localObject1 = localJSONArray1.optJSONObject(i);
      if (localObject1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject1 = ((JSONObject)localObject1).optJSONObject("legs");
        if (localObject1 == null) {
          return localDrivingRouteResult;
        }
        localDrivingRouteLine.setDistance(((JSONObject)localObject1).optInt("distance"));
        localDrivingRouteLine.setDuration(((JSONObject)localObject1).optInt("duration"));
        localDrivingRouteLine.setCongestionDistance(((JSONObject)localObject1).optInt("congestion_length"));
        localDrivingRouteLine.setLightNum(((JSONObject)localObject1).optInt("light_num"));
        localObject1 = ((JSONObject)localObject1).optJSONArray("steps");
        if (localObject1 == null) {
          return localDrivingRouteResult;
        }
        ArrayList localArrayList2 = new ArrayList();
        int j = 0;
        if (j < ((JSONArray)localObject1).length())
        {
          DrivingRouteLine.DrivingStep localDrivingStep = new DrivingRouteLine.DrivingStep();
          JSONObject localJSONObject1 = ((JSONArray)localObject1).optJSONObject(j);
          if (localJSONObject1 == null) {}
          for (;;)
          {
            j += 1;
            break;
            JSONArray localJSONArray2 = localJSONObject1.optJSONArray("paths");
            if (localJSONArray2 == null) {
              return localDrivingRouteResult;
            }
            Object localObject2;
            int k;
            if (localJSONArray2.length() >= 2)
            {
              localObject2 = new ArrayList();
              k = 0;
              if (k < localJSONArray2.length())
              {
                JSONObject localJSONObject2 = localJSONArray2.optJSONObject(k);
                GeoPoint localGeoPoint = new GeoPoint(0.0D, 0.0D);
                localGeoPoint.setLongitudeE6(localJSONObject2.optInt("loc_x"));
                localGeoPoint.setLatitudeE6(localJSONObject2.optInt("loc_y"));
                if (k == 0) {
                  localDrivingStep.a(RouteNode.location(CoordUtil.mc2ll(localGeoPoint)));
                }
                for (;;)
                {
                  ((List)localObject2).add(CoordUtil.mc2ll(localGeoPoint));
                  k += 1;
                  break;
                  if (k == localJSONArray2.length() - 1) {
                    localDrivingStep.b(RouteNode.location(CoordUtil.mc2ll(localGeoPoint)));
                  }
                }
              }
              localDrivingStep.a((List)localObject2);
            }
            localJSONArray2 = localJSONObject1.optJSONArray("traffics");
            if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
            {
              int m = localJSONArray2.length();
              localObject2 = new int[m];
              k = 0;
              while (k < m)
              {
                localObject2[k] = Integer.parseInt((String)localJSONArray2.opt(k));
                k += 1;
              }
              localDrivingStep.a((int[])localObject2);
            }
            localDrivingStep.a(localJSONObject1.optInt("direction") * 30);
            localDrivingStep.setDistance(localJSONObject1.optInt("distance"));
            localDrivingStep.setDuration(localJSONObject1.optInt("duration"));
            localDrivingStep.c(localJSONObject1.optString("description"));
            localDrivingStep.a(localJSONObject1.optString("start_desc"));
            localDrivingStep.b(localJSONObject1.optString("end_desc"));
            localDrivingStep.b(localJSONObject1.optInt("turn"));
            localArrayList2.add(localDrivingStep);
          }
        }
        localDrivingRouteLine.setSteps(localArrayList2);
        localArrayList1.add(localDrivingRouteLine);
      }
    }
    localDrivingRouteResult.a(localArrayList1);
    localDrivingRouteResult.setTaxiInfos(e(paramString.optString("taxis")));
    return localDrivingRouteResult;
  }
  
  public static List<CityInfo> b(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || (paramString.equals(""))) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.optJSONArray(paramString);
    } while ((paramJSONObject == null) || (paramJSONObject.length() <= 0));
    paramString = new ArrayList();
    int i = 0;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = (JSONObject)paramJSONObject.opt(i);
      if (localJSONObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        CityInfo localCityInfo = new CityInfo();
        localCityInfo.num = localJSONObject.optInt("number");
        localCityInfo.city = localJSONObject.optString("name");
        paramString.add(localCityInfo);
      }
    }
    paramString.trimToSize();
    return paramString;
  }
  
  private static List<PoiInfo> b(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((paramJSONObject == null) || (paramString1 == null) || ("".equals(paramString1))) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONArray(paramString1);
    if (paramJSONObject != null)
    {
      paramString1 = new ArrayList();
      int i = 0;
      if (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONObject.opt(i);
        if (localJSONObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          PoiInfo localPoiInfo = new PoiInfo();
          if (localJSONObject.has("address")) {
            localPoiInfo.address = localJSONObject.optString("address");
          }
          localPoiInfo.uid = localJSONObject.optString("uid");
          localPoiInfo.name = localJSONObject.optString("name");
          localPoiInfo.location = new LatLng(localJSONObject.optDouble("lat"), localJSONObject.optDouble("lng"));
          localPoiInfo.city = paramString2;
          paramString1.add(localPoiInfo);
        }
      }
      if (paramString1.size() > 0) {
        return paramString1;
      }
    }
    return null;
  }
  
  private static RouteNode c(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || ("".equals(paramString))) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONObject(paramString);
    paramString = new RouteNode();
    paramString.setTitle(paramJSONObject.optString("name"));
    paramString.setUid(paramJSONObject.optString("uid"));
    paramString.setLocation(CoordUtil.decodeLocation(paramJSONObject.optString("geo")));
    return paramString;
  }
  
  public static WalkingRouteResult c(String paramString)
  {
    WalkingRouteResult localWalkingRouteResult = new WalkingRouteResult();
    if ((paramString == null) || ("".equals(paramString)))
    {
      localWalkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localWalkingRouteResult;
    }
    try
    {
      localObject = new JSONObject(paramString);
      if (((JSONObject)localObject).has("taxi")) {
        localWalkingRouteResult.a(f(((JSONObject)localObject).optString("taxi")));
      }
      paramString = new WalkingRouteLine();
      paramString.setStarting(c((JSONObject)localObject, "start_point"));
      paramString.setTerminal(c((JSONObject)localObject, "end_point"));
      localObject = ((JSONObject)localObject).optJSONObject("routes");
      if (localObject == null) {
        return localWalkingRouteResult;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      localWalkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localWalkingRouteResult;
    }
    Object localObject = ((JSONObject)localObject).optJSONObject("legs");
    if (localObject == null) {
      return localWalkingRouteResult;
    }
    paramString.setDistance(((JSONObject)localObject).optInt("distance"));
    paramString.setDuration(((JSONObject)localObject).optInt("duration"));
    localObject = ((JSONObject)localObject).optJSONArray("steps");
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < ((JSONArray)localObject).length())
      {
        WalkingRouteLine.WalkingStep localWalkingStep = new WalkingRouteLine.WalkingStep();
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        if (localJSONObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localWalkingStep.a(localJSONObject.optInt("direction") * 30);
          localWalkingStep.setDistance(localJSONObject.optInt("distance"));
          localWalkingStep.setDuration(localJSONObject.optInt("duration"));
          localWalkingStep.a(RouteNode.location(CoordUtil.decodeLocation(localJSONObject.optString("start_loc"))));
          localWalkingStep.b(RouteNode.location(CoordUtil.decodeLocation(localJSONObject.optString("end_loc"))));
          localWalkingStep.d(localJSONObject.optString("description"));
          localWalkingStep.b(localJSONObject.optString("start_desc"));
          localWalkingStep.c(localJSONObject.optString("end_desc"));
          localWalkingStep.a(localJSONObject.optString("path"));
          localArrayList.add(localWalkingStep);
        }
      }
      if (localArrayList.size() > 0) {
        paramString.setSteps(localArrayList);
      }
    }
    localObject = new ArrayList();
    ((List)localObject).add(paramString);
    localWalkingRouteResult.a((List)localObject);
    return localWalkingRouteResult;
  }
  
  private static RouteNode d(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || ("".equals(paramString))) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONObject(paramString);
    paramString = new RouteNode();
    paramString.setTitle(paramJSONObject.optString("name"));
    paramString.setUid(paramJSONObject.optString("uid"));
    paramString.setLocation(new LatLng(paramJSONObject.optDouble("lat"), paramJSONObject.optDouble("lng")));
    return paramString;
  }
  
  public static BikingRouteResult d(String paramString)
  {
    BikingRouteResult localBikingRouteResult = new BikingRouteResult();
    if ((paramString == null) || ("".equals(paramString)))
    {
      localBikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localBikingRouteResult;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("type");
        if (i == 1)
        {
          localBikingRouteResult.a(a(paramString));
          localBikingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
          return localBikingRouteResult;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localBikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localBikingRouteResult;
      }
      JSONArray localJSONArray;
      ArrayList localArrayList1;
      BikingRouteLine localBikingRouteLine;
      if (i == 2)
      {
        localJSONArray = paramString.optJSONArray("routes");
        localArrayList1 = new ArrayList();
        i = 0;
        if (i < localJSONArray.length()) {
          localBikingRouteLine = new BikingRouteLine();
        }
      }
      try
      {
        Object localObject = localJSONArray.optJSONObject(i);
        localBikingRouteLine.setStarting(d(paramString, "start"));
        localBikingRouteLine.setTerminal(d(paramString, "end"));
        if (localObject == null) {
          return localBikingRouteResult;
        }
        localBikingRouteLine.setDistance(((JSONObject)localObject).optInt("distance"));
        localBikingRouteLine.setDuration(((JSONObject)localObject).optInt("duration"));
        localObject = ((JSONObject)localObject).optJSONArray("steps");
        ArrayList localArrayList2;
        int j;
        if (localObject != null)
        {
          localArrayList2 = new ArrayList();
          j = 0;
        }
        for (;;)
        {
          if (j < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject1 = ((JSONArray)localObject).optJSONObject(j);
            BikingRouteLine.BikingStep localBikingStep = new BikingRouteLine.BikingStep();
            if ((localJSONObject1 != null) && (localJSONObject1.length() > 0))
            {
              localBikingStep.a(localJSONObject1.optInt("direction") * 30);
              localBikingStep.setDistance(localJSONObject1.optInt("distance"));
              localBikingStep.setDuration(localJSONObject1.optInt("duration"));
              JSONObject localJSONObject2 = localJSONObject1.optJSONObject("start_pt");
              JSONObject localJSONObject3 = localJSONObject1.optJSONObject("end_pt");
              localBikingStep.a(RouteNode.location(new LatLng(localJSONObject2.optDouble("lat"), localJSONObject2.optDouble("lng"))));
              localBikingStep.b(RouteNode.location(new LatLng(localJSONObject3.optDouble("lat"), localJSONObject3.optDouble("lng"))));
              localBikingStep.d(localJSONObject1.optString("instructions"));
              localBikingStep.b(localJSONObject1.optString("start_instructions"));
              localBikingStep.c(localJSONObject1.optString("end_instructions"));
              localBikingStep.a(localJSONObject1.optString("path"));
              localArrayList2.add(localBikingStep);
            }
          }
          else
          {
            if (localArrayList2.size() > 0) {
              localBikingRouteLine.setSteps(localArrayList2);
            }
            localArrayList1.add(localBikingRouteLine);
            break label497;
            localBikingRouteResult.a(localArrayList1);
            return localBikingRouteResult;
            localBikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            break;
          }
          j += 1;
        }
      }
      catch (Exception localException)
      {
        label497:
        i += 1;
      }
    }
  }
  
  private static RouteNode e(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || ("".equals(paramString))) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONObject(paramString);
    paramString = new RouteNode();
    paramString.setTitle(paramJSONObject.optString("name"));
    GeoPoint localGeoPoint = new GeoPoint(0.0D, 0.0D);
    localGeoPoint.setLongitudeE6(paramJSONObject.optInt("loc_x"));
    localGeoPoint.setLatitudeE6(paramJSONObject.optInt("loc_y"));
    paramString.setLocation(CoordUtil.mc2ll(localGeoPoint));
    return paramString;
  }
  
  public static List<TaxiInfo> e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        if (paramString != null) {
          break label116;
        }
        return null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return localArrayList;
      }
      if (i < paramString.length())
      {
        Object localObject = paramString.getJSONObject(i);
        if (localObject != null)
        {
          TaxiInfo localTaxiInfo = new TaxiInfo();
          localObject = ((JSONObject)localObject).optString("total_price");
          if ((localObject == null) || (((String)localObject).equals("")))
          {
            localTaxiInfo.setTotalPrice(0.0F);
            localArrayList.add(localTaxiInfo);
          }
          else
          {
            localTaxiInfo.setTotalPrice(Float.parseFloat((String)localObject));
            continue;
          }
        }
      }
      else
      {
        return localArrayList;
        label116:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public static TaxiInfo f(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null) {
        return null;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      TaxiInfo localTaxiInfo = new TaxiInfo();
      localTaxiInfo.setDesc(paramString.optString("remark"));
      localTaxiInfo.setDistance(paramString.optInt("distance"));
      localTaxiInfo.setDuration(paramString.optInt("duration"));
      String str1 = paramString.optString("total_price");
      String str2 = paramString.optString("start_price");
      paramString = paramString.optString("km_price");
      if ((str1 == null) || (str1.equals("")))
      {
        localTaxiInfo.setTotalPrice(0.0F);
        if ((str1 != null) && (!str2.equals(""))) {
          break label155;
        }
        localTaxiInfo.setStartPrice(0.0F);
      }
      for (;;)
      {
        if ((paramString != null) && (!paramString.equals(""))) {
          break label166;
        }
        localTaxiInfo.setPerKMPrice(0.0F);
        return localTaxiInfo;
        localTaxiInfo.setTotalPrice(Float.parseFloat(str1));
        break;
        label155:
        localTaxiInfo.setStartPrice(Float.parseFloat(str2));
      }
      label166:
      localTaxiInfo.setPerKMPrice(Float.parseFloat(paramString));
      return localTaxiInfo;
    }
  }
  
  private static List<RouteNode> f(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || ("".equals(paramString))) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.optJSONArray(paramString);
    } while (paramJSONObject == null);
    paramString = new ArrayList();
    int i = 0;
    for (;;)
    {
      RouteNode localRouteNode;
      if (i < paramJSONObject.length()) {
        localRouteNode = new RouteNode();
      }
      try
      {
        localRouteNode.setTitle(paramJSONObject.getJSONObject(i).optString("name"));
        localRouteNode.setUid(paramJSONObject.getJSONObject(i).optString("uid"));
        GeoPoint localGeoPoint = new GeoPoint(0.0D, 0.0D);
        localGeoPoint.setLongitudeE6(paramJSONObject.getJSONObject(i).optInt("loc_x"));
        localGeoPoint.setLatitudeE6(paramJSONObject.getJSONObject(i).optInt("loc_y"));
        localRouteNode.setLocation(CoordUtil.mc2ll(localGeoPoint));
        paramString.add(localRouteNode);
        i += 1;
        continue;
        return paramString;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  public static VehicleInfo g(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null) {
        return null;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      VehicleInfo localVehicleInfo = new VehicleInfo();
      localVehicleInfo.setZonePrice(paramString.optInt("zone_price"));
      localVehicleInfo.setTotalPrice(paramString.optInt("total_price"));
      localVehicleInfo.setTitle(paramString.optString("name"));
      localVehicleInfo.setPassStationNum(paramString.optInt("stop_num"));
      localVehicleInfo.setUid(paramString.optString("uid"));
      return localVehicleInfo;
    }
  }
  
  public static SuggestAddrInfo h(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        Object localObject3 = ((JSONObject)localObject1).optJSONObject("address_info");
        if (localObject3 == null) {
          break;
        }
        paramString = new SuggestAddrInfo();
        Object localObject2 = ((JSONObject)localObject3).optString("st_cityname");
        localObject3 = ((JSONObject)localObject3).optString("en_cityname");
        if (((JSONObject)localObject1).optBoolean("hasAddrList"))
        {
          paramString.d(a((JSONObject)localObject1, "startcitys"));
          paramString.a(a((JSONObject)localObject1, "startpoints", (String)localObject2));
          paramString.e(a((JSONObject)localObject1, "endcitys"));
          paramString.b(a((JSONObject)localObject1, "endpoints", (String)localObject3));
          localObject1 = ((JSONObject)localObject1).optJSONArray("waypoints_result");
          if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
            break label271;
          }
          localObject2 = new ArrayList();
          localObject3 = new ArrayList();
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            Object localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            List localList = a((JSONObject)localObject4, "waypointcitys");
            if (localList != null) {
              ((List)localObject2).add(localList);
            }
            localObject4 = a((JSONObject)localObject4, "waypoints", "");
            if (localObject4 == null) {
              break label273;
            }
            ((List)localObject3).add(localObject4);
            break label273;
          }
          if (((List)localObject2).size() > 0) {
            paramString.f((List)localObject2);
          }
          if (((List)localObject3).size() > 0) {
            paramString.c((List)localObject3);
          }
        }
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      label271:
      return paramString;
      label273:
      i += 1;
    }
  }
  
  public static String i(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramString.toCharArray();
    int j = 0;
    int k = 0;
    if (j < paramString.length)
    {
      int i;
      if (paramString[j] == '<') {
        i = 1;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        if (paramString[j] == '>')
        {
          i = 0;
        }
        else
        {
          i = k;
          if (k == 0)
          {
            localStringBuilder.append(paramString[j]);
            i = k;
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */