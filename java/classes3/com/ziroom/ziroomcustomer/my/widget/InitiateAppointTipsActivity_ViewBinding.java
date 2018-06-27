package com.ziroom.ziroomcustomer.my.widget;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;

public class InitiateAppointTipsActivity_ViewBinding<T extends InitiateAppointTipsActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public InitiateAppointTipsActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
    paramT.mTvSubtitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690071, "field 'mTvSubtitle'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131690973, "field 'mTvToAppoint' and method 'onViewClicked'");
    paramT.mTvToAppoint = ((TextView)Utils.castView(localView, 2131690973, "field 'mTvToAppoint'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690974, "field 'mTvFindHouse' and method 'onViewClicked'");
    paramT.mTvFindHouse = ((TextView)Utils.castView(localView, 2131690974, "field 'mTvFindHouse'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mTvTipsTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690975, "field 'mTvTipsTitle'", TextView.class));
    paramT.mTvTipsContent = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690976, "field 'mTvTipsContent'", TextView.class));
    paramT.mCbBanner = ((ConvenientBanner)Utils.findRequiredViewAsType(paramView, 2131690977, "field 'mCbBanner'", ConvenientBanner.class));
  }
  
  public void unbind()
  {
    InitiateAppointTipsActivity localInitiateAppointTipsActivity = this.a;
    if (localInitiateAppointTipsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localInitiateAppointTipsActivity.mTvTitle = null;
    localInitiateAppointTipsActivity.mTvSubtitle = null;
    localInitiateAppointTipsActivity.mTvToAppoint = null;
    localInitiateAppointTipsActivity.mTvFindHouse = null;
    localInitiateAppointTipsActivity.mTvTipsTitle = null;
    localInitiateAppointTipsActivity.mTvTipsContent = null;
    localInitiateAppointTipsActivity.mCbBanner = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/InitiateAppointTipsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */