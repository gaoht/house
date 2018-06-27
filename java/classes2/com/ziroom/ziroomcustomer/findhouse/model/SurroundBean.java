package com.ziroom.ziroomcustomer.findhouse.model;

import java.io.Serializable;
import java.util.List;

public class SurroundBean
  implements Serializable
{
  public List<String> keywords;
  public String title;
  
  public List<String> getKeywords()
  {
    return this.keywords;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setKeywords(List<String> paramList)
  {
    this.keywords = paramList;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/SurroundBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */