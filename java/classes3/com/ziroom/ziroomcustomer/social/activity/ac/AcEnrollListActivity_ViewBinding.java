package com.ziroom.ziroomcustomer.social.activity.ac;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class AcEnrollListActivity_ViewBinding<T extends AcEnrollListActivity>
  implements Unbinder
{
  protected T a;
  
  public AcEnrollListActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mLv = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689817, "field 'mLv'", ListView.class));
    paramT.mLlEmpty = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689818, "field 'mLlEmpty'", LinearLayout.class));
  }
  
  public void unbind()
  {
    AcEnrollListActivity localAcEnrollListActivity = this.a;
    if (localAcEnrollListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localAcEnrollListActivity.mLv = null;
    localAcEnrollListActivity.mLlEmpty = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcEnrollListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */