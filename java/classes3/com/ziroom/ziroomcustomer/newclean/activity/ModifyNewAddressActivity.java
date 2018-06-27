package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
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
import android.view.Window;
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
import com.baidu.mapapi.search.geocode.GeoCoder;
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
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.b.z;
import com.ziroom.ziroomcustomer.newclean.d.bg;
import com.ziroom.ziroomcustomer.newmovehouse.model.LatPoint;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModifyNewAddressActivity
  extends BaseActivity
  implements View.OnClickListener, OnGetSuggestionResultListener
{
  private UserInfo A;
  private TextView B;
  private com.ziroom.ziroomcustomer.newclean.d.c C;
  private ImageView D;
  private MapView E = null;
  private BaiduMap F = null;
  private int G = 0;
  private View H;
  private EditText I;
  private ListView J;
  private View K;
  private TextView L;
  private int M = 0;
  private int N = 0;
  private int O = 0;
  private String P;
  private ImageView Q;
  private ImageView R;
  private TextView S;
  private TextView T;
  private ImageView U;
  private TextView V;
  private TextView W;
  private TextView X;
  private RelativeLayout Y;
  private BDLocation Z;
  String a = "";
  private PoiSearch aa;
  private LinearLayout ab;
  private TextView ac;
  private ListView ad;
  private String ae;
  private LocationClient af;
  private a ag;
  private boolean ah = false;
  private boolean ai = false;
  private Handler aj = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69785: 
        if (((l)localObject).getSuccess().booleanValue())
        {
          paramAnonymousMessage = (bg)((l)localObject).getObject();
          localObject = new Intent();
          ((Intent)localObject).putExtra("savaAddress", paramAnonymousMessage);
          ModifyNewAddressActivity.this.setResult(-1, (Intent)localObject);
          ModifyNewAddressActivity.this.finish();
        }
        for (;;)
        {
          ModifyNewAddressActivity.r(ModifyNewAddressActivity.this).setClickable(true);
          return;
          g.textToast(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), ((l)localObject).getMessage());
        }
      }
      if (((l)localObject).getSuccess().booleanValue())
      {
        paramAnonymousMessage = new Intent(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), CleanAddressActivity.class);
        if (!TextUtils.isEmpty(ModifyNewAddressActivity.s(ModifyNewAddressActivity.this))) {
          paramAnonymousMessage.putExtra("modifyPosition", ModifyNewAddressActivity.s(ModifyNewAddressActivity.this));
        }
        ModifyNewAddressActivity.t(ModifyNewAddressActivity.this).setLinkPhone(ModifyNewAddressActivity.f(ModifyNewAddressActivity.this).getText().toString());
        paramAnonymousMessage.putExtra("addressList", ModifyNewAddressActivity.t(ModifyNewAddressActivity.this));
        if ((!TextUtils.isEmpty(ModifyNewAddressActivity.this.getIntent().getStringExtra("modify"))) && ("bedroom_modify".equals(ModifyNewAddressActivity.this.getIntent().getStringExtra("modify")))) {
          paramAnonymousMessage.putExtra("modify_addressId", ModifyNewAddressActivity.t(ModifyNewAddressActivity.this).getAddressId());
        }
        ModifyNewAddressActivity.this.setResult(-1, paramAnonymousMessage);
        ModifyNewAddressActivity.this.finish();
      }
      for (;;)
      {
        ModifyNewAddressActivity.r(ModifyNewAddressActivity.this).setClickable(true);
        return;
        g.textToast(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), ((l)localObject).getMessage());
      }
    }
  };
  OnGetPoiSearchResultListener b = new OnGetPoiSearchResultListener()
  {
    public void onGetPoiDetailResult(PoiDetailResult paramAnonymousPoiDetailResult) {}
    
    public void onGetPoiIndoorResult(PoiIndoorResult paramAnonymousPoiIndoorResult) {}
    
    public void onGetPoiResult(final PoiResult paramAnonymousPoiResult)
    {
      if ((paramAnonymousPoiResult == null) || (paramAnonymousPoiResult.error == SearchResult.ERRORNO.RESULT_NOT_FOUND)) {
        g.textToast(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), "未找到结果");
      }
      while (paramAnonymousPoiResult.error != SearchResult.ERRORNO.NO_ERROR) {
        return;
      }
      u.d("skdl;gj", "========   poiResult= " + com.alibaba.fastjson.a.toJSONString(paramAnonymousPoiResult));
      z localz = new z(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), paramAnonymousPoiResult.getAllPoi());
      ModifyNewAddressActivity.p(ModifyNewAddressActivity.this).setAdapter(localz);
      ModifyNewAddressActivity.q(ModifyNewAddressActivity.this).setVisibility(0);
      ModifyNewAddressActivity.p(ModifyNewAddressActivity.this).setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
        {
          VdsAgent.onItemClick(this, paramAnonymous2AdapterView, paramAnonymous2View, paramAnonymous2Int, paramAnonymous2Long);
          double d1 = ((PoiInfo)paramAnonymousPoiResult.getAllPoi().get(paramAnonymous2Int)).location.latitude;
          double d2 = ((PoiInfo)paramAnonymousPoiResult.getAllPoi().get(paramAnonymous2Int)).location.longitude;
          paramAnonymous2AdapterView = ((PoiInfo)paramAnonymousPoiResult.getAllPoi().get(paramAnonymous2Int)).name;
          ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, d1, d2, paramAnonymous2AdapterView, false);
        }
      });
    }
  };
  private LabeledEditText c;
  private LabeledEditText d;
  private LabeledEditText e;
  private List<LatPoint> f;
  private com.ziroom.ziroomcustomer.newmovehouse.b.a g;
  private SuggestionSearch r = null;
  private double s;
  private double t;
  private String u = "";
  private String v = "";
  private GeoCoder w = null;
  private GeoCoder x;
  private String y = com.ziroom.ziroomcustomer.base.b.c;
  private Context z;
  
  private void a()
  {
    if (ApplicationEx.c.getUser() != null) {
      this.e.setText(ApplicationEx.c.getUser().getPhone());
    }
    if (!TextUtils.isEmpty(getIntent().getStringExtra("modify")))
    {
      if (!"bedroom_modify".equals(getIntent().getStringExtra("modify"))) {
        break label218;
      }
      this.C = ((com.ziroom.ziroomcustomer.newclean.d.c)getIntent().getSerializableExtra("addressList"));
      this.P = getIntent().getStringExtra("modify_position");
      this.R.setVisibility(0);
      if (this.C != null) {
        a(true);
      }
    }
    for (;;)
    {
      String str = getIntent().getStringExtra("isZhengzu");
      if ((!TextUtils.isEmpty(str)) && ("isZhengzu".equals(str)))
      {
        this.c.getTextView().setTextColor(-6710887);
        this.d.getTextView().setTextColor(-6710887);
        this.Q.setVisibility(8);
        this.c.setClickable(false);
        this.d.getTextView().setClickable(false);
        this.d.getTextView().setFocusable(false);
        this.d.getTextView().setEnabled(false);
        this.d.getTextView().setFocusableInTouchMode(false);
      }
      return;
      label218:
      if ("modify".equals(getIntent().getStringExtra("modify")))
      {
        this.C = ((com.ziroom.ziroomcustomer.newclean.d.c)getIntent().getSerializableExtra("addressList"));
        this.P = getIntent().getStringExtra("modify_position");
        this.M = 1;
        this.N = 1;
        this.O = 1;
        this.R.setVisibility(0);
        this.Q.setVisibility(0);
        if (this.C != null) {
          a(false);
        }
      }
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, String paramString, boolean paramBoolean)
  {
    b(new LatLng(paramDouble1, paramDouble2));
    this.c.setText(paramString);
    this.I.setText(paramString);
    this.I.clearFocus();
    ((InputMethodManager)this.z.getSystemService("input_method")).hideSoftInputFromWindow(this.I.getWindowToken(), 0);
    this.M = 1;
    this.g = new com.ziroom.ziroomcustomer.newmovehouse.b.a(new ArrayList(), this.z);
    this.J.setAdapter(this.g);
    this.g.notifyDataSetChanged();
    b(false);
    if (!paramBoolean) {
      i();
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
    this.aa.searchNearby(localPoiNearbySearchOption);
  }
  
  private void a(LatLng paramLatLng)
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.validMatchSupplierScopeByCoord(this, paramLatLng.longitude, paramLatLng.latitude, new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        if ((paramAnonymousThrowable instanceof com.ziroom.ziroomcustomer.e.b.a))
        {
          dismissProgress();
          e.newBuilder(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this)).setTitle("提示").setContent(paramAnonymousThrowable.getMessage()).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              ModifyNewAddressActivity.o(ModifyNewAddressActivity.this);
            }
          }).build().show();
          return;
        }
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
      }
    });
  }
  
  private void a(boolean paramBoolean)
  {
    this.c.setText(this.C.getVillage());
    this.d.setText(this.C.getDetAddress());
    this.e.setText(this.C.getLinkPhone());
    if ((this.C.getLongitude() != null) && (this.C.getLatitude() != null))
    {
      this.s = Double.parseDouble(this.C.getLongitude());
      this.t = Double.parseDouble(this.C.getLatitude());
      b(new LatLng(this.t, this.s));
    }
    this.I.setText(this.C.getVillage());
    if (paramBoolean)
    {
      this.c.getTextView().setTextColor(-6710887);
      this.d.getTextView().setTextColor(-6710887);
      this.Q.setVisibility(8);
      this.c.setClickable(false);
      this.d.getTextView().setClickable(false);
      this.d.getTextView().setFocusable(false);
      this.d.getTextView().setEnabled(false);
      this.d.getTextView().setFocusableInTouchMode(false);
    }
    this.r.requestSuggestion(new SuggestionSearchOption().keyword(this.C.getVillage()).city(this.a));
  }
  
  private void b()
  {
    this.aa = PoiSearch.newInstance();
    this.aa.setOnGetPoiSearchResultListener(this.b);
    this.E = ((MapView)findViewById(2131690529));
    this.E.showScaleControl(false);
    this.E.showZoomControls(false);
    this.E.removeViewAt(1);
    this.F = this.E.getMap();
    this.E.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        int i = ModifyNewAddressActivity.a(ModifyNewAddressActivity.this).getWidth();
        ViewGroup.LayoutParams localLayoutParams = ModifyNewAddressActivity.a(ModifyNewAddressActivity.this).getLayoutParams();
        localLayoutParams.height = (i / 2);
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this).setLayoutParams(localLayoutParams);
      }
    });
    this.c = ((LabeledEditText)findViewById(2131691715));
    this.d = ((LabeledEditText)findViewById(2131691718));
    this.e = ((LabeledEditText)findViewById(2131689811));
    this.B = ((TextView)findViewById(2131690552));
    this.D = ((ImageView)findViewById(2131689492));
    this.Q = ((ImageView)findViewById(2131691960));
    this.R = ((ImageView)findViewById(2131691961));
    this.W = ((TextView)findViewById(2131690546));
    this.X = ((TextView)findViewById(2131690537));
    this.Y = ((RelativeLayout)findViewById(2131690538));
    this.ab = ((LinearLayout)findViewById(2131690543));
    this.ac = ((TextView)findViewById(2131690544));
    this.ad = ((ListView)findViewById(2131690545));
    this.r = SuggestionSearch.newInstance();
    this.r.setOnGetSuggestionResultListener(this);
    this.f = new ArrayList();
    this.g = new com.ziroom.ziroomcustomer.newmovehouse.b.a(this.f, this.z);
    this.H = findViewById(2131690534);
    this.I = ((EditText)findViewById(2131690535));
    this.d.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() > 0)
        {
          ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, 1);
          ModifyNewAddressActivity.b(ModifyNewAddressActivity.this).setVisibility(0);
          return;
        }
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, 0);
        ModifyNewAddressActivity.b(ModifyNewAddressActivity.this).setVisibility(8);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 64)
        {
          g.textToast(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), "字数超出限制！");
          ModifyNewAddressActivity.d(ModifyNewAddressActivity.this).setText(paramAnonymousCharSequence.subSequence(0, 64).toString());
        }
      }
    });
    this.e.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() > 0)
        {
          ModifyNewAddressActivity.b(ModifyNewAddressActivity.this, 1);
          ModifyNewAddressActivity.e(ModifyNewAddressActivity.this).setVisibility(0);
          return;
        }
        ModifyNewAddressActivity.b(ModifyNewAddressActivity.this, 0);
        ModifyNewAddressActivity.e(ModifyNewAddressActivity.this).setVisibility(8);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 64)
        {
          g.textToast(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), "字数超出限制！");
          ModifyNewAddressActivity.f(ModifyNewAddressActivity.this).setText(paramAnonymousCharSequence.subSequence(0, 64).toString());
        }
      }
    });
    this.I.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() <= 0)
        {
          ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, "");
          ModifyNewAddressActivity.g(ModifyNewAddressActivity.this).clear();
          ModifyNewAddressActivity.h(ModifyNewAddressActivity.this);
          ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, true);
          return;
        }
        if (paramAnonymousCharSequence.length() > 0)
        {
          ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, false);
          w.onEvent(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), "dailyaddaddress_community");
        }
        ModifyNewAddressActivity.i(ModifyNewAddressActivity.this).requestSuggestion(new SuggestionSearchOption().keyword(paramAnonymousCharSequence.toString()).city(ModifyNewAddressActivity.this.a));
      }
    });
    this.L = ((TextView)findViewById(2131691962));
    this.J = ((ListView)findViewById(2131690547));
    this.J.setAdapter(this.g);
    this.J.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (((LatPoint)ModifyNewAddressActivity.j(ModifyNewAddressActivity.this).get(paramAnonymousInt)).getLatlng() == null)
        {
          g.textToast(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), "该地址无效，请重新输入地址");
          return;
        }
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, ((LatPoint)ModifyNewAddressActivity.j(ModifyNewAddressActivity.this).get(paramAnonymousInt)).getLatlng());
        ModifyNewAddressActivity.k(ModifyNewAddressActivity.this).setText(((LatPoint)ModifyNewAddressActivity.j(ModifyNewAddressActivity.this).get(paramAnonymousInt)).getName());
        ModifyNewAddressActivity.l(ModifyNewAddressActivity.this).setText(((LatPoint)ModifyNewAddressActivity.j(ModifyNewAddressActivity.this).get(paramAnonymousInt)).getName());
        ModifyNewAddressActivity.l(ModifyNewAddressActivity.this).clearFocus();
        ((InputMethodManager)ModifyNewAddressActivity.c(ModifyNewAddressActivity.this).getSystemService("input_method")).hideSoftInputFromWindow(ModifyNewAddressActivity.l(ModifyNewAddressActivity.this).getWindowToken(), 0);
        ModifyNewAddressActivity.c(ModifyNewAddressActivity.this, 1);
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, new com.ziroom.ziroomcustomer.newmovehouse.b.a(new ArrayList(), ModifyNewAddressActivity.c(ModifyNewAddressActivity.this)));
        ModifyNewAddressActivity.n(ModifyNewAddressActivity.this).setAdapter(ModifyNewAddressActivity.m(ModifyNewAddressActivity.this));
        ModifyNewAddressActivity.m(ModifyNewAddressActivity.this).notifyDataSetChanged();
        ModifyNewAddressActivity.b(ModifyNewAddressActivity.this, false);
        ModifyNewAddressActivity.o(ModifyNewAddressActivity.this);
      }
    });
    this.K = findViewById(2131690536);
    this.K.setOnClickListener(this);
    this.S = ((TextView)findViewById(2131690539));
    this.T = ((TextView)findViewById(2131690540));
    this.U = ((ImageView)findViewById(2131690542));
    this.V = ((TextView)findViewById(2131690541));
    g();
    this.B.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.R.setOnClickListener(this);
    this.Q.setOnClickListener(this);
    this.U.setOnClickListener(this);
    this.V.setOnClickListener(this);
    this.Y.setOnClickListener(this);
    if (!checkNet(this.z)) {
      g.textToast(this.z, "网络出现异常，请稍后再试");
    }
  }
  
  private void b(LatLng paramLatLng)
  {
    this.s = paramLatLng.longitude;
    this.t = paramLatLng.latitude;
    this.F.clear();
    Object localObject = BitmapDescriptorFactory.fromResource(2130839107);
    localObject = new MarkerOptions().position(paramLatLng).icon((BitmapDescriptor)localObject);
    this.F.addOverlay((OverlayOptions)localObject);
    localObject = MapStatusUpdateFactory.newLatLngZoom(paramLatLng, 15.0F);
    this.F.setMapStatus((MapStatusUpdate)localObject);
    a(paramLatLng);
  }
  
  private void b(final boolean paramBoolean)
  {
    this.ai = paramBoolean;
    Object localObject2 = null;
    Object localObject1;
    if ((this.H.getVisibility() != 0) && (paramBoolean))
    {
      localObject1 = new com.d.a.c();
      ((com.d.a.c)localObject1).playTogether(new com.d.a.a[] { com.d.a.j.ofFloat(this.H, "translationY", new float[] { this.H.getHeight(), 0.0F }) });
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((com.d.a.c)localObject1).addListener(new com.d.a.b()
        {
          public void onAnimationEnd(com.d.a.a paramAnonymousa)
          {
            super.onAnimationEnd(paramAnonymousa);
            if (!paramBoolean) {
              ModifyNewAddressActivity.u(ModifyNewAddressActivity.this).setVisibility(8);
            }
          }
          
          public void onAnimationStart(com.d.a.a paramAnonymousa)
          {
            super.onAnimationStart(paramAnonymousa);
            if (paramBoolean)
            {
              ModifyNewAddressActivity.u(ModifyNewAddressActivity.this).setVisibility(0);
              ModifyNewAddressActivity.l(ModifyNewAddressActivity.this).requestFocus();
              ((InputMethodManager)ModifyNewAddressActivity.c(ModifyNewAddressActivity.this).getSystemService("input_method")).toggleSoftInput(0, 2);
            }
          }
        });
        ((com.d.a.c)localObject1).start();
      }
      return;
      localObject1 = localObject2;
      if (this.H.getVisibility() == 0)
      {
        localObject1 = localObject2;
        if (!paramBoolean)
        {
          localObject1 = new com.d.a.c();
          ((com.d.a.c)localObject1).playTogether(new com.d.a.a[] { com.d.a.j.ofFloat(this.H, "translationY", new float[] { 0.0F, this.H.getHeight() }) });
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (VdsAgent.trackEditTextSilent(this.I).length() <= 0)
    {
      this.X.setVisibility(8);
      this.Y.setVisibility(8);
      if (this.ah)
      {
        this.ab.setVisibility(0);
        this.J.setVisibility(8);
        this.W.setVisibility(8);
        return;
      }
      this.ab.setVisibility(8);
      this.J.setVisibility(0);
      this.W.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      if (!com.ziroom.ziroomcustomer.newServiceList.utils.j.isOPenGps(this.z)) {
        this.ab.setVisibility(8);
      }
      for (;;)
      {
        this.J.setVisibility(8);
        this.W.setVisibility(8);
        this.X.setVisibility(8);
        this.Y.setVisibility(8);
        return;
        this.ab.setVisibility(0);
      }
    }
    this.ab.setVisibility(8);
    this.X.setVisibility(8);
    this.Y.setVisibility(8);
    this.J.setVisibility(0);
    this.W.setVisibility(0);
  }
  
  private void e()
  {
    this.A = ApplicationEx.c.getUser();
    String str1 = this.c.getText();
    String str2 = this.d.getText();
    String str3 = this.e.getText();
    if (TextUtils.isEmpty(str1))
    {
      g.textToast(this.z, "请输入小区地址");
      this.B.setClickable(true);
    }
    do
    {
      do
      {
        return;
        if (TextUtils.isEmpty(str2))
        {
          g.textToast(this.z, "请输入详细地址");
          this.B.setClickable(true);
          return;
        }
        if ((TextUtils.isEmpty(str3)) || (!ah.isMobile(str3)))
        {
          g.textToast(this.z, "请填写正确的电话号码");
          this.B.setClickable(true);
          return;
        }
        new StringBuilder().append(str1).append(str2).toString();
      } while (this.A == null);
      if (TextUtils.isEmpty(getIntent().getStringExtra("modify"))) {
        break;
      }
      if ("bedroom_modify".equals(getIntent().getStringExtra("modify")))
      {
        o.getNewGeneralAModifyList(this.z, this.aj, str2, this.C.getAddressId(), "", 1, 1, this.C.getLatitude() + "", str3, this.C.getLongitude() + "", "", this.A.getUid(), str1);
        return;
      }
    } while (!"modify".equals(getIntent().getStringExtra("modify")));
    o.getNewGeneralAModifyList(this.z, this.aj, str2, this.C.getFid(), "", 1, 1, this.t + "", str3, this.s + "", "", this.A.getUid(), str1);
    return;
    o.getNewGeneralAAddList(this.z, this.aj, str2, "", this.t, str3, this.s, "", this.A.getUid(), this.A.getUser_name(), this.A.getLogin_name_mobile(), str1);
  }
  
  private void f()
  {
    MapStatusUpdate localMapStatusUpdate;
    if ("310000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      localMapStatusUpdate = MapStatusUpdateFactory.newLatLngZoom(new LatLng(31.236334D, 121.480237D), 12.0F);
    }
    for (;;)
    {
      this.F.setMapStatus(localMapStatusUpdate);
      return;
      if ("440300".equals(com.ziroom.ziroomcustomer.base.b.d)) {
        localMapStatusUpdate = MapStatusUpdateFactory.newLatLngZoom(new LatLng(22.54855D, 114.065946D), 12.0F);
      } else {
        localMapStatusUpdate = MapStatusUpdateFactory.newLatLngZoom(new LatLng(39.915112D, 116.403963D), 12.0F);
      }
    }
  }
  
  private void g()
  {
    if (!com.ziroom.ziroomcustomer.newServiceList.utils.j.isOPenGps(this.z)) {
      return;
    }
    this.af = new LocationClient(this.z);
    this.ag = new a();
    this.af.registerLocationListener(this.ag);
    LocationClientOption localLocationClientOption = new LocationClientOption();
    localLocationClientOption.setOpenGps(true);
    localLocationClientOption.setCoorType("bd09ll");
    localLocationClientOption.setScanSpan(5000);
    localLocationClientOption.setIsNeedAddress(true);
    this.af.setLocOption(localLocationClientOption);
    this.af.start();
  }
  
  private void h()
  {
    this.af.stop();
    if (this.ag != null) {
      this.af.unRegisterLocationListener(this.ag);
    }
    this.af = null;
  }
  
  private void i()
  {
    this.d.setEditTextFocusable(true);
    j();
  }
  
  private void j()
  {
    getWindow().setSoftInputMode(5);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131690552: 
    case 2131690536: 
    case 2131691715: 
      do
      {
        return;
        this.B.setClickable(false);
        e();
        w.onEvent(this.z, "dailyaddaddress_complete");
        return;
        paramView = (InputMethodManager)this.z.getSystemService("input_method");
        if (paramView != null) {
          paramView.hideSoftInputFromWindow(this.I.getWindowToken(), 0);
        }
        b(false);
        return;
        a(this.d);
        b(true);
        c(false);
      } while (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.I)));
      this.r.requestSuggestion(new SuggestionSearchOption().keyword(VdsAgent.trackEditTextSilent(this.I).toString()).city(this.a));
      return;
    case 2131689492: 
      finish();
      w.onEvent(this.z, "dailyaddaddress_return");
      return;
    case 2131691960: 
      this.d.setText("");
      w.onEvent(this.z, "dailyaddaddress_return");
      return;
    case 2131691961: 
      this.e.setText("");
      w.onEvent(this.z, "dailyaddaddress_return");
      return;
    case 2131690541: 
    case 2131690542: 
      g();
      return;
    }
    if (this.Z == null)
    {
      g.textToast(this.z, "该地址无效，请重新输入地址");
      return;
    }
    a(this.Z.getLatitude(), this.Z.getLongitude(), this.Z.getAddress().address, false);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = com.ziroom.ziroomcustomer.base.b.c;
    setContentView(2130903392);
    this.z = this;
    b();
    f();
    a();
  }
  
  protected void onDestroy()
  {
    if (this.x != null) {
      this.x.destroy();
    }
    if (this.w != null) {
      this.w.destroy();
    }
    if (this.aa != null) {
      this.aa.destroy();
    }
    if (this.r != null) {
      this.r.destroy();
    }
    if (this.F != null) {
      this.F.clear();
    }
    if (this.E != null) {
      this.E.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onGetSuggestionResult(SuggestionResult paramSuggestionResult)
  {
    this.f.clear();
    if ((paramSuggestionResult == null) || (paramSuggestionResult.getAllSuggestions() == null))
    {
      this.L.setVisibility(0);
      return;
    }
    if ((!TextUtils.isEmpty(getIntent().getStringExtra("modify"))) && (this.G == 0)) {
      this.G = 1;
    }
    paramSuggestionResult = paramSuggestionResult.getAllSuggestions().iterator();
    while (paramSuggestionResult.hasNext())
    {
      SuggestionResult.SuggestionInfo localSuggestionInfo = (SuggestionResult.SuggestionInfo)paramSuggestionResult.next();
      if ((localSuggestionInfo.key != null) && (this.a != null) && (localSuggestionInfo.city != null) && (localSuggestionInfo.city.startsWith(this.a)))
      {
        u.d("key", "========   key=" + localSuggestionInfo.key + "  city=" + localSuggestionInfo.city);
        if ((!localSuggestionInfo.city.equals(localSuggestionInfo.key)) && (!localSuggestionInfo.district.equals(localSuggestionInfo.key)))
        {
          LatPoint localLatPoint = new LatPoint();
          localLatPoint.setName(localSuggestionInfo.key);
          localLatPoint.setAddress(localSuggestionInfo.city + localSuggestionInfo.district);
          localLatPoint.setLatlng(localSuggestionInfo.pt);
          this.f.add(localLatPoint);
        }
      }
    }
    if ((this.f != null) && (this.f.size() > 0))
    {
      this.L.setVisibility(8);
      this.W.setVisibility(0);
    }
    for (;;)
    {
      this.g = new com.ziroom.ziroomcustomer.newmovehouse.b.a(this.f, this);
      this.J.setAdapter(this.g);
      this.g.notifyDataSetChanged();
      return;
      this.W.setVisibility(8);
      this.L.setVisibility(0);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.E.onPause();
  }
  
  protected void onResume()
  {
    this.E.onResume();
    super.onResume();
    this.d.disposeFocus(findViewById(2131689541));
  }
  
  public class a
    implements BDLocationListener
  {
    public a() {}
    
    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      VdsAgent.onReceiveLocation(this, paramBDLocation);
      if (paramBDLocation != null) {
        if (paramBDLocation.getCity().startsWith(com.ziroom.ziroomcustomer.base.b.c))
        {
          ModifyNewAddressActivity.c(ModifyNewAddressActivity.this, true);
          if (VdsAgent.trackEditTextSilent(ModifyNewAddressActivity.l(ModifyNewAddressActivity.this)).length() > 0)
          {
            ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, false);
            ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, paramBDLocation);
            u.d("djsgkld", "=======  zhixingle " + ModifyNewAddressActivity.this.getIntent().getStringExtra("modify"));
            if ((TextUtils.isEmpty(ModifyNewAddressActivity.this.getIntent().getStringExtra("modify"))) && (TextUtils.isEmpty(ModifyNewAddressActivity.k(ModifyNewAddressActivity.this).getText())) && (!ModifyNewAddressActivity.v(ModifyNewAddressActivity.this)))
            {
              double d1 = paramBDLocation.getLatitude();
              double d2 = paramBDLocation.getLongitude();
              String str = paramBDLocation.getAddress().address;
              ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, d1, d2, str, true);
              ModifyNewAddressActivity.k(ModifyNewAddressActivity.this).setText(paramBDLocation.getAddress().address);
            }
            ModifyNewAddressActivity.w(ModifyNewAddressActivity.this).setText(paramBDLocation.getAddress().address);
            ModifyNewAddressActivity.x(ModifyNewAddressActivity.this).setText(paramBDLocation.getAddress().district);
            ModifyNewAddressActivity.b(ModifyNewAddressActivity.this, paramBDLocation.getAddress().district);
            ModifyNewAddressActivity.b(ModifyNewAddressActivity.this, paramBDLocation);
          }
        }
      }
      for (;;)
      {
        ModifyNewAddressActivity.y(ModifyNewAddressActivity.this);
        return;
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, true);
        break;
        ModifyNewAddressActivity.c(ModifyNewAddressActivity.this, false);
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, false);
        continue;
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, false);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/ModifyNewAddressActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */