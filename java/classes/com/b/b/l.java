package com.b.b;

import java.io.Serializable;

public class l
  extends Number
  implements Serializable
{
  private final long a;
  private final long b;
  
  public l(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  private boolean a()
  {
    return (Math.min(this.b, this.a) - 1L) / 5.0D + 2.0D > 1000.0D;
  }
  
  public final byte byteValue()
  {
    return (byte)(int)doubleValue();
  }
  
  public double doubleValue()
  {
    if (this.a == 0L) {
      return 0.0D;
    }
    return this.a / this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof l))) {}
    do
    {
      return false;
      paramObject = (l)paramObject;
    } while (doubleValue() != ((l)paramObject).doubleValue());
    return true;
  }
  
  public float floatValue()
  {
    if (this.a == 0L) {
      return 0.0F;
    }
    return (float)this.a / (float)this.b;
  }
  
  public final long getDenominator()
  {
    return this.b;
  }
  
  public final long getNumerator()
  {
    return this.a;
  }
  
  public l getReciprocal()
  {
    return new l(this.b, this.a);
  }
  
  public l getSimplifiedInstance()
  {
    if (a()) {
      return this;
    }
    int i = 2;
    label11:
    if (i <= Math.min(this.b, this.a)) {
      if (((i % 2 != 0) || (i <= 2)) && ((i % 5 != 0) || (i <= 5))) {
        break label57;
      }
    }
    label57:
    while ((this.b % i != 0L) || (this.a % i != 0L))
    {
      i += 1;
      break label11;
      break;
    }
    return new l(this.a / i, this.b / i);
  }
  
  public int hashCode()
  {
    return (int)this.b * 23 + (int)this.a;
  }
  
  public final int intValue()
  {
    return (int)doubleValue();
  }
  
  public boolean isInteger()
  {
    return (this.b == 1L) || ((this.b != 0L) && (this.a % this.b == 0L)) || ((this.b == 0L) && (this.a == 0L));
  }
  
  public final long longValue()
  {
    return doubleValue();
  }
  
  public final short shortValue()
  {
    return (short)(int)doubleValue();
  }
  
  public String toSimpleString(boolean paramBoolean)
  {
    Object localObject;
    if ((this.b == 0L) && (this.a != 0L)) {
      localObject = toString();
    }
    l locall;
    String str;
    do
    {
      return (String)localObject;
      if (isInteger()) {
        return Integer.toString(intValue());
      }
      if ((this.a != 1L) && (this.b % this.a == 0L)) {
        return new l(1L, this.b / this.a).toSimpleString(paramBoolean);
      }
      locall = getSimplifiedInstance();
      if (!paramBoolean) {
        break;
      }
      str = Double.toString(locall.doubleValue());
      localObject = str;
    } while (str.length() < 5);
    return locall.toString();
  }
  
  public String toString()
  {
    return this.a + "/" + this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */