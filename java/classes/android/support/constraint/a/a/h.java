package android.support.constraint.a.a;

import java.util.ArrayList;

public class h
  extends b
{
  protected ArrayList<b> aj = new ArrayList();
  
  public h() {}
  
  public h(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static f getBounds(ArrayList<b> paramArrayList)
  {
    int i2 = Integer.MAX_VALUE;
    f localf = new f();
    if (paramArrayList.size() == 0) {
      return localf;
    }
    int i4 = paramArrayList.size();
    int j = 0;
    int i = 0;
    int m = 0;
    int i3 = Integer.MAX_VALUE;
    int k;
    int n;
    int i1;
    if (j < i4)
    {
      b localb = (b)paramArrayList.get(j);
      k = i3;
      if (localb.getX() < i3) {
        k = localb.getX();
      }
      n = i2;
      if (localb.getY() < i2) {
        n = localb.getY();
      }
      i1 = m;
      if (localb.getRight() > m) {
        i1 = localb.getRight();
      }
      if (localb.getBottom() <= i) {
        break label171;
      }
      i = localb.getBottom();
    }
    label171:
    for (;;)
    {
      j += 1;
      i3 = k;
      i2 = n;
      m = i1;
      break;
      localf.setBounds(i3, i2, m - i3, i - i2);
      return localf;
    }
  }
  
  public void add(b paramb)
  {
    this.aj.add(paramb);
    if (paramb.getParent() != null) {
      ((h)paramb.getParent()).remove(paramb);
    }
    paramb.setParent(this);
  }
  
  public b findWidget(float paramFloat1, float paramFloat2)
  {
    Object localObject2 = null;
    int i = getDrawX();
    int j = getDrawY();
    int k = getWidth();
    int m = getHeight();
    Object localObject1 = localObject2;
    if (paramFloat1 >= i)
    {
      localObject1 = localObject2;
      if (paramFloat1 <= k + i)
      {
        localObject1 = localObject2;
        if (paramFloat2 >= j)
        {
          localObject1 = localObject2;
          if (paramFloat2 <= m + j) {
            localObject1 = this;
          }
        }
      }
    }
    j = this.aj.size();
    i = 0;
    b localb;
    if (i < j)
    {
      localb = (b)this.aj.get(i);
      if ((localb instanceof h))
      {
        localObject2 = ((h)localb).findWidget(paramFloat1, paramFloat2);
        if (localObject2 == null) {
          break label247;
        }
        localObject1 = localObject2;
      }
    }
    label247:
    for (;;)
    {
      localObject2 = localObject1;
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        k = localb.getDrawX();
        m = localb.getDrawY();
        int n = localb.getWidth();
        int i1 = localb.getHeight();
        localObject2 = localObject1;
        if (paramFloat1 >= k)
        {
          localObject2 = localObject1;
          if (paramFloat1 <= n + k)
          {
            localObject2 = localObject1;
            if (paramFloat2 >= m)
            {
              localObject2 = localObject1;
              if (paramFloat2 <= i1 + m) {
                localObject2 = localb;
              }
            }
          }
        }
      }
      return (b)localObject1;
    }
  }
  
  public ArrayList<b> findWidgets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList();
    f localf1 = new f();
    localf1.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = this.aj.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      b localb = (b)this.aj.get(paramInt1);
      f localf2 = new f();
      localf2.setBounds(localb.getDrawX(), localb.getDrawY(), localb.getWidth(), localb.getHeight());
      if (localf1.a(localf2)) {
        localArrayList.add(localb);
      }
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  public ArrayList<b> getChildren()
  {
    return this.aj;
  }
  
  public c getRootConstraintContainer()
  {
    Object localObject = getParent();
    c localc;
    if ((this instanceof c)) {
      localc = (c)this;
    }
    for (;;)
    {
      b localb;
      if (localObject != null)
      {
        localb = ((b)localObject).getParent();
        if ((localObject instanceof c))
        {
          localc = (c)localObject;
          localObject = localb;
        }
      }
      else
      {
        return localc;
      }
      localObject = localb;
      continue;
      localc = null;
    }
  }
  
  public void layout()
  {
    updateDrawPosition();
    if (this.aj == null) {}
    for (;;)
    {
      return;
      int j = this.aj.size();
      int i = 0;
      while (i < j)
      {
        b localb = (b)this.aj.get(i);
        if ((localb instanceof h)) {
          ((h)localb).layout();
        }
        i += 1;
      }
    }
  }
  
  public void remove(b paramb)
  {
    this.aj.remove(paramb);
    paramb.setParent(null);
  }
  
  public void removeAllChildren()
  {
    this.aj.clear();
  }
  
  public void reset()
  {
    this.aj.clear();
    super.reset();
  }
  
  public void resetGroups()
  {
    super.resetGroups();
    int j = this.aj.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.aj.get(i)).resetGroups();
      i += 1;
    }
  }
  
  public void resetSolverVariables(android.support.constraint.a.c paramc)
  {
    super.resetSolverVariables(paramc);
    int j = this.aj.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.aj.get(i)).resetSolverVariables(paramc);
      i += 1;
    }
  }
  
  public void setOffset(int paramInt1, int paramInt2)
  {
    super.setOffset(paramInt1, paramInt2);
    paramInt2 = this.aj.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      ((b)this.aj.get(paramInt1)).setOffset(a(), b());
      paramInt1 += 1;
    }
  }
  
  public void updateDrawPosition()
  {
    super.updateDrawPosition();
    if (this.aj == null) {}
    for (;;)
    {
      return;
      int j = this.aj.size();
      int i = 0;
      while (i < j)
      {
        b localb = (b)this.aj.get(i);
        localb.setOffset(getDrawX(), getDrawY());
        if (!(localb instanceof c)) {
          localb.updateDrawPosition();
        }
        i += 1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */