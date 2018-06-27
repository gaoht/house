package com.ziroom.datacenter.remote.responsebody.financial.clean;

import java.util.List;

public class c
{
  private String a;
  private int b;
  private List<CleanAcarusItem> c;
  private List<CleanAcarusItem> d;
  
  public int getChumanServicePrice()
  {
    return this.b;
  }
  
  public String getDesc()
  {
    return this.a;
  }
  
  public List<CleanAcarusItem> getMAreaGoodsVOs()
  {
    return this.d;
  }
  
  public List<CleanAcarusItem> getNAreaGoodsVOs()
  {
    return this.c;
  }
  
  public void setChumanServicePrice(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setDesc(String paramString)
  {
    this.a = paramString;
  }
  
  public void setMAreaGoodsVOs(List<CleanAcarusItem> paramList)
  {
    this.d = paramList;
  }
  
  public void setNAreaGoodsVOs(List<CleanAcarusItem> paramList)
  {
    this.c = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/clean/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */