package com.ziroom.ziroomcustomer.account.model;

import com.freelxl.baselibrary.b.b;
import java.io.Serializable;
import java.util.List;

public class AccountDetails
  extends b
  implements Serializable
{
  private List<DataBean> data;
  
  public List<DataBean> getData()
  {
    return this.data;
  }
  
  public void setData(List<DataBean> paramList)
  {
    this.data = paramList;
  }
  
  public class DataBean
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    private String balance;
    private String date;
    private String order_no;
    private String question_url;
    private String remark;
    private String status;
    private String status_name;
    private String type;
    private String type_name;
    
    public DataBean() {}
    
    public String getBalance()
    {
      return this.balance;
    }
    
    public String getDate()
    {
      return this.date;
    }
    
    public String getOrder_no()
    {
      return this.order_no;
    }
    
    public String getQuestion_url()
    {
      return this.question_url;
    }
    
    public String getRemark()
    {
      return this.remark;
    }
    
    public String getStatus()
    {
      return this.status;
    }
    
    public String getStatus_name()
    {
      return this.status_name;
    }
    
    public String getType()
    {
      return this.type;
    }
    
    public String getType_name()
    {
      return this.type_name;
    }
    
    public void setBalance(String paramString)
    {
      this.balance = paramString;
    }
    
    public void setDate(String paramString)
    {
      this.date = paramString;
    }
    
    public void setOrder_no(String paramString)
    {
      this.order_no = paramString;
    }
    
    public void setQuestion_url(String paramString)
    {
      this.question_url = paramString;
    }
    
    public void setRemark(String paramString)
    {
      this.remark = paramString;
    }
    
    public void setStatus(String paramString)
    {
      this.status = paramString;
    }
    
    public void setStatus_name(String paramString)
    {
      this.status_name = paramString;
    }
    
    public void setType(String paramString)
    {
      this.type = paramString;
    }
    
    public void setType_name(String paramString)
    {
      this.type_name = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/model/AccountDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */