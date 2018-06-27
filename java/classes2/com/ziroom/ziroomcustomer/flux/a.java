package com.ziroom.ziroomcustomer.flux;

public class a<T>
{
  private final String a;
  private final T b;
  private final String c;
  
  public a(String paramString, T paramT)
  {
    this(paramString, paramT, null);
  }
  
  public a(String paramString, T paramT, Object paramObject)
  {
    this.a = paramString;
    this.b = paramT;
    if (paramObject != null)
    {
      this.c = paramObject.getClass().getName();
      return;
    }
    this.c = null;
  }
  
  public T getData()
  {
    return (T)this.b;
  }
  
  public String getTarget()
  {
    return this.c;
  }
  
  public String getType()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/flux/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */