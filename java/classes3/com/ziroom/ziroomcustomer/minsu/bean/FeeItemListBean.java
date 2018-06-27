package com.ziroom.ziroomcustomer.minsu.bean;

public class FeeItemListBean
{
  public Integer colorType;
  public String fee;
  public Integer index;
  public String name;
  public String symbol;
  public String title1;
  public String title2;
  
  public Integer getColorType()
  {
    return this.colorType;
  }
  
  public String getFee()
  {
    return this.fee;
  }
  
  public Integer getIndex()
  {
    return this.index;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getSymbol()
  {
    return this.symbol;
  }
  
  public String getTitle1()
  {
    return this.title1;
  }
  
  public String getTitle2()
  {
    return this.title2;
  }
  
  public void setColorType(Integer paramInteger)
  {
    this.colorType = paramInteger;
  }
  
  public void setFee(String paramString)
  {
    this.fee = paramString;
  }
  
  public void setIndex(Integer paramInteger)
  {
    this.index = paramInteger;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSymbol(String paramString)
  {
    this.symbol = paramString;
  }
  
  public void setTitle1(String paramString)
  {
    this.title1 = paramString;
  }
  
  public void setTitle2(String paramString)
  {
    this.title2 = paramString;
  }
  
  public String toString()
  {
    return "FeeItemListBean{name='" + this.name + '\'' + ", colorType=" + this.colorType + ", fee='" + this.fee + '\'' + ", index=" + this.index + ", symbol='" + this.symbol + '\'' + ", title1='" + this.title1 + '\'' + ", title2='" + this.title2 + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/FeeItemListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */