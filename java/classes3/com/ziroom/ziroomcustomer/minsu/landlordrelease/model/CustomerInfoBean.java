package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.util.List;

public class CustomerInfoBean
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
    private String customerIntroduce;
    private String defaultIntroduce;
    private boolean isEdit;
    private String nickName;
    private PictruesBean pictrues;
    
    public String getCustomerIntroduce()
    {
      return this.customerIntroduce;
    }
    
    public String getDefaultIntroduce()
    {
      return this.defaultIntroduce;
    }
    
    public String getNickName()
    {
      return this.nickName;
    }
    
    public PictruesBean getPictrues()
    {
      return this.pictrues;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public boolean isIsEdit()
    {
      return this.isEdit;
    }
    
    public void setCustomerIntroduce(String paramString)
    {
      this.customerIntroduce = paramString;
    }
    
    public void setDefaultIntroduce(String paramString)
    {
      this.defaultIntroduce = paramString;
    }
    
    public void setEdit(boolean paramBoolean)
    {
      this.isEdit = paramBoolean;
    }
    
    public void setIsEdit(boolean paramBoolean)
    {
      this.isEdit = paramBoolean;
    }
    
    public void setNickName(String paramString)
    {
      this.nickName = paramString;
    }
    
    public void setPictrues(PictruesBean paramPictruesBean)
    {
      this.pictrues = paramPictruesBean;
    }
    
    public static class PictruesBean
    {
      private List<String> explain;
      private String headPicUrl;
      
      public List<String> getExplain()
      {
        return this.explain;
      }
      
      public String getHeadPicUrl()
      {
        return this.headPicUrl;
      }
      
      public void setExplain(List<String> paramList)
      {
        this.explain = paramList;
      }
      
      public void setHeadPicUrl(String paramString)
      {
        this.headPicUrl = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/CustomerInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */