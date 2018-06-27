package com.ziroom.ziroomcustomer.minsu.landlordrelease.qualification;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;

public class QApersonalActivity_ViewBinding<T extends QApersonalActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public QApersonalActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691061, "field 'contact_way' and method 'onClick'");
    paramT.contact_way = ((RelativeLayout)Utils.castView(localView, 2131691061, "field 'contact_way'", RelativeLayout.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.contact_status = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691063, "field 'contact_status'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691065, "field 'identity_information' and method 'onClick'");
    paramT.identity_information = ((RelativeLayout)Utils.castView(localView, 2131691065, "field 'identity_information'", RelativeLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.identity_status = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691067, "field 'identity_status'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691069, "field 'personal_information' and method 'onClick'");
    paramT.personal_information = ((RelativeLayout)Utils.castView(localView, 2131691069, "field 'personal_information'", RelativeLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.personal_status = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691071, "field 'personal_status'", TextView.class));
    paramT.release_usage_tips = ((ReleaseUsageAndTipsView)Utils.findRequiredViewAsType(paramView, 2131691073, "field 'release_usage_tips'", ReleaseUsageAndTipsView.class));
    localView = Utils.findRequiredView(paramView, 2131691074, "field 'release' and method 'onClick'");
    paramT.release = ((Button)Utils.castView(localView, 2131691074, "field 'release'", Button.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131691059, "method 'onClick'");
    this.f = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    QApersonalActivity localQApersonalActivity = this.a;
    if (localQApersonalActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localQApersonalActivity.contact_way = null;
    localQApersonalActivity.contact_status = null;
    localQApersonalActivity.identity_information = null;
    localQApersonalActivity.identity_status = null;
    localQApersonalActivity.personal_information = null;
    localQApersonalActivity.personal_status = null;
    localQApersonalActivity.release_usage_tips = null;
    localQApersonalActivity.release = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/qualification/QApersonalActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */