package com.d.b;

public abstract class d<T, V>
{
  private final String a;
  private final Class<V> b;
  
  public d(Class<V> paramClass, String paramString)
  {
    this.a = paramString;
    this.b = paramClass;
  }
  
  public static <T, V> d<T, V> of(Class<T> paramClass, Class<V> paramClass1, String paramString)
  {
    return new e(paramClass, paramClass1, paramString);
  }
  
  public abstract V get(T paramT);
  
  public String getName()
  {
    return this.a;
  }
  
  public Class<V> getType()
  {
    return this.b;
  }
  
  public boolean isReadOnly()
  {
    return false;
  }
  
  public void set(T paramT, V paramV)
  {
    throw new UnsupportedOperationException("Property " + getName() + " is read-only");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */