package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ProjectListConditionalView;

public class ZryuProjectListOptiActivity_ViewBinding<T extends ZryuProjectListOptiActivity>
  implements Unbinder
{
  protected T a;
  
  public ZryuProjectListOptiActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.btnBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690078, "field 'btnBack'", ImageView.class));
    paramT.iv_address_top_right = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692932, "field 'iv_address_top_right'", ImageView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.lvZryuProjectListOpti = ((ListView)Utils.findRequiredViewAsType(paramView, 2131692933, "field 'lvZryuProjectListOpti'", ListView.class));
    paramT.conditionalView = ((ProjectListConditionalView)Utils.findRequiredViewAsType(paramView, 2131690896, "field 'conditionalView'", ProjectListConditionalView.class));
  }
  
  public void unbind()
  {
    ZryuProjectListOptiActivity localZryuProjectListOptiActivity = this.a;
    if (localZryuProjectListOptiActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuProjectListOptiActivity.btnBack = null;
    localZryuProjectListOptiActivity.iv_address_top_right = null;
    localZryuProjectListOptiActivity.tvTitle = null;
    localZryuProjectListOptiActivity.lvZryuProjectListOpti = null;
    localZryuProjectListOptiActivity.conditionalView = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuProjectListOptiActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */