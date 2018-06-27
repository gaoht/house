package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuFirstCouponLoginBean
{
  private DataBean data;
  private String message;
  private String status;
  
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
    private String buttonHint;
    private String contentHint;
    private int isNew = 1;
    private MinsuFirstCouponLoginBean.LunboBean lunbo;
    private int mgClickSwitch;
    private String picHint;
    private int whetherOpen;
    
    public String getButtonHint()
    {
      return this.buttonHint;
    }
    
    public String getContentHint()
    {
      return this.contentHint;
    }
    
    public int getIsNew()
    {
      return this.isNew;
    }
    
    public MinsuFirstCouponLoginBean.LunboBean getLunbo()
    {
      return this.lunbo;
    }
    
    public int getMgClickSwitch()
    {
      return this.mgClickSwitch;
    }
    
    public String getPicHint()
    {
      return this.picHint;
    }
    
    public int getWhetherOpen()
    {
      return this.whetherOpen;
    }
    
    public void setButtonHint(String paramString)
    {
      this.buttonHint = paramString;
    }
    
    public void setContentHint(String paramString)
    {
      this.contentHint = paramString;
    }
    
    public void setIsNew(int paramInt)
    {
      this.isNew = paramInt;
    }
    
    public void setLunbo(MinsuFirstCouponLoginBean.LunboBean paramLunboBean)
    {
      this.lunbo = paramLunboBean;
    }
    
    public void setMgClickSwitch(int paramInt)
    {
      this.mgClickSwitch = paramInt;
    }
    
    public void setPicHint(String paramString)
    {
      this.picHint = paramString;
    }
    
    public void setWhetherOpen(int paramInt)
    {
      this.whetherOpen = paramInt;
    }
  }
  
  public static class LunboBean
  {
    private String app;
    private String description;
    private String img;
    private String target;
    private String title;
    
    public String getApp()
    {
      return this.app;
    }
    
    public String getDescription()
    {
      return this.description;
    }
    
    public String getImg()
    {
      return this.img;
    }
    
    public String getTarget()
    {
      return this.target;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setApp(String paramString)
    {
      this.app = paramString;
    }
    
    public void setDescription(String paramString)
    {
      this.description = paramString;
    }
    
    public void setImg(String paramString)
    {
      this.img = paramString;
    }
    
    public void setTarget(String paramString)
    {
      this.target = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuFirstCouponLoginBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */