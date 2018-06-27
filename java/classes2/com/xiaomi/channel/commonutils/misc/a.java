package com.xiaomi.channel.commonutils.misc;

public class a
{
  public static final String a;
  public static final boolean b;
  public static final boolean c;
  public static final boolean d;
  public static final boolean e;
  public static boolean f;
  public static final boolean g;
  public static final boolean h;
  private static int i = 1;
  
  static
  {
    boolean bool2 = false;
    String str;
    if (c.a)
    {
      str = "ONEBOX";
      a = str;
      b = a.contains("2A2FE0D7");
      if ((!b) && (!"DEBUG".equalsIgnoreCase(a))) {
        break label146;
      }
    }
    label146:
    for (boolean bool1 = true;; bool1 = false)
    {
      c = bool1;
      d = "LOGABLE".equalsIgnoreCase(a);
      e = a.contains("YY");
      f = a.equalsIgnoreCase("TEST");
      g = "BETA".equalsIgnoreCase(a);
      bool1 = bool2;
      if (a != null)
      {
        bool1 = bool2;
        if (a.startsWith("RC")) {
          bool1 = true;
        }
      }
      h = bool1;
      i = 1;
      if (!a.equalsIgnoreCase("SANDBOX")) {
        break label151;
      }
      i = 2;
      return;
      str = "@SHIP.TO.2A2FE0D7@";
      break;
    }
    label151:
    if (a.equalsIgnoreCase("ONEBOX"))
    {
      i = 3;
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    i = paramInt;
  }
  
  public static boolean a()
  {
    return i == 2;
  }
  
  public static boolean b()
  {
    return i == 3;
  }
  
  public static int c()
  {
    return i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/misc/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */