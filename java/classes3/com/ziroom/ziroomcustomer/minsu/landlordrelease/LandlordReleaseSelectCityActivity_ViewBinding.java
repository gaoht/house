package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LandlordReleaseSelectCityActivity_ViewBinding<T extends LandlordReleaseSelectCityActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public LandlordReleaseSelectCityActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.lv_city_level_1 = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691553, "field 'lv_city_level_1'", ListView.class));
    paramT.lv_city_level_2 = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691554, "field 'lv_city_level_2'", ListView.class));
    paramT.lv_city_level_3 = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691555, "field 'lv_city_level_3'", ListView.class));
    paramT.lv_city_level_4 = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691556, "field 'lv_city_level_4'", ListView.class));
    paramView = Utils.findRequiredView(paramView, 2131690460, "field 'btn_cancel' and method 'OnClick'");
    paramT.btn_cancel = paramView;
    this.b = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    LandlordReleaseSelectCityActivity localLandlordReleaseSelectCityActivity = this.a;
    if (localLandlordReleaseSelectCityActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordReleaseSelectCityActivity.lv_city_level_1 = null;
    localLandlordReleaseSelectCityActivity.lv_city_level_2 = null;
    localLandlordReleaseSelectCityActivity.lv_city_level_3 = null;
    localLandlordReleaseSelectCityActivity.lv_city_level_4 = null;
    localLandlordReleaseSelectCityActivity.btn_cancel = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseSelectCityActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */