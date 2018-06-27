package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class PeriodCleanFrequencyActivity_ViewBinding<T extends PeriodCleanFrequencyActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public PeriodCleanFrequencyActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'bankcardBack' and method 'onViewClicked'");
    paramT.bankcardBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'bankcardBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked();
      }
    });
    paramT.list = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691217, "field 'list'", ListView.class));
  }
  
  public void unbind()
  {
    PeriodCleanFrequencyActivity localPeriodCleanFrequencyActivity = this.a;
    if (localPeriodCleanFrequencyActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPeriodCleanFrequencyActivity.bankcardBack = null;
    localPeriodCleanFrequencyActivity.list = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanFrequencyActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */