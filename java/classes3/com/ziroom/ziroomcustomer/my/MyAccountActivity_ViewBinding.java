package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MyAccountActivity_ViewBinding<T extends MyAccountActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  
  public MyAccountActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mTvPhone = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690666, "field 'mTvPhone'", TextView.class));
    paramT.mTvEmail = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691823, "field 'mTvEmail'", TextView.class));
    paramT.mTvUsername = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691821, "field 'mTvUsername'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131691820, "method 'onViewClick'");
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690984, "method 'onViewClick'");
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691822, "method 'onViewClick'");
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691824, "method 'onViewClick'");
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689895, "method 'onViewClick'");
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131691825, "method 'onViewClick'");
    this.g = paramView;
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
    MyAccountActivity localMyAccountActivity = this.a;
    if (localMyAccountActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyAccountActivity.mTvPhone = null;
    localMyAccountActivity.mTvEmail = null;
    localMyAccountActivity.mTvUsername = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyAccountActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */