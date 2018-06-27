package android.support.constraint.a;

import java.util.ArrayList;

public class d
{
  ArrayList<g> a = new ArrayList();
  
  private void b(e parame)
  {
    this.a.clear();
    int i = 1;
    if (i < parame.b)
    {
      g localg = parame.c.c[i];
      int j = 0;
      while (j < 6)
      {
        localg.e[j] = 0.0F;
        j += 1;
      }
      localg.e[localg.c] = 1.0F;
      if (localg.f != g.a.d) {}
      for (;;)
      {
        i += 1;
        break;
        this.a.add(localg);
      }
    }
  }
  
  g a()
  {
    int n = this.a.size();
    int m = 0;
    int j = 0;
    Object localObject1 = null;
    while (m < n)
    {
      g localg = (g)this.a.get(m);
      int i = 5;
      while (i >= 0)
      {
        float f = localg.e[i];
        int k = j;
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          k = j;
          localObject2 = localObject1;
          if (f < 0.0F)
          {
            k = j;
            localObject2 = localObject1;
            if (i >= j)
            {
              k = i;
              localObject2 = localg;
            }
          }
        }
        j = k;
        localObject1 = localObject2;
        if (f > 0.0F)
        {
          j = k;
          localObject1 = localObject2;
          if (i > k)
          {
            j = i;
            localObject1 = null;
          }
        }
        i -= 1;
      }
      m += 1;
    }
    return (g)localObject1;
  }
  
  void a(e parame)
  {
    b(parame);
    int m = this.a.size();
    int i = 0;
    while (i < m)
    {
      g localg1 = (g)this.a.get(i);
      if (localg1.b != -1)
      {
        a locala = parame.a(localg1.b).d;
        int n = locala.a;
        int j = 0;
        if (j < n)
        {
          g localg2 = locala.a(j);
          if (localg2 == null) {}
          for (;;)
          {
            j += 1;
            break;
            float f = locala.b(j);
            int k = 0;
            while (k < 6)
            {
              float[] arrayOfFloat = localg2.e;
              arrayOfFloat[k] += localg1.e[k] * f;
              k += 1;
            }
            if (!this.a.contains(localg2)) {
              this.a.add(localg2);
            }
          }
        }
        localg1.a();
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    int j = this.a.size();
    String str = "Goal: ";
    int i = 0;
    while (i < j)
    {
      g localg = (g)this.a.get(i);
      str = str + localg.b();
      i += 1;
    }
    return str;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */