package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class MinsuInfoActivity_ViewBinding<T extends MinsuInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public MinsuInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.sv_content = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'sv_content'", ObservableScrollView.class));
    paramT.tvDec = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691441, "field 'tvDec'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131690216, "field 'tvAgree' and method 'onAgree'");
    paramT.tvAgree = ((TextView)Utils.castView(paramView, 2131690216, "field 'tvAgree'", TextView.class));
    this.b = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onAgree();
      }
    });
  }
  
  public void unbind()
  {
    MinsuInfoActivity localMinsuInfoActivity = this.a;
    if (localMinsuInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuInfoActivity.commonTitle = null;
    localMinsuInfoActivity.tvTitle = null;
    localMinsuInfoActivity.sv_content = null;
    localMinsuInfoActivity.tvDec = null;
    localMinsuInfoActivity.tvAgree = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */