package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;

public class CertificationBean
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
    private String fullFlag;
    private String isContactAuth;
    private String isFinishHead;
    private String isIdentityAuth;
    
    public String getFullFlag()
    {
      return this.fullFlag;
    }
    
    public String getIsContactAuth()
    {
      return this.isContactAuth;
    }
    
    public String getIsFinishHead()
    {
      return this.isFinishHead;
    }
    
    public String getIsIdentityAuth()
    {
      return this.isIdentityAuth;
    }
    
    public void setFullFlag(String paramString)
    {
      this.fullFlag = paramString;
    }
    
    public void setIsContactAuth(String paramString)
    {
      this.isContactAuth = paramString;
    }
    
    public void setIsFinishHead(String paramString)
    {
      this.isFinishHead = paramString;
    }
    
    public void setIsIdentityAuth(String paramString)
    {
      this.isIdentityAuth = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/CertificationBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */