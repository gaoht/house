package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.b;
import in.srain.cube.views.ptr.d;

public class MaterialHeader
  extends View
  implements b
{
  private a a;
  private float b = 1.0F;
  private PtrFrameLayout c;
  private Animation d = new Animation()
  {
    public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      MaterialHeader.a(MaterialHeader.this, 1.0F - paramAnonymousFloat);
      MaterialHeader.b(MaterialHeader.this).setAlpha((int)(255.0F * MaterialHeader.a(MaterialHeader.this)));
      MaterialHeader.this.invalidate();
    }
  };
  
  public MaterialHeader(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MaterialHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public MaterialHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new a(getContext(), this);
    this.a.setBackgroundColor(-1);
    this.a.setCallback(this);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.a)
    {
      invalidate();
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    Rect localRect = this.a.getBounds();
    paramCanvas.translate(getPaddingLeft() + (getMeasuredWidth() - this.a.getIntrinsicWidth()) / 2, getPaddingTop());
    paramCanvas.scale(this.b, this.b, localRect.exactCenterX(), localRect.exactCenterY());
    this.a.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = this.a.getIntrinsicHeight();
    this.a.setBounds(0, 0, paramInt1, paramInt1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.a.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom(), 1073741824));
  }
  
  public void onUIPositionChange(PtrFrameLayout paramPtrFrameLayout, boolean paramBoolean, byte paramByte, in.srain.cube.views.ptr.a.a parama)
  {
    float f = Math.min(1.0F, parama.getCurrentPercent());
    if (paramByte == 2)
    {
      this.a.setAlpha((int)(255.0F * f));
      this.a.showArrow(true);
      this.a.setStartEndTrim(0.0F, Math.min(0.8F, f * 0.8F));
      this.a.setArrowScale(Math.min(1.0F, f));
      this.a.setProgressRotation((f * 2.0F + (-0.25F + 0.4F * f)) * 0.5F);
      invalidate();
    }
  }
  
  public void onUIRefreshBegin(PtrFrameLayout paramPtrFrameLayout)
  {
    this.a.setAlpha(255);
    this.a.start();
  }
  
  public void onUIRefreshComplete(PtrFrameLayout paramPtrFrameLayout)
  {
    this.a.stop();
  }
  
  public void onUIRefreshPrepare(PtrFrameLayout paramPtrFrameLayout) {}
  
  public void onUIReset(PtrFrameLayout paramPtrFrameLayout)
  {
    this.b = 1.0F;
    this.a.stop();
  }
  
  public void setColorSchemeColors(int[] paramArrayOfInt)
  {
    this.a.setColorSchemeColors(paramArrayOfInt);
    invalidate();
  }
  
  public void setPtrFrameLayout(PtrFrameLayout paramPtrFrameLayout)
  {
    final d local2 = new d()
    {
      public void run()
      {
        MaterialHeader.this.startAnimation(MaterialHeader.c(MaterialHeader.this));
      }
    };
    this.d.setDuration(200L);
    this.d.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        local2.resume();
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.c = paramPtrFrameLayout;
    this.c.setRefreshCompleteHook(local2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/in/srain/cube/views/ptr/header/MaterialHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */