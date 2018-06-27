package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.io.Serializable;

public class MHTool
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String desc;
  private String goodsId;
  private String largeimgurl;
  private String name;
  private int num;
  private int price;
  private String smallimgurl;
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getGoodsId()
  {
    return this.goodsId;
  }
  
  public String getLargeimgurl()
  {
    return this.largeimgurl;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getNum()
  {
    return this.num;
  }
  
  public int getPrice()
  {
    return this.price;
  }
  
  public String getSmallimgurl()
  {
    return this.smallimgurl;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setGoodsId(String paramString)
  {
    this.goodsId = paramString;
  }
  
  public void setLargeimgurl(String paramString)
  {
    this.largeimgurl = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNum(int paramInt)
  {
    this.num = paramInt;
  }
  
  public void setPrice(int paramInt)
  {
    this.price = paramInt;
  }
  
  public void setSmallimgurl(String paramString)
  {
    this.smallimgurl = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MHTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */