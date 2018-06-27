package com.ziroom.ziroomcustomer.my;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.e;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a.c;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.b;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.f.b;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.home.view.HomeCListCtrlView.b;
import com.ziroom.ziroomcustomer.home.view.HomeRecyclerView;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.adapter.OwnerContractAdapter;
import com.ziroom.ziroomcustomer.my.model.OwnerEntrustScheduleBean;
import com.ziroom.ziroomcustomer.my.model.OwnerEntrustScheduleBean.ProgressBean;
import com.ziroom.ziroomcustomer.my.model.OwnerEntrustScheduleBean.ProgressBean.HousekepperBean;
import com.ziroom.ziroomcustomer.my.model.OwnerMyBannerOneBean;
import com.ziroom.ziroomcustomer.my.model.OwnerMyBannerOneBean.BannerBean;
import com.ziroom.ziroomcustomer.my.model.OwnerMyBannerOneBean.ClubBean;
import com.ziroom.ziroomcustomer.my.model.OwnerMyBannerOneBean.ClubBean.ListBean;
import com.ziroom.ziroomcustomer.my.model.OwnerMyBannerOneBean.HuodongBean;
import com.ziroom.ziroomcustomer.my.model.OwnerMyBannerOneBean.MenuPrimayBean;
import com.ziroom.ziroomcustomer.my.model.OwnerMyBannerOneBean.MenuSecondaryBean;
import com.ziroom.ziroomcustomer.my.model.OwnerMyBannerOneBean.TipBean;
import com.ziroom.ziroomcustomer.my.model.OwnerMyBannerOneBean.TrendsBean;
import com.ziroom.ziroomcustomer.my.model.OwnerMyBannerOneBean.TrendsBean.ListBean;
import com.ziroom.ziroomcustomer.my.model.OwnerMyBannerOneBean.YezhubannerBean;
import com.ziroom.ziroomcustomer.my.model.OwnerMyContractEntity;
import com.ziroom.ziroomcustomer.my.model.OwnerMySignedEntity;
import com.ziroom.ziroomcustomer.my.model.OwnerMySignedEntity.HouseEntity;
import com.ziroom.ziroomcustomer.my.model.OwnerMySignedEntity.HousekeeperEntity;
import com.ziroom.ziroomcustomer.my.model.OwnerMySignedEntity.IncomeEntity;
import com.ziroom.ziroomcustomer.my.model.OwnerMySignedEntity.IncomeEntity.EarningEntity;
import com.ziroom.ziroomcustomer.my.model.OwnerMySignedEntity.ServiceEntity;
import com.ziroom.ziroomcustomer.my.selfsetting.SelfSettingActivity;
import com.ziroom.ziroomcustomer.newchat.ChatNewActivity;
import com.ziroom.ziroomcustomer.newchat.l;
import com.ziroom.ziroomcustomer.newclean.mvp.CleanHomeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MoveTypeActivity;
import com.ziroom.ziroomcustomer.newrepair.mvp.RepairHomeActivity;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.MyGridView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuPhotoPreviewActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OwnerZoneActivity
  extends BaseActivity
  implements View.OnClickListener, f.b, ObservableScrollView.a
{
  private OwnerMyContractEntity A;
  private OwnerMySignedEntity B;
  private List<String> C;
  private int D = 0;
  private ArrayList<String> E;
  private boolean F = false;
  private boolean G = false;
  private boolean H = true;
  private String a = "您的房屋已交给自如托管";
  private String b = "，租约剩余";
  @BindView(2131697770)
  TextView btnSeeMfceoDetail;
  @BindView(2131697764)
  Button btnShowAllEntrust;
  private UserInfo c;
  @BindView(2131692027)
  LinearLayout changeMode;
  @BindView(2131697760)
  LinearLayout containerEntrustSchedule;
  @BindView(2131697766)
  LinearLayout containerOwnerMailFromCEO;
  @BindView(2131697701)
  LinearLayout containerOwnerZoneAdBanner;
  @BindView(2131697703)
  LinearLayout containerOwnerZoneAdBannerNotOwner;
  @BindView(2131697771)
  View container_ower_my_banner_bottom;
  @BindView(2131690977)
  ConvenientBanner convenientBanner;
  private String d;
  private boolean e;
  private OwnerMyBannerOneBean f;
  private List<OwnerEntrustScheduleBean> g;
  @BindView(2131697772)
  MyGridView glOwerMyBannerBottom;
  @BindView(2131692019)
  MyGridView glOwerMyBannerTop;
  @BindView(2131692022)
  View gl_ower_my_assets;
  @BindView(2131692021)
  View gl_ower_my_contract;
  @BindView(2131697774)
  HomeRecyclerView hrvOwnerClub;
  @BindView(2131697773)
  HomeRecyclerView hrvZiruNews;
  @BindView(2131697702)
  SimpleDraweeView ivOwnerZoneAdBanner;
  @BindView(2131697704)
  SimpleDraweeView ivOwnerZoneAdBannerNotOwner;
  @BindView(2131697769)
  SimpleDraweeView ivOwnerZoneMfceoIcon;
  @BindView(2131697763)
  LinearLayout llOwnerZoneEntrustSchedule;
  @BindView(2131692024)
  ImageView myinfoBack;
  @BindView(2131691481)
  SimpleDraweeView myinfoIvIcon;
  @BindView(2131692026)
  TextView myinfoOwnerSetting;
  @BindView(2131689928)
  RelativeLayout myinfoRlHeader;
  @BindView(2131691868)
  ObservableScrollView myinfoScrollview;
  @BindView(2131691166)
  View myinfoTitleLine;
  @BindView(2131692018)
  TextView myinfoTvName;
  @BindView(2131692025)
  TextView myinfoTvTitle;
  @BindView(2131697747)
  TextView owner_asset_clean_count;
  @BindView(2131697748)
  TextView owner_asset_clean_tv;
  @BindView(2131697730)
  SimpleDraweeView owner_asset_house_image1;
  @BindView(2131697731)
  SimpleDraweeView owner_asset_house_image2;
  @BindView(2131697733)
  SimpleDraweeView owner_asset_house_image3;
  @BindView(2131697732)
  View owner_asset_house_image3_fl;
  @BindView(2131697729)
  LinearLayout owner_asset_house_image_ll;
  @BindView(2131697735)
  TextView owner_asset_house_image_tv;
  @BindView(2131697725)
  TextView owner_asset_house_info_address;
  @BindView(2131697727)
  TextView owner_asset_house_info_time;
  @BindView(2131697726)
  TextView owner_asset_house_info_update;
  @BindView(2131697728)
  LinearLayout owner_asset_house_text_ll;
  @BindView(2131697741)
  TextView owner_asset_income_all_money;
  @BindView(2131697742)
  TextView owner_asset_income_latest_money;
  @BindView(2131697743)
  TextView owner_asset_income_latest_time;
  @BindView(2131697740)
  LinearLayout owner_asset_income_ll;
  @BindView(2131697744)
  TextView owner_asset_income_next_time;
  @BindView(2131697737)
  LinearLayout owner_asset_renew;
  @BindView(2131697739)
  TextView owner_asset_renew_btn;
  @BindView(2131697738)
  TextView owner_asset_renew_tv;
  @BindView(2131697750)
  TextView owner_asset_repair_count;
  @BindView(2131697751)
  TextView owner_asset_repair_tv;
  @BindView(2131697753)
  SimpleDraweeView owner_asset_steward_img;
  @BindView(2131697754)
  TextView owner_asset_steward_name;
  @BindView(2131697755)
  TextView owner_asset_steward_phone;
  @BindView(2131697757)
  TextView owner_asset_steward_text;
  @BindView(2131697736)
  TextView owner_asset_trusteeship_day;
  @BindView(2131697759)
  ListViewForScrollView owner_contract_list;
  private OwnerEntrustScheduleBean r;
  private int s = 0;
  @BindView(2131697765)
  Button showEntrustDetail;
  private int t = 0;
  @BindView(2131697761)
  TextView tvOwnerZoneEntrustSchedule;
  @BindView(2131697762)
  TextView tvOwnerZoneEntrustScheduleTitle;
  @BindView(2131697768)
  TextView tvOwnerZoneMfceoDesc;
  @BindView(2131697767)
  TextView tvOwnerZoneMfceoTitle;
  private OwnerMyBannerOneBean.YezhubannerBean u;
  private int v = 0;
  @BindView(2131692020)
  View vDividerTopCb;
  @BindView(2131697734)
  View view_third_background;
  @BindView(2131692023)
  View view_top_0dp;
  private OwnerMyBannerOneBean.BannerBean w;
  private com.ziroom.ziroomcustomer.dialog.f x;
  private int y;
  private Context z;
  
  private void a()
  {
    j.getOwnerContract(this, com.ziroom.commonlibrary.login.a.getToken(this), new com.ziroom.ziroomcustomer.e.a.f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.logBigData("OwnerZoneActivity", "===ContractData:" + paramAnonymouse.toString());
        paramAnonymouse = paramAnonymouse.toString();
        OwnerZoneActivity.a(OwnerZoneActivity.this, (OwnerMyContractEntity)com.alibaba.fastjson.a.parseObject(paramAnonymouse, OwnerMyContractEntity.class));
        OwnerZoneActivity.a(OwnerZoneActivity.this, true);
        if ((OwnerZoneActivity.g(OwnerZoneActivity.this)) && (OwnerZoneActivity.h(OwnerZoneActivity.this)))
        {
          OwnerZoneActivity.a(OwnerZoneActivity.this, false);
          OwnerZoneActivity.b(OwnerZoneActivity.this, false);
          OwnerZoneActivity.i(OwnerZoneActivity.this);
        }
        if (OwnerZoneActivity.j(OwnerZoneActivity.this) != null)
        {
          OwnerZoneActivity.b(OwnerZoneActivity.this, OwnerZoneActivity.j(OwnerZoneActivity.this));
          if (OwnerZoneActivity.j(OwnerZoneActivity.this).getContracts_signed() != null) {
            OwnerZoneActivity.a(OwnerZoneActivity.this, OwnerZoneActivity.j(OwnerZoneActivity.this), OwnerZoneActivity.k(OwnerZoneActivity.this));
          }
        }
        for (;;)
        {
          OwnerZoneActivity.l(OwnerZoneActivity.this);
          return;
          OwnerZoneActivity.this.showToast("");
        }
      }
    });
  }
  
  private void a(OwnerMyContractEntity paramOwnerMyContractEntity)
  {
    if (paramOwnerMyContractEntity == null)
    {
      this.gl_ower_my_contract.setVisibility(8);
      return;
    }
    if (paramOwnerMyContractEntity.getContracts_unsigned() == null)
    {
      this.gl_ower_my_contract.setVisibility(8);
      return;
    }
    if (paramOwnerMyContractEntity.getContracts_unsigned().size() <= 0)
    {
      this.gl_ower_my_contract.setVisibility(8);
      return;
    }
    this.gl_ower_my_contract.setVisibility(0);
    paramOwnerMyContractEntity = new OwnerContractAdapter(this, paramOwnerMyContractEntity.getContracts_unsigned());
    this.owner_contract_list.setAdapter(paramOwnerMyContractEntity);
  }
  
  private void a(OwnerMyContractEntity paramOwnerMyContractEntity, int paramInt)
  {
    if (paramOwnerMyContractEntity.getContracts_signed().size() <= 1) {
      this.owner_asset_house_info_update.setVisibility(4);
    }
    while (paramOwnerMyContractEntity.getContracts_signed() == null)
    {
      this.gl_ower_my_assets.setVisibility(8);
      return;
      this.owner_asset_house_info_update.setVisibility(0);
    }
    if (paramOwnerMyContractEntity.getContracts_signed().size() <= 0)
    {
      this.gl_ower_my_assets.setVisibility(8);
      return;
    }
    if (paramOwnerMyContractEntity.getContracts_signed().size() <= paramInt)
    {
      showToast("数据错误");
      return;
    }
    if (paramOwnerMyContractEntity.getContracts_signed().get(paramInt) == null)
    {
      showToast("更换失败");
      return;
    }
    this.B = ((OwnerMySignedEntity)paramOwnerMyContractEntity.getContracts_signed().get(paramInt));
    label193:
    Object localObject1;
    label215:
    label253:
    label368:
    label375:
    label383:
    int i;
    int j;
    int k;
    Object localObject2;
    if (this.B != null)
    {
      this.gl_ower_my_assets.setVisibility(0);
      if (ae.notNull(this.B.getAddress()))
      {
        this.owner_asset_house_info_address.setText(this.B.getAddress());
        if (!ae.notNull(this.B.getStart_date())) {
          break label368;
        }
        paramOwnerMyContractEntity = this.B.getStart_date();
        if (!ae.notNull(this.B.getEnd_date())) {
          break label375;
        }
        localObject1 = this.B.getEnd_date();
        if (1 != this.B.getIs_nc()) {
          break label383;
        }
        this.owner_asset_house_info_time.setText("合同开始日期 " + paramOwnerMyContractEntity);
      }
      for (;;)
      {
        if (this.B.getHouse() != null)
        {
          this.owner_asset_house_text_ll.setVisibility(0);
          paramOwnerMyContractEntity = this.B.getHouse();
          this.C = new ArrayList();
          if (paramOwnerMyContractEntity != null)
          {
            if ((paramOwnerMyContractEntity.getPhotos_big() != null) && (paramOwnerMyContractEntity.getPhotos_big().size() > 0))
            {
              paramInt = 0;
              for (;;)
              {
                if (paramInt < paramOwnerMyContractEntity.getPhotos_big().size())
                {
                  this.C.add(paramOwnerMyContractEntity.getPhotos_big().get(paramInt));
                  paramInt += 1;
                  continue;
                  this.owner_asset_house_info_address.setText("");
                  break;
                  paramOwnerMyContractEntity = "";
                  break label193;
                  localObject1 = "";
                  break label215;
                  this.owner_asset_house_info_time.setText("租约时间 " + paramOwnerMyContractEntity + " 至 " + (String)localObject1);
                  break label253;
                }
              }
            }
            if ((paramOwnerMyContractEntity.getPhotos_min() == null) || (paramOwnerMyContractEntity.getPhotos_min().size() == 0)) {
              this.owner_asset_house_image_ll.setVisibility(8);
            }
          }
          else
          {
            localObject1 = "";
            paramOwnerMyContractEntity = "";
            paramInt = this.B.getTrusteeship_day() / 30;
            i = this.B.getTrusteeship_surplus_day() / 30;
            j = this.B.getTrusteeship_day() % 30;
            k = this.B.getTrusteeship_surplus_day() % 30;
            if (paramInt == 0) {
              localObject1 = j + "天";
            }
            if (i == 0) {
              paramOwnerMyContractEntity = k + "天";
            }
            if (paramInt <= 0) {
              break label1944;
            }
            localObject2 = new StringBuilder().append(paramInt).append("个月");
            if (j != 0) {
              break label1641;
            }
            localObject1 = "";
            label593:
            localObject1 = (String)localObject1;
          }
        }
      }
    }
    label637:
    label701:
    label744:
    label814:
    label893:
    label959:
    label1038:
    label1173:
    label1641:
    label1788:
    label1812:
    label1825:
    label1837:
    label1849:
    label1870:
    label1882:
    label1894:
    label1906:
    label1918:
    label1928:
    label1930:
    label1944:
    for (;;)
    {
      if (i > 0)
      {
        localObject2 = new StringBuilder().append(i).append("个月");
        if (k == 0)
        {
          paramOwnerMyContractEntity = "";
          paramOwnerMyContractEntity = paramOwnerMyContractEntity;
        }
      }
      for (;;)
      {
        if (1 == this.B.getIs_nc())
        {
          paramOwnerMyContractEntity = this.a + (String)localObject1;
          ah.setTextColorOwner(this.owner_asset_trusteeship_day, paramOwnerMyContractEntity, this.a.length(), ((String)localObject1).length());
          if (!ae.notNull(this.B.getRenew_tip_text())) {
            break label1788;
          }
          this.owner_asset_renew.setVisibility(0);
          this.owner_asset_renew_tv.setVisibility(0);
          this.owner_asset_renew_tv.setText(this.B.getRenew_tip_text());
          if (this.B.getIncome() == null) {
            break label1894;
          }
          this.owner_asset_income_ll.setVisibility(0);
          if (!ae.notNull(this.B.getIncome().getAmount())) {
            break label1812;
          }
          this.owner_asset_income_all_money.setText("¥ " + this.B.getIncome().getAmount());
          if (this.B.getIncome().getLatest() == null) {
            break label1849;
          }
          if (!ae.notNull(this.B.getIncome().getLatest().getAmount())) {
            break label1825;
          }
          this.owner_asset_income_latest_money.setVisibility(0);
          this.owner_asset_income_latest_money.setText("最近一次打款记录: ¥ " + this.B.getIncome().getLatest().getAmount());
          if (!ae.notNull(this.B.getIncome().getLatest().getDate())) {
            break label1837;
          }
          this.owner_asset_income_latest_time.setVisibility(0);
          this.owner_asset_income_latest_time.setText("打款时间: " + this.B.getIncome().getLatest().getDate());
          if (this.B.getIncome().getNext() == null) {
            break label1882;
          }
          if (!ae.notNull(this.B.getIncome().getNext().getDate())) {
            break label1870;
          }
          this.owner_asset_income_next_time.setVisibility(0);
          this.owner_asset_income_next_time.setText("下一次付款将在" + this.B.getIncome().getNext().getDate());
          if (this.B.getService() != null)
          {
            this.owner_asset_clean_count.setText("累计保洁" + this.B.getService().getClean_times() + "次");
            this.owner_asset_repair_count.setText("累计维修服务" + this.B.getService().getRepair_times() + "次");
            if (!ae.notNull(this.B.getService().getClean_text())) {
              break label1906;
            }
            this.owner_asset_clean_tv.setVisibility(0);
            this.owner_asset_clean_tv.setText(this.B.getService().getClean_text());
            if (!ae.notNull(this.B.getService().getRepair_text())) {
              break label1918;
            }
            this.owner_asset_repair_tv.setVisibility(0);
            this.owner_asset_repair_tv.setText(this.B.getService().getRepair_text());
          }
        }
        for (;;)
        {
          if (this.B == null) {
            break label1928;
          }
          this.owner_asset_steward_img.setController(c.frescoController(this.B.getHousekeeper().getAvatar()));
          this.owner_asset_steward_name.setText("管家：" + this.B.getHousekeeper().getName());
          this.owner_asset_steward_phone.setText("手机：" + this.B.getHousekeeper().getPhone());
          if (!ae.notNull(this.B.getHousekeeper().getDesc())) {
            break label1930;
          }
          this.owner_asset_steward_text.setText(this.B.getHousekeeper().getDesc());
          return;
          this.owner_asset_house_image_ll.setVisibility(0);
          paramInt = (this.y - com.ziroom.ziroomcustomer.util.n.dip2px(this, 42.0F)) / 3;
          i = paramInt * 2 / 3;
          localObject1 = this.owner_asset_house_image1.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = paramInt;
          ((ViewGroup.LayoutParams)localObject1).height = i;
          this.owner_asset_house_image1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.owner_asset_house_image2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.owner_asset_house_image3_fl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.owner_asset_house_image1.setVisibility(8);
          this.owner_asset_house_image2.setVisibility(8);
          this.owner_asset_house_image3_fl.setVisibility(8);
          this.owner_asset_house_image_tv.setVisibility(8);
          this.view_third_background.setVisibility(8);
          if (paramOwnerMyContractEntity.getPhotos_min().size() >= 1)
          {
            this.owner_asset_house_image1.setController(c.frescoController((String)paramOwnerMyContractEntity.getPhotos_min().get(0)));
            this.owner_asset_house_image1.setVisibility(0);
          }
          if (paramOwnerMyContractEntity.getPhotos_min().size() >= 2)
          {
            this.owner_asset_house_image2.setController(c.frescoController((String)paramOwnerMyContractEntity.getPhotos_min().get(1)));
            this.owner_asset_house_image2.setVisibility(0);
          }
          if (paramOwnerMyContractEntity.getPhotos_min().size() >= 3)
          {
            this.owner_asset_house_image3.setController(c.frescoController((String)paramOwnerMyContractEntity.getPhotos_min().get(2)));
            this.owner_asset_house_image3.setVisibility(0);
            this.owner_asset_house_image3_fl.setVisibility(0);
          }
          if (paramOwnerMyContractEntity.getPhotos_min().size() <= 3) {
            break;
          }
          this.owner_asset_house_image_tv.setVisibility(0);
          this.view_third_background.setVisibility(0);
          break;
          localObject1 = j + "天";
          break label593;
          paramOwnerMyContractEntity = k + "天";
          break label637;
          localObject2 = this.a + (String)localObject1 + this.b + paramOwnerMyContractEntity;
          TextView localTextView = this.owner_asset_trusteeship_day;
          paramInt = this.a.length();
          i = ((String)localObject1).length();
          j = this.a.length();
          ah.setTextColorOwner(localTextView, (String)localObject2, paramInt, i, ((String)localObject1).length() + j + this.b.length(), paramOwnerMyContractEntity.length());
          break label701;
          this.owner_asset_renew.setVisibility(8);
          break label744;
          this.owner_asset_house_text_ll.setVisibility(8);
          break label744;
          this.owner_asset_income_all_money.setText("¥ 0.00");
          break label814;
          this.owner_asset_income_latest_money.setVisibility(8);
          break label893;
          this.owner_asset_income_latest_time.setVisibility(8);
          break label959;
          this.owner_asset_income_latest_money.setVisibility(8);
          this.owner_asset_income_latest_time.setVisibility(8);
          break label959;
          this.owner_asset_income_next_time.setVisibility(8);
          break label1038;
          this.owner_asset_income_next_time.setVisibility(8);
          break label1038;
          this.owner_asset_income_ll.setVisibility(8);
          break label1038;
          this.owner_asset_clean_tv.setVisibility(8);
          break label1173;
          this.owner_asset_repair_tv.setVisibility(8);
        }
        break;
        this.owner_asset_steward_text.setText("");
        return;
      }
    }
  }
  
  private void a(final Class paramClass)
  {
    if (this.e)
    {
      if (!ApplicationEx.c.isImconnect())
      {
        com.ziroom.ziroomcustomer.newchat.a.register(this);
        if (l.getNetWorkType(this.z)) {
          showProgressNoCancel("", 8000L);
        }
        for (;;)
        {
          new Thread()
          {
            public void run()
            {
              super.run();
              try
              {
                if (l.getNetWorkType(OwnerZoneActivity.p(OwnerZoneActivity.this))) {
                  Thread.sleep(8000L);
                }
                for (;;)
                {
                  Intent localIntent = new Intent(OwnerZoneActivity.p(OwnerZoneActivity.this), paramClass);
                  OwnerZoneActivity.this.startActivity(localIntent);
                  return;
                  Thread.sleep(18000L);
                }
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;)
                {
                  localInterruptedException.printStackTrace();
                }
              }
            }
          }.start();
          return;
          showProgressNoCancel("", 18000L);
        }
      }
      startActivity(new Intent(this.z, paramClass));
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  private void a(final List<OwnerMyBannerOneBean.HuodongBean> paramList)
  {
    if ((this.convenientBanner != null) && (paramList != null) && (paramList.size() > 0))
    {
      this.convenientBanner.setVisibility(0);
      this.vDividerTopCb.setVisibility(0);
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        localArrayList.add(((OwnerMyBannerOneBean.HuodongBean)paramList.get(i)).img);
        i += 1;
      }
      this.convenientBanner.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
      {
        public OwnerZoneActivity.a createHolder()
        {
          return new OwnerZoneActivity.a(OwnerZoneActivity.this, null);
        }
      }, localArrayList, new ConvenientBanner.b()
      {
        public void configGio(ViewPager paramAnonymousViewPager) {}
      }).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setCoverBottomViewResource(2130838550).setCoverBottomViewVisible(true).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
      {
        public void onItemClick(int paramAnonymousInt)
        {
          OwnerMyBannerOneBean.HuodongBean localHuodongBean = (OwnerMyBannerOneBean.HuodongBean)paramList.get(paramAnonymousInt);
          if (localHuodongBean != null) {
            JsBridgeWebActivity.start(OwnerZoneActivity.p(OwnerZoneActivity.this), localHuodongBean.title, localHuodongBean.target, true, localHuodongBean.description, localHuodongBean.img, false);
          }
        }
      }).setPointViewVisible(true);
      this.convenientBanner.startTurning(5000L);
      return;
    }
    this.convenientBanner.setVisibility(8);
    this.vDividerTopCb.setVisibility(8);
  }
  
  private void a(final boolean paramBoolean)
  {
    com.ziroom.commonlibrary.login.a.verifyToken(this, new a.c()
    {
      public void onVerifyFinish(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          if (paramBoolean)
          {
            OwnerZoneActivity.a(OwnerZoneActivity.this, com.ziroom.commonlibrary.login.a.getToken(OwnerZoneActivity.this));
            return;
          }
          OwnerZoneActivity.a(OwnerZoneActivity.this);
          OwnerZoneActivity.b(OwnerZoneActivity.this);
          return;
        }
        OwnerZoneActivity.c(OwnerZoneActivity.this);
      }
    });
  }
  
  private void b()
  {
    this.E = new ArrayList();
    if ((this.A != null) && (this.A.getContracts_signed() != null) && (this.A.getContracts_signed().size() > 0))
    {
      int i = 0;
      while (i < this.A.getContracts_signed().size())
      {
        this.E.add(((OwnerMySignedEntity)this.A.getContracts_signed().get(i)).getAddress());
        i += 1;
      }
    }
    if (this.x == null) {
      this.x = new com.ziroom.ziroomcustomer.dialog.f("选择房屋", this, this.E, this, this.view_top_0dp, this.D);
    }
    this.x.showPopwindow();
  }
  
  private void b(int paramInt)
  {
    Intent localIntent = new Intent(this, ZryuPhotoPreviewActivity.class);
    localIntent.putStringArrayListExtra("urlList", (ArrayList)this.C);
    localIntent.putExtra("position", paramInt);
    localIntent.putExtra("isDeleteable", false);
    startActivity(localIntent);
  }
  
  private void b(Class paramClass)
  {
    this.e = ApplicationEx.c.isLoginState();
    if (this.e)
    {
      startActivity(new Intent(this, paramClass));
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  private void d(String paramString)
  {
    j.getOwnerBaseInfo(this, paramString, new com.ziroom.ziroomcustomer.e.a.f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.logBigData("OwnerZoneActivity", "===" + paramAnonymouse.toString());
        OwnerZoneActivity.a(OwnerZoneActivity.this, (OwnerMyBannerOneBean)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString(), OwnerMyBannerOneBean.class));
        if (OwnerZoneActivity.d(OwnerZoneActivity.this) != null) {
          OwnerZoneActivity.e(OwnerZoneActivity.this);
        }
        for (;;)
        {
          if (OwnerZoneActivity.f(OwnerZoneActivity.this))
          {
            OwnerZoneActivity.a(OwnerZoneActivity.this);
            OwnerZoneActivity.b(OwnerZoneActivity.this);
          }
          return;
          OwnerZoneActivity.this.showToast("");
        }
      }
    });
  }
  
  private void e()
  {
    j.getOwnerEntrustSchedule(this, com.ziroom.commonlibrary.login.a.getToken(this), new com.ziroom.ziroomcustomer.e.a.f(this, new com.ziroom.ziroomcustomer.e.c.n())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        u.logBigData("OwnerZoneActivity", "===Entrust:" + paramAnonymousb.toString());
        OwnerZoneActivity.a(OwnerZoneActivity.this, com.alibaba.fastjson.a.parseArray(paramAnonymousb.toString(), OwnerEntrustScheduleBean.class));
        if ((OwnerZoneActivity.m(OwnerZoneActivity.this) != null) && (OwnerZoneActivity.m(OwnerZoneActivity.this).size() > 0) && (OwnerZoneActivity.m(OwnerZoneActivity.this).get(OwnerZoneActivity.n(OwnerZoneActivity.this)) != null))
        {
          OwnerZoneActivity.a(OwnerZoneActivity.this, (OwnerEntrustScheduleBean)OwnerZoneActivity.m(OwnerZoneActivity.this).get(OwnerZoneActivity.n(OwnerZoneActivity.this)));
          OwnerZoneActivity.o(OwnerZoneActivity.this);
        }
        for (;;)
        {
          OwnerZoneActivity.b(OwnerZoneActivity.this, true);
          if ((OwnerZoneActivity.g(OwnerZoneActivity.this)) && (OwnerZoneActivity.h(OwnerZoneActivity.this)))
          {
            OwnerZoneActivity.a(OwnerZoneActivity.this, false);
            OwnerZoneActivity.b(OwnerZoneActivity.this, false);
            OwnerZoneActivity.i(OwnerZoneActivity.this);
          }
          return;
          OwnerZoneActivity.this.containerEntrustSchedule.setVisibility(8);
          OwnerZoneActivity.this.containerOwnerZoneAdBanner.setVisibility(8);
        }
      }
    });
  }
  
  private void e(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramString.equals("zixun"))
        {
          i = 0;
          continue;
          if (paramString.equals("banjia"))
          {
            i = 1;
            continue;
            if (paramString.equals("baojie"))
            {
              i = 2;
              continue;
              if (paramString.equals("weixiu"))
              {
                i = 3;
                continue;
                if (paramString.equals("youhui"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("fuwuchuzhi")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    a(ChatNewActivity.class);
    return;
    startActivity(new Intent(this, MoveTypeActivity.class));
    return;
    startActivity(new Intent(this, CleanHomeActivity.class));
    return;
    startActivity(new Intent(this, RepairHomeActivity.class));
    return;
    b(MyCouponActivity.class);
    return;
    b(MyCardsActivity.class);
  }
  
  private void f()
  {
    int i;
    int j;
    label89:
    Object localObject;
    View localView1;
    View localView2;
    View localView3;
    TextView localTextView1;
    TextView localTextView2;
    TextView localTextView3;
    if (this.u != null)
    {
      this.containerOwnerZoneAdBanner.setVisibility(0);
      this.containerEntrustSchedule.setVisibility(0);
      this.tvOwnerZoneEntrustSchedule.setText("委托进度");
      this.tvOwnerZoneEntrustScheduleTitle.setText(this.r.address);
      if ((this.r.progress == null) || (this.r.progress.size() <= 0)) {
        break label608;
      }
      this.llOwnerZoneEntrustSchedule.removeAllViews();
      LayoutInflater localLayoutInflater = LayoutInflater.from(this);
      i = 0;
      j = -1;
      if (i >= this.r.progress.size()) {
        break label608;
      }
      localObject = (OwnerEntrustScheduleBean.ProgressBean)this.r.progress.get(i);
      localView1 = localLayoutInflater.inflate(2130904418, this.llOwnerZoneEntrustSchedule, false);
      localView2 = localView1.findViewById(2131695502);
      localView3 = localView1.findViewById(2131695504);
      localTextView1 = (TextView)localView1.findViewById(2131695505);
      localTextView2 = (TextView)localView1.findViewById(2131695507);
      localTextView3 = (TextView)localView1.findViewById(2131695506);
      if (ae.isNull(((OwnerEntrustScheduleBean.ProgressBean)localObject).desc)) {
        break label471;
      }
      localTextView1.setText("[" + ((OwnerEntrustScheduleBean.ProgressBean)localObject).name + "] " + ((OwnerEntrustScheduleBean.ProgressBean)localObject).desc);
      label251:
      if (!ae.isNull(((OwnerEntrustScheduleBean.ProgressBean)localObject).date)) {
        break label484;
      }
      localTextView2.setVisibility(8);
      label269:
      if ((((OwnerEntrustScheduleBean.ProgressBean)localObject).housekepper == null) || (ae.isNull(((OwnerEntrustScheduleBean.ProgressBean)localObject).housekepper.name)) || (ae.isNull(((OwnerEntrustScheduleBean.ProgressBean)localObject).housekepper.phone))) {
        break label493;
      }
      localTextView3.setVisibility(0);
      localTextView3.setText("管家: " + ((OwnerEntrustScheduleBean.ProgressBean)localObject).housekepper.name + " " + ((OwnerEntrustScheduleBean.ProgressBean)localObject).housekepper.phone);
      label360:
      if (((OwnerEntrustScheduleBean.ProgressBean)localObject).active != 1) {
        break label657;
      }
      j = i;
    }
    label397:
    label471:
    label484:
    label493:
    label560:
    label608:
    label657:
    for (;;)
    {
      int k;
      if ((j != -1) && (i > j))
      {
        localTextView1.setTextColor(-4276546);
        localTextView2.setTextColor(-4276546);
        localObject = (ViewGroup.MarginLayoutParams)localView2.getLayoutParams();
        k = (int)(2.25D * getResources().getDisplayMetrics().density);
        if (i != 0) {
          break label560;
        }
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(k, com.ziroom.ziroomcustomer.util.n.dip2px(this, 8.0F), 0, 0);
      }
      for (;;)
      {
        this.llOwnerZoneEntrustSchedule.addView(localView1);
        i += 1;
        break label89;
        this.containerOwnerZoneAdBanner.setVisibility(8);
        break;
        localTextView1.setText(((OwnerEntrustScheduleBean.ProgressBean)localObject).name);
        break label251;
        localTextView2.setVisibility(0);
        break label269;
        localTextView3.setVisibility(8);
        break label360;
        if (i == j)
        {
          localView3.setBackground(getResources().getDrawable(2130837702));
          localTextView1.setTextColor(getResources().getColor(2131624609));
          break label397;
        }
        localTextView1.setTextColor(-6710887);
        localTextView2.setTextColor(-6710887);
        break label397;
        if (i == this.r.progress.size() - 1) {
          ((ViewGroup.MarginLayoutParams)localObject).setMargins(k, 0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(this, 14.0F));
        } else {
          ((ViewGroup.MarginLayoutParams)localObject).setMargins(k, 0, 0, 0);
        }
      }
      if (this.u != null)
      {
        this.ivOwnerZoneAdBanner.setController(c.frescoController(this.u.img));
        this.ivOwnerZoneAdBanner.setOnClickListener(this);
      }
      this.btnShowAllEntrust.setOnClickListener(this);
      this.showEntrustDetail.setOnClickListener(this);
      return;
    }
  }
  
  private void f(String paramString)
  {
    GenericDraweeHierarchy localGenericDraweeHierarchy = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).setPlaceholderImage(2130839162).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFailureImage(2130839162).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();
    RoundingParams localRoundingParams = new RoundingParams();
    localRoundingParams.setRoundAsCircle(true);
    localRoundingParams.setBorder(Color.parseColor("#99FFFFFF"), com.ziroom.ziroomcustomer.util.n.dip2px(this, 2.0F));
    localGenericDraweeHierarchy.setRoundingParams(localRoundingParams);
    this.myinfoIvIcon.setHierarchy(localGenericDraweeHierarchy);
    this.myinfoIvIcon.setController(c.frescoController(paramString));
  }
  
  private void g()
  {
    if (h())
    {
      this.containerOwnerZoneAdBannerNotOwner.setVisibility(8);
      return;
    }
    if (this.w != null)
    {
      this.containerOwnerZoneAdBannerNotOwner.setVisibility(0);
      this.ivOwnerZoneAdBannerNotOwner.setController(c.frescoController(this.w.img));
      this.ivOwnerZoneAdBannerNotOwner.setOnClickListener(this);
      return;
    }
    this.containerOwnerZoneAdBannerNotOwner.setVisibility(8);
  }
  
  private boolean h()
  {
    return (k()) || (j()) || (i());
  }
  
  private boolean i()
  {
    return (this.A != null) && (this.A.getContracts_signed() != null) && (this.A.getContracts_signed().size() > 0);
  }
  
  private boolean j()
  {
    return (this.A != null) && (this.A.getContracts_unsigned() != null) && (this.A.getContracts_unsigned().size() > 0);
  }
  
  private boolean k()
  {
    return this.r != null;
  }
  
  private void l()
  {
    com.ziroom.commonlibrary.login.a.verifyToken(this, new a.c()
    {
      public void onVerifyFinish(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          Intent localIntent = new Intent(OwnerZoneActivity.this, OwnerContrastListActivity.class);
          OwnerZoneActivity.this.startActivity(localIntent);
          return;
        }
        com.ziroom.commonlibrary.login.a.startLoginActivity(OwnerZoneActivity.this);
      }
    });
  }
  
  private void m()
  {
    if ((this.f.yezhubanner != null) && (this.f.yezhubanner.size() > 0)) {
      this.u = ((OwnerMyBannerOneBean.YezhubannerBean)this.f.yezhubanner.get(this.t));
    }
    if ((this.f.banner != null) && (this.f.banner.size() > 0)) {
      this.w = ((OwnerMyBannerOneBean.BannerBean)this.f.banner.get(this.v));
    }
    if (this.f != null)
    {
      Object localObject;
      label197:
      label270:
      int i;
      label321:
      ContentBean localContentBean;
      if (this.f.huodong != null)
      {
        a(this.f.huodong);
        if ((this.f.menu_primay == null) || (this.f.menu_primay.size() <= 0)) {
          break label466;
        }
        localObject = new b(this, this.f.menu_primay);
        this.glOwerMyBannerTop.setVisibility(0);
        this.glOwerMyBannerTop.setAdapter((ListAdapter)localObject);
        this.glOwerMyBannerTop.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (!ae.isNull(((OwnerMyBannerOneBean.MenuPrimayBean)OwnerZoneActivity.d(OwnerZoneActivity.this).menu_primay.get(paramAnonymousInt)).applink))
            {
              paramAnonymousAdapterView = ((OwnerMyBannerOneBean.MenuPrimayBean)OwnerZoneActivity.d(OwnerZoneActivity.this).menu_primay.get(paramAnonymousInt)).applink;
              paramAnonymousInt = -1;
              switch (paramAnonymousAdapterView.hashCode())
              {
              default: 
                switch (paramAnonymousInt)
                {
                }
                break;
              }
            }
            do
            {
              return;
              if (!paramAnonymousAdapterView.equals("yzContract")) {
                break;
              }
              paramAnonymousInt = 0;
              break;
              OwnerZoneActivity.q(OwnerZoneActivity.this);
              return;
              if ("0".equals(((OwnerMyBannerOneBean.MenuPrimayBean)OwnerZoneActivity.d(OwnerZoneActivity.this).menu_primay.get(paramAnonymousInt)).app))
              {
                OwnerZoneActivity.this.toH5Page(((OwnerMyBannerOneBean.MenuPrimayBean)OwnerZoneActivity.d(OwnerZoneActivity.this).menu_primay.get(paramAnonymousInt)).target, ((OwnerMyBannerOneBean.MenuPrimayBean)OwnerZoneActivity.d(OwnerZoneActivity.this).menu_primay.get(paramAnonymousInt)).title);
                return;
              }
            } while (!"1".equals(((OwnerMyBannerOneBean.MenuPrimayBean)OwnerZoneActivity.d(OwnerZoneActivity.this).menu_primay.get(paramAnonymousInt)).app));
            paramAnonymousAdapterView = ((OwnerMyBannerOneBean.MenuPrimayBean)OwnerZoneActivity.d(OwnerZoneActivity.this).menu_primay.get(paramAnonymousInt)).target;
            OwnerZoneActivity.b(OwnerZoneActivity.this, paramAnonymousAdapterView);
          }
        });
        if ((this.f.menu_secondary == null) || (this.f.menu_secondary.size() <= 0)) {
          break label478;
        }
        localObject = new c(this, this.f.menu_secondary);
        this.container_ower_my_banner_bottom.setVisibility(0);
        this.glOwerMyBannerBottom.setAdapter((ListAdapter)localObject);
        this.glOwerMyBannerBottom.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if ("0".equals(((OwnerMyBannerOneBean.MenuSecondaryBean)OwnerZoneActivity.d(OwnerZoneActivity.this).menu_secondary.get(paramAnonymousInt)).app)) {
              OwnerZoneActivity.this.toH5Page(((OwnerMyBannerOneBean.MenuSecondaryBean)OwnerZoneActivity.d(OwnerZoneActivity.this).menu_secondary.get(paramAnonymousInt)).target, ((OwnerMyBannerOneBean.MenuSecondaryBean)OwnerZoneActivity.d(OwnerZoneActivity.this).menu_secondary.get(paramAnonymousInt)).title);
            }
            while (!"1".equals(((OwnerMyBannerOneBean.MenuSecondaryBean)OwnerZoneActivity.d(OwnerZoneActivity.this).menu_secondary.get(paramAnonymousInt)).app)) {
              return;
            }
            paramAnonymousAdapterView = ((OwnerMyBannerOneBean.MenuSecondaryBean)OwnerZoneActivity.d(OwnerZoneActivity.this).menu_secondary.get(paramAnonymousInt)).target;
            OwnerZoneActivity.b(OwnerZoneActivity.this, paramAnonymousAdapterView);
          }
        });
        if ((this.f.trends == null) || (this.f.trends.list == null) || (this.f.trends.list.size() <= 0)) {
          break label733;
        }
        localObject = new ArrayList();
        i = 0;
        if (i >= this.f.trends.list.size()) {
          break label538;
        }
        localContentBean = new ContentBean();
        localContentBean.setPic(((OwnerMyBannerOneBean.TrendsBean.ListBean)this.f.trends.list.get(i)).img);
        if (i != 0) {
          break label490;
        }
        localContentBean.setTitle(((OwnerMyBannerOneBean.TrendsBean.ListBean)this.f.trends.list.get(i)).title);
      }
      for (;;)
      {
        localContentBean.setLink(((OwnerMyBannerOneBean.TrendsBean.ListBean)this.f.trends.list.get(i)).target);
        ((List)localObject).add(localContentBean);
        i += 1;
        break label321;
        this.convenientBanner.setVisibility(8);
        this.vDividerTopCb.setVisibility(8);
        break;
        label466:
        this.glOwerMyBannerTop.setVisibility(8);
        break label197;
        label478:
        this.container_ower_my_banner_bottom.setVisibility(8);
        break label270;
        label490:
        if (!ae.isNull(((ContentBean)((List)localObject).get(0)).getTitle())) {
          localContentBean.setTitle(((OwnerMyBannerOneBean.TrendsBean.ListBean)this.f.trends.list.get(i)).title);
        }
      }
      label538:
      this.hrvZiruNews.setVisibility(0);
      bindHomeRecyclerView(this.hrvZiruNews, (List)localObject, "自如动态");
      if ((this.f.club != null) && (this.f.club.list != null) && (this.f.club.list.size() > 0))
      {
        localObject = new ArrayList();
        i = 0;
        label609:
        if (i < this.f.club.list.size())
        {
          localContentBean = new ContentBean();
          localContentBean.setPic(((OwnerMyBannerOneBean.ClubBean.ListBean)this.f.club.list.get(i)).img);
          if (i == 0) {
            localContentBean.setTitle(((OwnerMyBannerOneBean.ClubBean.ListBean)this.f.club.list.get(i)).title);
          }
          for (;;)
          {
            localContentBean.setLink(((OwnerMyBannerOneBean.ClubBean.ListBean)this.f.club.list.get(i)).target);
            ((List)localObject).add(localContentBean);
            i += 1;
            break label609;
            label733:
            this.hrvZiruNews.setVisibility(8);
            break;
            if (!ae.isNull(((ContentBean)((List)localObject).get(0)).getTitle())) {
              localContentBean.setTitle(((OwnerMyBannerOneBean.ClubBean.ListBean)this.f.club.list.get(i)).title);
            }
          }
        }
        this.hrvOwnerClub.setVisibility(0);
        bindHomeRecyclerView(this.hrvOwnerClub, (List)localObject, "业主俱乐部");
      }
    }
    else
    {
      return;
    }
    this.hrvOwnerClub.setVisibility(8);
  }
  
  private void n()
  {
    if (o())
    {
      if (this.f.tip != null)
      {
        this.containerOwnerMailFromCEO.setVisibility(0);
        this.tvOwnerZoneMfceoTitle.setText(this.f.tip.title);
        this.tvOwnerZoneMfceoDesc.setText(this.f.tip.desc);
        this.ivOwnerZoneMfceoIcon.setController(c.frescoController(this.f.tip.icon));
        this.btnSeeMfceoDetail.setOnClickListener(this);
        if (ae.isNull(ad.getOther(this, "owner_show_mfceo_time"))) {
          ad.putOther(this, "owner_show_mfceo_time", Calendar.getInstance().getTimeInMillis() + "");
        }
        return;
      }
      this.containerOwnerMailFromCEO.setVisibility(8);
      return;
    }
    this.containerOwnerMailFromCEO.setVisibility(8);
  }
  
  private boolean o()
  {
    return (p()) && (this.A != null) && (this.A.getContracts_signed() != null) && (this.A.getContracts_signed().size() > 0);
  }
  
  private boolean p()
  {
    String str = ad.getOther(this, "owner_show_mfceo_time");
    if (ae.isNull(str)) {}
    Calendar localCalendar;
    do
    {
      return true;
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(Long.parseLong(str));
      localCalendar.add(5, 1);
    } while (Calendar.getInstance().getTimeInMillis() < localCalendar.getTimeInMillis());
    return false;
  }
  
  private void q()
  {
    Object localObject = getResources().getDisplayMetrics();
    int i = (int)((((DisplayMetrics)localObject).widthPixels - ((DisplayMetrics)localObject).density * 36.0F) / 1.5F);
    ((LinearLayout.LayoutParams)this.convenientBanner.getLayoutParams()).height = i;
    this.myinfoScrollview.setOnScrollChangedCallback(this);
    this.glOwerMyBannerTop.setSelector(new ColorDrawable(0));
    this.glOwerMyBannerBottom.setSelector(new ColorDrawable(0));
    this.myinfoBack.setOnClickListener(this);
    this.myinfoOwnerSetting.setOnClickListener(this);
    this.changeMode.setOnClickListener(this);
    i = this.y * 70 / 375;
    localObject = this.owner_asset_house_image1.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.y;
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.ivOwnerZoneAdBannerNotOwner.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.ivOwnerZoneAdBanner.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private boolean r()
  {
    this.e = ApplicationEx.c.isLoginState();
    if (this.e)
    {
      this.myinfoTvName.setVisibility(0);
      this.c = ApplicationEx.c.getUser();
      if (this.c != null)
      {
        if (TextUtils.isEmpty(this.c.getNick_name())) {
          break label101;
        }
        this.myinfoTvName.setText(this.c.getNick_name());
        f(this.c.getHead_img());
      }
    }
    for (;;)
    {
      this.myinfoTvName.setOnClickListener(this);
      this.myinfoIvIcon.setOnClickListener(this);
      return this.e;
      label101:
      if (!TextUtils.isEmpty(this.c.getLogin_name_mobile()))
      {
        this.myinfoTvName.setText(this.c.getLogin_name_mobile());
        break;
      }
      if (!TextUtils.isEmpty(this.c.getLogin_name_email()))
      {
        this.myinfoTvName.setText(this.c.getLogin_name_email());
        break;
      }
      this.myinfoTvName.setText(getString(2131297329));
      break;
      this.myinfoTvName.setVisibility(0);
      this.myinfoTvName.setText("登录/注册");
      this.myinfoIvIcon.setImageResource(2130839260);
    }
  }
  
  private void s()
  {
    r();
    d("");
    this.containerOwnerMailFromCEO.setVisibility(8);
    this.containerOwnerZoneAdBannerNotOwner.setVisibility(8);
    this.containerOwnerZoneAdBanner.setVisibility(8);
    this.containerEntrustSchedule.setVisibility(8);
    this.gl_ower_my_contract.setVisibility(8);
    this.gl_ower_my_assets.setVisibility(8);
  }
  
  public void bindHomeRecyclerView(HomeRecyclerView paramHomeRecyclerView, final List<ContentBean> paramList, String paramString)
  {
    if (paramList == null)
    {
      paramHomeRecyclerView.setVisibility(8);
      return;
    }
    paramHomeRecyclerView.setVisibility(0);
    paramHomeRecyclerView.setTitle(paramString);
    paramHomeRecyclerView.setSubTitle(null);
    paramHomeRecyclerView.setData(this, paramList, 7);
    paramHomeRecyclerView.setOnClickListener(new HomeCListCtrlView.b()
    {
      public void onClick() {}
      
      public void onItemClick(int paramAnonymousInt)
      {
        ContentBean localContentBean = (ContentBean)paramList.get(paramAnonymousInt);
        OwnerZoneActivity.this.toH5Page(localContentBean.getLink(), localContentBean.getTitle());
      }
    });
  }
  
  @OnClick({2131697726, 2131697730, 2131697731, 2131697733, 2131697732, 2131697735, 2131697739, 2131697745, 2131697752, 2131697758})
  public void onClic(View paramView)
  {
    switch (paramView.getId())
    {
    }
    label326:
    do
    {
      do
      {
        return;
        b();
        return;
        b(0);
        return;
        b(1);
        return;
        b(2);
        return;
        if (this.B != null)
        {
          if (this.B.getHousekeeper() != null)
          {
            if (ae.notNull(this.B.getHousekeeper().getPhone()))
            {
              ah.callPhone(this, this.B.getHousekeeper().getPhone());
              return;
            }
            showToast("管家手机号为空");
            return;
          }
          showToast("数据错误");
          return;
        }
        showToast("数据错误");
        return;
        if (this.B != null)
        {
          if (this.B.getHousekeeper() != null)
          {
            if (ae.notNull(this.B.getHousekeeper().getPhone()))
            {
              ah.callPhone(this, this.B.getHousekeeper().getPhone());
              return;
            }
            showToast("管家手机号为空");
            return;
          }
          showToast("数据错误");
          return;
        }
        showToast("数据错误");
        return;
        if (this.B == null) {
          break label326;
        }
        if (this.B.getIncome() == null) {
          break;
        }
      } while (!"1".equals(this.B.getIncome().getLink_type()));
      toH5Page(this.B.getIncome().getLink(), "付款计划");
      return;
      showToast("数据错误");
      return;
      showToast("数据错误");
      return;
      if (this.B == null) {
        break label396;
      }
      if (this.B.getService() == null) {
        break;
      }
    } while (!"1".equals(this.B.getService().getLink_type()));
    toH5Page(this.B.getService().getLink(), "服务记录");
    return;
    showToast("数据错误");
    return;
    label396:
    showToast("数据错误");
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.e = ApplicationEx.c.isLoginState();
    switch (paramView.getId())
    {
    default: 
    case 2131697704: 
    case 2131697702: 
    case 2131697764: 
    case 2131697765: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                } while (this.w == null);
                if ("0".equals(this.w.app))
                {
                  toH5Page(this.w.target, this.w.title);
                  return;
                }
              } while (!"1".equals(this.w.app));
              return;
            } while (this.u == null);
            if ("0".equals(this.u.app))
            {
              toH5Page(this.u.target, this.u.title);
              return;
            }
          } while (!"1".equals(this.u.app));
          return;
          if ("1".equals(this.r.link_all_type))
          {
            toH5Page(this.r.link_all, "我的委托和我的推荐");
            return;
          }
        } while (!"0".equals(this.r.link_all_type));
        return;
        if ("1".equals(this.r.link_detail_type))
        {
          toH5Page(this.r.link_detail, "委托详情");
          return;
        }
      } while (!"0".equals(this.r.link_detail_type));
      return;
    case 2131697770: 
      toH5Page(this.f.tip.target, this.f.tip.title);
      return;
    case 2131692024: 
      startActivity(new Intent(this, IssueHouseActivity.class));
      finish();
      return;
    case 2131691481: 
    case 2131692018: 
      b(SelfSettingActivity.class);
      return;
    case 2131692026: 
      b(MyAccountActivity.class);
      return;
    }
    paramView = new Intent(this, MainActivity.class);
    paramView.putExtra("FRAGMENT_TYPE", 7);
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.y = ac.getScreenWidth(this);
    this.F = false;
    this.G = false;
    setContentView(2130903414);
    this.c = ApplicationEx.c.getUser();
    if (this.c != null) {}
    for (paramBundle = this.c.getUid();; paramBundle = "")
    {
      this.d = paramBundle;
      ButterKnife.bind(this);
      this.z = this;
      q();
      a(true);
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    r();
    if (this.H)
    {
      this.H = false;
      return;
    }
    a(false);
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    float f2 = paramInt2 / com.ziroom.ziroomcustomer.util.n.dip2px(this, 100.0F);
    if (f2 > 1.0F) {}
    for (;;)
    {
      this.myinfoRlHeader.setAlpha(f1);
      this.myinfoTvTitle.setAlpha(f1);
      this.myinfoTitleLine.setAlpha(f1);
      if (f1 > 0.6D)
      {
        this.myinfoBack.setImageResource(2130840141);
        this.myinfoOwnerSetting.setTextColor(getResources().getColor(2131624597));
        return;
      }
      this.myinfoBack.setImageResource(2130840142);
      this.myinfoOwnerSetting.setTextColor(getResources().getColor(2131624583));
      return;
      f1 = f2;
    }
  }
  
  public void onSelected(int paramInt)
  {
    this.D = paramInt;
    if (this.A.getContracts_signed() != null) {
      a(this.A, this.D);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public void toH5Page(final String paramString1, final String paramString2)
  {
    com.ziroom.commonlibrary.login.a.verifyToken(this, new a.c()
    {
      public void onVerifyFinish(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          String str = paramString1;
          if (str.contains("?")) {}
          for (str = str + "&";; str = str + "?")
          {
            str = str + "token=" + com.ziroom.commonlibrary.login.a.getToken(OwnerZoneActivity.this);
            Log.i("OwnerZoneActivity", "跳转到H5:" + str);
            JsBridgeWebActivity.start(OwnerZoneActivity.this, paramString2, str);
            return;
          }
        }
        com.ziroom.commonlibrary.login.a.startLoginActivity(OwnerZoneActivity.this);
      }
    });
  }
  
  private class a
    implements com.ziroom.commonlibrary.widget.convenientbanner.b.b<String>
  {
    private SimpleDraweeView b;
    
    private a() {}
    
    public void UpdateUI(Context paramContext, int paramInt, String paramString)
    {
      paramContext = x.makeUrl(paramString);
      this.b.setController(c.frescoController(paramContext));
    }
    
    public View createView(Context paramContext)
    {
      this.b = new SimpleDraweeView(paramContext);
      ((GenericDraweeHierarchy)this.b.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
      return this.b;
    }
  }
  
  public class b
    extends BaseAdapter
  {
    private Context b;
    private List<OwnerMyBannerOneBean.MenuPrimayBean> c;
    
    public b(List<OwnerMyBannerOneBean.MenuPrimayBean> paramList)
    {
      this.b = paramList;
      List localList;
      this.c = localList;
    }
    
    public int getCount()
    {
      if (this.c != null) {
        return this.c.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramViewGroup = new a(null);
        paramView = ((Activity)this.b).getLayoutInflater().inflate(2130904423, null);
        paramViewGroup.b = ((TextView)paramView.findViewById(2131695522));
        paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131695521));
        c.frescoHierarchyController(paramViewGroup.a, 2130840479);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.a.setController(c.frescoController(((OwnerMyBannerOneBean.MenuPrimayBean)this.c.get(paramInt)).img));
        paramViewGroup.b.setText(((OwnerMyBannerOneBean.MenuPrimayBean)this.c.get(paramInt)).getTitle());
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private class a
    {
      SimpleDraweeView a;
      TextView b;
      
      private a() {}
    }
  }
  
  public class c
    extends BaseAdapter
  {
    private Context b;
    private List<OwnerMyBannerOneBean.MenuSecondaryBean> c;
    
    public c(List<OwnerMyBannerOneBean.MenuSecondaryBean> paramList)
    {
      this.b = paramList;
      List localList;
      this.c = localList;
    }
    
    public int getCount()
    {
      if (this.c != null) {
        return this.c.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramViewGroup = new a(null);
        paramView = ((Activity)this.b).getLayoutInflater().inflate(2130904424, null);
        paramViewGroup.b = ((TextView)paramView.findViewById(2131695522));
        paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131695521));
        c.frescoHierarchyController(paramViewGroup.a, 2130840479);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.a.setController(c.frescoController(((OwnerMyBannerOneBean.MenuSecondaryBean)this.c.get(paramInt)).img));
        paramViewGroup.b.setText(((OwnerMyBannerOneBean.MenuSecondaryBean)this.c.get(paramInt)).getTitle());
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private class a
    {
      SimpleDraweeView a;
      TextView b;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerZoneActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */