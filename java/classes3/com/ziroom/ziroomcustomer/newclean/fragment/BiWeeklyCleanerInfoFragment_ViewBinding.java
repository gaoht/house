package com.ziroom.ziroomcustomer.newclean.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;

public class BiWeeklyCleanerInfoFragment_ViewBinding<T extends BiWeeklyCleanerInfoFragment>
  implements Unbinder
{
  protected T a;
  
  public BiWeeklyCleanerInfoFragment_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tv_service_place = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693960, "field 'tv_service_place'", TextView.class));
    paramT.tv_num = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690003, "field 'tv_num'", TextView.class));
    paramT.tv_hiredate = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693961, "field 'tv_hiredate'", TextView.class));
    paramT.tv_native_place = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693962, "field 'tv_native_place'", TextView.class));
    paramT.tv_age = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690052, "field 'tv_age'", TextView.class));
    paramT.tv_constellation = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693963, "field 'tv_constellation'", TextView.class));
    paramT.tv_fond = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693964, "field 'tv_fond'", TextView.class));
    paramT.fl_like = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131690332, "field 'fl_like'", FlowLayout.class));
  }
  
  public void unbind()
  {
    BiWeeklyCleanerInfoFragment localBiWeeklyCleanerInfoFragment = this.a;
    if (localBiWeeklyCleanerInfoFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localBiWeeklyCleanerInfoFragment.tv_service_place = null;
    localBiWeeklyCleanerInfoFragment.tv_num = null;
    localBiWeeklyCleanerInfoFragment.tv_hiredate = null;
    localBiWeeklyCleanerInfoFragment.tv_native_place = null;
    localBiWeeklyCleanerInfoFragment.tv_age = null;
    localBiWeeklyCleanerInfoFragment.tv_constellation = null;
    localBiWeeklyCleanerInfoFragment.tv_fond = null;
    localBiWeeklyCleanerInfoFragment.fl_like = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/BiWeeklyCleanerInfoFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */