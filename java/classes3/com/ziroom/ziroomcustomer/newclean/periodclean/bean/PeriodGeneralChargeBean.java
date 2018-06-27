package com.ziroom.ziroomcustomer.newclean.periodclean.bean;

import java.util.List;

public class PeriodGeneralChargeBean
{
  private Integer canUseCoupon;
  private ChargesBean charges;
  
  public Integer getCanUseCoupon()
  {
    return this.canUseCoupon;
  }
  
  public ChargesBean getCharges()
  {
    return this.charges;
  }
  
  public void setCanUseCoupon(Integer paramInteger)
  {
    this.canUseCoupon = paramInteger;
  }
  
  public void setCharges(ChargesBean paramChargesBean)
  {
    this.charges = paramChargesBean;
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
      private Integer itemCost;
      private String itemId;
      private String itemName;
      private int itemNum;
      private int itemUnitPrice;
      
      public Integer getItemCost()
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
      
      public int getItemUnitPrice()
      {
        return this.itemUnitPrice;
      }
      
      public void setItemCost(Integer paramInteger)
      {
        this.itemCost = paramInteger;
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
      
      public void setItemUnitPrice(int paramInt)
      {
        this.itemUnitPrice = paramInt;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/bean/PeriodGeneralChargeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */