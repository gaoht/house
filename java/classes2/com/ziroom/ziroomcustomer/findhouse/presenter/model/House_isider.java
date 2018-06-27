package com.ziroom.ziroomcustomer.findhouse.presenter.model;

import java.util.ArrayList;

public class House_isider
{
  private float area;
  private ArrayList<HouseConfig> config;
  private String face;
  private ArrayList<String> photos_big;
  private ArrayList<String> photos_min;
  private ArrayList<HouseTags> tags;
  private String title;
  private String type;
  
  public float getArea()
  {
    return this.area;
  }
  
  public ArrayList<HouseConfig> getConfig()
  {
    return this.config;
  }
  
  public String getFace()
  {
    return this.face;
  }
  
  public ArrayList<String> getPhotos_big()
  {
    return this.photos_big;
  }
  
  public ArrayList<String> getPhotos_min()
  {
    return this.photos_min;
  }
  
  public ArrayList<HouseTags> getTags()
  {
    return this.tags;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setArea(float paramFloat)
  {
    this.area = paramFloat;
  }
  
  public void setConfig(ArrayList<HouseConfig> paramArrayList)
  {
    this.config = paramArrayList;
  }
  
  public void setFace(String paramString)
  {
    this.face = paramString;
  }
  
  public void setPhotos_big(ArrayList<String> paramArrayList)
  {
    this.photos_big = paramArrayList;
  }
  
  public void setPhotos_min(ArrayList<String> paramArrayList)
  {
    this.photos_min = paramArrayList;
  }
  
  public void setTags(ArrayList<HouseTags> paramArrayList)
  {
    this.tags = paramArrayList;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public String toString()
  {
    return "House_isider [type=" + this.type + ", title=" + this.title + ", photos_min=" + this.photos_min + ", photos_big=" + this.photos_big + ", area=" + this.area + ", face=" + this.face + ", tags=" + this.tags + ", Config=" + this.config + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/model/House_isider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */