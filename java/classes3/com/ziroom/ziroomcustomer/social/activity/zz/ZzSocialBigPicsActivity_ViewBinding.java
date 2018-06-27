package com.ziroom.ziroomcustomer.social.activity.zz;

import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.BaseViewPager;

public class ZzSocialBigPicsActivity_ViewBinding<T extends ZzSocialBigPicsActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public ZzSocialBigPicsActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690960, "field 'viewPager' and method 'onViewClicked'");
    paramT.viewPager = ((BaseViewPager)Utils.castView(localView, 2131690960, "field 'viewPager'", BaseViewPager.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked();
      }
    });
    paramT.viewGroup = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131693062, "field 'viewGroup'", LinearLayout.class));
  }
  
  public void unbind()
  {
    ZzSocialBigPicsActivity localZzSocialBigPicsActivity = this.a;
    if (localZzSocialBigPicsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZzSocialBigPicsActivity.viewPager = null;
    localZzSocialBigPicsActivity.viewGroup = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialBigPicsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */