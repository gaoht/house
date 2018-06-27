package com.ziroom.ziroomcustomer.newmovehouse.widget.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.g;

@SuppressLint({"ViewConstructor"})
public abstract class LoadingLayout
  extends FrameLayout
  implements com.ziroom.ziroomcustomer.newmovehouse.widget.a
{
  static final Interpolator a = new LinearInterpolator();
  protected final ImageView b;
  protected final ProgressBar c;
  protected final PullToRefreshBase.b d;
  protected final PullToRefreshBase.g e;
  private FrameLayout f;
  private boolean g;
  private final TextView h;
  private final TextView i;
  private CharSequence j;
  private CharSequence k;
  private CharSequence l;
  
  public LoadingLayout(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.g paramg, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.d = paramb;
    this.e = paramg;
    FrameLayout.LayoutParams localLayoutParams;
    int m;
    switch (1.a[paramg.ordinal()])
    {
    default: 
      LayoutInflater.from(paramContext).inflate(2130905080, this);
      this.f = ((FrameLayout)findViewById(2131697366));
      this.h = ((TextView)this.f.findViewById(2131697369));
      this.c = ((ProgressBar)this.f.findViewById(2131697368));
      this.i = ((TextView)this.f.findViewById(2131697370));
      this.b = ((ImageView)this.f.findViewById(2131697367));
      localLayoutParams = (FrameLayout.LayoutParams)this.f.getLayoutParams();
      switch (1.b[paramb.ordinal()])
      {
      default: 
        if (paramg == PullToRefreshBase.g.a)
        {
          m = 80;
          label179:
          localLayoutParams.gravity = m;
          this.j = paramContext.getString(2131297351);
          this.k = paramContext.getString(2131297352);
          this.l = paramContext.getString(2131297353);
          if (paramTypedArray.hasValue(1))
          {
            paramg = paramTypedArray.getDrawable(1);
            if (paramg != null) {
              b.setBackground(this, paramg);
            }
          }
          if (paramTypedArray.hasValue(10))
          {
            paramg = new TypedValue();
            paramTypedArray.getValue(10, paramg);
            setTextAppearance(paramg.data);
          }
          if (paramTypedArray.hasValue(11))
          {
            paramg = new TypedValue();
            paramTypedArray.getValue(11, paramg);
            setSubTextAppearance(paramg.data);
          }
          if (paramTypedArray.hasValue(2))
          {
            paramg = paramTypedArray.getColorStateList(2);
            if (paramg != null) {
              setTextColor(paramg);
            }
          }
          if (paramTypedArray.hasValue(3))
          {
            paramg = paramTypedArray.getColorStateList(3);
            if (paramg != null) {
              setSubTextColor(paramg);
            }
          }
          paramg = null;
          if (paramTypedArray.hasValue(6)) {
            paramg = paramTypedArray.getDrawable(6);
          }
          switch (1.b[paramb.ordinal()])
          {
          default: 
            if (paramTypedArray.hasValue(7)) {
              paramb = paramTypedArray.getDrawable(7);
            }
            break;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramg = paramb;
      if (paramb == null) {
        paramg = paramContext.getResources().getDrawable(getDefaultDrawableResId());
      }
      setLoadingDrawable(paramg);
      reset();
      return;
      LayoutInflater.from(paramContext).inflate(2130905079, this);
      break;
      if (paramg == PullToRefreshBase.g.a) {}
      for (m = 48;; m = 3)
      {
        localLayoutParams.gravity = m;
        this.j = paramContext.getString(2131297348);
        this.k = paramContext.getString(2131297349);
        this.l = paramContext.getString(2131297350);
        break;
      }
      m = 5;
      break label179;
      paramb = paramg;
      if (paramTypedArray.hasValue(17))
      {
        a.warnDeprecation("ptrDrawableTop", "ptrDrawableStart");
        paramb = paramTypedArray.getDrawable(17);
        continue;
        if (paramTypedArray.hasValue(8))
        {
          paramb = paramTypedArray.getDrawable(8);
        }
        else
        {
          paramb = paramg;
          if (paramTypedArray.hasValue(18))
          {
            a.warnDeprecation("ptrDrawableBottom", "ptrDrawableEnd");
            paramb = paramTypedArray.getDrawable(18);
          }
        }
      }
    }
  }
  
  private void setSubHeaderText(CharSequence paramCharSequence)
  {
    if (this.i != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence)) {
        break label24;
      }
      this.i.setVisibility(8);
    }
    label24:
    do
    {
      return;
      this.i.setText(paramCharSequence);
    } while (8 != this.i.getVisibility());
    this.i.setVisibility(0);
  }
  
  private void setSubTextAppearance(int paramInt)
  {
    if (this.i != null) {
      this.i.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void setSubTextColor(ColorStateList paramColorStateList)
  {
    if (this.i != null) {
      this.i.setTextColor(paramColorStateList);
    }
  }
  
  private void setTextAppearance(int paramInt)
  {
    if (this.h != null) {
      this.h.setTextAppearance(getContext(), paramInt);
    }
    if (this.i != null) {
      this.i.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void setTextColor(ColorStateList paramColorStateList)
  {
    if (this.h != null) {
      this.h.setTextColor(paramColorStateList);
    }
    if (this.i != null) {
      this.i.setTextColor(paramColorStateList);
    }
  }
  
  protected abstract void a();
  
  protected abstract void a(float paramFloat);
  
  protected abstract void b();
  
  protected abstract void c();
  
  protected abstract void d();
  
  public final int getContentSize()
  {
    switch (1.a[this.e.ordinal()])
    {
    default: 
      return this.f.getHeight();
    }
    return this.f.getWidth();
  }
  
  protected abstract int getDefaultDrawableResId();
  
  public final void hideAllViews()
  {
    if (this.h.getVisibility() == 0) {
      this.h.setVisibility(4);
    }
    if (this.c.getVisibility() == 0) {
      this.c.setVisibility(4);
    }
    if (this.b.getVisibility() == 0) {
      this.b.setVisibility(4);
    }
    if (this.i.getVisibility() == 0) {
      this.i.setVisibility(4);
    }
  }
  
  protected abstract void onLoadingDrawableSet(Drawable paramDrawable);
  
  public final void onPull(float paramFloat)
  {
    if (!this.g) {
      a(paramFloat);
    }
  }
  
  public final void pullToRefresh()
  {
    if (this.h != null) {
      this.h.setText(this.j);
    }
    a();
  }
  
  public final void refreshing()
  {
    if (this.h != null) {
      this.h.setText(this.k);
    }
    if (this.g) {
      ((AnimationDrawable)this.b.getDrawable()).start();
    }
    for (;;)
    {
      if (this.i != null) {
        this.i.setVisibility(8);
      }
      return;
      b();
    }
  }
  
  public final void releaseToRefresh()
  {
    if (this.h != null) {
      this.h.setText(this.l);
    }
    c();
  }
  
  public final void reset()
  {
    if (this.h != null) {
      this.h.setText(this.j);
    }
    this.b.setVisibility(0);
    if (this.g) {
      ((AnimationDrawable)this.b.getDrawable()).stop();
    }
    for (;;)
    {
      if (this.i != null)
      {
        if (!TextUtils.isEmpty(this.i.getText())) {
          break;
        }
        this.i.setVisibility(8);
      }
      return;
      d();
    }
    this.i.setVisibility(0);
  }
  
  public final void setHeight(int paramInt)
  {
    getLayoutParams().height = paramInt;
    requestLayout();
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    setSubHeaderText(paramCharSequence);
  }
  
  public final void setLoadingDrawable(Drawable paramDrawable)
  {
    this.b.setImageDrawable(paramDrawable);
    this.g = (paramDrawable instanceof AnimationDrawable);
    onLoadingDrawableSet(paramDrawable);
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.k = paramCharSequence;
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.l = paramCharSequence;
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    this.h.setTypeface(paramTypeface);
  }
  
  public final void setWidth(int paramInt)
  {
    getLayoutParams().width = paramInt;
    requestLayout();
  }
  
  public final void showInvisibleViews()
  {
    if (4 == this.h.getVisibility()) {
      this.h.setVisibility(0);
    }
    if (4 == this.c.getVisibility()) {
      this.c.setVisibility(0);
    }
    if (4 == this.b.getVisibility()) {
      this.b.setVisibility(0);
    }
    if (4 == this.i.getVisibility()) {
      this.i.setVisibility(0);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/widget/internal/LoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */