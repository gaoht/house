package com.ziroom.ziroomcustomer.minsu.view.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public class c
  extends b
{
  private b i;
  
  protected c(a parama)
  {
    super(parama);
    this.i = a.a(parama);
  }
  
  private int a(int paramInt, RecyclerView paramRecyclerView)
  {
    if (this.c != null) {
      return (int)this.c.dividerPaint(paramInt, paramRecyclerView).getStrokeWidth();
    }
    if (this.f != null) {
      return this.f.dividerSize(paramInt, paramRecyclerView);
    }
    if (this.e != null) {
      return this.e.drawableProvider(paramInt, paramRecyclerView).getIntrinsicHeight();
    }
    throw new RuntimeException("failed to get size");
  }
  
  protected Rect a(int paramInt, RecyclerView paramRecyclerView, View paramView)
  {
    Rect localRect = new Rect(0, 0, 0, 0);
    int k = (int)ViewCompat.getTranslationX(paramView);
    int j = (int)ViewCompat.getTranslationY(paramView);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    localRect.left = (paramRecyclerView.getPaddingLeft() + this.i.dividerLeftMargin(paramInt, paramRecyclerView) + k);
    localRect.right = (k + (paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight() - this.i.dividerRightMargin(paramInt, paramRecyclerView)));
    paramInt = a(paramInt, paramRecyclerView);
    boolean bool = a(paramRecyclerView);
    if (this.a == b.c.a)
    {
      if (bool)
      {
        localRect.bottom = (paramView.getTop() - localLayoutParams.topMargin + j);
        localRect.top = (localRect.bottom - paramInt);
      }
      for (;;)
      {
        if (this.h)
        {
          if (!bool) {
            break;
          }
          localRect.top += paramInt;
          localRect.bottom += paramInt;
        }
        return localRect;
        k = paramView.getBottom();
        localRect.top = (localLayoutParams.bottomMargin + k + j);
        localRect.bottom = (localRect.top + paramInt);
      }
    }
    k = paramInt / 2;
    if (bool) {}
    int m;
    for (localRect.top = (paramView.getTop() - localLayoutParams.topMargin - k + j);; localRect.top = (localLayoutParams.bottomMargin + m + k + j))
    {
      localRect.bottom = localRect.top;
      break;
      m = paramView.getBottom();
    }
    localRect.top -= paramInt;
    localRect.bottom -= paramInt;
    return localRect;
  }
  
  protected void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    if (this.h)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    if (a(paramRecyclerView))
    {
      paramRect.set(0, a(paramInt, paramRecyclerView), 0, 0);
      return;
    }
    paramRect.set(0, 0, 0, a(paramInt, paramRecyclerView));
  }
  
  public static class a
    extends b.a<a>
  {
    private c.b b = new c.b()
    {
      public int dividerLeftMargin(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
      {
        return 0;
      }
      
      public int dividerRightMargin(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
      {
        return 0;
      }
    };
    
    public a(Context paramContext)
    {
      super();
    }
    
    public c build()
    {
      a();
      return new c(this);
    }
    
    public a margin(int paramInt)
    {
      return margin(paramInt, paramInt);
    }
    
    public a margin(final int paramInt1, final int paramInt2)
    {
      marginProvider(new c.b()
      {
        public int dividerLeftMargin(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
        {
          return paramInt1;
        }
        
        public int dividerRightMargin(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
        {
          return paramInt2;
        }
      });
    }
    
    public a marginProvider(c.b paramb)
    {
      this.b = paramb;
      return this;
    }
    
    public a marginResId(int paramInt)
    {
      return marginResId(paramInt, paramInt);
    }
    
    public a marginResId(int paramInt1, int paramInt2)
    {
      return margin(this.a.getDimensionPixelSize(paramInt1), this.a.getDimensionPixelSize(paramInt2));
    }
  }
  
  public static abstract interface b
  {
    public abstract int dividerLeftMargin(int paramInt, RecyclerView paramRecyclerView);
    
    public abstract int dividerRightMargin(int paramInt, RecyclerView paramRecyclerView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */