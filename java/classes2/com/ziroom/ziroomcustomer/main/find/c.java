package com.ziroom.ziroomcustomer.main.find;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class c
  implements b.a
{
  WeakReference<b.b> a;
  
  public c(b.b paramb)
  {
    this.a = new WeakReference(paramb);
    paramb = getView();
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
  
  public b.b getView()
  {
    if (this.a != null) {
      return (b.b)this.a.get();
    }
    return null;
  }
  
  public void start()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("友家整租");
    localArrayList.add("自如寓");
    localArrayList.add("旅居");
    if (getView() != null) {
      getView().setLines(localArrayList);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/main/find/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */