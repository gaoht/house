package com.ziroom.ziroomcustomer.ziroomapartment.zramain;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientOptiBanner;
import com.ziroom.ziroomcustomer.home.view.HomeRentItemView;

public class ZraMainActivity_ViewBinding<T extends ZraMainActivity>
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
  
  public ZraMainActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.svZraMain = ((ScrollView)Utils.findRequiredViewAsType(paramView, 2131691143, "field 'svZraMain'", ScrollView.class));
    paramT.sdvZryuMainTopPic = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131697854, "field 'sdvZryuMainTopPic'", SimpleDraweeView.class));
    paramT.tvZryuMainTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697855, "field 'tvZryuMainTitle'", TextView.class));
    paramT.tvZryuMainSubtitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695872, "field 'tvZryuMainSubtitle'", TextView.class));
    paramT.tvZryuMainTotal = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697857, "field 'tvZryuMainTotal'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131697856, "field 'llZryuMainSeeAllZryu' and method 'onViewClicked'");
    paramT.llZryuMainSeeAllZryu = ((LinearLayout)Utils.castView(localView, 2131697856, "field 'llZryuMainSeeAllZryu'", LinearLayout.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.sdvZryuMainBannerActivity = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131697841, "field 'sdvZryuMainBannerActivity'", SimpleDraweeView.class));
    paramT.tvZryuMainBannerActivity = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697842, "field 'tvZryuMainBannerActivity'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131697840, "field 'llZryuMainBannerActivity' and method 'onViewClicked'");
    paramT.llZryuMainBannerActivity = ((LinearLayout)Utils.castView(localView, 2131697840, "field 'llZryuMainBannerActivity'", LinearLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.sdvZryuMainBannerPerson = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131697844, "field 'sdvZryuMainBannerPerson'", SimpleDraweeView.class));
    paramT.tvZryuMainBannerPerson = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697845, "field 'tvZryuMainBannerPerson'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131697843, "field 'llZryuMainBannerPerson' and method 'onViewClicked'");
    paramT.llZryuMainBannerPerson = ((LinearLayout)Utils.castView(localView, 2131697843, "field 'llZryuMainBannerPerson'", LinearLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.sdvZryuMainBannerLife = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131697847, "field 'sdvZryuMainBannerLife'", SimpleDraweeView.class));
    paramT.tvZryuMainBannerLife = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697848, "field 'tvZryuMainBannerLife'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131697846, "field 'llZryuMainBannerLife' and method 'onViewClicked'");
    paramT.llZryuMainBannerLife = ((LinearLayout)Utils.castView(localView, 2131697846, "field 'llZryuMainBannerLife'", LinearLayout.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.sdvZryuMainBannerService = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131697850, "field 'sdvZryuMainBannerService'", SimpleDraweeView.class));
    paramT.tvZryuMainBannerService = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697851, "field 'tvZryuMainBannerService'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131697849, "field 'llZryuMainBannerService' and method 'onViewClicked'");
    paramT.llZryuMainBannerService = ((LinearLayout)Utils.castView(localView, 2131697849, "field 'llZryuMainBannerService'", LinearLayout.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.hrivZryuMainRecomHouseType = ((HomeRentItemView)Utils.findRequiredViewAsType(paramView, 2131691144, "field 'hrivZryuMainRecomHouseType'", HomeRentItemView.class));
    paramT.cbZryuMainLunbo = ((ConvenientOptiBanner)Utils.findRequiredViewAsType(paramView, 2131691146, "field 'cbZryuMainLunbo'", ConvenientOptiBanner.class));
    localView = Utils.findRequiredView(paramView, 2131697853, "field 'btnZryuMainSeeMoreZryu' and method 'onViewClicked'");
    paramT.btnZryuMainSeeMoreZryu = ((TextView)Utils.castView(localView, 2131697853, "field 'btnZryuMainSeeMoreZryu'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.hrivZryuMainYuPerson = ((HomeRentItemView)Utils.findRequiredViewAsType(paramView, 2131691149, "field 'hrivZryuMainYuPerson'", HomeRentItemView.class));
    paramT.hrivZryuMainSocialAc = ((HomeRentItemView)Utils.findRequiredViewAsType(paramView, 2131691151, "field 'hrivZryuMainSocialAc'", HomeRentItemView.class));
    paramT.hrivZryuMainMoreZryu = ((HomeRentItemView)Utils.findRequiredViewAsType(paramView, 2131691153, "field 'hrivZryuMainMoreZryu'", HomeRentItemView.class));
    paramT.tvZiruyuEmail = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690796, "field 'tvZiruyuEmail'", TextView.class));
    paramT.tvZiruyuTel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690797, "field 'tvZiruyuTel'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131697861, "field 'tvTitleRight' and method 'onViewClicked'");
    paramT.tvTitleRight = ((TextView)Utils.castView(localView, 2131697861, "field 'tvTitleRight'", TextView.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.viewRecomHouseTypeBelow = Utils.findRequiredView(paramView, 2131691145, "field 'viewRecomHouseTypeBelow'");
    paramT.viewLunboBelow = Utils.findRequiredView(paramView, 2131691147, "field 'viewLunboBelow'");
    paramT.viewRecommendZryuBelow = Utils.findRequiredView(paramView, 2131691148, "field 'viewRecommendZryuBelow'");
    paramT.viewYuPersonBelow = Utils.findRequiredView(paramView, 2131691150, "field 'viewYuPersonBelow'");
    paramT.viewSocialAcBelow = Utils.findRequiredView(paramView, 2131691152, "field 'viewSocialAcBelow'");
    paramT.viewMoreZryuBelow = Utils.findRequiredView(paramView, 2131691154, "field 'viewMoreZryuBelow'");
    paramT.hrivZryuMainRecomZryu = ((HomeRentItemView)Utils.findRequiredViewAsType(paramView, 2131697852, "field 'hrivZryuMainRecomZryu'", HomeRentItemView.class));
    paramT.tvSearchTip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697860, "field 'tvSearchTip'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131697859, "field 'llZryuMainTopSearch' and method 'onViewClicked'");
    paramT.llZryuMainTopSearch = ((LinearLayout)Utils.castView(localView, 2131697859, "field 'llZryuMainTopSearch'", LinearLayout.class));
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.rlTopBasement = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131697858, "field 'rlTopBasement'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    ZraMainActivity localZraMainActivity = this.a;
    if (localZraMainActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZraMainActivity.svZraMain = null;
    localZraMainActivity.sdvZryuMainTopPic = null;
    localZraMainActivity.tvZryuMainTitle = null;
    localZraMainActivity.tvZryuMainSubtitle = null;
    localZraMainActivity.tvZryuMainTotal = null;
    localZraMainActivity.llZryuMainSeeAllZryu = null;
    localZraMainActivity.sdvZryuMainBannerActivity = null;
    localZraMainActivity.tvZryuMainBannerActivity = null;
    localZraMainActivity.llZryuMainBannerActivity = null;
    localZraMainActivity.sdvZryuMainBannerPerson = null;
    localZraMainActivity.tvZryuMainBannerPerson = null;
    localZraMainActivity.llZryuMainBannerPerson = null;
    localZraMainActivity.sdvZryuMainBannerLife = null;
    localZraMainActivity.tvZryuMainBannerLife = null;
    localZraMainActivity.llZryuMainBannerLife = null;
    localZraMainActivity.sdvZryuMainBannerService = null;
    localZraMainActivity.tvZryuMainBannerService = null;
    localZraMainActivity.llZryuMainBannerService = null;
    localZraMainActivity.hrivZryuMainRecomHouseType = null;
    localZraMainActivity.cbZryuMainLunbo = null;
    localZraMainActivity.btnZryuMainSeeMoreZryu = null;
    localZraMainActivity.hrivZryuMainYuPerson = null;
    localZraMainActivity.hrivZryuMainSocialAc = null;
    localZraMainActivity.hrivZryuMainMoreZryu = null;
    localZraMainActivity.tvZiruyuEmail = null;
    localZraMainActivity.tvZiruyuTel = null;
    localZraMainActivity.ivBack = null;
    localZraMainActivity.tvTitleRight = null;
    localZraMainActivity.viewRecomHouseTypeBelow = null;
    localZraMainActivity.viewLunboBelow = null;
    localZraMainActivity.viewRecommendZryuBelow = null;
    localZraMainActivity.viewYuPersonBelow = null;
    localZraMainActivity.viewSocialAcBelow = null;
    localZraMainActivity.viewMoreZryuBelow = null;
    localZraMainActivity.hrivZryuMainRecomZryu = null;
    localZraMainActivity.tvSearchTip = null;
    localZraMainActivity.llZryuMainTopSearch = null;
    localZraMainActivity.rlTopBasement = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/zramain/ZraMainActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */