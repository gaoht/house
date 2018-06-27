package com.ziroom.ziroomcustomer.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class RentCardActivity_ViewBinding<T extends RentCardActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public RentCardActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131697381, "field 'rent_card_use' and method 'onViewClick'");
    paramT.rent_card_use = ((TextView)Utils.castView(localView, 2131697381, "field 'rent_card_use'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.mLv = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689817, "field 'mLv'", ListView.class));
    paramT.mFlEmpty = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691788, "field 'mFlEmpty'", FrameLayout.class));
    paramT.mTvEmpty = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691829, "field 'mTvEmpty'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131689895, "method 'onViewClick'");
    this.c = paramView;
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
    RentCardActivity localRentCardActivity = this.a;
    if (localRentCardActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localRentCardActivity.mTvTitle = null;
    localRentCardActivity.rent_card_use = null;
    localRentCardActivity.mLv = null;
    localRentCardActivity.mFlEmpty = null;
    localRentCardActivity.mTvEmpty = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/RentCardActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */