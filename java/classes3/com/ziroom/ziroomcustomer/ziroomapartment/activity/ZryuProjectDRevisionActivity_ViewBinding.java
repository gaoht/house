package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class ZryuProjectDRevisionActivity_ViewBinding<T extends ZryuProjectDRevisionActivity>
  implements Unbinder
{
  protected T a;
  
  public ZryuProjectDRevisionActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mOsv = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131691157, "field 'mOsv'", ObservableScrollView.class));
    paramT.rlSlider = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692858, "field 'rlSlider'", RelativeLayout.class));
    paramT.mRvSlider = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131692860, "field 'mRvSlider'", RecyclerView.class));
    paramT.ivBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689492, "field 'ivBack'", ImageView.class));
    paramT.mGridView = ((GridView)Utils.findRequiredViewAsType(paramView, 2131689486, "field 'mGridView'", GridView.class));
    paramT.llHeader = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691583, "field 'llHeader'", LinearLayout.class));
    paramT.llCheckTrafficIntro = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131694766, "field 'llCheckTrafficIntro'", LinearLayout.class));
    paramT.tvPdSeeCirclePic = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694773, "field 'tvPdSeeCirclePic'", TextView.class));
    paramT.lvHouseTypeList = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131694772, "field 'lvHouseTypeList'", ListViewForScrollView.class));
    paramT.ivShare = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690673, "field 'ivShare'", ImageView.class));
    paramT.ivMap = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131690895, "field 'ivMap'", SimpleDraweeView.class));
    paramT.ivMapecenter = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691349, "field 'ivMapecenter'", ImageView.class));
    paramT.subwayDistanceList = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131694776, "field 'subwayDistanceList'", LinearLayout.class));
    paramT.tvAddressStr = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694775, "field 'tvAddressStr'", TextView.class));
    paramT.cbZryuPdBanner = ((ConvenientBanner)Utils.findRequiredViewAsType(paramView, 2131692914, "field 'cbZryuPdBanner'", ConvenientBanner.class));
    paramT.sdvZoPic = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131694779, "field 'sdvZoPic'", SimpleDraweeView.class));
    paramT.tvPdName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694763, "field 'tvPdName'", TextView.class));
    paramT.tvPdNameDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694764, "field 'tvPdNameDesc'", TextView.class));
    paramT.tvPdIntroContent = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694768, "field 'tvPdIntroContent'", TextView.class));
    paramT.tvPdDedicatedNameDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694770, "field 'tvPdDedicatedNameDesc'", TextView.class));
    paramT.tvPdZSpaceContent = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694781, "field 'tvPdZSpaceContent'", TextView.class));
    paramT.tvPdZoContent = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694778, "field 'tvPdZoContent'", TextView.class));
    paramT.btnContractZo = ((Button)Utils.findRequiredViewAsType(paramView, 2131692916, "field 'btnContractZo'", Button.class));
    paramT.orderSeeHouse = ((Button)Utils.findRequiredViewAsType(paramView, 2131692917, "field 'orderSeeHouse'", Button.class));
    paramT.zryu_pd_revision_dedicated_service = Utils.findRequiredView(paramView, 2131692911, "field 'zryu_pd_revision_dedicated_service'");
    paramT.zryu_pd_revision_zspace = Utils.findRequiredView(paramView, 2131692912, "field 'zryu_pd_revision_zspace'");
    paramT.zryu_pd_revision_zo = Utils.findRequiredView(paramView, 2131692915, "field 'zryu_pd_revision_zo'");
    paramT.rlZryuPdRevisionHeader = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131694774, "field 'rlZryuPdRevisionHeader'", RelativeLayout.class));
    paramT.zryu_house_list_container = Utils.findRequiredView(paramView, 2131692913, "field 'zryu_house_list_container'");
  }
  
  public void unbind()
  {
    ZryuProjectDRevisionActivity localZryuProjectDRevisionActivity = this.a;
    if (localZryuProjectDRevisionActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuProjectDRevisionActivity.mOsv = null;
    localZryuProjectDRevisionActivity.rlSlider = null;
    localZryuProjectDRevisionActivity.mRvSlider = null;
    localZryuProjectDRevisionActivity.ivBack = null;
    localZryuProjectDRevisionActivity.mGridView = null;
    localZryuProjectDRevisionActivity.llHeader = null;
    localZryuProjectDRevisionActivity.llCheckTrafficIntro = null;
    localZryuProjectDRevisionActivity.tvPdSeeCirclePic = null;
    localZryuProjectDRevisionActivity.lvHouseTypeList = null;
    localZryuProjectDRevisionActivity.ivShare = null;
    localZryuProjectDRevisionActivity.ivMap = null;
    localZryuProjectDRevisionActivity.ivMapecenter = null;
    localZryuProjectDRevisionActivity.subwayDistanceList = null;
    localZryuProjectDRevisionActivity.tvAddressStr = null;
    localZryuProjectDRevisionActivity.cbZryuPdBanner = null;
    localZryuProjectDRevisionActivity.sdvZoPic = null;
    localZryuProjectDRevisionActivity.tvPdName = null;
    localZryuProjectDRevisionActivity.tvPdNameDesc = null;
    localZryuProjectDRevisionActivity.tvPdIntroContent = null;
    localZryuProjectDRevisionActivity.tvPdDedicatedNameDesc = null;
    localZryuProjectDRevisionActivity.tvPdZSpaceContent = null;
    localZryuProjectDRevisionActivity.tvPdZoContent = null;
    localZryuProjectDRevisionActivity.btnContractZo = null;
    localZryuProjectDRevisionActivity.orderSeeHouse = null;
    localZryuProjectDRevisionActivity.zryu_pd_revision_dedicated_service = null;
    localZryuProjectDRevisionActivity.zryu_pd_revision_zspace = null;
    localZryuProjectDRevisionActivity.zryu_pd_revision_zo = null;
    localZryuProjectDRevisionActivity.rlZryuPdRevisionHeader = null;
    localZryuProjectDRevisionActivity.zryu_house_list_container = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuProjectDRevisionActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */