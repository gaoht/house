package com.ziroom.datacenter.remote.responsebody.financial.repair;

import java.io.Serializable;
import java.util.List;

public class q
  implements Serializable
{
  private String a = "";
  private int b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private int h;
  private int i;
  private List<r> j;
  private boolean k;
  
  public String getLockSupEmpId()
  {
    return this.g;
  }
  
  public String getLockSupplierId()
  {
    return this.f;
  }
  
  public String getOrderTime()
  {
    return this.a;
  }
  
  public String getOrderTimeInterval()
  {
    return this.c;
  }
  
  public int getOrderTimePeriod()
  {
    return this.b;
  }
  
  public int getQuery_object_index()
  {
    return this.h;
  }
  
  public int getQuery_reason_index()
  {
    return this.i;
  }
  
  public String getSupEmpId()
  {
    return this.e;
  }
  
  public String getSupplierId()
  {
    return this.d;
  }
  
  public List<r> getWxxmList()
  {
    return this.j;
  }
  
  public boolean isDone()
  {
    return this.k;
  }
  
  public void setDone(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setLockSupEmpId(String paramString)
  {
    this.g = paramString;
  }
  
  public void setLockSupplierId(String paramString)
  {
    this.f = paramString;
  }
  
  public void setOrderTime(String paramString)
  {
    this.a = paramString;
  }
  
  public void setOrderTimeInterval(String paramString)
  {
    this.c = paramString;
  }
  
  public void setOrderTimePeriod(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setQuery_object_index(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setQuery_reason_index(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setSupEmpId(String paramString)
  {
    this.e = paramString;
  }
  
  public void setSupplierId(String paramString)
  {
    this.d = paramString;
  }
  
  public void setWxxmList(List<r> paramList)
  {
    this.j = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/repair/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */