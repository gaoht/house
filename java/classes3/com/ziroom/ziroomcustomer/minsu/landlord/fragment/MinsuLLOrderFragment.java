package com.ziroom.ziroomcustomer.minsu.landlord.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.adapter.p;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLOrderListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLOrderListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLOrderListBean.DataBean.OrderListBean;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.l;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;

public class MinsuLLOrderFragment
  extends BaseFragment
{
  private int a = 1;
  private int b = 10;
  private List<Integer> c;
  private View d;
  private CommonTitle e;
  private XListView f;
  private RadioGroup g;
  private p h;
  private List<MinsuLLOrderListBean.DataBean.OrderListBean> i;
  private boolean j = false;
  private RelativeLayout k;
  private TextView l;
  private int m;
  private int n;
  private View o;
  private ObjectAnimator p;
  private int q = 0;
  
  private void a(int paramInt)
  {
    this.a = 1;
    com.ziroom.ziroomcustomer.minsu.e.a.orderListLL(getActivity(), paramInt + 1, this.a, this.b, true, new s(getActivity(), new r(MinsuLLOrderListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MinsuLLOrderFragment.f(MinsuLLOrderFragment.this).clear();
        MinsuLLOrderFragment.j(MinsuLLOrderFragment.this).notifyDataSetChanged();
        MinsuLLOrderFragment.k(MinsuLLOrderFragment.this);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuLLOrderListBean paramAnonymousMinsuLLOrderListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuLLOrderListBean);
        if ((paramAnonymousMinsuLLOrderListBean == null) || (!paramAnonymousMinsuLLOrderListBean.checkSuccess(MinsuLLOrderFragment.this.getActivity()))) {
          return;
        }
        if (MinsuLLOrderFragment.f(MinsuLLOrderFragment.this) != null) {
          MinsuLLOrderFragment.f(MinsuLLOrderFragment.this).clear();
        }
        if ((paramAnonymousMinsuLLOrderListBean.data != null) && (paramAnonymousMinsuLLOrderListBean.data.orderList != null))
        {
          if (paramAnonymousMinsuLLOrderListBean.data.orderList.size() > 0)
          {
            MinsuLLOrderFragment.f(MinsuLLOrderFragment.this).addAll(paramAnonymousMinsuLLOrderListBean.data.orderList);
            MinsuLLOrderFragment.c(MinsuLLOrderFragment.this).setVisibility(0);
            MinsuLLOrderFragment.g(MinsuLLOrderFragment.this).setVisibility(8);
          }
        }
        else if (MinsuLLOrderFragment.j(MinsuLLOrderFragment.this) != null)
        {
          MinsuLLOrderFragment.j(MinsuLLOrderFragment.this).notifyDataSetChanged();
          if (MinsuLLOrderFragment.j(MinsuLLOrderFragment.this).getDatas().size() < 10) {
            break label224;
          }
          MinsuLLOrderFragment.c(MinsuLLOrderFragment.this).setPullLoadEnable(true);
        }
        for (;;)
        {
          MinsuLLOrderFragment.k(MinsuLLOrderFragment.this);
          return;
          MinsuLLOrderFragment.c(MinsuLLOrderFragment.this).setVisibility(8);
          MinsuLLOrderFragment.g(MinsuLLOrderFragment.this).setVisibility(0);
          MinsuLLOrderFragment.i(MinsuLLOrderFragment.this).setText(MinsuLLOrderFragment.h(MinsuLLOrderFragment.this));
          break;
          label224:
          MinsuLLOrderFragment.c(MinsuLLOrderFragment.this).setPullLoadEnable(false);
        }
      }
    });
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.p != null) && (this.p.isRunning())) {
      this.p.end();
    }
    int i1 = this.m;
    int i2 = this.m;
    this.p = ObjectAnimator.ofFloat(this.o, View.TRANSLATION_X, new float[] { i1 * paramInt1, i2 * paramInt2 }).setDuration(250L);
    this.p.setInterpolator(new LinearInterpolator());
    this.p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator) {}
    });
    this.p.start();
  }
  
  private void c()
  {
    this.k = ((RelativeLayout)this.d.findViewById(2131690377));
    this.l = ((TextView)this.d.findViewById(2131690175));
    this.g = ((RadioGroup)this.d.findViewById(2131694623));
    this.g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousRadioGroup, paramAnonymousInt);
        paramAnonymousInt = MinsuLLOrderFragment.a(MinsuLLOrderFragment.this).indexOf(Integer.valueOf(paramAnonymousInt));
        MinsuLLOrderFragment.a(MinsuLLOrderFragment.this, paramAnonymousInt);
        MinsuLLOrderFragment.a(MinsuLLOrderFragment.this, MinsuLLOrderFragment.b(MinsuLLOrderFragment.this), paramAnonymousInt);
        MinsuLLOrderFragment.b(MinsuLLOrderFragment.this, paramAnonymousInt);
        MinsuLLOrderFragment.c(MinsuLLOrderFragment.this).setSelection(0);
      }
    });
    this.f = ((XListView)this.d.findViewById(2131690955));
    this.f.setPullLoadEnable(true);
    this.f.setPullRefreshEnable(true);
    this.f.setXListViewListener(new XListView.a()
    {
      public void onLoadMore()
      {
        MinsuLLOrderFragment.e(MinsuLLOrderFragment.this);
      }
      
      public void onRefresh()
      {
        MinsuLLOrderFragment.a(MinsuLLOrderFragment.this, MinsuLLOrderFragment.a(MinsuLLOrderFragment.this).indexOf(Integer.valueOf(MinsuLLOrderFragment.d(MinsuLLOrderFragment.this).getCheckedRadioButtonId())));
      }
    });
    k();
    this.h = new p(getActivity(), this.i);
    this.f.setAdapter(this.h);
  }
  
  private void d()
  {
    this.e = ((CommonTitle)this.d.findViewById(2131691272));
    this.e.setMiddleText(getString(2131297122));
    this.e.showRightText(false, "");
    this.e.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLLOrderFragment.this.getActivity().finish();
      }
    });
  }
  
  private void e()
  {
    this.c = new ArrayList(3);
    this.c.add(Integer.valueOf(2131694617));
    this.c.add(Integer.valueOf(2131694618));
    this.c.add(Integer.valueOf(2131694619));
    this.i = new ArrayList();
  }
  
  private String f()
  {
    switch (this.c.indexOf(Integer.valueOf(this.g.getCheckedRadioButtonId())))
    {
    default: 
      return null;
    case 0: 
      return getString(2131297285);
    case 1: 
      return getString(2131297286);
    }
    return getString(2131297287);
  }
  
  private void g()
  {
    if ((this.g == null) || (this.c == null)) {
      return;
    }
    FragmentActivity localFragmentActivity = getActivity();
    int i2 = this.c.indexOf(Integer.valueOf(this.g.getCheckedRadioButtonId()));
    if (this.h.getCount() == 0) {}
    for (int i1 = this.b;; i1 = this.h.getCount())
    {
      com.ziroom.ziroomcustomer.minsu.e.a.orderListLL(localFragmentActivity, i2 + 1, 1, i1, true, new s(getActivity(), new r(MinsuLLOrderListBean.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          MinsuLLOrderFragment.f(MinsuLLOrderFragment.this).clear();
          MinsuLLOrderFragment.j(MinsuLLOrderFragment.this).notifyDataSetChanged();
          MinsuLLOrderFragment.k(MinsuLLOrderFragment.this);
        }
        
        public void onSuccess(int paramAnonymousInt, MinsuLLOrderListBean paramAnonymousMinsuLLOrderListBean)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousMinsuLLOrderListBean);
          l.e("error", "code = " + paramAnonymousInt + " ");
          if (!paramAnonymousMinsuLLOrderListBean.checkSuccess(MinsuLLOrderFragment.this.getActivity())) {
            return;
          }
          MinsuLLOrderFragment.f(MinsuLLOrderFragment.this).clear();
          if ((paramAnonymousMinsuLLOrderListBean != null) && (paramAnonymousMinsuLLOrderListBean.data != null) && (paramAnonymousMinsuLLOrderListBean.data.orderList != null))
          {
            l.e("error", "data = " + paramAnonymousMinsuLLOrderListBean.data.orderList.size());
            if (paramAnonymousMinsuLLOrderListBean.data.orderList.size() > 0)
            {
              MinsuLLOrderFragment.f(MinsuLLOrderFragment.this).addAll(paramAnonymousMinsuLLOrderListBean.data.orderList);
              MinsuLLOrderFragment.c(MinsuLLOrderFragment.this).setVisibility(0);
              MinsuLLOrderFragment.i(MinsuLLOrderFragment.this).setVisibility(8);
            }
          }
          else
          {
            MinsuLLOrderFragment.j(MinsuLLOrderFragment.this).notifyDataSetChanged();
            if (MinsuLLOrderFragment.j(MinsuLLOrderFragment.this).getDatas().size() < 10) {
              break label268;
            }
            MinsuLLOrderFragment.c(MinsuLLOrderFragment.this).setPullLoadEnable(true);
          }
          for (;;)
          {
            MinsuLLOrderFragment.k(MinsuLLOrderFragment.this);
            return;
            MinsuLLOrderFragment.c(MinsuLLOrderFragment.this).setVisibility(8);
            MinsuLLOrderFragment.i(MinsuLLOrderFragment.this).setText(MinsuLLOrderFragment.h(MinsuLLOrderFragment.this));
            MinsuLLOrderFragment.i(MinsuLLOrderFragment.this).setVisibility(0);
            break;
            label268:
            MinsuLLOrderFragment.c(MinsuLLOrderFragment.this).setPullLoadEnable(false);
          }
        }
      });
      return;
    }
  }
  
  private void h()
  {
    this.a += 1;
    int i1 = this.c.indexOf(Integer.valueOf(this.g.getCheckedRadioButtonId()));
    com.ziroom.ziroomcustomer.minsu.e.a.orderListLL(getActivity(), i1 + 1, this.a, this.b, false, new com.freelxl.baselibrary.d.c.a(new r(MinsuLLOrderListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        MinsuLLOrderFragment.l(MinsuLLOrderFragment.this);
        MinsuLLOrderFragment.k(MinsuLLOrderFragment.this);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuLLOrderListBean paramAnonymousMinsuLLOrderListBean)
      {
        l.e("error", "code = " + paramAnonymousInt + " s = " + paramAnonymousMinsuLLOrderListBean);
        if ((paramAnonymousMinsuLLOrderListBean != null) && (paramAnonymousMinsuLLOrderListBean.checkSuccess(MinsuLLOrderFragment.this.getActivity())) && (paramAnonymousMinsuLLOrderListBean.data != null) && (paramAnonymousMinsuLLOrderListBean.data.orderList != null))
        {
          if (paramAnonymousMinsuLLOrderListBean.data.orderList.size() <= 0) {
            break label121;
          }
          MinsuLLOrderFragment.f(MinsuLLOrderFragment.this).addAll(paramAnonymousMinsuLLOrderListBean.data.orderList);
        }
        for (;;)
        {
          MinsuLLOrderFragment.j(MinsuLLOrderFragment.this).notifyDataSetChanged();
          MinsuLLOrderFragment.k(MinsuLLOrderFragment.this);
          return;
          label121:
          g.textToast(MinsuLLOrderFragment.this.getActivity(), MinsuLLOrderFragment.this.getString(2131297294));
        }
      }
    });
  }
  
  private void i()
  {
    h();
  }
  
  private void j()
  {
    if (this.f != null)
    {
      this.f.stopRefresh();
      this.f.stopLoadMore();
      this.f.setRefreshTime("刚刚");
    }
  }
  
  private void k()
  {
    this.o = this.d.findViewById(2131691295);
    float f1 = ab.length((RadioButton)this.d.findViewById(2131694617), getString(2131297119));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.o.getLayoutParams();
    int i1 = ac.getScreenWidth(getActivity());
    this.n = ((int)(i1 / 3 - f1) / 2);
    this.m = (i1 / 3);
    localLayoutParams.setMargins(this.n, 0, 0, 0);
    this.o.getLayoutParams().width = ((int)f1);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.d = paramLayoutInflater.inflate(2130903954, paramViewGroup, false);
    return this.d;
  }
  
  public void onResume()
  {
    super.onResume();
    g();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    e();
    c();
    d();
    a(0);
  }
  
  public void onVisibilityChangedToUser(boolean paramBoolean)
  {
    super.onVisibilityChangedToUser(paramBoolean);
    if ((paramBoolean) && (this.j)) {
      g();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.j = true;
    }
    super.setUserVisibleHint(paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/fragment/MinsuLLOrderFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */