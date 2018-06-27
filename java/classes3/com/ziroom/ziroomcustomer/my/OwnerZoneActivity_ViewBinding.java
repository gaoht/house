package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.ziroomcustomer.home.view.HomeRecyclerView;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.MyGridView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class OwnerZoneActivity_ViewBinding<T extends OwnerZoneActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  
  public OwnerZoneActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.myinfoRlHeader = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689928, "field 'myinfoRlHeader'", RelativeLayout.class));
    paramT.myinfoBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692024, "field 'myinfoBack'", ImageView.class));
    paramT.myinfoOwnerSetting = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692026, "field 'myinfoOwnerSetting'", TextView.class));
    paramT.myinfoIvIcon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691481, "field 'myinfoIvIcon'", SimpleDraweeView.class));
    paramT.myinfoTvName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692018, "field 'myinfoTvName'", TextView.class));
    paramT.myinfoScrollview = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131691868, "field 'myinfoScrollview'", ObservableScrollView.class));
    paramT.changeMode = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692027, "field 'changeMode'", LinearLayout.class));
    paramT.myinfoTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692025, "field 'myinfoTvTitle'", TextView.class));
    paramT.myinfoTitleLine = Utils.findRequiredView(paramView, 2131691166, "field 'myinfoTitleLine'");
    paramT.glOwerMyBannerTop = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131692019, "field 'glOwerMyBannerTop'", MyGridView.class));
    paramT.glOwerMyBannerBottom = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131697772, "field 'glOwerMyBannerBottom'", MyGridView.class));
    paramT.container_ower_my_banner_bottom = Utils.findRequiredView(paramView, 2131697771, "field 'container_ower_my_banner_bottom'");
    paramT.tvOwnerZoneMfceoTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697767, "field 'tvOwnerZoneMfceoTitle'", TextView.class));
    paramT.tvOwnerZoneMfceoDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697768, "field 'tvOwnerZoneMfceoDesc'", TextView.class));
    paramT.ivOwnerZoneMfceoIcon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131697769, "field 'ivOwnerZoneMfceoIcon'", SimpleDraweeView.class));
    paramT.btnSeeMfceoDetail = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697770, "field 'btnSeeMfceoDetail'", TextView.class));
    paramT.hrvZiruNews = ((HomeRecyclerView)Utils.findRequiredViewAsType(paramView, 2131697773, "field 'hrvZiruNews'", HomeRecyclerView.class));
    paramT.hrvOwnerClub = ((HomeRecyclerView)Utils.findRequiredViewAsType(paramView, 2131697774, "field 'hrvOwnerClub'", HomeRecyclerView.class));
    paramT.containerEntrustSchedule = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131697760, "field 'containerEntrustSchedule'", LinearLayout.class));
    paramT.tvOwnerZoneEntrustSchedule = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697761, "field 'tvOwnerZoneEntrustSchedule'", TextView.class));
    paramT.tvOwnerZoneEntrustScheduleTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697762, "field 'tvOwnerZoneEntrustScheduleTitle'", TextView.class));
    paramT.llOwnerZoneEntrustSchedule = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131697763, "field 'llOwnerZoneEntrustSchedule'", LinearLayout.class));
    paramT.btnShowAllEntrust = ((Button)Utils.findRequiredViewAsType(paramView, 2131697764, "field 'btnShowAllEntrust'", Button.class));
    paramT.showEntrustDetail = ((Button)Utils.findRequiredViewAsType(paramView, 2131697765, "field 'showEntrustDetail'", Button.class));
    paramT.containerOwnerZoneAdBanner = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131697701, "field 'containerOwnerZoneAdBanner'", LinearLayout.class));
    paramT.containerOwnerMailFromCEO = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131697766, "field 'containerOwnerMailFromCEO'", LinearLayout.class));
    paramT.containerOwnerZoneAdBannerNotOwner = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131697703, "field 'containerOwnerZoneAdBannerNotOwner'", LinearLayout.class));
    paramT.ivOwnerZoneAdBannerNotOwner = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131697704, "field 'ivOwnerZoneAdBannerNotOwner'", SimpleDraweeView.class));
    paramT.ivOwnerZoneAdBanner = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131697702, "field 'ivOwnerZoneAdBanner'", SimpleDraweeView.class));
    paramT.view_top_0dp = Utils.findRequiredView(paramView, 2131692023, "field 'view_top_0dp'");
    paramT.owner_contract_list = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131697759, "field 'owner_contract_list'", ListViewForScrollView.class));
    paramT.gl_ower_my_contract = Utils.findRequiredView(paramView, 2131692021, "field 'gl_ower_my_contract'");
    paramT.gl_ower_my_assets = Utils.findRequiredView(paramView, 2131692022, "field 'gl_ower_my_assets'");
    paramT.owner_asset_house_info_address = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697725, "field 'owner_asset_house_info_address'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131697726, "field 'owner_asset_house_info_update' and method 'onClic'");
    paramT.owner_asset_house_info_update = ((TextView)Utils.castView(localView, 2131697726, "field 'owner_asset_house_info_update'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.owner_asset_house_info_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697727, "field 'owner_asset_house_info_time'", TextView.class));
    paramT.owner_asset_house_text_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131697728, "field 'owner_asset_house_text_ll'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131697730, "field 'owner_asset_house_image1' and method 'onClic'");
    paramT.owner_asset_house_image1 = ((SimpleDraweeView)Utils.castView(localView, 2131697730, "field 'owner_asset_house_image1'", SimpleDraweeView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131697731, "field 'owner_asset_house_image2' and method 'onClic'");
    paramT.owner_asset_house_image2 = ((SimpleDraweeView)Utils.castView(localView, 2131697731, "field 'owner_asset_house_image2'", SimpleDraweeView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131697733, "field 'owner_asset_house_image3' and method 'onClic'");
    paramT.owner_asset_house_image3 = ((SimpleDraweeView)Utils.castView(localView, 2131697733, "field 'owner_asset_house_image3'", SimpleDraweeView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131697732, "field 'owner_asset_house_image3_fl' and method 'onClic'");
    paramT.owner_asset_house_image3_fl = localView;
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.owner_asset_house_image_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131697729, "field 'owner_asset_house_image_ll'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131697735, "field 'owner_asset_house_image_tv' and method 'onClic'");
    paramT.owner_asset_house_image_tv = ((TextView)Utils.castView(localView, 2131697735, "field 'owner_asset_house_image_tv'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.view_third_background = Utils.findRequiredView(paramView, 2131697734, "field 'view_third_background'");
    paramT.owner_asset_trusteeship_day = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697736, "field 'owner_asset_trusteeship_day'", TextView.class));
    paramT.owner_asset_renew_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697738, "field 'owner_asset_renew_tv'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131697739, "field 'owner_asset_renew_btn' and method 'onClic'");
    paramT.owner_asset_renew_btn = ((TextView)Utils.castView(localView, 2131697739, "field 'owner_asset_renew_btn'", TextView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.owner_asset_renew = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131697737, "field 'owner_asset_renew'", LinearLayout.class));
    paramT.owner_asset_income_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131697740, "field 'owner_asset_income_ll'", LinearLayout.class));
    paramT.owner_asset_income_all_money = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697741, "field 'owner_asset_income_all_money'", TextView.class));
    paramT.owner_asset_income_latest_money = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697742, "field 'owner_asset_income_latest_money'", TextView.class));
    paramT.owner_asset_income_latest_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697743, "field 'owner_asset_income_latest_time'", TextView.class));
    paramT.owner_asset_income_next_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697744, "field 'owner_asset_income_next_time'", TextView.class));
    paramT.owner_asset_clean_count = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697747, "field 'owner_asset_clean_count'", TextView.class));
    paramT.owner_asset_clean_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697748, "field 'owner_asset_clean_tv'", TextView.class));
    paramT.owner_asset_repair_count = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697750, "field 'owner_asset_repair_count'", TextView.class));
    paramT.owner_asset_repair_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697751, "field 'owner_asset_repair_tv'", TextView.class));
    paramT.owner_asset_steward_img = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131697753, "field 'owner_asset_steward_img'", SimpleDraweeView.class));
    paramT.owner_asset_steward_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697754, "field 'owner_asset_steward_name'", TextView.class));
    paramT.owner_asset_steward_phone = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697755, "field 'owner_asset_steward_phone'", TextView.class));
    paramT.owner_asset_steward_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697757, "field 'owner_asset_steward_text'", TextView.class));
    paramT.vDividerTopCb = Utils.findRequiredView(paramView, 2131692020, "field 'vDividerTopCb'");
    paramT.convenientBanner = ((ConvenientBanner)Utils.findRequiredViewAsType(paramView, 2131690977, "field 'convenientBanner'", ConvenientBanner.class));
    localView = Utils.findRequiredView(paramView, 2131697745, "method 'onClic'");
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131697752, "method 'onClic'");
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131697758, "method 'onClic'");
    this.k = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    OwnerZoneActivity localOwnerZoneActivity = this.a;
    if (localOwnerZoneActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOwnerZoneActivity.myinfoRlHeader = null;
    localOwnerZoneActivity.myinfoBack = null;
    localOwnerZoneActivity.myinfoOwnerSetting = null;
    localOwnerZoneActivity.myinfoIvIcon = null;
    localOwnerZoneActivity.myinfoTvName = null;
    localOwnerZoneActivity.myinfoScrollview = null;
    localOwnerZoneActivity.changeMode = null;
    localOwnerZoneActivity.myinfoTvTitle = null;
    localOwnerZoneActivity.myinfoTitleLine = null;
    localOwnerZoneActivity.glOwerMyBannerTop = null;
    localOwnerZoneActivity.glOwerMyBannerBottom = null;
    localOwnerZoneActivity.container_ower_my_banner_bottom = null;
    localOwnerZoneActivity.tvOwnerZoneMfceoTitle = null;
    localOwnerZoneActivity.tvOwnerZoneMfceoDesc = null;
    localOwnerZoneActivity.ivOwnerZoneMfceoIcon = null;
    localOwnerZoneActivity.btnSeeMfceoDetail = null;
    localOwnerZoneActivity.hrvZiruNews = null;
    localOwnerZoneActivity.hrvOwnerClub = null;
    localOwnerZoneActivity.containerEntrustSchedule = null;
    localOwnerZoneActivity.tvOwnerZoneEntrustSchedule = null;
    localOwnerZoneActivity.tvOwnerZoneEntrustScheduleTitle = null;
    localOwnerZoneActivity.llOwnerZoneEntrustSchedule = null;
    localOwnerZoneActivity.btnShowAllEntrust = null;
    localOwnerZoneActivity.showEntrustDetail = null;
    localOwnerZoneActivity.containerOwnerZoneAdBanner = null;
    localOwnerZoneActivity.containerOwnerMailFromCEO = null;
    localOwnerZoneActivity.containerOwnerZoneAdBannerNotOwner = null;
    localOwnerZoneActivity.ivOwnerZoneAdBannerNotOwner = null;
    localOwnerZoneActivity.ivOwnerZoneAdBanner = null;
    localOwnerZoneActivity.view_top_0dp = null;
    localOwnerZoneActivity.owner_contract_list = null;
    localOwnerZoneActivity.gl_ower_my_contract = null;
    localOwnerZoneActivity.gl_ower_my_assets = null;
    localOwnerZoneActivity.owner_asset_house_info_address = null;
    localOwnerZoneActivity.owner_asset_house_info_update = null;
    localOwnerZoneActivity.owner_asset_house_info_time = null;
    localOwnerZoneActivity.owner_asset_house_text_ll = null;
    localOwnerZoneActivity.owner_asset_house_image1 = null;
    localOwnerZoneActivity.owner_asset_house_image2 = null;
    localOwnerZoneActivity.owner_asset_house_image3 = null;
    localOwnerZoneActivity.owner_asset_house_image3_fl = null;
    localOwnerZoneActivity.owner_asset_house_image_ll = null;
    localOwnerZoneActivity.owner_asset_house_image_tv = null;
    localOwnerZoneActivity.view_third_background = null;
    localOwnerZoneActivity.owner_asset_trusteeship_day = null;
    localOwnerZoneActivity.owner_asset_renew_tv = null;
    localOwnerZoneActivity.owner_asset_renew_btn = null;
    localOwnerZoneActivity.owner_asset_renew = null;
    localOwnerZoneActivity.owner_asset_income_ll = null;
    localOwnerZoneActivity.owner_asset_income_all_money = null;
    localOwnerZoneActivity.owner_asset_income_latest_money = null;
    localOwnerZoneActivity.owner_asset_income_latest_time = null;
    localOwnerZoneActivity.owner_asset_income_next_time = null;
    localOwnerZoneActivity.owner_asset_clean_count = null;
    localOwnerZoneActivity.owner_asset_clean_tv = null;
    localOwnerZoneActivity.owner_asset_repair_count = null;
    localOwnerZoneActivity.owner_asset_repair_tv = null;
    localOwnerZoneActivity.owner_asset_steward_img = null;
    localOwnerZoneActivity.owner_asset_steward_name = null;
    localOwnerZoneActivity.owner_asset_steward_phone = null;
    localOwnerZoneActivity.owner_asset_steward_text = null;
    localOwnerZoneActivity.vDividerTopCb = null;
    localOwnerZoneActivity.convenientBanner = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.g.setOnClickListener(null);
    this.g = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.i.setOnClickListener(null);
    this.i = null;
    this.j.setOnClickListener(null);
    this.j = null;
    this.k.setOnClickListener(null);
    this.k = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerZoneActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */