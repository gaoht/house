package com.ziroom.ziroomcustomer.ziroomapartment.a;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public class a
  implements ViewPager.PageTransformer
{
  public void transformPage(View paramView, float paramFloat)
  {
    float f = -1.0F;
    if (paramFloat <= -1.0F)
    {
      paramView.setPivotX(0.0F);
      paramView.setPivotY(paramView.getHeight());
      paramView.setRotation(7.0F * paramFloat);
      paramView.setVisibility(8);
    }
    do
    {
      return;
      if (paramFloat < 0.0F)
      {
        if (paramFloat < -0.87D) {}
        for (;;)
        {
          paramView.setAlpha(f + 1.0F);
          paramView.setPivotX(paramView.getWidth() - 20);
          paramView.setPivotY(paramView.getHeight() + 20);
          paramView.setRotation(7.0F * paramFloat);
          paramView.setVisibility(0);
          return;
          f = (paramFloat - 0.13F) * 6.0F + 5.0F;
        }
      }
      if (paramFloat == 0.0F)
      {
        paramView.setAlpha(1.0F);
        paramView.setPivotX(paramView.getWidth() / 2);
        paramView.setPivotY(paramView.getHeight());
        paramView.setRotation(paramFloat);
        paramView.setVisibility(0);
        return;
      }
      if (paramFloat < 1.0F)
      {
        if (paramFloat > 0.87D) {}
        for (f = 1.0F;; f = (0.13F + paramFloat) * 6.0F - 5.0F)
        {
          paramView.setAlpha(1.0F - f);
          paramView.setPivotX(20.0F);
          paramView.setPivotY(paramView.getHeight() + 20);
          paramView.setRotation(7.0F * paramFloat);
          paramView.setVisibility(0);
          return;
        }
      }
    } while (paramFloat < 1.0F);
    paramView.setPivotX(0.0F);
    paramView.setPivotY(paramView.getHeight());
    paramView.setVisibility(8);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */