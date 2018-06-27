package cn.testin.analysis;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;

public class gg
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private static final String b = gg.class.getSimpleName();
  Camera.AutoFocusCallback a = new gj(this);
  private Camera c;
  private boolean d = true;
  private boolean e = true;
  private boolean f = false;
  private gf g;
  private Runnable h = new gi(this);
  
  public gg(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (this.c != null) {}
    try
    {
      this.d = true;
      this.c.setPreviewDisplay(getHolder());
      this.g.b(this.c);
      this.c.startPreview();
      if (this.e) {
        this.c.autoFocus(this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e(b, localException.toString(), localException);
    }
  }
  
  public void b()
  {
    if (this.c != null) {}
    try
    {
      removeCallbacks(this.h);
      this.d = false;
      this.c.cancelAutoFocus();
      this.c.setOneShotPreviewCallback(null);
      this.c.stopPreview();
      return;
    }
    catch (Exception localException)
    {
      Log.e(b, localException.toString(), localException);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    int j = getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    paramInt1 = j;
    paramInt2 = i;
    float f1;
    if (this.g != null)
    {
      paramInt1 = j;
      paramInt2 = i;
      if (this.g.a() != null)
      {
        Point localPoint = this.g.a();
        paramInt1 = localPoint.y;
        paramInt2 = localPoint.x;
        if (i * 1.0F / j >= paramInt1 * 1.0F / paramInt2) {
          break label128;
        }
        f1 = paramInt2 * 1.0F / paramInt1;
        paramInt2 = (int)(j / f1 + 0.5F);
        paramInt1 = j;
      }
    }
    for (;;)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
      return;
      label128:
      f1 = paramInt1 * 1.0F / paramInt2;
      paramInt1 = (int)(i / f1 + 0.5F);
      paramInt2 = i;
    }
  }
  
  public void setCamera(Camera paramCamera)
  {
    this.c = paramCamera;
    if (this.c != null)
    {
      this.g = new gf(getContext());
      this.g.a(this.c);
      getHolder().addCallback(this);
      if (this.d) {
        requestLayout();
      }
    }
    else
    {
      return;
    }
    a();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramSurfaceHolder.getSurface() == null) {
      return;
    }
    b();
    post(new gh(this));
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.f = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.f = false;
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */