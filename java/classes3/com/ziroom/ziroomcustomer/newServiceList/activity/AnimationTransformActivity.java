package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.ziroom.ziroomcustomer.util.n;

public class AnimationTransformActivity
  extends FragmentActivity
{
  private static final AccelerateDecelerateInterpolator a = new AccelerateDecelerateInterpolator();
  private ImageView b;
  private RelativeLayout c;
  private Bundle d = new Bundle();
  private Bundle e = new Bundle();
  private int f;
  private int g;
  private int h;
  private int i;
  private Rect j;
  private AnimationTransformActivity k;
  
  private void a()
  {
    this.j = getIntent().getSourceBounds();
    this.h = (this.j.right - this.j.left);
    this.i = (this.j.bottom - this.j.top);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.h, this.i);
    localLayoutParams.setMargins(this.j.left, this.j.top - f(), this.j.right, this.j.bottom);
    this.b.setLayoutParams(localLayoutParams);
    this.b.setImageResource(2130840390);
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    b();
  }
  
  private void b()
  {
    float f1 = this.f - n.dip2px(this.k, 88.0F);
    float f2 = this.g * 391 / 667;
    this.d.putFloat("SCALE_WIDTH", f1 / this.h);
    this.d.putFloat("SCALE_HEIGHT", this.g / this.i);
    this.e.putFloat("TRANSITION_X", this.f / 2 - (this.j.left + (this.j.right - this.j.left) / 2));
    this.e.putFloat("TRANSITION_Y", this.g / 2 - (this.j.top + (this.j.bottom - this.j.top) / 2));
  }
  
  private void c()
  {
    this.b.animate().setInterpolator(a).setDuration(300L).scaleX(this.d.getFloat("SCALE_WIDTH")).scaleY(this.d.getFloat("SCALE_HEIGHT")).translationX(this.e.getFloat("TRANSITION_X")).translationY(this.e.getFloat("TRANSITION_Y")).start();
    this.b.setVisibility(0);
  }
  
  private void d()
  {
    this.b.animate().setInterpolator(a).setDuration(300L).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).withEndAction(new Runnable()
    {
      public void run()
      {
        AnimationTransformActivity.this.finish();
        AnimationTransformActivity.this.overridePendingTransition(0, 0);
      }
    }).start();
  }
  
  private void e()
  {
    Display localDisplay = getWindowManager().getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    this.f = localPoint.x;
    this.g = localPoint.y;
  }
  
  private int f()
  {
    int m = getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (m > 0) {
      return getResources().getDimensionPixelSize(m);
    }
    return -1;
  }
  
  public void onBackPressed()
  {
    d();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903093);
    this.k = this;
    e();
    this.b = ((ImageView)findViewById(2131689907));
    this.c = ((RelativeLayout)findViewById(2131689906));
    a();
    c();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/AnimationTransformActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */