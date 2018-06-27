package com.ziroom.ziroomcustomer.minsu.bean;

import java.io.Serializable;
import java.util.List;

public class MinsuHouseBeanToday
  extends MinsuBaseJson
  implements Serializable
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
  
  public static class DataBean
  {
    private String enTitle;
    private List<MinsuHouseBean.DataBean.ListBean> list;
    private String subTitle;
    private List<?> suggest;
    private String todayDiscountCode;
    private int total;
    private String zhTitle;
    
    public String getEnTitle()
    {
      return this.enTitle;
    }
    
    public List<MinsuHouseBean.DataBean.ListBean> getList()
    {
      return this.list;
    }
    
    public String getSubTitle()
    {
      return this.subTitle;
    }
    
    public List<?> getSuggest()
    {
      return this.suggest;
    }
    
    public String getTodayDiscountCode()
    {
      return this.todayDiscountCode;
    }
    
    public int getTotal()
    {
      return this.total;
    }
    
    public String getZhTitle()
    {
      return this.zhTitle;
    }
    
    public void setEnTitle(String paramString)
    {
      this.enTitle = paramString;
    }
    
    public void setList(List<MinsuHouseBean.DataBean.ListBean> paramList)
    {
      this.list = paramList;
    }
    
    public void setSubTitle(String paramString)
    {
      this.subTitle = paramString;
    }
    
    public void setSuggest(List<?> paramList)
    {
      this.suggest = paramList;
    }
    
    public void setTodayDiscountCode(String paramString)
    {
      this.todayDiscountCode = paramString;
    }
    
    public void setTotal(int paramInt)
    {
      this.total = paramInt;
    }
    
    public void setZhTitle(String paramString)
    {
      this.zhTitle = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuHouseBeanToday.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */