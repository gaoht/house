package com.ziroom.ziroomcustomer.social.activity.ac;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class AcListActivity_ViewBinding<T extends AcListActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public AcListActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.mTvRunning = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689829, "field 'mTvRunning'", TextView.class));
    paramT.mTvEnd = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689832, "field 'mTvEnd'", TextView.class));
    paramT.mTvTips = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689835, "field 'mTvTips'", TextView.class));
    paramT.mLlTips = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689834, "field 'mLlTips'", LinearLayout.class));
    paramT.mVRunningIndicator = Utils.findRequiredView(paramView, 2131689830, "field 'mVRunningIndicator'");
    paramT.mVEndIndicator = Utils.findRequiredView(paramView, 2131689833, "field 'mVEndIndicator'");
    paramT.mLv = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689817, "field 'mLv'", ListView.class));
    localView = Utils.findRequiredView(paramView, 2131689828, "method 'onViewClicked'");
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131689831, "method 'onViewClicked'");
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
    AcListActivity localAcListActivity = this.a;
    if (localAcListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localAcListActivity.mIvBack = null;
    localAcListActivity.mTvRunning = null;
    localAcListActivity.mTvEnd = null;
    localAcListActivity.mTvTips = null;
    localAcListActivity.mLlTips = null;
    localAcListActivity.mVRunningIndicator = null;
    localAcListActivity.mVEndIndicator = null;
    localAcListActivity.mLv = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */