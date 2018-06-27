package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ReFundWayModel
  extends b
{
  public DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public static class DataBean
  {
    public List<ListBean> list;
    public String refundNotice;
    public String refundRule;
    public int refundWay;
    
    public List<ListBean> getList()
    {
      return this.list;
    }
    
    public String getRefundNotice()
    {
      return this.refundNotice;
    }
    
    public String getRefundRule()
    {
      return this.refundRule;
    }
    
    public int getRefundWay()
    {
      return this.refundWay;
    }
    
    public void setList(List<ListBean> paramList)
    {
      this.list = paramList;
    }
    
    public void setRefundNotice(String paramString)
    {
      this.refundNotice = paramString;
    }
    
    public void setRefundRule(String paramString)
    {
      this.refundRule = paramString;
    }
    
    public void setRefundWay(int paramInt)
    {
      this.refundWay = paramInt;
    }
    
    public static class ListBean
    {
      public String amount;
      public List<AmountInfoBean> amountInfo;
      public String info;
      public String reason;
      
      public String getAmount()
      {
        return this.amount;
      }
      
      public List<AmountInfoBean> getAmountInfo()
      {
        return this.amountInfo;
      }
      
      public String getReason()
      {
        return this.reason;
      }
      
      public void setAmount(String paramString)
      {
        this.amount = paramString;
      }
      
      public void setAmountInfo(List<AmountInfoBean> paramList)
      {
        this.amountInfo = paramList;
      }
      
      public void setReason(String paramString)
      {
        this.reason = paramString;
      }
      
      public static class AmountInfoBean
      {
        public String feeAmount;
        public String feeName;
        
        public String getFeeAmount()
        {
          return this.feeAmount;
        }
        
        public String getFeeName()
        {
          return this.feeName;
        }
        
        public void setFeeAmount(String paramString)
        {
          this.feeAmount = paramString;
        }
        
        public void setFeeName(String paramString)
        {
          this.feeName = paramString;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/ReFundWayModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */