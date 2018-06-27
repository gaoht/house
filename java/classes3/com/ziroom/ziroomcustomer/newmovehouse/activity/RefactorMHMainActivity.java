package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption.DrivingPolicy;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.dialog.g.a;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceLoginActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.newclean.d.ba;
import com.ziroom.ziroomcustomer.newmovehouse.model.IsHaveGoingOrderModel;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHCapacity;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHCommitInfo;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHCostEstimateInfo;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHCostEstimates;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHCreateOrderResult;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHFloorsFee;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHTool;
import com.ziroom.ziroomcustomer.newmovehouse.model.SmallMoveAddressBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.SmallMoveGoodSNum;
import com.ziroom.ziroomcustomer.newmovehouse.mvp.OrderDetailActivity;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RefactorMHMainActivity
  extends BaseActivity
  implements View.OnClickListener, OnGetGeoCoderResultListener, OnGetRoutePlanResultListener
{
  private static String B;
  private ImageView A;
  private boolean C;
  private GeoCoder D = null;
  private int E = 0;
  private String F;
  private String G;
  private String H;
  private View I;
  private View J;
  private View K;
  private View L;
  private TextView M;
  private TextView N;
  private TextView O;
  private TextView P;
  private TextView Q;
  private TextView R;
  private RoutePlanSearch S;
  private boolean T = false;
  private boolean U = false;
  private boolean V = false;
  private boolean W = false;
  private boolean X = false;
  private boolean Y = false;
  private MHCommitInfo Z;
  private Context a;
  private long aA = 0L;
  private boolean aB = false;
  private boolean aC = false;
  private BroadcastReceiver aD = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      if ((i != 17) || (ApplicationEx.c.getUser() == null) || (TextUtils.isEmpty(RefactorMHMainActivity.a(RefactorMHMainActivity.this).getText()))) {}
      for (;;)
      {
        if (i == 7) {}
        return;
        paramAnonymousContext = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        RefactorMHMainActivity.this.getModeCoupon(paramAnonymousContext.format(Long.valueOf(RefactorMHMainActivity.b(RefactorMHMainActivity.this).getMoveDate())));
      }
    }
  };
  private MHCostEstimateInfo aa;
  private c ab;
  private MHCostEstimates ac;
  private List<MHTool> ad;
  private a ae;
  private TextView af;
  private TextView ag;
  private TextView ah;
  private RelativeLayout ai;
  private TextView aj;
  private ImageView ak;
  private ImageView al;
  private ImageView am;
  private LabeledEditText an;
  private LabeledEditText ao;
  private View ap;
  private View aq;
  private View ar;
  private ImageView as;
  private int at;
  private List<MHFloorsFee> au = new ArrayList();
  private List<String> av = new ArrayList();
  private String aw;
  private String ax;
  private SmallMoveAddressBean ay;
  private SmallMoveAddressBean az;
  private BaiduMap b;
  private MapView c;
  private View d;
  private TextView e;
  private TextView f;
  private LabeledEditText g;
  private LabeledEditText r;
  private LabeledEditText s;
  private LabeledEditText t;
  private LabeledEditText u;
  private LabeledEditText v;
  private LabeledEditText w;
  private View x;
  private View y;
  private Button z;
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1 == true) && (!paramBoolean2))
    {
      this.an.setVisibility(8);
      this.ap.setVisibility(8);
      this.ao.setVisibility(8);
      this.aq.setVisibility(8);
      this.ak.setVisibility(4);
      this.al.setVisibility(0);
      this.am.setVisibility(8);
    }
    for (;;)
    {
      this.an.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          RefactorMHMainActivity.a(RefactorMHMainActivity.this, 1);
        }
      });
      this.ao.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          RefactorMHMainActivity.a(RefactorMHMainActivity.this, 2);
        }
      });
      return;
      if ((!paramBoolean1) && (paramBoolean2 == true))
      {
        this.an.setVisibility(8);
        this.ap.setVisibility(8);
        this.ao.setVisibility(8);
        this.aq.setVisibility(8);
        this.ak.setVisibility(4);
        this.al.setVisibility(4);
        this.am.setVisibility(0);
      }
      else
      {
        this.an.setVisibility(8);
        this.ap.setVisibility(8);
        this.ao.setVisibility(8);
        this.aq.setVisibility(8);
        this.ak.setVisibility(0);
        this.al.setVisibility(0);
        this.am.setVisibility(8);
      }
    }
  }
  
  private void b()
  {
    this.aw = getIntent().getStringExtra("recommendCode");
    this.ax = getIntent().getStringExtra("channelCode");
    this.aB = false;
    this.aC = false;
    a(this.aB, this.aC);
    this.av.clear();
    this.ab = new c(this.a);
    this.Z = new MHCommitInfo();
    this.Z.setMoveInElevator(-1);
    this.Z.setMoveOutElevator(-1);
    this.Z.setMoveInFloors(-1);
    this.Z.setMoveOutFloors(-1);
    this.aa = new MHCostEstimateInfo();
    this.ae = new a(null);
    B = getIntent().getStringExtra("serviceInfoId");
    Object localObject1;
    if ("8a908eb161d66afc0161fa59fd210009".equals(B))
    {
      this.e.setText("自如小搬");
      this.Z.setServiceInfoId(B);
      this.aa.setServiceInfoId(B);
      this.Z.setCityCode(b.d);
      this.aa.setCityCode(b.d);
      this.C = ApplicationEx.c.isLoginState();
      this.D = GeoCoder.newInstance();
      this.D.setOnGetGeoCodeResultListener(this);
      if (this.C)
      {
        localObject1 = ApplicationEx.c.getUser();
        if ((localObject1 != null) && (((UserInfo)localObject1).getLogin_name_mobile() != null))
        {
          this.w.setText(((UserInfo)localObject1).getLogin_name_mobile());
          this.w.setSelection(this.w.getText().length());
          this.W = true;
          this.Z.setConnectPhone(((UserInfo)localObject1).getLogin_name_mobile());
          i();
        }
      }
      if (!"8a908eb161d66afc0161fa59fd210009".equals(B)) {
        break label397;
      }
      this.ay = ad.getSmallMoveStartAddressData(this.a, "service_small_move_start_address");
      this.az = ad.getSmallMoveStartAddressData(this.a, "service_small_move_end_address");
    }
    for (;;)
    {
      if ((this.ay != null) || (this.az != null)) {
        break label440;
      }
      return;
      if (!"2c9085f248ba3f3a0148bb156f6e0004".equals(B)) {
        break;
      }
      this.e.setText("自如中搬");
      break;
      label397:
      if ("2c9085f248ba3f3a0148bb156f6e0004".equals(B))
      {
        this.ay = ad.getMiddleMoveStartAddressData(this.a, "service_middle_move_start_address");
        this.az = ad.getMiddleMoveStartAddressData(this.a, "service_middle_move_end_address");
      }
    }
    label440:
    if (!TextUtils.isEmpty(this.ay.getAddress_location()))
    {
      localObject1 = this.ay.getStart_latlng();
      this.Z.setStartCoordinate((String)localObject1);
      this.aa.setOrderStartArea((String)localObject1);
    }
    try
    {
      localObject1 = new LatLng(Double.parseDouble(this.ay.getLatlng_map_lat()), Double.parseDouble(this.ay.getLatlng_map_lng()));
      this.ae.d = ((LatLng)localObject1);
      localObject1 = this.ay.getAddress_location();
      localObject2 = this.ay.getAddress_detail();
      this.Z.setStartArea((String)localObject1);
      this.Z.setStartAreaPoint((String)localObject2);
      this.r.setText((String)localObject1 + (String)localObject2);
      i = this.ay.getElevator();
      j = this.ay.getFloors();
    }
    catch (Exception localException4)
    {
      try
      {
        d1 = Double.parseDouble(this.ay.getFloorsFee());
        this.aa.setMoveOutFloorsFee(d1);
        this.Z.setMoveOutFloorsFee(d1);
        this.Z.setMoveOutFloors(j);
        this.Z.setMoveOutElevator(i);
        this.X = true;
        this.U = true;
        if (this.aB == true)
        {
          this.aB = false;
          a(this.aB, this.aC);
        }
        j();
        i();
        if (!TextUtils.isEmpty(this.az.getAddress_location()))
        {
          localObject1 = this.az.getStart_latlng();
          this.Z.setEndCoordinate((String)localObject1);
          this.aa.setOrderEndArea((String)localObject1);
        }
      }
      catch (Exception localException4)
      {
        try
        {
          localObject1 = new LatLng(Double.parseDouble(this.az.getLatlng_map_lat()), Double.parseDouble(this.az.getLatlng_map_lng()));
          this.ae.e = ((LatLng)localObject1);
          localObject1 = this.az.getAddress_location();
          localObject2 = this.az.getAddress_detail();
          this.Z.setEndArea((String)localObject1);
          this.Z.setEndAreaPoint((String)localObject2);
          this.s.setText((String)localObject1 + (String)localObject2);
          i = this.az.getElevator();
          j = this.az.getFloors();
        }
        catch (Exception localException4)
        {
          try
          {
            int j;
            double d1 = Double.parseDouble(this.az.getFloorsFee());
            this.aa.setMoveInFloorsFee(d1);
            this.Z.setMoveInFloorsFee(d1);
            this.Z.setMoveInFloors(j);
            this.Z.setMoveInElevator(i);
            this.Y = true;
            this.V = true;
            if (this.aC == true)
            {
              this.aC = false;
              a(this.aB, this.aC);
            }
            j();
            i();
            localObject1 = ApplicationEx.c.getContracts();
            u.d("sdjgsd", "===== " + com.alibaba.fastjson.a.toJSONString(localObject1));
            if (localObject1 != null)
            {
              i = 0;
              if (i >= ((List)localObject1).size()) {
                break label1417;
              }
              if ((TextUtils.isEmpty(((Contract)((List)localObject1).get(i)).getCity_code())) || (!b.d.equals(((Contract)((List)localObject1).get(i)).getCity_code()))) {
                break label1304;
              }
              if (i > -1)
              {
                localObject1 = (Contract)((List)localObject1).get(i);
                localObject2 = ((Contract)localObject1).getEffect_date();
                localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (!TextUtils.isEmpty(((Contract)localObject1).getAddress())) {
                  this.F = "";
                }
              }
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              try
              {
                SimpleDateFormat localSimpleDateFormat;
                Object localObject2 = localSimpleDateFormat.parse((String)localObject2);
                if (new Date().compareTo(new Date(((Date)localObject2).getTime() + 2592000000L)) <= 0)
                {
                  if (TextUtils.isEmpty(this.az.getAddress_location()))
                  {
                    this.E = 2;
                    this.D.geocode(new GeoCodeOption().city(b.c).address(((Contract)localObject1).getAddress()));
                    this.aC = true;
                    a(this.aB, this.aC);
                  }
                  this.S = RoutePlanSearch.newInstance();
                  this.S.setOnGetRoutePlanResultListener(this);
                  if (!TextUtils.isEmpty(this.w.getText().toString())) {
                    w.onEvent(this.a, "movebook_phone");
                  }
                  i();
                  e();
                  localObject1 = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
                  LocalBroadcastManager.getInstance(this.a).registerReceiver(this.aD, (IntentFilter)localObject1);
                  return;
                  localException1 = localException1;
                  localException1.printStackTrace();
                  continue;
                  localException2 = localException2;
                  localException2.printStackTrace();
                  continue;
                  localException3 = localException3;
                  localException3.printStackTrace();
                  continue;
                  localException4 = localException4;
                  localException4.printStackTrace();
                  continue;
                  label1304:
                  i += 1;
                  continue;
                }
                if (!TextUtils.isEmpty(this.ay.getAddress_location())) {
                  continue;
                }
                this.E = 1;
                this.D.geocode(new GeoCodeOption().city(b.c).address(localException4.getAddress()));
                this.aB = true;
                a(this.aB, this.aC);
                continue;
              }
              catch (ParseException localParseException)
              {
                this.E = 2;
                this.D.geocode(new GeoCodeOption().city(b.c).address(localException4.getAddress()));
                continue;
              }
              label1417:
              int i = -1;
            }
          }
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.at = paramInt;
    if ((this.av != null) && (this.av.size() > 0))
    {
      m();
      return;
    }
    n.getMHFloorsFeeList(this, B, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.l(MHFloorsFee.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, List<MHFloorsFee> paramAnonymousList)
      {
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          RefactorMHMainActivity.a(RefactorMHMainActivity.this, paramAnonymousList);
          paramAnonymousInt = 0;
          while (paramAnonymousInt < RefactorMHMainActivity.t(RefactorMHMainActivity.this).size())
          {
            RefactorMHMainActivity.u(RefactorMHMainActivity.this).add(((MHFloorsFee)RefactorMHMainActivity.t(RefactorMHMainActivity.this).get(paramAnonymousInt)).getFloorsFeeDescribe());
            paramAnonymousInt += 1;
          }
          RefactorMHMainActivity.v(RefactorMHMainActivity.this);
        }
      }
    });
  }
  
  private void e()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    String str = "";
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    n.getSmallMoveGoodsNum(this, B, str, new com.freelxl.baselibrary.d.c.a(new m(SmallMoveGoodSNum.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, SmallMoveGoodSNum paramAnonymousSmallMoveGoodSNum)
      {
        if (paramAnonymousSmallMoveGoodSNum != null)
        {
          if (paramAnonymousSmallMoveGoodSNum.getGoodsCount() > 0)
          {
            RefactorMHMainActivity.c(RefactorMHMainActivity.this).setVisibility(0);
            RefactorMHMainActivity.d(RefactorMHMainActivity.this).setVisibility(0);
          }
        }
        else {
          return;
        }
        RefactorMHMainActivity.c(RefactorMHMainActivity.this).setVisibility(8);
        RefactorMHMainActivity.d(RefactorMHMainActivity.this).setVisibility(8);
      }
    });
  }
  
  private void f()
  {
    this.d = findViewById(2131691493);
    this.e = ((TextView)findViewById(2131689541));
    this.g = ((LabeledEditText)findViewById(2131691722));
    this.r = ((LabeledEditText)findViewById(2131691727));
    this.s = ((LabeledEditText)findViewById(2131691730));
    this.t = ((LabeledEditText)findViewById(2131691734));
    this.u = ((LabeledEditText)findViewById(2131691735));
    this.v = ((LabeledEditText)findViewById(2131691737));
    this.w = ((LabeledEditText)findViewById(2131691733));
    this.x = findViewById(2131691741);
    this.f = ((TextView)findViewById(2131691740));
    this.y = findViewById(2131691739);
    this.z = ((Button)findViewById(2131691742));
    this.I = findViewById(2131691743);
    this.M = ((TextView)findViewById(2131691744));
    this.N = ((TextView)findViewById(2131691746));
    this.O = ((TextView)findViewById(2131691751));
    this.P = ((TextView)findViewById(2131691753));
    this.Q = ((TextView)findViewById(2131689994));
    this.R = ((TextView)findViewById(2131689996));
    this.J = findViewById(2131691750);
    this.K = findViewById(2131691752);
    this.L = findViewById(2131691754);
    this.af = ((TextView)findViewById(2131691749));
    this.aj = ((TextView)findViewById(2131691756));
    this.ak = ((ImageView)findViewById(2131691723));
    this.al = ((ImageView)findViewById(2131691725));
    this.am = ((ImageView)findViewById(2131691726));
    this.an = ((LabeledEditText)findViewById(2131691728));
    this.ap = findViewById(2131691729);
    this.ao = ((LabeledEditText)findViewById(2131691732));
    this.aq = findViewById(2131691731);
    this.ar = findViewById(2131691736);
    this.ag = ((TextView)findViewById(2131691745));
    this.ai = ((RelativeLayout)findViewById(2131691747));
    this.ah = ((TextView)findViewById(2131691748));
    this.A = ((ImageView)findViewById(2131690588));
    this.as = ((ImageView)findViewById(2131690023));
    this.c = ((MapView)findViewById(2131690823));
    this.b = this.c.getMap();
    this.c.showScaleControl(false);
    this.c.showZoomControls(false);
    this.c.removeViewAt(1);
    this.c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        int i = RefactorMHMainActivity.e(RefactorMHMainActivity.this).getWidth();
        ViewGroup.LayoutParams localLayoutParams = RefactorMHMainActivity.e(RefactorMHMainActivity.this).getLayoutParams();
        localLayoutParams.height = (i / 2);
        RefactorMHMainActivity.e(RefactorMHMainActivity.this).setLayoutParams(localLayoutParams);
      }
    });
  }
  
  private void g()
  {
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.I.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.as.setOnClickListener(this);
    this.w.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() > 11)
        {
          RefactorMHMainActivity.f(RefactorMHMainActivity.this).setText(paramAnonymousEditable.toString().substring(0, 11));
          RefactorMHMainActivity.f(RefactorMHMainActivity.this).setSelection(RefactorMHMainActivity.f(RefactorMHMainActivity.this).getText().length());
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() == 11)
        {
          RefactorMHMainActivity.a(RefactorMHMainActivity.this, true);
          RefactorMHMainActivity.b(RefactorMHMainActivity.this).setConnectPhone(paramAnonymousCharSequence.toString());
        }
        for (;;)
        {
          RefactorMHMainActivity.g(RefactorMHMainActivity.this);
          return;
          RefactorMHMainActivity.a(RefactorMHMainActivity.this, false);
        }
      }
    });
  }
  
  private void h()
  {
    if (checkNet(this.a))
    {
      Intent localIntent = new Intent(this.a, MHServiceTimeActivity.class);
      localIntent.putExtra("serviceTypeCode", B);
      localIntent.putExtra("moveTime", this.Z.getMoveDateTime());
      localIntent.putExtra("selectDate", this.aA);
      startActivityForResult(localIntent, 3846);
      return;
    }
    com.freelxl.baselibrary.f.g.textToast(this, "请求失败，请检查网络连接");
  }
  
  private void i()
  {
    if ((this.U) && (this.V) && (this.T) && (this.W))
    {
      this.z.setOnClickListener(this);
      this.z.setBackgroundColor(Color.parseColor("#ffa000"));
    }
    for (;;)
    {
      this.f.setText((int)this.ae.c + "");
      if ((!this.U) || (!this.V) || (!this.T)) {
        break;
      }
      this.y.setOnClickListener(this);
      this.x.setVisibility(0);
      return;
      this.z.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!RefactorMHMainActivity.l(RefactorMHMainActivity.this)) {
            com.freelxl.baselibrary.f.g.textToast(RefactorMHMainActivity.m(RefactorMHMainActivity.this), "请选择服务时间!");
          }
          do
          {
            return;
            if (!RefactorMHMainActivity.n(RefactorMHMainActivity.this))
            {
              com.freelxl.baselibrary.f.g.textToast(RefactorMHMainActivity.m(RefactorMHMainActivity.this), "请选择搬家起点地址!");
              return;
            }
            if (!RefactorMHMainActivity.o(RefactorMHMainActivity.this))
            {
              com.freelxl.baselibrary.f.g.textToast(RefactorMHMainActivity.m(RefactorMHMainActivity.this), "请选择搬家终点地址!");
              return;
            }
          } while (RefactorMHMainActivity.p(RefactorMHMainActivity.this));
          com.freelxl.baselibrary.f.g.textToast(RefactorMHMainActivity.m(RefactorMHMainActivity.this), "请输入联系电话!");
        }
      });
      this.z.setBackgroundColor(Color.parseColor("#d1d1d1"));
    }
    this.y.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (!RefactorMHMainActivity.l(RefactorMHMainActivity.this)) {
          com.freelxl.baselibrary.f.g.textToast(RefactorMHMainActivity.m(RefactorMHMainActivity.this), "请选择服务时间!");
        }
        do
        {
          return;
          if (!RefactorMHMainActivity.n(RefactorMHMainActivity.this))
          {
            com.freelxl.baselibrary.f.g.textToast(RefactorMHMainActivity.m(RefactorMHMainActivity.this), "请选择搬家起点地址!");
            return;
          }
        } while (RefactorMHMainActivity.o(RefactorMHMainActivity.this));
        com.freelxl.baselibrary.f.g.textToast(RefactorMHMainActivity.m(RefactorMHMainActivity.this), "请选择搬家终点地址!");
      }
    });
    this.x.setVisibility(8);
  }
  
  private void j()
  {
    if ((this.T) && (this.U) && (this.V))
    {
      this.b.clear();
      PlanNode localPlanNode1 = PlanNode.withLocation(this.ae.d);
      PlanNode localPlanNode2 = PlanNode.withLocation(this.ae.e);
      if ((this.S != null) && (!isFinishing())) {
        this.S.drivingSearch(new DrivingRoutePlanOption().policy(DrivingRoutePlanOption.DrivingPolicy.ECAR_DIS_FIRST).from(localPlanNode1).to(localPlanNode2));
      }
    }
  }
  
  private void k()
  {
    if (this.ac != null)
    {
      l();
      this.I.setVisibility(0);
      return;
    }
    af.showToast(this.a, "正在获取费用估计,请稍后");
  }
  
  private void l()
  {
    if (this.ac.getMoveFloorsFee() > 0)
    {
      this.J.setVisibility(0);
      this.O.setText(this.ac.getMoveFloorsFee() + " 元");
      if (this.ac.getGoodsPrice() <= 0) {
        break label442;
      }
      this.K.setVisibility(0);
      this.P.setText(this.ac.getGoodsPrice() + " 元");
      label102:
      if (this.ac.getPromoPrice() <= 0) {
        break label454;
      }
      this.L.setVisibility(0);
      this.Q.setText("-" + this.ac.getPromoPrice() + " 元");
      label159:
      this.M.setText((int)this.aa.getDistance() + " 公里");
      this.R.setText(this.ac.getTotalPrice() + " ");
      this.ag.setText("基础价格（含" + this.ac.getDefaultDistance() + "公里）");
      this.N.setText((int)this.ac.getDefaultPrice() + " 元");
      if (this.ac.getOverstepDistance() <= 0) {
        break label466;
      }
      this.ai.setVisibility(0);
      this.ah.setText("超出里程费（" + this.ac.getOverstepDistance() + "公里）");
      this.af.setText((int)this.ac.getOverstepPrice() + "元");
    }
    for (;;)
    {
      this.aj.setText("预估里程根据以下路线进行计算(共计" + this.ac.getDistance() + "公里)");
      return;
      this.J.setVisibility(8);
      break;
      label442:
      this.K.setVisibility(8);
      break label102;
      label454:
      this.L.setVisibility(8);
      break label159;
      label466:
      this.ai.setVisibility(8);
    }
  }
  
  private void m()
  {
    com.ziroom.ziroomcustomer.dialog.g localg = new com.ziroom.ziroomcustomer.dialog.g(this, new b(), this.av, null);
    localg.setCanceledOnTouchOutside(true);
    Window localWindow = localg.getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
    localg.show();
    localg.getTv_choose().setText("请选择楼层");
  }
  
  private void n()
  {
    this.C = ApplicationEx.c.isLoginState();
    if (this.C)
    {
      if (ApplicationEx.c.getUser() == null) {}
      for (String str = "";; str = ApplicationEx.c.getUser().getUid())
      {
        n.requestIsHaveGoingOrder(this, str, new com.ziroom.ziroomcustomer.e.a.d(this, new f(IsHaveGoingOrderModel.class))
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            super.onFailure(paramAnonymousThrowable);
            RefactorMHMainActivity.z(RefactorMHMainActivity.this);
          }
          
          public void onSuccess(int paramAnonymousInt, final IsHaveGoingOrderModel paramAnonymousIsHaveGoingOrderModel)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousIsHaveGoingOrderModel);
            if ((paramAnonymousIsHaveGoingOrderModel == null) || ("0".equals(paramAnonymousIsHaveGoingOrderModel.isHave)))
            {
              RefactorMHMainActivity.z(RefactorMHMainActivity.this);
              return;
            }
            com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(RefactorMHMainActivity.this).setContent(paramAnonymousIsHaveGoingOrderModel.content).setTitle("提示").setButtonText("查看订单", "继续下单").setOnConfirmClickListener(new d.b()
            {
              public void onLeftClick(View paramAnonymous2View)
              {
                paramAnonymous2View = new Intent(RefactorMHMainActivity.this, OrderDetailActivity.class);
                paramAnonymous2View.putExtra("orderId", paramAnonymousIsHaveGoingOrderModel.logicCode);
                if ("8a908eb161d66afc0161fa59fd210009".equals(paramAnonymousIsHaveGoingOrderModel.productCode)) {
                  paramAnonymous2View.putExtra("moveOrderType", "move_xiaomian");
                }
                for (;;)
                {
                  RefactorMHMainActivity.this.startActivity(paramAnonymous2View);
                  return;
                  if ("2c9085f248ba3f3a0148bb156f6e0004".equals(paramAnonymousIsHaveGoingOrderModel.productCode)) {
                    paramAnonymous2View.putExtra("moveOrderType", "move_small");
                  } else if ("8a90a5f8593e65b501593e65b5200000".equals(paramAnonymousIsHaveGoingOrderModel.productCode)) {
                    paramAnonymous2View.putExtra("moveOrderType", "move_van");
                  }
                }
              }
              
              public void onRightClick(View paramAnonymous2View)
              {
                RefactorMHMainActivity.z(RefactorMHMainActivity.this);
              }
            }).show();
          }
        });
        return;
      }
    }
    startActivity(new Intent(this.a, ServiceLoginActivity.class));
  }
  
  private void o()
  {
    this.C = ApplicationEx.c.isLoginState();
    if (this.C)
    {
      int i = this.Z.getConnectPhone().charAt(0);
      int j = this.Z.getConnectPhone().charAt(1);
      if ((i != 49) || (j == 48) || (j == 49) || (j == 50)) {
        com.freelxl.baselibrary.f.g.textToast(this, "手机号非法,请重新输入");
      }
      do
      {
        return;
        if ((this.aB == true) && (TextUtils.isEmpty(this.an.getText())))
        {
          com.freelxl.baselibrary.f.g.textToast(getApplicationContext(), "请先选择楼层");
          return;
        }
        if ((this.aC == true) && (TextUtils.isEmpty(this.ao.getText())))
        {
          com.freelxl.baselibrary.f.g.textToast(getApplicationContext(), "请先选择楼层");
          return;
        }
      } while (this.Z == null);
      this.Z.setUuid(ApplicationEx.c.getUser().getUid());
      showProgress("");
      if (TextUtils.isEmpty(this.ax)) {
        this.ax = "";
      }
      if (TextUtils.isEmpty(this.aw)) {
        this.aw = "";
      }
      String str = ah.getVersion(this.a);
      o.MHCreateOrder(this.a, this.ab, this.Z, this.ax, this.aw, str);
      w.onEvent(this.a, "movesubmit_submit");
      return;
    }
    startActivity(new Intent(this.a, ServiceLoginActivity.class));
  }
  
  public void getModeCoupon(String paramString)
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      n.getMateCoupon(this.a, 1, "", B, B, paramString, localUserInfo.getUid(), new com.freelxl.baselibrary.d.c.a(new m(ba.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
      {
        public void onFailure(Throwable paramAnonymousThrowable) {}
        
        public void onSuccess(int paramAnonymousInt, ba paramAnonymousba)
        {
          if (paramAnonymousba != null)
          {
            String str = paramAnonymousba.getPromoId();
            RefactorMHMainActivity.h(RefactorMHMainActivity.this).setPromoCodeId(str);
            RefactorMHMainActivity.b(RefactorMHMainActivity.this).setPromoCodeId(str);
            RefactorMHMainActivity.i(RefactorMHMainActivity.this).b = ((float)paramAnonymousba.getPromoPrice());
            RefactorMHMainActivity.j(RefactorMHMainActivity.this).setText("优惠" + (int)RefactorMHMainActivity.i(RefactorMHMainActivity.this).b + "元");
            RefactorMHMainActivity.k(RefactorMHMainActivity.this);
            RefactorMHMainActivity.g(RefactorMHMainActivity.this);
            return;
          }
          RefactorMHMainActivity.h(RefactorMHMainActivity.this).setPromoCodeId("");
          RefactorMHMainActivity.b(RefactorMHMainActivity.this).setPromoCodeId("");
          RefactorMHMainActivity.j(RefactorMHMainActivity.this).setText("");
          RefactorMHMainActivity.k(RefactorMHMainActivity.this);
          RefactorMHMainActivity.g(RefactorMHMainActivity.this);
        }
      });
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 1111) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (paramInt2 == -1) {}
      switch (paramInt1)
      {
      default: 
        return;
        this.aa.setPromoCodeId("");
        this.Z.setPromoCodeId("");
        this.ae.b = 0.0F;
        this.t.setText("");
        j();
        i();
      }
    }
    this.ae.a = paramIntent.getExtras().getFloat("totalPrice");
    this.ad = ((List)paramIntent.getExtras().getSerializable("shoppingCart"));
    paramIntent = new StringBuilder();
    if ((this.ad != null) && (this.ad.size() > 0))
    {
      localObject1 = new StringBuilder();
      paramInt1 = 0;
      while (paramInt1 < this.ad.size())
      {
        ((StringBuilder)localObject1).append(((MHTool)this.ad.get(paramInt1)).getGoodsId()).append(":").append(((MHTool)this.ad.get(paramInt1)).getNum());
        paramIntent.append(((MHTool)this.ad.get(paramInt1)).getName()).append("×").append(((MHTool)this.ad.get(paramInt1)).getNum());
        if (paramInt1 != this.ad.size() - 1)
        {
          ((StringBuilder)localObject1).append(",");
          paramIntent.append(" ");
        }
        paramInt1 += 1;
      }
      this.Z.setChooseGoods(((StringBuilder)localObject1).toString());
      this.aa.setChooseGoods(((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      this.u.setText(paramIntent.toString());
      j();
      i();
      return;
      this.Z.setChooseGoods("");
      this.aa.setChooseGoods("");
    }
    paramIntent = (al)paramIntent.getExtras().getSerializable("couponItem");
    Object localObject1 = paramIntent.getPromoId();
    this.aa.setPromoCodeId((String)localObject1);
    this.Z.setPromoCodeId((String)localObject1);
    this.ae.b = paramIntent.getPromoPrice();
    this.t.setText("优惠" + (int)this.ae.b + "元");
    j();
    i();
    return;
    localObject1 = paramIntent.getExtras().getString("NeedTagId", "");
    this.Z.setCharacterIds((String)localObject1);
    localObject1 = paramIntent.getExtras().getString("Remark", "");
    this.Z.setRemark((String)localObject1);
    this.H = paramIntent.getExtras().getString("TagStr", "");
    paramIntent = new StringBuilder();
    if (!TextUtils.isEmpty(this.H))
    {
      localObject2 = this.H.split(",");
      paramInt1 = 0;
      while (paramInt1 < localObject2.length)
      {
        paramIntent.append(localObject2[paramInt1]).append(" ");
        paramInt1 += 1;
      }
    }
    paramIntent.append((String)localObject1);
    this.v.setText(paramIntent.toString());
    return;
    localObject1 = paramIntent.getExtras().getString("latlng_str", "0.0 - 0.0");
    this.Z.setStartCoordinate((String)localObject1);
    this.aa.setOrderStartArea((String)localObject1);
    Object localObject2 = new LatLng(paramIntent.getExtras().getDouble("latlng_map_lat", 0.0D), paramIntent.getExtras().getDouble("latlng_map_lng", 0.0D));
    this.ae.d = ((LatLng)localObject2);
    localObject2 = paramIntent.getExtras().getString("address_location", "");
    String str = paramIntent.getExtras().getString("address_detail", "");
    this.Z.setStartArea((String)localObject2);
    this.Z.setStartAreaPoint(str);
    this.r.setText((String)localObject2 + str);
    if ("8a908eb161d66afc0161fa59fd210009".equals(B)) {
      ad.saveSmallMoveStartAddressData(this.a, (String)localObject1, paramIntent.getExtras().getDouble("latlng_map_lat", 0.0D), paramIntent.getExtras().getDouble("latlng_map_lng", 0.0D), (String)localObject2, str, paramIntent.getExtras().getInt("elevator", 0), paramIntent.getExtras().getInt("floors", 0), paramIntent.getExtras().getDouble("floorsFee", 0.0D));
    }
    double d1;
    for (;;)
    {
      paramInt1 = paramIntent.getExtras().getInt("elevator", 0);
      paramInt2 = paramIntent.getExtras().getInt("floors", 0);
      d1 = paramIntent.getExtras().getDouble("floorsFee", 0.0D);
      this.aa.setMoveOutFloorsFee(d1);
      this.Z.setMoveOutFloorsFee(d1);
      this.Z.setMoveOutFloors(paramInt2);
      this.Z.setMoveOutElevator(paramInt1);
      this.X = true;
      this.U = true;
      if (this.aB == true)
      {
        this.aB = false;
        a(this.aB, this.aC);
      }
      j();
      i();
      return;
      if ("2c9085f248ba3f3a0148bb156f6e0004".equals(B)) {
        ad.saveMiddleMoveStartAddressData(this.a, (String)localObject1, paramIntent.getExtras().getDouble("latlng_map_lat", 0.0D), paramIntent.getExtras().getDouble("latlng_map_lng", 0.0D), (String)localObject2, str, paramIntent.getExtras().getInt("elevator", 0), paramIntent.getExtras().getInt("floors", 0), paramIntent.getExtras().getDouble("floorsFee", 0.0D));
      }
    }
    localObject1 = paramIntent.getExtras().getString("latlng_str", "0.0 - 0.0");
    this.Z.setEndCoordinate((String)localObject1);
    this.aa.setOrderEndArea((String)localObject1);
    localObject2 = new LatLng(paramIntent.getExtras().getDouble("latlng_map_lat", 0.0D), paramIntent.getExtras().getDouble("latlng_map_lng", 0.0D));
    this.ae.e = ((LatLng)localObject2);
    localObject2 = paramIntent.getExtras().getString("address_location", "");
    str = paramIntent.getExtras().getString("address_detail", "");
    this.Z.setEndArea((String)localObject2);
    this.Z.setEndAreaPoint(str);
    this.s.setText((String)localObject2 + str);
    if ("8a908eb161d66afc0161fa59fd210009".equals(B)) {
      ad.saveSmallMoveEndAddressData(this.a, (String)localObject1, paramIntent.getExtras().getDouble("latlng_map_lat", 0.0D), paramIntent.getExtras().getDouble("latlng_map_lng", 0.0D), (String)localObject2, str, paramIntent.getExtras().getInt("elevator", 0), paramIntent.getExtras().getInt("floors", 0), paramIntent.getExtras().getDouble("floorsFee", 0.0D));
    }
    for (;;)
    {
      paramInt1 = paramIntent.getExtras().getInt("elevator", 0);
      paramInt2 = paramIntent.getExtras().getInt("floors", 0);
      d1 = paramIntent.getExtras().getDouble("floorsFee", 0.0D);
      this.aa.setMoveInFloorsFee(d1);
      this.Z.setMoveInFloorsFee(d1);
      this.Z.setMoveInFloors(paramInt2);
      this.Z.setMoveInElevator(paramInt1);
      this.Y = true;
      this.V = true;
      if (this.aC == true)
      {
        this.aC = false;
        a(this.aB, this.aC);
      }
      j();
      i();
      return;
      if ("2c9085f248ba3f3a0148bb156f6e0004".equals(B)) {
        ad.saveMidleMoveEndAddressData(this.a, (String)localObject1, paramIntent.getExtras().getDouble("latlng_map_lat", 0.0D), paramIntent.getExtras().getDouble("latlng_map_lng", 0.0D), (String)localObject2, str, paramIntent.getExtras().getInt("elevator", 0), paramIntent.getExtras().getInt("floors", 0), paramIntent.getExtras().getDouble("floorsFee", 0.0D));
      }
    }
    long l = paramIntent.getExtras().getLong("moveTime");
    this.aA = paramIntent.getExtras().getLong("selectDate");
    this.Z.setMoveDate(l);
    this.Z.setMoveDateTime(l);
    this.aa.setMoveDate(l);
    if ((l == 0L) || (this.aA == 0L))
    {
      this.T = false;
      this.g.setText("");
    }
    for (;;)
    {
      j();
      i();
      getModeCoupon(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(l)));
      return;
      this.T = true;
      paramIntent = new SimpleDateFormat("MM月dd日（E） HH:mm");
      this.g.setText(paramIntent.format(Long.valueOf(l)));
    }
  }
  
  public void onBackPressed()
  {
    if (this.I != null)
    {
      if (this.I.getVisibility() == 0)
      {
        this.I.setVisibility(8);
        return;
      }
      j.setFinishDialog(this);
      return;
    }
    super.onBackPressed();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
    switch (paramView.getId())
    {
    case 2131691743: 
    default: 
      return;
    case 2131691493: 
      j.setFinishDialog(this);
      return;
    case 2131691722: 
      h();
      w.onEvent(this.a, "movebook_time");
      return;
    case 2131691727: 
      paramView = new Intent(this.a, MHEnterAddressActivity.class);
      paramView.putExtra("type", "start");
      paramView.putExtra("serviceInfoId", B);
      paramView.putExtra("isStartFloor", this.aB);
      if ((!TextUtils.isEmpty(this.r.getText())) && (this.X))
      {
        paramView.putExtra("latlng_str", this.Z.getStartCoordinate());
        paramView.putExtra("latlng_map_lat", this.ae.d.latitude);
        paramView.putExtra("latlng_map_lng", this.ae.d.longitude);
        paramView.putExtra("address_location", this.Z.getStartArea());
        paramView.putExtra("address_detail", this.Z.getStartAreaPoint());
        paramView.putExtra("elevator", this.Z.getMoveOutElevator());
        paramView.putExtra("floorsFee", this.Z.getMoveOutFloorsFee());
        paramView.putExtra("floors", this.Z.getMoveOutFloors());
      }
      startActivityForResult(paramView, 3844);
      return;
    case 2131691730: 
      paramView = new Intent(this.a, MHEnterAddressActivity.class);
      paramView.putExtra("type", "end");
      paramView.putExtra("serviceInfoId", B);
      if ((!TextUtils.isEmpty(this.s.getText())) && (this.Y))
      {
        paramView.putExtra("latlng_str", this.Z.getEndCoordinate());
        paramView.putExtra("latlng_map_lat", this.ae.e.latitude);
        paramView.putExtra("latlng_map_lng", this.ae.e.longitude);
        paramView.putExtra("address_location", this.Z.getEndArea());
        paramView.putExtra("address_detail", this.Z.getEndAreaPoint());
        paramView.putExtra("elevator", this.Z.getMoveInElevator());
        paramView.putExtra("floorsFee", this.Z.getMoveInFloorsFee());
        paramView.putExtra("floors", this.Z.getMoveInFloors());
      }
      startActivityForResult(paramView, 3845);
      return;
    case 2131691734: 
      this.C = ApplicationEx.c.isLoginState();
      if (this.C)
      {
        if (TextUtils.isEmpty(this.g.getText()))
        {
          com.freelxl.baselibrary.f.g.textToast(this, "请先选择服务时间");
          return;
        }
        paramView = new Intent(this.a, MHPrivilegeActivity.class);
        paramView.putExtra("serviceInfoId", B);
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        paramView.putExtra("startTime", localSimpleDateFormat.format(Long.valueOf(this.Z.getMoveDate())));
        u.d(":jsdkjgkldjgklkg", "=======  " + localSimpleDateFormat.format(Long.valueOf(this.Z.getMoveDate())) + "   " + this.Z.getMoveDate());
        startActivityForResult(paramView, 3843);
      }
      for (;;)
      {
        w.onEvent(this.a, "movebook_coupon");
        return;
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      }
    case 2131691735: 
      paramView = new Intent(this.a, MHChangeToolActivity.class);
      paramView.putExtra("serviceInfoId", B);
      if (this.ad != null) {
        paramView.putExtra("shoppingCart", (Serializable)this.ad);
      }
      startActivityForResult(paramView, 3841);
      return;
    case 2131691737: 
      paramView = new Intent(this, SmallMoveSpecialActivity.class);
      paramView.putExtra("cityCode", b.d);
      paramView.putExtra("lastInput", this.Z.getRemark());
      paramView.putExtra("lastTag", this.H);
      paramView.putExtra("serviceInfoId", B);
      startActivityForResult(paramView, 3842);
      w.onEvent(this.a, "movebook_requirements");
      return;
    case 2131691739: 
      k();
      return;
    case 2131691742: 
      n();
      return;
    case 2131690588: 
      this.I.setVisibility(8);
      return;
    }
    startActivity(new Intent(this, ChatWebViewActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903347);
    getWindow().setSoftInputMode(32);
    this.a = this;
    f();
    g();
    b();
    w.onEventToZiroomAndUmeng("move_appointment_uv");
  }
  
  protected void onDestroy()
  {
    if (this.D != null) {
      this.D.destroy();
    }
    if (this.c != null) {
      this.c.onDestroy();
    }
    if (this.b != null) {
      this.b.clear();
    }
    if (this.S != null) {
      this.S.destroy();
    }
    super.onDestroy();
  }
  
  public void onGetBikingRouteResult(BikingRouteResult paramBikingRouteResult) {}
  
  public void onGetDrivingRouteResult(DrivingRouteResult paramDrivingRouteResult)
  {
    if ((paramDrivingRouteResult == null) || (paramDrivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR))
    {
      localObject = Toast.makeText(this.a, "抱歉，未找到结果", 0);
      if (!(localObject instanceof Toast)) {
        ((Toast)localObject).show();
      }
    }
    else
    {
      if (paramDrivingRouteResult.error != SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
        break label58;
      }
    }
    label58:
    while (paramDrivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR)
    {
      return;
      VdsAgent.showToast((Toast)localObject);
      break;
    }
    Object localObject = new d(this.b);
    this.b.setOnMarkerClickListener((BaiduMap.OnMarkerClickListener)localObject);
    paramDrivingRouteResult = (DrivingRouteLine)paramDrivingRouteResult.getRouteLines().get(0);
    ((com.ziroom.ziroomcustomer.util.b.a)localObject).setData(paramDrivingRouteResult);
    ((com.ziroom.ziroomcustomer.util.b.a)localObject).addToMap();
    ((com.ziroom.ziroomcustomer.util.b.a)localObject).zoomToSpan();
    int i = paramDrivingRouteResult.getDistance() / 1000;
    this.Z.setDistance(i);
    this.aa.setDistance(i);
    o.MHCostEstimates(this.a, this.ab, this.aa.getChooseGoods(), b.d, this.aa.getDistance(), this.aa.getMoveDate(), this.Z.getStartArea(), this.Z.getEndArea(), this.aa.getPromoCodeId(), this.aa.getServiceInfoId(), System.currentTimeMillis(), this.aa.getMoveOutFloorsFee(), this.aa.getMoveInFloorsFee(), this.ae.d.latitude, this.ae.d.longitude, this.ae.e.latitude, this.ae.e.longitude);
  }
  
  public void onGetGeoCodeResult(GeoCodeResult paramGeoCodeResult)
  {
    if (((!this.X) && (this.E == 1)) || ((this.Y) || (this.E != 2) || (paramGeoCodeResult == null) || (paramGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR))) {
      return;
    }
    if (this.E == 1)
    {
      this.r.setText(this.F);
      this.Z.setStartCoordinate(paramGeoCodeResult.getLocation().latitude + "-" + paramGeoCodeResult.getLocation().longitude);
      this.Z.setStartArea(this.F);
      this.aa.setOrderStartArea(paramGeoCodeResult.getLocation().latitude + "-" + paramGeoCodeResult.getLocation().longitude);
      this.ae.d = paramGeoCodeResult.getLocation();
      this.U = true;
    }
    for (;;)
    {
      i();
      return;
      if (this.E == 2)
      {
        this.s.setText(this.F);
        this.Z.setEndCoordinate(paramGeoCodeResult.getLocation().latitude + "-" + paramGeoCodeResult.getLocation().longitude);
        this.Z.setEndArea(this.F);
        this.aa.setOrderEndArea(paramGeoCodeResult.getLocation().latitude + "-" + paramGeoCodeResult.getLocation().longitude);
        this.ae.e = paramGeoCodeResult.getLocation();
        this.V = true;
      }
    }
  }
  
  public void onGetReverseGeoCodeResult(ReverseGeoCodeResult paramReverseGeoCodeResult) {}
  
  public void onGetTransitRouteResult(TransitRouteResult paramTransitRouteResult) {}
  
  public void onGetWalkingRouteResult(WalkingRouteResult paramWalkingRouteResult) {}
  
  protected void onPause()
  {
    super.onPause();
    this.c.onPause();
  }
  
  protected void onResume()
  {
    this.c.onResume();
    super.onResume();
    this.w.disposeFocus(this.e);
  }
  
  private class a
  {
    float a;
    float b;
    float c;
    LatLng d;
    LatLng e;
    
    private a() {}
  }
  
  class b
    implements g.a
  {
    b() {}
    
    public void showHour(String paramString, int paramInt)
    {
      if (RefactorMHMainActivity.w(RefactorMHMainActivity.this) == 1)
      {
        RefactorMHMainActivity.x(RefactorMHMainActivity.this).setText((String)RefactorMHMainActivity.u(RefactorMHMainActivity.this).get(paramInt));
        RefactorMHMainActivity.b(RefactorMHMainActivity.this).setMoveOutElevator(((MHFloorsFee)RefactorMHMainActivity.t(RefactorMHMainActivity.this).get(paramInt)).getElevator());
        RefactorMHMainActivity.b(RefactorMHMainActivity.this).setMoveOutFloors(((MHFloorsFee)RefactorMHMainActivity.t(RefactorMHMainActivity.this).get(paramInt)).getFloors());
        RefactorMHMainActivity.b(RefactorMHMainActivity.this).setMoveOutFloorsFee(((MHFloorsFee)RefactorMHMainActivity.t(RefactorMHMainActivity.this).get(paramInt)).getFloorsFee());
        RefactorMHMainActivity.h(RefactorMHMainActivity.this).setMoveOutFloorsFee(((MHFloorsFee)RefactorMHMainActivity.t(RefactorMHMainActivity.this).get(paramInt)).getFloorsFee());
      }
      for (;;)
      {
        RefactorMHMainActivity.k(RefactorMHMainActivity.this);
        return;
        if (RefactorMHMainActivity.w(RefactorMHMainActivity.this) == 2)
        {
          RefactorMHMainActivity.b(RefactorMHMainActivity.this).setMoveInElevator(((MHFloorsFee)RefactorMHMainActivity.t(RefactorMHMainActivity.this).get(paramInt)).getElevator());
          RefactorMHMainActivity.b(RefactorMHMainActivity.this).setMoveInFloors(((MHFloorsFee)RefactorMHMainActivity.t(RefactorMHMainActivity.this).get(paramInt)).getFloors());
          RefactorMHMainActivity.b(RefactorMHMainActivity.this).setMoveInFloorsFee(((MHFloorsFee)RefactorMHMainActivity.t(RefactorMHMainActivity.this).get(paramInt)).getFloorsFee());
          RefactorMHMainActivity.h(RefactorMHMainActivity.this).setMoveInFloorsFee(((MHFloorsFee)RefactorMHMainActivity.t(RefactorMHMainActivity.this).get(paramInt)).getFloorsFee());
          RefactorMHMainActivity.y(RefactorMHMainActivity.this).setText((String)RefactorMHMainActivity.u(RefactorMHMainActivity.this).get(paramInt));
        }
      }
    }
  }
  
  private static class c
    extends Handler
  {
    private WeakReference<Context> a;
    
    public c(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }
    
    public void handleMessage(Message paramMessage)
    {
      RefactorMHMainActivity localRefactorMHMainActivity = (RefactorMHMainActivity)this.a.get();
      Object localObject;
      if (localRefactorMHMainActivity != null)
      {
        localObject = (com.ziroom.ziroomcustomer.e.l)paramMessage.obj;
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        localRefactorMHMainActivity.dismissProgress();
        return;
        if (((com.ziroom.ziroomcustomer.e.l)localObject).getSuccess().booleanValue())
        {
          RefactorMHMainActivity.a(localRefactorMHMainActivity, (MHCostEstimates)((com.ziroom.ziroomcustomer.e.l)localObject).getObject());
          RefactorMHMainActivity.i(localRefactorMHMainActivity).c = RefactorMHMainActivity.q(localRefactorMHMainActivity).getTotalPrice();
          RefactorMHMainActivity.r(localRefactorMHMainActivity);
          RefactorMHMainActivity.g(localRefactorMHMainActivity);
        }
        else
        {
          localRefactorMHMainActivity.showToast(((com.ziroom.ziroomcustomer.e.l)localObject).getMessage());
          continue;
          localRefactorMHMainActivity.dismissProgress();
          if (((com.ziroom.ziroomcustomer.e.l)localObject).getSuccess().booleanValue())
          {
            paramMessage = (MHCreateOrderResult)((com.ziroom.ziroomcustomer.e.l)localObject).getObject();
            if (paramMessage != null)
            {
              localObject = new Intent(localRefactorMHMainActivity, MovingVanSuccessActivity.class);
              if (!"8a908eb161d66afc0161fa59fd210009".equals(RefactorMHMainActivity.a())) {
                break label208;
              }
              ((Intent)localObject).putExtra("move_from", "move_xiaomian");
            }
            for (;;)
            {
              ((Intent)localObject).putExtra("orderId", paramMessage.getWorkOrderId());
              localRefactorMHMainActivity.startActivity((Intent)localObject);
              localRefactorMHMainActivity.finish();
              break;
              label208:
              if ("2c9085f248ba3f3a0148bb156f6e0004".equals(RefactorMHMainActivity.a())) {
                ((Intent)localObject).putExtra("move_from", "small_move");
              }
            }
          }
          com.freelxl.baselibrary.f.g.textToast(localRefactorMHMainActivity, ((com.ziroom.ziroomcustomer.e.l)localObject).getMessage());
          continue;
          if (((com.ziroom.ziroomcustomer.e.l)localObject).getSuccess().booleanValue())
          {
            paramMessage = (MHCapacity)((com.ziroom.ziroomcustomer.e.l)localObject).getObject();
            if (paramMessage != null) {
              if (paramMessage.getSpareCapacityNum() > 0)
              {
                RefactorMHMainActivity.a(localRefactorMHMainActivity).setText(RefactorMHMainActivity.s(localRefactorMHMainActivity));
                RefactorMHMainActivity.b(localRefactorMHMainActivity, true);
                RefactorMHMainActivity.k(localRefactorMHMainActivity);
                RefactorMHMainActivity.g(localRefactorMHMainActivity);
              }
              else
              {
                RefactorMHMainActivity.a(localRefactorMHMainActivity).setText("");
                RefactorMHMainActivity.b(localRefactorMHMainActivity, false);
                RefactorMHMainActivity.g(localRefactorMHMainActivity);
                if (paramMessage.getRemark() != null) {
                  localRefactorMHMainActivity.showToast(paramMessage.getRemark());
                } else {
                  localRefactorMHMainActivity.showToast("该时间段已约满，请选择其他时段！");
                }
              }
            }
          }
          else
          {
            localRefactorMHMainActivity.showToast(((com.ziroom.ziroomcustomer.e.l)localObject).getMessage());
          }
        }
      }
    }
  }
  
  private class d
    extends com.ziroom.ziroomcustomer.util.b.a
  {
    public d(BaiduMap paramBaiduMap)
    {
      super();
    }
    
    public BitmapDescriptor getStartMarker()
    {
      return BitmapDescriptorFactory.fromResource(2130838844);
    }
    
    public BitmapDescriptor getTerminalMarker()
    {
      return BitmapDescriptorFactory.fromResource(2130838784);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/RefactorMHMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */