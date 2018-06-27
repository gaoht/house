package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.b.h;
import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class e
  implements h, Serializable
{
  private final TreeSet<b> a = new TreeSet(new d());
  
  public List<b> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.a);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(b paramb)
  {
    if (paramb != null) {}
    try
    {
      this.a.remove(paramb);
      if (!paramb.a(new Date())) {
        this.a.add(paramb);
      }
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public String toString()
  {
    try
    {
      String str = this.a.toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */