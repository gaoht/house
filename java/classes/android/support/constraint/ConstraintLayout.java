package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.a.a.a.b;
import android.support.constraint.a.a.a.c;
import android.support.constraint.a.a.b;
import android.support.constraint.a.a.b.a;
import android.support.constraint.a.a.c;
import android.support.constraint.a.a.d;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public class ConstraintLayout
  extends ViewGroup
{
  SparseArray<View> a = new SparseArray();
  c b = new c();
  private final ArrayList<b> c = new ArrayList(100);
  private int d = 0;
  private int e = 0;
  private int f = Integer.MAX_VALUE;
  private int g = Integer.MAX_VALUE;
  private boolean h = true;
  private int i = 2;
  private a j = null;
  
  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private final b a(int paramInt)
  {
    if (paramInt == 0) {
      return this.b;
    }
    View localView = (View)this.a.get(paramInt);
    if (localView == this) {
      return this.b;
    }
    if (localView == null) {
      return null;
    }
    return ((LayoutParams)localView.getLayoutParams()).Z;
  }
  
  private final b a(View paramView)
  {
    if (paramView == this) {
      return this.b;
    }
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).Z;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i5 = getPaddingTop() + getPaddingBottom();
    int i6 = getPaddingLeft() + getPaddingRight();
    int i7 = getChildCount();
    int n = 0;
    View localView;
    LayoutParams localLayoutParams;
    b localb;
    int i3;
    int i2;
    int k;
    label174:
    int i4;
    int i1;
    int m;
    if (n < i7)
    {
      localView = getChildAt(n);
      if (localView.getVisibility() == 8) {}
      do
      {
        n += 1;
        break;
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        localb = localLayoutParams.Z;
      } while (localLayoutParams.R);
      i3 = localLayoutParams.width;
      i2 = localLayoutParams.height;
      if ((localLayoutParams.O) || (localLayoutParams.P) || ((!localLayoutParams.O) && (localLayoutParams.F == 1)) || (localLayoutParams.width == -1) || ((!localLayoutParams.P) && ((localLayoutParams.G == 1) || (localLayoutParams.height == -1))))
      {
        k = 1;
        i4 = 0;
        i1 = 0;
        m = 0;
        if (k == 0) {
          break label364;
        }
        if ((i3 != 0) && (i3 != -1)) {
          break label335;
        }
        i1 = getChildMeasureSpec(paramInt1, i6, -2);
        k = 1;
        label210:
        if ((i2 != 0) && (i2 != -1)) {
          break label350;
        }
        i2 = getChildMeasureSpec(paramInt2, i5, -2);
        m = 1;
        label234:
        localView.measure(i1, i2);
        i3 = localView.getMeasuredWidth();
        i2 = localView.getMeasuredHeight();
        i1 = m;
        m = k;
      }
    }
    for (;;)
    {
      localb.setWidth(i3);
      localb.setHeight(i2);
      if (m != 0) {
        localb.setWrapWidth(i3);
      }
      if (i1 != 0) {
        localb.setWrapHeight(i2);
      }
      if (!localLayoutParams.Q) {
        break;
      }
      k = localView.getBaseline();
      if (k == -1) {
        break;
      }
      localb.setBaselineDistance(k);
      break;
      k = 0;
      break label174;
      label335:
      i1 = getChildMeasureSpec(paramInt1, i6, i3);
      k = 0;
      break label210;
      label350:
      i2 = getChildMeasureSpec(paramInt2, i5, i2);
      break label234;
      return;
      label364:
      k = i3;
      m = i4;
      i3 = k;
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    this.b.setCompanionWidget(this);
    this.a.put(getId(), this);
    this.j = null;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int m = paramAttributeSet.getIndexCount();
      int k = 0;
      if (k < m)
      {
        int n = paramAttributeSet.getIndex(k);
        if (n == R.styleable.ConstraintLayout_Layout_android_minWidth) {
          this.d = paramAttributeSet.getDimensionPixelOffset(n, this.d);
        }
        for (;;)
        {
          k += 1;
          break;
          if (n == R.styleable.ConstraintLayout_Layout_android_minHeight)
          {
            this.e = paramAttributeSet.getDimensionPixelOffset(n, this.e);
          }
          else if (n == R.styleable.ConstraintLayout_Layout_android_maxWidth)
          {
            this.f = paramAttributeSet.getDimensionPixelOffset(n, this.f);
          }
          else if (n == R.styleable.ConstraintLayout_Layout_android_maxHeight)
          {
            this.g = paramAttributeSet.getDimensionPixelOffset(n, this.g);
          }
          else if (n == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel)
          {
            this.i = paramAttributeSet.getInt(n, this.i);
          }
          else if (n == R.styleable.ConstraintLayout_Layout_constraintSet)
          {
            n = paramAttributeSet.getResourceId(n, 0);
            this.j = new a();
            this.j.load(getContext(), n);
          }
        }
      }
      paramAttributeSet.recycle();
    }
    this.b.setOptimizationLevel(this.i);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int m = getPaddingTop();
    int n = getPaddingBottom();
    int i2 = getPaddingLeft();
    int i3 = getPaddingRight();
    b.a locala1 = b.a.a;
    b.a locala2 = b.a.a;
    getLayoutParams();
    switch (i1)
    {
    default: 
      paramInt1 = 0;
      switch (k)
      {
      default: 
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      this.b.setMinWidth(0);
      this.b.setMinHeight(0);
      this.b.setHorizontalDimensionBehaviour(locala1);
      this.b.setWidth(paramInt1);
      this.b.setVerticalDimensionBehaviour(locala2);
      this.b.setHeight(paramInt2);
      this.b.setMinWidth(this.d - getPaddingLeft() - getPaddingRight());
      this.b.setMinHeight(this.e - getPaddingTop() - getPaddingBottom());
      return;
      locala1 = b.a.b;
      break;
      locala1 = b.a.b;
      paramInt1 = 0;
      break;
      paramInt1 = Math.min(this.f, paramInt1) - (i2 + i3);
      break;
      locala2 = b.a.b;
      continue;
      locala2 = b.a.b;
      paramInt2 = 0;
      continue;
      paramInt2 = Math.min(this.g, paramInt2) - (m + n);
    }
  }
  
  private void c()
  {
    int n = 0;
    int i1 = getChildCount();
    int k = 0;
    for (;;)
    {
      int m = n;
      if (k < i1)
      {
        if (getChildAt(k).isLayoutRequested()) {
          m = 1;
        }
      }
      else
      {
        if (m != 0)
        {
          this.c.clear();
          d();
        }
        return;
      }
      k += 1;
    }
  }
  
  private void d()
  {
    if (this.j != null) {
      this.j.a(this);
    }
    int i11 = getChildCount();
    this.b.removeAllChildren();
    int i7 = 0;
    Object localObject2;
    Object localObject1;
    LayoutParams localLayoutParams;
    label213:
    int i5;
    int i6;
    int i4;
    int i2;
    int i1;
    int i3;
    float f2;
    int i10;
    int i9;
    int i8;
    int n;
    float f1;
    int m;
    int k;
    if (i7 < i11)
    {
      localObject2 = getChildAt(i7);
      localObject1 = a((View)localObject2);
      if (localObject1 == null) {}
      do
      {
        for (;;)
        {
          i7 += 1;
          break;
          localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
          ((b)localObject1).reset();
          ((b)localObject1).setVisibility(((View)localObject2).getVisibility());
          ((b)localObject1).setCompanionWidget(localObject2);
          this.b.add((b)localObject1);
          if ((!localLayoutParams.P) || (!localLayoutParams.O)) {
            this.c.add(localObject1);
          }
          if (!localLayoutParams.R) {
            break label213;
          }
          localObject1 = (d)localObject1;
          if (localLayoutParams.a != -1) {
            ((d)localObject1).setGuideBegin(localLayoutParams.a);
          }
          if (localLayoutParams.b != -1) {
            ((d)localObject1).setGuideEnd(localLayoutParams.b);
          }
          if (localLayoutParams.c != -1.0F) {
            ((d)localObject1).setGuidePercent(localLayoutParams.c);
          }
        }
      } while ((localLayoutParams.S == -1) && (localLayoutParams.T == -1) && (localLayoutParams.U == -1) && (localLayoutParams.V == -1) && (localLayoutParams.h == -1) && (localLayoutParams.i == -1) && (localLayoutParams.j == -1) && (localLayoutParams.k == -1) && (localLayoutParams.l == -1) && (localLayoutParams.L == -1) && (localLayoutParams.M == -1) && (localLayoutParams.width != -1) && (localLayoutParams.height != -1));
      i5 = localLayoutParams.S;
      i6 = localLayoutParams.T;
      i4 = localLayoutParams.U;
      i2 = localLayoutParams.V;
      i1 = localLayoutParams.W;
      i3 = localLayoutParams.X;
      f2 = localLayoutParams.Y;
      if (Build.VERSION.SDK_INT >= 17) {
        break label1529;
      }
      i1 = localLayoutParams.d;
      i2 = localLayoutParams.e;
      i10 = localLayoutParams.f;
      i9 = localLayoutParams.g;
      i8 = localLayoutParams.q;
      n = localLayoutParams.s;
      f1 = localLayoutParams.w;
      m = i2;
      k = i1;
      if (i1 == -1)
      {
        m = i2;
        k = i1;
        if (i2 == -1)
        {
          if (localLayoutParams.n == -1) {
            break label1181;
          }
          k = localLayoutParams.n;
          m = i2;
        }
      }
      label479:
      f2 = f1;
      i3 = n;
      i2 = i9;
      i4 = i10;
      i1 = i8;
      i6 = m;
      i5 = k;
      if (i10 != -1) {
        break label1529;
      }
      f2 = f1;
      i3 = n;
      i2 = i9;
      i4 = i10;
      i1 = i8;
      i6 = m;
      i5 = k;
      if (i9 != -1) {
        break label1529;
      }
      if (localLayoutParams.o != -1)
      {
        i2 = localLayoutParams.o;
        i3 = m;
        i1 = i9;
        m = k;
        k = i3;
      }
    }
    for (;;)
    {
      label571:
      if (m != -1)
      {
        localObject2 = a(m);
        if (localObject2 != null) {
          ((b)localObject1).immediateConnect(a.c.b, (b)localObject2, a.c.b, localLayoutParams.leftMargin, i8);
        }
        label610:
        if (i2 == -1) {
          break label1308;
        }
        localObject2 = a(i2);
        if (localObject2 != null) {
          ((b)localObject1).immediateConnect(a.c.d, (b)localObject2, a.c.b, localLayoutParams.rightMargin, n);
        }
        label649:
        if (localLayoutParams.h == -1) {
          break label1350;
        }
        localObject2 = a(localLayoutParams.h);
        if (localObject2 != null) {
          ((b)localObject1).immediateConnect(a.c.c, (b)localObject2, a.c.c, localLayoutParams.topMargin, localLayoutParams.r);
        }
        label697:
        if (localLayoutParams.j == -1) {
          break label1401;
        }
        localObject2 = a(localLayoutParams.j);
        if (localObject2 != null) {
          ((b)localObject1).immediateConnect(a.c.e, (b)localObject2, a.c.c, localLayoutParams.bottomMargin, localLayoutParams.t);
        }
        label745:
        if (localLayoutParams.l != -1)
        {
          Object localObject3 = (View)this.a.get(localLayoutParams.l);
          localObject2 = a(localLayoutParams.l);
          if ((localObject2 != null) && (localObject3 != null) && ((((View)localObject3).getLayoutParams() instanceof LayoutParams)))
          {
            localObject3 = (LayoutParams)((View)localObject3).getLayoutParams();
            localLayoutParams.Q = true;
            ((LayoutParams)localObject3).Q = true;
            ((b)localObject1).getAnchor(a.c.f).connect(((b)localObject2).getAnchor(a.c.f), 0, -1, a.b.b, 0, true);
            ((b)localObject1).getAnchor(a.c.c).reset();
            ((b)localObject1).getAnchor(a.c.e).reset();
          }
        }
        if ((f1 >= 0.0F) && (f1 != 0.5F)) {
          ((b)localObject1).setHorizontalBiasPercent(f1);
        }
        if ((localLayoutParams.x >= 0.0F) && (localLayoutParams.x != 0.5F)) {
          ((b)localObject1).setVerticalBiasPercent(localLayoutParams.x);
        }
        if ((isInEditMode()) && ((localLayoutParams.L != -1) || (localLayoutParams.M != -1))) {
          ((b)localObject1).setOrigin(localLayoutParams.L, localLayoutParams.M);
        }
        if (localLayoutParams.O) {
          break label1469;
        }
        if (localLayoutParams.width != -1) {
          break label1452;
        }
        ((b)localObject1).setHorizontalDimensionBehaviour(b.a.d);
        ((b)localObject1).getAnchor(a.c.b).d = localLayoutParams.leftMargin;
        ((b)localObject1).getAnchor(a.c.d).d = localLayoutParams.rightMargin;
        label1023:
        if (localLayoutParams.P) {
          break label1507;
        }
        if (localLayoutParams.height != -1) {
          break label1490;
        }
        ((b)localObject1).setVerticalDimensionBehaviour(b.a.d);
        ((b)localObject1).getAnchor(a.c.c).d = localLayoutParams.topMargin;
        ((b)localObject1).getAnchor(a.c.e).d = localLayoutParams.bottomMargin;
      }
      for (;;)
      {
        if (localLayoutParams.y != null) {
          ((b)localObject1).setDimensionRatio(localLayoutParams.y);
        }
        ((b)localObject1).setHorizontalWeight(localLayoutParams.B);
        ((b)localObject1).setVerticalWeight(localLayoutParams.C);
        ((b)localObject1).setHorizontalChainStyle(localLayoutParams.D);
        ((b)localObject1).setVerticalChainStyle(localLayoutParams.E);
        ((b)localObject1).setHorizontalMatchStyle(localLayoutParams.F, localLayoutParams.H, localLayoutParams.J);
        ((b)localObject1).setVerticalMatchStyle(localLayoutParams.G, localLayoutParams.I, localLayoutParams.K);
        break;
        label1181:
        m = i2;
        k = i1;
        if (localLayoutParams.m == -1) {
          break label479;
        }
        m = localLayoutParams.m;
        k = i1;
        break label479;
        f2 = f1;
        i3 = n;
        i2 = i9;
        i4 = i10;
        i1 = i8;
        i6 = m;
        i5 = k;
        if (localLayoutParams.p == -1) {
          break label1529;
        }
        i1 = localLayoutParams.p;
        i2 = i10;
        i3 = k;
        k = m;
        m = i3;
        break label571;
        if (k == -1) {
          break label610;
        }
        localObject2 = a(k);
        if (localObject2 == null) {
          break label610;
        }
        ((b)localObject1).immediateConnect(a.c.b, (b)localObject2, a.c.d, localLayoutParams.leftMargin, i8);
        break label610;
        label1308:
        if (i1 == -1) {
          break label649;
        }
        localObject2 = a(i1);
        if (localObject2 == null) {
          break label649;
        }
        ((b)localObject1).immediateConnect(a.c.d, (b)localObject2, a.c.d, localLayoutParams.rightMargin, n);
        break label649;
        label1350:
        if (localLayoutParams.i == -1) {
          break label697;
        }
        localObject2 = a(localLayoutParams.i);
        if (localObject2 == null) {
          break label697;
        }
        ((b)localObject1).immediateConnect(a.c.c, (b)localObject2, a.c.e, localLayoutParams.topMargin, localLayoutParams.r);
        break label697;
        label1401:
        if (localLayoutParams.k == -1) {
          break label745;
        }
        localObject2 = a(localLayoutParams.k);
        if (localObject2 == null) {
          break label745;
        }
        ((b)localObject1).immediateConnect(a.c.e, (b)localObject2, a.c.e, localLayoutParams.bottomMargin, localLayoutParams.t);
        break label745;
        label1452:
        ((b)localObject1).setHorizontalDimensionBehaviour(b.a.c);
        ((b)localObject1).setWidth(0);
        break label1023;
        label1469:
        ((b)localObject1).setHorizontalDimensionBehaviour(b.a.a);
        ((b)localObject1).setWidth(localLayoutParams.width);
        break label1023;
        label1490:
        ((b)localObject1).setVerticalDimensionBehaviour(b.a.c);
        ((b)localObject1).setHeight(0);
        continue;
        label1507:
        ((b)localObject1).setVerticalDimensionBehaviour(b.a.a);
        ((b)localObject1).setHeight(localLayoutParams.height);
      }
      return;
      label1529:
      f1 = f2;
      k = i6;
      n = i3;
      m = i5;
      i8 = i1;
      i1 = i2;
      i2 = i4;
    }
  }
  
  protected void a()
  {
    this.b.layout();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14) {
      onViewAdded(paramView);
    }
  }
  
  protected LayoutParams b()
  {
    return new LayoutParams(-2, -2);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getMaxHeight()
  {
    return this.g;
  }
  
  public int getMaxWidth()
  {
    return this.f;
  }
  
  public int getMinHeight()
  {
    return this.e;
  }
  
  public int getMinWidth()
  {
    return this.d;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      Object localObject = (LayoutParams)localView.getLayoutParams();
      if ((localView.getVisibility() == 8) && (!((LayoutParams)localObject).R) && (!paramBoolean)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        localObject = ((LayoutParams)localObject).Z;
        paramInt3 = ((b)localObject).getDrawX();
        paramInt4 = ((b)localObject).getDrawY();
        localView.layout(paramInt3, paramInt4, ((b)localObject).getWidth() + paramInt3, ((b)localObject).getHeight() + paramInt4);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = getPaddingLeft();
    int i1 = getPaddingTop();
    this.b.setX(m);
    this.b.setY(i1);
    b(paramInt1, paramInt2);
    if (this.h)
    {
      this.h = false;
      c();
    }
    a(paramInt1, paramInt2);
    if (getChildCount() > 0) {
      a();
    }
    int n = 0;
    int k = 0;
    int i5 = this.c.size();
    int i6 = i1 + getPaddingBottom();
    int i7 = m + getPaddingRight();
    int i2;
    label141:
    label144:
    b localb;
    label188:
    label194:
    View localView;
    LayoutParams localLayoutParams;
    label258:
    int i4;
    if (i5 > 0)
    {
      m = 0;
      int i3;
      if (this.b.getHorizontalDimensionBehaviour() == b.a.b)
      {
        i1 = 1;
        if (this.b.getVerticalDimensionBehaviour() != b.a.b) {
          break label188;
        }
        i2 = 1;
        i3 = 0;
        if (i3 >= i5) {
          break label568;
        }
        localb = (b)this.c.get(i3);
        if (!(localb instanceof d)) {
          break label194;
        }
      }
      do
      {
        i3 += 1;
        break label144;
        i1 = 0;
        break;
        i2 = 0;
        break label141;
        localView = (View)localb.getCompanionWidget();
      } while ((localView == null) || (localView.getVisibility() == 8));
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.width == -2)
      {
        n = getChildMeasureSpec(paramInt1, i7, localLayoutParams.width);
        if (localLayoutParams.height != -2) {
          break label552;
        }
        i4 = getChildMeasureSpec(paramInt2, i6, localLayoutParams.height);
        label281:
        localView.measure(n, i4);
        n = localView.getMeasuredWidth();
        i4 = localView.getMeasuredHeight();
        if (n == localb.getWidth()) {
          break label718;
        }
        localb.setWidth(n);
        if ((i1 != 0) && (localb.getRight() > this.b.getWidth()))
        {
          m = localb.getRight();
          n = localb.getAnchor(a.c.d).getMargin();
          this.b.setWidth(Math.max(this.d, m + n));
        }
      }
    }
    label552:
    label568:
    label718:
    for (n = 1;; n = m)
    {
      if (i4 != localb.getHeight())
      {
        localb.setHeight(i4);
        if ((i2 != 0) && (localb.getBottom() > this.b.getHeight()))
        {
          m = localb.getBottom();
          n = localb.getAnchor(a.c.e).getMargin();
          this.b.setHeight(Math.max(this.e, m + n));
        }
        n = 1;
      }
      m = n;
      if (localLayoutParams.Q)
      {
        i4 = localView.getBaseline();
        m = n;
        if (i4 != -1)
        {
          m = n;
          if (i4 != localb.getBaselineDistance())
          {
            localb.setBaselineDistance(i4);
            m = 1;
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        k = combineMeasuredStates(k, localView.getMeasuredState());
        break;
        n = View.MeasureSpec.makeMeasureSpec(localb.getWidth(), 1073741824);
        break label258;
        i4 = View.MeasureSpec.makeMeasureSpec(localb.getHeight(), 1073741824);
        break label281;
        n = k;
        if (m != 0)
        {
          a();
          n = k;
        }
        k = this.b.getWidth() + i7;
        m = this.b.getHeight() + i6;
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramInt1 = resolveSizeAndState(k, paramInt1, n);
          paramInt2 = resolveSizeAndState(m, paramInt2, n << 16);
          paramInt1 = Math.min(this.f, paramInt1);
          k = Math.min(this.g, paramInt2);
          paramInt2 = paramInt1 & 0xFFFFFF;
          k &= 0xFFFFFF;
          paramInt1 = paramInt2;
          if (this.b.isWidthMeasuredTooSmall()) {
            paramInt1 = paramInt2 | 0x1000000;
          }
          paramInt2 = k;
          if (this.b.isHeightMeasuredTooSmall()) {
            paramInt2 = k | 0x1000000;
          }
          setMeasuredDimension(paramInt1, paramInt2);
          return;
        }
        setMeasuredDimension(k, m);
        return;
      }
      break;
    }
  }
  
  public void onViewAdded(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewAdded(paramView);
    }
    Object localObject = a(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof d)))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      ((LayoutParams)localObject).Z = new d();
      ((LayoutParams)localObject).R = true;
      ((d)((LayoutParams)localObject).Z).setOrientation(((LayoutParams)localObject).N);
      localObject = ((LayoutParams)localObject).Z;
    }
    this.a.put(paramView.getId(), paramView);
    this.h = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewRemoved(paramView);
    }
    this.a.remove(paramView.getId());
    this.b.remove(a(paramView));
    this.h = true;
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14) {
      onViewRemoved(paramView);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.h = true;
  }
  
  public void setConstraintSet(a parama)
  {
    this.j = parama;
  }
  
  public void setId(int paramInt)
  {
    this.a.remove(getId());
    super.setId(paramInt);
    this.a.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt == this.g) {
      return;
    }
    this.g = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt == this.f) {
      return;
    }
    this.f = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt == this.e) {
      return;
    }
    this.e = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt == this.d) {
      return;
    }
    this.d = paramInt;
    requestLayout();
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.b.setOptimizationLevel(paramInt);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    int A = 1;
    public float B = 0.0F;
    public float C = 0.0F;
    public int D = 0;
    public int E = 0;
    public int F = 0;
    public int G = 0;
    public int H = 0;
    public int I = 0;
    public int J = 0;
    public int K = 0;
    public int L = -1;
    public int M = -1;
    public int N = -1;
    boolean O = true;
    boolean P = true;
    boolean Q = false;
    boolean R = false;
    int S = -1;
    int T = -1;
    int U = -1;
    int V = -1;
    int W = -1;
    int X = -1;
    float Y = 0.5F;
    b Z = new b();
    public int a = -1;
    public int b = -1;
    public float c = -1.0F;
    public int d = -1;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int o = -1;
    public int p = -1;
    public int q = -1;
    public int r = -1;
    public int s = -1;
    public int t = -1;
    public int u = -1;
    public int v = -1;
    public float w = 0.5F;
    public float x = 0.5F;
    public String y = null;
    float z = 0.0F;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i3 = paramContext.getIndexCount();
      int i1 = 0;
      if (i1 < i3)
      {
        int i2 = paramContext.getIndex(i1);
        if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf)
        {
          this.d = paramContext.getResourceId(i2, this.d);
          if (this.d == -1) {
            this.d = paramContext.getInt(i2, -1);
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf)
          {
            this.e = paramContext.getResourceId(i2, this.e);
            if (this.e == -1) {
              this.e = paramContext.getInt(i2, -1);
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf)
          {
            this.f = paramContext.getResourceId(i2, this.f);
            if (this.f == -1) {
              this.f = paramContext.getInt(i2, -1);
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf)
          {
            this.g = paramContext.getResourceId(i2, this.g);
            if (this.g == -1) {
              this.g = paramContext.getInt(i2, -1);
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf)
          {
            this.h = paramContext.getResourceId(i2, this.h);
            if (this.h == -1) {
              this.h = paramContext.getInt(i2, -1);
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf)
          {
            this.i = paramContext.getResourceId(i2, this.i);
            if (this.i == -1) {
              this.i = paramContext.getInt(i2, -1);
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf)
          {
            this.j = paramContext.getResourceId(i2, this.j);
            if (this.j == -1) {
              this.j = paramContext.getInt(i2, -1);
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf)
          {
            this.k = paramContext.getResourceId(i2, this.k);
            if (this.k == -1) {
              this.k = paramContext.getInt(i2, -1);
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf)
          {
            this.l = paramContext.getResourceId(i2, this.l);
            if (this.l == -1) {
              this.l = paramContext.getInt(i2, -1);
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX)
          {
            this.L = paramContext.getDimensionPixelOffset(i2, this.L);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY)
          {
            this.M = paramContext.getDimensionPixelOffset(i2, this.M);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin)
          {
            this.a = paramContext.getDimensionPixelOffset(i2, this.a);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end)
          {
            this.b = paramContext.getDimensionPixelOffset(i2, this.b);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent)
          {
            this.c = paramContext.getFloat(i2, this.c);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_android_orientation)
          {
            this.N = paramContext.getInt(i2, this.N);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf)
          {
            this.m = paramContext.getResourceId(i2, this.m);
            if (this.m == -1) {
              this.m = paramContext.getInt(i2, -1);
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf)
          {
            this.n = paramContext.getResourceId(i2, this.n);
            if (this.n == -1) {
              this.n = paramContext.getInt(i2, -1);
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf)
          {
            this.o = paramContext.getResourceId(i2, this.o);
            if (this.o == -1) {
              this.o = paramContext.getInt(i2, -1);
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf)
          {
            this.p = paramContext.getResourceId(i2, this.p);
            if (this.p == -1) {
              this.p = paramContext.getInt(i2, -1);
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft)
          {
            this.q = paramContext.getDimensionPixelSize(i2, this.q);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_goneMarginTop)
          {
            this.r = paramContext.getDimensionPixelSize(i2, this.r);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_goneMarginRight)
          {
            this.s = paramContext.getDimensionPixelSize(i2, this.s);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom)
          {
            this.t = paramContext.getDimensionPixelSize(i2, this.t);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_goneMarginStart)
          {
            this.u = paramContext.getDimensionPixelSize(i2, this.u);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd)
          {
            this.v = paramContext.getDimensionPixelSize(i2, this.v);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias)
          {
            this.w = paramContext.getFloat(i2, this.w);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias)
          {
            this.x = paramContext.getFloat(i2, this.x);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio)
          {
            this.y = paramContext.getString(i2);
            this.z = NaN.0F;
            this.A = -1;
            if (this.y != null)
            {
              int i4 = this.y.length();
              i2 = this.y.indexOf(',');
              if ((i2 > 0) && (i2 < i4 - 1))
              {
                paramAttributeSet = this.y.substring(0, i2);
                if (paramAttributeSet.equalsIgnoreCase("W"))
                {
                  this.A = 0;
                  label1334:
                  i2 += 1;
                }
              }
              float f1;
              float f2;
              for (;;)
              {
                int i5 = this.y.indexOf(':');
                if ((i5 < 0) || (i5 >= i4 - 1)) {
                  break label1496;
                }
                paramAttributeSet = this.y.substring(i2, i5);
                String str = this.y.substring(i5 + 1);
                if ((paramAttributeSet.length() <= 0) || (str.length() <= 0)) {
                  break;
                }
                try
                {
                  f1 = Float.parseFloat(paramAttributeSet);
                  f2 = Float.parseFloat(str);
                  if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
                    break;
                  }
                  if (this.A != 1) {
                    break label1480;
                  }
                  this.z = Math.abs(f2 / f1);
                }
                catch (NumberFormatException paramAttributeSet) {}
                break;
                if (!paramAttributeSet.equalsIgnoreCase("H")) {
                  break label1334;
                }
                this.A = 1;
                break label1334;
                i2 = 0;
              }
              label1480:
              f1 /= f2;
              this.z = Math.abs(f1);
              continue;
              label1496:
              paramAttributeSet = this.y.substring(i2);
              if (paramAttributeSet.length() > 0) {
                try
                {
                  this.z = Float.parseFloat(paramAttributeSet);
                }
                catch (NumberFormatException paramAttributeSet) {}
              }
            }
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight)
          {
            this.B = paramContext.getFloat(i2, 0.0F);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight)
          {
            this.C = paramContext.getFloat(i2, 0.0F);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle)
          {
            this.D = paramContext.getInt(i2, 0);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle)
          {
            this.E = paramContext.getInt(i2, 0);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default)
          {
            this.F = paramContext.getInt(i2, 0);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default)
          {
            this.G = paramContext.getInt(i2, 0);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min)
          {
            this.H = paramContext.getDimensionPixelSize(i2, this.H);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max)
          {
            this.J = paramContext.getDimensionPixelSize(i2, this.J);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min)
          {
            this.I = paramContext.getDimensionPixelSize(i2, this.I);
          }
          else if (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max)
          {
            this.K = paramContext.getDimensionPixelSize(i2, this.K);
          }
          else if ((i2 == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator) || (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator) || (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator) || (i2 == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator) || (i2 != R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator)) {}
        }
      }
      paramContext.recycle();
      validate();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.a = paramLayoutParams.a;
      this.b = paramLayoutParams.b;
      this.c = paramLayoutParams.c;
      this.d = paramLayoutParams.d;
      this.e = paramLayoutParams.e;
      this.f = paramLayoutParams.f;
      this.g = paramLayoutParams.g;
      this.h = paramLayoutParams.h;
      this.i = paramLayoutParams.i;
      this.j = paramLayoutParams.j;
      this.k = paramLayoutParams.k;
      this.l = paramLayoutParams.l;
      this.m = paramLayoutParams.m;
      this.n = paramLayoutParams.n;
      this.o = paramLayoutParams.o;
      this.p = paramLayoutParams.p;
      this.q = paramLayoutParams.q;
      this.r = paramLayoutParams.r;
      this.s = paramLayoutParams.s;
      this.t = paramLayoutParams.t;
      this.u = paramLayoutParams.u;
      this.v = paramLayoutParams.v;
      this.w = paramLayoutParams.w;
      this.x = paramLayoutParams.x;
      this.y = paramLayoutParams.y;
      this.z = paramLayoutParams.z;
      this.A = paramLayoutParams.A;
      this.B = paramLayoutParams.B;
      this.C = paramLayoutParams.C;
      this.D = paramLayoutParams.D;
      this.E = paramLayoutParams.E;
      this.F = paramLayoutParams.F;
      this.G = paramLayoutParams.G;
      this.H = paramLayoutParams.H;
      this.J = paramLayoutParams.J;
      this.I = paramLayoutParams.I;
      this.K = paramLayoutParams.K;
      this.L = paramLayoutParams.L;
      this.M = paramLayoutParams.M;
      this.N = paramLayoutParams.N;
      this.O = paramLayoutParams.O;
      this.P = paramLayoutParams.P;
      this.Q = paramLayoutParams.Q;
      this.R = paramLayoutParams.R;
      this.S = paramLayoutParams.S;
      this.T = paramLayoutParams.T;
      this.U = paramLayoutParams.U;
      this.V = paramLayoutParams.V;
      this.W = paramLayoutParams.W;
      this.X = paramLayoutParams.X;
      this.Y = paramLayoutParams.Y;
      this.Z = paramLayoutParams.Z;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    @TargetApi(17)
    public void resolveLayoutDirection(int paramInt)
    {
      int i1 = 1;
      super.resolveLayoutDirection(paramInt);
      this.U = -1;
      this.V = -1;
      this.S = -1;
      this.T = -1;
      this.W = -1;
      this.X = -1;
      this.W = this.q;
      this.X = this.s;
      this.Y = this.w;
      if (1 == getLayoutDirection())
      {
        paramInt = i1;
        if (paramInt == 0) {
          break label254;
        }
        if (this.m == -1) {
          break label235;
        }
        this.U = this.m;
        label91:
        if (this.o != -1) {
          this.T = this.o;
        }
        if (this.p != -1) {
          this.S = this.p;
        }
        if (this.u != -1) {
          this.X = this.u;
        }
        if (this.v != -1) {
          this.W = this.v;
        }
        this.Y = (1.0F - this.w);
        label165:
        if ((this.o == -1) && (this.p == -1))
        {
          if (this.f == -1) {
            break label353;
          }
          this.U = this.f;
        }
        label197:
        if ((this.n == -1) && (this.m == -1))
        {
          if (this.d == -1) {
            break label372;
          }
          this.S = this.d;
        }
      }
      label235:
      label254:
      label353:
      label372:
      while (this.e == -1)
      {
        return;
        paramInt = 0;
        break;
        if (this.n == -1) {
          break label91;
        }
        this.V = this.n;
        break label91;
        if (this.m != -1) {
          this.T = this.m;
        }
        if (this.n != -1) {
          this.S = this.n;
        }
        if (this.o != -1) {
          this.U = this.o;
        }
        if (this.p != -1) {
          this.V = this.p;
        }
        if (this.u != -1) {
          this.W = this.u;
        }
        if (this.v == -1) {
          break label165;
        }
        this.X = this.v;
        break label165;
        if (this.g == -1) {
          break label197;
        }
        this.V = this.g;
        break label197;
      }
      this.T = this.e;
    }
    
    public void validate()
    {
      this.R = false;
      this.O = true;
      this.P = true;
      if ((this.width == 0) || (this.width == -1)) {
        this.O = false;
      }
      if ((this.height == 0) || (this.height == -1)) {
        this.P = false;
      }
      if ((this.c != -1.0F) || (this.a != -1) || (this.b != -1))
      {
        this.R = true;
        this.O = true;
        this.P = true;
        if (!(this.Z instanceof d)) {
          this.Z = new d();
        }
        ((d)this.Z).setOrientation(this.N);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/ConstraintLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */