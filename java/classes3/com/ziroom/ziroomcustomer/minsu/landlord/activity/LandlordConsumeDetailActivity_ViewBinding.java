package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.landlord.views.MyListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class LandlordConsumeDetailActivity_ViewBinding<T extends LandlordConsumeDetailActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public LandlordConsumeDetailActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.tvZonMoney = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691454, "field 'tvZonMoney'", TextView.class));
    paramT.list = ((MyListView)Utils.findRequiredViewAsType(paramView, 2131691217, "field 'list'", MyListView.class));
    paramT.listSublit = ((MyListView)Utils.findRequiredViewAsType(paramView, 2131691455, "field 'listSublit'", MyListView.class));
  }
  
  public void unbind()
  {
    LandlordConsumeDetailActivity localLandlordConsumeDetailActivity = this.a;
    if (localLandlordConsumeDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordConsumeDetailActivity.imgClose = null;
    localLandlordConsumeDetailActivity.vBottomLine = null;
    localLandlordConsumeDetailActivity.svContent = null;
    localLandlordConsumeDetailActivity.tvTitle = null;
    localLandlordConsumeDetailActivity.tvZonMoney = null;
    localLandlordConsumeDetailActivity.list = null;
    localLandlordConsumeDetailActivity.listSublit = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/LandlordConsumeDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */