package com.ziroom.ziroomcustomer.findhouse.model;

import java.util.List;

public class ZZBizcircle
{
  List<Bizcircle> bizcircle;
  String district_code = "";
  String district_name = "";
  
  public List<Bizcircle> getBizcircle()
  {
    return this.bizcircle;
  }
  
  public String getDistrict_code()
  {
    return this.district_code;
  }
  
  public String getDistrict_name()
  {
    return this.district_name;
  }
  
  public void setBizcircle(List<Bizcircle> paramList)
  {
    this.bizcircle = paramList;
  }
  
  public void setDistrict_code(String paramString)
  {
    this.district_code = paramString;
  }
  
  public void setDistrict_name(String paramString)
  {
    this.district_name = paramString;
  }
  
  public String toString()
  {
    return "ZZBizcircle{district_name='" + this.district_name + '\'' + ", bizcircle=" + this.bizcircle + '}';
  }
  
  public class Bizcircle
  {
    String bizcircle_code;
    String bizcircle_name;
    
    public Bizcircle() {}
    
    public String getBizcircle_code()
    {
      return this.bizcircle_code;
    }
    
    public String getBizcircle_name()
    {
      return this.bizcircle_name;
    }
    
    public void setBizcircle_code(String paramString)
    {
      this.bizcircle_code = paramString;
    }
    
    public void setBizcircle_name(String paramString)
    {
      this.bizcircle_name = paramString;
    }
    
    public String toString()
    {
      return "Bizcircle{bizcircle_code='" + this.bizcircle_code + '\'' + ", bizcircle_name='" + this.bizcircle_name + '\'' + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/ZZBizcircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */