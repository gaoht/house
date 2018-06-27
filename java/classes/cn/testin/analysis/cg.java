package cn.testin.analysis;

import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class cg<T>
{
  private Set<T> a = new HashSet();
  
  public void a(T paramT)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }
    this.a.remove(paramT);
  }
  
  public Set<T> b()
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }
    return Collections.unmodifiableSet(this.a);
  }
  
  public void b(T paramT)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("Can't add an activity when not on the UI thread");
    }
    this.a.add(paramT);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */