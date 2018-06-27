package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuServicelistActivity_ViewBinding<T extends MinsuServicelistActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuServicelistActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.list = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691217, "field 'list'", ListView.class));
  }
  
  public void unbind()
  {
    MinsuServicelistActivity localMinsuServicelistActivity = this.a;
    if (localMinsuServicelistActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuServicelistActivity.commonTitle = null;
    localMinsuServicelistActivity.list = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuServicelistActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */