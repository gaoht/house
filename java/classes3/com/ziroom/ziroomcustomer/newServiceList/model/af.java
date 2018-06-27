package com.ziroom.ziroomcustomer.newServiceList.model;

import java.io.Serializable;
import java.util.List;

public class af
  implements Serializable
{
  private String a;
  private int b;
  private String c;
  private int d;
  private String e;
  private String f;
  private String g;
  private String h;
  private List<a> i;
  private List<b> j;
  
  public String getEvaluateProjectCode()
  {
    return this.a;
  }
  
  public int getEvaluateScore()
  {
    return this.b;
  }
  
  public List<a> getNegativeTags()
  {
    return this.i;
  }
  
  public List<b> getPositiveTags()
  {
    return this.j;
  }
  
  public String getProductName()
  {
    return this.c;
  }
  
  public int getServiceNum()
  {
    return this.d;
  }
  
  public String getServicerCode()
  {
    return this.e;
  }
  
  public String getServicerHeadPath()
  {
    return this.f;
  }
  
  public String getServicerName()
  {
    return this.g;
  }
  
  public String getServicerPhone()
  {
    return this.h;
  }
  
  public void setEvaluateProjectCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setEvaluateScore(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setNegativeTags(List<a> paramList)
  {
    this.i = paramList;
  }
  
  public void setPositiveTags(List<b> paramList)
  {
    this.j = paramList;
  }
  
  public void setProductName(String paramString)
  {
    this.c = paramString;
  }
  
  public void setServiceNum(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setServicerCode(String paramString)
  {
    this.e = paramString;
  }
  
  public void setServicerHeadPath(String paramString)
  {
    this.f = paramString;
  }
  
  public void setServicerName(String paramString)
  {
    this.g = paramString;
  }
  
  public void setServicerPhone(String paramString)
  {
    this.h = paramString;
  }
  
  public static class a
  {
    private String a;
    private int b;
    private String c;
    
    public String getEnumName()
    {
      return this.a;
    }
    
    public int getTagKey()
    {
      return this.b;
    }
    
    public String getTagValue()
    {
      return this.c;
    }
    
    public void setEnumName(String paramString)
    {
      this.a = paramString;
    }
    
    public void setTagKey(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void setTagValue(String paramString)
    {
      this.c = paramString;
    }
  }
  
  public static class b
  {
    private String a;
    private int b;
    private String c;
    
    public String getEnumName()
    {
      return this.a;
    }
    
    public int getTagKey()
    {
      return this.b;
    }
    
    public String getTagValue()
    {
      return this.c;
    }
    
    public void setEnumName(String paramString)
    {
      this.a = paramString;
    }
    
    public void setTagKey(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void setTagValue(String paramString)
    {
      this.c = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/model/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */