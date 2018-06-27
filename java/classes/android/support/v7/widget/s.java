package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class s
{
  final b a;
  final a b;
  final List<View> c;
  
  s(b paramb)
  {
    this.a = paramb;
    this.b = new a();
    this.c = new ArrayList();
  }
  
  private int f(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = this.a.getChildCount();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - this.b.e(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!this.b.c(i)) {
            break;
          }
          i += 1;
        }
      }
      i += k;
    }
    label72:
    return -1;
  }
  
  private void g(View paramView)
  {
    this.c.add(paramView);
    this.a.onEnteredHiddenState(paramView);
  }
  
  private boolean h(View paramView)
  {
    if (this.c.remove(paramView))
    {
      this.a.onLeftHiddenState(paramView);
      return true;
    }
    return false;
  }
  
  void a()
  {
    this.b.a();
    int i = this.c.size() - 1;
    while (i >= 0)
    {
      this.a.onLeftHiddenState((View)this.c.get(i));
      this.c.remove(i);
      i -= 1;
    }
    this.a.removeAllViews();
  }
  
  void a(int paramInt)
  {
    paramInt = f(paramInt);
    View localView = this.a.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    if (this.b.d(paramInt)) {
      h(localView);
    }
    this.a.removeViewAt(paramInt);
  }
  
  void a(View paramView)
  {
    int i = this.a.indexOfChild(paramView);
    if (i < 0) {
      return;
    }
    if (this.b.d(i)) {
      h(paramView);
    }
    this.a.removeViewAt(i);
  }
  
  void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.a.getChildCount();; paramInt = f(paramInt))
    {
      this.b.a(paramInt, paramBoolean);
      if (paramBoolean) {
        g(paramView);
      }
      this.a.attachViewToParent(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.a.getChildCount();; paramInt = f(paramInt))
    {
      this.b.a(paramInt, paramBoolean);
      if (paramBoolean) {
        g(paramView);
      }
      this.a.addView(paramView, paramInt);
      return;
    }
  }
  
  void a(View paramView, boolean paramBoolean)
  {
    a(paramView, -1, paramBoolean);
  }
  
  int b()
  {
    return this.a.getChildCount() - this.c.size();
  }
  
  int b(View paramView)
  {
    int i = this.a.indexOfChild(paramView);
    if (i == -1) {}
    while (this.b.c(i)) {
      return -1;
    }
    return i - this.b.e(i);
  }
  
  View b(int paramInt)
  {
    paramInt = f(paramInt);
    return this.a.getChildAt(paramInt);
  }
  
  int c()
  {
    return this.a.getChildCount();
  }
  
  View c(int paramInt)
  {
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.c.get(i);
      RecyclerView.u localu = this.a.getChildViewHolder(localView);
      if ((localu.getLayoutPosition() == paramInt) && (!localu.isInvalid()) && (!localu.isRemoved())) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  boolean c(View paramView)
  {
    return this.c.contains(paramView);
  }
  
  View d(int paramInt)
  {
    return this.a.getChildAt(paramInt);
  }
  
  void d(View paramView)
  {
    int i = this.a.indexOfChild(paramView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide " + paramView);
    }
    this.b.a(i);
    g(paramView);
  }
  
  void e(int paramInt)
  {
    paramInt = f(paramInt);
    this.b.d(paramInt);
    this.a.detachViewFromParent(paramInt);
  }
  
  void e(View paramView)
  {
    int i = this.a.indexOfChild(paramView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide " + paramView);
    }
    if (!this.b.c(i)) {
      throw new RuntimeException("trying to unhide a view that was not hidden" + paramView);
    }
    this.b.b(i);
    h(paramView);
  }
  
  boolean f(View paramView)
  {
    int i = this.a.indexOfChild(paramView);
    if (i == -1)
    {
      if (h(paramView)) {}
      return true;
    }
    if (this.b.c(i))
    {
      this.b.d(i);
      if (!h(paramView)) {}
      this.a.removeViewAt(i);
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    return this.b.toString() + ", hidden list:" + this.c.size();
  }
  
  static class a
  {
    long a = 0L;
    a b;
    
    private void b()
    {
      if (this.b == null) {
        this.b = new a();
      }
    }
    
    void a()
    {
      this.a = 0L;
      if (this.b != null) {
        this.b.a();
      }
    }
    
    void a(int paramInt)
    {
      if (paramInt >= 64)
      {
        b();
        this.b.a(paramInt - 64);
        return;
      }
      this.a |= 1L << paramInt;
    }
    
    void a(int paramInt, boolean paramBoolean)
    {
      if (paramInt >= 64)
      {
        b();
        this.b.a(paramInt - 64, paramBoolean);
      }
      label113:
      label119:
      for (;;)
      {
        return;
        boolean bool;
        if ((this.a & 0x8000000000000000) != 0L)
        {
          bool = true;
          long l1 = (1L << paramInt) - 1L;
          long l2 = this.a;
          this.a = (((l1 ^ 0xFFFFFFFFFFFFFFFF) & this.a) << 1 | l2 & l1);
          if (!paramBoolean) {
            break label113;
          }
          a(paramInt);
        }
        for (;;)
        {
          if ((!bool) && (this.b == null)) {
            break label119;
          }
          b();
          this.b.a(0, bool);
          return;
          bool = false;
          break;
          b(paramInt);
        }
      }
    }
    
    void b(int paramInt)
    {
      if (paramInt >= 64)
      {
        if (this.b != null) {
          this.b.b(paramInt - 64);
        }
        return;
      }
      this.a &= (1L << paramInt ^ 0xFFFFFFFFFFFFFFFF);
    }
    
    boolean c(int paramInt)
    {
      if (paramInt >= 64)
      {
        b();
        return this.b.c(paramInt - 64);
      }
      return (this.a & 1L << paramInt) != 0L;
    }
    
    boolean d(int paramInt)
    {
      boolean bool2;
      if (paramInt >= 64)
      {
        b();
        bool2 = this.b.d(paramInt - 64);
        return bool2;
      }
      long l1 = 1L << paramInt;
      if ((this.a & l1) != 0L) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.a &= (l1 ^ 0xFFFFFFFFFFFFFFFF);
        l1 -= 1L;
        long l2 = this.a;
        this.a = (Long.rotateRight((l1 ^ 0xFFFFFFFFFFFFFFFF) & this.a, 1) | l2 & l1);
        bool2 = bool1;
        if (this.b == null) {
          break;
        }
        if (this.b.c(0)) {
          a(63);
        }
        this.b.d(0);
        return bool1;
      }
    }
    
    int e(int paramInt)
    {
      if (this.b == null)
      {
        if (paramInt >= 64) {
          return Long.bitCount(this.a);
        }
        return Long.bitCount(this.a & (1L << paramInt) - 1L);
      }
      if (paramInt < 64) {
        return Long.bitCount(this.a & (1L << paramInt) - 1L);
      }
      return this.b.e(paramInt - 64) + Long.bitCount(this.a);
    }
    
    public String toString()
    {
      if (this.b == null) {
        return Long.toBinaryString(this.a);
      }
      return this.b.toString() + "xx" + Long.toBinaryString(this.a);
    }
  }
  
  static abstract interface b
  {
    public abstract void addView(View paramView, int paramInt);
    
    public abstract void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);
    
    public abstract void detachViewFromParent(int paramInt);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int getChildCount();
    
    public abstract RecyclerView.u getChildViewHolder(View paramView);
    
    public abstract int indexOfChild(View paramView);
    
    public abstract void onEnteredHiddenState(View paramView);
    
    public abstract void onLeftHiddenState(View paramView);
    
    public abstract void removeAllViews();
    
    public abstract void removeViewAt(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */