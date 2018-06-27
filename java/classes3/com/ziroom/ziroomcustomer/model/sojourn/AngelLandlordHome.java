package com.ziroom.ziroomcustomer.model.sojourn;

import java.util.List;

public class AngelLandlordHome
{
  private String footerTitle;
  private String guideTitle;
  private String guideUrl;
  private String mainTitle;
  private List<String> privilegeMsgList;
  private String privilegeUrl;
  private String subtitle;
  private List<TargetListBean> targetList;
  
  public String getFooterTitle()
  {
    return this.footerTitle;
  }
  
  public String getGuideTitle()
  {
    return this.guideTitle;
  }
  
  public String getGuideUrl()
  {
    return this.guideUrl;
  }
  
  public String getMainTitle()
  {
    return this.mainTitle;
  }
  
  public List<String> getPrivilegeMsgList()
  {
    return this.privilegeMsgList;
  }
  
  public String getPrivilegeUrl()
  {
    return this.privilegeUrl;
  }
  
  public String getSubtitle()
  {
    return this.subtitle;
  }
  
  public List<TargetListBean> getTargetList()
  {
    return this.targetList;
  }
  
  public void setFooterTitle(String paramString)
  {
    this.footerTitle = paramString;
  }
  
  public void setGuideTitle(String paramString)
  {
    this.guideTitle = paramString;
  }
  
  public void setGuideUrl(String paramString)
  {
    this.guideUrl = paramString;
  }
  
  public void setMainTitle(String paramString)
  {
    this.mainTitle = paramString;
  }
  
  public void setPrivilegeMsgList(List<String> paramList)
  {
    this.privilegeMsgList = paramList;
  }
  
  public void setPrivilegeUrl(String paramString)
  {
    this.privilegeUrl = paramString;
  }
  
  public void setSubtitle(String paramString)
  {
    this.subtitle = paramString;
  }
  
  public void setTargetList(List<TargetListBean> paramList)
  {
    this.targetList = paramList;
  }
  
  public static class TargetListBean
  {
    private String fieldMsg;
    private String fieldStandard;
    private String fieldText;
    private String fieldValue;
    private int isLighten;
    
    public String getFieldMsg()
    {
      return this.fieldMsg;
    }
    
    public String getFieldStandard()
    {
      return this.fieldStandard;
    }
    
    public String getFieldText()
    {
      return this.fieldText;
    }
    
    public String getFieldValue()
    {
      return this.fieldValue;
    }
    
    public int getIsLighten()
    {
      return this.isLighten;
    }
    
    public void setFieldMsg(String paramString)
    {
      this.fieldMsg = paramString;
    }
    
    public void setFieldStandard(String paramString)
    {
      this.fieldStandard = paramString;
    }
    
    public void setFieldText(String paramString)
    {
      this.fieldText = paramString;
    }
    
    public void setFieldValue(String paramString)
    {
      this.fieldValue = paramString;
    }
    
    public void setIsLighten(int paramInt)
    {
      this.isLighten = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/sojourn/AngelLandlordHome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */