package com.ziroom.ziroomcustomer.social.activity.ac;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class AcEnrollSuccessActivity_ViewBinding<T extends AcEnrollSuccessActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public AcEnrollSuccessActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mTvMsg = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689823, "field 'mTvMsg'", TextView.class));
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
    paramT.mLlButtons = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689824, "field 'mLlButtons'", LinearLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131689826, "field 'mTvShare' and method 'onViewClicked'");
    paramT.mTvShare = ((TextView)Utils.castView(paramView, 2131689826, "field 'mTvShare'", TextView.class));
    this.c = paramView;
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
    AcEnrollSuccessActivity localAcEnrollSuccessActivity = this.a;
    if (localAcEnrollSuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localAcEnrollSuccessActivity.mTvMsg = null;
    localAcEnrollSuccessActivity.mIvBack = null;
    localAcEnrollSuccessActivity.mLlButtons = null;
    localAcEnrollSuccessActivity.mTvShare = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcEnrollSuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */