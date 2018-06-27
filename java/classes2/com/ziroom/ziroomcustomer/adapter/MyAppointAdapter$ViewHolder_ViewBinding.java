package com.ziroom.ziroomcustomer.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class MyAppointAdapter$ViewHolder_ViewBinding<T extends MyAppointAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public MyAppointAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tvAppointTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694329, "field 'tvAppointTime'", TextView.class));
    paramT.tvAppointLocation = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695403, "field 'tvAppointLocation'", TextView.class));
    paramT.tvAppointStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695402, "field 'tvAppointStatus'", TextView.class));
    paramT.ivAppointPic = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695405, "field 'ivAppointPic'", SimpleDraweeView.class));
    paramT.tvAppointTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695407, "field 'tvAppointTitle'", TextView.class));
    paramT.tvAppointArea = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695408, "field 'tvAppointArea'", TextView.class));
    paramT.tvAppointPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695409, "field 'tvAppointPrice'", TextView.class));
    paramT.tvAppointUnit = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695410, "field 'tvAppointUnit'", TextView.class));
    paramT.tvHouseStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695071, "field 'tvHouseStatus'", TextView.class));
    paramT.ivKeeperPic = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695401, "field 'ivKeeperPic'", SimpleDraweeView.class));
    paramT.tvKeeperName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694731, "field 'tvKeeperName'", TextView.class));
    paramT.tvKeeperTel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695411, "field 'tvKeeperTel'", TextView.class));
    paramT.tvAppointCancel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695412, "field 'tvAppointCancel'", TextView.class));
    paramT.tvAppointDel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695415, "field 'tvAppointDel'", TextView.class));
    paramT.tvAppointEvaluate = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695413, "field 'tvAppointEvaluate'", TextView.class));
    paramT.tvAppointSeeEvaluate = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695414, "field 'tvAppointSeeEvaluate'", TextView.class));
    paramT.ll_button_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689498, "field 'll_button_container'", LinearLayout.class));
    paramT.ll_appoint = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695406, "field 'll_appoint'", LinearLayout.class));
    paramT.tv_appoint_hint = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695404, "field 'tv_appoint_hint'", TextView.class));
  }
  
  public void unbind()
  {
    MyAppointAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.tvAppointTime = null;
    localViewHolder.tvAppointLocation = null;
    localViewHolder.tvAppointStatus = null;
    localViewHolder.ivAppointPic = null;
    localViewHolder.tvAppointTitle = null;
    localViewHolder.tvAppointArea = null;
    localViewHolder.tvAppointPrice = null;
    localViewHolder.tvAppointUnit = null;
    localViewHolder.tvHouseStatus = null;
    localViewHolder.ivKeeperPic = null;
    localViewHolder.tvKeeperName = null;
    localViewHolder.tvKeeperTel = null;
    localViewHolder.tvAppointCancel = null;
    localViewHolder.tvAppointDel = null;
    localViewHolder.tvAppointEvaluate = null;
    localViewHolder.tvAppointSeeEvaluate = null;
    localViewHolder.ll_button_container = null;
    localViewHolder.ll_appoint = null;
    localViewHolder.tv_appoint_hint = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/MyAppointAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */