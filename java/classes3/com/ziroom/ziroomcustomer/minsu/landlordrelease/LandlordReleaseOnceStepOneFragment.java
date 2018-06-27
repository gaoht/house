package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.BaseLandlordReleaseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.BaiduLocationBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseStreetBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.RegionMsgBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LandlordReleaseOnceStepOneFragment
  extends BaseLandlordReleaseFragment
  implements com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a
{
  private Context b;
  @BindView(2131690078)
  View btn_back;
  @BindView(2131694286)
  View btn_house_type;
  @BindView(2131691560)
  View btn_next;
  private Unbinder c;
  private c d;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b e;
  private LandlordReleaseTypeLocationInfo f;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  @BindView(2131694624)
  ImageView iv_house_rent_way_1;
  @BindView(2131694627)
  ImageView iv_house_rent_way_2;
  @BindView(2131694631)
  ImageView iv_house_rent_way_3;
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.a j;
  private List<String> k = new ArrayList();
  private String l = "您需要保证其他的合租室友知情并同意，如果在经营过程中出现其他室友投诉影响客户的正常入住，自如民宿平台会强制下架您的房源，并承担客户的损失，情节严重者，会把您加入自如民宿的黑名单，甚至封号处理。";
  @BindView(2131694282)
  LinearLayout ll_house_rent_way_container;
  @BindView(2131694628)
  LinearLayout ll_house_rent_way_title_3;
  @BindView(2131694285)
  LinearLayout ll_house_type_container;
  @BindView(2131691557)
  ObservableScrollView osv_content;
  @BindView(2131689893)
  ReleaseUsageAndTipsView ruatv_tip;
  @BindView(2131694284)
  TextView tv_house_rent_way_content_1;
  @BindView(2131694626)
  TextView tv_house_rent_way_content_2;
  @BindView(2131694630)
  TextView tv_house_rent_way_content_3;
  @BindView(2131694283)
  TextView tv_house_rent_way_title_1;
  @BindView(2131694625)
  TextView tv_house_rent_way_title_2;
  @BindView(2131694629)
  TextView tv_house_rent_way_title_3;
  @BindView(2131694215)
  TextView tv_house_type;
  @BindView(2131689863)
  View v_divider;
  
  private void a(int paramInt1, int paramInt2)
  {
    a("rentWayOld", Integer.valueOf(paramInt1));
    a("roomTypeOld", Integer.valueOf(paramInt2));
  }
  
  private void d()
  {
    this.d = new c(this);
    this.a.register(this.d);
    this.e = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void e()
  {
    Object localObject;
    if ((!this.i) || (this.ll_house_rent_way_container.getVisibility() == 8) || (this.ll_house_type_container.getVisibility() == 8))
    {
      if ((this.f.getData().getRegionMsg() != null) && (c("regionName") == null))
      {
        a("regionName", this.f.getData().getRegionMsg().getText());
        a("regionCode", this.f.getData().getRegionMsg().getValue());
      }
      if ((this.f.getData().getHouseStreet() != null) && (c("houseStreet") == null)) {
        a("houseStreet", this.f.getData().getHouseStreet().getValue());
      }
      if ((this.f.getData().getBaiduLocation() != null) && (c("longitude") == null))
      {
        localObject = this.f.getData().getBaiduLocation().getValue().split(",");
        a("longitude", Double.valueOf(localObject[0]));
        a("latitude", Double.valueOf(localObject[1]));
      }
      if ((!m()) || (!n())) {
        break label320;
      }
      this.ll_house_rent_way_container.setVisibility(0);
      this.ll_house_type_container.setVisibility(0);
      this.i = true;
      if (this.f.getData() != null) {
        this.l = this.f.getData().getHallContent();
      }
    }
    for (;;)
    {
      this.k.clear();
      localObject = this.f.getData().getHouseType().getList().iterator();
      while (((Iterator)localObject).hasNext())
      {
        LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX localListBeanX = (LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX)((Iterator)localObject).next();
        this.k.add(localListBeanX.getText());
      }
      label320:
      this.ll_house_rent_way_container.setVisibility(8);
      this.ll_house_type_container.setVisibility(8);
    }
    this.j = new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(this.b, "", new a.b()
    {
      public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
      {
        LandlordReleaseOnceStepOneFragment.this.tv_house_type.setText((CharSequence)paramAnonymousHashMap.get(Integer.valueOf(0)));
        Iterator localIterator = LandlordReleaseOnceStepOneFragment.a(LandlordReleaseOnceStepOneFragment.this).getData().getHouseType().getList().iterator();
        while (localIterator.hasNext())
        {
          LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX localListBeanX = (LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX)localIterator.next();
          if (localListBeanX.getText().equals(paramAnonymousHashMap.get(Integer.valueOf(0))))
          {
            LandlordReleaseOnceStepOneFragment.a(LandlordReleaseOnceStepOneFragment.this, "houseType", Integer.valueOf(localListBeanX.getValue()));
            LandlordReleaseOnceStepOneFragment.b(LandlordReleaseOnceStepOneFragment.this);
          }
        }
        LandlordReleaseOnceStepOneFragment.b(LandlordReleaseOnceStepOneFragment.this, "hasEdited", Integer.valueOf(1));
      }
    }, new List[] { this.k });
    o();
  }
  
  private boolean m()
  {
    int n = 2130839065;
    if ((this.f.getData().getHouseRentWay() == null) || (this.f.getData().getHouseRentWay().getList() == null) || (this.f.getData().getHouseRentWay().getList().size() < 2)) {
      return false;
    }
    Object localObject = (LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)this.f.getData().getHouseRentWay().getList().get(0);
    LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean localListBean = (LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)this.f.getData().getHouseRentWay().getList().get(1);
    this.tv_house_rent_way_title_1.setText(((LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)localObject).getText());
    this.tv_house_rent_way_content_1.setText(((LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)localObject).getExplain());
    this.tv_house_rent_way_title_2.setText(localListBean.getText());
    this.tv_house_rent_way_content_2.setText(localListBean.getExplain());
    int m;
    if (((LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)localObject).isIsSelect())
    {
      setRentWay(((LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)localObject).getValue());
      a(0);
      a(((LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)localObject).getValue(), 0);
      this.g = true;
      ImageView localImageView = this.iv_house_rent_way_1;
      if (!((LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)localObject).isIsSelect()) {
        break label397;
      }
      m = 2130839065;
      label205:
      localImageView.setImageResource(m);
      localObject = this.iv_house_rent_way_2;
      if (!localListBean.isIsSelect()) {
        break label404;
      }
      m = 2130839065;
      label228:
      ((ImageView)localObject).setImageResource(m);
      if (this.f.getData().getHouseRentWay().getList().size() <= 2) {
        break label418;
      }
      this.ll_house_rent_way_title_3.setVisibility(0);
      localListBean = (LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)this.f.getData().getHouseRentWay().getList().get(2);
      this.tv_house_rent_way_title_3.setText(localListBean.getText());
      this.tv_house_rent_way_content_3.setText(localListBean.getExplain());
      if (localListBean.isIsSelect())
      {
        setRentWay(1);
        a(1);
        a(1, 1);
        this.g = true;
      }
      localObject = this.iv_house_rent_way_3;
      if (!localListBean.isIsSelect()) {
        break label411;
      }
      m = n;
      label352:
      ((ImageView)localObject).setImageResource(m);
    }
    for (;;)
    {
      return true;
      if (!localListBean.isIsSelect()) {
        break;
      }
      setRentWay(localListBean.getValue());
      a(0);
      a(localListBean.getValue(), 0);
      this.g = true;
      break;
      label397:
      m = 2130839067;
      break label205;
      label404:
      m = 2130839067;
      break label228;
      label411:
      m = 2130839067;
      break label352;
      label418:
      this.ll_house_rent_way_title_3.setVisibility(8);
    }
  }
  
  private boolean n()
  {
    if ((this.f.getData().getHouseType() == null) || (this.f.getData().getHouseType().getList() == null)) {
      return false;
    }
    Iterator localIterator = this.f.getData().getHouseType().getList().iterator();
    while (localIterator.hasNext())
    {
      LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX localListBeanX = (LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX)localIterator.next();
      if (localListBeanX.isIsSelect())
      {
        this.tv_house_type.setText(localListBeanX.getText());
        a("houseType", Integer.valueOf(localListBeanX.getValue()));
      }
    }
    return true;
  }
  
  public static LandlordReleaseOnceStepOneFragment newInstance()
  {
    Bundle localBundle = new Bundle();
    LandlordReleaseOnceStepOneFragment localLandlordReleaseOnceStepOneFragment = new LandlordReleaseOnceStepOneFragment();
    localLandlordReleaseOnceStepOneFragment.setArguments(localBundle);
    return localLandlordReleaseOnceStepOneFragment;
  }
  
  private void o()
  {
    if ((c("houseType") != null) && (this.g))
    {
      this.btn_next.setBackgroundResource(2130839597);
      return;
    }
    this.btn_next.setBackgroundResource(2130837946);
  }
  
  private int p()
  {
    Object localObject = c("roomTypeOld");
    if (localObject == null) {}
    while (!ad.isNumber("" + localObject)) {
      return -1;
    }
    return Integer.valueOf("" + localObject).intValue();
  }
  
  private void q()
  {
    if (((i() == 1) && (i() != p())) || ((p() == 1) && (p() != i())))
    {
      Intent localIntent = new Intent(getString(2131296570));
      LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(localIntent);
    }
  }
  
  @OnClick({2131691560, 2131690078, 2131694624, 2131694627, 2131694631, 2131694286})
  public void OnClick(View paramView)
  {
    if (paramView != null) {
      switch (paramView.getId())
      {
      }
    }
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
            } while ((this.f == null) || (this.f.getData() == null) || (this.f.getData().getHouseRentWay() == null) || (!this.f.getData().getHouseRentWay().isIsEdit()));
            this.iv_house_rent_way_2.setImageResource(2130839067);
            this.iv_house_rent_way_3.setImageResource(2130839067);
            this.iv_house_rent_way_1.setImageResource(2130839065);
            setRentWay(((LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)this.f.getData().getHouseRentWay().getList().get(0)).getValue());
            a(0);
            this.g = true;
            o();
            a("hasEdited", Integer.valueOf(1));
            return;
          } while ((this.f == null) || (this.f.getData() == null) || (this.f.getData().getHouseRentWay() == null) || (!this.f.getData().getHouseRentWay().isIsEdit()));
          this.iv_house_rent_way_1.setImageResource(2130839067);
          this.iv_house_rent_way_3.setImageResource(2130839067);
          this.iv_house_rent_way_2.setImageResource(2130839065);
          setRentWay(((LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)this.f.getData().getHouseRentWay().getList().get(1)).getValue());
          a(0);
          this.g = true;
          o();
          a("hasEdited", Integer.valueOf(1));
          return;
        } while ((this.f == null) || (this.f.getData() == null) || (this.f.getData().getHouseRentWay() == null) || (!this.f.getData().getHouseRentWay().isIsEdit()));
        this.iv_house_rent_way_1.setImageResource(2130839067);
        this.iv_house_rent_way_2.setImageResource(2130839067);
        this.iv_house_rent_way_3.setImageResource(2130839065);
        setRentWay(1);
        a(1);
        this.g = true;
        this.h = true;
        o();
        a("hasEdited", Integer.valueOf(1));
        return;
      } while (this.j == null);
      this.j.show();
      return;
      if ((c("hasEdited") != null) && (ApplicationEx.c.isLoginState()))
      {
        d.newBuilder(this.b).setOnConfirmClickListener(new d.b()
        {
          public void onLeftClick(View paramAnonymousView) {}
          
          public void onRightClick(View paramAnonymousView)
          {
            LandlordReleaseOnceStepOneFragment.c(LandlordReleaseOnceStepOneFragment.this);
          }
        }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
        return;
      }
      g();
      return;
    } while ((!this.g) || (c("houseType") == null));
    if (this.h)
    {
      d.newBuilder(this.b).setTitle("提示").setContent(this.l).setButtonText("取消", "同意").setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          LandlordReleaseOnceStepOneFragment.d(LandlordReleaseOnceStepOneFragment.this);
          LandlordReleaseOnceStepOneFragment.e(LandlordReleaseOnceStepOneFragment.this);
        }
      }).show();
      return;
    }
    setRoomFid(null);
    q();
    f();
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int m = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (m)
      {
      }
      break;
    }
    do
    {
      return;
      if (!parama.equals("get_house_type_location")) {
        break;
      }
      m = 0;
      break;
      if (!parama.equals("get_house_type_location_error")) {
        break;
      }
      m = 1;
      break;
      this.f = this.d.getLandlordReleaseTypeLocationInfo();
    } while ((this.f == null) || (this.f.getData() == null));
    a("netData", this.f);
    e();
    return;
    this.ll_house_rent_way_container.setVisibility(8);
    this.ll_house_type_container.setVisibility(8);
  }
  
  protected View c()
  {
    this.b = getActivity();
    View localView = LayoutInflater.from(this.b).inflate(2130903950, null, false);
    this.c = ButterKnife.bind(this, localView);
    this.osv_content.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LandlordReleaseOnceStepOneFragment.this.v_divider.setAlpha(f);
      }
    });
    return localView;
  }
  
  public boolean onBackPressed()
  {
    if (c("hasEdited") != null)
    {
      d.newBuilder(this.b).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          LandlordReleaseOnceStepOneFragment.f(LandlordReleaseOnceStepOneFragment.this);
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return false;
    }
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    d();
    return c();
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.c.unbind();
    }
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.d);
    super.onDestroyView();
  }
  
  public void onFragmentSwitch(boolean paramBoolean)
  {
    super.onFragmentSwitch(paramBoolean);
    if ((paramBoolean) && (this.f == null))
    {
      this.f = ((LandlordReleaseTypeLocationInfo)c("netData"));
      if ((this.f != null) && (this.f.getData() != null)) {
        e();
      }
    }
    else
    {
      return;
    }
    this.e.getReleaseTypeLocationInfo(this, getActivity(), k(), i(), j(), h());
  }
  
  public void onLoginBack(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.f == null))
    {
      this.f = ((LandlordReleaseTypeLocationInfo)c("netData"));
      if ((this.f != null) && (this.f.getData() != null)) {
        e();
      }
    }
    else
    {
      return;
    }
    this.e.getReleaseTypeLocationInfo(this, getActivity(), k(), i(), j(), h());
  }
  
  public void onStart()
  {
    super.onStart();
    this.ruatv_tip.setCode("TIP_HOW_CHOOSE_RENT_WAY");
    if ((c("netData") == null) || (!(c("netData") instanceof LandlordReleaseTypeLocationInfo)))
    {
      this.e.getReleaseTypeLocationInfo(this, getActivity(), k(), i(), j(), h());
      return;
    }
    this.f = ((LandlordReleaseTypeLocationInfo)c("netData"));
    e();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseOnceStepOneFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */