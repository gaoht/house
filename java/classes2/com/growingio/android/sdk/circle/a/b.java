package com.growingio.android.sdk.circle.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.growingio.android.sdk.models.c.a;
import com.growingio.android.sdk.models.i;

public class b
{
  public int a;
  public int b;
  public double c;
  public View d;
  public ImageView e;
  
  public b(i parami, c.a parama)
  {
    this.a = parama.a();
    this.b = parama.b();
    this.c = parama.c();
    this.d = parami.c;
  }
  
  public void a() {}
  
  public void a(Context paramContext, Bitmap paramBitmap)
  {
    this.e = new ImageView(paramContext);
    this.e.setImageBitmap(paramBitmap);
    this.e.setLayoutParams(new FrameLayout.LayoutParams(this.d.getWidth(), this.d.getHeight()));
    this.e.setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  public void b()
  {
    if (this.e == null) {}
    int i;
    int j;
    int[] arrayOfInt;
    do
    {
      return;
      i = this.d.getWidth();
      j = this.d.getHeight();
      arrayOfInt = new int[2];
      this.d.getLocationOnScreen(arrayOfInt);
      localLayoutParams = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    } while ((localLayoutParams != null) && (localLayoutParams.width == i) && (localLayoutParams.height == j) && (localLayoutParams.leftMargin == arrayOfInt[0]) && (localLayoutParams.topMargin == arrayOfInt[1]));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, j);
    localLayoutParams.leftMargin = arrayOfInt[0];
    localLayoutParams.topMargin = arrayOfInt[1];
    this.e.setLayoutParams(localLayoutParams);
  }
  
  @TargetApi(11)
  public boolean c()
  {
    if ((this.d.getVisibility() != 0) || (this.d.getAlpha() == 0.0F)) {}
    View localView;
    do
    {
      return false;
      localView = this.d.getRootView();
    } while ((localView == null) || (localView.getParent() == null));
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */