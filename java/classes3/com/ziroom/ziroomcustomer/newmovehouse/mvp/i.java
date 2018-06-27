package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.baidu.mapapi.map.Arc;
import com.baidu.mapapi.map.ArcOptions;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapClickListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData.Builder;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Projection;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.mapapi.utils.DistanceUtil;
import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.api.track.LatestPoint;
import com.baidu.trace.api.track.LatestPointRequest;
import com.baidu.trace.api.track.LatestPointResponse;
import com.baidu.trace.api.track.OnTrackListener;
import com.baidu.trace.model.ProcessOption;
import com.baidu.trace.model.ProtocolType;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.h;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.d.ak;
import com.ziroom.ziroomcustomer.newclean.d.au.b;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MHPrivilegeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MovingVanCancleOrderActivity;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail.SupplierEmployeeInfoVOBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail.UserOrderItemVOsBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MvButtonState;
import com.ziroom.ziroomcustomer.newmovehouse.widget.MoveEvalWidget;
import com.ziroom.ziroomcustomer.newmovehouse.widget.MoveEvalWidget.a;
import com.ziroom.ziroomcustomer.util.af;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class i
  implements h.a
{
  private MovingVanDetail A;
  private String B;
  private String C = "";
  private boolean D;
  private boolean E = true;
  private boolean F = false;
  private ak G;
  private int H;
  private boolean I;
  private int J = 0;
  private String K = "";
  Timer a = null;
  int b = 0;
  List<MovingVanDetail.UserOrderItemVOsBean> c = new ArrayList();
  final List<MovingVanDetail.UserOrderItemVOsBean> d = new ArrayList();
  final List<MovingVanDetail.UserOrderItemVOsBean> e = new ArrayList();
  private WeakReference<h.b> f;
  private f g;
  private boolean h = false;
  private Handler i = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      i.this.getData();
    }
  };
  private int j = 0;
  private LBSTraceClient k = null;
  private RoutePlanSearch l = null;
  private LatestPointRequest m;
  private OnTrackListener n;
  private com.baidu.mapapi.model.LatLng o;
  private com.baidu.mapapi.model.LatLng p;
  private Polyline q;
  private Arc r;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = true;
  private boolean x = false;
  private String y;
  private String z;
  
  public i(h.b paramb)
  {
    this.f = new WeakReference(paramb);
    if (paramb != null) {
      paramb.setPresenter(this);
    }
  }
  
  private float a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    String[] arrayOfString = new String[16];
    arrayOfString[0] = "50";
    arrayOfString[1] = "100";
    arrayOfString[2] = "200";
    arrayOfString[3] = "500";
    arrayOfString[4] = "1000";
    arrayOfString[5] = "2000";
    arrayOfString[6] = "5000";
    arrayOfString[7] = "10000";
    arrayOfString[8] = "20000";
    arrayOfString[9] = "25000";
    arrayOfString[10] = "50000";
    arrayOfString[11] = "100000";
    arrayOfString[12] = "200000";
    arrayOfString[13] = "500000";
    arrayOfString[14] = "1000000";
    arrayOfString[15] = "2000000";
    paramDouble1 = DistanceUtil.getDistance(new com.baidu.mapapi.model.LatLng(paramDouble3, paramDouble1), new com.baidu.mapapi.model.LatLng(paramDouble4, paramDouble2));
    int i1 = 0;
    int i2 = arrayOfString.length;
    while (i1 < i2)
    {
      if (Integer.parseInt(arrayOfString[i1]) - paramDouble1 > 0.0D) {
        return 18 - i1 + 3 - 1;
      }
      i1 += 1;
    }
    return 10.0F;
  }
  
  private BitmapDescriptor a(com.baidu.mapapi.model.LatLng paramLatLng)
  {
    if (this.A.getOrderStatus() <= 20) {}
    for (BitmapDescriptor localBitmapDescriptor = BitmapDescriptorFactory.fromResource(2130840282);; localBitmapDescriptor = BitmapDescriptorFactory.fromResource(2130840281))
    {
      paramLatLng = new MarkerOptions().position(paramLatLng).icon(localBitmapDescriptor);
      ((h.b)this.f.get()).getBaiduMap().addOverlay(paramLatLng);
      return localBitmapDescriptor;
    }
  }
  
  private void a()
  {
    com.ziroom.ziroomcustomer.e.n.getOrderMapStatus(((h.b)this.f.get()).getViewContext(), this.y, new com.ziroom.ziroomcustomer.e.a.d(((h.b)this.f.get()).getViewContext(), new com.ziroom.ziroomcustomer.e.c.d() {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        if (!i.e(i.this)) {
          return;
        }
        com.freelxl.baselibrary.f.d.e("TAG", "请求失败：" + paramAnonymousThrowable.getMessage());
        ((h.b)i.b(i.this).get()).switchBehaviorByMapStatus();
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (!i.e(i.this)) {}
        do
        {
          do
          {
            return;
          } while (paramAnonymouse == null);
          i.this.b = ((Integer)paramAnonymouse.get("isShow")).intValue();
          ((h.b)i.b(i.this).get()).switchBehaviorByMapStatus();
          ((h.b)i.b(i.this).get()).switchRefrushAbledByBehaviorStatusAndMapStatus();
          if (i.this.b == 1)
          {
            i.f(i.this);
            i.this.initMapView();
            i.a(i.this, new LBSTraceClient(((h.b)i.b(i.this).get()).getViewContext()));
            i.g(i.this).setProtocolType(ProtocolType.HTTP);
            if (TextUtils.isEmpty(i.h(i.this))) {
              i.a(i.this, i.d(i.this).getSupplierEmployeeInfoVO().getEmployeeCode());
            }
            if (i.i(i.this) == null) {
              i.a(i.this, RoutePlanSearch.newInstance());
            }
            if (i.j(i.this) == null)
            {
              i.a(i.this, new LatestPointRequest(new AtomicInteger().incrementAndGet(), 128746L, i.h(i.this)));
              paramAnonymouse = new ProcessOption();
              paramAnonymouse.setNeedDenoise(true);
              paramAnonymouse.setRadiusThreshold(100);
              i.j(i.this).setProcessOption(paramAnonymouse);
            }
            i.k(i.this);
            return;
          }
          if (i.this.a != null) {
            i.this.a.cancel();
          }
        } while (i.l(i.this) == null);
        i.l(i.this).removeCallbacksAndMessages(null);
      }
    });
  }
  
  private void a(com.baidu.mapapi.model.LatLng paramLatLng1, com.baidu.mapapi.model.LatLng paramLatLng2)
  {
    if (paramLatLng2.longitude < paramLatLng1.longitude) {}
    for (;;)
    {
      Object localObject2 = ((h.b)this.f.get()).getBaiduMap().getProjection();
      Point localPoint1 = ((Projection)localObject2).toScreenLocation(paramLatLng2);
      Point localPoint2 = ((Projection)localObject2).toScreenLocation(paramLatLng1);
      int i4 = 0 - localPoint1.x;
      int i1;
      Point localPoint3;
      double d1;
      double d2;
      double d3;
      label371:
      double d4;
      int i3;
      int i2;
      if (localPoint1.y < localPoint2.y)
      {
        i1 = 0 - localPoint2.y;
        localPoint3 = new Point();
        Point localPoint4 = new Point();
        localObject1 = new Point();
        localPoint3.x = Math.abs(localPoint1.x + i4);
        localPoint3.y = Math.abs(localPoint1.y + i1);
        localPoint4.x = Math.abs(localPoint2.x + i4);
        localPoint4.y = Math.abs(localPoint2.y + i1);
        com.freelxl.baselibrary.f.d.e("TAG", "dxPointStartX=" + localPoint3.x + "dxPointStartY=" + localPoint3.y + "dxPointEndX=" + localPoint4.x + "dxPointEndY=" + localPoint4.y);
        d1 = (localPoint4.y - localPoint3.y) / (localPoint4.x - localPoint3.x);
        d2 = Math.pow(localPoint4.x - localPoint3.x, 2.0D);
        d2 = Math.sqrt(Math.pow(localPoint4.y - localPoint3.y, 2.0D) + d2);
        d3 = Math.cos(Math.toRadians(30.0D));
        d2 = d2 / 2.0D / d3;
        d3 = 90.0D - Math.atan(d1) * 180.0D / 3.141592653589793D;
        if (d3 >= 30.0D) {
          break label776;
        }
        d1 = -d3 - 60.0D;
        d4 = Math.sin(Math.toRadians(d1));
        d1 = Math.cos(Math.toRadians(d1));
        if (d3 >= 30.0D) {
          break label786;
        }
        i3 = (int)(-d1 * d2) + localPoint3.x;
        i2 = (int)(-d4 * d2);
        i2 = localPoint3.y + i2;
        label430:
        if (i4 <= 0) {
          break label820;
        }
        ((Point)localObject1).x = (i3 - i4);
        label445:
        if (i1 <= 0) {
          break label836;
        }
      }
      label776:
      label786:
      label820:
      label836:
      for (((Point)localObject1).y = (i2 - i1);; ((Point)localObject1).y = (Math.abs(i1) - i2))
      {
        com.freelxl.baselibrary.f.d.e("TAG", "centerPointTempX=" + i3 + "-------centerPointTempY=" + i2 + "dx=" + i4 + "-------dy=" + i1);
        com.freelxl.baselibrary.f.d.e("TAG", "SP1.X=" + localPoint1.x + "；SP1.Y=" + localPoint1.y + "；SP2.X=" + localPoint2.x + "；SP2.Y=" + localPoint2.y);
        localObject2 = ((Projection)localObject2).fromScreenLocation((Point)localObject1);
        com.freelxl.baselibrary.f.d.e("TAG", "screenPCenter.X=" + ((Point)localObject1).x + "；screenPCenter.Y=" + ((Point)localObject1).y + "；LatLng.Lat=" + ((com.baidu.mapapi.model.LatLng)localObject2).latitude + "；LatLng.Lon=" + ((com.baidu.mapapi.model.LatLng)localObject2).longitude);
        paramLatLng1 = new ArcOptions().color(((h.b)this.f.get()).getViewContext().getResources().getColor(2131624039)).width(com.ziroom.ziroomcustomer.util.n.dip2px(((h.b)this.f.get()).getViewContext(), 2.0F)).points(paramLatLng2, (com.baidu.mapapi.model.LatLng)localObject2, paramLatLng1);
        this.r = ((Arc)((h.b)this.f.get()).getBaiduMap().addOverlay(paramLatLng1));
        return;
        i1 = 0 - localPoint1.y;
        break;
        d1 = d3 - 30.0D;
        break label371;
        i3 = (int)(d2 * d4) + localPoint3.x;
        i2 = (int)(d2 * d1);
        i2 = localPoint3.y + i2;
        break label430;
        ((Point)localObject1).x = (Math.abs(i4) + i3);
        break label445;
      }
      Object localObject1 = paramLatLng1;
      paramLatLng1 = paramLatLng2;
      paramLatLng2 = (com.baidu.mapapi.model.LatLng)localObject1;
    }
  }
  
  private void a(com.baidu.mapapi.model.LatLng paramLatLng1, com.baidu.mapapi.model.LatLng paramLatLng2, int paramInt)
  {
    if (!j()) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        ((h.b)this.f.get()).getBaiduMap().clear();
        if (this.q != null) {
          this.q.remove();
        }
        if (this.r != null) {
          this.r.remove();
        }
        a(paramLatLng2);
      } while (paramLatLng1 == null);
      localArrayList = new ArrayList();
      localArrayList.add(paramLatLng1);
      localArrayList.add(paramLatLng2);
      b(localArrayList);
      b(paramLatLng1, paramLatLng2, paramInt);
    } while (DistanceUtil.getDistance(paramLatLng1, paramLatLng2) <= 500.0D);
    a(localArrayList);
    a(paramLatLng1, paramLatLng2);
  }
  
  private void a(MvButtonState paramMvButtonState)
  {
    int i1 = paramMvButtonState.getCancelShow();
    int i2 = paramMvButtonState.getPayShow();
    int i3 = paramMvButtonState.getEvaluateShow();
    int i4 = paramMvButtonState.getFinishShow();
    int i5 = paramMvButtonState.getReminderShow();
    this.B = paramMvButtonState.getEmployeeCode();
    this.J = paramMvButtonState.getSendCouponShow();
    this.K = paramMvButtonState.getCouponPromptOne();
    ((h.b)this.f.get()).getBtn().setVisibility(0);
    ((h.b)this.f.get()).setPayContainerVisiable(false);
    if (i1 == 1)
    {
      this.C = "";
      ((h.b)this.f.get()).getBtn().setText("取消订单");
      ((h.b)this.f.get()).getBtn().setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(((h.b)i.b(i.this).get()).getViewContext(), MovingVanCancleOrderActivity.class);
          paramAnonymousView.putExtra("orderCode", i.u(i.this));
          paramAnonymousView.putExtra("move_type", "move_small");
          ((h.b)i.b(i.this).get()).getActivity().startActivity(paramAnonymousView);
        }
      });
    }
    while (i5 == 1)
    {
      ((h.b)this.f.get()).getmTvReminder().setVisibility(0);
      ((h.b)this.f.get()).getmTvReminder().setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          i.y(i.this);
        }
      });
      return;
      if (i2 == 1)
      {
        this.C = "status_pay";
        ((h.b)this.f.get()).getBtn().setText("立即支付");
        ((h.b)this.f.get()).getBtn().setVisibility(8);
        ((h.b)this.f.get()).setPayContainerVisiable(true);
        ((h.b)this.f.get()).getBtn().setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            i.this.setPayOrpertion();
          }
        });
      }
      else if (i3 == 1)
      {
        this.C = "status_eval";
        ((h.b)this.f.get()).getBtn().setText("去评价");
        a(false);
        ((h.b)this.f.get()).getBtn().setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            i.a(i.this, true);
          }
        });
      }
      else if (i4 == 1)
      {
        ((h.b)this.f.get()).getBtn().setText("去验收");
        ((h.b)this.f.get()).getBtn().setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
          }
        });
      }
      else
      {
        ((h.b)this.f.get()).getBtn().setVisibility(8);
      }
    }
    ((h.b)this.f.get()).getmTvReminder().setVisibility(8);
  }
  
  private void a(String paramString)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    String str2 = ((UserInfo)localObject).getUid();
    String str1 = "";
    localObject = str1;
    if (this.E)
    {
      localObject = str1;
      if (this.G != null) {
        localObject = this.G.getCouponCode();
      }
    }
    if (!this.E) {}
    for (str1 = "2";; str1 = "1")
    {
      com.ziroom.ziroomcustomer.e.n.getMoveDetail(((h.b)this.f.get()).getViewContext(), paramString, str2, str1, (String)localObject, new com.ziroom.ziroomcustomer.e.a.d(((h.b)this.f.get()).getViewContext(), new m(MovingVanDetail.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          if (!i.e(i.this)) {
            return;
          }
          ((h.b)i.b(i.this).get()).doneLoad();
        }
        
        public void onSuccess(int paramAnonymousInt, MovingVanDetail paramAnonymousMovingVanDetail)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousMovingVanDetail);
          if (!i.e(i.this)) {}
          do
          {
            return;
            ((h.b)i.b(i.this).get()).doneLoad();
          } while (paramAnonymousMovingVanDetail == null);
          i.a(i.this, paramAnonymousMovingVanDetail);
          if (i.d(i.this) != null)
          {
            if (i.d(i.this).getSupplierEmployeeInfoVO() != null) {
              i.a(i.this, i.d(i.this).getSupplierEmployeeInfoVO().getEmployeeCode());
            }
            if (i.d(i.this).getOrderStatus() > 20) {
              break label220;
            }
            i.b(i.this, new com.baidu.mapapi.model.LatLng(i.d(i.this).getStartAddressLat(), i.d(i.this).getStartAddressLon()));
          }
          for (;;)
          {
            ((h.b)i.b(i.this).get()).getBtn().setClickable(true);
            if ("status_eval".equals(i.s(i.this))) {
              i.a(i.this, false);
            }
            ((h.b)i.b(i.this).get()).showDetail(i.d(i.this));
            i.t(i.this);
            return;
            label220:
            i.b(i.this, new com.baidu.mapapi.model.LatLng(i.d(i.this).getEndAddressLat(), i.d(i.this).getEndAddressLon()));
          }
        }
      });
      return;
    }
  }
  
  private void a(List<com.baidu.mapapi.model.LatLng> paramList)
  {
    BitmapDescriptor localBitmapDescriptor = BitmapDescriptorFactory.fromResource(2130840412);
    paramList = new PolylineOptions().width(com.ziroom.ziroomcustomer.util.n.dip2px(((h.b)this.f.get()).getViewContext(), 20.0F)).customTexture(localBitmapDescriptor).points(paramList);
    this.q = ((Polyline)((h.b)this.f.get()).getBaiduMap().addOverlay(paramList));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.A == null) {
        af.showToast(((h.b)this.f.get()).getViewContext(), "数据刷新中...");
      }
    }
    else {
      while ((this.A == null) || (!"status_eval".equals(this.C)) || (this.s) || (this.v) || ((this.A != null) && (this.A.getSupplierEmployeeInfoVO() == null))) {
        return;
      }
    }
    if (this.w)
    {
      this.w = false;
      ((h.b)this.f.get()).getEvalWidgth().setMoveDetailInfo(this.A, this.J, this.K);
    }
    ((h.b)this.f.get()).getEvalWidgth().setMoveVanEvalListener(new MoveEvalWidget.a()
    {
      public void evalCancleDialog(boolean paramAnonymousBoolean)
      {
        i.d(i.this, "");
      }
      
      public void evalStatus(boolean paramAnonymousBoolean)
      {
        i.b(i.this, true);
        i.b(i.this, "");
        i.c(i.this, i.u(i.this));
        org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("refresh_service_order_list", null));
        i.v(i.this);
      }
      
      public void evalToShare(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          i.c(i.this, true);
        }
      }
    });
    ((h.b)this.f.get()).getEvalWidgth().getmGvCamera().setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        ((h.b)i.b(i.this).get()).setEvalCamera(paramAnonymousInt);
      }
    });
    j.showChooseView(true, ((h.b)this.f.get()).getEvalWidgth());
    j.showCoverAlphaAnimation(true, ((h.b)this.f.get()).getViewConver());
    this.t = true;
    ((h.b)this.f.get()).getViewConver().setClickable(true);
    ((h.b)this.f.get()).getViewConver().setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        i.d(i.this, "");
      }
    });
  }
  
  private void b()
  {
    if (this.a == null)
    {
      this.a = new Timer();
      this.a.scheduleAtFixedRate(new TimerTask()
      {
        public void run()
        {
          if (i.m(i.this)) {
            return;
          }
          Message localMessage = new Message();
          localMessage.what = 1;
          i.l(i.this).sendMessage(localMessage);
        }
      }, 1000L, 60000L);
    }
  }
  
  private void b(com.baidu.mapapi.model.LatLng paramLatLng1, com.baidu.mapapi.model.LatLng paramLatLng2, int paramInt)
  {
    Object localObject2 = LayoutInflater.from(((h.b)this.f.get()).getViewContext()).inflate(2130905009, null, false);
    Object localObject1 = (LinearLayout)((View)localObject2).findViewById(2131697153);
    TextView localTextView1 = (TextView)((View)localObject2).findViewById(2131691744);
    TextView localTextView2 = (TextView)((View)localObject2).findViewById(2131697154);
    double d1 = DistanceUtil.getDistance(paramLatLng1, paramLatLng2);
    localObject1 = new DecimalFormat("######0.00");
    if (d1 > 1000.0D)
    {
      d1 /= 1000.0D;
      localObject1 = ((DecimalFormat)localObject1).format(d1) + "km";
      localTextView1.setText((CharSequence)localObject1);
      paramInt /= 60;
      if (paramInt < 1) {
        break label432;
      }
      localTextView2.setText("预计" + paramInt + "分钟到达");
    }
    for (;;)
    {
      if ((this.A.getOrderStatus() >= 25) && (DistanceUtil.getDistance(paramLatLng1, new com.baidu.mapapi.model.LatLng(this.A.getStartAddressLat(), this.A.getStartAddressLon())) < 200.0D)) {
        localTextView2.setText("正在为您服务");
      }
      localObject1 = BitmapDescriptorFactory.fromBitmap(a.getBitmapFromView((View)localObject2));
      localObject2 = BitmapDescriptorFactory.fromBitmap(a.getBitmapFromView(LayoutInflater.from(((h.b)this.f.get()).getViewContext()).inflate(2130905010, null, false)));
      ((h.b)this.f.get()).getBaiduMap().setMyLocationConfigeration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, (BitmapDescriptor)localObject2));
      paramLatLng2 = new MyLocationData.Builder().accuracy(0.0F).direction((float)a.getDerection(paramLatLng1, paramLatLng2)).latitude(paramLatLng1.latitude).longitude(paramLatLng1.longitude).build();
      paramLatLng1 = new MarkerOptions().position(paramLatLng1).icon((BitmapDescriptor)localObject1);
      ((h.b)this.f.get()).getBaiduMap().addOverlay(paramLatLng1);
      ((h.b)this.f.get()).getBaiduMap().setMyLocationData(paramLatLng2);
      return;
      localObject1 = ((DecimalFormat)localObject1).format(d1) + "m";
      break;
      label432:
      localTextView2.setText("师傅即将到达");
    }
  }
  
  private void b(String paramString)
  {
    this.t = false;
    this.s = true;
    j.showChooseView(false, ((h.b)this.f.get()).getEvalWidgth());
    j.showCoverAlphaAnimation(false, ((h.b)this.f.get()).getViewConver());
    ((h.b)this.f.get()).getViewConver().setClickable(false);
    if (this.u)
    {
      this.u = false;
      g();
    }
  }
  
  private void b(List<com.baidu.mapapi.model.LatLng> paramList)
  {
    if (paramList.size() > 0)
    {
      double d5 = ((com.baidu.mapapi.model.LatLng)paramList.get(0)).longitude;
      double d3 = ((com.baidu.mapapi.model.LatLng)paramList.get(0)).longitude;
      double d2 = ((com.baidu.mapapi.model.LatLng)paramList.get(0)).latitude;
      double d1 = ((com.baidu.mapapi.model.LatLng)paramList.get(0)).latitude;
      int i1 = paramList.size() - 1;
      while (i1 >= 0)
      {
        com.baidu.mapapi.model.LatLng localLatLng = (com.baidu.mapapi.model.LatLng)paramList.get(i1);
        d4 = d5;
        if (localLatLng.longitude > d5) {
          d4 = localLatLng.longitude;
        }
        d6 = d3;
        if (localLatLng.longitude < d3) {
          d6 = localLatLng.longitude;
        }
        double d7 = d2;
        if (localLatLng.latitude > d2) {
          d7 = localLatLng.latitude;
        }
        double d8 = d1;
        if (localLatLng.latitude < d1) {
          d8 = localLatLng.latitude;
        }
        i1 -= 1;
        d5 = d4;
        d3 = d6;
        d2 = d7;
        d1 = d8;
      }
      double d4 = (d5 + d3) / 2.0D;
      double d6 = (d2 + d1) / 2.0D;
      float f1 = a(d5, d3, d2, d1);
      ((h.b)this.f.get()).getBaiduMap().setMapStatus(MapStatusUpdateFactory.newLatLngZoom(new com.baidu.mapapi.model.LatLng(d6, d4), f1));
      return;
    }
    ((h.b)this.f.get()).getBaiduMap().setMapStatus(MapStatusUpdateFactory.newLatLngZoom(new com.baidu.mapapi.model.LatLng(35.563611D, 103.388611D), 5.0F));
  }
  
  private void c()
  {
    if (this.n == null) {
      this.n = new OnTrackListener()
      {
        public void onLatestPointCallback(LatestPointResponse paramAnonymousLatestPointResponse)
        {
          super.onLatestPointCallback(paramAnonymousLatestPointResponse);
          if (!i.e(i.this)) {
            return;
          }
          Log.e("TAG", "onLatestPointCallback:" + paramAnonymousLatestPointResponse.toString());
          if (paramAnonymousLatestPointResponse.getStatus() != 0)
          {
            if (i.n(i.this) < 10) {
              i.k(i.this);
            }
            for (;;)
            {
              i.q(i.this);
              return;
              com.freelxl.baselibrary.f.d.e("TAG", "获取师傅位置信息失败");
              i.a(i.this, i.o(i.this), i.p(i.this), 0);
            }
          }
          paramAnonymousLatestPointResponse = paramAnonymousLatestPointResponse.getLatestPoint().getLocation();
          if (a.isZeroPoint(paramAnonymousLatestPointResponse.latitude, paramAnonymousLatestPointResponse.longitude))
          {
            i.k(i.this);
            return;
          }
          i.a(i.this, a.convertTrace2Map(paramAnonymousLatestPointResponse));
          i.r(i.this);
        }
      };
    }
    this.k.queryLatestPoint(this.m, this.n);
  }
  
  private void d()
  {
    Object localObject = new OnGetRoutePlanResultListener()
    {
      public void onGetBikingRouteResult(BikingRouteResult paramAnonymousBikingRouteResult) {}
      
      public void onGetDrivingRouteResult(DrivingRouteResult paramAnonymousDrivingRouteResult)
      {
        int j = 0;
        if ((paramAnonymousDrivingRouteResult == null) || (paramAnonymousDrivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR))
        {
          com.freelxl.baselibrary.f.d.e("TAG", "路线规划失败" + paramAnonymousDrivingRouteResult.toString());
          i.r(i.this);
          return;
        }
        com.freelxl.baselibrary.f.d.e("TAG", "路线规划成功" + paramAnonymousDrivingRouteResult.toString());
        paramAnonymousDrivingRouteResult = paramAnonymousDrivingRouteResult.getRouteLines();
        int i = j;
        if (paramAnonymousDrivingRouteResult != null)
        {
          i = j;
          if (paramAnonymousDrivingRouteResult.size() > 0) {
            i = ((DrivingRouteLine)paramAnonymousDrivingRouteResult.get(0)).getDuration();
          }
        }
        i.a(i.this, i.o(i.this), i.p(i.this), i);
      }
      
      public void onGetTransitRouteResult(TransitRouteResult paramAnonymousTransitRouteResult) {}
      
      public void onGetWalkingRouteResult(WalkingRouteResult paramAnonymousWalkingRouteResult) {}
    };
    this.l.setOnGetRoutePlanResultListener((OnGetRoutePlanResultListener)localObject);
    localObject = PlanNode.withLocation(this.o);
    PlanNode localPlanNode = PlanNode.withLocation(this.p);
    localObject = new DrivingRoutePlanOption().from((PlanNode)localObject).to(localPlanNode);
    this.l.drivingSearch((DrivingRoutePlanOption)localObject);
  }
  
  private void e()
  {
    ((h.b)this.f.get()).getBaiduMap().setOnMapClickListener(new BaiduMap.OnMapClickListener()
    {
      public void onMapClick(com.baidu.mapapi.model.LatLng paramAnonymousLatLng)
      {
        ((h.b)i.b(i.this).get()).onMapClicked();
      }
      
      public boolean onMapPoiClick(MapPoi paramAnonymousMapPoi)
      {
        return false;
      }
    });
  }
  
  private void f()
  {
    this.d.clear();
    this.e.clear();
    this.c.clear();
    int i4 = this.A.getUserOrderItemVOs().size();
    int i2 = 0;
    int i1 = 0;
    int i3 = 0;
    if (i2 < i4)
    {
      this.d.add(this.A.getUserOrderItemVOs().get(i2));
      if (!"优惠金额".equals(((MovingVanDetail.UserOrderItemVOsBean)this.A.getUserOrderItemVOs().get(i2)).getItemName())) {
        break label445;
      }
      i3 = 1;
      i1 = i2;
    }
    label254:
    label445:
    for (;;)
    {
      i2 += 1;
      break;
      if (i3 == 0)
      {
        MovingVanDetail.UserOrderItemVOsBean localUserOrderItemVOsBean = new MovingVanDetail.UserOrderItemVOsBean();
        localUserOrderItemVOsBean.setItemName("优惠金额");
        localUserOrderItemVOsBean.setItemAmount(0);
        this.d.add(localUserOrderItemVOsBean);
        i1 = this.d.size() - 1;
      }
      i2 = 0;
      if (i2 < this.d.size())
      {
        if (this.d.size() < 3) {
          this.e.add(this.d.get(i2));
        }
        do
        {
          for (;;)
          {
            i2 += 1;
            break;
            if (i1 >= 3) {
              break label254;
            }
            if (i2 < 3) {
              this.e.add(this.d.get(i2));
            }
          }
          if (i2 < 2) {
            this.e.add(this.d.get(i2));
          }
        } while (i2 != 2);
        this.e.add(this.d.get(i1));
      }
      if (this.d.size() <= 3)
      {
        this.c.addAll(this.d);
        this.g.notifyDataSetChanged();
        ((h.b)this.f.get()).getRlPull().setVisibility(8);
        ((h.b)this.f.get()).getRvChargeDetail().setVisibility(0);
        return;
      }
      ((h.b)this.f.get()).getRlPull().setVisibility(0);
      this.c.addAll(this.e);
      this.g.notifyDataSetChanged();
      ((h.b)this.f.get()).getRlPull().setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!i.w(i.this))
          {
            i.d(i.this, true);
            i.this.c.clear();
            i.this.c.addAll(i.this.d);
            i.x(i.this).notifyDataSetChanged();
            ((h.b)i.b(i.this).get()).getTvPull().setText("收起");
            ((h.b)i.b(i.this).get()).getIvPull().setBackgroundResource(2130839136);
            return;
          }
          i.d(i.this, false);
          i.this.c.clear();
          i.this.c.addAll(i.this.e);
          i.x(i.this).notifyDataSetChanged();
          ((h.b)i.b(i.this).get()).getTvPull().setText("展开");
          ((h.b)i.b(i.this).get()).getIvPull().setBackgroundResource(2130839134);
        }
      });
      return;
    }
  }
  
  private void g()
  {
    if (ApplicationEx.c.getUser() == null) {}
    while (!this.x) {
      return;
    }
    this.x = false;
    j.createShareOrder(((h.b)this.f.get()).getViewContext(), this.y, "", "2c9085f248ba3f3a0148bb151aca0003", this.B);
  }
  
  private void h()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    com.ziroom.ziroomcustomer.e.n.getMoveOrderControl(((h.b)this.f.get()).getViewContext(), this.y, (String)localObject, new com.ziroom.ziroomcustomer.e.a.d(((h.b)this.f.get()).getViewContext(), new m(MvButtonState.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, MvButtonState paramAnonymousMvButtonState)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMvButtonState);
        if (!i.e(i.this)) {}
        while (paramAnonymousMvButtonState == null) {
          return;
        }
        i.a(i.this, paramAnonymousMvButtonState);
      }
    });
  }
  
  private void i()
  {
    com.ziroom.ziroomcustomer.e.n.setMoveReminder(((h.b)this.f.get()).getViewContext(), this.y, new com.freelxl.baselibrary.d.c.a(new h(e.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        if (paramAnonymouse != null)
        {
          String str1 = paramAnonymouse.getString("status");
          String str2 = paramAnonymouse.getString("code");
          if ((!"success".equals(str1)) || (!"200".equals(str2))) {
            break label78;
          }
          if (!TextUtils.isEmpty(paramAnonymouse.getString("data"))) {
            g.textToast(((h.b)i.b(i.this).get()).getViewContext(), paramAnonymouse.getString("data"));
          }
        }
        label78:
        while (TextUtils.isEmpty(paramAnonymouse.getString("message"))) {
          return;
        }
        g.textToast(((h.b)i.b(i.this).get()).getViewContext(), paramAnonymouse.getString("message"));
      }
    });
  }
  
  private boolean j()
  {
    return (getView() != null) && (((h.b)this.f.get()).isActive());
  }
  
  public void chargeViewControl()
  {
    if (this.A.getUserOrderItemVOs() == null)
    {
      ((h.b)this.f.get()).getRvChargeDetail().setVisibility(8);
      if ((this.A.getRecommandCoupon() == null) || (TextUtils.isEmpty(this.A.getRecommandCoupon().getCanUseCoupon()))) {
        break label107;
      }
      if (!"1".equals(this.A.getRecommandCoupon().getCanUseCoupon())) {
        break label99;
      }
      this.F = true;
    }
    for (;;)
    {
      this.g.setMoveFeeArrow(this.F);
      return;
      f();
      break;
      label99:
      this.F = false;
      continue;
      label107:
      this.F = false;
    }
  }
  
  public void destoryPollTask()
  {
    if (this.a != null) {
      this.a.cancel();
    }
    if (this.i != null) {
      this.i.removeCallbacksAndMessages(null);
    }
  }
  
  public void detachView()
  {
    if (this.f != null)
    {
      this.f.clear();
      this.f = null;
    }
  }
  
  public void getData()
  {
    if (j())
    {
      this.j = 0;
      h();
      a(this.y);
    }
  }
  
  public int getIsShowMap()
  {
    return this.b;
  }
  
  public String getOrderId()
  {
    return this.y;
  }
  
  public int getTempState()
  {
    return this.H;
  }
  
  public Object getView()
  {
    if (this.f != null) {
      return this.f.get();
    }
    return null;
  }
  
  public void initMapView()
  {
    ((h.b)this.f.get()).mapResControl(true);
    if (((h.b)this.f.get()).getMapView() != null)
    {
      ((h.b)this.f.get()).getMapView().showZoomControls(false);
      e();
    }
  }
  
  public void onKeyBack()
  {
    if (((h.b)this.f.get()).getBehavior().getState() == 5)
    {
      ((h.b)this.f.get()).getBehavior().setState(4);
      return;
    }
    if (this.t)
    {
      b("");
      return;
    }
    ((h.b)this.f.get()).getActivity().finish();
  }
  
  public void setMoverId(String paramString)
  {
    this.B = paramString;
    g();
  }
  
  public void setPayOrpertion()
  {
    if (this.A == null) {}
    while (!"status_pay".equals(this.C)) {
      return;
    }
    Object localObject1 = "";
    String str = "";
    Object localObject2 = localObject1;
    if (this.A.getRecommandCoupon() != null)
    {
      if (!TextUtils.isEmpty(this.A.getRecommandCoupon().getCouponId())) {
        localObject1 = this.A.getRecommandCoupon().getCouponId();
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty(this.A.getRecommandCoupon().getCouponCode())) {}
    }
    for (localObject2 = this.A.getRecommandCoupon().getCouponCode();; localObject2 = str)
    {
      long l1 = this.A.getActualAllAmount().longValue();
      if ((!"move_xiaomian".equals(this.z)) || ("move_small".equals(this.z))) {}
      for (int i1 = 2;; i1 = 6)
      {
        if ("move_van".equals(this.z)) {
          i1 = 4;
        }
        for (;;)
        {
          str = this.A.getEmployeeOrderCode();
          j.setServicePay(((h.b)this.f.get()).getActivity(), "move", str, i1, l1, (String)localObject1, (String)localObject2);
          return;
        }
      }
      localObject1 = localObject2;
    }
  }
  
  public void setTempState(int paramInt)
  {
    this.H = paramInt;
  }
  
  public void start()
  {
    if (j())
    {
      this.y = ((h.b)this.f.get()).getExtras().getStringExtra("orderId");
      this.z = ((h.b)this.f.get()).getExtras().getStringExtra("moveOrderType");
      if (!"move_xiaomian".equals(this.z)) {
        break label251;
      }
      ((h.b)this.f.get()).getTvTitle().setText("自如小搬");
      getData();
      Object localObject = ((h.b)this.f.get()).getActivity().getSharedPreferences("service_detail_cooy", 0);
      this.D = ((SharedPreferences)localObject).getBoolean("type_move_small_copy", true);
      if (!this.D) {
        break label325;
      }
      ((h.b)this.f.get()).getViewCopy().setVisibility(0);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("type_move_small_copy", false);
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (;;)
    {
      this.g = new f(((h.b)this.f.get()).getViewContext(), this.c);
      this.g.setOnItemClickListener(new f.a()
      {
        public void onClick(int paramAnonymousInt)
        {
          if (i.a(i.this))
          {
            Intent localIntent = new Intent(((h.b)i.b(i.this).get()).getViewContext(), MHPrivilegeActivity.class);
            if ("move_xiaomian".equals(i.c(i.this))) {
              localIntent.putExtra("serviceInfoId", "8a908eb161d66afc0161fa59fd210009");
            }
            if ("move_small".equals(i.c(i.this))) {
              localIntent.putExtra("serviceInfoId", "2c9085f248ba3f3a0148bb156f6e0004");
            }
            if ("move_van".equals(i.c(i.this))) {
              localIntent.putExtra("serviceInfoId", "8a90a5f8593e65b501593e65b5200000");
            }
            localIntent.putExtra("code_from", "move_detail");
            localIntent.putExtra("startTime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(i.d(i.this).getAppointmentTime())));
            ((h.b)i.b(i.this).get()).getViewContext().startActivity(localIntent);
          }
        }
      });
      ((h.b)this.f.get()).getRvChargeDetail().setAdapter(this.g);
      return;
      label251:
      if ("move_small".equals(this.z))
      {
        ((h.b)this.f.get()).getTvTitle().setText("自如中搬");
        break;
      }
      if (!"move_van".equals(this.z)) {
        break;
      }
      ((h.b)this.f.get()).getTvTitle().setText("自如大搬");
      break;
      label325:
      ((h.b)this.f.get()).getViewCopy().setVisibility(8);
    }
  }
  
  public void stopPollTask(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public void useCouponBean(boolean paramBoolean, ak paramak)
  {
    this.E = paramBoolean;
    this.G = paramak;
    getData();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */