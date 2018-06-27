package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuLandlordInfo
{
  public int angelLandlordOffOn;
  public Integer authCode;
  public Customer customer;
  public int isAngel;
  public int isAngelLandlord;
  public String isAuth;
  public int isFive;
  public String landlordTimeMsg;
  public String landlordUid;
  public List<Medal> medalList;
  public String medalMsgFront;
  public String medalMsgLater;
  public String phone400;
  public List<String> photoRules;
  public String picBaseAddrMona;
  public String userPicAuditMsg;
  public String userPicUrl;
  public int waitEvaNum;
  
  public static class Customer
  {
    public String customerMobile;
    public Long id;
    public Integer idType;
    public Integer isIdentityAuth;
    public String nickName;
    public String realName;
    public String uid;
  }
  
  public static class Medal
  {
    public int isLighten;
    public String medalMsg;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuLandlordInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */