package com.ziroom.ziroomcustomer.my.model;

import java.io.Serializable;
import java.util.List;

public class MyRentEvaluateListEntity
  implements Serializable
{
  private String butStr;
  private String evaluateType;
  private KeeperInfo keeperInfo;
  private String orderCode;
  private List<OrderInfo> orderInfo;
  private String orderName;
  private String orderState;
  
  public String getButStr()
  {
    return this.butStr;
  }
  
  public String getEvaluateType()
  {
    return this.evaluateType;
  }
  
  public KeeperInfo getKeeperInfo()
  {
    return this.keeperInfo;
  }
  
  public String getOrderCode()
  {
    return this.orderCode;
  }
  
  public List<OrderInfo> getOrderInfo()
  {
    return this.orderInfo;
  }
  
  public String getOrderName()
  {
    return this.orderName;
  }
  
  public String getOrderState()
  {
    return this.orderState;
  }
  
  public void setButStr(String paramString)
  {
    this.butStr = paramString;
  }
  
  public void setEvaluateType(String paramString)
  {
    this.evaluateType = paramString;
  }
  
  public void setKeeperInfo(KeeperInfo paramKeeperInfo)
  {
    this.keeperInfo = paramKeeperInfo;
  }
  
  public void setOrderCode(String paramString)
  {
    this.orderCode = paramString;
  }
  
  public void setOrderInfo(List<OrderInfo> paramList)
  {
    this.orderInfo = paramList;
  }
  
  public void setOrderName(String paramString)
  {
    this.orderName = paramString;
  }
  
  public void setOrderState(String paramString)
  {
    this.orderState = paramString;
  }
  
  public class KeeperInfo
  {
    private String keeperPhoto;
    private String keeperStr;
    
    public KeeperInfo() {}
    
    public String getKeeperPhoto()
    {
      return this.keeperPhoto;
    }
    
    public String getKeeperStr()
    {
      return this.keeperStr;
    }
    
    public void setKeeperPhoto(String paramString)
    {
      this.keeperPhoto = paramString;
    }
    
    public void setKeeperStr(String paramString)
    {
      this.keeperStr = paramString;
    }
  }
  
  public class OrderInfo
  {
    private String code;
    private String value;
    
    public OrderInfo() {}
    
    public String getCode()
    {
      return this.code;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public void setCode(String paramString)
    {
      this.code = paramString;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/MyRentEvaluateListEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */