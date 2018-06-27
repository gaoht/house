package com.ziroom.ziroomcustomer.minsu.mapsojourn.model;

import android.os.Bundle;

public class c
{
  private String a;
  private Object b;
  private Bundle c;
  
  public c(String paramString)
  {
    this.a = paramString;
  }
  
  public c(String paramString, Bundle paramBundle)
  {
    this.a = paramString;
    this.c = paramBundle;
  }
  
  public c(String paramString, Object paramObject)
  {
    this.a = paramString;
    this.b = paramObject;
  }
  
  public c(String paramString, Object paramObject, Bundle paramBundle)
  {
    this.a = paramString;
    this.b = paramObject;
    this.c = paramBundle;
  }
  
  public Bundle getData()
  {
    return this.c;
  }
  
  public Object getTag()
  {
    return this.b;
  }
  
  public String getType()
  {
    return this.a;
  }
  
  public void setData(Bundle paramBundle)
  {
    this.c = paramBundle;
  }
  
  public void setTag(Object paramObject)
  {
    this.b = paramObject;
  }
  
  public void setType(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/model/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */