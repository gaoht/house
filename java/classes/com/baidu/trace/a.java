package com.baidu.trace;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.trace.api.analysis.DrivingBehaviorRequest;
import com.baidu.trace.api.analysis.DrivingBehaviorResponse;
import com.baidu.trace.api.analysis.EndPoint;
import com.baidu.trace.api.analysis.HarshAccelerationPoint;
import com.baidu.trace.api.analysis.HarshBreakingPoint;
import com.baidu.trace.api.analysis.HarshSteeringPoint;
import com.baidu.trace.api.analysis.OnAnalysisListener;
import com.baidu.trace.api.analysis.SpeedingInfo;
import com.baidu.trace.api.analysis.SpeedingPoint;
import com.baidu.trace.api.analysis.StartPoint;
import com.baidu.trace.api.analysis.StayPoint;
import com.baidu.trace.api.analysis.StayPointRequest;
import com.baidu.trace.api.analysis.StayPointResponse;
import com.baidu.trace.api.analysis.ThresholdOption;
import com.baidu.trace.api.analysis.TurnType;
import com.baidu.trace.api.bos.BosGeneratePresignedUrlRequest;
import com.baidu.trace.api.bos.BosGeneratePresignedUrlResponse;
import com.baidu.trace.api.bos.BosGetObjectRequest;
import com.baidu.trace.api.bos.BosGetObjectResponse;
import com.baidu.trace.api.bos.BosObjectType;
import com.baidu.trace.api.bos.BosPutObjectRequest;
import com.baidu.trace.api.bos.BosPutObjectResponse;
import com.baidu.trace.api.bos.OnBosListener;
import com.baidu.trace.api.entity.AddEntityRequest;
import com.baidu.trace.api.entity.AddEntityResponse;
import com.baidu.trace.api.entity.AroundSearchRequest;
import com.baidu.trace.api.entity.BoundSearchRequest;
import com.baidu.trace.api.entity.CommonRequest;
import com.baidu.trace.api.entity.DeleteEntityRequest;
import com.baidu.trace.api.entity.DeleteEntityResponse;
import com.baidu.trace.api.entity.DistrictSearchRequest;
import com.baidu.trace.api.entity.EntityListRequest;
import com.baidu.trace.api.entity.LatestLocation;
import com.baidu.trace.api.entity.LocRequest;
import com.baidu.trace.api.entity.OnEntityListener;
import com.baidu.trace.api.entity.PolygonSearchRequest;
import com.baidu.trace.api.entity.ReturnType;
import com.baidu.trace.api.entity.SearchRequest;
import com.baidu.trace.api.entity.UpdateEntityRequest;
import com.baidu.trace.api.entity.UpdateEntityResponse;
import com.baidu.trace.api.fence.AlarmPoint;
import com.baidu.trace.api.fence.CircleFence;
import com.baidu.trace.api.fence.CreateFenceRequest;
import com.baidu.trace.api.fence.CreateFenceResponse;
import com.baidu.trace.api.fence.DeleteFenceRequest;
import com.baidu.trace.api.fence.DeleteFenceResponse;
import com.baidu.trace.api.fence.DistrictFence;
import com.baidu.trace.api.fence.Fence;
import com.baidu.trace.api.fence.FenceAlarmInfo;
import com.baidu.trace.api.fence.FenceListRequest;
import com.baidu.trace.api.fence.FenceListResponse;
import com.baidu.trace.api.fence.FenceShape;
import com.baidu.trace.api.fence.FenceType;
import com.baidu.trace.api.fence.HistoryAlarmRequest;
import com.baidu.trace.api.fence.HistoryAlarmResponse;
import com.baidu.trace.api.fence.MonitoredAction;
import com.baidu.trace.api.fence.MonitoredStatus;
import com.baidu.trace.api.fence.MonitoredStatusByLocationRequest;
import com.baidu.trace.api.fence.MonitoredStatusByLocationResponse;
import com.baidu.trace.api.fence.MonitoredStatusInfo;
import com.baidu.trace.api.fence.MonitoredStatusRequest;
import com.baidu.trace.api.fence.MonitoredStatusResponse;
import com.baidu.trace.api.fence.OnFenceListener;
import com.baidu.trace.api.fence.PolygonFence;
import com.baidu.trace.api.fence.PolylineFence;
import com.baidu.trace.api.fence.UpdateFenceRequest;
import com.baidu.trace.api.fence.UpdateFenceResponse;
import com.baidu.trace.api.track.AddPointRequest;
import com.baidu.trace.api.track.AddPointResponse;
import com.baidu.trace.api.track.AddPointsRequest;
import com.baidu.trace.api.track.AddPointsResponse;
import com.baidu.trace.api.track.DistanceRequest;
import com.baidu.trace.api.track.FailInfo;
import com.baidu.trace.api.track.FailInfo.InternalError;
import com.baidu.trace.api.track.FailInfo.ParamError;
import com.baidu.trace.api.track.HistoryTrackRequest;
import com.baidu.trace.api.track.LatestPoint;
import com.baidu.trace.api.track.LatestPointRequest;
import com.baidu.trace.api.track.OnTrackListener;
import com.baidu.trace.api.track.SupplementMode;
import com.baidu.trace.api.track.TrackPoint;
import com.baidu.trace.c.a.c;
import com.baidu.trace.c.e;
import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.BaseResponse;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import com.baidu.trace.model.Point;
import com.baidu.trace.model.ProcessOption;
import com.baidu.trace.model.SortType;
import com.baidu.trace.model.TransportMode;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public int a = -1;
  public int b = -1;
  public int c = -1;
  public int d = -1;
  public char e = '\000';
  
  private a(f paramf) {}
  
  protected static String a(List<Long> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Long localLong = (Long)paramList.next();
      if (localLong != null) {
        localStringBuffer.append(localLong).append(",");
      }
    }
    if (TextUtils.isEmpty(localStringBuffer.toString())) {
      return "";
    }
    return localStringBuffer.substring(0, localStringBuffer.length() - 1);
  }
  
  protected static String a(TreeMap<String, String> paramTreeMap)
    throws UnsupportedEncodingException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramTreeMap = paramTreeMap.entrySet().iterator();
    while (paramTreeMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramTreeMap.next();
      localStringBuffer.append((String)localEntry.getKey()).append("=").append((String)localEntry.getValue()).append("&");
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  protected static String a(TreeMap<String, String> paramTreeMap, long paramLong, a.c paramc)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramTreeMap.put("service_id", String.valueOf(paramLong));
    paramTreeMap.put("os", q.a);
    paramTreeMap.put("sdk_version", q.b);
    paramTreeMap.put("pcn", q.d);
    paramTreeMap.put("token", d.a);
    try
    {
      paramTreeMap.put("cuid", URLEncoder.encode(q.c, "UTF-8"));
      try
      {
        String str = a(paramTreeMap);
        Object localObject = new String(str + "99754106633f94d350db34d548d6091a");
        byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(((String)localObject).getBytes());
        localObject = new StringBuffer();
        int i = 0;
        while (i < arrayOfByte.length)
        {
          ((StringBuffer)localObject).append(Integer.toHexString(arrayOfByte[i] & 0xFF | 0x100).substring(1, 3));
          i += 1;
        }
        if (a.c.b == paramc) {
          str = b(paramTreeMap);
        }
        localStringBuffer.append(str).append("&sign").append("=").append(((StringBuffer)localObject).toString());
      }
      catch (Exception paramTreeMap)
      {
        for (;;) {}
      }
      return localStringBuffer.toString();
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected static void a(int paramInt, Handler paramHandler, BaseResponse paramBaseResponse, OnFenceListener paramOnFenceListener)
  {
    paramHandler.post(new ai(paramInt, paramOnFenceListener, paramBaseResponse));
  }
  
  protected static void a(Context paramContext, Handler paramHandler, FenceListRequest paramFenceListRequest, OnFenceListener paramOnFenceListener)
  {
    if (FenceType.server == paramFenceListRequest.getFenceType())
    {
      paramContext = new TreeMap();
      if (!TextUtils.isEmpty(paramFenceListRequest.getMonitoredPerson())) {}
      try
      {
        paramContext.put("monitored_person", URLEncoder.encode(paramFenceListRequest.getMonitoredPerson(), "UTF-8"));
        if ((paramFenceListRequest.getFenceIds() != null) && (!paramFenceListRequest.getFenceIds().isEmpty())) {
          paramContext.put("fence_ids", a(paramFenceListRequest.getFenceIds()));
        }
        if (paramFenceListRequest.getCoordTypeOutput() != null) {
          paramContext.put("coord_type_output", paramFenceListRequest.getCoordTypeOutput().name());
        }
        com.baidu.trace.c.a.a(paramFenceListRequest, 0, "fence/list", a.c.a, 4, a(paramContext, paramFenceListRequest.getServiceId(), a.c.a), paramOnFenceListener);
        paramContext.clear();
        return;
      }
      catch (Exception paramHandler)
      {
        for (;;)
        {
          paramContext.put("monitored_person", paramFenceListRequest.getMonitoredPerson());
        }
      }
    }
    com.baidu.trace.c.a.a.execute(new ae(paramContext, paramHandler, paramFenceListRequest, paramOnFenceListener));
  }
  
  protected static void a(Context paramContext, Handler paramHandler, HistoryAlarmRequest paramHistoryAlarmRequest, OnFenceListener paramOnFenceListener)
  {
    if (FenceType.server == paramHistoryAlarmRequest.getFenceType())
    {
      paramContext = new TreeMap();
      if (!TextUtils.isEmpty(paramHistoryAlarmRequest.getMonitoredPerson())) {}
      try
      {
        paramContext.put("monitored_person", URLEncoder.encode(paramHistoryAlarmRequest.getMonitoredPerson(), "UTF-8"));
        if (paramHistoryAlarmRequest.getStartTime() > 0L) {
          paramContext.put("start_time", String.valueOf(paramHistoryAlarmRequest.getStartTime()));
        }
        if (paramHistoryAlarmRequest.getEndTime() > 0L) {
          paramContext.put("end_time", String.valueOf(paramHistoryAlarmRequest.getEndTime()));
        }
        if ((paramHistoryAlarmRequest.getFenceIds() != null) && (!paramHistoryAlarmRequest.getFenceIds().isEmpty())) {
          paramContext.put("fence_ids", a(paramHistoryAlarmRequest.getFenceIds()));
        }
        if (paramHistoryAlarmRequest.getCoordTypeOutput() != null) {
          paramContext.put("coord_type_output", paramHistoryAlarmRequest.getCoordTypeOutput().name());
        }
        com.baidu.trace.c.a.a(paramHistoryAlarmRequest, 0, "fence/historyalarm", a.c.a, 7, a(paramContext, paramHistoryAlarmRequest.getServiceId(), a.c.a), paramOnFenceListener);
        paramContext.clear();
        return;
      }
      catch (Exception paramHandler)
      {
        for (;;)
        {
          paramContext.put("monitored_person", paramHistoryAlarmRequest.getMonitoredPerson());
        }
      }
    }
    com.baidu.trace.c.a.a.execute(new ah(paramContext, paramHandler, paramHistoryAlarmRequest, paramOnFenceListener));
  }
  
  protected static void a(Context paramContext, Handler paramHandler, MonitoredStatusByLocationRequest paramMonitoredStatusByLocationRequest, OnFenceListener paramOnFenceListener)
  {
    if (FenceType.server == paramMonitoredStatusByLocationRequest.getFenceType())
    {
      paramContext = new TreeMap();
      if (!TextUtils.isEmpty(paramMonitoredStatusByLocationRequest.getMonitoredPerson())) {}
      try
      {
        paramContext.put("monitored_person", URLEncoder.encode(paramMonitoredStatusByLocationRequest.getMonitoredPerson(), "UTF-8"));
        if ((paramMonitoredStatusByLocationRequest.getFenceIds() != null) && (!paramMonitoredStatusByLocationRequest.getFenceIds().isEmpty())) {
          paramContext.put("fence_ids", a(paramMonitoredStatusByLocationRequest.getFenceIds()));
        }
        if (paramMonitoredStatusByLocationRequest.getLatLng() != null)
        {
          paramContext.put("longitude", String.valueOf(paramMonitoredStatusByLocationRequest.getLatLng().longitude));
          paramContext.put("latitude", String.valueOf(paramMonitoredStatusByLocationRequest.getLatLng().latitude));
        }
        if (paramMonitoredStatusByLocationRequest.getCoordType() != null) {
          paramContext.put("coord_type", String.valueOf(paramMonitoredStatusByLocationRequest.getCoordType().name()));
        }
        com.baidu.trace.c.a.a(paramMonitoredStatusByLocationRequest, 0, "fence/querystatusbylocation", a.c.a, 6, a(paramContext, paramMonitoredStatusByLocationRequest.getServiceId(), a.c.a), paramOnFenceListener);
        paramContext.clear();
        return;
      }
      catch (Exception paramHandler)
      {
        for (;;)
        {
          paramContext.put("monitored_person", paramMonitoredStatusByLocationRequest.getMonitoredPerson());
        }
      }
    }
    com.baidu.trace.c.a.a.execute(new ag(paramContext, paramHandler, paramMonitoredStatusByLocationRequest, paramOnFenceListener));
  }
  
  protected static void a(Context paramContext, Handler paramHandler, MonitoredStatusRequest paramMonitoredStatusRequest, OnFenceListener paramOnFenceListener)
  {
    if (FenceType.server == paramMonitoredStatusRequest.getFenceType())
    {
      paramContext = new TreeMap();
      if (!TextUtils.isEmpty(paramMonitoredStatusRequest.getMonitoredPerson())) {}
      try
      {
        paramContext.put("monitored_person", URLEncoder.encode(paramMonitoredStatusRequest.getMonitoredPerson(), "UTF-8"));
        if ((paramMonitoredStatusRequest.getFenceIds() != null) && (!paramMonitoredStatusRequest.getFenceIds().isEmpty())) {
          paramContext.put("fence_ids", a(paramMonitoredStatusRequest.getFenceIds()));
        }
        com.baidu.trace.c.a.a(paramMonitoredStatusRequest, 0, "fence/querystatus", a.c.a, 5, a(paramContext, paramMonitoredStatusRequest.getServiceId(), a.c.a), paramOnFenceListener);
        paramContext.clear();
        return;
      }
      catch (Exception paramHandler)
      {
        for (;;)
        {
          paramContext.put("monitored_person", paramMonitoredStatusRequest.getMonitoredPerson());
        }
      }
    }
    com.baidu.trace.c.a.a.execute(new af(paramContext, paramHandler, paramMonitoredStatusRequest, paramOnFenceListener));
  }
  
  protected static void a(Context paramContext, IService paramIService, Handler paramHandler, CreateFenceRequest paramCreateFenceRequest, OnFenceListener paramOnFenceListener)
  {
    if (FenceType.server == paramCreateFenceRequest.getFence().getFenceType())
    {
      paramContext = paramCreateFenceRequest.getFence();
      if ((paramContext instanceof CircleFence))
      {
        paramContext = (CircleFence)paramContext;
        a(paramCreateFenceRequest, 1, FenceShape.circle, 0L, paramContext.getFenceName(), paramContext.getMonitoredPerson(), null, paramContext.getCenter(), paramContext.getRadius(), null, 0, paramContext.getCoordType(), paramContext.getDenoise(), paramOnFenceListener);
      }
      do
      {
        return;
        if ((paramContext instanceof PolygonFence))
        {
          paramContext = (PolygonFence)paramContext;
          a(paramCreateFenceRequest, 1, FenceShape.polygon, 0L, paramContext.getFenceName(), paramContext.getMonitoredPerson(), null, null, 0.0D, paramContext.getVertexes(), 0, paramContext.getCoordType(), paramContext.getDenoise(), paramOnFenceListener);
          return;
        }
        if ((paramContext instanceof PolylineFence))
        {
          paramContext = (PolylineFence)paramContext;
          a(paramCreateFenceRequest, 1, FenceShape.polyline, 0L, paramContext.getFenceName(), paramContext.getMonitoredPerson(), null, null, 0.0D, paramContext.getVertexes(), paramContext.getOffset(), paramContext.getCoordType(), paramContext.getDenoise(), paramOnFenceListener);
          return;
        }
      } while (!(paramContext instanceof DistrictFence));
      paramContext = (DistrictFence)paramContext;
      a(paramCreateFenceRequest, 1, FenceShape.district, 0L, paramContext.getFenceName(), paramContext.getMonitoredPerson(), paramContext.getKeyword(), null, 0.0D, null, 0, null, paramContext.getDenoise(), paramOnFenceListener);
      return;
    }
    com.baidu.trace.c.a.a.execute(new ab(paramContext, paramHandler, paramCreateFenceRequest, paramOnFenceListener, paramIService));
  }
  
  protected static void a(Context paramContext, IService paramIService, Handler paramHandler, DeleteFenceRequest paramDeleteFenceRequest, OnFenceListener paramOnFenceListener)
  {
    if (FenceType.server == paramDeleteFenceRequest.getFenceType())
    {
      paramContext = new TreeMap();
      if ((paramDeleteFenceRequest.getFenceIds() != null) && (!paramDeleteFenceRequest.getFenceIds().isEmpty())) {
        paramContext.put("fence_ids", a(paramDeleteFenceRequest.getFenceIds()));
      }
      if (!TextUtils.isEmpty(paramDeleteFenceRequest.getMonitoredPerson())) {}
      try
      {
        paramContext.put("monitored_person", URLEncoder.encode(paramDeleteFenceRequest.getMonitoredPerson(), "UTF-8"));
        com.baidu.trace.c.a.a(paramDeleteFenceRequest, 0, "fence/delete", a.c.b, 3, a(paramContext, paramDeleteFenceRequest.getServiceId(), a.c.b), paramOnFenceListener);
        paramContext.clear();
        return;
      }
      catch (Exception paramIService)
      {
        for (;;)
        {
          paramContext.put("monitored_person", paramDeleteFenceRequest.getMonitoredPerson());
        }
      }
    }
    com.baidu.trace.c.a.a.execute(new ad(paramContext, paramHandler, paramDeleteFenceRequest, paramOnFenceListener, paramIService));
  }
  
  protected static void a(Context paramContext, IService paramIService, Handler paramHandler, UpdateFenceRequest paramUpdateFenceRequest, OnFenceListener paramOnFenceListener)
  {
    if (FenceType.server == paramUpdateFenceRequest.getFence().getFenceType())
    {
      paramContext = paramUpdateFenceRequest.getFence();
      if ((paramContext instanceof CircleFence))
      {
        paramContext = (CircleFence)paramContext;
        if (FenceType.server == paramContext.getFenceType()) {
          a(paramUpdateFenceRequest, 2, FenceShape.circle, paramContext.getFenceId(), paramContext.getFenceName(), paramContext.getMonitoredPerson(), null, paramContext.getCenter(), paramContext.getRadius(), null, 0, paramContext.getCoordType(), paramContext.getDenoise(), paramOnFenceListener);
        }
      }
      do
      {
        return;
        if ((paramContext instanceof PolygonFence))
        {
          paramContext = (PolygonFence)paramContext;
          a(paramUpdateFenceRequest, 2, FenceShape.polygon, paramContext.getFenceId(), paramContext.getFenceName(), paramContext.getMonitoredPerson(), null, null, 0.0D, paramContext.getVertexes(), 0, paramContext.getCoordType(), paramContext.getDenoise(), paramOnFenceListener);
          return;
        }
        if ((paramContext instanceof PolylineFence))
        {
          paramContext = (PolylineFence)paramContext;
          a(paramUpdateFenceRequest, 2, FenceShape.polyline, paramContext.getFenceId(), paramContext.getFenceName(), paramContext.getMonitoredPerson(), null, null, 0.0D, paramContext.getVertexes(), paramContext.getOffset(), paramContext.getCoordType(), paramContext.getDenoise(), paramOnFenceListener);
          return;
        }
      } while (!(paramContext instanceof DistrictFence));
      paramContext = (DistrictFence)paramContext;
      a(paramUpdateFenceRequest, 2, FenceShape.district, paramContext.getFenceId(), paramContext.getFenceName(), paramContext.getMonitoredPerson(), paramContext.getKeyword(), null, 0.0D, null, 0, null, paramContext.getDenoise(), paramOnFenceListener);
      return;
    }
    com.baidu.trace.c.a.a.execute(new ac(paramContext, paramHandler, paramUpdateFenceRequest, paramOnFenceListener, paramIService));
  }
  
  protected static void a(DrivingBehaviorRequest paramDrivingBehaviorRequest, OnAnalysisListener paramOnAnalysisListener)
  {
    a(paramDrivingBehaviorRequest, paramDrivingBehaviorRequest.getEntityName(), paramDrivingBehaviorRequest.getServiceId(), paramDrivingBehaviorRequest.getStartTime(), paramDrivingBehaviorRequest.getEndTime(), "analysis/drivingbehavior", 2, 0, 0, paramDrivingBehaviorRequest.getSpeedingThreshold(), paramDrivingBehaviorRequest.getThresholdOption(), paramDrivingBehaviorRequest.getProcessOption(), paramDrivingBehaviorRequest.getCoordTypeOutput(), paramOnAnalysisListener);
  }
  
  protected static void a(StayPointRequest paramStayPointRequest, OnAnalysisListener paramOnAnalysisListener)
  {
    a(paramStayPointRequest, paramStayPointRequest.getEntityName(), paramStayPointRequest.getServiceId(), paramStayPointRequest.getStartTime(), paramStayPointRequest.getEndTime(), "analysis/staypoint", 1, paramStayPointRequest.getStayTime(), paramStayPointRequest.getStayRadius(), 0, null, paramStayPointRequest.getProcessOption(), paramStayPointRequest.getCoordTypeOutput(), paramOnAnalysisListener);
  }
  
  protected static void a(BosGeneratePresignedUrlRequest paramBosGeneratePresignedUrlRequest, OnBosListener paramOnBosListener)
  {
    if (TextUtils.isEmpty(paramBosGeneratePresignedUrlRequest.getObjectKey()))
    {
      paramOnBosListener.onGeneratePresignedUrlCallback(new BosGeneratePresignedUrlResponse(paramBosGeneratePresignedUrlRequest.getTag(), 2, "objectKey参数错误"));
      return;
    }
    TreeMap localTreeMap = new TreeMap();
    try
    {
      localTreeMap.put("object_key", URLEncoder.encode(paramBosGeneratePresignedUrlRequest.getObjectKey(), "UTF-8"));
      if (paramBosGeneratePresignedUrlRequest.getObjectType() != null) {
        localTreeMap.put("object_type", paramBosGeneratePresignedUrlRequest.getObjectType().name());
      }
      str = h.a(paramBosGeneratePresignedUrlRequest);
      if (TextUtils.isEmpty(str)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        String str;
        localTreeMap.put("image_command", URLEncoder.encode(str, "UTF-8"));
        com.baidu.trace.c.a.a(paramBosGeneratePresignedUrlRequest, 3, "object/generatepresignedurl", a.c.b, 3, a(localTreeMap, paramBosGeneratePresignedUrlRequest.getServiceId(), a.c.b), paramOnBosListener);
        localTreeMap.clear();
        return;
        localException1 = localException1;
        localTreeMap.put("object_key", paramBosGeneratePresignedUrlRequest.getObjectKey());
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localTreeMap.put("image_command", localException1);
        }
      }
    }
  }
  
  protected static void a(BosGetObjectRequest paramBosGetObjectRequest, OnBosListener paramOnBosListener)
  {
    if (TextUtils.isEmpty(paramBosGetObjectRequest.getObjectKey()))
    {
      paramOnBosListener.onGetObjectCallback(new BosGetObjectResponse(paramBosGetObjectRequest.getTag(), 2, "objectKey参数错误"));
      return;
    }
    TreeMap localTreeMap = new TreeMap();
    try
    {
      localTreeMap.put("object_key", URLEncoder.encode(paramBosGetObjectRequest.getObjectKey(), "UTF-8"));
      if (paramBosGetObjectRequest.getObjectType() != null) {
        localTreeMap.put("object_type", paramBosGetObjectRequest.getObjectType().name());
      }
      com.baidu.trace.c.a.a(paramBosGetObjectRequest, 3, "object/preparetoget", a.c.b, 2, a(localTreeMap, paramBosGetObjectRequest.getServiceId(), a.c.b), paramOnBosListener);
      localTreeMap.clear();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localTreeMap.put("object_key", paramBosGetObjectRequest.getObjectKey());
      }
    }
  }
  
  protected static void a(BosPutObjectRequest paramBosPutObjectRequest, OnBosListener paramOnBosListener)
  {
    if (TextUtils.isEmpty(paramBosPutObjectRequest.getObjectKey()))
    {
      paramOnBosListener.onPutObjectCallback(new BosPutObjectResponse(paramBosPutObjectRequest.getTag(), 2, "objectKey参数错误"));
      return;
    }
    long l2 = 0L;
    Object localObject = paramBosPutObjectRequest.getFile();
    long l1;
    if (localObject != null) {
      l1 = ((File)localObject).length();
    }
    for (;;)
    {
      paramBosPutObjectRequest.setObjectSize(l1);
      localObject = new TreeMap();
      try
      {
        ((TreeMap)localObject).put("object_key", URLEncoder.encode(paramBosPutObjectRequest.getObjectKey(), "UTF-8"));
        if (paramBosPutObjectRequest.getObjectType() != null) {
          ((TreeMap)localObject).put("object_type", paramBosPutObjectRequest.getObjectType().name());
        }
        ((TreeMap)localObject).put("object_size", String.valueOf(l1 / 1024L));
        com.baidu.trace.c.a.a(paramBosPutObjectRequest, 3, "object/preparetoput", a.c.b, 1, a((TreeMap)localObject, paramBosPutObjectRequest.getServiceId(), a.c.b), paramOnBosListener);
        ((TreeMap)localObject).clear();
        return;
        localObject = paramBosPutObjectRequest.getStringData();
        if (localObject != null)
        {
          l1 = ((String)localObject).length();
        }
        else
        {
          localObject = paramBosPutObjectRequest.getByteArray();
          if (localObject != null)
          {
            l1 = localObject.length;
          }
          else
          {
            localObject = paramBosPutObjectRequest.getStreamData();
            l1 = l2;
            if (localObject == null) {}
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            int i = ((InputStream)localObject).available();
            l1 = i;
          }
          catch (IOException localIOException)
          {
            l1 = l2;
          }
          localException = localException;
          ((TreeMap)localObject).put("object_key", paramBosPutObjectRequest.getObjectKey());
        }
      }
    }
  }
  
  protected static void a(AddEntityRequest paramAddEntityRequest, OnEntityListener paramOnEntityListener)
  {
    TreeMap localTreeMap = new TreeMap();
    if (a(0, paramAddEntityRequest.getTag(), paramAddEntityRequest.getEntityName(), paramAddEntityRequest.getEntityDesc(), paramAddEntityRequest.getColumns(), localTreeMap, paramOnEntityListener)) {
      com.baidu.trace.c.a.a(paramAddEntityRequest, 1, "entity/add", a.c.b, 2, a(localTreeMap, paramAddEntityRequest.getServiceId(), a.c.b), paramOnEntityListener);
    }
    localTreeMap.clear();
  }
  
  protected static void a(AroundSearchRequest paramAroundSearchRequest, OnEntityListener paramOnEntityListener)
  {
    TreeMap localTreeMap = new TreeMap();
    if (paramAroundSearchRequest.getCenter() != null)
    {
      LatLng localLatLng = paramAroundSearchRequest.getCenter();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(localLatLng.latitude).append(",").append(localLatLng.longitude);
      localTreeMap.put("center", localStringBuffer.toString());
    }
    if (paramAroundSearchRequest.getRadius() > 0.0D) {
      localTreeMap.put("radius", String.valueOf(paramAroundSearchRequest.getRadius()));
    }
    if (paramAroundSearchRequest.getCoordTypeInput() != null) {
      localTreeMap.put("coord_type_input", paramAroundSearchRequest.getCoordTypeInput().name());
    }
    if (paramAroundSearchRequest.getCoordTypeOutput() != null) {
      localTreeMap.put("coord_type_output", paramAroundSearchRequest.getCoordTypeOutput().name());
    }
    a(paramAroundSearchRequest, localTreeMap, "entity/aroundsearch", 8, paramOnEntityListener);
    localTreeMap.clear();
  }
  
  protected static void a(BoundSearchRequest paramBoundSearchRequest, OnEntityListener paramOnEntityListener)
  {
    TreeMap localTreeMap = new TreeMap();
    if (paramBoundSearchRequest.getCoordTypeInput() != null) {
      localTreeMap.put("coord_type_input", paramBoundSearchRequest.getCoordTypeInput().name());
    }
    if (paramBoundSearchRequest.getCoordTypeOutput() != null) {
      localTreeMap.put("coord_type_output", paramBoundSearchRequest.getCoordTypeOutput().name());
    }
    if ((paramBoundSearchRequest.getLowerLeft() != null) && (paramBoundSearchRequest.getUpperRight() != null))
    {
      LatLng localLatLng1 = paramBoundSearchRequest.getLowerLeft();
      LatLng localLatLng2 = paramBoundSearchRequest.getUpperRight();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(localLatLng1.latitude).append(",").append(localLatLng1.longitude).append(";");
      localStringBuffer.append(localLatLng2.latitude).append(",").append(localLatLng2.longitude);
      localTreeMap.put("bounds", localStringBuffer.toString());
    }
    a(paramBoundSearchRequest, localTreeMap, "entity/boundsearch", 7, paramOnEntityListener);
    localTreeMap.clear();
  }
  
  private static void a(CommonRequest paramCommonRequest, TreeMap<String, String> paramTreeMap, String paramString, int paramInt, OnEntityListener paramOnEntityListener)
  {
    aa.a(paramCommonRequest.getFilterCondition(), paramTreeMap);
    aa.a(paramCommonRequest.getSortBy(), paramTreeMap);
    e.a(paramCommonRequest.getPageIndex(), paramCommonRequest.getPageSize(), paramTreeMap);
    com.baidu.trace.c.a.a(paramCommonRequest, 1, paramString, a.c.a, paramInt, a(paramTreeMap, paramCommonRequest.getServiceId(), a.c.a), paramOnEntityListener);
  }
  
  protected static void a(DeleteEntityRequest paramDeleteEntityRequest, OnEntityListener paramOnEntityListener)
  {
    TreeMap localTreeMap = new TreeMap();
    if (a(2, paramDeleteEntityRequest.getTag(), paramDeleteEntityRequest.getEntityName(), null, null, localTreeMap, paramOnEntityListener)) {
      com.baidu.trace.c.a.a(paramDeleteEntityRequest, 1, "entity/delete", a.c.b, 3, a(localTreeMap, paramDeleteEntityRequest.getServiceId(), a.c.b), paramOnEntityListener);
    }
    localTreeMap.clear();
  }
  
  protected static void a(DistrictSearchRequest paramDistrictSearchRequest, OnEntityListener paramOnEntityListener)
  {
    TreeMap localTreeMap = new TreeMap();
    if (!TextUtils.isEmpty(paramDistrictSearchRequest.getKeyword())) {}
    try
    {
      localTreeMap.put("keyword", URLEncoder.encode(paramDistrictSearchRequest.getKeyword(), "UTF-8"));
      if (paramDistrictSearchRequest.getReturnType() != null) {
        localTreeMap.put("return_type", paramDistrictSearchRequest.getReturnType().name());
      }
      if (paramDistrictSearchRequest.getCoordTypeOutput() != null) {
        localTreeMap.put("coord_type_output", paramDistrictSearchRequest.getCoordTypeOutput().name());
      }
      a(paramDistrictSearchRequest, localTreeMap, "entity/districtsearch", 10, paramOnEntityListener);
      localTreeMap.clear();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localTreeMap.put("keyword", paramDistrictSearchRequest.getKeyword());
      }
    }
  }
  
  protected static void a(EntityListRequest paramEntityListRequest, OnEntityListener paramOnEntityListener)
  {
    TreeMap localTreeMap = new TreeMap();
    if (paramEntityListRequest.getCoordTypeOutput() != null) {
      localTreeMap.put("coord_type_output", paramEntityListRequest.getCoordTypeOutput().name());
    }
    a(paramEntityListRequest, localTreeMap, "entity/list", 1, paramOnEntityListener);
    localTreeMap.clear();
  }
  
  protected static void a(LocRequest paramLocRequest, String paramString, OnEntityListener paramOnEntityListener)
  {
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("apinfo", paramString);
    com.baidu.trace.c.a.a(paramLocRequest, 1, "internal/androidlocate", a.c.b, 5, a(localTreeMap, paramLocRequest.getServiceId(), a.c.b), paramOnEntityListener);
    localTreeMap.clear();
  }
  
  protected static void a(PolygonSearchRequest paramPolygonSearchRequest, OnEntityListener paramOnEntityListener)
  {
    TreeMap localTreeMap = new TreeMap();
    if (paramPolygonSearchRequest.getVertexes() != null) {
      aa.a(paramPolygonSearchRequest.getVertexes(), localTreeMap);
    }
    if (paramPolygonSearchRequest.getCoordTypeInput() != null) {
      localTreeMap.put("coord_type_input", paramPolygonSearchRequest.getCoordTypeInput().name());
    }
    if (paramPolygonSearchRequest.getCoordTypeOutput() != null) {
      localTreeMap.put("coord_type_output", paramPolygonSearchRequest.getCoordTypeOutput().name());
    }
    a(paramPolygonSearchRequest, localTreeMap, "entity/polygonsearch", 9, paramOnEntityListener);
    localTreeMap.clear();
  }
  
  protected static void a(SearchRequest paramSearchRequest, OnEntityListener paramOnEntityListener)
  {
    TreeMap localTreeMap = new TreeMap();
    if (paramSearchRequest.getCoordTypeOutput() != null) {
      localTreeMap.put("coord_type_output", paramSearchRequest.getCoordTypeOutput().name());
    }
    String str = paramSearchRequest.getKeyword();
    if (e.a(str)) {}
    try
    {
      localTreeMap.put("query", URLEncoder.encode(str, "UTF-8"));
      a(paramSearchRequest, localTreeMap, "entity/search", 6, paramOnEntityListener);
      localTreeMap.clear();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localTreeMap.put("query", str);
      }
    }
  }
  
  protected static void a(UpdateEntityRequest paramUpdateEntityRequest, OnEntityListener paramOnEntityListener)
  {
    TreeMap localTreeMap = new TreeMap();
    if (a(1, paramUpdateEntityRequest.getTag(), paramUpdateEntityRequest.getEntityName(), paramUpdateEntityRequest.getEntityDesc(), paramUpdateEntityRequest.getColumns(), localTreeMap, paramOnEntityListener)) {
      com.baidu.trace.c.a.a(paramUpdateEntityRequest, 1, "entity/update", a.c.b, 4, a(localTreeMap, paramUpdateEntityRequest.getServiceId(), a.c.b), paramOnEntityListener);
    }
    localTreeMap.clear();
  }
  
  protected static void a(CircleFence paramCircleFence, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("latitude", paramCircleFence.getCenter().latitude);
    localJSONObject1.put("longitude", paramCircleFence.getCenter().longitude);
    if (paramStringBuffer2 != null)
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("radius", paramCircleFence.getRadius());
      localJSONObject2.put("center", localJSONObject1);
      paramStringBuffer2.append(localJSONObject2.toString());
    }
    if (paramStringBuffer1 != null)
    {
      paramStringBuffer2 = new JSONObject();
      paramStringBuffer2.put("fenceName", paramCircleFence.getFenceName());
      paramStringBuffer2.put("monitoredPerson", paramCircleFence.getMonitoredPerson());
      paramStringBuffer2.put("coordType", paramCircleFence.getCoordType());
      paramStringBuffer2.put("denoise", paramCircleFence.getDenoise());
      paramStringBuffer2.put("fenceShape", CircleFence.class.getSimpleName());
      paramStringBuffer2.put("radius", paramCircleFence.getRadius());
      paramStringBuffer2.put("center", localJSONObject1);
      paramStringBuffer1.append(paramStringBuffer2.toString());
    }
  }
  
  protected static void a(Fence paramFence, String paramString, LatLng paramLatLng, List<MonitoredStatusInfo> paramList)
  {
    long l;
    if ((paramFence instanceof CircleFence))
    {
      CircleFence localCircleFence = (CircleFence)paramFence;
      l = paramFence.getFenceId();
      if (localCircleFence.getMonitoredPerson().equals(paramString))
      {
        paramFence = new MonitoredStatusInfo();
        double d1 = e.a(localCircleFence.getCenter(), paramLatLng);
        if (localCircleFence.getRadius() <= d1) {
          break label83;
        }
        paramFence.setMonitoredStatus(MonitoredStatus.in);
      }
    }
    for (;;)
    {
      paramFence.setFenceId(l);
      paramList.add(paramFence);
      return;
      label83:
      paramFence.setMonitoredStatus(MonitoredStatus.out);
    }
  }
  
  protected static void a(AddPointRequest paramAddPointRequest, OnTrackListener paramOnTrackListener)
  {
    TreeMap localTreeMap = new TreeMap();
    if (!TextUtils.isEmpty(paramAddPointRequest.getEntityName())) {}
    try
    {
      localTreeMap.put("entity_name", URLEncoder.encode(paramAddPointRequest.getEntityName(), "UTF-8"));
      AddPointResponse localAddPointResponse = new AddPointResponse(paramAddPointRequest.getTag());
      localObject = paramAddPointRequest.getPoint();
      if (localObject == null)
      {
        localAddPointResponse.setStatus(2);
        localAddPointResponse.setMessage("point参数错误");
        paramOnTrackListener.onAddPointCallback(localAddPointResponse);
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        localTreeMap.put("entity_name", paramAddPointRequest.getEntityName());
      }
      LatLng localLatLng = ((Point)localObject).getLocation();
      if (e.a(localLatLng))
      {
        localTreeMap.put("latitude", String.valueOf(localLatLng.getLatitude()));
        localTreeMap.put("longitude", String.valueOf(localLatLng.getLongitude()));
        if (((Point)localObject).getLocTime() > 0L)
        {
          localTreeMap.put("loc_time", String.valueOf(((Point)localObject).getLocTime()));
          if (((Point)localObject).getCoordType() != null) {
            localTreeMap.put("coord_type_input", ((Point)localObject).getCoordType().name());
          }
          localTreeMap.put("speed", String.valueOf(((Point)localObject).getSpeed()));
          localTreeMap.put("direction", String.valueOf(((Point)localObject).getDirection()));
          localTreeMap.put("height", String.valueOf(((Point)localObject).getHeight()));
          localTreeMap.put("radius", String.valueOf(((Point)localObject).getRadius()));
          if (!TextUtils.isEmpty(paramAddPointRequest.getObjectName())) {
            localTreeMap.put("object_name", paramAddPointRequest.getObjectName());
          }
          localObject = paramAddPointRequest.getColumns();
          if ((localObject == null) || (a((Map)localObject, localTreeMap, null))) {
            break label350;
          }
          localException.setStatus(2);
          localException.setMessage("column_key参数错误");
          paramOnTrackListener.onAddPointCallback(localException);
        }
      }
      else
      {
        localException.setStatus(2);
        localException.setMessage("location参数错误");
        paramOnTrackListener.onAddPointCallback(localException);
        return;
      }
    }
    localException.setStatus(2);
    localException.setMessage("locTime参数错误");
    paramOnTrackListener.onAddPointCallback(localException);
    return;
    label350:
    com.baidu.trace.c.a.a(paramAddPointRequest, 2, "track/addpoint", a.c.b, 4, a(localTreeMap, paramAddPointRequest.getServiceId(), a.c.b), paramOnTrackListener);
    localTreeMap.clear();
  }
  
  protected static void a(AddPointsRequest paramAddPointsRequest, OnTrackListener paramOnTrackListener)
  {
    TreeMap localTreeMap = new TreeMap();
    AddPointsResponse localAddPointsResponse = new AddPointsResponse(paramAddPointsRequest.getTag());
    Map localMap = paramAddPointsRequest.getPoints();
    if (localMap == null)
    {
      localAddPointsResponse.setStatus(2);
      localAddPointsResponse.setMessage("pointList参数错误");
      paramOnTrackListener.onAddPointsCallback(localAddPointsResponse);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (a(localMap, localStringBuffer))
    {
      if (!TextUtils.isEmpty(localStringBuffer)) {}
      try
      {
        localTreeMap.put("point_list", URLEncoder.encode(localStringBuffer.toString(), "UTF-8"));
        com.baidu.trace.c.a.a(paramAddPointsRequest, 2, "track/addpoints", a.c.b, 5, a(localTreeMap, paramAddPointsRequest.getServiceId(), a.c.b), paramOnTrackListener);
        localTreeMap.clear();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localTreeMap.put("point_list", localStringBuffer.toString());
        }
      }
    }
    localException.setStatus(2);
    localException.setMessage("pointList参数错误");
    paramOnTrackListener.onAddPointsCallback(localException);
  }
  
  protected static void a(DistanceRequest paramDistanceRequest, OnTrackListener paramOnTrackListener)
  {
    TreeMap localTreeMap = new TreeMap();
    a(paramDistanceRequest, "track/getdistance", 2, paramDistanceRequest.getServiceId(), paramDistanceRequest.getEntityName(), paramDistanceRequest.getStartTime(), paramDistanceRequest.getEndTime(), paramDistanceRequest.isProcessed(), paramDistanceRequest.getProcessOption(), paramDistanceRequest.getSupplementMode(), null, null, 0, 0, localTreeMap, paramOnTrackListener);
    localTreeMap.clear();
  }
  
  protected static void a(HistoryTrackRequest paramHistoryTrackRequest, OnTrackListener paramOnTrackListener)
  {
    TreeMap localTreeMap = new TreeMap();
    a(paramHistoryTrackRequest, "track/gettrack", 1, paramHistoryTrackRequest.getServiceId(), paramHistoryTrackRequest.getEntityName(), paramHistoryTrackRequest.getStartTime(), paramHistoryTrackRequest.getEndTime(), paramHistoryTrackRequest.isProcessed(), paramHistoryTrackRequest.getProcessOption(), paramHistoryTrackRequest.getSupplementMode(), paramHistoryTrackRequest.getCoordTypeOutput(), paramHistoryTrackRequest.getSortType(), paramHistoryTrackRequest.getPageSize(), paramHistoryTrackRequest.getPageIndex(), localTreeMap, paramOnTrackListener);
    localTreeMap.clear();
  }
  
  protected static void a(LatestPointRequest paramLatestPointRequest, OnTrackListener paramOnTrackListener)
  {
    TreeMap localTreeMap = new TreeMap();
    a(paramLatestPointRequest, "track/getlatestpoint", 3, paramLatestPointRequest.getServiceId(), paramLatestPointRequest.getEntityName(), 0L, 0L, false, paramLatestPointRequest.getProcessOption(), null, paramLatestPointRequest.getCoordTypeOutput(), null, 0, 0, localTreeMap, paramOnTrackListener);
    localTreeMap.clear();
  }
  
  private static void a(BaseRequest paramBaseRequest, int paramInt1, FenceShape paramFenceShape, long paramLong, String paramString1, String paramString2, String paramString3, LatLng paramLatLng, double paramDouble, List<LatLng> paramList, int paramInt2, CoordType paramCoordType, int paramInt3, OnFenceListener paramOnFenceListener)
  {
    TreeMap localTreeMap = new TreeMap();
    if (paramLong > 0L) {
      localTreeMap.put("fence_id", String.valueOf(paramLong));
    }
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      localTreeMap.put("fence_name", URLEncoder.encode(paramString1, "UTF-8"));
      if (TextUtils.isEmpty(paramString2)) {}
    }
    catch (Exception paramString1)
    {
      try
      {
        localTreeMap.put("monitored_person", URLEncoder.encode(paramString2, "UTF-8"));
        if (paramLatLng != null)
        {
          localTreeMap.put("longitude", String.valueOf(paramLatLng.longitude));
          localTreeMap.put("latitude", String.valueOf(paramLatLng.latitude));
        }
        if (paramDouble > 0.0D) {
          localTreeMap.put("radius", String.valueOf(paramDouble));
        }
        if (paramList != null) {
          localTreeMap.put("vertexes", String.valueOf(b(paramList)));
        }
        if (paramInt2 > 0) {
          localTreeMap.put("offset", String.valueOf(paramInt2));
        }
        if (paramCoordType != null) {
          localTreeMap.put("coord_type", paramCoordType.name());
        }
        if (paramInt3 >= 0) {
          localTreeMap.put("denoise", String.valueOf(paramInt3));
        }
        if (TextUtils.isEmpty(paramString3)) {}
      }
      catch (Exception paramString1)
      {
        try
        {
          for (;;)
          {
            localTreeMap.put("keyword", URLEncoder.encode(paramString3, "UTF-8"));
            paramString2 = "";
            if (1 != paramInt1) {
              break label410;
            }
            if (FenceShape.circle != paramFenceShape) {
              break;
            }
            paramString1 = "createcirclefence";
            if (!localTreeMap.isEmpty()) {
              com.baidu.trace.c.a.a(paramBaseRequest, 0, "fence/" + paramString1, a.c.b, paramInt1, a(localTreeMap, paramBaseRequest.getServiceId(), a.c.b), paramOnFenceListener);
            }
            localTreeMap.clear();
            return;
            localException = localException;
            localTreeMap.put("fence_name", paramString1);
          }
          paramString1 = paramString1;
          localTreeMap.put("monitored_person", paramString2);
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            localTreeMap.put("keyword", paramString3);
            continue;
            if (FenceShape.polygon == paramFenceShape)
            {
              paramString1 = "createpolygonfence";
            }
            else if (FenceShape.polyline == paramFenceShape)
            {
              paramString1 = "createpolylinefence";
            }
            else
            {
              paramString1 = paramString2;
              if (FenceShape.district == paramFenceShape)
              {
                paramString1 = "createdistrictfence";
                continue;
                label410:
                paramString1 = paramString2;
                if (2 == paramInt1) {
                  if (FenceShape.circle == paramFenceShape)
                  {
                    paramString1 = "updatecirclefence";
                  }
                  else if (FenceShape.polygon == paramFenceShape)
                  {
                    paramString1 = "updatepolygonfence";
                  }
                  else if (FenceShape.polyline == paramFenceShape)
                  {
                    paramString1 = "updatepolylinefence";
                  }
                  else
                  {
                    paramString1 = paramString2;
                    if (FenceShape.district == paramFenceShape) {
                      paramString1 = "updatedistrictfence";
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(BaseRequest paramBaseRequest, int paramInt1, boolean paramBoolean, int paramInt2, String paramString, OnAnalysisListener paramOnAnalysisListener)
  {
    int i = paramBaseRequest.getTag();
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      paramBaseRequest = new StayPointResponse(i, paramInt2, paramString);
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          localObject = new JSONObject(paramString);
          paramBoolean = b(paramString, paramBaseRequest);
          if (paramBoolean) {
            continue;
          }
        }
        catch (Exception paramString)
        {
          StayPoint localStayPoint;
          JSONObject localJSONObject;
          paramString = paramString;
          continue;
        }
        finally {}
        paramOnAnalysisListener.onStayPointCallback(paramBaseRequest);
        return;
        if (((JSONObject)localObject).has("staypoint_num")) {
          paramBaseRequest.setStayPointNum(((JSONObject)localObject).getInt("staypoint_num"));
        }
        paramString = new ArrayList();
        if (((JSONObject)localObject).has("stay_points"))
        {
          localObject = ((JSONObject)localObject).getJSONArray("stay_points");
          paramInt2 = ((JSONArray)localObject).length();
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            localStayPoint = new StayPoint();
            localJSONObject = ((JSONArray)localObject).getJSONObject(paramInt1);
            if (localJSONObject.has("start_time")) {
              localStayPoint.setStartTime(localJSONObject.getLong("start_time"));
            }
            if (localJSONObject.has("end_time")) {
              localStayPoint.setEndTime(localJSONObject.getLong("end_time"));
            }
            if (localJSONObject.has("duration")) {
              localStayPoint.setDuration(localJSONObject.getInt("duration"));
            }
            if (localJSONObject.has("stay_point"))
            {
              localJSONObject = localJSONObject.getJSONObject("stay_point");
              if ((localJSONObject.has("longitude")) && (localJSONObject.has("latitude"))) {
                localStayPoint.setLocation(new LatLng(localJSONObject.getDouble("latitude"), localJSONObject.getDouble("longitude")));
              }
              if (localJSONObject.has("coord_type")) {
                localStayPoint.setCoordType(CoordType.valueOf(localJSONObject.getString("coord_type")));
              }
            }
            paramString.add(localStayPoint);
            paramInt1 += 1;
            continue;
          }
        }
        paramBaseRequest.setStayPoints(paramString);
      }
    }
    Object localObject = new DrivingBehaviorResponse(i, paramInt2, paramString);
    if (paramBoolean) {
      a(paramString, ((DrivingBehaviorRequest)paramBaseRequest).getCoordTypeOutput(), (DrivingBehaviorResponse)localObject);
    }
    paramOnAnalysisListener.onDrivingBehaviorCallback((DrivingBehaviorResponse)localObject);
  }
  
  public static void a(BaseRequest paramBaseRequest, int paramInt1, boolean paramBoolean, int paramInt2, String paramString, OnFenceListener paramOnFenceListener)
  {
    int i = paramBaseRequest.getTag();
    Object localObject = FenceShape.circle;
    Fence localFence;
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      localFence = ((CreateFenceRequest)paramBaseRequest).getFence();
      if ((localFence instanceof PolygonFence))
      {
        paramBaseRequest = FenceShape.polygon;
        paramBaseRequest = new CreateFenceResponse(i, paramInt2, paramString, localFence.getFenceName(), paramBaseRequest, FenceType.server);
        if (!paramBoolean) {}
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject(paramString);
          paramBoolean = b(paramString, paramBaseRequest);
          if (paramBoolean) {
            continue;
          }
        }
        catch (Exception paramString)
        {
          paramString = paramString;
          continue;
        }
        finally {}
        paramOnFenceListener.onCreateFenceCallback(paramBaseRequest);
        return;
        if ((localFence instanceof PolylineFence))
        {
          paramBaseRequest = FenceShape.polyline;
          break;
        }
        paramBaseRequest = (BaseRequest)localObject;
        if (!(localFence instanceof DistrictFence)) {
          break;
        }
        paramBaseRequest = FenceShape.district;
        break;
        if (((JSONObject)localObject).has("fence_id")) {
          paramBaseRequest.setFenceId(((JSONObject)localObject).getLong("fence_id"));
        }
        if (((JSONObject)localObject).has("fence_name")) {
          paramBaseRequest.setFenceName(((JSONObject)localObject).getString("fence_name"));
        }
        if (((JSONObject)localObject).has("shape")) {
          paramBaseRequest.setFenceShape((FenceShape)FenceShape.valueOf(FenceShape.class, ((JSONObject)localObject).getString("shape")));
        }
        if (((JSONObject)localObject).has("district")) {
          paramBaseRequest.setDistrict(((JSONObject)localObject).getString("district"));
        }
        if (((JSONObject)localObject).has("district_list"))
        {
          paramString = ((JSONObject)localObject).getJSONArray("district_list");
          paramInt2 = paramString.length();
          localObject = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            ((List)localObject).add(paramString.getString(paramInt1));
            paramInt1 += 1;
          }
          else
          {
            paramBaseRequest.setDistrictList((List)localObject);
          }
        }
      }
    case 2: 
      localFence = ((UpdateFenceRequest)paramBaseRequest).getFence();
      paramBaseRequest = localFence.getFenceName();
      localObject = new UpdateFenceResponse(i, paramInt2, paramString, localFence.getFenceId(), paramBaseRequest, FenceType.server);
      paramBaseRequest = FenceShape.circle;
      if ((localFence instanceof CircleFence)) {
        paramBaseRequest = FenceShape.circle;
      }
      for (;;)
      {
        ((UpdateFenceResponse)localObject).setFenceShape(paramBaseRequest);
        if (paramBoolean) {
          a(paramString, (UpdateFenceResponse)localObject);
        }
        paramOnFenceListener.onUpdateFenceCallback((UpdateFenceResponse)localObject);
        return;
        if ((localFence instanceof PolygonFence)) {
          paramBaseRequest = FenceShape.polygon;
        } else if ((localFence instanceof PolylineFence)) {
          paramBaseRequest = FenceShape.polyline;
        } else if ((localFence instanceof DistrictFence)) {
          paramBaseRequest = FenceShape.district;
        }
      }
    case 3: 
      paramBaseRequest = new DeleteFenceResponse(i, paramInt2, paramString, FenceType.server);
      if (paramBoolean) {
        a(paramString, paramBaseRequest);
      }
      paramOnFenceListener.onDeleteFenceCallback(paramBaseRequest);
      return;
    case 4: 
      localObject = new FenceListResponse(i, paramInt2, paramString, FenceType.server);
      if (paramBoolean) {
        a(paramString, ((FenceListRequest)paramBaseRequest).getCoordTypeOutput(), (FenceListResponse)localObject);
      }
      paramOnFenceListener.onFenceListCallback((FenceListResponse)localObject);
      return;
    case 5: 
      paramBaseRequest = new MonitoredStatusResponse(i, paramInt2, paramString, FenceType.server);
      if (paramBoolean) {
        a(paramString, paramBaseRequest);
      }
      paramOnFenceListener.onMonitoredStatusCallback(paramBaseRequest);
      return;
    case 6: 
      paramBaseRequest = new MonitoredStatusByLocationResponse(i, paramInt2, paramString, FenceType.server);
      if (paramBoolean) {
        a(paramString, paramBaseRequest);
      }
      paramOnFenceListener.onMonitoredStatusByLocationCallback(paramBaseRequest);
      return;
    }
    localObject = new HistoryAlarmResponse(i, paramInt2, paramString, FenceType.server);
    if (paramBoolean) {
      a(paramString, ((HistoryAlarmRequest)paramBaseRequest).getCoordTypeOutput(), (HistoryAlarmResponse)localObject);
    }
    paramOnFenceListener.onHistoryAlarmCallback((HistoryAlarmResponse)localObject);
  }
  
  /* Error */
  public static void a(BaseRequest paramBaseRequest, int paramInt1, boolean paramBoolean, int paramInt2, String paramString, OnTrackListener paramOnTrackListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1052	com/baidu/trace/model/BaseRequest:getTag	()I
    //   4: istore 6
    //   6: aload_0
    //   7: instanceof 973
    //   10: ifeq +47 -> 57
    //   13: aload_0
    //   14: checkcast 973	com/baidu/trace/api/track/DistanceRequest
    //   17: invokevirtual 975	com/baidu/trace/api/track/DistanceRequest:getEntityName	()Ljava/lang/String;
    //   20: astore 7
    //   22: iload_1
    //   23: tableswitch	default:+33->56, 1:+72->95, 2:+481->504, 3:+567->590, 4:+614->637, 5:+645->668
    //   56: return
    //   57: aload_0
    //   58: instanceof 993
    //   61: ifeq +15 -> 76
    //   64: aload_0
    //   65: checkcast 993	com/baidu/trace/api/track/HistoryTrackRequest
    //   68: invokevirtual 995	com/baidu/trace/api/track/HistoryTrackRequest:getEntityName	()Ljava/lang/String;
    //   71: astore 7
    //   73: goto -51 -> 22
    //   76: aload_0
    //   77: instanceof 1012
    //   80: ifeq +618 -> 698
    //   83: aload_0
    //   84: checkcast 1012	com/baidu/trace/api/track/LatestPointRequest
    //   87: invokevirtual 1014	com/baidu/trace/api/track/LatestPointRequest:getEntityName	()Ljava/lang/String;
    //   90: astore 7
    //   92: goto -70 -> 22
    //   95: new 1254	com/baidu/trace/api/track/HistoryTrackResponse
    //   98: dup
    //   99: iload 6
    //   101: iload_3
    //   102: aload 4
    //   104: invokespecial 1255	com/baidu/trace/api/track/HistoryTrackResponse:<init>	(IILjava/lang/String;)V
    //   107: astore 8
    //   109: iload_2
    //   110: ifeq +27 -> 137
    //   113: aload_0
    //   114: checkcast 993	com/baidu/trace/api/track/HistoryTrackRequest
    //   117: invokevirtual 1001	com/baidu/trace/api/track/HistoryTrackRequest:getCoordTypeOutput	()Lcom/baidu/trace/model/CoordType;
    //   120: astore_0
    //   121: aload_0
    //   122: ifnull +30 -> 152
    //   125: aload 4
    //   127: aload 8
    //   129: invokestatic 1059	com/baidu/trace/a:b	(Ljava/lang/String;Lcom/baidu/trace/model/BaseResponse;)Z
    //   132: istore_2
    //   133: iload_2
    //   134: ifne +25 -> 159
    //   137: aload 8
    //   139: aload 7
    //   141: invokevirtual 1258	com/baidu/trace/api/track/HistoryTrackResponse:setEntityName	(Ljava/lang/String;)V
    //   144: aload 5
    //   146: aload 8
    //   148: invokevirtual 1262	com/baidu/trace/api/track/OnTrackListener:onHistoryTrackCallback	(Lcom/baidu/trace/api/track/HistoryTrackResponse;)V
    //   151: return
    //   152: getstatic 1266	com/baidu/trace/model/CoordType:bd09ll	Lcom/baidu/trace/model/CoordType;
    //   155: astore_0
    //   156: goto -31 -> 125
    //   159: new 798	org/json/JSONObject
    //   162: dup
    //   163: aload 4
    //   165: invokespecial 1056	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   168: astore 9
    //   170: aload 9
    //   172: ldc_w 1268
    //   175: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   178: ifeq +16 -> 194
    //   181: aload 8
    //   183: aload 9
    //   185: ldc_w 1268
    //   188: invokevirtual 1074	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   191: invokevirtual 1271	com/baidu/trace/api/track/HistoryTrackResponse:setTotal	(I)V
    //   194: aload 9
    //   196: ldc_w 1273
    //   199: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   202: ifeq +16 -> 218
    //   205: aload 8
    //   207: aload 9
    //   209: ldc_w 1273
    //   212: invokevirtual 1074	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   215: invokevirtual 1276	com/baidu/trace/api/track/HistoryTrackResponse:setSize	(I)V
    //   218: aload 9
    //   220: ldc_w 1278
    //   223: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   226: ifeq +16 -> 242
    //   229: aload 8
    //   231: aload 9
    //   233: ldc_w 1278
    //   236: invokevirtual 1120	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   239: invokevirtual 1282	com/baidu/trace/api/track/HistoryTrackResponse:setDistance	(D)V
    //   242: aload 9
    //   244: ldc_w 1284
    //   247: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   250: ifeq +16 -> 266
    //   253: aload 8
    //   255: aload 9
    //   257: ldc_w 1284
    //   260: invokevirtual 1120	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   263: invokevirtual 1287	com/baidu/trace/api/track/HistoryTrackResponse:setTollDistance	(D)V
    //   266: aload 9
    //   268: ldc_w 1289
    //   271: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   274: ifeq +39 -> 313
    //   277: aload 9
    //   279: ldc_w 1289
    //   282: invokevirtual 1116	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   285: astore 4
    //   287: new 888	com/baidu/trace/model/Point
    //   290: dup
    //   291: aconst_null
    //   292: aload_0
    //   293: invokespecial 1292	com/baidu/trace/model/Point:<init>	(Lcom/baidu/trace/model/LatLng;Lcom/baidu/trace/model/CoordType;)V
    //   296: astore 10
    //   298: aload 4
    //   300: aload 10
    //   302: aconst_null
    //   303: invokestatic 1295	com/baidu/trace/a:a	(Lorg/json/JSONObject;Lcom/baidu/trace/model/Point;Ljava/util/List;)V
    //   306: aload 8
    //   308: aload 10
    //   310: invokevirtual 1299	com/baidu/trace/api/track/HistoryTrackResponse:setStartPoint	(Lcom/baidu/trace/model/Point;)V
    //   313: aload 9
    //   315: ldc_w 1301
    //   318: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   321: ifeq +39 -> 360
    //   324: aload 9
    //   326: ldc_w 1301
    //   329: invokevirtual 1116	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   332: astore 4
    //   334: new 888	com/baidu/trace/model/Point
    //   337: dup
    //   338: aconst_null
    //   339: aload_0
    //   340: invokespecial 1292	com/baidu/trace/model/Point:<init>	(Lcom/baidu/trace/model/LatLng;Lcom/baidu/trace/model/CoordType;)V
    //   343: astore 10
    //   345: aload 4
    //   347: aload 10
    //   349: aconst_null
    //   350: invokestatic 1295	com/baidu/trace/a:a	(Lorg/json/JSONObject;Lcom/baidu/trace/model/Point;Ljava/util/List;)V
    //   353: aload 8
    //   355: aload 10
    //   357: invokevirtual 1304	com/baidu/trace/api/track/HistoryTrackResponse:setEndPoint	(Lcom/baidu/trace/model/Point;)V
    //   360: new 1079	java/util/ArrayList
    //   363: dup
    //   364: invokespecial 1080	java/util/ArrayList:<init>	()V
    //   367: astore 4
    //   369: aload 9
    //   371: ldc_w 1306
    //   374: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   377: ifeq +114 -> 491
    //   380: aload 9
    //   382: ldc_w 1306
    //   385: invokevirtual 1086	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   388: astore 9
    //   390: aload 9
    //   392: invokevirtual 1089	org/json/JSONArray:length	()I
    //   395: istore_3
    //   396: iconst_0
    //   397: istore_1
    //   398: iload_1
    //   399: iload_3
    //   400: if_icmpge +91 -> 491
    //   403: aload 9
    //   405: iload_1
    //   406: invokevirtual 1096	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   409: astore 10
    //   411: aload 10
    //   413: invokevirtual 1309	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   416: astore 12
    //   418: new 1079	java/util/ArrayList
    //   421: dup
    //   422: invokespecial 1080	java/util/ArrayList:<init>	()V
    //   425: astore 11
    //   427: aload 12
    //   429: invokeinterface 52 1 0
    //   434: ifeq +21 -> 455
    //   437: aload 11
    //   439: aload 12
    //   441: invokeinterface 56 1 0
    //   446: invokeinterface 852 2 0
    //   451: pop
    //   452: goto -25 -> 427
    //   455: new 1311	com/baidu/trace/api/track/TrackPoint
    //   458: dup
    //   459: aload_0
    //   460: invokespecial 1313	com/baidu/trace/api/track/TrackPoint:<init>	(Lcom/baidu/trace/model/CoordType;)V
    //   463: astore 12
    //   465: aload 10
    //   467: aload 12
    //   469: aload 11
    //   471: invokestatic 1295	com/baidu/trace/a:a	(Lorg/json/JSONObject;Lcom/baidu/trace/model/Point;Ljava/util/List;)V
    //   474: aload 4
    //   476: aload 12
    //   478: invokeinterface 852 2 0
    //   483: pop
    //   484: iload_1
    //   485: iconst_1
    //   486: iadd
    //   487: istore_1
    //   488: goto -90 -> 398
    //   491: aload 8
    //   493: aload 4
    //   495: invokevirtual 1316	com/baidu/trace/api/track/HistoryTrackResponse:setTrackPoints	(Ljava/util/List;)V
    //   498: goto -361 -> 137
    //   501: astore_0
    //   502: aload_0
    //   503: athrow
    //   504: new 1318	com/baidu/trace/api/track/DistanceResponse
    //   507: dup
    //   508: iload 6
    //   510: iload_3
    //   511: aload 4
    //   513: invokespecial 1319	com/baidu/trace/api/track/DistanceResponse:<init>	(IILjava/lang/String;)V
    //   516: astore_0
    //   517: iload_2
    //   518: ifeq +14 -> 532
    //   521: aload 4
    //   523: aload_0
    //   524: invokestatic 1059	com/baidu/trace/a:b	(Ljava/lang/String;Lcom/baidu/trace/model/BaseResponse;)Z
    //   527: istore_2
    //   528: iload_2
    //   529: ifne +16 -> 545
    //   532: aload_0
    //   533: aload 7
    //   535: invokevirtual 1320	com/baidu/trace/api/track/DistanceResponse:setEntityName	(Ljava/lang/String;)V
    //   538: aload 5
    //   540: aload_0
    //   541: invokevirtual 1324	com/baidu/trace/api/track/OnTrackListener:onDistanceCallback	(Lcom/baidu/trace/api/track/DistanceResponse;)V
    //   544: return
    //   545: new 798	org/json/JSONObject
    //   548: dup
    //   549: aload 4
    //   551: invokespecial 1056	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   554: astore 4
    //   556: aload 4
    //   558: ldc_w 1278
    //   561: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   564: ifeq -32 -> 532
    //   567: aload_0
    //   568: aload 4
    //   570: ldc_w 1278
    //   573: invokevirtual 1120	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   576: invokevirtual 1325	com/baidu/trace/api/track/DistanceResponse:setDistance	(D)V
    //   579: goto -47 -> 532
    //   582: astore 4
    //   584: goto -52 -> 532
    //   587: astore_0
    //   588: aload_0
    //   589: athrow
    //   590: new 1327	com/baidu/trace/api/track/LatestPointResponse
    //   593: dup
    //   594: iload 6
    //   596: iload_3
    //   597: aload 4
    //   599: invokespecial 1328	com/baidu/trace/api/track/LatestPointResponse:<init>	(IILjava/lang/String;)V
    //   602: astore 8
    //   604: iload_2
    //   605: ifeq +17 -> 622
    //   608: aload 4
    //   610: aload_0
    //   611: checkcast 1012	com/baidu/trace/api/track/LatestPointRequest
    //   614: invokevirtual 1016	com/baidu/trace/api/track/LatestPointRequest:getCoordTypeOutput	()Lcom/baidu/trace/model/CoordType;
    //   617: aload 8
    //   619: invokestatic 1331	com/baidu/trace/a:a	(Ljava/lang/String;Lcom/baidu/trace/model/CoordType;Lcom/baidu/trace/api/track/LatestPointResponse;)V
    //   622: aload 8
    //   624: aload 7
    //   626: invokevirtual 1332	com/baidu/trace/api/track/LatestPointResponse:setEntityName	(Ljava/lang/String;)V
    //   629: aload 5
    //   631: aload 8
    //   633: invokevirtual 1336	com/baidu/trace/api/track/OnTrackListener:onLatestPointCallback	(Lcom/baidu/trace/api/track/LatestPointResponse;)V
    //   636: return
    //   637: new 864	com/baidu/trace/api/track/AddPointResponse
    //   640: dup
    //   641: iload 6
    //   643: iload_3
    //   644: aload 4
    //   646: invokespecial 1337	com/baidu/trace/api/track/AddPointResponse:<init>	(IILjava/lang/String;)V
    //   649: astore_0
    //   650: iload_2
    //   651: ifeq +10 -> 661
    //   654: aload 4
    //   656: aload_0
    //   657: invokestatic 1059	com/baidu/trace/a:b	(Ljava/lang/String;Lcom/baidu/trace/model/BaseResponse;)Z
    //   660: pop
    //   661: aload 5
    //   663: aload_0
    //   664: invokevirtual 886	com/baidu/trace/api/track/OnTrackListener:onAddPointCallback	(Lcom/baidu/trace/api/track/AddPointResponse;)V
    //   667: return
    //   668: new 945	com/baidu/trace/api/track/AddPointsResponse
    //   671: dup
    //   672: iload 6
    //   674: iload_3
    //   675: aload 4
    //   677: invokespecial 1338	com/baidu/trace/api/track/AddPointsResponse:<init>	(IILjava/lang/String;)V
    //   680: astore_0
    //   681: iload_2
    //   682: ifeq +9 -> 691
    //   685: aload 4
    //   687: aload_0
    //   688: invokestatic 1341	com/baidu/trace/a:a	(Ljava/lang/String;Lcom/baidu/trace/api/track/AddPointsResponse;)V
    //   691: aload 5
    //   693: aload_0
    //   694: invokevirtual 960	com/baidu/trace/api/track/OnTrackListener:onAddPointsCallback	(Lcom/baidu/trace/api/track/AddPointsResponse;)V
    //   697: return
    //   698: ldc 79
    //   700: astore 7
    //   702: goto -680 -> 22
    //   705: astore_0
    //   706: goto -569 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	709	0	paramBaseRequest	BaseRequest
    //   0	709	1	paramInt1	int
    //   0	709	2	paramBoolean	boolean
    //   0	709	3	paramInt2	int
    //   0	709	4	paramString	String
    //   0	709	5	paramOnTrackListener	OnTrackListener
    //   4	669	6	i	int
    //   20	681	7	str	String
    //   107	525	8	localObject1	Object
    //   168	236	9	localObject2	Object
    //   296	170	10	localObject3	Object
    //   425	45	11	localArrayList	ArrayList
    //   416	61	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   125	133	501	finally
    //   159	194	501	finally
    //   194	218	501	finally
    //   218	242	501	finally
    //   242	266	501	finally
    //   266	313	501	finally
    //   313	360	501	finally
    //   360	396	501	finally
    //   403	427	501	finally
    //   427	452	501	finally
    //   455	484	501	finally
    //   491	498	501	finally
    //   521	528	582	java/lang/Exception
    //   545	579	582	java/lang/Exception
    //   521	528	587	finally
    //   545	579	587	finally
    //   125	133	705	java/lang/Exception
    //   159	194	705	java/lang/Exception
    //   194	218	705	java/lang/Exception
    //   218	242	705	java/lang/Exception
    //   242	266	705	java/lang/Exception
    //   266	313	705	java/lang/Exception
    //   313	360	705	java/lang/Exception
    //   360	396	705	java/lang/Exception
    //   403	427	705	java/lang/Exception
    //   427	452	705	java/lang/Exception
    //   455	484	705	java/lang/Exception
    //   491	498	705	java/lang/Exception
  }
  
  private static void a(BaseRequest paramBaseRequest, String paramString1, int paramInt1, long paramLong1, String paramString2, long paramLong2, long paramLong3, boolean paramBoolean, ProcessOption paramProcessOption, SupplementMode paramSupplementMode, CoordType paramCoordType, SortType paramSortType, int paramInt2, int paramInt3, TreeMap<String, String> paramTreeMap, OnTrackListener paramOnTrackListener)
  {
    if (!TextUtils.isEmpty(paramString2)) {}
    try
    {
      paramTreeMap.put("entity_name", URLEncoder.encode(paramString2, "UTF-8"));
      if (paramLong2 > 0L) {
        paramTreeMap.put("start_time", String.valueOf(paramLong2));
      }
      if (paramLong3 > 0L) {
        paramTreeMap.put("end_time", String.valueOf(paramLong3));
      }
      if (paramBoolean)
      {
        paramString2 = String.valueOf(1);
        paramTreeMap.put("is_processed", paramString2);
        if (paramSupplementMode != null) {
          paramTreeMap.put("supplement_mode", paramSupplementMode.name());
        }
        a(paramProcessOption, paramTreeMap);
        if (paramCoordType != null) {
          paramTreeMap.put("coord_type_output", paramCoordType.name());
        }
        if (paramSortType != null) {
          paramTreeMap.put("sort_type", paramSortType.name());
        }
        if (paramInt2 > 0) {
          paramTreeMap.put("page_size", String.valueOf(paramInt2));
        }
        if (paramInt3 > 0) {
          paramTreeMap.put("page_index", String.valueOf(paramInt3));
        }
        com.baidu.trace.c.a.a(paramBaseRequest, 2, paramString1, a.c.a, paramInt1, a(paramTreeMap, paramLong1, a.c.a), paramOnTrackListener);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramTreeMap.put("entity_name", paramString2);
        continue;
        paramString2 = String.valueOf(0);
      }
    }
  }
  
  private static void a(BaseRequest paramBaseRequest, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ThresholdOption paramThresholdOption, ProcessOption paramProcessOption, CoordType paramCoordType, OnAnalysisListener paramOnAnalysisListener)
  {
    if (!e.a(paramString1))
    {
      if ((paramBaseRequest instanceof StayPointRequest)) {
        paramOnAnalysisListener.onStayPointCallback(new StayPointResponse(paramBaseRequest.getTag(), 2, "entityName参数错误"));
      }
      while (!(paramBaseRequest instanceof DrivingBehaviorRequest)) {
        return;
      }
      paramOnAnalysisListener.onDrivingBehaviorCallback(new DrivingBehaviorResponse(paramBaseRequest.getTag(), 2, "entityName参数错误"));
      return;
    }
    TreeMap localTreeMap = new TreeMap();
    try
    {
      localTreeMap.put("entity_name", URLEncoder.encode(paramString1, "UTF-8"));
      if (paramLong2 > 0L) {
        localTreeMap.put("start_time", String.valueOf(paramLong2));
      }
      if (paramLong3 > 0L) {
        localTreeMap.put("end_time", String.valueOf(paramLong3));
      }
      if (paramInt2 > 0) {
        localTreeMap.put("stay_time", String.valueOf(paramInt2));
      }
      if (paramInt3 > 0) {
        localTreeMap.put("stay_radius", String.valueOf(paramInt3));
      }
      if (paramThresholdOption != null)
      {
        if (paramThresholdOption.getSpeedingThreshold() > 0.0D) {
          localTreeMap.put("speeding_threshold", String.valueOf(paramThresholdOption.getSpeedingThreshold()));
        }
        if (paramThresholdOption.getHarshAccelerationThreshold() > 0.0D) {
          localTreeMap.put("harsh_acceleration_threshold", String.valueOf(paramThresholdOption.getHarshAccelerationThreshold()));
        }
        if (paramThresholdOption.getHarshBreakingThreshold() < 0.0D) {
          localTreeMap.put("harsh_breaking_threshold", String.valueOf(paramThresholdOption.getHarshBreakingThreshold()));
        }
        if (paramThresholdOption.getHarshSteeringThreshold() > 0.0D) {
          localTreeMap.put("harsh_steering_threshold", String.valueOf(paramThresholdOption.getHarshSteeringThreshold()));
        }
      }
      if (paramInt4 > 0) {
        localTreeMap.put("speeding_threshold", String.valueOf(paramInt4));
      }
      a(paramProcessOption, localTreeMap);
      if (paramCoordType != null) {
        localTreeMap.put("coord_type_output", paramCoordType.name());
      }
      com.baidu.trace.c.a.a(paramBaseRequest, 4, paramString2, a.c.a, paramInt1, a(localTreeMap, paramLong1, a.c.a), paramOnAnalysisListener);
      localTreeMap.clear();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localTreeMap.put("entity_name", paramString1);
      }
    }
  }
  
  protected static void a(ProcessOption paramProcessOption, TreeMap<String, String> paramTreeMap)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    if ((paramProcessOption != null) && (paramProcessOption.isNeedDenoise()))
    {
      localStringBuffer.append("need_denoise=").append(1);
      if ((paramProcessOption == null) || (!paramProcessOption.isNeedVacuate())) {
        break label212;
      }
      localStringBuffer.append(",need_vacuate").append("=1");
      label58:
      if ((paramProcessOption == null) || (!paramProcessOption.isNeedMapMatch())) {
        break label229;
      }
      localStringBuffer.append(",need_mapmatch").append("=1");
    }
    for (;;)
    {
      if ((paramProcessOption != null) && (paramProcessOption.getRadiusThreshold() > 0)) {
        localStringBuffer.append(",radius_threshold").append("=").append(paramProcessOption.getRadiusThreshold());
      }
      if ((paramProcessOption != null) && (paramProcessOption.getTransportMode() != null)) {
        localStringBuffer.append(",transport_mode").append("=").append(paramProcessOption.getTransportMode().name());
      }
      if ((localStringBuffer.length() > 0) && (localStringBuffer.charAt(0) == ',')) {
        localStringBuffer.replace(0, 1, "");
      }
      if (!TextUtils.isEmpty(localStringBuffer.toString())) {
        paramTreeMap.put("process_option", localStringBuffer.toString());
      }
      return;
      localStringBuffer.append("need_denoise=").append(0);
      break;
      label212:
      localStringBuffer.append(",need_vacuate").append("=0");
      break label58;
      label229:
      localStringBuffer.append(",need_mapmatch").append("=0");
    }
  }
  
  public static void a(String paramString)
  {
    if (Thread.currentThread().getStackTrace().length == 0) {
      return;
    }
    com.baidu.trace.c.h.a("INFO", paramString);
  }
  
  public static void a(String paramString, DeleteFenceResponse paramDeleteFenceResponse)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      if (!b(paramString, paramDeleteFenceResponse)) {
        return;
      }
      paramString = new ArrayList();
      if (((JSONObject)localObject).has("fence_ids"))
      {
        localObject = ((JSONObject)localObject).getJSONArray("fence_ids");
        int j = ((JSONArray)localObject).length();
        int i = 0;
        while (i < j)
        {
          paramString.add(Long.valueOf(((JSONArray)localObject).getLong(i)));
          i += 1;
        }
      }
      paramDeleteFenceResponse.setFenceIds(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, UpdateFenceResponse paramUpdateFenceResponse)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      if (!b(paramString, paramUpdateFenceResponse)) {
        return;
      }
      if (((JSONObject)localObject).has("district")) {
        paramUpdateFenceResponse.setDistrict(((JSONObject)localObject).getString("district"));
      }
      if (((JSONObject)localObject).has("district_list"))
      {
        paramString = ((JSONObject)localObject).getJSONArray("district_list");
        int j = paramString.length();
        localObject = new ArrayList();
        int i = 0;
        while (i < j)
        {
          ((List)localObject).add(paramString.getString(i));
          i += 1;
        }
        paramUpdateFenceResponse.setDistrictList((List)localObject);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString = paramString;
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, AddPointsResponse paramAddPointsResponse)
  {
    int j = 0;
    try
    {
      if (!b(paramString, paramAddPointsResponse)) {
        return;
      }
      Object localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).has("success_num")) {
        paramAddPointsResponse.setSuccessNum(((JSONObject)localObject1).getInt("success_num"));
      }
      paramString = new FailInfo();
      if (((JSONObject)localObject1).has("fail_info"))
      {
        localObject1 = ((JSONObject)localObject1).getJSONObject("fail_info");
        ArrayList localArrayList = new ArrayList();
        Object localObject2;
        int i;
        if (((JSONObject)localObject1).has("param_error"))
        {
          localObject2 = ((JSONObject)localObject1).getJSONArray("param_error");
          i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            paramString.getClass();
            FailInfo.ParamError localParamError = new FailInfo.ParamError(paramString);
            a(((JSONArray)localObject2).getJSONObject(i), localParamError);
            localArrayList.add(localParamError);
            i += 1;
          }
        }
        paramString.setParamErrors(localArrayList);
        localArrayList = new ArrayList();
        if (((JSONObject)localObject1).has("internal_error"))
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("internal_error");
          i = j;
          while (i < ((JSONArray)localObject1).length())
          {
            paramString.getClass();
            localObject2 = new FailInfo.InternalError(paramString);
            a(((JSONArray)localObject1).getJSONObject(i), (FailInfo.InternalError)localObject2);
            localArrayList.add(localObject2);
            i += 1;
          }
        }
        paramString.setInternalErrors(localArrayList);
      }
      paramAddPointsResponse.setFailInfo(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(String paramString, BaseResponse paramBaseResponse)
  {
    // Byte code:
    //   0: new 798	org/json/JSONObject
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 1056	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload_0
    //   11: aload_1
    //   12: invokestatic 1059	com/baidu/trace/a:b	(Ljava/lang/String;Lcom/baidu/trace/model/BaseResponse;)Z
    //   15: ifne +4 -> 19
    //   18: return
    //   19: aload 4
    //   21: ldc_w 1273
    //   24: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   27: ifeq +25 -> 52
    //   30: aload_1
    //   31: instanceof 1226
    //   34: ifeq +150 -> 184
    //   37: aload_1
    //   38: checkcast 1226	com/baidu/trace/api/fence/MonitoredStatusResponse
    //   41: aload 4
    //   43: ldc_w 1273
    //   46: invokevirtual 1074	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   49: invokevirtual 1504	com/baidu/trace/api/fence/MonitoredStatusResponse:setSize	(I)V
    //   52: new 1079	java/util/ArrayList
    //   55: dup
    //   56: invokespecial 1080	java/util/ArrayList:<init>	()V
    //   59: astore_0
    //   60: aload 4
    //   62: ldc_w 1506
    //   65: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   68: ifeq +141 -> 209
    //   71: aload 4
    //   73: ldc_w 1506
    //   76: invokevirtual 1086	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   79: astore 4
    //   81: aload 4
    //   83: invokevirtual 1089	org/json/JSONArray:length	()I
    //   86: istore_3
    //   87: iconst_0
    //   88: istore_2
    //   89: iload_2
    //   90: iload_3
    //   91: if_icmpge +118 -> 209
    //   94: new 832	com/baidu/trace/api/fence/MonitoredStatusInfo
    //   97: dup
    //   98: invokespecial 833	com/baidu/trace/api/fence/MonitoredStatusInfo:<init>	()V
    //   101: astore 5
    //   103: aload 4
    //   105: iload_2
    //   106: invokevirtual 1096	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   109: astore 6
    //   111: aload 6
    //   113: ldc_w 1018
    //   116: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   119: ifeq +16 -> 135
    //   122: aload 5
    //   124: aload 6
    //   126: ldc_w 1018
    //   129: invokevirtual 1100	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   132: invokevirtual 849	com/baidu/trace/api/fence/MonitoredStatusInfo:setFenceId	(J)V
    //   135: aload 6
    //   137: ldc_w 1508
    //   140: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   143: ifeq +25 -> 168
    //   146: aload 5
    //   148: ldc_w 838
    //   151: aload 6
    //   153: ldc_w 1508
    //   156: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokestatic 1509	com/baidu/trace/api/fence/MonitoredStatus:valueOf	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;
    //   162: checkcast 838	com/baidu/trace/api/fence/MonitoredStatus
    //   165: invokevirtual 846	com/baidu/trace/api/fence/MonitoredStatusInfo:setMonitoredStatus	(Lcom/baidu/trace/api/fence/MonitoredStatus;)V
    //   168: aload_0
    //   169: aload 5
    //   171: invokeinterface 852 2 0
    //   176: pop
    //   177: iload_2
    //   178: iconst_1
    //   179: iadd
    //   180: istore_2
    //   181: goto -92 -> 89
    //   184: aload_1
    //   185: instanceof 1236
    //   188: ifeq -136 -> 52
    //   191: aload_1
    //   192: checkcast 1236	com/baidu/trace/api/fence/MonitoredStatusByLocationResponse
    //   195: aload 4
    //   197: ldc_w 1273
    //   200: invokevirtual 1074	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   203: invokevirtual 1510	com/baidu/trace/api/fence/MonitoredStatusByLocationResponse:setSize	(I)V
    //   206: goto -154 -> 52
    //   209: aload_1
    //   210: instanceof 1226
    //   213: ifeq +15 -> 228
    //   216: aload_1
    //   217: checkcast 1226	com/baidu/trace/api/fence/MonitoredStatusResponse
    //   220: aload_0
    //   221: invokevirtual 1513	com/baidu/trace/api/fence/MonitoredStatusResponse:setMonitoredStatusInfos	(Ljava/util/List;)V
    //   224: return
    //   225: astore_0
    //   226: aload_0
    //   227: athrow
    //   228: aload_1
    //   229: instanceof 1236
    //   232: ifeq +11 -> 243
    //   235: aload_1
    //   236: checkcast 1236	com/baidu/trace/api/fence/MonitoredStatusByLocationResponse
    //   239: aload_0
    //   240: invokevirtual 1514	com/baidu/trace/api/fence/MonitoredStatusByLocationResponse:setMonitoredStatusInfos	(Ljava/util/List;)V
    //   243: return
    //   244: astore_0
    //   245: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramString	String
    //   0	246	1	paramBaseResponse	BaseResponse
    //   88	93	2	i	int
    //   86	6	3	j	int
    //   8	188	4	localObject	Object
    //   101	69	5	localMonitoredStatusInfo	MonitoredStatusInfo
    //   109	43	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	18	225	finally
    //   19	52	225	finally
    //   52	87	225	finally
    //   94	135	225	finally
    //   135	168	225	finally
    //   168	177	225	finally
    //   184	206	225	finally
    //   209	224	225	finally
    //   228	243	225	finally
    //   0	18	244	java/lang/Exception
    //   19	52	244	java/lang/Exception
    //   52	87	244	java/lang/Exception
    //   94	135	244	java/lang/Exception
    //   135	168	244	java/lang/Exception
    //   168	177	244	java/lang/Exception
    //   184	206	244	java/lang/Exception
    //   209	224	244	java/lang/Exception
    //   228	243	244	java/lang/Exception
  }
  
  public static void a(String paramString, CoordType paramCoordType, DrivingBehaviorResponse paramDrivingBehaviorResponse)
  {
    if (paramCoordType != null) {}
    label805:
    for (;;)
    {
      try
      {
        Object localObject1;
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        ArrayList localArrayList3;
        int i;
        JSONArray localJSONArray;
        int j;
        Object localObject3;
        Object localObject2;
        try
        {
          JSONObject localJSONObject1 = new JSONObject(paramString);
          boolean bool = b(paramString, paramDrivingBehaviorResponse);
          if (!bool)
          {
            return;
            paramCoordType = CoordType.bd09ll;
            continue;
          }
          if (localJSONObject1.has("distance")) {
            paramDrivingBehaviorResponse.setDistance(localJSONObject1.getDouble("distance"));
          }
          if (localJSONObject1.has("duration")) {
            paramDrivingBehaviorResponse.setDuration(localJSONObject1.getInt("duration"));
          }
          if (localJSONObject1.has("average_speed")) {
            paramDrivingBehaviorResponse.setAverageSpeed(localJSONObject1.getDouble("average_speed"));
          }
          if (localJSONObject1.has("max_speed")) {
            paramDrivingBehaviorResponse.setMaxSpeed(localJSONObject1.getDouble("max_speed"));
          }
          if (localJSONObject1.has("speeding_num")) {
            paramDrivingBehaviorResponse.setSpeedingNum(localJSONObject1.getInt("speeding_num"));
          }
          if (localJSONObject1.has("harsh_acceleration_num")) {
            paramDrivingBehaviorResponse.setHarshAccelerationNum(localJSONObject1.getInt("harsh_acceleration_num"));
          }
          if (localJSONObject1.has("harsh_breaking_num")) {
            paramDrivingBehaviorResponse.setHarshBreakingNum(localJSONObject1.getInt("harsh_breaking_num"));
          }
          if (localJSONObject1.has("harsh_steering_num")) {
            paramDrivingBehaviorResponse.setHarshSteeringNum(localJSONObject1.getInt("harsh_steering_num"));
          }
          if (localJSONObject1.has("start_point"))
          {
            paramString = localJSONObject1.getJSONObject("start_point");
            localObject1 = new StartPoint(paramCoordType);
            a(paramString, (Point)localObject1, null);
            paramDrivingBehaviorResponse.setStartPoint((StartPoint)localObject1);
          }
          if (localJSONObject1.has("end_point"))
          {
            paramString = localJSONObject1.getJSONObject("end_point");
            localObject1 = new EndPoint(paramCoordType);
            a(paramString, (Point)localObject1, null);
            paramDrivingBehaviorResponse.setEndPoint((EndPoint)localObject1);
          }
          paramString = new String[4];
          paramString[0] = "speeding";
          paramString[1] = "harsh_acceleration";
          paramString[2] = "harsh_breaking";
          paramString[3] = "harsh_steering";
          localObject1 = new ArrayList();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          localArrayList3 = new ArrayList();
          i = 0;
          if ((i >= paramString.length) || (!localJSONObject1.has(paramString[i]))) {
            continue;
          }
          localJSONArray = localJSONObject1.getJSONArray(paramString[i]);
          int m = localJSONArray.length();
          j = 0;
          if (j >= m) {
            break label805;
          }
          if ("speeding".equals(paramString[i]))
          {
            localObject3 = localJSONArray.getJSONObject(j);
            localObject2 = new SpeedingInfo();
            if (((JSONObject)localObject3).has("speeding_distance")) {
              ((SpeedingInfo)localObject2).setDistance(((JSONObject)localObject3).getDouble("speeding_distance"));
            }
            if (((JSONObject)localObject3).has("speeding_points"))
            {
              localObject3 = ((JSONObject)localObject3).getJSONArray("speeding_points");
              ArrayList localArrayList4 = new ArrayList();
              int n = ((JSONArray)localObject3).length();
              int k = 0;
              if (k < n)
              {
                SpeedingPoint localSpeedingPoint = new SpeedingPoint(paramCoordType);
                JSONObject localJSONObject2 = ((JSONArray)localObject3).getJSONObject(k);
                a(localJSONObject2, localSpeedingPoint, null);
                a(localJSONObject2, localSpeedingPoint);
                localArrayList4.add(localSpeedingPoint);
                k += 1;
                continue;
              }
              ((SpeedingInfo)localObject2).setPoints(localArrayList4);
            }
            ((List)localObject1).add(localObject2);
            continue;
          }
          if ("harsh_acceleration".equals(paramString[i]))
          {
            localObject2 = new HarshAccelerationPoint(paramCoordType);
            localObject3 = localJSONArray.getJSONObject(j);
            a((JSONObject)localObject3, (Point)localObject2, null);
            a((JSONObject)localObject3, (Point)localObject2);
            localArrayList1.add(localObject2);
            continue;
          }
          if ("harsh_breaking".equals(paramString[i]))
          {
            localObject2 = new HarshBreakingPoint(paramCoordType);
            localObject3 = localJSONArray.getJSONObject(j);
            a((JSONObject)localObject3, (Point)localObject2, null);
            a((JSONObject)localObject3, (Point)localObject2);
            localArrayList2.add(localObject2);
            continue;
          }
        }
        finally {}
        if ("harsh_steering".equals(paramString[i]))
        {
          localObject2 = new HarshSteeringPoint(paramCoordType);
          localObject3 = localJSONArray.getJSONObject(j);
          a((JSONObject)localObject3, (Point)localObject2, null);
          a((JSONObject)localObject3, (Point)localObject2);
          localArrayList3.add(localObject2);
          continue;
          paramDrivingBehaviorResponse.setSpeedings((List)localObject1);
          paramDrivingBehaviorResponse.setHarshAccelerationPoints(localArrayList1);
          paramDrivingBehaviorResponse.setHarshBreakingPoints(localArrayList2);
          paramDrivingBehaviorResponse.setHarshSteeringPoints(localArrayList3);
          return;
        }
        j += 1;
        continue;
        i += 1;
      }
      catch (Exception paramString)
      {
        return;
      }
    }
  }
  
  /* Error */
  public static void a(String paramString, CoordType paramCoordType, com.baidu.trace.api.entity.CommonResponse paramCommonResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +16 -> 17
    //   4: aload_0
    //   5: aload_2
    //   6: invokestatic 1059	com/baidu/trace/a:b	(Ljava/lang/String;Lcom/baidu/trace/model/BaseResponse;)Z
    //   9: istore 5
    //   11: iload 5
    //   13: ifne +11 -> 24
    //   16: return
    //   17: getstatic 1266	com/baidu/trace/model/CoordType:bd09ll	Lcom/baidu/trace/model/CoordType;
    //   20: astore_1
    //   21: goto -17 -> 4
    //   24: new 798	org/json/JSONObject
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 1056	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   32: astore 6
    //   34: aload 6
    //   36: ldc_w 1268
    //   39: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   42: ifeq +15 -> 57
    //   45: aload_2
    //   46: aload 6
    //   48: ldc_w 1268
    //   51: invokevirtual 1074	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   54: invokevirtual 1608	com/baidu/trace/api/entity/CommonResponse:setTotal	(I)V
    //   57: aload 6
    //   59: ldc_w 1273
    //   62: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   65: ifeq +15 -> 80
    //   68: aload_2
    //   69: aload 6
    //   71: ldc_w 1273
    //   74: invokevirtual 1074	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   77: invokevirtual 1609	com/baidu/trace/api/entity/CommonResponse:setSize	(I)V
    //   80: new 1079	java/util/ArrayList
    //   83: dup
    //   84: invokespecial 1080	java/util/ArrayList:<init>	()V
    //   87: astore_0
    //   88: aload 6
    //   90: ldc_w 1611
    //   93: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   96: ifeq +417 -> 513
    //   99: aload 6
    //   101: ldc_w 1611
    //   104: invokevirtual 1086	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   107: astore 7
    //   109: aload 7
    //   111: invokevirtual 1089	org/json/JSONArray:length	()I
    //   114: istore 4
    //   116: iconst_0
    //   117: istore_3
    //   118: iload_3
    //   119: iload 4
    //   121: if_icmpge +392 -> 513
    //   124: new 1613	com/baidu/trace/api/entity/EntityInfo
    //   127: dup
    //   128: invokespecial 1614	com/baidu/trace/api/entity/EntityInfo:<init>	()V
    //   131: astore 8
    //   133: aload 7
    //   135: iload_3
    //   136: invokevirtual 1096	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   139: astore 9
    //   141: aload 9
    //   143: invokevirtual 1309	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   146: astore 11
    //   148: new 1079	java/util/ArrayList
    //   151: dup
    //   152: invokespecial 1080	java/util/ArrayList:<init>	()V
    //   155: astore 10
    //   157: aload 11
    //   159: invokeinterface 52 1 0
    //   164: ifeq +21 -> 185
    //   167: aload 10
    //   169: aload 11
    //   171: invokeinterface 56 1 0
    //   176: invokeinterface 852 2 0
    //   181: pop
    //   182: goto -25 -> 157
    //   185: aload 9
    //   187: ldc_w 862
    //   190: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   193: ifeq +27 -> 220
    //   196: aload 8
    //   198: aload 9
    //   200: ldc_w 862
    //   203: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: invokevirtual 1615	com/baidu/trace/api/entity/EntityInfo:setEntityName	(Ljava/lang/String;)V
    //   209: aload 10
    //   211: ldc_w 862
    //   214: invokeinterface 1618 2 0
    //   219: pop
    //   220: aload 9
    //   222: ldc_w 1620
    //   225: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   228: ifeq +27 -> 255
    //   231: aload 8
    //   233: aload 9
    //   235: ldc_w 1620
    //   238: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   241: invokevirtual 1623	com/baidu/trace/api/entity/EntityInfo:setEntityDesc	(Ljava/lang/String;)V
    //   244: aload 10
    //   246: ldc_w 1620
    //   249: invokeinterface 1618 2 0
    //   254: pop
    //   255: aload 9
    //   257: ldc_w 1625
    //   260: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   263: ifeq +27 -> 290
    //   266: aload 8
    //   268: aload 9
    //   270: ldc_w 1625
    //   273: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   276: invokevirtual 1628	com/baidu/trace/api/entity/EntityInfo:setCreateTime	(Ljava/lang/String;)V
    //   279: aload 10
    //   281: ldc_w 1625
    //   284: invokeinterface 1618 2 0
    //   289: pop
    //   290: aload 9
    //   292: ldc_w 1630
    //   295: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   298: ifeq +27 -> 325
    //   301: aload 8
    //   303: aload 9
    //   305: ldc_w 1630
    //   308: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   311: invokevirtual 1633	com/baidu/trace/api/entity/EntityInfo:setModifyTime	(Ljava/lang/String;)V
    //   314: aload 10
    //   316: ldc_w 1630
    //   319: invokeinterface 1618 2 0
    //   324: pop
    //   325: aload 9
    //   327: ldc_w 1635
    //   330: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   333: ifeq +97 -> 430
    //   336: aload 9
    //   338: ldc_w 1635
    //   341: invokevirtual 1116	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   344: astore 11
    //   346: aload 10
    //   348: ldc_w 1635
    //   351: invokeinterface 1618 2 0
    //   356: pop
    //   357: aload 11
    //   359: invokevirtual 1309	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   362: astore 13
    //   364: new 1079	java/util/ArrayList
    //   367: dup
    //   368: invokespecial 1080	java/util/ArrayList:<init>	()V
    //   371: astore 12
    //   373: aload 13
    //   375: invokeinterface 52 1 0
    //   380: ifeq +24 -> 404
    //   383: aload 12
    //   385: aload 13
    //   387: invokeinterface 56 1 0
    //   392: invokeinterface 852 2 0
    //   397: pop
    //   398: goto -25 -> 373
    //   401: astore_0
    //   402: aload_0
    //   403: athrow
    //   404: new 1637	com/baidu/trace/api/entity/LatestLocation
    //   407: dup
    //   408: aload_1
    //   409: invokespecial 1638	com/baidu/trace/api/entity/LatestLocation:<init>	(Lcom/baidu/trace/model/CoordType;)V
    //   412: astore 13
    //   414: aload 11
    //   416: aload 13
    //   418: aload 12
    //   420: invokestatic 1295	com/baidu/trace/a:a	(Lorg/json/JSONObject;Lcom/baidu/trace/model/Point;Ljava/util/List;)V
    //   423: aload 8
    //   425: aload 13
    //   427: invokevirtual 1642	com/baidu/trace/api/entity/EntityInfo:setLatestLocation	(Lcom/baidu/trace/api/entity/LatestLocation;)V
    //   430: new 1644	java/util/HashMap
    //   433: dup
    //   434: invokespecial 1645	java/util/HashMap:<init>	()V
    //   437: astore 11
    //   439: aload 10
    //   441: invokeinterface 46 1 0
    //   446: astore 10
    //   448: aload 10
    //   450: invokeinterface 52 1 0
    //   455: ifeq +35 -> 490
    //   458: aload 10
    //   460: invokeinterface 56 1 0
    //   465: checkcast 108	java/lang/String
    //   468: astore 12
    //   470: aload 11
    //   472: aload 12
    //   474: aload 9
    //   476: aload 12
    //   478: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   481: invokeinterface 1648 3 0
    //   486: pop
    //   487: goto -39 -> 448
    //   490: aload 8
    //   492: aload 11
    //   494: invokevirtual 1652	com/baidu/trace/api/entity/EntityInfo:setColumns	(Ljava/util/Map;)V
    //   497: aload_0
    //   498: aload 8
    //   500: invokeinterface 852 2 0
    //   505: pop
    //   506: iload_3
    //   507: iconst_1
    //   508: iadd
    //   509: istore_3
    //   510: goto -392 -> 118
    //   513: aload_2
    //   514: instanceof 1654
    //   517: ifeq +75 -> 592
    //   520: aload 6
    //   522: ldc_w 1184
    //   525: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   528: ifeq +64 -> 592
    //   531: aload 6
    //   533: ldc_w 1184
    //   536: invokevirtual 1086	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   539: astore_1
    //   540: aload_1
    //   541: invokevirtual 1089	org/json/JSONArray:length	()I
    //   544: istore 4
    //   546: new 1079	java/util/ArrayList
    //   549: dup
    //   550: invokespecial 1080	java/util/ArrayList:<init>	()V
    //   553: astore 6
    //   555: iconst_0
    //   556: istore_3
    //   557: iload_3
    //   558: iload 4
    //   560: if_icmpge +23 -> 583
    //   563: aload 6
    //   565: aload_1
    //   566: iload_3
    //   567: invokevirtual 1186	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   570: invokeinterface 852 2 0
    //   575: pop
    //   576: iload_3
    //   577: iconst_1
    //   578: iadd
    //   579: istore_3
    //   580: goto -23 -> 557
    //   583: aload_2
    //   584: checkcast 1654	com/baidu/trace/api/entity/DistrictSearchResponse
    //   587: aload 6
    //   589: invokevirtual 1655	com/baidu/trace/api/entity/DistrictSearchResponse:setDistrictList	(Ljava/util/List;)V
    //   592: aload_2
    //   593: aload_0
    //   594: invokevirtual 1658	com/baidu/trace/api/entity/CommonResponse:setEntities	(Ljava/util/List;)V
    //   597: return
    //   598: astore_0
    //   599: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	paramString	String
    //   0	600	1	paramCoordType	CoordType
    //   0	600	2	paramCommonResponse	com.baidu.trace.api.entity.CommonResponse
    //   117	463	3	i	int
    //   114	447	4	j	int
    //   9	3	5	bool	boolean
    //   32	556	6	localObject1	Object
    //   107	27	7	localJSONArray	JSONArray
    //   131	368	8	localEntityInfo	com.baidu.trace.api.entity.EntityInfo
    //   139	336	9	localJSONObject	JSONObject
    //   155	304	10	localObject2	Object
    //   146	347	11	localObject3	Object
    //   371	106	12	localObject4	Object
    //   362	64	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   4	11	401	finally
    //   24	57	401	finally
    //   57	80	401	finally
    //   80	116	401	finally
    //   124	157	401	finally
    //   157	182	401	finally
    //   185	220	401	finally
    //   220	255	401	finally
    //   255	290	401	finally
    //   290	325	401	finally
    //   325	373	401	finally
    //   373	398	401	finally
    //   404	430	401	finally
    //   430	448	401	finally
    //   448	487	401	finally
    //   490	506	401	finally
    //   513	555	401	finally
    //   563	576	401	finally
    //   583	592	401	finally
    //   592	597	401	finally
    //   4	11	598	java/lang/Exception
    //   24	57	598	java/lang/Exception
    //   57	80	598	java/lang/Exception
    //   80	116	598	java/lang/Exception
    //   124	157	598	java/lang/Exception
    //   157	182	598	java/lang/Exception
    //   185	220	598	java/lang/Exception
    //   220	255	598	java/lang/Exception
    //   255	290	598	java/lang/Exception
    //   290	325	598	java/lang/Exception
    //   325	373	598	java/lang/Exception
    //   373	398	598	java/lang/Exception
    //   404	430	598	java/lang/Exception
    //   430	448	598	java/lang/Exception
    //   448	487	598	java/lang/Exception
    //   490	506	598	java/lang/Exception
    //   513	555	598	java/lang/Exception
    //   563	576	598	java/lang/Exception
    //   583	592	598	java/lang/Exception
    //   592	597	598	java/lang/Exception
  }
  
  /* Error */
  public static void a(String paramString, CoordType paramCoordType, FenceListResponse paramFenceListResponse)
  {
    // Byte code:
    //   0: new 798	org/json/JSONObject
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 1056	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 11
    //   10: aload_0
    //   11: aload_2
    //   12: invokestatic 1059	com/baidu/trace/a:b	(Ljava/lang/String;Lcom/baidu/trace/model/BaseResponse;)Z
    //   15: ifne +4 -> 19
    //   18: return
    //   19: aload 11
    //   21: ldc_w 1273
    //   24: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   27: ifeq +15 -> 42
    //   30: aload_2
    //   31: aload 11
    //   33: ldc_w 1273
    //   36: invokevirtual 1074	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   39: invokevirtual 1659	com/baidu/trace/api/fence/FenceListResponse:setSize	(I)V
    //   42: new 1079	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 1080	java/util/ArrayList:<init>	()V
    //   49: astore 16
    //   51: aload 11
    //   53: ldc_w 1661
    //   56: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   59: ifeq +641 -> 700
    //   62: aload 11
    //   64: ldc_w 1661
    //   67: invokevirtual 1086	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   70: astore 17
    //   72: aload 17
    //   74: invokevirtual 1089	org/json/JSONArray:length	()I
    //   77: istore 8
    //   79: iconst_0
    //   80: istore 5
    //   82: iload 5
    //   84: iload 8
    //   86: if_icmpge +614 -> 700
    //   89: new 1663	com/baidu/trace/api/fence/FenceInfo
    //   92: dup
    //   93: invokespecial 1664	com/baidu/trace/api/fence/FenceInfo:<init>	()V
    //   96: astore 18
    //   98: aload 17
    //   100: iload 5
    //   102: invokevirtual 1096	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   105: astore 19
    //   107: lconst_0
    //   108: lstore 9
    //   110: aload 19
    //   112: ldc_w 1018
    //   115: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   118: ifeq +13 -> 131
    //   121: aload 19
    //   123: ldc_w 1018
    //   126: invokevirtual 1100	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   129: lstore 9
    //   131: aload 19
    //   133: ldc_w 1625
    //   136: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   139: ifeq +16 -> 155
    //   142: aload 18
    //   144: aload 19
    //   146: ldc_w 1625
    //   149: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   152: invokevirtual 1665	com/baidu/trace/api/fence/FenceInfo:setCreateTime	(Ljava/lang/String;)V
    //   155: aload 19
    //   157: ldc_w 1630
    //   160: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   163: ifeq +16 -> 179
    //   166: aload 18
    //   168: aload 19
    //   170: ldc_w 1630
    //   173: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: invokevirtual 1666	com/baidu/trace/api/fence/FenceInfo:setModifyTime	(Ljava/lang/String;)V
    //   179: aload 19
    //   181: ldc_w 1171
    //   184: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   187: ifeq +25 -> 212
    //   190: aload 18
    //   192: ldc_w 386
    //   195: aload 19
    //   197: ldc_w 1171
    //   200: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokestatic 1174	com/baidu/trace/api/fence/FenceShape:valueOf	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;
    //   206: checkcast 386	com/baidu/trace/api/fence/FenceShape
    //   209: invokevirtual 1667	com/baidu/trace/api/fence/FenceInfo:setFenceShape	(Lcom/baidu/trace/api/fence/FenceShape;)V
    //   212: ldc 79
    //   214: astore 11
    //   216: aload 19
    //   218: ldc_w 1020
    //   221: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   224: ifeq +13 -> 237
    //   227: aload 19
    //   229: ldc_w 1020
    //   232: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   235: astore 11
    //   237: ldc 79
    //   239: astore 12
    //   241: aload 19
    //   243: ldc -12
    //   245: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   248: ifeq +12 -> 260
    //   251: aload 19
    //   253: ldc -12
    //   255: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   258: astore 12
    //   260: aconst_null
    //   261: astore_0
    //   262: aload_0
    //   263: astore 13
    //   265: aload 19
    //   267: ldc_w 332
    //   270: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   273: ifeq +42 -> 315
    //   276: aload_0
    //   277: astore 13
    //   279: aload 19
    //   281: ldc_w 342
    //   284: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   287: ifeq +28 -> 315
    //   290: new 334	com/baidu/trace/model/LatLng
    //   293: dup
    //   294: aload 19
    //   296: ldc_w 342
    //   299: invokevirtual 1120	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   302: aload 19
    //   304: ldc_w 332
    //   307: invokevirtual 1120	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   310: invokespecial 1123	com/baidu/trace/model/LatLng:<init>	(DD)V
    //   313: astore 13
    //   315: dconst_0
    //   316: dstore_3
    //   317: aload 19
    //   319: ldc_w 661
    //   322: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   325: ifeq +12 -> 337
    //   328: aload 19
    //   330: ldc_w 661
    //   333: invokevirtual 1120	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   336: dstore_3
    //   337: aconst_null
    //   338: astore 14
    //   340: aload 19
    //   342: ldc_w 1022
    //   345: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   348: ifeq +359 -> 707
    //   351: new 1079	java/util/ArrayList
    //   354: dup
    //   355: invokespecial 1080	java/util/ArrayList:<init>	()V
    //   358: astore_0
    //   359: aload 19
    //   361: ldc_w 1022
    //   364: invokevirtual 1086	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   367: astore 15
    //   369: aload 15
    //   371: invokevirtual 1089	org/json/JSONArray:length	()I
    //   374: istore 7
    //   376: iconst_0
    //   377: istore 6
    //   379: aload_0
    //   380: astore 14
    //   382: iload 6
    //   384: iload 7
    //   386: if_icmpge +321 -> 707
    //   389: aload 15
    //   391: iload 6
    //   393: invokevirtual 1096	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   396: astore 14
    //   398: aload_0
    //   399: new 334	com/baidu/trace/model/LatLng
    //   402: dup
    //   403: aload 14
    //   405: ldc_w 342
    //   408: invokevirtual 1120	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   411: aload 14
    //   413: ldc_w 332
    //   416: invokevirtual 1120	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   419: invokespecial 1123	com/baidu/trace/model/LatLng:<init>	(DD)V
    //   422: invokeinterface 852 2 0
    //   427: pop
    //   428: iload 6
    //   430: iconst_1
    //   431: iadd
    //   432: istore 6
    //   434: goto -55 -> 379
    //   437: aload 19
    //   439: ldc_w 349
    //   442: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   445: ifeq +15 -> 460
    //   448: aload 19
    //   450: ldc_w 349
    //   453: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   456: invokestatic 1134	com/baidu/trace/model/CoordType:valueOf	(Ljava/lang/String;)Lcom/baidu/trace/model/CoordType;
    //   459: astore_0
    //   460: iconst_0
    //   461: istore 6
    //   463: aload 19
    //   465: ldc_w 1026
    //   468: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   471: ifeq +13 -> 484
    //   474: aload 19
    //   476: ldc_w 1026
    //   479: invokevirtual 1074	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   482: istore 6
    //   484: iconst_0
    //   485: istore 7
    //   487: aload 19
    //   489: ldc_w 814
    //   492: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   495: ifeq +13 -> 508
    //   498: aload 19
    //   500: ldc_w 814
    //   503: invokevirtual 1074	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   506: istore 7
    //   508: ldc 79
    //   510: astore 15
    //   512: aload 19
    //   514: ldc_w 1179
    //   517: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   520: ifeq +13 -> 533
    //   523: aload 19
    //   525: ldc_w 1179
    //   528: invokevirtual 1131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   531: astore 15
    //   533: aload 18
    //   535: invokevirtual 1671	com/baidu/trace/api/fence/FenceInfo:getFenceShape	()Lcom/baidu/trace/api/fence/FenceShape;
    //   538: getstatic 390	com/baidu/trace/api/fence/FenceShape:circle	Lcom/baidu/trace/api/fence/FenceShape;
    //   541: if_acmpne +49 -> 590
    //   544: aload 18
    //   546: lload 9
    //   548: aload 11
    //   550: aload 12
    //   552: aload 13
    //   554: dload_3
    //   555: iload 7
    //   557: aload_0
    //   558: invokestatic 1675	com/baidu/trace/api/fence/CircleFence:buildServerFence	(JLjava/lang/String;Ljava/lang/String;Lcom/baidu/trace/model/LatLng;DILcom/baidu/trace/model/CoordType;)Lcom/baidu/trace/api/fence/CircleFence;
    //   561: invokevirtual 1679	com/baidu/trace/api/fence/FenceInfo:setCircleFence	(Lcom/baidu/trace/api/fence/CircleFence;)V
    //   564: aload 16
    //   566: aload 18
    //   568: invokeinterface 852 2 0
    //   573: pop
    //   574: iload 5
    //   576: iconst_1
    //   577: iadd
    //   578: istore 5
    //   580: goto -498 -> 82
    //   583: getstatic 1266	com/baidu/trace/model/CoordType:bd09ll	Lcom/baidu/trace/model/CoordType;
    //   586: astore_0
    //   587: goto -150 -> 437
    //   590: aload 18
    //   592: invokevirtual 1671	com/baidu/trace/api/fence/FenceInfo:getFenceShape	()Lcom/baidu/trace/api/fence/FenceShape;
    //   595: getstatic 413	com/baidu/trace/api/fence/FenceShape:polygon	Lcom/baidu/trace/api/fence/FenceShape;
    //   598: if_acmpne +25 -> 623
    //   601: aload 18
    //   603: lload 9
    //   605: aload 11
    //   607: aload 12
    //   609: aload 14
    //   611: iload 7
    //   613: aload_0
    //   614: invokestatic 1682	com/baidu/trace/api/fence/PolygonFence:buildServerFence	(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;ILcom/baidu/trace/model/CoordType;)Lcom/baidu/trace/api/fence/PolygonFence;
    //   617: invokevirtual 1686	com/baidu/trace/api/fence/FenceInfo:setPolygonFence	(Lcom/baidu/trace/api/fence/PolygonFence;)V
    //   620: goto -56 -> 564
    //   623: aload 18
    //   625: invokevirtual 1671	com/baidu/trace/api/fence/FenceInfo:getFenceShape	()Lcom/baidu/trace/api/fence/FenceShape;
    //   628: getstatic 425	com/baidu/trace/api/fence/FenceShape:polyline	Lcom/baidu/trace/api/fence/FenceShape;
    //   631: if_acmpne +30 -> 661
    //   634: aload 18
    //   636: lload 9
    //   638: aload 11
    //   640: aload 12
    //   642: aload 14
    //   644: iload 6
    //   646: iload 7
    //   648: aload_0
    //   649: invokestatic 1689	com/baidu/trace/api/fence/PolylineFence:buildServerFence	(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;IILcom/baidu/trace/model/CoordType;)Lcom/baidu/trace/api/fence/PolylineFence;
    //   652: invokevirtual 1693	com/baidu/trace/api/fence/FenceInfo:setPolylineFence	(Lcom/baidu/trace/api/fence/PolylineFence;)V
    //   655: goto -91 -> 564
    //   658: astore_0
    //   659: aload_0
    //   660: athrow
    //   661: aload 18
    //   663: invokevirtual 1671	com/baidu/trace/api/fence/FenceInfo:getFenceShape	()Lcom/baidu/trace/api/fence/FenceShape;
    //   666: getstatic 438	com/baidu/trace/api/fence/FenceShape:district	Lcom/baidu/trace/api/fence/FenceShape;
    //   669: if_acmpne -105 -> 564
    //   672: lload 9
    //   674: aload 11
    //   676: aload 12
    //   678: iload 7
    //   680: aconst_null
    //   681: invokestatic 1696	com/baidu/trace/api/fence/DistrictFence:buildServerFence	(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/baidu/trace/api/fence/DistrictFence;
    //   684: astore_0
    //   685: aload_0
    //   686: aload 15
    //   688: invokevirtual 1697	com/baidu/trace/api/fence/DistrictFence:setDistrict	(Ljava/lang/String;)V
    //   691: aload 18
    //   693: aload_0
    //   694: invokevirtual 1701	com/baidu/trace/api/fence/FenceInfo:setDistrictFence	(Lcom/baidu/trace/api/fence/DistrictFence;)V
    //   697: goto -133 -> 564
    //   700: aload_2
    //   701: aload 16
    //   703: invokevirtual 1704	com/baidu/trace/api/fence/FenceListResponse:setFenceInfos	(Ljava/util/List;)V
    //   706: return
    //   707: aload_1
    //   708: ifnull -125 -> 583
    //   711: aload_1
    //   712: astore_0
    //   713: goto -276 -> 437
    //   716: astore_0
    //   717: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	718	0	paramString	String
    //   0	718	1	paramCoordType	CoordType
    //   0	718	2	paramFenceListResponse	FenceListResponse
    //   316	239	3	d1	double
    //   80	499	5	i	int
    //   377	268	6	j	int
    //   374	305	7	k	int
    //   77	10	8	m	int
    //   108	565	9	l	long
    //   8	667	11	localObject1	Object
    //   239	438	12	str	String
    //   263	290	13	localObject2	Object
    //   338	305	14	localObject3	Object
    //   367	320	15	localObject4	Object
    //   49	653	16	localArrayList	ArrayList
    //   70	29	17	localJSONArray	JSONArray
    //   96	596	18	localFenceInfo	com.baidu.trace.api.fence.FenceInfo
    //   105	419	19	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	18	658	finally
    //   19	42	658	finally
    //   42	79	658	finally
    //   89	107	658	finally
    //   110	131	658	finally
    //   131	155	658	finally
    //   155	179	658	finally
    //   179	212	658	finally
    //   216	237	658	finally
    //   241	260	658	finally
    //   265	276	658	finally
    //   279	315	658	finally
    //   317	337	658	finally
    //   340	376	658	finally
    //   389	428	658	finally
    //   437	460	658	finally
    //   463	484	658	finally
    //   487	508	658	finally
    //   512	533	658	finally
    //   533	564	658	finally
    //   564	574	658	finally
    //   583	587	658	finally
    //   590	620	658	finally
    //   623	655	658	finally
    //   661	697	658	finally
    //   700	706	658	finally
    //   0	18	716	java/lang/Exception
    //   19	42	716	java/lang/Exception
    //   42	79	716	java/lang/Exception
    //   89	107	716	java/lang/Exception
    //   110	131	716	java/lang/Exception
    //   131	155	716	java/lang/Exception
    //   155	179	716	java/lang/Exception
    //   179	212	716	java/lang/Exception
    //   216	237	716	java/lang/Exception
    //   241	260	716	java/lang/Exception
    //   265	276	716	java/lang/Exception
    //   279	315	716	java/lang/Exception
    //   317	337	716	java/lang/Exception
    //   340	376	716	java/lang/Exception
    //   389	428	716	java/lang/Exception
    //   437	460	716	java/lang/Exception
    //   463	484	716	java/lang/Exception
    //   487	508	716	java/lang/Exception
    //   512	533	716	java/lang/Exception
    //   533	564	716	java/lang/Exception
    //   564	574	716	java/lang/Exception
    //   583	587	716	java/lang/Exception
    //   590	620	716	java/lang/Exception
    //   623	655	716	java/lang/Exception
    //   661	697	716	java/lang/Exception
    //   700	706	716	java/lang/Exception
  }
  
  public static void a(String paramString, CoordType paramCoordType, HistoryAlarmResponse paramHistoryAlarmResponse)
  {
    if (paramCoordType != null) {}
    try
    {
      Object localObject;
      for (;;)
      {
        localObject = new JSONObject(paramString);
        boolean bool = b(paramString, paramHistoryAlarmResponse);
        if (bool) {
          break;
        }
        return;
        paramCoordType = CoordType.bd09ll;
      }
      if (((JSONObject)localObject).has("size")) {
        paramHistoryAlarmResponse.setSize(((JSONObject)localObject).getInt("size"));
      }
      if (((JSONObject)localObject).has("total")) {
        paramHistoryAlarmResponse.setTotal(((JSONObject)localObject).getInt("total"));
      }
      paramString = new ArrayList();
      if (((JSONObject)localObject).has("alarms"))
      {
        localObject = ((JSONObject)localObject).getJSONArray("alarms");
        int j = ((JSONArray)localObject).length();
        int i = 0;
        while (i < j)
        {
          FenceAlarmInfo localFenceAlarmInfo = new FenceAlarmInfo();
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          if (localJSONObject.has("fence_id")) {
            localFenceAlarmInfo.setFenceId(localJSONObject.getLong("fence_id"));
          }
          if (localJSONObject.has("fence_name")) {
            localFenceAlarmInfo.setFenceName(localJSONObject.getString("fence_name"));
          }
          if (localJSONObject.has("monitored_person")) {
            localFenceAlarmInfo.setMonitoredPerson(localJSONObject.getString("monitored_person"));
          }
          if (localJSONObject.has("action")) {
            localFenceAlarmInfo.setMonitoredAction((MonitoredAction)MonitoredAction.valueOf(MonitoredAction.class, localJSONObject.getString("action")));
          }
          AlarmPoint localAlarmPoint;
          if (localJSONObject.has("alarm_point"))
          {
            localAlarmPoint = new AlarmPoint();
            a(localJSONObject.getJSONObject("alarm_point"), paramCoordType, localAlarmPoint, String.class);
            localFenceAlarmInfo.setCurrentPoint(localAlarmPoint);
          }
          if (localJSONObject.has("pre_point"))
          {
            localAlarmPoint = new AlarmPoint();
            a(localJSONObject.getJSONObject("pre_point"), paramCoordType, localAlarmPoint, String.class);
            localFenceAlarmInfo.setPrePoint(localAlarmPoint);
          }
          paramString.add(localFenceAlarmInfo);
          i += 1;
        }
      }
      paramHistoryAlarmResponse.setFenceAlarmInfos(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(String paramString, CoordType paramCoordType, com.baidu.trace.api.track.LatestPointResponse paramLatestPointResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +14 -> 15
    //   4: aload_0
    //   5: aload_2
    //   6: invokestatic 1059	com/baidu/trace/a:b	(Ljava/lang/String;Lcom/baidu/trace/model/BaseResponse;)Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifne +11 -> 22
    //   14: return
    //   15: getstatic 1266	com/baidu/trace/model/CoordType:bd09ll	Lcom/baidu/trace/model/CoordType;
    //   18: astore_1
    //   19: goto -15 -> 4
    //   22: new 798	org/json/JSONObject
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 1056	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   30: astore_0
    //   31: new 1747	com/baidu/trace/api/track/LatestPoint
    //   34: dup
    //   35: aconst_null
    //   36: aload_1
    //   37: invokespecial 1748	com/baidu/trace/api/track/LatestPoint:<init>	(Lcom/baidu/trace/model/LatLng;Lcom/baidu/trace/model/CoordType;)V
    //   40: astore_1
    //   41: aload_0
    //   42: ldc_w 1750
    //   45: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   48: ifeq +69 -> 117
    //   51: aload_0
    //   52: ldc_w 1750
    //   55: invokevirtual 1116	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   58: astore 4
    //   60: aload 4
    //   62: invokevirtual 1309	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   65: astore 5
    //   67: new 1079	java/util/ArrayList
    //   70: dup
    //   71: invokespecial 1080	java/util/ArrayList:<init>	()V
    //   74: astore 6
    //   76: aload 5
    //   78: invokeinterface 52 1 0
    //   83: ifeq +21 -> 104
    //   86: aload 6
    //   88: aload 5
    //   90: invokeinterface 56 1 0
    //   95: invokeinterface 852 2 0
    //   100: pop
    //   101: goto -25 -> 76
    //   104: aload 4
    //   106: aload_1
    //   107: aload 6
    //   109: invokestatic 1295	com/baidu/trace/a:a	(Lorg/json/JSONObject;Lcom/baidu/trace/model/Point;Ljava/util/List;)V
    //   112: aload_2
    //   113: aload_1
    //   114: invokevirtual 1754	com/baidu/trace/api/track/LatestPointResponse:setLatestPoint	(Lcom/baidu/trace/api/track/LatestPoint;)V
    //   117: aload_0
    //   118: ldc_w 1756
    //   121: invokevirtual 1070	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   124: ifeq -110 -> 14
    //   127: aload_2
    //   128: aload_0
    //   129: ldc_w 1756
    //   132: invokevirtual 1120	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   135: invokevirtual 1759	com/baidu/trace/api/track/LatestPointResponse:setLimitSpeed	(D)V
    //   138: return
    //   139: astore_0
    //   140: aload_0
    //   141: athrow
    //   142: astore_0
    //   143: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramString	String
    //   0	144	1	paramCoordType	CoordType
    //   0	144	2	paramLatestPointResponse	com.baidu.trace.api.track.LatestPointResponse
    //   9	2	3	bool	boolean
    //   58	47	4	localJSONObject	JSONObject
    //   65	24	5	localIterator	Iterator
    //   74	34	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   4	10	139	finally
    //   22	76	139	finally
    //   76	101	139	finally
    //   104	117	139	finally
    //   117	138	139	finally
    //   4	10	142	java/lang/Exception
    //   22	76	142	java/lang/Exception
    //   76	101	142	java/lang/Exception
    //   104	117	142	java/lang/Exception
    //   117	138	142	java/lang/Exception
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  protected static void a(JSONObject paramJSONObject, CircleFence paramCircleFence)
    throws JSONException
  {
    if (paramJSONObject.has("fenceName")) {
      paramCircleFence.setFenceName(paramJSONObject.getString("fenceName"));
    }
    if (paramJSONObject.has("monitoredPerson")) {
      paramCircleFence.setMonitoredPerson(paramJSONObject.getString("monitoredPerson"));
    }
    if (paramJSONObject.has("denoise")) {
      paramCircleFence.setDenoise(paramJSONObject.getInt("denoise"));
    }
    if (paramJSONObject.has("radius")) {
      paramCircleFence.setRadius(paramJSONObject.getDouble("radius"));
    }
    if (paramJSONObject.has("center"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("center");
      LatLng localLatLng = new LatLng();
      if (paramJSONObject.has("latitude"))
      {
        localLatLng.latitude = paramJSONObject.getDouble("latitude");
        localLatLng.longitude = paramJSONObject.getDouble("longitude");
      }
      paramCircleFence.setCenter(localLatLng);
    }
  }
  
  private static void a(JSONObject paramJSONObject, FailInfo.InternalError paramInternalError)
    throws JSONException
  {
    if (paramJSONObject == null) {
      return;
    }
    Object localObject = paramJSONObject.keys();
    ArrayList localArrayList = new ArrayList();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((Iterator)localObject).next());
    }
    if (paramJSONObject.has("entity_name"))
    {
      paramInternalError.setEntityName(paramJSONObject.getString("entity_name"));
      localArrayList.remove("entity_name");
    }
    if (paramJSONObject.has("error"))
    {
      if ((paramInternalError instanceof FailInfo.ParamError)) {
        ((FailInfo.ParamError)paramInternalError).setError(paramJSONObject.getString("error"));
      }
      localArrayList.remove("error");
    }
    localObject = new TrackPoint();
    a(paramJSONObject, (Point)localObject, localArrayList);
    paramInternalError.setTrackPoint((TrackPoint)localObject);
  }
  
  public static void a(JSONObject paramJSONObject, CoordType paramCoordType, AlarmPoint paramAlarmPoint, Class paramClass)
    throws JSONException
  {
    CoordType localCoordType;
    if (paramJSONObject.has("loc_time"))
    {
      paramAlarmPoint.setLocTime(paramJSONObject.getLong("loc_time"));
      if (paramJSONObject.has("create_time")) {
        paramAlarmPoint.setCreateTime(paramJSONObject.getLong("create_time"));
      }
      if ((paramJSONObject.has("longitude")) && (paramJSONObject.has("latitude"))) {
        paramAlarmPoint.setLocation(new LatLng(paramJSONObject.getDouble("latitude"), paramJSONObject.getDouble("longitude")));
      }
      if (paramJSONObject.has("radius")) {
        paramAlarmPoint.setRadius(paramJSONObject.getDouble("radius"));
      }
      if (paramCoordType == null) {
        break label178;
      }
      localCoordType = paramCoordType;
      label115:
      paramCoordType = localCoordType;
      if (paramJSONObject.has("coord_type"))
      {
        if (!String.class.isAssignableFrom(paramClass)) {
          break label186;
        }
        paramCoordType = CoordType.valueOf(paramJSONObject.getString("coord_type"));
      }
    }
    for (;;)
    {
      paramAlarmPoint.setCoordType(paramCoordType);
      return;
      if (!paramJSONObject.has("time")) {
        break;
      }
      paramAlarmPoint.setLocTime(paramJSONObject.getLong("time"));
      break;
      label178:
      localCoordType = CoordType.bd09ll;
      break label115;
      label186:
      paramCoordType = localCoordType;
      if (Integer.class.isAssignableFrom(paramClass)) {
        switch (paramJSONObject.getInt("coord_type"))
        {
        default: 
          paramCoordType = CoordType.bd09ll;
          break;
        case 1: 
          paramCoordType = CoordType.wgs84;
          break;
        case 2: 
          paramCoordType = CoordType.gcj02;
          break;
        case 3: 
          paramCoordType = CoordType.bd09ll;
        }
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, Point paramPoint)
    throws JSONException
  {
    if ((paramJSONObject.has("actual_speed")) && ((paramPoint instanceof SpeedingPoint))) {
      ((SpeedingPoint)paramPoint).setActualSpeed(paramJSONObject.getDouble("actual_speed"));
    }
    if ((paramJSONObject.has("limit_speed")) && ((paramPoint instanceof SpeedingPoint))) {
      ((SpeedingPoint)paramPoint).setLimitSpeed(paramJSONObject.getDouble("limit_speed"));
    }
    if (paramJSONObject.has("acceleration"))
    {
      if ((paramPoint instanceof HarshAccelerationPoint)) {
        ((HarshAccelerationPoint)paramPoint).setAcceleration(paramJSONObject.getDouble("acceleration"));
      }
    }
    else
    {
      if (paramJSONObject.has("initial_speed"))
      {
        if (!(paramPoint instanceof HarshAccelerationPoint)) {
          break label282;
        }
        ((HarshAccelerationPoint)paramPoint).setInitialSpeed(paramJSONObject.getDouble("initial_speed"));
      }
      label124:
      if (paramJSONObject.has("end_speed"))
      {
        if (!(paramPoint instanceof HarshAccelerationPoint)) {
          break label306;
        }
        ((HarshAccelerationPoint)paramPoint).setEndSpeed(paramJSONObject.getDouble("end_speed"));
      }
    }
    for (;;)
    {
      if ((paramJSONObject.has("centripetal_acceleration")) && ((paramPoint instanceof HarshSteeringPoint))) {
        ((HarshSteeringPoint)paramPoint).setCentripetalAcceleration(paramJSONObject.getDouble("centripetal_acceleration"));
      }
      if ((paramJSONObject.has("turn_type")) && ((paramPoint instanceof HarshSteeringPoint))) {
        ((HarshSteeringPoint)paramPoint).setTurnType((TurnType)TurnType.valueOf(TurnType.class, paramJSONObject.getString("turn_type")));
      }
      if ((paramJSONObject.has("speed")) && ((paramPoint instanceof HarshSteeringPoint))) {
        ((HarshSteeringPoint)paramPoint).setTurnSpeed(paramJSONObject.getDouble("speed"));
      }
      return;
      if (!(paramPoint instanceof HarshBreakingPoint)) {
        break;
      }
      ((HarshBreakingPoint)paramPoint).setAcceleration(paramJSONObject.getDouble("acceleration"));
      break;
      label282:
      if (!(paramPoint instanceof HarshBreakingPoint)) {
        break label124;
      }
      ((HarshBreakingPoint)paramPoint).setInitialSpeed(paramJSONObject.getDouble("initial_speed"));
      break label124;
      label306:
      if ((paramPoint instanceof HarshBreakingPoint)) {
        ((HarshBreakingPoint)paramPoint).setEndSpeed(paramJSONObject.getDouble("end_speed"));
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, Point paramPoint, List<String> paramList)
    throws JSONException
  {
    if ((paramJSONObject.has("longitude")) && (paramJSONObject.has("latitude"))) {
      paramPoint.setLocation(new LatLng(paramJSONObject.getDouble("latitude"), paramJSONObject.getDouble("longitude")));
    }
    if ((paramList != null) && (paramList.contains("longitude"))) {
      paramList.remove("longitude");
    }
    if ((paramList != null) && (paramList.contains("latitude"))) {
      paramList.remove("latitude");
    }
    if (paramJSONObject.has("coord_type"))
    {
      paramPoint.setCoordType(CoordType.valueOf(paramJSONObject.getString("coord_type")));
      if (paramList != null) {
        paramList.remove("coord_type");
      }
    }
    for (;;)
    {
      if (paramJSONObject.has("address"))
      {
        if (!(paramPoint instanceof StartPoint)) {
          break label645;
        }
        ((StartPoint)paramPoint).setAddress(paramJSONObject.getString("address"));
        label166:
        if (paramList != null) {
          paramList.remove("address");
        }
      }
      if (paramJSONObject.has("radius"))
      {
        paramPoint.setRadius(paramJSONObject.getDouble("radius"));
        if (paramList != null) {
          paramList.remove("radius");
        }
      }
      if (paramJSONObject.has("loc_time")) {}
      try
      {
        paramPoint.setLocTime(Long.parseLong(paramJSONObject.getString("loc_time")));
        if (paramList != null) {
          paramList.remove("loc_time");
        }
        if ((paramJSONObject.has("create_time")) && ((paramPoint instanceof TrackPoint)))
        {
          ((TrackPoint)paramPoint).setCreateTime(paramJSONObject.getString("create_time"));
          if (paramList != null) {
            paramList.remove("create_time");
          }
        }
        if (paramJSONObject.has("direction"))
        {
          paramPoint.setDirection(paramJSONObject.getInt("direction"));
          if (paramList != null) {
            paramList.remove("direction");
          }
        }
        if (paramJSONObject.has("speed"))
        {
          paramPoint.setSpeed(paramJSONObject.getDouble("speed"));
          if (paramList != null) {
            paramList.remove("speed");
          }
        }
        if (paramJSONObject.has("height"))
        {
          paramPoint.setHeight(paramJSONObject.getDouble("height"));
          if (paramList != null) {
            paramList.remove("height");
          }
        }
        if ((paramJSONObject.has("distance")) && ((paramPoint instanceof LatestLocation)))
        {
          ((LatestLocation)paramPoint).setDistance(paramJSONObject.getDouble("distance"));
          if (paramList != null) {
            paramList.remove("distance");
          }
        }
        if (paramJSONObject.has("floor"))
        {
          if (!(paramPoint instanceof LatestLocation)) {
            break label669;
          }
          ((LatestLocation)paramPoint).setFloor(paramJSONObject.getString("floor"));
          label479:
          if (paramList != null) {
            paramList.remove("floor");
          }
        }
        if (paramJSONObject.has("object_name"))
        {
          if (!(paramPoint instanceof LatestLocation)) {
            break label693;
          }
          ((LatestLocation)paramPoint).setObjectName(paramJSONObject.getString("object_name"));
        }
        HashMap localHashMap;
        for (;;)
        {
          if (paramList != null) {
            paramList.remove("object_name");
          }
          localHashMap = new HashMap();
          if ((paramList == null) || (paramList.isEmpty())) {
            break label741;
          }
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            String str = (String)paramList.next();
            localHashMap.put(str, paramJSONObject.getString(str));
          }
          if (!paramJSONObject.has("coord_type_input")) {
            break;
          }
          paramPoint.setCoordType(CoordType.valueOf(paramJSONObject.getString("coord_type_input")));
          if (paramList == null) {
            break;
          }
          paramList.remove("coord_type_input");
          break;
          label645:
          if (!(paramPoint instanceof EndPoint)) {
            break label166;
          }
          ((EndPoint)paramPoint).setAddress(paramJSONObject.getString("address"));
          break label166;
          label669:
          if (!(paramPoint instanceof LatestPoint)) {
            break label479;
          }
          ((LatestPoint)paramPoint).setFloor(paramJSONObject.getString("floor"));
          break label479;
          label693:
          if ((paramPoint instanceof TrackPoint)) {
            ((TrackPoint)paramPoint).setObjectName(paramJSONObject.getString("object_name"));
          } else if ((paramPoint instanceof LatestPoint)) {
            ((LatestPoint)paramPoint).setObjectName(paramJSONObject.getString("object_name"));
          }
        }
        label741:
        if ((paramPoint instanceof LatestLocation)) {
          ((LatestLocation)paramPoint).setColumns(localHashMap);
        }
        do
        {
          return;
          if ((paramPoint instanceof TrackPoint))
          {
            ((TrackPoint)paramPoint).setColumns(localHashMap);
            return;
          }
        } while (!(paramPoint instanceof LatestPoint));
        ((LatestPoint)paramPoint).setColumns(localHashMap);
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  protected static boolean a(double paramDouble, String paramString, BaseResponse paramBaseResponse)
  {
    if (paramDouble < 0.0D)
    {
      paramBaseResponse.setStatus(2);
      paramBaseResponse.setMessage(paramString + "参数错误");
      return false;
    }
    return true;
  }
  
  protected static boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, Map<String, String> paramMap, TreeMap<String, String> paramTreeMap, OnEntityListener paramOnEntityListener)
  {
    if (!e.a(paramString1))
    {
      if (paramInt1 == 0) {
        paramOnEntityListener.onAddEntityCallback(new AddEntityResponse(paramInt2, 2, "entityName参数错误"));
      }
      for (;;)
      {
        return false;
        if (1 == paramInt1) {
          paramOnEntityListener.onUpdateEntityCallback(new UpdateEntityResponse(paramInt2, 2, "entityName参数错误"));
        } else if (2 == paramInt1) {
          paramOnEntityListener.onDeleteEntityCallback(new DeleteEntityResponse(paramInt2, 2, "entityName参数错误"));
        }
      }
    }
    try
    {
      paramTreeMap.put("entity_name", URLEncoder.encode(paramString1, "UTF-8"));
      if (TextUtils.isEmpty(paramString2)) {}
    }
    catch (Exception localException)
    {
      try
      {
        paramTreeMap.put("entity_desc", URLEncoder.encode(paramString2, "UTF-8"));
        if ((paramMap == null) || (paramMap.isEmpty()))
        {
          return true;
          localException = localException;
          paramTreeMap.put("entity_name", paramString1);
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramTreeMap.put("entity_desc", paramString2);
        }
        paramString1 = paramMap.entrySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (Map.Entry)paramString1.next();
          if (!e.b((String)paramString2.getKey()))
          {
            if (paramInt1 == 0) {
              paramOnEntityListener.onAddEntityCallback(new AddEntityResponse(paramInt2, 2, "column_key参数错误"));
            }
            for (;;)
            {
              return false;
              if (1 == paramInt1) {
                paramOnEntityListener.onUpdateEntityCallback(new UpdateEntityResponse(paramInt2, 2, "column_key参数错误"));
              }
            }
          }
          if (!TextUtils.isEmpty((CharSequence)paramString2.getValue())) {
            try
            {
              paramTreeMap.put(paramString2.getKey(), URLEncoder.encode((String)paramString2.getValue(), "UTF-8"));
            }
            catch (Exception paramMap)
            {
              paramTreeMap.put(paramString2.getKey(), paramString2.getValue());
            }
          }
        }
      }
    }
    return true;
  }
  
  protected static boolean a(String paramString, BaseRequest paramBaseRequest, Object paramObject)
  {
    if (paramBaseRequest == null)
    {
      a("BaiduTraceSDK", paramString + ", request object is null!");
      return false;
    }
    if (paramObject == null)
    {
      a("BaiduTraceSDK", paramString + ", listener is null!");
      return false;
    }
    return true;
  }
  
  protected static boolean a(String paramString1, String paramString2, BaseResponse paramBaseResponse)
  {
    if (e.a(paramString1)) {
      return true;
    }
    paramBaseResponse.setStatus(2);
    paramBaseResponse.setMessage(paramString2 + "参数错误");
    return false;
  }
  
  protected static boolean a(Map<String, List<TrackPoint>> paramMap, StringBuffer paramStringBuffer)
  {
    if ((paramMap == null) || (paramStringBuffer == null)) {
      return false;
    }
    JSONArray localJSONArray = new JSONArray();
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject1 = (Map.Entry)paramMap.next();
        String str = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (List)((Map.Entry)localObject1).getValue();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (TrackPoint)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("entity_name", str);
              localJSONObject.put("loc_time", ((TrackPoint)localObject2).getLocTime());
              LatLng localLatLng = ((TrackPoint)localObject2).getLocation();
              if (localLatLng != null)
              {
                localJSONObject.put("latitude", localLatLng.getLatitude());
                localJSONObject.put("longitude", localLatLng.getLongitude());
              }
              if (((TrackPoint)localObject2).getCoordType() != null) {
                localJSONObject.put("coord_type_input", ((TrackPoint)localObject2).getCoordType().name());
              }
              localJSONObject.put("speed", ((TrackPoint)localObject2).getSpeed());
              localJSONObject.put("direction", ((TrackPoint)localObject2).getDirection());
              localJSONObject.put("height", ((TrackPoint)localObject2).getHeight());
              localJSONObject.put("radius", ((TrackPoint)localObject2).getRadius());
              localJSONObject.put("object_name", ((TrackPoint)localObject2).getObjectName());
              localObject2 = ((TrackPoint)localObject2).getColumns();
              if ((localObject2 != null) && (!a((Map)localObject2, null, localJSONObject))) {
                return false;
              }
              localJSONArray.put(localJSONObject);
            }
          }
        }
      }
      paramStringBuffer.append(localJSONArray.toString());
    }
    catch (Exception paramMap)
    {
      return false;
    }
    return true;
  }
  
  protected static boolean a(Map<String, String> paramMap, TreeMap<String, String> paramTreeMap, JSONObject paramJSONObject)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!e.b((String)localEntry.getKey())) {
        return false;
      }
      if (!TextUtils.isEmpty((CharSequence)localEntry.getValue())) {
        if (paramTreeMap != null)
        {
          try
          {
            paramTreeMap.put(localEntry.getKey(), URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
          }
          catch (Exception localException) {}
          if (paramTreeMap != null) {
            paramTreeMap.put(localEntry.getKey(), localEntry.getValue());
          }
        }
        else if (paramJSONObject != null)
        {
          paramJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
      }
    }
    return true;
  }
  
  private static String b(Context paramContext, Handler paramHandler, int paramInt, Fence paramFence, OnFenceListener paramOnFenceListener)
  {
    CreateFenceResponse localCreateFenceResponse = new CreateFenceResponse(paramInt, 0, "成功", FenceType.local);
    if (paramFence == null)
    {
      localCreateFenceResponse.setStatus(2);
      localCreateFenceResponse.setMessage("fence参数错误");
      a(1, paramHandler, localCreateFenceResponse, paramOnFenceListener);
      return null;
    }
    CircleFence localCircleFence = (CircleFence)paramFence;
    localCreateFenceResponse.setFenceName(localCircleFence.getFenceName());
    localCreateFenceResponse.setFenceShape(FenceShape.circle);
    if (e.a(localCircleFence.getCenter()))
    {
      if ((localCircleFence.getCoordType() != null) && (CoordType.bd09ll != localCircleFence.getCoordType()))
      {
        paramFence = null;
        if (CoordType.wgs84 == localCircleFence.getCoordType()) {
          paramFence = TraceJniInterface.wgsToBaidu(localCircleFence.getCenter().latitude, localCircleFence.getCenter().longitude);
        }
        while (paramFence == null)
        {
          localCreateFenceResponse.setStatus(2);
          localCreateFenceResponse.setMessage("center参数错误");
          a(1, paramHandler, localCreateFenceResponse, paramOnFenceListener);
          return null;
          if (CoordType.gcj02 == localCircleFence.getCoordType()) {
            paramFence = TraceJniInterface.gcjToBaidu(localCircleFence.getCenter().latitude, localCircleFence.getCenter().longitude);
          }
        }
        localCircleFence.setCenter(new LatLng(paramFence[0], paramFence[1]));
      }
      localCircleFence.setCoordType(CoordType.bd09ll);
      if ((!a(localCircleFence.getFenceName(), "fenceName", localCreateFenceResponse)) || (!a(localCircleFence.getMonitoredPerson(), "monitoredPerson", localCreateFenceResponse)) || (!a(localCircleFence.getDenoise(), "denoise", localCreateFenceResponse)) || (!a(localCircleFence.getRadius(), "radius", localCreateFenceResponse)))
      {
        a(1, paramHandler, localCreateFenceResponse, paramOnFenceListener);
        return null;
      }
    }
    else
    {
      localCreateFenceResponse.setStatus(2);
      localCreateFenceResponse.setMessage("center参数错误");
      a(1, paramHandler, localCreateFenceResponse, paramOnFenceListener);
      return null;
    }
    paramFence = new StringBuffer();
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      a(localCircleFence, localStringBuffer, paramFence);
      long l = am.a(paramContext, localCircleFence.getFenceName(), localCircleFence.getMonitoredPerson(), localCircleFence.getCoordType(), localCircleFence.getDenoise(), FenceShape.circle, paramFence.toString());
      if (-1L != l)
      {
        localCircleFence.setFenceId(l);
        localCreateFenceResponse.setFenceId(l);
        a(1, paramHandler, localCreateFenceResponse, paramOnFenceListener);
        return localStringBuffer.toString();
      }
    }
    catch (JSONException paramContext)
    {
      localCreateFenceResponse.setStatus(15001);
      localCreateFenceResponse.setMessage("创建本地围栏失败");
      a(1, paramHandler, localCreateFenceResponse, paramOnFenceListener);
      return null;
    }
    localCreateFenceResponse.setStatus(15001);
    localCreateFenceResponse.setMessage("创建本地围栏失败");
    a(1, paramHandler, localCreateFenceResponse, paramOnFenceListener);
    return null;
  }
  
  private static String b(Context paramContext, Handler paramHandler, UpdateFenceRequest paramUpdateFenceRequest, OnFenceListener paramOnFenceListener)
  {
    UpdateFenceResponse localUpdateFenceResponse = new UpdateFenceResponse(paramUpdateFenceRequest.getTag(), 0, "成功", FenceType.local);
    if (paramUpdateFenceRequest.getFence() == null)
    {
      localUpdateFenceResponse.setStatus(2);
      localUpdateFenceResponse.setMessage("fence参数错误");
      a(2, paramHandler, localUpdateFenceResponse, paramOnFenceListener);
      return null;
    }
    long l = paramUpdateFenceRequest.getFence().getFenceId();
    CircleFence localCircleFence = am.a(paramContext, l);
    if (localCircleFence == null)
    {
      localUpdateFenceResponse.setStatus(15000);
      localUpdateFenceResponse.setMessage("指定fenceId不存在");
      a(2, paramHandler, localUpdateFenceResponse, paramOnFenceListener);
      return null;
    }
    Object localObject = (CircleFence)paramUpdateFenceRequest.getFence();
    if (!TextUtils.isEmpty(((CircleFence)localObject).getFenceName()))
    {
      if (a(((CircleFence)localObject).getFenceName(), "fenceName", localUpdateFenceResponse)) {
        localCircleFence.setFenceName(((CircleFence)localObject).getFenceName());
      }
    }
    else
    {
      if (!TextUtils.isEmpty(((CircleFence)localObject).getMonitoredPerson()))
      {
        if (!a(((CircleFence)localObject).getMonitoredPerson(), "monitoredPerson", localUpdateFenceResponse)) {
          break label283;
        }
        localCircleFence.setMonitoredPerson(((CircleFence)localObject).getMonitoredPerson());
      }
      if (e.a(((CircleFence)localObject).getCenter()))
      {
        if ((((CircleFence)localObject).getCoordType() != null) && (CoordType.bd09ll != ((CircleFence)localObject).getCoordType())) {
          break label293;
        }
        localCircleFence.setCenter(((CircleFence)localObject).getCenter());
      }
    }
    for (;;)
    {
      localCircleFence.setCoordType(CoordType.bd09ll);
      if ((a(((CircleFence)localObject).getDenoise(), "denoise", localUpdateFenceResponse)) && (a(((CircleFence)localObject).getRadius(), "radius", localUpdateFenceResponse))) {
        break;
      }
      a(2, paramHandler, localUpdateFenceResponse, paramOnFenceListener);
      return null;
      a(2, paramHandler, localUpdateFenceResponse, paramOnFenceListener);
      return null;
      label283:
      a(2, paramHandler, localUpdateFenceResponse, paramOnFenceListener);
      return null;
      label293:
      paramUpdateFenceRequest = null;
      if (CoordType.wgs84 == ((CircleFence)localObject).getCoordType()) {
        paramUpdateFenceRequest = TraceJniInterface.wgsToBaidu(((CircleFence)localObject).getCenter().latitude, ((CircleFence)localObject).getCenter().longitude);
      }
      while (paramUpdateFenceRequest == null)
      {
        localUpdateFenceResponse.setStatus(2);
        localUpdateFenceResponse.setMessage("center参数错误");
        a(2, paramHandler, localUpdateFenceResponse, paramOnFenceListener);
        return null;
        if (CoordType.gcj02 == ((CircleFence)localObject).getCoordType()) {
          paramUpdateFenceRequest = TraceJniInterface.gcjToBaidu(((CircleFence)localObject).getCenter().latitude, ((CircleFence)localObject).getCenter().longitude);
        }
      }
      localCircleFence.setCenter(new LatLng(paramUpdateFenceRequest[0], paramUpdateFenceRequest[1]));
    }
    if (((CircleFence)localObject).getDenoise() > 0) {
      localCircleFence.setDenoise(((CircleFence)localObject).getDenoise());
    }
    if (((CircleFence)localObject).getRadius() > 0.0D) {
      localCircleFence.setRadius(((CircleFence)localObject).getRadius());
    }
    paramUpdateFenceRequest = new StringBuffer();
    localObject = new StringBuffer();
    try
    {
      a(localCircleFence, (StringBuffer)localObject, paramUpdateFenceRequest);
      if (am.a(paramContext, l, localCircleFence.getFenceName(), localCircleFence.getMonitoredPerson(), localCircleFence.getCoordType(), localCircleFence.getDenoise(), FenceShape.circle, paramUpdateFenceRequest.toString()))
      {
        localUpdateFenceResponse.setFenceName(localCircleFence.getFenceName());
        localUpdateFenceResponse.setFenceId(l);
        a(2, paramHandler, localUpdateFenceResponse, paramOnFenceListener);
        return ((StringBuffer)localObject).toString();
      }
    }
    catch (JSONException paramContext)
    {
      localUpdateFenceResponse.setStatus(15002);
      localUpdateFenceResponse.setMessage("更新本地围栏失败");
      localUpdateFenceResponse.setFenceId(l);
      a(2, paramHandler, localUpdateFenceResponse, paramOnFenceListener);
      return null;
    }
    localUpdateFenceResponse.setStatus(15002);
    localUpdateFenceResponse.setMessage("更新本地围栏失败");
    a(2, paramHandler, localUpdateFenceResponse, paramOnFenceListener);
    return null;
  }
  
  protected static String b(List<LatLng> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LatLng localLatLng = (LatLng)paramList.next();
      localStringBuffer.append(localLatLng.latitude).append(",").append(localLatLng.longitude).append(";");
    }
    if (TextUtils.isEmpty(localStringBuffer.toString())) {
      return "";
    }
    return localStringBuffer.substring(0, localStringBuffer.length() - 1);
  }
  
  protected static String b(TreeMap<String, String> paramTreeMap)
    throws UnsupportedEncodingException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramTreeMap = paramTreeMap.entrySet().iterator();
    while (paramTreeMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramTreeMap.next();
      String str = (String)localEntry.getValue();
      if (!TextUtils.isEmpty(str)) {
        if (str.contains("%")) {
          localStringBuffer.append((String)localEntry.getKey()).append("=").append(URLEncoder.encode(str, "UTF-8")).append("&");
        } else {
          localStringBuffer.append((String)localEntry.getKey()).append("=").append(str).append("&");
        }
      }
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  protected static void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if ((paramString.has("status")) && (paramString.getInt("status") == 0)) {
        d.a = URLEncoder.encode(paramString.getString("token"), "UTF-8");
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private boolean b()
  {
    return (this.a >= 0) && (this.b > 0);
  }
  
  public static boolean b(String paramString, BaseResponse paramBaseResponse)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.has("status_sp")) {
        break label173;
      }
      i = paramString.getInt("status_sp");
      switch (i)
      {
      case 1: 
        paramBaseResponse.setStatus(14001);
        paramBaseResponse.setMessage("请求失败");
        return false;
      }
    }
    catch (Exception paramString)
    {
      int i;
      paramBaseResponse.setStatus(14000);
      paramBaseResponse.setMessage("响应解析失败");
      return false;
    }
    paramBaseResponse.setStatus(i);
    paramBaseResponse.setMessage("服务内部错误");
    return false;
    d.a();
    paramBaseResponse.setStatus(14004);
    paramBaseResponse.setMessage("鉴权失败");
    return false;
    d.a();
    paramBaseResponse.setStatus(14003);
    paramBaseResponse.setMessage("鉴权未完成");
    return false;
    label173:
    if (paramString.has("status")) {
      paramBaseResponse.setStatus(paramString.getInt("status"));
    }
    if (paramString.has("message")) {
      paramBaseResponse.setMessage(paramString.getString("message"));
    } else if (paramString.has("status")) {
      switch (paramString.getInt("status"))
      {
      }
    }
    for (;;)
    {
      paramBaseResponse.setMessage("服务内部错误");
      break label289;
      paramBaseResponse.setMessage("成功");
      break label289;
      paramBaseResponse.setMessage("服务内部错误");
      break label289;
      break;
      label289:
      return true;
    }
  }
  
  public String a()
  {
    if (!b()) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append(this.e);
    localStringBuffer.append("h");
    if (this.c != 460) {
      localStringBuffer.append(this.c);
    }
    localStringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b) }));
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */