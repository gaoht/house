package com.mato.sdk.b;

import com.mato.sdk.e.b.g;

public abstract class a
{
  private static a a;
  private static a b;
  
  static
  {
    a local1 = new a() {};
    a = local1;
    b = local1;
  }
  
  public static a a()
  {
    return b;
  }
  
  private static void a(a parama)
  {
    a locala = parama;
    if (parama == null) {
      locala = a;
    }
    b = locala;
  }
  
  public static String b()
  {
    return "";
  }
  
  public static boolean c()
  {
    return false;
  }
  
  public static boolean d()
  {
    return false;
  }
  
  public static g e()
  {
    return null;
  }
  
  public static boolean f()
  {
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */