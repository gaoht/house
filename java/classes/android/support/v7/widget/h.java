package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.a.a.b;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class h
{
  private final ImageView a;
  private ar b;
  private ar c;
  private ar d;
  
  public h(ImageView paramImageView)
  {
    this.a = paramImageView;
  }
  
  private boolean a(Drawable paramDrawable)
  {
    if (this.d == null) {
      this.d = new ar();
    }
    ar localar = this.d;
    localar.a();
    Object localObject = ImageViewCompat.getImageTintList(this.a);
    if (localObject != null)
    {
      localar.d = true;
      localar.a = ((ColorStateList)localObject);
    }
    localObject = ImageViewCompat.getImageTintMode(this.a);
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
  
  private boolean e()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.b == null) {}
    }
    while (i == 21)
    {
      return true;
      return false;
    }
    return false;
  }
  
  void a(ColorStateList paramColorStateList)
  {
    if (this.c == null) {
      this.c = new ar();
    }
    this.c.a = paramColorStateList;
    this.c.d = true;
    d();
  }
  
  void a(PorterDuff.Mode paramMode)
  {
    if (this.c == null) {
      this.c = new ar();
    }
    this.c.b = paramMode;
    this.c.c = true;
    d();
  }
  
  boolean a()
  {
    Drawable localDrawable = this.a.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  ColorStateList b()
  {
    if (this.c != null) {
      return this.c.a;
    }
    return null;
  }
  
  PorterDuff.Mode c()
  {
    if (this.c != null) {
      return this.c.b;
    }
    return null;
  }
  
  void d()
  {
    Drawable localDrawable = this.a.getDrawable();
    if (localDrawable != null) {
      w.a(localDrawable);
    }
    if ((localDrawable == null) || ((e()) && (a(localDrawable)))) {}
    do
    {
      return;
      if (this.c != null)
      {
        g.a(localDrawable, this.c, this.a.getDrawableState());
        return;
      }
    } while (this.b == null);
    g.a(localDrawable, this.b, this.a.getDrawableState());
  }
  
  public void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    at localat = at.obtainStyledAttributes(this.a.getContext(), paramAttributeSet, R.styleable.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.a.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localat.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = b.getDrawable(this.a.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.a.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        w.a(paramAttributeSet);
      }
      if (localat.hasValue(R.styleable.AppCompatImageView_tint)) {
        ImageViewCompat.setImageTintList(this.a, localat.getColorStateList(R.styleable.AppCompatImageView_tint));
      }
      if (localat.hasValue(R.styleable.AppCompatImageView_tintMode)) {
        ImageViewCompat.setImageTintMode(this.a, w.parseTintMode(localat.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));
      }
      return;
    }
    finally
    {
      localat.recycle();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = b.getDrawable(this.a.getContext(), paramInt);
      if (localDrawable != null) {
        w.a(localDrawable);
      }
      this.a.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      d();
      return;
      this.a.setImageDrawable(null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */