package android.support.v7.widget;

import android.view.View;

class ab
{
  boolean a = true;
  int b;
  int c;
  int d;
  int e;
  int f = 0;
  int g = 0;
  boolean h;
  boolean i;
  
  View a(RecyclerView.n paramn)
  {
    paramn = paramn.getViewForPosition(this.c);
    this.c += this.d;
    return paramn;
  }
  
  boolean a(RecyclerView.r paramr)
  {
    return (this.c >= 0) && (this.c < paramr.getItemCount());
  }
  
  public String toString()
  {
    return "LayoutState{mAvailable=" + this.b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */