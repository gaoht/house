package com.ziroom.ziroomcustomer.findhouse.model;

import com.ziroom.ziroomcustomer.model.rent.PriceLimit;
import java.io.Serializable;
import java.util.List;

public class SelectCondition
  implements Serializable
{
  private List<SelectBean> area2;
  private List<SelectBean> around;
  private SelectDate checkin_date;
  private List<SelectBean> face;
  private List<SelectBean> feature;
  private List<SelectBean> feature1;
  private List<SelectBean> feature2;
  private List<SelectBean> hface2;
  private List<SelectBean> leasetype;
  private List<SelectBean> price;
  private List<SelectBean> price1;
  private PriceLimit price1_limit = new PriceLimit();
  private List<SelectBean> price2;
  private PriceLimit price2_limit = new PriceLimit();
  private PriceLimit price_limit = new PriceLimit();
  private List<SelectBean> rapid;
  private List<SelectBean> rface1;
  private List<SelectBean> sort;
  private List<SelectBean> tag;
  private List<SelectType> type;
  private List<TypeExtra> type_extra;
  private List<SelectBean> version1;
  private List<SelectBean> version2;
  
  public List<SelectBean> getArea2()
  {
    return this.area2;
  }
  
  public List<SelectBean> getAround()
  {
    return this.around;
  }
  
  public SelectDate getCheckin_date()
  {
    return this.checkin_date;
  }
  
  public List<SelectBean> getFace()
  {
    return this.face;
  }
  
  public List<SelectBean> getFeature()
  {
    return this.feature;
  }
  
  public List<SelectBean> getFeature1()
  {
    return this.feature1;
  }
  
  public List<SelectBean> getFeature2()
  {
    return this.feature2;
  }
  
  public List<SelectBean> getHface2()
  {
    return this.hface2;
  }
  
  public List<SelectBean> getLeasetype()
  {
    return this.leasetype;
  }
  
  public List<SelectBean> getPrice()
  {
    return this.price;
  }
  
  public List<SelectBean> getPrice1()
  {
    return this.price1;
  }
  
  public PriceLimit getPrice1_limit()
  {
    return this.price1_limit;
  }
  
  public List<SelectBean> getPrice2()
  {
    return this.price2;
  }
  
  public PriceLimit getPrice2_limit()
  {
    return this.price2_limit;
  }
  
  public PriceLimit getPrice_limit()
  {
    return this.price_limit;
  }
  
  public List<SelectBean> getRapid()
  {
    return this.rapid;
  }
  
  public List<SelectBean> getRface1()
  {
    return this.rface1;
  }
  
  public List<SelectBean> getSort()
  {
    return this.sort;
  }
  
  public List<SelectBean> getTag()
  {
    return this.tag;
  }
  
  public List<SelectType> getType()
  {
    return this.type;
  }
  
  public List<TypeExtra> getType_extra()
  {
    return this.type_extra;
  }
  
  public List<SelectBean> getVersion1()
  {
    return this.version1;
  }
  
  public List<SelectBean> getVersion2()
  {
    return this.version2;
  }
  
  public void setArea2(List<SelectBean> paramList)
  {
    this.area2 = paramList;
  }
  
  public void setAround(List<SelectBean> paramList)
  {
    this.around = paramList;
  }
  
  public void setCheckin_date(SelectDate paramSelectDate)
  {
    this.checkin_date = paramSelectDate;
  }
  
  public void setFace(List<SelectBean> paramList)
  {
    this.face = paramList;
  }
  
  public void setFeature(List<SelectBean> paramList)
  {
    this.feature = paramList;
  }
  
  public void setFeature1(List<SelectBean> paramList)
  {
    this.feature1 = paramList;
  }
  
  public void setFeature2(List<SelectBean> paramList)
  {
    this.feature2 = paramList;
  }
  
  public void setHface2(List<SelectBean> paramList)
  {
    this.hface2 = paramList;
  }
  
  public void setLeasetype(List<SelectBean> paramList)
  {
    this.leasetype = paramList;
  }
  
  public void setPrice(List<SelectBean> paramList)
  {
    this.price = paramList;
  }
  
  public void setPrice1(List<SelectBean> paramList)
  {
    this.price1 = paramList;
  }
  
  public void setPrice1_limit(PriceLimit paramPriceLimit)
  {
    this.price1_limit = paramPriceLimit;
  }
  
  public void setPrice2(List<SelectBean> paramList)
  {
    this.price2 = paramList;
  }
  
  public void setPrice2_limit(PriceLimit paramPriceLimit)
  {
    this.price2_limit = paramPriceLimit;
  }
  
  public void setPrice_limit(PriceLimit paramPriceLimit)
  {
    this.price_limit = paramPriceLimit;
  }
  
  public void setRapid(List<SelectBean> paramList)
  {
    this.rapid = paramList;
  }
  
  public void setRface1(List<SelectBean> paramList)
  {
    this.rface1 = paramList;
  }
  
  public void setSort(List<SelectBean> paramList)
  {
    this.sort = paramList;
  }
  
  public void setTag(List<SelectBean> paramList)
  {
    this.tag = paramList;
  }
  
  public void setType(List<SelectType> paramList)
  {
    this.type = paramList;
  }
  
  public void setType_extra(List<TypeExtra> paramList)
  {
    this.type_extra = paramList;
  }
  
  public void setVersion1(List<SelectBean> paramList)
  {
    this.version1 = paramList;
  }
  
  public void setVersion2(List<SelectBean> paramList)
  {
    this.version2 = paramList;
  }
  
  public String toString()
  {
    return "SelectCondition{leasetype=" + this.leasetype + ", type=" + this.type + ", type_extra=" + this.type_extra + ", price=" + this.price + ", price1=" + this.price1 + ", price2=" + this.price2 + ", sort=" + this.sort + ", hface2=" + this.hface2 + ", face=" + this.face + ", area2=" + this.area2 + ", rface1=" + this.rface1 + ", tag=" + this.tag + ", feature1=" + this.feature1 + ", feature2=" + this.feature2 + ", feature=" + this.feature + ", around=" + this.around + ", version1=" + this.version1 + ", version2=" + this.version2 + '}';
  }
  
  public class SelectDate
    implements Serializable
  {
    private String end_date = "";
    private String start_date = "";
    
    public SelectDate() {}
    
    public String getEnd_date()
    {
      return this.end_date;
    }
    
    public String getStart_date()
    {
      return this.start_date;
    }
    
    public void setEnd_date(String paramString)
    {
      this.end_date = paramString;
    }
    
    public void setStart_date(String paramString)
    {
      this.start_date = paramString;
    }
  }
  
  public static class SelectType
    implements Serializable
  {
    private String show = "";
    private String title = "";
    private int type;
    private String value = "";
    
    public String getShow()
    {
      return this.show;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public int getType()
    {
      return this.type;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public void setShow(String paramString)
    {
      this.show = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setType(int paramInt)
    {
      this.type = paramInt;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
    
    public String toString()
    {
      return "SelectType{show='" + this.show + '\'' + "title='" + this.title + '\'' + ", value='" + this.value + '\'' + ", type=" + this.type + '}';
    }
  }
  
  public class TypeExtra
    implements Serializable
  {
    private String desc = "";
    private String link = "";
    private String link_text = "";
    private String link_title = "";
    private String title = "";
    private int type;
    
    public TypeExtra() {}
    
    public String getDesc()
    {
      return this.desc;
    }
    
    public String getLink()
    {
      return this.link;
    }
    
    public String getLink_text()
    {
      return this.link_text;
    }
    
    public String getLink_title()
    {
      return this.link_title;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public int getType()
    {
      return this.type;
    }
    
    public void setDesc(String paramString)
    {
      this.desc = paramString;
    }
    
    public void setLink(String paramString)
    {
      this.link = paramString;
    }
    
    public void setLink_text(String paramString)
    {
      this.link_text = paramString;
    }
    
    public void setLink_title(String paramString)
    {
      this.link_title = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setType(int paramInt)
    {
      this.type = paramInt;
    }
    
    public String toString()
    {
      return "TypeExtra{type=" + this.type + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", link='" + this.link + '\'' + ", link_text='" + this.link_text + '\'' + ", link_title='" + this.link_title + '\'' + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/SelectCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */