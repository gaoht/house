package com.ziroom.ziroomcustomer.minsu;

import java.lang.ref.WeakReference;

public class c<T>
  implements a
{
  private WeakReference<T> a;
  
  public c(T paramT)
  {
    this.a = new WeakReference(paramT);
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public T getView()
  {
    if (this.a != null) {
      return (T)this.a.get();
    }
    return null;
  }
  
  public void start() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */