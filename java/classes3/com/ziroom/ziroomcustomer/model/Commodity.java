package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class Commodity
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String bigImg;
  private String detail;
  private String itemId;
  private int num;
  private Float price;
  private String size;
  private String smallImg;
  private String title;
  private String type;
  
  public Commodity() {}
  
  public Commodity(String paramString1, String paramString2, int paramInt, Float paramFloat, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.itemId = paramString1;
    this.title = paramString2;
    this.num = paramInt;
    this.price = paramFloat;
    this.detail = paramString3;
    this.type = paramString4;
    this.size = paramString5;
    this.bigImg = paramString6;
    this.smallImg = paramString7;
  }
  
  public String getBigImg()
  {
    return this.bigImg;
  }
  
  public String getDetail()
  {
    return this.detail;
  }
  
  public String getItemId()
  {
    return this.itemId;
  }
  
  public int getNum()
  {
    return this.num;
  }
  
  public float getPrice()
  {
    return this.price.floatValue();
  }
  
  public String getSize()
  {
    return this.size;
  }
  
  public String getSmallImg()
  {
    return this.smallImg;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setBigImg(String paramString)
  {
    this.bigImg = paramString;
  }
  
  public void setDetail(String paramString)
  {
    this.detail = paramString;
  }
  
  public void setItemId(String paramString)
  {
    this.itemId = paramString;
  }
  
  public void setNum(int paramInt)
  {
    this.num = paramInt;
  }
  
  public void setPrice(float paramFloat)
  {
    this.price = Float.valueOf(paramFloat);
  }
  
  public void setPrice(Float paramFloat)
  {
    this.price = paramFloat;
  }
  
  public void setSize(String paramString)
  {
    this.size = paramString;
  }
  
  public void setSmallImg(String paramString)
  {
    this.smallImg = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/Commodity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */