package com.ziroom.ziroomcustomer.main.find.zra;

import java.lang.ref.WeakReference;

public class b
  implements a.a
{
  WeakReference<a.b> a;
  
  public b(a.b paramb)
  {
    this.a = new WeakReference(paramb);
    paramb = (a.b)this.a.get();
    if (paramb != null) {
      paramb.setPresenter(this);
    }
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public a.b getView()
  {
    if (this.a != null) {
      return (a.b)this.a.get();
    }
    return null;
  }
  
  public void start() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/main/find/zra/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */