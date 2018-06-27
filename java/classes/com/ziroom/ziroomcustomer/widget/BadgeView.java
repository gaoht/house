package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TabWidget;
import android.widget.TextView;

public class BadgeView
  extends TextView
{
  private static final int e = Color.parseColor("#CCFF0000");
  private static Animation f;
  private static Animation g;
  private int a = 5;
  private int b = 5;
  private int c = 8;
  private int d = 0;
  private Context h;
  private View i;
  private int j;
  private int k;
  private int l;
  private int m;
  private boolean n;
  private ShapeDrawable o;
  private int p;
  
  public BadgeView(Context paramContext)
  {
    this(paramContext, (AttributeSet)null, 16842884);
  }
  
  public BadgeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public BadgeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, null, 0);
  }
  
  public BadgeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, View paramView, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    a(paramContext, paramView, paramInt2);
  }
  
  public BadgeView(Context paramContext, View paramView)
  {
    this(paramContext, null, 16842884, paramView, 0);
  }
  
  public BadgeView(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    this(paramContext, null, 16842884, paramView, 0);
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public BadgeView(Context paramContext, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramContext, null, 16842884, paramView, 0);
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public BadgeView(Context paramContext, TabWidget paramTabWidget, int paramInt)
  {
    this(paramContext, null, 16842884, paramTabWidget, paramInt);
  }
  
  private int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  private void a()
  {
    FrameLayout.LayoutParams localLayoutParams;
    if (this.d == 0)
    {
      localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      switch (this.j)
      {
      }
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      return;
      localLayoutParams = new FrameLayout.LayoutParams(a(this.c), a(this.c));
      break;
      localLayoutParams.gravity = 51;
      localLayoutParams.setMargins(this.k, this.l, 0, 0);
      continue;
      localLayoutParams.gravity = 53;
      localLayoutParams.setMargins(0, this.l, this.k, 0);
      continue;
      localLayoutParams.gravity = 83;
      localLayoutParams.setMargins(this.k, 0, 0, this.l);
      continue;
      localLayoutParams.gravity = 85;
      localLayoutParams.setMargins(0, 0, this.k, this.l);
      continue;
      localLayoutParams.gravity = 17;
      localLayoutParams.setMargins(0, 0, 0, 0);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt)
  {
    this.h = paramContext;
    this.i = paramView;
    this.p = paramInt;
    this.j = 2;
    this.k = a(this.a);
    this.l = this.k;
    this.m = e;
    setTypeface(Typeface.DEFAULT_BOLD);
    paramInt = a(this.b);
    setPadding(paramInt, 0, paramInt, 0);
    setTextColor(-1);
    f = new AlphaAnimation(0.0F, 1.0F);
    f.setInterpolator(new DecelerateInterpolator());
    f.setDuration(200L);
    g = new AlphaAnimation(1.0F, 0.0F);
    g.setInterpolator(new AccelerateInterpolator());
    g.setDuration(200L);
    this.n = false;
    if (this.i != null)
    {
      a(this.i);
      return;
    }
    show();
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = paramView.getParent();
    FrameLayout localFrameLayout = new FrameLayout(this.h);
    if ((paramView instanceof TabWidget))
    {
      paramView = ((TabWidget)paramView).getChildTabViewAt(this.p);
      this.i = paramView;
      ((ViewGroup)paramView).addView(localFrameLayout, new ViewGroup.LayoutParams(-1, -1));
      setVisibility(8);
      localFrameLayout.addView(this);
      return;
    }
    localObject = (ViewGroup)localObject;
    int i1 = ((ViewGroup)localObject).indexOfChild(paramView);
    ((ViewGroup)localObject).removeView(paramView);
    ((ViewGroup)localObject).addView(localFrameLayout, i1, localLayoutParams);
    localFrameLayout.addView(paramView);
    setVisibility(8);
    localFrameLayout.addView(this);
    ((ViewGroup)localObject).invalidate();
  }
  
  private void a(boolean paramBoolean, Animation paramAnimation)
  {
    if (getBackground() == null)
    {
      if (this.o == null) {
        this.o = getDefaultBackground();
      }
      setBackgroundDrawable(this.o);
    }
    a();
    if (paramBoolean) {
      startAnimation(paramAnimation);
    }
    setVisibility(0);
    this.n = true;
  }
  
  private void a(boolean paramBoolean, Animation paramAnimation1, Animation paramAnimation2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.n)
    {
      if ((paramBoolean) && (paramAnimation2 != null)) {}
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        b(paramBoolean, paramAnimation2);
        return;
      }
    }
    if ((paramBoolean) && (paramAnimation1 != null)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      a(paramBoolean, paramAnimation1);
      return;
    }
  }
  
  private void b(boolean paramBoolean, Animation paramAnimation)
  {
    setVisibility(8);
    if (paramBoolean) {
      startAnimation(paramAnimation);
    }
    this.n = false;
  }
  
  private ShapeDrawable getDefaultBackground()
  {
    int i1 = a(this.c);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { i1, i1, i1, i1, i1, i1, i1, i1 }, null, null));
    localShapeDrawable.getPaint().setColor(this.m);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    return localShapeDrawable;
  }
  
  public int decrement(int paramInt)
  {
    return increment(-paramInt);
  }
  
  public int getBadgeBackgroundColor()
  {
    return this.m;
  }
  
  public int getBadgePosition()
  {
    return this.j;
  }
  
  public int getHorizontalBadgeMargin()
  {
    return this.k;
  }
  
  public View getTarget()
  {
    return this.i;
  }
  
  public int getVerticalBadgeMargin()
  {
    return this.l;
  }
  
  public void hide()
  {
    b(false, null);
  }
  
  public void hide(Animation paramAnimation)
  {
    b(true, paramAnimation);
  }
  
  public void hide(boolean paramBoolean)
  {
    b(paramBoolean, g);
  }
  
  public int increment(int paramInt)
  {
    int i2 = 0;
    CharSequence localCharSequence = getText();
    int i1 = i2;
    if (localCharSequence != null) {}
    try
    {
      i1 = Integer.parseInt(localCharSequence.toString());
      if (i1 == 0)
      {
        setText("");
        return i1;
      }
      paramInt = i1 + paramInt;
      setText(String.valueOf(paramInt));
      return paramInt;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
  }
  
  public boolean isShown()
  {
    return this.n;
  }
  
  public void setBadgeBackgroundColor(int paramInt)
  {
    this.m = paramInt;
    this.o = getDefaultBackground();
  }
  
  public void setBadgeMargin(int paramInt)
  {
    this.k = paramInt;
    this.l = paramInt;
  }
  
  public void setBadgeMargin(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
  }
  
  public void setBadgePosition(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void show()
  {
    a(false, null);
  }
  
  public void show(Animation paramAnimation)
  {
    a(true, paramAnimation);
  }
  
  public void show(boolean paramBoolean)
  {
    a(paramBoolean, f);
  }
  
  public void toggle()
  {
    a(false, null, null);
  }
  
  public void toggle(Animation paramAnimation1, Animation paramAnimation2)
  {
    a(true, paramAnimation1, paramAnimation2);
  }
  
  public void toggle(boolean paramBoolean)
  {
    a(paramBoolean, f, g);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/BadgeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */