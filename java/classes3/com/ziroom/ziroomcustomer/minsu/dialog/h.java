package com.ziroom.ziroomcustomer.minsu.dialog;

public enum h
{
  private int c = 0;
  
  private h(int paramInt)
  {
    this.c = paramInt;
  }
  
  public static h valueOf(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return a;
    }
    return b;
  }
  
  public boolean isCustomer()
  {
    return false;
  }
  
  public boolean isLandlord()
  {
    return false;
  }
  
  public int value()
  {
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/dialog/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */