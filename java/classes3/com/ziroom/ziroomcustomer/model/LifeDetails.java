package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class LifeDetails
  implements Serializable
{
  private Life_Campaign activity;
  private List<Life_Body> body;
  private Life_Header header;
  
  public Life_Campaign getActivity()
  {
    return this.activity;
  }
  
  public List<Life_Body> getBody()
  {
    return this.body;
  }
  
  public Life_Header getHeader()
  {
    return this.header;
  }
  
  public void setActivity(Life_Campaign paramLife_Campaign)
  {
    this.activity = paramLife_Campaign;
  }
  
  public void setBody(List<Life_Body> paramList)
  {
    this.body = paramList;
  }
  
  public void setHeader(Life_Header paramLife_Header)
  {
    this.header = paramLife_Header;
  }
  
  public String toString()
  {
    return "LifeDetails [activity=" + this.activity + ", header=" + this.header + ", body=" + this.body + "]";
  }
  
  public class Life_Body
    implements Serializable
  {
    private List<Body_Content> content;
    private String title;
    
    public Life_Body() {}
    
    public List<Body_Content> getContent()
    {
      return this.content;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setContent(List<Body_Content> paramList)
    {
      this.content = paramList;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public String toString()
    {
      return "Life_Body [title=" + this.title + ", content=" + this.content + "]";
    }
    
    public class Body_Content
      implements Serializable
    {
      private String height;
      private String type;
      private String value;
      private String width;
      
      public Body_Content() {}
      
      public String getHeight()
      {
        return this.height;
      }
      
      public String getType()
      {
        return this.type;
      }
      
      public String getValue()
      {
        return this.value;
      }
      
      public String getWidth()
      {
        return this.width;
      }
      
      public void setHeight(String paramString)
      {
        this.height = paramString;
      }
      
      public void setType(String paramString)
      {
        this.type = paramString;
      }
      
      public void setValue(String paramString)
      {
        this.value = paramString;
      }
      
      public void setWidth(String paramString)
      {
        this.width = paramString;
      }
      
      public String toString()
      {
        return "Body_Content [type=" + this.type + ", value=" + this.value + ", height=" + this.height + ", width=" + this.width + "]";
      }
    }
  }
  
  public class Life_Campaign
    implements Serializable
  {
    private String url;
    
    public Life_Campaign() {}
    
    public String getUrl()
    {
      return this.url;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
    
    public String toString()
    {
      return "Life_Campaign [url=" + this.url + "]";
    }
  }
  
  public class Life_Header
    implements Serializable
  {
    private String activity_address;
    private String activity_time;
    private String pic;
    private String price;
    private String title;
    
    public Life_Header() {}
    
    public String getActivity_address()
    {
      return this.activity_address;
    }
    
    public String getActivity_time()
    {
      return this.activity_time;
    }
    
    public String getPic()
    {
      return this.pic;
    }
    
    public String getPrice()
    {
      return this.price;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setActivity_address(String paramString)
    {
      this.activity_address = paramString;
    }
    
    public void setActivity_time(String paramString)
    {
      this.activity_time = paramString;
    }
    
    public void setPic(String paramString)
    {
      this.pic = paramString;
    }
    
    public void setPrice(String paramString)
    {
      this.price = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public String toString()
    {
      return "Life_Header [activity_address=" + this.activity_address + ", activity_time=" + this.activity_time + ", pic=" + this.pic + ", price=" + this.price + ", title=" + this.title + "]";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/LifeDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */