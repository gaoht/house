package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapTouchListener;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxFragment;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseSaveTypeLocationBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseSaveTypeLocationBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.BaiduLocationBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.CommunityNameBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseNumberBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseStreetBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo.DataBean.RegionMsgBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LLRManagerStepfirstFragment
  extends BaseFluxFragment
  implements OnGetGeoCoderResultListener, com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a
{
  ReleaseUsageAndTipsView b;
  @BindView(2131694286)
  View btn_house_type;
  @BindView(2131694632)
  View btn_select_city;
  CommonTitle c;
  @BindView(2131694635)
  View city_arrow;
  private String d;
  private String e;
  @BindView(2131694639)
  EditText et_community;
  @BindView(2131694641)
  EditText et_number;
  @BindView(2131694637)
  EditText et_street;
  private int f;
  private int g;
  private int h = -2;
  @BindView(2131694287)
  View house_type_arrow;
  private Unbinder i;
  private LandlordReleaseTypeLocationInfo j;
  private BaiduMap k;
  private GeoCoder l;
  @BindView(2131694282)
  LinearLayout ll_house_rent_way_container;
  @BindView(2131694285)
  LinearLayout ll_house_type_container;
  private Map<String, Boolean> m = new HashMap();
  @BindView(2131692902)
  MapView mv_map;
  private c n;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b o;
  @BindView(2131691365)
  ObservableScrollView osv_main;
  private Map<String, Object> p = new HashMap();
  @BindView(2131694634)
  TextView tv_city_content;
  @BindView(2131694284)
  TextView tv_house_rent_way_content_1;
  @BindView(2131694283)
  TextView tv_house_rent_way_title_1;
  @BindView(2131694215)
  TextView tv_house_type;
  
  private void e()
  {
    h();
    f();
    l();
  }
  
  private void f()
  {
    this.l = GeoCoder.newInstance();
    this.l.setOnGetGeoCodeResultListener(this);
    this.mv_map.getChildAt(0).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          LLRManagerStepfirstFragment.this.osv_main.requestDisallowInterceptTouchEvent(false);
          return false;
        }
        LLRManagerStepfirstFragment.this.osv_main.requestDisallowInterceptTouchEvent(true);
        return false;
      }
    });
    this.et_street.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if ((!paramAnonymousBoolean) && (LLRManagerStepfirstFragment.this.b("regionName") != null)) {}
        try
        {
          paramAnonymousView = LLRManagerStepfirstFragment.this.b("regionName").toString().split(",");
          if (paramAnonymousView.length > 0) {
            LLRManagerStepfirstFragment.a(LLRManagerStepfirstFragment.this).geocode(new GeoCodeOption().city(paramAnonymousView[(paramAnonymousView.length - 1)]).address(VdsAgent.trackEditTextSilent(LLRManagerStepfirstFragment.this.et_street) + ""));
          }
          return;
        }
        catch (Exception paramAnonymousView)
        {
          paramAnonymousView.printStackTrace();
        }
      }
    });
    this.osv_main.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LLRManagerStepfirstFragment.this.c.setBottomLineAlpha(f);
      }
    });
  }
  
  private void g()
  {
    this.et_community.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        LLRManagerStepfirstFragment.b(LLRManagerStepfirstFragment.this).put("community", Boolean.valueOf(true));
      }
    });
    this.et_number.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        LLRManagerStepfirstFragment.b(LLRManagerStepfirstFragment.this).put("number", Boolean.valueOf(true));
      }
    });
    this.et_street.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        LLRManagerStepfirstFragment.b(LLRManagerStepfirstFragment.this).put("street", Boolean.valueOf(true));
      }
    });
  }
  
  public static LLRManagerStepfirstFragment getInstance(Bundle paramBundle)
  {
    LLRManagerStepfirstFragment localLLRManagerStepfirstFragment = new LLRManagerStepfirstFragment();
    localLLRManagerStepfirstFragment.setArguments(paramBundle);
    return localLLRManagerStepfirstFragment;
  }
  
  private void h()
  {
    i();
    this.b = ((ReleaseUsageAndTipsView)getView().findViewById(2131689893));
    this.b.setCode("TIP_HOW_WRITE_RENT_WAY_LOCATION");
    if (1 == this.h)
    {
      this.house_type_arrow.setVisibility(8);
      this.city_arrow.setVisibility(8);
      this.c.showRightText(false, "");
    }
  }
  
  private void i()
  {
    this.c = ((CommonTitle)getView().findViewById(2131691272));
    this.c.setLeftButtonType(0);
    this.c.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LLRManagerStepfirstFragment.c(LLRManagerStepfirstFragment.this);
      }
    });
    this.c.showRightText(true, getString(2131297412));
    this.c.setBottomLineAlpha(0.0F);
    this.c.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (LLRManagerStepfirstFragment.this.b("houseType") == null)
        {
          af.showToast(LLRManagerStepfirstFragment.this.getActivity(), "请选择房源类型！");
          return;
        }
        if (LLRManagerStepfirstFragment.this.b("regionName") != null)
        {
          LLRManagerStepfirstFragment.d(LLRManagerStepfirstFragment.this);
          return;
        }
        af.showToast(LLRManagerStepfirstFragment.this.getActivity(), "请选择地区！");
      }
    });
  }
  
  private void j()
  {
    if (this.m.containsValue(Boolean.valueOf(true)))
    {
      d.newBuilder(getActivity()).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          LLRManagerStepfirstFragment.this.getActivity().finish();
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return;
    }
    getActivity().finish();
  }
  
  private void k()
  {
    this.n = new c(this);
    this.a.register(this.n);
    this.o = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void l()
  {
    this.o.getReleaseTypeLocationInfo(this, getActivity(), this.d, this.g, this.e, this.f);
  }
  
  private boolean m()
  {
    if ((this.j.getData().getHouseRentWay() == null) || (this.j.getData().getHouseRentWay().getList() == null) || (this.j.getData().getHouseRentWay().getList().size() == 0)) {
      return false;
    }
    Object localObject = (LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)this.j.getData().getHouseRentWay().getList().get(0);
    Iterator localIterator = this.j.getData().getHouseRentWay().getList().iterator();
    if (localIterator.hasNext())
    {
      LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean localListBean = (LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)localIterator.next();
      if (!localListBean.isIsSelect()) {
        break label165;
      }
      localObject = localListBean;
    }
    label165:
    for (;;)
    {
      break;
      this.tv_house_rent_way_title_1.setText(((LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)localObject).getText());
      this.tv_house_rent_way_content_1.setText(((LandlordReleaseTypeLocationInfo.DataBean.HouseRentWayBean.ListBean)localObject).getExplain());
      if (this.j.getData().getHouseRentWay().isIsEdit()) {}
      return true;
    }
  }
  
  private boolean n()
  {
    if ((this.j.getData().getHouseType() == null) || (this.j.getData().getHouseType().getList() == null)) {
      return false;
    }
    if (this.j.getData().getHouseType().isIsEdit()) {
      this.house_type_arrow.setVisibility(0);
    }
    for (;;)
    {
      Iterator localIterator = this.j.getData().getHouseType().getList().iterator();
      while (localIterator.hasNext())
      {
        LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX localListBeanX = (LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX)localIterator.next();
        if (localListBeanX.isIsSelect())
        {
          this.tv_house_type.setText(localListBeanX.getText());
          a("houseType", Integer.valueOf(localListBeanX.getValue()));
        }
      }
      this.house_type_arrow.setVisibility(8);
    }
    return true;
  }
  
  private void o()
  {
    if (this.j.getData().getRegionMsg() != null)
    {
      a("regionName", this.j.getData().getRegionMsg().getText());
      a("regionCode", this.j.getData().getRegionMsg().getValue());
      this.tv_city_content.setText(this.j.getData().getRegionMsg().getText());
    }
    if (this.j.getData().getHouseStreet() != null)
    {
      a("houseStreet", this.j.getData().getHouseStreet().getValue());
      this.et_street.setText(this.j.getData().getHouseStreet().getValue());
      if (!this.j.getData().getHouseStreet().isIsEdit())
      {
        this.et_street.setFocusable(false);
        this.et_street.setClickable(false);
        this.et_street.setEnabled(false);
        this.et_street.setKeyListener(null);
      }
    }
    Object localObject;
    if (this.j.getData().getBaiduLocation() != null)
    {
      localObject = this.j.getData().getBaiduLocation().getValue().split(",");
      a("longitude", Double.valueOf(localObject[1]));
      a("latitude", Double.valueOf(localObject[0]));
      localObject = MapStatusUpdateFactory.newLatLngZoom(new LatLng(Double.valueOf(this.j.getData().getBaiduLocation().getValue().split(",")[1]).doubleValue(), Double.valueOf(this.j.getData().getBaiduLocation().getValue().split(",")[0]).doubleValue()), 13.0F);
      this.k.setOnMapTouchListener(new BaiduMap.OnMapTouchListener()
      {
        public void onTouch(MotionEvent paramAnonymousMotionEvent)
        {
          if (paramAnonymousMotionEvent.getAction() == 2) {
            LLRManagerStepfirstFragment.b(LLRManagerStepfirstFragment.this).put("map", Boolean.valueOf(true));
          }
        }
      });
      this.k.setMapStatus((MapStatusUpdate)localObject);
    }
    if ((m()) && (n()))
    {
      this.ll_house_rent_way_container.setVisibility(0);
      this.ll_house_type_container.setVisibility(0);
    }
    for (;;)
    {
      if (this.j.getData().getCommunityName() != null)
      {
        this.et_community.setText(this.j.getData().getCommunityName().getValue());
        if (!this.j.getData().getCommunityName().isIsEdit())
        {
          this.et_community.setFocusable(false);
          this.et_community.setClickable(false);
          this.et_community.setEnabled(false);
          this.et_community.setKeyListener(null);
        }
      }
      if (this.j.getData().getHouseNumber() != null)
      {
        this.et_number.setText(this.j.getData().getHouseNumber().getValue());
        if (!this.j.getData().getHouseNumber().isIsEdit())
        {
          this.et_number.setFocusable(false);
          this.et_number.setClickable(false);
          this.et_number.setEnabled(false);
          this.et_number.setKeyListener(null);
        }
      }
      if ((this.j.getData().getHouseType() == null) || (this.j.getData().getHouseType().getList() == null)) {
        break;
      }
      localObject = this.j.getData().getHouseType().getList().iterator();
      while (((Iterator)localObject).hasNext())
      {
        LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX localListBeanX = (LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX)((Iterator)localObject).next();
        if (localListBeanX.isIsSelect()) {
          a("houseType", Integer.valueOf(localListBeanX.getValue()));
        }
      }
      this.ll_house_rent_way_container.setVisibility(8);
      this.ll_house_type_container.setVisibility(8);
    }
  }
  
  private void p()
  {
    a("houseStreet", VdsAgent.trackEditTextSilent(this.et_street).toString());
    if ((d() != 1) && (c() != 0) && (c() != 1))
    {
      af.showToast(getActivity(), "请选择出租方式！");
      return;
    }
    if (b("houseType") == null)
    {
      af.showToast(getActivity(), "请选择房屋类型！");
      return;
    }
    if ((b("regionCode") == null) || (b("regionName") == null))
    {
      af.showToast(getActivity(), "请选择地区！");
      return;
    }
    if (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.et_street).toString()))
    {
      af.showToast(getActivity(), "请输入街道地址！");
      return;
    }
    this.o.saveReleaseTypeLocation(this, getActivity(), this.d, Integer.valueOf(c()), Integer.valueOf(d()), (Integer)b("houseType"), b("regionCode").toString(), b("regionName").toString(), b("houseStreet").toString(), VdsAgent.trackEditTextSilent(this.et_community).toString(), VdsAgent.trackEditTextSilent(this.et_number).toString(), Double.valueOf(this.k.getMapStatus().target.longitude), Double.valueOf(this.k.getMapStatus().target.latitude));
  }
  
  @OnClick({2131694286, 2131694632})
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
        return;
      } while (!this.j.getData().getHouseType().isIsEdit());
      paramView = new ArrayList();
      Iterator localIterator = this.j.getData().getHouseType().getList().iterator();
      while (localIterator.hasNext()) {
        paramView.add(((LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX)localIterator.next()).getText());
      }
      new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(getActivity(), "", new a.b()
      {
        public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
        {
          LLRManagerStepfirstFragment.this.tv_house_type.setText((CharSequence)paramAnonymousHashMap.get(Integer.valueOf(0)));
          Iterator localIterator = LLRManagerStepfirstFragment.e(LLRManagerStepfirstFragment.this).getData().getHouseType().getList().iterator();
          while (localIterator.hasNext())
          {
            LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX localListBeanX = (LandlordReleaseTypeLocationInfo.DataBean.HouseTypeBean.ListBeanX)localIterator.next();
            if (localListBeanX.getText().equals(paramAnonymousHashMap.get(Integer.valueOf(0))))
            {
              LLRManagerStepfirstFragment.this.a("houseType", Integer.valueOf(localListBeanX.getValue()));
              LLRManagerStepfirstFragment.b(LLRManagerStepfirstFragment.this).put("houseType", Boolean.valueOf(true));
            }
          }
        }
      }, new List[] { paramView }).show();
      return;
    } while (!this.j.getData().getRegionMsg().isIsEdit());
    startActivityForResult(new Intent(getActivity(), LandlordReleaseSelectCityActivity.class), 257);
  }
  
  protected void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i1 = -1;
    switch (parama.hashCode())
    {
    }
    for (;;)
    {
      switch (i1)
      {
      default: 
        return;
        if (parama.equals("get_house_type_location"))
        {
          i1 = 0;
          continue;
          if (parama.equals("get_house_type_location_error"))
          {
            i1 = 1;
            continue;
            if (parama.equals("save_house_type_location"))
            {
              i1 = 2;
              continue;
              if (parama.equals("save_house_type_location_error")) {
                i1 = 3;
              }
            }
          }
        }
        break;
      }
    }
    this.j = this.n.getLandlordReleaseTypeLocationInfo();
    if ((this.j != null) && (this.j.getData() != null))
    {
      a("netData", this.j);
      o();
      g();
      return;
    }
    if (this.j == null) {}
    for (parama = "";; parama = this.j.getMessage())
    {
      ad.shouErrorMessage(parama);
      return;
    }
    this.ll_house_rent_way_container.setVisibility(8);
    this.ll_house_type_container.setVisibility(8);
    return;
    parama = this.n.getLandlordReleaseSaveTypeLocationBean();
    if ((parama.checkSuccess(getActivity())) && (parama.getData() != null) && (!TextUtils.isEmpty(parama.getData().getHouseBaseFid())))
    {
      af.showToast(getActivity(), "保存成功");
      getActivity().finish();
      return;
    }
    if (parama == null) {}
    for (parama = "";; parama = parama.getMessage())
    {
      ad.shouErrorMessage(parama);
      return;
    }
    af.showToast(getActivity(), this.n.getHouseSaveErrorMsg());
  }
  
  protected void a(String paramString, Object paramObject)
  {
    this.p.put(paramString, paramObject);
  }
  
  protected Object b(String paramString)
  {
    return this.p.get(paramString);
  }
  
  protected void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  protected int c()
  {
    return this.f;
  }
  
  protected int d()
  {
    return this.g;
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
    if (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.et_street).toString()))
    {
      paramIntent = ((String)localObject).split(",");
      if (paramIntent.length > 0) {
        this.l.geocode(new GeoCodeOption().city(paramIntent[(paramIntent.length - 1)]).address(VdsAgent.trackEditTextSilent(this.et_street).toString()));
      }
    }
    this.m.put("city", Boolean.valueOf(true));
  }
  
  public boolean onBackPressed()
  {
    j();
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    k();
    paramLayoutInflater = paramLayoutInflater.inflate(2130903958, null);
    this.i = ButterKnife.bind(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.i != null)
    {
      this.i.unbind();
      this.i = null;
    }
    if (this.l != null) {
      this.l.destroy();
    }
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.n);
    if (this.i != null)
    {
      this.i.unbind();
      this.i = null;
    }
    super.onDestroyView();
    if (this.mv_map != null) {
      this.mv_map.onDestroy();
    }
  }
  
  public void onGetGeoCodeResult(GeoCodeResult paramGeoCodeResult)
  {
    if (paramGeoCodeResult.getLocation() != null)
    {
      paramGeoCodeResult = MapStatusUpdateFactory.newLatLngZoom(paramGeoCodeResult.getLocation(), 13.0F);
      this.k.setMapStatus(paramGeoCodeResult);
    }
    do
    {
      do
      {
        return;
      } while ((paramGeoCodeResult.getAddress() == null) || (b("regionName") == null));
      paramGeoCodeResult = b("regionName").toString().split(",");
    } while (paramGeoCodeResult.length <= 0);
    this.l.geocode(new GeoCodeOption().city(paramGeoCodeResult[(paramGeoCodeResult.length - 1)]));
  }
  
  public void onGetReverseGeoCodeResult(ReverseGeoCodeResult paramReverseGeoCodeResult) {}
  
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
  
  public void onStart()
  {
    super.onStart();
    this.k = this.mv_map.getMap();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    e();
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
    if (paramBundle != null)
    {
      this.d = paramBundle.getString("houseBaseFid");
      this.e = paramBundle.getString("roomFid");
      this.f = paramBundle.getInt("rentWay");
      this.g = paramBundle.getInt("roomType");
      this.h = paramBundle.getInt("status");
      a(this.f);
      b(this.g);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LLRManagerStepfirstFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */