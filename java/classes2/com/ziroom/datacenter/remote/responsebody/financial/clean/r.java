package com.ziroom.datacenter.remote.responsebody.financial.clean;

import java.util.List;

public class r
{
  private List<Object> a;
  private List<Object> b;
  
  public List<Object> getPointItems()
  {
    return this.b;
  }
  
  public List<Object> getSelectItems()
  {
    return this.a;
  }
  
  public void setPointItems(List<Object> paramList)
  {
    this.b = paramList;
  }
  
  public void setSelectItems(List<Object> paramList)
  {
    this.a = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("selectItems:");
    if (this.a == null)
    {
      str = "";
      localStringBuilder = localStringBuilder.append(str).append(",pointItems:");
      if (this.b != null) {
        break label64;
      }
    }
    label64:
    for (String str = "";; str = this.b.toString())
    {
      return str;
      str = this.a.toString();
      break;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/clean/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */