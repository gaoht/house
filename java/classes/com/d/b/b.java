package com.d.b;

public abstract class b<T>
  extends d<T, Integer>
{
  public b(String paramString)
  {
    super(Integer.class, paramString);
  }
  
  public final void set(T paramT, Integer paramInteger)
  {
    set(paramT, Integer.valueOf(paramInteger.intValue()));
  }
  
  public abstract void setValue(T paramT, int paramInt);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */