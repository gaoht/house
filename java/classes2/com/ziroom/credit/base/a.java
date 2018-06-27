package com.ziroom.credit.base;

import java.lang.ref.WeakReference;

public class a<T extends c>
  implements b
{
  protected WeakReference<T> a;
  
  public a(T paramT)
  {
    this.a = new WeakReference(paramT);
    paramT = getView();
    if (paramT != null) {
      paramT.setPresenter(this);
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
  
  public T getView()
  {
    if (this.a != null) {
      return (c)this.a.get();
    }
    return null;
  }
  
  public void start() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/base/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */