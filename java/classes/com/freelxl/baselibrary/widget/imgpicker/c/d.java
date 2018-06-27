package com.freelxl.baselibrary.widget.imgpicker.c;

import android.hardware.Camera;

public class d
{
  public static boolean isCameraCanUse()
  {
    Object localObject = null;
    try
    {
      Camera localCamera = Camera.open();
      localObject = localCamera;
      localCamera.setParameters(localCamera.getParameters());
      bool = true;
      localObject = localCamera;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    if (localObject != null) {
      ((Camera)localObject).release();
    }
    return bool;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/imgpicker/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */