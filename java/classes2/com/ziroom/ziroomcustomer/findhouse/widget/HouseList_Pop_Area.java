package com.ziroom.ziroomcustomer.findhouse.widget;

import android.content.Context;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.findhouse.model.ZZBizcircle;
import com.ziroom.ziroomcustomer.findhouse.model.ZZBizcircle.Bizcircle;
import com.ziroom.ziroomcustomer.findhouse.model.ZZSubway;
import com.ziroom.ziroomcustomer.findhouse.model.ZZSubway.Subway_station;
import com.ziroom.ziroomcustomer.util.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HouseList_Pop_Area
  extends PopupWindow
{
  private static String b = "";
  private static String c = "";
  private Context a;
  private float d;
  private List<ZZBizcircle> e;
  private List<ZZSubway> f;
  private String[] g = { "#FAFAFA", "#F5F5F5", "#F5F5F5" };
  private List<String> h = new ArrayList();
  private List<String> i = new ArrayList();
  private List<String> j = new ArrayList();
  private List<String> k = new ArrayList();
  private List<String> l = new ArrayList();
  private int[] m = { 1, 0, -1 };
  private a n;
  private a o;
  private a p;
  private RelativeLayout q;
  private View r;
  private ListView s;
  private ListView t;
  private ListView u;
  private boolean v = false;
  private HouseList_ConditionalView.c w;
  private c x;
  
  public HouseList_Pop_Area(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HouseList_Pop_Area(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HouseList_Pop_Area(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    setSoftInputMode(16);
    setWidth(-1);
    if (Build.VERSION.SDK_INT >= 24) {
      setHeight(-2);
    }
    for (;;)
    {
      setAnimationStyle(2131427934);
      this.d = this.a.getResources().getDisplayMetrics().density;
      this.q = ((RelativeLayout)LayoutInflater.from(this.a).inflate(2130905045, null));
      d();
      c();
      setContentView(this.q);
      return;
      setHeight(-1);
    }
  }
  
  private List<String> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt >= this.e.size()) {
      return localArrayList;
    }
    List localList = ((ZZBizcircle)this.e.get(paramInt)).getBizcircle();
    if ((localList == null) || (localList.size() < 1)) {
      return localArrayList;
    }
    if (this.v) {
      paramInt = 1;
    }
    while (paramInt < localList.size())
    {
      localArrayList.add(((ZZBizcircle.Bizcircle)localList.get(paramInt)).getBizcircle_name());
      paramInt += 1;
      continue;
      paramInt = 0;
    }
    return localArrayList;
  }
  
  private List<String> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.f == null) || (this.f.size() < 1)) {
      return localArrayList;
    }
    List localList = ((ZZSubway)this.f.get(paramInt)).getSubway_station();
    if ((localList == null) || (localList.size() < 1)) {
      return localArrayList;
    }
    if (this.v) {
      paramInt = 1;
    }
    while (paramInt < localList.size())
    {
      localArrayList.add(((ZZSubway.Subway_station)localList.get(paramInt)).getSubway_station_name());
      paramInt += 1;
      continue;
      paramInt = 0;
    }
    return localArrayList;
  }
  
  private void c()
  {
    this.s.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ((paramAnonymousInt == HouseList_Pop_Area.a(HouseList_Pop_Area.this)[0]) && (paramAnonymousInt != 0)) {
          return;
        }
        HouseList_Pop_Area.b(HouseList_Pop_Area.this).setSelect(paramAnonymousInt);
        HouseList_Pop_Area.c(HouseList_Pop_Area.this).setSelect(-1);
        HouseList_Pop_Area.d(HouseList_Pop_Area.this).setSelect(-1);
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 0: 
          HouseList_Pop_Area.a(HouseList_Pop_Area.this, new int[] { 0, 0, 0 });
          HouseList_Pop_Area.c(HouseList_Pop_Area.this).setList(null);
          HouseList_Pop_Area.d(HouseList_Pop_Area.this).setList(null);
          HouseList_Pop_Area.e(HouseList_Pop_Area.this);
          paramAnonymousAdapterView = (LocationManager)HouseList_Pop_Area.f(HouseList_Pop_Area.this).getSystemService("location");
          boolean bool1 = paramAnonymousAdapterView.isProviderEnabled("network");
          boolean bool2 = paramAnonymousAdapterView.isProviderEnabled("gps");
          if ((!bool1) && (!bool2))
          {
            com.freelxl.baselibrary.f.g.textToast(HouseList_Pop_Area.f(HouseList_Pop_Area.this), "定位失败，请更改定位设置以允许定位", 0);
            return;
          }
          if (HouseList_Pop_Area.g(HouseList_Pop_Area.this) != null) {
            HouseList_Pop_Area.g(HouseList_Pop_Area.this).onAreaSelect(0, "", "", "", "");
          }
          HouseList_Pop_Area.h(HouseList_Pop_Area.this).setVisibility(8);
          HouseList_Pop_Area.i(HouseList_Pop_Area.this).setVisibility(8);
          HouseList_Pop_Area.this.dismiss();
          w.onEventToZiroomAndUmeng("entire_list_location_nearby");
          return;
        case 1: 
          HouseList_Pop_Area.a(HouseList_Pop_Area.this, new int[] { 1, 0, -1 });
          HouseList_Pop_Area.h(HouseList_Pop_Area.this).setVisibility(0);
          HouseList_Pop_Area.i(HouseList_Pop_Area.this).setVisibility(8);
          if ((HouseList_Pop_Area.j(HouseList_Pop_Area.this) == null) || (HouseList_Pop_Area.j(HouseList_Pop_Area.this).size() < 1) || (!b.d.equals(HouseList_Pop_Area.a()))) {
            j.getZZBizcirle(HouseList_Pop_Area.f(HouseList_Pop_Area.this), com.ziroom.ziroomcustomer.e.g.buildZZBizcirle(), new HouseList_Pop_Area.d(HouseList_Pop_Area.this), true);
          }
          for (;;)
          {
            w.onEventToZiroomAndUmeng("entire_list_location_commercial district");
            return;
            HouseList_Pop_Area.k(HouseList_Pop_Area.this);
          }
        }
        HouseList_Pop_Area.a(HouseList_Pop_Area.this, new int[] { 2, 0, -1 });
        HouseList_Pop_Area.h(HouseList_Pop_Area.this).setVisibility(0);
        HouseList_Pop_Area.i(HouseList_Pop_Area.this).setVisibility(8);
        if ((HouseList_Pop_Area.l(HouseList_Pop_Area.this) == null) || (HouseList_Pop_Area.l(HouseList_Pop_Area.this).size() < 1) || (!b.d.equals(HouseList_Pop_Area.b()))) {
          j.getZZSubway(HouseList_Pop_Area.f(HouseList_Pop_Area.this), com.ziroom.ziroomcustomer.e.g.buildZZBizcirle(), new HouseList_Pop_Area.e(HouseList_Pop_Area.this), true);
        }
        for (;;)
        {
          w.onEventToZiroomAndUmeng("entire_list_location_subway");
          return;
          HouseList_Pop_Area.m(HouseList_Pop_Area.this);
        }
      }
    });
    this.t.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ((paramAnonymousInt != 0) && (paramAnonymousInt == HouseList_Pop_Area.a(HouseList_Pop_Area.this)[1])) {
          return;
        }
        HouseList_Pop_Area.c(HouseList_Pop_Area.this).setSelect(paramAnonymousInt);
        HouseList_Pop_Area.d(HouseList_Pop_Area.this).setSelect(-1);
        if (HouseList_Pop_Area.a(HouseList_Pop_Area.this)[0] == 1)
        {
          HouseList_Pop_Area.a(HouseList_Pop_Area.this, new int[] { 1, paramAnonymousInt, -1 });
          HouseList_Pop_Area.a(HouseList_Pop_Area.this, HouseList_Pop_Area.a(HouseList_Pop_Area.this, paramAnonymousInt));
          if ((paramAnonymousInt == 0) && ((HouseList_Pop_Area.n(HouseList_Pop_Area.this) == null) || (HouseList_Pop_Area.n(HouseList_Pop_Area.this).size() < 1)))
          {
            HouseList_Pop_Area.g(HouseList_Pop_Area.this).onAreaSelect(1, "商圈", "", ((ZZBizcircle)HouseList_Pop_Area.j(HouseList_Pop_Area.this).get(paramAnonymousInt)).getDistrict_name(), ((ZZBizcircle)HouseList_Pop_Area.j(HouseList_Pop_Area.this).get(paramAnonymousInt)).getDistrict_code());
            HouseList_Pop_Area.i(HouseList_Pop_Area.this).setVisibility(8);
            HouseList_Pop_Area.d(HouseList_Pop_Area.this).setList(HouseList_Pop_Area.n(HouseList_Pop_Area.this));
          }
        }
        while (HouseList_Pop_Area.a(HouseList_Pop_Area.this)[0] != 2) {
          for (;;)
          {
            HouseList_Pop_Area.e(HouseList_Pop_Area.this);
            HouseList_Pop_Area.i(HouseList_Pop_Area.this).setSelectionFromTop(0, 0);
            if ((HouseList_Pop_Area.p(HouseList_Pop_Area.this)) || (paramAnonymousInt != 0)) {
              break;
            }
            HouseList_Pop_Area.this.dismiss();
            return;
            HouseList_Pop_Area.i(HouseList_Pop_Area.this).setVisibility(0);
          }
        }
        HouseList_Pop_Area.a(HouseList_Pop_Area.this, new int[] { 2, paramAnonymousInt, -1 });
        HouseList_Pop_Area.b(HouseList_Pop_Area.this, HouseList_Pop_Area.b(HouseList_Pop_Area.this, paramAnonymousInt));
        if ((paramAnonymousInt == 0) && ((HouseList_Pop_Area.o(HouseList_Pop_Area.this) == null) || (HouseList_Pop_Area.o(HouseList_Pop_Area.this).size() < 1)))
        {
          HouseList_Pop_Area.g(HouseList_Pop_Area.this).onAreaSelect(2, "地铁", "", ((ZZSubway)HouseList_Pop_Area.l(HouseList_Pop_Area.this).get(paramAnonymousInt)).getSubway_name(), ((ZZSubway)HouseList_Pop_Area.l(HouseList_Pop_Area.this).get(paramAnonymousInt)).getSubway_code());
          HouseList_Pop_Area.i(HouseList_Pop_Area.this).setVisibility(8);
        }
        for (;;)
        {
          HouseList_Pop_Area.d(HouseList_Pop_Area.this).setList(HouseList_Pop_Area.o(HouseList_Pop_Area.this));
          break;
          HouseList_Pop_Area.i(HouseList_Pop_Area.this).setVisibility(0);
        }
      }
    });
    this.u.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (HouseList_Pop_Area.p(HouseList_Pop_Area.this)) {}
        for (int i = paramAnonymousInt + 1;; i = paramAnonymousInt)
        {
          HouseList_Pop_Area.d(HouseList_Pop_Area.this).setSelect(paramAnonymousInt);
          HouseList_Pop_Area.a(HouseList_Pop_Area.this)[2] = paramAnonymousInt;
          if (HouseList_Pop_Area.a(HouseList_Pop_Area.this)[1] == -1) {
            HouseList_Pop_Area.a(HouseList_Pop_Area.this)[1] = 0;
          }
          if (HouseList_Pop_Area.a(HouseList_Pop_Area.this)[0] != 1) {
            break label230;
          }
          if (HouseList_Pop_Area.g(HouseList_Pop_Area.this) == null) {
            break label215;
          }
          paramAnonymousAdapterView = (ZZBizcircle.Bizcircle)((ZZBizcircle)HouseList_Pop_Area.j(HouseList_Pop_Area.this).get(HouseList_Pop_Area.a(HouseList_Pop_Area.this)[1])).getBizcircle().get(i);
          if (paramAnonymousAdapterView != null) {
            break;
          }
          return;
        }
        HouseList_Pop_Area.g(HouseList_Pop_Area.this).onAreaSelect(1, paramAnonymousAdapterView.getBizcircle_name(), paramAnonymousAdapterView.getBizcircle_code(), ((ZZBizcircle)HouseList_Pop_Area.j(HouseList_Pop_Area.this).get(HouseList_Pop_Area.a(HouseList_Pop_Area.this)[1])).getDistrict_name(), ((ZZBizcircle)HouseList_Pop_Area.j(HouseList_Pop_Area.this).get(HouseList_Pop_Area.a(HouseList_Pop_Area.this)[1])).getDistrict_code());
        for (;;)
        {
          label215:
          HouseList_Pop_Area.e(HouseList_Pop_Area.this);
          HouseList_Pop_Area.this.dismiss();
          return;
          label230:
          if ((HouseList_Pop_Area.a(HouseList_Pop_Area.this)[0] == 2) && (HouseList_Pop_Area.g(HouseList_Pop_Area.this) != null))
          {
            paramAnonymousAdapterView = (ZZSubway.Subway_station)((ZZSubway)HouseList_Pop_Area.l(HouseList_Pop_Area.this).get(HouseList_Pop_Area.a(HouseList_Pop_Area.this)[1])).getSubway_station().get(i);
            if (paramAnonymousAdapterView == null) {
              break;
            }
            HouseList_Pop_Area.g(HouseList_Pop_Area.this).onAreaSelect(2, paramAnonymousAdapterView.getSubway_station_name(), paramAnonymousAdapterView.getSubway_station_code(), (String)HouseList_Pop_Area.q(HouseList_Pop_Area.this).get(HouseList_Pop_Area.a(HouseList_Pop_Area.this)[1]), (String)HouseList_Pop_Area.q(HouseList_Pop_Area.this).get(HouseList_Pop_Area.a(HouseList_Pop_Area.this)[1]));
          }
        }
      }
    });
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (HouseList_Pop_Area.r(HouseList_Pop_Area.this) != null) {
          HouseList_Pop_Area.r(HouseList_Pop_Area.this).onDismiss();
        }
      }
    });
    this.r.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        HouseList_Pop_Area.this.dismiss();
      }
    });
  }
  
  private void d()
  {
    this.r = this.q.findViewById(2131694517);
    this.s = ((ListView)this.q.findViewById(2131697301));
    this.t = ((ListView)this.q.findViewById(2131697302));
    this.u = ((ListView)this.q.findViewById(2131697303));
  }
  
  private void e()
  {
    this.m = new int[] { 1, 0, -1 };
    this.h.clear();
    this.i.clear();
    this.j.clear();
    this.h.add("附近");
    this.h.add("商圈");
    this.h.add("地铁");
    this.n = new a(this.h);
    this.n.setSelect(this.m[0]);
    if ((this.v) && (this.e != null) && (this.e.size() > 1)) {
      this.e.remove(0);
    }
    int i1 = 0;
    while (i1 < this.e.size())
    {
      this.i.add(((ZZBizcircle)this.e.get(i1)).getDistrict_name());
      i1 += 1;
    }
    this.o = new a(this.i);
    this.o.setSelect(this.m[1]);
    this.j = a(this.m[1]);
    this.p = new a(this.j);
    this.s.setAdapter(this.n);
    this.t.setAdapter(this.o);
    this.u.setAdapter(this.p);
    this.u.setVisibility(8);
    this.p.setSelect(this.m[2]);
    f();
    this.t.setSelectionFromTop(0, 0);
  }
  
  private void f()
  {
    this.n.notifyDataSetChanged();
    this.o.notifyDataSetChanged();
    this.p.notifyDataSetChanged();
  }
  
  private void g()
  {
    this.m = new int[] { 2, 0, -1 };
    this.h.clear();
    this.h.add("附近");
    this.h.add("商圈");
    this.h.add("地铁");
    this.n = new a(this.h);
    this.n.setSelect(this.m[0]);
    this.k.clear();
    this.l.clear();
    if ((this.v) && (this.f != null) && (this.f.size() > 1)) {
      this.f.remove(0);
    }
    int i1 = 0;
    while (i1 < this.f.size())
    {
      this.k.add(((ZZSubway)this.f.get(i1)).getSubway_name());
      i1 += 1;
    }
    this.o = new a(this.k);
    this.o.setSelect(this.m[1]);
    this.l = b(0);
    this.p = new a(this.l);
    this.s.setAdapter(this.n);
    this.t.setAdapter(this.o);
    this.u.setAdapter(this.p);
    this.u.setVisibility(8);
    f();
    this.t.setSelectionFromTop(0, 0);
  }
  
  public void setAreaSelectListener(c paramc)
  {
    this.x = paramc;
  }
  
  public void setDismissListener(HouseList_ConditionalView.c paramc)
  {
    this.w = paramc;
  }
  
  public void setIsMapActivity(boolean paramBoolean)
  {
    this.v = paramBoolean;
    if (this.v) {
      this.u.setVisibility(0);
    }
  }
  
  public void showAsDropDown(View paramView)
  {
    if (!(this instanceof PopupWindow))
    {
      showAsDropDown(paramView, 0, 0);
      if ((this.e != null) && (this.e.size() >= 1) && (b.d.equals(b))) {
        break label79;
      }
      j.getZZBizcirle(this.a, com.ziroom.ziroomcustomer.e.g.buildZZBizcirle(), new d(), true);
    }
    label79:
    while (((this.i != null) || (this.f != null)) && ((this.i.size() >= 1) || (this.f.size() >= 1)))
    {
      return;
      VdsAgent.showAsDropDown((PopupWindow)this, paramView, 0, 0);
      break;
    }
    e();
  }
  
  public void showAsDropDown(View paramView, int paramInt)
  {
    if (!(this instanceof PopupWindow)) {
      showAsDropDown(paramView, 0, 0);
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return;
        VdsAgent.showAsDropDown((PopupWindow)this, paramView, 0, 0);
      }
    }
    if ((this.e == null) || (this.e.size() < 1) || (!b.d.equals(b)))
    {
      j.getZZBizcirle(this.a, com.ziroom.ziroomcustomer.e.g.buildZZBizcirle(), new d(), true);
      return;
    }
    e();
    return;
    if ((this.f == null) || (this.f.size() < 1) || (!b.d.equals(c)))
    {
      j.getZZSubway(this.a, com.ziroom.ziroomcustomer.e.g.buildZZBizcirle(), new e(), true);
      return;
    }
    g();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT == 24)
    {
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      paramInt2 = arrayOfInt[1] + paramView.getHeight() + paramInt2;
      if (!(this instanceof PopupWindow))
      {
        showAtLocation(paramView, 0, paramInt1, paramInt2);
        return;
      }
      VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, paramInt1, paramInt2);
      return;
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  class a
    extends BaseAdapter
  {
    private List<String> b;
    private int c = -1;
    
    public a()
    {
      List localList;
      this.b = localList;
    }
    
    public int getCount()
    {
      if ((this.b == null) || (this.b.size() == 0)) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        paramView = new HouseList_Pop_Area.b();
        localView = LayoutInflater.from(HouseList_Pop_Area.f(HouseList_Pop_Area.this)).inflate(2130903675, null);
        paramView.a = ((TextView)localView.findViewById(2131693236));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.a.setTextSize(2, 14.0F);
        paramViewGroup.a.setTextColor(HouseList_Pop_Area.f(HouseList_Pop_Area.this).getResources().getColor(2131624415));
        if (paramInt == this.c) {
          paramViewGroup.a.setTextColor(HouseList_Pop_Area.f(HouseList_Pop_Area.this).getResources().getColor(2131624588));
        }
        paramViewGroup.a.setText((CharSequence)this.b.get(paramInt));
        return localView;
        paramViewGroup = (HouseList_Pop_Area.b)paramView.getTag();
        localView = paramView;
      }
    }
    
    public void setList(List<String> paramList)
    {
      this.b = paramList;
    }
    
    public void setSelect(int paramInt)
    {
      this.c = paramInt;
    }
  }
  
  static class b
  {
    TextView a;
  }
  
  public static abstract interface c
  {
    public abstract void onAreaSelect(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);
  }
  
  class d
    implements i.a<String>
  {
    d() {}
    
    public void onParse(String paramString, k paramk)
    {
      e locale = a.parseObject(paramString);
      if ("success".equals(locale.get("status").toString()))
      {
        paramk.setSuccess(Boolean.valueOf(true));
        localObject = locale.get("data").toString();
        paramString = null;
      }
      try
      {
        localObject = a.parseArray((String)localObject, ZZBizcircle.class);
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      paramk.setObject(paramString);
      return;
      paramk.setSuccess(Boolean.valueOf(false));
      Object localObject = locale.get("error_message").toString();
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "服务器异常，正在努力抢修中，请稍后再试!";
      }
      paramk.setMessage(paramString);
      paramk.setCode(locale.get("error_code").toString());
      paramk.setMessage(paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        HouseList_Pop_Area.d(HouseList_Pop_Area.this, (List)paramk.getObject());
        if ((HouseList_Pop_Area.j(HouseList_Pop_Area.this) != null) && (HouseList_Pop_Area.j(HouseList_Pop_Area.this).size() > 0))
        {
          HouseList_Pop_Area.b(b.d);
          HouseList_Pop_Area.k(HouseList_Pop_Area.this);
        }
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(HouseList_Pop_Area.f(HouseList_Pop_Area.this), "服务器异常，正在努力抢修中，请稍后再试!", 0);
    }
  }
  
  class e
    implements i.a<String>
  {
    e() {}
    
    public void onParse(String paramString, k paramk)
    {
      e locale = a.parseObject(paramString);
      if ("success".equals(locale.get("status").toString()))
      {
        paramk.setSuccess(Boolean.valueOf(true));
        localObject = locale.get("data").toString();
        paramString = null;
      }
      try
      {
        localObject = a.parseArray((String)localObject, ZZSubway.class);
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      paramk.setObject(paramString);
      return;
      paramk.setSuccess(Boolean.valueOf(false));
      Object localObject = locale.get("error_message").toString();
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "服务器异常，正在努力抢修中，请稍后再试!";
      }
      paramk.setMessage(paramString);
      paramk.setCode(locale.get("error_code").toString());
      paramk.setMessage(paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        HouseList_Pop_Area.c(HouseList_Pop_Area.this, (List)paramk.getObject());
        if ((HouseList_Pop_Area.l(HouseList_Pop_Area.this) != null) && (HouseList_Pop_Area.l(HouseList_Pop_Area.this).size() > 0))
        {
          HouseList_Pop_Area.a(b.d);
          HouseList_Pop_Area.m(HouseList_Pop_Area.this);
        }
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(HouseList_Pop_Area.f(HouseList_Pop_Area.this), "服务器异常，正在努力抢修中，请稍后再试!", 0);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/widget/HouseList_Pop_Area.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */