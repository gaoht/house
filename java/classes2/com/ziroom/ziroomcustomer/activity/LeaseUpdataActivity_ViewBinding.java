package com.ziroom.ziroomcustomer.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class LeaseUpdataActivity_ViewBinding<T extends LeaseUpdataActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public LeaseUpdataActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.lease_updata_list = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131696705, "field 'lease_updata_list'", ListViewForScrollView.class));
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
    paramView = Utils.findRequiredView(paramView, 2131696665, "method 'onClic'");
    this.b = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    LeaseUpdataActivity localLeaseUpdataActivity = this.a;
    if (localLeaseUpdataActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLeaseUpdataActivity.lease_updata_list = null;
    localLeaseUpdataActivity.mBztb = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/LeaseUpdataActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */