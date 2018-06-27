package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.h
  implements RecyclerView.q.b
{
  private c a;
  private boolean b;
  private boolean c = false;
  private boolean d = false;
  private boolean e = true;
  private boolean f;
  private final b g = new b();
  private int h = 2;
  int i;
  af j;
  boolean k = false;
  int l = -1;
  int m = Integer.MIN_VALUE;
  SavedState n = null;
  final a o = new a();
  
  public LinearLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    setReverseLayout(paramBoolean);
    setAutoMeasureEnabled(true);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.a);
    setReverseLayout(paramContext.c);
    setStackFromEnd(paramContext.d);
    setAutoMeasureEnabled(true);
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.r paramr, boolean paramBoolean)
  {
    int i1 = this.j.getEndAfterPadding() - paramInt;
    if (i1 > 0)
    {
      int i2 = -a(-i1, paramn, paramr);
      i1 = i2;
      if (paramBoolean)
      {
        paramInt = this.j.getEndAfterPadding() - (paramInt + i2);
        i1 = i2;
        if (paramInt > 0)
        {
          this.j.offsetChildren(paramInt);
          i1 = i2 + paramInt;
        }
      }
      return i1;
    }
    return 0;
  }
  
  private View a(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    if (this.k) {
      return c(paramn, paramr);
    }
    return d(paramn, paramr);
  }
  
  private View a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.k) {
      return a(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
    }
    return a(0, getChildCount(), paramBoolean1, paramBoolean2);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.a.c = (this.j.getEndAfterPadding() - paramInt2);
    c localc = this.a;
    if (this.k) {}
    for (int i1 = -1;; i1 = 1)
    {
      localc.e = i1;
      this.a.d = paramInt1;
      this.a.f = 1;
      this.a.b = paramInt2;
      this.a.g = Integer.MIN_VALUE;
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.r paramr)
  {
    int i1 = -1;
    int i2 = 1;
    this.a.l = d();
    this.a.h = a(paramr);
    this.a.f = paramInt1;
    if (paramInt1 == 1)
    {
      paramr = this.a;
      paramr.h += this.j.getEndPadding();
      paramr = j();
      localc = this.a;
      if (this.k) {}
      for (paramInt1 = i1;; paramInt1 = 1)
      {
        localc.e = paramInt1;
        this.a.d = (getPosition(paramr) + this.a.e);
        this.a.b = this.j.getDecoratedEnd(paramr);
        paramInt1 = this.j.getDecoratedEnd(paramr) - this.j.getEndAfterPadding();
        this.a.c = paramInt2;
        if (paramBoolean)
        {
          paramr = this.a;
          paramr.c -= paramInt1;
        }
        this.a.g = paramInt1;
        return;
      }
    }
    paramr = i();
    c localc = this.a;
    localc.h += this.j.getStartAfterPadding();
    localc = this.a;
    if (this.k) {}
    for (paramInt1 = i2;; paramInt1 = -1)
    {
      localc.e = paramInt1;
      this.a.d = (getPosition(paramr) + this.a.e);
      this.a.b = this.j.getDecoratedStart(paramr);
      paramInt1 = -this.j.getDecoratedStart(paramr) + this.j.getStartAfterPadding();
      break;
    }
  }
  
  private void a(a parama)
  {
    a(parama.a, parama.b);
  }
  
  private void a(RecyclerView.n paramn, int paramInt)
  {
    if (paramInt < 0) {}
    for (;;)
    {
      return;
      int i2 = getChildCount();
      int i1;
      View localView;
      if (this.k)
      {
        i1 = i2 - 1;
        while (i1 >= 0)
        {
          localView = getChildAt(i1);
          if ((this.j.getDecoratedEnd(localView) > paramInt) || (this.j.getTransformedEndWithDecoration(localView) > paramInt))
          {
            a(paramn, i2 - 1, i1);
            return;
          }
          i1 -= 1;
        }
      }
      else
      {
        i1 = 0;
        while (i1 < i2)
        {
          localView = getChildAt(i1);
          if ((this.j.getDecoratedEnd(localView) > paramInt) || (this.j.getTransformedEndWithDecoration(localView) > paramInt))
          {
            a(paramn, 0, i1);
            return;
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void a(RecyclerView.n paramn, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return;
      int i1 = paramInt1;
      if (paramInt2 > paramInt1)
      {
        paramInt2 -= 1;
        while (paramInt2 >= paramInt1)
        {
          removeAndRecycleViewAt(paramInt2, paramn);
          paramInt2 -= 1;
        }
      }
      else
      {
        while (i1 > paramInt2)
        {
          removeAndRecycleViewAt(i1, paramn);
          i1 -= 1;
        }
      }
    }
  }
  
  private void a(RecyclerView.n paramn, c paramc)
  {
    if ((!paramc.a) || (paramc.l)) {
      return;
    }
    if (paramc.f == -1)
    {
      b(paramn, paramc.g);
      return;
    }
    a(paramn, paramc.g);
  }
  
  private void a(RecyclerView.n paramn, RecyclerView.r paramr, int paramInt1, int paramInt2)
  {
    if ((!paramr.willRunPredictiveAnimations()) || (getChildCount() == 0) || (paramr.isPreLayout()) || (!supportsPredictiveItemAnimations())) {
      return;
    }
    int i1 = 0;
    int i2 = 0;
    List localList = paramn.getScrapList();
    int i5 = localList.size();
    int i6 = getPosition(getChildAt(0));
    int i3 = 0;
    if (i3 < i5)
    {
      RecyclerView.u localu = (RecyclerView.u)localList.get(i3);
      int i4;
      if (localu.isRemoved())
      {
        i4 = i2;
        i2 = i1;
        i1 = i4;
      }
      for (;;)
      {
        i4 = i3 + 1;
        i3 = i2;
        i2 = i1;
        i1 = i3;
        i3 = i4;
        break;
        int i7;
        if (localu.getLayoutPosition() < i6)
        {
          i7 = 1;
          label143:
          if (i7 == this.k) {
            break label195;
          }
        }
        label195:
        for (i4 = -1;; i4 = 1)
        {
          if (i4 != -1) {
            break label201;
          }
          i4 = this.j.getDecoratedMeasurement(localu.itemView) + i1;
          i1 = i2;
          i2 = i4;
          break;
          i7 = 0;
          break label143;
        }
        label201:
        i4 = this.j.getDecoratedMeasurement(localu.itemView) + i2;
        i2 = i1;
        i1 = i4;
      }
    }
    this.a.k = localList;
    if (i1 > 0)
    {
      e(getPosition(i()), paramInt1);
      this.a.h = i1;
      this.a.c = 0;
      this.a.assignPositionFromScrapList();
      a(paramn, this.a, paramr, false);
    }
    if (i2 > 0)
    {
      a(getPosition(j()), paramInt2);
      this.a.h = i2;
      this.a.c = 0;
      this.a.assignPositionFromScrapList();
      a(paramn, this.a, paramr, false);
    }
    this.a.k = null;
  }
  
  private void a(RecyclerView.n paramn, RecyclerView.r paramr, a parama)
  {
    if (a(paramr, parama)) {}
    while (b(paramn, paramr, parama)) {
      return;
    }
    parama.b();
    if (this.d) {}
    for (int i1 = paramr.getItemCount() - 1;; i1 = 0)
    {
      parama.a = i1;
      return;
    }
  }
  
  private boolean a(RecyclerView.r paramr, a parama)
  {
    boolean bool = false;
    if ((paramr.isPreLayout()) || (this.l == -1)) {
      return false;
    }
    if ((this.l < 0) || (this.l >= paramr.getItemCount()))
    {
      this.l = -1;
      this.m = Integer.MIN_VALUE;
      return false;
    }
    parama.a = this.l;
    if ((this.n != null) && (this.n.a()))
    {
      parama.c = this.n.c;
      if (parama.c)
      {
        parama.b = (this.j.getEndAfterPadding() - this.n.b);
        return true;
      }
      parama.b = (this.j.getStartAfterPadding() + this.n.b);
      return true;
    }
    if (this.m == Integer.MIN_VALUE)
    {
      paramr = findViewByPosition(this.l);
      int i1;
      if (paramr != null)
      {
        if (this.j.getDecoratedMeasurement(paramr) > this.j.getTotalSpace())
        {
          parama.b();
          return true;
        }
        if (this.j.getDecoratedStart(paramr) - this.j.getStartAfterPadding() < 0)
        {
          parama.b = this.j.getStartAfterPadding();
          parama.c = false;
          return true;
        }
        if (this.j.getEndAfterPadding() - this.j.getDecoratedEnd(paramr) < 0)
        {
          parama.b = this.j.getEndAfterPadding();
          parama.c = true;
          return true;
        }
        if (parama.c) {}
        for (i1 = this.j.getDecoratedEnd(paramr) + this.j.getTotalSpaceChange();; i1 = this.j.getDecoratedStart(paramr))
        {
          parama.b = i1;
          return true;
        }
      }
      if (getChildCount() > 0)
      {
        i1 = getPosition(getChildAt(0));
        if (this.l >= i1) {
          break label351;
        }
      }
      label351:
      for (int i2 = 1;; i2 = 0)
      {
        if (i2 == this.k) {
          bool = true;
        }
        parama.c = bool;
        parama.b();
        return true;
      }
    }
    parama.c = this.k;
    if (this.k)
    {
      parama.b = (this.j.getEndAfterPadding() - this.m);
      return true;
    }
    parama.b = (this.j.getStartAfterPadding() + this.m);
    return true;
  }
  
  private int b(int paramInt, RecyclerView.n paramn, RecyclerView.r paramr, boolean paramBoolean)
  {
    int i1 = paramInt - this.j.getStartAfterPadding();
    if (i1 > 0)
    {
      int i2 = -a(i1, paramn, paramr);
      i1 = i2;
      if (paramBoolean)
      {
        paramInt = paramInt + i2 - this.j.getStartAfterPadding();
        i1 = i2;
        if (paramInt > 0)
        {
          this.j.offsetChildren(-paramInt);
          i1 = i2 - paramInt;
        }
      }
      return i1;
    }
    return 0;
  }
  
  private int b(RecyclerView.r paramr)
  {
    boolean bool2 = false;
    if (getChildCount() == 0) {
      return 0;
    }
    b();
    af localaf = this.j;
    if (!this.e) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = a(bool1, true);
      bool1 = bool2;
      if (!this.e) {
        bool1 = true;
      }
      return al.a(paramr, localaf, localView, b(bool1, true), this, this.e, this.k);
    }
  }
  
  private View b(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    if (this.k) {
      return d(paramn, paramr);
    }
    return c(paramn, paramr);
  }
  
  private View b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.k) {
      return a(0, getChildCount(), paramBoolean1, paramBoolean2);
    }
    return a(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
  }
  
  private void b(a parama)
  {
    e(parama.a, parama.b);
  }
  
  private void b(RecyclerView.n paramn, int paramInt)
  {
    int i1 = getChildCount();
    if (paramInt < 0) {}
    for (;;)
    {
      return;
      int i2 = this.j.getEnd() - paramInt;
      View localView;
      if (this.k)
      {
        paramInt = 0;
        while (paramInt < i1)
        {
          localView = getChildAt(paramInt);
          if ((this.j.getDecoratedStart(localView) < i2) || (this.j.getTransformedStartWithDecoration(localView) < i2))
          {
            a(paramn, 0, paramInt);
            return;
          }
          paramInt += 1;
        }
      }
      else
      {
        paramInt = i1 - 1;
        while (paramInt >= 0)
        {
          localView = getChildAt(paramInt);
          if ((this.j.getDecoratedStart(localView) < i2) || (this.j.getTransformedStartWithDecoration(localView) < i2))
          {
            a(paramn, i1 - 1, paramInt);
            return;
          }
          paramInt -= 1;
        }
      }
    }
  }
  
  private boolean b(RecyclerView.n paramn, RecyclerView.r paramr, a parama)
  {
    int i1 = 0;
    if (getChildCount() == 0) {}
    do
    {
      return false;
      View localView = getFocusedChild();
      if ((localView != null) && (parama.a(localView, paramr)))
      {
        parama.assignFromViewAndKeepVisibleRect(localView);
        return true;
      }
    } while (this.b != this.d);
    if (parama.c)
    {
      paramn = a(paramn, paramr);
      label66:
      if (paramn == null) {
        break label165;
      }
      parama.assignFromView(paramn);
      if ((!paramr.isPreLayout()) && (supportsPredictiveItemAnimations()))
      {
        if ((this.j.getDecoratedStart(paramn) >= this.j.getEndAfterPadding()) || (this.j.getDecoratedEnd(paramn) < this.j.getStartAfterPadding())) {
          i1 = 1;
        }
        if (i1 != 0) {
          if (!parama.c) {
            break label167;
          }
        }
      }
    }
    label165:
    label167:
    for (i1 = this.j.getEndAfterPadding();; i1 = this.j.getStartAfterPadding())
    {
      parama.b = i1;
      return true;
      paramn = b(paramn, paramr);
      break label66;
      break;
    }
  }
  
  private int c(RecyclerView.r paramr)
  {
    boolean bool2 = false;
    if (getChildCount() == 0) {
      return 0;
    }
    b();
    af localaf = this.j;
    if (!this.e) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = a(bool1, true);
      bool1 = bool2;
      if (!this.e) {
        bool1 = true;
      }
      return al.a(paramr, localaf, localView, b(bool1, true), this, this.e);
    }
  }
  
  private View c(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    return a(paramn, paramr, 0, getChildCount(), paramr.getItemCount());
  }
  
  private int d(RecyclerView.r paramr)
  {
    boolean bool2 = false;
    if (getChildCount() == 0) {
      return 0;
    }
    b();
    af localaf = this.j;
    if (!this.e) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = a(bool1, true);
      bool1 = bool2;
      if (!this.e) {
        bool1 = true;
      }
      return al.b(paramr, localaf, localView, b(bool1, true), this, this.e);
    }
  }
  
  private View d(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    return a(paramn, paramr, getChildCount() - 1, -1, paramr.getItemCount());
  }
  
  private View e(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    if (this.k) {
      return g(paramn, paramr);
    }
    return h(paramn, paramr);
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    this.a.c = (paramInt2 - this.j.getStartAfterPadding());
    this.a.d = paramInt1;
    c localc = this.a;
    if (this.k) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localc.e = paramInt1;
      this.a.f = -1;
      this.a.b = paramInt2;
      this.a.g = Integer.MIN_VALUE;
      return;
    }
  }
  
  private View f(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    if (this.k) {
      return h(paramn, paramr);
    }
    return g(paramn, paramr);
  }
  
  private View g(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    return b(0, getChildCount());
  }
  
  private View h(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    return b(getChildCount() - 1, -1);
  }
  
  private void h()
  {
    boolean bool = true;
    if ((this.i == 1) || (!a()))
    {
      this.k = this.c;
      return;
    }
    if (!this.c) {}
    for (;;)
    {
      this.k = bool;
      return;
      bool = false;
    }
  }
  
  private View i()
  {
    if (this.k) {}
    for (int i1 = getChildCount() - 1;; i1 = 0) {
      return getChildAt(i1);
    }
  }
  
  private View j()
  {
    if (this.k) {}
    for (int i1 = 0;; i1 = getChildCount() - 1) {
      return getChildAt(i1);
    }
  }
  
  int a(int paramInt)
  {
    int i1 = -1;
    int i2 = Integer.MIN_VALUE;
    int i3 = 1;
    switch (paramInt)
    {
    default: 
      paramInt = Integer.MIN_VALUE;
    case 1: 
    case 2: 
    case 33: 
    case 130: 
    case 17: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return paramInt;
                paramInt = i1;
              } while (this.i == 1);
              paramInt = i1;
            } while (!a());
            return 1;
            if (this.i == 1) {
              return 1;
            }
            paramInt = i1;
          } while (a());
          return 1;
          paramInt = i1;
        } while (this.i == 1);
        return Integer.MIN_VALUE;
        paramInt = i2;
        if (this.i == 1) {
          paramInt = 1;
        }
        return paramInt;
        paramInt = i1;
      } while (this.i == 0);
      return Integer.MIN_VALUE;
    }
    if (this.i == 0) {}
    for (paramInt = i3;; paramInt = Integer.MIN_VALUE) {
      return paramInt;
    }
  }
  
  int a(int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.a.a = true;
    b();
    if (paramInt > 0) {}
    int i2;
    int i3;
    for (int i1 = 1;; i1 = -1)
    {
      i2 = Math.abs(paramInt);
      a(i1, i2, true, paramr);
      i3 = this.a.g + a(paramn, this.a, paramr, false);
      if (i3 >= 0) {
        break;
      }
      return 0;
    }
    if (i2 > i3) {
      paramInt = i1 * i3;
    }
    this.j.offsetChildren(-paramInt);
    this.a.j = paramInt;
    return paramInt;
  }
  
  int a(RecyclerView.n paramn, c paramc, RecyclerView.r paramr, boolean paramBoolean)
  {
    int i3 = paramc.c;
    if (paramc.g != Integer.MIN_VALUE)
    {
      if (paramc.c < 0) {
        paramc.g += paramc.c;
      }
      a(paramn, paramc);
    }
    int i1 = paramc.c + paramc.h;
    b localb = this.g;
    if (((paramc.l) || (i1 > 0)) && (paramc.a(paramr)))
    {
      localb.a();
      a(paramn, paramr, paramc, localb);
      if (!localb.b) {
        break label108;
      }
    }
    for (;;)
    {
      return i3 - paramc.c;
      label108:
      paramc.b += localb.a * paramc.f;
      int i2;
      if ((localb.c) && (this.a.k == null))
      {
        i2 = i1;
        if (paramr.isPreLayout()) {}
      }
      else
      {
        paramc.c -= localb.a;
        i2 = i1 - localb.a;
      }
      if (paramc.g != Integer.MIN_VALUE)
      {
        paramc.g += localb.a;
        if (paramc.c < 0) {
          paramc.g += paramc.c;
        }
        a(paramn, paramc);
      }
      i1 = i2;
      if (!paramBoolean) {
        break;
      }
      i1 = i2;
      if (!localb.d) {
        break;
      }
    }
  }
  
  protected int a(RecyclerView.r paramr)
  {
    if (paramr.hasTargetScrollPosition()) {
      return this.j.getTotalSpace();
    }
    return 0;
  }
  
  View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 320;
    b();
    int i1;
    if (paramBoolean1)
    {
      i1 = 24579;
      if (!paramBoolean2) {
        break label66;
      }
    }
    for (;;)
    {
      if (this.i == 0)
      {
        return this.r.a(paramInt1, paramInt2, i1, i2);
        i1 = 320;
        break;
      }
      return this.s.a(paramInt1, paramInt2, i1, i2);
      label66:
      i2 = 0;
    }
  }
  
  View a(RecyclerView.n paramn, RecyclerView.r paramr, int paramInt1, int paramInt2, int paramInt3)
  {
    paramr = null;
    b();
    int i2 = this.j.getStartAfterPadding();
    int i3 = this.j.getEndAfterPadding();
    int i1;
    label35:
    Object localObject1;
    if (paramInt2 > paramInt1)
    {
      i1 = 1;
      paramn = null;
      if (paramInt1 == paramInt2) {
        break label157;
      }
      localObject1 = getChildAt(paramInt1);
      int i4 = getPosition((View)localObject1);
      if ((i4 < 0) || (i4 >= paramInt3)) {
        break label172;
      }
      if (!((RecyclerView.LayoutParams)((View)localObject1).getLayoutParams()).isItemRemoved()) {
        break label113;
      }
      if (paramn != null) {
        break label172;
      }
      paramn = paramr;
      paramr = (RecyclerView.r)localObject1;
    }
    for (;;)
    {
      paramInt1 += i1;
      localObject1 = paramr;
      paramr = paramn;
      paramn = (RecyclerView.n)localObject1;
      break label35;
      i1 = -1;
      break;
      label113:
      Object localObject2;
      if (this.j.getDecoratedStart((View)localObject1) < i3)
      {
        localObject2 = localObject1;
        if (this.j.getDecoratedEnd((View)localObject1) >= i2) {}
      }
      else
      {
        if (paramr != null) {
          break label172;
        }
        paramr = paramn;
        paramn = (RecyclerView.n)localObject1;
        continue;
        label157:
        if (paramr == null) {
          break label167;
        }
      }
      for (;;)
      {
        localObject2 = paramr;
        return (View)localObject2;
        label167:
        paramr = paramn;
      }
      label172:
      localObject1 = paramn;
      paramn = paramr;
      paramr = (RecyclerView.r)localObject1;
    }
  }
  
  void a(RecyclerView.n paramn, RecyclerView.r paramr, a parama, int paramInt) {}
  
  void a(RecyclerView.n paramn, RecyclerView.r paramr, c paramc, b paramb)
  {
    paramn = paramc.a(paramn);
    if (paramn == null)
    {
      paramb.b = true;
      return;
    }
    paramr = (RecyclerView.LayoutParams)paramn.getLayoutParams();
    boolean bool2;
    boolean bool1;
    label61:
    int i1;
    int i2;
    label120:
    int i4;
    int i3;
    if (paramc.k == null)
    {
      bool2 = this.k;
      if (paramc.f == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label195;
        }
        addView(paramn);
        measureChildWithMargins(paramn, 0, 0);
        paramb.a = this.j.getDecoratedMeasurement(paramn);
        if (this.i != 1) {
          break label298;
        }
        if (!a()) {
          break label251;
        }
        i1 = getWidth() - getPaddingRight();
        i2 = i1 - this.j.getDecoratedMeasurementInOther(paramn);
        if (paramc.f != -1) {
          break label273;
        }
        i4 = paramc.b;
        i3 = paramc.b - paramb.a;
      }
    }
    for (;;)
    {
      layoutDecoratedWithMargins(paramn, i2, i3, i1, i4);
      if ((paramr.isItemRemoved()) || (paramr.isItemChanged())) {
        paramb.c = true;
      }
      paramb.d = paramn.hasFocusable();
      return;
      bool1 = false;
      break;
      label195:
      addView(paramn, 0);
      break label61;
      bool2 = this.k;
      if (paramc.f == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label242;
        }
        addDisappearingView(paramn);
        break;
      }
      label242:
      addDisappearingView(paramn, 0);
      break label61;
      label251:
      i2 = getPaddingLeft();
      i1 = this.j.getDecoratedMeasurementInOther(paramn) + i2;
      break label120;
      label273:
      i3 = paramc.b;
      i4 = paramc.b;
      i4 = paramb.a + i4;
      continue;
      label298:
      i3 = getPaddingTop();
      i4 = i3 + this.j.getDecoratedMeasurementInOther(paramn);
      if (paramc.f == -1)
      {
        i1 = paramc.b;
        i2 = paramc.b - paramb.a;
      }
      else
      {
        i2 = paramc.b;
        i1 = paramc.b + paramb.a;
      }
    }
  }
  
  void a(RecyclerView.r paramr, c paramc, RecyclerView.h.a parama)
  {
    int i1 = paramc.d;
    if ((i1 >= 0) && (i1 < paramr.getItemCount())) {
      parama.addPosition(i1, Math.max(0, paramc.g));
    }
  }
  
  protected boolean a()
  {
    return getLayoutDirection() == 1;
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.n == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  View b(int paramInt1, int paramInt2)
  {
    b();
    if (paramInt2 > paramInt1) {
      i1 = 1;
    }
    while (i1 == 0)
    {
      return getChildAt(paramInt1);
      if (paramInt2 < paramInt1) {
        i1 = -1;
      } else {
        i1 = 0;
      }
    }
    int i2;
    if (this.j.getDecoratedStart(getChildAt(paramInt1)) < this.j.getStartAfterPadding()) {
      i2 = 16644;
    }
    for (int i1 = 16388; this.i == 0; i1 = 4097)
    {
      return this.r.a(paramInt1, paramInt2, i2, i1);
      i2 = 4161;
    }
    return this.s.a(paramInt1, paramInt2, i2, i1);
  }
  
  void b()
  {
    if (this.a == null) {
      this.a = c();
    }
    if (this.j == null) {
      this.j = af.createOrientationHelper(this, this.i);
    }
  }
  
  c c()
  {
    return new c();
  }
  
  public boolean canScrollHorizontally()
  {
    return this.i == 0;
  }
  
  public boolean canScrollVertically()
  {
    return this.i == 1;
  }
  
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.r paramr, RecyclerView.h.a parama)
  {
    if (this.i == 0) {}
    while ((getChildCount() == 0) || (paramInt1 == 0))
    {
      return;
      paramInt1 = paramInt2;
    }
    b();
    if (paramInt1 > 0) {}
    for (paramInt2 = 1;; paramInt2 = -1)
    {
      a(paramInt2, Math.abs(paramInt1), true, paramr);
      a(paramr, this.a, parama);
      return;
    }
  }
  
  public void collectInitialPrefetchPositions(int paramInt, RecyclerView.h.a parama)
  {
    boolean bool;
    int i1;
    if ((this.n != null) && (this.n.a()))
    {
      bool = this.n.c;
      i1 = this.n.a;
      if (!bool) {
        break label136;
      }
    }
    label136:
    for (int i2 = -1;; i2 = 1)
    {
      int i4 = 0;
      int i3 = i1;
      i1 = i4;
      while ((i1 < this.h) && (i3 >= 0) && (i3 < paramInt))
      {
        parama.addPosition(i3, 0);
        i3 += i2;
        i1 += 1;
      }
      h();
      bool = this.k;
      if (this.l == -1)
      {
        if (bool) {}
        for (i1 = paramInt - 1;; i1 = 0) {
          break;
        }
      }
      i1 = this.l;
      break;
    }
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.r paramr)
  {
    return c(paramr);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.r paramr)
  {
    return b(paramr);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.r paramr)
  {
    return d(paramr);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    int i1 = 1;
    int i2 = 0;
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {
      i2 = 1;
    }
    paramInt = i1;
    if (i2 != this.k) {
      paramInt = -1;
    }
    if (this.i == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.r paramr)
  {
    return c(paramr);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.r paramr)
  {
    return b(paramr);
  }
  
  public int computeVerticalScrollRange(RecyclerView.r paramr)
  {
    return d(paramr);
  }
  
  boolean d()
  {
    return (this.j.getMode() == 0) && (this.j.getEnd() == 0);
  }
  
  boolean e()
  {
    return (getHeightMode() != 1073741824) && (getWidthMode() != 1073741824) && (g());
  }
  
  public int findFirstCompletelyVisibleItemPosition()
  {
    View localView = a(0, getChildCount(), true, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findFirstVisibleItemPosition()
  {
    View localView = a(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findLastCompletelyVisibleItemPosition()
  {
    View localView = a(getChildCount() - 1, -1, true, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findLastVisibleItemPosition()
  {
    View localView = a(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public View findViewByPosition(int paramInt)
  {
    int i1 = getChildCount();
    Object localObject;
    if (i1 == 0) {
      localObject = null;
    }
    View localView;
    do
    {
      return (View)localObject;
      int i2 = paramInt - getPosition(getChildAt(0));
      if ((i2 < 0) || (i2 >= i1)) {
        break;
      }
      localView = getChildAt(i2);
      localObject = localView;
    } while (getPosition(localView) == paramInt);
    return super.findViewByPosition(paramInt);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public int getInitialPrefetchItemCount()
  {
    return this.h;
  }
  
  public int getOrientation()
  {
    return this.i;
  }
  
  public boolean getRecycleChildrenOnDetach()
  {
    return this.f;
  }
  
  public boolean getReverseLayout()
  {
    return this.c;
  }
  
  public boolean getStackFromEnd()
  {
    return this.d;
  }
  
  public boolean isSmoothScrollbarEnabled()
  {
    return this.e;
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    if (this.f)
    {
      removeAndRecycleAllViews(paramn);
      paramn.clear();
    }
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
  {
    h();
    if (getChildCount() == 0)
    {
      paramView = null;
      return paramView;
    }
    paramInt = a(paramInt);
    if (paramInt == Integer.MIN_VALUE) {
      return null;
    }
    b();
    b();
    a(paramInt, (int)(0.33333334F * this.j.getTotalSpace()), false, paramr);
    this.a.g = Integer.MIN_VALUE;
    this.a.a = false;
    a(paramn, this.a, paramr, true);
    if (paramInt == -1)
    {
      paramn = f(paramn, paramr);
      label101:
      if (paramInt != -1) {
        break label135;
      }
    }
    label135:
    for (paramView = i();; paramView = j())
    {
      if (!paramView.hasFocusable()) {
        return paramn;
      }
      if (paramn != null) {
        break;
      }
      return null;
      paramn = e(paramn, paramr);
      break label101;
    }
    return paramn;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
      paramAccessibilityEvent.setToIndex(findLastVisibleItemPosition());
    }
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    int i3 = -1;
    if (((this.n != null) || (this.l != -1)) && (paramr.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramn);
      return;
    }
    if ((this.n != null) && (this.n.a())) {
      this.l = this.n.a;
    }
    b();
    this.a.a = false;
    h();
    Object localObject = getFocusedChild();
    int i2;
    label166:
    int i4;
    int i5;
    if ((!this.o.d) || (this.l != -1) || (this.n != null))
    {
      this.o.a();
      this.o.c = (this.k ^ this.d);
      a(paramn, paramr, this.o);
      this.o.d = true;
      i1 = a(paramr);
      if (this.a.j < 0) {
        break label719;
      }
      i2 = 0;
      i4 = i2 + this.j.getStartAfterPadding();
      i5 = i1 + this.j.getEndPadding();
      i1 = i5;
      i2 = i4;
      if (paramr.isPreLayout())
      {
        i1 = i5;
        i2 = i4;
        if (this.l != -1)
        {
          i1 = i5;
          i2 = i4;
          if (this.m != Integer.MIN_VALUE)
          {
            localObject = findViewByPosition(this.l);
            i1 = i5;
            i2 = i4;
            if (localObject != null)
            {
              if (!this.k) {
                break label727;
              }
              i1 = this.j.getEndAfterPadding() - this.j.getDecoratedEnd((View)localObject) - this.m;
              label286:
              if (i1 <= 0) {
                break label759;
              }
              i2 = i4 + i1;
              i1 = i5;
            }
          }
        }
      }
      label299:
      if (!this.o.c) {
        break label771;
      }
      if (this.k) {
        i3 = 1;
      }
      label319:
      a(paramn, paramr, this.o, i3);
      detachAndScrapAttachedViews(paramn);
      this.a.l = d();
      this.a.i = paramr.isPreLayout();
      if (!this.o.c) {
        break label784;
      }
      b(this.o);
      this.a.h = i2;
      a(paramn, this.a, paramr, false);
      i4 = this.a.b;
      i5 = this.a.d;
      i2 = i1;
      if (this.a.c > 0) {
        i2 = i1 + this.a.c;
      }
      a(this.o);
      this.a.h = i2;
      localObject = this.a;
      ((c)localObject).d += this.a.e;
      a(paramn, this.a, paramr, false);
      i3 = this.a.b;
      if (this.a.c <= 0) {
        break label1038;
      }
      i1 = this.a.c;
      e(i5, i4);
      this.a.h = i1;
      a(paramn, this.a, paramr, false);
    }
    label561:
    label631:
    label719:
    label727:
    label759:
    label771:
    label784:
    label1028:
    label1038:
    for (int i1 = this.a.b;; i1 = i4)
    {
      i2 = i1;
      i1 = i3;
      i3 = i1;
      i4 = i2;
      if (getChildCount() > 0)
      {
        if ((this.k ^ this.d))
        {
          i3 = a(i1, paramn, paramr, true);
          i4 = i2 + i3;
          i2 = b(i4, paramn, paramr, false);
          i4 += i2;
          i3 = i1 + i3 + i2;
        }
      }
      else
      {
        a(paramn, paramr, i4, i3);
        if (paramr.isPreLayout()) {
          break label1028;
        }
        this.j.onLayoutComplete();
      }
      for (;;)
      {
        this.b = this.d;
        return;
        if ((localObject == null) || ((this.j.getDecoratedStart((View)localObject) < this.j.getEndAfterPadding()) && (this.j.getDecoratedEnd((View)localObject) > this.j.getStartAfterPadding()))) {
          break;
        }
        this.o.assignFromViewAndKeepVisibleRect((View)localObject);
        break;
        i2 = i1;
        i1 = 0;
        break label166;
        i1 = this.j.getDecoratedStart((View)localObject);
        i2 = this.j.getStartAfterPadding();
        i1 = this.m - (i1 - i2);
        break label286;
        i1 = i5 - i1;
        i2 = i4;
        break label299;
        if (this.k) {
          break label319;
        }
        i3 = 1;
        break label319;
        a(this.o);
        this.a.h = i1;
        a(paramn, this.a, paramr, false);
        i3 = this.a.b;
        i5 = this.a.d;
        i1 = i2;
        if (this.a.c > 0) {
          i1 = i2 + this.a.c;
        }
        b(this.o);
        this.a.h = i1;
        localObject = this.a;
        ((c)localObject).d += this.a.e;
        a(paramn, this.a, paramr, false);
        i4 = this.a.b;
        i1 = i3;
        i2 = i4;
        if (this.a.c <= 0) {
          break label561;
        }
        i1 = this.a.c;
        a(i5, i3);
        this.a.h = i1;
        a(paramn, this.a, paramr, false);
        i1 = this.a.b;
        i2 = i4;
        break label561;
        i3 = b(i2, paramn, paramr, true);
        i1 += i3;
        i5 = a(i1, paramn, paramr, false);
        i4 = i2 + i3 + i5;
        i3 = i1 + i5;
        break label631;
        this.o.a();
      }
    }
  }
  
  public void onLayoutCompleted(RecyclerView.r paramr)
  {
    super.onLayoutCompleted(paramr);
    this.n = null;
    this.l = -1;
    this.m = Integer.MIN_VALUE;
    this.o.a();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.n = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.n != null) {
      return new SavedState(this.n);
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      b();
      boolean bool = this.b ^ this.k;
      localSavedState.c = bool;
      if (bool)
      {
        localView = j();
        localSavedState.b = (this.j.getEndAfterPadding() - this.j.getDecoratedEnd(localView));
        localSavedState.a = getPosition(localView);
        return localSavedState;
      }
      View localView = i();
      localSavedState.a = getPosition(localView);
      localSavedState.b = (this.j.getDecoratedStart(localView) - this.j.getStartAfterPadding());
      return localSavedState;
    }
    localSavedState.b();
    return localSavedState;
  }
  
  public void prepareForDrop(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    b();
    h();
    paramInt1 = getPosition(paramView1);
    paramInt2 = getPosition(paramView2);
    if (paramInt1 < paramInt2) {
      paramInt1 = 1;
    }
    while (this.k) {
      if (paramInt1 == 1)
      {
        scrollToPositionWithOffset(paramInt2, this.j.getEndAfterPadding() - (this.j.getDecoratedStart(paramView2) + this.j.getDecoratedMeasurement(paramView1)));
        return;
        paramInt1 = -1;
      }
      else
      {
        scrollToPositionWithOffset(paramInt2, this.j.getEndAfterPadding() - this.j.getDecoratedEnd(paramView2));
        return;
      }
    }
    if (paramInt1 == -1)
    {
      scrollToPositionWithOffset(paramInt2, this.j.getDecoratedStart(paramView2));
      return;
    }
    scrollToPositionWithOffset(paramInt2, this.j.getDecoratedEnd(paramView2) - this.j.getDecoratedMeasurement(paramView1));
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
  {
    if (this.i == 1) {
      return 0;
    }
    return a(paramInt, paramn, paramr);
  }
  
  public void scrollToPosition(int paramInt)
  {
    this.l = paramInt;
    this.m = Integer.MIN_VALUE;
    if (this.n != null) {
      this.n.b();
    }
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    this.l = paramInt1;
    this.m = paramInt2;
    if (this.n != null) {
      this.n.b();
    }
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
  {
    if (this.i == 0) {
      return 0;
    }
    return a(paramInt, paramn, paramr);
  }
  
  public void setInitialPrefetchItemCount(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:" + paramInt);
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.i) {
      return;
    }
    this.i = paramInt;
    this.j = null;
    requestLayout();
  }
  
  public void setRecycleChildrenOnDetach(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.c) {
      return;
    }
    this.c = paramBoolean;
    requestLayout();
  }
  
  public void setSmoothScrollbarEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (this.d == paramBoolean) {
      return;
    }
    this.d = paramBoolean;
    requestLayout();
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.r paramr, int paramInt)
  {
    paramRecyclerView = new ac(paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.n == null) && (this.b == this.d);
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public LinearLayoutManager.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new LinearLayoutManager.SavedState(paramAnonymousParcel);
      }
      
      public LinearLayoutManager.SavedState[] newArray(int paramAnonymousInt)
      {
        return new LinearLayoutManager.SavedState[paramAnonymousInt];
      }
    };
    int a;
    int b;
    boolean c;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.c = bool;
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.a = paramSavedState.a;
      this.b = paramSavedState.b;
      this.c = paramSavedState.c;
    }
    
    boolean a()
    {
      return this.a >= 0;
    }
    
    void b()
    {
      this.a = -1;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeInt(this.b);
      if (this.c) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  class a
  {
    int a;
    int b;
    boolean c;
    boolean d;
    
    a()
    {
      a();
    }
    
    void a()
    {
      this.a = -1;
      this.b = Integer.MIN_VALUE;
      this.c = false;
      this.d = false;
    }
    
    boolean a(View paramView, RecyclerView.r paramr)
    {
      paramView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return (!paramView.isItemRemoved()) && (paramView.getViewLayoutPosition() >= 0) && (paramView.getViewLayoutPosition() < paramr.getItemCount());
    }
    
    public void assignFromView(View paramView)
    {
      if (this.c) {}
      for (this.b = (LinearLayoutManager.this.j.getDecoratedEnd(paramView) + LinearLayoutManager.this.j.getTotalSpaceChange());; this.b = LinearLayoutManager.this.j.getDecoratedStart(paramView))
      {
        this.a = LinearLayoutManager.this.getPosition(paramView);
        return;
      }
    }
    
    public void assignFromViewAndKeepVisibleRect(View paramView)
    {
      int j = LinearLayoutManager.this.j.getTotalSpaceChange();
      if (j >= 0) {
        assignFromView(paramView);
      }
      int i;
      do
      {
        int k;
        do
        {
          do
          {
            do
            {
              return;
              this.a = LinearLayoutManager.this.getPosition(paramView);
              if (!this.c) {
                break;
              }
              i = LinearLayoutManager.this.j.getEndAfterPadding() - j - LinearLayoutManager.this.j.getDecoratedEnd(paramView);
              this.b = (LinearLayoutManager.this.j.getEndAfterPadding() - i);
            } while (i <= 0);
            j = LinearLayoutManager.this.j.getDecoratedMeasurement(paramView);
            k = this.b;
            m = LinearLayoutManager.this.j.getStartAfterPadding();
            j = k - j - (m + Math.min(LinearLayoutManager.this.j.getDecoratedStart(paramView) - m, 0));
          } while (j >= 0);
          k = this.b;
          this.b = (Math.min(i, -j) + k);
          return;
          k = LinearLayoutManager.this.j.getDecoratedStart(paramView);
          i = k - LinearLayoutManager.this.j.getStartAfterPadding();
          this.b = k;
        } while (i <= 0);
        int m = LinearLayoutManager.this.j.getDecoratedMeasurement(paramView);
        int n = LinearLayoutManager.this.j.getEndAfterPadding();
        int i1 = LinearLayoutManager.this.j.getDecoratedEnd(paramView);
        j = LinearLayoutManager.this.j.getEndAfterPadding() - Math.min(0, n - j - i1) - (k + m);
      } while (j >= 0);
      this.b -= Math.min(i, -j);
    }
    
    void b()
    {
      if (this.c) {}
      for (int i = LinearLayoutManager.this.j.getEndAfterPadding();; i = LinearLayoutManager.this.j.getStartAfterPadding())
      {
        this.b = i;
        return;
      }
    }
    
    public String toString()
    {
      return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + ", mValid=" + this.d + '}';
    }
  }
  
  protected static class b
  {
    public int a;
    public boolean b;
    public boolean c;
    public boolean d;
    
    void a()
    {
      this.a = 0;
      this.b = false;
      this.c = false;
      this.d = false;
    }
  }
  
  static class c
  {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h = 0;
    boolean i = false;
    int j;
    List<RecyclerView.u> k = null;
    boolean l;
    
    private View a()
    {
      int n = this.k.size();
      int m = 0;
      if (m < n)
      {
        View localView = ((RecyclerView.u)this.k.get(m)).itemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.isItemRemoved()) {}
        while (this.d != localLayoutParams.getViewLayoutPosition())
        {
          m += 1;
          break;
        }
        assignPositionFromScrapList(localView);
        return localView;
      }
      return null;
    }
    
    View a(RecyclerView.n paramn)
    {
      if (this.k != null) {
        return a();
      }
      paramn = paramn.getViewForPosition(this.d);
      this.d += this.e;
      return paramn;
    }
    
    boolean a(RecyclerView.r paramr)
    {
      return (this.d >= 0) && (this.d < paramr.getItemCount());
    }
    
    public void assignPositionFromScrapList()
    {
      assignPositionFromScrapList(null);
    }
    
    public void assignPositionFromScrapList(View paramView)
    {
      paramView = nextViewInLimitedList(paramView);
      if (paramView == null)
      {
        this.d = -1;
        return;
      }
      this.d = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    }
    
    public View nextViewInLimitedList(View paramView)
    {
      int i2 = this.k.size();
      Object localObject = null;
      int m = Integer.MAX_VALUE;
      int n = 0;
      if (n < i2)
      {
        View localView = ((RecyclerView.u)this.k.get(n)).itemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if (localView != paramView) {
          if (!localLayoutParams.isItemRemoved()) {}
        }
        for (;;)
        {
          n += 1;
          break;
          int i1 = (localLayoutParams.getViewLayoutPosition() - this.d) * this.e;
          if (i1 >= 0) {
            if (i1 < m)
            {
              if (i1 == 0) {
                return localView;
              }
              localObject = localView;
              m = i1;
            }
          }
        }
      }
      return (View)localObject;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/LinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */