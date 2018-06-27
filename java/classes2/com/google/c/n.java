package com.google.c;

public class n
{
  private final float a;
  private final float b;
  
  public n(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  private static float a(n paramn1, n paramn2, n paramn3)
  {
    float f1 = paramn2.a;
    float f2 = paramn2.b;
    float f3 = paramn3.a;
    float f4 = paramn1.b;
    float f5 = paramn3.b;
    return (f3 - f1) * (f4 - f2) - (paramn1.a - f1) * (f5 - f2);
  }
  
  public static float distance(n paramn1, n paramn2)
  {
    float f1 = paramn1.a - paramn2.a;
    float f2 = paramn1.b - paramn2.b;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public static void orderBestPatterns(n[] paramArrayOfn)
  {
    float f1 = distance(paramArrayOfn[0], paramArrayOfn[1]);
    float f2 = distance(paramArrayOfn[1], paramArrayOfn[2]);
    float f3 = distance(paramArrayOfn[0], paramArrayOfn[2]);
    n localn;
    Object localObject2;
    Object localObject1;
    if ((f2 >= f1) && (f2 >= f3))
    {
      localn = paramArrayOfn[0];
      localObject2 = paramArrayOfn[1];
      localObject1 = paramArrayOfn[2];
      if (a((n)localObject2, localn, (n)localObject1) >= 0.0F) {
        break label135;
      }
    }
    for (;;)
    {
      paramArrayOfn[0] = localObject1;
      paramArrayOfn[1] = localn;
      paramArrayOfn[2] = localObject2;
      return;
      if ((f3 >= f2) && (f3 >= f1))
      {
        localn = paramArrayOfn[1];
        localObject2 = paramArrayOfn[0];
        localObject1 = paramArrayOfn[2];
        break;
      }
      localn = paramArrayOfn[2];
      localObject2 = paramArrayOfn[0];
      localObject1 = paramArrayOfn[1];
      break;
      label135:
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
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
        if (this.b == ((n)paramObject).b) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final float getX()
  {
    return this.a;
  }
  
  public final float getY()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(this.a) * 31 + Float.floatToIntBits(this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(25);
    localStringBuilder.append('(');
    localStringBuilder.append(this.a);
    localStringBuilder.append(',');
    localStringBuilder.append(this.b);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */