package org.greenrobot.eventbus.util;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
{
  public final Map<Class<? extends Throwable>, Integer> a = new HashMap();
  
  protected Integer a(Throwable paramThrowable)
  {
    Class localClass = paramThrowable.getClass();
    paramThrowable = (Integer)this.a.get(localClass);
    Object localObject2;
    if (paramThrowable == null)
    {
      Object localObject1 = null;
      Iterator localIterator = this.a.entrySet().iterator();
      localObject2 = paramThrowable;
      if (!localIterator.hasNext()) {
        break label117;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localObject2 = (Class)localEntry.getKey();
      if ((!((Class)localObject2).isAssignableFrom(localClass)) || ((localObject1 != null) && (!((Class)localObject1).isAssignableFrom((Class)localObject2)))) {
        break label119;
      }
      paramThrowable = (Integer)localEntry.getValue();
      localObject1 = localObject2;
    }
    label117:
    label119:
    for (;;)
    {
      break;
      localObject2 = paramThrowable;
      return (Integer)localObject2;
    }
  }
  
  public c addMapping(Class<? extends Throwable> paramClass, int paramInt)
  {
    this.a.put(paramClass, Integer.valueOf(paramInt));
    return this;
  }
  
  public Integer mapThrowable(Throwable paramThrowable)
  {
    int i = 20;
    Object localObject1 = paramThrowable;
    Object localObject2;
    do
    {
      localObject2 = a((Throwable)localObject1);
      if (localObject2 != null) {
        return (Integer)localObject2;
      }
      localObject2 = ((Throwable)localObject1).getCause();
      i -= 1;
      if ((i <= 0) || (localObject2 == paramThrowable)) {
        break;
      }
      localObject1 = localObject2;
    } while (localObject2 != null);
    Log.d(org.greenrobot.eventbus.c.a, "No specific message ressource ID found for " + paramThrowable);
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */