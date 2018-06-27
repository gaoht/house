package com.unionpay.mobile.android.upwidget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.unionpay.mobile.android.global.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UPRadiationView
  extends View
{
  private List<a> a;
  private int b;
  private int c;
  private Context d;
  private Handler e;
  
  public UPRadiationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public UPRadiationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    this.a = Collections.synchronizedList(new ArrayList());
    paramContext = new DisplayMetrics();
    ((Activity)this.d).getWindowManager().getDefaultDisplay().getMetrics(paramContext);
    int i = paramContext.widthPixels;
    paramContext = new DisplayMetrics();
    ((Activity)this.d).getWindowManager().getDefaultDisplay().getMetrics(paramContext);
    int j = paramContext.heightPixels;
    if ((i <= 0) || (j <= 0)) {
      throw new RuntimeException("size illegal");
    }
    this.b = (i / 2);
    this.c = (j / 2 - b.n);
    this.e = new t(this);
    this.e.sendEmptyMessage(0);
  }
  
  private static Paint a(int paramInt, float paramFloat)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStrokeWidth(paramFloat);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAlpha(paramInt);
    localPaint.setColor(-1);
    return localPaint;
  }
  
  public final void a()
  {
    this.d = null;
    this.e.removeCallbacksAndMessages(null);
    this.e = null;
    if (this.a != null) {
      this.a.clear();
    }
    this.a = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < this.a.size())
    {
      a locala = (a)this.a.get(i);
      paramCanvas.drawCircle(this.b, this.c, locala.b, locala.a);
      i += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  private final class a
  {
    Paint a;
    int b;
    float c;
    int d;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/UPRadiationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */