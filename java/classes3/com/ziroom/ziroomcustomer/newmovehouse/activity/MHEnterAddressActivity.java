package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.poi.PoiSortType;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionResult.SuggestionInfo;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.d.a.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.newclean.b.z;
import com.ziroom.ziroomcustomer.newmovehouse.model.LatPoint;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHFloorsFee;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MHEnterAddressActivity
  extends BaseActivity
  implements View.OnClickListener, OnGetSuggestionResultListener
{
  private SuggestionSearch A = null;
  private String B = com.ziroom.ziroomcustomer.base.b.c;
  private int C = 0;
  private LatLng D;
  private LatLng E;
  private boolean F = false;
  private TextView G;
  private boolean H = false;
  private List<MHFloorsFee> I;
  private double J;
  private int K;
  private int L;
  private View M;
  private View N;
  private EditText O;
  private ListView P;
  private View Q;
  private boolean R = false;
  private Context S;
  private String T;
  private boolean U;
  private TextView V;
  private TextView W;
  private ImageView X;
  private TextView Y;
  private TextView Z;
  OnGetPoiSearchResultListener a = new OnGetPoiSearchResultListener()
  {
    public void onGetPoiDetailResult(PoiDetailResult paramAnonymousPoiDetailResult) {}
    
    public void onGetPoiIndoorResult(PoiIndoorResult paramAnonymousPoiIndoorResult) {}
    
    public void onGetPoiResult(final PoiResult paramAnonymousPoiResult)
    {
      if ((paramAnonymousPoiResult == null) || (paramAnonymousPoiResult.error == SearchResult.ERRORNO.RESULT_NOT_FOUND)) {
        g.textToast(MHEnterAddressActivity.d(MHEnterAddressActivity.this), "未找到结果");
      }
      while (paramAnonymousPoiResult.error != SearchResult.ERRORNO.NO_ERROR) {
        return;
      }
      z localz = new z(MHEnterAddressActivity.d(MHEnterAddressActivity.this), paramAnonymousPoiResult.getAllPoi());
      MHEnterAddressActivity.s(MHEnterAddressActivity.this).setAdapter(localz);
      MHEnterAddressActivity.t(MHEnterAddressActivity.this).setVisibility(0);
      MHEnterAddressActivity.s(MHEnterAddressActivity.this).setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
        {
          VdsAgent.onItemClick(this, paramAnonymous2AdapterView, paramAnonymous2View, paramAnonymous2Int, paramAnonymous2Long);
          double d1 = ((PoiInfo)paramAnonymousPoiResult.getAllPoi().get(paramAnonymous2Int)).location.latitude;
          double d2 = ((PoiInfo)paramAnonymousPoiResult.getAllPoi().get(paramAnonymous2Int)).location.longitude;
          paramAnonymous2AdapterView = ((PoiInfo)paramAnonymousPoiResult.getAllPoi().get(paramAnonymous2Int)).name;
          MHEnterAddressActivity.a(MHEnterAddressActivity.this, d1, d2, paramAnonymous2AdapterView, false);
        }
      });
    }
  };
  private RelativeLayout aa;
  private TextView ab;
  private BDLocation ac;
  private PoiSearch ad;
  private LinearLayout ae;
  private TextView af;
  private ListView ag;
  private String ah;
  private LocationClient ai;
  private b aj;
  private boolean ak = false;
  private boolean al = false;
  private a am = new a(this);
  private MapView b = null;
  private BaiduMap c = null;
  private TextView d;
  private View e;
  private View f;
  private LabeledEditText g;
  private LabeledEditText r;
  private LabeledEditText s;
  private String t;
  private String u;
  private int v;
  private boolean w = true;
  private boolean x = true;
  private com.ziroom.ziroomcustomer.newmovehouse.b.a y;
  private List<LatPoint> z;
  
  private void a()
  {
    Intent localIntent = getIntent();
    this.g.setText(localIntent.getExtras().getString("address_location", ""));
    this.r.setText(localIntent.getExtras().getString("address_detail", ""));
    this.r.setSelection(this.r.getText().length());
    this.K = localIntent.getExtras().getInt("elevator");
    this.J = localIntent.getExtras().getDouble("floorsFee");
    this.L = localIntent.getExtras().getInt("floors");
    if ((!TextUtils.isEmpty(this.g.getText())) && (!TextUtils.isEmpty(this.r.getText())))
    {
      this.F = true;
      this.w = false;
      this.x = false;
      this.H = true;
      this.R = true;
      if (this.C != 1) {
        break label169;
      }
      a(this.D);
    }
    for (;;)
    {
      g();
      return;
      label169:
      if (this.C == 2) {
        a(this.E);
      }
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, String paramString, boolean paramBoolean)
  {
    a(new LatLng(paramDouble1, paramDouble2));
    this.g.setText(paramString);
    this.O.setText(paramString);
    this.O.clearFocus();
    ((InputMethodManager)this.S.getSystemService("input_method")).hideSoftInputFromWindow(this.O.getWindowToken(), 0);
    this.w = false;
    this.x = false;
    this.y = new com.ziroom.ziroomcustomer.newmovehouse.b.a(new ArrayList(), this);
    this.P.setAdapter(this.y);
    this.y.notifyDataSetChanged();
    a(false);
    g();
    if (!paramBoolean) {
      j();
    }
  }
  
  private void a(View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
  }
  
  private void a(BDLocation paramBDLocation)
  {
    PoiNearbySearchOption localPoiNearbySearchOption = new PoiNearbySearchOption();
    localPoiNearbySearchOption.keyword("小区");
    localPoiNearbySearchOption.sortType(PoiSortType.comprehensive);
    localPoiNearbySearchOption.location(new LatLng(paramBDLocation.getLatitude(), paramBDLocation.getLongitude()));
    localPoiNearbySearchOption.radius(1000);
    localPoiNearbySearchOption.pageCapacity(5);
    this.ad.searchNearby(localPoiNearbySearchOption);
  }
  
  private void a(LatLng paramLatLng)
  {
    if (this.C == 1)
    {
      this.D = paramLatLng;
      this.t = (paramLatLng.latitude + "-" + paramLatLng.longitude);
    }
    for (;;)
    {
      this.c.clear();
      Object localObject = BitmapDescriptorFactory.fromResource(2130839107);
      localObject = new MarkerOptions().position(paramLatLng).icon((BitmapDescriptor)localObject);
      this.c.addOverlay((OverlayOptions)localObject);
      paramLatLng = MapStatusUpdateFactory.newLatLngZoom(paramLatLng, 15.0F);
      this.c.setMapStatus(paramLatLng);
      this.F = true;
      return;
      if (this.C == 2)
      {
        this.E = paramLatLng;
        this.u = (paramLatLng.latitude + "-" + paramLatLng.longitude);
      }
    }
  }
  
  private void a(final boolean paramBoolean)
  {
    this.al = paramBoolean;
    Object localObject2 = null;
    Object localObject1;
    if ((this.N.getVisibility() != 0) && (paramBoolean))
    {
      localObject1 = new c();
      ((c)localObject1).playTogether(new com.d.a.a[] { com.d.a.j.ofFloat(this.N, "translationY", new float[] { this.N.getHeight(), 0.0F }) });
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((c)localObject1).addListener(new com.d.a.b()
        {
          public void onAnimationEnd(com.d.a.a paramAnonymousa)
          {
            super.onAnimationEnd(paramAnonymousa);
            if (!paramBoolean) {
              MHEnterAddressActivity.B(MHEnterAddressActivity.this).setVisibility(8);
            }
          }
          
          public void onAnimationStart(com.d.a.a paramAnonymousa)
          {
            super.onAnimationStart(paramAnonymousa);
            if (paramBoolean)
            {
              MHEnterAddressActivity.B(MHEnterAddressActivity.this).setVisibility(0);
              MHEnterAddressActivity.n(MHEnterAddressActivity.this).requestFocus();
              ((InputMethodManager)MHEnterAddressActivity.d(MHEnterAddressActivity.this).getSystemService("input_method")).toggleSoftInput(0, 2);
            }
          }
        });
        ((c)localObject1).start();
      }
      return;
      localObject1 = localObject2;
      if (this.N.getVisibility() == 0)
      {
        localObject1 = localObject2;
        if (!paramBoolean)
        {
          localObject1 = new c();
          ((c)localObject1).playTogether(new com.d.a.a[] { com.d.a.j.ofFloat(this.N, "translationY", new float[] { 0.0F, this.N.getHeight() }) });
        }
      }
    }
  }
  
  private void b()
  {
    int i = 1;
    Object localObject = getIntent();
    String str = ((Intent)localObject).getExtras().getString("type");
    this.U = ((Intent)localObject).getExtras().getBoolean("is_moving_van", false);
    if ("start".equals(str))
    {
      this.C = 1;
      this.t = ((Intent)localObject).getExtras().getString("latlng_str");
      this.D = new LatLng(((Intent)localObject).getExtras().getDouble("latlng_map_lat"), ((Intent)localObject).getExtras().getDouble("latlng_map_lng"));
      this.G.setText("搬出地址");
    }
    for (;;)
    {
      this.T = ((Intent)localObject).getExtras().getString("serviceInfoId", "");
      if (!this.U) {
        break label417;
      }
      this.I = new ArrayList();
      localObject = new MHFloorsFee();
      ((MHFloorsFee)localObject).setElevator(1);
      ((MHFloorsFee)localObject).setFloors(0);
      ((MHFloorsFee)localObject).setFloorsFeeDescribe("有电梯—无楼层费");
      this.I.add(localObject);
      while (i < 9)
      {
        localObject = new MHFloorsFee();
        ((MHFloorsFee)localObject).setElevator(0);
        ((MHFloorsFee)localObject).setFloors(i);
        ((MHFloorsFee)localObject).setFloorsFeeDescribe("无电梯住" + i + "层");
        this.I.add(localObject);
        i += 1;
      }
      if ("end".equals(str))
      {
        this.C = 2;
        this.u = ((Intent)localObject).getExtras().getString("latlng_str");
        this.E = new LatLng(((Intent)localObject).getExtras().getDouble("latlng_map_lat"), ((Intent)localObject).getExtras().getDouble("latlng_map_lng"));
        this.G.setText("搬入地址");
      }
    }
    if (this.R) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.I.size())
      {
        if ((((MHFloorsFee)this.I.get(i)).getElevator() == this.K) && (((MHFloorsFee)this.I.get(i)).getFloors() == this.L)) {
          this.s.setText(((MHFloorsFee)this.I.get(i)).getFloorsFeeDescribe());
        }
      }
      else {
        return;
      }
      i += 1;
    }
    label417:
    o.getMHFloorsFeeList(this.am, this.S, this.T);
  }
  
  private void b(boolean paramBoolean)
  {
    if (VdsAgent.trackEditTextSilent(this.O).length() <= 0)
    {
      this.ab.setVisibility(8);
      this.aa.setVisibility(8);
      if (this.ak)
      {
        this.ae.setVisibility(0);
        this.P.setVisibility(8);
        this.Z.setVisibility(8);
        return;
      }
      this.ae.setVisibility(8);
      this.P.setVisibility(0);
      this.Z.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      if (!com.ziroom.ziroomcustomer.newServiceList.utils.j.isOPenGps(this.S)) {
        this.ae.setVisibility(8);
      }
      for (;;)
      {
        this.ab.setVisibility(8);
        this.aa.setVisibility(8);
        this.P.setVisibility(8);
        this.Z.setVisibility(8);
        return;
        this.ae.setVisibility(0);
      }
    }
    this.ae.setVisibility(8);
    this.ab.setVisibility(8);
    this.aa.setVisibility(8);
    this.P.setVisibility(0);
    this.Z.setVisibility(0);
  }
  
  private void e()
  {
    this.ae = ((LinearLayout)findViewById(2131690543));
    this.af = ((TextView)findViewById(2131690544));
    this.ag = ((ListView)findViewById(2131690545));
    this.ab = ((TextView)findViewById(2131690537));
    this.b = ((MapView)findViewById(2131690529));
    this.b.showScaleControl(false);
    this.b.showZoomControls(false);
    this.b.removeViewAt(1);
    this.c = this.b.getMap();
    this.b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        int i = MHEnterAddressActivity.a(MHEnterAddressActivity.this).getWidth();
        ViewGroup.LayoutParams localLayoutParams = MHEnterAddressActivity.a(MHEnterAddressActivity.this).getLayoutParams();
        localLayoutParams.height = (i / 2);
        MHEnterAddressActivity.a(MHEnterAddressActivity.this).setLayoutParams(localLayoutParams);
      }
    });
    this.e = findViewById(2131689492);
    this.e.setOnClickListener(this);
    this.Z = ((TextView)findViewById(2131690546));
    this.d = ((TextView)findViewById(2131689843));
    this.d.setOnClickListener(this);
    this.g = ((LabeledEditText)findViewById(2131690530));
    this.aa = ((RelativeLayout)findViewById(2131690538));
    this.g.setOnClickListener(this);
    this.z = new ArrayList();
    this.y = new com.ziroom.ziroomcustomer.newmovehouse.b.a(this.z, this.S);
    this.r = ((LabeledEditText)findViewById(2131690532));
    this.r.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() > 0) {
          MHEnterAddressActivity.b(MHEnterAddressActivity.this).setVisibility(0);
        }
        for (;;)
        {
          MHEnterAddressActivity.c(MHEnterAddressActivity.this);
          return;
          MHEnterAddressActivity.b(MHEnterAddressActivity.this).setVisibility(8);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 64)
        {
          g.textToast(MHEnterAddressActivity.d(MHEnterAddressActivity.this), "字数超出限制！");
          MHEnterAddressActivity.e(MHEnterAddressActivity.this).setText(paramAnonymousCharSequence.subSequence(0, 64).toString());
        }
      }
    });
    this.f = findViewById(2131690531);
    this.f.setOnClickListener(this);
    this.A = SuggestionSearch.newInstance();
    this.A.setOnGetSuggestionResultListener(this);
    this.s = ((LabeledEditText)findViewById(2131690533));
    this.s.setOnClickListener(this);
    this.G = ((TextView)findViewById(2131689541));
    this.N = findViewById(2131690534);
    this.O = ((EditText)findViewById(2131690535));
    this.O.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() <= 0)
        {
          MHEnterAddressActivity.a(MHEnterAddressActivity.this, "");
          MHEnterAddressActivity.a(MHEnterAddressActivity.this, true);
        }
        do
        {
          return;
          if (paramAnonymousCharSequence.length() > 0) {
            MHEnterAddressActivity.a(MHEnterAddressActivity.this, false);
          }
          if ((!MHEnterAddressActivity.f(MHEnterAddressActivity.this)) && (MHEnterAddressActivity.g(MHEnterAddressActivity.this) > paramAnonymousCharSequence.length()))
          {
            MHEnterAddressActivity.h(MHEnterAddressActivity.this);
            MHEnterAddressActivity.i(MHEnterAddressActivity.this).clear();
          }
          if (MHEnterAddressActivity.g(MHEnterAddressActivity.this) > paramAnonymousCharSequence.length()) {
            MHEnterAddressActivity.b(MHEnterAddressActivity.this, true);
          }
          if ((MHEnterAddressActivity.f(MHEnterAddressActivity.this)) && (MHEnterAddressActivity.g(MHEnterAddressActivity.this) < paramAnonymousCharSequence.length())) {
            MHEnterAddressActivity.c(MHEnterAddressActivity.this, true);
          }
          MHEnterAddressActivity.a(MHEnterAddressActivity.this, paramAnonymousCharSequence.length());
        } while ((!MHEnterAddressActivity.f(MHEnterAddressActivity.this)) || (!MHEnterAddressActivity.j(MHEnterAddressActivity.this)));
        MHEnterAddressActivity.k(MHEnterAddressActivity.this).requestSuggestion(new SuggestionSearchOption().keyword(paramAnonymousCharSequence.toString()).city(com.ziroom.ziroomcustomer.base.b.c));
      }
    });
    this.P = ((ListView)findViewById(2131690547));
    this.P.setAdapter(this.y);
    this.P.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (((LatPoint)MHEnterAddressActivity.l(MHEnterAddressActivity.this).get(paramAnonymousInt)).getLatlng() == null)
        {
          g.textToast(MHEnterAddressActivity.d(MHEnterAddressActivity.this), "该地址无效，请重新输入地址");
          return;
        }
        MHEnterAddressActivity.d(MHEnterAddressActivity.this, false);
        MHEnterAddressActivity.a(MHEnterAddressActivity.this, ((LatPoint)MHEnterAddressActivity.l(MHEnterAddressActivity.this).get(paramAnonymousInt)).getLatlng());
        MHEnterAddressActivity.m(MHEnterAddressActivity.this).setText(((LatPoint)MHEnterAddressActivity.l(MHEnterAddressActivity.this).get(paramAnonymousInt)).getAddress() + ((LatPoint)MHEnterAddressActivity.l(MHEnterAddressActivity.this).get(paramAnonymousInt)).getName());
        MHEnterAddressActivity.n(MHEnterAddressActivity.this).setText(((LatPoint)MHEnterAddressActivity.l(MHEnterAddressActivity.this).get(paramAnonymousInt)).getName());
        MHEnterAddressActivity.n(MHEnterAddressActivity.this).clearFocus();
        ((InputMethodManager)MHEnterAddressActivity.d(MHEnterAddressActivity.this).getSystemService("input_method")).hideSoftInputFromWindow(MHEnterAddressActivity.n(MHEnterAddressActivity.this).getWindowToken(), 0);
        MHEnterAddressActivity.b(MHEnterAddressActivity.this, false);
        MHEnterAddressActivity.c(MHEnterAddressActivity.this, false);
        MHEnterAddressActivity.a(MHEnterAddressActivity.this, new com.ziroom.ziroomcustomer.newmovehouse.b.a(new ArrayList(), MHEnterAddressActivity.this));
        MHEnterAddressActivity.p(MHEnterAddressActivity.this).setAdapter(MHEnterAddressActivity.o(MHEnterAddressActivity.this));
        MHEnterAddressActivity.o(MHEnterAddressActivity.this).notifyDataSetChanged();
        MHEnterAddressActivity.e(MHEnterAddressActivity.this, false);
        MHEnterAddressActivity.c(MHEnterAddressActivity.this);
        if (MHEnterAddressActivity.q(MHEnterAddressActivity.this) == 1) {
          w.onEvent(MHEnterAddressActivity.this, "movebook_beginaddress");
        }
        for (;;)
        {
          MHEnterAddressActivity.r(MHEnterAddressActivity.this);
          return;
          if (MHEnterAddressActivity.q(MHEnterAddressActivity.this) == 2) {
            w.onEvent(MHEnterAddressActivity.this, "movebook_endaddress");
          }
        }
      }
    });
    this.Q = findViewById(2131690536);
    this.Q.setOnClickListener(this);
    this.M = findViewById(2131690548);
    this.V = ((TextView)findViewById(2131690539));
    this.W = ((TextView)findViewById(2131690540));
    this.X = ((ImageView)findViewById(2131690542));
    this.Y = ((TextView)findViewById(2131690541));
    this.ad = PoiSearch.newInstance();
    this.ad.setOnGetPoiSearchResultListener(this.a);
    h();
    this.X.setOnClickListener(this);
    this.Y.setOnClickListener(this);
    this.aa.setOnClickListener(this);
    if (!checkNet(this.S)) {
      g.textToast(this.S, "网络出现异常，请稍后再试");
    }
  }
  
  private void f()
  {
    MapStatusUpdate localMapStatusUpdate = MapStatusUpdateFactory.newLatLngZoom(new LatLng(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getLat(), com.ziroom.ziroomcustomer.base.b.getCurrentCity().getLng()), 12.0F);
    this.c.setMapStatus(localMapStatusUpdate);
  }
  
  private void g()
  {
    if ((!TextUtils.isEmpty(this.g.getText())) && (!TextUtils.isEmpty(this.r.getText())) && (this.H))
    {
      this.d.setTextColor(Color.parseColor("#ffa000"));
      return;
    }
    this.d.setTextColor(Color.parseColor("#999999"));
  }
  
  private void h()
  {
    if (!com.ziroom.ziroomcustomer.newServiceList.utils.j.isOPenGps(this.S)) {
      return;
    }
    this.ai = new LocationClient(this);
    this.aj = new b();
    this.ai.registerLocationListener(this.aj);
    LocationClientOption localLocationClientOption = new LocationClientOption();
    localLocationClientOption.setOpenGps(true);
    localLocationClientOption.setCoorType("bd09ll");
    localLocationClientOption.setScanSpan(5000);
    localLocationClientOption.setIsNeedAddress(true);
    this.ai.setLocOption(localLocationClientOption);
    this.ai.start();
  }
  
  private void i()
  {
    this.ai.stop();
    if (this.aj != null) {
      this.ai.unRegisterLocationListener(this.aj);
    }
    this.ai = null;
  }
  
  private void j()
  {
    this.r.setEditTextFocusable(true);
    k();
  }
  
  private void k()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.toggleSoftInput(0, 2);
    }
  }
  
  public void onBackPressed()
  {
    if (this.N.getVisibility() == 0)
    {
      a(false);
      if (!TextUtils.isEmpty(this.g.getText()))
      {
        this.w = false;
        this.x = false;
      }
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
    default: 
    case 2131689492: 
    case 2131689843: 
    case 2131690531: 
    case 2131690533: 
    case 2131690536: 
    case 2131690530: 
      do
      {
        do
        {
          return;
          finish();
          return;
          if (this.F)
          {
            if ((!this.w) && (!this.x))
            {
              if (this.r.getText().length() == 0)
              {
                g.textToast(this.S, "请输入详细地址门牌号！");
                return;
              }
              if (!this.H)
              {
                g.textToast(this.S, "请选择楼层数！");
                return;
              }
              paramView = getIntent();
              if (this.C == 1)
              {
                paramView.putExtra("latlng_str", this.t);
                paramView.putExtra("latlng_map_lat", this.D.latitude);
                paramView.putExtra("latlng_map_lng", this.D.longitude);
              }
              for (;;)
              {
                paramView.putExtra("address_location", this.g.getText());
                paramView.putExtra("address_detail", this.r.getText());
                paramView.putExtra("elevator", this.K);
                paramView.putExtra("floorsFee", this.J);
                paramView.putExtra("floors", this.L);
                setResult(-1, paramView);
                finish();
                return;
                paramView.putExtra("latlng_str", this.u);
                paramView.putExtra("latlng_map_lat", this.E.latitude);
                paramView.putExtra("latlng_map_lng", this.E.longitude);
              }
            }
            g.textToast(this.S, "请使用提示的地址!");
            return;
          }
          g.textToast(this.S, "未能定位目标地址所在经纬度，请使用提示的地址!");
          return;
          this.r.setText("");
          return;
          paramView = new ArrayList();
          if ((this.I != null) && (this.I.size() > 0))
          {
            int i = 0;
            while (i < this.I.size())
            {
              paramView.add(((MHFloorsFee)this.I.get(i)).getFloorsFeeDescribe());
              i += 1;
            }
            new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(this.S, "请选择楼层", new a.b()
            {
              public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
              {
                paramAnonymousHashMap = (String)paramAnonymousHashMap.get(Integer.valueOf(0));
                MHEnterAddressActivity.u(MHEnterAddressActivity.this).setText(paramAnonymousHashMap);
                int i = 0;
                for (;;)
                {
                  if (i < MHEnterAddressActivity.v(MHEnterAddressActivity.this).size())
                  {
                    if (paramAnonymousHashMap.equals(((MHFloorsFee)MHEnterAddressActivity.v(MHEnterAddressActivity.this).get(i)).getFloorsFeeDescribe()))
                    {
                      MHEnterAddressActivity.a(MHEnterAddressActivity.this, ((MHFloorsFee)MHEnterAddressActivity.v(MHEnterAddressActivity.this).get(i)).getFloorsFee());
                      MHEnterAddressActivity.b(MHEnterAddressActivity.this, ((MHFloorsFee)MHEnterAddressActivity.v(MHEnterAddressActivity.this).get(i)).getFloors());
                      MHEnterAddressActivity.c(MHEnterAddressActivity.this, ((MHFloorsFee)MHEnterAddressActivity.v(MHEnterAddressActivity.this).get(i)).getElevator());
                      MHEnterAddressActivity.f(MHEnterAddressActivity.this, true);
                    }
                  }
                  else
                  {
                    if (!MHEnterAddressActivity.w(MHEnterAddressActivity.this)) {
                      MHEnterAddressActivity.u(MHEnterAddressActivity.this).setText("");
                    }
                    MHEnterAddressActivity.c(MHEnterAddressActivity.this);
                    return;
                  }
                  i += 1;
                }
              }
            }, new List[] { paramView }).show();
            return;
          }
          g.textToast(this.S, "服务器异常，请稍后重试");
          return;
          paramView = (InputMethodManager)getSystemService("input_method");
          if (paramView != null) {
            paramView.hideSoftInputFromWindow(this.g.getWindowToken(), 0);
          }
          a(false);
        } while (TextUtils.isEmpty(this.g.getText()));
        this.w = false;
        this.x = false;
        return;
        a(this.r);
        a(true);
        b(false);
        if (!TextUtils.isEmpty(this.g.getText()))
        {
          this.O.setText(this.g.getText());
          this.O.setSelection(VdsAgent.trackEditTextSilent(this.O).length());
        }
      } while (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.O)));
      this.A.requestSuggestion(new SuggestionSearchOption().keyword(VdsAgent.trackEditTextSilent(this.O).toString()).city(com.ziroom.ziroomcustomer.base.b.c));
      this.w = true;
      this.x = true;
      return;
    case 2131690541: 
    case 2131690542: 
      h();
      return;
    }
    if (this.ac == null)
    {
      g.textToast(this.S, "该地址无效，请重新输入地址");
      return;
    }
    this.F = false;
    a(this.ac.getLatitude(), this.ac.getLongitude(), this.ac.getAddress().address, false);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903167);
    this.S = this;
    e();
    a();
    b();
    f();
  }
  
  protected void onDestroy()
  {
    if (this.c != null) {
      this.c.clear();
    }
    if (this.b != null) {
      this.b.onDestroy();
    }
    if (this.A != null) {
      this.A.destroy();
    }
    if (this.ad != null) {
      this.ad.destroy();
    }
    super.onDestroy();
  }
  
  public void onGetSuggestionResult(SuggestionResult paramSuggestionResult)
  {
    if ((paramSuggestionResult == null) || (paramSuggestionResult.getAllSuggestions() == null))
    {
      this.M.setVisibility(0);
      this.P.setVisibility(8);
      return;
    }
    this.z.clear();
    paramSuggestionResult = paramSuggestionResult.getAllSuggestions().iterator();
    while (paramSuggestionResult.hasNext())
    {
      SuggestionResult.SuggestionInfo localSuggestionInfo = (SuggestionResult.SuggestionInfo)paramSuggestionResult.next();
      if ((localSuggestionInfo.key != null) && (com.ziroom.ziroomcustomer.base.b.c != null) && (localSuggestionInfo.city != null) && (localSuggestionInfo.city.startsWith(com.ziroom.ziroomcustomer.base.b.c)) && (!localSuggestionInfo.city.equals(localSuggestionInfo.key)) && (!localSuggestionInfo.district.equals(localSuggestionInfo.key)))
      {
        LatPoint localLatPoint = new LatPoint();
        localLatPoint.setName(localSuggestionInfo.key);
        localLatPoint.setAddress(this.B + "市" + localSuggestionInfo.district);
        localLatPoint.setLatlng(localSuggestionInfo.pt);
        this.z.add(localLatPoint);
      }
    }
    if (this.z.size() == 0)
    {
      this.M.setVisibility(0);
      this.P.setVisibility(8);
      this.Z.setVisibility(8);
    }
    for (;;)
    {
      this.y = new com.ziroom.ziroomcustomer.newmovehouse.b.a(this.z, this.S);
      if ((!this.w) || (!this.x)) {
        break;
      }
      this.P.setAdapter(this.y);
      this.y.notifyDataSetChanged();
      return;
      this.M.setVisibility(8);
      this.P.setVisibility(0);
      this.Z.setVisibility(0);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.b.onPause();
  }
  
  protected void onResume()
  {
    this.b.onResume();
    super.onResume();
    this.r.disposeFocus(this.G);
  }
  
  private static class a
    extends Handler
  {
    private WeakReference<Context> a;
    
    public a(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }
    
    public void handleMessage(Message paramMessage)
    {
      MHEnterAddressActivity localMHEnterAddressActivity = (MHEnterAddressActivity)this.a.get();
      l locall;
      if (localMHEnterAddressActivity != null)
      {
        locall = (l)paramMessage.obj;
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        return;
        if (!locall.getSuccess().booleanValue()) {
          break;
        }
        MHEnterAddressActivity.a(localMHEnterAddressActivity, (List)locall.getObject());
        if (MHEnterAddressActivity.x(localMHEnterAddressActivity))
        {
          int i = 0;
          while (i < MHEnterAddressActivity.v(localMHEnterAddressActivity).size())
          {
            if ((((MHFloorsFee)MHEnterAddressActivity.v(localMHEnterAddressActivity).get(i)).getElevator() == MHEnterAddressActivity.y(localMHEnterAddressActivity)) && (((MHFloorsFee)MHEnterAddressActivity.v(localMHEnterAddressActivity).get(i)).getFloors() == MHEnterAddressActivity.z(localMHEnterAddressActivity)) && (((MHFloorsFee)MHEnterAddressActivity.v(localMHEnterAddressActivity).get(i)).getFloorsFee() == MHEnterAddressActivity.A(localMHEnterAddressActivity)))
            {
              MHEnterAddressActivity.u(localMHEnterAddressActivity).setText(((MHFloorsFee)MHEnterAddressActivity.v(localMHEnterAddressActivity).get(i)).getFloorsFeeDescribe());
              return;
            }
            i += 1;
          }
        }
      }
      localMHEnterAddressActivity.showToast(locall.getMessage());
    }
  }
  
  public class b
    implements BDLocationListener
  {
    public b() {}
    
    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      VdsAgent.onReceiveLocation(this, paramBDLocation);
      if (paramBDLocation != null) {
        if (paramBDLocation.getCity().startsWith(com.ziroom.ziroomcustomer.base.b.c))
        {
          MHEnterAddressActivity.g(MHEnterAddressActivity.this, true);
          if (VdsAgent.trackEditTextSilent(MHEnterAddressActivity.n(MHEnterAddressActivity.this)).length() > 0)
          {
            MHEnterAddressActivity.a(MHEnterAddressActivity.this, false);
            MHEnterAddressActivity.a(MHEnterAddressActivity.this, paramBDLocation);
            String str = MHEnterAddressActivity.this.getIntent().getExtras().getString("type");
            if ((TextUtils.isEmpty(MHEnterAddressActivity.this.getIntent().getExtras().getString("address_location", ""))) && (TextUtils.isEmpty(MHEnterAddressActivity.m(MHEnterAddressActivity.this).getText())) && (!TextUtils.isEmpty(str)) && ("start".equals(str)) && (!MHEnterAddressActivity.C(MHEnterAddressActivity.this)) && (!MHEnterAddressActivity.this.getIntent().getBooleanExtra("isStartFloor", false)))
            {
              double d1 = paramBDLocation.getLatitude();
              double d2 = paramBDLocation.getLongitude();
              str = paramBDLocation.getAddress().address;
              MHEnterAddressActivity.a(MHEnterAddressActivity.this, d1, d2, str, true);
              MHEnterAddressActivity.m(MHEnterAddressActivity.this).setText(paramBDLocation.getAddress().address);
            }
            MHEnterAddressActivity.D(MHEnterAddressActivity.this).setText(paramBDLocation.getAddress().address);
            MHEnterAddressActivity.E(MHEnterAddressActivity.this).setText(paramBDLocation.getAddress().district);
            MHEnterAddressActivity.b(MHEnterAddressActivity.this, paramBDLocation.getAddress().district);
            MHEnterAddressActivity.b(MHEnterAddressActivity.this, paramBDLocation);
          }
        }
      }
      for (;;)
      {
        MHEnterAddressActivity.F(MHEnterAddressActivity.this);
        return;
        MHEnterAddressActivity.a(MHEnterAddressActivity.this, true);
        break;
        MHEnterAddressActivity.g(MHEnterAddressActivity.this, false);
        MHEnterAddressActivity.a(MHEnterAddressActivity.this, false);
        continue;
        MHEnterAddressActivity.a(MHEnterAddressActivity.this, false);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MHEnterAddressActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */