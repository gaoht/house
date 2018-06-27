package com.ziroom.ziroomcustomer.home.bean;

import java.util.List;

public class HomeRentItem
{
  private List<ContentBean> content;
  private String link;
  private MoreBean more;
  private String more_type;
  private String subtitle;
  private String title;
  
  public List<ContentBean> getContent()
  {
    return this.content;
  }
  
  public String getLink()
  {
    return this.link;
  }
  
  public MoreBean getMore()
  {
    return this.more;
  }
  
  public String getMore_type()
  {
    return this.more_type;
  }
  
  public String getSubtitle()
  {
    return this.subtitle;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setContent(List<ContentBean> paramList)
  {
    this.content = paramList;
  }
  
  public void setLink(String paramString)
  {
    this.link = paramString;
  }
  
  public void setMore(MoreBean paramMoreBean)
  {
    this.more = paramMoreBean;
  }
  
  public void setMore_type(String paramString)
  {
    this.more_type = paramString;
  }
  
  public void setSubtitle(String paramString)
  {
    this.subtitle = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/HomeRentItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */