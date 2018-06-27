package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.widget.ReMeasureRecyclerView;

public class MoveRecFragment_ViewBinding<T extends MoveRecFragment>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public MoveRecFragment_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tvSize = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696330, "field 'tvSize'", TextView.class));
    paramT.tvIndex = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695659, "field 'tvIndex'", TextView.class));
    paramT.tvRecStandard = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696331, "field 'tvRecStandard'", TextView.class));
    paramT.sdvMoveRec = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131696332, "field 'sdvMoveRec'", SimpleDraweeView.class));
    paramT.rvRecSelect = ((ReMeasureRecyclerView)Utils.findRequiredViewAsType(paramView, 2131696333, "field 'rvRecSelect'", ReMeasureRecyclerView.class));
    paramT.svMoveRecContainer = ((ScrollView)Utils.findRequiredViewAsType(paramView, 2131696329, "field 'svMoveRecContainer'", ScrollView.class));
    paramT.sdvMoveRecResult = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131696335, "field 'sdvMoveRecResult'", SimpleDraweeView.class));
    paramT.tvMoveRecResultType = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696336, "field 'tvMoveRecResultType'", TextView.class));
    paramT.tvMoveRecResultYuan = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696337, "field 'tvMoveRecResultYuan'", TextView.class));
    paramT.tvMoveRecResultMoney = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696338, "field 'tvMoveRecResultMoney'", TextView.class));
    paramT.tvMoveRecResultTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696339, "field 'tvMoveRecResultTime'", TextView.class));
    paramT.tvMoveRecResultDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696340, "field 'tvMoveRecResultDesc'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131694350, "field 'btnDetail' and method 'click'");
    paramT.btnDetail = ((Button)Utils.castView(localView, 2131694350, "field 'btnDetail'", Button.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.click(paramAnonymousView);
      }
    });
    paramT.llMoveRecResultContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696334, "field 'llMoveRecResultContainer'", LinearLayout.class));
  }
  
  public void unbind()
  {
    MoveRecFragment localMoveRecFragment = this.a;
    if (localMoveRecFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMoveRecFragment.tvSize = null;
    localMoveRecFragment.tvIndex = null;
    localMoveRecFragment.tvRecStandard = null;
    localMoveRecFragment.sdvMoveRec = null;
    localMoveRecFragment.rvRecSelect = null;
    localMoveRecFragment.svMoveRecContainer = null;
    localMoveRecFragment.sdvMoveRecResult = null;
    localMoveRecFragment.tvMoveRecResultType = null;
    localMoveRecFragment.tvMoveRecResultYuan = null;
    localMoveRecFragment.tvMoveRecResultMoney = null;
    localMoveRecFragment.tvMoveRecResultTime = null;
    localMoveRecFragment.tvMoveRecResultDesc = null;
    localMoveRecFragment.btnDetail = null;
    localMoveRecFragment.llMoveRecResultContainer = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/MoveRecFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */