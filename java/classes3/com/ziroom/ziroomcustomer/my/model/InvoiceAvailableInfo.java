package com.ziroom.ziroomcustomer.my.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InvoiceAvailableInfo
  implements Serializable
{
  private List<BusInvoiceType> busInvoiceTypeList;
  private String contractCode;
  private String invoiceTitle;
  private ArrayList<RegionBean> region;
  private int type;
  
  public List<BusInvoiceType> getBusInvoiceTypeList()
  {
    return this.busInvoiceTypeList;
  }
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public String getInvoiceTitle()
  {
    return this.invoiceTitle;
  }
  
  public ArrayList<RegionBean> getRegion()
  {
    return this.region;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setBusInvoiceTypeList(List<BusInvoiceType> paramList)
  {
    this.busInvoiceTypeList = paramList;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setInvoiceTitle(String paramString)
  {
    this.invoiceTitle = paramString;
  }
  
  public void setRegion(ArrayList<RegionBean> paramArrayList)
  {
    this.region = paramArrayList;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static class BusInvoiceType
  {
    int invoiceMount;
    List<InvoiceAvailableInfo.InvoiceTypeInfo> invoiceTypeInfolist;
    ArrayList<InvoiceAvailableInfo.MonthInfo> mounthList;
    String name;
    int taxPoint;
    int type;
    
    public int getInvoiceMount()
    {
      return this.invoiceMount;
    }
    
    public List<InvoiceAvailableInfo.InvoiceTypeInfo> getInvoiceTypeInfolist()
    {
      return this.invoiceTypeInfolist;
    }
    
    public ArrayList<InvoiceAvailableInfo.MonthInfo> getMounthList()
    {
      return this.mounthList;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public int getTaxPoint()
    {
      return this.taxPoint;
    }
    
    public int getType()
    {
      return this.type;
    }
    
    public void setInvoiceMount(int paramInt)
    {
      this.invoiceMount = paramInt;
    }
    
    public void setInvoiceTypeInfolist(List<InvoiceAvailableInfo.InvoiceTypeInfo> paramList)
    {
      this.invoiceTypeInfolist = paramList;
    }
    
    public void setMounthList(ArrayList<InvoiceAvailableInfo.MonthInfo> paramArrayList)
    {
      this.mounthList = paramArrayList;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setTaxPoint(int paramInt)
    {
      this.taxPoint = paramInt;
    }
    
    public void setType(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  public static class InvoiceTypeInfo
    implements Serializable
  {
    private boolean authNeed;
    private int invoiceTypeCode;
    private String invoiceTypeName;
    
    public int getInvoiceTypeCode()
    {
      return this.invoiceTypeCode;
    }
    
    public String getInvoiceTypeName()
    {
      return this.invoiceTypeName;
    }
    
    public boolean isAuthNeed()
    {
      return this.authNeed;
    }
    
    public void setAuthNeed(boolean paramBoolean)
    {
      this.authNeed = paramBoolean;
    }
    
    public void setInvoiceTypeCode(int paramInt)
    {
      this.invoiceTypeCode = paramInt;
    }
    
    public void setInvoiceTypeName(String paramString)
    {
      this.invoiceTypeName = paramString;
    }
  }
  
  public static class MonthInfo
    implements Serializable
  {
    private String endTime;
    private int monthAmount;
    private String monthNum;
    private int monthTaxAmount;
    private int periodTotalAmount;
    private String startTime;
    
    public String getEndTime()
    {
      return this.endTime;
    }
    
    public int getMonthAmount()
    {
      return this.monthAmount;
    }
    
    public String getMonthNum()
    {
      return this.monthNum;
    }
    
    public int getMonthTaxAmount()
    {
      return this.monthTaxAmount;
    }
    
    public int getPeriodTotalAmount()
    {
      return this.periodTotalAmount;
    }
    
    public String getStartTime()
    {
      return this.startTime;
    }
    
    public void setEndTime(String paramString)
    {
      this.endTime = paramString;
    }
    
    public void setMonthAmount(int paramInt)
    {
      this.monthAmount = paramInt;
    }
    
    public void setMonthNum(String paramString)
    {
      this.monthNum = paramString;
    }
    
    public void setMonthTaxAmount(int paramInt)
    {
      this.monthTaxAmount = paramInt;
    }
    
    public void setPeriodTotalAmount(int paramInt)
    {
      this.periodTotalAmount = paramInt;
    }
    
    public void setStartTime(String paramString)
    {
      this.startTime = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/InvoiceAvailableInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */