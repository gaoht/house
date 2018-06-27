package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuLLHouseTodayHintBean
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
    private String actIntroduc;
    private String actIntroducPic;
    private String guideHint;
    private String saveHint;
    private String setHint;
    
    public String getActIntroduc()
    {
      return this.actIntroduc;
    }
    
    public String getActIntroducPic()
    {
      return this.actIntroducPic;
    }
    
    public String getGuideHint()
    {
      return this.guideHint;
    }
    
    public String getSaveHint()
    {
      return this.saveHint;
    }
    
    public String getSetHint()
    {
      return this.setHint;
    }
    
    public void setActIntroduc(String paramString)
    {
      this.actIntroduc = paramString;
    }
    
    public void setActIntroducPic(String paramString)
    {
      this.actIntroducPic = paramString;
    }
    
    public void setGuideHint(String paramString)
    {
      this.guideHint = paramString;
    }
    
    public void setSaveHint(String paramString)
    {
      this.saveHint = paramString;
    }
    
    public void setSetHint(String paramString)
    {
      this.setHint = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuLLHouseTodayHintBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */