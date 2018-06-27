package com.b.c.c.a;

import com.b.c.g;

public class m
  extends g<n>
{
  public m(n paramn)
  {
    super(paramn);
  }
  
  private String a()
  {
    return a(800, "%d C");
  }
  
  private String b()
  {
    return b(787);
  }
  
  private String c()
  {
    return b(786);
  }
  
  private String d()
  {
    return b(785);
  }
  
  private String e()
  {
    return a(772, new String[] { "Auto or Manual", "Daylight", "Fluorescent", "Tungsten", "Flash", "Cloudy", "Shadow" });
  }
  
  private String f()
  {
    return a(768, 1, new String[] { "User Profile 1", "User Profile 2", "User Profile 3", "User Profile 0 (Dynamic)" });
  }
  
  private String g()
  {
    return a(768, 1, new String[] { "Fine", "Basic" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 768: 
      return g();
    case 770: 
      return f();
    case 772: 
      return e();
    case 785: 
      return d();
    case 786: 
      return c();
    case 787: 
      return b();
    case 800: 
      return a();
    }
    return b(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */