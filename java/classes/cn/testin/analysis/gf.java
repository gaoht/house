package cn.testin.analysis;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.view.Display;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

final class gf
{
  private static final Pattern a = Pattern.compile(",");
  private final Context b;
  private Point c;
  private Point d;
  
  public gf(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private static int a(CharSequence paramCharSequence, int paramInt)
  {
    paramCharSequence = a.split(paramCharSequence);
    int m = paramCharSequence.length;
    int j = 0;
    int i = 0;
    String str;
    if (j < m) {
      str = paramCharSequence[j].trim();
    }
    label86:
    for (;;)
    {
      try
      {
        double d1 = Double.parseDouble(str);
        int k = (int)(10.0D * d1);
        if (Math.abs(paramInt - d1) >= Math.abs(paramInt - i)) {
          break label86;
        }
        i = k;
        j += 1;
      }
      catch (NumberFormatException paramCharSequence)
      {
        return paramInt;
      }
      return i;
    }
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    Point localPoint = a(paramParameters.getSupportedPreviewSizes(), paramPoint);
    paramParameters = localPoint;
    if (localPoint == null) {
      paramParameters = new Point(paramPoint.x >> 3 << 3, paramPoint.y >> 3 << 3);
    }
    return paramParameters;
  }
  
  private static Point a(List<Camera.Size> paramList, Point paramPoint)
  {
    paramList = paramList.iterator();
    int j = 0;
    int i = 0;
    int k = Integer.MAX_VALUE;
    int m;
    int n;
    int i1;
    if (paramList.hasNext())
    {
      Camera.Size localSize = (Camera.Size)paramList.next();
      m = localSize.width;
      n = localSize.height;
      i1 = Math.abs(m - paramPoint.x) + Math.abs(n - paramPoint.y);
      if (i1 != 0) {}
    }
    for (;;)
    {
      if ((m > 0) && (n > 0))
      {
        return new Point(m, n);
        if (i1 >= k) {
          break label131;
        }
        j = n;
        k = m;
        i = i1;
      }
      for (;;)
      {
        m = k;
        k = i;
        i = m;
        break;
        return null;
        label131:
        m = i;
        i = k;
        k = m;
      }
      n = j;
      m = i;
    }
  }
  
  private void a(Camera.Parameters paramParameters)
  {
    String str1 = paramParameters.get("zoom-supported");
    if ((str1 != null) && (!Boolean.parseBoolean(str1))) {}
    do
    {
      return;
      j = 27;
      str1 = paramParameters.get("max-zoom");
      i = j;
      if (str1 != null) {}
      try
      {
        double d1 = Double.parseDouble(str1);
        i = (int)(d1 * 10.0D);
        if (27 <= i) {
          break;
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        for (;;)
        {
          String str2;
          i = j;
          continue;
          i = 27;
        }
      }
      str2 = paramParameters.get("taking-picture-zoom-max");
      j = i;
      if (str2 != null) {}
      try
      {
        k = Integer.parseInt(str2);
        j = i;
        if (i > k) {
          j = k;
        }
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          int k;
          String str3;
          String str4;
          j = i;
        }
      }
      str3 = paramParameters.get("mot-zoom-values");
      i = j;
      if (str3 != null) {
        i = a(str3, j);
      }
      str4 = paramParameters.get("mot-zoom-step");
      j = i;
      if (str4 != null) {}
      try
      {
        k = (int)(Double.parseDouble(str4.trim()) * 10.0D);
        j = i;
        if (k > 1) {
          j = i - i % k;
        }
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        for (;;)
        {
          j = i;
        }
      }
      if ((str1 != null) || (str3 != null)) {
        paramParameters.set("zoom", String.valueOf(j / 10.0D));
      }
    } while (str2 == null);
    paramParameters.set("taking-picture-zoom", j);
  }
  
  public Point a()
  {
    return this.d;
  }
  
  public void a(Camera paramCamera)
  {
    paramCamera = paramCamera.getParameters();
    Object localObject = ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay();
    this.c = new Point(((Display)localObject).getWidth(), ((Display)localObject).getHeight());
    localObject = new Point();
    ((Point)localObject).x = this.c.x;
    ((Point)localObject).y = this.c.y;
    if (this.c.x < this.c.y)
    {
      ((Point)localObject).x = this.c.y;
      ((Point)localObject).y = this.c.x;
    }
    this.d = a(paramCamera, (Point)localObject);
  }
  
  public int b()
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(0, localCameraInfo);
    int i;
    switch (((WindowManager)this.b.getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      i = 0;
    }
    while (localCameraInfo.facing == 1)
    {
      return (360 - (i + localCameraInfo.orientation) % 360) % 360;
      i = 0;
      continue;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
    return (localCameraInfo.orientation - i + 360) % 360;
  }
  
  public void b(Camera paramCamera)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    localParameters.setPreviewSize(this.d.x, this.d.y);
    a(localParameters);
    paramCamera.setDisplayOrientation(b());
    paramCamera.setParameters(localParameters);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/gf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */