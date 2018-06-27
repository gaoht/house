package com.xiaomi.network;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class b
  extends Fallback
{
  Fallback i = this.j;
  
  b(HostManager paramHostManager, String paramString, Fallback paramFallback)
  {
    super(paramString);
    this.b = this.b;
    if (this.j != null) {
      this.f = this.j.f;
    }
  }
  
  public ArrayList<String> a(boolean paramBoolean)
  {
    ArrayList localArrayList3;
    for (;;)
    {
      try
      {
        localArrayList3 = new ArrayList();
        if (this.i != null) {
          localArrayList3.addAll(this.i.a(true));
        }
        synchronized (HostManager.mReservedHosts)
        {
          Object localObject3 = (ArrayList)HostManager.mReservedHosts.get(this.b);
          if (localObject3 == null) {
            break label159;
          }
          if (this.i != null)
          {
            ArrayList localArrayList1 = this.i.a(false);
            localObject3 = ((ArrayList)localObject3).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            String str = (String)((Iterator)localObject3).next();
            if (localArrayList1.indexOf(str) != -1) {
              continue;
            }
            localArrayList3.add(str);
          }
        }
        ArrayList localArrayList2 = localArrayList3;
      }
      finally {}
    }
    localArrayList3.remove(this.b);
    localArrayList3.add(this.b);
    label159:
    return localArrayList3;
  }
  
  public void a(String paramString, AccessHistory paramAccessHistory)
  {
    try
    {
      if (this.i != null) {
        this.i.a(paramString, paramAccessHistory);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/network/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */