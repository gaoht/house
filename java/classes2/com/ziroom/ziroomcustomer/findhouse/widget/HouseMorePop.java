package com.ziroom.ziroomcustomer.findhouse.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar.a;
import com.ziroom.ziroomcustomer.findhouse.a;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.model.rent.PriceLimit;
import com.ziroom.ziroomcustomer.widget.FourItemLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HouseMorePop
  extends PopupWindow
  implements View.OnClickListener
{
  private FourItemLayout A;
  private FourItemLayout B;
  private LinearLayout C;
  private String D = "";
  private RangeBar E;
  private TextView F;
  private List<SelectBean> G;
  private int H;
  private int I;
  private PriceLimit J;
  private int K = 0;
  private int L = 101;
  private a M;
  private HouseList_ConditionalView.c N;
  CompoundButton.OnCheckedChangeListener a = new CompoundButton.OnCheckedChangeListener()
  {
    @Instrumented
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
      if ((paramAnonymousBoolean) && (HouseMorePop.g(HouseMorePop.this).getChildCount() > 0))
      {
        int i = 0;
        while (i < HouseMorePop.g(HouseMorePop.this).getChildCount())
        {
          CheckBox localCheckBox = (CheckBox)HouseMorePop.g(HouseMorePop.this).getChildAt(i);
          if (!paramAnonymousCompoundButton.getTag().equals(localCheckBox.getTag())) {
            localCheckBox.setChecked(false);
          }
          i += 1;
        }
      }
    }
  };
  CompoundButton.OnCheckedChangeListener b = new CompoundButton.OnCheckedChangeListener()
  {
    @Instrumented
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
      if ((paramAnonymousBoolean) && (HouseMorePop.h(HouseMorePop.this).getChildCount() > 0))
      {
        int i = 0;
        while (i < HouseMorePop.h(HouseMorePop.this).getChildCount())
        {
          CheckBox localCheckBox = (CheckBox)HouseMorePop.h(HouseMorePop.this).getChildAt(i);
          if (!paramAnonymousCompoundButton.getTag().equals(localCheckBox.getTag())) {
            localCheckBox.setChecked(false);
          }
          i += 1;
        }
      }
    }
  };
  CompoundButton.OnCheckedChangeListener c = new CompoundButton.OnCheckedChangeListener()
  {
    @Instrumented
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
      if ((paramAnonymousBoolean) && (HouseMorePop.i(HouseMorePop.this).getChildCount() > 0))
      {
        int i = 0;
        while (i < HouseMorePop.i(HouseMorePop.this).getChildCount())
        {
          CheckBox localCheckBox = (CheckBox)HouseMorePop.i(HouseMorePop.this).getChildAt(i);
          if (!paramAnonymousCompoundButton.getTag().equals(localCheckBox.getTag())) {
            localCheckBox.setChecked(false);
          }
          i += 1;
        }
      }
    }
  };
  CompoundButton.OnCheckedChangeListener d = new CompoundButton.OnCheckedChangeListener()
  {
    @Instrumented
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
      if ((paramAnonymousBoolean) && (HouseMorePop.j(HouseMorePop.this).getChildCount() > 0))
      {
        int i = 0;
        while (i < HouseMorePop.j(HouseMorePop.this).getChildCount())
        {
          CheckBox localCheckBox = (CheckBox)HouseMorePop.j(HouseMorePop.this).getChildAt(i);
          if (!paramAnonymousCompoundButton.getTag().equals(localCheckBox.getTag())) {
            localCheckBox.setChecked(false);
          }
          i += 1;
        }
      }
    }
  };
  CompoundButton.OnCheckedChangeListener e = new CompoundButton.OnCheckedChangeListener()
  {
    @Instrumented
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      int j = 0;
      VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
      int k = HouseMorePop.k(HouseMorePop.this).getChildCount();
      HouseMorePop.l(HouseMorePop.this).removeAllViews();
      HouseMorePop.a(HouseMorePop.this, "");
      if (paramAnonymousBoolean)
      {
        int i;
        if (k > 0)
        {
          i = 0;
          while (i < k)
          {
            CheckBox localCheckBox = (CheckBox)HouseMorePop.k(HouseMorePop.this).getChildAt(i);
            if (!paramAnonymousCompoundButton.getTag().equals(localCheckBox.getTag())) {
              localCheckBox.setChecked(false);
            }
            i += 1;
          }
        }
        if (HouseMorePop.m(HouseMorePop.this) != null)
        {
          i = j;
          if (HouseMorePop.m(HouseMorePop.this).size() >= 1) {
            break label132;
          }
        }
        for (;;)
        {
          return;
          label132:
          while (i < k)
          {
            if (((CheckBox)HouseMorePop.k(HouseMorePop.this).getChildAt(i)).isChecked())
            {
              if (a.getHouseClassify(HouseMorePop.n(HouseMorePop.this).getTypeSet()) == 10) {
                HouseMorePop.a(HouseMorePop.this, ((SelectBean)HouseMorePop.o(HouseMorePop.this).getVersion1().get(i)).getTitle());
              }
              HouseMorePop.a(HouseMorePop.this, ((SelectBean)HouseMorePop.m(HouseMorePop.this).get(i)).getChildren(), HouseMorePop.l(HouseMorePop.this));
            }
            i += 1;
          }
        }
      }
      HouseMorePop.l(HouseMorePop.this).removeAllViews();
    }
  };
  private Context f;
  private float g;
  private View h;
  private SelectCondition i;
  private SearchCondition j;
  private TextView k;
  private TextView l;
  private ScrollView m;
  private TextView n;
  private FourItemLayout o;
  private LinearLayout p;
  private LinearLayout q;
  private FourItemLayout r;
  private FourItemLayout s;
  private LinearLayout t;
  private FourItemLayout u;
  private LinearLayout v;
  private FourItemLayout w;
  private LinearLayout x;
  private FourItemLayout y;
  private LinearLayout z;
  
  public HouseMorePop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HouseMorePop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HouseMorePop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f = paramContext;
    this.g = this.f.getResources().getDisplayMetrics().density;
    if (Build.VERSION.SDK_INT >= 24) {
      setHeight(-2);
    }
    for (;;)
    {
      setWidth(-1);
      setSoftInputMode(16);
      setAnimationStyle(2131427934);
      this.h = LayoutInflater.from(paramContext).inflate(2130905046, null);
      a();
      return;
      setHeight(-1);
    }
  }
  
  private int a(int paramInt)
  {
    if ((this.J == null) || (this.J.getStep() < 1) || (paramInt == this.L - 1)) {
      i1 = 0;
    }
    do
    {
      do
      {
        return i1;
        i2 = this.J.getStep() * paramInt;
        i1 = i2;
      } while (this.J.getMid() <= 0);
      i1 = i2;
    } while (i2 <= this.J.getMid());
    int i1 = this.J.getMid() / this.J.getStep();
    int i2 = this.J.getStep();
    return c(paramInt - i1) + i2 * i1;
  }
  
  private CheckBox a(SelectBean paramSelectBean, ViewGroup paramViewGroup)
  {
    if (paramSelectBean == null) {
      return new CheckBox(this.f);
    }
    paramViewGroup = c(paramViewGroup);
    paramViewGroup.setText(paramSelectBean.getTitle());
    paramViewGroup.setTag(paramSelectBean);
    return paramViewGroup;
  }
  
  private void a()
  {
    this.m = ((ScrollView)this.h.findViewById(2131689709));
    this.p = ((LinearLayout)this.h.findViewById(2131697315));
    this.t = ((LinearLayout)this.h.findViewById(2131697310));
    this.v = ((LinearLayout)this.h.findViewById(2131697311));
    this.x = ((LinearLayout)this.h.findViewById(2131697306));
    this.z = ((LinearLayout)this.h.findViewById(2131697317));
    this.C = ((LinearLayout)this.h.findViewById(2131697312));
    this.q = ((LinearLayout)this.h.findViewById(2131697308));
    this.o = ((FourItemLayout)this.h.findViewById(2131697316));
    this.s = ((FourItemLayout)this.h.findViewById(2131696236));
    this.u = ((FourItemLayout)this.h.findViewById(2131695971));
    this.w = ((FourItemLayout)this.h.findViewById(2131696233));
    this.y = ((FourItemLayout)this.h.findViewById(2131695864));
    this.A = ((FourItemLayout)this.h.findViewById(2131696239));
    this.r = ((FourItemLayout)this.h.findViewById(2131694308));
    this.B = ((FourItemLayout)this.h.findViewById(2131697313));
    this.l = ((TextView)this.h.findViewById(2131691289));
    this.k = ((TextView)this.h.findViewById(2131693064));
    this.n = ((TextView)this.h.findViewById(2131697307));
    this.F = ((TextView)this.h.findViewById(2131697304));
    this.E = ((RangeBar)this.h.findViewById(2131696231));
    this.l.setOnClickListener(this);
    this.k.setOnClickListener(this);
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (HouseMorePop.a(HouseMorePop.this) != null) {
          HouseMorePop.a(HouseMorePop.this).onDismiss();
        }
      }
    });
    setContentView(this.h);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    int i1 = 0;
    if (i1 < paramViewGroup.getChildCount())
    {
      if ((paramViewGroup.getChildAt(i1) instanceof CheckBox)) {
        ((CheckBox)paramViewGroup.getChildAt(i1)).setChecked(false);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if ((paramViewGroup.getChildAt(i1) instanceof RadioButton)) {
          ((RadioButton)paramViewGroup.getChildAt(i1)).setChecked(false);
        }
      }
    }
  }
  
  private void a(String paramString, ViewGroup paramViewGroup)
  {
    if ((paramViewGroup.getChildCount() < 1) || (paramString == null)) {}
    for (;;)
    {
      return;
      paramString = paramString.split("\\|");
      if ((paramString != null) && (paramString.length >= 1))
      {
        int i1 = 0;
        while (i1 < paramViewGroup.getChildCount())
        {
          View localView = paramViewGroup.getChildAt(i1);
          int i2 = 0;
          if (i2 < paramString.length)
          {
            SelectBean localSelectBean = (SelectBean)localView.getTag();
            if ((!TextUtils.isEmpty(paramString[i2])) && (paramString[i2].equals(localSelectBean.getValue())))
            {
              if (!(localView instanceof CheckBox)) {
                break label119;
              }
              ((CheckBox)localView).setChecked(true);
            }
            for (;;)
            {
              i2 += 1;
              break;
              label119:
              if ((localView instanceof RadioButton)) {
                ((RadioButton)localView).setChecked(true);
              }
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void a(List<SelectBean> paramList, ViewGroup paramViewGroup)
  {
    paramViewGroup.removeAllViews();
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramViewGroup.addView(a((SelectBean)paramList.next(), paramViewGroup));
      }
    }
  }
  
  private int b(int paramInt)
  {
    int i1 = this.J.getStep() * paramInt;
    if ((this.J.getMid() <= 0) || (i1 <= this.J.getMid())) {
      return i1;
    }
    i1 = this.J.getMid() / this.J.getStep();
    int i2 = this.J.getStep();
    return c(paramInt - i1) + i2 * i1;
  }
  
  private String b(ViewGroup paramViewGroup)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i1);
      if ((((localView instanceof CheckBox)) && (((CheckBox)localView).isChecked())) || (((localView instanceof RadioButton)) && (((RadioButton)localView).isChecked()))) {
        localStringBuilder.append(((SelectBean)localView.getTag()).getValue()).append("|");
      }
      i1 += 1;
    }
    if (localStringBuilder.length() == 0) {
      return "";
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  private void b()
  {
    switch (a.getHouseClassify(this.j.getTypeSet()))
    {
    }
    while (this.J == null)
    {
      this.E.setVisibility(8);
      return;
      this.J = this.i.getPrice1_limit();
      continue;
      this.J = this.i.getPrice2_limit();
      continue;
      this.J = this.i.getPrice_limit();
    }
    if (this.J.getMid() <= 0) {}
    for (this.L = (this.J.getMax() / this.J.getStep() + 1);; this.L = (this.J.getMid() / this.J.getStep() + this.J.getFast_seg() + 1))
    {
      if (this.L < 1) {
        this.L = 2;
      }
      this.E.setTickCount(this.L);
      this.K = b(this.L - 1);
      this.E.setOnRangeBarChangeListener(new RangeBar.a()
      {
        public void onIndexChangeListener(RangeBar paramAnonymousRangeBar, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          int i = HouseMorePop.a(HouseMorePop.this, paramAnonymousInt1);
          paramAnonymousInt2 = HouseMorePop.a(HouseMorePop.this, paramAnonymousInt2);
          HouseMorePop.b(HouseMorePop.this, i);
          HouseMorePop.c(HouseMorePop.this, paramAnonymousInt2);
          if (paramAnonymousInt1 == HouseMorePop.b(HouseMorePop.this) - 1)
          {
            HouseMorePop.d(HouseMorePop.this).setText("¥" + HouseMorePop.c(HouseMorePop.this) + "元以上");
            return;
          }
          if ((HouseMorePop.e(HouseMorePop.this) == 0) && (HouseMorePop.f(HouseMorePop.this) == 0))
          {
            HouseMorePop.d(HouseMorePop.this).setText("不限");
            return;
          }
          if (HouseMorePop.f(HouseMorePop.this) == 0)
          {
            HouseMorePop.d(HouseMorePop.this).setText("¥" + paramAnonymousInt2 + "元以下");
            return;
          }
          if (HouseMorePop.e(HouseMorePop.this) != 0)
          {
            HouseMorePop.d(HouseMorePop.this).setText("¥" + i + " - " + paramAnonymousInt2 + "元");
            return;
          }
          HouseMorePop.d(HouseMorePop.this).setText("¥" + i + "元以上");
        }
      });
      return;
    }
  }
  
  private void b(List<SelectBean> paramList, ViewGroup paramViewGroup)
  {
    this.A.removeAllViews();
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CheckBox localCheckBox = a((SelectBean)paramList.next(), paramViewGroup);
        this.A.addView(localCheckBox);
      }
    }
  }
  
  private int c(int paramInt)
  {
    int i2 = 0;
    int i3 = this.J.getStep();
    int i1 = 0;
    while (i2 < paramInt)
    {
      i3 += this.J.getDiff();
      i1 += i3;
      i2 += 1;
    }
    return i1;
  }
  
  private CheckBox c(ViewGroup paramViewGroup)
  {
    CheckBox localCheckBox = new CheckBox(this.f);
    localCheckBox.setTextSize(2, 14.0F);
    localCheckBox.setButtonDrawable(2131624576);
    localCheckBox.setGravity(17);
    localCheckBox.setSingleLine(true);
    localCheckBox.setSingleLine(true);
    localCheckBox.setEllipsize(null);
    localCheckBox.setBackgroundResource(2130839489);
    localCheckBox.setTextColor(this.f.getResources().getColorStateList(2131624647));
    int i1 = (int)(8.0F * this.g);
    int i2 = (int)(this.g * 1.0F);
    localCheckBox.setPadding(i2, i1, i2, i1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.leftMargin = i1;
    localLayoutParams.rightMargin = i1;
    localCheckBox.setLayoutParams(localLayoutParams);
    localCheckBox.setIncludeFontPadding(false);
    if ("ll_leasetype".equals(paramViewGroup.getTag())) {
      localCheckBox.setOnCheckedChangeListener(this.a);
    }
    do
    {
      return localCheckBox;
      if ("ll_version".equals(paramViewGroup.getTag()))
      {
        localCheckBox.setOnCheckedChangeListener(this.e);
        return localCheckBox;
      }
    } while (!"ll_tags".equals(paramViewGroup.getTag()));
    localCheckBox.setOnCheckedChangeListener(this.d);
    return localCheckBox;
  }
  
  private void c()
  {
    this.G = new ArrayList();
    switch (a.getHouseClassify(this.j.getTypeSet()))
    {
    }
    for (;;)
    {
      this.B.removeAllViews();
      this.D = this.j.getChildVersionIndex();
      if ((this.G == null) || (this.G.size() <= 0)) {
        return;
      }
      int i1 = 0;
      while (i1 < this.G.size())
      {
        if ((!TextUtils.isEmpty(this.D)) && (this.D.equals(((SelectBean)this.G.get(i1)).getTitle()))) {
          a(((SelectBean)this.G.get(i1)).getChildren(), this.B);
        }
        i1 += 1;
      }
      this.G.addAll(this.i.getVersion1());
      continue;
      this.G.clear();
      continue;
      this.G.clear();
    }
    b(this.G, this.A);
  }
  
  private int d(int paramInt)
  {
    if ((this.J == null) || (paramInt < 0)) {
      return 0;
    }
    if ((this.J.getMid() <= 0) || (paramInt <= this.J.getMid())) {
      return paramInt / this.J.getStep();
    }
    int i4 = this.J.getMid() / this.J.getStep();
    int i5 = this.J.getStep();
    int i3 = this.J.getStep();
    int i1 = 1;
    int i2 = 0;
    if (i1 < 1000)
    {
      i3 += this.J.getDiff();
      i2 += i3;
      if (i2 < paramInt - i5 * i4) {}
    }
    for (;;)
    {
      if (i4 + i1 > this.L - 1)
      {
        return this.L - 1;
        i1 += 1;
        break;
      }
      return i4 + i1;
      i1 = 0;
    }
  }
  
  private List<SelectBean> d(ViewGroup paramViewGroup)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramViewGroup.getChildCount())
    {
      CompoundButton localCompoundButton = (CompoundButton)paramViewGroup.getChildAt(i1);
      if (localCompoundButton.isChecked()) {
        localArrayList.add((SelectBean)localCompoundButton.getTag());
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  private void d()
  {
    a(this.o);
    a(this.s);
    a(this.u);
    a(this.w);
    a(this.y);
    a(this.A);
    a(this.B);
    a(this.r);
    this.D = "";
    this.E.setThumbIndices(0, this.L - 1);
  }
  
  private void e()
  {
    int i2 = a.getHouseClassify(this.j.getTypeSet());
    switch (i2)
    {
    default: 
      this.j.setAround(b(this.u));
      this.j.setFeature(b(this.s));
      this.j.setLeasetype(b(this.o));
      this.j.setTags(b(this.y));
      this.j.setAroundBeanList(d(this.u));
      this.j.setFeatureBeanList(d(this.s));
      this.j.setLeaseTypeBeanList(d(this.o));
      this.j.setTagsBeanList(d(this.y));
      this.j.setMinPrice(this.H);
      this.j.setMaxPrice(this.I);
      if ((this.H == 0) && (this.I == 0)) {
        break;
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (this.M != null) {}
      switch (i2)
      {
      default: 
        return;
        this.j.setFace("");
        this.j.setHface("");
        this.j.setArea("");
        SelectBean localSelectBean = new SelectBean();
        this.j.setBedroom(localSelectBean);
        this.j.setRface(b(this.w));
        this.j.setVersion(b(this.A));
        this.j.setStyle(b(this.B));
        this.j.setFaceBeanList(new ArrayList());
        this.j.sethFaceBeanList(new ArrayList());
        this.j.setAreaBeanList(new ArrayList());
        this.j.setrFaceBeanList(d(this.w));
        this.j.setVersionBeanList(d(this.A));
        this.j.setStyleBeanList(d(this.B));
        break;
        this.j.setFace("");
        this.j.setRface("");
        this.j.setBedroom(new SelectBean());
        this.j.setHface(b(this.w));
        this.j.setArea(b(this.r));
        this.j.setVersion(b(this.A));
        this.j.setStyle(b(this.B));
        this.j.setFaceBeanList(new ArrayList());
        this.j.setrFaceBeanList(new ArrayList());
        this.j.sethFaceBeanList(d(this.w));
        this.j.setAreaBeanList(d(this.r));
        this.j.setVersionBeanList(d(this.A));
        this.j.setStyleBeanList(d(this.B));
        break;
        this.j.setRface("");
        this.j.setHface("");
        this.j.setArea("");
        this.j.setBedroom(new SelectBean());
        this.j.setVersion("");
        this.j.setStyle("");
        this.j.setFace(b(this.w));
        this.j.setFaceBeanList(d(this.w));
        this.j.setrFaceBeanList(new ArrayList());
        this.j.sethFaceBeanList(new ArrayList());
        this.j.setAreaBeanList(new ArrayList());
        this.j.setStyleBeanList(new ArrayList());
        break;
      case 10: 
        if ((TextUtils.isEmpty(this.j.getLeasetype())) && (TextUtils.isEmpty(this.j.getFeature())) && (TextUtils.isEmpty(this.j.getBedroom().getValue())) && (TextUtils.isEmpty(this.j.getRface())) && (TextUtils.isEmpty(this.j.getTags())) && (TextUtils.isEmpty(this.j.getAround())) && (TextUtils.isEmpty(this.j.getVersion())) && (i1 == 0))
        {
          this.M.select(false);
          return;
        }
        this.M.select(true);
        return;
      case 20: 
        if ((TextUtils.isEmpty(this.j.getLeasetype())) && (TextUtils.isEmpty(this.j.getFeature())) && (TextUtils.isEmpty(this.j.getAround())) && (TextUtils.isEmpty(this.j.getArea())) && (TextUtils.isEmpty(this.j.getHface())) && (TextUtils.isEmpty(this.j.getTags())) && (TextUtils.isEmpty(this.j.getVersion())) && (i1 == 0))
        {
          this.M.select(false);
          return;
        }
        this.M.select(true);
        return;
      case 100: 
        if ((TextUtils.isEmpty(this.j.getLeasetype())) && (TextUtils.isEmpty(this.j.getFeature())) && (TextUtils.isEmpty(this.j.getAround())) && (TextUtils.isEmpty(this.j.getFace())) && (TextUtils.isEmpty(this.j.getTags())) && (i1 == 0))
        {
          this.M.select(false);
          return;
        }
        this.M.select(true);
        return;
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
      return;
    case 2131691289: 
      e();
      dismiss();
      return;
    }
    d();
  }
  
  public void setOnSelectListener(a parama)
  {
    this.M = parama;
  }
  
  public void setPopDismisListener(HouseList_ConditionalView.c paramc)
  {
    this.N = paramc;
  }
  
  public void show(View paramView, SelectCondition paramSelectCondition, SearchCondition paramSearchCondition)
  {
    if ((paramSelectCondition == null) || (paramSearchCondition == null)) {
      return;
    }
    this.m.scrollTo(0, 0);
    this.i = paramSelectCondition;
    this.j = paramSearchCondition;
    this.o.removeAllViews();
    this.s.removeAllViews();
    this.u.removeAllViews();
    this.w.removeAllViews();
    this.y.removeAllViews();
    this.r.removeAllViews();
    this.r.setChildTextLength(8);
    this.A.removeAllViews();
    this.B.removeAllViews();
    this.o.setTag("ll_leasetype");
    this.A.setTag("ll_version");
    this.y.setTag("ll_tags");
    this.r.setTag("ll_area");
    int i1;
    int i2;
    switch (a.getHouseClassify(this.j.getTypeSet()))
    {
    default: 
      b();
      i1 = this.j.getMinPrice();
      i2 = this.j.getMaxPrice();
      if ((i1 == 0) && (i2 == 0)) {
        this.E.setThumbIndices(0, this.L - 1);
      }
      break;
    }
    for (;;)
    {
      this.H = i1;
      this.I = i2;
      if ((this instanceof PopupWindow)) {
        break label952;
      }
      showAsDropDown(paramView, 0, 0);
      return;
      this.C.setVisibility(0);
      this.q.setVisibility(8);
      this.n.setText("房源朝向");
      a(this.i.getLeasetype(), this.o);
      a(this.i.getFeature1(), this.s);
      a(this.i.getAround(), this.u);
      a(this.i.getRface1(), this.w);
      a(this.i.getTag(), this.y);
      b(this.i.getVersion1(), this.A);
      c();
      a(this.j.getLeasetype(), this.o);
      a(this.j.getFeature(), this.s);
      a(this.j.getAround(), this.u);
      a(this.j.getRface(), this.w);
      a(this.j.getTags(), this.y);
      a(this.j.getVersion(), this.A);
      a(this.j.getStyle(), this.B);
      break;
      this.C.setVisibility(8);
      this.q.setVisibility(0);
      this.n.setText("房源朝向");
      a(this.i.getLeasetype(), this.o);
      a(this.i.getFeature2(), this.s);
      a(this.i.getAround(), this.u);
      a(this.i.getHface2(), this.w);
      a(this.i.getTag(), this.y);
      a(this.i.getArea2(), this.r);
      c();
      a(this.j.getLeasetype(), this.o);
      a(this.j.getArea(), this.r);
      a(this.j.getFeature(), this.s);
      a(this.j.getAround(), this.u);
      a(this.j.getHface(), this.w);
      a(this.j.getTags(), this.y);
      a(this.j.getVersion(), this.A);
      a(this.j.getStyle(), this.B);
      break;
      this.C.setVisibility(8);
      this.q.setVisibility(8);
      this.n.setText("房源朝向");
      a(this.i.getLeasetype(), this.o);
      a(this.i.getFeature(), this.s);
      a(this.i.getAround(), this.u);
      a(this.i.getFace(), this.w);
      a(this.i.getTag(), this.y);
      a(this.j.getLeasetype(), this.o);
      a(this.j.getFeature(), this.s);
      a(this.j.getAround(), this.u);
      a(this.j.getFace(), this.w);
      a(this.j.getTags(), this.y);
      break;
      if (i2 == 0) {
        this.E.setThumbIndices(d(i1), this.L - 1);
      } else {
        this.E.setThumbIndices(d(i1), d(i2));
      }
    }
    label952:
    VdsAgent.showAsDropDown((PopupWindow)this, paramView, 0, 0);
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
  
  public static abstract interface a
  {
    public abstract void select(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/widget/HouseMorePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */