package com.ziroom.ziroomcustomer.home.bean;

public class HouseDetailJs
{
  private ParamBean param;
  
  public ParamBean getParam()
  {
    return this.param;
  }
  
  public void setParam(ParamBean paramParamBean)
  {
    this.param = paramParamBean;
  }
  
  public static class ParamBean
  {
    private String houseType;
    private String house_code;
    private String house_id;
    private int outsidePage;
    private String tel;
    private String url;
    
    public String getHouseType()
    {
      return this.houseType;
    }
    
    public String getHouse_code()
    {
      return this.house_code;
    }
    
    public String getHouse_id()
    {
      return this.house_id;
    }
    
    public int getOutsidePage()
    {
      return this.outsidePage;
    }
    
    public String getTel()
    {
      return this.tel;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public void setHouseType(String paramString)
    {
      this.houseType = paramString;
    }
    
    public void setHouse_code(String paramString)
    {
      this.house_code = paramString;
    }
    
    public void setHouse_id(String paramString)
    {
      this.house_id = paramString;
    }
    
    public void setOutsidePage(int paramInt)
    {
      this.outsidePage = paramInt;
    }
    
    public void setTel(String paramString)
    {
      this.tel = paramString;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/HouseDetailJs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */