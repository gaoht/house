package com.ziroom.ziroomcustomer.newmovehouse.widget.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.g;

public class RotateLoadingLayout
  extends LoadingLayout
{
  private final Animation f;
  private final Matrix g;
  private float h;
  private float i;
  private final boolean j;
  
  public RotateLoadingLayout(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.g paramg, TypedArray paramTypedArray)
  {
    super(paramContext, paramb, paramg, paramTypedArray);
    this.j = paramTypedArray.getBoolean(15, true);
    this.b.setScaleType(ImageView.ScaleType.MATRIX);
    this.g = new Matrix();
    this.b.setImageMatrix(this.g);
    this.f = new RotateAnimation(0.0F, 720.0F, 1, 0.5F, 1, 0.5F);
    this.f.setInterpolator(a);
    this.f.setDuration(1200L);
    this.f.setRepeatCount(-1);
    this.f.setRepeatMode(1);
  }
  
  private void e()
  {
    if (this.g != null)
    {
      this.g.reset();
      this.b.setImageMatrix(this.g);
    }
  }
  
  protected void a() {}
  
  protected void a(float paramFloat)
  {
    if (this.j) {}
    for (paramFloat = 90.0F * paramFloat;; paramFloat = Math.max(0.0F, Math.min(180.0F, 360.0F * paramFloat - 180.0F)))
    {
      this.g.setRotate(paramFloat, this.h, this.i);
      this.b.setImageMatrix(this.g);
      return;
    }
  }
  
  protected void b()
  {
    this.b.startAnimation(this.f);
  }
  
  protected void c() {}
  
  protected void d()
  {
    this.b.clearAnimation();
    e();
  }
  
  protected int getDefaultDrawableResId()
  {
    return 2130838352;
  }
  
  public void onLoadingDrawableSet(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.h = Math.round(paramDrawable.getIntrinsicWidth() / 2.0F);
      this.i = Math.round(paramDrawable.getIntrinsicHeight() / 2.0F);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/widget/internal/RotateLoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */