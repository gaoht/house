package com.ziroom.ziroomcustomer.base.a;

import org.json.JSONObject;

public class b
{
  protected String a = "";
  protected String b = "";
  protected double c = 39.915073D;
  protected double d = 116.403945D;
  protected JSONObject e;
  
  public String getCode()
  {
    return this.b;
  }
  
  public JSONObject getExtra()
  {
    return this.e;
  }
  
  public double getLat()
  {
    return this.c;
  }
  
  public double getLng()
  {
    return this.d;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public void setCode(String paramString)
  {
    this.b = paramString;
  }
  
  public void setExtra(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
  }
  
  public void setLat(double paramDouble)
  {
    this.c = paramDouble;
  }
  
  public void setLng(double paramDouble)
  {
    this.d = paramDouble;
  }
  
  public void setName(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/base/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */