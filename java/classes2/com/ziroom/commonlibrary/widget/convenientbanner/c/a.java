package com.ziroom.commonlibrary.widget.convenientbanner.c;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import java.util.ArrayList;

public class a
  implements ViewPager.OnPageChangeListener
{
  private ArrayList<ImageView> a;
  private int[] b;
  private ViewPager.OnPageChangeListener c;
  
  public a(ArrayList<ImageView> paramArrayList, int[] paramArrayOfInt)
  {
    this.a = paramArrayList;
    this.b = paramArrayOfInt;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.c != null) {
      this.c.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.c != null) {
      this.c.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((ImageView)this.a.get(paramInt)).setImageResource(this.b[1]);
      if (paramInt != i) {
        ((ImageView)this.a.get(i)).setImageResource(this.b[0]);
      }
      i += 1;
    }
    if (this.c != null) {
      this.c.onPageSelected(paramInt);
    }
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.c = paramOnPageChangeListener;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/convenientbanner/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */