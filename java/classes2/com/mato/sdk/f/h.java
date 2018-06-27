package com.mato.sdk.f;

public final class h<T>
{
  public final T a;
  public final Throwable b;
  
  private h(T paramT)
  {
    this.a = paramT;
    this.b = null;
  }
  
  private h(Throwable paramThrowable)
  {
    this.a = null;
    this.b = paramThrowable;
  }
  
  public static <T> h<T> a(T paramT)
  {
    return new h(paramT);
  }
  
  public static <T> h<T> a(Throwable paramThrowable)
  {
    return new h(paramThrowable);
  }
  
  public final boolean a()
  {
    return this.b == null;
  }
  
  public static abstract interface a
  {
    public abstract void a(Throwable paramThrowable);
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(T paramT);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */