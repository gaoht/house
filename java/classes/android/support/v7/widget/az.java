package android.support.v7.widget;

import android.view.View;

class az
{
  final b a;
  a b;
  
  az(b paramb)
  {
    this.a = paramb;
    this.b = new a();
  }
  
  View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.a.getParentStart();
    int k = this.a.getParentEnd();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label172;
      }
      localView = this.a.getChildAt(paramInt1);
      int m = this.a.getChildStart(localView);
      int n = this.a.getChildEnd(localView);
      this.b.a(j, k, m, n);
      if (paramInt3 == 0) {
        break;
      }
      this.b.a();
      this.b.a(paramInt3);
      if (!this.b.b()) {
        break;
      }
      return localView;
    }
    if (paramInt4 != 0)
    {
      this.b.a();
      this.b.a(paramInt4);
      if (this.b.b()) {
        localObject = localView;
      }
    }
    for (;;)
    {
      paramInt1 += i;
      break;
      label172:
      return (View)localObject;
    }
  }
  
  boolean a(View paramView, int paramInt)
  {
    this.b.a(this.a.getParentStart(), this.a.getParentEnd(), this.a.getChildStart(paramView), this.a.getChildEnd(paramView));
    if (paramInt != 0)
    {
      this.b.a();
      this.b.a(paramInt);
      return this.b.b();
    }
    return false;
  }
  
  static class a
  {
    int a = 0;
    int b;
    int c;
    int d;
    int e;
    
    int a(int paramInt1, int paramInt2)
    {
      if (paramInt1 > paramInt2) {
        return 1;
      }
      if (paramInt1 == paramInt2) {
        return 2;
      }
      return 4;
    }
    
    void a()
    {
      this.a = 0;
    }
    
    void a(int paramInt)
    {
      this.a |= paramInt;
    }
    
    void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
    }
    
    boolean b()
    {
      if (((this.a & 0x7) != 0) && ((this.a & a(this.d, this.b) << 0) == 0)) {}
      while ((((this.a & 0x70) != 0) && ((this.a & a(this.d, this.c) << 4) == 0)) || (((this.a & 0x700) != 0) && ((this.a & a(this.e, this.b) << 8) == 0)) || (((this.a & 0x7000) != 0) && ((this.a & a(this.e, this.c) << 12) == 0))) {
        return false;
      }
      return true;
    }
  }
  
  static abstract interface b
  {
    public abstract View getChildAt(int paramInt);
    
    public abstract int getChildCount();
    
    public abstract int getChildEnd(View paramView);
    
    public abstract int getChildStart(View paramView);
    
    public abstract View getParent();
    
    public abstract int getParentEnd();
    
    public abstract int getParentStart();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */