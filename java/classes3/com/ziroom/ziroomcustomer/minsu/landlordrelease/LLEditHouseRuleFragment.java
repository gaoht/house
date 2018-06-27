package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.EditHouseRuleResult;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.CommonSaveDescInfoActivity;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LLEditHouseRuleFragment
  extends BaseFluxFragment
{
  Unbinder b;
  com.freelxl.baselibrary.a.a<Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX> c;
  @BindView(2131691272)
  CommonTitle commonTitle;
  private Bundle d;
  private String e;
  private String f;
  private boolean g;
  private List<Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX> h;
  private List<Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX> i;
  private boolean j;
  private View.OnClickListener k = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      if (!LLEditHouseRuleFragment.f(LLEditHouseRuleFragment.this)) {
        g.textToast(LLEditHouseRuleFragment.this.getActivity(), "不可编辑");
      }
      do
      {
        return;
        paramAnonymousView = paramAnonymousView.getTag(2131689523);
      } while ((paramAnonymousView == null) || (!(paramAnonymousView instanceof Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX)));
      paramAnonymousView = (Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX)paramAnonymousView;
      if (!paramAnonymousView.isSelect) {}
      for (boolean bool = true;; bool = false)
      {
        paramAnonymousView.isSelect = bool;
        Iterator localIterator = LLEditHouseRuleFragment.c(LLEditHouseRuleFragment.this).iterator();
        while (localIterator.hasNext())
        {
          Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX localListBeanX = (Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX)localIterator.next();
          if (localListBeanX.value == paramAnonymousView.value) {
            localListBeanX.isSelect = paramAnonymousView.isSelect;
          }
        }
        LLEditHouseRuleFragment.this.c.notifyDataSetChanged();
        return;
      }
    }
  };
  private c l;
  @BindView(2131690955)
  ListViewForScrollView listview;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b m;
  @BindView(2131694161)
  LinearLayout otherRuleArea;
  @BindView(2131689506)
  ObservableScrollView scrollview;
  @BindView(2131694162)
  TextView tvOtherRule;
  
  private void a(Bundle paramBundle)
  {
    this.d = paramBundle;
  }
  
  private void c()
  {
    d();
    e();
  }
  
  private void d()
  {
    this.i = new ArrayList();
    this.e = this.d.getString("text", "");
    this.f = this.d.getString("hint", "");
    this.g = this.d.getBoolean("textIsEdit", true);
    Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean localHouseRulesSelectBean = (Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean)this.d.getSerializable("houseRulesisSelect");
    if ((localHouseRulesSelectBean != null) && (localHouseRulesSelectBean.list != null))
    {
      this.h = localHouseRulesSelectBean.list;
      if ((this.h != null) && (this.h.size() > 0))
      {
        int n = 0;
        while (n < this.h.size())
        {
          this.i.add(((Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX)this.h.get(n)).copy());
          n += 1;
        }
      }
      this.j = localHouseRulesSelectBean.isEdit;
      return;
    }
    this.h = new ArrayList();
    this.j = false;
  }
  
  private void e()
  {
    f();
    h();
    this.tvOtherRule.setText(this.e);
    this.scrollview.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LLEditHouseRuleFragment.this.commonTitle.setBottomLineAlpha(f);
      }
    });
  }
  
  private void f()
  {
    this.commonTitle.setLeftButtonType(0);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LLEditHouseRuleFragment.a(LLEditHouseRuleFragment.this);
      }
    });
    this.commonTitle.showRightText(true, getString(2131297412));
    this.commonTitle.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = LLEditHouseRuleFragment.this.getActivity().getIntent();
        paramAnonymousView.putExtra("text", LLEditHouseRuleFragment.b(LLEditHouseRuleFragment.this));
        paramAnonymousView.putExtra("list", com.alibaba.fastjson.b.toJSONString(LLEditHouseRuleFragment.c(LLEditHouseRuleFragment.this)));
        LLEditHouseRuleFragment.this.getActivity().setResult(-1);
        paramAnonymousView = new EditHouseRuleResult();
        paramAnonymousView.text = LLEditHouseRuleFragment.b(LLEditHouseRuleFragment.this);
        paramAnonymousView.list = com.alibaba.fastjson.b.toJSONString(LLEditHouseRuleFragment.c(LLEditHouseRuleFragment.this));
        LLEditHouseRuleFragment.d(LLEditHouseRuleFragment.this).editHouseRuleResult(paramAnonymousView);
        LLEditHouseRuleFragment.this.getActivity().finish();
      }
    });
    this.commonTitle.setBottomLineAlpha(0.0F);
  }
  
  private void g()
  {
    int i2 = 0;
    int n = i2;
    if (this.h != null)
    {
      if (this.i != null) {
        break label77;
      }
      n = i2;
    }
    while (n != 0)
    {
      d.newBuilder(getActivity()).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          LLEditHouseRuleFragment.this.getActivity().finish();
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return;
      label77:
      if (this.h.size() != this.i.size())
      {
        n = 1;
      }
      else
      {
        int i1 = 0;
        for (;;)
        {
          n = i2;
          if (i1 >= this.h.size()) {
            break;
          }
          if (!((Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX)this.h.get(i1)).equals(this.i.get(i1)))
          {
            n = 1;
            break;
          }
          i1 += 1;
        }
      }
    }
    getActivity().finish();
  }
  
  public static LLEditHouseRuleFragment getInstance(Bundle paramBundle)
  {
    LLEditHouseRuleFragment localLLEditHouseRuleFragment = new LLEditHouseRuleFragment();
    localLLEditHouseRuleFragment.a(paramBundle);
    return localLLEditHouseRuleFragment;
  }
  
  private void h()
  {
    this.c = new com.freelxl.baselibrary.a.a(getActivity(), this.h, 2130904357)
    {
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, Step3InitDealPolicyBean.DataBean.HouseRulesSelectBean.ListBeanX paramAnonymousListBeanX)
      {
        paramAnonymousb.setText(2131689752, paramAnonymousListBeanX.text);
        paramAnonymousb.getView(2131690977).setSelected(paramAnonymousListBeanX.isSelect);
        paramAnonymousb.setEnabled(2131690977, false);
        paramAnonymousb.getConvertView().setTag(2131689523, paramAnonymousListBeanX);
        paramAnonymousb.getConvertView().setOnClickListener(LLEditHouseRuleFragment.e(LLEditHouseRuleFragment.this));
      }
    };
    this.listview.setAdapter(this.c);
  }
  
  private void i()
  {
    this.l = new c(this);
    this.a.register(this.l);
    this.m = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 258) && (paramInt2 == 4096))
    {
      this.e = paramIntent.getStringExtra("saveDesc");
      this.tvOtherRule.setText(this.e);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    i();
    paramLayoutInflater = paramLayoutInflater.inflate(2130903939, null);
    this.b = ButterKnife.bind(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.l);
    super.onDestroyView();
    this.b.unbind();
  }
  
  @OnClick({2131694161})
  public void onViewClicked()
  {
    if (this.g)
    {
      Intent localIntent = new Intent(getActivity(), CommonSaveDescInfoActivity.class);
      localIntent.putExtra("titleName", "其他规定");
      localIntent.putExtra("editTextHint", this.f);
      String str = this.tvOtherRule.getText().toString();
      if (!TextUtils.isEmpty(str)) {
        localIntent.putExtra("saveDescText", str);
      }
      localIntent.putExtra("editMaxNum", 1000);
      localIntent.putExtra("editMinNum", 50);
      localIntent.putExtra("nullable", true);
      startActivityForResult(localIntent, 258);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    c();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LLEditHouseRuleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */