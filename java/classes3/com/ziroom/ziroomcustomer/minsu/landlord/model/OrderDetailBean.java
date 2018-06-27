package com.ziroom.ziroomcustomer.minsu.landlord.model;

import java.util.List;

public class OrderDetailBean
{
  private String acceptConfirmMsg;
  private String[] buttonNames;
  private RuleItem checkOutRule;
  private ContactBean contacts;
  private String createTime;
  private DepositMoneyBean depositMoney;
  private TimeItem endTime;
  private float evaAva = -1.0F;
  private String feeUnit;
  private String houseFid;
  private String houseName;
  private String landlordUid;
  private List<MoneyItem> moneyItems;
  private OrderIncome orderIncome;
  private MoneyItem orderPenalty;
  private String orderSn;
  private int orderStatus;
  private String orderStatusName;
  private String orderTitle;
  private String otherHasMoneyConfirmMsg;
  private OtherMoneyBean otherMoney;
  private String otherNoMoneyConfirmMsg;
  private int payStatus;
  private RemarkBean remarks;
  private int rentWay;
  private String roomFid;
  private TimeItem startTime;
  private BaseItem tripPurpose;
  private int userEvaTotal = -1;
  private String userHeadPic;
  private String userInfoUrl;
  private String userName;
  private String userTel;
  private String userUid;
  
  public String getAcceptConfirmMsg()
  {
    return this.acceptConfirmMsg;
  }
  
  public String[] getButtonNames()
  {
    return this.buttonNames;
  }
  
  public RuleItem getCheckOutRule()
  {
    return this.checkOutRule;
  }
  
  public ContactBean getContacts()
  {
    return this.contacts;
  }
  
  public String getCreateTime()
  {
    return this.createTime;
  }
  
  public DepositMoneyBean getDepositMoney()
  {
    return this.depositMoney;
  }
  
  public TimeItem getEndTime()
  {
    return this.endTime;
  }
  
  public float getEvaAva()
  {
    return this.evaAva;
  }
  
  public String getFeeUnit()
  {
    return this.feeUnit;
  }
  
  public String getHouseFid()
  {
    return this.houseFid;
  }
  
  public String getHouseName()
  {
    return this.houseName;
  }
  
  public String getLandlordUid()
  {
    return this.landlordUid;
  }
  
  public List<MoneyItem> getMoneyItems()
  {
    return this.moneyItems;
  }
  
  public OrderIncome getOrderIncome()
  {
    return this.orderIncome;
  }
  
  public MoneyItem getOrderPenalty()
  {
    return this.orderPenalty;
  }
  
  public String getOrderSn()
  {
    return this.orderSn;
  }
  
  public int getOrderStatus()
  {
    return this.orderStatus;
  }
  
  public String getOrderStatusName()
  {
    return this.orderStatusName;
  }
  
  public String getOrderTitle()
  {
    return this.orderTitle;
  }
  
  public String getOtherHasMoneyConfirmMsg()
  {
    return this.otherHasMoneyConfirmMsg;
  }
  
  public OtherMoneyBean getOtherMoney()
  {
    return this.otherMoney;
  }
  
  public String getOtherNoMoneyConfirmMsg()
  {
    return this.otherNoMoneyConfirmMsg;
  }
  
  public int getPayStatus()
  {
    return this.payStatus;
  }
  
  public RemarkBean getRemarks()
  {
    return this.remarks;
  }
  
  public int getRentWay()
  {
    return this.rentWay;
  }
  
  public String getRoomFid()
  {
    return this.roomFid;
  }
  
  public TimeItem getStartTime()
  {
    return this.startTime;
  }
  
  public BaseItem getTripPurpose()
  {
    return this.tripPurpose;
  }
  
  public int getUserEvaTotal()
  {
    return this.userEvaTotal;
  }
  
  public String getUserHeadPic()
  {
    return this.userHeadPic;
  }
  
  public String getUserInfoUrl()
  {
    return this.userInfoUrl;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public String getUserTel()
  {
    return this.userTel;
  }
  
  public String getUserUid()
  {
    return this.userUid;
  }
  
  public void setAcceptConfirmMsg(String paramString)
  {
    this.acceptConfirmMsg = paramString;
  }
  
  public void setButtonNames(String[] paramArrayOfString)
  {
    this.buttonNames = paramArrayOfString;
  }
  
  public void setCheckOutRule(RuleItem paramRuleItem)
  {
    this.checkOutRule = paramRuleItem;
  }
  
  public void setContacts(ContactBean paramContactBean)
  {
    this.contacts = paramContactBean;
  }
  
  public void setCreateTime(String paramString)
  {
    this.createTime = paramString;
  }
  
  public void setDepositMoney(DepositMoneyBean paramDepositMoneyBean)
  {
    this.depositMoney = paramDepositMoneyBean;
  }
  
  public void setEndTime(TimeItem paramTimeItem)
  {
    this.endTime = paramTimeItem;
  }
  
  public void setEvaAva(float paramFloat)
  {
    this.evaAva = paramFloat;
  }
  
  public void setFeeUnit(String paramString)
  {
    this.feeUnit = paramString;
  }
  
  public void setHouseFid(String paramString)
  {
    this.houseFid = paramString;
  }
  
  public void setHouseName(String paramString)
  {
    this.houseName = paramString;
  }
  
  public void setLandlordUid(String paramString)
  {
    this.landlordUid = paramString;
  }
  
  public void setMoneyItems(List<MoneyItem> paramList)
  {
    this.moneyItems = paramList;
  }
  
  public void setOrderIncome(OrderIncome paramOrderIncome)
  {
    this.orderIncome = paramOrderIncome;
  }
  
  public void setOrderPenalty(MoneyItem paramMoneyItem)
  {
    this.orderPenalty = paramMoneyItem;
  }
  
  public void setOrderSn(String paramString)
  {
    this.orderSn = paramString;
  }
  
  public void setOrderStatus(int paramInt)
  {
    this.orderStatus = paramInt;
  }
  
  public void setOrderStatusName(String paramString)
  {
    this.orderStatusName = paramString;
  }
  
  public void setOrderTitle(String paramString)
  {
    this.orderTitle = paramString;
  }
  
  public void setOtherHasMoneyConfirmMsg(String paramString)
  {
    this.otherHasMoneyConfirmMsg = paramString;
  }
  
  public void setOtherMoney(OtherMoneyBean paramOtherMoneyBean)
  {
    this.otherMoney = paramOtherMoneyBean;
  }
  
  public void setOtherNoMoneyConfirmMsg(String paramString)
  {
    this.otherNoMoneyConfirmMsg = paramString;
  }
  
  public void setPayStatus(int paramInt)
  {
    this.payStatus = paramInt;
  }
  
  public void setRemarks(RemarkBean paramRemarkBean)
  {
    this.remarks = paramRemarkBean;
  }
  
  public void setRentWay(int paramInt)
  {
    this.rentWay = paramInt;
  }
  
  public void setRoomFid(String paramString)
  {
    this.roomFid = paramString;
  }
  
  public void setStartTime(TimeItem paramTimeItem)
  {
    this.startTime = paramTimeItem;
  }
  
  public void setTripPurpose(BaseItem paramBaseItem)
  {
    this.tripPurpose = paramBaseItem;
  }
  
  public void setUserEvaTotal(int paramInt)
  {
    this.userEvaTotal = paramInt;
  }
  
  public void setUserHeadPic(String paramString)
  {
    this.userHeadPic = paramString;
  }
  
  public void setUserInfoUrl(String paramString)
  {
    this.userInfoUrl = paramString;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public void setUserTel(String paramString)
  {
    this.userTel = paramString;
  }
  
  public void setUserUid(String paramString)
  {
    this.userUid = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/model/OrderDetailBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */