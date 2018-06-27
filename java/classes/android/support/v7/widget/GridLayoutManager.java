package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager
  extends LinearLayoutManager
{
  boolean a = false;
  int b = -1;
  int[] c;
  View[] d;
  final SparseIntArray e = new SparseIntArray();
  final SparseIntArray f = new SparseIntArray();
  b g = new a();
  final Rect h = new Rect();
  
  public GridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext);
    setSpanCount(paramInt);
  }
  
  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt2, paramBoolean);
    setSpanCount(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setSpanCount(getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2).b);
  }
  
  private int a(RecyclerView.n paramn, RecyclerView.r paramr, int paramInt)
  {
    if (!paramr.isPreLayout()) {
      return this.g.getSpanGroupIndex(paramInt, this.b);
    }
    int i = paramn.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + paramInt);
      return 0;
    }
    return this.g.getSpanGroupIndex(i, this.b);
  }
  
  private void a(float paramFloat, int paramInt)
  {
    b(Math.max(Math.round(this.b * paramFloat), paramInt));
  }
  
  private void a(RecyclerView.n paramn, RecyclerView.r paramr, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j;
    int i;
    if (paramBoolean)
    {
      paramInt2 = 1;
      j = 0;
      i = paramInt1;
      paramInt1 = j;
    }
    for (;;)
    {
      j = 0;
      while (paramInt1 != i)
      {
        View localView = this.d[paramInt1];
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        localLayoutParams.b = c(paramn, paramr, getPosition(localView));
        localLayoutParams.a = j;
        j += localLayoutParams.b;
        paramInt1 += paramInt2;
      }
      i = -1;
      paramInt1 -= 1;
      paramInt2 = -1;
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {}
    for (paramBoolean = a(paramView, paramInt1, paramInt2, localLayoutParams);; paramBoolean = b(paramView, paramInt1, paramInt2, localLayoutParams))
    {
      if (paramBoolean) {
        paramView.measure(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  private void a(View paramView, int paramInt, boolean paramBoolean)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.d;
    int j = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int i = localRect.left;
    int k = localRect.right;
    int m = localLayoutParams.leftMargin;
    i = localLayoutParams.rightMargin + (k + i + m);
    k = a(localLayoutParams.a, localLayoutParams.b);
    if (this.i == 1)
    {
      i = getChildMeasureSpec(k, paramInt, i, localLayoutParams.width, false);
      paramInt = getChildMeasureSpec(this.j.getTotalSpace(), getHeightMode(), j, localLayoutParams.height, true);
    }
    for (;;)
    {
      a(paramView, i, paramInt, paramBoolean);
      return;
      paramInt = getChildMeasureSpec(k, paramInt, j, localLayoutParams.height, false);
      i = getChildMeasureSpec(this.j.getTotalSpace(), getWidthMode(), i, localLayoutParams.width, true);
    }
  }
  
  static int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int k = 0;
    int[] arrayOfInt;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length == paramInt1 + 1))
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt[(paramArrayOfInt.length - 1)] == paramInt2) {}
    }
    else
    {
      arrayOfInt = new int[paramInt1 + 1];
    }
    arrayOfInt[0] = 0;
    int m = paramInt2 / paramInt1;
    int n = paramInt2 % paramInt1;
    int i = 1;
    int j = 0;
    paramInt2 = k;
    if (i <= paramInt1)
    {
      paramInt2 += n;
      if ((paramInt2 <= 0) || (paramInt1 - paramInt2 >= n)) {
        break label113;
      }
      k = m + 1;
      paramInt2 -= paramInt1;
    }
    for (;;)
    {
      j += k;
      arrayOfInt[i] = j;
      i += 1;
      break;
      return arrayOfInt;
      label113:
      k = m;
    }
  }
  
  private int b(RecyclerView.n paramn, RecyclerView.r paramr, int paramInt)
  {
    if (!paramr.isPreLayout()) {
      i = this.g.a(paramInt, this.b);
    }
    int j;
    do
    {
      return i;
      j = this.f.get(paramInt, -1);
      i = j;
    } while (j != -1);
    int i = paramn.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + paramInt);
      return 0;
    }
    return this.g.a(i, this.b);
  }
  
  private void b(int paramInt)
  {
    this.c = a(this.c, this.b, paramInt);
  }
  
  private void b(RecyclerView.n paramn, RecyclerView.r paramr, LinearLayoutManager.a parama, int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {}
    for (;;)
    {
      paramInt = b(paramn, paramr, parama.a);
      if (i == 0) {
        break;
      }
      while ((paramInt > 0) && (parama.a > 0))
      {
        parama.a -= 1;
        paramInt = b(paramn, paramr, parama.a);
      }
      i = 0;
    }
    int k = paramr.getItemCount();
    i = parama.a;
    while (i < k - 1)
    {
      int j = b(paramn, paramr, i + 1);
      if (j <= paramInt) {
        break;
      }
      i += 1;
      paramInt = j;
    }
    parama.a = i;
  }
  
  private int c(RecyclerView.n paramn, RecyclerView.r paramr, int paramInt)
  {
    if (!paramr.isPreLayout()) {
      i = this.g.getSpanSize(paramInt);
    }
    int j;
    do
    {
      return i;
      j = this.e.get(paramInt, -1);
      i = j;
    } while (j != -1);
    int i = paramn.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + paramInt);
      return 1;
    }
    return this.g.getSpanSize(i);
  }
  
  private void h()
  {
    this.e.clear();
    this.f.clear();
  }
  
  private void i()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
      int k = localLayoutParams.getViewLayoutPosition();
      this.e.put(k, localLayoutParams.getSpanSize());
      this.f.put(k, localLayoutParams.getSpanIndex());
      i += 1;
    }
  }
  
  private void j()
  {
    if (getOrientation() == 1) {}
    for (int i = getWidth() - getPaddingRight() - getPaddingLeft();; i = getHeight() - getPaddingBottom() - getPaddingTop())
    {
      b(i);
      return;
    }
  }
  
  private void k()
  {
    if ((this.d == null) || (this.d.length != this.b)) {
      this.d = new View[this.b];
    }
  }
  
  int a(int paramInt1, int paramInt2)
  {
    if ((this.i == 1) && (a())) {
      return this.c[(this.b - paramInt1)] - this.c[(this.b - paramInt1 - paramInt2)];
    }
    return this.c[(paramInt1 + paramInt2)] - this.c[paramInt1];
  }
  
  View a(RecyclerView.n paramn, RecyclerView.r paramr, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    b();
    int j = this.j.getStartAfterPadding();
    int k = this.j.getEndAfterPadding();
    int i;
    Object localObject1;
    label37:
    Object localObject3;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      localObject1 = null;
      if (paramInt1 == paramInt2) {
        break label197;
      }
      localObject3 = getChildAt(paramInt1);
      int m = getPosition((View)localObject3);
      if ((m < 0) || (m >= paramInt3)) {
        break label216;
      }
      if (b(paramn, paramr, m) == 0) {
        break label119;
      }
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      paramInt1 += i;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label37;
      i = -1;
      break;
      label119:
      if (((RecyclerView.LayoutParams)((View)localObject3).getLayoutParams()).isItemRemoved())
      {
        if (localObject1 == null)
        {
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
      else
      {
        Object localObject4;
        if (this.j.getDecoratedStart((View)localObject3) < k)
        {
          localObject4 = localObject3;
          if (this.j.getDecoratedEnd((View)localObject3) >= j) {}
        }
        else
        {
          if (localObject2 != null) {
            break label216;
          }
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
          label197:
          if (localObject2 == null) {
            break label209;
          }
        }
        for (;;)
        {
          localObject4 = localObject2;
          return (View)localObject4;
          label209:
          localObject2 = localObject1;
        }
      }
      label216:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  void a(RecyclerView.n paramn, RecyclerView.r paramr, LinearLayoutManager.a parama, int paramInt)
  {
    super.a(paramn, paramr, parama, paramInt);
    j();
    if ((paramr.getItemCount() > 0) && (!paramr.isPreLayout())) {
      b(paramn, paramr, parama, paramInt);
    }
    k();
  }
  
  void a(RecyclerView.n paramn, RecyclerView.r paramr, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb)
  {
    int i3 = this.j.getModeInOther();
    int j;
    int m;
    label38:
    boolean bool;
    label58:
    int i1;
    int i2;
    int n;
    if (i3 != 1073741824)
    {
      j = 1;
      if (getChildCount() <= 0) {
        break label226;
      }
      m = this.c[this.b];
      if (j != 0) {
        j();
      }
      if (paramc.e != 1) {
        break label232;
      }
      bool = true;
      i1 = 0;
      i2 = 0;
      i = this.b;
      n = i1;
      k = i2;
      if (!bool)
      {
        i = b(paramn, paramr, paramc.d) + c(paramn, paramr, paramc.d);
        k = i2;
        n = i1;
      }
    }
    label226:
    label232:
    label262:
    Object localObject;
    for (;;)
    {
      if ((n < this.b) && (paramc.a(paramr)) && (i > 0))
      {
        i2 = paramc.d;
        i1 = c(paramn, paramr, i2);
        if (i1 > this.b)
        {
          throw new IllegalArgumentException("Item at position " + i2 + " requires " + i1 + " spans but GridLayoutManager has only " + this.b + " spans.");
          j = 0;
          break;
          m = 0;
          break label38;
          bool = false;
          break label58;
        }
        i -= i1;
        if (i >= 0) {
          break label262;
        }
      }
      do
      {
        if (n != 0) {
          break;
        }
        paramb.b = true;
        return;
        localObject = paramc.a(paramn);
      } while (localObject == null);
      k += i1;
      this.d[n] = localObject;
      n += 1;
    }
    a(paramn, paramr, n, k, bool);
    int k = 0;
    float f1 = 0.0F;
    int i = 0;
    if (k < n)
    {
      paramn = this.d[k];
      if (paramc.k == null) {
        if (bool)
        {
          addView(paramn);
          label352:
          calculateItemDecorationsForChild(paramn, this.h);
          a(paramn, i3, false);
          i2 = this.j.getDecoratedMeasurement(paramn);
          i1 = i;
          if (i2 > i) {
            i1 = i2;
          }
          paramr = (LayoutParams)paramn.getLayoutParams();
          float f2 = this.j.getDecoratedMeasurementInOther(paramn) * 1.0F / paramr.b;
          if (f2 <= f1) {
            break label1106;
          }
          f1 = f2;
        }
      }
    }
    label724:
    label825:
    label1030:
    label1062:
    label1094:
    label1103:
    label1106:
    for (;;)
    {
      k += 1;
      i = i1;
      break;
      addView(paramn, 0);
      break label352;
      if (bool)
      {
        addDisappearingView(paramn);
        break label352;
      }
      addDisappearingView(paramn, 0);
      break label352;
      k = i;
      if (j != 0)
      {
        a(f1, m);
        i = 0;
        j = 0;
        k = i;
        if (j < n)
        {
          paramn = this.d[j];
          a(paramn, 1073741824, true);
          k = this.j.getDecoratedMeasurement(paramn);
          if (k <= i) {
            break label1103;
          }
          i = k;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i = 0;
        if (i < n)
        {
          paramn = this.d[i];
          if (this.j.getDecoratedMeasurement(paramn) != k)
          {
            paramr = (LayoutParams)paramn.getLayoutParams();
            localObject = paramr.d;
            j = ((Rect)localObject).top + ((Rect)localObject).bottom + paramr.topMargin + paramr.bottomMargin;
            m = ((Rect)localObject).left;
            m = ((Rect)localObject).right + m + paramr.leftMargin + paramr.rightMargin;
            i1 = a(paramr.a, paramr.b);
            if (this.i != 1) {
              break label724;
            }
            m = getChildMeasureSpec(i1, 1073741824, m, paramr.width, false);
          }
          for (j = View.MeasureSpec.makeMeasureSpec(k - j, 1073741824);; j = getChildMeasureSpec(i1, 1073741824, j, paramr.height, false))
          {
            a(paramn, m, j, true);
            i += 1;
            break;
            m = View.MeasureSpec.makeMeasureSpec(k - m, 1073741824);
          }
        }
        paramb.a = k;
        m = 0;
        if (this.i == 1) {
          if (paramc.f == -1)
          {
            m = paramc.b;
            i = m - k;
            j = 0;
            k = 0;
            i2 = k;
            i3 = 0;
            k = m;
            i1 = i;
            i = i2;
            m = i3;
            if (m >= n) {
              break label1094;
            }
            paramn = this.d[m];
            paramr = (LayoutParams)paramn.getLayoutParams();
            if (this.i != 1) {
              break label1062;
            }
            if (!a()) {
              break label1030;
            }
            j = getPaddingLeft() + this.c[(this.b - paramr.a)];
            i = j - this.j.getDecoratedMeasurementInOther(paramn);
          }
        }
        for (;;)
        {
          layoutDecoratedWithMargins(paramn, i, i1, j, k);
          if ((paramr.isItemRemoved()) || (paramr.isItemChanged())) {
            paramb.c = true;
          }
          paramb.d |= paramn.hasFocusable();
          m += 1;
          break label825;
          i = paramc.b;
          m = i + k;
          j = 0;
          k = 0;
          break;
          if (paramc.f == -1)
          {
            i = paramc.b;
            j = i;
            k = i - k;
            i = 0;
            break;
          }
          i1 = paramc.b;
          j = k + i1;
          i = 0;
          k = i1;
          break;
          i = getPaddingLeft() + this.c[paramr.a];
          j = i + this.j.getDecoratedMeasurementInOther(paramn);
          continue;
          i1 = getPaddingTop() + this.c[paramr.a];
          k = i1 + this.j.getDecoratedMeasurementInOther(paramn);
        }
        Arrays.fill(this.d, null);
        return;
      }
    }
  }
  
  void a(RecyclerView.r paramr, LinearLayoutManager.c paramc, RecyclerView.h.a parama)
  {
    int j = this.b;
    int i = 0;
    while ((i < this.b) && (paramc.a(paramr)) && (j > 0))
    {
      int k = paramc.d;
      parama.addPosition(k, Math.max(0, paramc.g));
      j -= this.g.getSpanSize(k);
      paramc.d += paramc.e;
      i += 1;
    }
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (this.i == 0) {
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
    if (this.i == 1) {
      return this.b;
    }
    if (paramr.getItemCount() < 1) {
      return 0;
    }
    return a(paramn, paramr, paramr.getItemCount() - 1) + 1;
  }
  
  public int getRowCountForAccessibility(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    if (this.i == 0) {
      return this.b;
    }
    if (paramr.getItemCount() < 1) {
      return 0;
    }
    return a(paramn, paramr, paramr.getItemCount() - 1) + 1;
  }
  
  public int getSpanCount()
  {
    return this.b;
  }
  
  public b getSpanSizeLookup()
  {
    return this.g;
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
  {
    View localView = findContainingItemView(paramView);
    Object localObject3;
    if (localView == null)
    {
      localObject3 = null;
      return (View)localObject3;
    }
    Object localObject1 = (LayoutParams)localView.getLayoutParams();
    int i6 = ((LayoutParams)localObject1).a;
    int i7 = ((LayoutParams)localObject1).a + ((LayoutParams)localObject1).b;
    if (super.onFocusSearchFailed(paramView, paramInt, paramn, paramr) == null) {
      return null;
    }
    int i11;
    label74:
    label85:
    int i1;
    int n;
    label102:
    int i2;
    label120:
    int m;
    int k;
    int j;
    int i;
    int i8;
    int i3;
    label150:
    Object localObject2;
    if (a(paramInt) == 1)
    {
      i11 = 1;
      if (i11 == this.k) {
        break label194;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label199;
      }
      paramInt = getChildCount() - 1;
      i1 = -1;
      n = -1;
      if ((this.i != 1) || (!a())) {
        break label213;
      }
      i2 = 1;
      paramView = null;
      m = -1;
      k = 0;
      localObject1 = null;
      j = -1;
      i = 0;
      i8 = a(paramn, paramr, paramInt);
      i3 = paramInt;
      if (i3 != n)
      {
        paramInt = a(paramn, paramr, i3);
        localObject2 = getChildAt(i3);
        if (localObject2 != localView) {
          break label219;
        }
      }
      label182:
      if (paramView == null) {
        break label652;
      }
    }
    for (;;)
    {
      return paramView;
      i11 = 0;
      break label74;
      label194:
      paramInt = 0;
      break label85;
      label199:
      n = getChildCount();
      paramInt = 0;
      i1 = 1;
      break label102;
      label213:
      i2 = 0;
      break label120;
      label219:
      if ((((View)localObject2).hasFocusable()) && (paramInt != i8))
      {
        if (paramView != null) {
          break label182;
        }
        paramInt = i;
        i = j;
        localObject2 = localObject1;
        j = k;
        localObject1 = paramView;
        k = m;
        paramView = (View)localObject2;
      }
      for (;;)
      {
        int i4 = i3 + i1;
        localObject2 = localObject1;
        m = j;
        i3 = k;
        j = i;
        i = paramInt;
        localObject1 = paramView;
        k = m;
        m = i3;
        paramView = (View)localObject2;
        i3 = i4;
        break label150;
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
        int i9 = localLayoutParams.a;
        int i10 = localLayoutParams.a + localLayoutParams.b;
        if ((((View)localObject2).hasFocusable()) && (i9 == i6))
        {
          localObject3 = localObject2;
          if (i10 == i7) {
            break;
          }
        }
        int i5 = 0;
        if (((((View)localObject2).hasFocusable()) && (paramView == null)) || ((!((View)localObject2).hasFocusable()) && (localObject1 == null))) {
          paramInt = 1;
        }
        for (;;)
        {
          label395:
          if (paramInt != 0)
          {
            if (!((View)localObject2).hasFocusable()) {
              break label612;
            }
            k = localLayoutParams.a;
            paramInt = Math.min(i10, i7);
            m = Math.max(i9, i6);
            paramView = (View)localObject1;
            m = paramInt - m;
            paramInt = i;
            localObject1 = localObject2;
            i = j;
            j = m;
            break;
            paramInt = Math.max(i9, i6);
            i4 = Math.min(i10, i7) - paramInt;
            if (((View)localObject2).hasFocusable())
            {
              if (i4 > k)
              {
                paramInt = 1;
              }
              else
              {
                paramInt = i5;
                if (i4 == k)
                {
                  if (i9 > m) {}
                  for (i4 = 1;; i4 = 0)
                  {
                    paramInt = i5;
                    if (i2 != i4) {
                      break;
                    }
                    paramInt = 1;
                    break;
                  }
                }
              }
            }
            else
            {
              paramInt = i5;
              if (paramView == null)
              {
                paramInt = i5;
                if (isViewPartiallyVisible((View)localObject2, false, true)) {
                  if (i4 > i)
                  {
                    paramInt = 1;
                  }
                  else
                  {
                    paramInt = i5;
                    if (i4 == i) {
                      if (i9 <= j) {
                        break label606;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label606:
        for (i4 = 1;; i4 = 0)
        {
          paramInt = i5;
          if (i2 != i4) {
            break label395;
          }
          paramInt = 1;
          break label395;
          break;
        }
        label612:
        i = localLayoutParams.a;
        paramInt = Math.min(i10, i7) - Math.max(i9, i6);
        j = k;
        k = m;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
      label652:
      paramView = (View)localObject1;
    }
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n paramn, RecyclerView.r paramr, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.a(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = a(paramn, paramr, paramView.getViewLayoutPosition());
    if (this.i == 0)
    {
      j = paramView.getSpanIndex();
      k = paramView.getSpanSize();
      if ((this.b > 1) && (paramView.getSpanSize() == this.b)) {}
      for (bool = true;; bool = false)
      {
        paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(j, k, i, 1, bool, false));
        return;
      }
    }
    int j = paramView.getSpanIndex();
    int k = paramView.getSpanSize();
    if ((this.b > 1) && (paramView.getSpanSize() == this.b)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, k, bool, false));
      return;
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.g.invalidateSpanIndexCache();
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.g.invalidateSpanIndexCache();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.g.invalidateSpanIndexCache();
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.g.invalidateSpanIndexCache();
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    this.g.invalidateSpanIndexCache();
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.r paramr)
  {
    if (paramr.isPreLayout()) {
      i();
    }
    super.onLayoutChildren(paramn, paramr);
    h();
  }
  
  public void onLayoutCompleted(RecyclerView.r paramr)
  {
    super.onLayoutCompleted(paramr);
    this.a = false;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
  {
    j();
    k();
    return super.scrollHorizontallyBy(paramInt, paramn, paramr);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
  {
    j();
    k();
    return super.scrollVerticallyBy(paramInt, paramn, paramr);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.c == null) {
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.i == 1)
    {
      i = chooseSize(paramInt2, k + paramRect.height(), getMinimumHeight());
      paramInt2 = chooseSize(paramInt1, j + this.c[(this.c.length - 1)], getMinimumWidth());
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = chooseSize(paramInt1, j + paramRect.width(), getMinimumWidth());
      paramInt1 = chooseSize(paramInt2, k + this.c[(this.c.length - 1)], getMinimumHeight());
      paramInt2 = i;
    }
  }
  
  public void setSpanCount(int paramInt)
  {
    if (paramInt == this.b) {
      return;
    }
    this.a = true;
    if (paramInt < 1) {
      throw new IllegalArgumentException("Span count should be at least 1. Provided " + paramInt);
    }
    this.b = paramInt;
    this.g.invalidateSpanIndexCache();
    requestLayout();
  }
  
  public void setSpanSizeLookup(b paramb)
  {
    this.g = paramb;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }
    super.setStackFromEnd(false);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.n == null) && (!this.a);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    int a = -1;
    int b = 0;
    
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
    
    public int getSpanIndex()
    {
      return this.a;
    }
    
    public int getSpanSize()
    {
      return this.b;
    }
  }
  
  public static final class a
    extends GridLayoutManager.b
  {
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }
    
    public int getSpanSize(int paramInt)
    {
      return 1;
    }
  }
  
  public static abstract class b
  {
    final SparseIntArray a = new SparseIntArray();
    private boolean b = false;
    
    int a(int paramInt)
    {
      int i = 0;
      int j = this.a.size() - 1;
      while (i <= j)
      {
        int k = i + j >>> 1;
        if (this.a.keyAt(k) < paramInt) {
          i = k + 1;
        } else {
          j = k - 1;
        }
      }
      paramInt = i - 1;
      if ((paramInt >= 0) && (paramInt < this.a.size())) {
        return this.a.keyAt(paramInt);
      }
      return -1;
    }
    
    int a(int paramInt1, int paramInt2)
    {
      int i;
      if (!this.b) {
        i = getSpanIndex(paramInt1, paramInt2);
      }
      int j;
      do
      {
        return i;
        j = this.a.get(paramInt1, -1);
        i = j;
      } while (j != -1);
      paramInt2 = getSpanIndex(paramInt1, paramInt2);
      this.a.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public int getSpanGroupIndex(int paramInt1, int paramInt2)
    {
      int n = getSpanSize(paramInt1);
      int k = 0;
      int i = 0;
      int j = 0;
      int m;
      if (k < paramInt1)
      {
        m = getSpanSize(k);
        j += m;
        if (j == paramInt2)
        {
          j = i + 1;
          i = 0;
        }
      }
      for (;;)
      {
        m = k + 1;
        k = i;
        i = j;
        j = k;
        k = m;
        break;
        if (j > paramInt2)
        {
          j = i + 1;
          i = m;
          continue;
          paramInt1 = i;
          if (j + n > paramInt2) {
            paramInt1 = i + 1;
          }
          return paramInt1;
        }
        else
        {
          m = j;
          j = i;
          i = m;
        }
      }
    }
    
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      int n = getSpanSize(paramInt1);
      if (n == paramInt2) {
        return 0;
      }
      int j;
      int i;
      if ((this.b) && (this.a.size() > 0))
      {
        j = a(paramInt1);
        if (j >= 0)
        {
          i = this.a.get(j) + getSpanSize(j);
          j += 1;
        }
      }
      for (;;)
      {
        if (j < paramInt1)
        {
          int k = getSpanSize(j);
          int m = i + k;
          if (m == paramInt2) {
            i = 0;
          }
          for (;;)
          {
            j += 1;
            break;
            i = k;
            if (m <= paramInt2) {
              i = m;
            }
          }
        }
        if (i + n > paramInt2) {
          break;
        }
        return i;
        j = 0;
        i = 0;
      }
    }
    
    public abstract int getSpanSize(int paramInt);
    
    public void invalidateSpanIndexCache()
    {
      this.a.clear();
    }
    
    public boolean isSpanIndexCacheEnabled()
    {
      return this.b;
    }
    
    public void setSpanIndexCacheEnabled(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/GridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */