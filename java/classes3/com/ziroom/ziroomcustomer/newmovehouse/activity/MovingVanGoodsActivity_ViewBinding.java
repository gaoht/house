package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MovingVanGoodsActivity_ViewBinding<T extends MovingVanGoodsActivity>
  implements Unbinder
{
  protected T a;
  
  public MovingVanGoodsActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mLv = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689817, "field 'mLv'", ListView.class));
    paramT.mTvPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689912, "field 'mTvPrice'", TextView.class));
    paramT.mBtnSubmit = ((Button)Utils.findRequiredViewAsType(paramView, 2131689816, "field 'mBtnSubmit'", Button.class));
    paramT.mFlEmpty = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691788, "field 'mFlEmpty'", FrameLayout.class));
    paramT.mLlBottom = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689838, "field 'mLlBottom'", LinearLayout.class));
  }
  
  public void unbind()
  {
    MovingVanGoodsActivity localMovingVanGoodsActivity = this.a;
    if (localMovingVanGoodsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMovingVanGoodsActivity.mLv = null;
    localMovingVanGoodsActivity.mTvPrice = null;
    localMovingVanGoodsActivity.mBtnSubmit = null;
    localMovingVanGoodsActivity.mFlEmpty = null;
    localMovingVanGoodsActivity.mLlBottom = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MovingVanGoodsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */