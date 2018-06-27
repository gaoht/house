package com.ziroom.ziroomcustomer.payment.views.wheelview;

public class a<T>
  implements d
{
  private T[] a;
  private int b;
  
  public a(T[] paramArrayOfT)
  {
    this(paramArrayOfT, -1);
  }
  
  public a(T[] paramArrayOfT, int paramInt)
  {
    this.a = paramArrayOfT;
    this.b = paramInt;
  }
  
  public String getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.length)) {
      return this.a[paramInt].toString();
    }
    return null;
  }
  
  public int getItemsCount()
  {
    return this.a.length;
  }
  
  public int getMaximumLength()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/views/wheelview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */