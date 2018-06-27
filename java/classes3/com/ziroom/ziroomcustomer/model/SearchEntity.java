package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class SearchEntity
  implements Serializable
{
  private List<String> searchNearText;
  private List<String> searchTopText;
  
  public List<String> getSearchNearText()
  {
    return this.searchNearText;
  }
  
  public List<String> getSearchTopText()
  {
    return this.searchTopText;
  }
  
  public void setSearchNearText(List<String> paramList)
  {
    this.searchNearText = paramList;
  }
  
  public void setSearchTopText(List<String> paramList)
  {
    this.searchTopText = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SearchEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */