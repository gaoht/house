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

public class f
  extends b
{
  private b i;
  
  protected f(a parama)
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
      return this.e.drawableProvider(paramInt, paramRecyclerView).getIntrinsicWidth();
    }
    throw new RuntimeException("failed to get size");
  }
  
  protected Rect a(int paramInt, RecyclerView paramRecyclerView, View paramView)
  {
    Rect localRect = new Rect(0, 0, 0, 0);
    int j = (int)ViewCompat.getTranslationX(paramView);
    int k = (int)ViewCompat.getTranslationY(paramView);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    localRect.top = (paramRecyclerView.getPaddingTop() + this.i.dividerTopMargin(paramInt, paramRecyclerView) + k);
    localRect.bottom = (k + (paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom() - this.i.dividerBottomMargin(paramInt, paramRecyclerView)));
    paramInt = a(paramInt, paramRecyclerView);
    boolean bool = a(paramRecyclerView);
    if (this.a == b.c.a)
    {
      if (bool)
      {
        localRect.right = (paramView.getLeft() - localLayoutParams.leftMargin + j);
        localRect.left = (localRect.right - paramInt);
      }
      for (;;)
      {
        if (this.h)
        {
          if (!bool) {
            break;
          }
          localRect.left += paramInt;
          localRect.right += paramInt;
        }
        return localRect;
        k = paramView.getRight();
        localRect.left = (localLayoutParams.rightMargin + k + j);
        localRect.right = (localRect.left + paramInt);
      }
    }
    k = paramInt / 2;
    if (bool) {}
    int m;
    for (localRect.left = (paramView.getLeft() - localLayoutParams.leftMargin - k + j);; localRect.left = (localLayoutParams.rightMargin + m + k + j))
    {
      localRect.right = localRect.left;
      break;
      m = paramView.getRight();
    }
    localRect.left -= paramInt;
    localRect.right -= paramInt;
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
      paramRect.set(a(paramInt, paramRecyclerView), 0, 0, 0);
      return;
    }
    paramRect.set(0, 0, a(paramInt, paramRecyclerView), 0);
  }
  
  public static class a
    extends b.a<a>
  {
    private f.b b = new f.b()
    {
      public int dividerBottomMargin(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
      {
        return 0;
      }
      
      public int dividerTopMargin(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
      {
        return 0;
      }
    };
    
    public a(Context paramContext)
    {
      super();
    }
    
    public f build()
    {
      a();
      return new f(this);
    }
    
    public a margin(int paramInt)
    {
      return margin(paramInt, paramInt);
    }
    
    public a margin(final int paramInt1, final int paramInt2)
    {
      marginProvider(new f.b()
      {
        public int dividerBottomMargin(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
        {
          return paramInt2;
        }
        
        public int dividerTopMargin(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
        {
          return paramInt1;
        }
      });
    }
    
    public a marginProvider(f.b paramb)
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
    public abstract int dividerBottomMargin(int paramInt, RecyclerView paramRecyclerView);
    
    public abstract int dividerTopMargin(int paramInt, RecyclerView paramRecyclerView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */