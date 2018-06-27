package com.ziroom.ziroomcustomer.minsu.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class MinsuHouseDetailBottomFragment_ViewBinding<T extends MinsuHouseDetailBottomFragment>
  implements Unbinder
{
  protected T a;
  
  public MinsuHouseDetailBottomFragment_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.sdv_house = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695337, "field 'sdv_house'", SimpleDraweeView.class));
    paramT.sdv_landlord = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695295, "field 'sdv_landlord'", SimpleDraweeView.class));
    paramT.tv_house_address = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691378, "field 'tv_house_address'", TextView.class));
    paramT.tv_house_type = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694215, "field 'tv_house_type'", TextView.class));
    paramT.tv_house_evaluate_count = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695340, "field 'tv_house_evaluate_count'", TextView.class));
    paramT.tv_house_evaluate_score = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695339, "field 'tv_house_evaluate_score'", TextView.class));
    paramT.tv_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689912, "field 'tv_price'", TextView.class));
    paramT.tv_originalPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691316, "field 'tv_originalPrice'", TextView.class));
    paramT.tv_price_privilege = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695261, "field 'tv_price_privilege'", TextView.class));
    paramT.tv_ts_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694747, "field 'tv_ts_price'", TextView.class));
    paramT.tv_ts_price_dsc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694748, "field 'tv_ts_price_dsc'", TextView.class));
    paramT.tv_list_tips = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694755, "field 'tv_list_tips'", TextView.class));
    paramT.include_today_special = Utils.findRequiredView(paramView, 2131695270, "field 'include_today_special'");
    paramT.ll_tag_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695341, "field 'll_tag_container'", LinearLayout.class));
    paramT.count_down_area = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131694749, "field 'count_down_area'", LinearLayout.class));
    paramT.ongonging_area = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131694754, "field 'ongonging_area'", RelativeLayout.class));
    paramT.ts_price_area = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131694746, "field 'ts_price_area'", RelativeLayout.class));
    paramT.btn_collect = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691394, "field 'btn_collect'", ImageView.class));
    paramT.rl_common_content = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131695258, "field 'rl_common_content'", RelativeLayout.class));
    paramT.rl_ll_icon = Utils.findRequiredView(paramView, 2131695263, "field 'rl_ll_icon'");
  }
  
  public void unbind()
  {
    MinsuHouseDetailBottomFragment localMinsuHouseDetailBottomFragment = this.a;
    if (localMinsuHouseDetailBottomFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuHouseDetailBottomFragment.sdv_house = null;
    localMinsuHouseDetailBottomFragment.sdv_landlord = null;
    localMinsuHouseDetailBottomFragment.tv_house_address = null;
    localMinsuHouseDetailBottomFragment.tv_house_type = null;
    localMinsuHouseDetailBottomFragment.tv_house_evaluate_count = null;
    localMinsuHouseDetailBottomFragment.tv_house_evaluate_score = null;
    localMinsuHouseDetailBottomFragment.tv_price = null;
    localMinsuHouseDetailBottomFragment.tv_originalPrice = null;
    localMinsuHouseDetailBottomFragment.tv_price_privilege = null;
    localMinsuHouseDetailBottomFragment.tv_ts_price = null;
    localMinsuHouseDetailBottomFragment.tv_ts_price_dsc = null;
    localMinsuHouseDetailBottomFragment.tv_list_tips = null;
    localMinsuHouseDetailBottomFragment.include_today_special = null;
    localMinsuHouseDetailBottomFragment.ll_tag_container = null;
    localMinsuHouseDetailBottomFragment.count_down_area = null;
    localMinsuHouseDetailBottomFragment.ongonging_area = null;
    localMinsuHouseDetailBottomFragment.ts_price_area = null;
    localMinsuHouseDetailBottomFragment.btn_collect = null;
    localMinsuHouseDetailBottomFragment.rl_common_content = null;
    localMinsuHouseDetailBottomFragment.rl_ll_icon = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/fragment/MinsuHouseDetailBottomFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */