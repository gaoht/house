package com.growingio.android.sdk.circle;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.MessageProcessor;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import java.io.ByteArrayOutputStream;

public class i
{
  private static boolean a = false;
  private static int b = -1;
  private static int c = -1;
  private static int d = -1;
  private static int e = -1;
  private static double f = -1.0D;
  private static float g = -1.0F;
  private static float h = -1.0F;
  private static Bitmap i;
  
  static Bitmap a(View[] paramArrayOfView)
  {
    Bitmap localBitmap = Bitmap.createBitmap(c(), e(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.scale((float)f(), (float)f());
    int[] arrayOfInt = new int[2];
    boolean bool;
    int j;
    label58:
    View localView;
    if (ViewHelper.a(paramArrayOfView) > 1)
    {
      bool = true;
      int k = paramArrayOfView.length;
      j = 0;
      if (j >= k) {
        break label186;
      }
      localView = paramArrayOfView[j];
      if ((!(localView instanceof f)) && (localView.getVisibility() == 0) && (localView.getWidth() != 0) && (localView.getHeight() != 0) && (ViewHelper.a(localView, MessageProcessor.e().a(localView), bool)) && (!"DO_NOT_DRAW".equals(localView.getTag()))) {
        break label142;
      }
    }
    for (;;)
    {
      j += 1;
      break label58;
      bool = false;
      break;
      label142:
      localView.getLocationOnScreen(arrayOfInt);
      localCanvas.save(1);
      localCanvas.translate(arrayOfInt[0], arrayOfInt[1]);
      localView.draw(localCanvas);
      localCanvas.restore();
    }
    label186:
    return localBitmap;
  }
  
  static void a()
  {
    if (a) {}
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = AppState.l();
      } while (localObject1 == null);
      localObject2 = ((AppState)localObject1).k();
    } while (localObject2 == null);
    Object localObject1 = new DisplayMetrics();
    Object localObject3 = ((WindowManager)((Context)localObject2).getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      ((Display)localObject3).getRealMetrics((DisplayMetrics)localObject1);
    }
    for (;;)
    {
      b = ((DisplayMetrics)localObject1).widthPixels;
      d = ((DisplayMetrics)localObject1).heightPixels;
      f = 720.0D / b;
      c = (int)(f * b);
      e = (int)(f * d);
      a = true;
      h = Util.a((Context)localObject2, 100.0F);
      g = b - Util.a((Context)localObject2, 50.0F);
      localObject2 = new TextPaint();
      int j = (int)(((DisplayMetrics)localObject1).density * 2.0F);
      localObject3 = new Rect();
      ((TextPaint)localObject2).setAntiAlias(true);
      ((TextPaint)localObject2).setColor(-13421773);
      ((TextPaint)localObject2).setTextSize(((DisplayMetrics)localObject1).density * 14.0F);
      ((TextPaint)localObject2).getTextBounds("截图失败", 0, "截图失败".length(), (Rect)localObject3);
      i = Bitmap.createBitmap(((Rect)localObject3).width() + j * 2, ((Rect)localObject3).height() + j * 2, Bitmap.Config.ALPHA_8);
      new Canvas(i).drawText("截图失败", j, ((Rect)localObject3).height(), (Paint)localObject2);
      return;
      ((Display)localObject3).getMetrics((DisplayMetrics)localObject1);
    }
  }
  
  @TargetApi(13)
  static byte[] a(View[] paramArrayOfView, RectF paramRectF)
  {
    paramRectF = b(paramArrayOfView, paramRectF);
    paramArrayOfView = paramRectF;
    if (paramRectF == null) {
      paramArrayOfView = new byte[0];
    }
    return paramArrayOfView;
  }
  
  static int b()
  {
    return b;
  }
  
  private static byte[] b(View[] paramArrayOfView, RectF paramRectF)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      paramArrayOfView = a(paramArrayOfView);
      if (paramRectF != null)
      {
        localObject1 = localObject2;
        Canvas localCanvas = new Canvas(paramArrayOfView);
        localObject1 = localObject2;
        Context localContext = AppState.l().k();
        localObject1 = localObject2;
        Paint localPaint = new Paint();
        localObject1 = localObject2;
        float f1 = Util.a(AppState.l().k(), 3.0F);
        localObject1 = localObject2;
        localPaint.setColor(1291798564);
        localObject1 = localObject2;
        localCanvas.drawRoundRect(paramRectF, f1, f1, localPaint);
        localObject1 = localObject2;
        localPaint.setStyle(Paint.Style.STROKE);
        localObject1 = localObject2;
        localPaint.setStrokeWidth(Util.a(localContext, 1.0F));
        localObject1 = localObject2;
        localPaint.setColor(-436254684);
        localObject1 = localObject2;
        localCanvas.drawRoundRect(paramRectF, f1, f1, localPaint);
      }
      localObject1 = localObject2;
      paramRectF = new ByteArrayOutputStream();
      localObject1 = localObject2;
      paramArrayOfView.compress(Bitmap.CompressFormat.JPEG, 70, paramRectF);
      localObject1 = localObject2;
      paramArrayOfView.recycle();
      localObject1 = localObject2;
      paramArrayOfView = paramRectF.toByteArray();
      localObject1 = paramArrayOfView;
      paramRectF.close();
    }
    catch (Exception paramArrayOfView)
    {
      do
      {
        paramArrayOfView = (View[])localObject1;
      } while (i == null);
      paramArrayOfView = new ByteArrayOutputStream();
      i.compress(Bitmap.CompressFormat.JPEG, 50, paramArrayOfView);
    }
    return paramArrayOfView;
    return paramArrayOfView.toByteArray();
  }
  
  static int c()
  {
    return c;
  }
  
  static int d()
  {
    return d;
  }
  
  static int e()
  {
    return e;
  }
  
  public static double f()
  {
    return f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */