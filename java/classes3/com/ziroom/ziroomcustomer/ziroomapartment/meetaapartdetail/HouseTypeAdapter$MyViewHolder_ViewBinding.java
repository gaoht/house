package com.ziroom.ziroomcustomer.ziroomapartment.meetaapartdetail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;

public class HouseTypeAdapter$MyViewHolder_ViewBinding<T extends HouseTypeAdapter.MyViewHolder>
  implements Unbinder
{
  protected T a;
  
  public HouseTypeAdapter$MyViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.viewLineTop = Utils.findRequiredView(paramView, 2131695019, "field 'viewLineTop'");
    paramT.img = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131689744, "field 'img'", SimpleDraweeView.class));
    paramT.roomType = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694996, "field 'roomType'", TextView.class));
    paramT.roomPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695012, "field 'roomPrice'", TextView.class));
    paramT.flTagHouseTypeStatus = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131695022, "field 'flTagHouseTypeStatus'", FlowLayout.class));
    paramT.tvRoomTypeFull = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695023, "field 'tvRoomTypeFull'", TextView.class));
    paramT.viewDividerBottom = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695018, "field 'viewDividerBottom'", LinearLayout.class));
  }
  
  public void unbind()
  {
    HouseTypeAdapter.MyViewHolder localMyViewHolder = this.a;
    if (localMyViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyViewHolder.viewLineTop = null;
    localMyViewHolder.img = null;
    localMyViewHolder.roomType = null;
    localMyViewHolder.roomPrice = null;
    localMyViewHolder.flTagHouseTypeStatus = null;
    localMyViewHolder.tvRoomTypeFull = null;
    localMyViewHolder.viewDividerBottom = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/meetaapartdetail/HouseTypeAdapter$MyViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */