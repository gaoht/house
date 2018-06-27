package com.ziroom.datacenter.remote.responsebody.financial.repair;

import java.io.Serializable;
import java.util.List;

public class i
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private int f;
  private List<String> g;
  private boolean h;
  private String i;
  private Integer j;
  private Integer k;
  
  public Integer getApp()
  {
    return this.j;
  }
  
  public Integer getOpen()
  {
    return this.k;
  }
  
  public String getPicUrl()
  {
    return this.c;
  }
  
  public String getPriceRemark()
  {
    return this.d;
  }
  
  public List<String> getProDescs()
  {
    return this.g;
  }
  
  public String getRemark()
  {
    return this.e;
  }
  
  public String getServiceInfoId()
  {
    return this.a;
  }
  
  public String getServiceInfoName()
  {
    return this.b;
  }
  
  public int getSuggest()
  {
    return this.f;
  }
  
  public String getTargetUrl()
  {
    return this.i;
  }
  
  public boolean isZhengZu()
  {
    return this.h;
  }
  
  public void setApp(Integer paramInteger)
  {
    this.j = paramInteger;
  }
  
  public void setIsZhengZu(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setOpen(Integer paramInteger)
  {
    this.k = paramInteger;
  }
  
  public void setPicUrl(String paramString)
  {
    this.c = paramString;
  }
  
  public void setPriceRemark(String paramString)
  {
    this.d = paramString;
  }
  
  public void setProDescs(List<String> paramList)
  {
    this.g = paramList;
  }
  
  public void setRemark(String paramString)
  {
    this.e = paramString;
  }
  
  public void setServiceInfoId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setServiceInfoName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setSuggest(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setTargetUrl(String paramString)
  {
    this.i = paramString;
  }
  
  public void setZhengZu(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/repair/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */