package com.ziroom.ziroomcustomer.newclean.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;

public class BiWeeklyCleanerEvalFragment_ViewBinding<T extends BiWeeklyCleanerEvalFragment>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public BiWeeklyCleanerEvalFragment_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.lv_eval = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131693955, "field 'lv_eval'", ListViewForScrollView.class));
    View localView = Utils.findRequiredView(paramView, 2131693956, "field 'tv_to_all_list' and method 'onClick'");
    paramT.tv_to_all_list = ((TextView)Utils.castView(localView, 2131693956, "field 'tv_to_all_list'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_no_data = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690175, "field 'tv_no_data'", TextView.class));
  }
  
  public void unbind()
  {
    BiWeeklyCleanerEvalFragment localBiWeeklyCleanerEvalFragment = this.a;
    if (localBiWeeklyCleanerEvalFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localBiWeeklyCleanerEvalFragment.lv_eval = null;
    localBiWeeklyCleanerEvalFragment.tv_to_all_list = null;
    localBiWeeklyCleanerEvalFragment.tv_no_data = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/BiWeeklyCleanerEvalFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */