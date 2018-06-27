package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;

class e
{
  private final View a;
  private final g b;
  private int c = -1;
  private ar d;
  private ar e;
  private ar f;
  
  e(View paramView)
  {
    this.a = paramView;
    this.b = g.get();
  }
  
  private boolean b(Drawable paramDrawable)
  {
    if (this.f == null) {
      this.f = new ar();
    }
    ar localar = this.f;
    localar.a();
    Object localObject = ViewCompat.getBackgroundTintList(this.a);
    if (localObject != null)
    {
      localar.d = true;
      localar.a = ((ColorStateList)localObject);
    }
    localObject = ViewCompat.getBackgroundTintMode(this.a);
    if (localObject != null)
    {
      localar.c = true;
      localar.b = ((PorterDuff.Mode)localObject);
    }
    if ((localar.d) || (localar.c))
    {
      g.a(paramDrawable, localar, this.a.getDrawableState());
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.d == null) {}
    }
    while (i == 21)
    {
      return true;
      return false;
    }
    return false;
  }
  
  ColorStateList a()
  {
    if (this.e != null) {
      return this.e.a;
    }
    return null;
  }
  
  void a(int paramInt)
  {
    this.c = paramInt;
    if (this.b != null) {}
    for (ColorStateList localColorStateList = this.b.a(this.a.getContext(), paramInt);; localColorStateList = null)
    {
      b(localColorStateList);
      c();
      return;
    }
  }
  
  void a(ColorStateList paramColorStateList)
  {
    if (this.e == null) {
      this.e = new ar();
    }
    this.e.a = paramColorStateList;
    this.e.d = true;
    c();
  }
  
  void a(PorterDuff.Mode paramMode)
  {
    if (this.e == null) {
      this.e = new ar();
    }
    this.e.b = paramMode;
    this.e.c = true;
    c();
  }
  
  void a(Drawable paramDrawable)
  {
    this.c = -1;
    b(null);
    c();
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = at.obtainStyledAttributes(this.a.getContext(), paramAttributeSet, R.styleable.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(R.styleable.ViewBackgroundHelper_android_background))
      {
        this.c = paramAttributeSet.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
        ColorStateList localColorStateList = this.b.a(this.a.getContext(), this.c);
        if (localColorStateList != null) {
          b(localColorStateList);
        }
      }
      if (paramAttributeSet.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint)) {
        ViewCompat.setBackgroundTintList(this.a, paramAttributeSet.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
        ViewCompat.setBackgroundTintMode(this.a, w.parseTintMode(paramAttributeSet.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  PorterDuff.Mode b()
  {
    if (this.e != null) {
      return this.e.b;
    }
    return null;
  }
  
  void b(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.d == null) {
        this.d = new ar();
      }
      this.d.a = paramColorStateList;
      this.d.d = true;
    }
    for (;;)
    {
      c();
      return;
      this.d = null;
    }
  }
  
  void c()
  {
    Drawable localDrawable = this.a.getBackground();
    if ((localDrawable == null) || ((d()) && (b(localDrawable)))) {}
    do
    {
      return;
      if (this.e != null)
      {
        g.a(localDrawable, this.e, this.a.getDrawableState());
        return;
      }
    } while (this.d == null);
    g.a(localDrawable, this.d, this.a.getDrawableState());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */