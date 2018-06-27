package d;

import javax.annotation.Nullable;

final class q
{
  @Nullable
  static p a;
  static long b;
  
  static p a()
  {
    try
    {
      if (a != null)
      {
        p localp = a;
        a = localp.f;
        localp.f = null;
        b -= 8192L;
        return localp;
      }
      return new p();
    }
    finally {}
  }
  
  static void a(p paramp)
  {
    if ((paramp.f != null) || (paramp.g != null)) {
      throw new IllegalArgumentException();
    }
    if (paramp.d) {
      return;
    }
    try
    {
      if (b + 8192L > 65536L) {
        return;
      }
    }
    finally {}
    b += 8192L;
    paramp.f = a;
    paramp.c = 0;
    paramp.b = 0;
    a = paramp;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/d/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */