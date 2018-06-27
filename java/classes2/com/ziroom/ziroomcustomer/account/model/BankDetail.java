package com.ziroom.ziroomcustomer.account.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class BankDetail
  extends b
{
  private List<DataBean> data;
  
  public List<DataBean> getData()
  {
    return this.data;
  }
  
  public int getError_code()
  {
    return this.error_code;
  }
  
  public String getError_message()
  {
    return this.error_message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setData(List<DataBean> paramList)
  {
    this.data = paramList;
  }
  
  public void setError_code(int paramInt)
  {
    this.error_code = paramInt;
  }
  
  public void setError_message(String paramString)
  {
    this.error_message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBean
  {
    private String bank_flag;
    private String bank_icon;
    private String bank_name;
    private String id;
    
    public String getBank_flag()
    {
      return this.bank_flag;
    }
    
    public String getBank_icon()
    {
      return this.bank_icon;
    }
    
    public String getBank_name()
    {
      return this.bank_name;
    }
    
    public String getId()
    {
      return this.id;
    }
    
    public void setBank_flag(String paramString)
    {
      this.bank_flag = paramString;
    }
    
    public void setBank_icon(String paramString)
    {
      this.bank_icon = paramString;
    }
    
    public void setBank_name(String paramString)
    {
      this.bank_name = paramString;
    }
    
    public void setId(String paramString)
    {
      this.id = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/model/BankDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */