package com.ziroom.ziroomcustomer.widget;

import android.os.Handler;
import android.widget.ImageView;

public class e
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
      e.c(e.this).setBackgroundResource(e.a(e.this)[e.b(e.this)]);
      e.a(e.this, (e.b(e.this) + 1) % e.d(e.this));
      Handler localHandler = e.g(e.this);
      if (e.e(e.this) == null) {}
      for (long l = e.f(e.this);; l = e.e(e.this)[e.b(e.this)])
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
      e.c(e.this).setBackgroundResource(e.a(e.this)[e.b(e.this)]);
      e.a(e.this, (e.b(e.this) + 1) % e.d(e.this));
      Handler localHandler = e.g(e.this);
      long l;
      if ((e.b(e.this) == e.d(e.this) - 1) && (e.h(e.this) > 0)) {
        l = e.h(e.this);
      }
      for (;;)
      {
        localHandler.postDelayed(this, l);
        return;
        if (e.e(e.this) == null) {
          l = e.f(e.this);
        } else {
          l = e.e(e.this)[e.b(e.this)];
        }
      }
    }
  };
  
  public e(ImageView paramImageView, int[] paramArrayOfInt, int paramInt)
  {
    this.b = paramImageView;
    this.c = paramArrayOfInt;
    this.e = paramInt;
    this.g = paramArrayOfInt.length;
    paramImageView.setBackgroundResource(paramArrayOfInt[0]);
    a(1);
  }
  
  public e(ImageView paramImageView, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.b = paramImageView;
    this.c = paramArrayOfInt;
    this.e = paramInt1;
    this.h = paramInt2;
    this.g = paramArrayOfInt.length;
    paramImageView.setBackgroundResource(paramArrayOfInt[0]);
    b(1);
  }
  
  public e(ImageView paramImageView, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.b = paramImageView;
    this.c = paramArrayOfInt1;
    this.d = paramArrayOfInt2;
    this.g = paramArrayOfInt1.length;
    paramImageView.setBackgroundResource(paramArrayOfInt1[0]);
    a(1);
  }
  
  public e(ImageView paramImageView, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */