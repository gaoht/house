package com.ziroom.ziroomcustomer.newclean.periodclean.bean;

import java.util.List;

public class PeriodGeneralDetailBean
{
  private String addressId;
  private String addressName;
  private String appointDateTime;
  private ChargesBean charges;
  private String connectPhone;
  private String cyclePlanCode;
  private String employeeCode;
  private String orderNum;
  private int orderStatus;
  private String productCode;
  private String productName;
  private RecommendCoupon recommandCoupon;
  private String remark;
  private ServiceContentBean serviceContent;
  private List<ItemBean> userOrderItemVOs;
  
  public String getAddressId()
  {
    return this.addressId;
  }
  
  public String getAddressName()
  {
    return this.addressName;
  }
  
  public String getAppointDateTime()
  {
    return this.appointDateTime;
  }
  
  public ChargesBean getCharges()
  {
    return this.charges;
  }
  
  public String getConnectPhone()
  {
    return this.connectPhone;
  }
  
  public String getCyclePlanCode()
  {
    return this.cyclePlanCode;
  }
  
  public String getEmployeeCode()
  {
    return this.employeeCode;
  }
  
  public String getOrderNum()
  {
    return this.orderNum;
  }
  
  public int getOrderStatus()
  {
    return this.orderStatus;
  }
  
  public String getProductCode()
  {
    return this.productCode;
  }
  
  public String getProductName()
  {
    return this.productName;
  }
  
  public RecommendCoupon getRecommandCoupon()
  {
    return this.recommandCoupon;
  }
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public ServiceContentBean getServiceContent()
  {
    return this.serviceContent;
  }
  
  public List<ItemBean> getUserOrderItemVOs()
  {
    return this.userOrderItemVOs;
  }
  
  public void setAddressId(String paramString)
  {
    this.addressId = paramString;
  }
  
  public void setAddressName(String paramString)
  {
    this.addressName = paramString;
  }
  
  public void setAppointDateTime(String paramString)
  {
    this.appointDateTime = paramString;
  }
  
  public void setCharges(ChargesBean paramChargesBean)
  {
    this.charges = paramChargesBean;
  }
  
  public void setConnectPhone(String paramString)
  {
    this.connectPhone = paramString;
  }
  
  public void setCyclePlanCode(String paramString)
  {
    this.cyclePlanCode = paramString;
  }
  
  public void setEmployeeCode(String paramString)
  {
    this.employeeCode = paramString;
  }
  
  public void setOrderNum(String paramString)
  {
    this.orderNum = paramString;
  }
  
  public void setOrderStatus(int paramInt)
  {
    this.orderStatus = paramInt;
  }
  
  public void setProductCode(String paramString)
  {
    this.productCode = paramString;
  }
  
  public void setProductName(String paramString)
  {
    this.productName = paramString;
  }
  
  public void setRecommandCoupon(RecommendCoupon paramRecommendCoupon)
  {
    this.recommandCoupon = paramRecommendCoupon;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  public void setServiceContent(ServiceContentBean paramServiceContentBean)
  {
    this.serviceContent = paramServiceContentBean;
  }
  
  public void setUserOrderItemVOs(List<ItemBean> paramList)
  {
    this.userOrderItemVOs = paramList;
  }
  
  public static class ChargesBean
  {
    private Long discount;
    private List<ItemsBeanX> items;
    private Long needPay;
    private Long total;
    
    public Long getDiscount()
    {
      return this.discount;
    }
    
    public List<ItemsBeanX> getItems()
    {
      return this.items;
    }
    
    public Long getNeedPay()
    {
      return this.needPay;
    }
    
    public Long getTotal()
    {
      return this.total;
    }
    
    public void setDiscount(Long paramLong)
    {
      this.discount = paramLong;
    }
    
    public void setItems(List<ItemsBeanX> paramList)
    {
      this.items = paramList;
    }
    
    public void setNeedPay(Long paramLong)
    {
      this.needPay = paramLong;
    }
    
    public void setTotal(Long paramLong)
    {
      this.total = paramLong;
    }
    
    public static class ItemsBeanX
    {
      private int itemCost;
      private String itemId;
      private String itemName;
      private int itemNum;
      private int itemUnitPrice;
      
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
      
      public int getItemUnitPrice()
      {
        return this.itemUnitPrice;
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
      
      public void setItemUnitPrice(int paramInt)
      {
        this.itemUnitPrice = paramInt;
      }
    }
  }
  
  public static class ItemBean
  {
    private boolean isCanShowCoupon;
    private Integer itemAmount;
    private String itemName;
    
    public Integer getItemAmount()
    {
      return this.itemAmount;
    }
    
    public String getItemName()
    {
      return this.itemName;
    }
    
    public boolean isCanShowCoupon()
    {
      return this.isCanShowCoupon;
    }
    
    public void setCanShowCoupon(boolean paramBoolean)
    {
      this.isCanShowCoupon = paramBoolean;
    }
    
    public void setItemAmount(Integer paramInteger)
    {
      this.itemAmount = paramInteger;
    }
    
    public void setItemName(String paramString)
    {
      this.itemName = paramString;
    }
  }
  
  public static class RecommendCoupon
  {
    private String canUseCoupon;
    private String couponCode;
    private String couponId;
    
    public String getCanUseCoupon()
    {
      return this.canUseCoupon;
    }
    
    public String getCouponCode()
    {
      return this.couponCode;
    }
    
    public String getCouponId()
    {
      return this.couponId;
    }
    
    public void setCanUseCoupon(String paramString)
    {
      this.canUseCoupon = paramString;
    }
    
    public void setCouponCode(String paramString)
    {
      this.couponCode = paramString;
    }
    
    public void setCouponId(String paramString)
    {
      this.couponId = paramString;
    }
  }
  
  public static class ServiceContentBean
  {
    private String desc;
    private List<ItemsBean> items;
    
    public String getDesc()
    {
      return this.desc;
    }
    
    public List<ItemsBean> getItems()
    {
      return this.items;
    }
    
    public void setDesc(String paramString)
    {
      this.desc = paramString;
    }
    
    public void setItems(List<ItemsBean> paramList)
    {
      this.items = paramList;
    }
    
    public static class ItemsBean
    {
      private String itemId;
      private String itemName;
      
      public String getItemId()
      {
        return this.itemId;
      }
      
      public String getItemName()
      {
        return this.itemName;
      }
      
      public void setItemId(String paramString)
      {
        this.itemId = paramString;
      }
      
      public void setItemName(String paramString)
      {
        this.itemName = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/bean/PeriodGeneralDetailBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */