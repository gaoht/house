package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class ZryuRentCardActivity_ViewBinding<T extends ZryuRentCardActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public ZryuRentCardActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689895, "field 'tvBack' and method 'onViewClick'");
    paramT.tvBack = ((ImageView)Utils.castView(localView, 2131689895, "field 'tvBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692909, "field 'tvSelectCancelAll' and method 'onViewClick'");
    paramT.tvSelectCancelAll = ((TextView)Utils.castView(localView, 2131692909, "field 'tvSelectCancelAll'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
    paramT.mLv = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689817, "field 'mLv'", ListView.class));
    paramT.mFlEmpty = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691788, "field 'mFlEmpty'", FrameLayout.class));
    paramT.mTvEmpty = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691829, "field 'mTvEmpty'", TextView.class));
  }
  
  public void unbind()
  {
    ZryuRentCardActivity localZryuRentCardActivity = this.a;
    if (localZryuRentCardActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuRentCardActivity.tvBack = null;
    localZryuRentCardActivity.tvSelectCancelAll = null;
    localZryuRentCardActivity.mTvTitle = null;
    localZryuRentCardActivity.mLv = null;
    localZryuRentCardActivity.mFlEmpty = null;
    localZryuRentCardActivity.mTvEmpty = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuRentCardActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */