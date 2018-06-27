package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class OwnerContractListBean
{
  public List<BeautyContractBean> beautyContract;
  public List<DeliveryBean> delivery;
  public HouseContractBean houseContract;
  public List<LoanBean> loanContract;
  public List<SupplyBean> supply;
  
  public List<BeautyContractBean> getBeautyContract()
  {
    return this.beautyContract;
  }
  
  public List<DeliveryBean> getDelivery()
  {
    return this.delivery;
  }
  
  public HouseContractBean getHouseContract()
  {
    return this.houseContract;
  }
  
  public List<LoanBean> getLoanContract()
  {
    return this.loanContract;
  }
  
  public List<SupplyBean> getSupply()
  {
    return this.supply;
  }
  
  public void setBeautyContract(List<BeautyContractBean> paramList)
  {
    this.beautyContract = paramList;
  }
  
  public void setDelivery(List<DeliveryBean> paramList)
  {
    this.delivery = paramList;
  }
  
  public void setHouseContract(HouseContractBean paramHouseContractBean)
  {
    this.houseContract = paramHouseContractBean;
  }
  
  public void setLoanContract(List<LoanBean> paramList)
  {
    this.loanContract = paramList;
  }
  
  public void setSupply(List<SupplyBean> paramList)
  {
    this.supply = paramList;
  }
  
  public static class BeautyContractBean
  {
    public String beautyContractCode;
    public String contractCode;
    public String contractStatus;
    public String contractUrl;
    public List<OwnerContractListBean.DataBean> data;
    public boolean invoiceApply;
    public String statusName;
    
    public String getContractCode()
    {
      return this.contractCode;
    }
    
    public String getContractStatus()
    {
      return this.contractStatus;
    }
    
    public String getContractUrl()
    {
      return this.contractUrl;
    }
    
    public List<OwnerContractListBean.DataBean> getData()
    {
      return this.data;
    }
    
    public String getStatusName()
    {
      return this.statusName;
    }
    
    public void setContractCode(String paramString)
    {
      this.contractCode = paramString;
    }
    
    public void setContractStatus(String paramString)
    {
      this.contractStatus = paramString;
    }
    
    public void setContractUrl(String paramString)
    {
      this.contractUrl = paramString;
    }
    
    public void setData(List<OwnerContractListBean.DataBean> paramList)
    {
      this.data = paramList;
    }
    
    public void setStatusName(String paramString)
    {
      this.statusName = paramString;
    }
  }
  
  public static class DataBean
  {
    public String title;
    public String value;
    
    public String getTitle()
    {
      return this.title;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
  }
  
  public static class DeliveryBean
  {
    public String contractCode;
    public String contractStatus;
    public List<OwnerContractListBean.DataBean> data;
    public String statusName;
    
    public String getContractCode()
    {
      return this.contractCode;
    }
    
    public String getContractStatus()
    {
      return this.contractStatus;
    }
    
    public List<OwnerContractListBean.DataBean> getData()
    {
      return this.data;
    }
    
    public String getStatusName()
    {
      return this.statusName;
    }
    
    public void setContractCode(String paramString)
    {
      this.contractCode = paramString;
    }
    
    public void setContractStatus(String paramString)
    {
      this.contractStatus = paramString;
    }
    
    public void setData(List<OwnerContractListBean.DataBean> paramList)
    {
      this.data = paramList;
    }
    
    public void setStatusName(String paramString)
    {
      this.statusName = paramString;
    }
  }
  
  public static class HouseContractBean
  {
    public String contractCode;
    public String contractStatus;
    public String createTime;
    public List<OwnerContractListBean.DataBean> data;
    public String houseAddress;
    public String lastPageValue;
    public String productType;
    public String statusName;
    
    public String getContractCode()
    {
      return this.contractCode;
    }
    
    public String getContractStatus()
    {
      return this.contractStatus;
    }
    
    public String getCreateTime()
    {
      return this.createTime;
    }
    
    public List<OwnerContractListBean.DataBean> getData()
    {
      return this.data;
    }
    
    public String getHouseAddress()
    {
      return this.houseAddress;
    }
    
    public String getLastPageValue()
    {
      return this.lastPageValue;
    }
    
    public String getProductType()
    {
      return this.productType;
    }
    
    public String getStatusName()
    {
      return this.statusName;
    }
    
    public void setContractCode(String paramString)
    {
      this.contractCode = paramString;
    }
    
    public void setContractStatus(String paramString)
    {
      this.contractStatus = paramString;
    }
    
    public void setCreateTime(String paramString)
    {
      this.createTime = paramString;
    }
    
    public void setData(List<OwnerContractListBean.DataBean> paramList)
    {
      this.data = paramList;
    }
    
    public void setHouseAddress(String paramString)
    {
      this.houseAddress = paramString;
    }
    
    public void setLastPageValue(String paramString)
    {
      this.lastPageValue = paramString;
    }
    
    public void setProductType(String paramString)
    {
      this.productType = paramString;
    }
    
    public void setStatusName(String paramString)
    {
      this.statusName = paramString;
    }
  }
  
  public static class LoanBean
  {
    private String contractStatus;
    private String contractUrl;
    private List<OwnerContractListBean.DataBean> data;
    private String isPdf;
    private String loanContractCode;
    private String payPlanUrl;
    private String statusName;
    
    public String getContractStatus()
    {
      return this.contractStatus;
    }
    
    public String getContractUrl()
    {
      return this.contractUrl;
    }
    
    public List<OwnerContractListBean.DataBean> getData()
    {
      return this.data;
    }
    
    public String getIsPdf()
    {
      return this.isPdf;
    }
    
    public String getLoanContractCode()
    {
      return this.loanContractCode;
    }
    
    public String getPayPlanUrl()
    {
      return this.payPlanUrl;
    }
    
    public String getStatusName()
    {
      return this.statusName;
    }
    
    public void setContractStatus(String paramString)
    {
      this.contractStatus = paramString;
    }
    
    public void setContractUrl(String paramString)
    {
      this.contractUrl = paramString;
    }
    
    public void setData(List<OwnerContractListBean.DataBean> paramList)
    {
      this.data = paramList;
    }
    
    public void setIsPdf(String paramString)
    {
      this.isPdf = paramString;
    }
    
    public void setLoanContractCode(String paramString)
    {
      this.loanContractCode = paramString;
    }
    
    public void setPayPlanUrl(String paramString)
    {
      this.payPlanUrl = paramString;
    }
    
    public void setStatusName(String paramString)
    {
      this.statusName = paramString;
    }
  }
  
  public static class SupplyBean
  {
    public String contractCode;
    public String contractStatus;
    public String contractUrl;
    public List<OwnerContractListBean.DataBean> data;
    public String statusName;
    
    public String getContractCode()
    {
      return this.contractCode;
    }
    
    public String getContractStatus()
    {
      return this.contractStatus;
    }
    
    public String getContractUrl()
    {
      return this.contractUrl;
    }
    
    public List<OwnerContractListBean.DataBean> getData()
    {
      return this.data;
    }
    
    public String getStatusName()
    {
      return this.statusName;
    }
    
    public void setContractCode(String paramString)
    {
      this.contractCode = paramString;
    }
    
    public void setContractStatus(String paramString)
    {
      this.contractStatus = paramString;
    }
    
    public void setContractUrl(String paramString)
    {
      this.contractUrl = paramString;
    }
    
    public void setData(List<OwnerContractListBean.DataBean> paramList)
    {
      this.data = paramList;
    }
    
    public void setStatusName(String paramString)
    {
      this.statusName = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/OwnerContractListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */