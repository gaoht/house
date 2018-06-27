package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class Children
{
  private String code;
  private String index;
  private String label;
  private int optionType;
  private List<Option> options;
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getIndex()
  {
    return this.index;
  }
  
  public String getLabel()
  {
    return this.label;
  }
  
  public int getOptionType()
  {
    return this.optionType;
  }
  
  public List<Option> getOptions()
  {
    return this.options;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setIndex(String paramString)
  {
    this.index = paramString;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public void setOptionType(int paramInt)
  {
    this.optionType = paramInt;
  }
  
  public void setOptions(List<Option> paramList)
  {
    this.options = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/Children.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */