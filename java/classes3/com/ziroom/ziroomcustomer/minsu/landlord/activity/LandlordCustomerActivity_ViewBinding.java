package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.landlord.views.MyListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class LandlordCustomerActivity_ViewBinding<T extends LandlordCustomerActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public LandlordCustomerActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691452, "field 'imgClose' and method 'onViewClicked'");
    paramT.imgClose = ((ImageView)Utils.castView(localView, 2131691452, "field 'imgClose'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.vBottomLine = Utils.findRequiredView(paramView, 2131691453, "field 'vBottomLine'");
    paramT.svContent = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'svContent'", ObservableScrollView.class));
    paramT.list = ((MyListView)Utils.findRequiredViewAsType(paramView, 2131691217, "field 'list'", MyListView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
  }
  
  public void unbind()
  {
    LandlordCustomerActivity localLandlordCustomerActivity = this.a;
    if (localLandlordCustomerActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordCustomerActivity.imgClose = null;
    localLandlordCustomerActivity.vBottomLine = null;
    localLandlordCustomerActivity.svContent = null;
    localLandlordCustomerActivity.list = null;
    localLandlordCustomerActivity.tvTitle = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/LandlordCustomerActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */