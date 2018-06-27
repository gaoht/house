package com.b.c;

public class c
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final String e;
  private final a f;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, a parama)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramString;
    this.f = parama;
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
      paramObject = (c)paramObject;
      if (this.d != ((c)paramObject).d) {
        return false;
      }
      if (this.c != ((c)paramObject).c) {
        return false;
      }
      if (this.a != ((c)paramObject).a) {
        return false;
      }
      if (this.b != ((c)paramObject).b) {
        return false;
      }
      if (this.f != null)
      {
        if (this.f.equals(((c)paramObject).f)) {}
      }
      else {
        while (((c)paramObject).f != null) {
          return false;
        }
      }
      if (this.e == null) {
        break;
      }
    } while (this.e.equals(((c)paramObject).e));
    for (;;)
    {
      return false;
      if (((c)paramObject).e == null) {
        break;
      }
    }
  }
  
  public a getAge()
  {
    return this.f;
  }
  
  public int getHeight()
  {
    return this.d;
  }
  
  public String getName()
  {
    return this.e;
  }
  
  public int getWidth()
  {
    return this.c;
  }
  
  public int getX()
  {
    return this.a;
  }
  
  public int getY()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = this.a;
    int m = this.b;
    int n = this.c;
    int i1 = this.d;
    if (this.e != null) {}
    for (int i = this.e.hashCode();; i = 0)
    {
      if (this.f != null) {
        j = this.f.hashCode();
      }
      return (i + (((k * 31 + m) * 31 + n) * 31 + i1) * 31) * 31 + j;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("x: ").append(this.a);
    localStringBuilder.append(" y: ").append(this.b);
    localStringBuilder.append(" width: ").append(this.c);
    localStringBuilder.append(" height: ").append(this.d);
    if (this.e != null) {
      localStringBuilder.append(" name: ").append(this.e);
    }
    if (this.f != null) {
      localStringBuilder.append(" age: ").append(this.f.toFriendlyString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */