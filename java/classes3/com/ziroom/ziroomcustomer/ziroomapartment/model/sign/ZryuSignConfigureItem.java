package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.util.List;

public class ZryuSignConfigureItem
{
  private List<Item> items;
  private String name;
  
  public List<Item> getItems()
  {
    return this.items;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setItems(List<Item> paramList)
  {
    this.items = paramList;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public static class Item
  {
    public static final int TYPE_CHILD = 1;
    public static final int TYPE_PARENT = 0;
    private String name;
    private Integer num;
    private String price;
    private int type;
    
    public String getName()
    {
      return this.name;
    }
    
    public Integer getNum()
    {
      return this.num;
    }
    
    public String getPrice()
    {
      return this.price;
    }
    
    public int getType()
    {
      return this.type;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setNum(Integer paramInteger)
    {
      this.num = paramInteger;
    }
    
    public void setPrice(String paramString)
    {
      this.price = paramString;
    }
    
    public void setType(int paramInt)
    {
      this.type = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignConfigureItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */