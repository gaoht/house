package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.baidu.mapapi.map.MapView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class LLRManagerStepfirstFragment_ViewBinding<T extends LLRManagerStepfirstFragment>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public LLRManagerStepfirstFragment_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ll_house_rent_way_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131694282, "field 'll_house_rent_way_container'", LinearLayout.class));
    paramT.tv_house_rent_way_title_1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694283, "field 'tv_house_rent_way_title_1'", TextView.class));
    paramT.tv_house_rent_way_content_1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694284, "field 'tv_house_rent_way_content_1'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131694286, "field 'btn_house_type' and method 'OnClick'");
    paramT.btn_house_type = localView;
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.tv_house_type = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694215, "field 'tv_house_type'", TextView.class));
    paramT.house_type_arrow = Utils.findRequiredView(paramView, 2131694287, "field 'house_type_arrow'");
    paramT.city_arrow = Utils.findRequiredView(paramView, 2131694635, "field 'city_arrow'");
    paramT.ll_house_type_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131694285, "field 'll_house_type_container'", LinearLayout.class));
    paramT.mv_map = ((MapView)Utils.findRequiredViewAsType(paramView, 2131692902, "field 'mv_map'", MapView.class));
    paramT.tv_city_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694634, "field 'tv_city_content'", TextView.class));
    paramT.et_street = ((EditText)Utils.findRequiredViewAsType(paramView, 2131694637, "field 'et_street'", EditText.class));
    paramT.et_community = ((EditText)Utils.findRequiredViewAsType(paramView, 2131694639, "field 'et_community'", EditText.class));
    paramT.et_number = ((EditText)Utils.findRequiredViewAsType(paramView, 2131694641, "field 'et_number'", EditText.class));
    localView = Utils.findRequiredView(paramView, 2131694632, "field 'btn_select_city' and method 'OnClick'");
    paramT.btn_select_city = localView;
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.osv_main = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131691365, "field 'osv_main'", ObservableScrollView.class));
  }
  
  public void unbind()
  {
    LLRManagerStepfirstFragment localLLRManagerStepfirstFragment = this.a;
    if (localLLRManagerStepfirstFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLLRManagerStepfirstFragment.ll_house_rent_way_container = null;
    localLLRManagerStepfirstFragment.tv_house_rent_way_title_1 = null;
    localLLRManagerStepfirstFragment.tv_house_rent_way_content_1 = null;
    localLLRManagerStepfirstFragment.btn_house_type = null;
    localLLRManagerStepfirstFragment.tv_house_type = null;
    localLLRManagerStepfirstFragment.house_type_arrow = null;
    localLLRManagerStepfirstFragment.city_arrow = null;
    localLLRManagerStepfirstFragment.ll_house_type_container = null;
    localLLRManagerStepfirstFragment.mv_map = null;
    localLLRManagerStepfirstFragment.tv_city_content = null;
    localLLRManagerStepfirstFragment.et_street = null;
    localLLRManagerStepfirstFragment.et_community = null;
    localLLRManagerStepfirstFragment.et_number = null;
    localLLRManagerStepfirstFragment.btn_select_city = null;
    localLLRManagerStepfirstFragment.osv_main = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LLRManagerStepfirstFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */