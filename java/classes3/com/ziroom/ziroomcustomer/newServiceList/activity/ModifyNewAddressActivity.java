package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
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
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionResult.SuggestionInfo;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.d.a.c;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.AddressMo;
import com.ziroom.ziroomcustomer.newclean.activity.CleanAddressActivity;
import com.ziroom.ziroomcustomer.newmovehouse.model.LatPoint;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ModifyNewAddressActivity
  extends BaseActivity
  implements View.OnClickListener, OnGetSuggestionResultListener
{
  private ImageView A;
  private MapView B = null;
  private BaiduMap C = null;
  private int D = 0;
  private View E;
  private EditText F;
  private ListView G;
  private View H;
  private TextView I;
  private int J = 0;
  private int K = 0;
  private int L = 1;
  private ImageView M;
  private boolean N = false;
  String a = "";
  private LabeledEditText b;
  private LabeledEditText c;
  private List<LatPoint> d;
  private com.ziroom.ziroomcustomer.newmovehouse.b.a e;
  private SuggestionSearch f = null;
  private double g;
  private double r;
  private String s = "";
  private String t = "";
  private GeoCoder u = null;
  private GeoCoder v;
  private String w = com.ziroom.ziroomcustomer.base.b.c;
  private Context x;
  private TextView y;
  private AddressMo z;
  
  private void a()
  {
    this.N = getIntent().getBooleanExtra("isAllCity", false);
    if (!TextUtils.isEmpty(getIntent().getStringExtra("modify")))
    {
      this.z = ((AddressMo)getIntent().getParcelableExtra("address"));
      this.J = 1;
      this.K = 1;
      this.L = 1;
      a(this.J, this.K, this.L);
      this.M.setVisibility(0);
      b();
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 1) && (paramInt2 == 1) && (paramInt3 == 1))
    {
      this.y.setTextColor(40960);
      return;
    }
    this.y.setTextColor(-6710887);
  }
  
  private void a(LatLng paramLatLng)
  {
    this.g = paramLatLng.longitude;
    this.r = paramLatLng.latitude;
    this.C.clear();
    Object localObject = BitmapDescriptorFactory.fromResource(2130839107);
    localObject = new MarkerOptions().position(paramLatLng).icon((BitmapDescriptor)localObject);
    this.C.addOverlay((OverlayOptions)localObject);
    paramLatLng = MapStatusUpdateFactory.newLatLngZoom(paramLatLng, 15.0F);
    this.C.setMapStatus(paramLatLng);
  }
  
  private void a(final boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.E.getVisibility() != 0) && (paramBoolean))
    {
      localObject1 = new c();
      ((c)localObject1).playTogether(new com.d.a.a[] { com.d.a.j.ofFloat(this.E, "translationY", new float[] { this.E.getHeight(), 0.0F }) });
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
              ModifyNewAddressActivity.q(ModifyNewAddressActivity.this).setVisibility(8);
            }
          }
          
          public void onAnimationStart(com.d.a.a paramAnonymousa)
          {
            super.onAnimationStart(paramAnonymousa);
            if (paramBoolean)
            {
              ModifyNewAddressActivity.q(ModifyNewAddressActivity.this).setVisibility(0);
              ModifyNewAddressActivity.e(ModifyNewAddressActivity.this).requestFocus();
              ModifyNewAddressActivity.e(ModifyNewAddressActivity.this).setSelection(VdsAgent.trackEditTextSilent(ModifyNewAddressActivity.e(ModifyNewAddressActivity.this)).toString().length());
              ((InputMethodManager)ModifyNewAddressActivity.c(ModifyNewAddressActivity.this).getSystemService("input_method")).toggleSoftInput(0, 2);
            }
          }
        });
        ((c)localObject1).start();
      }
      return;
      localObject1 = localObject2;
      if (this.E.getVisibility() == 0)
      {
        localObject1 = localObject2;
        if (!paramBoolean)
        {
          localObject1 = new c();
          ((c)localObject1).playTogether(new com.d.a.a[] { com.d.a.j.ofFloat(this.E, "translationY", new float[] { 0.0F, this.E.getHeight() }) });
        }
      }
    }
  }
  
  private void b()
  {
    this.b.setText(this.z.getVillage());
    this.c.setText(this.z.getDetAddress());
    if ((this.z.getLongitude() != null) && (this.z.getLatitude() != null))
    {
      this.g = Double.parseDouble(this.z.getLongitude());
      this.r = Double.parseDouble(this.z.getLatitude());
      a(new LatLng(this.r, this.g));
    }
    String str = this.z.getCityCode();
    if ("110000".equals(str)) {
      this.a = "北京";
    }
    for (;;)
    {
      this.F.setText(this.z.getVillage());
      this.f.requestSuggestion(new SuggestionSearchOption().keyword(this.z.getVillage()).city(this.a));
      return;
      if ("310000".equals(str)) {
        this.a = "上海";
      } else if ("440300".equals(str)) {
        this.a = "深圳";
      }
    }
  }
  
  private void e()
  {
    this.B = ((MapView)findViewById(2131690529));
    this.B.showScaleControl(false);
    this.B.showZoomControls(false);
    this.B.removeViewAt(1);
    this.C = this.B.getMap();
    this.B.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        int i = ModifyNewAddressActivity.a(ModifyNewAddressActivity.this).getWidth();
        ViewGroup.LayoutParams localLayoutParams = ModifyNewAddressActivity.a(ModifyNewAddressActivity.this).getLayoutParams();
        localLayoutParams.height = (i / 2);
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this).setLayoutParams(localLayoutParams);
      }
    });
    this.b = ((LabeledEditText)findViewById(2131691715));
    this.c = ((LabeledEditText)findViewById(2131691718));
    this.y = ((TextView)findViewById(2131690552));
    this.A = ((ImageView)findViewById(2131689492));
    this.M = ((ImageView)findViewById(2131691960));
    this.f = SuggestionSearch.newInstance();
    this.f.setOnGetSuggestionResultListener(this);
    this.d = new ArrayList();
    this.e = new com.ziroom.ziroomcustomer.newmovehouse.b.a(this.d, this.x);
    this.E = findViewById(2131690534);
    this.F = ((EditText)findViewById(2131690535));
    this.c.addTextChangedListener(new c((EditText)this.c.getTextView(), this.x));
    this.F.addTextChangedListener(new b(this.F, this.x));
    this.I = ((TextView)findViewById(2131691962));
    this.G = ((ListView)findViewById(2131690547));
    this.G.setAdapter(this.e);
    this.G.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (((LatPoint)ModifyNewAddressActivity.b(ModifyNewAddressActivity.this).get(paramAnonymousInt)).getLatlng() == null)
        {
          g.textToast(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), "该地址无效，请重新输入地址");
          return;
        }
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, ((LatPoint)ModifyNewAddressActivity.b(ModifyNewAddressActivity.this).get(paramAnonymousInt)).getLatlng());
        ModifyNewAddressActivity.d(ModifyNewAddressActivity.this).setText(((LatPoint)ModifyNewAddressActivity.b(ModifyNewAddressActivity.this).get(paramAnonymousInt)).getAddress() + ((LatPoint)ModifyNewAddressActivity.b(ModifyNewAddressActivity.this).get(paramAnonymousInt)).getName());
        ModifyNewAddressActivity.e(ModifyNewAddressActivity.this).setText(((LatPoint)ModifyNewAddressActivity.b(ModifyNewAddressActivity.this).get(paramAnonymousInt)).getName());
        ModifyNewAddressActivity.e(ModifyNewAddressActivity.this).clearFocus();
        ((InputMethodManager)ModifyNewAddressActivity.c(ModifyNewAddressActivity.this).getSystemService("input_method")).hideSoftInputFromWindow(ModifyNewAddressActivity.e(ModifyNewAddressActivity.this).getWindowToken(), 0);
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, 1);
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, ModifyNewAddressActivity.f(ModifyNewAddressActivity.this), ModifyNewAddressActivity.g(ModifyNewAddressActivity.this), ModifyNewAddressActivity.h(ModifyNewAddressActivity.this));
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, new com.ziroom.ziroomcustomer.newmovehouse.b.a(new ArrayList(), ModifyNewAddressActivity.c(ModifyNewAddressActivity.this)));
        ModifyNewAddressActivity.j(ModifyNewAddressActivity.this).setAdapter(ModifyNewAddressActivity.i(ModifyNewAddressActivity.this));
        ModifyNewAddressActivity.i(ModifyNewAddressActivity.this).notifyDataSetChanged();
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, false);
      }
    });
    this.H = findViewById(2131690536);
    this.H.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.M.setOnClickListener(this);
  }
  
  private void f()
  {
    String str = this.b.getText();
    Object localObject = this.c.getText();
    if (TextUtils.isEmpty(str))
    {
      g.textToast(this.x, "请选择联想地址！");
      this.y.setClickable(true);
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      g.textToast(this.x, "请输入详细地址！");
      this.y.setClickable(true);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("detAddress", localObject);
    localHashMap.put("grade", "");
    if (!TextUtils.isEmpty(getIntent().getStringExtra("modify"))) {
      localHashMap.put("fid", this.z.getFid());
    }
    for (;;)
    {
      localHashMap.put("longitude", this.g + "");
      localHashMap.put("latitude", this.r + "");
      localObject = ApplicationEx.c.getUser();
      if (localObject != null) {
        localHashMap.put("linkPhone", ((UserInfo)localObject).getLogin_name_mobile());
      }
      localHashMap.put("provinceCode", "");
      localHashMap.put("village", str);
      showProgress("");
      if (TextUtils.isEmpty(getIntent().getStringExtra("modify"))) {
        break;
      }
      com.ziroom.ziroomcustomer.e.j.modifyServiceAddressList(this.x, localHashMap, new d());
      return;
      localHashMap.put("fid", "");
    }
    com.ziroom.ziroomcustomer.e.j.modifyServiceAddressList(this.x, localHashMap, new a());
  }
  
  private void g()
  {
    MapStatusUpdate localMapStatusUpdate;
    if (!this.N) {
      if ("310000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
        localMapStatusUpdate = MapStatusUpdateFactory.newLatLngZoom(new LatLng(31.236334D, 121.480237D), 12.0F);
      }
    }
    for (;;)
    {
      this.C.setMapStatus(localMapStatusUpdate);
      return;
      if ("440300".equals(com.ziroom.ziroomcustomer.base.b.d))
      {
        localMapStatusUpdate = MapStatusUpdateFactory.newLatLngZoom(new LatLng(22.54855D, 114.065946D), 12.0F);
      }
      else
      {
        localMapStatusUpdate = MapStatusUpdateFactory.newLatLngZoom(new LatLng(39.915112D, 116.403963D), 12.0F);
        continue;
        localMapStatusUpdate = MapStatusUpdateFactory.newLatLngZoom(new LatLng(39.915112D, 116.403963D), 12.0F);
      }
    }
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
        this.y.setClickable(false);
        f();
        return;
        a(false);
        return;
        a(true);
      } while (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.F)));
      this.f.requestSuggestion(new SuggestionSearchOption().keyword(VdsAgent.trackEditTextSilent(this.F).toString()).city(this.a));
      return;
    case 2131689492: 
      finish();
      return;
    }
    this.c.setText("");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = com.ziroom.ziroomcustomer.base.b.c;
    setContentView(2130903440);
    this.x = this;
    e();
    a();
    g();
  }
  
  protected void onDestroy()
  {
    if (this.v != null) {
      this.v.destroy();
    }
    if (this.u != null) {
      this.u.destroy();
    }
    if (this.f != null) {
      this.f.destroy();
    }
    if (this.C != null) {
      this.C.clear();
    }
    if (this.B != null) {
      this.B.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onGetSuggestionResult(SuggestionResult paramSuggestionResult)
  {
    this.d.clear();
    if ((paramSuggestionResult == null) || (paramSuggestionResult.getAllSuggestions() == null))
    {
      this.I.setVisibility(0);
      return;
    }
    if ((!TextUtils.isEmpty(getIntent().getStringExtra("modify"))) && (this.D == 0)) {
      this.D = 1;
    }
    paramSuggestionResult = paramSuggestionResult.getAllSuggestions().iterator();
    while (paramSuggestionResult.hasNext())
    {
      SuggestionResult.SuggestionInfo localSuggestionInfo = (SuggestionResult.SuggestionInfo)paramSuggestionResult.next();
      if ((localSuggestionInfo.key != null) && (this.a != null) && (localSuggestionInfo.city != null))
      {
        LatPoint localLatPoint;
        if (!this.N)
        {
          if (localSuggestionInfo.city.startsWith(this.a))
          {
            localLatPoint = new LatPoint();
            localLatPoint.setName(localSuggestionInfo.key);
            localLatPoint.setAddress(localSuggestionInfo.city + localSuggestionInfo.district);
            localLatPoint.setLatlng(localSuggestionInfo.pt);
            this.d.add(localLatPoint);
          }
        }
        else
        {
          localLatPoint = new LatPoint();
          localLatPoint.setName(localSuggestionInfo.key);
          localLatPoint.setAddress(localSuggestionInfo.city + localSuggestionInfo.district);
          localLatPoint.setLatlng(localSuggestionInfo.pt);
          this.d.add(localLatPoint);
        }
      }
    }
    if ((this.d != null) && (this.d.size() > 0)) {
      this.I.setVisibility(8);
    }
    for (;;)
    {
      this.e = new com.ziroom.ziroomcustomer.newmovehouse.b.a(this.d, this);
      this.G.setAdapter(this.e);
      this.e.notifyDataSetChanged();
      return;
      this.I.setVisibility(0);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.B.onPause();
  }
  
  protected void onResume()
  {
    this.B.onResume();
    super.onResume();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if ("0".equals((String)paramString.get("status")))
      {
        paramString = (AddressMo)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), AddressMo.class);
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(paramString);
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (AddressMo)paramk.getObject();
        Intent localIntent = new Intent();
        localIntent.putExtra("savaAddress", paramk);
        ModifyNewAddressActivity.this.setResult(-1, localIntent);
        ModifyNewAddressActivity.this.finish();
      }
      for (;;)
      {
        ModifyNewAddressActivity.p(ModifyNewAddressActivity.this).setClickable(true);
        ModifyNewAddressActivity.this.dismissProgress();
        return;
        paramk = paramk.getMessage();
        if (paramk != null) {
          g.textToast(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), paramk);
        } else {
          g.textToast(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), "修改地址失败，请重试");
        }
      }
    }
  }
  
  class b
    extends com.ziroom.ziroomcustomer.newServiceList.view.a
  {
    public b(EditText paramEditText, Context paramContext)
    {
      super(paramContext);
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if (paramCharSequence.length() <= 0)
      {
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, "");
        ModifyNewAddressActivity.k(ModifyNewAddressActivity.this).clear();
        ModifyNewAddressActivity.l(ModifyNewAddressActivity.this);
        return;
      }
      if (paramCharSequence.length() > 0) {
        w.onEvent(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), "dailyaddaddress_community");
      }
      ModifyNewAddressActivity.m(ModifyNewAddressActivity.this).requestSuggestion(new SuggestionSearchOption().keyword(paramCharSequence.toString()).city(ModifyNewAddressActivity.this.a));
    }
  }
  
  class c
    extends com.ziroom.ziroomcustomer.newServiceList.view.a
    implements LabeledEditText.a
  {
    public c(EditText paramEditText, Context paramContext)
    {
      super(paramContext);
    }
    
    public void afterTextChanged(Editable paramEditable)
    {
      super.afterTextChanged(paramEditable);
      if (paramEditable.length() > 0)
      {
        ModifyNewAddressActivity.b(ModifyNewAddressActivity.this, 1);
        ModifyNewAddressActivity.a(ModifyNewAddressActivity.this, ModifyNewAddressActivity.f(ModifyNewAddressActivity.this), ModifyNewAddressActivity.g(ModifyNewAddressActivity.this), ModifyNewAddressActivity.h(ModifyNewAddressActivity.this));
        ModifyNewAddressActivity.o(ModifyNewAddressActivity.this).setVisibility(0);
        return;
      }
      ModifyNewAddressActivity.b(ModifyNewAddressActivity.this, 0);
      ModifyNewAddressActivity.p(ModifyNewAddressActivity.this).setTextColor(-6710887);
      ModifyNewAddressActivity.o(ModifyNewAddressActivity.this).setVisibility(8);
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if (paramCharSequence.length() > 64)
      {
        g.textToast(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), "字数超出限制！");
        ModifyNewAddressActivity.n(ModifyNewAddressActivity.this).setText(paramCharSequence.subSequence(0, 64).toString());
        ModifyNewAddressActivity.n(ModifyNewAddressActivity.this).setSelection(ModifyNewAddressActivity.n(ModifyNewAddressActivity.this).getText().length());
      }
    }
  }
  
  class d
    implements i.a<String>
  {
    d() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if ("0".equals((String)paramString.get("status")))
      {
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(null);
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = new Intent(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), CleanAddressActivity.class);
        ModifyNewAddressActivity.this.setResult(-1, paramk);
        ModifyNewAddressActivity.this.finish();
      }
      for (;;)
      {
        ModifyNewAddressActivity.p(ModifyNewAddressActivity.this).setClickable(true);
        ModifyNewAddressActivity.this.dismissProgress();
        return;
        paramk = paramk.getMessage();
        if (paramk != null) {
          g.textToast(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), paramk);
        } else {
          g.textToast(ModifyNewAddressActivity.c(ModifyNewAddressActivity.this), "修改地址失败，请重试");
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/ModifyNewAddressActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */