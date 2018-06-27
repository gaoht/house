package cn.jiguang.c.c;

import java.util.HashMap;

final class i
{
  private static Integer[] a;
  private static final String z;
  private HashMap b;
  private HashMap c;
  private String d;
  private int e;
  private String f;
  private int g;
  private boolean h;
  
  static
  {
    int n = 0;
    Object localObject1 = "\035n\007~\022\000=HwG\006|Iv\002".toCharArray();
    int j = localObject1.length;
    int i;
    int m;
    int k;
    Object localObject2;
    if (j <= 1)
    {
      i = 0;
      m = i;
      for (k = i;; k = j)
      {
        localObject2 = localObject1;
        int i1 = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 103;
          localObject2[k] = ((char)(i ^ i1));
          m += 1;
          if (j != 0) {
            break label93;
          }
        }
      }
      label93:
      k = j;
      localObject2 = localObject1;
    }
    for (;;)
    {
      localObject1 = localObject2;
      j = k;
      i = m;
      if (k > m) {
        break;
      }
      z = new String((char[])localObject2).intern();
      a = new Integer[64];
      i = n;
      for (;;)
      {
        if (i < a.length)
        {
          a[i] = new Integer(i);
          i += 1;
          continue;
          i = 116;
          break;
          i = 29;
          break;
          i = 39;
          break;
          i = 17;
          break;
        }
      }
      return;
      m = 0;
      localObject2 = localObject1;
      k = j;
    }
  }
  
  public i(String paramString, int paramInt)
  {
    this.d = paramString;
    this.e = 3;
    this.b = new HashMap();
    this.c = new HashMap();
    this.g = Integer.MAX_VALUE;
  }
  
  private static Integer c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < a.length)) {
      return a[paramInt];
    }
    return new Integer(paramInt);
  }
  
  private void d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.g)) {
      throw new IllegalArgumentException(this.d + " " + paramInt + z);
    }
  }
  
  public final void a(int paramInt)
  {
    this.g = 3;
  }
  
  public final void a(int paramInt, String paramString)
  {
    d(paramInt);
    Integer localInteger = c(paramInt);
    String str;
    if (this.e == 2) {
      str = paramString.toUpperCase();
    }
    for (;;)
    {
      this.b.put(str, localInteger);
      this.c.put(localInteger, str);
      return;
      str = paramString;
      if (this.e == 3) {
        str = paramString.toLowerCase();
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.h = true;
  }
  
  public final String b(int paramInt)
  {
    d(paramInt);
    Object localObject = (String)this.c.get(c(paramInt));
    if (localObject != null) {}
    String str;
    do
    {
      return (String)localObject;
      str = Integer.toString(paramInt);
      localObject = str;
    } while (this.f == null);
    return this.f + str;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */