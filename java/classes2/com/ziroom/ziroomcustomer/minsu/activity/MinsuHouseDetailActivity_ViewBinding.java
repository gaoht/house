package com.ziroom.ziroomcustomer.minsu.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.CustomViewPager;
import com.ziroom.ziroomcustomer.minsu.view.FiveEvaluteButton;
import com.ziroom.ziroomcustomer.minsu.view.MinsuHouseDeatailFolderTextView;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class MinsuHouseDetailActivity_ViewBinding<T extends MinsuHouseDetailActivity>
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
  
  public MinsuHouseDetailActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.viewpagerhomepage = ((ViewPager)Utils.findRequiredViewAsType(paramView, 2131691308, "field 'viewpagerhomepage'", ViewPager.class));
    paramT.tvPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689912, "field 'tvPrice'", TextView.class));
    paramT.tvOriginalPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691316, "field 'tvOriginalPrice'", TextView.class));
    paramT.tv_price_original = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691317, "field 'tv_price_original'", TextView.class));
    paramT.ll_tips_area = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691318, "field 'll_tips_area'", LinearLayout.class));
    paramT.houseName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691319, "field 'houseName'", TextView.class));
    paramT.llHouseInfo = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691320, "field 'llHouseInfo'", LinearLayout.class));
    paramT.tvHouseDetailTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691329, "field 'tvHouseDetailTitle'", TextView.class));
    paramT.llHouseDetail = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691328, "field 'llHouseDetail'", LinearLayout.class));
    paramT.tvEvaTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691337, "field 'tvEvaTitle'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131691338, "field 'tvEvaAll' and method 'onClick'");
    paramT.tvEvaAll = ((TextView)Utils.castView(localView, 2131691338, "field 'tvEvaAll'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.fiveEvalute = ((FiveEvaluteButton)Utils.findRequiredViewAsType(paramView, 2131691339, "field 'fiveEvalute'", FiveEvaluteButton.class));
    paramT.tvEvaDetail = ((MinsuHouseDeatailFolderTextView)Utils.findRequiredViewAsType(paramView, 2131691341, "field 'tvEvaDetail'", MinsuHouseDeatailFolderTextView.class));
    paramT.tvEvaTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691342, "field 'tvEvaTime'", TextView.class));
    paramT.llEva = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691336, "field 'llEva'", RelativeLayout.class));
    paramT.ivLImg = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691345, "field 'ivLImg'", SimpleDraweeView.class));
    paramT.tvLName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691346, "field 'tvLName'", TextView.class));
    paramT.personCertification = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691347, "field 'personCertification'", TextView.class));
    paramT.houseCertification = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691348, "field 'houseCertification'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691344, "field 'rlLlInfo' and method 'onClick'");
    paramT.rlLlInfo = ((RelativeLayout)Utils.castView(localView, 2131691344, "field 'rlLlInfo'", RelativeLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690895, "field 'ivMap' and method 'onClick'");
    paramT.ivMap = ((SimpleDraweeView)Utils.castView(localView, 2131690895, "field 'ivMap'", SimpleDraweeView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tvAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690053, "field 'tvAddress'", TextView.class));
    paramT.ivMapecenter = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691349, "field 'ivMapecenter'", ImageView.class));
    paramT.tvConfigName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691350, "field 'tvConfigName'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691351, "field 'tvConfigAll' and method 'onClick'");
    paramT.tvConfigAll = ((TextView)Utils.castView(localView, 2131691351, "field 'tvConfigAll'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.llConfig = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691352, "field 'llConfig'", LinearLayout.class));
    paramT.tvRulesName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691353, "field 'tvRulesName'", TextView.class));
    paramT.listRules = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131691354, "field 'listRules'", ListViewForScrollView.class));
    paramT.svMain = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131689919, "field 'svMain'", ObservableScrollView.class));
    localView = Utils.findRequiredView(paramView, 2131691359, "field 'tvConsult' and method 'onClick'");
    paramT.tvConsult = ((TextView)Utils.castView(localView, 2131691359, "field 'tvConsult'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691360, "field 'tvOrderNow' and method 'onClick'");
    paramT.tvOrderNow = ((TextView)Utils.castView(localView, 2131691360, "field 'tvOrderNow'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.llBottom = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689838, "field 'llBottom'", LinearLayout.class));
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.tvLMoreHouse = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691356, "field 'tvLMoreHouse'", TextView.class));
    paramT.listHouse = ((CustomViewPager)Utils.findRequiredViewAsType(paramView, 2131691358, "field 'listHouse'", CustomViewPager.class));
    paramT.pagerLayout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691357, "field 'pagerLayout'", RelativeLayout.class));
    paramT.tvTitle1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691330, "field 'tvTitle1'", TextView.class));
    paramT.tvDes1 = ((MinsuHouseDeatailFolderTextView)Utils.findRequiredViewAsType(paramView, 2131691331, "field 'tvDes1'", MinsuHouseDeatailFolderTextView.class));
    paramT.tvTitle2 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691333, "field 'tvTitle2'", TextView.class));
    paramT.tvDes2 = ((MinsuHouseDeatailFolderTextView)Utils.findRequiredViewAsType(paramView, 2131691334, "field 'tvDes2'", MinsuHouseDeatailFolderTextView.class));
    paramT.tvFold1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691332, "field 'tvFold1'", TextView.class));
    paramT.tvFold2 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691335, "field 'tvFold2'", TextView.class));
    paramT.image = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689700, "field 'image'", ImageView.class));
    paramT.lineEva = Utils.findRequiredView(paramView, 2131691343, "field 'lineEva'");
    paramT.ll_special_tonight_container = Utils.findRequiredView(paramView, 2131691309, "field 'll_special_tonight_container'");
    paramT.ll_special_tonight_left_container = Utils.findRequiredView(paramView, 2131691310, "field 'll_special_tonight_left_container'");
    paramT.tv_special_tonight_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691311, "field 'tv_special_tonight_price'", TextView.class));
    paramT.tv_special_tonight_info = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691312, "field 'tv_special_tonight_info'", TextView.class));
    paramT.tv_special_tonight_hour = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691313, "field 'tv_special_tonight_hour'", TextView.class));
    paramT.tv_special_tonight_minutes = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691314, "field 'tv_special_tonight_minutes'", TextView.class));
    paramT.tv_special_tonight_seconds = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691315, "field 'tv_special_tonight_seconds'", TextView.class));
    paramT.tvCouponBar0 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691322, "field 'tvCouponBar0'", TextView.class));
    paramT.tvCouponBar1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691323, "field 'tvCouponBar1'", TextView.class));
    paramT.tvCouponBar2 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691324, "field 'tvCouponBar2'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691224, "field 'couponArea' and method 'onClick'");
    paramT.couponArea = ((LinearLayout)Utils.castView(localView, 2131691224, "field 'couponArea'", LinearLayout.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.line_coupon = Utils.findRequiredView(paramView, 2131691321, "field 'line_coupon'");
    paramT.first_reduce_area = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691326, "field 'first_reduce_area'", LinearLayout.class));
    paramT.tv_first_reduce = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691327, "field 'tv_first_reduce'", TextView.class));
    paramT.line_first_reduce = Utils.findRequiredView(paramView, 2131691325, "field 'line_first_reduce'");
  }
  
  public void unbind()
  {
    MinsuHouseDetailActivity localMinsuHouseDetailActivity = this.a;
    if (localMinsuHouseDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuHouseDetailActivity.viewpagerhomepage = null;
    localMinsuHouseDetailActivity.tvPrice = null;
    localMinsuHouseDetailActivity.tvOriginalPrice = null;
    localMinsuHouseDetailActivity.tv_price_original = null;
    localMinsuHouseDetailActivity.ll_tips_area = null;
    localMinsuHouseDetailActivity.houseName = null;
    localMinsuHouseDetailActivity.llHouseInfo = null;
    localMinsuHouseDetailActivity.tvHouseDetailTitle = null;
    localMinsuHouseDetailActivity.llHouseDetail = null;
    localMinsuHouseDetailActivity.tvEvaTitle = null;
    localMinsuHouseDetailActivity.tvEvaAll = null;
    localMinsuHouseDetailActivity.fiveEvalute = null;
    localMinsuHouseDetailActivity.tvEvaDetail = null;
    localMinsuHouseDetailActivity.tvEvaTime = null;
    localMinsuHouseDetailActivity.llEva = null;
    localMinsuHouseDetailActivity.ivLImg = null;
    localMinsuHouseDetailActivity.tvLName = null;
    localMinsuHouseDetailActivity.personCertification = null;
    localMinsuHouseDetailActivity.houseCertification = null;
    localMinsuHouseDetailActivity.rlLlInfo = null;
    localMinsuHouseDetailActivity.ivMap = null;
    localMinsuHouseDetailActivity.tvAddress = null;
    localMinsuHouseDetailActivity.ivMapecenter = null;
    localMinsuHouseDetailActivity.tvConfigName = null;
    localMinsuHouseDetailActivity.tvConfigAll = null;
    localMinsuHouseDetailActivity.llConfig = null;
    localMinsuHouseDetailActivity.tvRulesName = null;
    localMinsuHouseDetailActivity.listRules = null;
    localMinsuHouseDetailActivity.svMain = null;
    localMinsuHouseDetailActivity.tvConsult = null;
    localMinsuHouseDetailActivity.tvOrderNow = null;
    localMinsuHouseDetailActivity.llBottom = null;
    localMinsuHouseDetailActivity.commonTitle = null;
    localMinsuHouseDetailActivity.tvLMoreHouse = null;
    localMinsuHouseDetailActivity.listHouse = null;
    localMinsuHouseDetailActivity.pagerLayout = null;
    localMinsuHouseDetailActivity.tvTitle1 = null;
    localMinsuHouseDetailActivity.tvDes1 = null;
    localMinsuHouseDetailActivity.tvTitle2 = null;
    localMinsuHouseDetailActivity.tvDes2 = null;
    localMinsuHouseDetailActivity.tvFold1 = null;
    localMinsuHouseDetailActivity.tvFold2 = null;
    localMinsuHouseDetailActivity.image = null;
    localMinsuHouseDetailActivity.lineEva = null;
    localMinsuHouseDetailActivity.ll_special_tonight_container = null;
    localMinsuHouseDetailActivity.ll_special_tonight_left_container = null;
    localMinsuHouseDetailActivity.tv_special_tonight_price = null;
    localMinsuHouseDetailActivity.tv_special_tonight_info = null;
    localMinsuHouseDetailActivity.tv_special_tonight_hour = null;
    localMinsuHouseDetailActivity.tv_special_tonight_minutes = null;
    localMinsuHouseDetailActivity.tv_special_tonight_seconds = null;
    localMinsuHouseDetailActivity.tvCouponBar0 = null;
    localMinsuHouseDetailActivity.tvCouponBar1 = null;
    localMinsuHouseDetailActivity.tvCouponBar2 = null;
    localMinsuHouseDetailActivity.couponArea = null;
    localMinsuHouseDetailActivity.line_coupon = null;
    localMinsuHouseDetailActivity.first_reduce_area = null;
    localMinsuHouseDetailActivity.tv_first_reduce = null;
    localMinsuHouseDetailActivity.line_first_reduce = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuHouseDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */