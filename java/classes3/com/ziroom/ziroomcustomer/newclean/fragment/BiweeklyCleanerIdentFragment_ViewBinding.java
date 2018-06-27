package com.ziroom.ziroomcustomer.newclean.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;

public class BiweeklyCleanerIdentFragment_ViewBinding<T extends BiweeklyCleanerIdentFragment>
  implements Unbinder
{
  protected T a;
  
  public BiweeklyCleanerIdentFragment_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.gv_ident = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131693958, "field 'gv_ident'", MyGridView.class));
    paramT.view_up = Utils.findRequiredView(paramView, 2131693957, "field 'view_up'");
    paramT.view_down = Utils.findRequiredView(paramView, 2131693959, "field 'view_down'");
  }
  
  public void unbind()
  {
    BiweeklyCleanerIdentFragment localBiweeklyCleanerIdentFragment = this.a;
    if (localBiweeklyCleanerIdentFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localBiweeklyCleanerIdentFragment.gv_ident = null;
    localBiweeklyCleanerIdentFragment.view_up = null;
    localBiweeklyCleanerIdentFragment.view_down = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/BiweeklyCleanerIdentFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */