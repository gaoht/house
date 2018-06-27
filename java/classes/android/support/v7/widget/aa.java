package android.support.v7.widget;

import android.support.v4.os.TraceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class aa
  implements Runnable
{
  static final ThreadLocal<aa> a = new ThreadLocal();
  static Comparator<b> e = new Comparator()
  {
    public int compare(aa.b paramAnonymousb1, aa.b paramAnonymousb2)
    {
      int k = -1;
      int m = 1;
      int i;
      int j;
      if (paramAnonymousb1.d == null)
      {
        i = 1;
        if (paramAnonymousb2.d != null) {
          break label48;
        }
        j = 1;
        label25:
        if (i == j) {
          break label56;
        }
        if (paramAnonymousb1.d != null) {
          break label54;
        }
        i = m;
      }
      label48:
      label54:
      label56:
      do
      {
        do
        {
          return i;
          i = 0;
          break;
          j = 0;
          break label25;
          return -1;
          if (paramAnonymousb1.a != paramAnonymousb2.a)
          {
            if (paramAnonymousb1.a) {}
            for (i = k;; i = 1) {
              return i;
            }
          }
          j = paramAnonymousb2.b - paramAnonymousb1.b;
          i = j;
        } while (j != 0);
        j = paramAnonymousb1.c - paramAnonymousb2.c;
        i = j;
      } while (j != 0);
      return 0;
    }
  };
  ArrayList<RecyclerView> b = new ArrayList();
  long c;
  long d;
  private ArrayList<b> f = new ArrayList();
  
  /* Error */
  private RecyclerView.u a(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: invokestatic 51	android/support/v7/widget/aa:a	(Landroid/support/v7/widget/RecyclerView;I)Z
    //   5: ifeq +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: aload_1
    //   11: getfield 57	android/support/v7/widget/RecyclerView:mRecycler	Landroid/support/v7/widget/RecyclerView$n;
    //   14: astore 5
    //   16: aload_1
    //   17: invokevirtual 60	android/support/v7/widget/RecyclerView:onEnterLayoutOrScroll	()V
    //   20: aload 5
    //   22: iload_2
    //   23: iconst_0
    //   24: lload_3
    //   25: invokevirtual 65	android/support/v7/widget/RecyclerView$n:a	(IZJ)Landroid/support/v7/widget/RecyclerView$u;
    //   28: astore 6
    //   30: aload 6
    //   32: ifnull +29 -> 61
    //   35: aload 6
    //   37: invokevirtual 71	android/support/v7/widget/RecyclerView$u:isBound	()Z
    //   40: ifeq +29 -> 69
    //   43: aload 6
    //   45: invokevirtual 74	android/support/v7/widget/RecyclerView$u:isInvalid	()Z
    //   48: ifne +21 -> 69
    //   51: aload 5
    //   53: aload 6
    //   55: getfield 78	android/support/v7/widget/RecyclerView$u:itemView	Landroid/view/View;
    //   58: invokevirtual 82	android/support/v7/widget/RecyclerView$n:recycleView	(Landroid/view/View;)V
    //   61: aload_1
    //   62: iconst_0
    //   63: invokevirtual 86	android/support/v7/widget/RecyclerView:onExitLayoutOrScroll	(Z)V
    //   66: aload 6
    //   68: areturn
    //   69: aload 5
    //   71: aload 6
    //   73: iconst_0
    //   74: invokevirtual 89	android/support/v7/widget/RecyclerView$n:a	(Landroid/support/v7/widget/RecyclerView$u;Z)V
    //   77: goto -16 -> 61
    //   80: astore 5
    //   82: aload_1
    //   83: iconst_0
    //   84: invokevirtual 86	android/support/v7/widget/RecyclerView:onExitLayoutOrScroll	(Z)V
    //   87: aload 5
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	aa
    //   0	90	1	paramRecyclerView	RecyclerView
    //   0	90	2	paramInt	int
    //   0	90	3	paramLong	long
    //   14	56	5	localn	RecyclerView.n
    //   80	8	5	localObject	Object
    //   28	44	6	localu	RecyclerView.u
    // Exception table:
    //   from	to	target	type
    //   16	30	80	finally
    //   35	61	80	finally
    //   69	77	80	finally
  }
  
  private void a()
  {
    int m = this.b.size();
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < m)
    {
      localObject = (RecyclerView)this.b.get(j);
      if (((RecyclerView)localObject).getWindowVisibility() != 0) {
        break label292;
      }
      ((RecyclerView)localObject).mPrefetchRegistry.a((RecyclerView)localObject, false);
      i = ((RecyclerView)localObject).mPrefetchRegistry.d + i;
    }
    label184:
    label272:
    label292:
    for (;;)
    {
      j += 1;
      break;
      this.f.ensureCapacity(i);
      j = 0;
      i = 0;
      RecyclerView localRecyclerView;
      if (j < m)
      {
        localRecyclerView = (RecyclerView)this.b.get(j);
        if (localRecyclerView.getWindowVisibility() == 0) {}
      }
      for (;;)
      {
        j += 1;
        break;
        a locala = localRecyclerView.mPrefetchRegistry;
        int n = Math.abs(locala.a) + Math.abs(locala.b);
        int k = 0;
        if (k < locala.d * 2)
        {
          int i1;
          if (i >= this.f.size())
          {
            localObject = new b();
            this.f.add(localObject);
            i1 = locala.c[(k + 1)];
            if (i1 > n) {
              break label272;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ((b)localObject).a = bool;
            ((b)localObject).b = n;
            ((b)localObject).c = i1;
            ((b)localObject).d = localRecyclerView;
            ((b)localObject).e = locala.c[k];
            i += 1;
            k += 2;
            break;
            localObject = (b)this.f.get(i);
            break label184;
          }
          Collections.sort(this.f, e);
          return;
        }
      }
    }
  }
  
  private void a(RecyclerView paramRecyclerView, long paramLong)
  {
    if (paramRecyclerView == null) {}
    a locala;
    do
    {
      return;
      if ((paramRecyclerView.mDataSetHasChangedAfterLayout) && (paramRecyclerView.mChildHelper.c() != 0)) {
        paramRecyclerView.removeAndRecycleViews();
      }
      locala = paramRecyclerView.mPrefetchRegistry;
      locala.a(paramRecyclerView, true);
    } while (locala.d == 0);
    try
    {
      TraceCompat.beginSection("RV Nested Prefetch");
      paramRecyclerView.mState.a(paramRecyclerView.mAdapter);
      int i = 0;
      while (i < locala.d * 2)
      {
        a(paramRecyclerView, locala.c[i], paramLong);
        i += 2;
      }
      return;
    }
    finally
    {
      TraceCompat.endSection();
    }
  }
  
  private void a(b paramb, long paramLong)
  {
    if (paramb.a) {}
    for (long l = Long.MAX_VALUE;; l = paramLong)
    {
      paramb = a(paramb.d, paramb.e, l);
      if ((paramb != null) && (paramb.mNestedRecyclerView != null) && (paramb.isBound()) && (!paramb.isInvalid())) {
        a((RecyclerView)paramb.mNestedRecyclerView.get(), paramLong);
      }
      return;
    }
  }
  
  static boolean a(RecyclerView paramRecyclerView, int paramInt)
  {
    boolean bool2 = false;
    int j = paramRecyclerView.mChildHelper.c();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        RecyclerView.u localu = RecyclerView.getChildViewHolderInt(paramRecyclerView.mChildHelper.d(i));
        if ((localu.mPosition == paramInt) && (!localu.isInvalid())) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void b(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      b localb;
      if (i < this.f.size())
      {
        localb = (b)this.f.get(i);
        if (localb.d != null) {}
      }
      else
      {
        return;
      }
      a(localb, paramLong);
      localb.clear();
      i += 1;
    }
  }
  
  void a(long paramLong)
  {
    a();
    b(paramLong);
  }
  
  void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.isAttachedToWindow()) && (this.c == 0L))
    {
      this.c = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView.mPrefetchRegistry.a(paramInt1, paramInt2);
  }
  
  public void add(RecyclerView paramRecyclerView)
  {
    this.b.add(paramRecyclerView);
  }
  
  public void remove(RecyclerView paramRecyclerView)
  {
    this.b.remove(paramRecyclerView);
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        TraceCompat.beginSection("RV Prefetch");
        boolean bool = this.b.isEmpty();
        if (bool) {
          return;
        }
        int j = this.b.size();
        int i = 0;
        long l = 0L;
        if (i < j)
        {
          RecyclerView localRecyclerView = (RecyclerView)this.b.get(i);
          if (localRecyclerView.getWindowVisibility() == 0)
          {
            l = Math.max(localRecyclerView.getDrawingTime(), l);
            i += 1;
          }
        }
        else
        {
          if (l == 0L) {
            return;
          }
          a(TimeUnit.MILLISECONDS.toNanos(l) + this.d);
          return;
        }
      }
      finally
      {
        this.c = 0L;
        TraceCompat.endSection();
      }
    }
  }
  
  static class a
    implements RecyclerView.h.a
  {
    int a;
    int b;
    int[] c;
    int d;
    
    void a()
    {
      if (this.c != null) {
        Arrays.fill(this.c, -1);
      }
      this.d = 0;
    }
    
    void a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
    
    void a(RecyclerView paramRecyclerView, boolean paramBoolean)
    {
      this.d = 0;
      if (this.c != null) {
        Arrays.fill(this.c, -1);
      }
      RecyclerView.h localh = paramRecyclerView.mLayout;
      if ((paramRecyclerView.mAdapter != null) && (localh != null) && (localh.isItemPrefetchEnabled()))
      {
        if (!paramBoolean) {
          break label101;
        }
        if (!paramRecyclerView.mAdapterHelper.d()) {
          localh.collectInitialPrefetchPositions(paramRecyclerView.mAdapter.getItemCount(), this);
        }
      }
      for (;;)
      {
        if (this.d > localh.x)
        {
          localh.x = this.d;
          localh.y = paramBoolean;
          paramRecyclerView.mRecycler.a();
        }
        return;
        label101:
        if (!paramRecyclerView.hasPendingAdapterUpdates()) {
          localh.collectAdjacentPrefetchPositions(this.a, this.b, paramRecyclerView.mState, this);
        }
      }
    }
    
    boolean a(int paramInt)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      int j;
      int i;
      if (this.c != null)
      {
        j = this.d;
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < j * 2)
        {
          if (this.c[i] == paramInt) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 2;
      }
    }
    
    public void addPosition(int paramInt1, int paramInt2)
    {
      if (paramInt1 < 0) {
        throw new IllegalArgumentException("Layout positions must be non-negative");
      }
      if (paramInt2 < 0) {
        throw new IllegalArgumentException("Pixel distance must be non-negative");
      }
      int i = this.d * 2;
      if (this.c == null)
      {
        this.c = new int[4];
        Arrays.fill(this.c, -1);
      }
      for (;;)
      {
        this.c[i] = paramInt1;
        this.c[(i + 1)] = paramInt2;
        this.d += 1;
        return;
        if (i >= this.c.length)
        {
          int[] arrayOfInt = this.c;
          this.c = new int[i * 2];
          System.arraycopy(arrayOfInt, 0, this.c, 0, arrayOfInt.length);
        }
      }
    }
  }
  
  static class b
  {
    public boolean a;
    public int b;
    public int c;
    public RecyclerView d;
    public int e;
    
    public void clear()
    {
      this.a = false;
      this.b = 0;
      this.c = 0;
      this.d = null;
      this.e = 0;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */