package android.support.constraint.a.a;

import android.support.constraint.a.e;
import android.support.constraint.a.g;
import java.util.ArrayList;

public class b
{
  public static float D = 0.5F;
  int A = 0;
  protected int B;
  protected int C;
  float E = D;
  float F = D;
  a G = a.a;
  a H = a.a;
  int I;
  int J;
  int K;
  int L;
  boolean M;
  boolean N;
  boolean O;
  boolean P;
  boolean Q;
  boolean R;
  int S = 0;
  int T = 0;
  boolean U;
  boolean V;
  float W = 0.0F;
  float X = 0.0F;
  b Y = null;
  b Z = null;
  public int a = -1;
  private int aa = 0;
  private int ab = 0;
  private int ac = 0;
  private int ad = 0;
  private int ae = 0;
  private int af = 0;
  private int ag = 0;
  private int ah = 0;
  private int ai;
  private int aj;
  private Object ak;
  private int al = 0;
  private int am = 0;
  private String an = null;
  private String ao = null;
  public int b = -1;
  int c = 0;
  int d = 0;
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  a i = new a(this, a.c.b);
  a j = new a(this, a.c.c);
  a k = new a(this, a.c.d);
  a l = new a(this, a.c.e);
  a m = new a(this, a.c.f);
  a n = new a(this, a.c.h);
  a o = new a(this, a.c.i);
  a p = new a(this, a.c.g);
  protected ArrayList<a> q = new ArrayList();
  b r = null;
  int s = 0;
  int t = 0;
  protected float u = 0.0F;
  protected int v = -1;
  protected int w = 0;
  protected int x = 0;
  protected int y = 0;
  protected int z = 0;
  
  public b()
  {
    c();
  }
  
  public b(int paramInt1, int paramInt2)
  {
    this(0, 0, paramInt1, paramInt2);
  }
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.w = paramInt1;
    this.x = paramInt2;
    this.s = paramInt3;
    this.t = paramInt4;
    c();
    forceUpdateDrawPosition();
  }
  
  private void a(e parame, boolean paramBoolean1, boolean paramBoolean2, a parama1, a parama2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7)
  {
    g localg3 = parame.createObjectVariable(parama1);
    g localg1 = parame.createObjectVariable(parama2);
    g localg4 = parame.createObjectVariable(parama1.getTarget());
    g localg2 = parame.createObjectVariable(parama2.getTarget());
    int i1 = parama1.getMargin();
    int i2 = parama2.getMargin();
    if (this.am == 8)
    {
      paramInt3 = 0;
      paramBoolean2 = true;
    }
    for (;;)
    {
      if ((localg4 == null) && (localg2 == null))
      {
        parame.addConstraint(parame.createRow().createRowEquals(localg3, paramInt1));
        if (!paramBoolean3)
        {
          if (!paramBoolean1) {
            break label116;
          }
          parame.addConstraint(e.createRowEquals(parame, localg1, localg3, paramInt4, true));
        }
      }
      label116:
      label626:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramBoolean2)
              {
                parame.addConstraint(e.createRowEquals(parame, localg1, localg3, paramInt3, false));
                return;
              }
              parame.addConstraint(parame.createRow().createRowEquals(localg1, paramInt2));
              return;
              if ((localg4 == null) || (localg2 != null)) {
                break;
              }
              parame.addConstraint(parame.createRow().createRowEquals(localg3, localg4, i1));
              if (paramBoolean1)
              {
                parame.addConstraint(e.createRowEquals(parame, localg1, localg3, paramInt4, true));
                return;
              }
            } while (paramBoolean3);
            if (paramBoolean2)
            {
              parame.addConstraint(parame.createRow().createRowEquals(localg1, localg3, paramInt3));
              return;
            }
            parame.addConstraint(parame.createRow().createRowEquals(localg1, paramInt2));
            return;
            if ((localg4 != null) || (localg2 == null)) {
              break;
            }
            parame.addConstraint(parame.createRow().createRowEquals(localg1, localg2, i2 * -1));
            if (paramBoolean1)
            {
              parame.addConstraint(e.createRowEquals(parame, localg1, localg3, paramInt4, true));
              return;
            }
          } while (paramBoolean3);
          if (paramBoolean2)
          {
            parame.addConstraint(parame.createRow().createRowEquals(localg1, localg3, paramInt3));
            return;
          }
          parame.addConstraint(parame.createRow().createRowEquals(localg3, paramInt1));
          return;
          if (!paramBoolean2) {
            break;
          }
          if (paramBoolean1) {
            parame.addConstraint(e.createRowEquals(parame, localg1, localg3, paramInt4, true));
          }
          while (parama1.getStrength() != parama2.getStrength()) {
            if (parama1.getStrength() == a.b.b)
            {
              parame.addConstraint(parame.createRow().createRowEquals(localg3, localg4, i1));
              parama1 = parame.createSlackVariable();
              parama2 = parame.createRow();
              parama2.createRowLowerThan(localg1, localg2, parama1, i2 * -1);
              parame.addConstraint(parama2);
              return;
              parame.addConstraint(parame.createRow().createRowEquals(localg1, localg3, paramInt3));
            }
            else
            {
              parama1 = parame.createSlackVariable();
              parama2 = parame.createRow();
              parama2.createRowGreaterThan(localg3, localg4, parama1, i1);
              parame.addConstraint(parama2);
              parame.addConstraint(parame.createRow().createRowEquals(localg1, localg2, i2 * -1));
              return;
            }
          }
          if (localg4 == localg2)
          {
            parame.addConstraint(e.createRowCentering(parame, localg3, localg4, 0, 0.5F, localg2, localg1, 0, true));
            return;
          }
        } while (paramBoolean4);
        if (parama1.getConnectionType() != a.a.b)
        {
          paramBoolean1 = true;
          parame.addConstraint(e.createRowGreaterThan(parame, localg3, localg4, i1, paramBoolean1));
          if (parama2.getConnectionType() == a.a.b) {
            break label626;
          }
        }
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          parame.addConstraint(e.createRowLowerThan(parame, localg1, localg2, i2 * -1, paramBoolean1));
          parame.addConstraint(e.createRowCentering(parame, localg3, localg4, i1, paramFloat, localg2, localg1, i2, false));
          return;
          paramBoolean1 = false;
          break;
        }
        if (paramBoolean3)
        {
          parame.addGreaterThan(localg3, localg4, i1, 3);
          parame.addLowerThan(localg1, localg2, i2 * -1, 3);
          parame.addConstraint(e.createRowCentering(parame, localg3, localg4, i1, paramFloat, localg2, localg1, i2, true));
          return;
        }
      } while (paramBoolean4);
      if (paramInt5 == 1)
      {
        paramInt1 = paramInt3;
        if (paramInt6 > paramInt3) {
          paramInt1 = paramInt6;
        }
        if (paramInt7 > 0) {
          if (paramInt7 >= paramInt1) {}
        }
        for (;;)
        {
          parame.addEquality(localg1, localg3, paramInt7, 3);
          parame.addGreaterThan(localg3, localg4, i1, 2);
          parame.addLowerThan(localg1, localg2, -i2, 2);
          parame.addCentering(localg3, localg4, i1, paramFloat, localg2, localg1, i2, 4);
          return;
          parame.addLowerThan(localg1, localg3, paramInt7, 3);
          paramInt7 = paramInt1;
        }
      }
      if ((paramInt6 == 0) && (paramInt7 == 0))
      {
        parame.addConstraint(parame.createRow().createRowEquals(localg3, localg4, i1));
        parame.addConstraint(parame.createRow().createRowEquals(localg1, localg2, i2 * -1));
        return;
      }
      if (paramInt7 > 0) {
        parame.addLowerThan(localg1, localg3, paramInt7, 3);
      }
      parame.addGreaterThan(localg3, localg4, i1, 2);
      parame.addLowerThan(localg1, localg2, -i2, 2);
      parame.addCentering(localg3, localg4, i1, paramFloat, localg2, localg1, i2, 4);
      return;
    }
  }
  
  private void c()
  {
    this.q.add(this.i);
    this.q.add(this.j);
    this.q.add(this.k);
    this.q.add(this.l);
    this.q.add(this.n);
    this.q.add(this.o);
    this.q.add(this.m);
  }
  
  protected int a()
  {
    return this.w + this.y;
  }
  
  public void addToSolver(e parame)
  {
    addToSolver(parame, Integer.MAX_VALUE);
  }
  
  public void addToSolver(e parame, int paramInt)
  {
    if ((paramInt == Integer.MAX_VALUE) || (this.i.g == paramInt)) {}
    for (g localg1 = parame.createObjectVariable(this.i);; localg1 = null)
    {
      if ((paramInt == Integer.MAX_VALUE) || (this.k.g == paramInt)) {}
      for (g localg2 = parame.createObjectVariable(this.k);; localg2 = null)
      {
        if ((paramInt == Integer.MAX_VALUE) || (this.j.g == paramInt)) {}
        for (g localg3 = parame.createObjectVariable(this.j);; localg3 = null)
        {
          if ((paramInt == Integer.MAX_VALUE) || (this.l.g == paramInt)) {}
          for (g localg4 = parame.createObjectVariable(this.l);; localg4 = null)
          {
            if ((paramInt == Integer.MAX_VALUE) || (this.m.g == paramInt)) {}
            for (Object localObject1 = parame.createObjectVariable(this.m);; localObject1 = null)
            {
              boolean bool1;
              boolean bool2;
              label285:
              Object localObject2;
              Object localObject3;
              label370:
              label437:
              label522:
              boolean bool3;
              boolean bool4;
              if (this.r != null) {
                if (((this.i.c != null) && (this.i.c.c == this.i)) || ((this.k.c != null) && (this.k.c.c == this.k)))
                {
                  ((c)this.r).a(this, 0);
                  bool1 = true;
                  if (((this.j.c != null) && (this.j.c.c == this.j)) || ((this.l.c != null) && (this.l.c.c == this.l)))
                  {
                    ((c)this.r).a(this, 1);
                    bool2 = true;
                    if ((this.r.getHorizontalDimensionBehaviour() == a.b) && (!bool1))
                    {
                      if ((this.i.c != null) && (this.i.c.a == this.r)) {
                        break label1128;
                      }
                      localObject2 = parame.createObjectVariable(this.r.i);
                      localObject3 = parame.createRow();
                      ((android.support.constraint.a.b)localObject3).createRowGreaterThan(localg1, (g)localObject2, parame.createSlackVariable(), 0);
                      parame.addConstraint((android.support.constraint.a.b)localObject3);
                      break label1127;
                      if ((this.k.c != null) && (this.k.c.a == this.r)) {
                        break label1168;
                      }
                      localObject2 = parame.createObjectVariable(this.r.k);
                      localObject3 = parame.createRow();
                      ((android.support.constraint.a.b)localObject3).createRowGreaterThan((g)localObject2, localg2, parame.createSlackVariable(), 0);
                      parame.addConstraint((android.support.constraint.a.b)localObject3);
                    }
                    else
                    {
                      if ((this.r.getVerticalDimensionBehaviour() != a.b) || (bool2)) {
                        break label1285;
                      }
                      if ((this.j.c != null) && (this.j.c.a == this.r)) {
                        break label1208;
                      }
                      localObject2 = parame.createObjectVariable(this.r.j);
                      localObject3 = parame.createRow();
                      ((android.support.constraint.a.b)localObject3).createRowGreaterThan(localg3, (g)localObject2, parame.createSlackVariable(), 0);
                      parame.addConstraint((android.support.constraint.a.b)localObject3);
                      if ((this.l.c != null) && (this.l.c.a == this.r)) {
                        break label1248;
                      }
                      localObject2 = parame.createObjectVariable(this.r.l);
                      localObject3 = parame.createRow();
                      ((android.support.constraint.a.b)localObject3).createRowGreaterThan((g)localObject2, localg4, parame.createSlackVariable(), 0);
                      parame.addConstraint((android.support.constraint.a.b)localObject3);
                      bool3 = bool2;
                      bool4 = bool1;
                    }
                  }
                }
              }
              for (;;)
              {
                label597:
                int i2 = this.s;
                int i1 = i2;
                if (i2 < this.B) {
                  i1 = this.B;
                }
                int i3 = this.t;
                i2 = i3;
                if (i3 < this.C) {
                  i2 = this.C;
                }
                if (this.G != a.c)
                {
                  bool1 = true;
                  label660:
                  if (this.H == a.c) {
                    break label1302;
                  }
                  bool2 = true;
                  label673:
                  if ((bool1) || (this.i == null) || (this.k == null) || ((this.i.c != null) && (this.k.c != null))) {
                    break label2407;
                  }
                  bool1 = true;
                }
                label902:
                label921:
                label941:
                label1119:
                label1127:
                label1128:
                label1168:
                label1208:
                label1248:
                label1285:
                label1302:
                label1508:
                label1514:
                label1571:
                label1591:
                label1611:
                label1927:
                label1933:
                label2000:
                label2228:
                label2229:
                label2230:
                label2351:
                label2362:
                label2365:
                label2407:
                for (;;)
                {
                  if ((!bool2) && (this.j != null) && (this.l != null) && ((this.j.c == null) || (this.l.c == null)) && ((this.A == 0) || ((this.m != null) && ((this.j.c == null) || (this.m.c == null))))) {
                    bool2 = true;
                  }
                  for (;;)
                  {
                    int i6 = 0;
                    int i5 = this.v;
                    float f1 = this.u;
                    int i4 = i5;
                    i3 = i6;
                    boolean bool5;
                    if (this.u > 0.0F)
                    {
                      i4 = i5;
                      i3 = i6;
                      if (this.am != 8) {
                        if ((this.G == a.c) && (this.H == a.c))
                        {
                          i6 = 1;
                          if ((bool1) && (!bool2))
                          {
                            i3 = 0;
                            i4 = 1;
                            i5 = i1;
                            bool5 = bool1;
                            bool1 = bool2;
                            i1 = i2;
                            i2 = i5;
                            bool2 = bool5;
                          }
                        }
                      }
                    }
                    for (;;)
                    {
                      boolean bool6;
                      g localg5;
                      if ((i4 != 0) && ((i3 == 0) || (i3 == -1)))
                      {
                        bool5 = true;
                        if ((this.G != a.b) || (!(this instanceof c))) {
                          break label1508;
                        }
                        bool6 = true;
                        if ((this.a != 2) && ((paramInt == Integer.MAX_VALUE) || ((this.i.g == paramInt) && (this.k.g == paramInt))))
                        {
                          if ((!bool5) || (this.i.c == null) || (this.k.c == null)) {
                            break label1514;
                          }
                          localObject2 = parame.createObjectVariable(this.i);
                          localObject3 = parame.createObjectVariable(this.k);
                          localg5 = parame.createObjectVariable(this.i.getTarget());
                          g localg6 = parame.createObjectVariable(this.k.getTarget());
                          parame.addGreaterThan((g)localObject2, localg5, this.i.getMargin(), 3);
                          parame.addLowerThan((g)localObject3, localg6, this.k.getMargin() * -1, 3);
                          if (!bool4) {
                            parame.addCentering((g)localObject2, localg5, this.i.getMargin(), this.E, localg6, (g)localObject3, this.k.getMargin(), 4);
                          }
                        }
                        if (this.b != 2) {
                          break label1571;
                        }
                        return;
                        if ((this.i.c == null) || (this.i.c.a != this.r)) {
                          break label2229;
                        }
                        this.i.setConnectionType(a.a.b);
                        break label370;
                        if ((this.k.c == null) || (this.k.c.a != this.r)) {
                          break label437;
                        }
                        this.k.setConnectionType(a.a.b);
                        break label437;
                        if ((this.j.c == null) || (this.j.c.a != this.r)) {
                          break label522;
                        }
                        this.j.setConnectionType(a.a.b);
                        break label522;
                        if ((this.l.c != null) && (this.l.c.a == this.r)) {
                          this.l.setConnectionType(a.a.b);
                        }
                        bool4 = bool1;
                        bool3 = bool2;
                        break label597;
                        bool1 = false;
                        break label660;
                        bool2 = false;
                        break label673;
                        i4 = i5;
                        i3 = i6;
                        if (bool1) {
                          break label2365;
                        }
                        i4 = i5;
                        i3 = i6;
                        if (!bool2) {
                          break label2365;
                        }
                        i4 = 1;
                        i3 = i6;
                        if (this.v != -1) {
                          break label2365;
                        }
                        f1 = 1.0F / f1;
                        i5 = 1;
                        i4 = 1;
                        bool5 = bool2;
                        i3 = i2;
                        bool2 = bool1;
                        i2 = i1;
                        i1 = i3;
                        i3 = i5;
                        bool1 = bool5;
                        continue;
                        if (this.G == a.c)
                        {
                          i5 = (int)(this.t * f1);
                          i3 = 0;
                          i4 = 0;
                          bool1 = bool2;
                          i1 = i2;
                          bool2 = true;
                          i2 = i5;
                          continue;
                        }
                        i4 = i5;
                        i3 = i6;
                        if (this.H != a.c) {
                          break label2365;
                        }
                        if (this.v != -1) {
                          break label2362;
                        }
                        f1 = 1.0F / f1;
                      }
                      for (;;)
                      {
                        i5 = (int)(this.s * f1);
                        i3 = 1;
                        i4 = 0;
                        bool5 = true;
                        bool2 = bool1;
                        i2 = i1;
                        i1 = i5;
                        bool1 = bool5;
                        break label902;
                        bool5 = false;
                        break label921;
                        bool6 = false;
                        break label941;
                        a(parame, bool6, bool2, this.i, this.k, this.w, this.w + i2, i2, this.B, this.E, bool5, bool4, this.c, this.e, this.f);
                        break label1119;
                        if ((this.H == a.b) && ((this instanceof c)))
                        {
                          bool2 = true;
                          if ((i4 == 0) || ((i3 != 1) && (i3 != -1))) {
                            break label1927;
                          }
                          bool4 = true;
                          if (this.A <= 0) {
                            break label2000;
                          }
                          localObject2 = this.l;
                          if ((paramInt == Integer.MAX_VALUE) || ((this.l.g == paramInt) && (this.m.g == paramInt))) {
                            parame.addEquality((g)localObject1, localg3, getBaselineDistance(), 5);
                          }
                          if (this.m.c == null) {
                            break label2351;
                          }
                          i2 = this.A;
                        }
                        for (localObject1 = this.m;; localObject1 = localObject2)
                        {
                          if ((paramInt == Integer.MAX_VALUE) || ((this.j.g == paramInt) && (((a)localObject1).g == paramInt)))
                          {
                            if ((!bool4) || (this.j.c == null) || (this.l.c == null)) {
                              break label1933;
                            }
                            localObject1 = parame.createObjectVariable(this.j);
                            localObject2 = parame.createObjectVariable(this.l);
                            localObject3 = parame.createObjectVariable(this.j.getTarget());
                            localg5 = parame.createObjectVariable(this.l.getTarget());
                            parame.addGreaterThan((g)localObject1, (g)localObject3, this.j.getMargin(), 3);
                            parame.addLowerThan((g)localObject2, localg5, this.l.getMargin() * -1, 3);
                            if (!bool3) {
                              parame.addCentering((g)localObject1, (g)localObject3, this.j.getMargin(), this.F, localg5, (g)localObject2, this.l.getMargin(), 4);
                            }
                          }
                          for (;;)
                          {
                            if (i4 == 0) {
                              break label2228;
                            }
                            localObject1 = parame.createRow();
                            if ((paramInt != Integer.MAX_VALUE) && ((this.i.g != paramInt) || (this.k.g != paramInt))) {
                              break;
                            }
                            if (i3 != 0) {
                              break label2230;
                            }
                            parame.addConstraint(((android.support.constraint.a.b)localObject1).createRowDimensionRatio(localg2, localg1, localg4, localg3, f1));
                            return;
                            bool2 = false;
                            break label1591;
                            bool4 = false;
                            break label1611;
                            a(parame, bool2, bool1, this.j, (a)localObject1, this.x, this.x + i2, i2, this.C, this.F, bool4, bool3, this.d, this.g, this.h);
                            parame.addEquality(localg4, localg3, i1, 5);
                            continue;
                            if ((paramInt == Integer.MAX_VALUE) || ((this.j.g == paramInt) && (this.l.g == paramInt))) {
                              if ((bool4) && (this.j.c != null) && (this.l.c != null))
                              {
                                localObject1 = parame.createObjectVariable(this.j);
                                localObject2 = parame.createObjectVariable(this.l);
                                localObject3 = parame.createObjectVariable(this.j.getTarget());
                                localg5 = parame.createObjectVariable(this.l.getTarget());
                                parame.addGreaterThan((g)localObject1, (g)localObject3, this.j.getMargin(), 3);
                                parame.addLowerThan((g)localObject2, localg5, this.l.getMargin() * -1, 3);
                                if (!bool3) {
                                  parame.addCentering((g)localObject1, (g)localObject3, this.j.getMargin(), this.F, localg5, (g)localObject2, this.l.getMargin(), 4);
                                }
                              }
                              else
                              {
                                a(parame, bool2, bool1, this.j, this.l, this.x, this.x + i1, i1, this.C, this.F, bool4, bool3, this.d, this.g, this.h);
                              }
                            }
                          }
                          break label1127;
                          break label370;
                          if (i3 == 1)
                          {
                            parame.addConstraint(((android.support.constraint.a.b)localObject1).createRowDimensionRatio(localg4, localg3, localg2, localg1, f1));
                            return;
                          }
                          if (this.e > 0) {
                            parame.addGreaterThan(localg2, localg1, this.e, 3);
                          }
                          if (this.g > 0) {
                            parame.addGreaterThan(localg4, localg3, this.g, 3);
                          }
                          ((android.support.constraint.a.b)localObject1).createRowDimensionRatio(localg2, localg1, localg4, localg3, f1);
                          localg1 = parame.createErrorVariable();
                          localg2 = parame.createErrorVariable();
                          localg1.c = 4;
                          localg2.c = 4;
                          ((android.support.constraint.a.b)localObject1).addError(localg1, localg2);
                          parame.addConstraint((android.support.constraint.a.b)localObject1);
                          return;
                          i2 = i1;
                        }
                      }
                      i5 = i3;
                      bool5 = bool2;
                      i3 = i2;
                      bool2 = bool1;
                      i2 = i1;
                      i1 = i3;
                      i3 = i4;
                      i4 = i5;
                      bool1 = bool5;
                    }
                  }
                }
                bool2 = false;
                break label285;
                bool1 = false;
                break;
                bool3 = false;
                bool4 = false;
              }
            }
          }
        }
      }
    }
  }
  
  protected int b()
  {
    return this.x + this.z;
  }
  
  public void connect(a.c paramc1, b paramb, a.c paramc2)
  {
    connect(paramc1, paramb, paramc2, 0, a.b.b);
  }
  
  public void connect(a.c paramc1, b paramb, a.c paramc2, int paramInt)
  {
    connect(paramc1, paramb, paramc2, paramInt, a.b.b);
  }
  
  public void connect(a.c paramc1, b paramb, a.c paramc2, int paramInt, a.b paramb1)
  {
    connect(paramc1, paramb, paramc2, paramInt, paramb1, 0);
  }
  
  public void connect(a.c paramc1, b paramb, a.c paramc2, int paramInt1, a.b paramb1, int paramInt2)
  {
    a locala1;
    a locala2;
    if (paramc1 == a.c.g) {
      if (paramc2 == a.c.g)
      {
        paramc1 = getAnchor(a.c.b);
        paramc2 = getAnchor(a.c.d);
        locala1 = getAnchor(a.c.c);
        locala2 = getAnchor(a.c.e);
        if ((paramc1 != null) && (paramc1.isConnected())) {
          break label960;
        }
        if ((paramc2 != null) && (paramc2.isConnected())) {
          paramInt1 = 0;
        }
      }
    }
    for (;;)
    {
      int i1;
      if ((locala1 == null) || (!locala1.isConnected())) {
        if ((locala2 != null) && (locala2.isConnected())) {
          i1 = 0;
        }
      }
      for (;;)
      {
        label102:
        if ((paramInt1 != 0) && (i1 != 0)) {
          getAnchor(a.c.g).connect(paramb.getAnchor(a.c.g), 0, paramInt2);
        }
        do
        {
          do
          {
            do
            {
              return;
              connect(a.c.b, paramb, a.c.b, 0, paramb1, paramInt2);
              connect(a.c.d, paramb, a.c.d, 0, paramb1, paramInt2);
              paramInt1 = 1;
              break;
              connect(a.c.c, paramb, a.c.c, 0, paramb1, paramInt2);
              connect(a.c.e, paramb, a.c.e, 0, paramb1, paramInt2);
              i1 = 1;
              break label102;
              if (paramInt1 != 0)
              {
                getAnchor(a.c.h).connect(paramb.getAnchor(a.c.h), 0, paramInt2);
                return;
              }
            } while (i1 == 0);
            getAnchor(a.c.i).connect(paramb.getAnchor(a.c.i), 0, paramInt2);
            return;
            if ((paramc2 == a.c.b) || (paramc2 == a.c.d))
            {
              connect(a.c.b, paramb, paramc2, 0, paramb1, paramInt2);
              connect(a.c.d, paramb, paramc2, 0, paramb1, paramInt2);
              getAnchor(a.c.g).connect(paramb.getAnchor(paramc2), 0, paramInt2);
              return;
            }
          } while ((paramc2 != a.c.c) && (paramc2 != a.c.e));
          connect(a.c.c, paramb, paramc2, 0, paramb1, paramInt2);
          connect(a.c.e, paramb, paramc2, 0, paramb1, paramInt2);
          getAnchor(a.c.g).connect(paramb.getAnchor(paramc2), 0, paramInt2);
          return;
          if ((paramc1 == a.c.h) && ((paramc2 == a.c.b) || (paramc2 == a.c.d)))
          {
            paramc1 = getAnchor(a.c.b);
            paramb = paramb.getAnchor(paramc2);
            paramc2 = getAnchor(a.c.d);
            paramc1.connect(paramb, 0, paramInt2);
            paramc2.connect(paramb, 0, paramInt2);
            getAnchor(a.c.h).connect(paramb, 0, paramInt2);
            return;
          }
          if ((paramc1 == a.c.i) && ((paramc2 == a.c.c) || (paramc2 == a.c.e)))
          {
            paramc1 = paramb.getAnchor(paramc2);
            getAnchor(a.c.c).connect(paramc1, 0, paramInt2);
            getAnchor(a.c.e).connect(paramc1, 0, paramInt2);
            getAnchor(a.c.i).connect(paramc1, 0, paramInt2);
            return;
          }
          if ((paramc1 == a.c.h) && (paramc2 == a.c.h))
          {
            getAnchor(a.c.b).connect(paramb.getAnchor(a.c.b), 0, paramInt2);
            getAnchor(a.c.d).connect(paramb.getAnchor(a.c.d), 0, paramInt2);
            getAnchor(a.c.h).connect(paramb.getAnchor(paramc2), 0, paramInt2);
            return;
          }
          if ((paramc1 == a.c.i) && (paramc2 == a.c.i))
          {
            getAnchor(a.c.c).connect(paramb.getAnchor(a.c.c), 0, paramInt2);
            getAnchor(a.c.e).connect(paramb.getAnchor(a.c.e), 0, paramInt2);
            getAnchor(a.c.i).connect(paramb.getAnchor(paramc2), 0, paramInt2);
            return;
          }
          locala1 = getAnchor(paramc1);
          paramb = paramb.getAnchor(paramc2);
        } while (!locala1.isValidConnection(paramb));
        if (paramc1 == a.c.f)
        {
          paramc1 = getAnchor(a.c.c);
          paramc2 = getAnchor(a.c.e);
          if (paramc1 != null) {
            paramc1.reset();
          }
          if (paramc2 != null) {
            paramc2.reset();
          }
          i1 = 0;
        }
        for (;;)
        {
          locala1.connect(paramb, i1, paramb1, paramInt2);
          paramb.getOwner().connectedTo(locala1.getOwner());
          return;
          if ((paramc1 == a.c.c) || (paramc1 == a.c.e))
          {
            paramc2 = getAnchor(a.c.f);
            if (paramc2 != null) {
              paramc2.reset();
            }
            paramc2 = getAnchor(a.c.g);
            if (paramc2.getTarget() != paramb) {
              paramc2.reset();
            }
            paramc1 = getAnchor(paramc1).getOpposite();
            paramc2 = getAnchor(a.c.i);
            i1 = paramInt1;
            if (paramc2.isConnected())
            {
              paramc1.reset();
              paramc2.reset();
              i1 = paramInt1;
            }
          }
          else if (paramc1 != a.c.b)
          {
            i1 = paramInt1;
            if (paramc1 != a.c.d) {}
          }
          else
          {
            paramc2 = getAnchor(a.c.g);
            if (paramc2.getTarget() != paramb) {
              paramc2.reset();
            }
            paramc1 = getAnchor(paramc1).getOpposite();
            paramc2 = getAnchor(a.c.h);
            i1 = paramInt1;
            if (paramc2.isConnected())
            {
              paramc1.reset();
              paramc2.reset();
              i1 = paramInt1;
            }
          }
        }
        i1 = 0;
      }
      label960:
      paramInt1 = 0;
    }
  }
  
  public void connect(a parama1, a parama2, int paramInt)
  {
    connect(parama1, parama2, paramInt, a.b.b, 0);
  }
  
  public void connect(a parama1, a parama2, int paramInt1, int paramInt2)
  {
    connect(parama1, parama2, paramInt1, a.b.b, paramInt2);
  }
  
  public void connect(a parama1, a parama2, int paramInt1, a.b paramb, int paramInt2)
  {
    if (parama1.getOwner() == this) {
      connect(parama1.getType(), parama2.getOwner(), parama2.getType(), paramInt1, paramb, paramInt2);
    }
  }
  
  public void connectedTo(b paramb) {}
  
  public void disconnectUnlockedWidget(b paramb)
  {
    ArrayList localArrayList = getAnchors();
    int i2 = localArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = (a)localArrayList.get(i1);
      if ((locala.isConnected()) && (locala.getTarget().getOwner() == paramb) && (locala.getConnectionCreator() == 2)) {
        locala.reset();
      }
      i1 += 1;
    }
  }
  
  public void disconnectWidget(b paramb)
  {
    ArrayList localArrayList = getAnchors();
    int i2 = localArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = (a)localArrayList.get(i1);
      if ((locala.isConnected()) && (locala.getTarget().getOwner() == paramb)) {
        locala.reset();
      }
      i1 += 1;
    }
  }
  
  public void forceUpdateDrawPosition()
  {
    int i1 = this.w;
    int i2 = this.x;
    int i3 = this.w;
    int i4 = this.s;
    int i5 = this.x;
    int i6 = this.t;
    this.ae = i1;
    this.af = i2;
    this.ag = (i3 + i4 - i1);
    this.ah = (i5 + i6 - i2);
  }
  
  public a getAnchor(a.c paramc)
  {
    switch (1.a[paramc.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return this.i;
    case 2: 
      return this.j;
    case 3: 
      return this.k;
    case 4: 
      return this.l;
    case 5: 
      return this.m;
    case 6: 
      return this.n;
    case 7: 
      return this.o;
    }
    return this.p;
  }
  
  public ArrayList<a> getAnchors()
  {
    return this.q;
  }
  
  public int getBaselineDistance()
  {
    return this.A;
  }
  
  public int getBottom()
  {
    return getY() + this.t;
  }
  
  public Object getCompanionWidget()
  {
    return this.ak;
  }
  
  public int getContainerItemSkip()
  {
    return this.al;
  }
  
  public String getDebugName()
  {
    return this.an;
  }
  
  public float getDimensionRatio()
  {
    return this.u;
  }
  
  public int getDimensionRatioSide()
  {
    return this.v;
  }
  
  public int getDrawBottom()
  {
    return getDrawY() + this.ah;
  }
  
  public int getDrawHeight()
  {
    return this.ah;
  }
  
  public int getDrawRight()
  {
    return getDrawX() + this.ag;
  }
  
  public int getDrawWidth()
  {
    return this.ag;
  }
  
  public int getDrawX()
  {
    return this.ae + this.y;
  }
  
  public int getDrawY()
  {
    return this.af + this.z;
  }
  
  public int getHeight()
  {
    if (this.am == 8) {
      return 0;
    }
    return this.t;
  }
  
  public float getHorizontalBiasPercent()
  {
    return this.E;
  }
  
  public b getHorizontalChainControlWidget()
  {
    if (isInHorizontalChain())
    {
      Object localObject1 = this;
      Object localObject2 = null;
      Object localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = localObject2;
        if (localObject1 != null)
        {
          localObject3 = ((b)localObject1).getAnchor(a.c.b);
          if (localObject3 != null) {
            break label55;
          }
          localObject3 = null;
          if (localObject3 != null) {
            break label63;
          }
        }
      }
      label55:
      label63:
      for (localObject3 = null;; localObject3 = ((a)localObject3).getOwner())
      {
        if (localObject3 != getParent()) {
          break label71;
        }
        localObject3 = localObject1;
        return (b)localObject3;
        localObject3 = ((a)localObject3).getTarget();
        break;
      }
      label71:
      a locala;
      if (localObject3 == null)
      {
        locala = null;
        label78:
        if ((locala == null) || (locala.getOwner() == localObject1)) {
          break label112;
        }
        localObject2 = localObject1;
      }
      for (;;)
      {
        break;
        locala = ((b)localObject3).getAnchor(a.c.d).getTarget();
        break label78;
        label112:
        localObject1 = localObject3;
      }
    }
    return null;
  }
  
  public int getHorizontalChainStyle()
  {
    return this.S;
  }
  
  public a getHorizontalDimensionBehaviour()
  {
    return this.G;
  }
  
  public int getInternalDrawBottom()
  {
    return this.af + this.ah;
  }
  
  public int getInternalDrawRight()
  {
    return this.ae + this.ag;
  }
  
  public int getLeft()
  {
    return getX();
  }
  
  public int getMinHeight()
  {
    return this.C;
  }
  
  public int getMinWidth()
  {
    return this.B;
  }
  
  public int getOptimizerWrapHeight()
  {
    int i1 = this.t;
    int i2 = i1;
    if (this.H == a.c)
    {
      if (this.d != 1) {
        break label60;
      }
      i1 = Math.max(this.g, i1);
    }
    for (;;)
    {
      i2 = i1;
      if (this.h > 0)
      {
        i2 = i1;
        if (this.h < i1) {
          i2 = this.h;
        }
      }
      return i2;
      label60:
      if (this.g > 0)
      {
        i1 = this.g;
        this.t = i1;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  public int getOptimizerWrapWidth()
  {
    int i1 = this.s;
    int i2 = i1;
    if (this.G == a.c)
    {
      if (this.c != 1) {
        break label60;
      }
      i1 = Math.max(this.e, i1);
    }
    for (;;)
    {
      i2 = i1;
      if (this.f > 0)
      {
        i2 = i1;
        if (this.f < i1) {
          i2 = this.f;
        }
      }
      return i2;
      label60:
      if (this.e > 0)
      {
        i1 = this.e;
        this.s = i1;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  public b getParent()
  {
    return this.r;
  }
  
  public int getRight()
  {
    return getX() + this.s;
  }
  
  public h getRootWidgetContainer()
  {
    for (b localb = this; localb.getParent() != null; localb = localb.getParent()) {}
    if ((localb instanceof h)) {
      return (h)localb;
    }
    return null;
  }
  
  public int getTop()
  {
    return getY();
  }
  
  public String getType()
  {
    return this.ao;
  }
  
  public float getVerticalBiasPercent()
  {
    return this.F;
  }
  
  public b getVerticalChainControlWidget()
  {
    if (isInVerticalChain())
    {
      Object localObject1 = this;
      Object localObject2 = null;
      Object localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = localObject2;
        if (localObject1 != null)
        {
          localObject3 = ((b)localObject1).getAnchor(a.c.c);
          if (localObject3 != null) {
            break label55;
          }
          localObject3 = null;
          if (localObject3 != null) {
            break label63;
          }
        }
      }
      label55:
      label63:
      for (localObject3 = null;; localObject3 = ((a)localObject3).getOwner())
      {
        if (localObject3 != getParent()) {
          break label71;
        }
        localObject3 = localObject1;
        return (b)localObject3;
        localObject3 = ((a)localObject3).getTarget();
        break;
      }
      label71:
      a locala;
      if (localObject3 == null)
      {
        locala = null;
        label78:
        if ((locala == null) || (locala.getOwner() == localObject1)) {
          break label112;
        }
        localObject2 = localObject1;
      }
      for (;;)
      {
        break;
        locala = ((b)localObject3).getAnchor(a.c.e).getTarget();
        break label78;
        label112:
        localObject1 = localObject3;
      }
    }
    return null;
  }
  
  public int getVerticalChainStyle()
  {
    return this.T;
  }
  
  public a getVerticalDimensionBehaviour()
  {
    return this.H;
  }
  
  public int getVisibility()
  {
    return this.am;
  }
  
  public int getWidth()
  {
    if (this.am == 8) {
      return 0;
    }
    return this.s;
  }
  
  public int getWrapHeight()
  {
    return this.aj;
  }
  
  public int getWrapWidth()
  {
    return this.ai;
  }
  
  public int getX()
  {
    return this.w;
  }
  
  public int getY()
  {
    return this.x;
  }
  
  public boolean hasAncestor(b paramb)
  {
    b localb2 = getParent();
    if (localb2 == paramb) {
      return true;
    }
    b localb1 = localb2;
    if (localb2 == paramb.getParent()) {
      return false;
    }
    do
    {
      localb1 = localb1.getParent();
      if (localb1 == null) {
        break label48;
      }
      if (localb1 == paramb) {
        break;
      }
    } while (localb1 != paramb.getParent());
    return true;
    label48:
    return false;
  }
  
  public boolean hasBaseline()
  {
    return this.A > 0;
  }
  
  public void immediateConnect(a.c paramc1, b paramb, a.c paramc2, int paramInt1, int paramInt2)
  {
    getAnchor(paramc1).connect(paramb.getAnchor(paramc2), paramInt1, paramInt2, a.b.b, 0, true);
  }
  
  public boolean isInHorizontalChain()
  {
    return ((this.i.c != null) && (this.i.c.c == this.i)) || ((this.k.c != null) && (this.k.c.c == this.k));
  }
  
  public boolean isInVerticalChain()
  {
    return ((this.j.c != null) && (this.j.c.c == this.j)) || ((this.l.c != null) && (this.l.c.c == this.l));
  }
  
  public boolean isInsideConstraintLayout()
  {
    b localb2 = getParent();
    b localb1 = localb2;
    if (localb2 == null) {
      return false;
    }
    do
    {
      localb1 = localb1.getParent();
      if (localb1 == null) {
        break;
      }
    } while (!(localb1 instanceof c));
    return true;
  }
  
  public boolean isRoot()
  {
    return this.r == null;
  }
  
  public boolean isRootContainer()
  {
    return ((this instanceof c)) && ((this.r == null) || (!(this.r instanceof c)));
  }
  
  public void reset()
  {
    this.i.reset();
    this.j.reset();
    this.k.reset();
    this.l.reset();
    this.m.reset();
    this.n.reset();
    this.o.reset();
    this.p.reset();
    this.r = null;
    this.s = 0;
    this.t = 0;
    this.u = 0.0F;
    this.v = -1;
    this.w = 0;
    this.x = 0;
    this.ae = 0;
    this.af = 0;
    this.ag = 0;
    this.ah = 0;
    this.y = 0;
    this.z = 0;
    this.A = 0;
    this.B = 0;
    this.C = 0;
    this.ai = 0;
    this.aj = 0;
    this.E = D;
    this.F = D;
    this.G = a.a;
    this.H = a.a;
    this.ak = null;
    this.al = 0;
    this.am = 0;
    this.an = null;
    this.ao = null;
    this.Q = false;
    this.R = false;
    this.S = 0;
    this.T = 0;
    this.U = false;
    this.V = false;
    this.W = 0.0F;
    this.X = 0.0F;
    this.a = -1;
    this.b = -1;
  }
  
  public void resetAllConstraints()
  {
    resetAnchors();
    setVerticalBiasPercent(D);
    setHorizontalBiasPercent(D);
    if ((this instanceof c)) {}
    label83:
    label104:
    do
    {
      for (;;)
      {
        return;
        if (getHorizontalDimensionBehaviour() == a.c)
        {
          if (getWidth() != getWrapWidth()) {
            break label83;
          }
          setHorizontalDimensionBehaviour(a.b);
        }
        while (getVerticalDimensionBehaviour() == a.c)
        {
          if (getHeight() != getWrapHeight()) {
            break label104;
          }
          setVerticalDimensionBehaviour(a.b);
          return;
          if (getWidth() > getMinWidth()) {
            setHorizontalDimensionBehaviour(a.a);
          }
        }
      }
    } while (getHeight() <= getMinHeight());
    setVerticalDimensionBehaviour(a.a);
  }
  
  public void resetAnchor(a parama)
  {
    if ((getParent() != null) && ((getParent() instanceof c)) && (((c)getParent()).handlesInternalConstraints())) {
      return;
    }
    a locala1 = getAnchor(a.c.b);
    a locala2 = getAnchor(a.c.d);
    a locala3 = getAnchor(a.c.c);
    a locala4 = getAnchor(a.c.e);
    a locala5 = getAnchor(a.c.g);
    a locala6 = getAnchor(a.c.h);
    a locala7 = getAnchor(a.c.i);
    if (parama == locala5)
    {
      if ((locala1.isConnected()) && (locala2.isConnected()) && (locala1.getTarget() == locala2.getTarget()))
      {
        locala1.reset();
        locala2.reset();
      }
      if ((locala3.isConnected()) && (locala4.isConnected()) && (locala3.getTarget() == locala4.getTarget()))
      {
        locala3.reset();
        locala4.reset();
      }
      this.E = 0.5F;
      this.F = 0.5F;
    }
    for (;;)
    {
      parama.reset();
      return;
      if (parama == locala6)
      {
        if ((locala1.isConnected()) && (locala2.isConnected()) && (locala1.getTarget().getOwner() == locala2.getTarget().getOwner()))
        {
          locala1.reset();
          locala2.reset();
        }
        this.E = 0.5F;
      }
      else if (parama == locala7)
      {
        if ((locala3.isConnected()) && (locala4.isConnected()) && (locala3.getTarget().getOwner() == locala4.getTarget().getOwner()))
        {
          locala3.reset();
          locala4.reset();
        }
        this.F = 0.5F;
      }
      else if ((parama == locala1) || (parama == locala2))
      {
        if ((locala1.isConnected()) && (locala1.getTarget() == locala2.getTarget())) {
          locala5.reset();
        }
      }
      else if (((parama == locala3) || (parama == locala4)) && (locala3.isConnected()) && (locala3.getTarget() == locala4.getTarget()))
      {
        locala5.reset();
      }
    }
  }
  
  public void resetAnchors()
  {
    b localb = getParent();
    if ((localb != null) && ((localb instanceof c)) && (((c)getParent()).handlesInternalConstraints())) {}
    for (;;)
    {
      return;
      int i2 = this.q.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((a)this.q.get(i1)).reset();
        i1 += 1;
      }
    }
  }
  
  public void resetAnchors(int paramInt)
  {
    Object localObject = getParent();
    if ((localObject != null) && ((localObject instanceof c)) && (((c)getParent()).handlesInternalConstraints())) {
      return;
    }
    int i2 = this.q.size();
    int i1 = 0;
    label43:
    if (i1 < i2)
    {
      localObject = (a)this.q.get(i1);
      if (paramInt == ((a)localObject).getConnectionCreator())
      {
        if (!((a)localObject).isVerticalAnchor()) {
          break label97;
        }
        setVerticalBiasPercent(D);
      }
    }
    for (;;)
    {
      ((a)localObject).reset();
      i1 += 1;
      break label43;
      break;
      label97:
      setHorizontalBiasPercent(D);
    }
  }
  
  public void resetGroups()
  {
    int i2 = this.q.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((a)this.q.get(i1)).g = Integer.MAX_VALUE;
      i1 += 1;
    }
  }
  
  public void resetSolverVariables(android.support.constraint.a.c paramc)
  {
    this.i.resetSolverVariable(paramc);
    this.j.resetSolverVariable(paramc);
    this.k.resetSolverVariable(paramc);
    this.l.resetSolverVariable(paramc);
    this.m.resetSolverVariable(paramc);
    this.p.resetSolverVariable(paramc);
    this.n.resetSolverVariable(paramc);
    this.o.resetSolverVariable(paramc);
  }
  
  public void setBaselineDistance(int paramInt)
  {
    this.A = paramInt;
  }
  
  public void setCompanionWidget(Object paramObject)
  {
    this.ak = paramObject;
  }
  
  public void setContainerItemSkip(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.al = paramInt;
      return;
    }
    this.al = 0;
  }
  
  public void setDebugName(String paramString)
  {
    this.an = paramString;
  }
  
  public void setDebugSolverName(e parame, String paramString)
  {
    this.an = paramString;
    g localg1 = parame.createObjectVariable(this.i);
    g localg2 = parame.createObjectVariable(this.j);
    g localg3 = parame.createObjectVariable(this.k);
    g localg4 = parame.createObjectVariable(this.l);
    localg1.setName(paramString + ".left");
    localg2.setName(paramString + ".top");
    localg3.setName(paramString + ".right");
    localg4.setName(paramString + ".bottom");
    if (this.A > 0) {
      parame.createObjectVariable(this.m).setName(paramString + ".baseline");
    }
  }
  
  public void setDimension(int paramInt1, int paramInt2)
  {
    this.s = paramInt1;
    if (this.s < this.B) {
      this.s = this.B;
    }
    this.t = paramInt2;
    if (this.t < this.C) {
      this.t = this.C;
    }
  }
  
  public void setDimensionRatio(float paramFloat, int paramInt)
  {
    this.u = paramFloat;
    this.v = paramInt;
  }
  
  public void setDimensionRatio(String paramString)
  {
    int i5 = 0;
    int i3 = 0;
    if ((paramString == null) || (paramString.length() == 0))
    {
      this.u = 0.0F;
      return;
    }
    int i4 = -1;
    int i6 = paramString.length();
    int i7 = paramString.indexOf(',');
    int i2 = i5;
    int i1 = i4;
    String str;
    if (i7 > 0)
    {
      i2 = i5;
      i1 = i4;
      if (i7 < i6 - 1)
      {
        str = paramString.substring(0, i7);
        if (!str.equalsIgnoreCase("W")) {
          break label210;
        }
        i1 = i3;
      }
    }
    for (;;)
    {
      label94:
      i2 = i7 + 1;
      i3 = paramString.indexOf(':');
      if ((i3 >= 0) && (i3 < i6 - 1))
      {
        str = paramString.substring(i2, i3);
        paramString = paramString.substring(i3 + 1);
        if ((str.length() <= 0) || (paramString.length() <= 0)) {
          break label273;
        }
      }
      for (;;)
      {
        try
        {
          f1 = Float.parseFloat(str);
          f2 = Float.parseFloat(paramString);
          if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
            break label273;
          }
          if (i1 != 1) {
            continue;
          }
          f1 = Math.abs(f2 / f1);
        }
        catch (NumberFormatException paramString)
        {
          float f2;
          label210:
          f1 = 0.0F;
          continue;
        }
        if (f1 <= 0.0F) {
          break;
        }
        this.u = f1;
        this.v = i1;
        return;
        if (!str.equalsIgnoreCase("H")) {
          break label278;
        }
        i1 = 1;
        break label94;
        f1 /= f2;
        float f1 = Math.abs(f1);
        continue;
        paramString = paramString.substring(i2);
        if (paramString.length() > 0) {
          try
          {
            f1 = Float.parseFloat(paramString);
          }
          catch (NumberFormatException paramString)
          {
            f1 = 0.0F;
          }
        } else {
          label273:
          f1 = 0.0F;
        }
      }
      label278:
      i1 = -1;
    }
  }
  
  public void setDrawHeight(int paramInt)
  {
    this.ah = paramInt;
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2)
  {
    this.ae = (paramInt1 - this.y);
    this.af = (paramInt2 - this.z);
    this.w = this.ae;
    this.x = this.af;
  }
  
  public void setDrawWidth(int paramInt)
  {
    this.ag = paramInt;
  }
  
  public void setDrawX(int paramInt)
  {
    this.ae = (paramInt - this.y);
    this.w = this.ae;
  }
  
  public void setDrawY(int paramInt)
  {
    this.af = (paramInt - this.z);
    this.x = this.af;
  }
  
  public void setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    paramInt3 = paramInt4 - paramInt2;
    this.w = paramInt1;
    this.x = paramInt2;
    if (this.am == 8)
    {
      this.s = 0;
      this.t = 0;
    }
    do
    {
      return;
      paramInt1 = i1;
      if (this.G == a.a)
      {
        paramInt1 = i1;
        if (i1 < this.s) {
          paramInt1 = this.s;
        }
      }
      paramInt2 = paramInt3;
      if (this.H == a.a)
      {
        paramInt2 = paramInt3;
        if (paramInt3 < this.t) {
          paramInt2 = this.t;
        }
      }
      this.s = paramInt1;
      this.t = paramInt2;
      if (this.t < this.C) {
        this.t = this.C;
      }
    } while (this.s >= this.B);
    this.s = this.B;
  }
  
  public void setGoneMargin(a.c paramc, int paramInt)
  {
    switch (1.a[paramc.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.i.e = paramInt;
      return;
    case 2: 
      this.j.e = paramInt;
      return;
    case 3: 
      this.k.e = paramInt;
      return;
    }
    this.l.e = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    this.t = paramInt;
    if (this.t < this.C) {
      this.t = this.C;
    }
  }
  
  public void setHorizontalBiasPercent(float paramFloat)
  {
    this.E = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt)
  {
    this.S = paramInt;
  }
  
  public void setHorizontalDimension(int paramInt1, int paramInt2)
  {
    this.w = paramInt1;
    this.s = (paramInt2 - paramInt1);
    if (this.s < this.B) {
      this.s = this.B;
    }
  }
  
  public void setHorizontalDimensionBehaviour(a parama)
  {
    this.G = parama;
    if (this.G == a.b) {
      setWidth(this.ai);
    }
  }
  
  public void setHorizontalMatchStyle(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
  }
  
  public void setHorizontalWeight(float paramFloat)
  {
    this.W = paramFloat;
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt < 0)
    {
      this.C = 0;
      return;
    }
    this.C = paramInt;
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt < 0)
    {
      this.B = 0;
      return;
    }
    this.B = paramInt;
  }
  
  public void setOffset(int paramInt1, int paramInt2)
  {
    this.y = paramInt1;
    this.z = paramInt2;
  }
  
  public void setOrigin(int paramInt1, int paramInt2)
  {
    this.w = paramInt1;
    this.x = paramInt2;
  }
  
  public void setParent(b paramb)
  {
    this.r = paramb;
  }
  
  public void setType(String paramString)
  {
    this.ao = paramString;
  }
  
  public void setVerticalBiasPercent(float paramFloat)
  {
    this.F = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt)
  {
    this.T = paramInt;
  }
  
  public void setVerticalDimension(int paramInt1, int paramInt2)
  {
    this.x = paramInt1;
    this.t = (paramInt2 - paramInt1);
    if (this.t < this.C) {
      this.t = this.C;
    }
  }
  
  public void setVerticalDimensionBehaviour(a parama)
  {
    this.H = parama;
    if (this.H == a.b) {
      setHeight(this.aj);
    }
  }
  
  public void setVerticalMatchStyle(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
  }
  
  public void setVerticalWeight(float paramFloat)
  {
    this.X = paramFloat;
  }
  
  public void setVisibility(int paramInt)
  {
    this.am = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.s = paramInt;
    if (this.s < this.B) {
      this.s = this.B;
    }
  }
  
  public void setWrapHeight(int paramInt)
  {
    this.aj = paramInt;
  }
  
  public void setWrapWidth(int paramInt)
  {
    this.ai = paramInt;
  }
  
  public void setX(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void setY(int paramInt)
  {
    this.x = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.ao != null)
    {
      str = "type: " + this.ao + " ";
      localStringBuilder = localStringBuilder.append(str);
      if (this.an == null) {
        break label194;
      }
    }
    label194:
    for (String str = "id: " + this.an + " ";; str = "")
    {
      return str + "(" + this.w + ", " + this.x + ") - (" + this.s + " x " + this.t + ")" + " wrap: (" + this.ai + " x " + this.aj + ")";
      str = "";
      break;
    }
  }
  
  public void updateDrawPosition()
  {
    int i1 = this.w;
    int i2 = this.x;
    int i3 = this.w;
    int i4 = this.s;
    int i5 = this.x;
    int i6 = this.t;
    this.ae = i1;
    this.af = i2;
    this.ag = (i3 + i4 - i1);
    this.ah = (i5 + i6 - i2);
  }
  
  public void updateFromSolver(e parame)
  {
    updateFromSolver(parame, Integer.MAX_VALUE);
  }
  
  public void updateFromSolver(e parame, int paramInt)
  {
    if (paramInt == Integer.MAX_VALUE) {
      setFrame(parame.getObjectVariableValue(this.i), parame.getObjectVariableValue(this.j), parame.getObjectVariableValue(this.k), parame.getObjectVariableValue(this.l));
    }
    do
    {
      return;
      if (paramInt == -2)
      {
        setFrame(this.aa, this.ab, this.ac, this.ad);
        return;
      }
      if (this.i.g == paramInt) {
        this.aa = parame.getObjectVariableValue(this.i);
      }
      if (this.j.g == paramInt) {
        this.ab = parame.getObjectVariableValue(this.j);
      }
      if (this.k.g == paramInt) {
        this.ac = parame.getObjectVariableValue(this.k);
      }
    } while (this.l.g != paramInt);
    this.ad = parame.getObjectVariableValue(this.l);
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */