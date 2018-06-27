package com.ziroom.ziroomcustomer.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.Display;
import android.view.WindowManager;
import com.google.c.a.b;
import com.google.c.f;
import java.util.HashMap;
import java.util.Map;

public class z
{
  private static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBitmap1 == null) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      return null;
      if (paramBitmap2 == null) {
        return paramBitmap1;
      }
      i = paramBitmap1.getWidth();
      j = paramBitmap1.getHeight();
      k = paramBitmap2.getWidth();
      m = paramBitmap2.getHeight();
    } while ((i == 0) || (j == 0));
    if ((k == 0) || (m == 0)) {
      return paramBitmap1;
    }
    float f = i * 1.0F / 5.0F / k;
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    try
    {
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
      localCanvas.scale(f, f, i / 2, j / 2);
      localCanvas.drawBitmap(paramBitmap2, (i - k) / 2, (j - m) / 2, null);
      localCanvas.save(31);
      localCanvas.restore();
      paramBitmap1 = localBitmap;
    }
    catch (Exception paramBitmap1)
    {
      for (;;)
      {
        paramBitmap1.getStackTrace();
        paramBitmap1 = null;
      }
    }
    return paramBitmap1;
  }
  
  public static Bitmap createQRImage(Context paramContext, String paramString, Bitmap paramBitmap)
  {
    if (paramString != null) {}
    for (;;)
    {
      int k;
      int i;
      int j;
      try
      {
        if ("".equals(paramString)) {
          break label200;
        }
        k = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth() / 5 * 3;
        paramContext = new HashMap();
        paramContext.put(f.b, "utf-8");
        paramContext.put(f.a, com.google.c.d.a.a.d);
        paramString = new com.google.c.d.a().encode(paramString, com.google.c.a.l, k, k, paramContext);
        paramContext = new int[k * k];
        i = 0;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      if (j < k)
      {
        if (paramString.get(j, i)) {
          paramContext[(i * k + j)] = -16777216;
        } else {
          paramContext[(i * k + j)] = -1;
        }
      }
      else
      {
        i += 1;
        label200:
        while (i >= k)
        {
          paramString = Bitmap.createBitmap(k, k, Bitmap.Config.ARGB_8888);
          paramString.setPixels(paramContext, 0, k, 0, 0, k, k);
          paramContext = paramString;
          if (paramBitmap != null)
          {
            paramContext = a(paramString, paramBitmap);
            return paramContext;
            paramContext = null;
          }
          return paramContext;
        }
        j = 0;
        continue;
      }
      j += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */