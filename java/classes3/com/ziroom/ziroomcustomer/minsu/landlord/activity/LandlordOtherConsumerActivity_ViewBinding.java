package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LandlordOtherConsumerActivity_ViewBinding<T extends LandlordOtherConsumerActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public LandlordOtherConsumerActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.etRemark = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690002, "field 'etRemark'", EditText.class));
    paramT.tvCurrentNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690403, "field 'tvCurrentNum'", TextView.class));
    paramT.tvMaxNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690404, "field 'tvMaxNum'", TextView.class));
    paramT.flDescInfo = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691548, "field 'flDescInfo'", FrameLayout.class));
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
    paramT.editText = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691545, "field 'editText'", EditText.class));
    paramT.edDetail = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691547, "field 'edDetail'", EditText.class));
    paramT.tvName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'tvName'", TextView.class));
    paramT.tvValue = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691546, "field 'tvValue'", TextView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.tvSymble = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691544, "field 'tvSymble'", TextView.class));
  }
  
  public void unbind()
  {
    LandlordOtherConsumerActivity localLandlordOtherConsumerActivity = this.a;
    if (localLandlordOtherConsumerActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordOtherConsumerActivity.imgClose = null;
    localLandlordOtherConsumerActivity.etRemark = null;
    localLandlordOtherConsumerActivity.tvCurrentNum = null;
    localLandlordOtherConsumerActivity.tvMaxNum = null;
    localLandlordOtherConsumerActivity.flDescInfo = null;
    localLandlordOtherConsumerActivity.tvSave = null;
    localLandlordOtherConsumerActivity.editText = null;
    localLandlordOtherConsumerActivity.edDetail = null;
    localLandlordOtherConsumerActivity.tvName = null;
    localLandlordOtherConsumerActivity.tvValue = null;
    localLandlordOtherConsumerActivity.tvTitle = null;
    localLandlordOtherConsumerActivity.tvSymble = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/LandlordOtherConsumerActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */