package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuChatMemberListBean
  extends MinsuBaseJson
{
  private DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBean
  {
    private List<MinsuChatMemberBaseInfoBean> listUserInfo;
    
    public List<MinsuChatMemberBaseInfoBean> getListUserInfo()
    {
      return this.listUserInfo;
    }
    
    public void setListUserInfo(List<MinsuChatMemberBaseInfoBean> paramList)
    {
      this.listUserInfo = paramList;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuChatMemberListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */