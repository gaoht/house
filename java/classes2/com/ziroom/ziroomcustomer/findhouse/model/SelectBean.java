package com.ziroom.ziroomcustomer.findhouse.model;

import java.io.Serializable;
import java.util.List;

public class SelectBean
  implements Serializable
{
  private List<SelectBean> children;
  int hot;
  String title = "";
  String value = "";
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    return paramObject.toString().equals(toString());
  }
  
  public List<SelectBean> getChildren()
  {
    return this.children;
  }
  
  public int getHot()
  {
    return this.hot;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setChildren(List<SelectBean> paramList)
  {
    this.children = paramList;
  }
  
  public void setHot(int paramInt)
  {
    this.hot = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public String toString()
  {
    return "SelectBean{title='" + this.title + '\'' + ", value='" + this.value + '\'' + ", children=" + this.children + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/SelectBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */