package com.ziroom.ziroomcustomer.findhouse.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.c.p;
import com.ziroom.ziroomcustomer.e.c.q;
import com.ziroom.ziroomcustomer.e.c.r;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.PayType;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ActivityBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Banner;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ResidentialInfo;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Space;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Sublet;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Sublet.PromptBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.TipBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseRecommend;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.findhouse.widget.ZhuanBookCodeDialog;
import com.ziroom.ziroomcustomer.findhouse.widget.ZhuanBookCodeDialog.a;
import com.ziroom.ziroomcustomer.model.BookingOrderTextEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.CreditsBean;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.KeeperInfo;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.sublet.activity.SubletHouseShareActivity;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class d
  implements b.a
{
  private WeakReference<b.b> a;
  private RentHouseDetail b;
  private PayType c;
  private Map<String, RentHouseDetail.Space> d = new HashMap();
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private String j;
  private String k;
  private com.ziroom.ziroomcustomer.e.a.f<com.alibaba.fastjson.e> l;
  private com.ziroom.ziroomcustomer.e.a.f<com.alibaba.fastjson.e> m;
  
  public d(b.b paramb)
  {
    if (getView() != null) {}
    for (Object localObject1 = getView().getViewContext();; localObject1 = null)
    {
      this.l = new com.ziroom.ziroomcustomer.e.a.f((Context)localObject1, new o())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          b.b localb = d.this.getView();
          if ((localb != null) && (localb.isActive()))
          {
            paramAnonymouse = (CertInfoEntity)com.ziroom.ziroomcustomer.ziroomstation.utils.h.parseObject(paramAnonymouse.toJSONString(), CertInfoEntity.class);
            if ((paramAnonymouse == null) || (paramAnonymouse.credits == null) || (paramAnonymouse.credits.realNameStatus == 0)) {}
          }
          switch (paramAnonymouse.credits.realNameStatus)
          {
          default: 
            return;
          case 2: 
            localb.toCertStatus(d.d(d.this), paramAnonymouse, d.f(d.this), 1);
            return;
          case 3: 
            localb.toCertStatus(d.d(d.this), paramAnonymouse, d.f(d.this), 1);
            return;
          case 4: 
            localb.toCertInfoConfirm(d.d(d.this), paramAnonymouse, d.f(d.this), 1);
            return;
          case 1: 
            if ("1".equals(paramAnonymouse.getCert_type()))
            {
              localb.toCertInput(paramAnonymouse, d.d(d.this), d.f(d.this), 1);
              return;
            }
            localb.toCertStatus(d.d(d.this), paramAnonymouse, d.f(d.this), 1);
            return;
          }
          localb.toCertInput(paramAnonymouse, d.d(d.this), d.f(d.this), 1);
        }
      };
      localObject1 = localObject2;
      if (getView() != null) {
        localObject1 = getView().getViewContext();
      }
      this.m = new com.ziroom.ziroomcustomer.e.a.f((Context)localObject1, new o())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          b.b localb = d.this.getView();
          if ((localb != null) && (localb.isActive()))
          {
            paramAnonymouse = (CertInfoEntity)com.ziroom.ziroomcustomer.ziroomstation.utils.h.parseObject(paramAnonymouse.toJSONString(), CertInfoEntity.class);
            if (paramAnonymouse != null)
            {
              if (!"2".equals(paramAnonymouse.getUser_type())) {
                break label59;
              }
              localb.showToast("以公司名称签约，暂不支持配置中房源预订哦");
            }
          }
          label59:
          while ((paramAnonymouse.credits == null) || (paramAnonymouse.credits.realNameStatus == 0)) {
            return;
          }
          switch (paramAnonymouse.credits.realNameStatus)
          {
          default: 
            return;
          case 1: 
            if ("1".equals(paramAnonymouse.getCert_type()))
            {
              localb.toCertInput(paramAnonymouse, d.d(d.this), d.f(d.this), 2);
              return;
            }
          case 2: 
            localb.toCertStatus(d.d(d.this), paramAnonymouse, d.f(d.this), 2);
            return;
          case 3: 
            localb.toCertStatus(d.d(d.this), paramAnonymouse, d.f(d.this), 2);
            return;
          case 4: 
            localb.toCertInfoConfirm(d.d(d.this), paramAnonymouse, d.f(d.this), 2);
            return;
            localb.toCertStatus(d.d(d.this), paramAnonymouse, d.f(d.this), 2);
            return;
          }
          localb.toCertInput(paramAnonymouse, d.d(d.this), d.f(d.this), 2);
        }
      };
      this.a = new WeakReference(paramb);
      paramb.setPresenter(this);
      return;
    }
  }
  
  private HouseDetail a()
  {
    HouseDetail localHouseDetail = new HouseDetail();
    localHouseDetail.setHouse_photos_small(this.b.getPhotos_min());
    localHouseDetail.setHouse_name(this.b.getName());
    localHouseDetail.setHouse_price(this.b.getPrice());
    localHouseDetail.setHouse_price_desc(this.b.getPrice_desc());
    localHouseDetail.setHouse_area(this.b.getArea());
    localHouseDetail.setHouse_id(this.b.getHouse_id());
    localHouseDetail.setHouse_code(this.b.getId());
    localHouseDetail.setHouse_number("-1");
    localHouseDetail.setIs_duanzu(this.b.getIs_duanzu());
    localHouseDetail.setHouse_type(this.b.getHouse_type() + "");
    if (this.b.getResblock() != null) {
      localHouseDetail.setResblock_id(this.b.getResblock().getId());
    }
    localHouseDetail.setFrom(1);
    return localHouseDetail;
  }
  
  private void a(RentHouseDetail paramRentHouseDetail)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = new LinkedHashMap();
    Object localObject4 = new ArrayList();
    Object localObject5 = new RentHouseDetail.Space();
    if (paramRentHouseDetail.getHouse_type() == 1)
    {
      ((RentHouseDetail.Space)localObject5).setName(paramRentHouseDetail.getIndex_no() + "卧");
      ((RentHouseDetail.Space)localObject5).setPhotos_big(paramRentHouseDetail.getPhotos_big());
      ((RentHouseDetail.Space)localObject5).setPhotos_min(paramRentHouseDetail.getPhotos_min());
      ((RentHouseDetail.Space)localObject5).setFocus("1");
      ((List)localObject4).add(localObject5);
      localObject5 = new RentHouseDetail.Space();
      ((RentHouseDetail.Space)localObject5).setName("户型图");
      ((RentHouseDetail.Space)localObject5).setPhotos_big(paramRentHouseDetail.getHx_photos_big());
      ((RentHouseDetail.Space)localObject5).setPhotos_min(paramRentHouseDetail.getHx_photos_min());
      ((RentHouseDetail.Space)localObject5).setFocus("1");
      ((List)localObject4).add(localObject5);
      ((List)localObject4).addAll(paramRentHouseDetail.getSpace());
      if ((paramRentHouseDetail.getAir_photos_big() != null) && (paramRentHouseDetail.getAir_photos_min() != null) && (paramRentHouseDetail.getAir_photos_big().size() != 0) && (paramRentHouseDetail.getAir_photos_min().size() != 0)) {
        break label419;
      }
    }
    for (;;)
    {
      label217:
      if ((localObject4 != null) && (((List)localObject4).size() > 0))
      {
        int i1 = 0;
        int i2 = 1;
        if (i1 < ((List)localObject4).size())
        {
          localObject5 = (RentHouseDetail.Space)((List)localObject4).get(i1);
          int n = i2;
          String str;
          if (((RentHouseDetail.Space)localObject5).getFocus() != null)
          {
            n = i2;
            if ("1".equals(((RentHouseDetail.Space)localObject5).getFocus()))
            {
              n = i2;
              if (((RentHouseDetail.Space)localObject5).getPhotos_min() != null)
              {
                n = i2;
                if (((RentHouseDetail.Space)localObject5).getPhotos_min().size() > 0)
                {
                  ((List)localObject1).addAll(((RentHouseDetail.Space)localObject5).getPhotos_big());
                  ((List)localObject2).addAll(((RentHouseDetail.Space)localObject5).getPhotos_min());
                  str = ((RentHouseDetail.Space)localObject5).getName();
                  this.d.put(str, localObject5);
                  if (!((LinkedHashMap)localObject3).containsKey(str)) {
                    break label528;
                  }
                  n = 1;
                  for (;;)
                  {
                    if (((LinkedHashMap)localObject3).containsKey(str + n))
                    {
                      n += 1;
                      continue;
                      ((RentHouseDetail.Space)localObject5).setName("房源");
                      break;
                      label419:
                      localObject5 = new RentHouseDetail.Space();
                      ((RentHouseDetail.Space)localObject5).setName("空气检测报告");
                      ((RentHouseDetail.Space)localObject5).setPhotos_big(paramRentHouseDetail.getAir_photos_big());
                      ((RentHouseDetail.Space)localObject5).setPhotos_min(paramRentHouseDetail.getAir_photos_min());
                      ((RentHouseDetail.Space)localObject5).setFocus("1");
                      ((List)localObject4).add(localObject5);
                      break label217;
                    }
                  }
                  ((LinkedHashMap)localObject3).put(str + n, Integer.valueOf(i2));
                }
              }
            }
          }
          for (n = i2 + ((RentHouseDetail.Space)localObject5).getPhotos_min().size();; n = i2 + ((RentHouseDetail.Space)localObject5).getPhotos_min().size())
          {
            i1 += 1;
            i2 = n;
            break;
            label528:
            ((LinkedHashMap)localObject3).put(str, Integer.valueOf(i2));
          }
        }
      }
    }
    localObject2 = getView();
    if ((localObject2 != null) && (((b.b)localObject2).isActive()))
    {
      ((b.b)localObject2).showCarousel((List)localObject1, (List)localObject1, (LinkedHashMap)localObject3);
      if (paramRentHouseDetail.getHouse_type() != 1) {
        break label873;
      }
      localObject1 = "";
      if (!TextUtils.isEmpty(this.b.getPrice()))
      {
        localObject3 = new StringBuilder().append("¥").append(this.b.getPrice()).append(this.b.getPrice_unit());
        if (!TextUtils.isEmpty(this.b.getPrice_desc())) {
          break label836;
        }
        localObject1 = "";
        localObject1 = (String)localObject1;
      }
      localObject3 = this.b.getArea() + "㎡";
      localObject4 = this.b.getFloor() + "/" + this.b.getFloor_total() + "层";
      localObject5 = this.b.getBedroom() + "室" + this.b.getParlor() + "厅";
      ((b.b)localObject2).showHouseInfo(paramRentHouseDetail.getName(), (String)localObject1, (String)localObject3, paramRentHouseDetail.getFace(), (String)localObject4, (String)localObject5, paramRentHouseDetail.getSubway_primary(), paramRentHouseDetail.getTags(), this.b.getActivity());
    }
    label836:
    label873:
    while (paramRentHouseDetail.getHouse_type() != 8) {
      for (;;)
      {
        return;
        localObject1 = "(" + this.b.getPrice_desc() + ")";
      }
    }
    localObject1 = "";
    if (!TextUtils.isEmpty(this.b.getPrice()))
    {
      localObject3 = new StringBuilder().append("¥").append(this.b.getPrice()).append(this.b.getPrice_unit());
      if (!TextUtils.isEmpty(this.b.getPrice_desc())) {
        break label1118;
      }
    }
    label1118:
    for (localObject1 = "";; localObject1 = "(" + this.b.getPrice_desc() + ")")
    {
      localObject1 = (String)localObject1;
      localObject3 = this.b.getArea() + "㎡";
      localObject4 = this.b.getFloor() + "/" + this.b.getFloor_total() + "层";
      localObject5 = this.b.getBedroom() + "室" + this.b.getParlor() + "厅";
      ((b.b)localObject2).showHouseInfo(paramRentHouseDetail.getName(), (String)localObject1, (String)localObject3, paramRentHouseDetail.getFace(), (String)localObject4, (String)localObject5, paramRentHouseDetail.getSubway_primary(), paramRentHouseDetail.getTags(), this.b.getActivity());
      return;
    }
  }
  
  private void b()
  {
    if ((this.b != null) && (this.b.getResblock() != null) && (!TextUtils.isEmpty(this.b.getResblock().getId())))
    {
      String str4 = "0";
      String str1 = "";
      String str2 = "";
      String str3 = "";
      Object localObject = ApplicationEx.c.getUser();
      if (localObject != null)
      {
        str4 = "1";
        str1 = ((UserInfo)localObject).getUid();
        str2 = ((UserInfo)localObject).getPhone();
        str3 = ((UserInfo)localObject).getRealName();
      }
      localObject = getView();
      if ((localObject != null) && (((b.b)localObject).isActive()))
      {
        com.ziroom.ziroomcustomer.e.a.e local8 = new com.ziroom.ziroomcustomer.e.a.e(((b.b)localObject).getViewContext(), new m(KeeperInfo.class, new com.ziroom.ziroomcustomer.e.c.a.d()))
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            super.onFailure(paramAnonymousThrowable);
          }
          
          public void onSuccess(int paramAnonymousInt, KeeperInfo paramAnonymousKeeperInfo)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousKeeperInfo);
            b.b localb = d.this.getView();
            if ((localb != null) && (localb.isActive())) {
              localb.showHousekeeper(paramAnonymousKeeperInfo);
            }
          }
        };
        j.getRentHouseKeeper(((b.b)localObject).getViewContext(), str1, str2, str3, str4, this.b.getResblock().getId(), this.b.getHouse_id(), this.b.getId(), this.b.getHouse_type(), local8);
      }
    }
  }
  
  private void c()
  {
    if ((this.b != null) && (!TextUtils.isEmpty(this.b.getAd_1())))
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive()))
      {
        com.ziroom.ziroomcustomer.e.a.e local9 = new com.ziroom.ziroomcustomer.e.a.e(localb.getViewContext(), new q(com.alibaba.fastjson.e.class))
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            super.onFailure(paramAnonymousThrowable);
          }
          
          public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymouse);
            if (paramAnonymouse != null)
            {
              b.b localb = d.this.getView();
              if ((localb != null) && (localb.isActive())) {
                localb.showCoordination(paramAnonymouse.getString("title"), paramAnonymouse.getString("photo"), paramAnonymouse.getString("link"), paramAnonymouse.getString("description"), paramAnonymouse.getString("app"));
              }
            }
          }
        };
        j.getCommonJson(localb.getViewContext(), this.b.getAd_1(), local9);
      }
    }
  }
  
  private void d()
  {
    if ((this.b != null) && (!TextUtils.isEmpty(this.b.getHouse_id())))
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive()))
      {
        com.ziroom.ziroomcustomer.e.a.e local10 = new com.ziroom.ziroomcustomer.e.a.e(localb.getViewContext(), new p(RentHouseRecommend.class))
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            super.onFailure(paramAnonymousThrowable);
          }
          
          public void onSuccess(int paramAnonymousInt, List<RentHouseRecommend> paramAnonymousList)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousList);
            b.b localb = d.this.getView();
            if ((localb != null) && (localb.isActive())) {
              localb.showRecommend(paramAnonymousList);
            }
          }
        };
        j.getRecommedList(localb.getViewContext(), this.b.getId(), this.b.getHouse_id(), local10);
      }
    }
  }
  
  private void e()
  {
    boolean bool2 = false;
    boolean bool1;
    Object localObject;
    long l1;
    boolean bool4;
    String str;
    boolean bool3;
    if (this.b != null)
    {
      if ((this.b.getStatus().equals("yxd")) || (this.b.getStatus().equals("ycz"))) {
        break label139;
      }
      bool1 = true;
      if (!this.e) {
        break label243;
      }
      if (!this.b.getTurn().getStatus().equals("yxd")) {
        break label169;
      }
      if (!this.g) {
        break label144;
      }
      localObject = "已预订";
      l1 = 0L;
      bool4 = false;
      str = "立即预订";
      bool1 = true;
      bool3 = false;
      bool2 = false;
    }
    label139:
    label144:
    label169:
    label223:
    label243:
    boolean bool5;
    for (;;)
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.showBottom(bool1, str, bool2, bool3, (String)localObject, bool4, l1, true);
      }
      return;
      bool1 = false;
      break;
      localObject = "已预订";
      l1 = 0L;
      bool4 = false;
      str = "立即签约";
      bool1 = true;
      bool3 = true;
      bool2 = false;
      continue;
      if (this.g) {}
      for (str = "立即预订";; str = "立即签约")
      {
        if (this.b.getTurn().getContactable() != 1) {
          break label223;
        }
        localObject = "联系Ta";
        l1 = 0L;
        bool4 = true;
        bool1 = true;
        bool3 = true;
        bool2 = true;
        break;
      }
      localObject = "休息中";
      l1 = 0L;
      bool4 = true;
      bool1 = true;
      bool3 = true;
      bool2 = true;
      continue;
      if (this.f)
      {
        localObject = "立即收藏";
        l1 = 0L;
        str = "预约看房";
        bool5 = false;
        bool4 = true;
        bool3 = false;
        bool2 = bool1;
        bool1 = bool5;
      }
      else
      {
        if (!this.b.getStatus().equals("dzz")) {
          break label324;
        }
        localObject = "立即签约";
        l1 = 0L;
        str = "预约看房";
        bool5 = true;
        bool4 = true;
        bool3 = true;
        bool2 = bool1;
        bool1 = bool5;
      }
    }
    label324:
    if ((this.b.getIs_reserve() == 1) || (this.b.getIs_reserve() == 2))
    {
      if (!TextUtils.isEmpty(this.b.getReserve_message())) {}
      for (str = this.b.getReserve_message();; str = "预订")
      {
        if (this.b.getIs_reserve() == 1) {
          bool2 = true;
        }
        l1 = 0L;
        localObject = str;
        str = "预约看房";
        bool3 = bool1;
        bool4 = bool2;
        bool5 = true;
        bool1 = true;
        bool2 = bool3;
        bool3 = bool5;
        break;
      }
    }
    if (this.b.getStatus().equals("sfz"))
    {
      l1 = this.b.getSign_date();
      if ((l1 > 0L) && (l1 < 43200L)) {
        str = "预订";
      }
    }
    for (;;)
    {
      localObject = str;
      bool3 = true;
      bool2 = bool1;
      str = "预约看房";
      bool1 = true;
      bool4 = false;
      break;
      str = "释放中";
      l1 = 0L;
      continue;
      if ((this.b.getStatus().equals("zxpzz")) || (this.b.getStatus().equals("tzpzz")))
      {
        if (!TextUtils.isEmpty(this.b.getNotice_word()))
        {
          str = this.b.getNotice_word();
          l1 = 0L;
          continue;
        }
        if (this.b.getStatus().equals("zxpzz"))
        {
          str = "装修配置中";
          l1 = 0L;
          continue;
        }
        if (this.b.getStatus().equals("tzpzz"))
        {
          str = "退租配置中";
          l1 = 0L;
        }
      }
      else
      {
        if (this.b.getStatus().equals("yxd"))
        {
          str = "已预订";
          l1 = 0L;
          continue;
        }
        if (this.b.getStatus().equals("ycz"))
        {
          str = "已出租";
          l1 = 0L;
          continue;
        }
        str = "配置中";
        l1 = 0L;
        continue;
      }
      str = "立即签约";
      l1 = 0L;
    }
  }
  
  public void checkSubletCode(String paramString)
  {
    String str1;
    if (this.b.getHouse_type() == 1)
    {
      str1 = "1";
      if (this.b.getHouse_type() != 1) {
        break label100;
      }
    }
    label100:
    for (String str2 = this.b.getCode();; str2 = this.b.getHouse_code())
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        j.checkSubletCode(localb.getViewContext(), str2, paramString, str1, new com.ziroom.ziroomcustomer.e.a.f(localb.getViewContext(), new q(String.class))
        {
          public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousString);
            paramAnonymousString = d.this.getView();
            if ((paramAnonymousString != null) && (paramAnonymousString.isActive()))
            {
              paramAnonymousString.dismissSubletCode();
              d.this.doSign();
            }
          }
        });
      }
      return;
      str1 = "2";
      break;
    }
  }
  
  public void checkSubletReservationCode(String paramString)
  {
    String str1;
    if (this.b.getHouse_type() == 1)
    {
      str1 = "1";
      if (this.b.getHouse_type() != 1) {
        break label100;
      }
    }
    label100:
    for (String str2 = this.b.getCode();; str2 = this.b.getHouse_code())
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        j.checkSubletCode(localb.getViewContext(), str2, paramString, str1, new com.ziroom.ziroomcustomer.e.a.f(localb.getViewContext(), new q(String.class))
        {
          public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousString);
            b.b localb = d.this.getView();
            HouseDetail localHouseDetail;
            if ((localb != null) && (localb.isActive()))
            {
              localHouseDetail = d.d(d.this);
              localHouseDetail.setSubletReserveCode(d.e(d.this));
              if (2 != com.ziroom.commonlib.utils.h.getsEnvironment()) {
                break label115;
              }
              paramAnonymousString = "http://www.t.ziroom.com/zhuanti/app/interaction/yuding.html";
            }
            for (;;)
            {
              Intent localIntent = new Intent(localb.getViewContext(), JsBridgeWebActivity.class);
              localIntent.putExtra("detail", localHouseDetail);
              localIntent.putExtra("url", paramAnonymousString);
              localIntent.putExtra("type", 3);
              localb.getViewContext().startActivity(localIntent);
              return;
              label115:
              if (3 == com.ziroom.commonlib.utils.h.getsEnvironment()) {
                paramAnonymousString = "http://www.q.ziroom.com/zhuanti/app/interaction/yuding.html";
              } else {
                paramAnonymousString = "http://zhuanti.ziroom.com/zhuanti/app/interaction/yuding.html";
              }
            }
          }
        });
      }
      return;
      str1 = "2";
      break;
    }
  }
  
  public void clickTabInitData(int paramInt)
  {
    if ((this.b == null) || (this.b.getSpace() == null) || (paramInt > this.b.getSpace().size() - 1)) {}
    b.b localb;
    do
    {
      return;
      localb = getView();
    } while ((localb == null) || (!localb.isActive()));
    localb.updataSubsidiary(paramInt, (RentHouseDetail.Space)this.b.getSpace().get(paramInt));
  }
  
  public void contactSublet()
  {
    if (this.e)
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.toSubletContact(this.b.getHouse_id(), this.b.getName(), this.b.getTurn().getCustomer_phone());
      }
    }
  }
  
  public void countTimeFinish()
  {
    this.i = true;
    b.b localb = getView();
    if ((localb != null) && (localb.isActive())) {
      localb.showCountTimeFinish();
    }
  }
  
  public void detachView()
  {
    b.b localb = getView();
    if ((localb != null) && (localb.isActive())) {
      com.freelxl.baselibrary.d.a.cancel(localb.getViewContext());
    }
    if (this.a != null) {
      this.a.clear();
    }
    this.a = null;
  }
  
  public void doAuthenticate(String paramString)
  {
    paramString = getView();
    if ((paramString != null) && (paramString.isActive()) && (paramString.getViewContext() != null)) {
      j.getCertInfo(paramString.getViewContext(), com.ziroom.commonlibrary.login.a.getToken(paramString.getViewContext()), 1, this.l);
    }
  }
  
  public void doBook()
  {
    b.b localb = getView();
    if ((localb != null) && (localb.isActive())) {
      com.ziroom.commonlibrary.login.a.getUserInfo(localb.getViewContext(), new a.b()
      {
        public void onUserInfo(com.alibaba.fastjson.e paramAnonymouse)
        {
          if (paramAnonymouse == null) {}
          b.b localb;
          do
          {
            return;
            localb = d.this.getView();
          } while ((localb == null) || (!localb.isActive()));
          d.b(d.this, (String)paramAnonymouse.get("phone"));
          if (!TextUtils.isEmpty(d.f(d.this)))
          {
            j.getCertInfo(localb.getViewContext(), com.ziroom.commonlibrary.login.a.getToken(localb.getViewContext()), 1, d.g(d.this));
            return;
          }
          com.ziroom.commonlibrary.login.a.startBindPhoneActivity(localb.getViewContext());
        }
      });
    }
  }
  
  public void doSign()
  {
    b.b localb = getView();
    if ((localb != null) && (localb.isActive())) {
      com.ziroom.commonlibrary.login.a.getUserInfo(localb.getViewContext(), new a.b()
      {
        public void onUserInfo(com.alibaba.fastjson.e paramAnonymouse)
        {
          if (paramAnonymouse == null) {}
          do
          {
            return;
            d.b(d.this, (String)paramAnonymouse.get("phone"));
            if (!TextUtils.isEmpty(d.f(d.this)))
            {
              d.this.doAuthenticate(d.f(d.this));
              return;
            }
            paramAnonymouse = d.this.getView();
          } while ((paramAnonymouse == null) || (!paramAnonymouse.isActive()));
          com.ziroom.commonlibrary.login.a.startBindPhoneActivity(paramAnonymouse.getViewContext());
        }
      });
    }
  }
  
  public void fillReservationCode(String paramString1, String paramString2, String paramString3, final String paramString4, final String paramString5, final String paramString6, final String paramString7)
  {
    b.b localb = getView();
    if ((localb != null) && (localb.isActive()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("title", paramString1);
      localBundle.putString("desc", paramString2);
      localBundle.putString("linkStr", paramString3);
      ZhuanBookCodeDialog.getInstance(localBundle);
      ZhuanBookCodeDialog.setLinkListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = d.this.getView();
          if ((paramAnonymousView != null) && (paramAnonymousView.isActive())) {
            JsBridgeWebActivity.start(paramAnonymousView.getViewContext(), paramString4, paramString5);
          }
        }
      });
      paramString1 = ZhuanBookCodeDialog.setOKListener(new ZhuanBookCodeDialog.a()
      {
        public void onClick(View paramAnonymousView, String paramAnonymousString)
        {
          paramAnonymousView = new com.alibaba.fastjson.e();
          paramAnonymousView.put("subletCode", paramString6);
          paramAnonymousView.put("reservationCode", paramAnonymousString);
          paramAnonymousView.put("reserveType", paramString7);
          paramAnonymousView.put("houseCode", d.a(d.this).getId());
          paramAnonymousView.put("houseId", d.a(d.this).getHouse_id());
          paramAnonymousView.put("houseType", Integer.valueOf(d.a(d.this).getHouse_type()));
          paramAnonymousView.put("confirmType", "ZZYD");
          d.a(d.this, paramAnonymousView.toJSONString());
          d.this.checkSubletReservationCode(paramAnonymousString);
        }
      });
      if (((RentHouseDetailActivity)localb.getViewContext()).isStateEnable())
      {
        paramString2 = ((RentHouseDetailActivity)localb.getViewContext()).getSupportFragmentManager();
        if ((paramString1 instanceof DialogFragment)) {
          break label141;
        }
        paramString1.show(paramString2, "subletReservation");
      }
    }
    return;
    label141:
    VdsAgent.showDialogFragment((DialogFragment)paramString1, paramString2, "subletReservation");
  }
  
  public boolean getCollect()
  {
    return this.h;
  }
  
  public void getCollectFormServer()
  {
    if (ApplicationEx.c.getUser() != null)
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive()))
      {
        com.ziroom.ziroomcustomer.e.a.e local11 = new com.ziroom.ziroomcustomer.e.a.e(localb.getViewContext(), new q(com.alibaba.fastjson.e.class))
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            super.onFailure(paramAnonymousThrowable);
          }
          
          public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymouse);
            b.b localb = d.this.getView();
            if ((localb != null) && (localb.isActive()) && (paramAnonymouse != null) && (paramAnonymouse.containsKey("exist")))
            {
              if (paramAnonymouse.getInteger("exist").intValue() != 0) {
                break label82;
              }
              d.a(d.this, false);
            }
            for (;;)
            {
              localb.showCollection(d.b(d.this), d.c(d.this));
              return;
              label82:
              if (paramAnonymouse.getInteger("exist").intValue() == 1) {
                d.a(d.this, true);
              }
            }
          }
        };
        j.getCollect(localb.getViewContext(), this.b.getId(), local11);
      }
    }
  }
  
  public b.b getView()
  {
    if (this.a != null) {
      return (b.b)this.a.get();
    }
    return null;
  }
  
  public void init(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.b = ((RentHouseDetail)com.alibaba.fastjson.e.parseObject(paramString, RentHouseDetail.class));
    }
    b.b localb = getView();
    if ((this.b != null) && (localb != null) && (localb.isActive()))
    {
      com.freelxl.baselibrary.f.d.d("fragment", "=======onSuccess");
      if ((this.b != null) && (this.b.getTurn() != null) && (!TextUtils.isEmpty(this.b.getTurn().getUid())))
      {
        this.e = true;
        if (2 == this.b.getTurn().getVersion()) {
          this.g = true;
        }
      }
      if ((com.freelxl.baselibrary.f.f.notNull(this.b.getWill_unrent_date())) && (!this.e)) {
        this.f = true;
      }
      if (this.e)
      {
        this.b.setPrice(this.b.getTurn().getEstimate_price());
        this.b.setPrice_unit(this.b.getTurn().getEstimate_price_company());
        this.b.setPrice_desc(this.b.getTurn().getEstimate_price_desc());
      }
      getCollectFormServer();
      new Thread(new Runnable()
      {
        public void run()
        {
          if (com.ziroom.ziroomcustomer.b.g.sava(ApplicationEx.c, d.a(d.this).getBizcircle_code(), d.a(d.this).getBizcircle_name())) {
            com.ziroom.ziroomcustomer.b.h.sava(ApplicationEx.c, d.a(d.this).getResblock().getId(), d.a(d.this).getResblock().getName());
          }
        }
      }).start();
      localb.growingIo(this.b.getHouse_type(), this.b.getId(), this.b.getHouse_id(), this.b.getVersion_name());
      if (this.b.getHouse_type() != 1) {
        break label705;
      }
      localb.saveHouseCode2Clipboard(this.b.getCode());
      a(this.b);
      localb.showBigPic((String)this.b.getPhotos_big().get(0));
      localb.showPicNumsign(this.b.getHouse_type(), this.b.getStatus());
      localb.showIntroduce(this.b.getIntroduction());
      if (!this.e) {
        break label721;
      }
      localb.showSubletDesc(this.b.getTurn());
      localb.showSubletRecommend(this.b.getTurn().getDescribe());
      label373:
      if ((this.b.getHx_photos_big() != null) && (this.b.getHx_photos_big().size() >= 1)) {
        break label781;
      }
      paramString = "";
      label402:
      localb.showSubsidiary(this.b.getSpace(), paramString);
      localb.showActivitys(this.b.getActivity_list());
      localb.showRoomInfo(this.b.getId(), this.b.getRoommates());
      localb.showSignEndDate(this.b.getSign_duration());
      if (this.b.getHouse_type() != 5)
      {
        int n = this.b.getHouse_type();
        paramString = this.b;
        if (n != 8) {
          break label801;
        }
      }
      localb.showEnsure(this.b.getEnsures());
      label505:
      localb.initHoustTips(this.b.getTips());
      localb.showResblockIntroduce(this.b.getResblock());
      localb.showHouseConfig(this.b.getConfig());
      localb.showAround(this.b.getResblock());
      if (this.b.getResblock() != null) {
        localb.showAroundPoi(this.b.getResblock().getSurround());
      }
      if ((this.b.getHx_photos_big() != null) && (this.b.getHx_photos_big().size() >= 1)) {
        break label817;
      }
      paramString = "";
      label612:
      localb.showHuxingInfo(paramString);
      if ((!this.e) && (!this.f)) {
        break label837;
      }
      localb.showHousekeeper(null);
    }
    for (;;)
    {
      localb.showQuestions(this.b.getQuestions());
      c();
      d();
      e();
      localb.showHeader(this.b.getName());
      localb.show3D(this.b.getShow3d());
      localb.showBanner(this.b.getBanner());
      return;
      label705:
      localb.saveHouseCode2Clipboard(this.b.getHouse_code());
      break;
      label721:
      if (this.f)
      {
        localb.showWillUnrent(this.b);
        localb.showSubletDesc(null);
        localb.showSubletRecommend("");
        break label373;
      }
      localb.showWillUnrent(null);
      localb.showSubletDesc(null);
      localb.showSubletRecommend("");
      break label373;
      label781:
      paramString = (String)this.b.getHx_photos_big().get(0);
      break label402;
      label801:
      localb.showService(this.b.getServices());
      break label505;
      label817:
      paramString = (String)this.b.getHx_photos_big().get(0);
      break label612;
      label837:
      b();
    }
  }
  
  public void init3D()
  {
    if (this.b != null)
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.show3D("", this.b.getShow3d());
      }
    }
  }
  
  public void initAroundBaiduMap()
  {
    if ((this.b != null) && (this.b.getResblock() != null))
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.showAroundBaiduMap(this.b.getResblock().getName(), this.b.getResblock().getLng(), this.b.getResblock().getLat(), this.b.getResblock().getSurround());
      }
    }
  }
  
  public void initAroundDetail()
  {
    if (this.b != null)
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.showAroundAll(this.b.getResblock());
      }
    }
  }
  
  public void initDistrictDetail()
  {
    if ((this.b == null) || (this.b.getResblock() == null)) {}
    b.b localb;
    do
    {
      return;
      localb = getView();
    } while ((localb == null) || (!localb.isActive()));
    localb.toDistrictDetail(this.b);
  }
  
  public void initEnsureAll()
  {
    if (this.b != null)
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.showEnsureAll(this.b.getEnsures());
      }
    }
  }
  
  public void initHouseCode()
  {
    b.b localb;
    if (this.b != null)
    {
      localb = getView();
      if ((localb != null) && (localb.isActive()))
      {
        if (this.b.getHouse_type() != 1) {
          break label50;
        }
        localb.showHouseCode(this.b.getCode());
      }
    }
    return;
    label50:
    localb.showHouseCode(this.b.getHouse_code());
  }
  
  public void initHouseInfo()
  {
    if ((this.b != null) && (this.b.getBanner() != null))
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.showHouseInfo(this.b.getBanner().getTitle(), this.b.getBanner().getLink());
      }
    }
  }
  
  public void initHxPicDetail()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = new ArrayList();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    ArrayList localArrayList2 = new ArrayList();
    RentHouseDetail.Space localSpace = new RentHouseDetail.Space();
    localSpace.setName("户型图");
    localSpace.setPhotos_big(this.b.getHx_photos_big());
    localSpace.setPhotos_min(this.b.getHx_photos_min());
    localSpace.setFocus("1");
    localArrayList2.add(localSpace);
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      int i1 = 0;
      int i2 = 1;
      if (i1 < localArrayList2.size())
      {
        localSpace = (RentHouseDetail.Space)localArrayList2.get(i1);
        int n = i2;
        String str;
        if (localSpace.getFocus() != null)
        {
          n = i2;
          if ("1".equals(localSpace.getFocus()))
          {
            n = i2;
            if (localSpace.getPhotos_min() != null)
            {
              n = i2;
              if (localSpace.getPhotos_min().size() > 0)
              {
                localArrayList1.addAll(localSpace.getPhotos_big());
                ((List)localObject).addAll(localSpace.getPhotos_min());
                str = localSpace.getName();
                this.d.put(str, localSpace);
                if (!localLinkedHashMap.containsKey(str)) {
                  break label331;
                }
                n = 1;
                while (localLinkedHashMap.containsKey(str + n)) {
                  n += 1;
                }
                localLinkedHashMap.put(str + n, Integer.valueOf(i2));
              }
            }
          }
        }
        for (n = i2 + localSpace.getPhotos_min().size();; n = i2 + localSpace.getPhotos_min().size())
        {
          i1 += 1;
          i2 = n;
          break;
          label331:
          localLinkedHashMap.put(str, Integer.valueOf(i2));
        }
      }
    }
    localObject = getView();
    if ((localObject != null) && (((b.b)localObject).isActive())) {
      ((b.b)localObject).showHxPicDetail(localArrayList1, localArrayList1, localLinkedHashMap);
    }
  }
  
  public void initPayType()
  {
    b.b localb;
    if (this.c == null)
    {
      localb = getView();
      if ((localb == null) || (!localb.isActive())) {
        break label95;
      }
      if ((this.b != null) && (!TextUtils.isEmpty(this.b.getHouse_id())))
      {
        com.ziroom.ziroomcustomer.e.a.f local13 = new com.ziroom.ziroomcustomer.e.a.f(localb.getViewContext(), new q(PayType.class))
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            super.onFailure(paramAnonymousThrowable);
          }
          
          public void onSuccess(int paramAnonymousInt, PayType paramAnonymousPayType)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousPayType);
            b.b localb = d.this.getView();
            if ((localb != null) && (localb.isActive()) && (paramAnonymousPayType != null))
            {
              d.a(d.this, paramAnonymousPayType);
              localb.showPayType(paramAnonymousPayType);
            }
          }
        };
        j.getPayType(localb.getViewContext(), this.b.getId(), this.b.getHouse_id(), local13);
      }
    }
    return;
    label95:
    localb.showPayType(this.c);
  }
  
  public void initResblockHouseList()
  {
    if ((this.b != null) && (this.b.getResblock() != null))
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.toResblockHouseList(this.b.getResblock().getId(), this.b.getResblock().getName());
      }
    }
  }
  
  public void initServiceAll()
  {
    if (this.b != null)
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.showServiceAll(this.b.getServices());
      }
    }
  }
  
  public void initShare()
  {
    if (this.b != null)
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive()) && (this.b.getPhotos_min() != null) && (this.b.getPhotos_min().size() > 0)) {
        localb.showShare((String)this.b.getPhotos_min().get(0), this.b.getWechat_share(), 2130840431, "生成图片", new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = d.this.getView();
            if ((paramAnonymousView != null) && (paramAnonymousView.isActive()))
            {
              Intent localIntent = new Intent(paramAnonymousView.getViewContext(), SubletHouseShareActivity.class);
              localIntent.putExtra("houseDetail", d.a(d.this));
              paramAnonymousView.getViewContext().startActivity(localIntent);
            }
          }
        });
      }
    }
  }
  
  public void initSpaceAll()
  {
    if (this.b != null)
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.showSubsidiaryAll(this.b.getSpace());
      }
    }
  }
  
  public void initWillUnrent()
  {
    if (this.b != null)
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.showWillUnrentPop(this.b);
      }
    }
  }
  
  public boolean ismIsWillUnrent()
  {
    return this.f;
  }
  
  public void showActivitysPop()
  {
    if (this.b != null)
    {
      b.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.showActivitysPop(this.b.getActivity_list());
      }
    }
  }
  
  public void showHouseTips()
  {
    b.b localb = getView();
    if ((localb != null) && (localb.isActive())) {
      localb.showHouseTips(this.b.getTips().getContent());
    }
  }
  
  public void showSignEndDate()
  {
    if (this.b == null) {}
  }
  
  public void start() {}
  
  public void submitBtnA()
  {
    if (this.b == null) {}
    b.b localb;
    do
    {
      do
      {
        return;
        localb = getView();
      } while ((localb == null) || (!localb.isActive()));
      if (this.e)
      {
        if (this.g)
        {
          localObject1 = this.b.getTurn().getReserve_prompt();
          localObject2 = new HashMap();
          ((Map)localObject2).put("uid", com.ziroom.commonlibrary.login.a.getUid(localb.getViewContext()));
          ((Map)localObject2).put("subletCode", this.b.getTurn().getTurn_id() + "");
          ((Map)localObject2).put("reserveType", "2");
          com.ziroom.ziroomcustomer.e.g.appendCommenParams((Map)localObject2);
          j.hasSubletReservation(localb.getViewContext(), (Map)localObject2, new com.ziroom.ziroomcustomer.e.a.f(localb.getViewContext(), new r())
          {
            public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
            {
              super.onSuccess(paramAnonymousInt, paramAnonymouse);
              b.b localb = d.this.getView();
              if ((localb != null) && (localb.isActive()))
              {
                paramAnonymousInt = paramAnonymouse.getInteger("error_code").intValue();
                String str = paramAnonymouse.getString("status");
                paramAnonymouse.getString("data");
                paramAnonymouse = paramAnonymouse.getString("error_message");
                if ((paramAnonymousInt != 0) || (!"success".equals(str))) {
                  break label157;
                }
                if (localObject1 != null) {}
              }
              else
              {
                return;
              }
              d.this.fillReservationCode(localObject1.getTitle(), localObject1.getText(), localObject1.getLink_text(), localObject1.getLink_text(), localObject1.getLink_url(), d.a(d.this).getTurn().getTurn_id() + "", "2");
              return;
              label157:
              af.showToast(localb.getViewContext(), paramAnonymouse);
            }
          });
          return;
        }
        if (this.b.getTurn().getSigning() == 1)
        {
          localb.toSubletCode(this.b.getHouse_id(), this.b.getTurn().getSigning_text());
          return;
        }
        localb.toSublet(this.b.getHouse_id(), this.b.getTurn().getSigning_text());
        return;
      }
      com.ziroom.commonlibrary.g.b.a.onAppointment();
    } while ((this.b == null) || ("yxd".equals(this.b.getStatus())) || ("ycz".equals(this.b.getStatus())));
    String str1 = this.b.getName();
    String str2 = this.b.getPrice() + this.b.getPrice_unit();
    final Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.b.getArea()).append(" ㎡ | ").append(this.b.getFloor()).append("/").append(this.b.getFloor_total()).append("层");
    String str3 = ((StringBuilder)localObject1).toString();
    Object localObject2 = "";
    List localList = this.b.getPhotos_min();
    localObject1 = localObject2;
    if (localList != null)
    {
      localObject1 = localObject2;
      if (localList.size() > 0) {
        localObject1 = (String)localList.get(0);
      }
    }
    localb.toAppointment(this.b.getId(), this.b.getHouse_id(), this.b.getHouse_type(), this.b.getResblock().getId(), str1, str2, str3, (String)localObject1);
  }
  
  public void submitBtnB()
  {
    if (this.b == null) {}
    b.b localb;
    do
    {
      do
      {
        return;
        localb = getView();
      } while ((localb == null) || (!localb.isActive()));
      if (!this.e) {
        break;
      }
    } while (this.b.getTurn() == null);
    if ((!this.b.getTurn().getStatus().equals("yxd")) && (this.b.getTurn().getContactable() != 1))
    {
      localb.showSubleDialog();
      return;
    }
    localb.toSubletContact(this.b.getHouse_id(), this.b.getName(), this.b.getTurn().getCustomer_phone());
    return;
    if (this.f)
    {
      updateCollect();
      return;
    }
    if ((this.b.getStatus().equals("dzz")) || ((this.b.getStatus().equals("sfz")) && (this.i)))
    {
      doSign();
      return;
    }
    if (this.b.getIs_reserve() == 1)
    {
      if ((this.b.getHouse_type() == 5) || (this.b.getHouse_type() == 8))
      {
        localb.showToast("当前版本暂时不支持预订");
        return;
      }
      com.ziroom.ziroomcustomer.e.a.f local17 = new com.ziroom.ziroomcustomer.e.a.f(localb.getViewContext(), new q(BookingOrderTextEntity.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, BookingOrderTextEntity paramAnonymousBookingOrderTextEntity)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousBookingOrderTextEntity);
          b.b localb = d.this.getView();
          if ((localb != null) && (localb.isActive()) && (paramAnonymousBookingOrderTextEntity != null)) {
            localb.showBookDialog(paramAnonymousBookingOrderTextEntity);
          }
        }
      };
      j.getBookText(localb.getViewContext(), this.b.getId(), this.b.getHouse_id(), this.b.getHouse_type(), local17);
      return;
    }
    localb.showToast("该房源当前状态不能签约");
  }
  
  public void updateCollect()
  {
    if (this.b == null) {}
    b.b localb;
    do
    {
      return;
      localb = getView();
    } while ((localb == null) || (!localb.isActive()));
    boolean bool;
    if (!this.h)
    {
      bool = true;
      this.h = bool;
      localb.showCollection(this.h, this.f);
      if (!this.h) {
        break label143;
      }
      localb.showToast("收藏成功");
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.e.a.e local12 = new com.ziroom.ziroomcustomer.e.a.e(localb.getViewContext(), new q(com.alibaba.fastjson.e.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
        }
      };
      j.updateRentHouseCollect(localb.getViewContext(), this.h, this.b.getId(), this.b.getHouse_type(), this.b.getCode(), this.b.getStatus(), local12);
      return;
      bool = false;
      break;
      label143:
      localb.showToast("已取消收藏");
    }
  }
  
  public void updateHouseInfo(String paramString)
  {
    b.b localb = getView();
    Object localObject;
    if ((localb != null) && (localb.isActive()) && (this.b != null) && ((this.b.getHouse_type() == 5) || (this.b.getHouse_type() == 8) || (this.b.getHouse_type() == 2) || (this.b.getHouse_type() == 3) || (this.b.getHouse_type() == 9) || (this.b.getHouse_type() == 4)))
    {
      if ((!"房源".equals(paramString)) && (!"户型图".equals(paramString)) && (!"空气检测报告".equals(paramString))) {
        break label444;
      }
      if (this.b != null)
      {
        paramString = "";
        if (!TextUtils.isEmpty(this.b.getPrice()))
        {
          localObject = new StringBuilder().append("¥").append(this.b.getPrice()).append(this.b.getPrice_unit());
          if (!TextUtils.isEmpty(this.b.getPrice_desc())) {
            break label408;
          }
        }
      }
    }
    label408:
    for (paramString = "";; paramString = "(" + this.b.getPrice_desc() + ")")
    {
      paramString = paramString;
      String str1 = this.b.getArea() + "㎡";
      String str2 = this.b.getFloor() + "/" + this.b.getFloor_total() + "层";
      String str3 = this.b.getBedroom() + "室" + this.b.getParlor() + "厅";
      RentHouseDetail.ActivityBean localActivityBean = this.b.getActivity();
      localObject = localActivityBean;
      if (this.b.getBanner() != null)
      {
        localObject = localActivityBean;
        if (!com.freelxl.baselibrary.f.f.isNull(this.b.getBanner().getPhoto())) {
          localObject = null;
        }
      }
      localb.showHouseInfo(this.b.getName(), paramString, str1, this.b.getFace(), str2, str3, this.b.getSubway_primary(), this.b.getTags(), (RentHouseDetail.ActivityBean)localObject);
      return;
    }
    label444:
    localb.showHouseInfoSpace((RentHouseDetail.Space)this.d.get(paramString));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */