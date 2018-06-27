package org.greenrobot.eventbus;

final class n
{
  final Object a;
  final l b;
  volatile boolean c;
  
  n(Object paramObject, l paraml)
  {
    this.a = paramObject;
    this.b = paraml;
    this.c = true;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof n))
    {
      paramObject = (n)paramObject;
      bool1 = bool2;
      if (this.a == ((n)paramObject).a)
      {
        bool1 = bool2;
        if (this.b.equals(((n)paramObject).b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() + this.b.f.hashCode();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */