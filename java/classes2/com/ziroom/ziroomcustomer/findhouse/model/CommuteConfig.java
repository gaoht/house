package com.ziroom.ziroomcustomer.findhouse.model;

public class CommuteConfig
{
  public static final String ID_DRIVE = "drive";
  public static final String ID_RIDE = "ride";
  public static final String ID_TRANSIT = "transit";
  public static final String ID_WALK = "walk";
  private String id;
  private String name;
  private Integer prefered;
  private Integer[] sections;
  private Integer selected;
  
  public String getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Integer getPrefered()
  {
    return this.prefered;
  }
  
  public Integer[] getSections()
  {
    return this.sections;
  }
  
  public Integer getSelected()
  {
    return this.selected;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPrefered(Integer paramInteger)
  {
    this.prefered = paramInteger;
  }
  
  public void setSections(Integer[] paramArrayOfInteger)
  {
    this.sections = paramArrayOfInteger;
  }
  
  public void setSelected(Integer paramInteger)
  {
    this.selected = paramInteger;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/CommuteConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */