package android.support.constraint.a.a;

import android.support.constraint.a.c;
import android.support.constraint.a.g;
import android.support.constraint.a.g.a;
import java.util.ArrayList;
import java.util.HashSet;

public class a
{
  final b a;
  final c b;
  a c;
  public int d = 0;
  int e = -1;
  g f;
  int g = Integer.MAX_VALUE;
  private b h = b.a;
  private a i = a.a;
  private int j = 0;
  
  public a(b paramb, c paramc)
  {
    this.a = paramb;
    this.b = paramc;
  }
  
  private String a(HashSet<a> paramHashSet)
  {
    if (paramHashSet.add(this))
    {
      StringBuilder localStringBuilder = new StringBuilder().append(this.a.getDebugName()).append(":").append(this.b.toString());
      if (this.c != null) {}
      for (paramHashSet = " connected to " + this.c.a(paramHashSet);; paramHashSet = "") {
        return paramHashSet;
      }
    }
    return "<-";
  }
  
  private boolean a(b paramb, HashSet<b> paramHashSet)
  {
    if (paramHashSet.contains(paramb)) {
      return false;
    }
    paramHashSet.add(paramb);
    if (paramb == getOwner()) {
      return true;
    }
    paramb = paramb.getAnchors();
    int m = paramb.size();
    int k = 0;
    while (k < m)
    {
      a locala = (a)paramb.get(k);
      if ((locala.isSimilarDimensionConnection(this)) && (locala.isConnected()) && (a(locala.getTarget().getOwner(), paramHashSet))) {
        return true;
      }
      k += 1;
    }
    return false;
  }
  
  public boolean connect(a parama, int paramInt)
  {
    return connect(parama, paramInt, -1, b.b, 0, false);
  }
  
  public boolean connect(a parama, int paramInt1, int paramInt2)
  {
    return connect(parama, paramInt1, -1, b.b, paramInt2, false);
  }
  
  public boolean connect(a parama, int paramInt1, int paramInt2, b paramb, int paramInt3, boolean paramBoolean)
  {
    if (parama == null)
    {
      this.c = null;
      this.d = 0;
      this.e = -1;
      this.h = b.a;
      this.j = 2;
      return true;
    }
    if ((!paramBoolean) && (!isValidConnection(parama))) {
      return false;
    }
    this.c = parama;
    if (paramInt1 > 0) {}
    for (this.d = paramInt1;; this.d = 0)
    {
      this.e = paramInt2;
      this.h = paramb;
      this.j = paramInt3;
      return true;
    }
  }
  
  public boolean connect(a parama, int paramInt1, b paramb, int paramInt2)
  {
    return connect(parama, paramInt1, -1, paramb, paramInt2, false);
  }
  
  public int getConnectionCreator()
  {
    return this.j;
  }
  
  public a getConnectionType()
  {
    return this.i;
  }
  
  public int getGroup()
  {
    return this.g;
  }
  
  public int getMargin()
  {
    if (this.a.getVisibility() == 8) {
      return 0;
    }
    if ((this.e > -1) && (this.c != null) && (this.c.a.getVisibility() == 8)) {
      return this.e;
    }
    return this.d;
  }
  
  public final a getOpposite()
  {
    switch (1.a[this.b.ordinal()])
    {
    default: 
      return null;
    case 2: 
      return this.a.k;
    case 3: 
      return this.a.i;
    case 4: 
      return this.a.l;
    }
    return this.a.j;
  }
  
  public b getOwner()
  {
    return this.a;
  }
  
  public int getPriorityLevel()
  {
    switch (1.a[this.b.ordinal()])
    {
    case 6: 
    case 7: 
    default: 
      return 0;
    case 8: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 2;
    case 4: 
      return 2;
    case 5: 
      return 2;
    }
    return 2;
  }
  
  public int getSnapPriorityLevel()
  {
    int k = 1;
    switch (1.a[this.b.ordinal()])
    {
    default: 
      k = 0;
    case 2: 
    case 3: 
    case 7: 
      return k;
    case 6: 
      return 0;
    case 4: 
      return 0;
    case 5: 
      return 0;
    case 8: 
      return 2;
    }
    return 3;
  }
  
  public g getSolverVariable()
  {
    return this.f;
  }
  
  public b getStrength()
  {
    return this.h;
  }
  
  public a getTarget()
  {
    return this.c;
  }
  
  public c getType()
  {
    return this.b;
  }
  
  public boolean isConnected()
  {
    return this.c != null;
  }
  
  public boolean isConnectionAllowed(b paramb)
  {
    if (a(paramb, new HashSet())) {}
    b localb;
    do
    {
      return false;
      localb = getOwner().getParent();
      if (localb == paramb) {
        return true;
      }
    } while (paramb.getParent() != localb);
    return true;
  }
  
  public boolean isConnectionAllowed(b paramb, a parama)
  {
    return isConnectionAllowed(paramb);
  }
  
  public boolean isSideAnchor()
  {
    switch (1.a[this.b.ordinal()])
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean isSimilarDimensionConnection(a parama)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    parama = parama.getType();
    if (parama == this.b) {
      bool1 = true;
    }
    label119:
    do
    {
      do
      {
        return bool1;
        switch (1.a[this.b.ordinal()])
        {
        default: 
          return false;
        case 1: 
          if (parama != c.f) {}
          for (;;)
          {
            return bool1;
            bool1 = false;
          }
        case 2: 
        case 3: 
        case 6: 
          if ((parama == c.b) || (parama == c.d)) {
            break label119;
          }
          bool1 = bool2;
        }
      } while (parama != c.h);
      return true;
      if ((parama == c.c) || (parama == c.e) || (parama == c.i)) {
        break;
      }
      bool1 = bool2;
    } while (parama != c.f);
    return true;
  }
  
  public boolean isSnapCompatibleWith(a parama)
  {
    if (this.b == c.g) {
      return false;
    }
    if (this.b == parama.getType()) {
      return true;
    }
    switch (1.a[this.b.ordinal()])
    {
    default: 
      return false;
    case 2: 
      switch (1.a[parama.getType().ordinal()])
      {
      case 4: 
      case 5: 
      default: 
        return false;
      case 3: 
        return true;
      }
      return true;
    case 3: 
      switch (1.a[parama.getType().ordinal()])
      {
      default: 
        return false;
      case 2: 
        return true;
      }
      return true;
    case 6: 
      switch (1.a[parama.getType().ordinal()])
      {
      default: 
        return false;
      case 2: 
        return true;
      }
      return true;
    case 4: 
      switch (1.a[parama.getType().ordinal()])
      {
      case 6: 
      default: 
        return false;
      case 5: 
        return true;
      }
      return true;
    case 5: 
      switch (1.a[parama.getType().ordinal()])
      {
      case 5: 
      case 6: 
      default: 
        return false;
      case 4: 
        return true;
      }
      return true;
    }
    switch (1.a[parama.getType().ordinal()])
    {
    default: 
      return false;
    case 4: 
      return true;
    }
    return true;
  }
  
  public boolean isValidConnection(a parama)
  {
    boolean bool1 = true;
    if (parama == null) {}
    c localc;
    do
    {
      return false;
      localc = parama.getType();
      if (localc != this.b) {
        break;
      }
    } while ((this.b == c.g) || ((this.b == c.f) && ((!parama.getOwner().hasBaseline()) || (!getOwner().hasBaseline()))));
    return true;
    boolean bool2;
    switch (1.a[this.b.ordinal()])
    {
    default: 
      return false;
    case 1: 
      if ((localc != c.f) && (localc != c.h) && (localc != c.i)) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
    case 2: 
    case 3: 
      if ((localc == c.b) || (localc == c.d)) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (!(parama.getOwner() instanceof d)) {
          return bool2;
        }
        if ((!bool1) && (localc != c.h)) {
          break;
        }
        return true;
      }
    }
    if ((localc == c.c) || (localc == c.e)) {}
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!(parama.getOwner() instanceof d)) {
        return bool2;
      }
      if ((!bool1) && (localc != c.i)) {
        break;
      }
      return true;
    }
    return bool2;
  }
  
  public boolean isVerticalAnchor()
  {
    switch (1.a[this.b.ordinal()])
    {
    case 4: 
    case 5: 
    default: 
      return true;
    }
    return false;
  }
  
  public void reset()
  {
    this.c = null;
    this.d = 0;
    this.e = -1;
    this.h = b.b;
    this.j = 0;
    this.i = a.a;
  }
  
  public void resetSolverVariable(c paramc)
  {
    if (this.f == null)
    {
      this.f = new g(g.a.a);
      return;
    }
    this.f.reset();
  }
  
  public void setConnectionCreator(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setConnectionType(a parama)
  {
    this.i = parama;
  }
  
  public void setGoneMargin(int paramInt)
  {
    if (isConnected()) {
      this.e = paramInt;
    }
  }
  
  public void setGroup(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setMargin(int paramInt)
  {
    if (isConnected()) {
      this.d = paramInt;
    }
  }
  
  public void setStrength(b paramb)
  {
    if (isConnected()) {
      this.h = paramb;
    }
  }
  
  public String toString()
  {
    Object localObject = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder().append(this.a.getDebugName()).append(":").append(this.b.toString());
    if (this.c != null) {}
    for (localObject = " connected to " + this.c.a((HashSet)localObject);; localObject = "") {
      return (String)localObject;
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */