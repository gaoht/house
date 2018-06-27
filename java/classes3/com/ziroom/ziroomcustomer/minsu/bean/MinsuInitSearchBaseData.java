package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuInitSearchBaseData
  extends MinsuBaseJson
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
    private List<HouseTypeListBean> houseTypeList;
    
    public List<HouseTypeListBean> getHouseTypeList()
    {
      return this.houseTypeList;
    }
    
    public void setHouseTypeList(List<HouseTypeListBean> paramList)
    {
      this.houseTypeList = paramList;
    }
    
    public static class HouseTypeListBean
    {
      private String key;
      private String text;
      
      public String getKey()
      {
        return this.key;
      }
      
      public String getText()
      {
        return this.text;
      }
      
      public void setKey(String paramString)
      {
        this.key = paramString;
      }
      
      public void setText(String paramString)
      {
        this.text = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuInitSearchBaseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */