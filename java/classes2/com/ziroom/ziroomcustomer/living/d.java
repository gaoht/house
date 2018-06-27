package com.ziroom.ziroomcustomer.living;

import java.io.Serializable;

public class d
  implements Serializable
{
  private String a;
  private String b;
  private int c;
  private int d;
  
  public String getExpensesCategory()
  {
    return this.a;
  }
  
  public String getExpensesCategoryName()
  {
    return this.b;
  }
  
  public int getNumOfThis()
  {
    return this.d;
  }
  
  public int getShouldPayAmount()
  {
    return this.c;
  }
  
  public void setExpensesCategory(String paramString)
  {
    this.a = paramString;
  }
  
  public void setExpensesCategoryName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setNumOfThis(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setShouldPayAmount(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */