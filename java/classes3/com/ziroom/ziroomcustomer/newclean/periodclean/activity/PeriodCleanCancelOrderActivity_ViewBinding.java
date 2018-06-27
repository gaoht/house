package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.landlord.views.MyListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class PeriodCleanCancelOrderActivity_ViewBinding<T extends PeriodCleanCancelOrderActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public PeriodCleanCancelOrderActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.rlTitle = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689808, "field 'rlTitle'", RelativeLayout.class));
    paramT.vBottomLine = Utils.findRequiredView(paramView, 2131691453, "field 'vBottomLine'");
    paramT.tvMessage = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689850, "field 'tvMessage'", TextView.class));
    paramT.listReason = ((MyListView)Utils.findRequiredViewAsType(paramView, 2131691550, "field 'listReason'", MyListView.class));
    paramT.etRemark = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690002, "field 'etRemark'", EditText.class));
    paramT.tvCurrentNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690403, "field 'tvCurrentNum'", TextView.class));
    paramT.tvMaxNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690404, "field 'tvMaxNum'", TextView.class));
    paramT.rlDescInfo = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131690402, "field 'rlDescInfo'", FrameLayout.class));
    paramT.svContent = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'svContent'", ObservableScrollView.class));
    paramView = Utils.findRequiredView(paramView, 2131690953, "field 'tvSave' and method 'onViewClicked'");
    paramT.tvSave = ((TextView)Utils.castView(paramView, 2131690953, "field 'tvSave'", TextView.class));
    this.c = paramView;
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
    PeriodCleanCancelOrderActivity localPeriodCleanCancelOrderActivity = this.a;
    if (localPeriodCleanCancelOrderActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPeriodCleanCancelOrderActivity.ivBack = null;
    localPeriodCleanCancelOrderActivity.tvTitle = null;
    localPeriodCleanCancelOrderActivity.rlTitle = null;
    localPeriodCleanCancelOrderActivity.vBottomLine = null;
    localPeriodCleanCancelOrderActivity.tvMessage = null;
    localPeriodCleanCancelOrderActivity.listReason = null;
    localPeriodCleanCancelOrderActivity.etRemark = null;
    localPeriodCleanCancelOrderActivity.tvCurrentNum = null;
    localPeriodCleanCancelOrderActivity.tvMaxNum = null;
    localPeriodCleanCancelOrderActivity.rlDescInfo = null;
    localPeriodCleanCancelOrderActivity.svContent = null;
    localPeriodCleanCancelOrderActivity.tvSave = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanCancelOrderActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */