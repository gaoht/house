package com.freelxl.baselibrary.widget;

import android.os.Handler;
import android.widget.ImageView;

public class b
{
  String a = "drawable://";
  private ImageView b;
  private int[] c;
  private int[] d;
  private int e;
  private int f;
  private int g;
  private int h;
  private Handler i = new Handler();
  private Runnable j = new Runnable()
  {
    public void run()
    {
      b.c(b.this).setBackgroundResource(b.a(b.this)[b.b(b.this)]);
      b.a(b.this, (b.b(b.this) + 1) % b.d(b.this));
      Handler localHandler = b.g(b.this);
      if (b.e(b.this) == null) {}
      for (long l = b.f(b.this);; l = b.e(b.this)[b.b(b.this)])
      {
        localHandler.postDelayed(this, l);
        return;
      }
    }
  };
  private Runnable k = new Runnable()
  {
    public void run()
    {
      b.c(b.this).setBackgroundResource(b.a(b.this)[b.b(b.this)]);
      b.a(b.this, (b.b(b.this) + 1) % b.d(b.this));
      Handler localHandler = b.g(b.this);
      long l;
      if ((b.b(b.this) == b.d(b.this) - 1) && (b.h(b.this) > 0)) {
        l = b.h(b.this);
      }
      for (;;)
      {
        localHandler.postDelayed(this, l);
        return;
        if (b.e(b.this) == null) {
          l = b.f(b.this);
        } else {
          l = b.e(b.this)[b.b(b.this)];
        }
      }
    }
  };
  
  public b(ImageView paramImageView, int[] paramArrayOfInt, int paramInt)
  {
    this.b = paramImageView;
    this.c = paramArrayOfInt;
    this.e = paramInt;
    this.g = paramArrayOfInt.length;
    paramImageView.setBackgroundResource(paramArrayOfInt[0]);
    a(1);
  }
  
  public b(ImageView paramImageView, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.b = paramImageView;
    this.c = paramArrayOfInt;
    this.e = paramInt1;
    this.h = paramInt2;
    this.g = paramArrayOfInt.length;
    paramImageView.setBackgroundResource(paramArrayOfInt[0]);
    b(1);
  }
  
  public b(ImageView paramImageView, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.b = paramImageView;
    this.c = paramArrayOfInt1;
    this.d = paramArrayOfInt2;
    this.g = paramArrayOfInt1.length;
    paramImageView.setBackgroundResource(paramArrayOfInt1[0]);
    a(1);
  }
  
  public b(ImageView paramImageView, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    this.b = paramImageView;
    this.c = paramArrayOfInt1;
    this.d = paramArrayOfInt2;
    this.h = paramInt;
    this.g = paramArrayOfInt1.length;
    paramImageView.setBackgroundResource(paramArrayOfInt1[0]);
    b(1);
  }
  
  private void a(int paramInt)
  {
    this.f = paramInt;
    Handler localHandler = this.i;
    Runnable localRunnable = this.j;
    if (this.d == null) {}
    for (long l = this.e;; l = this.d[paramInt])
    {
      localHandler.postDelayed(localRunnable, l);
      return;
    }
  }
  
  private void b(int paramInt)
  {
    this.f = paramInt;
    Handler localHandler = this.i;
    Runnable localRunnable = this.k;
    long l;
    if ((paramInt == this.g - 1) && (this.h > 0)) {
      l = this.h;
    }
    for (;;)
    {
      localHandler.postDelayed(localRunnable, l);
      return;
      if (this.d == null) {
        l = this.e;
      } else {
        l = this.d[paramInt];
      }
    }
  }
  
  public void removeCallBacks()
  {
    if (this.j != null) {
      this.i.removeCallbacks(this.j);
    }
    if (this.k != null) {
      this.i.removeCallbacks(this.k);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */