package android.support.v7.widget;

import java.util.List;

class ae
{
  final a a;
  
  ae(a parama)
  {
    this.a = parama;
  }
  
  private void a(List<d.b> paramList, int paramInt1, int paramInt2)
  {
    d.b localb1 = (d.b)paramList.get(paramInt1);
    d.b localb2 = (d.b)paramList.get(paramInt2);
    switch (localb2.a)
    {
    case 3: 
    default: 
      return;
    case 2: 
      a(paramList, paramInt1, localb1, paramInt2, localb2);
      return;
    case 1: 
      c(paramList, paramInt1, localb1, paramInt2, localb2);
      return;
    }
    b(paramList, paramInt1, localb1, paramInt2, localb2);
  }
  
  private int b(List<d.b> paramList)
  {
    int i = 0;
    int j = paramList.size() - 1;
    if (j >= 0)
    {
      if (((d.b)paramList.get(j)).a == 8)
      {
        if (i == 0) {
          break label50;
        }
        return j;
      }
      i = 1;
    }
    label50:
    for (;;)
    {
      j -= 1;
      break;
      return -1;
    }
  }
  
  private void c(List<d.b> paramList, int paramInt1, d.b paramb1, int paramInt2, d.b paramb2)
  {
    int i = 0;
    if (paramb1.d < paramb2.b) {
      i = -1;
    }
    int j = i;
    if (paramb1.b < paramb2.b) {
      j = i + 1;
    }
    if (paramb2.b <= paramb1.b) {
      paramb1.b += paramb2.d;
    }
    if (paramb2.b <= paramb1.d) {
      paramb1.d += paramb2.d;
    }
    paramb2.b = (j + paramb2.b);
    paramList.set(paramInt1, paramb2);
    paramList.set(paramInt2, paramb1);
  }
  
  void a(List<d.b> paramList)
  {
    for (;;)
    {
      int i = b(paramList);
      if (i == -1) {
        break;
      }
      a(paramList, i, i + 1);
    }
  }
  
  void a(List<d.b> paramList, int paramInt1, d.b paramb1, int paramInt2, d.b paramb2)
  {
    int j = 0;
    int i;
    if (paramb1.b < paramb1.d)
    {
      if ((paramb2.b != paramb1.b) || (paramb2.d != paramb1.d - paramb1.b)) {
        break label623;
      }
      i = 1;
    }
    for (;;)
    {
      label70:
      d.b localb;
      if (paramb1.d < paramb2.b)
      {
        paramb2.b -= 1;
        if (paramb1.b > paramb2.b) {
          break label241;
        }
        paramb2.b += 1;
        localb = null;
      }
      for (;;)
      {
        label97:
        if (i != 0)
        {
          paramList.set(paramInt1, paramb2);
          paramList.remove(paramInt2);
          this.a.recycleUpdateOp(paramb1);
        }
        label241:
        label596:
        label606:
        for (;;)
        {
          return;
          if ((paramb2.b != paramb1.d + 1) || (paramb2.d != paramb1.b - paramb1.d)) {
            break label614;
          }
          j = 1;
          i = 1;
          break;
          if (paramb1.d >= paramb2.b + paramb2.d) {
            break label70;
          }
          paramb2.d -= 1;
          paramb1.a = 2;
          paramb1.d = 1;
          if (paramb2.d == 0)
          {
            paramList.remove(paramInt2);
            this.a.recycleUpdateOp(paramb2);
            return;
            if (paramb1.b >= paramb2.b + paramb2.d) {
              break label608;
            }
            int k = paramb2.b;
            int m = paramb2.d;
            int n = paramb1.b;
            localb = this.a.obtainUpdateOp(2, paramb1.b + 1, k + m - n, null);
            paramb2.d = (paramb1.b - paramb2.b);
            break label97;
            if (j != 0)
            {
              if (localb != null)
              {
                if (paramb1.b > localb.b) {
                  paramb1.b -= localb.d;
                }
                if (paramb1.d > localb.b) {
                  paramb1.d -= localb.d;
                }
              }
              if (paramb1.b > paramb2.b) {
                paramb1.b -= paramb2.d;
              }
              if (paramb1.d > paramb2.b) {
                paramb1.d -= paramb2.d;
              }
              paramList.set(paramInt1, paramb2);
              if (paramb1.b == paramb1.d) {
                break label596;
              }
              paramList.set(paramInt2, paramb1);
            }
            for (;;)
            {
              if (localb == null) {
                break label606;
              }
              paramList.add(paramInt1, localb);
              return;
              if (localb != null)
              {
                if (paramb1.b >= localb.b) {
                  paramb1.b -= localb.d;
                }
                if (paramb1.d >= localb.b) {
                  paramb1.d -= localb.d;
                }
              }
              if (paramb1.b >= paramb2.b) {
                paramb1.b -= paramb2.d;
              }
              if (paramb1.d < paramb2.b) {
                break;
              }
              paramb1.d -= paramb2.d;
              break;
              paramList.remove(paramInt2);
            }
          }
        }
        label608:
        localb = null;
      }
      label614:
      i = 0;
      j = 1;
      continue;
      label623:
      i = 0;
    }
  }
  
  void b(List<d.b> paramList, int paramInt1, d.b paramb1, int paramInt2, d.b paramb2)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramb1.d < paramb2.b)
    {
      paramb2.b -= 1;
      localObject1 = null;
    }
    for (;;)
    {
      if (paramb1.b <= paramb2.b)
      {
        paramb2.b += 1;
        label54:
        paramList.set(paramInt2, paramb1);
        if (paramb2.d <= 0) {
          break label243;
        }
        paramList.set(paramInt1, paramb2);
      }
      for (;;)
      {
        if (localObject1 != null) {
          paramList.add(paramInt1, localObject1);
        }
        if (localObject2 != null) {
          paramList.add(paramInt1, localObject2);
        }
        return;
        if (paramb1.d >= paramb2.b + paramb2.d) {
          break label265;
        }
        paramb2.d -= 1;
        localObject1 = this.a.obtainUpdateOp(4, paramb1.b, 1, paramb2.c);
        break;
        if (paramb1.b >= paramb2.b + paramb2.d) {
          break label54;
        }
        int i = paramb2.b + paramb2.d - paramb1.b;
        localObject2 = this.a.obtainUpdateOp(4, paramb1.b + 1, i, paramb2.c);
        paramb2.d -= i;
        break label54;
        label243:
        paramList.remove(paramInt1);
        this.a.recycleUpdateOp(paramb2);
      }
      label265:
      localObject1 = null;
    }
  }
  
  static abstract interface a
  {
    public abstract d.b obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
    
    public abstract void recycleUpdateOp(d.b paramb);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */