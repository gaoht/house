package com.ziroom.datacenter.remote.responsebody.financial.b;

import com.ziroom.datacenter.a.a;
import java.io.Serializable;
import java.util.List;

public class b
  implements Serializable
{
  @a
  private List<b> a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public String getApp()
  {
    return this.b;
  }
  
  public List<b> getBanner()
  {
    return this.a;
  }
  
  public String getDescription()
  {
    return this.d;
  }
  
  public String getImg()
  {
    return this.f;
  }
  
  public String getTarget()
  {
    return this.e;
  }
  
  public String getTitle()
  {
    return this.c;
  }
  
  public void setApp(String paramString)
  {
    this.b = paramString;
  }
  
  public void setBanner(List<b> paramList)
  {
    this.a = paramList;
  }
  
  public void setDescription(String paramString)
  {
    this.d = paramString;
  }
  
  public void setImg(String paramString)
  {
    this.f = paramString;
  }
  
  public void setTarget(String paramString)
  {
    this.e = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */