package com.b.a.j;

public class a
{
  public static final a a = new a("BYTE", 1, 1);
  public static final a b = new a("STRING", 2, 1);
  public static final a c = new a("USHORT", 3, 2);
  public static final a d = new a("ULONG", 4, 4);
  public static final a e = new a("URATIONAL", 5, 8);
  public static final a f = new a("SBYTE", 6, 1);
  public static final a g = new a("UNDEFINED", 7, 1);
  public static final a h = new a("SSHORT", 8, 2);
  public static final a i = new a("SLONG", 9, 4);
  public static final a j = new a("SRATIONAL", 10, 8);
  public static final a k = new a("SINGLE", 11, 4);
  public static final a l = new a("DOUBLE", 12, 8);
  private final String m;
  private final int n;
  private final int o;
  
  private a(String paramString, int paramInt1, int paramInt2)
  {
    this.m = paramString;
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  public static a fromTiffFormatCode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return a;
    case 2: 
      return b;
    case 3: 
      return c;
    case 4: 
      return d;
    case 5: 
      return e;
    case 6: 
      return f;
    case 7: 
      return g;
    case 8: 
      return h;
    case 9: 
      return i;
    case 10: 
      return j;
    case 11: 
      return k;
    }
    return l;
  }
  
  public int getComponentSizeBytes()
  {
    return this.o;
  }
  
  public int getTiffFormatCode()
  {
    return this.n;
  }
  
  public String toString()
  {
    return this.m;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/j/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */