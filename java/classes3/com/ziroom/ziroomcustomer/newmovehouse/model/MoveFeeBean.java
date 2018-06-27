package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.util.List;

public class MoveFeeBean
{
  private Integer canUseCoupon;
  private ChargesBean charges;
  private String couponCode;
  private String couponId;
  
  public Integer getCanUseCoupon()
  {
    return this.canUseCoupon;
  }
  
  public ChargesBean getCharges()
  {
    return this.charges;
  }
  
  public String getCouponCode()
  {
    return this.couponCode;
  }
  
  public String getCouponId()
  {
    return this.couponId;
  }
  
  public void setCanUseCoupon(Integer paramInteger)
  {
    this.canUseCoupon = paramInteger;
  }
  
  public void setCharges(ChargesBean paramChargesBean)
  {
    this.charges = paramChargesBean;
  }
  
  public void setCouponCode(String paramString)
  {
    this.couponCode = paramString;
  }
  
  public void setCouponId(String paramString)
  {
    this.couponId = paramString;
  }
  
  public static class ChargesBean
  {
    private Integer discount;
    private List<ItemsBean> items;
    private Integer needPay;
    private Integer total;
    
    public Integer getDiscount()
    {
      return this.discount;
    }
    
    public List<ItemsBean> getItems()
    {
      return this.items;
    }
    
    public Integer getNeedPay()
    {
      return this.needPay;
    }
    
    public Integer getTotal()
    {
      return this.total;
    }
    
    public void setDiscount(Integer paramInteger)
    {
      this.discount = paramInteger;
    }
    
    public void setItems(List<ItemsBean> paramList)
    {
      this.items = paramList;
    }
    
    public void setNeedPay(Integer paramInteger)
    {
      this.needPay = paramInteger;
    }
    
    public void setTotal(Integer paramInteger)
    {
      this.total = paramInteger;
    }
    
    public static class ItemsBean
    {
      private int itemCost;
      private String itemId;
      private String itemName;
      private int itemNum;
      
      public int getItemCost()
      {
        return this.itemCost;
      }
      
      public String getItemId()
      {
        return this.itemId;
      }
      
      public String getItemName()
      {
        return this.itemName;
      }
      
      public int getItemNum()
      {
        return this.itemNum;
      }
      
      public void setItemCost(int paramInt)
      {
        this.itemCost = paramInt;
      }
      
      public void setItemId(String paramString)
      {
        this.itemId = paramString;
      }
      
      public void setItemName(String paramString)
      {
        this.itemName = paramString;
      }
      
      public void setItemNum(int paramInt)
      {
        this.itemNum = paramInt;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MoveFeeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */