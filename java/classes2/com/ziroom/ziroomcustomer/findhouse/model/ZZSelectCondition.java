package com.ziroom.ziroomcustomer.findhouse.model;

import java.util.List;

public class ZZSelectCondition
{
  List<SelectBean> bedroom;
  List<SelectBean> config;
  List<SelectBean> face;
  List<SelectBean> feature;
  List<SelectBean> price;
  List<SelectBean> sort;
  List<SelectBean> style;
  
  public List<SelectBean> getBedroom()
  {
    return this.bedroom;
  }
  
  public List<SelectBean> getConfig()
  {
    return this.config;
  }
  
  public List<SelectBean> getFace()
  {
    return this.face;
  }
  
  public List<SelectBean> getFeature()
  {
    return this.feature;
  }
  
  public List<SelectBean> getPrice()
  {
    return this.price;
  }
  
  public List<SelectBean> getSort()
  {
    return this.sort;
  }
  
  public List<SelectBean> getStyle()
  {
    return this.style;
  }
  
  public void setBedroom(List<SelectBean> paramList)
  {
    this.bedroom = paramList;
  }
  
  public void setConfig(List<SelectBean> paramList)
  {
    this.config = paramList;
  }
  
  public void setFace(List<SelectBean> paramList)
  {
    this.face = paramList;
  }
  
  public void setFeature(List<SelectBean> paramList)
  {
    this.feature = paramList;
  }
  
  public void setPrice(List<SelectBean> paramList)
  {
    this.price = paramList;
  }
  
  public void setSort(List<SelectBean> paramList)
  {
    this.sort = paramList;
  }
  
  public void setStyle(List<SelectBean> paramList)
  {
    this.style = paramList;
  }
  
  public String toString()
  {
    return "ZZSelectCondition{bedroom=" + this.bedroom + ", price=" + this.price + ", sort=" + this.sort + ", face=" + this.face + ", style=" + this.style + ", Config=" + this.config + ", feature=" + this.feature + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/ZZSelectCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */