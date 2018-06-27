package com.ziroom.ziroomcustomer.account.model;

import com.freelxl.baselibrary.b.b;

public class GiftBase
  extends b
{
  private DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public class DataBean
  {
    private int code;
    private String desc;
    
    public DataBean() {}
    
    public int getCode()
    {
      return this.code;
    }
    
    public String getDesc()
    {
      return this.desc;
    }
    
    public void setCode(int paramInt)
    {
      this.code = paramInt;
    }
    
    public void setDesc(String paramString)
    {
      this.desc = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/model/GiftBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */