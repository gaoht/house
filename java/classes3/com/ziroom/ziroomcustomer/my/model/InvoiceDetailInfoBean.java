package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class InvoiceDetailInfoBean
{
  private boolean cancelApplyButton;
  private String deadLineTime;
  private String downUrl;
  private List<Bean> invoiceInfo;
  private String invoiceStatus;
  private String invoiceStatusName;
  private int invoiceType;
  private int payAmount;
  private boolean payButton;
  private int payTimeOut;
  private String receivableNum;
  private List<Bean> receiverInfo;
  private String rejectReason;
  private String systemId;
  
  public String getDeadLineTime()
  {
    return this.deadLineTime;
  }
  
  public String getDownUrl()
  {
    return this.downUrl;
  }
  
  public List<Bean> getInvoiceInfo()
  {
    return this.invoiceInfo;
  }
  
  public String getInvoiceStatus()
  {
    return this.invoiceStatus;
  }
  
  public String getInvoiceStatusName()
  {
    return this.invoiceStatusName;
  }
  
  public int getInvoiceType()
  {
    return this.invoiceType;
  }
  
  public int getPayAmount()
  {
    return this.payAmount;
  }
  
  public int getPayTimeOut()
  {
    return this.payTimeOut;
  }
  
  public String getReceivableNum()
  {
    return this.receivableNum;
  }
  
  public List<Bean> getReceiverInfo()
  {
    return this.receiverInfo;
  }
  
  public String getRejectReason()
  {
    return this.rejectReason;
  }
  
  public String getSystemId()
  {
    return this.systemId;
  }
  
  public boolean isCancelApplyButton()
  {
    return this.cancelApplyButton;
  }
  
  public boolean isPayButton()
  {
    return this.payButton;
  }
  
  public void setCancelApplyButton(boolean paramBoolean)
  {
    this.cancelApplyButton = paramBoolean;
  }
  
  public void setDeadLineTime(String paramString)
  {
    this.deadLineTime = paramString;
  }
  
  public void setDownUrl(String paramString)
  {
    this.downUrl = paramString;
  }
  
  public void setInvoiceInfo(List<Bean> paramList)
  {
    this.invoiceInfo = paramList;
  }
  
  public void setInvoiceStatus(String paramString)
  {
    this.invoiceStatus = paramString;
  }
  
  public void setInvoiceStatusName(String paramString)
  {
    this.invoiceStatusName = paramString;
  }
  
  public void setInvoiceType(int paramInt)
  {
    this.invoiceType = paramInt;
  }
  
  public void setPayAmount(int paramInt)
  {
    this.payAmount = paramInt;
  }
  
  public void setPayButton(boolean paramBoolean)
  {
    this.payButton = paramBoolean;
  }
  
  public void setPayTimeOut(int paramInt)
  {
    this.payTimeOut = paramInt;
  }
  
  public void setReceivableNum(String paramString)
  {
    this.receivableNum = paramString;
  }
  
  public void setReceiverInfo(List<Bean> paramList)
  {
    this.receiverInfo = paramList;
  }
  
  public void setRejectReason(String paramString)
  {
    this.rejectReason = paramString;
  }
  
  public void setSystemId(String paramString)
  {
    this.systemId = paramString;
  }
  
  public static class Bean
  {
    private String title;
    private String value;
    
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/InvoiceDetailInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */