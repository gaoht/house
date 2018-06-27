package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager
  extends RecyclerView.h
  implements RecyclerView.q.b
{
  private SavedState A;
  private int B;
  private final Rect C = new Rect();
  private final a D = new a();
  private boolean E = false;
  private boolean F = true;
  private int[] G;
  private final Runnable H = new Runnable()
  {
    public void run()
    {
      StaggeredGridLayoutManager.this.a();
    }
  };
  b[] a;
  af b;
  af c;
  boolean d = false;
  boolean e = false;
  int f = -1;
  int g = Integer.MIN_VALUE;
  LazySpanLookup h = new LazySpanLookup();
  private int i = -1;
  private int j;
  private int k;
  private final ab l;
  private BitSet m;
  private int n = 2;
  private boolean o;
  private boolean z;
  
  public StaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    this.j = paramInt2;
    setSpanCount(paramInt1);
    if (this.n != 0) {}
    for (;;)
    {
      setAutoMeasureEnabled(bool);
      this.l = new ab();
      l();
      return;
      bool = false;
    }
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.a);
    setSpanCount(paramContext.b);
    setReverseLayout(paramContext.c);
    if (this.n != 0) {}
    for (;;)
    {
      setAutoMeasureEnabled(bool);
      this.l = new ab();
      l();
      return;
      bool = false;
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    int i1;
    do
    {
      return paramInt1;
      i1 = View.MeasureSpec.getMode(paramInt1);
    } while ((i1 != Integer.MIN_VALUE) && (i1 != 1073741824));
    return View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i1);
  }
  
  private int a(RecyclerView.n paramn, ab paramab, RecyclerView.r paramr)
  {
    this.m.set(0, this.i, true);
    int i1;
    int i4;
    label61:
    int i2;
    label64:
    View localView;
    LayoutParams localLayoutParams;
    int i7;
    int i6;
    label136:
    b localb;
    label157:
    label168:
    label189:
    label222:
    int i5;
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    int i3;
    if (this.l.i) {
      if (paramab.e == 1)
      {
        i1 = Integer.MAX_VALUE;
        a(paramab.e, i1);
        if (!this.e) {
          break label506;
        }
        i4 = this.b.getEndAfterPadding();
        i2 = 0;
        if ((!paramab.a(paramr)) || ((!this.l.i) && (this.m.isEmpty()))) {
          break label876;
        }
        localView = paramab.a(paramn);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i7 = localLayoutParams.getViewLayoutPosition();
        i2 = this.h.c(i7);
        if (i2 != -1) {
          break label518;
        }
        i6 = 1;
        if (i6 == 0) {
          break label534;
        }
        if (!localLayoutParams.b) {
          break label524;
        }
        localb = this.a[0];
        this.h.a(i7, localb);
        localLayoutParams.a = localb;
        if (paramab.e != 1) {
          break label546;
        }
        addView(localView);
        a(localView, localLayoutParams, false);
        if (paramab.e != 1) {
          break label568;
        }
        if (!localLayoutParams.b) {
          break label556;
        }
        i2 = g(i4);
        i5 = i2 + this.b.getDecoratedMeasurement(localView);
        if ((i6 == 0) || (!localLayoutParams.b)) {
          break label967;
        }
        localFullSpanItem = c(i2);
        localFullSpanItem.b = -1;
        localFullSpanItem.a = i7;
        this.h.addFullSpanItem(localFullSpanItem);
        i3 = i2;
      }
    }
    for (;;)
    {
      if ((localLayoutParams.b) && (paramab.d == -1))
      {
        if (i6 != 0) {
          this.E = true;
        }
      }
      else
      {
        label309:
        a(localView, localLayoutParams, paramab);
        if ((!c()) || (this.j != 1)) {
          break label768;
        }
        if (!localLayoutParams.b) {
          break label738;
        }
        i2 = this.c.getEndAfterPadding();
        label350:
        i7 = i2 - this.c.getDecoratedMeasurement(localView);
        i6 = i2;
        i2 = i7;
        if (this.j != 1) {
          break label825;
        }
        layoutDecoratedWithMargins(localView, i2, i3, i6, i5);
        label394:
        if (!localLayoutParams.b) {
          break label842;
        }
        a(this.l.e, i1);
        label415:
        a(paramn, this.l);
        if ((this.l.h) && (localView.hasFocusable()))
        {
          if (!localLayoutParams.b) {
            break label860;
          }
          this.m.clear();
        }
      }
      for (;;)
      {
        i2 = 1;
        break label64;
        i1 = Integer.MIN_VALUE;
        break;
        if (paramab.e == 1)
        {
          i1 = paramab.g + paramab.b;
          break;
        }
        i1 = paramab.f - paramab.b;
        break;
        label506:
        i4 = this.b.getStartAfterPadding();
        break label61;
        label518:
        i6 = 0;
        break label136;
        label524:
        localb = a(paramab);
        break label157;
        label534:
        localb = this.a[i2];
        break label168;
        label546:
        addView(localView, 0);
        break label189;
        label556:
        i2 = localb.b(i4);
        break label222;
        label568:
        if (localLayoutParams.b) {}
        for (i2 = f(i4);; i2 = localb.a(i4))
        {
          i3 = i2 - this.b.getDecoratedMeasurement(localView);
          if ((i6 != 0) && (localLayoutParams.b))
          {
            localFullSpanItem = d(i2);
            localFullSpanItem.b = 1;
            localFullSpanItem.a = i7;
            this.h.addFullSpanItem(localFullSpanItem);
          }
          i5 = i2;
          break;
        }
        if (paramab.e == 1) {
          if (!h()) {
            i2 = 1;
          }
        }
        for (;;)
        {
          if (i2 == 0) {
            break label736;
          }
          localFullSpanItem = this.h.getFullSpanItem(i7);
          if (localFullSpanItem != null) {
            localFullSpanItem.d = true;
          }
          this.E = true;
          break;
          i2 = 0;
          continue;
          if (!i()) {
            i2 = 1;
          } else {
            i2 = 0;
          }
        }
        label736:
        break label309;
        label738:
        i2 = this.c.getEndAfterPadding() - (this.i - 1 - localb.e) * this.k;
        break label350;
        label768:
        if (localLayoutParams.b) {}
        for (i2 = this.c.getStartAfterPadding();; i2 = localb.e * this.k + this.c.getStartAfterPadding())
        {
          i6 = i2 + this.c.getDecoratedMeasurement(localView);
          break;
        }
        label825:
        layoutDecoratedWithMargins(localView, i3, i2, i5, i6);
        break label394;
        label842:
        a(localb, this.l.e, i1);
        break label415;
        label860:
        this.m.set(localb.e, false);
      }
      label876:
      if (i2 == 0) {
        a(paramn, this.l);
      }
      if (this.l.e == -1) {
        i1 = f(this.b.getStartAfterPadding());
      }
      for (i1 = this.b.getStartAfterPadding() - i1; i1 > 0; i1 = g(this.b.getEndAfterPadding()) - this.b.getEndAfterPadding()) {
        return Math.min(paramab.b, i1);
      }
      return 0;
      label967:
      i3 = i2;
    }
  }
  
  private int a(RecyclerView.r paramr)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    af localaf = this.b;
    View localView;
    if (!this.F)
    {
      bool1 = true;
      localView = a(bool1);
      if (this.F) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return al.a(paramr, localaf, localView, b(bool1), this, this.F, this.e);
      bool1 = false;
      break;
    }
  }
  
  private b a(ab paramab)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i2 = -1;
    int i1;
    int i3;
    int i6;
    int i5;
    int i4;
    if (i(paramab.e))
    {
      i1 = this.i - 1;
      i3 = -1;
      if (paramab.e != 1) {
        break label121;
      }
      i6 = this.b.getStartAfterPadding();
      i5 = Integer.MAX_VALUE;
      i4 = i1;
      paramab = (ab)localObject1;
      i1 = i5;
      label59:
      localObject1 = paramab;
      if (i4 == i3) {
        break label192;
      }
      localObject1 = this.a[i4];
      i5 = ((b)localObject1).b(i6);
      if (i5 >= i1) {
        break label198;
      }
      paramab = (ab)localObject1;
      i1 = i5;
    }
    label121:
    label192:
    label195:
    label198:
    for (;;)
    {
      i4 += i2;
      break label59;
      i3 = this.i;
      i1 = 0;
      i2 = 1;
      break;
      i6 = this.b.getEndAfterPadding();
      i5 = Integer.MIN_VALUE;
      i4 = i1;
      paramab = (ab)localObject2;
      i1 = i5;
      localObject1 = paramab;
      if (i4 != i3)
      {
        localObject1 = this.a[i4];
        i5 = ((b)localObject1).a(i6);
        if (i5 <= i1) {
          break label195;
        }
        paramab = (ab)localObject1;
        i1 = i5;
      }
      for (;;)
      {
        i4 += i2;
        break;
        return (b)localObject1;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (i1 < this.i)
    {
      if (this.a[i1].a.isEmpty()) {}
      for (;;)
      {
        i1 += 1;
        break;
        a(this.a[i1], paramInt1, paramInt2);
      }
    }
  }
  
  private void a(RecyclerView.n paramn, int paramInt)
  {
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        if ((this.b.getDecoratedEnd(localView) <= paramInt) && (this.b.getTransformedEndWithDecoration(localView) <= paramInt))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.b) {
            break label118;
          }
          i1 = 0;
          if (i1 >= this.i) {
            break label92;
          }
          if (this.a[i1].a.size() != 1) {
            break label85;
          }
        }
      }
      label85:
      label92:
      label118:
      while (localLayoutParams.a.a.size() == 1)
      {
        for (;;)
        {
          return;
          i1 += 1;
        }
        int i1 = 0;
        while (i1 < this.i)
        {
          this.a[i1].h();
          i1 += 1;
        }
      }
      localLayoutParams.a.h();
      removeAndRecycleView(localView, paramn);
    }
  }
  
  private void a(RecyclerView.n paramn, RecyclerView.r paramr, boolean paramBoolean)
  {
    a locala = this.D;
    if (((this.A != null) || (this.f != -1)) && (paramr.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramn);
      locala.a();
      return;
    }
    if ((!locala.e) || (this.f != -1) || (this.A != null))
    {
      i1 = 1;
      if (i1 != 0)
      {
        locala.a();
        if (this.A == null) {
          break label247;
        }
        a(locala);
      }
    }
    for (;;)
    {
      a(paramr, locala);
      locala.e = true;
      if ((this.A == null) && (this.f == -1) && ((locala.c != this.o) || (c() != this.z)))
      {
        this.h.a();
        locala.d = true;
      }
      if ((getChildCount() <= 0) || ((this.A != null) && (this.A.c >= 1))) {
        break label329;
      }
      if (!locala.d) {
        break label263;
      }
      i1 = 0;
      while (i1 < this.i)
      {
        this.a[i1].e();
        if (locala.b != Integer.MIN_VALUE) {
          this.a[i1].c(locala.b);
        }
        i1 += 1;
      }
      i1 = 0;
      break;
      label247:
      m();
      locala.c = this.e;
    }
    label263:
    if ((i1 != 0) || (this.D.f == null))
    {
      i1 = 0;
      while (i1 < this.i)
      {
        this.a[i1].a(this.e, locala.b);
        i1 += 1;
      }
      this.D.a(this.a);
      label329:
      detachAndScrapAttachedViews(paramn);
      this.l.a = false;
      this.E = false;
      a(this.c.getTotalSpace());
      b(locala.a, paramr);
      if (!locala.c) {
        break label627;
      }
      b(-1);
      a(paramn, this.l, paramr);
      b(1);
      this.l.c = (locala.a + this.l.d);
      a(paramn, this.l, paramr);
      label428:
      n();
      if (getChildCount() > 0)
      {
        if (!this.e) {
          break label682;
        }
        b(paramn, paramr, true);
        c(paramn, paramr, false);
      }
      label460:
      if ((!paramBoolean) || (paramr.isPreLayout())) {
        break label705;
      }
      if ((this.n == 0) || (getChildCount() <= 0) || ((!this.E) && (b() == null))) {
        break label699;
      }
      i1 = 1;
      label502:
      if (i1 == 0) {
        break label705;
      }
      removeCallbacks(this.H);
      if (!a()) {
        break label705;
      }
    }
    label627:
    label682:
    label699:
    label705:
    for (int i1 = 1;; i1 = 0)
    {
      if (paramr.isPreLayout()) {
        this.D.a();
      }
      this.o = locala.c;
      this.z = c();
      if (i1 == 0) {
        break;
      }
      this.D.a();
      a(paramn, paramr, false);
      return;
      i1 = 0;
      while (i1 < this.i)
      {
        b localb = this.a[i1];
        localb.e();
        localb.c(this.D.f[i1]);
        i1 += 1;
      }
      break label329;
      b(1);
      a(paramn, this.l, paramr);
      b(-1);
      this.l.c = (locala.a + this.l.d);
      a(paramn, this.l, paramr);
      break label428;
      c(paramn, paramr, true);
      b(paramn, paramr, false);
      break label460;
      i1 = 0;
      break label502;
    }
  }
  
  private void a(RecyclerView.n paramn, ab paramab)
  {
    if ((!paramab.a) || (paramab.i)) {
      return;
    }
    if (paramab.b == 0)
    {
      if (paramab.e == -1)
      {
        b(paramn, paramab.g);
        return;
      }
      a(paramn, paramab.f);
      return;
    }
    if (paramab.e == -1)
    {
      i1 = paramab.f - e(paramab.f);
      if (i1 < 0) {}
      for (i1 = paramab.g;; i1 = paramab.g - Math.min(i1, paramab.b))
      {
        b(paramn, i1);
        return;
      }
    }
    int i1 = h(paramab.g) - paramab.g;
    if (i1 < 0) {}
    int i2;
    for (i1 = paramab.f;; i1 = Math.min(i1, paramab.b) + i2)
    {
      a(paramn, i1);
      return;
      i2 = paramab.f;
    }
  }
  
  private void a(a parama)
  {
    if (this.A.c > 0) {
      if (this.A.c == this.i)
      {
        int i2 = 0;
        if (i2 < this.i)
        {
          this.a[i2].e();
          int i3 = this.A.d[i2];
          int i1 = i3;
          if (i3 != Integer.MIN_VALUE) {
            if (!this.A.i) {
              break label102;
            }
          }
          label102:
          for (i1 = i3 + this.b.getEndAfterPadding();; i1 = i3 + this.b.getStartAfterPadding())
          {
            this.a[i2].c(i1);
            i2 += 1;
            break;
          }
        }
      }
      else
      {
        this.A.a();
        this.A.a = this.A.b;
      }
    }
    this.z = this.A.j;
    setReverseLayout(this.A.h);
    m();
    if (this.A.a != -1) {
      this.f = this.A.a;
    }
    for (parama.c = this.A.i;; parama.c = this.e)
    {
      if (this.A.e > 1)
      {
        this.h.a = this.A.f;
        this.h.b = this.A.g;
      }
      return;
    }
  }
  
  private void a(b paramb, int paramInt1, int paramInt2)
  {
    int i1 = paramb.getDeletedSize();
    if (paramInt1 == -1) {
      if (i1 + paramb.b() <= paramInt2) {
        this.m.set(paramb.e, false);
      }
    }
    while (paramb.d() - i1 < paramInt2) {
      return;
    }
    this.m.set(paramb.e, false);
  }
  
  private void a(View paramView)
  {
    int i1 = this.i - 1;
    while (i1 >= 0)
    {
      this.a[i1].b(paramView);
      i1 -= 1;
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    calculateItemDecorationsForChild(paramView, this.C);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt1 = a(paramInt1, localLayoutParams.leftMargin + this.C.left, localLayoutParams.rightMargin + this.C.right);
    paramInt2 = a(paramInt2, localLayoutParams.topMargin + this.C.top, localLayoutParams.bottomMargin + this.C.bottom);
    if (paramBoolean) {}
    for (paramBoolean = a(paramView, paramInt1, paramInt2, localLayoutParams);; paramBoolean = b(paramView, paramInt1, paramInt2, localLayoutParams))
    {
      if (paramBoolean) {
        paramView.measure(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams, ab paramab)
  {
    if (paramab.e == 1)
    {
      if (paramLayoutParams.b)
      {
        a(paramView);
        return;
      }
      paramLayoutParams.a.b(paramView);
      return;
    }
    if (paramLayoutParams.b)
    {
      b(paramView);
      return;
    }
    paramLayoutParams.a.a(paramView);
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramLayoutParams.b)
    {
      if (this.j == 1)
      {
        a(paramView, this.B, getChildMeasureSpec(getHeight(), getHeightMode(), 0, paramLayoutParams.height, true), paramBoolean);
        return;
      }
      a(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), 0, paramLayoutParams.width, true), this.B, paramBoolean);
      return;
    }
    if (this.j == 1)
    {
      a(paramView, getChildMeasureSpec(this.k, getWidthMode(), 0, paramLayoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), 0, paramLayoutParams.height, true), paramBoolean);
      return;
    }
    a(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), 0, paramLayoutParams.width, true), getChildMeasureSpec(this.k, getHeightMode(), 0, paramLayoutParams.height, false), paramBoolean);
  }
  
  private boolean a(b paramb)
  {
    boolean bool = true;
    if (this.e)
    {
      if (paramb.d() < this.b.getEndAfterPadding()) {
        return !paramb.c((View)paramb.a.get(paramb.a.size() - 1)).b;
      }
    }
    else if (paramb.b() > this.b.getStartAfterPadding())
    {
      if (!paramb.c((View)paramb.a.get(0)).b) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return false;
  }
  
  private int b(RecyclerView.r paramr)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    af localaf = this.b;
    View localView;
    if (!this.F)
    {
      bool1 = true;
      localView = a(bool1);
      if (this.F) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return al.a(paramr, localaf, localView, b(bool1), this, this.F);
      bool1 = false;
      break;
    }
  }
  
  private void b(int paramInt)
  {
    int i1 = 1;
    this.l.e = paramInt;
    ab localab = this.l;
    boolean bool2 = this.e;
    boolean bool1;
    if (paramInt == -1)
    {
      bool1 = true;
      if (bool2 != bool1) {
        break label49;
      }
    }
    label49:
    for (paramInt = i1;; paramInt = -1)
    {
      localab.d = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i3;
    int i2;
    int i1;
    if (this.e)
    {
      i3 = j();
      if (paramInt3 != 8) {
        break label104;
      }
      if (paramInt1 >= paramInt2) {
        break label93;
      }
      i2 = paramInt2 + 1;
      i1 = paramInt1;
      label32:
      this.h.b(i1);
      switch (paramInt3)
      {
      default: 
        label76:
        if (i2 > i3) {
          break;
        }
      }
    }
    for (;;)
    {
      return;
      i3 = k();
      break;
      label93:
      i2 = paramInt1 + 1;
      i1 = paramInt2;
      break label32;
      label104:
      i2 = paramInt1 + paramInt2;
      i1 = paramInt1;
      break label32;
      this.h.b(paramInt1, paramInt2);
      break label76;
      this.h.a(paramInt1, paramInt2);
      break label76;
      this.h.a(paramInt1, 1);
      this.h.b(paramInt2, 1);
      break label76;
      if (this.e) {}
      for (paramInt1 = k(); i1 <= paramInt1; paramInt1 = j())
      {
        requestLayout();
        return;
      }
    }
  }
  
  private void b(int paramInt, RecyclerView.r paramr)
  {
    boolean bool2 = false;
    this.l.b = 0;
    this.l.c = paramInt;
    int i1;
    boolean bool1;
    if (isSmoothScrolling())
    {
      i1 = paramr.getTargetScrollPosition();
      if (i1 != -1)
      {
        boolean bool3 = this.e;
        if (i1 < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label171;
          }
          paramInt = this.b.getTotalSpace();
          i1 = 0;
        }
      }
    }
    for (;;)
    {
      label67:
      if (getClipToPadding())
      {
        this.l.f = (this.b.getStartAfterPadding() - i1);
        this.l.g = (paramInt + this.b.getEndAfterPadding());
      }
      for (;;)
      {
        this.l.h = false;
        this.l.a = true;
        paramr = this.l;
        bool1 = bool2;
        if (this.b.getMode() == 0)
        {
          bool1 = bool2;
          if (this.b.getEnd() == 0) {
            bool1 = true;
          }
        }
        paramr.i = bool1;
        return;
        bool1 = false;
        break;
        label171:
        i1 = this.b.getTotalSpace();
        paramInt = 0;
        break label67;
        this.l.g = (paramInt + this.b.getEnd());
        this.l.f = (-i1);
      }
      paramInt = 0;
      i1 = 0;
    }
  }
  
  private void b(RecyclerView.n paramn, int paramInt)
  {
    int i1 = getChildCount() - 1;
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (i1 >= 0)
      {
        localView = getChildAt(i1);
        if ((this.b.getDecoratedStart(localView) >= paramInt) && (this.b.getTransformedStartWithDecoration(localView) >= paramInt))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.b) {
            break label132;
          }
          i2 = 0;
          if (i2 >= this.i) {
            break label101;
          }
          if (this.a[i2].a.size() != 1) {
            break label92;
          }
        }
      }
      label92:
      label101:
      label132:
      while (localLayoutParams.a.a.size() == 1)
      {
        for (;;)
        {
          return;
          i2 += 1;
        }
        int i2 = 0;
        while (i2 < this.i)
        {
          this.a[i2].g();
          i2 += 1;
        }
      }
      localLayoutParams.a.g();
      removeAndRecycleView(localView, paramn);
      i1 -= 1;
    }
  }
  
  private void b(RecyclerView.n paramn, RecyclerView.r paramr, boolean paramBoolean)
  {
    int i1 = g(Integer.MIN_VALUE);
    if (i1 == Integer.MIN_VALUE) {}
    do
    {
      do
      {
        return;
        i1 = this.b.getEndAfterPadding() - i1;
      } while (i1 <= 0);
      i1 -= -a(-i1, paramn, paramr);
    } while ((!paramBoolean) || (i1 <= 0));
    this.b.offsetChildren(i1);
  }
  
  private void b(View paramView)
  {
    int i1 = this.i - 1;
    while (i1 >= 0)
    {
      this.a[i1].a(paramView);
      i1 -= 1;
    }
  }
  
  private int c(RecyclerView.r paramr)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    af localaf = this.b;
    View localView;
    if (!this.F)
    {
      bool1 = true;
      localView = a(bool1);
      if (this.F) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return al.b(paramr, localaf, localView, b(bool1), this, this.F);
      bool1 = false;
      break;
    }
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem c(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.c = new int[this.i];
    int i1 = 0;
    while (i1 < this.i)
    {
      localFullSpanItem.c[i1] = (paramInt - this.a[i1].b(paramInt));
      i1 += 1;
    }
    return localFullSpanItem;
  }
  
  private void c(RecyclerView.n paramn, RecyclerView.r paramr, boolean paramBoolean)
  {
    int i1 = f(Integer.MAX_VALUE);
    if (i1 == Integer.MAX_VALUE) {}
    do
    {
      do
      {
        return;
        i1 -= this.b.getStartAfterPadding();
      } while (i1 <= 0);
      i1 -= a(i1, paramn, paramr);
    } while ((!paramBoolean) || (i1 <= 0));
    this.b.offsetChildren(-i1);
  }
  
  private boolean c(RecyclerView.r paramr, a parama)
  {
    if (this.o) {}
    for (int i1 = l(paramr.getItemCount());; i1 = k(paramr.getItemCount()))
    {
      parama.a = i1;
      parama.b = Integer.MIN_VALUE;
      return true;
    }
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem d(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.c = new int[this.i];
    int i1 = 0;
    while (i1 < this.i)
    {
      localFullSpanItem.c[i1] = (this.a[i1].a(paramInt) - paramInt);
      i1 += 1;
    }
    return localFullSpanItem;
  }
  
  private int e(int paramInt)
  {
    int i2 = this.a[0].a(paramInt);
    int i1 = 1;
    while (i1 < this.i)
    {
      int i4 = this.a[i1].a(paramInt);
      int i3 = i2;
      if (i4 > i2) {
        i3 = i4;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  private int f(int paramInt)
  {
    int i2 = this.a[0].a(paramInt);
    int i1 = 1;
    while (i1 < this.i)
    {
      int i4 = this.a[i1].a(paramInt);
      int i3 = i2;
      if (i4 < i2) {
        i3 = i4;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  private int g(int paramInt)
  {
    int i2 = this.a[0].b(paramInt);
    int i1 = 1;
    while (i1 < this.i)
    {
      int i4 = this.a[i1].b(paramInt);
      int i3 = i2;
      if (i4 > i2) {
        i3 = i4;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  private int h(int paramInt)
  {
    int i2 = this.a[0].b(paramInt);
    int i1 = 1;
    while (i1 < this.i)
    {
      int i4 = this.a[i1].b(paramInt);
      int i3 = i2;
      if (i4 < i2) {
        i3 = i4;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  private boolean i(int paramInt)
  {
    int i1;
    if (this.j == 0) {
      if (paramInt == -1)
      {
        i1 = 1;
        if (i1 == this.e) {
          break label29;
        }
      }
    }
    label29:
    label63:
    label66:
    for (;;)
    {
      return true;
      i1 = 0;
      break;
      return false;
      if (paramInt == -1)
      {
        i1 = 1;
        if (i1 != this.e) {
          break label63;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == c()) {
          break label66;
        }
        return false;
        i1 = 0;
        break;
      }
    }
  }
  
  private int j(int paramInt)
  {
    int i1 = -1;
    if (getChildCount() == 0)
    {
      if (this.e) {
        return 1;
      }
      return -1;
    }
    int i2;
    if (paramInt < k())
    {
      i2 = 1;
      if (i2 == this.e) {
        break label47;
      }
    }
    label47:
    for (paramInt = i1;; paramInt = 1)
    {
      return paramInt;
      i2 = 0;
      break;
    }
  }
  
  private int k(int paramInt)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = getPosition(getChildAt(i1));
      if ((i3 >= 0) && (i3 < paramInt)) {
        return i3;
      }
      i1 += 1;
    }
    return 0;
  }
  
  private int l(int paramInt)
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      int i2 = getPosition(getChildAt(i1));
      if ((i2 >= 0) && (i2 < paramInt)) {
        return i2;
      }
      i1 -= 1;
    }
    return 0;
  }
  
  private void l()
  {
    this.b = af.createOrientationHelper(this, this.j);
    this.c = af.createOrientationHelper(this, 1 - this.j);
  }
  
  private int m(int paramInt)
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
              } while (this.j == 1);
              paramInt = i1;
            } while (!c());
            return 1;
            if (this.j == 1) {
              return 1;
            }
            paramInt = i1;
          } while (c());
          return 1;
          paramInt = i1;
        } while (this.j == 1);
        return Integer.MIN_VALUE;
        paramInt = i2;
        if (this.j == 1) {
          paramInt = 1;
        }
        return paramInt;
        paramInt = i1;
      } while (this.j == 0);
      return Integer.MIN_VALUE;
    }
    if (this.j == 0) {}
    for (paramInt = i3;; paramInt = Integer.MIN_VALUE) {
      return paramInt;
    }
  }
  
  private void m()
  {
    boolean bool = true;
    if ((this.j == 1) || (!c()))
    {
      this.e = this.d;
      return;
    }
    if (!this.d) {}
    for (;;)
    {
      this.e = bool;
      return;
      bool = false;
    }
  }
  
  private void n()
  {
    if (this.c.getMode() == 1073741824) {
      return;
    }
    float f1 = 0.0F;
    int i3 = getChildCount();
    int i1 = 0;
    View localView;
    float f2;
    while (i1 < i3)
    {
      localView = getChildAt(i1);
      f2 = this.c.getDecoratedMeasurement(localView);
      if (f2 < f1)
      {
        label53:
        i1 += 1;
      }
      else
      {
        if (!((LayoutParams)localView.getLayoutParams()).isFullSpan()) {
          break label319;
        }
        f2 = 1.0F * f2 / this.i;
      }
    }
    label155:
    label193:
    label319:
    for (;;)
    {
      f1 = Math.max(f1, f2);
      break label53;
      int i4 = this.k;
      int i2 = Math.round(this.i * f1);
      i1 = i2;
      if (this.c.getMode() == Integer.MIN_VALUE) {
        i1 = Math.min(i2, this.c.getTotalSpace());
      }
      a(i1);
      if (this.k == i4) {
        break;
      }
      i1 = 0;
      LayoutParams localLayoutParams;
      if (i1 < i3)
      {
        localView = getChildAt(i1);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.b) {
          break label193;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label155;
        break;
        if ((c()) && (this.j == 1))
        {
          localView.offsetLeftAndRight(-(this.i - 1 - localLayoutParams.a.e) * this.k - -(this.i - 1 - localLayoutParams.a.e) * i4);
        }
        else
        {
          i2 = localLayoutParams.a.e * this.k;
          int i5 = localLayoutParams.a.e * i4;
          if (this.j == 1) {
            localView.offsetLeftAndRight(i2 - i5);
          } else {
            localView.offsetTopAndBottom(i2 - i5);
          }
        }
      }
    }
  }
  
  int a(int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    a(paramInt, paramr);
    int i1 = a(paramn, this.l, paramr);
    if (this.l.b < i1) {}
    for (;;)
    {
      this.b.offsetChildren(-paramInt);
      this.o = this.e;
      this.l.b = 0;
      a(paramn, this.l);
      return paramInt;
      if (paramInt < 0) {
        paramInt = -i1;
      } else {
        paramInt = i1;
      }
    }
  }
  
  View a(boolean paramBoolean)
  {
    int i2 = this.b.getStartAfterPadding();
    int i3 = this.b.getEndAfterPadding();
    int i4 = getChildCount();
    int i1 = 0;
    Object localObject1 = null;
    if (i1 < i4)
    {
      View localView = getChildAt(i1);
      int i5 = this.b.getDecoratedStart(localView);
      Object localObject2 = localObject1;
      if (this.b.getDecoratedEnd(localView) > i2)
      {
        if (i5 < i3) {
          break label91;
        }
        localObject2 = localObject1;
      }
      for (;;)
      {
        i1 += 1;
        localObject1 = localObject2;
        break;
        label91:
        if ((i5 >= i2) || (!paramBoolean)) {
          return localView;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localView;
        }
      }
    }
    return (View)localObject1;
  }
  
  void a(int paramInt)
  {
    this.k = (paramInt / this.i);
    this.B = View.MeasureSpec.makeMeasureSpec(paramInt, this.c.getMode());
  }
  
  void a(int paramInt, RecyclerView.r paramr)
  {
    int i2;
    int i1;
    if (paramInt > 0)
    {
      i2 = j();
      i1 = 1;
    }
    for (;;)
    {
      this.l.a = true;
      b(i2, paramr);
      b(i1);
      this.l.c = (this.l.d + i2);
      this.l.b = Math.abs(paramInt);
      return;
      i1 = -1;
      i2 = k();
    }
  }
  
  void a(RecyclerView.r paramr, a parama)
  {
    if (b(paramr, parama)) {}
    while (c(paramr, parama)) {
      return;
    }
    parama.b();
    parama.a = 0;
  }
  
  boolean a()
  {
    if ((getChildCount() == 0) || (this.n == 0) || (!isAttachedToWindow())) {
      return false;
    }
    int i2;
    if (this.e) {
      i2 = j();
    }
    for (int i1 = k(); (i2 == 0) && (b() != null); i1 = j())
    {
      this.h.a();
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      return true;
      i2 = k();
    }
    if (!this.E) {
      return false;
    }
    if (this.e) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int i3 = -1;; i3 = 1)
    {
      localFullSpanItem1 = this.h.getFirstFullSpanItemInRange(i2, i1 + 1, i3, true);
      if (localFullSpanItem1 != null) {
        break;
      }
      this.E = false;
      this.h.a(i1 + 1);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.h.getFirstFullSpanItemInRange(i2, localFullSpanItem1.a, i3 * -1, true);
    if (localFullSpanItem2 == null) {
      this.h.a(localFullSpanItem1.a);
    }
    for (;;)
    {
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      return true;
      this.h.a(localFullSpanItem2.a + 1);
    }
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.A == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  View b()
  {
    int i1 = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.i);
    localBitSet.set(0, this.i, true);
    int i2;
    int i3;
    if ((this.j == 1) && (c()))
    {
      i2 = 1;
      if (!this.e) {
        break label128;
      }
      i3 = -1;
      label57:
      if (i1 >= i3) {
        break label137;
      }
    }
    int i5;
    View localView;
    LayoutParams localLayoutParams;
    label128:
    label137:
    for (int i4 = 1;; i4 = -1)
    {
      i5 = i1;
      if (i5 == i3) {
        break label343;
      }
      localView = getChildAt(i5);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localBitSet.get(localLayoutParams.a.e)) {
        break label156;
      }
      if (!a(localLayoutParams.a)) {
        break label143;
      }
      return localView;
      i2 = -1;
      break;
      i3 = i1 + 1;
      i1 = 0;
      break label57;
    }
    label143:
    localBitSet.clear(localLayoutParams.a.e);
    label156:
    if (localLayoutParams.b) {}
    label275:
    label337:
    label341:
    label343:
    label345:
    label348:
    for (;;)
    {
      i5 += i4;
      break;
      if (i5 + i4 != i3)
      {
        Object localObject = getChildAt(i5 + i4);
        int i6;
        if (this.e)
        {
          i1 = this.b.getDecoratedEnd(localView);
          i6 = this.b.getDecoratedEnd((View)localObject);
          if (i1 < i6) {
            return localView;
          }
          if (i1 != i6) {
            break label345;
          }
          i1 = 1;
        }
        for (;;)
        {
          if (i1 == 0) {
            break label348;
          }
          localObject = (LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams.a.e - ((LayoutParams)localObject).a.e < 0)
          {
            i1 = 1;
            if (i2 >= 0) {
              break label337;
            }
          }
          for (i6 = 1;; i6 = 0)
          {
            if (i1 == i6) {
              break label341;
            }
            return localView;
            i1 = this.b.getDecoratedStart(localView);
            i6 = this.b.getDecoratedStart((View)localObject);
            if (i1 > i6) {
              return localView;
            }
            if (i1 != i6) {
              break label345;
            }
            i1 = 1;
            break;
            i1 = 0;
            break label275;
          }
          break;
          return null;
          i1 = 0;
        }
      }
    }
  }
  
  View b(boolean paramBoolean)
  {
    int i2 = this.b.getStartAfterPadding();
    int i3 = this.b.getEndAfterPadding();
    int i1 = getChildCount() - 1;
    Object localObject1 = null;
    if (i1 >= 0)
    {
      View localView = getChildAt(i1);
      int i4 = this.b.getDecoratedStart(localView);
      int i5 = this.b.getDecoratedEnd(localView);
      Object localObject2 = localObject1;
      if (i5 > i2)
      {
        if (i4 < i3) {
          break label92;
        }
        localObject2 = localObject1;
      }
      for (;;)
      {
        i1 -= 1;
        localObject1 = localObject2;
        break;
        label92:
        if ((i5 <= i3) || (!paramBoolean)) {
          return localView;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localView;
        }
      }
    }
    return (View)localObject1;
  }
  
  boolean b(RecyclerView.r paramr, a parama)
  {
    boolean bool = false;
    if ((paramr.isPreLayout()) || (this.f == -1)) {
      return false;
    }
    if ((this.f < 0) || (this.f >= paramr.getItemCount()))
    {
      this.f = -1;
      this.g = Integer.MIN_VALUE;
      return false;
    }
    if ((this.A == null) || (this.A.a == -1) || (this.A.c < 1))
    {
      paramr = findViewByPosition(this.f);
      if (paramr != null)
      {
        if (this.e) {}
        for (int i1 = j();; i1 = k())
        {
          parama.a = i1;
          if (this.g == Integer.MIN_VALUE) {
            break label188;
          }
          if (!parama.c) {
            break;
          }
          parama.b = (this.b.getEndAfterPadding() - this.g - this.b.getDecoratedEnd(paramr));
          return true;
        }
        parama.b = (this.b.getStartAfterPadding() + this.g - this.b.getDecoratedStart(paramr));
        return true;
        label188:
        if (this.b.getDecoratedMeasurement(paramr) > this.b.getTotalSpace())
        {
          if (parama.c) {}
          for (i1 = this.b.getEndAfterPadding();; i1 = this.b.getStartAfterPadding())
          {
            parama.b = i1;
            return true;
          }
        }
        i1 = this.b.getDecoratedStart(paramr) - this.b.getStartAfterPadding();
        if (i1 < 0)
        {
          parama.b = (-i1);
          return true;
        }
        i1 = this.b.getEndAfterPadding() - this.b.getDecoratedEnd(paramr);
        if (i1 < 0)
        {
          parama.b = i1;
          return true;
        }
        parama.b = Integer.MIN_VALUE;
        return true;
      }
      parama.a = this.f;
      if (this.g == Integer.MIN_VALUE)
      {
        if (j(parama.a) == 1) {
          bool = true;
        }
        parama.c = bool;
        parama.b();
      }
      for (;;)
      {
        parama.d = true;
        return true;
        parama.a(this.g);
      }
    }
    parama.b = Integer.MIN_VALUE;
    parama.a = this.f;
    return true;
  }
  
  boolean c()
  {
    return getLayoutDirection() == 1;
  }
  
  public boolean canScrollHorizontally()
  {
    return this.j == 0;
  }
  
  public boolean canScrollVertically()
  {
    return this.j == 1;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.r paramr, RecyclerView.h.a parama)
  {
    int i3 = 0;
    if (this.j == 0) {
      if ((getChildCount() != 0) && (paramInt1 != 0)) {
        break label27;
      }
    }
    for (;;)
    {
      return;
      paramInt1 = paramInt2;
      break;
      label27:
      a(paramInt1, paramr);
      if ((this.G == null) || (this.G.length < this.i)) {
        this.G = new int[this.i];
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if (paramInt2 < this.i)
      {
        if (this.l.d == -1) {}
        for (int i2 = this.l.f - this.a[paramInt2].a(this.l.f);; i2 = this.a[paramInt2].b(this.l.g) - this.l.g)
        {
          int i1 = paramInt1;
          if (i2 >= 0)
          {
            this.G[paramInt1] = i2;
            i1 = paramInt1 + 1;
          }
          paramInt2 += 1;
          paramInt1 = i1;
          break;
        }
      }
      Arrays.sort(this.G, 0, paramInt1);
      paramInt2 = i3;
      while ((paramInt2 < paramInt1) && (this.l.a(paramr)))
      {
        parama.addPosition(this.l.c, this.G[paramInt2]);
        ab localab = this.l;
        localab.c += this.l.d;
        paramInt2 += 1;
      }
    }
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.r paramr)
  {
    return b(paramr);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.r paramr)
  {
    return a(paramr);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.r paramr)
  {
    return c(paramr);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    paramInt = j(paramInt);
    PointF localPointF = new PointF();
    if (paramInt == 0) {
      return null;
    }
    if (this.j == 0)
    {
      localPointF.x = paramInt;
      localPointF.y = 0.0F;
      return localPointF;
    }
    localPointF.x = 0.0F;
    localPointF.y = paramInt;
    return localPointF;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.r paramr)
  {
    return b(paramr);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.r paramr)
  {
    return a(paramr);
  }
  
  public int computeVerticalScrollRange(RecyclerView.r paramr)
  {
    return c(paramr);
  }
  
  int d()
  {
    if (this.e) {}
    for (View localView = b(true); localView == null; localView = a(true)) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int[] findFirstCompletelyVisibleItemPositions(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[this.i];
    }
    do
    {
      int i1 = 0;
      while (i1 < this.i)
      {
        arrayOfInt[i1] = this.a[i1].findFirstCompletelyVisibleItemPosition();
        i1 += 1;
      }
      arrayOfInt = paramArrayOfInt;
    } while (paramArrayOfInt.length >= this.i);
    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.i + ", array size:" + paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public int[] findFirstVisibleItemPositions(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[this.i];
    }
    do
    {
      int i1 = 0;
      while (i1 < this.i)
      {
        arrayOfInt[i1] = this.a[i1].findFirstVisibleItemPosition();
        i1 += 1;
      }
      arrayOfInt = paramArrayOfInt;
    } while (paramArrayOfInt.length >= this.i);
    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.i + ", array size:" + paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public int[] findLastCompletelyVisibleItemPositions(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[this.i];
    }
    do
    {
      int i1 = 0;
      while (i1 < this.i)
      {
        arrayOfInt[i1] = this.a[i1].findLastCompletelyVisibleItemPosition();
        i1 += 1;
      }
      arrayOfInt = paramArrayOfInt;
    } while (paramArrayOfInt.length >= this.i);
    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.i + ", array size:" + paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public int[] findLastVisibleItemPositions(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[this.i];
    }
    do
    {
      int i1 = 0;
      while (i1 < this.i)
      {
        arrayOfInt[i1] = this.a[i1].findLastVisibleItemPosition();
        i1 += 1;
      }
      arrayOfInt = paramArrayOfInt;
    } while (paramArrayOfInt.length >= this.i);
    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.i + ", array size:" + paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (this.j == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getColumnCountForAccessibility(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    if (this.j == 1) {
      return this.i;
    }
    return super.getColumnCountForAccessibility(paramn, paramr);
  }
  
  public int getGapStrategy()
  {
    return this.n;
  }
  
  public int getOrientation()
  {
    return this.j;
  }
  
  public boolean getReverseLayout()
  {
    return this.d;
  }
  
  public int getRowCountForAccessibility(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    if (this.j == 0) {
      return this.i;
    }
    return super.getRowCountForAccessibility(paramn, paramr);
  }
  
  public int getSpanCount()
  {
    return this.i;
  }
  
  boolean h()
  {
    boolean bool2 = true;
    int i2 = this.a[0].b(Integer.MIN_VALUE);
    int i1 = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.i)
      {
        if (this.a[i1].b(Integer.MIN_VALUE) != i2) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  boolean i()
  {
    boolean bool2 = true;
    int i2 = this.a[0].a(Integer.MIN_VALUE);
    int i1 = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.i)
      {
        if (this.a[i1].a(Integer.MIN_VALUE) != i2) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public void invalidateSpanAssignments()
  {
    this.h.a();
    requestLayout();
  }
  
  int j()
  {
    int i1 = getChildCount();
    if (i1 == 0) {
      return 0;
    }
    return getPosition(getChildAt(i1 - 1));
  }
  
  int k()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return getPosition(getChildAt(0));
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    super.offsetChildrenHorizontal(paramInt);
    int i1 = 0;
    while (i1 < this.i)
    {
      this.a[i1].d(paramInt);
      i1 += 1;
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    super.offsetChildrenVertical(paramInt);
    int i1 = 0;
    while (i1 < this.i)
    {
      this.a[i1].d(paramInt);
      i1 += 1;
    }
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    removeCallbacks(this.H);
    int i1 = 0;
    while (i1 < this.i)
    {
      this.a[i1].e();
      i1 += 1;
    }
    paramRecyclerView.requestLayout();
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
  {
    int i2 = 0;
    if (getChildCount() == 0)
    {
      paramView = null;
      return paramView;
    }
    View localView = findContainingItemView(paramView);
    if (localView == null) {
      return null;
    }
    m();
    int i3 = m(paramInt);
    if (i3 == Integer.MIN_VALUE) {
      return null;
    }
    paramView = (LayoutParams)localView.getLayoutParams();
    boolean bool = paramView.b;
    b localb = paramView.a;
    if (i3 == 1) {}
    for (paramInt = j();; paramInt = k())
    {
      b(paramInt, paramr);
      b(i3);
      this.l.c = (this.l.d + paramInt);
      this.l.b = ((int)(0.33333334F * this.b.getTotalSpace()));
      this.l.h = true;
      this.l.a = false;
      a(paramn, this.l, paramr);
      this.o = this.e;
      if (bool) {
        break;
      }
      paramView = localb.getFocusableViewAfter(paramInt, i3);
      if ((paramView == null) || (paramView == localView)) {
        break;
      }
      return paramView;
    }
    if (i(i3))
    {
      i1 = this.i - 1;
      while (i1 >= 0)
      {
        paramView = this.a[i1].getFocusableViewAfter(paramInt, i3);
        if ((paramView != null) && (paramView != localView)) {
          return paramView;
        }
        i1 -= 1;
      }
    }
    int i1 = 0;
    while (i1 < this.i)
    {
      paramView = this.a[i1].getFocusableViewAfter(paramInt, i3);
      if ((paramView != null) && (paramView != localView)) {
        return paramView;
      }
      i1 += 1;
    }
    if (!this.d)
    {
      paramInt = 1;
      label312:
      if (i3 != -1) {
        break label414;
      }
      i1 = 1;
      label321:
      if (paramInt != i1) {
        break label420;
      }
      paramInt = 1;
      label329:
      if (!bool) {
        if (paramInt == 0) {
          break label425;
        }
      }
    }
    label414:
    label420:
    label425:
    for (i1 = localb.findFirstPartiallyVisibleItemPosition();; i1 = localb.findLastPartiallyVisibleItemPosition())
    {
      paramn = findViewByPosition(i1);
      if (paramn != null)
      {
        paramView = paramn;
        if (paramn != localView) {
          break;
        }
      }
      i1 = i2;
      if (!i(i3)) {
        break label491;
      }
      i1 = this.i - 1;
      for (;;)
      {
        if (i1 < 0) {
          break label550;
        }
        if (i1 != localb.e) {
          break;
        }
        i1 -= 1;
      }
      paramInt = 0;
      break label312;
      i1 = 0;
      break label321;
      paramInt = 0;
      break label329;
    }
    if (paramInt != 0) {}
    for (i2 = this.a[i1].findFirstPartiallyVisibleItemPosition();; i2 = this.a[i1].findLastPartiallyVisibleItemPosition())
    {
      paramView = findViewByPosition(i2);
      if ((paramView == null) || (paramView == localView)) {
        break;
      }
      return paramView;
    }
    i1 += 1;
    label491:
    if (i1 < this.i)
    {
      if (paramInt != 0) {}
      for (i2 = this.a[i1].findFirstPartiallyVisibleItemPosition();; i2 = this.a[i1].findLastPartiallyVisibleItemPosition())
      {
        paramView = findViewByPosition(i2);
        if ((paramView == null) || (paramView == localView)) {
          break;
        }
        return paramView;
      }
    }
    label550:
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    View localView1;
    View localView2;
    if (getChildCount() > 0)
    {
      localView1 = a(false);
      localView2 = b(false);
      if ((localView1 != null) && (localView2 != null)) {}
    }
    else
    {
      return;
    }
    int i1 = getPosition(localView1);
    int i2 = getPosition(localView2);
    if (i1 < i2)
    {
      paramAccessibilityEvent.setFromIndex(i1);
      paramAccessibilityEvent.setToIndex(i2);
      return;
    }
    paramAccessibilityEvent.setFromIndex(i2);
    paramAccessibilityEvent.setToIndex(i1);
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n paramn, RecyclerView.r paramr, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    paramn = paramView.getLayoutParams();
    if (!(paramn instanceof LayoutParams))
    {
      super.a(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    paramn = (LayoutParams)paramn;
    if (this.j == 0)
    {
      i2 = paramn.getSpanIndex();
      if (paramn.b) {}
      for (i1 = this.i;; i1 = 1)
      {
        paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i2, i1, -1, -1, paramn.b, false));
        return;
      }
    }
    int i2 = paramn.getSpanIndex();
    if (paramn.b) {}
    for (int i1 = this.i;; i1 = 1)
    {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, i2, i1, paramn.b, false));
      return;
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2, 1);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.h.a();
    requestLayout();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, 8);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2, 2);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    b(paramInt1, paramInt2, 4);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    a(paramn, paramr, true);
  }
  
  public void onLayoutCompleted(RecyclerView.r paramr)
  {
    super.onLayoutCompleted(paramr);
    this.f = -1;
    this.g = Integer.MIN_VALUE;
    this.A = null;
    this.D.a();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.A = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.A != null) {
      return new SavedState(this.A);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.h = this.d;
    localSavedState.i = this.o;
    localSavedState.j = this.z;
    int i1;
    label126:
    int i2;
    label163:
    int i3;
    if ((this.h != null) && (this.h.a != null))
    {
      localSavedState.f = this.h.a;
      localSavedState.e = localSavedState.f.length;
      localSavedState.g = this.h.b;
      if (getChildCount() <= 0) {
        break label273;
      }
      if (!this.o) {
        break label232;
      }
      i1 = j();
      localSavedState.a = i1;
      localSavedState.b = d();
      localSavedState.c = this.i;
      localSavedState.d = new int[this.i];
      i2 = 0;
      if (i2 >= this.i) {
        break label291;
      }
      if (!this.o) {
        break label240;
      }
      i3 = this.a[i2].b(Integer.MIN_VALUE);
      i1 = i3;
      if (i3 != Integer.MIN_VALUE) {
        i1 = i3 - this.b.getEndAfterPadding();
      }
    }
    for (;;)
    {
      localSavedState.d[i2] = i1;
      i2 += 1;
      break label163;
      localSavedState.e = 0;
      break;
      label232:
      i1 = k();
      break label126;
      label240:
      i3 = this.a[i2].a(Integer.MIN_VALUE);
      i1 = i3;
      if (i3 != Integer.MIN_VALUE) {
        i1 = i3 - this.b.getStartAfterPadding();
      }
    }
    label273:
    localSavedState.a = -1;
    localSavedState.b = -1;
    localSavedState.c = 0;
    label291:
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      a();
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
  {
    return a(paramInt, paramn, paramr);
  }
  
  public void scrollToPosition(int paramInt)
  {
    if ((this.A != null) && (this.A.a != paramInt)) {
      this.A.b();
    }
    this.f = paramInt;
    this.g = Integer.MIN_VALUE;
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    if (this.A != null) {
      this.A.b();
    }
    this.f = paramInt1;
    this.g = paramInt2;
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
  {
    return a(paramInt, paramn, paramr);
  }
  
  public void setGapStrategy(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.n) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 2)) {
      throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
    }
    this.n = paramInt;
    if (this.n != 0) {}
    for (boolean bool = true;; bool = false)
    {
      setAutoMeasureEnabled(bool);
      requestLayout();
      return;
    }
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight() + i1;
    int i3 = getPaddingTop() + getPaddingBottom();
    if (this.j == 1)
    {
      i1 = chooseSize(paramInt2, i3 + paramRect.height(), getMinimumHeight());
      paramInt2 = chooseSize(paramInt1, i2 + this.k * this.i, getMinimumWidth());
      paramInt1 = i1;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i1 = chooseSize(paramInt1, i2 + paramRect.width(), getMinimumWidth());
      paramInt1 = chooseSize(paramInt2, i3 + this.k * this.i, getMinimumHeight());
      paramInt2 = i1;
    }
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.j) {
      return;
    }
    this.j = paramInt;
    af localaf = this.b;
    this.b = this.c;
    this.c = localaf;
    requestLayout();
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if ((this.A != null) && (this.A.h != paramBoolean)) {
      this.A.h = paramBoolean;
    }
    this.d = paramBoolean;
    requestLayout();
  }
  
  public void setSpanCount(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt != this.i)
    {
      invalidateSpanAssignments();
      this.i = paramInt;
      this.m = new BitSet(this.i);
      this.a = new b[this.i];
      paramInt = 0;
      while (paramInt < this.i)
      {
        this.a[paramInt] = new b(paramInt);
        paramInt += 1;
      }
      requestLayout();
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.r paramr, int paramInt)
  {
    paramRecyclerView = new ac(paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return this.A == null;
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    StaggeredGridLayoutManager.b a;
    boolean b;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public final int getSpanIndex()
    {
      if (this.a == null) {
        return -1;
      }
      return this.a.e;
    }
    
    public boolean isFullSpan()
    {
      return this.b;
    }
    
    public void setFullSpan(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
  }
  
  static class LazySpanLookup
  {
    int[] a;
    List<FullSpanItem> b;
    
    private void c(int paramInt1, int paramInt2)
    {
      if (this.b == null) {
        return;
      }
      int i = this.b.size() - 1;
      label20:
      FullSpanItem localFullSpanItem;
      if (i >= 0)
      {
        localFullSpanItem = (FullSpanItem)this.b.get(i);
        if (localFullSpanItem.a >= paramInt1) {
          break label55;
        }
      }
      for (;;)
      {
        i -= 1;
        break label20;
        break;
        label55:
        if (localFullSpanItem.a < paramInt1 + paramInt2) {
          this.b.remove(i);
        } else {
          localFullSpanItem.a -= paramInt2;
        }
      }
    }
    
    private void d(int paramInt1, int paramInt2)
    {
      if (this.b == null) {
        return;
      }
      int i = this.b.size() - 1;
      label20:
      FullSpanItem localFullSpanItem;
      if (i >= 0)
      {
        localFullSpanItem = (FullSpanItem)this.b.get(i);
        if (localFullSpanItem.a >= paramInt1) {
          break label55;
        }
      }
      for (;;)
      {
        i -= 1;
        break label20;
        break;
        label55:
        localFullSpanItem.a += paramInt2;
      }
    }
    
    private int f(int paramInt)
    {
      if (this.b == null) {
        return -1;
      }
      FullSpanItem localFullSpanItem = getFullSpanItem(paramInt);
      if (localFullSpanItem != null) {
        this.b.remove(localFullSpanItem);
      }
      int j = this.b.size();
      int i = 0;
      if (i < j) {
        if (((FullSpanItem)this.b.get(i)).a < paramInt) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          localFullSpanItem = (FullSpanItem)this.b.get(i);
          this.b.remove(i);
          return localFullSpanItem.a;
          i += 1;
          break;
        }
        return -1;
        i = -1;
      }
    }
    
    int a(int paramInt)
    {
      if (this.b != null)
      {
        int i = this.b.size() - 1;
        while (i >= 0)
        {
          if (((FullSpanItem)this.b.get(i)).a >= paramInt) {
            this.b.remove(i);
          }
          i -= 1;
        }
      }
      return b(paramInt);
    }
    
    void a()
    {
      if (this.a != null) {
        Arrays.fill(this.a, -1);
      }
      this.b = null;
    }
    
    void a(int paramInt1, int paramInt2)
    {
      if ((this.a == null) || (paramInt1 >= this.a.length)) {
        return;
      }
      e(paramInt1 + paramInt2);
      System.arraycopy(this.a, paramInt1 + paramInt2, this.a, paramInt1, this.a.length - paramInt1 - paramInt2);
      Arrays.fill(this.a, this.a.length - paramInt2, this.a.length, -1);
      c(paramInt1, paramInt2);
    }
    
    void a(int paramInt, StaggeredGridLayoutManager.b paramb)
    {
      e(paramInt);
      this.a[paramInt] = paramb.e;
    }
    
    public void addFullSpanItem(FullSpanItem paramFullSpanItem)
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.b.get(i);
        if (localFullSpanItem.a == paramFullSpanItem.a) {
          this.b.remove(i);
        }
        if (localFullSpanItem.a >= paramFullSpanItem.a)
        {
          this.b.add(i, paramFullSpanItem);
          return;
        }
        i += 1;
      }
      this.b.add(paramFullSpanItem);
    }
    
    int b(int paramInt)
    {
      if (this.a == null) {}
      while (paramInt >= this.a.length) {
        return -1;
      }
      int i = f(paramInt);
      if (i == -1)
      {
        Arrays.fill(this.a, paramInt, this.a.length, -1);
        return this.a.length;
      }
      Arrays.fill(this.a, paramInt, i + 1, -1);
      return i + 1;
    }
    
    void b(int paramInt1, int paramInt2)
    {
      if ((this.a == null) || (paramInt1 >= this.a.length)) {
        return;
      }
      e(paramInt1 + paramInt2);
      System.arraycopy(this.a, paramInt1, this.a, paramInt1 + paramInt2, this.a.length - paramInt1 - paramInt2);
      Arrays.fill(this.a, paramInt1, paramInt1 + paramInt2, -1);
      d(paramInt1, paramInt2);
    }
    
    int c(int paramInt)
    {
      if ((this.a == null) || (paramInt >= this.a.length)) {
        return -1;
      }
      return this.a[paramInt];
    }
    
    int d(int paramInt)
    {
      int i = this.a.length;
      while (i <= paramInt) {
        i *= 2;
      }
      return i;
    }
    
    void e(int paramInt)
    {
      if (this.a == null)
      {
        this.a = new int[Math.max(paramInt, 10) + 1];
        Arrays.fill(this.a, -1);
      }
      while (paramInt < this.a.length) {
        return;
      }
      int[] arrayOfInt = this.a;
      this.a = new int[d(paramInt)];
      System.arraycopy(arrayOfInt, 0, this.a, 0, arrayOfInt.length);
      Arrays.fill(this.a, arrayOfInt.length, this.a.length, -1);
    }
    
    public FullSpanItem getFirstFullSpanItemInRange(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      Object localObject;
      if (this.b == null)
      {
        localObject = null;
        return (FullSpanItem)localObject;
      }
      int j = this.b.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label117;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)this.b.get(i);
        if (localFullSpanItem.a >= paramInt2) {
          return null;
        }
        if (localFullSpanItem.a >= paramInt1)
        {
          localObject = localFullSpanItem;
          if (paramInt3 == 0) {
            break;
          }
          localObject = localFullSpanItem;
          if (localFullSpanItem.b == paramInt3) {
            break;
          }
          if (paramBoolean)
          {
            localObject = localFullSpanItem;
            if (localFullSpanItem.d) {
              break;
            }
          }
        }
        i += 1;
      }
      label117:
      return null;
    }
    
    public FullSpanItem getFullSpanItem(int paramInt)
    {
      Object localObject;
      if (this.b == null)
      {
        localObject = null;
        return (FullSpanItem)localObject;
      }
      int i = this.b.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label61;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)this.b.get(i);
        localObject = localFullSpanItem;
        if (localFullSpanItem.a == paramInt) {
          break;
        }
        i -= 1;
      }
      label61:
      return null;
    }
    
    static class FullSpanItem
      implements Parcelable
    {
      public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator()
      {
        public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel paramAnonymousParcel)
        {
          return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(paramAnonymousParcel);
        }
        
        public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int paramAnonymousInt)
        {
          return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[paramAnonymousInt];
        }
      };
      int a;
      int b;
      int[] c;
      boolean d;
      
      FullSpanItem() {}
      
      FullSpanItem(Parcel paramParcel)
      {
        this.a = paramParcel.readInt();
        this.b = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          this.d = bool;
          int i = paramParcel.readInt();
          if (i > 0)
          {
            this.c = new int[i];
            paramParcel.readIntArray(this.c);
          }
          return;
          bool = false;
        }
      }
      
      int a(int paramInt)
      {
        if (this.c == null) {
          return 0;
        }
        return this.c[paramInt];
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String toString()
      {
        return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.a);
        paramParcel.writeInt(this.b);
        if (this.d) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if ((this.c == null) || (this.c.length <= 0)) {
            break;
          }
          paramParcel.writeInt(this.c.length);
          paramParcel.writeIntArray(this.c);
          return;
        }
        paramParcel.writeInt(0);
      }
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public StaggeredGridLayoutManager.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new StaggeredGridLayoutManager.SavedState(paramAnonymousParcel);
      }
      
      public StaggeredGridLayoutManager.SavedState[] newArray(int paramAnonymousInt)
      {
        return new StaggeredGridLayoutManager.SavedState[paramAnonymousInt];
      }
    };
    int a;
    int b;
    int c;
    int[] d;
    int e;
    int[] f;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> g;
    boolean h;
    boolean i;
    boolean j;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
      this.c = paramParcel.readInt();
      if (this.c > 0)
      {
        this.d = new int[this.c];
        paramParcel.readIntArray(this.d);
      }
      this.e = paramParcel.readInt();
      if (this.e > 0)
      {
        this.f = new int[this.e];
        paramParcel.readIntArray(this.f);
      }
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.h = bool1;
        if (paramParcel.readInt() != 1) {
          break label152;
        }
        bool1 = true;
        label113:
        this.i = bool1;
        if (paramParcel.readInt() != 1) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.j = bool1;
        this.g = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label113;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.c = paramSavedState.c;
      this.a = paramSavedState.a;
      this.b = paramSavedState.b;
      this.d = paramSavedState.d;
      this.e = paramSavedState.e;
      this.f = paramSavedState.f;
      this.h = paramSavedState.h;
      this.i = paramSavedState.i;
      this.j = paramSavedState.j;
      this.g = paramSavedState.g;
    }
    
    void a()
    {
      this.d = null;
      this.c = 0;
      this.e = 0;
      this.f = null;
      this.g = null;
    }
    
    void b()
    {
      this.d = null;
      this.c = 0;
      this.a = -1;
      this.b = -1;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int k = 1;
      paramParcel.writeInt(this.a);
      paramParcel.writeInt(this.b);
      paramParcel.writeInt(this.c);
      if (this.c > 0) {
        paramParcel.writeIntArray(this.d);
      }
      paramParcel.writeInt(this.e);
      if (this.e > 0) {
        paramParcel.writeIntArray(this.f);
      }
      if (this.h)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.i) {
          break label120;
        }
        paramInt = 1;
        label87:
        paramParcel.writeInt(paramInt);
        if (!this.j) {
          break label125;
        }
      }
      label120:
      label125:
      for (paramInt = k;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeList(this.g);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label87;
      }
    }
  }
  
  class a
  {
    int a;
    int b;
    boolean c;
    boolean d;
    boolean e;
    int[] f;
    
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
      this.e = false;
      if (this.f != null) {
        Arrays.fill(this.f, -1);
      }
    }
    
    void a(int paramInt)
    {
      if (this.c)
      {
        this.b = (StaggeredGridLayoutManager.this.b.getEndAfterPadding() - paramInt);
        return;
      }
      this.b = (StaggeredGridLayoutManager.this.b.getStartAfterPadding() + paramInt);
    }
    
    void a(StaggeredGridLayoutManager.b[] paramArrayOfb)
    {
      int j = paramArrayOfb.length;
      if ((this.f == null) || (this.f.length < j)) {
        this.f = new int[StaggeredGridLayoutManager.this.a.length];
      }
      int i = 0;
      while (i < j)
      {
        this.f[i] = paramArrayOfb[i].a(Integer.MIN_VALUE);
        i += 1;
      }
    }
    
    void b()
    {
      if (this.c) {}
      for (int i = StaggeredGridLayoutManager.this.b.getEndAfterPadding();; i = StaggeredGridLayoutManager.this.b.getStartAfterPadding())
      {
        this.b = i;
        return;
      }
    }
  }
  
  class b
  {
    ArrayList<View> a = new ArrayList();
    int b = Integer.MIN_VALUE;
    int c = Integer.MIN_VALUE;
    int d = 0;
    final int e;
    
    b(int paramInt)
    {
      this.e = paramInt;
    }
    
    int a(int paramInt)
    {
      if (this.b != Integer.MIN_VALUE) {
        paramInt = this.b;
      }
      while (this.a.size() == 0) {
        return paramInt;
      }
      a();
      return this.b;
    }
    
    int a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return a(paramInt1, paramInt2, paramBoolean, true, false);
    }
    
    int a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      int m = StaggeredGridLayoutManager.this.b.getStartAfterPadding();
      int n = StaggeredGridLayoutManager.this.b.getEndAfterPadding();
      int j;
      int k;
      if (paramInt2 > paramInt1)
      {
        j = 1;
        k = paramInt1;
      }
      while (k != paramInt2)
      {
        View localView = (View)this.a.get(k);
        int i1 = StaggeredGridLayoutManager.this.b.getDecoratedStart(localView);
        int i2 = StaggeredGridLayoutManager.this.b.getDecoratedEnd(localView);
        label97:
        int i;
        if (paramBoolean3) {
          if (i1 <= n)
          {
            paramInt1 = 1;
            if (!paramBoolean3) {
              break label191;
            }
            if (i2 < m) {
              break label185;
            }
            i = 1;
          }
        }
        for (;;)
        {
          if ((paramInt1 != 0) && (i != 0))
          {
            if ((paramBoolean1) && (paramBoolean2))
            {
              if ((i1 < m) || (i2 > n)) {
                break label249;
              }
              return StaggeredGridLayoutManager.this.getPosition(localView);
              j = -1;
              k = paramInt1;
              break;
              paramInt1 = 0;
              break label97;
              if (i1 < n)
              {
                paramInt1 = 1;
                break label97;
              }
              paramInt1 = 0;
              break label97;
              label185:
              i = 0;
              continue;
              label191:
              if (i2 > m)
              {
                i = 1;
                continue;
              }
              i = 0;
              continue;
            }
            if (paramBoolean2) {
              return StaggeredGridLayoutManager.this.getPosition(localView);
            }
            if ((i1 < m) || (i2 > n)) {
              return StaggeredGridLayoutManager.this.getPosition(localView);
            }
          }
        }
        label249:
        k += j;
      }
      return -1;
    }
    
    void a()
    {
      Object localObject = (View)this.a.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = c((View)localObject);
      this.b = StaggeredGridLayoutManager.this.b.getDecoratedStart((View)localObject);
      if (localLayoutParams.b)
      {
        localObject = StaggeredGridLayoutManager.this.h.getFullSpanItem(localLayoutParams.getViewLayoutPosition());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).b == -1)) {
          this.b -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).a(this.e);
        }
      }
    }
    
    void a(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = c(paramView);
      localLayoutParams.a = this;
      this.a.add(0, paramView);
      this.b = Integer.MIN_VALUE;
      if (this.a.size() == 1) {
        this.c = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        this.d += StaggeredGridLayoutManager.this.b.getDecoratedMeasurement(paramView);
      }
    }
    
    void a(boolean paramBoolean, int paramInt)
    {
      int i;
      if (paramBoolean)
      {
        i = b(Integer.MIN_VALUE);
        e();
        if (i != Integer.MIN_VALUE) {
          break label32;
        }
      }
      label32:
      while (((paramBoolean) && (i < StaggeredGridLayoutManager.this.b.getEndAfterPadding())) || ((!paramBoolean) && (i > StaggeredGridLayoutManager.this.b.getStartAfterPadding())))
      {
        return;
        i = a(Integer.MIN_VALUE);
        break;
      }
      int j = i;
      if (paramInt != Integer.MIN_VALUE) {
        j = i + paramInt;
      }
      this.c = j;
      this.b = j;
    }
    
    int b()
    {
      if (this.b != Integer.MIN_VALUE) {
        return this.b;
      }
      a();
      return this.b;
    }
    
    int b(int paramInt)
    {
      if (this.c != Integer.MIN_VALUE) {
        paramInt = this.c;
      }
      while (this.a.size() == 0) {
        return paramInt;
      }
      c();
      return this.c;
    }
    
    int b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return a(paramInt1, paramInt2, false, false, paramBoolean);
    }
    
    void b(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = c(paramView);
      localLayoutParams.a = this;
      this.a.add(paramView);
      this.c = Integer.MIN_VALUE;
      if (this.a.size() == 1) {
        this.b = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        this.d += StaggeredGridLayoutManager.this.b.getDecoratedMeasurement(paramView);
      }
    }
    
    StaggeredGridLayoutManager.LayoutParams c(View paramView)
    {
      return (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    }
    
    void c()
    {
      Object localObject = (View)this.a.get(this.a.size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = c((View)localObject);
      this.c = StaggeredGridLayoutManager.this.b.getDecoratedEnd((View)localObject);
      if (localLayoutParams.b)
      {
        localObject = StaggeredGridLayoutManager.this.h.getFullSpanItem(localLayoutParams.getViewLayoutPosition());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).b == 1))
        {
          int i = this.c;
          this.c = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).a(this.e) + i);
        }
      }
    }
    
    void c(int paramInt)
    {
      this.b = paramInt;
      this.c = paramInt;
    }
    
    int d()
    {
      if (this.c != Integer.MIN_VALUE) {
        return this.c;
      }
      c();
      return this.c;
    }
    
    void d(int paramInt)
    {
      if (this.b != Integer.MIN_VALUE) {
        this.b += paramInt;
      }
      if (this.c != Integer.MIN_VALUE) {
        this.c += paramInt;
      }
    }
    
    void e()
    {
      this.a.clear();
      f();
      this.d = 0;
    }
    
    void f()
    {
      this.b = Integer.MIN_VALUE;
      this.c = Integer.MIN_VALUE;
    }
    
    public int findFirstCompletelyVisibleItemPosition()
    {
      if (StaggeredGridLayoutManager.this.d) {
        return a(this.a.size() - 1, -1, true);
      }
      return a(0, this.a.size(), true);
    }
    
    public int findFirstPartiallyVisibleItemPosition()
    {
      if (StaggeredGridLayoutManager.this.d) {
        return b(this.a.size() - 1, -1, true);
      }
      return b(0, this.a.size(), true);
    }
    
    public int findFirstVisibleItemPosition()
    {
      if (StaggeredGridLayoutManager.this.d) {
        return a(this.a.size() - 1, -1, false);
      }
      return a(0, this.a.size(), false);
    }
    
    public int findLastCompletelyVisibleItemPosition()
    {
      if (StaggeredGridLayoutManager.this.d) {
        return a(0, this.a.size(), true);
      }
      return a(this.a.size() - 1, -1, true);
    }
    
    public int findLastPartiallyVisibleItemPosition()
    {
      if (StaggeredGridLayoutManager.this.d) {
        return b(0, this.a.size(), true);
      }
      return b(this.a.size() - 1, -1, true);
    }
    
    public int findLastVisibleItemPosition()
    {
      if (StaggeredGridLayoutManager.this.d) {
        return a(0, this.a.size(), false);
      }
      return a(this.a.size() - 1, -1, false);
    }
    
    void g()
    {
      int i = this.a.size();
      View localView = (View)this.a.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = c(localView);
      localLayoutParams.a = null;
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        this.d -= StaggeredGridLayoutManager.this.b.getDecoratedMeasurement(localView);
      }
      if (i == 1) {
        this.b = Integer.MIN_VALUE;
      }
      this.c = Integer.MIN_VALUE;
    }
    
    public int getDeletedSize()
    {
      return this.d;
    }
    
    public View getFocusableViewAfter(int paramInt1, int paramInt2)
    {
      View localView2 = null;
      View localView1 = null;
      if (paramInt2 == -1)
      {
        int i = this.a.size();
        paramInt2 = 0;
        for (;;)
        {
          if (paramInt2 < i)
          {
            localView2 = (View)this.a.get(paramInt2);
            if (((!StaggeredGridLayoutManager.this.d) || (StaggeredGridLayoutManager.this.getPosition(localView2) > paramInt1)) && ((StaggeredGridLayoutManager.this.d) || (StaggeredGridLayoutManager.this.getPosition(localView2) < paramInt1))) {
              break label88;
            }
          }
          label88:
          while (!localView2.hasFocusable()) {
            return localView1;
          }
          paramInt2 += 1;
          localView1 = localView2;
        }
      }
      paramInt2 = this.a.size() - 1;
      for (localView1 = localView2; paramInt2 >= 0; localView1 = localView2)
      {
        localView2 = (View)this.a.get(paramInt2);
        if ((StaggeredGridLayoutManager.this.d) && (StaggeredGridLayoutManager.this.getPosition(localView2) >= paramInt1)) {
          break;
        }
        if ((!StaggeredGridLayoutManager.this.d) && (StaggeredGridLayoutManager.this.getPosition(localView2) <= paramInt1)) {
          return localView1;
        }
        if (!localView2.hasFocusable()) {
          break;
        }
        paramInt2 -= 1;
      }
      return localView1;
    }
    
    void h()
    {
      View localView = (View)this.a.remove(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = c(localView);
      localLayoutParams.a = null;
      if (this.a.size() == 0) {
        this.c = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        this.d -= StaggeredGridLayoutManager.this.b.getDecoratedMeasurement(localView);
      }
      this.b = Integer.MIN_VALUE;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/StaggeredGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */