package com.ziroom.ziroomcustomer.ziroomstation;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class StationInfoActivity_ViewBinding<T extends StationInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public StationInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.tvDec = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691441, "field 'tvDec'", TextView.class));
    paramT.sv_content = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'sv_content'", ObservableScrollView.class));
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
    StationInfoActivity localStationInfoActivity = this.a;
    if (localStationInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localStationInfoActivity.commonTitle = null;
    localStationInfoActivity.tvTitle = null;
    localStationInfoActivity.tvDec = null;
    localStationInfoActivity.sv_content = null;
    localStationInfoActivity.tvAgree = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/StationInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */