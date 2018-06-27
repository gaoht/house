package com.ziroom.ziroomcustomer.findhouse.model;

import java.util.List;

public class SearchSuggestion
{
  List<Item> items;
  int num;
  String query;
  
  public List<Item> getItems()
  {
    return this.items;
  }
  
  public int getNum()
  {
    return this.num;
  }
  
  public String getQuery()
  {
    return this.query;
  }
  
  public void setItems(List<Item> paramList)
  {
    this.items = paramList;
  }
  
  public void setNum(int paramInt)
  {
    this.num = paramInt;
  }
  
  public void setQuery(String paramString)
  {
    this.query = paramString;
  }
  
  public String toString()
  {
    return "SearchSuggestion{query='" + this.query + '\'' + ", num=" + this.num + ", items=" + this.items + '}';
  }
  
  public static class Item
  {
    int flag;
    String housenum;
    String icon;
    String memo;
    String name;
    String value;
    
    public int getFlag()
    {
      return this.flag;
    }
    
    public String getHousenum()
    {
      return this.housenum;
    }
    
    public String getIcon()
    {
      return this.icon;
    }
    
    public String getMemo()
    {
      return this.memo;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public void setFlag(int paramInt)
    {
      this.flag = paramInt;
    }
    
    public void setHousenum(String paramString)
    {
      this.housenum = paramString;
    }
    
    public void setIcon(String paramString)
    {
      this.icon = paramString;
    }
    
    public void setMemo(String paramString)
    {
      this.memo = paramString;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
    
    public String toString()
    {
      return "Item{name='" + this.name + '\'' + ", flag=" + this.flag + ", icon='" + this.icon + '\'' + ", memo='" + this.memo + '\'' + ", housenum=" + this.housenum + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/SearchSuggestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */