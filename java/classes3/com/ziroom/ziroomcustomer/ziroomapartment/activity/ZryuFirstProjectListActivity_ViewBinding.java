package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ZryuFirstProjectListActivity_ViewBinding<T extends ZryuFirstProjectListActivity>
  implements Unbinder
{
  protected T a;
  
  public ZryuFirstProjectListActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.btnBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690078, "field 'btnBack'", ImageView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.tvProjectListFilter = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692856, "field 'tvProjectListFilter'", TextView.class));
    paramT.lvZryuProjectListFirst = ((ListView)Utils.findRequiredViewAsType(paramView, 2131692857, "field 'lvZryuProjectListFirst'", ListView.class));
  }
  
  public void unbind()
  {
    ZryuFirstProjectListActivity localZryuFirstProjectListActivity = this.a;
    if (localZryuFirstProjectListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuFirstProjectListActivity.btnBack = null;
    localZryuFirstProjectListActivity.tvTitle = null;
    localZryuFirstProjectListActivity.tvProjectListFilter = null;
    localZryuFirstProjectListActivity.lvZryuProjectListFirst = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuFirstProjectListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */