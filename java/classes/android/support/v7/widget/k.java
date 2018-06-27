package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.styleable;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class k
{
  final TextView a;
  private ar b;
  private ar c;
  private ar d;
  private ar e;
  private final m f;
  private int g = 0;
  private Typeface h;
  
  k(TextView paramTextView)
  {
    this.a = paramTextView;
    this.f = new m(this.a);
  }
  
  protected static ar a(Context paramContext, g paramg, int paramInt)
  {
    paramContext = paramg.a(paramContext, paramInt);
    if (paramContext != null)
    {
      paramg = new ar();
      paramg.d = true;
      paramg.a = paramContext;
      return paramg;
    }
    return null;
  }
  
  static k a(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new l(paramTextView);
    }
    return new k(paramTextView);
  }
  
  private void a(Context paramContext, at paramat)
  {
    this.g = paramat.getInt(R.styleable.TextAppearance_android_textStyle, this.g);
    int i;
    if ((paramat.hasValue(R.styleable.TextAppearance_android_fontFamily)) || (paramat.hasValue(R.styleable.TextAppearance_fontFamily)))
    {
      this.h = null;
      if (!paramat.hasValue(R.styleable.TextAppearance_android_fontFamily)) {
        break label102;
      }
      i = R.styleable.TextAppearance_android_fontFamily;
    }
    for (;;)
    {
      if (!paramContext.isRestricted()) {}
      try
      {
        this.h = paramat.getFont(i, this.g, this.a);
        if (this.h == null) {
          this.h = Typeface.create(paramat.getString(i), this.g);
        }
        return;
        label102:
        i = R.styleable.TextAppearance_fontFamily;
      }
      catch (UnsupportedOperationException paramContext)
      {
        for (;;) {}
      }
      catch (Resources.NotFoundException paramContext)
      {
        for (;;) {}
      }
    }
  }
  
  private void b(int paramInt, float paramFloat)
  {
    this.f.a(paramInt, paramFloat);
  }
  
  void a()
  {
    if ((this.b != null) || (this.c != null) || (this.d != null) || (this.e != null))
    {
      Drawable[] arrayOfDrawable = this.a.getCompoundDrawables();
      a(arrayOfDrawable[0], this.b);
      a(arrayOfDrawable[1], this.c);
      a(arrayOfDrawable[2], this.d);
      a(arrayOfDrawable[3], this.e);
    }
  }
  
  void a(int paramInt)
  {
    this.f.a(paramInt);
  }
  
  void a(int paramInt, float paramFloat)
  {
    if ((Build.VERSION.SDK_INT < 26) && (!c())) {
      b(paramInt, paramFloat);
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    this.f.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void a(Context paramContext, int paramInt)
  {
    at localat = at.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    if (localat.hasValue(R.styleable.TextAppearance_textAllCaps)) {
      a(localat.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localat.hasValue(R.styleable.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localat.getColorStateList(R.styleable.TextAppearance_android_textColor);
      if (localColorStateList != null) {
        this.a.setTextColor(localColorStateList);
      }
    }
    a(paramContext, localat);
    localat.recycle();
    if (this.h != null) {
      this.a.setTypeface(this.h, this.g);
    }
  }
  
  final void a(Drawable paramDrawable, ar paramar)
  {
    if ((paramDrawable != null) && (paramar != null)) {
      g.a(paramDrawable, paramar, this.a.getDrawableState());
    }
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Context localContext = this.a.getContext();
    Object localObject1 = g.get();
    Object localObject2 = at.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    int i = ((at)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    if (((at)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
      this.b = a(localContext, (g)localObject1, ((at)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
    }
    if (((at)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableTop)) {
      this.c = a(localContext, (g)localObject1, ((at)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
    }
    if (((at)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableRight)) {
      this.d = a(localContext, (g)localObject1, ((at)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
    }
    if (((at)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
      this.e = a(localContext, (g)localObject1, ((at)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
    }
    ((at)localObject2).recycle();
    boolean bool3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
    Object localObject6;
    boolean bool1;
    label266:
    label287:
    Object localObject5;
    if (i != -1)
    {
      localObject6 = at.obtainStyledAttributes(localContext, i, R.styleable.TextAppearance);
      if ((!bool3) && (((at)localObject6).hasValue(R.styleable.TextAppearance_textAllCaps)))
      {
        bool1 = ((at)localObject6).getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        i = 1;
        a(localContext, (at)localObject6);
        if (Build.VERSION.SDK_INT < 23) {
          if (((at)localObject6).hasValue(R.styleable.TextAppearance_android_textColor))
          {
            localObject1 = ((at)localObject6).getColorStateList(R.styleable.TextAppearance_android_textColor);
            if (((at)localObject6).hasValue(R.styleable.TextAppearance_android_textColorHint))
            {
              localObject3 = ((at)localObject6).getColorStateList(R.styleable.TextAppearance_android_textColorHint);
              localObject2 = localObject1;
              localObject5 = localObject3;
              if (((at)localObject6).hasValue(R.styleable.TextAppearance_android_textColorLink))
              {
                localObject4 = ((at)localObject6).getColorStateList(R.styleable.TextAppearance_android_textColorLink);
                localObject5 = localObject3;
                localObject2 = localObject1;
              }
              label324:
              ((at)localObject6).recycle();
              localObject1 = localObject5;
              localObject3 = localObject4;
            }
          }
        }
      }
    }
    for (;;)
    {
      at localat = at.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.TextAppearance, paramInt, 0);
      int j = i;
      boolean bool2 = bool1;
      if (!bool3)
      {
        j = i;
        bool2 = bool1;
        if (localat.hasValue(R.styleable.TextAppearance_textAllCaps))
        {
          bool2 = localat.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
          j = 1;
        }
      }
      localObject5 = localObject2;
      localObject6 = localObject3;
      localObject4 = localObject1;
      if (Build.VERSION.SDK_INT < 23)
      {
        if (localat.hasValue(R.styleable.TextAppearance_android_textColor)) {
          localObject2 = localat.getColorStateList(R.styleable.TextAppearance_android_textColor);
        }
        if (localat.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
          localObject1 = localat.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
        }
        localObject5 = localObject2;
        localObject6 = localObject3;
        localObject4 = localObject1;
        if (localat.hasValue(R.styleable.TextAppearance_android_textColorLink))
        {
          localObject6 = localat.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
          localObject4 = localObject1;
          localObject5 = localObject2;
        }
      }
      a(localContext, localat);
      localat.recycle();
      if (localObject5 != null) {
        this.a.setTextColor((ColorStateList)localObject5);
      }
      if (localObject4 != null) {
        this.a.setHintTextColor((ColorStateList)localObject4);
      }
      if (localObject6 != null) {
        this.a.setLinkTextColor((ColorStateList)localObject6);
      }
      if ((!bool3) && (j != 0)) {
        a(bool2);
      }
      if (this.h != null) {
        this.a.setTypeface(this.h, this.g);
      }
      this.f.a(paramAttributeSet, paramInt);
      if ((Build.VERSION.SDK_INT >= 26) && (this.f.a() != 0))
      {
        paramAttributeSet = this.f.e();
        if (paramAttributeSet.length > 0)
        {
          if (this.a.getAutoSizeStepGranularity() == -1.0F) {
            break label674;
          }
          this.a.setAutoSizeTextTypeUniformWithConfiguration(this.f.c(), this.f.d(), this.f.b(), 0);
        }
      }
      return;
      label674:
      this.a.setAutoSizeTextTypeUniformWithPresetSizes(paramAttributeSet, 0);
      return;
      localObject3 = null;
      break label287;
      localObject1 = null;
      break label266;
      localObject5 = null;
      localObject2 = null;
      break label324;
      i = 0;
      bool1 = false;
      break;
      localObject1 = null;
      localObject2 = null;
      i = 0;
      bool1 = false;
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.a.setAllCaps(paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT < 26) {
      b();
    }
  }
  
  void a(int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    this.f.a(paramArrayOfInt, paramInt);
  }
  
  void b()
  {
    this.f.f();
  }
  
  boolean c()
  {
    return this.f.g();
  }
  
  int d()
  {
    return this.f.a();
  }
  
  int e()
  {
    return this.f.b();
  }
  
  int f()
  {
    return this.f.c();
  }
  
  int g()
  {
    return this.f.d();
  }
  
  int[] h()
  {
    return this.f.e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */