package com.baidu.trace;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.trace.api.entity.AddEntityResponse;
import com.baidu.trace.api.entity.AroundSearchRequest;
import com.baidu.trace.api.entity.AroundSearchResponse;
import com.baidu.trace.api.entity.BoundSearchRequest;
import com.baidu.trace.api.entity.BoundSearchResponse;
import com.baidu.trace.api.entity.CommonResponse;
import com.baidu.trace.api.entity.DeleteEntityResponse;
import com.baidu.trace.api.entity.DistrictSearchRequest;
import com.baidu.trace.api.entity.DistrictSearchResponse;
import com.baidu.trace.api.entity.EntityListRequest;
import com.baidu.trace.api.entity.EntityListResponse;
import com.baidu.trace.api.entity.FilterCondition;
import com.baidu.trace.api.entity.LocRequest;
import com.baidu.trace.api.entity.OnEntityListener;
import com.baidu.trace.api.entity.PolygonSearchRequest;
import com.baidu.trace.api.entity.PolygonSearchResponse;
import com.baidu.trace.api.entity.SearchRequest;
import com.baidu.trace.api.entity.SearchResponse;
import com.baidu.trace.api.entity.SortBy;
import com.baidu.trace.api.entity.UpdateEntityResponse;
import com.baidu.trace.c.e;
import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import com.baidu.trace.model.LocType;
import com.baidu.trace.model.SortType;
import com.baidu.trace.model.TraceLocation;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public final class aa
{
  private static String a = "";
  private static f b = null;
  
  private static String a(List<String> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      try
      {
        localStringBuffer.append(URLEncoder.encode(str, "UTF-8")).append(",");
      }
      catch (Exception localException)
      {
        localStringBuffer.append(str).append(",");
      }
    }
    if (TextUtils.isEmpty(localStringBuffer.toString())) {
      return "";
    }
    return localStringBuffer.substring(0, localStringBuffer.length() - 1);
  }
  
  private static String a(Map<String, String> paramMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      try
      {
        localStringBuffer.append((String)localEntry.getKey()).append(":").append(URLEncoder.encode((String)localEntry.getValue(), "UTF-8")).append("|");
      }
      catch (Exception localException)
      {
        localStringBuffer.append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append("|");
      }
    }
    if (TextUtils.isEmpty(localStringBuffer.toString())) {
      return "";
    }
    return localStringBuffer.substring(0, localStringBuffer.length() - 1);
  }
  
  protected static void a(Context paramContext, LocRequest paramLocRequest, OnEntityListener paramOnEntityListener)
  {
    if (b == null) {
      b = new f(paramContext);
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool1 = e.e(paramContext);
      boolean bool2 = e.f(paramContext);
      boolean bool3 = e.g(paramContext);
      if (((!bool2) || (!bool3)) && (!bool1))
      {
        a.a("BaiduTraceSDK", "Need ACCESS_WIFI_STATE or ACCESS_FINE_LOCATION permission to get wifi information");
        paramOnEntityListener.onReceiveLocation(new TraceLocation(paramLocRequest.getTag(), 14001, "请求失败"));
        return;
      }
    }
    if ((!e.d(paramContext)) || (TextUtils.isEmpty(a))) {
      a = b.a();
    }
    if (TextUtils.isEmpty(a))
    {
      paramOnEntityListener.onReceiveLocation(new TraceLocation(paramLocRequest.getTag(), 14001, "请求失败"));
      return;
    }
    a.a(paramLocRequest, a, paramOnEntityListener);
  }
  
  protected static void a(FilterCondition paramFilterCondition, TreeMap<String, String> paramTreeMap)
  {
    if (paramFilterCondition == null) {}
    StringBuffer localStringBuffer;
    do
    {
      return;
      localStringBuffer = new StringBuffer("");
      if ((paramFilterCondition.getEntityNames() != null) && (!paramFilterCondition.getEntityNames().isEmpty())) {
        localStringBuffer.append("entity_names:").append(a(paramFilterCondition.getEntityNames()));
      }
      if (paramFilterCondition.getActiveTime() > 0L) {
        localStringBuffer.append("|active_time").append(":").append(paramFilterCondition.getActiveTime());
      }
      if (paramFilterCondition.getInActiveTime() > 0L) {
        localStringBuffer.append("|inactive_time").append(":").append(paramFilterCondition.getInActiveTime());
      }
      if ((paramFilterCondition.getColumns() != null) && (!paramFilterCondition.getColumns().isEmpty())) {
        localStringBuffer.append("|").append(a(paramFilterCondition.getColumns()));
      }
      if ((localStringBuffer.length() > 0) && (localStringBuffer.charAt(0) == '|')) {
        localStringBuffer.replace(0, 1, "");
      }
    } while (TextUtils.isEmpty(localStringBuffer.toString()));
    paramTreeMap.put("filter", localStringBuffer.toString());
  }
  
  protected static void a(SortBy paramSortBy, TreeMap<String, String> paramTreeMap)
  {
    if (paramSortBy == null) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramSortBy.getFieldName()).append(":").append(paramSortBy.getSortType().name());
    try
    {
      paramTreeMap.put("sortby", URLEncoder.encode(localStringBuffer.toString(), "UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException paramSortBy)
    {
      paramTreeMap.put("sortby", localStringBuffer.toString());
    }
  }
  
  public static void a(BaseRequest paramBaseRequest, int paramInt1, boolean paramBoolean, int paramInt2, String paramString, OnEntityListener paramOnEntityListener)
  {
    int i = paramBaseRequest.getTag();
    switch (paramInt1)
    {
    default: 
      return;
    case 2: 
      paramBaseRequest = new AddEntityResponse(i, paramInt2, paramString);
      if (paramBoolean) {
        a.b(paramString, paramBaseRequest);
      }
      paramOnEntityListener.onAddEntityCallback(paramBaseRequest);
      return;
    case 4: 
      paramBaseRequest = new UpdateEntityResponse(i, paramInt2, paramString);
      if (paramBoolean) {
        a.b(paramString, paramBaseRequest);
      }
      paramOnEntityListener.onUpdateEntityCallback(paramBaseRequest);
      return;
    case 3: 
      paramBaseRequest = new DeleteEntityResponse(i, paramInt2, paramString);
      if (paramBoolean) {
        a.b(paramString, paramBaseRequest);
      }
      paramOnEntityListener.onDeleteEntityCallback(paramBaseRequest);
      return;
    case 1: 
      localObject = new EntityListResponse(i, paramInt2, paramString);
      if (paramBoolean) {
        a.a(paramString, ((EntityListRequest)paramBaseRequest).getCoordTypeOutput(), (CommonResponse)localObject);
      }
      paramOnEntityListener.onEntityListCallback((EntityListResponse)localObject);
      return;
    case 5: 
      paramBaseRequest = new TraceLocation(i, paramInt2, paramString);
      if (paramBoolean) {
        paramBaseRequest.setLocType(LocType.NET_WORK);
      }
      for (;;)
      {
        try
        {
          paramBoolean = a.b(paramString, paramBaseRequest);
          if (paramBoolean) {
            continue;
          }
        }
        catch (Exception paramString)
        {
          JSONObject localJSONObject;
          paramString = paramString;
          continue;
        }
        finally {}
        paramOnEntityListener.onReceiveLocation(paramBaseRequest);
        return;
        paramString = new JSONObject(paramString);
        if (paramString.has("result"))
        {
          paramString = paramString.getJSONObject("result");
          if (paramString.has("content"))
          {
            localObject = paramString.getJSONObject("content");
            if (((JSONObject)localObject).has("point"))
            {
              localJSONObject = ((JSONObject)localObject).getJSONObject("point");
              if ((localJSONObject.has("y")) && (!TextUtils.isEmpty(localJSONObject.getString("y")))) {
                paramBaseRequest.setLatitude(Double.parseDouble(localJSONObject.getString("y")));
              }
              if ((localJSONObject.has("x")) && (!TextUtils.isEmpty(localJSONObject.getString("x")))) {
                paramBaseRequest.setLongitude(Double.parseDouble(localJSONObject.getString("x")));
              }
            }
            if (((JSONObject)localObject).has("floor")) {
              paramBaseRequest.setFloor(((JSONObject)localObject).getString("floor"));
            }
            if (((JSONObject)localObject).has("indoor")) {
              paramBaseRequest.setIndoor(((JSONObject)localObject).getString("indoor"));
            }
            if (((JSONObject)localObject).has("bldg")) {
              paramBaseRequest.setBuilding(((JSONObject)localObject).getString("bldg"));
            }
            if ((((JSONObject)localObject).has("radius")) && (!TextUtils.isEmpty(((JSONObject)localObject).getString("radius")))) {
              paramBaseRequest.setRadius(Double.parseDouble(((JSONObject)localObject).getString("radius")));
            }
          }
          if (paramString.has("result"))
          {
            paramString = paramString.getJSONObject("result");
            if (paramString.has("time")) {
              paramBaseRequest.setTime(paramString.getString("time"));
            }
          }
          paramBaseRequest.setCoordType(CoordType.bd09ll);
        }
      }
    case 6: 
      localObject = new SearchResponse(i, paramInt2, paramString);
      if (paramBoolean) {
        a.a(paramString, ((SearchRequest)paramBaseRequest).getCoordTypeOutput(), (CommonResponse)localObject);
      }
      paramOnEntityListener.onSearchEntityCallback((SearchResponse)localObject);
      return;
    case 7: 
      localObject = new BoundSearchResponse(i, paramInt2, paramString);
      if (paramBoolean) {
        a.a(paramString, ((BoundSearchRequest)paramBaseRequest).getCoordTypeOutput(), (CommonResponse)localObject);
      }
      paramOnEntityListener.onBoundSearchCallback((BoundSearchResponse)localObject);
      return;
    case 8: 
      localObject = new AroundSearchResponse(i, paramInt2, paramString);
      if (paramBoolean) {
        a.a(paramString, ((AroundSearchRequest)paramBaseRequest).getCoordTypeOutput(), (CommonResponse)localObject);
      }
      paramOnEntityListener.onAroundSearchCallback((AroundSearchResponse)localObject);
      return;
    case 9: 
      localObject = new PolygonSearchResponse(i, paramInt2, paramString);
      if (paramBoolean) {
        a.a(paramString, ((PolygonSearchRequest)paramBaseRequest).getCoordTypeOutput(), (CommonResponse)localObject);
      }
      paramOnEntityListener.onPolygonSearchCallback((PolygonSearchResponse)localObject);
      return;
    }
    Object localObject = new DistrictSearchResponse(i, paramInt2, paramString);
    if (paramBoolean) {
      a.a(paramString, ((DistrictSearchRequest)paramBaseRequest).getCoordTypeOutput(), (CommonResponse)localObject);
    }
    paramOnEntityListener.onDistrictSearchCallback((DistrictSearchResponse)localObject);
  }
  
  protected static void a(List<LatLng> paramList, TreeMap<String, String> paramTreeMap)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    StringBuffer localStringBuffer;
    do
    {
      return;
      localStringBuffer = new StringBuffer("");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LatLng localLatLng = (LatLng)paramList.next();
        localStringBuffer.append(localLatLng.getLatitude()).append(",").append(localLatLng.getLongitude()).append(";");
      }
    } while (localStringBuffer.length() <= 0);
    localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    paramTreeMap.put("vertexes", localStringBuffer.toString());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */