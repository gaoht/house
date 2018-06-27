package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.landlord.views.MyListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class LandlordRefuseReasonActivity_ViewBinding<T extends LandlordRefuseReasonActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public LandlordRefuseReasonActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.listReason = ((MyListView)Utils.findRequiredViewAsType(paramView, 2131691550, "field 'listReason'", MyListView.class));
    paramT.etRemark = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690002, "field 'etRemark'", EditText.class));
    paramT.tvCurrentNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690403, "field 'tvCurrentNum'", TextView.class));
    paramT.tvMaxNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690404, "field 'tvMaxNum'", TextView.class));
    paramT.rlDescInfo = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131690402, "field 'rlDescInfo'", FrameLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690953, "field 'tvSave' and method 'onViewClicked'");
    paramT.tvSave = ((TextView)Utils.castView(localView, 2131690953, "field 'tvSave'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
  }
  
  public void unbind()
  {
    LandlordRefuseReasonActivity localLandlordRefuseReasonActivity = this.a;
    if (localLandlordRefuseReasonActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordRefuseReasonActivity.imgClose = null;
    localLandlordRefuseReasonActivity.vBottomLine = null;
    localLandlordRefuseReasonActivity.svContent = null;
    localLandlordRefuseReasonActivity.listReason = null;
    localLandlordRefuseReasonActivity.etRemark = null;
    localLandlordRefuseReasonActivity.tvCurrentNum = null;
    localLandlordRefuseReasonActivity.tvMaxNum = null;
    localLandlordRefuseReasonActivity.rlDescInfo = null;
    localLandlordRefuseReasonActivity.tvSave = null;
    localLandlordRefuseReasonActivity.tvTitle = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/LandlordRefuseReasonActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */