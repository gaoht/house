package com.ziroom.ziroomcustomer.findhouse.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.HouseListActivity;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition.SelectDate;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import java.util.ArrayList;
import java.util.HashSet;

public class HouseList_ConditionalView
  extends LinearLayout
  implements View.OnClickListener
{
  private static String h = "";
  private Context a;
  private float b;
  private final int c = -1;
  private int d = -1;
  private String[] e = { "合租/整租", "位置", "入住日期", "筛选" };
  private SelectCondition f;
  private String g;
  private HashSet<Integer> i = new HashSet();
  private HouseList_Pop_Area j;
  private CheckinDatePop k;
  private HouseTypePop l;
  private HouseMorePop m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private boolean r = false;
  private LocationClient s;
  private b t;
  private String u = "";
  private String v = "";
  private SearchCondition w = new SearchCondition();
  private a x;
  
  public HouseList_ConditionalView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HouseList_ConditionalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HouseList_ConditionalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.b = this.a.getResources().getDisplayMetrics().density;
    a();
  }
  
  private String a(String paramString, HashSet<Integer> paramHashSet)
  {
    if ((paramString == null) || (paramString.length() < 1))
    {
      this.p.setText(this.e[0]);
      this.p.setTextColor(this.a.getResources().getColor(2131624415));
      return "";
    }
    this.i.clear();
    this.i.addAll(paramHashSet);
    int i1 = com.ziroom.ziroomcustomer.findhouse.a.getHouseClassify(paramHashSet);
    if (paramString.indexOf("|") == -1) {
      if (TextUtils.isEmpty(this.w.getTypeName()))
      {
        paramString = HouseListActivity.b;
        this.p.setText(paramString);
        this.p.setTextColor(this.a.getResources().getColor(2131624588));
      }
    }
    for (;;)
    {
      this.p.setGravity(17);
      return paramString;
      paramString = this.w.getTypeName();
      break;
      if (i1 == 10)
      {
        paramString = "合租";
        this.p.setText("合租");
        this.p.setTextColor(this.a.getResources().getColor(2131624588));
      }
      else if (i1 == 20)
      {
        paramString = "整租";
        this.p.setText("整租");
        this.p.setTextColor(this.a.getResources().getColor(2131624588));
      }
      else
      {
        paramString = this.e[0];
        this.p.setText(this.e[0]);
        this.p.setTextColor(this.a.getResources().getColor(2131624588));
      }
    }
  }
  
  private void a()
  {
    setOrientation(0);
    setBackgroundColor(this.a.getResources().getColor(2131624583));
    int i1 = 0;
    while (i1 < this.e.length)
    {
      View localView = c();
      localView.setTag(this.e[i1]);
      ((TextView)localView).setText(this.e[i1]);
      localView.setOnClickListener(this);
      addView(localView);
      if (i1 != this.e.length - 1)
      {
        localView = new View(this.a);
        localView.setBackgroundColor(Color.parseColor("#dddddd"));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(0.5D * this.b), -1);
        localLayoutParams.topMargin = ((int)(this.b * 14.0F));
        localLayoutParams.bottomMargin = ((int)(this.b * 14.0F));
        localView.setLayoutParams(localLayoutParams);
        addView(localView);
      }
      i1 += 1;
    }
    this.p = ((TextView)getChildAt(0));
    this.n = ((TextView)getChildAt(2));
    this.o = ((TextView)getChildAt(4));
    this.q = ((TextView)getChildAt(6));
    b();
  }
  
  private void a(TextView paramTextView)
  {
    setSelectStyle(3, paramTextView);
    f();
  }
  
  private void a(SearchCondition paramSearchCondition)
  {
    if ((!HouseListActivity.d) && (paramSearchCondition != null))
    {
      paramSearchCondition.setClng("");
      paramSearchCondition.setClat("");
    }
    HouseListActivity.d = true;
  }
  
  private void b()
  {
    this.s = new LocationClient(this.a);
    this.t = new b();
    this.s.registerLocationListener(this.t);
    LocationClientOption localLocationClientOption = new LocationClientOption();
    localLocationClientOption.setOpenGps(true);
    localLocationClientOption.setCoorType("bd09ll");
    localLocationClientOption.setScanSpan(5000);
    localLocationClientOption.setIsNeedAddress(true);
    this.s.setLocOption(localLocationClientOption);
    this.s.start();
  }
  
  private void b(TextView paramTextView)
  {
    setSelectStyle(0, paramTextView);
    h();
  }
  
  private View c()
  {
    TextView localTextView = new TextView(this.a);
    localTextView.setSingleLine();
    localTextView.setGravity(17);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextColor(this.a.getResources().getColor(2131624415));
    Object localObject = getResources().getDrawable(2130837621);
    ((Drawable)localObject).setBounds(0, 0, (int)(6.0F * this.b), (int)(4.0F * this.b));
    localTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
    localTextView.setPadding((int)(12.0F * this.b), 0, (int)(8.0F * this.b), 0);
    localObject = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    return localTextView;
  }
  
  private void c(TextView paramTextView)
  {
    setSelectStyle(2, paramTextView);
    j();
  }
  
  private void d()
  {
    if (this.j == null)
    {
      this.j = new HouseList_Pop_Area(this.a);
      this.j.setIsMapActivity(this.r);
      e();
    }
    if (this.j.isShowing())
    {
      this.j.dismiss();
      return;
    }
    HouseList_Pop_Area localHouseList_Pop_Area = this.j;
    TextView localTextView = this.n;
    if (!(localHouseList_Pop_Area instanceof PopupWindow))
    {
      localHouseList_Pop_Area.showAsDropDown(localTextView);
      return;
    }
    VdsAgent.showAsDropDown((PopupWindow)localHouseList_Pop_Area, localTextView);
  }
  
  private void d(TextView paramTextView)
  {
    setSelectStyle(1, paramTextView);
    d();
  }
  
  private void e()
  {
    this.j.setDismissListener(new c()
    {
      public void onDismiss()
      {
        HouseList_ConditionalView.b(HouseList_ConditionalView.this).setSelected(false);
        HouseList_ConditionalView.a(HouseList_ConditionalView.this, -1);
      }
    });
    this.j.setAreaSelectListener(new HouseList_Pop_Area.c()
    {
      public void onAreaSelect(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        Object localObject = HouseList_ConditionalView.b(HouseList_ConditionalView.this);
        ((TextView)localObject).setTextColor(HouseList_ConditionalView.c(HouseList_ConditionalView.this).getResources().getColor(2131624588));
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.length() > 4)) {
          ((TextView)localObject).setGravity(19);
        }
        for (;;)
        {
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setKeywords("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setSuggestion_type("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setSuggestion_value("");
          switch (paramAnonymousInt)
          {
          default: 
            if (HouseList_ConditionalView.g(HouseList_ConditionalView.this) != null) {
              HouseList_ConditionalView.g(HouseList_ConditionalView.this).getData(HouseList_ConditionalView.d(HouseList_ConditionalView.this));
            }
            return;
            ((TextView)localObject).setGravity(17);
          }
        }
        ((TextView)localObject).setText("附近");
        HouseList_ConditionalView.d(HouseList_ConditionalView.this).setAreaText("附近");
        if ((!TextUtils.isEmpty(HouseList_ConditionalView.e(HouseList_ConditionalView.this))) && (!TextUtils.isEmpty(HouseList_ConditionalView.f(HouseList_ConditionalView.this))))
        {
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setClng(HouseList_ConditionalView.f(HouseList_ConditionalView.this));
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setClat(HouseList_ConditionalView.e(HouseList_ConditionalView.this));
        }
        for (;;)
        {
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setBizcircle_code("");
          paramAnonymousString1 = new SelectBean();
          paramAnonymousString1.setTitle("");
          paramAnonymousString1.setValue("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setBizcircle(paramAnonymousString1);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setDistrict("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setDistrictName("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setSubway_line("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setSubway("");
          break;
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setClng(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getLng() + "");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setClat(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getLat() + "");
        }
        if ("不限".equals(paramAnonymousString1))
        {
          ((TextView)localObject).setText(paramAnonymousString3);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setAreaText(paramAnonymousString3);
        }
        for (;;)
        {
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setClat("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setClng("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setSubway("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setSubwayName("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setSubway_line("");
          localObject = new SelectBean();
          ((SelectBean)localObject).setTitle(paramAnonymousString1);
          ((SelectBean)localObject).setValue(paramAnonymousString2);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setBizcircle((SelectBean)localObject);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setBizcircle_code(paramAnonymousString2);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setDistrictName(paramAnonymousString3);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setDistrict(paramAnonymousString4);
          break;
          ((TextView)localObject).setText(paramAnonymousString1);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setAreaText(paramAnonymousString1);
        }
        if ("不限".equals(paramAnonymousString1))
        {
          ((TextView)localObject).setText(paramAnonymousString3);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setAreaText(paramAnonymousString3);
        }
        for (;;)
        {
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setClat("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setClng("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setBizcircle(new SelectBean());
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setBizcircle_code("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setDistrictName("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setDistrict("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setSubway(paramAnonymousString2);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setSubwayName(paramAnonymousString1);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setSubway_line(paramAnonymousString4);
          break;
          ((TextView)localObject).setText(paramAnonymousString1);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setAreaText(paramAnonymousString1);
        }
      }
    });
  }
  
  private void f()
  {
    if (this.m == null)
    {
      this.m = new HouseMorePop(this.a);
      g();
    }
    if (this.m.isShowing())
    {
      this.m.dismiss();
      return;
    }
    this.m.show(this.q, this.f, this.w);
  }
  
  private void g()
  {
    this.m.setPopDismisListener(new c()
    {
      public void onDismiss()
      {
        HouseList_ConditionalView.h(HouseList_ConditionalView.this).setSelected(false);
        HouseList_ConditionalView.a(HouseList_ConditionalView.this, -1);
      }
    });
    this.m.setOnSelectListener(new HouseMorePop.a()
    {
      public void select(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          HouseList_ConditionalView.h(HouseList_ConditionalView.this).setTextColor(HouseList_ConditionalView.c(HouseList_ConditionalView.this).getResources().getColor(2131624588));
        }
        for (;;)
        {
          if (HouseList_ConditionalView.g(HouseList_ConditionalView.this) != null)
          {
            HouseList_ConditionalView.a(HouseList_ConditionalView.this, HouseList_ConditionalView.d(HouseList_ConditionalView.this));
            HouseList_ConditionalView.g(HouseList_ConditionalView.this).getData(HouseList_ConditionalView.d(HouseList_ConditionalView.this));
          }
          return;
          HouseList_ConditionalView.h(HouseList_ConditionalView.this).setTextColor(HouseList_ConditionalView.c(HouseList_ConditionalView.this).getResources().getColor(2131624415));
        }
      }
    });
  }
  
  private void h()
  {
    if (this.l == null)
    {
      this.l = new HouseTypePop(this.a);
      i();
    }
    if (this.l.isShowing())
    {
      this.l.dismiss();
      return;
    }
    this.l.show(this.p, this.f, this.w);
  }
  
  private void i()
  {
    this.l.setPopDismisListener(new c()
    {
      public void onDismiss()
      {
        HouseList_ConditionalView.i(HouseList_ConditionalView.this).setSelected(false);
        HouseList_ConditionalView.a(HouseList_ConditionalView.this, -1);
      }
    });
    this.l.setOnTypeSelectListener(new HouseTypePop.a()
    {
      public void select(String paramAnonymousString1, String paramAnonymousString2, HashSet<Integer> paramAnonymousHashSet)
      {
        HouseList_ConditionalView.d(HouseList_ConditionalView.this).setTypeName(paramAnonymousString2);
        paramAnonymousString2 = HouseList_ConditionalView.a(HouseList_ConditionalView.this, paramAnonymousString1, paramAnonymousHashSet);
        if ((paramAnonymousHashSet != null) || (paramAnonymousHashSet.size() != HouseList_ConditionalView.d(HouseList_ConditionalView.this).getTypeSet().size()) || (!paramAnonymousHashSet.containsAll(HouseList_ConditionalView.d(HouseList_ConditionalView.this).getTypeSet())))
        {
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setRface("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setHface("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setFace("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setBedroom(new SelectBean());
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setFeature("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setVersion("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setStyle("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setArea("");
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setMaxPrice(0);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setMinPrice(0);
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setFaceBeanList(new ArrayList());
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setrFaceBeanList(new ArrayList());
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).sethFaceBeanList(new ArrayList());
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setAreaBeanList(new ArrayList());
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setFeatureBeanList(new ArrayList());
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setStyleBeanList(new ArrayList());
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setVersionBeanList(new ArrayList());
        }
        HouseList_ConditionalView.d(HouseList_ConditionalView.this).setLive("");
        HouseList_ConditionalView.d(HouseList_ConditionalView.this).setType(paramAnonymousString1);
        HouseList_ConditionalView.d(HouseList_ConditionalView.this).setTypeSet(paramAnonymousHashSet);
        if ((TextUtils.isEmpty(HouseList_ConditionalView.d(HouseList_ConditionalView.this).getLeasetype())) && (TextUtils.isEmpty(HouseList_ConditionalView.d(HouseList_ConditionalView.this).getTags())) && (TextUtils.isEmpty(HouseList_ConditionalView.d(HouseList_ConditionalView.this).getRface())) && (TextUtils.isEmpty(HouseList_ConditionalView.d(HouseList_ConditionalView.this).getHface())) && (TextUtils.isEmpty(HouseList_ConditionalView.d(HouseList_ConditionalView.this).getBedroom().getValue())) && (TextUtils.isEmpty(HouseList_ConditionalView.d(HouseList_ConditionalView.this).getFeature())) && (TextUtils.isEmpty(HouseList_ConditionalView.d(HouseList_ConditionalView.this).getArea())) && (TextUtils.isEmpty(HouseList_ConditionalView.d(HouseList_ConditionalView.this).getAround())) && (TextUtils.isEmpty(HouseList_ConditionalView.d(HouseList_ConditionalView.this).getVersion())) && (TextUtils.isEmpty(HouseList_ConditionalView.d(HouseList_ConditionalView.this).getStyle())) && (HouseList_ConditionalView.d(HouseList_ConditionalView.this).getMaxPrice() == 0) && (HouseList_ConditionalView.d(HouseList_ConditionalView.this).getMinPrice() == 0))
        {
          HouseList_ConditionalView.h(HouseList_ConditionalView.this).setTextColor(HouseList_ConditionalView.c(HouseList_ConditionalView.this).getResources().getColor(2131624415));
          if (!TextUtils.isEmpty(paramAnonymousString1)) {
            break label656;
          }
          HouseListActivity.a = "";
        }
        for (HouseListActivity.b = HouseList_ConditionalView.j(HouseList_ConditionalView.this)[0];; HouseListActivity.b = paramAnonymousString2)
        {
          if (paramAnonymousHashSet != null) {
            HouseListActivity.c = paramAnonymousHashSet;
          }
          if (HouseList_ConditionalView.g(HouseList_ConditionalView.this) != null)
          {
            HouseList_ConditionalView.a(HouseList_ConditionalView.this, HouseList_ConditionalView.d(HouseList_ConditionalView.this));
            HouseList_ConditionalView.g(HouseList_ConditionalView.this).getData(HouseList_ConditionalView.d(HouseList_ConditionalView.this));
          }
          return;
          HouseList_ConditionalView.h(HouseList_ConditionalView.this).setTextColor(HouseList_ConditionalView.c(HouseList_ConditionalView.this).getResources().getColor(2131624588));
          break;
          label656:
          HouseListActivity.a = paramAnonymousString1;
        }
      }
    });
  }
  
  private void j()
  {
    if (this.k == null)
    {
      this.k = new CheckinDatePop(this.a);
      k();
    }
    if (this.k.isShowing()) {
      this.k.dismiss();
    }
    while ((this.f == null) || (this.f.getCheckin_date() == null)) {
      return;
    }
    this.k.show(this.o, this.f.getCheckin_date().getStart_date(), this.f.getCheckin_date().getEnd_date(), this.w, this.e[2].equals(this.o.getText().toString()));
  }
  
  private void k()
  {
    this.k.setPopDismisListener(new c()
    {
      public void onDismiss()
      {
        HouseList_ConditionalView.k(HouseList_ConditionalView.this).setSelected(false);
        HouseList_ConditionalView.a(HouseList_ConditionalView.this, -1);
      }
    });
    this.k.setOnSelectListener(new CheckinDatePop.a()
    {
      public void select(String paramAnonymousString)
      {
        if (HouseList_ConditionalView.g(HouseList_ConditionalView.this) != null)
        {
          HouseList_ConditionalView.d(HouseList_ConditionalView.this).setCheckin_date(paramAnonymousString);
          HouseList_ConditionalView.g(HouseList_ConditionalView.this).getData(HouseList_ConditionalView.d(HouseList_ConditionalView.this));
        }
        HouseList_ConditionalView.this.setTimeText(paramAnonymousString);
      }
    });
  }
  
  public void dismissAllPop()
  {
    if ((this.j != null) && (this.j.isShowing())) {
      this.j.dismiss();
    }
    if ((this.l != null) && (this.l.isShowing())) {
      this.l.dismiss();
    }
    if ((this.k != null) && (this.k.isShowing())) {
      this.k.dismiss();
    }
    if ((this.m != null) && (this.m.isShowing())) {
      this.m.dismiss();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Paint localPaint = new Paint(1);
    localPaint.setColor(Color.parseColor("#d1d1d1"));
    localPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawLine(0.0F, getMeasuredHeight() - this.b, getMeasuredWidth(), getMeasuredHeight(), localPaint);
  }
  
  public HashSet<Integer> getHouseTypeSet()
  {
    return this.i;
  }
  
  public void initState(SearchCondition paramSearchCondition)
  {
    int i1 = 1;
    this.d = -1;
    if (paramSearchCondition == null)
    {
      this.w = new SearchCondition();
      return;
    }
    this.w = paramSearchCondition;
    this.o.setSelected(false);
    paramSearchCondition = this.w.getCheckin_date();
    if (f.isNull(paramSearchCondition))
    {
      this.o.setText(this.e[2]);
      this.o.setTextColor(this.a.getResources().getColor(2131624415));
      this.p.setSelected(false);
      paramSearchCondition = this.e[0];
      a(this.w.getType(), this.w.getTypeSet());
      d.d("findHouse", "======mSearchCondition:" + this.w);
      this.n.setSelected(false);
      if (!ae.notNull(this.w.getKeywords())) {
        break label436;
      }
      this.n.setText(this.e[1]);
      this.n.setTextColor(this.a.getResources().getColor(2131624415));
      label199:
      if ((this.w.getTypeSet() != null) && (this.w.getTypeSet().size() != 2)) {
        break label654;
      }
      i1 = 3;
    }
    for (;;)
    {
      switch (i1)
      {
      default: 
        label225:
        if ((TextUtils.isEmpty(this.w.getLeasetype())) && (TextUtils.isEmpty(this.w.getFeature())) && (TextUtils.isEmpty(this.w.getAround())) && (TextUtils.isEmpty(this.w.getHface())) && (TextUtils.isEmpty(this.w.getTags()))) {
          this.q.setTextColor(this.a.getResources().getColor(2131624415));
        }
        break;
      }
      for (;;)
      {
        if ((this.w.getMinPrice() != 0) || (this.w.getMaxPrice() != 0)) {
          this.q.setTextColor(this.a.getResources().getColor(2131624588));
        }
        this.q.setSelected(false);
        return;
        this.g = paramSearchCondition;
        this.o.setText("" + this.g);
        this.o.setTextColor(this.a.getResources().getColor(2131624588));
        break;
        label436:
        if (ae.notNull(this.w.getSubwayName()))
        {
          if ("不限".equals(this.w.getSubwayName())) {
            this.n.setText(this.w.getSubway_line());
          }
          for (;;)
          {
            this.n.setTextColor(this.a.getResources().getColor(2131624588));
            break;
            this.n.setText(this.w.getSubwayName());
          }
        }
        if ((!TextUtils.isEmpty(this.w.getBizcircle_code())) || (ae.notNull(this.w.getDistrict())))
        {
          if ("不限".equals(this.w.getBizcircle().getTitle())) {
            this.n.setText(this.w.getDistrictName());
          }
          for (;;)
          {
            this.n.setTextColor(this.a.getResources().getColor(2131624588));
            break;
            this.n.setText(this.w.getBizcircle().getTitle());
          }
        }
        this.n.setText(this.e[1]);
        this.n.setTextColor(this.a.getResources().getColor(2131624415));
        break label199;
        label654:
        if (this.w.getTypeSet().contains(Integer.valueOf(1))) {
          break label225;
        }
        if (!this.w.getTypeSet().contains(Integer.valueOf(2))) {
          break label988;
        }
        i1 = 2;
        break label225;
        if ((TextUtils.isEmpty(this.w.getLeasetype())) && (TextUtils.isEmpty(this.w.getFeature())) && (TextUtils.isEmpty(this.w.getAround())) && (TextUtils.isEmpty(this.w.getBedroom().getValue())) && (TextUtils.isEmpty(this.w.getRface())) && (TextUtils.isEmpty(this.w.getTags())) && (TextUtils.isEmpty(this.w.getVersion())))
        {
          this.q.setTextColor(this.a.getResources().getColor(2131624415));
        }
        else
        {
          this.q.setTextColor(this.a.getResources().getColor(2131624588));
          continue;
          if ((TextUtils.isEmpty(this.w.getLeasetype())) && (TextUtils.isEmpty(this.w.getFeature())) && (TextUtils.isEmpty(this.w.getAround())) && (TextUtils.isEmpty(this.w.getArea())) && (TextUtils.isEmpty(this.w.getHface())) && (TextUtils.isEmpty(this.w.getTags())) && (TextUtils.isEmpty(this.w.getVersion())))
          {
            this.q.setTextColor(this.a.getResources().getColor(2131624415));
          }
          else
          {
            this.q.setTextColor(this.a.getResources().getColor(2131624588));
            continue;
            this.q.setTextColor(this.a.getResources().getColor(2131624588));
          }
        }
      }
      label988:
      i1 = 3;
    }
  }
  
  public boolean isPopShowing()
  {
    return ((this.j != null) && (this.j.isShowing())) || ((this.l != null) && (this.l.isShowing())) || ((this.k != null) && (this.k.isShowing())) || ((this.m != null) && (this.m.isShowing()));
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.f == null) {
      g.textToast(this.a, "服务器异常，正在努力抢修中，请稍后再试!");
    }
    String str;
    do
    {
      return;
      str = paramView.getTag().toString();
      u.i("onclick", str + "123");
      int i1 = 0;
      while (i1 < getChildCount())
      {
        getChildAt(i1).setSelected(false);
        i1 += 1;
      }
      paramView = (TextView)paramView;
      if (this.e[0].equals(str))
      {
        b(paramView);
        com.ziroom.ziroomcustomer.a.a.onClickEvent("searchlist_area_product", "", com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode(), "");
        w.onEventToZiroomAndUmeng("5joint_entire");
        return;
      }
      if (this.e[1].equals(str))
      {
        d(paramView);
        com.ziroom.ziroomcustomer.a.a.onClickEvent("searchlist_area_station", "", com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode(), "");
        w.onEventToZiroomAndUmeng("5location");
        return;
      }
      if (this.e[2].equals(str))
      {
        c(paramView);
        com.ziroom.ziroomcustomer.a.a.onClickEvent("searchlist_area_date", "", com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode(), "");
        w.onEventToZiroomAndUmeng("5rent");
        return;
      }
    } while (!this.e[3].equals(str));
    a(paramView);
    w.onEventToZiroomAndUmeng("5all_filter");
  }
  
  public void setDataListener(a parama)
  {
    this.x = parama;
  }
  
  public void setIsMapActivity(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void setSearchCondition(SearchCondition paramSearchCondition)
  {
    SelectBean localSelectBean;
    String str;
    if (this.w == null)
    {
      this.w = new SearchCondition();
      paramSearchCondition = this.w.getClat();
      localSelectBean = this.w.getBizcircle();
      str = this.w.getSubway();
      if (TextUtils.isEmpty(paramSearchCondition)) {
        break label68;
      }
      this.n.setText("附近");
    }
    label68:
    do
    {
      return;
      this.w = paramSearchCondition;
      break;
      if (!TextUtils.isEmpty(str))
      {
        this.n.setText(str);
        return;
      }
    } while ((localSelectBean == null) || (TextUtils.isEmpty(localSelectBean.getTitle())));
    this.n.setText(localSelectBean.getTitle());
  }
  
  public void setSelectStyle(int paramInt, TextView paramTextView)
  {
    switch (this.d)
    {
    }
    while (this.d == paramInt)
    {
      this.d = -1;
      paramTextView.setSelected(false);
      return;
      if ((paramInt != 0) && (this.l != null) && (this.l.isShowing()))
      {
        this.l.dismiss();
        continue;
        if ((paramInt != 1) && (this.j != null) && (this.j.isShowing()))
        {
          this.j.dismiss();
          continue;
          if ((paramInt != 2) && (this.k != null) && (this.k.isShowing()))
          {
            this.k.dismiss();
            continue;
            if ((paramInt != 3) && (this.m != null) && (this.m.isShowing())) {
              this.m.dismiss();
            }
          }
        }
      }
    }
    this.d = paramInt;
    paramTextView.setSelected(true);
  }
  
  public void setSelection(SelectCondition paramSelectCondition)
  {
    this.f = paramSelectCondition;
  }
  
  public void setTimeText(String paramString)
  {
    this.o.setSelected(false);
    if (f.isNull(paramString))
    {
      this.o.setText(this.e[2]);
      this.o.setTextColor(this.a.getResources().getColor(2131624415));
      return;
    }
    this.g = paramString;
    this.o.setText("" + this.g);
    this.o.setTextColor(this.a.getResources().getColor(2131624588));
  }
  
  public void showArea(int paramInt)
  {
    setSelectStyle(1, this.n);
    if (this.j == null)
    {
      this.j = new HouseList_Pop_Area(this.a);
      this.j.setIsMapActivity(this.r);
      e();
    }
    if (this.j.isShowing())
    {
      this.j.dismiss();
      return;
    }
    this.j.showAsDropDown(this.n, paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void getData(SearchCondition paramSearchCondition);
  }
  
  public class b
    implements BDLocationListener
  {
    public b() {}
    
    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      VdsAgent.onReceiveLocation(this, paramBDLocation);
      if (paramBDLocation == null) {}
      do
      {
        return;
        HouseList_ConditionalView.a(HouseList_ConditionalView.this, paramBDLocation.getLongitude() + "");
        HouseList_ConditionalView.b(HouseList_ConditionalView.this, paramBDLocation.getLatitude() + "");
      } while ((HouseList_ConditionalView.a(HouseList_ConditionalView.this) == null) || (!HouseList_ConditionalView.a(HouseList_ConditionalView.this).isStarted()));
      HouseList_ConditionalView.a(HouseList_ConditionalView.this).stop();
      HouseList_ConditionalView.a(HouseList_ConditionalView.this, null);
    }
    
    public void onReceivePoi(BDLocation paramBDLocation) {}
  }
  
  public static abstract interface c
  {
    public abstract void onDismiss();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/widget/HouseList_ConditionalView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */