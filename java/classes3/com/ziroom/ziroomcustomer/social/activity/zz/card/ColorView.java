package com.ziroom.ziroomcustomer.social.activity.zz.card;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class ColorView
  extends View
{
  boolean a = true;
  private int b = 0;
  private int c = 0;
  private Paint d = new Paint();
  
  public ColorView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ColorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ColorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void StartAnimation()
  {
    boolean bool = true;
    ObjectAnimator localObjectAnimator1;
    ObjectAnimator localObjectAnimator2;
    AnimatorSet localAnimatorSet;
    if (this.a)
    {
      localObjectAnimator1 = ObjectAnimator.ofFloat(this, "TranslationX", new float[] { 0.0F });
      localObjectAnimator2 = ObjectAnimator.ofFloat(this, "TranslationY", new float[] { this.c / 2 });
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
      localAnimatorSet.setDuration(700L);
      localAnimatorSet.start();
      if (this.a) {
        break label161;
      }
    }
    for (;;)
    {
      this.a = bool;
      return;
      localObjectAnimator1 = ObjectAnimator.ofFloat(this, "TranslationX", new float[] { this.b / 2 });
      localObjectAnimator2 = ObjectAnimator.ofFloat(this, "TranslationY", new float[] { 0.0F });
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
      localAnimatorSet.setDuration(700L);
      localAnimatorSet.start();
      break;
      label161:
      bool = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = this.c;
    float f2 = this.b;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, f1, f2, 0.0F, new int[] { -13622405, -8774266, -8182491 }, null, (Shader.TileMode)localObject);
    this.d.setShader((Shader)localObject);
    this.d.setStyle(Paint.Style.FILL);
    paramCanvas.save();
    paramCanvas.drawRect(new RectF(0.0F, 0.0F, this.b, this.c), this.d);
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.b = View.MeasureSpec.getSize(paramInt1);
    this.c = View.MeasureSpec.getSize(paramInt2);
    setMeasuredDimension(this.b, this.c);
    setScaleX(2.0F);
    setScaleY(2.0F);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/card/ColorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */