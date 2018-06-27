package android.support.constraint.a.a;

import java.util.ArrayList;
import java.util.Arrays;

public class c
  extends h
{
  static boolean ac = true;
  protected android.support.constraint.a.e aa = new android.support.constraint.a.e();
  protected android.support.constraint.a.e ab = null;
  int ad;
  int ae;
  int af;
  int ag;
  int ah;
  int ai;
  private g ak;
  private int al = 0;
  private int am = 0;
  private b[] an = new b[4];
  private b[] ao = new b[4];
  private b[] ap = new b[4];
  private int aq = 2;
  private boolean[] ar = new boolean[3];
  private b[] as = new b[4];
  private boolean at = false;
  private boolean au = false;
  
  public c() {}
  
  public c(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static int a(a parama, int paramInt)
  {
    int i = parama.g;
    if (parama.a.getParent() == null) {
      return paramInt;
    }
    if (i <= paramInt) {
      return i;
    }
    parama.g = paramInt;
    a locala1 = parama.getOpposite();
    a locala2 = parama.c;
    if (locala1 != null) {}
    for (i = a(locala1, paramInt);; i = paramInt)
    {
      paramInt = i;
      if (locala2 != null) {
        paramInt = a(locala2, i);
      }
      i = paramInt;
      if (locala1 != null) {
        i = a(locala1, paramInt);
      }
      parama.g = i;
      return i;
    }
  }
  
  private int a(android.support.constraint.a.e parame, b[] paramArrayOfb, b paramb, int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = true;
    paramArrayOfBoolean[1] = false;
    paramArrayOfb[0] = null;
    paramArrayOfb[2] = null;
    paramArrayOfb[1] = null;
    paramArrayOfb[3] = null;
    if (paramInt == 0) {
      if ((paramb.i.c == null) || (paramb.i.c.a == this)) {
        break label1067;
      }
    }
    label127:
    label150:
    label443:
    label628:
    label651:
    label944:
    label1033:
    label1053:
    label1067:
    for (boolean bool1 = false;; bool1 = true)
    {
      paramb.Y = null;
      Object localObject2 = null;
      if (paramb.getVisibility() != 8) {
        localObject2 = paramb;
      }
      Object localObject3 = null;
      int i = 0;
      b localb = paramb;
      Object localObject1 = localObject2;
      Object localObject5;
      Object localObject4;
      if (localb.k.c != null)
      {
        localb.Y = null;
        if (localb.getVisibility() != 8)
        {
          if (localObject1 != null) {
            break label1053;
          }
          localObject1 = localb;
          if ((localObject2 != null) && (localObject2 != localb)) {
            ((b)localObject2).Y = localb;
          }
          localObject2 = localb;
          paramInt = i;
          if (localb.getVisibility() != 8)
          {
            paramInt = i;
            if (localb.G == b.a.c)
            {
              if (localb.H == b.a.c) {
                paramArrayOfBoolean[0] = false;
              }
              paramInt = i;
              if (localb.u <= 0.0F)
              {
                paramArrayOfBoolean[0] = false;
                if (i + 1 >= this.an.length) {
                  this.an = ((b[])Arrays.copyOf(this.an, this.an.length * 2));
                }
                this.an[i] = localb;
                paramInt = i + 1;
              }
            }
          }
          if (localb.k.c.a.i.c != null) {
            break label443;
          }
          i = paramInt;
          localObject5 = localObject1;
          localObject4 = localObject2;
        }
      }
      for (;;)
      {
        boolean bool2 = bool1;
        if (localb.k.c != null)
        {
          bool2 = bool1;
          if (localb.k.c.a != this) {
            bool2 = false;
          }
        }
        if ((paramb.i.c == null) || (((b)localObject3).k.c == null)) {
          paramArrayOfBoolean[1] = true;
        }
        paramb.U = bool2;
        ((b)localObject3).Y = null;
        paramArrayOfb[0] = paramb;
        paramArrayOfb[2] = localObject5;
        paramArrayOfb[1] = localObject3;
        paramArrayOfb[3] = localObject4;
        return i;
        parame.addEquality(localb.i.f, localb.i.c.f, 0, 5);
        parame.addEquality(localb.k.f, localb.i.f, 0, 5);
        break label150;
        localObject4 = localObject2;
        localObject5 = localObject1;
        i = paramInt;
        if (localb.k.c.a.i.c.a == localb)
        {
          localObject4 = localObject2;
          localObject5 = localObject1;
          i = paramInt;
          if (localb.k.c.a != localb)
          {
            localb = localb.k.c.a;
            localObject3 = localb;
            i = paramInt;
            break;
            if ((paramb.j.c != null) && (paramb.j.c.a != this)) {}
            for (bool1 = false;; bool1 = true)
            {
              paramb.Z = null;
              localObject2 = null;
              if (paramb.getVisibility() != 8) {
                localObject2 = paramb;
              }
              localObject3 = null;
              i = 0;
              localb = paramb;
              localObject1 = localObject2;
              if (localb.l.c != null)
              {
                localb.Z = null;
                if (localb.getVisibility() != 8)
                {
                  if (localObject1 != null) {
                    break label1033;
                  }
                  localObject1 = localb;
                  if ((localObject2 != null) && (localObject2 != localb)) {
                    ((b)localObject2).Z = localb;
                  }
                  localObject2 = localb;
                  paramInt = i;
                  if (localb.getVisibility() != 8)
                  {
                    paramInt = i;
                    if (localb.H == b.a.c)
                    {
                      if (localb.G == b.a.c) {
                        paramArrayOfBoolean[0] = false;
                      }
                      paramInt = i;
                      if (localb.u <= 0.0F)
                      {
                        paramArrayOfBoolean[0] = false;
                        if (i + 1 >= this.an.length) {
                          this.an = ((b[])Arrays.copyOf(this.an, this.an.length * 2));
                        }
                        this.an[i] = localb;
                        paramInt = i + 1;
                      }
                    }
                  }
                  if (localb.l.c.a.j.c != null) {
                    break label944;
                  }
                  i = paramInt;
                  localObject5 = localObject1;
                  localObject4 = localObject2;
                }
              }
              for (;;)
              {
                bool2 = bool1;
                if (localb.l.c != null)
                {
                  bool2 = bool1;
                  if (localb.l.c.a != this) {
                    bool2 = false;
                  }
                }
                if ((paramb.j.c == null) || (((b)localObject3).l.c == null)) {
                  paramArrayOfBoolean[1] = true;
                }
                paramb.V = bool2;
                ((b)localObject3).Z = null;
                paramArrayOfb[0] = paramb;
                paramArrayOfb[2] = localObject5;
                paramArrayOfb[1] = localObject3;
                paramArrayOfb[3] = localObject4;
                return i;
                parame.addEquality(localb.j.f, localb.j.c.f, 0, 5);
                parame.addEquality(localb.l.f, localb.j.f, 0, 5);
                break label651;
                localObject4 = localObject2;
                localObject5 = localObject1;
                i = paramInt;
                if (localb.l.c.a.j.c.a == localb)
                {
                  localObject4 = localObject2;
                  localObject5 = localObject1;
                  i = paramInt;
                  if (localb.l.c.a != localb)
                  {
                    localb = localb.l.c.a;
                    localObject3 = localb;
                    i = paramInt;
                    break;
                    break label628;
                    localObject4 = localObject2;
                    localObject5 = localObject1;
                  }
                }
              }
            }
            break label127;
            localObject4 = localObject2;
            localObject5 = localObject1;
          }
        }
      }
    }
  }
  
  private void a(b paramb)
  {
    int i = 0;
    while (i < this.al)
    {
      if (this.ap[i] == paramb) {
        return;
      }
      i += 1;
    }
    if (this.al + 1 >= this.ap.length) {
      this.ap = ((b[])Arrays.copyOf(this.ap, this.ap.length * 2));
    }
    this.ap[this.al] = paramb;
    this.al += 1;
  }
  
  private boolean a(android.support.constraint.a.e parame)
  {
    int i4 = this.aj.size();
    int i = 0;
    b localb;
    int k;
    int j;
    label94:
    int m;
    int i1;
    int n;
    for (;;)
    {
      if (i < i4)
      {
        localb = (b)this.aj.get(i);
        localb.a = -1;
        localb.b = -1;
        if ((localb.G == b.a.c) || (localb.H == b.a.c))
        {
          localb.a = 1;
          localb.b = 1;
        }
        i += 1;
        continue;
        if ((k == 0) && (i == 0))
        {
          j = 1;
          m += 1;
          i1 = k;
          n = i;
        }
      }
    }
    for (;;)
    {
      int i2;
      label119:
      label165:
      label190:
      int i3;
      if (j == 0)
      {
        i2 = 0;
        i = 0;
        k = 0;
        if (i2 < i4)
        {
          localb = (b)this.aj.get(i2);
          if (localb.a == -1)
          {
            if (this.G != b.a.b) {
              break label235;
            }
            localb.a = 1;
          }
          if (localb.b == -1)
          {
            if (this.H != b.a.b) {
              break label245;
            }
            localb.b = 1;
          }
          i3 = k;
          if (localb.b == -1) {
            i3 = k + 1;
          }
          if (localb.a != -1) {
            break label374;
          }
          i += 1;
        }
      }
      label235:
      label245:
      label368:
      label374:
      for (;;)
      {
        i2 += 1;
        k = i3;
        break label119;
        break;
        e.b(this, parame, localb);
        break label165;
        e.c(this, parame, localb);
        break label190;
        if ((i1 == k) && (n == i))
        {
          j = 1;
          break label94;
          j = 0;
          i = 0;
          m = 0;
          if (j < i4)
          {
            parame = (b)this.aj.get(j);
            if (parame.a != 1)
            {
              k = m;
              if (parame.a != -1) {}
            }
            else
            {
              k = m + 1;
            }
            if ((parame.b != 1) && (parame.b != -1)) {
              break label368;
            }
            i += 1;
          }
          for (;;)
          {
            j += 1;
            m = k;
            break;
            return (m == 0) && (i == 0);
          }
        }
        break label94;
      }
      m = 0;
      n = 0;
      i1 = 0;
      j = 0;
    }
  }
  
  private void b(b paramb)
  {
    int i = 0;
    while (i < this.am)
    {
      if (this.ao[i] == paramb) {
        return;
      }
      i += 1;
    }
    if (this.am + 1 >= this.ao.length) {
      this.ao = ((b[])Arrays.copyOf(this.ao, this.ao.length * 2));
    }
    this.ao[this.am] = paramb;
    this.am += 1;
  }
  
  private void b(android.support.constraint.a.e parame)
  {
    int j = 0;
    b localb2;
    int n;
    Object localObject2;
    int i;
    Object localObject1;
    label139:
    int k;
    label150:
    int m;
    label162:
    label243:
    label249:
    label254:
    b localb1;
    Object localObject6;
    Object localObject3;
    if (j < this.al)
    {
      localb2 = this.ap[j];
      n = a(parame, this.as, this.ap[j], 0, this.ar);
      localObject2 = this.as[2];
      if (localObject2 == null) {}
      for (;;)
      {
        j += 1;
        break;
        if (this.ar[1] == 0) {
          break label139;
        }
        i = localb2.getDrawX();
        while (localObject2 != null)
        {
          parame.addEquality(((b)localObject2).i.f, i);
          localObject1 = ((b)localObject2).Y;
          i += ((b)localObject2).i.getMargin() + ((b)localObject2).getWidth() + ((b)localObject2).k.getMargin();
          localObject2 = localObject1;
        }
      }
      if (localb2.S == 0)
      {
        k = 1;
        if (localb2.S != 2) {
          break label243;
        }
        m = 1;
        if (this.G != b.a.b) {
          break label249;
        }
      }
      for (i = 1;; i = 0)
      {
        if (((this.aq != 2) && (this.aq != 8)) || (this.ar[0] == 0) || (!localb2.U) || (m != 0) || (i != 0) || (localb2.S != 0)) {
          break label254;
        }
        e.a(this, parame, n, localb2);
        break;
        k = 0;
        break label150;
        m = 0;
        break label162;
      }
      if ((n == 0) || (m != 0))
      {
        localb1 = null;
        i = 0;
        localObject6 = null;
        localObject3 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = ((b)localObject3).Y;
          if (localObject1 != null) {
            break label2397;
          }
          localb1 = this.as[1];
          i = 1;
        }
      }
    }
    label452:
    label669:
    label756:
    label789:
    label822:
    label909:
    label915:
    label921:
    label983:
    label1068:
    label1072:
    label1722:
    label1989:
    label2377:
    label2384:
    label2391:
    label2394:
    label2397:
    for (;;)
    {
      Object localObject4;
      if (m != 0)
      {
        localObject4 = ((b)localObject3).i;
        n = ((a)localObject4).getMargin();
        if (localObject6 == null) {
          break label2394;
        }
        n += ((b)localObject6).k.getMargin();
      }
      for (;;)
      {
        int i1 = 1;
        if (localObject2 != localObject3) {
          i1 = 3;
        }
        parame.addGreaterThan(((a)localObject4).f, ((a)localObject4).c.f, n, i1);
        Object localObject5;
        if (((b)localObject3).G == b.a.c)
        {
          localObject5 = ((b)localObject3).k;
          if (((b)localObject3).c != 1) {
            break label452;
          }
          n = Math.max(((b)localObject3).e, ((b)localObject3).getWidth());
          parame.addEquality(((a)localObject5).f, ((a)localObject4).f, n, 3);
        }
        for (;;)
        {
          if (i != 0) {
            localObject1 = null;
          }
          localObject6 = localObject3;
          localObject3 = localObject1;
          break;
          parame.addGreaterThan(((a)localObject4).f, ((a)localObject4).c.f, ((a)localObject4).d, 3);
          parame.addLowerThan(((a)localObject5).f, ((a)localObject4).f, ((b)localObject3).e, 3);
          continue;
          if ((k == 0) && (i != 0) && (localObject6 != null))
          {
            if (((b)localObject3).k.c == null)
            {
              parame.addEquality(((b)localObject3).k.f, ((b)localObject3).getDrawRight());
            }
            else
            {
              n = ((b)localObject3).k.getMargin();
              parame.addEquality(((b)localObject3).k.f, localb1.k.c.f, -n, 5);
            }
          }
          else
          {
            if ((k != 0) || (i != 0) || (localObject6 != null)) {
              break label669;
            }
            if (((b)localObject3).i.c == null)
            {
              parame.addEquality(((b)localObject3).i.f, ((b)localObject3).getDrawX());
            }
            else
            {
              n = ((b)localObject3).i.getMargin();
              parame.addEquality(((b)localObject3).i.f, localb2.i.c.f, n, 5);
            }
          }
        }
        a locala1 = ((b)localObject3).i;
        a locala2 = ((b)localObject3).k;
        n = locala1.getMargin();
        i1 = locala2.getMargin();
        parame.addGreaterThan(locala1.f, locala1.c.f, n, 1);
        parame.addLowerThan(locala2.f, locala2.c.f, -i1, 1);
        if (locala1.c != null)
        {
          localObject4 = locala1.c.f;
          localObject5 = localObject4;
          if (localObject6 == null)
          {
            if (localb2.i.c == null) {
              break label909;
            }
            localObject4 = localb2.i.c.f;
            localObject5 = localObject4;
          }
          if (localObject1 != null) {
            break label2391;
          }
          if (localb1.k.c == null) {
            break label915;
          }
          localObject1 = localb1.k.c.a;
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            localObject4 = ((b)localObject1).i.f;
            if (i != 0) {
              if (localb1.k.c == null) {
                break label921;
              }
            }
          }
          for (localObject4 = localb1.k.c.f;; localObject4 = null)
          {
            if ((localObject5 != null) && (localObject4 != null)) {
              parame.addCentering(locala1.f, (android.support.constraint.a.g)localObject5, n, 0.5F, (android.support.constraint.a.g)localObject4, locala2.f, i1, 4);
            }
            break;
            localObject4 = null;
            break label756;
            localObject4 = null;
            break label789;
            localObject1 = null;
            break label822;
          }
          if (m == 0) {
            break;
          }
          localObject3 = ((b)localObject2).i;
          localObject4 = localb1.k;
          i = ((a)localObject3).getMargin();
          k = ((a)localObject4).getMargin();
          if (localb2.i.c != null)
          {
            localObject1 = localb2.i.c.f;
            if (localb1.k.c == null) {
              break label1068;
            }
          }
          for (localObject2 = localb1.k.c.f;; localObject2 = null)
          {
            if ((localObject1 == null) || (localObject2 == null)) {
              break label1072;
            }
            parame.addLowerThan(((a)localObject4).f, (android.support.constraint.a.g)localObject2, -k, 1);
            parame.addCentering(((a)localObject3).f, (android.support.constraint.a.g)localObject1, i, localb2.E, (android.support.constraint.a.g)localObject2, ((a)localObject4).f, k, 4);
            break;
            localObject1 = null;
            break label983;
          }
          break;
          float f = 0.0F;
          localObject3 = null;
          localObject1 = localObject2;
          localObject2 = localObject3;
          if (localObject1 != null)
          {
            if (((b)localObject1).G != b.a.c)
            {
              k = ((b)localObject1).i.getMargin();
              i = k;
              if (localObject2 != null) {
                i = k + ((b)localObject2).k.getMargin();
              }
              k = 3;
              if (((b)localObject1).i.c.a.G == b.a.c) {
                k = 2;
              }
              parame.addGreaterThan(((b)localObject1).i.f, ((b)localObject1).i.c.f, i, k);
              k = ((b)localObject1).k.getMargin();
              i = k;
              if (((b)localObject1).k.c.a.i.c != null)
              {
                i = k;
                if (((b)localObject1).k.c.a.i.c.a == localObject1) {
                  i = k + ((b)localObject1).k.c.a.i.getMargin();
                }
              }
              k = 3;
              if (((b)localObject1).k.c.a.G == b.a.c) {
                k = 2;
              }
              parame.addLowerThan(((b)localObject1).k.f, ((b)localObject1).k.c.f, -i, k);
            }
            for (;;)
            {
              localObject3 = ((b)localObject1).Y;
              localObject2 = localObject1;
              localObject1 = localObject3;
              break;
              f += ((b)localObject1).W;
              i = 0;
              if (((b)localObject1).k.c != null)
              {
                k = ((b)localObject1).k.getMargin();
                i = k;
                if (localObject1 != this.as[3]) {
                  i = k + ((b)localObject1).k.c.a.i.getMargin();
                }
              }
              parame.addGreaterThan(((b)localObject1).k.f, ((b)localObject1).i.f, 0, 1);
              parame.addLowerThan(((b)localObject1).k.f, ((b)localObject1).k.c.f, -i, 1);
            }
          }
          if (n == 1)
          {
            localObject2 = this.an[0];
            k = ((b)localObject2).i.getMargin();
            i = k;
            if (((b)localObject2).i.c != null) {
              i = k + ((b)localObject2).i.c.getMargin();
            }
            m = ((b)localObject2).k.getMargin();
            k = m;
            if (((b)localObject2).k.c != null) {
              k = m + ((b)localObject2).k.c.getMargin();
            }
            localObject1 = localb2.k.c.f;
            if (localObject2 == this.as[3]) {
              localObject1 = this.as[1].k.c.f;
            }
            if (((b)localObject2).c == 1)
            {
              parame.addGreaterThan(localb2.i.f, localb2.i.c.f, i, 1);
              parame.addLowerThan(localb2.k.f, (android.support.constraint.a.g)localObject1, -k, 1);
              parame.addEquality(localb2.k.f, localb2.i.f, localb2.getWidth(), 2);
              break;
            }
            parame.addEquality(((b)localObject2).i.f, ((b)localObject2).i.c.f, i, 1);
            parame.addEquality(((b)localObject2).k.f, (android.support.constraint.a.g)localObject1, -k, 1);
            break;
          }
          i = 0;
          if (i < n - 1)
          {
            localObject3 = this.an[i];
            localb1 = this.an[(i + 1)];
            localObject4 = ((b)localObject3).i.f;
            localObject5 = ((b)localObject3).k.f;
            localObject6 = localb1.i.f;
            localObject1 = localb1.k.f;
            if (localb1 == this.as[3]) {
              localObject1 = this.as[1].k.f;
            }
            m = ((b)localObject3).i.getMargin();
            k = m;
            if (((b)localObject3).i.c != null)
            {
              k = m;
              if (((b)localObject3).i.c.a.k.c != null)
              {
                k = m;
                if (((b)localObject3).i.c.a.k.c.a == localObject3) {
                  k = m + ((b)localObject3).i.c.a.k.getMargin();
                }
              }
            }
            parame.addGreaterThan((android.support.constraint.a.g)localObject4, ((b)localObject3).i.c.f, k, 2);
            m = ((b)localObject3).k.getMargin();
            if ((((b)localObject3).k.c == null) || (((b)localObject3).Y == null)) {
              break label2384;
            }
            if (((b)localObject3).Y.i.c == null) {
              break label2377;
            }
            k = ((b)localObject3).Y.i.getMargin();
            k += m;
          }
          for (;;)
          {
            parame.addLowerThan((android.support.constraint.a.g)localObject5, ((b)localObject3).k.c.f, -k, 2);
            if (i + 1 == n - 1)
            {
              m = localb1.i.getMargin();
              k = m;
              if (localb1.i.c != null)
              {
                k = m;
                if (localb1.i.c.a.k.c != null)
                {
                  k = m;
                  if (localb1.i.c.a.k.c.a == localb1) {
                    k = m + localb1.i.c.a.k.getMargin();
                  }
                }
              }
              parame.addGreaterThan((android.support.constraint.a.g)localObject6, localb1.i.c.f, k, 2);
              localObject2 = localb1.k;
              if (localb1 == this.as[3]) {
                localObject2 = this.as[1].k;
              }
              m = ((a)localObject2).getMargin();
              k = m;
              if (((a)localObject2).c != null)
              {
                k = m;
                if (((a)localObject2).c.a.i.c != null)
                {
                  k = m;
                  if (((a)localObject2).c.a.i.c.a == localb1) {
                    k = m + ((a)localObject2).c.a.i.getMargin();
                  }
                }
              }
              parame.addLowerThan((android.support.constraint.a.g)localObject1, ((a)localObject2).c.f, -k, 2);
            }
            if (localb2.f > 0) {
              parame.addLowerThan((android.support.constraint.a.g)localObject5, (android.support.constraint.a.g)localObject4, localb2.f, 2);
            }
            localObject2 = parame.createRow();
            ((android.support.constraint.a.b)localObject2).createRowEqualDimension(((b)localObject3).W, f, localb1.W, (android.support.constraint.a.g)localObject4, ((b)localObject3).i.getMargin(), (android.support.constraint.a.g)localObject5, ((b)localObject3).k.getMargin(), (android.support.constraint.a.g)localObject6, localb1.i.getMargin(), (android.support.constraint.a.g)localObject1, localb1.k.getMargin());
            parame.addConstraint((android.support.constraint.a.b)localObject2);
            i += 1;
            break label1722;
            break;
            k = 0;
            break label1989;
            return;
            k = m;
          }
        }
      }
    }
  }
  
  private void c()
  {
    this.al = 0;
    this.am = 0;
  }
  
  private void c(android.support.constraint.a.e parame)
  {
    int k = 0;
    b localb2;
    int i1;
    Object localObject2;
    int i;
    Object localObject1;
    label139:
    int m;
    label150:
    int n;
    label162:
    label243:
    label249:
    label254:
    b localb1;
    Object localObject6;
    Object localObject3;
    if (k < this.am)
    {
      localb2 = this.ao[k];
      i1 = a(parame, this.as, this.ao[k], 1, this.ar);
      localObject2 = this.as[2];
      if (localObject2 == null) {}
      for (;;)
      {
        k += 1;
        break;
        if (this.ar[1] == 0) {
          break label139;
        }
        i = localb2.getDrawY();
        while (localObject2 != null)
        {
          parame.addEquality(((b)localObject2).j.f, i);
          localObject1 = ((b)localObject2).Z;
          i += ((b)localObject2).j.getMargin() + ((b)localObject2).getHeight() + ((b)localObject2).l.getMargin();
          localObject2 = localObject1;
        }
      }
      if (localb2.T == 0)
      {
        m = 1;
        if (localb2.T != 2) {
          break label243;
        }
        n = 1;
        if (this.H != b.a.b) {
          break label249;
        }
      }
      for (i = 1;; i = 0)
      {
        if (((this.aq != 2) && (this.aq != 8)) || (this.ar[0] == 0) || (!localb2.V) || (n != 0) || (i != 0) || (localb2.T != 0)) {
          break label254;
        }
        e.b(this, parame, i1, localb2);
        break;
        m = 0;
        break label150;
        n = 0;
        break label162;
      }
      if ((i1 == 0) || (n != 0))
      {
        localb1 = null;
        i = 0;
        localObject6 = null;
        localObject3 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = ((b)localObject3).Z;
          if (localObject1 != null) {
            break label2485;
          }
          localb1 = this.as[1];
          i = 1;
        }
      }
    }
    label392:
    label543:
    label760:
    label847:
    label880:
    label913:
    label1000:
    label1006:
    label1012:
    label1074:
    label1159:
    label1163:
    label1813:
    label2080:
    label2468:
    label2475:
    label2482:
    label2485:
    for (;;)
    {
      Object localObject5;
      Object localObject4;
      int i2;
      if (n != 0)
      {
        locala1 = ((b)localObject3).j;
        i1 = locala1.getMargin();
        j = i1;
        if (localObject6 != null) {
          j = i1 + ((b)localObject6).l.getMargin();
        }
        i1 = 1;
        if (localObject2 != localObject3) {
          i1 = 3;
        }
        localObject5 = null;
        localObject4 = null;
        if (locala1.c != null)
        {
          localObject5 = locala1.f;
          localObject4 = locala1.c.f;
          i2 = j;
          if ((localObject5 != null) && (localObject4 != null)) {
            parame.addGreaterThan((android.support.constraint.a.g)localObject5, (android.support.constraint.a.g)localObject4, i2, i1);
          }
          if (((b)localObject3).H == b.a.c)
          {
            localObject4 = ((b)localObject3).l;
            if (((b)localObject3).d != 1) {
              break label543;
            }
            j = Math.max(((b)localObject3).g, ((b)localObject3).getHeight());
            parame.addEquality(((a)localObject4).f, locala1.f, j, 3);
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          localObject1 = null;
        }
        localObject6 = localObject3;
        localObject3 = localObject1;
        break;
        i2 = j;
        if (((b)localObject3).m.c == null) {
          break label392;
        }
        localObject5 = ((b)localObject3).m.f;
        localObject4 = ((b)localObject3).m.c.f;
        i2 = j - locala1.getMargin();
        break label392;
        parame.addGreaterThan(locala1.f, locala1.c.f, locala1.d, 3);
        parame.addLowerThan(((a)localObject4).f, locala1.f, ((b)localObject3).g, 3);
        continue;
        if ((m == 0) && (i != 0) && (localObject6 != null))
        {
          if (((b)localObject3).l.c == null)
          {
            parame.addEquality(((b)localObject3).l.f, ((b)localObject3).getDrawBottom());
          }
          else
          {
            j = ((b)localObject3).l.getMargin();
            parame.addEquality(((b)localObject3).l.f, localb1.l.c.f, -j, 5);
          }
        }
        else
        {
          if ((m != 0) || (i != 0) || (localObject6 != null)) {
            break label760;
          }
          if (((b)localObject3).j.c == null)
          {
            parame.addEquality(((b)localObject3).j.f, ((b)localObject3).getDrawY());
          }
          else
          {
            j = ((b)localObject3).j.getMargin();
            parame.addEquality(((b)localObject3).j.f, localb2.j.c.f, j, 5);
          }
        }
      }
      a locala1 = ((b)localObject3).j;
      a locala2 = ((b)localObject3).l;
      int j = locala1.getMargin();
      i1 = locala2.getMargin();
      parame.addGreaterThan(locala1.f, locala1.c.f, j, 1);
      parame.addLowerThan(locala2.f, locala2.c.f, -i1, 1);
      if (locala1.c != null)
      {
        localObject4 = locala1.c.f;
        localObject5 = localObject4;
        if (localObject6 == null)
        {
          if (localb2.j.c == null) {
            break label1000;
          }
          localObject4 = localb2.j.c.f;
          localObject5 = localObject4;
        }
        if (localObject1 != null) {
          break label2482;
        }
        if (localb1.l.c == null) {
          break label1006;
        }
        localObject1 = localb1.l.c.a;
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject4 = ((b)localObject1).j.f;
          if (i != 0) {
            if (localb1.l.c == null) {
              break label1012;
            }
          }
        }
        for (localObject4 = localb1.l.c.f;; localObject4 = null)
        {
          if ((localObject5 != null) && (localObject4 != null)) {
            parame.addCentering(locala1.f, (android.support.constraint.a.g)localObject5, j, 0.5F, (android.support.constraint.a.g)localObject4, locala2.f, i1, 4);
          }
          break;
          localObject4 = null;
          break label847;
          localObject4 = null;
          break label880;
          localObject1 = null;
          break label913;
        }
        if (n == 0) {
          break;
        }
        localObject3 = ((b)localObject2).j;
        localObject4 = localb1.l;
        i = ((a)localObject3).getMargin();
        j = ((a)localObject4).getMargin();
        if (localb2.j.c != null)
        {
          localObject1 = localb2.j.c.f;
          if (localb1.l.c == null) {
            break label1159;
          }
        }
        for (localObject2 = localb1.l.c.f;; localObject2 = null)
        {
          if ((localObject1 == null) || (localObject2 == null)) {
            break label1163;
          }
          parame.addLowerThan(((a)localObject4).f, (android.support.constraint.a.g)localObject2, -j, 1);
          parame.addCentering(((a)localObject3).f, (android.support.constraint.a.g)localObject1, i, localb2.F, (android.support.constraint.a.g)localObject2, ((a)localObject4).f, j, 4);
          break;
          localObject1 = null;
          break label1074;
        }
        break;
        float f = 0.0F;
        localObject3 = null;
        localObject1 = localObject2;
        localObject2 = localObject3;
        if (localObject1 != null)
        {
          if (((b)localObject1).H != b.a.c)
          {
            j = ((b)localObject1).j.getMargin();
            i = j;
            if (localObject2 != null) {
              i = j + ((b)localObject2).l.getMargin();
            }
            j = 3;
            if (((b)localObject1).j.c.a.H == b.a.c) {
              j = 2;
            }
            parame.addGreaterThan(((b)localObject1).j.f, ((b)localObject1).j.c.f, i, j);
            j = ((b)localObject1).l.getMargin();
            i = j;
            if (((b)localObject1).l.c.a.j.c != null)
            {
              i = j;
              if (((b)localObject1).l.c.a.j.c.a == localObject1) {
                i = j + ((b)localObject1).l.c.a.j.getMargin();
              }
            }
            j = 3;
            if (((b)localObject1).l.c.a.H == b.a.c) {
              j = 2;
            }
            parame.addLowerThan(((b)localObject1).l.f, ((b)localObject1).l.c.f, -i, j);
          }
          for (;;)
          {
            localObject3 = ((b)localObject1).Z;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break;
            f += ((b)localObject1).X;
            i = 0;
            if (((b)localObject1).l.c != null)
            {
              j = ((b)localObject1).l.getMargin();
              i = j;
              if (localObject1 != this.as[3]) {
                i = j + ((b)localObject1).l.c.a.j.getMargin();
              }
            }
            parame.addGreaterThan(((b)localObject1).l.f, ((b)localObject1).j.f, 0, 1);
            parame.addLowerThan(((b)localObject1).l.f, ((b)localObject1).l.c.f, -i, 1);
          }
        }
        if (i1 == 1)
        {
          localObject2 = this.an[0];
          j = ((b)localObject2).j.getMargin();
          i = j;
          if (((b)localObject2).j.c != null) {
            i = j + ((b)localObject2).j.c.getMargin();
          }
          m = ((b)localObject2).l.getMargin();
          j = m;
          if (((b)localObject2).l.c != null) {
            j = m + ((b)localObject2).l.c.getMargin();
          }
          localObject1 = localb2.l.c.f;
          if (localObject2 == this.as[3]) {
            localObject1 = this.as[1].l.c.f;
          }
          if (((b)localObject2).d == 1)
          {
            parame.addGreaterThan(localb2.j.f, localb2.j.c.f, i, 1);
            parame.addLowerThan(localb2.l.f, (android.support.constraint.a.g)localObject1, -j, 1);
            parame.addEquality(localb2.l.f, localb2.j.f, localb2.getHeight(), 2);
            break;
          }
          parame.addEquality(((b)localObject2).j.f, ((b)localObject2).j.c.f, i, 1);
          parame.addEquality(((b)localObject2).l.f, (android.support.constraint.a.g)localObject1, -j, 1);
          break;
        }
        i = 0;
        if (i < i1 - 1)
        {
          localObject3 = this.an[i];
          localb1 = this.an[(i + 1)];
          localObject4 = ((b)localObject3).j.f;
          localObject5 = ((b)localObject3).l.f;
          localObject6 = localb1.j.f;
          localObject1 = localb1.l.f;
          if (localb1 == this.as[3]) {
            localObject1 = this.as[1].l.f;
          }
          m = ((b)localObject3).j.getMargin();
          j = m;
          if (((b)localObject3).j.c != null)
          {
            j = m;
            if (((b)localObject3).j.c.a.l.c != null)
            {
              j = m;
              if (((b)localObject3).j.c.a.l.c.a == localObject3) {
                j = m + ((b)localObject3).j.c.a.l.getMargin();
              }
            }
          }
          parame.addGreaterThan((android.support.constraint.a.g)localObject4, ((b)localObject3).j.c.f, j, 2);
          m = ((b)localObject3).l.getMargin();
          if ((((b)localObject3).l.c == null) || (((b)localObject3).Z == null)) {
            break label2475;
          }
          if (((b)localObject3).Z.j.c == null) {
            break label2468;
          }
          j = ((b)localObject3).Z.j.getMargin();
          j += m;
        }
        for (;;)
        {
          parame.addLowerThan((android.support.constraint.a.g)localObject5, ((b)localObject3).l.c.f, -j, 2);
          if (i + 1 == i1 - 1)
          {
            m = localb1.j.getMargin();
            j = m;
            if (localb1.j.c != null)
            {
              j = m;
              if (localb1.j.c.a.l.c != null)
              {
                j = m;
                if (localb1.j.c.a.l.c.a == localb1) {
                  j = m + localb1.j.c.a.l.getMargin();
                }
              }
            }
            parame.addGreaterThan((android.support.constraint.a.g)localObject6, localb1.j.c.f, j, 2);
            localObject2 = localb1.l;
            if (localb1 == this.as[3]) {
              localObject2 = this.as[1].l;
            }
            m = ((a)localObject2).getMargin();
            j = m;
            if (((a)localObject2).c != null)
            {
              j = m;
              if (((a)localObject2).c.a.j.c != null)
              {
                j = m;
                if (((a)localObject2).c.a.j.c.a == localb1) {
                  j = m + ((a)localObject2).c.a.j.getMargin();
                }
              }
            }
            parame.addLowerThan((android.support.constraint.a.g)localObject1, ((a)localObject2).c.f, -j, 2);
          }
          if (localb2.h > 0) {
            parame.addLowerThan((android.support.constraint.a.g)localObject5, (android.support.constraint.a.g)localObject4, localb2.h, 2);
          }
          localObject2 = parame.createRow();
          ((android.support.constraint.a.b)localObject2).createRowEqualDimension(((b)localObject3).X, f, localb1.X, (android.support.constraint.a.g)localObject4, ((b)localObject3).j.getMargin(), (android.support.constraint.a.g)localObject5, ((b)localObject3).l.getMargin(), (android.support.constraint.a.g)localObject6, localb1.j.getMargin(), (android.support.constraint.a.g)localObject1, localb1.l.getMargin());
          parame.addConstraint((android.support.constraint.a.b)localObject2);
          i += 1;
          break label1813;
          break;
          j = 0;
          break label2080;
          return;
          j = m;
        }
      }
    }
  }
  
  public static c createContainer(c paramc, String paramString, ArrayList<b> paramArrayList, int paramInt)
  {
    int j = 0;
    f localf = getBounds(paramArrayList);
    if ((localf.c == 0) || (localf.d == 0)) {
      paramString = null;
    }
    int i;
    b localb;
    do
    {
      return paramString;
      if (paramInt > 0)
      {
        int k = Math.min(localf.a, localf.b);
        i = paramInt;
        if (paramInt > k) {
          i = k;
        }
        localf.a(i, i);
      }
      paramc.setOrigin(localf.a, localf.b);
      paramc.setDimension(localf.c, localf.d);
      paramc.setDebugName(paramString);
      localb = ((b)paramArrayList.get(0)).getParent();
      i = paramArrayList.size();
      paramInt = j;
      paramString = paramc;
    } while (paramInt >= i);
    paramString = (b)paramArrayList.get(paramInt);
    if (paramString.getParent() != localb) {}
    for (;;)
    {
      paramInt += 1;
      break;
      paramc.add(paramString);
      paramString.setX(paramString.getX() - localf.a);
      paramString.setY(paramString.getY() - localf.b);
    }
  }
  
  void a(b paramb, int paramInt)
  {
    if (paramInt == 0)
    {
      while ((paramb.i.c != null) && (paramb.i.c.a.k.c != null) && (paramb.i.c.a.k.c == paramb.i) && (paramb.i.c.a != paramb)) {
        paramb = paramb.i.c.a;
      }
      a(paramb);
    }
    while (paramInt != 1) {
      return;
    }
    while ((paramb.j.c != null) && (paramb.j.c.a.l.c != null) && (paramb.j.c.a.l.c == paramb.j) && (paramb.j.c.a != paramb)) {
      paramb = paramb.j.c.a;
    }
    b(paramb);
  }
  
  public boolean addChildrenToSolver(android.support.constraint.a.e parame, int paramInt)
  {
    addToSolver(parame, paramInt);
    int k = this.aj.size();
    if ((this.aq == 2) || (this.aq == 4))
    {
      if (!a(parame)) {
        break label214;
      }
      return false;
    }
    label214:
    for (int i = 1;; i = 0)
    {
      int j = 0;
      if (j < k)
      {
        b localb = (b)this.aj.get(j);
        if ((localb instanceof c))
        {
          b.a locala1 = localb.G;
          b.a locala2 = localb.H;
          if (locala1 == b.a.b) {
            localb.setHorizontalDimensionBehaviour(b.a.a);
          }
          if (locala2 == b.a.b) {
            localb.setVerticalDimensionBehaviour(b.a.a);
          }
          localb.addToSolver(parame, paramInt);
          if (locala1 == b.a.b) {
            localb.setHorizontalDimensionBehaviour(locala1);
          }
          if (locala2 == b.a.b) {
            localb.setVerticalDimensionBehaviour(locala2);
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (i != 0) {
            e.a(this, parame, localb);
          }
          localb.addToSolver(parame, paramInt);
        }
      }
      if (this.al > 0) {
        b(parame);
      }
      if (this.am > 0) {
        c(parame);
      }
      return true;
    }
  }
  
  public void findHorizontalWrapRecursive(b paramb, boolean[] paramArrayOfBoolean)
  {
    Object localObject = null;
    boolean bool2 = false;
    int j = 0;
    if ((paramb.G == b.a.c) && (paramb.H == b.a.c) && (paramb.u > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    int i = paramb.getOptimizerWrapWidth();
    if ((paramb.G == b.a.c) && (paramb.H != b.a.c) && (paramb.u > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    paramb.Q = true;
    if ((paramb instanceof d))
    {
      paramArrayOfBoolean = (d)paramb;
      if (paramArrayOfBoolean.getOrientation() != 1) {
        break label906;
      }
      if (paramArrayOfBoolean.getRelativeBegin() != -1) {
        i = paramArrayOfBoolean.getRelativeBegin();
      }
    }
    for (;;)
    {
      int m = j;
      for (;;)
      {
        k = i;
        j = m;
        if (paramb.getVisibility() == 8)
        {
          k = i - paramb.s;
          j = m - paramb.s;
        }
        paramb.J = k;
        paramb.K = j;
        return;
        if (paramArrayOfBoolean.getRelativeEnd() == -1) {
          break label901;
        }
        j = paramArrayOfBoolean.getRelativeEnd();
        i = 0;
        break;
        if ((paramb.k.isConnected()) || (paramb.i.isConnected())) {
          break label226;
        }
        j = paramb.getX();
        m = i;
        i = j + i;
      }
      label226:
      if ((paramb.k.c != null) && (paramb.i.c != null) && ((paramb.k.c == paramb.i.c) || ((paramb.k.c.a == paramb.i.c.a) && (paramb.k.c.a != paramb.r))))
      {
        paramArrayOfBoolean[0] = false;
        return;
      }
      b localb2;
      b localb1;
      if (paramb.k.c != null)
      {
        localb2 = paramb.k.c.a;
        j = paramb.k.getMargin() + i;
        localb1 = localb2;
        m = j;
        if (!localb2.isRoot())
        {
          localb1 = localb2;
          m = j;
          if (!localb2.Q)
          {
            findHorizontalWrapRecursive(localb2, paramArrayOfBoolean);
            m = j;
            localb1 = localb2;
          }
        }
      }
      for (;;)
      {
        j = i;
        if (paramb.i.c != null)
        {
          localb2 = paramb.i.c.a;
          i += paramb.i.getMargin();
          j = i;
          localObject = localb2;
          if (!localb2.isRoot())
          {
            j = i;
            localObject = localb2;
            if (!localb2.Q)
            {
              findHorizontalWrapRecursive(localb2, paramArrayOfBoolean);
              localObject = localb2;
              j = i;
            }
          }
        }
        k = m;
        label524:
        boolean bool1;
        if (paramb.k.c != null)
        {
          k = m;
          if (!localb1.isRoot())
          {
            if (paramb.k.c.b != a.c.d) {
              break label776;
            }
            i = m + (localb1.K - localb1.getOptimizerWrapWidth());
            if ((!localb1.N) && ((localb1.i.c == null) || (localb1.k.c == null) || (localb1.G == b.a.c))) {
              break label807;
            }
            bool1 = true;
            label568:
            paramb.N = bool1;
            k = i;
            if (paramb.N)
            {
              if (localb1.i.c != null) {
                break label813;
              }
              label595:
              k = i + (i - localb1.K);
            }
          }
        }
        label606:
        i = j;
        m = k;
        if (paramb.i.c == null) {
          break;
        }
        i = j;
        m = k;
        if (((b)localObject).isRoot()) {
          break;
        }
        int n;
        if (paramb.i.c.getType() == a.c.b)
        {
          n = j + (((b)localObject).J - ((b)localObject).getOptimizerWrapWidth());
          label670:
          if (!((b)localObject).M)
          {
            bool1 = bool2;
            if (((b)localObject).i.c != null)
            {
              bool1 = bool2;
              if (((b)localObject).k.c != null)
              {
                bool1 = bool2;
                if (((b)localObject).G == b.a.c) {}
              }
            }
          }
          else
          {
            bool1 = true;
          }
          paramb.M = bool1;
          i = n;
          m = k;
          if (!paramb.M) {
            break;
          }
          if (((b)localObject).k.c != null) {
            break label867;
          }
        }
        for (;;)
        {
          i = n + (n - ((b)localObject).J);
          m = k;
          break;
          label776:
          i = m;
          if (paramb.k.c.getType() != a.c.b) {
            break label524;
          }
          i = m + localb1.K;
          break label524;
          label807:
          bool1 = false;
          break label568;
          label813:
          k = i;
          if (localb1.i.c.a == paramb) {
            break label606;
          }
          break label595;
          n = j;
          if (paramb.i.c.getType() != a.c.d) {
            break label670;
          }
          n = j + ((b)localObject).J;
          break label670;
          label867:
          i = n;
          m = k;
          if (((b)localObject).k.c.a == paramb) {
            break;
          }
        }
        localb1 = null;
        m = i;
      }
      label901:
      i = 0;
      continue;
      label906:
      j = i;
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public void findVerticalWrapRecursive(b paramb, boolean[] paramArrayOfBoolean)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    int j = 0;
    if ((paramb.H == b.a.c) && (paramb.G != b.a.c) && (paramb.u > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    int i = paramb.getOptimizerWrapHeight();
    paramb.R = true;
    if ((paramb instanceof d))
    {
      paramArrayOfBoolean = (d)paramb;
      if (paramArrayOfBoolean.getOrientation() != 0) {
        break label1063;
      }
      if (paramArrayOfBoolean.getRelativeBegin() != -1)
      {
        j = paramArrayOfBoolean.getRelativeBegin();
        i = 0;
      }
    }
    for (;;)
    {
      for (int m = j;; m = i + paramb.getY())
      {
        k = i;
        j = m;
        if (paramb.getVisibility() == 8)
        {
          j = m - paramb.t;
          k = i - paramb.t;
        }
        paramb.I = j;
        paramb.L = k;
        return;
        if (paramArrayOfBoolean.getRelativeEnd() == -1) {
          break label1058;
        }
        i = paramArrayOfBoolean.getRelativeEnd();
        break;
        if ((paramb.m.c != null) || (paramb.j.c != null) || (paramb.l.c != null)) {
          break label195;
        }
      }
      label195:
      if ((paramb.l.c != null) && (paramb.j.c != null) && ((paramb.l.c == paramb.j.c) || ((paramb.l.c.a == paramb.j.c.a) && (paramb.l.c.a != paramb.r))))
      {
        paramArrayOfBoolean[0] = false;
        return;
      }
      Object localObject1;
      if (paramb.m.isConnected())
      {
        localObject1 = paramb.m.c.getOwner();
        if (!((b)localObject1).R) {
          findVerticalWrapRecursive((b)localObject1, paramArrayOfBoolean);
        }
        k = Math.max(((b)localObject1).I - ((b)localObject1).t + i, i);
        m = Math.max(((b)localObject1).L - ((b)localObject1).t + i, i);
        j = m;
        i = k;
        if (paramb.getVisibility() == 8)
        {
          i = k - paramb.t;
          j = m - paramb.t;
        }
        paramb.I = i;
        paramb.L = j;
        return;
      }
      b localb;
      if (paramb.j.isConnected())
      {
        localb = paramb.j.c.getOwner();
        j = paramb.j.getMargin() + i;
        localObject1 = localb;
        m = j;
        if (!localb.isRoot())
        {
          localObject1 = localb;
          m = j;
          if (!localb.R)
          {
            findVerticalWrapRecursive(localb, paramArrayOfBoolean);
            m = j;
            localObject1 = localb;
          }
        }
      }
      for (;;)
      {
        j = i;
        if (paramb.l.isConnected())
        {
          localb = paramb.l.c.getOwner();
          i += paramb.l.getMargin();
          j = i;
          localObject2 = localb;
          if (!localb.isRoot())
          {
            j = i;
            localObject2 = localb;
            if (!localb.R)
            {
              findVerticalWrapRecursive(localb, paramArrayOfBoolean);
              localObject2 = localb;
              j = i;
            }
          }
        }
        k = m;
        label613:
        boolean bool1;
        if (paramb.j.c != null)
        {
          k = m;
          if (!((b)localObject1).isRoot())
          {
            if (paramb.j.c.getType() != a.c.c) {
              break label933;
            }
            i = m + (((b)localObject1).I - ((b)localObject1).getOptimizerWrapHeight());
            if ((!((b)localObject1).O) && ((((b)localObject1).j.c == null) || (((b)localObject1).j.c.a == paramb) || (((b)localObject1).l.c == null) || (((b)localObject1).l.c.a == paramb) || (((b)localObject1).H == b.a.c))) {
              break label964;
            }
            bool1 = true;
            label687:
            paramb.O = bool1;
            k = i;
            if (paramb.O)
            {
              if (((b)localObject1).l.c != null) {
                break label970;
              }
              label714:
              k = i + (i - ((b)localObject1).I);
            }
          }
        }
        label725:
        i = j;
        m = k;
        if (paramb.l.c == null) {
          break;
        }
        i = j;
        m = k;
        if (((b)localObject2).isRoot()) {
          break;
        }
        int n;
        if (paramb.l.c.getType() == a.c.e)
        {
          n = j + (((b)localObject2).L - ((b)localObject2).getOptimizerWrapHeight());
          label789:
          if (!((b)localObject2).P)
          {
            bool1 = bool2;
            if (((b)localObject2).j.c != null)
            {
              bool1 = bool2;
              if (((b)localObject2).j.c.a != paramb)
              {
                bool1 = bool2;
                if (((b)localObject2).l.c != null)
                {
                  bool1 = bool2;
                  if (((b)localObject2).l.c.a != paramb)
                  {
                    bool1 = bool2;
                    if (((b)localObject2).H == b.a.c) {}
                  }
                }
              }
            }
          }
          else
          {
            bool1 = true;
          }
          paramb.P = bool1;
          i = n;
          m = k;
          if (!paramb.P) {
            break;
          }
          if (((b)localObject2).j.c != null) {
            break label1024;
          }
        }
        for (;;)
        {
          i = n + (n - ((b)localObject2).L);
          m = k;
          break;
          label933:
          i = m;
          if (paramb.j.c.getType() != a.c.e) {
            break label613;
          }
          i = m + ((b)localObject1).I;
          break label613;
          label964:
          bool1 = false;
          break label687;
          label970:
          k = i;
          if (((b)localObject1).l.c.a == paramb) {
            break label725;
          }
          break label714;
          n = j;
          if (paramb.l.c.getType() != a.c.c) {
            break label789;
          }
          n = j + ((b)localObject2).L;
          break label789;
          label1024:
          i = n;
          m = k;
          if (((b)localObject2).j.c.a == paramb) {
            break;
          }
        }
        localObject1 = null;
        m = i;
      }
      label1058:
      i = 0;
      continue;
      label1063:
      j = i;
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public void findWrapSize(ArrayList<b> paramArrayList, boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i5 = paramArrayList.size();
    paramArrayOfBoolean[0] = true;
    int i4 = 0;
    b localb;
    int i2;
    for (;;)
    {
      if (i4 < i5)
      {
        localb = (b)paramArrayList.get(i4);
        if (localb.isRoot())
        {
          i2 = j;
          j = k;
          k = n;
          n = i;
          i = i2;
          i4 += 1;
          i2 = n;
          n = k;
          k = j;
          j = i;
          i = i2;
        }
        else
        {
          if (!localb.Q) {
            findHorizontalWrapRecursive(localb, paramArrayOfBoolean);
          }
          if (!localb.R) {
            findVerticalWrapRecursive(localb, paramArrayOfBoolean);
          }
          if (paramArrayOfBoolean[0] != 0) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      return;
      i2 = localb.J + localb.K - localb.getWidth();
      int i3 = localb.I + localb.L - localb.getHeight();
      if (localb.G == b.a.d) {
        i2 = localb.getWidth() + localb.i.d + localb.k.d;
      }
      if (localb.H == b.a.d) {
        i3 = localb.getHeight() + localb.j.d + localb.l.d;
      }
      if (localb.getVisibility() == 8)
      {
        i2 = 0;
        i3 = 0;
      }
      i1 = Math.max(i1, localb.J);
      n = Math.max(n, localb.K);
      m = Math.max(m, localb.L);
      i = Math.max(i, localb.I);
      i2 = Math.max(k, i2);
      j = Math.max(j, i3);
      k = n;
      n = i;
      i = j;
      j = i2;
      break;
      n = Math.max(i1, n);
      this.ad = Math.max(this.B, Math.max(n, k));
      i = Math.max(i, m);
      this.ae = Math.max(this.C, Math.max(i, j));
      i = 0;
      while (i < i5)
      {
        paramArrayOfBoolean = (b)paramArrayList.get(i);
        paramArrayOfBoolean.Q = false;
        paramArrayOfBoolean.R = false;
        paramArrayOfBoolean.M = false;
        paramArrayOfBoolean.N = false;
        paramArrayOfBoolean.O = false;
        paramArrayOfBoolean.P = false;
        i += 1;
      }
    }
  }
  
  public ArrayList<d> getHorizontalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.aj.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (b)this.aj.get(i);
      if ((localObject instanceof d))
      {
        localObject = (d)localObject;
        if (((d)localObject).getOrientation() == 0) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public android.support.constraint.a.e getSystem()
  {
    return this.aa;
  }
  
  public String getType()
  {
    return "ConstraintLayout";
  }
  
  public ArrayList<d> getVerticalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.aj.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (b)this.aj.get(i);
      if ((localObject instanceof d))
      {
        localObject = (d)localObject;
        if (((d)localObject).getOrientation() == 1) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean handlesInternalConstraints()
  {
    return false;
  }
  
  public boolean isHeightMeasuredTooSmall()
  {
    return this.au;
  }
  
  public boolean isWidthMeasuredTooSmall()
  {
    return this.at;
  }
  
  public void layout()
  {
    int n = this.w;
    int i1 = this.x;
    int i2 = Math.max(0, getWidth());
    int i3 = Math.max(0, getHeight());
    this.at = false;
    this.au = false;
    int i6;
    b.a locala1;
    b.a locala2;
    if (this.r != null)
    {
      if (this.ak == null) {
        this.ak = new g(this);
      }
      this.ak.updateFrom(this);
      setX(this.af);
      setY(this.ag);
      resetAnchors();
      resetSolverVariables(this.aa.getCache());
      i6 = 0;
      locala1 = this.H;
      locala2 = this.G;
      i7 = i6;
      if (this.aq != 2) {
        break label425;
      }
      if (this.H != b.a.b)
      {
        i7 = i6;
        if (this.G != b.a.b) {
          break label425;
        }
      }
      findWrapSize(this.aj, this.ar);
      i7 = this.ar[0];
      i6 = i7;
      if (i2 > 0)
      {
        i6 = i7;
        if (i3 > 0) {
          if (this.ad <= i2)
          {
            i6 = i7;
            if (this.ae <= i3) {}
          }
          else
          {
            i6 = 0;
          }
        }
      }
      i7 = i6;
      if (i6 == 0) {
        break label425;
      }
      if (this.G == b.a.b)
      {
        this.G = b.a.a;
        if ((i2 <= 0) || (i2 >= this.ad)) {
          break label388;
        }
        this.at = true;
        setWidth(i2);
      }
      label272:
      i7 = i6;
      if (this.H != b.a.b) {
        break label425;
      }
      this.H = b.a.a;
      if ((i3 <= 0) || (i3 >= this.ae)) {
        break label406;
      }
      this.au = true;
      setHeight(i3);
    }
    int i4;
    b localb1;
    for (;;)
    {
      c();
      i4 = this.aj.size();
      i = 0;
      while (i < i4)
      {
        localb1 = (b)this.aj.get(i);
        if ((localb1 instanceof h)) {
          ((h)localb1).layout();
        }
        i += 1;
      }
      this.w = 0;
      this.x = 0;
      break;
      label388:
      setWidth(Math.max(this.B, this.ad));
      break label272;
      label406:
      setHeight(Math.max(this.C, this.ae));
      i7 = i6;
      label425:
      i6 = i7;
    }
    int i = 0;
    int i7 = 1;
    int m;
    int i9;
    int j;
    int i10;
    if (i7 != 0)
    {
      m = i + 1;
      i9 = i7;
      try
      {
        this.aa.reset();
        i9 = i7;
        i8 = addChildrenToSolver(this.aa, Integer.MAX_VALUE);
        i9 = i8;
        if (i8 != 0)
        {
          i9 = i8;
          this.aa.minimize();
          i9 = i8;
        }
      }
      catch (Exception localException)
      {
        int k;
        for (;;)
        {
          localException.printStackTrace();
        }
        updateFromSolver(this.aa, Integer.MAX_VALUE);
        i = 0;
        while (i < i4)
        {
          b localb2 = (b)this.aj.get(i);
          if ((localb2.G == b.a.c) && (localb2.getWidth() < localb2.getWrapWidth()))
          {
            this.ar[2] = true;
            break;
          }
          if ((localb2.H == b.a.c) && (localb2.getHeight() < localb2.getWrapHeight()))
          {
            this.ar[2] = true;
            break;
          }
          i += 1;
        }
        j = Math.max(this.B, k);
        i = Math.max(this.C, i);
        if (locala2 != b.a.b) {
          break label1206;
        }
      }
      if (i9 != 0)
      {
        updateChildrenFromSolver(this.aa, Integer.MAX_VALUE, this.ar);
        if ((m >= 8) || (this.ar[2] == 0)) {
          break label1216;
        }
        k = 0;
        i = 0;
        j = 0;
        while (j < i4)
        {
          localb1 = (b)this.aj.get(j);
          k = Math.max(k, localb1.w + localb1.getWidth());
          int i5 = localb1.x;
          i = Math.max(i, localb1.getHeight() + i5);
          j += 1;
        }
      }
      if (getWidth() >= j) {
        break label1206;
      }
      setWidth(j);
      this.G = b.a.b;
      i10 = 1;
      i9 = 1;
      label772:
      i8 = i9;
      i6 = i10;
      if (locala1 == b.a.b)
      {
        i8 = i9;
        i6 = i10;
        if (getHeight() < i)
        {
          setHeight(i);
          this.H = b.a.b;
          i6 = 1;
        }
      }
    }
    label1206:
    label1216:
    for (int i8 = 1;; i8 = 0)
    {
      i = Math.max(this.B, getWidth());
      i9 = i8;
      i8 = i6;
      if (i > getWidth())
      {
        setWidth(i);
        this.G = b.a.a;
        i8 = 1;
        i9 = 1;
      }
      i = Math.max(this.C, getHeight());
      i6 = i9;
      if (i > getHeight())
      {
        setHeight(i);
        this.H = b.a.a;
        i8 = 1;
        i6 = 1;
      }
      i9 = i6;
      i10 = i8;
      if (i8 == 0)
      {
        int i12 = i6;
        int i11 = i8;
        if (this.G == b.a.b)
        {
          i12 = i6;
          i11 = i8;
          if (i2 > 0)
          {
            i12 = i6;
            i11 = i8;
            if (getWidth() > i2)
            {
              this.at = true;
              i11 = 1;
              this.G = b.a.a;
              setWidth(i2);
              i12 = 1;
            }
          }
        }
        i9 = i12;
        i10 = i11;
        if (this.H == b.a.b)
        {
          i9 = i12;
          i10 = i11;
          if (i3 > 0)
          {
            i9 = i12;
            i10 = i11;
            if (getHeight() > i3)
            {
              this.au = true;
              i10 = 1;
              this.H = b.a.a;
              setHeight(i3);
              i9 = 1;
            }
          }
        }
      }
      i6 = i10;
      i8 = i9;
      i = m;
      break;
      if (this.r != null)
      {
        i = Math.max(this.B, getWidth());
        j = Math.max(this.C, getHeight());
        this.ak.applyTo(this);
        setWidth(i + this.af + this.ah);
        setHeight(this.ag + j + this.ai);
      }
      for (;;)
      {
        if (i6 != 0)
        {
          this.G = locala2;
          this.H = locala1;
        }
        resetSolverVariables(this.aa.getCache());
        if (this == getRootConstraintContainer()) {
          updateDrawPosition();
        }
        return;
        this.w = n;
        this.x = i1;
      }
      i9 = 0;
      i10 = i6;
      break label772;
    }
  }
  
  public int layoutFindGroups()
  {
    Object localObject2 = new a.c[5];
    localObject2[0] = a.c.b;
    localObject2[1] = a.c.d;
    localObject2[2] = a.c.c;
    localObject2[3] = a.c.f;
    localObject2[4] = a.c.e;
    int i = 1;
    int i3 = this.aj.size();
    int k = 0;
    Object localObject3;
    int j;
    if (k < i3)
    {
      localObject1 = (b)this.aj.get(k);
      localObject3 = ((b)localObject1).i;
      if (((a)localObject3).c != null)
      {
        j = i;
        if (a((a)localObject3, i) == i) {
          j = i + 1;
        }
        label104:
        localObject3 = ((b)localObject1).j;
        if (((a)localObject3).c == null) {
          break label250;
        }
        i = j;
        if (a((a)localObject3, j) == j) {
          i = j + 1;
        }
        label135:
        localObject3 = ((b)localObject1).k;
        if (((a)localObject3).c == null) {
          break label263;
        }
        j = i;
        if (a((a)localObject3, i) == i) {
          j = i + 1;
        }
        label166:
        localObject3 = ((b)localObject1).l;
        if (((a)localObject3).c == null) {
          break label276;
        }
        i = j;
        if (a((a)localObject3, j) == j) {
          i = j + 1;
        }
        label197:
        localObject1 = ((b)localObject1).m;
        if (((a)localObject1).c == null) {
          break label289;
        }
        j = i;
        if (a((a)localObject1, i) != i) {}
      }
      for (j = i + 1;; j = i)
      {
        k += 1;
        i = j;
        break;
        ((a)localObject3).g = Integer.MAX_VALUE;
        j = i;
        break label104;
        label250:
        ((a)localObject3).g = Integer.MAX_VALUE;
        i = j;
        break label135;
        label263:
        ((a)localObject3).g = Integer.MAX_VALUE;
        j = i;
        break label166;
        label276:
        ((a)localObject3).g = Integer.MAX_VALUE;
        i = j;
        break label197;
        label289:
        ((a)localObject1).g = Integer.MAX_VALUE;
      }
    }
    k = 1;
    int n = 0;
    i = 0;
    label404:
    int m;
    while (k != 0)
    {
      k = 0;
      int i1 = 0;
      while (i1 < i3)
      {
        localObject3 = (b)this.aj.get(i1);
        int i2 = 0;
        if (i2 < localObject2.length)
        {
          a locala = localObject2[i2];
          localObject1 = null;
          switch (1.a[locala.ordinal()])
          {
          default: 
            locala = ((a)localObject1).c;
            if (locala != null) {
              break;
            }
          }
          label528:
          do
          {
            do
            {
              i2 += 1;
              break;
              localObject1 = ((b)localObject3).i;
              break label404;
              localObject1 = ((b)localObject3).j;
              break label404;
              localObject1 = ((b)localObject3).k;
              break label404;
              localObject1 = ((b)localObject3).l;
              break label404;
              localObject1 = ((b)localObject3).m;
              break label404;
              j = i;
              m = k;
              if (locala.a.getParent() != null)
              {
                j = i;
                m = k;
                if (locala.g != ((a)localObject1).g)
                {
                  if (((a)localObject1).g <= locala.g) {
                    break label622;
                  }
                  j = locala.g;
                  ((a)localObject1).g = j;
                  locala.g = j;
                  j = i + 1;
                  m = 1;
                }
              }
              locala = locala.getOpposite();
              i = j;
              k = m;
            } while (locala == null);
            i = j;
            k = m;
          } while (locala.g == ((a)localObject1).g);
          if (((a)localObject1).g > locala.g) {}
          for (i = locala.g;; i = ((a)localObject1).g)
          {
            ((a)localObject1).g = i;
            locala.g = i;
            i = j + 1;
            k = 1;
            break;
            label622:
            j = ((a)localObject1).g;
            break label528;
          }
        }
        i1 += 1;
      }
      n += 1;
    }
    i = 0;
    Object localObject1 = new int[this.aj.size() * localObject2.length + 1];
    Arrays.fill((int[])localObject1, -1);
    k = 0;
    if (k < i3)
    {
      localObject2 = (b)this.aj.get(k);
      localObject3 = ((b)localObject2).i;
      if (((a)localObject3).g == Integer.MAX_VALUE) {
        break label1006;
      }
      m = ((a)localObject3).g;
      if (localObject1[m] != -1) {
        break label1001;
      }
      j = i + 1;
      localObject1[m] = i;
      label748:
      ((a)localObject3).g = localObject1[m];
    }
    for (;;)
    {
      localObject3 = ((b)localObject2).j;
      i = j;
      if (((a)localObject3).g != Integer.MAX_VALUE)
      {
        m = ((a)localObject3).g;
        i = j;
        if (localObject1[m] == -1)
        {
          localObject1[m] = j;
          i = j + 1;
        }
        ((a)localObject3).g = localObject1[m];
      }
      localObject3 = ((b)localObject2).k;
      j = i;
      if (((a)localObject3).g != Integer.MAX_VALUE)
      {
        m = ((a)localObject3).g;
        j = i;
        if (localObject1[m] == -1)
        {
          localObject1[m] = i;
          j = i + 1;
        }
        ((a)localObject3).g = localObject1[m];
      }
      localObject3 = ((b)localObject2).l;
      i = j;
      if (((a)localObject3).g != Integer.MAX_VALUE)
      {
        m = ((a)localObject3).g;
        i = j;
        if (localObject1[m] == -1)
        {
          localObject1[m] = j;
          i = j + 1;
        }
        ((a)localObject3).g = localObject1[m];
      }
      localObject2 = ((b)localObject2).m;
      j = i;
      if (((a)localObject2).g != Integer.MAX_VALUE)
      {
        m = ((a)localObject2).g;
        j = i;
        if (localObject1[m] == -1)
        {
          localObject1[m] = i;
          j = i + 1;
        }
        ((a)localObject2).g = localObject1[m];
      }
      k += 1;
      i = j;
      break;
      return i;
      label1001:
      j = i;
      break label748;
      label1006:
      j = i;
    }
  }
  
  public int layoutFindGroupsSimple()
  {
    int j = this.aj.size();
    int i = 0;
    while (i < j)
    {
      b localb = (b)this.aj.get(i);
      localb.i.g = 0;
      localb.k.g = 0;
      localb.j.g = 1;
      localb.l.g = 1;
      localb.m.g = 1;
      i += 1;
    }
    return 2;
  }
  
  public void layoutWithGroup(int paramInt)
  {
    int j = 0;
    int k = this.w;
    int m = this.x;
    if (this.r != null)
    {
      if (this.ak == null) {
        this.ak = new g(this);
      }
      this.ak.updateFrom(this);
      this.w = 0;
      this.x = 0;
      resetAnchors();
      resetSolverVariables(this.aa.getCache());
    }
    for (;;)
    {
      int n = this.aj.size();
      i = 0;
      while (i < n)
      {
        b localb = (b)this.aj.get(i);
        if ((localb instanceof h)) {
          ((h)localb).layout();
        }
        i += 1;
      }
      this.w = 0;
      this.x = 0;
    }
    this.i.g = 0;
    this.k.g = 0;
    this.j.g = 1;
    this.l.g = 1;
    this.aa.reset();
    int i = j;
    for (;;)
    {
      if (i < paramInt) {
        try
        {
          addToSolver(this.aa, i);
          this.aa.minimize();
          updateFromSolver(this.aa, i);
          updateFromSolver(this.aa, -2);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    if (this.r != null)
    {
      paramInt = getWidth();
      i = getHeight();
      this.ak.applyTo(this);
      setWidth(paramInt);
      setHeight(i);
    }
    for (;;)
    {
      if (this == getRootConstraintContainer()) {
        updateDrawPosition();
      }
      return;
      this.w = k;
      this.x = m;
    }
  }
  
  public void reset()
  {
    this.aa.reset();
    this.af = 0;
    this.ah = 0;
    this.ag = 0;
    this.ai = 0;
    super.reset();
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.aq = paramInt;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.af = paramInt1;
    this.ag = paramInt2;
    this.ah = paramInt3;
    this.ai = paramInt4;
  }
  
  public void updateChildrenFromSolver(android.support.constraint.a.e parame, int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[2] = false;
    updateFromSolver(parame, paramInt);
    int j = this.aj.size();
    int i = 0;
    while (i < j)
    {
      b localb = (b)this.aj.get(i);
      localb.updateFromSolver(parame, paramInt);
      if ((localb.G == b.a.c) && (localb.getWidth() < localb.getWrapWidth())) {
        paramArrayOfBoolean[2] = true;
      }
      if ((localb.H == b.a.c) && (localb.getHeight() < localb.getWrapHeight())) {
        paramArrayOfBoolean[2] = true;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */