package com.ziroom.ziroomcustomer.minsu.home.a;

import android.app.Activity;
import android.content.Context;
import com.freelxl.baselibrary.d.f.d;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponConfigInfoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuFirstCouponLoginBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBeanToday;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.minsu.home.b.c;

public class a
{
  private static a b;
  final com.ziroom.ziroomcustomer.flux.b a;
  
  private a(com.ziroom.ziroomcustomer.flux.b paramb)
  {
    this.a = paramb;
  }
  
  public static a getInstance(com.ziroom.ziroomcustomer.flux.b paramb)
  {
    if (b == null) {
      b = new a(paramb);
    }
    return b;
  }
  
  public void getMinSuCouponConfigInfo(final Object paramObject, Activity paramActivity)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getMinSuCouponConfigInfo(paramActivity, new t(paramActivity, new d(MinsuCouponConfigInfoBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("home_coupon_configinfo_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuCouponConfigInfoBean paramAnonymousMinsuCouponConfigInfoBean)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("home_coupon_configinfo", paramAnonymousMinsuCouponConfigInfoBean), paramObject);
      }
    });
  }
  
  public void getMinsuHomeCms(final Object paramObject, Activity paramActivity)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getHomeCms(paramActivity, new t(paramActivity, new d(com.ziroom.ziroomcustomer.minsu.home.b.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("home_cms_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.minsu.home.b.a paramAnonymousa)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("home_cms", paramAnonymousa), paramObject);
      }
    });
  }
  
  public void getMinsuHomeServer(final Object paramObject, Activity paramActivity)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.HomeServer(paramActivity, new t(paramActivity, new d(com.ziroom.ziroomcustomer.minsu.home.b.b.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("home_house_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.minsu.home.b.b paramAnonymousb)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("home_house", paramAnonymousb), paramObject);
      }
    });
  }
  
  public void getMinsuLandlordData(final Object paramObject, Activity paramActivity)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.MinsuLandlordData(paramActivity, new s(paramActivity, new r(c.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("home_landlord_status_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, c paramAnonymousc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("home_landlord_status", paramAnonymousc), paramObject);
      }
    });
  }
  
  public void getMinsuLottieData(final Object paramObject, Activity paramActivity)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getLottieData(paramActivity, new t(paramActivity, new d(MinsuFirstCouponLoginBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("home_first_lottie_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuFirstCouponLoginBean paramAnonymousMinsuFirstCouponLoginBean)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("home_first_lottie", paramAnonymousMinsuFirstCouponLoginBean), paramObject);
      }
    });
  }
  
  public void getTodaySpecial(final Object paramObject, Activity paramActivity)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.TodaySpecialList(paramActivity, new t(paramActivity, new d(MinsuHouseBeanToday.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("home_today_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseBeanToday paramAnonymousMinsuHouseBeanToday)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("home_today", paramAnonymousMinsuHouseBeanToday), paramObject);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/home/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */