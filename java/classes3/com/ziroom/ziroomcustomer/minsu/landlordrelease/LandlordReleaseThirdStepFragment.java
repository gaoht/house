package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.BaseLandlordReleaseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.EditHouseRuleResult;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean.DataBean.CancellationPolicyBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean.DataBean.CancellationPolicyBean.ListBeanXX;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean.DataBean.DepositMoneyBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean.DataBean.HouseRulesBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean.DataBean.OrderTypeBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean.DataBean.OrderTypeBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean.DataBean.UnSelectcancellationPolicyBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LandlordReleaseThirdStepFragment
  extends BaseLandlordReleaseFragment
  implements com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a
{
  Unbinder b;
  private Step3InitDealPolicyBean.DataBean.OrderTypeBean.ListBean c;
  @BindView(2131694677)
  CheckBox checkbox1;
  @BindView(2131694680)
  CheckBox checkbox2;
  @BindView(2131691272)
  CommonTitle commonTitle;
  private List<CheckBox> d;
  private Step3InitDealPolicyBean.DataBean.CancellationPolicyBean.ListBeanXX e;
  @BindView(2131694225)
  EditText etDeposit;
  private Set<CheckBox> f;
  private BaseActivity g;
  private String h;
  @BindView(2131694222)
  LinearLayout houseRuleArea;
  private String i;
  @BindView(2131694675)
  RelativeLayout item1;
  @BindView(2131694678)
  RelativeLayout item2;
  @BindView(2131694223)
  ImageView ivHouseRuleArrow;
  private int j;
  private Step3InitDealPolicyBean k;
  private List<Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX> l;
  @BindView(2131694228)
  ListViewForScrollView lvCancelPolicy;
  @BindView(2131694229)
  ListViewForScrollView lvLongPolicy;
  private String m;
  private String n;
  @BindView(2131694230)
  Button next;
  private boolean o;
  private Map<String, Boolean> p = new HashMap();
  private b q;
  private a r;
  @BindView(2131694219)
  RelativeLayout rlHouseRule;
  @BindView(2131689893)
  ReleaseUsageAndTipsView ruatv_bottom;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c s;
  @BindView(2131689506)
  ObservableScrollView scrollview;
  @BindView(2131694217)
  TextView step3_title;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b t;
  @BindView(2131694226)
  TextView tvCancelPolicyTitle;
  @BindView(2131694227)
  TextView tvCancelTitleHint;
  @BindView(2131694676)
  TextView tvDesc1;
  @BindView(2131694679)
  TextView tvDesc2;
  @BindView(2131691330)
  TextView tvTitle1;
  @BindView(2131691333)
  TextView tvTitle2;
  @BindView(2131694221)
  TextView tv_title_rule_review;
  
  private void A()
  {
    if ((TextUtils.isEmpty(C())) && (TextUtils.isEmpty(this.m)))
    {
      com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(getActivity()).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          LandlordReleaseThirdStepFragment.k(LandlordReleaseThirdStepFragment.this);
        }
      }).setContent(getString(2131297079)).setButtonText("取消", "确定").show();
      return;
    }
    B();
  }
  
  private void B()
  {
    Object localObject1 = this.d.iterator();
    int i2 = -1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CheckBox)((Iterator)localObject1).next();
      if (((CheckBox)localObject2).isChecked())
      {
        localObject2 = ((CheckBox)localObject2).getTag();
        if ((localObject2 instanceof Step3InitDealPolicyBean.DataBean.OrderTypeBean.ListBean)) {
          i2 = ((Step3InitDealPolicyBean.DataBean.OrderTypeBean.ListBean)localObject2).value;
        }
      }
    }
    if (i2 == -1)
    {
      g.textToast(getActivity(), "请选择预定类型");
      return;
    }
    Object localObject2 = C();
    localObject1 = VdsAgent.trackEditTextSilent(this.etDeposit).toString();
    int i3 = this.k.data.depositMin;
    int i4 = this.k.data.depositMax;
    int i1 = 0;
    if (((String)localObject1).contains(getString(2131297161))) {
      i1 = Integer.parseInt(((String)localObject1).replaceAll(getString(2131297161), ""));
    }
    while (i1 < i3)
    {
      g.textToast(getActivity(), "押金不能小于" + i3);
      return;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        i1 = Integer.parseInt((String)localObject1);
      }
    }
    if (i1 > i4)
    {
      g.textToast(getActivity(), "押金不能大于" + i4);
      return;
    }
    localObject1 = "";
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (CheckBox)localIterator.next();
      if (((CheckBox)localObject3).isChecked())
      {
        localObject3 = ((CheckBox)localObject3).getTag();
        if ((localObject3 instanceof Step3InitDealPolicyBean.DataBean.CancellationPolicyBean.ListBeanXX)) {
          localObject1 = ((Step3InitDealPolicyBean.DataBean.CancellationPolicyBean.ListBeanXX)localObject3).value;
        }
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      g.textToast(getActivity(), "请选择退订政策");
      return;
    }
    this.t.savePolicy(this, getActivity(), this.h, this.i, this.j, i2, this.m, (String)localObject2, i1, (String)localObject1);
  }
  
  private String C()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.l))
    {
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext())
      {
        Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX localListBeanX = (Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX)localIterator.next();
        if (localListBeanX.isSelect) {
          localStringBuilder.append(localListBeanX.value).append(",");
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    return "";
  }
  
  private void a(CheckBox paramCheckBox)
  {
    if (this.f == null) {
      this.f = new HashSet();
    }
    if (paramCheckBox != null) {
      this.f.add(paramCheckBox);
    }
  }
  
  private void a(EditHouseRuleResult paramEditHouseRuleResult)
  {
    if ((paramEditHouseRuleResult == null) || ((TextUtils.isEmpty(paramEditHouseRuleResult.text)) && (TextUtils.isEmpty(paramEditHouseRuleResult.list))))
    {
      this.l.clear();
      this.m = "";
      this.houseRuleArea.removeAllViews();
      paramEditHouseRuleResult = (TextView)LayoutInflater.from(getActivity()).inflate(2130904092, null);
      if ((this.k != null) && (this.k.data != null) && (this.k.data.houseRules != null)) {
        paramEditHouseRuleResult.setText(this.k.data.houseRules.explain);
      }
      this.houseRuleArea.addView(paramEditHouseRuleResult);
      return;
    }
    Object localObject;
    label169:
    label201:
    int i2;
    if (!TextUtils.isEmpty(paramEditHouseRuleResult.list))
    {
      localObject = com.alibaba.fastjson.b.parseArray(paramEditHouseRuleResult.list, Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX.class);
      if (localObject != null)
      {
        this.l.clear();
        this.l.addAll((Collection)localObject);
      }
      this.houseRuleArea.removeAllViews();
      if (this.l.size() <= 0) {
        break label288;
      }
      localObject = this.l.iterator();
      int i1 = 0;
      i2 = i1;
      if (!((Iterator)localObject).hasNext()) {
        break label290;
      }
      Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX localListBeanX = (Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX)((Iterator)localObject).next();
      if (!localListBeanX.isSelect) {
        break label443;
      }
      TextView localTextView = (TextView)LayoutInflater.from(getActivity()).inflate(2130904093, null);
      localTextView.setText(localListBeanX.text);
      this.houseRuleArea.addView(localTextView);
      i1 = 1;
    }
    label288:
    label290:
    label443:
    for (;;)
    {
      break label201;
      this.l.clear();
      break label169;
      i2 = 0;
      if (!TextUtils.isEmpty(paramEditHouseRuleResult.text))
      {
        this.m = paramEditHouseRuleResult.text;
        localObject = (TextView)LayoutInflater.from(getActivity()).inflate(2130904093, null);
        ((TextView)localObject).setText(this.m);
        this.houseRuleArea.addView((View)localObject);
      }
      while ((TextUtils.isEmpty(paramEditHouseRuleResult.text)) && (i2 == 0))
      {
        paramEditHouseRuleResult = (TextView)LayoutInflater.from(getActivity()).inflate(2130904092, null);
        if ((this.k != null) && (this.k.data != null) && (this.k.data.houseRules != null)) {
          paramEditHouseRuleResult.setText(this.k.data.houseRules.explain);
        }
        this.houseRuleArea.addView(paramEditHouseRuleResult);
        return;
        this.m = "";
      }
      break;
    }
  }
  
  private void d()
  {
    Step3InitDealPolicyBean.DataBean.OrderTypeBean localOrderTypeBean = this.k.data.orderType;
    boolean bool = localOrderTypeBean.isEdit;
    View[] arrayOfView = new View[2];
    arrayOfView[0] = this.item1;
    arrayOfView[1] = this.item2;
    TextView localTextView1 = this.tvTitle1;
    TextView localTextView2 = this.tvTitle2;
    TextView localTextView3 = this.tvDesc1;
    TextView localTextView4 = this.tvDesc2;
    if (localOrderTypeBean.list != null)
    {
      int i1 = 0;
      if (i1 < 2)
      {
        ((CheckBox)this.d.get(i1)).setEnabled(bool);
        if (localOrderTypeBean.list.size() > i1)
        {
          Step3InitDealPolicyBean.DataBean.OrderTypeBean.ListBean localListBean = (Step3InitDealPolicyBean.DataBean.OrderTypeBean.ListBean)localOrderTypeBean.list.get(i1);
          arrayOfView[i1].setVisibility(0);
          new TextView[] { localTextView1, localTextView2 }[i1].setText(localListBean.text);
          new TextView[] { localTextView3, localTextView4 }[i1].setText(localListBean.explain);
          ((CheckBox)this.d.get(i1)).setChecked(localListBean.isSelect);
          ((CheckBox)this.d.get(i1)).setTag(localListBean);
        }
        for (;;)
        {
          i1 += 1;
          break;
          arrayOfView[i1].setVisibility(8);
        }
      }
    }
  }
  
  private void e()
  {
    this.l.clear();
    if ((this.k.data.houseRulesSelect != null) && (this.k.data.houseRulesSelect.list != null)) {
      this.l.addAll(this.k.data.houseRulesSelect.list);
    }
    boolean bool1 = m();
    boolean bool2 = n();
    if ((bool1) || (bool2))
    {
      this.houseRuleArea.removeAllViews();
      if (bool2) {
        localObject = this.l.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext())
      {
        Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX localListBeanX = (Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX)((Iterator)localObject).next();
        if (localListBeanX.isSelect)
        {
          TextView localTextView = (TextView)LayoutInflater.from(getActivity()).inflate(2130904093, null);
          localTextView.setText(localListBeanX.text);
          this.houseRuleArea.addView(localTextView);
          continue;
          this.houseRuleArea.removeAllViews();
          localObject = (TextView)LayoutInflater.from(getActivity()).inflate(2130904092, null);
          if ((this.k != null) && (this.k.data != null) && (this.k.data.houseRules != null)) {
            ((TextView)localObject).setText(this.k.data.houseRules.explain);
          }
          this.houseRuleArea.addView((View)localObject);
        }
      }
    }
    do
    {
      return;
      if ((this.k != null) && (this.k.data != null) && (this.k.data.houseRules != null)) {
        this.tv_title_rule_review.setText(this.k.data.houseRules.auditMsg);
      }
    } while (!m());
    this.m = this.k.data.houseRules.value;
    Object localObject = (TextView)LayoutInflater.from(getActivity()).inflate(2130904093, null);
    ((TextView)localObject).setText(this.m);
    this.houseRuleArea.addView((View)localObject);
  }
  
  public static LandlordReleaseThirdStepFragment getInstance(Bundle paramBundle)
  {
    LandlordReleaseThirdStepFragment localLandlordReleaseThirdStepFragment = new LandlordReleaseThirdStepFragment();
    localLandlordReleaseThirdStepFragment.setArguments(paramBundle);
    return localLandlordReleaseThirdStepFragment;
  }
  
  private boolean m()
  {
    return (this.k.data.houseRules != null) && (!TextUtils.isEmpty(this.k.data.houseRules.value));
  }
  
  private boolean n()
  {
    boolean bool2;
    if ((this.k.data.houseRulesSelect == null) || (this.k.data.houseRulesSelect.list == null) || (this.k.data.houseRulesSelect.list.size() == 0)) {
      bool2 = false;
    }
    Iterator localIterator;
    boolean bool1;
    do
    {
      return bool2;
      localIterator = this.k.data.houseRulesSelect.list.iterator();
      bool1 = false;
      bool2 = bool1;
    } while (!localIterator.hasNext());
    if (((Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX)localIterator.next()).isSelect) {
      bool1 = true;
    }
    for (;;)
    {
      break;
    }
  }
  
  private void o()
  {
    if ((this.k.data.depositMoney != null) && (this.k.data.depositMoney.value >= 0)) {
      this.etDeposit.setText(this.k.data.depositMoney.value + getString(2131297161));
    }
    if ((this.k.data.depositMoney != null) && (this.k.data.depositMoney.isEdit))
    {
      this.etDeposit.setEnabled(true);
      return;
    }
    this.etDeposit.setEnabled(false);
  }
  
  private void p()
  {
    if (this.k.data.cancellationPolicyTips != null) {
      this.tvCancelTitleHint.setText(this.k.data.cancellationPolicyTips);
    }
    Object localObject;
    if ((this.k.data.cancellationPolicy != null) && (this.k.data.cancellationPolicy.list != null) && (this.k.data.cancellationPolicy.list.size() > 0))
    {
      this.q = new b(this.k.data.cancellationPolicy.list.size());
      localObject = new com.freelxl.baselibrary.a.a(getActivity(), this.k.data.cancellationPolicy.list, 2130904356)
      {
        public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, Step3InitDealPolicyBean.DataBean.CancellationPolicyBean.ListBeanXX paramAnonymousListBeanXX) {}
        
        public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, Step3InitDealPolicyBean.DataBean.CancellationPolicyBean.ListBeanXX paramAnonymousListBeanXX, int paramAnonymousInt)
        {
          paramAnonymousb.setText(2131689541, paramAnonymousListBeanXX.text);
          paramAnonymousb.setText(2131690073, paramAnonymousListBeanXX.explain);
          paramAnonymousb = (CheckBox)paramAnonymousb.getView(2131689720);
          paramAnonymousb.setTag(paramAnonymousListBeanXX);
          paramAnonymousb.setChecked(paramAnonymousListBeanXX.isSelect);
          LandlordReleaseThirdStepFragment.a(LandlordReleaseThirdStepFragment.this, paramAnonymousb);
          LandlordReleaseThirdStepFragment.a(LandlordReleaseThirdStepFragment.this).sendEmptyMessage(paramAnonymousInt);
        }
      };
      this.lvCancelPolicy.setAdapter((ListAdapter)localObject);
    }
    if ((this.k.data.cancellationPolicy != null) && (this.k.data.unSelectcancellationPolicy != null) && (this.k.data.unSelectcancellationPolicy.size() > 0))
    {
      localObject = new com.freelxl.baselibrary.a.a(getActivity(), this.k.data.unSelectcancellationPolicy, 2130904356)
      {
        public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, Step3InitDealPolicyBean.DataBean.UnSelectcancellationPolicyBean paramAnonymousUnSelectcancellationPolicyBean)
        {
          paramAnonymousb.setText(2131689541, paramAnonymousUnSelectcancellationPolicyBean.text);
          paramAnonymousb.setText(2131690073, paramAnonymousUnSelectcancellationPolicyBean.explain);
          ((CheckBox)paramAnonymousb.getView(2131689720)).setVisibility(8);
        }
      };
      this.lvLongPolicy.setAdapter((ListAdapter)localObject);
    }
  }
  
  private void q()
  {
    r();
    s();
    v();
    z();
  }
  
  private void r()
  {
    this.n = getActivity().getIntent().getStringExtra("from");
    this.h = k();
    this.i = j();
    this.j = h();
    this.l = new ArrayList();
  }
  
  private void s()
  {
    t();
    this.ruatv_bottom.setCode("TIP_ORDER_TYPE_EFFECT");
    this.d = new ArrayList();
    this.d.add(this.checkbox1);
    this.d.add(this.checkbox2);
    if ("manager".equals(this.n))
    {
      this.next.setVisibility(8);
      this.step3_title.setText("预订及政策信息");
      this.commonTitle.setRightTextColorSize(2131624475, 14);
      this.commonTitle.showRightText(true, "保存");
      this.commonTitle.setOnRightButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          LandlordReleaseThirdStepFragment.b(LandlordReleaseThirdStepFragment.this);
        }
      });
    }
  }
  
  private void t()
  {
    this.commonTitle.setLeftButtonType(0);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LandlordReleaseThirdStepFragment.c(LandlordReleaseThirdStepFragment.this);
      }
    });
    this.commonTitle.setBottomLineAlpha(0.0F);
  }
  
  private void u()
  {
    Iterator localIterator = this.p.entrySet().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((Boolean)((Map.Entry)localIterator.next()).getValue()).booleanValue());
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(getActivity()).setOnConfirmClickListener(new d.b()
        {
          public void onLeftClick(View paramAnonymousView) {}
          
          public void onRightClick(View paramAnonymousView)
          {
            LandlordReleaseThirdStepFragment.d(LandlordReleaseThirdStepFragment.this);
          }
        }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
        return;
      }
      g();
      return;
    }
  }
  
  private void v()
  {
    if (this.d != null)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((CheckBox)localIterator.next()).setOnCheckedChangeListener(new c());
      }
    }
    this.scrollview.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LandlordReleaseThirdStepFragment.this.commonTitle.setBottomLineAlpha(f);
      }
    });
  }
  
  private void w()
  {
    this.etDeposit.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (LandlordReleaseThirdStepFragment.this.etDeposit == null) {
          com.freelxl.baselibrary.f.d.e("wz error", "etdeposit  == null");
        }
        do
        {
          return;
          if (paramAnonymousBoolean) {
            break;
          }
        } while (VdsAgent.trackEditTextSilent(LandlordReleaseThirdStepFragment.this.etDeposit).toString().isEmpty());
        LandlordReleaseThirdStepFragment.this.etDeposit.setInputType(1);
        LandlordReleaseThirdStepFragment.this.etDeposit.append(LandlordReleaseThirdStepFragment.this.getString(2131297161));
        return;
        paramAnonymousView = VdsAgent.trackEditTextSilent(LandlordReleaseThirdStepFragment.this.etDeposit).toString();
        if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.contains(LandlordReleaseThirdStepFragment.this.getString(2131297161)))) {
          LandlordReleaseThirdStepFragment.this.etDeposit.setText(paramAnonymousView.replace(LandlordReleaseThirdStepFragment.this.getString(2131297161), ""));
        }
        LandlordReleaseThirdStepFragment.this.etDeposit.setInputType(2);
        LandlordReleaseThirdStepFragment.e(LandlordReleaseThirdStepFragment.this).put("deposit", Boolean.valueOf(true));
      }
    });
    this.etDeposit.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getKeyCode() == 66)) {
          LandlordReleaseThirdStepFragment.this.etDeposit.clearFocus();
        }
        return false;
      }
    });
  }
  
  private void x()
  {
    if (this.r == null) {
      this.r = new a();
    }
    if (this.f != null)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((CheckBox)localIterator.next()).setOnCheckedChangeListener(this.r);
      }
    }
  }
  
  private void y()
  {
    this.s = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c(this);
    this.a.register(this.s);
    this.t = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void z()
  {
    this.t.initPolicy(this, this.g, this.h, this.i, Integer.valueOf(this.j));
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i1 = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (i1)
      {
      }
      break;
    }
    do
    {
      return;
      if (!parama.equals("ll_release_step3")) {
        break;
      }
      i1 = 0;
      break;
      if (!parama.equals("ll_release_step3_error")) {
        break;
      }
      i1 = 1;
      break;
      if (!parama.equals("ll_release_step3_save")) {
        break;
      }
      i1 = 2;
      break;
      if (!parama.equals("ll_release_step3_save_error")) {
        break;
      }
      i1 = 3;
      break;
      if (!parama.equals("ll_release_edit_house_rule")) {
        break;
      }
      i1 = 4;
      break;
      this.k = this.s.getDealPolicyBean();
      if ((this.k != null) && (this.k.data != null))
      {
        d();
        e();
        o();
        p();
        this.etDeposit.clearFocus();
        w();
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            LandlordReleaseThirdStepFragment.a(LandlordReleaseThirdStepFragment.this, true);
            if (LandlordReleaseThirdStepFragment.this.scrollview != null) {
              LandlordReleaseThirdStepFragment.this.scrollview.scrollTo(0, 0);
            }
          }
        }, 80L);
        return;
      }
      if (this.k == null) {}
      for (parama = "";; parama = this.k.message)
      {
        ad.shouErrorMessage(parama);
        return;
      }
      parama = this.s.getSavePolicyResult();
      if (parama.checkSuccess(getActivity()))
      {
        if ("manager".equals(this.n)) {
          g.textToast(getActivity(), "保存成功");
        }
        f();
        return;
      }
      if (parama == null) {}
      for (parama = null;; parama = parama.message)
      {
        ad.shouErrorMessage(parama);
        return;
      }
      parama = this.s.getEditHouseRuleResult();
    } while (parama == null);
    this.p.put("rule", Boolean.valueOf(true));
    a(parama);
  }
  
  protected View c()
  {
    return LayoutInflater.from(this.g).inflate(2130903948, null);
  }
  
  public boolean onBackPressed()
  {
    u();
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = ((BaseActivity)getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    y();
    paramLayoutInflater = c();
    this.b = ButterKnife.bind(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.s);
    super.onDestroyView();
    this.b.unbind();
  }
  
  public void onLoginBack(boolean paramBoolean1, boolean paramBoolean2) {}
  
  @OnClick({2131694219, 2131694230})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131694219: 
      do
      {
        return;
      } while ((this.k == null) || (this.k.data == null));
      paramView = new Bundle();
      paramView.putInt("type", 1);
      if (this.k.data.houseRules != null)
      {
        paramView.putSerializable("text", this.m);
        paramView.putSerializable("hint", this.k.data.houseRules.text);
        paramView.putSerializable("textIsEdit", Boolean.valueOf(this.k.data.houseRules.isEdit));
      }
      if (this.k.data.houseRulesSelect != null)
      {
        Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean localHouseRulesSelectBean = this.k.data.houseRulesSelect;
        localHouseRulesSelectBean.list = this.l;
        paramView.putSerializable("houseRulesisSelect", localHouseRulesSelectBean);
      }
      k.toFragmengWraperActivity(getActivity(), paramView);
      return;
    }
    A();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    q();
  }
  
  public class a
    implements CompoundButton.OnCheckedChangeListener
  {
    public a() {}
    
    @Instrumented
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
      Object localObject;
      if (paramBoolean)
      {
        localObject = paramCompoundButton.getTag();
        if ((localObject != null) && ((localObject instanceof Step3InitDealPolicyBean.DataBean.CancellationPolicyBean.ListBeanXX))) {}
      }
      for (;;)
      {
        return;
        if (LandlordReleaseThirdStepFragment.h(LandlordReleaseThirdStepFragment.this)) {
          LandlordReleaseThirdStepFragment.e(LandlordReleaseThirdStepFragment.this).put("cancelPolicy", Boolean.valueOf(true));
        }
        LandlordReleaseThirdStepFragment.a(LandlordReleaseThirdStepFragment.this, (Step3InitDealPolicyBean.DataBean.CancellationPolicyBean.ListBeanXX)paramCompoundButton.getTag());
        paramCompoundButton = LandlordReleaseThirdStepFragment.i(LandlordReleaseThirdStepFragment.this).iterator();
        while (paramCompoundButton.hasNext())
        {
          localObject = (CheckBox)paramCompoundButton.next();
          if (!((Step3InitDealPolicyBean.DataBean.CancellationPolicyBean.ListBeanXX)((CheckBox)localObject).getTag()).value.equals(LandlordReleaseThirdStepFragment.j(LandlordReleaseThirdStepFragment.this).value)) {
            ((CheckBox)localObject).setChecked(false);
          }
        }
        continue;
        localObject = LandlordReleaseThirdStepFragment.i(LandlordReleaseThirdStepFragment.this).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!((CheckBox)((Iterator)localObject).next()).isChecked());
        for (int i = 1; i == 0; i = 0)
        {
          paramCompoundButton.setChecked(true);
          return;
        }
      }
    }
  }
  
  private class b
    extends Handler
  {
    boolean a = false;
    private int c;
    private Map<Integer, Boolean> d;
    
    public b(int paramInt)
    {
      this.c = paramInt;
      this.d = new HashMap(paramInt);
      int i = 0;
      while (i < paramInt)
      {
        this.d.put(Integer.valueOf(i), Boolean.valueOf(false));
        i += 1;
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      this.d.put(Integer.valueOf(paramMessage.what), Boolean.valueOf(true));
      paramMessage = this.d.entrySet().iterator();
      do
      {
        if (!paramMessage.hasNext()) {
          break;
        }
      } while (((Boolean)((Map.Entry)paramMessage.next()).getValue()).booleanValue());
      for (int i = 0;; i = 1)
      {
        if ((i != 0) && (!this.a))
        {
          this.a = true;
          LandlordReleaseThirdStepFragment.l(LandlordReleaseThirdStepFragment.this);
        }
        return;
      }
    }
  }
  
  public class c
    implements CompoundButton.OnCheckedChangeListener
  {
    public c() {}
    
    @Instrumented
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
      Object localObject;
      if (paramBoolean)
      {
        localObject = paramCompoundButton.getTag();
        if ((localObject != null) && ((localObject instanceof Step3InitDealPolicyBean.DataBean.OrderTypeBean.ListBean))) {}
      }
      for (;;)
      {
        return;
        LandlordReleaseThirdStepFragment.e(LandlordReleaseThirdStepFragment.this).put("orderType", Boolean.valueOf(true));
        LandlordReleaseThirdStepFragment.a(LandlordReleaseThirdStepFragment.this, (Step3InitDealPolicyBean.DataBean.OrderTypeBean.ListBean)paramCompoundButton.getTag());
        paramCompoundButton = LandlordReleaseThirdStepFragment.f(LandlordReleaseThirdStepFragment.this).iterator();
        while (paramCompoundButton.hasNext())
        {
          localObject = (CheckBox)paramCompoundButton.next();
          if (((Step3InitDealPolicyBean.DataBean.OrderTypeBean.ListBean)((CheckBox)localObject).getTag()).value != LandlordReleaseThirdStepFragment.g(LandlordReleaseThirdStepFragment.this).value) {
            ((CheckBox)localObject).setChecked(false);
          }
        }
        continue;
        localObject = LandlordReleaseThirdStepFragment.f(LandlordReleaseThirdStepFragment.this).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!((CheckBox)((Iterator)localObject).next()).isChecked());
        for (int i = 1; i == 0; i = 0)
        {
          paramCompoundButton.setChecked(true);
          return;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseThirdStepFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */