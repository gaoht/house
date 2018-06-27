package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MovingVanBulkyActivity_ViewBinding<T extends MovingVanBulkyActivity>
  implements Unbinder
{
  protected T a;
  
  public MovingVanBulkyActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mFl = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131690607, "field 'mFl'", FrameLayout.class));
    paramT.mTvPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689912, "field 'mTvPrice'", TextView.class));
    paramT.mBtnSubmit = ((Button)Utils.findRequiredViewAsType(paramView, 2131689816, "field 'mBtnSubmit'", Button.class));
    paramT.mIvPrice = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691807, "field 'mIvPrice'", ImageView.class));
  }
  
  public void unbind()
  {
    MovingVanBulkyActivity localMovingVanBulkyActivity = this.a;
    if (localMovingVanBulkyActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMovingVanBulkyActivity.mFl = null;
    localMovingVanBulkyActivity.mTvPrice = null;
    localMovingVanBulkyActivity.mBtnSubmit = null;
    localMovingVanBulkyActivity.mIvPrice = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MovingVanBulkyActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */