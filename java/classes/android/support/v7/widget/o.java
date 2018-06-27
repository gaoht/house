package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class o
  implements r
{
  private ai a(q paramq)
  {
    return (ai)paramq.getCardBackground();
  }
  
  public ColorStateList getBackgroundColor(q paramq)
  {
    return a(paramq).getColor();
  }
  
  public float getElevation(q paramq)
  {
    return paramq.getCardView().getElevation();
  }
  
  public float getMaxElevation(q paramq)
  {
    return a(paramq).a();
  }
  
  public float getMinHeight(q paramq)
  {
    return getRadius(paramq) * 2.0F;
  }
  
  public float getMinWidth(q paramq)
  {
    return getRadius(paramq) * 2.0F;
  }
  
  public float getRadius(q paramq)
  {
    return a(paramq).getRadius();
  }
  
  public void initStatic() {}
  
  public void initialize(q paramq, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramq.setCardBackground(new ai(paramColorStateList, paramFloat1));
    paramContext = paramq.getCardView();
    paramContext.setClipToOutline(true);
    paramContext.setElevation(paramFloat2);
    setMaxElevation(paramq, paramFloat3);
  }
  
  public void onCompatPaddingChanged(q paramq)
  {
    setMaxElevation(paramq, getMaxElevation(paramq));
  }
  
  public void onPreventCornerOverlapChanged(q paramq)
  {
    setMaxElevation(paramq, getMaxElevation(paramq));
  }
  
  public void setBackgroundColor(q paramq, ColorStateList paramColorStateList)
  {
    a(paramq).setColor(paramColorStateList);
  }
  
  public void setElevation(q paramq, float paramFloat)
  {
    paramq.getCardView().setElevation(paramFloat);
  }
  
  public void setMaxElevation(q paramq, float paramFloat)
  {
    a(paramq).a(paramFloat, paramq.getUseCompatPadding(), paramq.getPreventCornerOverlap());
    updatePadding(paramq);
  }
  
  public void setRadius(q paramq, float paramFloat)
  {
    a(paramq).a(paramFloat);
  }
  
  public void updatePadding(q paramq)
  {
    if (!paramq.getUseCompatPadding())
    {
      paramq.setShadowPadding(0, 0, 0, 0);
      return;
    }
    float f1 = getMaxElevation(paramq);
    float f2 = getRadius(paramq);
    int i = (int)Math.ceil(aj.b(f1, f2, paramq.getPreventCornerOverlap()));
    int j = (int)Math.ceil(aj.a(f1, f2, paramq.getPreventCornerOverlap()));
    paramq.setShadowPadding(i, j, i, j);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */