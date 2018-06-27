package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuHouseDetailBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public List<BedListBean> bedList;
    public int checkInLimit;
    public String checkOutRulesTitle;
    public String communityName;
    public String curRulesType;
    public String defaultPic;
    public int evaluateCount;
    public String fid;
    public float gradeStar;
    public String houseAddr;
    public String houseName;
    public List<String> houseNameInfoList;
    public int housePrice;
    public String houseShareUrl;
    public int houseStatus;
    public int isAuth;
    public int isLock;
    public int isToNightDiscount;
    public List<LabelTipsListBean> labelTipsList;
    public String landlordIcon;
    public String landlordMobile;
    public String landlordName;
    public String landlordUid;
    public double latitude;
    public List<ListCheckRuleVoBean> listCheckRuleVo;
    public List<ListHouseFacServBean> listHouseFacServ;
    public List<ListHouseFacilitiesBean> listHouseFacilities;
    public Integer longTermDays;
    public String longTermName;
    public String longTermType;
    public double longitude;
    public MercureInfoVoBean mercureInfoVo;
    public int minDay;
    public String msgInfo;
    public int orderType;
    public String orderTypeName;
    public Integer originalPrice;
    public List<PicDisListBean> picDisList;
    public int rentWay;
    public String rentWayName;
    public int roomType;
    public String sheetsReplaceRulesName;
    public int sheetsReplaceRulesValue;
    public TenantEvalVoBean tenantEvalVo;
    public long tillDate;
    public ToNightDiscountBean toNightDiscount;
    
    public static class BedListBean
    {
      public int bedNum;
      public Object bedSize;
      public Object bedSizeName;
      public int bedType;
      public String bedTypeName;
    }
    
    public static class LabelTipsListBean
    {
      public int index;
      public String name;
      public String tipsType;
    }
    
    public static class ListCheckRuleVoBean
    {
      public int clickType;
      public String name;
      public String type;
      public String val;
    }
    
    public static class ListHouseFacServBean
    {
      public String iconThrUrl;
      public String iconTwoUrl;
      public String key;
      public List<SubEnumValsBean> subEnumVals;
      public String text;
      
      public static class SubEnumValsBean
      {
        public String iconThrUrl;
        public String iconTwoUrl;
        public String key;
        public List<?> subEnumVals;
        public String text;
      }
    }
    
    public static class ListHouseFacilitiesBean
    {
      public String iconThrUrl;
      public String iconTwoUrl;
      public String key;
      public List<?> subEnumVals;
      public String text;
    }
    
    public static class MercureInfoVoBean
    {
      public String houseAroundDesc;
      public String houseAroundTitle;
      public String houseDesc;
      public String mercureDesHouseInfo;
      public String mercureDesTitle;
      public String mercureTitle;
    }
    
    public static class PicDisListBean
    {
      public String eleKey;
      public String eleValue;
    }
    
    public static class TenantEvalVoBean
    {
      public String customerIcon;
      public String customerName;
      public String evalContent;
      public String evalDate;
      public Object landlordEvalContent;
    }
    
    public static class ToNightDiscountBean
    {
      public long deadlineRemainTime;
      public String deadlineTime;
      public String deadlineTimeTips;
      public String openTime;
      public String openTimeTips;
      public long remainTime;
      public String tipsNname;
      public float toNightDiscount;
      public int tonightPrice;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuHouseDetailBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */