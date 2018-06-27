package com.ziroom.ziroomcustomer.minsu.bean;

import java.io.Serializable;
import java.util.List;

public class MinsuOrderDetailBean
  extends MinsuBaseJson
  implements Serializable
{
  public static final long serialVersionUID = -1461882270789161853L;
  public DataBean data;
  
  public String toString()
  {
    return "MinsuOrderDetailBean{data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public Integer accountsStatus;
    public String cityCode;
    public String cityName;
    public Integer couponMoney;
    public Integer depositMoney;
    public DetialFeeBean detailFee;
    public Integer discountMoney;
    public String dynaExpiredTimeStr;
    public int dynaNum;
    public String dynaPswd;
    public String endTimeStr;
    public String expireTime;
    public String houseAddr;
    public String houseFid;
    public String houseName;
    public int isHalfHoure;
    public int isLock;
    public int isOneDay;
    public String landlordMobile;
    public String landlordUid;
    public String msgInfo;
    public Integer needPay;
    public String orderSn;
    public Integer orderStatus;
    public String orderStatusName;
    public Integer orderStatusShowCode;
    public Integer otherMoney;
    public String otherMoneyDes;
    public Integer payStatus;
    public Integer penaltyMoney;
    public String persistPswd;
    public Integer persistPswdStatus;
    public String picUrl;
    public Integer preFreeHour;
    public Integer realUserMoney;
    public Integer refundMoney;
    public Integer rentWay;
    public String rentWayName;
    public Integer rentalMoney;
    public String roomName;
    public String shareLinks;
    public Integer smartLockSta;
    public String startTimeStr;
    public Integer userCommMoney;
    public String userName;
    public String userTel;
    public String userUid;
    public List<UsualContactListBean> usualContactList;
    
    public String toString()
    {
      return "DataBean{orderSn='" + this.orderSn + '\'' + ", picUrl='" + this.picUrl + '\'' + ", houseFid='" + this.houseFid + '\'' + ", houseName='" + this.houseName + '\'' + ", houseAddr='" + this.houseAddr + '\'' + ", expireTime='" + this.expireTime + '\'' + ", roomName='" + this.roomName + '\'' + ", rentWay=" + this.rentWay + ", startTimeStr='" + this.startTimeStr + '\'' + ", endTimeStr='" + this.endTimeStr + '\'' + ", userUid='" + this.userUid + '\'' + ", userTel='" + this.userTel + '\'' + ", userName='" + this.userName + '\'' + ", usualContactList=" + this.usualContactList + ", depositMoney=" + this.depositMoney + ", userCommMoney=" + this.userCommMoney + ", rentalMoney=" + this.rentalMoney + ", couponMoney=" + this.couponMoney + ", discountMoney=" + this.discountMoney + ", needPay=" + this.needPay + ", penaltyMoney=" + this.penaltyMoney + ", otherMoney=" + this.otherMoney + ", refundMoney=" + this.refundMoney + ", realUserMoney=" + this.realUserMoney + ", detailFee=" + this.detailFee + ", orderStatus=" + this.orderStatus + ", payStatus=" + this.payStatus + ", cityCode='" + this.cityCode + '\'' + ", cityName='" + this.cityName + '\'' + ", shareLinks='" + this.shareLinks + '\'' + ", orderStatusName='" + this.orderStatusName + '\'' + ", orderStatusShowCode=" + this.orderStatusShowCode + ", accountsStatus=" + this.accountsStatus + ", preFreeHour=" + this.preFreeHour + ", otherMoneyDes='" + this.otherMoneyDes + '\'' + ", landlordMobile='" + this.landlordMobile + '\'' + ", smartLockSta=" + this.smartLockSta + ", isLock=" + this.isLock + ", isOneDay=" + this.isOneDay + ", isHalfHoure=" + this.isHalfHoure + ", persistPswd='" + this.persistPswd + '\'' + ", persistPswdStatus=" + this.persistPswdStatus + ", dynaPswd='" + this.dynaPswd + '\'' + ", dynaExpiredTimeStr='" + this.dynaExpiredTimeStr + '\'' + ", dynaNum=" + this.dynaNum + '}';
    }
    
    public static class DetialFeeBean
    {
      public List<FeeItemListBean> feeItemList;
      public String feeUnit;
      public Integer totalFee;
    }
    
    public static class UsualContactListBean
    {
      public int cardType;
      public String cardValue;
      public String conName;
      public String conTel;
      public String userUid;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuOrderDetailBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */