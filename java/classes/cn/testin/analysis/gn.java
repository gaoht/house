package cn.testin.analysis;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public abstract class gn
  extends RelativeLayout
  implements Camera.PreviewCallback, gl
{
  protected Camera a;
  protected gg b;
  protected gr c;
  protected gq d;
  protected Handler e = new Handler();
  protected boolean f = false;
  protected gk g;
  private Runnable h = new gp(this);
  
  public gn(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.b = new gg(getContext());
    this.c = new gr(getContext());
    addView(this.b);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.c, paramContext);
  }
  
  private void c(int paramInt)
  {
    try
    {
      this.a = Camera.open(paramInt);
      this.b.setCamera(this.a);
      return;
    }
    catch (Exception localException)
    {
      while (this.d == null) {}
      this.d.b();
    }
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a != null) {}
    for (;;)
    {
      return;
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      int i = 0;
      while (i < Camera.getNumberOfCameras())
      {
        Camera.getCameraInfo(i, localCameraInfo);
        if (localCameraInfo.facing == paramInt)
        {
          c(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void b()
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
  }
  
  public void b(int paramInt)
  {
    this.f = true;
    c();
    this.e.removeCallbacks(this.h);
    this.e.postDelayed(this.h, paramInt);
  }
  
  public void c()
  {
    a(0);
  }
  
  public void d()
  {
    try
    {
      g();
      if (this.a != null)
      {
        this.b.b();
        this.b.setCamera(null);
        this.a.release();
        this.a = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void e()
  {
    b(1500);
  }
  
  public void f()
  {
    i();
    this.f = false;
    if (this.a != null) {}
    try
    {
      this.a.setOneShotPreviewCallback(null);
      if (this.e != null) {
        this.e.removeCallbacks(this.h);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void g()
  {
    f();
    b();
  }
  
  public boolean getIsScanBarcodeStyle()
  {
    return this.c.getIsBarcode();
  }
  
  public gr getScanBoxView()
  {
    return this.c;
  }
  
  public void h()
  {
    d();
    this.e = null;
    this.d = null;
    this.h = null;
  }
  
  protected void i()
  {
    if (this.g != null)
    {
      this.g.b();
      this.g = null;
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.f)
    {
      i();
      this.g = new go(this, paramCamera, paramArrayOfByte, this, paramCamera).a();
    }
  }
  
  public void setDelegate(gq paramgq)
  {
    this.d = paramgq;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/gn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */