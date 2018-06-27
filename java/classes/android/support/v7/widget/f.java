package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.a.a.b;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class f
{
  private final CompoundButton a;
  private ColorStateList b = null;
  private PorterDuff.Mode c = null;
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  
  f(CompoundButton paramCompoundButton)
  {
    this.a = paramCompoundButton;
  }
  
  int a(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(this.a);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  ColorStateList a()
  {
    return this.b;
  }
  
  void a(ColorStateList paramColorStateList)
  {
    this.b = paramColorStateList;
    this.d = true;
    d();
  }
  
  void a(PorterDuff.Mode paramMode)
  {
    this.c = paramMode;
    this.e = true;
    d();
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.a.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_android_button))
      {
        paramInt = paramAttributeSet.getResourceId(R.styleable.CompoundButton_android_button, 0);
        if (paramInt != 0) {
          this.a.setButtonDrawable(b.getDrawable(this.a.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTint)) {
        CompoundButtonCompat.setButtonTintList(this.a, paramAttributeSet.getColorStateList(R.styleable.CompoundButton_buttonTint));
      }
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
        CompoundButtonCompat.setButtonTintMode(this.a, w.parseTintMode(paramAttributeSet.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
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
    return this.c;
  }
  
  void c()
  {
    if (this.f)
    {
      this.f = false;
      return;
    }
    this.f = true;
    d();
  }
  
  void d()
  {
    Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(this.a);
    if ((localDrawable != null) && ((this.d) || (this.e)))
    {
      localDrawable = DrawableCompat.wrap(localDrawable).mutate();
      if (this.d) {
        DrawableCompat.setTintList(localDrawable, this.b);
      }
      if (this.e) {
        DrawableCompat.setTintMode(localDrawable, this.c);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.a.getDrawableState());
      }
      this.a.setButtonDrawable(localDrawable);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */