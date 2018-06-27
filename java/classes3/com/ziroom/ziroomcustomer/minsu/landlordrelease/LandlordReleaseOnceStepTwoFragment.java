package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiAddrInfo;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.BaseLandlordReleaseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseSaveTypeLocationBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseSaveTypeLocationBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.BaiduLocationBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.CommunityNameBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseNumberBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseStreetBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.RegionMsgBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.Iterator;
import java.util.List;

public class LandlordReleaseOnceStepTwoFragment
  extends BaseLandlordReleaseFragment
  implements OnGetPoiSearchResultListener, com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a
{
  private Context b;
  @BindView(2131690078)
  View btn_back;
  @BindView(2131691560)
  View btn_next;
  @BindView(2131694632)
  View btn_select_city;
  private Unbinder c;
  private c d;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b e;
  @BindView(2131694639)
  EditText et_community;
  @BindView(2131694641)
  EditText et_number;
  @BindView(2131694637)
  EditText et_street;
  private LandlordReleaseTypeLocationInfo f;
  private BaiduMap g;
  private PoiSearch h;
  private boolean i = false;
  @BindView(2131692902)
  MapView mv_map;
  @BindView(2131691365)
  ObservableScrollView osv_main;
  @BindView(2131689893)
  ReleaseUsageAndTipsView ruatv_tip;
  @BindView(2131694634)
  TextView tv_city_content;
  @BindView(2131689863)
  View v_divider;
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString1)) {
        break label31;
      }
      if (!paramString1.equals(paramString2)) {
        break label39;
      }
    }
    label31:
    while (paramString2.equals(paramString1)) {
      return true;
    }
    label39:
    return false;
  }
  
  private void d()
  {
    this.d = new c(this);
    this.a.register(this.d);
    this.e = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void e()
  {
    this.h = PoiSearch.newInstance();
    this.h.setOnGetPoiSearchResultListener(this);
    this.mv_map.getChildAt(0).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 1) {
          LandlordReleaseOnceStepTwoFragment.this.osv_main.requestDisallowInterceptTouchEvent(false);
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent.getAction() == 0) {
            LandlordReleaseOnceStepTwoFragment.a(LandlordReleaseOnceStepTwoFragment.this, "hasEdited", Integer.valueOf(1));
          }
          return false;
          LandlordReleaseOnceStepTwoFragment.this.osv_main.requestDisallowInterceptTouchEvent(true);
        }
      }
    });
    this.osv_main.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LandlordReleaseOnceStepTwoFragment.this.v_divider.setAlpha(f);
      }
    });
    this.et_community.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.et_number.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.et_street.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        LandlordReleaseOnceStepTwoFragment.a(LandlordReleaseOnceStepTwoFragment.this);
      }
    });
    this.et_street.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          LandlordReleaseOnceStepTwoFragment.b(LandlordReleaseOnceStepTwoFragment.this);
        }
      }
    });
    this.et_community.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          LandlordReleaseOnceStepTwoFragment.b(LandlordReleaseOnceStepTwoFragment.this);
        }
      }
    });
  }
  
  private void m()
  {
    if (!this.i)
    {
      if (this.f.getData().getRegionMsg() != null)
      {
        a("regionName", this.f.getData().getRegionMsg().getText());
        a("regionCode", this.f.getData().getRegionMsg().getValue());
        this.tv_city_content.setText(this.f.getData().getRegionMsg().getText().replace(',', ' '));
      }
      if (this.f.getData().getHouseStreet() != null)
      {
        a("houseStreet", this.f.getData().getHouseStreet().getValue());
        this.et_street.setText(this.f.getData().getHouseStreet().getValue());
      }
      Object localObject;
      if (this.f.getData().getBaiduLocation() != null)
      {
        localObject = this.f.getData().getBaiduLocation().getValue().split(",");
        a("longitude", Double.valueOf(localObject[0]));
        a("latitude", Double.valueOf(localObject[1]));
        localObject = MapStatusUpdateFactory.newLatLngZoom(new LatLng(Double.valueOf(this.f.getData().getBaiduLocation().getValue().split(",")[1]).doubleValue(), Double.valueOf(this.f.getData().getBaiduLocation().getValue().split(",")[0]).doubleValue()), 15.0F);
        this.g.setMapStatus((MapStatusUpdate)localObject);
      }
      if (this.f.getData().getCommunityName() != null) {
        this.et_community.setText(this.f.getData().getCommunityName().getValue());
      }
      if (this.f.getData().getHouseNumber() != null) {
        this.et_number.setText(this.f.getData().getHouseNumber().getValue());
      }
      if ((this.f.getData().getHouseType() != null) && (this.f.getData().getHouseType().getList() != null))
      {
        localObject = this.f.getData().getHouseType().getList().iterator();
        while (((Iterator)localObject).hasNext())
        {
          LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX localListBeanX = (LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX)((Iterator)localObject).next();
          if (localListBeanX.isIsSelect()) {
            a("houseType", Integer.valueOf(localListBeanX.getValue()));
          }
        }
      }
      n();
      this.i = true;
    }
  }
  
  private void n()
  {
    if ((c("houseType") != null) && (c("regionCode") != null) && (c("regionName") != null) && (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.et_street).toString())))
    {
      this.btn_next.setBackgroundResource(2130839597);
      return;
    }
    this.btn_next.setBackgroundResource(2130837946);
  }
  
  public static LandlordReleaseOnceStepTwoFragment newInstance()
  {
    Bundle localBundle = new Bundle();
    LandlordReleaseOnceStepTwoFragment localLandlordReleaseOnceStepTwoFragment = new LandlordReleaseOnceStepTwoFragment();
    localLandlordReleaseOnceStepTwoFragment.setArguments(localBundle);
    return localLandlordReleaseOnceStepTwoFragment;
  }
  
  private void o()
  {
    String[] arrayOfString;
    String str2;
    String str1;
    if (c("regionName") != null)
    {
      arrayOfString = c("regionName").toString().split(",");
      if (arrayOfString.length > 0)
      {
        str2 = arrayOfString[(arrayOfString.length - 1)];
        str1 = "";
        if (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.et_street).toString())) {
          break label118;
        }
        str1 = VdsAgent.trackEditTextSilent(this.et_street).toString() + VdsAgent.trackEditTextSilent(this.et_community).toString();
      }
    }
    for (;;)
    {
      this.h.searchInCity(new PoiCitySearchOption().city(str2).keyword(str1));
      return;
      label118:
      if (arrayOfString.length > 1) {
        if (arrayOfString.length == 2)
        {
          str2 = arrayOfString[(arrayOfString.length - 1)];
          str1 = arrayOfString[(arrayOfString.length - 1)];
        }
        else
        {
          str2 = arrayOfString[(arrayOfString.length - 2)];
          str1 = arrayOfString[(arrayOfString.length - 1)];
        }
      }
    }
  }
  
  @OnClick({2131690078, 2131691560, 2131694632})
  public void OnClick(View paramView)
  {
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
    case 2131690078: 
    case 2131691560: 
      label138:
      do
      {
        do
        {
          return;
          if ((this.f != null) && (this.f.getData() != null) && (this.f != null) && (this.f.getData() != null))
          {
            if ((this.f.getData().getHouseNumber() == null) || (a(VdsAgent.trackEditTextSilent(this.et_number).toString(), this.f.getData().getHouseNumber().getValue()))) {
              break label138;
            }
            a("hasEdited", Integer.valueOf(1));
          }
          for (;;)
          {
            g();
            return;
            if ((this.f.getData().getCommunityName() != null) && (!a(VdsAgent.trackEditTextSilent(this.et_community).toString(), this.f.getData().getCommunityName().getValue()))) {
              a("hasEdited", Integer.valueOf(1));
            } else if ((this.f.getData().getHouseStreet() != null) && (!a(VdsAgent.trackEditTextSilent(this.et_street).toString(), this.f.getData().getHouseStreet().getValue()))) {
              a("hasEdited", Integer.valueOf(1));
            }
          }
        } while (!l());
        a("houseStreet", VdsAgent.trackEditTextSilent(this.et_street).toString());
      } while (((h() != 0) && (h() != 1)) || (c("houseType") == null) || (c("regionCode") == null) || (c("regionName") == null) || (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.et_street).toString())));
      d.newBuilder(this.b).setButtonText("取消", "确定").setTitle("请确认房源位置").setContent("您填写的位置信息为：" + c("regionName").toString().replace(",", "") + VdsAgent.trackEditTextSilent(this.et_street).toString() + VdsAgent.trackEditTextSilent(this.et_community).toString() + VdsAgent.trackEditTextSilent(this.et_number).toString() + "。发布后不可修改，请确认是否继续？").setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          LandlordReleaseOnceStepTwoFragment.g(LandlordReleaseOnceStepTwoFragment.this).saveReleaseTypeLocation(LandlordReleaseOnceStepTwoFragment.this, LandlordReleaseOnceStepTwoFragment.this.getActivity(), LandlordReleaseOnceStepTwoFragment.c(LandlordReleaseOnceStepTwoFragment.this), Integer.valueOf(LandlordReleaseOnceStepTwoFragment.d(LandlordReleaseOnceStepTwoFragment.this)), Integer.valueOf(LandlordReleaseOnceStepTwoFragment.e(LandlordReleaseOnceStepTwoFragment.this)), (Integer)LandlordReleaseOnceStepTwoFragment.a(LandlordReleaseOnceStepTwoFragment.this, "houseType"), LandlordReleaseOnceStepTwoFragment.b(LandlordReleaseOnceStepTwoFragment.this, "regionCode").toString(), LandlordReleaseOnceStepTwoFragment.c(LandlordReleaseOnceStepTwoFragment.this, "regionName").toString(), LandlordReleaseOnceStepTwoFragment.d(LandlordReleaseOnceStepTwoFragment.this, "houseStreet").toString(), VdsAgent.trackEditTextSilent(LandlordReleaseOnceStepTwoFragment.this.et_community).toString(), VdsAgent.trackEditTextSilent(LandlordReleaseOnceStepTwoFragment.this.et_number).toString(), Double.valueOf(LandlordReleaseOnceStepTwoFragment.f(LandlordReleaseOnceStepTwoFragment.this).getMapStatus().target.longitude), Double.valueOf(LandlordReleaseOnceStepTwoFragment.f(LandlordReleaseOnceStepTwoFragment.this).getMapStatus().target.latitude));
        }
      }).show();
      return;
    }
    startActivityForResult(new Intent(this.b, LandlordReleaseSelectCityActivity.class), 257);
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int j = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (j)
      {
      }
      break;
    }
    do
    {
      do
      {
        return;
        if (!parama.equals("save_house_type_location")) {
          break;
        }
        j = 0;
        break;
        if (!parama.equals("save_house_type_location_error")) {
          break;
        }
        j = 1;
        break;
        if (!parama.equals("get_house_type_location")) {
          break;
        }
        j = 2;
        break;
        if (!parama.equals("get_house_type_location_error")) {
          break;
        }
        j = 3;
        break;
        parama = this.d.getLandlordReleaseSaveTypeLocationBean();
      } while (parama == null);
      if ((parama.getData() != null) && (!TextUtils.isEmpty(parama.getData().getHouseBaseFid())))
      {
        this.mv_map.setVisibility(4);
        b(parama.getData().getHouseBaseFid());
        setRentWay(parama.getData().getRentWay());
        f();
        return;
      }
      af.showToast(this.b, parama.getMessage());
      return;
      af.showToast(this.b, this.d.getHouseSaveErrorMsg());
      return;
      this.f = this.d.getLandlordReleaseTypeLocationInfo();
    } while ((this.f == null) || (this.f.getData() == null));
    a("netData", this.f);
    m();
  }
  
  protected View c()
  {
    this.b = getActivity();
    View localView = LayoutInflater.from(this.b).inflate(2130903951, null, false);
    this.c = ButterKnife.bind(this, localView);
    e();
    return localView;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (-1 != paramInt2);
    Object localObject = paramIntent.getExtras();
    paramIntent = ((Bundle)localObject).getString("cityCode");
    localObject = ((Bundle)localObject).getString("address");
    this.tv_city_content.setText((CharSequence)localObject);
    localObject = ((String)localObject).replace(' ', ',');
    a("regionCode", paramIntent);
    a("regionName", localObject);
    o();
    n();
    a("hasEdited", Integer.valueOf(1));
  }
  
  public boolean onBackPressed()
  {
    if ((this.f != null) && (this.f.getData() != null))
    {
      if ((this.f.getData().getHouseNumber() == null) || (a(VdsAgent.trackEditTextSilent(this.et_number).toString(), this.f.getData().getHouseNumber().getValue()))) {
        break label73;
      }
      a("hasEdited", Integer.valueOf(1));
    }
    label73:
    do
    {
      return true;
      if ((this.f.getData().getCommunityName() != null) && (!a(VdsAgent.trackEditTextSilent(this.et_community).toString(), this.f.getData().getCommunityName().getValue())))
      {
        a("hasEdited", Integer.valueOf(1));
        return true;
      }
    } while ((this.f.getData().getHouseStreet() == null) || (a(VdsAgent.trackEditTextSilent(this.et_street).toString(), this.f.getData().getHouseStreet().getValue())));
    a("hasEdited", Integer.valueOf(1));
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
    if (this.mv_map != null) {
      this.mv_map.onDestroy();
    }
  }
  
  public void onFragmentSwitch(boolean paramBoolean)
  {
    super.onFragmentSwitch(paramBoolean);
    if ((paramBoolean) && (this.f == null))
    {
      this.f = ((LandlordReleaseTypeLocationInfo)c("netData"));
      if (this.f == null) {
        this.e.getReleaseTypeLocationInfo(this, getActivity(), k(), i(), j(), h());
      }
    }
    else
    {
      return;
    }
    m();
  }
  
  public void onGetPoiDetailResult(PoiDetailResult paramPoiDetailResult) {}
  
  public void onGetPoiIndoorResult(PoiIndoorResult paramPoiIndoorResult) {}
  
  public void onGetPoiResult(PoiResult paramPoiResult)
  {
    List localList2 = paramPoiResult.getAllAddr();
    List localList1 = paramPoiResult.getSuggestCityList();
    paramPoiResult = paramPoiResult.getAllPoi();
    Object localObject = null;
    if ((paramPoiResult != null) && (paramPoiResult.size() > 0)) {
      paramPoiResult = MapStatusUpdateFactory.newLatLngZoom(((PoiInfo)paramPoiResult.get(0)).location, 15.0F);
    }
    for (;;)
    {
      if ((this.g != null) && (paramPoiResult != null)) {
        this.g.setMapStatus(paramPoiResult);
      }
      return;
      if ((localList2 != null) && (localList2.size() > 0))
      {
        paramPoiResult = MapStatusUpdateFactory.newLatLngZoom(((PoiAddrInfo)localList2.get(0)).location, 15.0F);
      }
      else
      {
        paramPoiResult = (PoiResult)localObject;
        if (localList1 != null)
        {
          paramPoiResult = (PoiResult)localObject;
          if (localList1.size() > 0) {
            paramPoiResult = (PoiResult)localObject;
          }
        }
      }
    }
  }
  
  public void onLoginBack(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.f == null))
    {
      this.f = ((LandlordReleaseTypeLocationInfo)c("netData"));
      if (this.f == null) {
        this.e.getReleaseTypeLocationInfo(this, getActivity(), k(), i(), j(), h());
      }
    }
    else
    {
      return;
    }
    m();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mv_map != null) {
      this.mv_map.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mv_map != null)
    {
      this.mv_map.onResume();
      this.mv_map.setVisibility(0);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.ruatv_tip.setCode("TIP_HOW_WRITE_LOCATION");
    this.g = this.mv_map.getMap();
    if ((c("netData") == null) || (!(c("netData") instanceof LandlordReleaseTypeLocationInfo)))
    {
      this.e.getReleaseTypeLocationInfo(this, getActivity(), k(), i(), j(), h());
      return;
    }
    this.f = ((LandlordReleaseTypeLocationInfo)c("netData"));
    m();
  }
  
  public void onVisibilityChangedToUser(boolean paramBoolean)
  {
    super.onVisibilityChangedToUser(paramBoolean);
    if (paramBoolean) {
      n();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseOnceStepTwoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */