package com.ziroom.ziroomcustomer.minsu.bean;

import android.text.TextUtils;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.bean.MinsuMapBuildBean;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.bean.ZryMapItembean;
import java.io.Serializable;
import java.util.List;

public class MinsuHouseBean
  extends MinsuBaseJson
  implements Serializable
{
  public DataBean data;
  
  public static class DataBean
    implements Serializable
  {
    public List<MinsuHouseBannerBean> bannerList;
    public CityCardBean cityCard;
    public List<GuideCardBean> guideCard;
    public List<ListBean> list;
    public List<ListBean> suggest;
    public String suggestMsg;
    public int total;
    public int ziruyiCount;
    public List<ZryMapItembean> ziruyiList;
    
    public static class CityCardBean
      implements Serializable
    {
      public String cityCode;
      public String colBackColor;
      public String colDeputyTitle;
      public String colShareTitle;
      public String colTitle;
      public int index;
      public List<RegionListBean> regionList;
      
      public static class RegionListBean
        implements Serializable
      {
        public String picSrc;
        public String regionBrief;
        public String regionName;
        public String standbyField;
        public String targetUrl;
      }
    }
    
    public static class GuideCardBean
      implements Serializable
    {
      public int code;
      public String describe;
      public int index;
      public boolean isShow;
      public String subTitle;
      public String title;
    }
    
    public static class ListBean
      implements Serializable
    {
      public static final int ORDER_TYPE_NORMAL = 2;
      public static final int ORDER_TYPE_RESERVE = 1;
      public int balconyCount;
      public List<BedListBean> bedList;
      public List<?> brotherBeds;
      public List<?> brotherRooms;
      public String cityCode;
      public String cityName;
      public String description;
      public String dist;
      public int evaluateCount;
      public String fid;
      public String houseAddr;
      public MinsuHouseBannerBean houseBannerBean;
      public String houseName;
      public int houseStatus;
      public int houseType;
      public String houseTypeName;
      public int isAvailable;
      public int isBalcony;
      public int isCollect;
      public int isLock;
      public int isToNightDiscount;
      public int isToilet;
      public int isTop50Online;
      public List<LabelInfo> labelInfoList;
      public List<LabelTips> labelTipsList;
      public String landlordUid;
      public String landlordUrl;
      public String loc;
      public LocRepeatVo locRepeatVo;
      public String nickName;
      public int orderType;
      public String orderTypeName;
      public int originalPrice;
      public int personCount;
      public String picUrl;
      public int price;
      public float realEvaluateScore;
      public int rentWay;
      public String rentWayName;
      public int roomCount;
      public List<?> rooms;
      public int toiletCount;
      public TonightDiscountInfoVoBean tonightDiscountInfoVo;
      public int type;
      public long updateTime;
      public int weights;
      
      public MinsuMapBuildBean convertMapBean(boolean paramBoolean)
      {
        MinsuMapBuildBean localMinsuMapBuildBean = new MinsuMapBuildBean();
        localMinsuMapBuildBean.setFidrentway(this.fid + this.rentWay);
        localMinsuMapBuildBean.orderType = this.orderType;
        if (this.locRepeatVo == null)
        {
          if (this.isToNightDiscount == 1) {
            localMinsuMapBuildBean.setName("今夜特价");
          }
          for (;;)
          {
            localMinsuMapBuildBean.setNum(String.valueOf(this.price / 100));
            localMinsuMapBuildBean.setRepeatRoom(false);
            localMinsuMapBuildBean.setValidLevel(paramBoolean);
            try
            {
              if (!TextUtils.isEmpty(this.loc))
              {
                localObject = this.loc.split(",");
                if (localObject.length == 2)
                {
                  localMinsuMapBuildBean.setLatitude(Double.parseDouble(localObject[0]));
                  localMinsuMapBuildBean.setLongitude(Double.parseDouble(localObject[1]));
                }
              }
              return localMinsuMapBuildBean;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              Object localObject;
              localNumberFormatException.printStackTrace();
            }
            localMinsuMapBuildBean.setName(this.rentWayName);
          }
        }
        if (this.locRepeatVo.priceStr == null)
        {
          localObject = "";
          label161:
          localMinsuMapBuildBean.setName((String)localObject);
          if (this.locRepeatVo.sizeStr != null) {
            break label203;
          }
        }
        label203:
        for (localObject = "";; localObject = this.locRepeatVo.sizeStr)
        {
          localMinsuMapBuildBean.setNum((String)localObject);
          localMinsuMapBuildBean.setRepeatRoom(true);
          break;
          localObject = this.locRepeatVo.priceStr;
          break label161;
        }
        return localMinsuMapBuildBean;
      }
      
      public MinsuMapBuildBean convertMapBean(boolean paramBoolean1, boolean paramBoolean2)
      {
        MinsuMapBuildBean localMinsuMapBuildBean = new MinsuMapBuildBean();
        localMinsuMapBuildBean.setFidrentway(this.fid + this.rentWay);
        if ((paramBoolean2) && (this.isToNightDiscount == 1)) {
          localMinsuMapBuildBean.setName("今夜特价");
        }
        for (;;)
        {
          localMinsuMapBuildBean.setNum(String.valueOf(this.price / 100));
          localMinsuMapBuildBean.setValidLevel(paramBoolean1);
          try
          {
            if (!TextUtils.isEmpty(this.loc))
            {
              String[] arrayOfString = this.loc.split(",");
              if (arrayOfString.length == 2)
              {
                localMinsuMapBuildBean.setLatitude(Double.parseDouble(arrayOfString[0]));
                localMinsuMapBuildBean.setLongitude(Double.parseDouble(arrayOfString[1]));
              }
            }
            return localMinsuMapBuildBean;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
          localMinsuMapBuildBean.setName(this.rentWayName);
        }
        return localMinsuMapBuildBean;
      }
      
      public static class BedListBean
        implements Serializable
      {
        public String name;
        public String num;
        public String type;
      }
      
      public static class LabelInfo
        implements Serializable
      {
        public String code;
        public String iconUrl;
        public Object index;
        public String name;
      }
      
      public static class LabelInfoListBean
        implements Serializable
      {
        public String code;
        public String iconUrl;
        public int index;
        public String name;
      }
      
      public static class LabelTips
        implements Serializable
      {
        public Object index;
        public String name;
        public String tipsType;
      }
      
      public static class LocRepeatVo
      {
        public List<MinsuHouseBean.DataBean.ListBean> locRepeatList;
        public String priceStr;
        public String sizeStr;
      }
      
      public static class TonightDiscountInfoVoBean
        implements Serializable
      {
        public long deadlineRemainTime;
        public String deadlineTime;
        public String deadlineTimeListTips;
        public String deadlineTimeTips;
        public String openTime;
        public String openTimeListTips;
        public String openTimeTips;
        public long remainTime;
        public String tipsNname;
        public float tonightDiscount;
        public int tonightPrice;
        
        public long getDeadlineRemainTime()
        {
          return this.deadlineRemainTime;
        }
        
        public String getDeadlineTime()
        {
          return this.deadlineTime;
        }
        
        public String getDeadlineTimeListTips()
        {
          return this.deadlineTimeListTips;
        }
        
        public String getDeadlineTimeTips()
        {
          return this.deadlineTimeTips;
        }
        
        public String getOpenTime()
        {
          return this.openTime;
        }
        
        public String getOpenTimeListTips()
        {
          return this.openTimeListTips;
        }
        
        public String getOpenTimeTips()
        {
          return this.openTimeTips;
        }
        
        public long getRemainTime()
        {
          return this.remainTime;
        }
        
        public String getTipsNname()
        {
          return this.tipsNname;
        }
        
        public float getTonightDiscount()
        {
          return this.tonightDiscount;
        }
        
        public int getTonightPrice()
        {
          return this.tonightPrice;
        }
        
        public void setDeadlineRemainTime(long paramLong)
        {
          this.deadlineRemainTime = paramLong;
        }
        
        public void setDeadlineTime(String paramString)
        {
          this.deadlineTime = paramString;
        }
        
        public void setDeadlineTimeListTips(String paramString)
        {
          this.deadlineTimeListTips = paramString;
        }
        
        public void setDeadlineTimeTips(String paramString)
        {
          this.deadlineTimeTips = paramString;
        }
        
        public void setOpenTime(String paramString)
        {
          this.openTime = paramString;
        }
        
        public void setOpenTimeListTips(String paramString)
        {
          this.openTimeListTips = paramString;
        }
        
        public void setOpenTimeTips(String paramString)
        {
          this.openTimeTips = paramString;
        }
        
        public void setRemainTime(long paramLong)
        {
          this.remainTime = paramLong;
        }
        
        public void setTipsNname(String paramString)
        {
          this.tipsNname = paramString;
        }
        
        public void setTonightDiscount(float paramFloat)
        {
          this.tonightDiscount = paramFloat;
        }
        
        public void setTonightPrice(int paramInt)
        {
          this.tonightPrice = paramInt;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuHouseBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */