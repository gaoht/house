package com.ziroom.ziroomcustomer.minsu.home.c;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponConfigInfoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuFirstCouponLoginBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBeanToday;
import com.ziroom.ziroomcustomer.minsu.home.b.b;

public class a
  extends com.ziroom.ziroomcustomer.flux.c
{
  private b b;
  private com.ziroom.ziroomcustomer.minsu.home.b.a c;
  private MinsuHouseBeanToday d;
  private com.ziroom.ziroomcustomer.minsu.home.b.c e;
  private MinsuCouponConfigInfoBean f;
  private MinsuFirstCouponLoginBean g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  
  public a() {}
  
  public a(Object paramObject)
  {
    super(paramObject);
  }
  
  public MinsuFirstCouponLoginBean getHomeFirstCouponLoginBean()
  {
    return this.g;
  }
  
  public com.ziroom.ziroomcustomer.minsu.home.b.a getmHomeCmsBean()
  {
    return this.c;
  }
  
  public MinsuCouponConfigInfoBean getmHomeCouponConfigInfoBean()
  {
    return this.f;
  }
  
  public b getmHomeHouseBean()
  {
    return this.b;
  }
  
  public com.ziroom.ziroomcustomer.minsu.home.b.c getmHomeLandlordBean()
  {
    return this.e;
  }
  
  public MinsuHouseBeanToday getmHomeTodayBean()
  {
    return this.d;
  }
  
  public void onAction(com.ziroom.ziroomcustomer.flux.a parama)
  {
    String str = parama.getType();
    int n = -1;
    switch (str.hashCode())
    {
    default: 
      switch (n)
      {
      }
      break;
    }
    for (;;)
    {
      a(new com.ziroom.ziroomcustomer.flux.a.a(parama.getType()));
      return;
      if (!str.equals("home_cms")) {
        break;
      }
      n = 0;
      break;
      if (!str.equals("home_house")) {
        break;
      }
      n = 1;
      break;
      if (!str.equals("home_today")) {
        break;
      }
      n = 2;
      break;
      if (!str.equals("home_landlord_status")) {
        break;
      }
      n = 3;
      break;
      if (!str.equals("home_cms_error")) {
        break;
      }
      n = 4;
      break;
      if (!str.equals("home_house_error")) {
        break;
      }
      n = 5;
      break;
      if (!str.equals("home_today_error")) {
        break;
      }
      n = 6;
      break;
      if (!str.equals("home_landlord_status_error")) {
        break;
      }
      n = 7;
      break;
      if (!str.equals("home_coupon_configinfo")) {
        break;
      }
      n = 8;
      break;
      if (!str.equals("home_coupon_configinfo_error")) {
        break;
      }
      n = 9;
      break;
      if (!str.equals("home_first_lottie")) {
        break;
      }
      n = 10;
      break;
      if (!str.equals("home_first_lottie_error")) {
        break;
      }
      n = 11;
      break;
      this.c = ((com.ziroom.ziroomcustomer.minsu.home.b.a)parama.getData());
      continue;
      this.b = ((b)parama.getData());
      continue;
      this.d = ((MinsuHouseBeanToday)parama.getData());
      continue;
      this.e = ((com.ziroom.ziroomcustomer.minsu.home.b.c)parama.getData());
      continue;
      this.h = ((String)parama.getData());
      continue;
      this.i = ((String)parama.getData());
      continue;
      this.j = ((String)parama.getData());
      continue;
      this.k = ((String)parama.getData());
      continue;
      this.f = ((MinsuCouponConfigInfoBean)parama.getData());
      continue;
      this.l = ((String)parama.getData());
      continue;
      this.g = ((MinsuFirstCouponLoginBean)parama.getData());
      continue;
      this.m = ((String)parama.getData());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/home/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */