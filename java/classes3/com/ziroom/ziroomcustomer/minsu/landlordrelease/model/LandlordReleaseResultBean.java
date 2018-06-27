package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.util.List;

public class LandlordReleaseResultBean
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
    private List<String> nameList;
    private String remindMsg;
    
    public List<String> getNameList()
    {
      return this.nameList;
    }
    
    public String getRemindMsg()
    {
      return this.remindMsg;
    }
    
    public void setNameList(List<String> paramList)
    {
      this.nameList = paramList;
    }
    
    public void setRemindMsg(String paramString)
    {
      this.remindMsg = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LandlordReleaseResultBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */