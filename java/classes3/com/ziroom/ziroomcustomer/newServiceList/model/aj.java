package com.ziroom.ziroomcustomer.newServiceList.model;

import java.io.Serializable;
import java.util.List;

public class aj
  implements Serializable
{
  private String a;
  private List<a> b;
  
  public String getMaintainOrderCode()
  {
    return this.a;
  }
  
  public List<a> getTags()
  {
    return this.b;
  }
  
  public void setMaintainOrderCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setTags(List<a> paramList)
  {
    this.b = paramList;
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/model/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */