package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuLandlordBean
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
    public double eva;
    public String headPicUrl;
    public String headPicUrlOrg;
    public String introduce;
    public String nickName;
    
    public double getEva()
    {
      return this.eva;
    }
    
    public String getHeadPicUrl()
    {
      return this.headPicUrl;
    }
    
    public String getHeadPicUrlOrg()
    {
      return this.headPicUrlOrg;
    }
    
    public String getIntroduce()
    {
      return this.introduce;
    }
    
    public String getNickName()
    {
      return this.nickName;
    }
    
    public void setEva(double paramDouble)
    {
      this.eva = paramDouble;
    }
    
    public void setHeadPicUrl(String paramString)
    {
      this.headPicUrl = paramString;
    }
    
    public void setHeadPicUrlOrg(String paramString)
    {
      this.headPicUrlOrg = paramString;
    }
    
    public void setIntroduce(String paramString)
    {
      this.introduce = paramString;
    }
    
    public void setNickName(String paramString)
    {
      this.nickName = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuLandlordBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */