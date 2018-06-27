package cn.testin.analysis;

import android.view.View;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class ct
  extends cm
{
  private final cz a;
  private final cz b;
  private final WeakHashMap<View, Object> c;
  
  public ct(cz paramcz1, cz paramcz2)
  {
    this.a = paramcz1;
    this.b = paramcz2;
    this.c = new WeakHashMap();
  }
  
  public void a()
  {
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      View localView = (View)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      try
      {
        this.a.b(localView, new Object[] { localObject });
      }
      catch (df localdf)
      {
        ar.a(localdf);
      }
    }
    this.c.clear();
  }
  
  public void a(View paramView)
  {
    Object localObject1 = null;
    Object localObject2;
    Object localObject4;
    if (this.b != null)
    {
      localObject2 = this.a.a();
      if (1 == localObject2.length) {
        localObject4 = localObject2[0];
      }
    }
    try
    {
      localObject2 = this.b.a(paramView);
      localObject1 = localObject2;
      localObject2 = null;
    }
    catch (df localdf)
    {
      Object localObject3;
      for (;;) {}
    }
    localObject3 = localObject1;
    if ("getTextSize".equals(this.b.b())) {
      localObject3 = Float.valueOf(al.a(((Float)localObject1).floatValue()));
    }
    if (localObject4 == localObject3) {}
    while ((localObject4 != null) && ((localObject4.equals(localObject3)) || (((localObject3 instanceof CharSequence)) && (localObject4.equals(localObject3.toString()))))) {
      return;
    }
    if (!this.c.containsKey(paramView))
    {
      if ((!(this.a instanceof dc)) && (!(this.a instanceof db)) && (!(this.a instanceof dd))) {
        break label188;
      }
      this.c.put(paramView, this.a.b(paramView));
    }
    for (;;)
    {
      try
      {
        this.a.a(paramView);
        return;
      }
      catch (df paramView)
      {
        return;
      }
      label188:
      if ((this.a.a(new Object[] { localObject3 })) && (localObject2 == null)) {
        this.c.put(paramView, localObject3);
      }
    }
  }
  
  protected String b()
  {
    return this.a.b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */