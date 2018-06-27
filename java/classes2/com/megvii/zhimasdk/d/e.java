package com.megvii.zhimasdk.d;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class e
{
  public Camera a;
  public int b;
  public int c;
  public int d = 1;
  
  private Camera.Size a(Camera.Parameters paramParameters, final int paramInt1, final int paramInt2)
  {
    Object localObject = paramParameters.getSupportedPreviewSizes();
    paramParameters = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
      if (localSize.width > localSize.height) {
        paramParameters.add(localSize);
      }
    }
    Collections.sort(paramParameters, new Comparator()
    {
      public int a(Camera.Size paramAnonymousSize1, Camera.Size paramAnonymousSize2)
      {
        return Math.abs(paramAnonymousSize1.width * paramAnonymousSize1.height - paramInt1 * paramInt2) - Math.abs(paramAnonymousSize2.width * paramAnonymousSize2.height - paramInt1 * paramInt2);
      }
    });
    return (Camera.Size)paramParameters.get(0);
  }
  
  private static boolean a(int paramInt)
  {
    if (d() < 9) {}
    for (;;)
    {
      return false;
      int j = Camera.getNumberOfCameras();
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      int i = 0;
      while (i < j)
      {
        Camera.getCameraInfo(i, localCameraInfo);
        if (paramInt == localCameraInfo.facing) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean c()
  {
    return a(1);
  }
  
  public static int d()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public int a(Activity paramActivity)
  {
    int j = 0;
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(this.d, localCameraInfo);
    int i = j;
    switch (paramActivity.getWindowManager().getDefaultDisplay().getRotation())
    {
    default: 
      i = j;
    }
    while (localCameraInfo.facing == 1)
    {
      return (360 - (i + localCameraInfo.orientation) % 360) % 360;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
    return (localCameraInfo.orientation - i + 360) % 360;
  }
  
  public Camera a(Activity paramActivity, int paramInt)
  {
    try
    {
      this.d = paramInt;
      this.a = Camera.open(paramInt);
      Camera.getCameraInfo(paramInt, new Camera.CameraInfo());
      Camera.Parameters localParameters = this.a.getParameters();
      Camera.Size localSize = a(this.a.getParameters(), 640, 480);
      this.b = localSize.width;
      this.c = localSize.height;
      localParameters.setPreviewSize(this.b, this.c);
      if (localParameters.getSupportedFocusModes().contains("continuous-video")) {
        localParameters.setFocusMode("continuous-video");
      }
      this.a.setDisplayOrientation(a(paramActivity));
      this.a.setParameters(localParameters);
      paramActivity = this.a;
      return paramActivity;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return null;
  }
  
  public RelativeLayout.LayoutParams a()
  {
    Camera.Size localSize = this.a.getParameters().getPreviewSize();
    float f = Math.min(k.e * 1.0F / localSize.height, k.f * 1.0F / localSize.width);
    return new RelativeLayout.LayoutParams((int)(localSize.height * f), (int)(localSize.width * f));
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    if (this.a != null) {}
    try
    {
      this.a.setPreviewTexture(paramSurfaceTexture);
      this.a.startPreview();
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      paramSurfaceTexture.printStackTrace();
    }
  }
  
  public void a(Camera.PreviewCallback paramPreviewCallback)
  {
    try
    {
      if (this.a != null) {
        this.a.setPreviewCallback(paramPreviewCallback);
      }
      return;
    }
    catch (Exception paramPreviewCallback)
    {
      paramPreviewCallback.printStackTrace();
    }
  }
  
  public void b()
  {
    if (this.a != null) {}
    try
    {
      this.a.stopPreview();
      this.a.setPreviewCallback(null);
      this.a.release();
      this.a = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */