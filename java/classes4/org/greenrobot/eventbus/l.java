package org.greenrobot.eventbus;

import java.lang.reflect.Method;

public class l
{
  final Method a;
  final ThreadMode b;
  final Class<?> c;
  final int d;
  final boolean e;
  String f;
  
  public l(Method paramMethod, Class<?> paramClass, ThreadMode paramThreadMode, int paramInt, boolean paramBoolean)
  {
    this.a = paramMethod;
    this.b = paramThreadMode;
    this.c = paramClass;
    this.d = paramInt;
    this.e = paramBoolean;
  }
  
  private void a()
  {
    try
    {
      if (this.f == null)
      {
        StringBuilder localStringBuilder = new StringBuilder(64);
        localStringBuilder.append(this.a.getDeclaringClass().getName());
        localStringBuilder.append('#').append(this.a.getName());
        localStringBuilder.append('(').append(this.c.getName());
        this.f = localStringBuilder.toString();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof l))
    {
      a();
      paramObject = (l)paramObject;
      ((l)paramObject).a();
      return this.f.equals(((l)paramObject).f);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */