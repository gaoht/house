package cn.testin.analysis;

import android.util.LruCache;

class cj
  extends LruCache<Class<?>, String>
{
  public cj(int paramInt)
  {
    super(paramInt);
  }
  
  protected String a(Class<?> paramClass)
  {
    return paramClass.getCanonicalName();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */