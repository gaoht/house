package com.ziroom.ziroomcustomer.model;

public class CleanService
{
  private String vasbContent;
  private String vasbId;
  private int vasbPrice;
  private String vasbRemark;
  
  public String getVasbContent()
  {
    return this.vasbContent;
  }
  
  public String getVasbId()
  {
    return this.vasbId;
  }
  
  public int getVasbPrice()
  {
    return this.vasbPrice;
  }
  
  public String getVasbRemark()
  {
    return this.vasbRemark;
  }
  
  public void setVasbContent(String paramString)
  {
    this.vasbContent = paramString;
  }
  
  public void setVasbId(String paramString)
  {
    this.vasbId = paramString;
  }
  
  public void setVasbPrice(int paramInt)
  {
    this.vasbPrice = paramInt;
  }
  
  public void setVasbRemark(String paramString)
  {
    this.vasbRemark = paramString;
  }
  
  public String toString()
  {
    return "CleanService [vasbId=" + this.vasbId + ", vasbRemark=" + this.vasbRemark + ", vasbPrice=" + this.vasbPrice + ", vasbContent=" + this.vasbContent + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */