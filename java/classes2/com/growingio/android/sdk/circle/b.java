package com.growingio.android.sdk.circle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.growingio.android.sdk.collection.MessageProcessor;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;

public class b
  extends View
{
  private WindowManager a;
  private Rect b;
  private Bitmap c;
  private int d;
  private int e;
  private int f;
  private int g;
  private float h;
  private float i;
  private int j;
  private final float k = 1.17F;
  private a l = a.a;
  
  public b(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a(View[] paramArrayOfView, float paramFloat)
  {
    if (this.c == null) {
      this.c = Bitmap.createBitmap(this.d, this.e, Bitmap.Config.RGB_565);
    }
    Canvas localCanvas = new Canvas(this.c);
    localCanvas.scale(1.17F, 1.17F);
    localCanvas.translate(-this.h + this.d / 2.34F, -this.i + this.e / 2.34F);
    int[] arrayOfInt = new int[2];
    boolean bool;
    int m;
    label102:
    View localView;
    if (ViewHelper.a(paramArrayOfView) > 1)
    {
      bool = true;
      int n = paramArrayOfView.length;
      m = 0;
      if (m >= n) {
        break label233;
      }
      localView = paramArrayOfView[m];
      if ((!(localView instanceof f)) && (localView.getVisibility() == 0) && (localView.getWidth() != 0) && (localView.getHeight() != 0) && (ViewHelper.a(localView, MessageProcessor.e().a(localView), bool)) && (!"DO_NOT_DRAW".equals(localView.getTag()))) {
        break label189;
      }
    }
    for (;;)
    {
      m += 1;
      break label102;
      bool = false;
      break;
      label189:
      localView.getLocationOnScreen(arrayOfInt);
      localCanvas.save(1);
      localCanvas.translate(arrayOfInt[0], arrayOfInt[1]);
      localView.draw(localCanvas);
      localCanvas.restore();
    }
    label233:
    paramArrayOfView = new Paint();
    paramArrayOfView.setAntiAlias(true);
    paramArrayOfView.setStrokeWidth(Util.a(getContext(), 1.0F));
    paramArrayOfView.setStyle(Paint.Style.STROKE);
    paramArrayOfView.setColor(-436254684);
    localCanvas.drawRoundRect(new RectF(this.b), paramFloat, paramFloat, paramArrayOfView);
    paramArrayOfView.setStyle(Paint.Style.FILL);
    paramArrayOfView.setColor(1291798564);
    localCanvas.drawRoundRect(new RectF(this.b), paramFloat, paramFloat, paramArrayOfView);
  }
  
  public void a()
  {
    this.a = ((WindowManager)getContext().getApplicationContext().getSystemService("window"));
    this.j = Util.a(getContext(), 80.0F);
    this.d = Util.a(getContext(), 120.0F);
    this.e = Util.a(getContext(), 80.0F);
    this.g = Util.a(getContext(), 16.0F);
    this.f = Util.a(getContext(), 18.0F);
  }
  
  public void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    if ((paramRect == null) || (paramRect.width() >= this.j) || (paramRect.height() >= this.j))
    {
      setVisibility(8);
      return;
    }
    int m = getResources().getDisplayMetrics().widthPixels;
    float f1 = (this.d / 2 - Util.a(getContext(), 2.0F)) / 1.17F;
    label107:
    WindowManager.LayoutParams localLayoutParams;
    if (paramInt1 > m - f1)
    {
      this.h = (m - f1);
      if (paramInt2 >= this.e / 2) {
        break label277;
      }
      f1 = this.e / 2;
      this.i = f1;
      this.b = paramRect;
      localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      paramInt1 = Util.a(getContext(), 1.0F);
      if (paramRect.top - this.e < this.g + paramInt1) {
        break label284;
      }
      localLayoutParams.width = this.d;
      localLayoutParams.height = (this.e + this.g);
      localLayoutParams.x = (paramRect.left + paramRect.width() / 2 - localLayoutParams.width / 2);
      localLayoutParams.y = (paramRect.top - localLayoutParams.height - paramInt1);
      this.l = a.a;
    }
    for (;;)
    {
      this.a.updateViewLayout(this, localLayoutParams);
      setVisibility(0);
      bringToFront();
      invalidate();
      return;
      if (paramInt1 < f1)
      {
        this.h = f1;
        break;
      }
      this.h = paramInt1;
      break;
      label277:
      f1 = paramInt2;
      break label107;
      label284:
      if (paramRect.left - getWidth() >= this.g + paramInt1)
      {
        localLayoutParams.width = (this.d + this.g);
        localLayoutParams.height = this.e;
        localLayoutParams.x = (paramRect.left - localLayoutParams.width - paramInt1);
        localLayoutParams.y = (paramRect.top + paramRect.height() / 2 - localLayoutParams.height / 2);
        this.l = a.b;
      }
      else
      {
        localLayoutParams.width = (this.d + this.g);
        localLayoutParams.height = this.e;
        localLayoutParams.x = (paramInt1 + paramRect.right);
        localLayoutParams.y = (paramRect.top + paramRect.height() / 2 - localLayoutParams.height / 2);
        this.l = a.c;
      }
    }
  }
  
  @SuppressLint({"RtlHardcoded"})
  public void b()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(0, 0, c.a, 312, -3);
    localLayoutParams.gravity = 51;
    localLayoutParams.setTitle("CircleMagnifierWindow:" + getContext().getPackageName());
    setVisibility(8);
    this.a.addView(this, localLayoutParams);
  }
  
  public void c()
  {
    if ((this.c != null) && (!this.c.isRecycled()))
    {
      this.c.recycle();
      this.c = null;
    }
    if (getParent() != null) {
      this.a.removeView(this);
    }
  }
  
  @SuppressLint({"DrawAllocation"})
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = WindowHelper.c();
    if (localObject.length <= 0) {
      return;
    }
    float f1 = 2.0F * getResources().getDisplayMetrics().density;
    float f2 = 5.0F * getResources().getDisplayMetrics().density;
    int i1 = this.d / 2;
    int n = this.e / 2;
    int m = 0;
    Path localPath1 = new Path();
    if (this.l == a.a)
    {
      localPath1.moveTo(i1 - this.f / 2, this.e - f1);
      localPath1.lineTo(i1, this.e + this.g - f1);
      localPath1.lineTo(i1 + this.f / 2, this.e - f1);
      localPath1.close();
    }
    for (;;)
    {
      Path localPath2 = new Path();
      localPath2.addRoundRect(new RectF(m + f1, f1, this.d + m - f1, this.e - f1), f2, f2, Path.Direction.CCW);
      Paint localPaint = new Paint();
      localPaint.setColor(-986896);
      localPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      localPaint.setFilterBitmap(true);
      paramCanvas.drawPath(localPath2, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      a((View[])localObject, f2);
      paramCanvas.save();
      paramCanvas.translate(m, 0.0F);
      paramCanvas.drawBitmap(this.c, 0.0F, 0.0F, localPaint);
      paramCanvas.restore();
      localObject = new Paint();
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setStrokeWidth(f1);
      ((Paint)localObject).setColor(-986896);
      paramCanvas.drawPath(localPath2, (Paint)localObject);
      ((Paint)localObject).setStyle(Paint.Style.FILL_AND_STROKE);
      ((Paint)localObject).setColor(-986896);
      paramCanvas.drawPath(localPath1, (Paint)localObject);
      return;
      if (this.l == a.b)
      {
        localPath1.moveTo(this.d - f1, n - this.f / 2);
        localPath1.lineTo(this.d + this.g - f1, n);
        localPath1.lineTo(this.d - f1, n + this.f / 2);
        localPath1.close();
      }
      else if (this.l == a.c)
      {
        m = this.g;
        localPath1.moveTo(m + f1, n - this.f / 2);
        localPath1.lineTo(f1, n);
        localPath1.lineTo(m + f1, n + this.f / 2);
        localPath1.close();
      }
    }
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */