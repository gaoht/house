package com.ziroom.ziroomcustomer.my.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MyTravelListMoreAdapter$MyTravelViewHolder_ViewBinding<T extends MyTravelListMoreAdapter.MyTravelViewHolder>
  implements Unbinder
{
  protected T a;
  
  public MyTravelListMoreAdapter$MyTravelViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.travel_tv_contract = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695436, "field 'travel_tv_contract'", TextView.class));
    paramT.travel_tv_address = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695435, "field 'travel_tv_address'", TextView.class));
    paramT.travel_tv_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695432, "field 'travel_tv_name'", TextView.class));
    paramT.travel_tv_arriveTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695433, "field 'travel_tv_arriveTime'", TextView.class));
    paramT.travel_tv_leaveTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695434, "field 'travel_tv_leaveTime'", TextView.class));
  }
  
  public void unbind()
  {
    MyTravelListMoreAdapter.MyTravelViewHolder localMyTravelViewHolder = this.a;
    if (localMyTravelViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyTravelViewHolder.travel_tv_contract = null;
    localMyTravelViewHolder.travel_tv_address = null;
    localMyTravelViewHolder.travel_tv_name = null;
    localMyTravelViewHolder.travel_tv_arriveTime = null;
    localMyTravelViewHolder.travel_tv_leaveTime = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/MyTravelListMoreAdapter$MyTravelViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */