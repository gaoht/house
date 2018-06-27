package com.ziroom.ziroomcustomer.my.aboutus;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class AboutUsActivity_ViewBinding<T extends AboutUsActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public AboutUsActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131695948, "field 'commonTitleIvBack' and method 'onViewClicked'");
    paramT.commonTitleIvBack = ((ImageView)Utils.castView(localView, 2131695948, "field 'commonTitleIvBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.commonTitleTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695949, "field 'commonTitleTvTitle'", TextView.class));
    paramT.commonTitleTvRightButton = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695950, "field 'commonTitleTvRightButton'", TextView.class));
    paramT.commonTitleDivideLine = Utils.findRequiredView(paramView, 2131695951, "field 'commonTitleDivideLine'");
    localView = Utils.findRequiredView(paramView, 2131689804, "field 'llServiceAndHelp' and method 'onViewClicked'");
    paramT.llServiceAndHelp = ((LinearLayout)Utils.castView(localView, 2131689804, "field 'llServiceAndHelp'", LinearLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.viewHasUpdateSign = Utils.findRequiredView(paramView, 2131689806, "field 'viewHasUpdateSign'");
    paramT.tvCurrentVersion = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689807, "field 'tvCurrentVersion'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131689805, "field 'llCurrVersion' and method 'onViewClicked'");
    paramT.llCurrVersion = ((LinearLayout)Utils.castView(paramView, 2131689805, "field 'llCurrVersion'", LinearLayout.class));
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
    AboutUsActivity localAboutUsActivity = this.a;
    if (localAboutUsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localAboutUsActivity.commonTitleIvBack = null;
    localAboutUsActivity.commonTitleTvTitle = null;
    localAboutUsActivity.commonTitleTvRightButton = null;
    localAboutUsActivity.commonTitleDivideLine = null;
    localAboutUsActivity.llServiceAndHelp = null;
    localAboutUsActivity.viewHasUpdateSign = null;
    localAboutUsActivity.tvCurrentVersion = null;
    localAboutUsActivity.llCurrVersion = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/aboutus/AboutUsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */