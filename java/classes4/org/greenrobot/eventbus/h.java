package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

final class h
{
  private static final List<h> d = new ArrayList();
  Object a;
  n b;
  h c;
  
  private h(Object paramObject, n paramn)
  {
    this.a = paramObject;
    this.b = paramn;
  }
  
  static h a(n paramn, Object paramObject)
  {
    synchronized (d)
    {
      int i = d.size();
      if (i > 0)
      {
        h localh = (h)d.remove(i - 1);
        localh.a = paramObject;
        localh.b = paramn;
        localh.c = null;
        return localh;
      }
      return new h(paramObject, paramn);
    }
  }
  
  static void a(h paramh)
  {
    paramh.a = null;
    paramh.b = null;
    paramh.c = null;
    synchronized (d)
    {
      if (d.size() < 10000) {
        d.add(paramh);
      }
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */