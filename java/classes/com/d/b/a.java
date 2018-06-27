package com.d.b;

public abstract class a<T>
  extends d<T, Float>
{
  public a(String paramString)
  {
    super(Float.class, paramString);
  }
  
  public final void set(T paramT, Float paramFloat)
  {
    setValue(paramT, paramFloat.floatValue());
  }
  
  public abstract void setValue(T paramT, float paramFloat);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */