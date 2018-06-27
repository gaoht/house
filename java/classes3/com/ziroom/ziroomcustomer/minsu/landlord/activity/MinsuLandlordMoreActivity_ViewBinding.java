package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuLandlordMoreActivity_ViewBinding<T extends MinsuLandlordMoreActivity>
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
  
  public MinsuLandlordMoreActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    View localView = Utils.findRequiredView(paramView, 2131691487, "field 'tvPeopleMessage' and method 'onViewClicked'");
    paramT.tvPeopleMessage = ((TextView)Utils.castView(localView, 2131691487, "field 'tvPeopleMessage'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691488, "field 'tvAuthentication' and method 'onViewClicked'");
    paramT.tvAuthentication = ((TextView)Utils.castView(localView, 2131691488, "field 'tvAuthentication'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691489, "field 'tvServiceAbout' and method 'onViewClicked'");
    paramT.tvServiceAbout = ((TextView)Utils.castView(localView, 2131691489, "field 'tvServiceAbout'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691490, "field 'tvContract' and method 'onViewClicked'");
    paramT.tvContract = ((TextView)Utils.castView(localView, 2131691490, "field 'tvContract'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691491, "field 'tvSuggestion' and method 'onViewClicked'");
    paramT.tvSuggestion = ((TextView)Utils.castView(localView, 2131691491, "field 'tvSuggestion'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690319, "field 'tvAgreement' and method 'onViewClicked'");
    paramT.tvAgreement = ((TextView)Utils.castView(localView, 2131690319, "field 'tvAgreement'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131691492, "field 'tvQuit' and method 'onViewClicked'");
    paramT.tvQuit = ((TextView)Utils.castView(paramView, 2131691492, "field 'tvQuit'", TextView.class));
    this.h = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    MinsuLandlordMoreActivity localMinsuLandlordMoreActivity = this.a;
    if (localMinsuLandlordMoreActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuLandlordMoreActivity.commonTitle = null;
    localMinsuLandlordMoreActivity.tvPeopleMessage = null;
    localMinsuLandlordMoreActivity.tvAuthentication = null;
    localMinsuLandlordMoreActivity.tvServiceAbout = null;
    localMinsuLandlordMoreActivity.tvContract = null;
    localMinsuLandlordMoreActivity.tvSuggestion = null;
    localMinsuLandlordMoreActivity.tvAgreement = null;
    localMinsuLandlordMoreActivity.tvQuit = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/MinsuLandlordMoreActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */