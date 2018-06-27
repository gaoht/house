package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.baidu.mapapi.map.MapView;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class LandlordReleaseOnceStepTwoFragment_ViewBinding<T extends LandlordReleaseOnceStepTwoFragment>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public LandlordReleaseOnceStepTwoFragment_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mv_map = ((MapView)Utils.findRequiredViewAsType(paramView, 2131692902, "field 'mv_map'", MapView.class));
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
    paramT.ruatv_tip = ((ReleaseUsageAndTipsView)Utils.findRequiredViewAsType(paramView, 2131689893, "field 'ruatv_tip'", ReleaseUsageAndTipsView.class));
    paramT.tv_city_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694634, "field 'tv_city_content'", TextView.class));
    paramT.et_street = ((EditText)Utils.findRequiredViewAsType(paramView, 2131694637, "field 'et_street'", EditText.class));
    paramT.et_community = ((EditText)Utils.findRequiredViewAsType(paramView, 2131694639, "field 'et_community'", EditText.class));
    paramT.et_number = ((EditText)Utils.findRequiredViewAsType(paramView, 2131694641, "field 'et_number'", EditText.class));
    localView = Utils.findRequiredView(paramView, 2131694632, "field 'btn_select_city' and method 'OnClick'");
    paramT.btn_select_city = localView;
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.v_divider = Utils.findRequiredView(paramView, 2131689863, "field 'v_divider'");
    paramT.osv_main = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131691365, "field 'osv_main'", ObservableScrollView.class));
  }
  
  public void unbind()
  {
    LandlordReleaseOnceStepTwoFragment localLandlordReleaseOnceStepTwoFragment = this.a;
    if (localLandlordReleaseOnceStepTwoFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordReleaseOnceStepTwoFragment.mv_map = null;
    localLandlordReleaseOnceStepTwoFragment.btn_next = null;
    localLandlordReleaseOnceStepTwoFragment.btn_back = null;
    localLandlordReleaseOnceStepTwoFragment.ruatv_tip = null;
    localLandlordReleaseOnceStepTwoFragment.tv_city_content = null;
    localLandlordReleaseOnceStepTwoFragment.et_street = null;
    localLandlordReleaseOnceStepTwoFragment.et_community = null;
    localLandlordReleaseOnceStepTwoFragment.et_number = null;
    localLandlordReleaseOnceStepTwoFragment.btn_select_city = null;
    localLandlordReleaseOnceStepTwoFragment.v_divider = null;
    localLandlordReleaseOnceStepTwoFragment.osv_main = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseOnceStepTwoFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */