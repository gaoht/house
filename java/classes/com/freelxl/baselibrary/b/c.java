package com.freelxl.baselibrary.b;

public class c
{
  private static volatile c a;
  private a b;
  
  public static c getInstance()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new c();
      }
      return a;
    }
    finally {}
  }
  
  public int[] LoadImageRes()
  {
    return this.b.getmImageRess();
  }
  
  public Boolean LogSwitch()
  {
    return this.b.getLOG_SWITCH();
  }
  
  public String getIvString()
  {
    return this.b.getIvString();
  }
  
  public String getKeyString()
  {
    return this.b.getKeyString();
  }
  
  public void init(a parama)
  {
    if (parama == null) {
      try
      {
        throw new IllegalArgumentException("Baselibrary configuration can not be initialized with null");
      }
      finally {}
    }
    if (this.b == null) {
      this.b = parama;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */