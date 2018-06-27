package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.aa;
import com.megvii.zhimasdk.b.a.ab;
import com.megvii.zhimasdk.b.a.d.b;
import com.megvii.zhimasdk.b.a.j.c;
import com.megvii.zhimasdk.b.a.j.f;
import com.megvii.zhimasdk.b.a.k.j;
import com.megvii.zhimasdk.b.a.k.t;
import com.megvii.zhimasdk.b.a.p;
import com.megvii.zhimasdk.b.a.x;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T extends p>
  implements c<T>
{
  private final f a;
  protected final t b;
  private final b c;
  private final List<com.megvii.zhimasdk.b.a.o.d> d;
  private int e;
  private T f;
  
  @Deprecated
  public a(f paramf, t paramt, com.megvii.zhimasdk.b.a.l.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramf, "Session input buffer");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters");
    this.a = paramf;
    this.c = com.megvii.zhimasdk.b.a.l.d.a(parame);
    if (paramt != null) {}
    for (;;)
    {
      this.b = paramt;
      this.d = new ArrayList();
      this.e = 0;
      return;
      paramt = j.b;
    }
  }
  
  public static com.megvii.zhimasdk.b.a.e[] a(f paramf, int paramInt1, int paramInt2, t paramt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramt != null) {}
    for (;;)
    {
      return a(paramf, paramInt1, paramInt2, paramt, localArrayList);
      paramt = j.b;
    }
  }
  
  public static com.megvii.zhimasdk.b.a.e[] a(f paramf, int paramInt1, int paramInt2, t paramt, List<com.megvii.zhimasdk.b.a.o.d> paramList)
  {
    int j = 0;
    com.megvii.zhimasdk.b.a.o.a.a(paramf, "Session input buffer");
    com.megvii.zhimasdk.b.a.o.a.a(paramt, "Line parser");
    com.megvii.zhimasdk.b.a.o.a.a(paramList, "Header line list");
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      if (localObject1 == null) {
        localObject1 = new com.megvii.zhimasdk.b.a.o.d(64);
      }
      while ((paramf.a((com.megvii.zhimasdk.b.a.o.d)localObject1) == -1) || (((com.megvii.zhimasdk.b.a.o.d)localObject1).c() < 1))
      {
        paramf = new com.megvii.zhimasdk.b.a.e[paramList.size()];
        paramInt1 = j;
        while (paramInt1 < paramList.size())
        {
          localObject1 = (com.megvii.zhimasdk.b.a.o.d)paramList.get(paramInt1);
          try
          {
            paramf[paramInt1] = paramt.a((com.megvii.zhimasdk.b.a.o.d)localObject1);
            paramInt1 += 1;
          }
          catch (aa paramf)
          {
            int i;
            throw new ab(paramf.getMessage());
          }
        }
        ((com.megvii.zhimasdk.b.a.o.d)localObject1).a();
      }
      if (((((com.megvii.zhimasdk.b.a.o.d)localObject1).a(0) == ' ') || (((com.megvii.zhimasdk.b.a.o.d)localObject1).a(0) == '\t')) && (localObject2 != null))
      {
        i = 0;
        for (;;)
        {
          if (i < ((com.megvii.zhimasdk.b.a.o.d)localObject1).c())
          {
            int k = ((com.megvii.zhimasdk.b.a.o.d)localObject1).a(i);
            if ((k == 32) || (k == 9)) {}
          }
          else
          {
            if ((paramInt2 <= 0) || (((com.megvii.zhimasdk.b.a.o.d)localObject2).c() + 1 + ((com.megvii.zhimasdk.b.a.o.d)localObject1).c() - i <= paramInt2)) {
              break;
            }
            throw new x("Maximum line length limit exceeded");
          }
          i += 1;
        }
        ((com.megvii.zhimasdk.b.a.o.d)localObject2).a(' ');
        ((com.megvii.zhimasdk.b.a.o.d)localObject2).a((com.megvii.zhimasdk.b.a.o.d)localObject1, i, ((com.megvii.zhimasdk.b.a.o.d)localObject1).c() - i);
      }
      while ((paramInt1 > 0) && (paramList.size() >= paramInt1))
      {
        throw new x("Maximum header count exceeded");
        paramList.add(localObject1);
        Object localObject3 = null;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    return paramf;
  }
  
  public T a()
  {
    switch (this.e)
    {
    default: 
      throw new IllegalStateException("Inconsistent parser web_state");
    }
    try
    {
      this.f = b(this.a);
      this.e = 1;
      Object localObject = a(this.a, this.c.b(), this.c.a(), this.b, this.d);
      this.f.a((com.megvii.zhimasdk.b.a.e[])localObject);
      localObject = this.f;
      this.f = null;
      this.d.clear();
      this.e = 0;
      return (T)localObject;
    }
    catch (aa localaa)
    {
      throw new ab(localaa.getMessage(), localaa);
    }
  }
  
  protected abstract T b(f paramf);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */