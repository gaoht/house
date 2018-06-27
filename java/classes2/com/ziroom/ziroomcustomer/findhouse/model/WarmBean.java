package com.ziroom.ziroomcustomer.findhouse.model;

public class WarmBean
{
  private HouseInfoBean house_info;
  
  public HouseInfoBean getHouse_info()
  {
    return this.house_info;
  }
  
  public void setHouse_info(HouseInfoBean paramHouseInfoBean)
  {
    this.house_info = paramHouseInfoBean;
  }
  
  public String toString()
  {
    return "WarmBean{, house_info=" + this.house_info + '}';
  }
  
  public static class HouseInfoBean
  {
    private String active_url;
    private int display;
    private String house_name;
    private String house_num;
    private int house_status;
    private String house_style;
    private String house_type;
    private int is_my;
    private String qrcode;
    
    public String getActive_url()
    {
      return this.active_url;
    }
    
    public int getDisplay()
    {
      return this.display;
    }
    
    public String getHouse_name()
    {
      return this.house_name;
    }
    
    public String getHouse_num()
    {
      return this.house_num;
    }
    
    public int getHouse_status()
    {
      return this.house_status;
    }
    
    public String getHouse_style()
    {
      return this.house_style;
    }
    
    public String getHouse_type()
    {
      return this.house_type;
    }
    
    public int getIs_my()
    {
      return this.is_my;
    }
    
    public String getQrcode()
    {
      return this.qrcode;
    }
    
    public void setActive_url(String paramString)
    {
      this.active_url = paramString;
    }
    
    public void setDisplay(int paramInt)
    {
      this.display = paramInt;
    }
    
    public void setHouse_name(String paramString)
    {
      this.house_name = paramString;
    }
    
    public void setHouse_num(String paramString)
    {
      this.house_num = paramString;
    }
    
    public void setHouse_status(int paramInt)
    {
      this.house_status = paramInt;
    }
    
    public void setHouse_style(String paramString)
    {
      this.house_style = paramString;
    }
    
    public void setHouse_type(String paramString)
    {
      this.house_type = paramString;
    }
    
    public void setIs_my(int paramInt)
    {
      this.is_my = paramInt;
    }
    
    public void setQrcode(String paramString)
    {
      this.qrcode = paramString;
    }
    
    public String toString()
    {
      return "HouseInfoBean{house_type='" + this.house_type + '\'' + ", house_name='" + this.house_name + '\'' + ", house_style='" + this.house_style + '\'' + ", house_status=" + this.house_status + ", house_num='" + this.house_num + '\'' + ", display=" + this.display + ", qrcode='" + this.qrcode + '\'' + ", active_url='" + this.active_url + '\'' + ", is_my=" + this.is_my + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/WarmBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */