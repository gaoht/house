package android.support.constraint.a;

import java.util.Arrays;

public class g
{
  private static int i = 1;
  public int a = -1;
  int b = -1;
  public int c = 0;
  public float d;
  float[] e = new float[6];
  a f;
  b[] g = new b[8];
  int h = 0;
  private String j;
  
  public g(a parama)
  {
    this.f = parama;
  }
  
  public g(String paramString, a parama)
  {
    this.j = paramString;
    this.f = parama;
  }
  
  void a()
  {
    int k = 0;
    while (k < 6)
    {
      this.e[k] = 0.0F;
      k += 1;
    }
  }
  
  void a(b paramb)
  {
    int k = 0;
    while (k < this.h)
    {
      if (this.g[k] == paramb) {
        return;
      }
      k += 1;
    }
    if (this.h >= this.g.length) {
      this.g = ((b[])Arrays.copyOf(this.g, this.g.length * 2));
    }
    this.g[this.h] = paramb;
    this.h += 1;
  }
  
  String b()
  {
    String str = this + "[";
    int k = 0;
    if (k < this.e.length)
    {
      str = str + this.e[k];
      if (k < this.e.length - 1) {}
      for (str = str + ", ";; str = str + "] ")
      {
        k += 1;
        break;
      }
    }
    return str;
  }
  
  void b(b paramb)
  {
    int m = 0;
    int k = 0;
    for (;;)
    {
      if (k < this.h)
      {
        if (this.g[k] == paramb)
        {
          while (m < this.h - k - 1)
          {
            this.g[(k + m)] = this.g[(k + m + 1)];
            m += 1;
          }
          this.h -= 1;
        }
      }
      else {
        return;
      }
      k += 1;
    }
  }
  
  public String getName()
  {
    return this.j;
  }
  
  public void reset()
  {
    this.j = null;
    this.f = a.e;
    this.c = 0;
    this.a = -1;
    this.b = -1;
    this.d = 0.0F;
    this.h = 0;
  }
  
  public void setName(String paramString)
  {
    this.j = paramString;
  }
  
  public void setType(a parama)
  {
    this.f = parama;
  }
  
  public String toString()
  {
    return "" + this.j;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */