package com.baidu.trace;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.lbsapi.auth.tracesdk.LBSAuthManager;
import com.baidu.trace.api.analysis.DrivingBehaviorRequest;
import com.baidu.trace.api.analysis.OnAnalysisListener;
import com.baidu.trace.api.analysis.StayPointRequest;
import com.baidu.trace.api.bos.BosGeneratePresignedUrlRequest;
import com.baidu.trace.api.bos.BosGetObjectRequest;
import com.baidu.trace.api.bos.BosPutObjectRequest;
import com.baidu.trace.api.bos.OnBosListener;
import com.baidu.trace.api.entity.AddEntityRequest;
import com.baidu.trace.api.entity.AroundSearchRequest;
import com.baidu.trace.api.entity.BoundSearchRequest;
import com.baidu.trace.api.entity.DeleteEntityRequest;
import com.baidu.trace.api.entity.DistrictSearchRequest;
import com.baidu.trace.api.entity.EntityListRequest;
import com.baidu.trace.api.entity.LocRequest;
import com.baidu.trace.api.entity.OnEntityListener;
import com.baidu.trace.api.entity.PolygonSearchRequest;
import com.baidu.trace.api.entity.SearchRequest;
import com.baidu.trace.api.entity.UpdateEntityRequest;
import com.baidu.trace.api.fence.AlarmPoint;
import com.baidu.trace.api.fence.CreateFenceRequest;
import com.baidu.trace.api.fence.DeleteFenceRequest;
import com.baidu.trace.api.fence.FenceAlarmPushInfo;
import com.baidu.trace.api.fence.FenceListRequest;
import com.baidu.trace.api.fence.HistoryAlarmRequest;
import com.baidu.trace.api.fence.MonitoredAction;
import com.baidu.trace.api.fence.MonitoredStatusByLocationRequest;
import com.baidu.trace.api.fence.MonitoredStatusRequest;
import com.baidu.trace.api.fence.OnFenceListener;
import com.baidu.trace.api.fence.UpdateFenceRequest;
import com.baidu.trace.api.track.AddPointRequest;
import com.baidu.trace.api.track.AddPointsRequest;
import com.baidu.trace.api.track.ClearCacheTrackRequest;
import com.baidu.trace.api.track.ClearCacheTrackResponse;
import com.baidu.trace.api.track.DistanceRequest;
import com.baidu.trace.api.track.HistoryTrackRequest;
import com.baidu.trace.api.track.LatestPointRequest;
import com.baidu.trace.api.track.OnTrackListener;
import com.baidu.trace.api.track.QueryCacheTrackRequest;
import com.baidu.trace.api.track.QueryCacheTrackResponse;
import com.baidu.trace.c.e;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import com.baidu.trace.model.LocType;
import com.baidu.trace.model.LocationMode;
import com.baidu.trace.model.OnCustomAttributeListener;
import com.baidu.trace.model.OnTraceListener;
import com.baidu.trace.model.ProtocolType;
import com.baidu.trace.model.PushMessage;
import com.baidu.trace.model.TraceLocation;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public final class LBSTraceClient
{
  protected static LBSTraceClient a = null;
  private Context b;
  private Intent c = null;
  private IService d = null;
  private ClientListener e = null;
  private a f = new a(this);
  private LocationMode g = LocationMode.High_Accuracy;
  private OnTraceListener h = null;
  private OnCustomAttributeListener i = null;
  private boolean j = false;
  private ar k = null;
  private ServiceConnection l = new ap(this);
  
  public LBSTraceClient(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.e = new ClientListener(this);
    c();
  }
  
  private void b()
  {
    try
    {
      this.b.startService(this.c);
      this.b.bindService(this.c, this.l, 1);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        StringWriter localStringWriter = new StringWriter();
        localException.printStackTrace(new PrintWriter(localStringWriter));
        a.a("start and bind service failed, Exception : " + localStringWriter.toString());
      } while (this.h == null);
      this.h.onBindServiceCallback(1, "失败");
    }
  }
  
  private void c()
  {
    if (this.j) {
      return;
    }
    this.j = true;
    av.a(this.b);
    d.b = LBSAuthManager.getInstance(this.b);
    q.a(this.b, d.b);
    e.a(this.b);
    com.baidu.trace.c.a.a(this.b, LBSTraceClient.class);
    am.a(this.b);
    String str = e.c;
    com.baidu.trace.c.h.b();
    d.a();
  }
  
  protected final void a()
  {
    try
    {
      this.d.handleExtendedOperate(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void addEntity(AddEntityRequest paramAddEntityRequest, OnEntityListener paramOnEntityListener)
  {
    if (a.a("addEntity", paramAddEntityRequest, paramOnEntityListener)) {
      a.a(paramAddEntityRequest, paramOnEntityListener);
    }
  }
  
  public final void addPoint(AddPointRequest paramAddPointRequest, OnTrackListener paramOnTrackListener)
  {
    if (a.a("addPoint", paramAddPointRequest, paramOnTrackListener)) {
      a.a(paramAddPointRequest, paramOnTrackListener);
    }
  }
  
  public final void addPoints(AddPointsRequest paramAddPointsRequest, OnTrackListener paramOnTrackListener)
  {
    if (a.a("addPoints", paramAddPointsRequest, paramOnTrackListener)) {
      a.a(paramAddPointsRequest, paramOnTrackListener);
    }
  }
  
  public final void aroundSearchEntity(AroundSearchRequest paramAroundSearchRequest, OnEntityListener paramOnEntityListener)
  {
    if (a.a("aroundSearchEntity", paramAroundSearchRequest, paramOnEntityListener)) {
      a.a(paramAroundSearchRequest, paramOnEntityListener);
    }
  }
  
  public final void boundSearchEntity(BoundSearchRequest paramBoundSearchRequest, OnEntityListener paramOnEntityListener)
  {
    if (a.a("boundSearchEntity", paramBoundSearchRequest, paramOnEntityListener)) {
      a.a(paramBoundSearchRequest, paramOnEntityListener);
    }
  }
  
  public final void clear()
  {
    am.a();
    com.baidu.trace.c.a.a();
    d.b();
    if (this.k != null)
    {
      this.k.c();
      this.k = null;
    }
    a = null;
    this.j = false;
  }
  
  public final void clearCacheTrack(ClearCacheTrackRequest paramClearCacheTrackRequest, OnTrackListener paramOnTrackListener)
  {
    if (a.a("clearCacheTrack", paramClearCacheTrackRequest, paramOnTrackListener))
    {
      Context localContext = this.b;
      a locala = this.f;
      ClearCacheTrackResponse localClearCacheTrackResponse = new ClearCacheTrackResponse(paramClearCacheTrackRequest.getTag(), 0, "成功");
      List localList = paramClearCacheTrackRequest.getEntityNames();
      paramClearCacheTrackRequest = paramClearCacheTrackRequest.getCacheTrackInfos();
      com.baidu.trace.c.a.a.execute(new bg(localContext, localList, paramClearCacheTrackRequest, localClearCacheTrackResponse, locala, paramOnTrackListener));
    }
  }
  
  public final void createFence(CreateFenceRequest paramCreateFenceRequest, OnFenceListener paramOnFenceListener)
  {
    if (a.a("createFence", paramCreateFenceRequest, paramOnFenceListener)) {
      a.a(this.b, this.d, this.f, paramCreateFenceRequest, paramOnFenceListener);
    }
  }
  
  public final void deleteEntity(DeleteEntityRequest paramDeleteEntityRequest, OnEntityListener paramOnEntityListener)
  {
    if (a.a("deleteEntity", paramDeleteEntityRequest, paramOnEntityListener)) {
      a.a(paramDeleteEntityRequest, paramOnEntityListener);
    }
  }
  
  public final void deleteFence(DeleteFenceRequest paramDeleteFenceRequest, OnFenceListener paramOnFenceListener)
  {
    if (a.a("deleteFence", paramDeleteFenceRequest, paramOnFenceListener)) {
      a.a(this.b, this.d, this.f, paramDeleteFenceRequest, paramOnFenceListener);
    }
  }
  
  public final void districtSearchEntity(DistrictSearchRequest paramDistrictSearchRequest, OnEntityListener paramOnEntityListener)
  {
    if (a.a("districtSearchRequest", paramDistrictSearchRequest, paramOnEntityListener)) {
      a.a(paramDistrictSearchRequest, paramOnEntityListener);
    }
  }
  
  public final void generatePresignedUrl(BosGeneratePresignedUrlRequest paramBosGeneratePresignedUrlRequest, OnBosListener paramOnBosListener)
  {
    if (a.a("generatePresignedUrl", paramBosGeneratePresignedUrlRequest, paramOnBosListener)) {
      a.a(paramBosGeneratePresignedUrlRequest, paramOnBosListener);
    }
  }
  
  public final void getObject(BosGetObjectRequest paramBosGetObjectRequest, OnBosListener paramOnBosListener)
  {
    if (a.a("getObject", paramBosGetObjectRequest, paramOnBosListener)) {
      a.a(paramBosGetObjectRequest, paramOnBosListener);
    }
  }
  
  public final boolean initThreadPoolConfig(int paramInt1, int paramInt2, int paramInt3)
  {
    return com.baidu.trace.c.a.a(paramInt1, paramInt2, paramInt3);
  }
  
  public final void polygonSearchEntity(PolygonSearchRequest paramPolygonSearchRequest, OnEntityListener paramOnEntityListener)
  {
    if (a.a("polygonSearchRequest", paramPolygonSearchRequest, paramOnEntityListener)) {
      a.a(paramPolygonSearchRequest, paramOnEntityListener);
    }
  }
  
  public final void putObject(BosPutObjectRequest paramBosPutObjectRequest, OnBosListener paramOnBosListener)
  {
    if (a.a("putObject", paramBosPutObjectRequest, paramOnBosListener)) {
      a.a(paramBosPutObjectRequest, paramOnBosListener);
    }
  }
  
  public final void queryCacheTrack(QueryCacheTrackRequest paramQueryCacheTrackRequest, OnTrackListener paramOnTrackListener)
  {
    if (a.a("queryCacheTrack", paramQueryCacheTrackRequest, paramOnTrackListener))
    {
      Context localContext = this.b;
      a locala = this.f;
      QueryCacheTrackResponse localQueryCacheTrackResponse = new QueryCacheTrackResponse(paramQueryCacheTrackRequest.getTag(), 0, "成功");
      com.baidu.trace.c.a.a.execute(new be(localContext, paramQueryCacheTrackRequest, localQueryCacheTrackResponse, locala, paramOnTrackListener));
    }
  }
  
  public final void queryDistance(DistanceRequest paramDistanceRequest, OnTrackListener paramOnTrackListener)
  {
    if (a.a("queryDistance", paramDistanceRequest, paramOnTrackListener)) {
      a.a(paramDistanceRequest, paramOnTrackListener);
    }
  }
  
  public final void queryDrivingBehavior(DrivingBehaviorRequest paramDrivingBehaviorRequest, OnAnalysisListener paramOnAnalysisListener)
  {
    if (a.a("queryDrivingBehavior", paramDrivingBehaviorRequest, paramOnAnalysisListener)) {
      a.a(paramDrivingBehaviorRequest, paramOnAnalysisListener);
    }
  }
  
  public final void queryEntityList(EntityListRequest paramEntityListRequest, OnEntityListener paramOnEntityListener)
  {
    if (a.a("queryEntityList", paramEntityListRequest, paramOnEntityListener)) {
      a.a(paramEntityListRequest, paramOnEntityListener);
    }
  }
  
  public final void queryFenceHistoryAlarmInfo(HistoryAlarmRequest paramHistoryAlarmRequest, OnFenceListener paramOnFenceListener)
  {
    if (a.a("queryFenceHistoryAlarmInfo", paramHistoryAlarmRequest, paramOnFenceListener)) {
      a.a(this.b, this.f, paramHistoryAlarmRequest, paramOnFenceListener);
    }
  }
  
  public final void queryFenceList(FenceListRequest paramFenceListRequest, OnFenceListener paramOnFenceListener)
  {
    if (a.a("queryFenceList", paramFenceListRequest, paramOnFenceListener)) {
      a.a(this.b, this.f, paramFenceListRequest, paramOnFenceListener);
    }
  }
  
  public final void queryHistoryTrack(HistoryTrackRequest paramHistoryTrackRequest, OnTrackListener paramOnTrackListener)
  {
    if (a.a("queryHistoryTrack", paramHistoryTrackRequest, paramOnTrackListener)) {
      a.a(paramHistoryTrackRequest, paramOnTrackListener);
    }
  }
  
  public final void queryLatestPoint(LatestPointRequest paramLatestPointRequest, OnTrackListener paramOnTrackListener)
  {
    if (a.a("queryLatestPoint", paramLatestPointRequest, paramOnTrackListener)) {
      a.a(paramLatestPointRequest, paramOnTrackListener);
    }
  }
  
  public final void queryMonitoredStatus(MonitoredStatusRequest paramMonitoredStatusRequest, OnFenceListener paramOnFenceListener)
  {
    if (a.a("queryMonitoredStatus", paramMonitoredStatusRequest, paramOnFenceListener)) {
      a.a(this.b, this.f, paramMonitoredStatusRequest, paramOnFenceListener);
    }
  }
  
  public final void queryMonitoredStatusByLocation(MonitoredStatusByLocationRequest paramMonitoredStatusByLocationRequest, OnFenceListener paramOnFenceListener)
  {
    if (a.a("queryMonitoredStatusByLocation", paramMonitoredStatusByLocationRequest, paramOnFenceListener)) {
      a.a(this.b, this.f, paramMonitoredStatusByLocationRequest, paramOnFenceListener);
    }
  }
  
  public final void queryRealTimeLoc(LocRequest paramLocRequest, OnEntityListener paramOnEntityListener)
  {
    if (!a.a("queryRealTimeLoc", paramLocRequest, paramOnEntityListener)) {}
    for (;;)
    {
      return;
      if (this.k == null) {}
      try
      {
        if (this.k == null) {
          this.k = new ar(this.b, this.f);
        }
        TraceLocation localTraceLocation = new TraceLocation(paramLocRequest.getTag(), 0, "成功", "", "", "", 0.0D, 0.0D, CoordType.bd09ll, 0.0D, 0.0F, 0.0F, 0, "");
        if (this.k.a(this.b, this.f, localTraceLocation))
        {
          if (paramLocRequest.isCanceled()) {
            continue;
          }
          localTraceLocation.setLocType(LocType.GPS);
          paramOnEntityListener.onReceiveLocation(localTraceLocation);
        }
      }
      finally {}
    }
    aa.a(this.b, paramLocRequest, paramOnEntityListener);
  }
  
  public final void queryStayPoint(StayPointRequest paramStayPointRequest, OnAnalysisListener paramOnAnalysisListener)
  {
    if (a.a("queryStayPoint", paramStayPointRequest, paramOnAnalysisListener)) {
      a.a(paramStayPointRequest, paramOnAnalysisListener);
    }
  }
  
  public final void searchEntity(SearchRequest paramSearchRequest, OnEntityListener paramOnEntityListener)
  {
    if (a.a("searchEntity", paramSearchRequest, paramOnEntityListener)) {
      a.a(paramSearchRequest, paramOnEntityListener);
    }
  }
  
  public final boolean setCacheSize(int paramInt)
  {
    if (paramInt < 50) {}
    for (;;)
    {
      return false;
      if (this.d == null)
      {
        if (Trace.a(paramInt))
        {
          am.a(paramInt);
          return true;
        }
      }
      else {
        try
        {
          if (this.d.setCacheSize(paramInt))
          {
            am.a(paramInt);
            return true;
          }
        }
        catch (Exception localException) {}
      }
    }
    return false;
  }
  
  public final boolean setInterval(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 <= 0) || (paramInt1 > 300) || (paramInt2 < paramInt1) || (paramInt2 < 2) || (paramInt2 > 300) || (paramInt2 % paramInt1 != 0)) {
      bool = false;
    }
    do
    {
      return bool;
      bool = Trace.a(paramInt1, paramInt2);
    } while (this.d == null);
    try
    {
      bool = this.d.setInterval(paramInt1, paramInt2);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public final boolean setLocTimeOffset(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    boolean bool = Trace.b(paramInt);
    if (this.d == null) {
      return bool;
    }
    try
    {
      bool = this.d.setLocTimeOffset(paramInt);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public final LBSTraceClient setLocationMode(LocationMode paramLocationMode)
  {
    LocationMode localLocationMode = paramLocationMode;
    if (paramLocationMode == null) {
      localLocationMode = LocationMode.High_Accuracy;
    }
    this.g = localLocationMode;
    if (this.d == null) {
      return this;
    }
    try
    {
      this.d.setLocationMode(this.g.ordinal());
      return this;
    }
    catch (Exception paramLocationMode) {}
    return this;
  }
  
  public final void setOnCustomAttributeListener(OnCustomAttributeListener paramOnCustomAttributeListener)
  {
    this.i = paramOnCustomAttributeListener;
  }
  
  public final void setOnTraceListener(OnTraceListener paramOnTraceListener)
  {
    this.h = paramOnTraceListener;
  }
  
  public final LBSTraceClient setProtocolType(ProtocolType paramProtocolType)
  {
    ProtocolType localProtocolType = paramProtocolType;
    if (paramProtocolType == null) {
      localProtocolType = ProtocolType.HTTPS;
    }
    com.baidu.trace.c.a.b = localProtocolType;
    if (this.d == null) {
      return this;
    }
    try
    {
      this.d.setProtocolType(com.baidu.trace.c.a.b.ordinal());
      return this;
    }
    catch (Exception paramProtocolType) {}
    return this;
  }
  
  public final void startGather(OnTraceListener paramOnTraceListener)
  {
    if (paramOnTraceListener != null) {
      this.h = paramOnTraceListener;
    }
    if (this.d == null) {
      if (e.a(this.b, LBSTraceService.class.getName()))
      {
        if (this.c == null) {
          this.c = new Intent(this.b, LBSTraceService.class);
        }
        this.c.putExtra("operateType", 1);
        b();
      }
    }
    int m;
    do
    {
      for (;;)
      {
        return;
        if (this.h != null)
        {
          this.h.onStartGatherCallback(12002, "服务未开启");
          return;
          try
          {
            m = this.d.startGather();
            if (this.h != null)
            {
              if (52 != m) {
                break label173;
              }
              this.h.onStartGatherCallback(0, "成功");
              return;
            }
          }
          catch (Exception paramOnTraceListener) {}
        }
      }
    } while (this.h == null);
    if (!e.a(this.b, LBSTraceService.class.getName()))
    {
      this.h.onStartGatherCallback(12002, "服务未开启");
      return;
      label173:
      if (54 == m)
      {
        this.h.onStartGatherCallback(12003, "采集已开启");
        return;
      }
      this.h.onStartGatherCallback(12001, "采集开启失败");
      return;
    }
    this.h.onStartGatherCallback(12000, "请求发送失败");
  }
  
  public final void startTrace(Trace paramTrace, OnTraceListener paramOnTraceListener)
  {
    if (paramTrace == null) {
      a.a("BaiduTraceSDK", "Trace instance is null");
    }
    long l1;
    label104:
    String str;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (paramOnTraceListener != null) {
              this.h = paramOnTraceListener;
            }
            try
            {
              c();
              if (a == null) {
                a = this;
              }
              l1 = paramTrace.getServiceId();
              if (l1 > 0L) {
                break label104;
              }
              if (this.h != null)
              {
                this.h.onStartTraceCallback(10002, "service_id参数错误");
                a.a("BaiduTraceSDK", "serviceId is invalid");
                return;
              }
            }
            catch (Exception paramTrace) {}
          }
        } while (this.h == null);
        this.h.onStartTraceCallback(10000, "请求发送失败");
        return;
        z.b = l1;
        paramOnTraceListener = d.b.getKey();
        if (!TextUtils.isEmpty(paramOnTraceListener)) {
          break;
        }
      } while (this.h == null);
      this.h.onStartTraceCallback(10002, "ak参数错误");
      a.a("BaiduTraceSDK", "ak is empty string or null");
      return;
      str = paramTrace.getEntityName();
      if (e.a(str)) {
        break;
      }
    } while (this.h == null);
    this.h.onStartTraceCallback(10002, "entity_name参数错误");
    a.a("BaiduTraceSDK", "entityName is empty string or null");
    return;
    if (this.c == null) {
      this.c = new Intent(this.b, LBSTraceService.class);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("locationMode", this.g.ordinal());
    localBundle.putInt("protocolType", com.baidu.trace.c.a.b.ordinal());
    localBundle.putInt("gatherInterval", Trace.a);
    localBundle.putInt("packInterval", Trace.b);
    localBundle.putInt("locTimeOffset", Trace.d);
    localBundle.putLong("serviceId", l1);
    localBundle.putBoolean("isNeedObjectStorage", paramTrace.isNeedObjectStorage());
    localBundle.putString("ak", paramOnTraceListener);
    localBundle.putString("entityName", str);
    localBundle.putString("mcode", d.b.getMCode());
    localBundle.putString("pcn", e.c(this.b));
    if (50 <= Trace.c) {
      localBundle.putInt("cacheSize", Trace.c);
    }
    if (paramTrace.getNotification() != null) {
      localBundle.putParcelable("notification", paramTrace.getNotification());
    }
    this.c.putExtra("initData", localBundle);
    this.c.putExtra("operateType", 0);
    this.c.putExtra("processID", Process.myPid());
    b();
  }
  
  public final void stopGather(OnTraceListener paramOnTraceListener)
  {
    if (paramOnTraceListener != null) {
      this.h = paramOnTraceListener;
    }
    if (this.d == null) {
      if (e.a(this.b, LBSTraceService.class.getName()))
      {
        if (this.c == null) {
          this.c = new Intent(this.b, LBSTraceService.class);
        }
        this.c.putExtra("operateType", 2);
        b();
      }
    }
    int m;
    do
    {
      for (;;)
      {
        return;
        if (this.h != null)
        {
          this.h.onStopGatherCallback(13002, "服务未开启");
          return;
          try
          {
            m = this.d.stopGather();
            if (this.h != null)
            {
              if (55 != m) {
                break label173;
              }
              this.h.onStopGatherCallback(0, "成功");
              return;
            }
          }
          catch (Exception paramOnTraceListener) {}
        }
      }
    } while (this.h == null);
    if (!e.a(this.b, LBSTraceService.class.getName()))
    {
      this.h.onStopGatherCallback(13002, "服务未开启");
      return;
      label173:
      if (57 == m)
      {
        this.h.onStopGatherCallback(13003, "采集已停止");
        return;
      }
      this.h.onStopGatherCallback(13001, "采集停止失败");
      return;
    }
    this.h.onStartGatherCallback(13000, "请求发送失败");
  }
  
  public final void stopRealTimeLoc()
  {
    if (this.k != null) {
      this.k.b();
    }
  }
  
  public final void stopTrace(Trace paramTrace, OnTraceListener paramOnTraceListener)
  {
    if (paramTrace == null) {
      a.a("BaiduTraceSDK", "Trace instance is null");
    }
    do
    {
      do
      {
        return;
        if (paramOnTraceListener != null) {
          this.h = paramOnTraceListener;
        }
        if (this.d != null) {
          break;
        }
      } while (this.h == null);
      this.h.onStopTraceCallback(11002, "服务未开启");
      return;
      try
      {
        this.d.stopTrace(paramTrace.getServiceId(), paramTrace.getEntityName());
        return;
      }
      catch (Exception paramTrace) {}
    } while (this.h == null);
    this.h.onStopTraceCallback(11000, "请求发送失败");
  }
  
  public final void updateEntity(UpdateEntityRequest paramUpdateEntityRequest, OnEntityListener paramOnEntityListener)
  {
    if (a.a("updateEntity", paramUpdateEntityRequest, paramOnEntityListener)) {
      a.a(paramUpdateEntityRequest, paramOnEntityListener);
    }
  }
  
  public final void updateFence(UpdateFenceRequest paramUpdateFenceRequest, OnFenceListener paramOnFenceListener)
  {
    if (a.a("updateFence", paramUpdateFenceRequest, paramOnFenceListener)) {
      a.a(this.b, this.d, this.f, paramUpdateFenceRequest, paramOnFenceListener);
    }
  }
  
  static class ClientListener
    extends IListener.Stub
  {
    private WeakReference<LBSTraceClient> traceClient = null;
    
    public ClientListener(LBSTraceClient paramLBSTraceClient)
    {
      this.traceClient = new WeakReference(paramLBSTraceClient);
    }
    
    private void sendMessage(int paramInt)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt;
      if ((this.traceClient != null) && (LBSTraceClient.h((LBSTraceClient)this.traceClient.get()) != null)) {
        LBSTraceClient.h((LBSTraceClient)this.traceClient.get()).sendMessage(localMessage);
      }
    }
    
    public void extendedOperationCallback(int paramInt, String paramString)
      throws RemoteException
    {
      if (paramInt != 0)
      {
        sendMessage(172);
        return;
      }
      paramInt = 171;
      try
      {
        paramString = new JSONObject(paramString);
        g.a = paramString.getString("accessKey");
        g.c = paramString.getString("secretKey");
        g.d = paramString.getString("token");
        g.b = paramString.getLong("expireTime");
        h.a();
        sendMessage(paramInt);
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramInt = 172;
        }
      }
    }
    
    public Map<String, String> gatherAttribute(long paramLong)
      throws RemoteException
    {
      LBSTraceClient localLBSTraceClient = (LBSTraceClient)this.traceClient.get();
      if ((localLBSTraceClient != null) && (LBSTraceClient.g(localLBSTraceClient) != null))
      {
        a.a("LC-GPS locTime is: " + paramLong);
        Map localMap = LBSTraceClient.g(localLBSTraceClient).onTrackAttributeCallback(paramLong);
        if (localMap == null) {
          return LBSTraceClient.g(localLBSTraceClient).onTrackAttributeCallback();
        }
        return localMap;
      }
      return null;
    }
    
    public void pushCallback(byte paramByte, String paramString)
      throws RemoteException
    {
      Message localMessage = new Message();
      localMessage.arg1 = paramByte;
      localMessage.obj = paramString;
      localMessage.what = 162;
      if ((this.traceClient != null) && (LBSTraceClient.h((LBSTraceClient)this.traceClient.get()) != null)) {
        LBSTraceClient.h((LBSTraceClient)this.traceClient.get()).sendMessage(localMessage);
      }
    }
    
    public void startGatherCallback(int paramInt)
      throws RemoteException
    {
      sendMessage(paramInt);
    }
    
    public void startTraceCallback(int paramInt)
      throws RemoteException
    {
      sendMessage(paramInt);
    }
    
    public void stopGatherCallback(int paramInt)
      throws RemoteException
    {
      sendMessage(paramInt);
    }
    
    public void stopTraceCallback(int paramInt)
      throws RemoteException
    {
      sendMessage(paramInt);
    }
  }
  
  static final class a
    extends Handler
  {
    private WeakReference<LBSTraceClient> a = null;
    
    public a(LBSTraceClient paramLBSTraceClient)
    {
      this.a = new WeakReference(paramLBSTraceClient);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      LBSTraceClient localLBSTraceClient = (LBSTraceClient)this.a.get();
      if (localLBSTraceClient == null) {
        a.a("LBSTraceClient instance is null");
      }
      label382:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    for (;;)
                                    {
                                      return;
                                      switch (paramMessage.what)
                                      {
                                      case 111: 
                                      default: 
                                        return;
                                      case 18: 
                                        if (LBSTraceClient.c(localLBSTraceClient) != null)
                                        {
                                          LBSTraceClient.c(localLBSTraceClient).onStartTraceCallback(10003, "网络连接失败");
                                          return;
                                        }
                                        break;
                                      case 124: 
                                        if (LBSTraceClient.c(localLBSTraceClient) != null)
                                        {
                                          LBSTraceClient.c(localLBSTraceClient).onStartTraceCallback(0, "成功");
                                          return;
                                        }
                                        break;
                                      case 1241: 
                                        if (LBSTraceClient.c(localLBSTraceClient) != null)
                                        {
                                          LBSTraceClient.c(localLBSTraceClient).onStartTraceCallback(10001, "服务开启失败");
                                          return;
                                        }
                                        break;
                                      case 10000: 
                                        if (LBSTraceClient.c(localLBSTraceClient) != null)
                                        {
                                          LBSTraceClient.c(localLBSTraceClient).onStartTraceCallback(10000, "请求发送失败");
                                          return;
                                        }
                                        break;
                                      case 142: 
                                      case 143: 
                                        try
                                        {
                                          LBSTraceClient.b(localLBSTraceClient).unregisterListener();
                                          LBSTraceClient.e(localLBSTraceClient).unbindService(LBSTraceClient.d(localLBSTraceClient));
                                          LBSTraceClient.e(localLBSTraceClient).stopService(LBSTraceClient.f(localLBSTraceClient));
                                          if (LBSTraceClient.c(localLBSTraceClient) != null)
                                          {
                                            if (142 != paramMessage.what) {
                                              break label382;
                                            }
                                            LBSTraceClient.c(localLBSTraceClient).onStopTraceCallback(0, "成功");
                                          }
                                          for (;;)
                                          {
                                            LBSTraceClient.a(localLBSTraceClient, null);
                                            return;
                                            LBSTraceClient.c(localLBSTraceClient).onStopTraceCallback(11004, "服务停止成功，还有未上传的缓存轨迹");
                                          }
                                          if (LBSTraceClient.c(localLBSTraceClient) == null) {}
                                        }
                                        catch (Exception paramMessage)
                                        {
                                          localObject = new StringWriter();
                                          paramMessage.printStackTrace(new PrintWriter((Writer)localObject));
                                          a.a("unbind and stop LBSTraceService failed, Exception : " + ((StringWriter)localObject).toString());
                                          if (LBSTraceClient.c(localLBSTraceClient) != null) {
                                            LBSTraceClient.c(localLBSTraceClient).onStopTraceCallback(11001, "服务停止失败");
                                          }
                                          return;
                                        }
                                        finally
                                        {
                                          com.baidu.trace.c.h.a();
                                        }
                                      }
                                    }
                                    LBSTraceClient.c(localLBSTraceClient).onStartTraceCallback(10004, "网络未开启");
                                    return;
                                  } while (LBSTraceClient.c(localLBSTraceClient) == null);
                                  LBSTraceClient.c(localLBSTraceClient).onStartTraceCallback(10005, "服务正在开启");
                                  return;
                                } while (LBSTraceClient.c(localLBSTraceClient) == null);
                                LBSTraceClient.c(localLBSTraceClient).onStartTraceCallback(10006, "服务已开启");
                                return;
                              } while (LBSTraceClient.c(localLBSTraceClient) == null);
                              LBSTraceClient.c(localLBSTraceClient).onStartTraceCallback(10007, "服务正在停止");
                              return;
                            } while (LBSTraceClient.c(localLBSTraceClient) == null);
                            LBSTraceClient.c(localLBSTraceClient).onInitBOSCallback(0, "成功");
                            return;
                          } while (LBSTraceClient.c(localLBSTraceClient) == null);
                          LBSTraceClient.c(localLBSTraceClient).onInitBOSCallback(1, "失败");
                          return;
                        } while (LBSTraceClient.c(localLBSTraceClient) == null);
                        LBSTraceClient.c(localLBSTraceClient).onStopTraceCallback(11001, "服务停止失败");
                        return;
                      } while (LBSTraceClient.c(localLBSTraceClient) == null);
                      LBSTraceClient.c(localLBSTraceClient).onStopTraceCallback(11002, "服务未开启");
                      return;
                    } while (LBSTraceClient.c(localLBSTraceClient) == null);
                    LBSTraceClient.c(localLBSTraceClient).onStopTraceCallback(11003, "服务正在停止");
                    return;
                  } while (LBSTraceClient.c(localLBSTraceClient) == null);
                  LBSTraceClient.c(localLBSTraceClient).onStartGatherCallback(0, "成功");
                  return;
                } while (LBSTraceClient.c(localLBSTraceClient) == null);
                LBSTraceClient.c(localLBSTraceClient).onStartGatherCallback(12003, "采集已开启");
                return;
              } while (LBSTraceClient.c(localLBSTraceClient) == null);
              LBSTraceClient.c(localLBSTraceClient).onStartGatherCallback(12001, "采集开启失败");
              return;
            } while (LBSTraceClient.c(localLBSTraceClient) == null);
            LBSTraceClient.c(localLBSTraceClient).onStopGatherCallback(13003, "采集已停止");
            return;
          } while (LBSTraceClient.c(localLBSTraceClient) == null);
          LBSTraceClient.c(localLBSTraceClient).onStopGatherCallback(0, "成功");
          return;
        } while (LBSTraceClient.c(localLBSTraceClient) == null);
        LBSTraceClient.c(localLBSTraceClient).onStopGatherCallback(13001, "采集停止失败");
        return;
      } while (LBSTraceClient.c(localLBSTraceClient) == null);
      byte b = (byte)paramMessage.arg1;
      paramMessage = (String)paramMessage.obj;
      Object localObject = new PushMessage();
      FenceAlarmPushInfo localFenceAlarmPushInfo = new FenceAlarmPushInfo();
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject(paramMessage);
          if (localJSONObject.has("fence_id")) {
            localFenceAlarmPushInfo.setFenceId(localJSONObject.getLong("fence_id"));
          }
          if (localJSONObject.has("fence")) {
            localFenceAlarmPushInfo.setFenceName(localJSONObject.getString("fence"));
          }
          if (localJSONObject.has("monitored_person")) {
            localFenceAlarmPushInfo.setMonitoredPerson(localJSONObject.getString("monitored_person"));
          }
          if (localJSONObject.has("action")) {
            if (3 != b) {
              continue;
            }
          }
          switch (localJSONObject.getInt("action"))
          {
          case 1: 
            AlarmPoint localAlarmPoint2 = new AlarmPoint();
            localAlarmPoint1 = new AlarmPoint();
            if (localJSONObject.has("time")) {
              localAlarmPoint2.setLocTime(localJSONObject.getLong("time"));
            }
            if (localJSONObject.has("create_time")) {
              localAlarmPoint2.setCreateTime(localJSONObject.getLong("create_time"));
            }
            if ((localJSONObject.has("latitude")) && (localJSONObject.has("longitude"))) {
              localAlarmPoint2.setLocation(new LatLng(localJSONObject.getDouble("latitude"), localJSONObject.getDouble("longitude")));
            }
            if (localJSONObject.has("coord_type")) {
              paramMessage = CoordType.bd09ll;
            }
            switch (localJSONObject.getInt("coord_type"))
            {
            case 1: 
              localAlarmPoint2.setCoordType(paramMessage);
              if (localJSONObject.has("radius")) {
                localAlarmPoint2.setRadius(localJSONObject.getDouble("radius"));
              }
              if (localJSONObject.has("cur_point")) {
                a.a(localJSONObject.getJSONObject("cur_point"), CoordType.bd09ll, localAlarmPoint2, String.class);
              }
              localFenceAlarmPushInfo.setCurrentPoint(localAlarmPoint2);
              if (localJSONObject.has("pre_point"))
              {
                paramMessage = localJSONObject.getJSONObject("pre_point");
                if (3 != b) {
                  continue;
                }
                a.a(paramMessage, CoordType.bd09ll, localAlarmPoint1, Integer.class);
                localFenceAlarmPushInfo.setPrePoint(localAlarmPoint1);
              }
              break;
            }
            break;
          }
        }
        catch (Exception paramMessage)
        {
          JSONObject localJSONObject;
          AlarmPoint localAlarmPoint1;
          continue;
        }
        ((PushMessage)localObject).setFenceAlarmPushInfo(localFenceAlarmPushInfo);
        LBSTraceClient.c(localLBSTraceClient).onPushCallback(b, (PushMessage)localObject);
        return;
        localFenceAlarmPushInfo.setMonitoredAction(MonitoredAction.enter);
        continue;
        localFenceAlarmPushInfo.setMonitoredAction(MonitoredAction.exit);
        continue;
        if (4 == b)
        {
          localFenceAlarmPushInfo.setMonitoredAction(MonitoredAction.valueOf(localJSONObject.getString("action")));
          continue;
          paramMessage = CoordType.wgs84;
          continue;
          paramMessage = CoordType.gcj02;
          continue;
          paramMessage = CoordType.bd09ll;
          continue;
          if (4 == b)
          {
            a.a(paramMessage, CoordType.bd09ll, localAlarmPoint1, String.class);
            continue;
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/LBSTraceClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */