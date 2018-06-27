package com.superrtc.call;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class c
{
  private static c a = new d();
  
  private static String a(int paramInt)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = 0;
    while (i < Camera.getNumberOfCameras()) {
      try
      {
        Camera.getCameraInfo(i, localCameraInfo);
        if (localCameraInfo.facing == paramInt)
        {
          String str = getDeviceName(i);
          return str;
        }
      }
      catch (Exception localException)
      {
        Logging.e("CameraEnumerationAndroid", "getCameraInfo() failed on index " + i, localException);
        i += 1;
      }
    }
    return null;
  }
  
  public static Camera.Size getClosestSupportedSize(List<Camera.Size> paramList, int paramInt1, final int paramInt2)
  {
    (Camera.Size)Collections.min(paramList, new b(paramInt1)
    {
      int a(Camera.Size paramAnonymousSize)
      {
        return Math.abs(this.a - paramAnonymousSize.width) + Math.abs(paramInt2 - paramAnonymousSize.height);
      }
    });
  }
  
  public static int getDeviceCount()
  {
    return Camera.getNumberOfCameras();
  }
  
  public static String getDeviceName(int paramInt)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    for (;;)
    {
      try
      {
        Camera.getCameraInfo(paramInt, localCameraInfo);
        if (localCameraInfo.facing == 1)
        {
          String str1 = "front";
          return "Camera " + paramInt + ", Facing " + str1 + ", Orientation " + localCameraInfo.orientation;
        }
      }
      catch (Exception localException)
      {
        Logging.e("CameraEnumerationAndroid", "getCameraInfo failed on index " + paramInt, localException);
        return null;
      }
      String str2 = "back";
    }
  }
  
  public static String[] getDeviceNames()
  {
    String[] arrayOfString = new String[Camera.getNumberOfCameras()];
    int i = 0;
    while (i < Camera.getNumberOfCameras())
    {
      arrayOfString[i] = getDeviceName(i);
      i += 1;
    }
    return arrayOfString;
  }
  
  public static int[] getFramerateRange(Camera.Parameters paramParameters, int paramInt)
  {
    paramParameters = paramParameters.getSupportedPreviewFpsRange();
    if (paramParameters.isEmpty())
    {
      Logging.w("CameraEnumerationAndroid", "No supported preview fps range");
      return new int[] { 0, 0 };
    }
    (int[])Collections.min(paramParameters, new b(paramInt)
    {
      int a(int[] paramAnonymousArrayOfInt)
      {
        return paramAnonymousArrayOfInt[0] + Math.abs(this.a - paramAnonymousArrayOfInt[1]) * 10;
      }
    });
  }
  
  public static String getNameOfBackFacingDevice()
  {
    return a(0);
  }
  
  public static String getNameOfFrontFacingDevice()
  {
    return a(1);
  }
  
  public static List<a> getSupportedFormats(int paramInt)
  {
    try
    {
      List localList = a.getSupportedFormats(paramInt);
      Logging.d("CameraEnumerationAndroid", "Supported formats for camera " + paramInt + ": " + localList);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void setEnumerator(c paramc)
  {
    try
    {
      a = paramc;
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public static class a
  {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e = 17;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.d = paramInt3;
      this.c = paramInt4;
    }
    
    public static int frameSize(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt3 != 17) {
        throw new UnsupportedOperationException("Don't know how to calculate the frame size of non-NV21 image formats.");
      }
      return paramInt1 * paramInt2 * ImageFormat.getBitsPerPixel(paramInt3) / 8;
    }
    
    public int frameSize()
    {
      return frameSize(this.a, this.b, 17);
    }
    
    public boolean isSameFormat(a parama)
    {
      if (parama == null) {}
      while ((this.a != parama.a) || (this.b != parama.b) || (this.c != parama.c) || (this.d != parama.d)) {
        return false;
      }
      return true;
    }
    
    public String toString()
    {
      return this.a + "x" + this.b + "@[" + this.d + ":" + this.c + "]";
    }
  }
  
  private static abstract class b<T>
    implements Comparator<T>
  {
    abstract int a(T paramT);
    
    public int compare(T paramT1, T paramT2)
    {
      return a(paramT1) - a(paramT2);
    }
  }
  
  public static abstract interface c
  {
    public abstract List<c.a> getSupportedFormats(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */