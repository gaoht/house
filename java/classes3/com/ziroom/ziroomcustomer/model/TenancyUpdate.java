package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class TenancyUpdate
  implements Serializable
{
  private String isZWhite;
  private int is_blank;
  private List<Integer> payments;
  
  public TenancyUpdate(List<Integer> paramList, int paramInt, String paramString)
  {
    this.payments = paramList;
    this.is_blank = paramInt;
    this.isZWhite = paramString;
  }
  
  public String getIsZWhite()
  {
    return this.isZWhite;
  }
  
  public int getIs_blank()
  {
    return this.is_blank;
  }
  
  public List<Integer> getPayments()
  {
    return this.payments;
  }
  
  public void setIsZWhite(String paramString)
  {
    this.isZWhite = paramString;
  }
  
  public void setIs_blank(int paramInt)
  {
    this.is_blank = paramInt;
  }
  
  public void setPayments(List<Integer> paramList)
  {
    this.payments = paramList;
  }
  
  public String toString()
  {
    return "TenancyUpdate [payments=" + this.payments + ", is_blank=" + this.is_blank + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/TenancyUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */