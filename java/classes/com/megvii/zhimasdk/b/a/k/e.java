package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.f;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.d;
import com.megvii.zhimasdk.b.a.y;

public class e
{
  @Deprecated
  public static final e a = new e();
  public static final e b = new e();
  
  protected int a(f paramf)
  {
    int k = 0;
    int j;
    if (paramf == null) {
      j = 0;
    }
    int i;
    int m;
    do
    {
      return j;
      j = paramf.a().length();
      String str = paramf.b();
      i = j;
      if (str != null) {
        i = j + (str.length() + 3);
      }
      m = paramf.d();
      j = i;
    } while (m <= 0);
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += a(paramf.a(k)) + 2;
      k += 1;
    }
  }
  
  protected int a(y paramy)
  {
    int i;
    if (paramy == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = paramy.a().length();
      paramy = paramy.b();
      i = j;
    } while (paramy == null);
    return j + (paramy.length() + 3);
  }
  
  protected int a(y[] paramArrayOfy)
  {
    int i = 0;
    int k = i;
    if (paramArrayOfy != null)
    {
      if (paramArrayOfy.length < 1) {
        k = i;
      }
    }
    else {
      return k;
    }
    i = paramArrayOfy.length;
    int m = paramArrayOfy.length;
    i = (i - 1) * 2;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = a(paramArrayOfy[j]);
      j += 1;
      i = k + i;
    }
  }
  
  public d a(d paramd, f paramf, boolean paramBoolean)
  {
    a.a(paramf, "Header element");
    int i = a(paramf);
    if (paramd == null) {
      paramd = new d(i);
    }
    for (;;)
    {
      paramd.a(paramf.a());
      String str = paramf.b();
      if (str != null)
      {
        paramd.a('=');
        a(paramd, str, paramBoolean);
      }
      int j = paramf.d();
      if (j <= 0) {
        break;
      }
      i = 0;
      while (i < j)
      {
        paramd.a("; ");
        a(paramd, paramf.a(i), paramBoolean);
        i += 1;
      }
      paramd.b(i);
    }
    return paramd;
  }
  
  public d a(d paramd, y paramy, boolean paramBoolean)
  {
    a.a(paramy, "Name / value pair");
    int i = a(paramy);
    if (paramd == null) {
      paramd = new d(i);
    }
    for (;;)
    {
      paramd.a(paramy.a());
      paramy = paramy.b();
      if (paramy != null)
      {
        paramd.a('=');
        a(paramd, paramy, paramBoolean);
      }
      return paramd;
      paramd.b(i);
    }
  }
  
  public d a(d paramd, y[] paramArrayOfy, boolean paramBoolean)
  {
    a.a(paramArrayOfy, "Header parameter array");
    int i = a(paramArrayOfy);
    if (paramd == null) {
      paramd = new d(i);
    }
    for (;;)
    {
      i = 0;
      while (i < paramArrayOfy.length)
      {
        if (i > 0) {
          paramd.a("; ");
        }
        a(paramd, paramArrayOfy[i], paramBoolean);
        i += 1;
      }
      paramd.b(i);
    }
    return paramd;
  }
  
  protected void a(d paramd, String paramString, boolean paramBoolean)
  {
    int j = 0;
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      i = 0;
      for (;;)
      {
        bool = paramBoolean;
        if (i >= paramString.length()) {
          break;
        }
        bool = paramBoolean;
        if (paramBoolean) {
          break;
        }
        paramBoolean = a(paramString.charAt(i));
        i += 1;
      }
    }
    int i = j;
    if (bool)
    {
      paramd.a('"');
      i = j;
    }
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (b(c)) {
        paramd.a('\\');
      }
      paramd.a(c);
      i += 1;
    }
    if (bool) {
      paramd.a('"');
    }
  }
  
  protected boolean a(char paramChar)
  {
    return " ;,:@()<>\\\"/[]?={}\t".indexOf(paramChar) >= 0;
  }
  
  protected boolean b(char paramChar)
  {
    return "\"\\".indexOf(paramChar) >= 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */