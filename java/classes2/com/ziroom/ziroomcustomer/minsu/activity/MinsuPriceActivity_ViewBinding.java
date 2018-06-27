package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuPriceActivity_ViewBinding<T extends MinsuPriceActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public MinsuPriceActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.tvPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689912, "field 'tvPrice'", TextView.class));
    paramT.rangebar = ((RangeBar)Utils.findRequiredViewAsType(paramView, 2131691679, "field 'rangebar'", RangeBar.class));
    paramView = Utils.findRequiredView(paramView, 2131690953, "field 'tvSave' and method 'onClick'");
    paramT.tvSave = ((TextView)Utils.castView(paramView, 2131690953, "field 'tvSave'", TextView.class));
    this.b = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    MinsuPriceActivity localMinsuPriceActivity = this.a;
    if (localMinsuPriceActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuPriceActivity.commonTitle = null;
    localMinsuPriceActivity.tvPrice = null;
    localMinsuPriceActivity.rangebar = null;
    localMinsuPriceActivity.tvSave = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuPriceActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */