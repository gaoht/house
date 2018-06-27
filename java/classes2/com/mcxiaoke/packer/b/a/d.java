package com.mcxiaoke.packer.b.a;

final class d<A, B>
{
  private final A a;
  private final B b;
  
  private d(A paramA, B paramB)
  {
    this.a = paramA;
    this.b = paramB;
  }
  
  public static <A, B> d<A, B> of(A paramA, B paramB)
  {
    return new d(paramA, paramB);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (d)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(((d)paramObject).a)) {}
      }
      else {
        while (((d)paramObject).a != null) {
          return false;
        }
      }
      if (this.b != null) {
        return this.b.equals(((d)paramObject).b);
      }
    } while (((d)paramObject).b == null);
    return false;
  }
  
  public A getFirst()
  {
    return (A)this.a;
  }
  
  public B getSecond()
  {
    return (B)this.b;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.a != null) {}
    for (int i = this.a.hashCode();; i = 0)
    {
      if (this.b != null) {
        j = this.b.hashCode();
      }
      return i * 31 + j;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mcxiaoke/packer/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */