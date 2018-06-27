package android.support.constraint.a.a;

import android.support.constraint.a.g;

public class e
{
  static void a(c paramc, android.support.constraint.a.e parame, int paramInt, b paramb)
  {
    int m = 0;
    int i = 0;
    float f2 = 0.0F;
    Object localObject2 = null;
    Object localObject1 = paramb;
    int j;
    label33:
    int k;
    if (localObject1 != null) {
      if (((b)localObject1).getVisibility() == 8)
      {
        j = 1;
        if (j != 0) {
          break label738;
        }
        k = i + 1;
        if (((b)localObject1).G == b.a.c) {
          break label236;
        }
        int n = ((b)localObject1).getWidth();
        if (((b)localObject1).i.c == null) {
          break label224;
        }
        i = ((b)localObject1).i.getMargin();
        label83:
        if (((b)localObject1).k.c == null) {
          break label230;
        }
        j = ((b)localObject1).k.getMargin();
        label104:
        m = j + (m + n + i);
        i = k;
      }
    }
    label121:
    label224:
    label230:
    label236:
    label366:
    label392:
    label413:
    label482:
    label523:
    label608:
    label630:
    label636:
    label642:
    label669:
    label683:
    label731:
    label737:
    label738:
    for (;;)
    {
      if (((b)localObject1).k.c != null) {}
      for (Object localObject3 = ((b)localObject1).k.c.a;; localObject3 = null)
      {
        localObject2 = localObject3;
        if (localObject3 != null) {
          if (((b)localObject3).i.c != null)
          {
            localObject2 = localObject3;
            if (((b)localObject3).i.c != null)
            {
              localObject2 = localObject3;
              if (((b)localObject3).i.c.a == localObject1) {}
            }
          }
          else
          {
            localObject2 = null;
          }
        }
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        j = 0;
        break label33;
        i = 0;
        break label83;
        j = 0;
        break label104;
        f2 = ((b)localObject1).W + f2;
        i = k;
        break label121;
      }
      k = 0;
      if (localObject2 != null)
      {
        if (((b)localObject2).k.c == null) {
          break label608;
        }
        j = ((b)localObject2).k.c.a.getX();
        k = j;
        if (((b)localObject2).k.c != null)
        {
          k = j;
          if (((b)localObject2).k.c.a == paramc) {
            k = paramc.getRight();
          }
        }
      }
      float f5 = k - 0 - m;
      float f1 = f5 / (i + 1);
      float f3;
      float f4;
      if (paramInt == 0)
      {
        f3 = f1;
        localObject2 = paramb;
        if (localObject2 == null) {
          break label737;
        }
        if (((b)localObject2).i.c == null) {
          break label630;
        }
        i = ((b)localObject2).i.getMargin();
        if (((b)localObject2).k.c == null) {
          break label636;
        }
        j = ((b)localObject2).k.getMargin();
        if (((b)localObject2).getVisibility() == 8) {
          break label683;
        }
        f1 += i;
        parame.addEquality(((b)localObject2).i.f, (int)(0.5F + f1));
        if (((b)localObject2).G != b.a.c) {
          break label669;
        }
        if (f2 != 0.0F) {
          break label642;
        }
        f1 = f3 - i - j + f1;
        parame.addEquality(((b)localObject2).k.f, (int)(0.5F + f1));
        f4 = f1;
        if (paramInt == 0) {
          f4 = f1 + f3;
        }
        f1 = f4 + j;
        if (((b)localObject2).k.c == null) {
          break label731;
        }
      }
      for (localObject1 = ((b)localObject2).k.c.a;; localObject1 = null)
      {
        paramb = (b)localObject1;
        if (localObject1 != null)
        {
          paramb = (b)localObject1;
          if (((b)localObject1).i.c != null)
          {
            paramb = (b)localObject1;
            if (((b)localObject1).i.c.a != localObject2) {
              paramb = null;
            }
          }
        }
        localObject1 = paramb;
        if (paramb == paramc) {
          localObject1 = null;
        }
        localObject2 = localObject1;
        break label366;
        j = 0;
        break;
        f3 = f5 / paramInt;
        f1 = 0.0F;
        localObject2 = paramb;
        break label366;
        i = 0;
        break label392;
        j = 0;
        break label413;
        f1 = ((b)localObject2).W * f5 / f2 - i - j + f1;
        break label482;
        f1 = ((b)localObject2).getWidth() + f1;
        break label482;
        f4 = f1 - f3 / 2.0F;
        parame.addEquality(((b)localObject2).i.f, (int)(0.5F + f4));
        parame.addEquality(((b)localObject2).k.f, (int)(f4 + 0.5F));
        break label523;
      }
      return;
    }
  }
  
  static void a(c paramc, android.support.constraint.a.e parame, b paramb)
  {
    int i;
    int j;
    if ((paramc.G != b.a.b) && (paramb.G == b.a.d))
    {
      paramb.i.f = parame.createObjectVariable(paramb.i);
      paramb.k.f = parame.createObjectVariable(paramb.k);
      i = paramb.i.d;
      j = paramc.getWidth() - paramb.k.d;
      parame.addEquality(paramb.i.f, i);
      parame.addEquality(paramb.k.f, j);
      paramb.setHorizontalDimension(i, j);
      paramb.a = 2;
    }
    if ((paramc.H != b.a.b) && (paramb.H == b.a.d))
    {
      paramb.j.f = parame.createObjectVariable(paramb.j);
      paramb.l.f = parame.createObjectVariable(paramb.l);
      i = paramb.j.d;
      j = paramc.getHeight() - paramb.l.d;
      parame.addEquality(paramb.j.f, i);
      parame.addEquality(paramb.l.f, j);
      if ((paramb.A > 0) || (paramb.getVisibility() == 8))
      {
        paramb.m.f = parame.createObjectVariable(paramb.m);
        parame.addEquality(paramb.m.f, paramb.A + i);
      }
      paramb.setVerticalDimension(i, j);
      paramb.b = 2;
    }
  }
  
  static void b(c paramc, android.support.constraint.a.e parame, int paramInt, b paramb)
  {
    int m = 0;
    int i = 0;
    float f2 = 0.0F;
    Object localObject2 = null;
    Object localObject1 = paramb;
    int j;
    label33:
    int k;
    if (localObject1 != null) {
      if (((b)localObject1).getVisibility() == 8)
      {
        j = 1;
        if (j != 0) {
          break label738;
        }
        k = i + 1;
        if (((b)localObject1).H == b.a.c) {
          break label236;
        }
        int n = ((b)localObject1).getHeight();
        if (((b)localObject1).j.c == null) {
          break label224;
        }
        i = ((b)localObject1).j.getMargin();
        label83:
        if (((b)localObject1).l.c == null) {
          break label230;
        }
        j = ((b)localObject1).l.getMargin();
        label104:
        m = j + (m + n + i);
        i = k;
      }
    }
    label121:
    label224:
    label230:
    label236:
    label366:
    label392:
    label413:
    label482:
    label523:
    label608:
    label630:
    label636:
    label642:
    label669:
    label683:
    label731:
    label737:
    label738:
    for (;;)
    {
      if (((b)localObject1).l.c != null) {}
      for (Object localObject3 = ((b)localObject1).l.c.a;; localObject3 = null)
      {
        localObject2 = localObject3;
        if (localObject3 != null) {
          if (((b)localObject3).j.c != null)
          {
            localObject2 = localObject3;
            if (((b)localObject3).j.c != null)
            {
              localObject2 = localObject3;
              if (((b)localObject3).j.c.a == localObject1) {}
            }
          }
          else
          {
            localObject2 = null;
          }
        }
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        j = 0;
        break label33;
        i = 0;
        break label83;
        j = 0;
        break label104;
        f2 = ((b)localObject1).X + f2;
        i = k;
        break label121;
      }
      k = 0;
      if (localObject2 != null)
      {
        if (((b)localObject2).l.c == null) {
          break label608;
        }
        j = ((b)localObject2).l.c.a.getX();
        k = j;
        if (((b)localObject2).l.c != null)
        {
          k = j;
          if (((b)localObject2).l.c.a == paramc) {
            k = paramc.getBottom();
          }
        }
      }
      float f5 = k - 0 - m;
      float f1 = f5 / (i + 1);
      float f3;
      float f4;
      if (paramInt == 0)
      {
        f3 = f1;
        localObject2 = paramb;
        if (localObject2 == null) {
          break label737;
        }
        if (((b)localObject2).j.c == null) {
          break label630;
        }
        i = ((b)localObject2).j.getMargin();
        if (((b)localObject2).l.c == null) {
          break label636;
        }
        j = ((b)localObject2).l.getMargin();
        if (((b)localObject2).getVisibility() == 8) {
          break label683;
        }
        f1 += i;
        parame.addEquality(((b)localObject2).j.f, (int)(0.5F + f1));
        if (((b)localObject2).H != b.a.c) {
          break label669;
        }
        if (f2 != 0.0F) {
          break label642;
        }
        f1 = f3 - i - j + f1;
        parame.addEquality(((b)localObject2).l.f, (int)(0.5F + f1));
        f4 = f1;
        if (paramInt == 0) {
          f4 = f1 + f3;
        }
        f1 = f4 + j;
        if (((b)localObject2).l.c == null) {
          break label731;
        }
      }
      for (localObject1 = ((b)localObject2).l.c.a;; localObject1 = null)
      {
        paramb = (b)localObject1;
        if (localObject1 != null)
        {
          paramb = (b)localObject1;
          if (((b)localObject1).j.c != null)
          {
            paramb = (b)localObject1;
            if (((b)localObject1).j.c.a != localObject2) {
              paramb = null;
            }
          }
        }
        localObject1 = paramb;
        if (paramb == paramc) {
          localObject1 = null;
        }
        localObject2 = localObject1;
        break label366;
        j = 0;
        break;
        f3 = f5 / paramInt;
        f1 = 0.0F;
        localObject2 = paramb;
        break label366;
        i = 0;
        break label392;
        j = 0;
        break label413;
        f1 = ((b)localObject2).X * f5 / f2 - i - j + f1;
        break label482;
        f1 = ((b)localObject2).getHeight() + f1;
        break label482;
        f4 = f1 - f3 / 2.0F;
        parame.addEquality(((b)localObject2).j.f, (int)(0.5F + f4));
        parame.addEquality(((b)localObject2).l.f, (int)(f4 + 0.5F));
        break label523;
      }
      return;
    }
  }
  
  static void b(c paramc, android.support.constraint.a.e parame, b paramb)
  {
    if (paramb.G == b.a.c) {
      paramb.a = 1;
    }
    label850:
    label863:
    d locald;
    do
    {
      return;
      if ((paramc.G != b.a.b) && (paramb.G == b.a.d))
      {
        paramb.i.f = parame.createObjectVariable(paramb.i);
        paramb.k.f = parame.createObjectVariable(paramb.k);
        i = paramb.i.d;
        j = paramc.getWidth() - paramb.k.d;
        parame.addEquality(paramb.i.f, i);
        parame.addEquality(paramb.k.f, j);
        paramb.setHorizontalDimension(i, j);
        paramb.a = 2;
        return;
      }
      if ((paramb.i.c != null) && (paramb.k.c != null))
      {
        if ((paramb.i.c.a == paramc) && (paramb.k.c.a == paramc))
        {
          j = paramb.i.getMargin();
          i = paramb.k.getMargin();
          if (paramc.G == b.a.c) {}
          for (i = paramc.getWidth() - i;; i = paramb.getWidth() + j)
          {
            paramb.i.f = parame.createObjectVariable(paramb.i);
            paramb.k.f = parame.createObjectVariable(paramb.k);
            parame.addEquality(paramb.i.f, j);
            parame.addEquality(paramb.k.f, i);
            paramb.a = 2;
            paramb.setHorizontalDimension(j, i);
            return;
            int k = paramb.getWidth();
            j += (int)((paramc.getWidth() - j - i - k) * paramb.E + 0.5F);
          }
        }
        paramb.a = 1;
        return;
      }
      if ((paramb.i.c != null) && (paramb.i.c.a == paramc))
      {
        i = paramb.i.getMargin();
        j = paramb.getWidth() + i;
        paramb.i.f = parame.createObjectVariable(paramb.i);
        paramb.k.f = parame.createObjectVariable(paramb.k);
        parame.addEquality(paramb.i.f, i);
        parame.addEquality(paramb.k.f, j);
        paramb.a = 2;
        paramb.setHorizontalDimension(i, j);
        return;
      }
      if ((paramb.k.c != null) && (paramb.k.c.a == paramc))
      {
        paramb.i.f = parame.createObjectVariable(paramb.i);
        paramb.k.f = parame.createObjectVariable(paramb.k);
        i = paramc.getWidth() - paramb.k.getMargin();
        j = i - paramb.getWidth();
        parame.addEquality(paramb.i.f, j);
        parame.addEquality(paramb.k.f, i);
        paramb.a = 2;
        paramb.setHorizontalDimension(j, i);
        return;
      }
      if ((paramb.i.c != null) && (paramb.i.c.a.a == 2))
      {
        paramc = paramb.i.c.f;
        paramb.i.f = parame.createObjectVariable(paramb.i);
        paramb.k.f = parame.createObjectVariable(paramb.k);
        i = (int)(paramc.d + paramb.i.getMargin() + 0.5F);
        j = paramb.getWidth() + i;
        parame.addEquality(paramb.i.f, i);
        parame.addEquality(paramb.k.f, j);
        paramb.a = 2;
        paramb.setHorizontalDimension(i, j);
        return;
      }
      if ((paramb.k.c != null) && (paramb.k.c.a.a == 2))
      {
        paramc = paramb.k.c.f;
        paramb.i.f = parame.createObjectVariable(paramb.i);
        paramb.k.f = parame.createObjectVariable(paramb.k);
        i = (int)(paramc.d - paramb.k.getMargin() + 0.5F);
        j = i - paramb.getWidth();
        parame.addEquality(paramb.i.f, j);
        parame.addEquality(paramb.k.f, i);
        paramb.a = 2;
        paramb.setHorizontalDimension(j, i);
        return;
      }
      if (paramb.i.c == null) {
        break;
      }
      i = 1;
      if (paramb.k.c == null) {
        break label1008;
      }
      j = 1;
      if ((i != 0) || (j != 0)) {
        break label1012;
      }
      if (!(paramb instanceof d)) {
        break label1055;
      }
      locald = (d)paramb;
    } while (locald.getOrientation() != 1);
    paramb.i.f = parame.createObjectVariable(paramb.i);
    paramb.k.f = parame.createObjectVariable(paramb.k);
    float f;
    if (locald.getRelativeBegin() != -1) {
      f = locald.getRelativeBegin();
    }
    for (;;)
    {
      i = (int)(f + 0.5F);
      parame.addEquality(paramb.i.f, i);
      parame.addEquality(paramb.k.f, i);
      paramb.a = 2;
      paramb.b = 2;
      paramb.setHorizontalDimension(i, i);
      paramb.setVerticalDimension(0, paramc.getHeight());
      return;
      i = 0;
      break label850;
      label1008:
      j = 0;
      break label863;
      label1012:
      break;
      if (locald.getRelativeEnd() != -1)
      {
        f = paramc.getWidth() - locald.getRelativeEnd();
      }
      else
      {
        f = paramc.getWidth();
        f = locald.getRelativePercent() * f;
      }
    }
    label1055:
    paramb.i.f = parame.createObjectVariable(paramb.i);
    paramb.k.f = parame.createObjectVariable(paramb.k);
    int i = paramb.getX();
    int j = paramb.getWidth();
    parame.addEquality(paramb.i.f, i);
    parame.addEquality(paramb.k.f, j + i);
    paramb.a = 2;
  }
  
  static void c(c paramc, android.support.constraint.a.e parame, b paramb)
  {
    int k = 1;
    if (paramb.H == b.a.c) {
      paramb.b = 1;
    }
    float f;
    label1320:
    label1333:
    label1343:
    d locald;
    do
    {
      return;
      if ((paramc.H != b.a.b) && (paramb.H == b.a.d))
      {
        paramb.j.f = parame.createObjectVariable(paramb.j);
        paramb.l.f = parame.createObjectVariable(paramb.l);
        i = paramb.j.d;
        j = paramc.getHeight() - paramb.l.d;
        parame.addEquality(paramb.j.f, i);
        parame.addEquality(paramb.l.f, j);
        if ((paramb.A > 0) || (paramb.getVisibility() == 8))
        {
          paramb.m.f = parame.createObjectVariable(paramb.m);
          parame.addEquality(paramb.m.f, paramb.A + i);
        }
        paramb.setVerticalDimension(i, j);
        paramb.b = 2;
        return;
      }
      if ((paramb.j.c != null) && (paramb.l.c != null))
      {
        if ((paramb.j.c.a == paramc) && (paramb.l.c.a == paramc))
        {
          j = paramb.j.getMargin();
          i = paramb.l.getMargin();
          if (paramc.H == b.a.c) {}
          for (i = paramb.getHeight() + j;; i = paramb.getHeight() + j)
          {
            paramb.j.f = parame.createObjectVariable(paramb.j);
            paramb.l.f = parame.createObjectVariable(paramb.l);
            parame.addEquality(paramb.j.f, j);
            parame.addEquality(paramb.l.f, i);
            if ((paramb.A > 0) || (paramb.getVisibility() == 8))
            {
              paramb.m.f = parame.createObjectVariable(paramb.m);
              parame.addEquality(paramb.m.f, paramb.A + j);
            }
            paramb.b = 2;
            paramb.setVerticalDimension(j, i);
            return;
            k = paramb.getHeight();
            int m = paramc.getHeight();
            f = j;
            j = (int)((m - j - i - k) * paramb.F + f + 0.5F);
          }
        }
        paramb.b = 1;
        return;
      }
      if ((paramb.j.c != null) && (paramb.j.c.a == paramc))
      {
        i = paramb.j.getMargin();
        j = paramb.getHeight() + i;
        paramb.j.f = parame.createObjectVariable(paramb.j);
        paramb.l.f = parame.createObjectVariable(paramb.l);
        parame.addEquality(paramb.j.f, i);
        parame.addEquality(paramb.l.f, j);
        if ((paramb.A > 0) || (paramb.getVisibility() == 8))
        {
          paramb.m.f = parame.createObjectVariable(paramb.m);
          parame.addEquality(paramb.m.f, paramb.A + i);
        }
        paramb.b = 2;
        paramb.setVerticalDimension(i, j);
        return;
      }
      if ((paramb.l.c != null) && (paramb.l.c.a == paramc))
      {
        paramb.j.f = parame.createObjectVariable(paramb.j);
        paramb.l.f = parame.createObjectVariable(paramb.l);
        i = paramc.getHeight() - paramb.l.getMargin();
        j = i - paramb.getHeight();
        parame.addEquality(paramb.j.f, j);
        parame.addEquality(paramb.l.f, i);
        if ((paramb.A > 0) || (paramb.getVisibility() == 8))
        {
          paramb.m.f = parame.createObjectVariable(paramb.m);
          parame.addEquality(paramb.m.f, paramb.A + j);
        }
        paramb.b = 2;
        paramb.setVerticalDimension(j, i);
        return;
      }
      if ((paramb.j.c != null) && (paramb.j.c.a.b == 2))
      {
        paramc = paramb.j.c.f;
        paramb.j.f = parame.createObjectVariable(paramb.j);
        paramb.l.f = parame.createObjectVariable(paramb.l);
        i = (int)(paramc.d + paramb.j.getMargin() + 0.5F);
        j = paramb.getHeight() + i;
        parame.addEquality(paramb.j.f, i);
        parame.addEquality(paramb.l.f, j);
        if ((paramb.A > 0) || (paramb.getVisibility() == 8))
        {
          paramb.m.f = parame.createObjectVariable(paramb.m);
          parame.addEquality(paramb.m.f, paramb.A + i);
        }
        paramb.b = 2;
        paramb.setVerticalDimension(i, j);
        return;
      }
      if ((paramb.l.c != null) && (paramb.l.c.a.b == 2))
      {
        paramc = paramb.l.c.f;
        paramb.j.f = parame.createObjectVariable(paramb.j);
        paramb.l.f = parame.createObjectVariable(paramb.l);
        i = (int)(paramc.d - paramb.l.getMargin() + 0.5F);
        j = i - paramb.getHeight();
        parame.addEquality(paramb.j.f, j);
        parame.addEquality(paramb.l.f, i);
        if ((paramb.A > 0) || (paramb.getVisibility() == 8))
        {
          paramb.m.f = parame.createObjectVariable(paramb.m);
          parame.addEquality(paramb.m.f, paramb.A + j);
        }
        paramb.b = 2;
        paramb.setVerticalDimension(j, i);
        return;
      }
      if ((paramb.m.c != null) && (paramb.m.c.a.b == 2))
      {
        paramc = paramb.m.c.f;
        paramb.j.f = parame.createObjectVariable(paramb.j);
        paramb.l.f = parame.createObjectVariable(paramb.l);
        i = (int)(paramc.d - paramb.A + 0.5F);
        j = paramb.getHeight() + i;
        parame.addEquality(paramb.j.f, i);
        parame.addEquality(paramb.l.f, j);
        paramb.m.f = parame.createObjectVariable(paramb.m);
        parame.addEquality(paramb.m.f, paramb.A + i);
        paramb.b = 2;
        paramb.setVerticalDimension(i, j);
        return;
      }
      if (paramb.m.c == null) {
        break;
      }
      i = 1;
      if (paramb.j.c == null) {
        break label1492;
      }
      j = 1;
      if (paramb.l.c == null) {
        break label1498;
      }
      if ((i != 0) || (j != 0) || (k != 0)) {
        break label1502;
      }
      if (!(paramb instanceof d)) {
        break label1545;
      }
      locald = (d)paramb;
    } while (locald.getOrientation() != 0);
    paramb.j.f = parame.createObjectVariable(paramb.j);
    paramb.l.f = parame.createObjectVariable(paramb.l);
    if (locald.getRelativeBegin() != -1) {
      f = locald.getRelativeBegin();
    }
    for (;;)
    {
      i = (int)(f + 0.5F);
      parame.addEquality(paramb.j.f, i);
      parame.addEquality(paramb.l.f, i);
      paramb.b = 2;
      paramb.a = 2;
      paramb.setVerticalDimension(i, i);
      paramb.setHorizontalDimension(0, paramc.getWidth());
      return;
      i = 0;
      break label1320;
      label1492:
      j = 0;
      break label1333;
      label1498:
      k = 0;
      break label1343;
      label1502:
      break;
      if (locald.getRelativeEnd() != -1)
      {
        f = paramc.getHeight() - locald.getRelativeEnd();
      }
      else
      {
        f = paramc.getHeight();
        f = locald.getRelativePercent() * f;
      }
    }
    label1545:
    paramb.j.f = parame.createObjectVariable(paramb.j);
    paramb.l.f = parame.createObjectVariable(paramb.l);
    int i = paramb.getY();
    int j = paramb.getHeight();
    parame.addEquality(paramb.j.f, i);
    parame.addEquality(paramb.l.f, j + i);
    if ((paramb.A > 0) || (paramb.getVisibility() == 8))
    {
      paramb.m.f = parame.createObjectVariable(paramb.m);
      parame.addEquality(paramb.m.f, i + paramb.A);
    }
    paramb.b = 2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */