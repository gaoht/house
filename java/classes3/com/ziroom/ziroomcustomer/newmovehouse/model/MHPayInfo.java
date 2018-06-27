package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.io.Serializable;

public class MHPayInfo
  implements Serializable
{
  private String billId;
  private String end;
  private int money;
  private String moveDate;
  private String orderCode;
  private String start;
  private String terminalType;
  private String userId;
  private String userName;
  
  public MHPayInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.userId = paramString1;
    this.billId = paramString2;
    this.money = paramInt;
    this.terminalType = paramString3;
    this.userName = paramString4;
    this.orderCode = paramString5;
    this.moveDate = paramString6;
    this.start = paramString7;
    this.end = paramString8;
  }
  
  public String getBillId()
  {
    return this.billId;
  }
  
  public String getEnd()
  {
    return this.end;
  }
  
  public int getMoney()
  {
    return this.money;
  }
  
  public String getMoveDate()
  {
    return this.moveDate;
  }
  
  public String getOrderCode()
  {
    return this.orderCode;
  }
  
  public String getStart()
  {
    return this.start;
  }
  
  public String getTerminalType()
  {
    return this.terminalType;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setMoney(int paramInt)
  {
    this.money = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MHPayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */