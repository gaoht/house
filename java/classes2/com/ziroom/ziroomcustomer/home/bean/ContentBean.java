package com.ziroom.ziroomcustomer.home.bean;

import java.io.Serializable;
import java.util.List;

public class ContentBean
  implements Serializable
{
  public String app;
  public String bigPic;
  private String code;
  public String customer_avatar;
  public String customer_name;
  public String desc;
  public String describe;
  public String description;
  public String headPic;
  private String house_code;
  private String house_id;
  private String id;
  public String img;
  public int isNewDetail;
  private String link;
  public String pic;
  public String pin_text;
  public String price;
  public String projectId;
  private String rgb;
  public String share_content;
  public String share_title;
  public String share_url;
  public List<SmallPic> smallList;
  public String subtitle;
  public String target;
  public String targetUr;
  public String title;
  public String titleTag;
  public String type;
  private String types;
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getCustomer_avatar()
  {
    return this.customer_avatar;
  }
  
  public String getCustomer_name()
  {
    return this.customer_name;
  }
  
  public String getDescribe()
  {
    return this.describe;
  }
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public String getHouse_id()
  {
    return this.house_id;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getLink()
  {
    return this.link;
  }
  
  public String getPic()
  {
    return this.pic;
  }
  
  public String getPin_text()
  {
    return this.pin_text;
  }
  
  public String getRgb()
  {
    return this.rgb;
  }
  
  public String getShare_content()
  {
    return this.share_content;
  }
  
  public String getShare_title()
  {
    return this.share_title;
  }
  
  public String getSubtitle()
  {
    return this.subtitle;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getTypes()
  {
    return this.types;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setCustomer_avatar(String paramString)
  {
    this.customer_avatar = paramString;
  }
  
  public void setCustomer_name(String paramString)
  {
    this.customer_name = paramString;
  }
  
  public void setDescribe(String paramString)
  {
    this.describe = paramString;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setHouse_id(String paramString)
  {
    this.house_id = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setLink(String paramString)
  {
    this.link = paramString;
  }
  
  public void setPic(String paramString)
  {
    this.pic = paramString;
  }
  
  public void setPin_text(String paramString)
  {
    this.pin_text = paramString;
  }
  
  public void setRgb(String paramString)
  {
    this.rgb = paramString;
  }
  
  public void setShare_content(String paramString)
  {
    this.share_content = paramString;
  }
  
  public void setShare_title(String paramString)
  {
    this.share_title = paramString;
  }
  
  public void setSubtitle(String paramString)
  {
    this.subtitle = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setTypes(String paramString)
  {
    this.types = paramString;
  }
  
  public static class SmallPic
  {
    public String smaPic;
    public String smaTitle;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/ContentBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */