package com.ziroom.ziroomcustomer.ziroomapartment.zramain;

import com.ziroom.ziroomcustomer.b;
import com.ziroom.ziroomcustomer.home.bean.HomeRentItem;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.BannerBean.LunboBeanXXX;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.HeadBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.IconBean.LunboBeanX;
import java.util.List;

public class a
{
  static abstract interface a
    extends com.ziroom.ziroomcustomer.a
  {}
  
  static abstract interface b
    extends b<a.a>
  {
    public abstract void showBanner(List<ZraMainBean.IconBean.LunboBeanX> paramList);
    
    public abstract void showBusinessInfo(String paramString1, String paramString2);
    
    public abstract void showLunboAd(List<ZraMainBean.BannerBean.LunboBeanXXX> paramList);
    
    public abstract void showMoreZra(HomeRentItem paramHomeRentItem);
    
    public abstract void showPerson(HomeRentItem paramHomeRentItem);
    
    public abstract void showRecommendApartment(HomeRentItem paramHomeRentItem);
    
    public abstract void showRecommendHouseType(HomeRentItem paramHomeRentItem);
    
    public abstract void showSocialAc(HomeRentItem paramHomeRentItem);
    
    public abstract void showTop(ZraMainBean.HeadBean paramHeadBean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/zramain/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */