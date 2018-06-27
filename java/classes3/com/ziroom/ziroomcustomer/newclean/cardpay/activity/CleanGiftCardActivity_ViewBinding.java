package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class CleanGiftCardActivity_ViewBinding<T extends CleanGiftCardActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public CleanGiftCardActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked();
      }
    });
    paramT.tabs = ((TabLayout)Utils.findRequiredViewAsType(paramView, 2131690261, "field 'tabs'", TabLayout.class));
    paramT.viewpage = ((ViewPager)Utils.findRequiredViewAsType(paramView, 2131690262, "field 'viewpage'", ViewPager.class));
    paramT.rlBaseTitle = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689768, "field 'rlBaseTitle'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    CleanGiftCardActivity localCleanGiftCardActivity = this.a;
    if (localCleanGiftCardActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localCleanGiftCardActivity.ivBack = null;
    localCleanGiftCardActivity.tabs = null;
    localCleanGiftCardActivity.viewpage = null;
    localCleanGiftCardActivity.rlBaseTitle = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/CleanGiftCardActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */