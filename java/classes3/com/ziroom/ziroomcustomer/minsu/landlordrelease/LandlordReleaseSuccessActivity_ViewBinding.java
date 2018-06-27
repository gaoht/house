package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class LandlordReleaseSuccessActivity_ViewBinding<T extends LandlordReleaseSuccessActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public LandlordReleaseSuccessActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691560, "field 'btn_next' and method 'OnClick'");
    paramT.btn_next = localView;
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690078, "field 'btn_back' and method 'OnClick'");
    paramT.btn_back = localView;
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.ll_house_name_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691559, "field 'll_house_name_container'", LinearLayout.class));
    paramT.tv_success_info = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691558, "field 'tv_success_info'", TextView.class));
    paramT.osv_content = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131691557, "field 'osv_content'", ObservableScrollView.class));
    paramT.v_divider = Utils.findRequiredView(paramView, 2131689863, "field 'v_divider'");
  }
  
  public void unbind()
  {
    LandlordReleaseSuccessActivity localLandlordReleaseSuccessActivity = this.a;
    if (localLandlordReleaseSuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordReleaseSuccessActivity.btn_next = null;
    localLandlordReleaseSuccessActivity.btn_back = null;
    localLandlordReleaseSuccessActivity.ll_house_name_container = null;
    localLandlordReleaseSuccessActivity.tv_success_info = null;
    localLandlordReleaseSuccessActivity.osv_content = null;
    localLandlordReleaseSuccessActivity.v_divider = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseSuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */