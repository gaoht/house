package com.ziroom.ziroomcustomer.minsu.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.ziroomcustomer.minsu.home.view.MinsuHomeRecyclerViewHouseItem;
import com.ziroom.ziroomcustomer.minsu.home.view.MinsuHomeRecyclerViewInv;
import com.ziroom.ziroomcustomer.minsu.home.view.MinsuHomeRecyclerViewTop;
import com.ziroom.ziroomcustomer.minsu.home.view.SojournHomeItemView;

public class SojournHomeFragment_ViewBinding<T extends SojournHomeFragment>
  implements Unbinder
{
  protected T a;
  
  public SojournHomeFragment_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.iv_search = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131694116, "field 'iv_search'", ImageView.class));
    paramT.iv_top_banner = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131694668, "field 'iv_top_banner'", SimpleDraweeView.class));
    paramT.tv_title_top = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694028, "field 'tv_title_top'", TextView.class));
    paramT.minsu_home_mdd = ((SojournHomeItemView)Utils.findRequiredViewAsType(paramView, 2131694163, "field 'minsu_home_mdd'", SojournHomeItemView.class));
    paramT.minsu_home_zry = ((SojournHomeItemView)Utils.findRequiredViewAsType(paramView, 2131694164, "field 'minsu_home_zry'", SojournHomeItemView.class));
    paramT.minsu_home_zryhd = ((SojournHomeItemView)Utils.findRequiredViewAsType(paramView, 2131694359, "field 'minsu_home_zryhd'", SojournHomeItemView.class));
    paramT.minsu_home_inv = ((MinsuHomeRecyclerViewInv)Utils.findRequiredViewAsType(paramView, 2131694360, "field 'minsu_home_inv'", MinsuHomeRecyclerViewInv.class));
    paramT.minsu_home_qds = ((SojournHomeItemView)Utils.findRequiredViewAsType(paramView, 2131694361, "field 'minsu_home_qds'", SojournHomeItemView.class));
    paramT.minsu_home_pinp = ((SojournHomeItemView)Utils.findRequiredViewAsType(paramView, 2131694171, "field 'minsu_home_pinp'", SojournHomeItemView.class));
    paramT.minsu_home_story = ((SojournHomeItemView)Utils.findRequiredViewAsType(paramView, 2131694363, "field 'minsu_home_story'", SojournHomeItemView.class));
    paramT.minsu_home_ad_banner = ((ConvenientBanner)Utils.findRequiredViewAsType(paramView, 2131694166, "field 'minsu_home_ad_banner'", ConvenientBanner.class));
    paramT.img_landlord = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131694362, "field 'img_landlord'", SimpleDraweeView.class));
    paramT.minsu_home_today = ((MinsuHomeRecyclerViewHouseItem)Utils.findRequiredViewAsType(paramView, 2131694165, "field 'minsu_home_today'", MinsuHomeRecyclerViewHouseItem.class));
    paramT.minsu_home_top = ((MinsuHomeRecyclerViewTop)Utils.findRequiredViewAsType(paramView, 2131694167, "field 'minsu_home_top'", MinsuHomeRecyclerViewTop.class));
    paramT.to_minsu_customer_service = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694173, "field 'to_minsu_customer_service'", TextView.class));
    paramT.lav_home = ((LottieAnimationView)Utils.findRequiredViewAsType(paramView, 2131694118, "field 'lav_home'", LottieAnimationView.class));
  }
  
  public void unbind()
  {
    SojournHomeFragment localSojournHomeFragment = this.a;
    if (localSojournHomeFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSojournHomeFragment.iv_search = null;
    localSojournHomeFragment.iv_top_banner = null;
    localSojournHomeFragment.tv_title_top = null;
    localSojournHomeFragment.minsu_home_mdd = null;
    localSojournHomeFragment.minsu_home_zry = null;
    localSojournHomeFragment.minsu_home_zryhd = null;
    localSojournHomeFragment.minsu_home_inv = null;
    localSojournHomeFragment.minsu_home_qds = null;
    localSojournHomeFragment.minsu_home_pinp = null;
    localSojournHomeFragment.minsu_home_story = null;
    localSojournHomeFragment.minsu_home_ad_banner = null;
    localSojournHomeFragment.img_landlord = null;
    localSojournHomeFragment.minsu_home_today = null;
    localSojournHomeFragment.minsu_home_top = null;
    localSojournHomeFragment.to_minsu_customer_service = null;
    localSojournHomeFragment.lav_home = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/home/SojournHomeFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */