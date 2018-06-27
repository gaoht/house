package com.ziroom.ziroomcustomer.minsu.landlordangel;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class LandlordAngelActivity_ViewBinding<T extends LandlordAngelActivity>
  implements Unbinder
{
  protected T a;
  
  public LandlordAngelActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tv_landlord_angel_pre_arrowright = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691051, "field 'tv_landlord_angel_pre_arrowright'", TextView.class));
    paramT.tv_landlord_angel_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691044, "field 'tv_landlord_angel_title'", TextView.class));
    paramT.tv_landlord_angel_describe = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691046, "field 'tv_landlord_angel_describe'", TextView.class));
    paramT.tv_landlord_angel_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691048, "field 'tv_landlord_angel_time'", TextView.class));
    paramT.recyclerview_landlord_angel = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131691047, "field 'recyclerview_landlord_angel'", RecyclerView.class));
    paramT.ll_landlord_angel_pre = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691050, "field 'll_landlord_angel_pre'", LinearLayout.class));
    paramT.rl_landlord_angel_pre = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691049, "field 'rl_landlord_angel_pre'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    LandlordAngelActivity localLandlordAngelActivity = this.a;
    if (localLandlordAngelActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordAngelActivity.tv_landlord_angel_pre_arrowright = null;
    localLandlordAngelActivity.tv_landlord_angel_title = null;
    localLandlordAngelActivity.tv_landlord_angel_describe = null;
    localLandlordAngelActivity.tv_landlord_angel_time = null;
    localLandlordAngelActivity.recyclerview_landlord_angel = null;
    localLandlordAngelActivity.ll_landlord_angel_pre = null;
    localLandlordAngelActivity.rl_landlord_angel_pre = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordangel/LandlordAngelActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */