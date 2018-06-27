package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.MinsuEvaItemView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class MinsuEvaluetionActivity_ViewBinding<T extends MinsuEvaluetionActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuEvaluetionActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.sv_content = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'sv_content'", ObservableScrollView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.tvContentTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691573, "field 'tvContentTime'", TextView.class));
    paramT.tvContentPerson = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691576, "field 'tvContentPerson'", TextView.class));
    paramT.tvContentPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691575, "field 'tvContentPrice'", TextView.class));
    paramT.iv = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691574, "field 'iv'", SimpleDraweeView.class));
    paramT.evaItem1 = ((MinsuEvaItemView)Utils.findRequiredViewAsType(paramView, 2131691578, "field 'evaItem1'", MinsuEvaItemView.class));
    paramT.lineEva1 = Utils.findRequiredView(paramView, 2131691579, "field 'lineEva1'");
    paramT.evaItem2 = ((MinsuEvaItemView)Utils.findRequiredViewAsType(paramView, 2131691580, "field 'evaItem2'", MinsuEvaItemView.class));
    paramT.tvTip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689837, "field 'tvTip'", TextView.class));
    paramT.tvInfo = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691571, "field 'tvInfo'", TextView.class));
    paramT.tvNext = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691581, "field 'tvNext'", TextView.class));
    paramT.rlOrder = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691572, "field 'rlOrder'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    MinsuEvaluetionActivity localMinsuEvaluetionActivity = this.a;
    if (localMinsuEvaluetionActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuEvaluetionActivity.commonTitle = null;
    localMinsuEvaluetionActivity.sv_content = null;
    localMinsuEvaluetionActivity.tvTitle = null;
    localMinsuEvaluetionActivity.tvContentTime = null;
    localMinsuEvaluetionActivity.tvContentPerson = null;
    localMinsuEvaluetionActivity.tvContentPrice = null;
    localMinsuEvaluetionActivity.iv = null;
    localMinsuEvaluetionActivity.evaItem1 = null;
    localMinsuEvaluetionActivity.lineEva1 = null;
    localMinsuEvaluetionActivity.evaItem2 = null;
    localMinsuEvaluetionActivity.tvTip = null;
    localMinsuEvaluetionActivity.tvInfo = null;
    localMinsuEvaluetionActivity.tvNext = null;
    localMinsuEvaluetionActivity.rlOrder = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuEvaluetionActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */