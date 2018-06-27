package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.widget.TextView;

class l
  extends k
{
  private ar b;
  private ar c;
  
  l(TextView paramTextView)
  {
    super(paramTextView);
  }
  
  void a()
  {
    super.a();
    if ((this.b != null) || (this.c != null))
    {
      Drawable[] arrayOfDrawable = this.a.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.b);
      a(arrayOfDrawable[2], this.c);
    }
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    Context localContext = this.a.getContext();
    g localg = g.get();
    paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextHelper_android_drawableStart)) {
      this.b = a(localContext, localg, paramAttributeSet.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
    }
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
      this.c = a(localContext, localg, paramAttributeSet.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
    }
    paramAttributeSet.recycle();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */