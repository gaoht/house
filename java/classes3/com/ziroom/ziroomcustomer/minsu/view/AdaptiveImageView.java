package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class AdaptiveImageView
  extends ImageView
{
  private int a = 0;
  private int b = 0;
  private float c = 0.0F;
  
  public AdaptiveImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdaptiveImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdaptiveImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = getDrawable();
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((getWidth() == 0) || (getHeight() == 0));
        measure(0, 0);
      } while (localObject.getClass() == NinePatchDrawable.class);
      localObject = ((BitmapDrawable)localObject).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
    } while ((((Bitmap)localObject).getWidth() == 0) || (((Bitmap)localObject).getHeight() == 0));
    if (this.a == 0) {
      this.a = getWidth();
    }
    if (this.b == 0) {
      this.b = getHeight();
    }
    this.c = (this.a / ((Bitmap)localObject).getWidth());
    this.b = Math.round(((Bitmap)localObject).getHeight() * this.c);
    localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.a;
    ((ViewGroup.LayoutParams)localObject).height = this.a;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    super.onDraw(paramCanvas);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/AdaptiveImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */