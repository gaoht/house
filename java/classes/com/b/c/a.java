package com.b.c;

public class a
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      if (paramStringBuilder.length() != 0) {
        paramStringBuilder.append(' ');
      }
      paramStringBuilder.append(paramInt).append(' ').append(paramString);
    } while (paramInt == 1);
    paramStringBuilder.append('s');
  }
  
  public static a fromPanasonicString(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    if ((paramString.length() != 19) || (paramString.startsWith("9999:99:99"))) {
      return null;
    }
    try
    {
      paramString = new a(Integer.parseInt(paramString.substring(0, 4)), Integer.parseInt(paramString.substring(5, 7)), Integer.parseInt(paramString.substring(8, 10)), Integer.parseInt(paramString.substring(11, 13)), Integer.parseInt(paramString.substring(14, 16)), Integer.parseInt(paramString.substring(17, 19)));
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
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
      paramObject = (a)paramObject;
      if (this.c != ((a)paramObject).c) {
        return false;
      }
      if (this.d != ((a)paramObject).d) {
        return false;
      }
      if (this.e != ((a)paramObject).e) {
        return false;
      }
      if (this.b != ((a)paramObject).b) {
        return false;
      }
      if (this.f != ((a)paramObject).f) {
        return false;
      }
    } while (this.a == ((a)paramObject).a);
    return false;
  }
  
  public int getDays()
  {
    return this.c;
  }
  
  public int getHours()
  {
    return this.d;
  }
  
  public int getMinutes()
  {
    return this.e;
  }
  
  public int getMonths()
  {
    return this.b;
  }
  
  public int getSeconds()
  {
    return this.f;
  }
  
  public int getYears()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    return ((((this.a * 31 + this.b) * 31 + this.c) * 31 + this.d) * 31 + this.e) * 31 + this.f;
  }
  
  public String toFriendlyString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, this.a, "year");
    a(localStringBuilder, this.b, "month");
    a(localStringBuilder, this.c, "day");
    a(localStringBuilder, this.d, "hour");
    a(localStringBuilder, this.e, "minute");
    a(localStringBuilder, this.f, "second");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return String.format("%04d:%02d:%02d %02d:%02d:%02d", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f) });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */