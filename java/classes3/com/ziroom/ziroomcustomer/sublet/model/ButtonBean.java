package com.ziroom.ziroomcustomer.sublet.model;

public class ButtonBean
{
  private String promptText;
  private String promptTitle;
  private String text;
  private String type;
  private String value;
  
  public ButtonBean() {}
  
  public ButtonBean(SubletTurnDetailBean.ButtonBean paramButtonBean)
  {
    this.type = paramButtonBean.getType();
    this.text = paramButtonBean.getText();
    this.promptText = paramButtonBean.getPrompt_text();
    this.promptTitle = paramButtonBean.getPrompt_title();
    this.value = paramButtonBean.getLink();
  }
  
  public ButtonBean(String paramString)
  {
    this.type = paramString;
  }
  
  public String getPromptText()
  {
    return this.promptText;
  }
  
  public String getPromptTitle()
  {
    return this.promptTitle;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setPromptText(String paramString)
  {
    this.promptText = paramString;
  }
  
  public void setPromptTitle(String paramString)
  {
    this.promptTitle = paramString;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public String toString()
  {
    return "ButtonBean{type='" + this.type + '\'' + ", text='" + this.text + '\'' + ", promptTitle='" + this.promptTitle + '\'' + ", promptText='" + this.promptText + '\'' + ", value='" + this.value + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/model/ButtonBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */