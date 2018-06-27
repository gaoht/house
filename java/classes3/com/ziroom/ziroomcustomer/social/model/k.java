package com.ziroom.ziroomcustomer.social.model;

import java.io.Serializable;
import java.util.List;

public class k
  implements Serializable
{
  private String a;
  private List<String> b;
  
  public String getDescription()
  {
    return this.a;
  }
  
  public List<String> getPhotos()
  {
    return this.b;
  }
  
  public void setDescription(String paramString)
  {
    this.a = paramString;
  }
  
  public void setPhotos(List<String> paramList)
  {
    this.b = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/model/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */