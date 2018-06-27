package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.aa;
import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.af;
import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.v;

public class j
  implements t
{
  @Deprecated
  public static final j a = new j();
  public static final j b = new j();
  protected final ac c;
  
  public j()
  {
    this(null);
  }
  
  public j(ac paramac)
  {
    if (paramac != null) {}
    for (;;)
    {
      this.c = paramac;
      return;
      paramac = v.c;
    }
  }
  
  protected ac a(int paramInt1, int paramInt2)
  {
    return this.c.a(paramInt1, paramInt2);
  }
  
  public ac a(com.megvii.zhimasdk.b.a.o.d paramd, u paramu)
  {
    int m = 1;
    a.a(paramd, "Char array buffer");
    a.a(paramu, "Parser cursor");
    String str = this.c.a();
    int i1 = str.length();
    n = paramu.b();
    k = paramu.a();
    d(paramd, paramu);
    int i2 = paramu.b();
    if (i2 + i1 + 4 > k) {
      throw new aa("Not a valid protocol version: " + paramd.a(n, k));
    }
    int j = 0;
    int i = 1;
    if ((i != 0) && (j < i1))
    {
      if (paramd.a(i2 + j) == str.charAt(j)) {}
      for (i = 1;; i = 0)
      {
        j += 1;
        break;
      }
    }
    if (i != 0)
    {
      if (paramd.a(i2 + i1) == '/') {
        i = m;
      }
      for (;;)
      {
        if (i == 0)
        {
          throw new aa("Not a valid protocol version: " + paramd.a(n, k));
          i = 0;
          continue;
        }
        j = i1 + 1 + i2;
        i = paramd.a(46, j, k);
        if (i == -1) {
          throw new aa("Invalid protocol version number: " + paramd.a(n, k));
        }
        try
        {
          m = Integer.parseInt(paramd.b(j, i));
          i1 = i + 1;
          j = paramd.a(32, i1, k);
          i = j;
          if (j == -1) {
            i = k;
          }
        }
        catch (NumberFormatException paramu)
        {
          try
          {
            j = Integer.parseInt(paramd.b(i1, i));
            paramu.a(i);
            return a(m, j);
          }
          catch (NumberFormatException paramu)
          {
            throw new aa("Invalid protocol minor version number: " + paramd.a(n, k));
          }
          paramu = paramu;
          throw new aa("Invalid protocol major version number: " + paramd.a(n, k));
        }
      }
    }
  }
  
  protected af a(ac paramac, int paramInt, String paramString)
  {
    return new n(paramac, paramInt, paramString);
  }
  
  public e a(com.megvii.zhimasdk.b.a.o.d paramd)
  {
    return new p(paramd);
  }
  
  public boolean b(com.megvii.zhimasdk.b.a.o.d paramd, u paramu)
  {
    boolean bool2 = true;
    a.a(paramd, "Char array buffer");
    a.a(paramu, "Parser cursor");
    int j = paramu.b();
    paramu = this.c.a();
    int k = paramu.length();
    if (paramd.c() < k + 4) {
      break label65;
    }
    int i;
    label65:
    while (i + k + 4 > paramd.c())
    {
      return false;
      if (j >= 0) {
        break;
      }
      i = paramd.c() - 4 - k;
    }
    j = 0;
    boolean bool1 = true;
    label84:
    if ((bool1) && (j < k))
    {
      if (paramd.a(i + j) == paramu.charAt(j)) {}
      for (bool1 = true;; bool1 = false)
      {
        j += 1;
        break label84;
        i = j;
        if (j != 0) {
          break;
        }
        for (;;)
        {
          i = j;
          if (j >= paramd.c()) {
            break;
          }
          i = j;
          if (!com.megvii.zhimasdk.b.a.n.d.a(paramd.a(j))) {
            break;
          }
          j += 1;
        }
      }
    }
    if (bool1) {
      if (paramd.a(i + k) == '/') {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public af c(com.megvii.zhimasdk.b.a.o.d paramd, u paramu)
  {
    a.a(paramd, "Char array buffer");
    a.a(paramu, "Parser cursor");
    int m = paramu.b();
    int k = paramu.a();
    label174:
    label245:
    for (;;)
    {
      ac localac;
      int j;
      int i;
      try
      {
        localac = a(paramd, paramu);
        d(paramd, paramu);
        j = paramu.b();
        i = paramd.a(32, j, k);
        if (i >= 0) {
          break label245;
        }
        i = k;
        paramu = paramd.b(j, i);
        j = 0;
        if (j >= paramu.length()) {
          break label174;
        }
        if (!Character.isDigit(paramu.charAt(j))) {
          throw new aa("Status line contains invalid status code: " + paramd.a(m, k));
        }
      }
      catch (IndexOutOfBoundsException paramu)
      {
        throw new aa("Invalid status line: " + paramd.a(m, k));
      }
      j += 1;
      continue;
      for (;;)
      {
        try
        {
          j = Integer.parseInt(paramu);
          if (i < k)
          {
            paramu = paramd.b(i, k);
            return a(localac, j, paramu);
          }
        }
        catch (NumberFormatException paramu)
        {
          throw new aa("Status line contains invalid status code: " + paramd.a(m, k));
        }
        paramu = "";
      }
    }
  }
  
  protected void d(com.megvii.zhimasdk.b.a.o.d paramd, u paramu)
  {
    int i = paramu.b();
    int j = paramu.a();
    while ((i < j) && (com.megvii.zhimasdk.b.a.n.d.a(paramd.a(i)))) {
      i += 1;
    }
    paramu.a(i);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */