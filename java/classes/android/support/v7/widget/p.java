package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

class p
  implements r
{
  private final RectF a = new RectF();
  
  private aj a(Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new aj(paramContext.getResources(), paramColorStateList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  private aj a(q paramq)
  {
    return (aj)paramq.getCardBackground();
  }
  
  public ColorStateList getBackgroundColor(q paramq)
  {
    return a(paramq).f();
  }
  
  public float getElevation(q paramq)
  {
    return a(paramq).b();
  }
  
  public float getMaxElevation(q paramq)
  {
    return a(paramq).c();
  }
  
  public float getMinHeight(q paramq)
  {
    return a(paramq).e();
  }
  
  public float getMinWidth(q paramq)
  {
    return a(paramq).d();
  }
  
  public float getRadius(q paramq)
  {
    return a(paramq).a();
  }
  
  public void initStatic()
  {
    aj.a = new aj.a()
    {
      public void drawRoundRect(Canvas paramAnonymousCanvas, RectF paramAnonymousRectF, float paramAnonymousFloat, Paint paramAnonymousPaint)
      {
        float f1 = 2.0F * paramAnonymousFloat;
        float f2 = paramAnonymousRectF.width() - f1 - 1.0F;
        float f3 = paramAnonymousRectF.height();
        if (paramAnonymousFloat >= 1.0F)
        {
          float f4 = paramAnonymousFloat + 0.5F;
          p.a(p.this).set(-f4, -f4, f4, f4);
          int i = paramAnonymousCanvas.save();
          paramAnonymousCanvas.translate(paramAnonymousRectF.left + f4, paramAnonymousRectF.top + f4);
          paramAnonymousCanvas.drawArc(p.a(p.this), 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f2, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(p.a(p.this), 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f3 - f1 - 1.0F, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(p.a(p.this), 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f2, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(p.a(p.this), 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.restoreToCount(i);
          paramAnonymousCanvas.drawRect(paramAnonymousRectF.left + f4 - 1.0F, paramAnonymousRectF.top, 1.0F + (paramAnonymousRectF.right - f4), paramAnonymousRectF.top + f4, paramAnonymousPaint);
          paramAnonymousCanvas.drawRect(paramAnonymousRectF.left + f4 - 1.0F, paramAnonymousRectF.bottom - f4, 1.0F + (paramAnonymousRectF.right - f4), paramAnonymousRectF.bottom, paramAnonymousPaint);
        }
        paramAnonymousCanvas.drawRect(paramAnonymousRectF.left, paramAnonymousRectF.top + paramAnonymousFloat, paramAnonymousRectF.right, paramAnonymousRectF.bottom - paramAnonymousFloat, paramAnonymousPaint);
      }
    };
  }
  
  public void initialize(q paramq, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramContext = a(paramContext, paramColorStateList, paramFloat1, paramFloat2, paramFloat3);
    paramContext.a(paramq.getPreventCornerOverlap());
    paramq.setCardBackground(paramContext);
    updatePadding(paramq);
  }
  
  public void onCompatPaddingChanged(q paramq) {}
  
  public void onPreventCornerOverlapChanged(q paramq)
  {
    a(paramq).a(paramq.getPreventCornerOverlap());
    updatePadding(paramq);
  }
  
  public void setBackgroundColor(q paramq, ColorStateList paramColorStateList)
  {
    a(paramq).a(paramColorStateList);
  }
  
  public void setElevation(q paramq, float paramFloat)
  {
    a(paramq).b(paramFloat);
  }
  
  public void setMaxElevation(q paramq, float paramFloat)
  {
    a(paramq).c(paramFloat);
    updatePadding(paramq);
  }
  
  public void setRadius(q paramq, float paramFloat)
  {
    a(paramq).a(paramFloat);
    updatePadding(paramq);
  }
  
  public void updatePadding(q paramq)
  {
    Rect localRect = new Rect();
    a(paramq).a(localRect);
    paramq.setMinWidthHeightInternal((int)Math.ceil(getMinWidth(paramq)), (int)Math.ceil(getMinHeight(paramq)));
    paramq.setShadowPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */