package com.ziroom.ziroomcustomer.minsu.mapsojourn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.model.LatLng;
import com.freelxl.baselibrary.d.f.d;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityItemBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.LocRepeatVo;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.bean.MapSearchHouseBusinessCircleBean;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.bean.MapSearchHouseBusinessCircleBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.bean.MapSearchHouseDistrictBean;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.bean.MapSearchHouseDistrictBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.bean.ZryMapItembean;
import com.ziroom.ziroomcustomer.minsu.searchlist.b.a.c;
import com.ziroom.ziroomcustomer.minsu.searchlist.b.c.b;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StationSearchListBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.m;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b
  implements a.a, com.ziroom.ziroomcustomer.minsu.searchlist.base.b<MinsuHouseBean.DataBean.ListBean>
{
  WeakReference<a.b> a;
  boolean b = false;
  private Map<String, MinsuHouseBean.DataBean.ListBean> c = new HashMap();
  private Map<String, ZryMapItembean> d = new HashMap();
  private Set<String> e = new HashSet();
  private List<MinsuHouseBean.DataBean.ListBean> f = new ArrayList(1);
  private List<StationSearchListBean.DataBean.ListBean> g = new ArrayList(1);
  private com.ziroom.ziroomcustomer.minsu.searchlist.b.a h;
  private com.ziroom.ziroomcustomer.minsu.searchlist.b.c i;
  private Calendar j = null;
  private Calendar k = null;
  private boolean l = false;
  private MinsuCityItemBean m;
  private LatLng n;
  
  public b(a.b paramb)
  {
    this.a = new WeakReference(paramb);
    paramb = getView();
    if (paramb != null) {
      paramb.setPresenter(this);
    }
  }
  
  private Calendar a(String paramString)
  {
    Calendar localCalendar = null;
    if (ae.isNull(paramString)) {
      return null;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      return localCalendar;
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localCalendar;
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = null;
    if (ae.isNull(paramString1))
    {
      paramString1 = null;
      this.j = paramString1;
      if (!ae.isNull(paramString2)) {
        break label127;
      }
    }
    label127:
    for (paramString1 = (String)localObject;; paramString1 = a(paramString2))
    {
      this.k = paramString1;
      if (this.j == null) {
        break label136;
      }
      this.j.getTime().getMonth();
      this.k.getTime().getMonth();
      paramString1 = m.getFormatDate(this.j.getTime(), "M/d");
      paramString2 = m.getFormatDate(this.k.getTime(), "M/d");
      getView().dateStartEnd(paramString1 + "-" + paramString2);
      return;
      paramString1 = a(paramString1);
      break;
    }
    label136:
    getView().dateStartEnd("");
  }
  
  private boolean a()
  {
    Object localObject = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getLocLat();
    Double localDouble = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getLocLon();
    if ((localObject != null) && (((Double)localObject).doubleValue() != 0.0D) && (localDouble != null) && (localDouble.doubleValue() != 0.0D))
    {
      localObject = new LatLng(((Double)localObject).doubleValue(), localDouble.doubleValue());
      getView().animateMapStatus((LatLng)localObject, 16.0F);
      return true;
    }
    return false;
  }
  
  private boolean b()
  {
    if ((this.m != null) && (this.m.latitude != null) && (this.m.longitude != null))
    {
      LatLng localLatLng = new LatLng(this.m.latitude.doubleValue(), this.m.longitude.doubleValue());
      getView().animateMapStatus(localLatLng, 13.5F);
      return true;
    }
    return false;
  }
  
  public void changeCity()
  {
    k.toMinsuCityListActivityForResult(((a.b)this.a.get()).getActivity());
  }
  
  public void changeCount()
  {
    k.toMinsuPersonActivityForResult(getView().getActivity(), com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getPersonCount(), "map");
  }
  
  public void changeDate()
  {
    k.toMinsuTimeSelectActivityForResult(getView().getActivity(), this.j, this.k, "map");
  }
  
  public void changeDistrict()
  {
    if (ae.isNull(com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getCityCode()))
    {
      k.toMinsuCityListActivityForResult(((a.b)this.a.get()).getActivity());
      return;
    }
    k.toLocationInfo(((a.b)this.a.get()).getActivity());
  }
  
  public void changeFilter()
  {
    getView().showFilterArea();
  }
  
  public void changeKeyword()
  {
    k.toMinsuHouseListSearch(getView().getActivity());
  }
  
  public void clearData()
  {
    if ((getView() != null) && (getView().isActive()))
    {
      getView().clearMap();
      getView().hideBottom();
    }
    this.c.clear();
    this.d.clear();
    this.e.clear();
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public void getBuildMapData()
  {
    getBuildMapData(true);
  }
  
  public void getBuildMapData(final boolean paramBoolean)
  {
    a.b localb = getView();
    if ((localb == null) || (!localb.isActive()) || (this.b)) {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.queryMinsu(getView().getActivity(), 1, "HOUSE_LEVEL_SEARCH", new t(getView().getActivity(), new d(MinsuHouseBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        if ((b.this.getView() != null) && (b.this.getView().isActive())) {
          b.this.getView().showMinsuBuildMapData(false, null, false);
        }
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseBean paramAnonymousMinsuHouseBean)
      {
        int i = 0;
        if ((b.this.getView() == null) || (!b.this.getView().isActive())) {}
        ArrayList localArrayList;
        do
        {
          return;
          localArrayList = new ArrayList();
        } while ((paramAnonymousMinsuHouseBean == null) || (paramAnonymousMinsuHouseBean.data == null));
        int j;
        Object localObject;
        if (paramAnonymousMinsuHouseBean.data.list != null)
        {
          j = paramAnonymousMinsuHouseBean.data.list.size();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < j)
          {
            localObject = (MinsuHouseBean.DataBean.ListBean)paramAnonymousMinsuHouseBean.data.list.get(paramAnonymousInt);
            localArrayList.add(((MinsuHouseBean.DataBean.ListBean)localObject).convertMapBean(paramBoolean));
            b.c(b.this).put(((MinsuHouseBean.DataBean.ListBean)localObject).fid + ((MinsuHouseBean.DataBean.ListBean)localObject).rentWay, localObject);
            paramAnonymousInt += 1;
          }
        }
        if (paramAnonymousMinsuHouseBean.data.ziruyiList != null)
        {
          j = paramAnonymousMinsuHouseBean.data.ziruyiList.size();
          paramAnonymousInt = i;
          while (paramAnonymousInt < j)
          {
            localObject = (ZryMapItembean)paramAnonymousMinsuHouseBean.data.ziruyiList.get(paramAnonymousInt);
            b.d(b.this).put(((ZryMapItembean)localObject).projectBid, localObject);
            localArrayList.add(((ZryMapItembean)localObject).convertZryMapBuildBean(paramBoolean));
            paramAnonymousInt += 1;
          }
        }
        b.this.getView().showMinsuBuildMapData(true, localArrayList, paramBoolean);
      }
    });
  }
  
  public void getBusinessCircleMapData()
  {
    a.b localb = getView();
    if ((localb == null) || (!localb.isActive()) || (this.b)) {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.mapSearchHouse(getView().getActivity(), new t(getView().getActivity(), new com.ziroom.ziroomcustomer.minsu.landlord.d.c(MapSearchHouseBusinessCircleBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MapSearchHouseBusinessCircleBean paramAnonymousMapSearchHouseBusinessCircleBean)
      {
        if ((b.this.getView() == null) || (!b.this.getView().isActive())) {}
        do
        {
          return;
          if ((paramAnonymousMapSearchHouseBusinessCircleBean != null) && (paramAnonymousMapSearchHouseBusinessCircleBean.getData() != null) && (paramAnonymousMapSearchHouseBusinessCircleBean.getData().getMapSearchHouseVoList() != null) && (paramAnonymousMapSearchHouseBusinessCircleBean.getData().getMapSearchHouseVoList().size() != 0))
          {
            b.this.getView().showBusinessCircleMapData(paramAnonymousMapSearchHouseBusinessCircleBean.getData().getMapSearchHouseVoList(), true);
            return;
          }
        } while ((paramAnonymousMapSearchHouseBusinessCircleBean != null) && (paramAnonymousMapSearchHouseBusinessCircleBean.getData() != null) && (paramAnonymousMapSearchHouseBusinessCircleBean.getData().getMapSearchHouseVoList() != null) && (paramAnonymousMapSearchHouseBusinessCircleBean.getData().getMapSearchHouseVoList().size() != 0));
        b.this.getBuildMapData(false);
      }
    });
  }
  
  public void getData()
  {
    a.b localb = getView();
    if ((localb != null) && (localb.isActive())) {}
    switch (Integer.valueOf(getView().getMapZoomType()).intValue())
    {
    default: 
      getDistrictMapData();
      return;
    case 2: 
      getDistrictMapData();
      return;
    case 3: 
      getBusinessCircleMapData();
      return;
    }
    getBuildMapData();
  }
  
  public void getDistrictMapData()
  {
    if (!this.l)
    {
      getDistrictMapData(true);
      this.l = true;
      return;
    }
    getDistrictMapData(true);
  }
  
  public void getDistrictMapData(boolean paramBoolean)
  {
    a.b localb = getView();
    if ((localb == null) || (!localb.isActive()) || (this.b)) {
      return;
    }
    if (paramBoolean) {
      this.b = true;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.mapSearchHouseCity(getView().getActivity(), paramBoolean, new t(getView().getActivity(), new com.ziroom.ziroomcustomer.minsu.landlord.d.c(MapSearchHouseDistrictBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.this.b = false;
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, MapSearchHouseDistrictBean paramAnonymousMapSearchHouseDistrictBean)
      {
        b.this.b = false;
        if ((b.this.getView() == null) || (!b.this.getView().isActive())) {}
        do
        {
          return;
          if ((paramAnonymousMapSearchHouseDistrictBean != null) && (paramAnonymousMapSearchHouseDistrictBean.getData() != null) && (paramAnonymousMapSearchHouseDistrictBean.getData().getMapSearchHouseVoList() != null) && (paramAnonymousMapSearchHouseDistrictBean.getData().getMapSearchHouseVoList().size() != 0))
          {
            b.this.getView().showDistrictMapData(paramAnonymousMapSearchHouseDistrictBean.getData().getMapSearchHouseVoList(), false);
            return;
          }
        } while ((paramAnonymousMapSearchHouseDistrictBean != null) && (paramAnonymousMapSearchHouseDistrictBean.getData() != null) && (paramAnonymousMapSearchHouseDistrictBean.getData().getMapSearchHouseVoList() != null) && (paramAnonymousMapSearchHouseDistrictBean.getData().getMapSearchHouseVoList().size() != 0));
        b.this.getBuildMapData(false);
      }
    });
  }
  
  public MinsuHouseBean.DataBean.ListBean getHouseDetail(String paramString)
  {
    return (MinsuHouseBean.DataBean.ListBean)this.c.get(paramString);
  }
  
  public a.b getView()
  {
    if (this.a != null) {
      return (a.b)this.a.get();
    }
    return null;
  }
  
  public void goBrowseRecently()
  {
    k.toMinsuHistory(getView().getActivity());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    boolean bool2 = true;
    Object localObject2 = getView();
    if ((localObject2 == null) || (!((a.b)localObject2).isActive())) {
      return;
    }
    boolean bool1;
    switch (paramInt1)
    {
    case 123: 
    default: 
    case 111: 
      for (;;)
      {
        paramIntent = getView();
        if (com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getMinsuConditionCount() <= 0) {
          break;
        }
        bool1 = bool2;
        paramIntent.showRedDot(bool1);
        return;
        if (paramInt2 == -1)
        {
          com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().clearMinsuLocationCondition();
          com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().clearMinsuSortCondition();
          com.ziroom.ziroomcustomer.minsu.b.c.a = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getCityCode();
          this.m = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getCityBean();
          getView().cityName();
          getView().location("");
          clearData();
          b();
        }
      }
    case 134: 
      label114:
      if (paramInt2 == -1)
      {
        getView().location(com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getLocationName());
        if ((com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getLocLat() == null) || (com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getLocLon() == null)) {
          break label759;
        }
      }
      break;
    }
    label533:
    label535:
    label606:
    label620:
    label721:
    label727:
    label732:
    label744:
    label752:
    label757:
    label759:
    for (paramIntent = new LatLng(com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getLocLat().doubleValue(), com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getLocLon().doubleValue());; paramIntent = null)
    {
      getView().updateClickBusinessCircleFlag(true, paramIntent, com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getLocationName());
      while (!a())
      {
        b();
        getData();
        break;
        if (paramInt2 == 11)
        {
          getView().location("");
          com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().clearMinsuLocationCondition();
        }
      }
      if (-1 != paramInt2) {
        break;
      }
      if ("keyWord".equals(paramIntent.getStringExtra("type")))
      {
        paramIntent = paramIntent.getStringExtra("key");
        com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setKeyword(paramIntent);
        getView().keyWord(paramIntent + "");
      }
      getData();
      break;
      if (paramInt2 != -1) {
        break;
      }
      localObject1 = paramIntent.getStringExtra("startDate");
      paramIntent = paramIntent.getStringExtra("endDate");
      com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setStartTime((String)localObject1);
      com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setEndTime(paramIntent);
      a((String)localObject1, paramIntent);
      getData();
      break;
      if (paramInt2 != -1) {
        break;
      }
      paramInt1 = paramIntent.getIntExtra("personNum", 0);
      localObject2 = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance();
      if (paramInt1 <= 0) {}
      for (paramIntent = (Intent)localObject1;; paramIntent = Integer.valueOf(paramInt1))
      {
        ((com.ziroom.ziroomcustomer.minsu.searchlist.base.c)localObject2).setPersonCount(paramIntent);
        getView().personCount(paramInt1);
        getData();
        break;
      }
      if (paramInt2 != 101) {
        break;
      }
      localObject2 = paramIntent.getStringExtra("fid");
      int i1 = paramIntent.getIntExtra("rentWay", -1);
      if (this.h.getData() == null)
      {
        paramInt2 = 0;
        paramInt1 = 0;
        if (paramInt1 >= paramInt2) {
          break label752;
        }
        localObject1 = (MinsuHouseBean.DataBean.ListBean)this.h.getData().get(paramInt1);
        if ((localObject1 == null) || (((MinsuHouseBean.DataBean.ListBean)localObject1).rentWay != i1) || (((MinsuHouseBean.DataBean.ListBean)localObject1).fid == null) || (!((MinsuHouseBean.DataBean.ListBean)localObject1).fid.equals(localObject2))) {
          break label732;
        }
        if (((MinsuHouseBean.DataBean.ListBean)localObject1).isCollect != 1) {
          break label721;
        }
        bool1 = true;
        if (!paramIntent.getBooleanExtra("isCollect", bool1)) {
          break label727;
        }
        paramInt2 = 1;
        ((MinsuHouseBean.DataBean.ListBean)localObject1).isCollect = paramInt2;
        paramIntent = (Intent)localObject1;
      }
      for (;;)
      {
        if ((paramInt1 == -1) || (paramIntent == null)) {
          break label757;
        }
        localObject1 = (LinearLayoutManager)getView().getBottomRv().getLayoutManager();
        paramInt1 = ((LinearLayoutManager)localObject1).findFirstVisibleItemPosition();
        paramInt2 = ((LinearLayoutManager)localObject1).findLastVisibleItemPosition();
        for (;;)
        {
          if (paramInt1 > paramInt2) {
            break label744;
          }
          if (paramIntent.equals((MinsuHouseBean.DataBean.ListBean)((LinearLayoutManager)localObject1).findViewByPosition(paramInt1).getTag(2131689523)))
          {
            this.h.notifyItemChanged(paramInt1);
            break;
            paramInt2 = this.h.getData().size();
            break label533;
            bool1 = false;
            break label606;
            paramInt2 = 0;
            break label620;
            paramInt1 += 1;
            break label535;
          }
          paramInt1 += 1;
        }
        break;
        bool1 = false;
        break label114;
        paramIntent = null;
        paramInt1 = -1;
      }
      break;
    }
  }
  
  public void onBottomHiden()
  {
    if ((this.n != null) && (getView() != null) && (getView().isActive())) {
      getView().moveMap(this.n);
    }
  }
  
  public void onCollectClick(MinsuHouseBean.DataBean.ListBean paramListBean, boolean paramBoolean)
  {
    if (ApplicationEx.c.isLoginState())
    {
      if (paramBoolean)
      {
        com.ziroom.ziroomcustomer.minsu.e.a.collectHouse(getView().getActivity(), paramListBean.fid, paramListBean.rentWay, new s(getView().getActivity(), new r(MinsuHouseCollectResultBean.class))
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            super.onFailure(paramAnonymousThrowable);
            if ((b.this.getView() != null) && (b.this.getView().isActive())) {
              ((BaseActivity)b.this.getView().getActivity()).dismissProgress();
            }
          }
          
          public void onSuccess(int paramAnonymousInt, MinsuHouseCollectResultBean paramAnonymousMinsuHouseCollectResultBean)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousMinsuHouseCollectResultBean);
            if ((paramAnonymousMinsuHouseCollectResultBean != null) && (paramAnonymousMinsuHouseCollectResultBean.checkSuccess(b.this.getView().getActivity())) && (paramAnonymousMinsuHouseCollectResultBean.data != null) && ("0".equals(paramAnonymousMinsuHouseCollectResultBean.data.collResult)))
            {
              if ((b.a(b.this) != null) && (b.a(b.this).getCurrentCollectData() != null))
              {
                b.a(b.this).getCurrentCollectData().isCollect = 1;
                b.this.getHouseDetail(b.a(b.this).getCurrentCollectData().fid + b.a(b.this).getCurrentCollectData().rentWay).isCollect = 1;
                ((MinsuHouseBean.DataBean.ListBean)b.b(b.this).get(0)).isCollect = 1;
                b.a(b.this).notifyDataSetChanged();
                af.showToast(b.this.getView().getActivity(), "收藏成功");
              }
              ((BaseActivity)b.this.getView().getActivity()).dismissProgress();
              return;
            }
            if (paramAnonymousMinsuHouseCollectResultBean == null) {}
            for (paramAnonymousMinsuHouseCollectResultBean = null;; paramAnonymousMinsuHouseCollectResultBean = paramAnonymousMinsuHouseCollectResultBean.message)
            {
              ad.shouErrorMessage(paramAnonymousMinsuHouseCollectResultBean);
              break;
            }
          }
        });
        return;
      }
      com.ziroom.ziroomcustomer.minsu.e.a.cancelCollectHouse(getView().getActivity(), paramListBean.fid, paramListBean.rentWay, new s(getView().getActivity(), new r(MinsuHouseCancelCollectResultBean.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, MinsuHouseCancelCollectResultBean paramAnonymousMinsuHouseCancelCollectResultBean)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousMinsuHouseCancelCollectResultBean);
          if ((paramAnonymousMinsuHouseCancelCollectResultBean != null) && (paramAnonymousMinsuHouseCancelCollectResultBean.checkSuccess(b.this.getView().getActivity())) && ("0".equals(paramAnonymousMinsuHouseCancelCollectResultBean.data.delCollResult)))
          {
            if ((b.a(b.this) != null) && (b.a(b.this).getCurrentCancelCollectData() != null))
            {
              b.a(b.this).getCurrentCancelCollectData().isCollect = 0;
              b.this.getHouseDetail(b.a(b.this).getCurrentCollectData().fid + b.a(b.this).getCurrentCollectData().rentWay).isCollect = 0;
              b.a(b.this).notifyDataSetChanged();
              af.showToast(b.this.getView().getActivity(), "取消收藏成功");
            }
            ((BaseActivity)b.this.getView().getActivity()).dismissProgress();
            return;
          }
          if (paramAnonymousMinsuHouseCancelCollectResultBean == null) {}
          for (paramAnonymousMinsuHouseCancelCollectResultBean = null;; paramAnonymousMinsuHouseCancelCollectResultBean = paramAnonymousMinsuHouseCancelCollectResultBean.message)
          {
            ad.shouErrorMessage(paramAnonymousMinsuHouseCancelCollectResultBean);
            break;
          }
        }
      });
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(getView().getViewContext());
  }
  
  public void onHouseClick(String paramString)
  {
    this.e.add(paramString);
  }
  
  public void onLocInfo(int paramInt)
  {
    a.b localb;
    if (paramInt == -1)
    {
      getData();
      localb = getView();
      if (com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getMinsuConditionCount() <= 0) {
        break label42;
      }
    }
    label42:
    for (boolean bool = true;; bool = false)
    {
      localb.showRedDot(bool);
      return;
      if (paramInt != 11) {
        break;
      }
      break;
    }
  }
  
  public void onMapLoaded()
  {
    if ((this.l) || (this.m == null) || (a()) || (b())) {
      return;
    }
    getDistrictMapData(true);
  }
  
  public void showBottomRvMinsu(RecyclerView paramRecyclerView, RelativeLayout paramRelativeLayout, TextView paramTextView, String paramString, boolean paramBoolean)
  {
    paramString = getHouseDetail(paramString);
    this.f.clear();
    if (paramBoolean)
    {
      if ((paramString.locRepeatVo != null) && (paramString.locRepeatVo.locRepeatList != null) && (paramString.locRepeatVo.locRepeatList.size() > 0)) {
        this.f.addAll(paramString.locRepeatVo.locRepeatList);
      }
      paramRelativeLayout.setVisibility(0);
      paramTextView.setText(this.f.size() + "间房源");
      if (this.h != null) {
        break label266;
      }
      paramRelativeLayout = new LinearLayoutManager(getView().getViewContext(), 1, false);
      this.h = new com.ziroom.ziroomcustomer.minsu.searchlist.b.a(getView().getViewContext(), this);
      this.h.setData(this.f, a.c.b);
      paramRecyclerView.setLayoutManager(paramRelativeLayout);
      paramRecyclerView.setAdapter(this.h);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString.loc))
      {
        paramRecyclerView = paramString.loc.split(",");
        if (paramRecyclerView.length != 2) {
          break label298;
        }
        this.n = new LatLng(Double.parseDouble(paramRecyclerView[0]), Double.parseDouble(paramRecyclerView[1]));
      }
      return;
      paramRelativeLayout.setVisibility(8);
      paramTextView.setText("");
      this.f.add(paramString);
      break;
      label266:
      this.h.setData(this.f, a.c.b);
      paramRecyclerView.setAdapter(this.h);
      this.h.notifyDataSetChanged();
    }
    label298:
    this.n = null;
  }
  
  public void showBottomRvZry(RecyclerView paramRecyclerView, String paramString)
  {
    paramString = (ZryMapItembean)this.d.get(paramString);
    this.g.clear();
    this.g.add(paramString.convertListBean());
    if (this.i == null)
    {
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getView().getViewContext(), 1, false);
      this.i = new com.ziroom.ziroomcustomer.minsu.searchlist.b.c(getView().getViewContext());
      this.i.setData(this.g, c.b.b);
      paramRecyclerView.setLayoutManager(localLinearLayoutManager);
      paramRecyclerView.setAdapter(this.i);
    }
    while ((!TextUtils.isEmpty(paramString.latitude)) && (!TextUtils.isEmpty(paramString.longitude)))
    {
      this.n = new LatLng(Double.parseDouble(paramString.latitude), Double.parseDouble(paramString.longitude));
      return;
      this.i.setData(this.g, c.b.b);
      paramRecyclerView.setAdapter(this.i);
      this.i.notifyDataSetChanged();
    }
    this.n = null;
  }
  
  public void start()
  {
    this.m = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getCityBean();
    if ((this.m == null) || (this.m.longitude == null) || (this.m.latitude == null)) {
      this.m = com.ziroom.ziroomcustomer.minsu.d.b.getIntance(getView().getActivity()).getCityBean(com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getCityCode());
    }
  }
  
  public void updateDate()
  {
    a(com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getStartTime(), com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getEndTime());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */