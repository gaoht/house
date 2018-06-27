package com.ziroom.ziroomcustomer.flux;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static b a;
  private final List<c> b = new ArrayList();
  
  private void a(a parama)
  {
    if (parama.getTarget() != null) {
      b(parama);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).onAction(parama);
      }
    }
  }
  
  private void b(a parama)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a(parama);
    }
  }
  
  public static b get()
  {
    if (a == null) {
      a = new b();
    }
    return a;
  }
  
  public void dispatch(a parama)
  {
    a(parama);
  }
  
  public void dispatchWithTarget(a parama, Object paramObject)
  {
    if (paramObject != null)
    {
      b(new a(parama.getType(), parama.getData(), paramObject));
      return;
    }
    a(parama);
  }
  
  public void register(c paramc)
  {
    this.b.add(paramc);
  }
  
  public void unregister(c paramc)
  {
    this.b.remove(paramc);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/flux/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */