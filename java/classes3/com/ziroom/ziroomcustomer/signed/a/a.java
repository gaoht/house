package com.ziroom.ziroomcustomer.signed.a;

import java.io.Serializable;
import java.util.List;

public class a
  implements Serializable
{
  private String a;
  private float b;
  private List<a> c;
  
  public String getActivityCount()
  {
    return this.a;
  }
  
  public List<a> getActivityDetailList()
  {
    return this.c;
  }
  
  public float getActivityMoney()
  {
    return this.b;
  }
  
  public void setActivityCount(String paramString)
  {
    this.a = paramString;
  }
  
  public void setActivityDetailList(List<a> paramList)
  {
    this.c = paramList;
  }
  
  public void setActivityMoney(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public class a
    implements Serializable
  {
    private String b;
    private String c;
    
    public a() {}
    
    public String getActivityDescribe()
    {
      return this.b;
    }
    
    public String getActivityMoney()
    {
      return this.c;
    }
    
    public void setActivityDescribe(String paramString)
    {
      this.b = paramString;
    }
    
    public void setActivityMoney(String paramString)
    {
      this.c = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */