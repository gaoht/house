package com.ziroom.ziroomcustomer.findhouse.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar.a;
import com.ziroom.ziroomcustomer.findhouse.a;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition.SelectType;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition.TypeExtra;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.model.rent.PriceLimit;
import com.ziroom.ziroomcustomer.widget.AverageItemLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HousemapFilterDialog
  extends DialogFragment
{
  Unbinder a;
  private Context b;
  private View c;
  private float d;
  private SelectCondition e;
  private SearchCondition f = new SearchCondition();
  private List<AverageItemLayout> g = new ArrayList();
  private int h;
  private int i;
  private PriceLimit j;
  private int k = 0;
  private int l = 101;
  private c m = c.c;
  @BindView(2131696235)
  AverageItemLayout mAilArea;
  @BindView(2131696238)
  AverageItemLayout mAilAround;
  @BindView(2131696234)
  AverageItemLayout mAilFace;
  @BindView(2131696237)
  AverageItemLayout mAilFeature;
  @BindView(2131696223)
  AverageItemLayout mAilHouseTypeHZ;
  @BindView(2131696229)
  AverageItemLayout mAilHouseTypeLuxury;
  @BindView(2131696227)
  AverageItemLayout mAilHouseTypeYZ;
  @BindView(2131696225)
  AverageItemLayout mAilHouseTypeZZ;
  @BindView(2131696243)
  AverageItemLayout mAilLeaseType;
  @BindView(2131696232)
  AverageItemLayout mAilPrice;
  @BindView(2131696221)
  AverageItemLayout mAilRapid;
  @BindView(2131696245)
  AverageItemLayout mAilTags;
  @BindView(2131696240)
  AverageItemLayout mAilVersion1;
  @BindView(2131696241)
  AverageItemLayout mAilVersion2;
  @BindView(2131694308)
  LinearLayout mLlArea;
  @BindView(2131695971)
  LinearLayout mLlAround;
  @BindView(2131696233)
  LinearLayout mLlFace;
  @BindView(2131696236)
  LinearLayout mLlFeature;
  @BindView(2131696244)
  LinearLayout mLlHouseStatus;
  @BindView(2131696222)
  LinearLayout mLlHouseTypeHZ;
  @BindView(2131696228)
  LinearLayout mLlHouseTypeLuxury;
  @BindView(2131696226)
  LinearLayout mLlHouseTypeYZ;
  @BindView(2131696224)
  LinearLayout mLlHouseTypeZZ;
  @BindView(2131692948)
  LinearLayout mLlPrice;
  @BindView(2131696242)
  LinearLayout mLlRentType;
  @BindView(2131696239)
  LinearLayout mLlVersion;
  @BindView(2131696231)
  RangeBar mRangebarPrice;
  @BindView(2131696230)
  TextView mTvHousemapPrice;
  @BindView(2131691289)
  TextView mTvOk;
  @BindView(2131693064)
  TextView mTvReset;
  private HashSet<Integer> n = new HashSet();
  private Handler o = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      b.setViewSelecet(HousemapFilterDialog.k(HousemapFilterDialog.this).getStyle(), HousemapFilterDialog.this.mAilVersion2);
    }
  };
  private a p;
  
  private int a(int paramInt)
  {
    if ((this.j == null) || (this.j.getStep() < 1) || (paramInt == this.l - 1)) {
      i1 = 0;
    }
    do
    {
      do
      {
        return i1;
        i2 = this.j.getStep() * paramInt;
        i1 = i2;
      } while (this.j.getMid() <= 0);
      i1 = i2;
    } while (i2 <= this.j.getMid());
    int i1 = this.j.getMid() / this.j.getStep();
    int i2 = this.j.getStep();
    return c(paramInt - i1) + i2 * i1;
  }
  
  private List<SelectBean> a(ViewGroup paramViewGroup)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramViewGroup.getChildCount())
    {
      CompoundButton localCompoundButton = (CompoundButton)paramViewGroup.getChildAt(i1);
      if ((localCompoundButton.isChecked()) && ((localCompoundButton.getTag() instanceof SelectBean))) {
        localArrayList.add((SelectBean)localCompoundButton.getTag());
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  private void a()
  {
    getDialog().requestWindowFeature(1);
    getDialog().getWindow().setGravity(5);
    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    this.d = this.b.getResources().getDisplayMetrics().density;
    int i1 = this.b.getResources().getDisplayMetrics().widthPixels / 5;
    getDialog().getWindow().getDecorView().setPadding(0, 0, 0, 0);
    getDialog().getWindow().setLayout(i1 * 4, -1);
    getDialog().setCanceledOnTouchOutside(true);
    getDialog().setCancelable(true);
    getDialog().getWindow().setWindowAnimations(2131427783);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i3 = 0;
    if (i3 < this.mAilPrice.getChildCount())
    {
      CheckBox localCheckBox = (CheckBox)this.mAilPrice.getChildAt(i3);
      Object localObject = (SelectBean)localCheckBox.getTag();
      if (localObject == null) {}
      for (;;)
      {
        i3 += 1;
        break;
        localObject = ((SelectBean)localObject).getValue().split(",", 2);
        if ("".equals(localObject[0])) {
          localObject[0] = "0";
        }
        if ("".equals(localObject[1])) {
          localObject[1] = "0";
        }
        for (;;)
        {
          try
          {
            i1 = Integer.parseInt(localObject[0]);
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            try
            {
              int i5 = Integer.parseInt(localObject[1]);
              i2 = i5;
              i4 = i1;
              if (i5 == 0)
              {
                i2 = 0;
                i4 = i1;
              }
              if ((i4 != paramInt1) || (i2 != paramInt2)) {
                break label182;
              }
              localCheckBox.setChecked(true);
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              int i1;
              int i2;
              int i4;
              for (;;) {}
            }
            localNumberFormatException1 = localNumberFormatException1;
            i1 = 0;
          }
          Log.getStackTraceString(localNumberFormatException1);
          i2 = 0;
          i4 = i1;
        }
        label182:
        localCheckBox.setChecked(false);
      }
    }
  }
  
  private void a(final ViewGroup paramViewGroup, List<SelectBean> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        final SelectBean localSelectBean = (SelectBean)paramList.next();
        if (localSelectBean != null)
        {
          CheckBox localCheckBox = b.getCheckBox(this.b, 2130839468, 2131624647);
          localCheckBox.setText(localSelectBean.getTitle());
          localCheckBox.setTag(localSelectBean);
          paramViewGroup.addView(localCheckBox);
          localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
            @Instrumented
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
              VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
              b.clearSelect(paramViewGroup);
              if (paramAnonymousBoolean)
              {
                paramAnonymousCompoundButton.setChecked(true);
                HousemapFilterDialog.this.mAilVersion2.removeAllViews();
                if ((localSelectBean.getChildren() != null) && (localSelectBean.getChildren().size() > 0)) {
                  HousemapFilterDialog.a(HousemapFilterDialog.this, HousemapFilterDialog.this.mAilVersion2, localSelectBean.getChildren());
                }
                return;
              }
              HousemapFilterDialog.this.mAilVersion2.removeAllViews();
            }
          });
        }
      }
    }
  }
  
  private void a(SearchCondition paramSearchCondition)
  {
    if (paramSearchCondition == null) {
      return;
    }
    this.n = paramSearchCondition.getTypeSet();
    b.setViewSelecet(paramSearchCondition.getType(), this.mAilHouseTypeHZ);
    b.setViewSelecet(paramSearchCondition.getType(), this.mAilHouseTypeZZ);
    b.setViewSelecet(paramSearchCondition.getType(), this.mAilHouseTypeYZ);
    b.setViewSelecet(paramSearchCondition.getType(), this.mAilHouseTypeLuxury);
    e();
    c localc = d();
    this.h = this.f.getMinPrice();
    this.i = this.f.getMaxPrice();
    switch (6.a[localc.ordinal()])
    {
    }
    for (;;)
    {
      b.setViewSelecet(paramSearchCondition.getFace(), this.mAilFace);
      b.setViewSelecet(paramSearchCondition.getArea(), this.mAilArea);
      b.setViewSelecet(paramSearchCondition.getFeature(), this.mAilFeature);
      b.setViewSelecet(paramSearchCondition.getAround(), this.mAilAround);
      b.setViewSelecet(paramSearchCondition.getVersion(), this.mAilVersion1);
      b.setViewSelecet(paramSearchCondition.getLeasetype(), this.mAilLeaseType);
      b.setViewSelecet(paramSearchCondition.getTags(), this.mAilTags);
      b.setViewSelecet(paramSearchCondition.getRapid(), this.mAilRapid);
      this.mAilVersion2.postDelayed(new Runnable()
      {
        public void run()
        {
          HousemapFilterDialog.j(HousemapFilterDialog.this).sendEmptyMessage(0);
        }
      }, 300L);
      b(paramSearchCondition);
      return;
      b.setViewSelecet(paramSearchCondition.getRface(), this.mAilFace);
      continue;
      b.setViewSelecet(paramSearchCondition.getHface(), this.mAilFace);
      continue;
      b.setViewSelecet(paramSearchCondition.getFace(), this.mAilFace);
    }
  }
  
  private int b(int paramInt)
  {
    int i1 = this.j.getStep() * paramInt;
    if ((this.j.getMid() <= 0) || (i1 <= this.j.getMid())) {
      return i1;
    }
    i1 = this.j.getMid() / this.j.getStep();
    int i2 = this.j.getStep();
    return c(paramInt - i1) + i2 * i1;
  }
  
  private void b()
  {
    this.a = ButterKnife.bind(this, this.c);
    c();
    this.n = this.f.getTypeSet();
    f();
    this.mAilRapid.removeAllViews();
    b(this.mAilRapid, this.e.getRapid());
    k();
  }
  
  private void b(ViewGroup paramViewGroup, List<SelectBean> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SelectBean localSelectBean = (SelectBean)paramList.next();
        if (localSelectBean != null)
        {
          CheckBox localCheckBox = b.getCheckBox(this.b, 2130839468, 2131624647);
          localCheckBox.setText(localSelectBean.getTitle());
          localCheckBox.setTag(localSelectBean);
          localCheckBox.setOnCheckedChangeListener(new d(null));
          paramViewGroup.addView(localCheckBox);
        }
      }
    }
  }
  
  private void b(SearchCondition paramSearchCondition)
  {
    if (paramSearchCondition == null) {
      return;
    }
    this.h = paramSearchCondition.getMinPrice();
    this.i = paramSearchCondition.getMaxPrice();
    int i2 = d(this.i);
    int i1 = i2;
    if (i2 == 0) {
      i1 = this.l - 1;
    }
    this.mRangebarPrice.setThumbIndices(d(this.h), i1);
    a(this.h, this.i);
  }
  
  private int c(int paramInt)
  {
    int i2 = 0;
    int i3 = this.j.getStep();
    int i1 = 0;
    while (i2 < paramInt)
    {
      i3 += this.j.getDiff();
      i1 += i3;
      i2 += 1;
    }
    return i1;
  }
  
  private void c()
  {
    if ((this.e == null) || (this.e.getType_extra() == null) || (this.e.getType_extra().size() < 1) || (this.e.getType() == null) || (this.e.getType().size() < 1))
    {
      this.mLlHouseTypeHZ.setVisibility(8);
      this.mLlHouseTypeZZ.setVisibility(8);
      this.mLlHouseTypeZZ.setVisibility(8);
    }
    this.g.clear();
    this.g.add(this.mAilHouseTypeHZ);
    this.g.add(this.mAilHouseTypeZZ);
    this.g.add(this.mAilHouseTypeYZ);
    this.g.add(this.mAilHouseTypeLuxury);
    if (this.g.size() > this.e.getType_extra().size())
    {
      i1 = 0;
      while (i1 < this.g.size())
      {
        if (i1 >= this.e.getType_extra().size()) {
          ((View)((AverageItemLayout)this.g.get(i1)).getParent()).setVisibility(8);
        }
        i1 += 1;
      }
    }
    int i1 = 0;
    while (i1 < this.e.getType_extra().size())
    {
      SelectCondition.TypeExtra localTypeExtra = (SelectCondition.TypeExtra)this.e.getType_extra().get(i1);
      ((TextView)((ViewGroup)((AverageItemLayout)this.g.get(i1)).getParent()).getChildAt(0)).setText(localTypeExtra.getTitle());
      int i2 = 0;
      while (i2 < this.e.getType().size())
      {
        SelectCondition.SelectType localSelectType = (SelectCondition.SelectType)this.e.getType().get(i2);
        if (localTypeExtra.getType() == localSelectType.getType())
        {
          CheckBox localCheckBox = b.getCheckBox(this.b, 2130839468, 2131624647);
          localCheckBox.setText(localSelectType.getTitle());
          localCheckBox.setTag(localSelectType);
          localCheckBox.setOnCheckedChangeListener(new b(null));
          ((AverageItemLayout)this.g.get(i1)).addView(localCheckBox);
        }
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  private int d(int paramInt)
  {
    if ((this.j == null) || (paramInt < 0)) {
      return 0;
    }
    if ((this.j.getMid() <= 0) || (paramInt <= this.j.getMid())) {
      return paramInt / this.j.getStep();
    }
    int i4 = this.j.getMid() / this.j.getStep();
    int i5 = this.j.getStep();
    int i3 = this.j.getStep();
    int i1 = 1;
    int i2 = 0;
    if (i1 < 1000)
    {
      i3 += this.j.getDiff();
      i2 += i3;
      if (i2 < paramInt - i5 * i4) {}
    }
    for (;;)
    {
      if (i4 + i1 > this.l - 1)
      {
        return this.l - 1;
        i1 += 1;
        break;
      }
      return i4 + i1;
      i1 = 0;
    }
  }
  
  private c d()
  {
    if (this.n.size() == 0) {
      return c.c;
    }
    if ((this.n.size() == 1) && (this.n.contains(Integer.valueOf(1)))) {
      return c.b;
    }
    if ((this.n.size() > 1) && (this.n.contains(Integer.valueOf(1)))) {
      return c.c;
    }
    return c.a;
  }
  
  private void e()
  {
    int i1 = 0;
    if (i1 < this.g.size())
    {
      Object localObject = (AverageItemLayout)this.g.get(i1);
      int i2 = 0;
      for (;;)
      {
        if (i2 < ((AverageItemLayout)localObject).getChildCount())
        {
          CheckBox localCheckBox = (CheckBox)((AverageItemLayout)localObject).getChildAt(i2);
          if (localCheckBox.isChecked())
          {
            localObject = (SelectCondition.SelectType)localCheckBox.getTag();
            this.n.add(Integer.valueOf(((SelectCondition.SelectType)localObject).getType()));
          }
        }
        else
        {
          i1 += 1;
          break;
        }
        i2 += 1;
      }
    }
  }
  
  private void f()
  {
    switch (6.a[this.m.ordinal()])
    {
    default: 
      return;
    case 1: 
      g();
      return;
    case 2: 
      h();
      return;
    }
    i();
  }
  
  private void g()
  {
    j();
    b(this.mAilPrice, this.e.getPrice1());
    k();
    this.mRangebarPrice.setThumbIndices(0, this.l - 1);
    b.clearSelect(this.mAilPrice);
    b(this.mAilFace, this.e.getRface1());
    this.mLlArea.setVisibility(8);
    b(this.mAilFeature, this.e.getFeature1());
    b(this.mAilAround, this.e.getAround());
    this.mLlVersion.setVisibility(0);
    a(this.mAilVersion1, this.e.getVersion1());
    b(this.mAilLeaseType, this.e.getLeasetype());
    b(this.mAilTags, this.e.getTag());
  }
  
  public static HousemapFilterDialog getInstance(Bundle paramBundle)
  {
    HousemapFilterDialog localHousemapFilterDialog = new HousemapFilterDialog();
    localHousemapFilterDialog.setArguments(paramBundle);
    return localHousemapFilterDialog;
  }
  
  private void h()
  {
    j();
    b(this.mAilPrice, this.e.getPrice2());
    k();
    this.mRangebarPrice.setThumbIndices(0, this.l - 1);
    b.clearSelect(this.mAilPrice);
    b(this.mAilFace, this.e.getHface2());
    b(this.mAilArea, this.e.getArea2());
    this.mLlArea.setVisibility(0);
    b(this.mAilFeature, this.e.getFeature2());
    b(this.mAilAround, this.e.getAround());
    this.mLlVersion.setVisibility(8);
    b(this.mAilLeaseType, this.e.getLeasetype());
    b(this.mAilTags, this.e.getTag());
  }
  
  private void i()
  {
    j();
    b(this.mAilPrice, this.e.getPrice());
    k();
    this.mRangebarPrice.setThumbIndices(0, this.l - 1);
    b.clearSelect(this.mAilPrice);
    b(this.mAilFace, this.e.getFace());
    this.mLlArea.setVisibility(8);
    b(this.mAilFeature, this.e.getFeature());
    b(this.mAilAround, this.e.getAround());
    this.mLlVersion.setVisibility(8);
    b(this.mAilLeaseType, this.e.getLeasetype());
    b(this.mAilTags, this.e.getTag());
  }
  
  private void j()
  {
    this.mAilPrice.removeAllViews();
    this.mAilFace.removeAllViews();
    this.mAilArea.removeAllViews();
    this.mAilFeature.removeAllViews();
    this.mAilAround.removeAllViews();
    this.mAilVersion1.removeAllViews();
    this.mAilVersion2.removeAllViews();
    this.mAilLeaseType.removeAllViews();
    this.mAilTags.removeAllViews();
  }
  
  private void k()
  {
    switch (a.getHouseClassify(this.f.getTypeSet()))
    {
    }
    while (this.j == null)
    {
      this.mRangebarPrice.setVisibility(8);
      return;
      this.j = this.e.getPrice1_limit();
      continue;
      this.j = this.e.getPrice2_limit();
      continue;
      this.j = this.e.getPrice_limit();
    }
    if (this.j.getMid() <= 0) {}
    for (this.l = (this.j.getMax() / this.j.getStep() + 1);; this.l = (this.j.getMid() / this.j.getStep() + this.j.getFast_seg() + 1))
    {
      if (this.l < 1) {
        this.l = 2;
      }
      this.mRangebarPrice.setTickCount(this.l);
      this.k = b(this.l - 1);
      this.mRangebarPrice.setOnRangeBarChangeListener(new RangeBar.a()
      {
        public void onIndexChangeListener(RangeBar paramAnonymousRangeBar, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          int i = HousemapFilterDialog.a(HousemapFilterDialog.this, paramAnonymousInt1);
          paramAnonymousInt2 = HousemapFilterDialog.a(HousemapFilterDialog.this, paramAnonymousInt2);
          HousemapFilterDialog.b(HousemapFilterDialog.this, i);
          HousemapFilterDialog.c(HousemapFilterDialog.this, paramAnonymousInt2);
          if (paramAnonymousInt1 == HousemapFilterDialog.f(HousemapFilterDialog.this) - 1) {
            HousemapFilterDialog.this.mTvHousemapPrice.setText("¥" + HousemapFilterDialog.g(HousemapFilterDialog.this) + "元以上");
          }
          for (;;)
          {
            HousemapFilterDialog.a(HousemapFilterDialog.this, i, paramAnonymousInt2);
            return;
            if ((HousemapFilterDialog.h(HousemapFilterDialog.this) == 0) && (HousemapFilterDialog.i(HousemapFilterDialog.this) == 0)) {
              HousemapFilterDialog.this.mTvHousemapPrice.setText("不限");
            } else if (HousemapFilterDialog.i(HousemapFilterDialog.this) == 0) {
              HousemapFilterDialog.this.mTvHousemapPrice.setText("¥" + paramAnonymousInt2 + "元以下");
            } else if (HousemapFilterDialog.h(HousemapFilterDialog.this) != 0) {
              HousemapFilterDialog.this.mTvHousemapPrice.setText("¥" + i + " - " + paramAnonymousInt2 + "元");
            } else {
              HousemapFilterDialog.this.mTvHousemapPrice.setText("¥" + i + "元以上");
            }
          }
        }
      });
      int i1 = 0;
      while (i1 < this.mAilPrice.getChildCount())
      {
        CheckBox localCheckBox = (CheckBox)this.mAilPrice.getChildAt(i1);
        localCheckBox.setTextSize(2, 12.0F);
        localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          @Instrumented
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
            if (paramAnonymousBoolean)
            {
              b.clearSelect(HousemapFilterDialog.this.mAilPrice);
              localObject = "";
              if (paramAnonymousCompoundButton.getTag() != null) {}
            }
            else
            {
              return;
            }
            if ((paramAnonymousCompoundButton.getTag() instanceof SelectBean)) {
              localObject = ((SelectBean)paramAnonymousCompoundButton.getTag()).getValue();
            }
            Object localObject = ((String)localObject).split(",", 2);
            if ("".equals(localObject[0])) {
              localObject[0] = "0";
            }
            if ("".equals(localObject[1])) {
              localObject[1] = "0";
            }
            int j = HousemapFilterDialog.h(HousemapFilterDialog.this);
            for (;;)
            {
              try
              {
                i = Integer.parseInt(localObject[0]);
                int k;
                int m;
                Log.getStackTraceString(localNumberFormatException1);
              }
              catch (NumberFormatException localNumberFormatException1)
              {
                try
                {
                  k = Integer.parseInt(localObject[1]);
                  j = k;
                  m = HousemapFilterDialog.d(HousemapFilterDialog.this, j);
                  k = m;
                  if (m == 0) {
                    k = HousemapFilterDialog.f(HousemapFilterDialog.this) - 1;
                  }
                  HousemapFilterDialog.this.mRangebarPrice.setThumbIndices(HousemapFilterDialog.d(HousemapFilterDialog.this, i), k);
                  HousemapFilterDialog.b(HousemapFilterDialog.this, i);
                  HousemapFilterDialog.c(HousemapFilterDialog.this, j);
                  if ((HousemapFilterDialog.h(HousemapFilterDialog.this) != 0) || (HousemapFilterDialog.i(HousemapFilterDialog.this) != 0)) {
                    break label251;
                  }
                  HousemapFilterDialog.this.mTvHousemapPrice.setText("不限");
                  paramAnonymousCompoundButton.setChecked(true);
                  return;
                }
                catch (NumberFormatException localNumberFormatException2)
                {
                  int i;
                  for (;;) {}
                }
                localNumberFormatException1 = localNumberFormatException1;
                i = 0;
              }
              continue;
              label251:
              if (HousemapFilterDialog.i(HousemapFilterDialog.this) == 0) {
                HousemapFilterDialog.this.mTvHousemapPrice.setText("¥" + j + "元以下");
              } else if (HousemapFilterDialog.h(HousemapFilterDialog.this) != 0) {
                HousemapFilterDialog.this.mTvHousemapPrice.setText("¥" + i + " - " + j + "元");
              } else {
                HousemapFilterDialog.this.mTvHousemapPrice.setText("¥" + i + "元以上");
              }
            }
          }
        });
        i1 += 1;
      }
      break;
    }
  }
  
  private void l()
  {
    String str = b.joinTypeString(this.mAilHouseTypeHZ) + b.joinTypeString(this.mAilHouseTypeZZ) + b.joinTypeString(this.mAilHouseTypeYZ) + b.joinTypeString(this.mAilHouseTypeLuxury);
    Object localObject = str;
    if (!TextUtils.isEmpty(str)) {
      localObject = str.substring(0, str.length() - 1);
    }
    this.f.setType((String)localObject);
    this.f.setTypeSet(this.n);
    this.f.setMinPrice(this.h);
    this.f.setMaxPrice(this.i);
    localObject = d();
    switch (6.a[localObject.ordinal()])
    {
    }
    for (;;)
    {
      this.f.setAround(b.joinString(this.mAilAround));
      this.f.setFeature(b.joinString(this.mAilFeature));
      this.f.setLeasetype(b.joinString(this.mAilLeaseType));
      this.f.setTags(b.joinString(this.mAilTags));
      this.f.setAroundBeanList(a(this.mAilAround));
      this.f.setFeatureBeanList(a(this.mAilFeature));
      this.f.setLeaseTypeBeanList(a(this.mAilLeaseType));
      this.f.setTagsBeanList(a(this.mAilTags));
      this.f.setRapid(b.joinString(this.mAilRapid));
      this.f.setRapidBeanList(a(this.mAilRapid));
      return;
      this.f.setFace("");
      this.f.setHface("");
      this.f.setArea("");
      localObject = new SelectBean();
      this.f.setBedroom((SelectBean)localObject);
      this.f.setRface(b.joinString(this.mAilFace));
      this.f.setVersion(b.joinString(this.mAilVersion1));
      this.f.setStyle(b.joinString(this.mAilVersion2));
      this.f.setFaceBeanList(new ArrayList());
      this.f.sethFaceBeanList(new ArrayList());
      this.f.setAreaBeanList(new ArrayList());
      this.f.setrFaceBeanList(a(this.mAilFace));
      this.f.setVersionBeanList(a(this.mAilVersion1));
      this.f.setStyleBeanList(a(this.mAilVersion2));
      this.f.setAroundBeanList(a(this.mAilAround));
      continue;
      this.f.setFace("");
      this.f.setRface("");
      this.f.setBedroom(new SelectBean());
      this.f.setHface(b.joinString(this.mAilFace));
      this.f.setArea(b.joinString(this.mAilArea));
      this.f.setVersion(b.joinString(this.mAilVersion1));
      this.f.setStyle(b.joinString(this.mAilVersion2));
      this.f.setFaceBeanList(new ArrayList());
      this.f.setrFaceBeanList(new ArrayList());
      this.f.sethFaceBeanList(a(this.mAilFace));
      this.f.setAreaBeanList(a(this.mAilArea));
      this.f.setVersionBeanList(a(this.mAilVersion1));
      this.f.setStyleBeanList(a(this.mAilVersion2));
      this.f.setAroundBeanList(a(this.mAilAround));
      continue;
      this.f.setRface("");
      this.f.setHface("");
      this.f.setArea("");
      this.f.setBedroom(new SelectBean());
      this.f.setVersion(b.joinString(this.mAilVersion1));
      this.f.setStyle(b.joinString(this.mAilVersion2));
      this.f.setFace(b.joinString(this.mAilFace));
      this.f.setFaceBeanList(a(this.mAilFace));
      this.f.setrFaceBeanList(new ArrayList());
      this.f.sethFaceBeanList(new ArrayList());
      this.f.setAreaBeanList(new ArrayList());
      this.f.setStyleBeanList(new ArrayList());
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.b = paramContext;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    a();
    paramLayoutInflater = getArguments();
    this.e = ((SelectCondition)paramLayoutInflater.getSerializable("select_condition"));
    this.f = ((SearchCondition)paramLayoutInflater.getSerializable("search_condition"));
    if (this.f == null) {
      this.f = new SearchCondition();
    }
    this.c = LayoutInflater.from(this.b).inflate(2130904728, null, false);
    b();
    a(this.f);
    return this.c;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.a.unbind();
  }
  
  @OnClick({2131693064, 2131691289})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131693064: 
      b.clearSelect(this.mAilHouseTypeHZ);
      b.clearSelect(this.mAilHouseTypeZZ);
      b.clearSelect(this.mAilHouseTypeYZ);
      b.clearSelect(this.mAilHouseTypeLuxury);
      i();
      this.m = c.c;
      b.clearSelect(this.mAilRapid);
      return;
    }
    l();
    if (this.p != null) {
      this.p.onConfirmClick(this.f);
    }
    dismiss();
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString, SearchCondition paramSearchCondition, a parama)
  {
    if (!(this instanceof DialogFragment)) {
      super.show(paramFragmentManager, paramString);
    }
    for (;;)
    {
      this.f = paramSearchCondition;
      this.p = parama;
      return;
      VdsAgent.showDialogFragment((DialogFragment)this, paramFragmentManager, paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onConfirmClick(SearchCondition paramSearchCondition);
  }
  
  private class b
    implements CompoundButton.OnCheckedChangeListener
  {
    private b() {}
    
    @Instrumented
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
      HousemapFilterDialog.a(HousemapFilterDialog.this).clear();
      HousemapFilterDialog.b(HousemapFilterDialog.this);
      paramCompoundButton = HousemapFilterDialog.c(HousemapFilterDialog.this);
      if (paramCompoundButton == HousemapFilterDialog.d(HousemapFilterDialog.this)) {
        return;
      }
      HousemapFilterDialog.a(HousemapFilterDialog.this, paramCompoundButton);
      HousemapFilterDialog.e(HousemapFilterDialog.this);
    }
  }
  
  private static enum c
  {
    private c() {}
  }
  
  private class d
    implements CompoundButton.OnCheckedChangeListener
  {
    private d() {}
    
    @Instrumented
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
      if (paramBoolean)
      {
        if (paramCompoundButton.getParent() != HousemapFilterDialog.this.mAilLeaseType) {
          break label40;
        }
        b.clearSelect(HousemapFilterDialog.this.mAilLeaseType);
      }
      for (;;)
      {
        paramCompoundButton.setChecked(true);
        return;
        label40:
        if (paramCompoundButton.getParent() == HousemapFilterDialog.this.mAilTags) {
          b.clearSelect(HousemapFilterDialog.this.mAilTags);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/HousemapFilterDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */