package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class MyStewardListActivity_ViewBinding<T extends MyStewardListActivity>
  implements Unbinder
{
  protected T a;
  
  public MyStewardListActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.my_steward_list = ((ListView)Utils.findRequiredViewAsType(paramView, 2131697005, "field 'my_steward_list'", ListView.class));
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
  }
  
  public void unbind()
  {
    MyStewardListActivity localMyStewardListActivity = this.a;
    if (localMyStewardListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyStewardListActivity.my_steward_list = null;
    localMyStewardListActivity.mBztb = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyStewardListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */