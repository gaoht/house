package com.ziroom.ziroomcustomer.social.activity.ac;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView;

public class AcMainActivity_ViewBinding<T extends AcMainActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public AcMainActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'mIvBack' and method 'onViewClicked'");
    paramT.mIvBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'mIvBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mTvCity = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692497, "field 'mTvCity'", TextView.class));
    paramT.mSbwv = ((ScrollBridgeWebView)Utils.findRequiredViewAsType(paramView, 2131692499, "field 'mSbwv'", ScrollBridgeWebView.class));
    paramT.mPb = ((ProgressBar)Utils.findRequiredViewAsType(paramView, 2131690674, "field 'mPb'", ProgressBar.class));
    localView = Utils.findRequiredView(paramView, 2131692496, "method 'onViewClicked'");
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131692498, "method 'onViewClicked'");
    this.d = paramView;
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
    AcMainActivity localAcMainActivity = this.a;
    if (localAcMainActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localAcMainActivity.mIvBack = null;
    localAcMainActivity.mTvCity = null;
    localAcMainActivity.mSbwv = null;
    localAcMainActivity.mPb = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcMainActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */