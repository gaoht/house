package com.ziroom.ziroomcustomer.minsu.view.b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.r;
import android.view.View;

public abstract class b
  extends RecyclerView.g
{
  private static final int[] i = { 16843284 };
  protected c a = c.a;
  protected g b;
  protected e c;
  protected b d;
  protected d e;
  protected f f;
  protected boolean g;
  protected boolean h;
  private Paint j;
  
  protected b(a parama)
  {
    if (a.a(parama) != null)
    {
      this.a = c.b;
      this.c = a.a(parama);
    }
    for (;;)
    {
      this.b = a.f(parama);
      this.g = a.g(parama);
      this.h = a.h(parama);
      return;
      if (a.b(parama) == null) {
        break;
      }
      this.a = c.c;
      this.d = a.b(parama);
      this.j = new Paint();
      a(parama);
    }
    this.a = c.a;
    final Drawable localDrawable;
    if (a.c(parama) == null)
    {
      TypedArray localTypedArray = a.d(parama).obtainStyledAttributes(i);
      localDrawable = localTypedArray.getDrawable(0);
      localTypedArray.recycle();
    }
    for (this.e = new d()
        {
          public Drawable drawableProvider(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
          {
            return localDrawable;
          }
        };; this.e = a.c(parama))
    {
      this.f = a.e(parama);
      break;
    }
  }
  
  private void a(a parama)
  {
    this.f = a.e(parama);
    if (this.f == null) {
      this.f = new f()
      {
        public int dividerSize(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
        {
          return 2;
        }
      };
    }
  }
  
  private boolean a(int paramInt, RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView.getLayoutManager() instanceof GridLayoutManager))
    {
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      return paramRecyclerView.getSpanSizeLookup().getSpanIndex(paramInt, paramRecyclerView.getSpanCount()) > 0;
    }
    return false;
  }
  
  private int b(int paramInt, RecyclerView paramRecyclerView)
  {
    int k = paramInt;
    if ((paramRecyclerView.getLayoutManager() instanceof GridLayoutManager))
    {
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      k = paramRecyclerView.getSpanSizeLookup().getSpanGroupIndex(paramInt, paramRecyclerView.getSpanCount());
    }
    return k;
  }
  
  private int b(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView.getLayoutManager() instanceof GridLayoutManager))
    {
      GridLayoutManager localGridLayoutManager = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      GridLayoutManager.b localb = localGridLayoutManager.getSpanSizeLookup();
      int m = localGridLayoutManager.getSpanCount();
      int n = paramRecyclerView.getAdapter().getItemCount();
      int k = n - 1;
      while (k >= 0)
      {
        if (localb.getSpanIndex(k, m) == 0) {
          return n - k;
        }
        k -= 1;
      }
    }
    return 1;
  }
  
  protected abstract Rect a(int paramInt, RecyclerView paramRecyclerView, View paramView);
  
  protected abstract void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView);
  
  protected boolean a(RecyclerView paramRecyclerView)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof LinearLayoutManager)) {
      return ((LinearLayoutManager)paramRecyclerView).getReverseLayout();
    }
    return false;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.r paramr)
  {
    int k = paramRecyclerView.getChildAdapterPosition(paramView);
    int m = paramRecyclerView.getAdapter().getItemCount();
    int n = b(paramRecyclerView);
    if ((!this.g) && (k >= m - n)) {}
    do
    {
      return;
      k = b(k, paramRecyclerView);
    } while (this.b.shouldHideDivider(k, paramRecyclerView));
    a(paramRect, k, paramRecyclerView);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.r paramr)
  {
    paramr = paramRecyclerView.getAdapter();
    if (paramr == null) {
      return;
    }
    int i1 = paramr.getItemCount();
    int i2 = b(paramRecyclerView);
    int i3 = paramRecyclerView.getChildCount();
    int m = 0;
    int n = -1;
    label35:
    int k;
    if (m < i3)
    {
      paramr = paramRecyclerView.getChildAt(m);
      k = paramRecyclerView.getChildAdapterPosition(paramr);
      if (k >= n) {
        break label80;
      }
      k = n;
    }
    label80:
    do
    {
      do
      {
        m += 1;
        n = k;
        break label35;
        break;
      } while (((!this.g) && (k >= i1 - i2)) || (a(k, paramRecyclerView)));
      n = b(k, paramRecyclerView);
    } while (this.b.shouldHideDivider(n, paramRecyclerView));
    paramr = a(n, paramRecyclerView, paramr);
    switch (3.a[this.a.ordinal()])
    {
    }
    for (;;)
    {
      break;
      Drawable localDrawable = this.e.drawableProvider(n, paramRecyclerView);
      localDrawable.setBounds(paramr);
      localDrawable.draw(paramCanvas);
      break;
      this.j = this.c.dividerPaint(n, paramRecyclerView);
      paramCanvas.drawLine(paramr.left, paramr.top, paramr.right, paramr.bottom, this.j);
      break;
      this.j.setColor(this.d.dividerColor(n, paramRecyclerView));
      this.j.setStrokeWidth(this.f.dividerSize(n, paramRecyclerView));
      paramCanvas.drawLine(paramr.left, paramr.top, paramr.right, paramr.bottom, this.j);
    }
  }
  
  public static class a<T extends a>
  {
    protected Resources a;
    private Context b;
    private b.e c;
    private b.b d;
    private b.d e;
    private b.f f;
    private b.g g = new b.g()
    {
      public boolean shouldHideDivider(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
      {
        return false;
      }
    };
    private boolean h = false;
    private boolean i = false;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
      this.a = paramContext.getResources();
    }
    
    protected void a()
    {
      if (this.c != null)
      {
        if (this.d != null) {
          throw new IllegalArgumentException("Use setColor method of Paint class to specify line color. Do not provider ColorProvider if you set PaintProvider.");
        }
        if (this.f != null) {
          throw new IllegalArgumentException("Use setStrokeWidth method of Paint class to specify line size. Do not provider SizeProvider if you set PaintProvider.");
        }
      }
    }
    
    public T color(final int paramInt)
    {
      colorProvider(new b.b()
      {
        public int dividerColor(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
        {
          return paramInt;
        }
      });
    }
    
    public T colorProvider(b.b paramb)
    {
      this.d = paramb;
      return this;
    }
    
    public T colorResId(int paramInt)
    {
      return color(ContextCompat.getColor(this.b, paramInt));
    }
    
    public T drawable(int paramInt)
    {
      return drawable(ContextCompat.getDrawable(this.b, paramInt));
    }
    
    public T drawable(final Drawable paramDrawable)
    {
      drawableProvider(new b.d()
      {
        public Drawable drawableProvider(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
        {
          return paramDrawable;
        }
      });
    }
    
    public T drawableProvider(b.d paramd)
    {
      this.e = paramd;
      return this;
    }
    
    public T paint(final Paint paramPaint)
    {
      paintProvider(new b.e()
      {
        public Paint dividerPaint(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
        {
          return paramPaint;
        }
      });
    }
    
    public T paintProvider(b.e parame)
    {
      this.c = parame;
      return this;
    }
    
    public T positionInsideItem(boolean paramBoolean)
    {
      this.i = paramBoolean;
      return this;
    }
    
    public T showLastDivider()
    {
      this.h = true;
      return this;
    }
    
    public T size(final int paramInt)
    {
      sizeProvider(new b.f()
      {
        public int dividerSize(int paramAnonymousInt, RecyclerView paramAnonymousRecyclerView)
        {
          return paramInt;
        }
      });
    }
    
    public T sizeProvider(b.f paramf)
    {
      this.f = paramf;
      return this;
    }
    
    public T sizeResId(int paramInt)
    {
      return size(this.a.getDimensionPixelSize(paramInt));
    }
    
    public T visibilityProvider(b.g paramg)
    {
      this.g = paramg;
      return this;
    }
  }
  
  public static abstract interface b
  {
    public abstract int dividerColor(int paramInt, RecyclerView paramRecyclerView);
  }
  
  protected static enum c
  {
    private c() {}
  }
  
  public static abstract interface d
  {
    public abstract Drawable drawableProvider(int paramInt, RecyclerView paramRecyclerView);
  }
  
  public static abstract interface e
  {
    public abstract Paint dividerPaint(int paramInt, RecyclerView paramRecyclerView);
  }
  
  public static abstract interface f
  {
    public abstract int dividerSize(int paramInt, RecyclerView paramRecyclerView);
  }
  
  public static abstract interface g
  {
    public abstract boolean shouldHideDivider(int paramInt, RecyclerView paramRecyclerView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */