package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MinsuReleaseActivity_ViewBinding<T extends MinsuReleaseActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuReleaseActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.fl_root = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691551, "field 'fl_root'", FrameLayout.class));
  }
  
  public void unbind()
  {
    MinsuReleaseActivity localMinsuReleaseActivity = this.a;
    if (localMinsuReleaseActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuReleaseActivity.fl_root = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/MinsuReleaseActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */