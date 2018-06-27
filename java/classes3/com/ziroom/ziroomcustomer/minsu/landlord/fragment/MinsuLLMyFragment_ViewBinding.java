package com.ziroom.ziroomcustomer.minsu.landlord.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class MinsuLLMyFragment_ViewBinding<T extends MinsuLLMyFragment>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  private View n;
  private View o;
  private View p;
  
  public MinsuLLMyFragment_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mSdvBg = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131694261, "field 'mSdvBg'", SimpleDraweeView.class));
    View localView = Utils.findRequiredView(paramView, 2131690049, "field 'mTvName' and method 'onViewClick'");
    paramT.mTvName = ((TextView)Utils.castView(localView, 2131690049, "field 'mTvName'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691098, "field 'mSdv' and method 'onViewClick'");
    paramT.mSdv = ((SimpleDraweeView)Utils.castView(localView, 2131691098, "field 'mSdv'", SimpleDraweeView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131694265, "field 'mTvAccount' and method 'onViewClick'");
    paramT.mTvAccount = ((TextView)Utils.castView(localView, 2131694265, "field 'mTvAccount'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131694266, "field 'mTvIncome' and method 'onViewClick'");
    paramT.mTvIncome = ((TextView)Utils.castView(localView, 2131694266, "field 'mTvIncome'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690695, "field 'mTvService' and method 'onViewClick'");
    paramT.mTvService = ((TextView)Utils.castView(localView, 2131690695, "field 'mTvService'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131694260, "field 'mTvUpHouseRanking' and method 'onViewClick'");
    paramT.mTvUpHouseRanking = ((TextView)Utils.castView(localView, 2131694260, "field 'mTvUpHouseRanking'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691571, "field 'mTvInfo' and method 'onViewClick'");
    paramT.mTvInfo = ((TextView)Utils.castView(localView, 2131691571, "field 'mTvInfo'", TextView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.mTvAuthInfo = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694270, "field 'mTvAuthInfo'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131694269, "field 'mRlAuthInfo' and method 'onViewClick'");
    paramT.mRlAuthInfo = ((RelativeLayout)Utils.castView(localView, 2131694269, "field 'mRlAuthInfo'", RelativeLayout.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689835, "field 'mTvTips' and method 'onViewClick'");
    paramT.mTvTips = ((TextView)Utils.castView(localView, 2131689835, "field 'mTvTips'", TextView.class));
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.mTvCustomerService = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694272, "field 'mTvCustomerService'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131694271, "field 'mRlCustomerService' and method 'onViewClick'");
    paramT.mRlCustomerService = ((RelativeLayout)Utils.castView(localView, 2131694271, "field 'mRlCustomerService'", RelativeLayout.class));
    this.k = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691491, "field 'mTvSuggestion' and method 'onViewClick'");
    paramT.mTvSuggestion = ((TextView)Utils.castView(localView, 2131691491, "field 'mTvSuggestion'", TextView.class));
    this.l = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690319, "field 'mTvAgreement' and method 'onViewClick'");
    paramT.mTvAgreement = ((TextView)Utils.castView(localView, 2131690319, "field 'mTvAgreement'", TextView.class));
    this.m = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.mOsv = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131691157, "field 'mOsv'", ObservableScrollView.class));
    localView = Utils.findRequiredView(paramView, 2131694274, "field 'changeMode' and method 'onViewClick'");
    paramT.changeMode = ((LinearLayout)Utils.castView(localView, 2131694274, "field 'changeMode'", LinearLayout.class));
    this.n = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.mAngel = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131694262, "field 'mAngel'", ImageView.class));
    paramT.mYear5 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131694264, "field 'mYear5'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131694273, "field 'logout' and method 'onViewClick'");
    paramT.logout = ((TextView)Utils.castView(localView, 2131694273, "field 'logout'", TextView.class));
    this.o = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.tvMinsuEva = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694268, "field 'tvMinsuEva'", TextView.class));
    paramT.tv_header_msg = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694263, "field 'tv_header_msg'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131694267, "method 'onViewClick'");
    this.p = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    MinsuLLMyFragment localMinsuLLMyFragment = this.a;
    if (localMinsuLLMyFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuLLMyFragment.mSdvBg = null;
    localMinsuLLMyFragment.mTvName = null;
    localMinsuLLMyFragment.mSdv = null;
    localMinsuLLMyFragment.mTvAccount = null;
    localMinsuLLMyFragment.mTvIncome = null;
    localMinsuLLMyFragment.mTvService = null;
    localMinsuLLMyFragment.mTvUpHouseRanking = null;
    localMinsuLLMyFragment.mTvInfo = null;
    localMinsuLLMyFragment.mTvAuthInfo = null;
    localMinsuLLMyFragment.mRlAuthInfo = null;
    localMinsuLLMyFragment.mTvTips = null;
    localMinsuLLMyFragment.mTvCustomerService = null;
    localMinsuLLMyFragment.mRlCustomerService = null;
    localMinsuLLMyFragment.mTvSuggestion = null;
    localMinsuLLMyFragment.mTvAgreement = null;
    localMinsuLLMyFragment.mOsv = null;
    localMinsuLLMyFragment.changeMode = null;
    localMinsuLLMyFragment.mAngel = null;
    localMinsuLLMyFragment.mYear5 = null;
    localMinsuLLMyFragment.logout = null;
    localMinsuLLMyFragment.tvMinsuEva = null;
    localMinsuLLMyFragment.tv_header_msg = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.g.setOnClickListener(null);
    this.g = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.i.setOnClickListener(null);
    this.i = null;
    this.j.setOnClickListener(null);
    this.j = null;
    this.k.setOnClickListener(null);
    this.k = null;
    this.l.setOnClickListener(null);
    this.l = null;
    this.m.setOnClickListener(null);
    this.m = null;
    this.n.setOnClickListener(null);
    this.n = null;
    this.o.setOnClickListener(null);
    this.o = null;
    this.p.setOnClickListener(null);
    this.p = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/fragment/MinsuLLMyFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */