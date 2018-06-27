package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.widget.SeekBar;

class j
  extends i
{
  private final SeekBar a;
  private Drawable b;
  private ColorStateList c = null;
  private PorterDuff.Mode d = null;
  private boolean e = false;
  private boolean f = false;
  
  j(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.a = paramSeekBar;
  }
  
  private void d()
  {
    if ((this.b != null) && ((this.e) || (this.f)))
    {
      this.b = DrawableCompat.wrap(this.b.mutate());
      if (this.e) {
        DrawableCompat.setTintList(this.b, this.c);
      }
      if (this.f) {
        DrawableCompat.setTintMode(this.b, this.d);
      }
      if (this.b.isStateful()) {
        this.b.setState(this.a.getDrawableState());
      }
    }
  }
  
  void a(Canvas paramCanvas)
  {
    int j = 1;
    if (this.b != null)
    {
      int k = this.a.getMax();
      if (k > 1)
      {
        int i = this.b.getIntrinsicWidth();
        int m = this.b.getIntrinsicHeight();
        if (i >= 0) {
          i /= 2;
        }
        for (;;)
        {
          if (m >= 0) {
            j = m / 2;
          }
          this.b.setBounds(-i, -j, i, j);
          float f1 = (this.a.getWidth() - this.a.getPaddingLeft() - this.a.getPaddingRight()) / k;
          j = paramCanvas.save();
          paramCanvas.translate(this.a.getPaddingLeft(), this.a.getHeight() / 2);
          i = 0;
          while (i <= k)
          {
            this.b.draw(paramCanvas);
            paramCanvas.translate(f1, 0.0F);
            i += 1;
          }
          i = 1;
        }
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  void a(Drawable paramDrawable)
  {
    if (this.b != null) {
      this.b.setCallback(null);
    }
    this.b = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this.a);
      DrawableCompat.setLayoutDirection(paramDrawable, ViewCompat.getLayoutDirection(this.a));
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(this.a.getDrawableState());
      }
      d();
    }
    this.a.invalidate();
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = at.obtainStyledAttributes(this.a.getContext(), paramAttributeSet, R.styleable.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
    if (localDrawable != null) {
      this.a.setThumb(localDrawable);
    }
    a(paramAttributeSet.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
    if (paramAttributeSet.hasValue(R.styleable.AppCompatSeekBar_tickMarkTintMode))
    {
      this.d = w.parseTintMode(paramAttributeSet.getInt(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
      this.f = true;
    }
    if (paramAttributeSet.hasValue(R.styleable.AppCompatSeekBar_tickMarkTint))
    {
      this.c = paramAttributeSet.getColorStateList(R.styleable.AppCompatSeekBar_tickMarkTint);
      this.e = true;
    }
    paramAttributeSet.recycle();
    d();
  }
  
  void b()
  {
    if (this.b != null) {
      this.b.jumpToCurrentState();
    }
  }
  
  void c()
  {
    Drawable localDrawable = this.b;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(this.a.getDrawableState()))) {
      this.a.invalidateDrawable(localDrawable);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */