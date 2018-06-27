package com.ziroom.ziroomcustomer.newmovehouse.widget.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.g;

@SuppressLint({"ViewConstructor"})
public class FlipLoadingLayout
  extends LoadingLayout
{
  private final Animation f;
  private final Animation g;
  
  public FlipLoadingLayout(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.g paramg, TypedArray paramTypedArray)
  {
    super(paramContext, paramb, paramg, paramTypedArray);
    if (paramb == PullToRefreshBase.b.b) {}
    for (int i = 65356;; i = 180)
    {
      this.f = new RotateAnimation(0.0F, i, 1, 0.5F, 1, 0.5F);
      this.f.setInterpolator(a);
      this.f.setDuration(150L);
      this.f.setFillAfter(true);
      this.g = new RotateAnimation(i, 0.0F, 1, 0.5F, 1, 0.5F);
      this.g.setInterpolator(a);
      this.g.setDuration(150L);
      this.g.setFillAfter(true);
      return;
    }
  }
  
  private float getDrawableRotationAngle()
  {
    switch (1.a[this.d.ordinal()])
    {
    }
    do
    {
      return 0.0F;
      if (this.e == PullToRefreshBase.g.b) {
        return 90.0F;
      }
      return 180.0F;
    } while (this.e != PullToRefreshBase.g.b);
    return 270.0F;
  }
  
  protected void a()
  {
    if (this.f == this.b.getAnimation()) {
      this.b.startAnimation(this.g);
    }
  }
  
  protected void a(float paramFloat) {}
  
  protected void b()
  {
    this.b.clearAnimation();
    this.b.setVisibility(4);
    this.c.setVisibility(0);
  }
  
  protected void c()
  {
    this.b.startAnimation(this.f);
  }
  
  protected void d()
  {
    this.b.clearAnimation();
    this.c.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  protected int getDefaultDrawableResId()
  {
    return 2130838351;
  }
  
  protected void onLoadingDrawableSet(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicHeight();
      int j = paramDrawable.getIntrinsicWidth();
      paramDrawable = this.b.getLayoutParams();
      int k = Math.max(i, j);
      paramDrawable.height = k;
      paramDrawable.width = k;
      this.b.requestLayout();
      this.b.setScaleType(ImageView.ScaleType.MATRIX);
      Matrix localMatrix = new Matrix();
      localMatrix.postTranslate((paramDrawable.width - j) / 2.0F, (paramDrawable.height - i) / 2.0F);
      localMatrix.postRotate(getDrawableRotationAngle(), paramDrawable.width / 2.0F, paramDrawable.height / 2.0F);
      this.b.setImageMatrix(localMatrix);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/widget/internal/FlipLoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */