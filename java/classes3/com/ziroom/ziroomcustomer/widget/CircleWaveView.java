package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.util.n;
import java.io.PrintStream;

public class CircleWaveView
  extends View
  implements Runnable
{
  Context a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g = -1.0F;
  private volatile boolean h = false;
  private Paint i;
  private Paint j;
  private int k;
  private float l;
  private boolean m = true;
  private float n = 0.0F;
  private boolean o = true;
  private float p;
  private float q;
  private long r;
  private Thread s;
  
  public CircleWaveView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public CircleWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.k = Color.parseColor("#55FAA9");
    this.q = n.dip2px(paramContext, 1.0F);
    this.p = (this.q * 4.0F);
    this.l = (this.q * 42.0F);
    this.r = 60L;
    a();
    b();
  }
  
  private void a()
  {
    this.i = new Paint();
    this.i.setAlpha(150);
    this.j = new Paint();
    this.j.setAlpha(150);
  }
  
  private void b()
  {
    this.b = getWidth();
    this.c = getHeight();
    this.i.setAntiAlias(true);
    this.i.setColor(this.k);
    if (this.o)
    {
      this.j.setStyle(Paint.Style.STROKE);
      this.j.setColor(this.k);
    }
    this.d = (this.b / 2.0F);
    if (this.m)
    {
      this.e = (this.c / 2.0F);
      if (this.b < this.c) {
        break label144;
      }
    }
    label144:
    for (this.g = (this.c / 2.0F);; this.g = (this.b / 2.0F))
    {
      this.f = (this.g % this.l);
      return;
      this.e = (this.c - this.n);
      break;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    stopAnimat();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.g <= 0.0F) {
      return;
    }
    for (float f1 = this.f % this.l;; f1 += this.l)
    {
      int i1 = (int)(255.0F * (1.0F - f1 / this.g));
      if (i1 <= 0) {
        break;
      }
      if (this.o)
      {
        this.j.setAlpha(i1 >> 2);
        paramCanvas.drawCircle(this.d, this.e, f1 - this.l / 2.0F, this.j);
      }
      this.i.setAlpha(i1);
      paramCanvas.drawCircle(this.d, this.e, f1, this.i);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = (getWidth() / 2);
    this.d = this.g;
    this.e = (getHeight() / 2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      startAnimat();
      return;
    }
    stopAnimat();
  }
  
  public void run()
  {
    while (this.h)
    {
      this.f = (this.p + this.f);
      if (this.f > this.g) {
        this.f = (this.g % this.l);
      }
      postInvalidate();
      try
      {
        Thread.sleep(this.r);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public void setColor(String paramString)
  {
    this.k = Color.parseColor(paramString);
    this.i.setColor(this.k);
    if (this.o)
    {
      this.j.setStyle(Paint.Style.STROKE);
      this.j.setColor(this.k);
    }
  }
  
  public void setThread(Thread paramThread)
  {
    this.s = paramThread;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 179	com/ziroom/ziroomcustomer/widget/CircleWaveView:s	Ljava/lang/Thread;
    //   6: invokevirtual 184	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   9: pop
    //   10: aload_0
    //   11: getfield 45	com/ziroom/ziroomcustomer/widget/CircleWaveView:h	Z
    //   14: ifne +83 -> 97
    //   17: aload_0
    //   18: getfield 179	com/ziroom/ziroomcustomer/widget/CircleWaveView:s	Ljava/lang/Thread;
    //   21: invokevirtual 188	java/lang/Thread:isAlive	()Z
    //   24: ifne +73 -> 97
    //   27: aload_0
    //   28: getfield 179	com/ziroom/ziroomcustomer/widget/CircleWaveView:s	Ljava/lang/Thread;
    //   31: invokevirtual 191	java/lang/Thread:isInterrupted	()Z
    //   34: ifne +63 -> 97
    //   37: getstatic 197	java/lang/System:out	Ljava/io/PrintStream;
    //   40: new 199	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   47: ldc -54
    //   49: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 179	com/ziroom/ziroomcustomer/widget/CircleWaveView:s	Ljava/lang/Thread;
    //   56: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokevirtual 218	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: iconst_1
    //   67: putfield 45	com/ziroom/ziroomcustomer/widget/CircleWaveView:h	Z
    //   70: aload_0
    //   71: getfield 179	com/ziroom/ziroomcustomer/widget/CircleWaveView:s	Ljava/lang/Thread;
    //   74: invokevirtual 184	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   77: getstatic 224	java/lang/Thread$State:NEW	Ljava/lang/Thread$State;
    //   80: if_acmpne +20 -> 100
    //   83: aload_0
    //   84: getfield 179	com/ziroom/ziroomcustomer/widget/CircleWaveView:s	Ljava/lang/Thread;
    //   87: invokevirtual 226	java/lang/Thread:start	()V
    //   90: ldc -28
    //   92: ldc -26
    //   94: invokestatic 235	com/freelxl/baselibrary/f/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: aload_0
    //   101: getfield 179	com/ziroom/ziroomcustomer/widget/CircleWaveView:s	Ljava/lang/Thread;
    //   104: invokevirtual 184	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   107: getstatic 238	java/lang/Thread$State:RUNNABLE	Ljava/lang/Thread$State;
    //   110: if_acmpeq -20 -> 90
    //   113: aload_0
    //   114: new 167	java/lang/Thread
    //   117: dup
    //   118: aload_0
    //   119: invokespecial 241	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   122: putfield 179	com/ziroom/ziroomcustomer/widget/CircleWaveView:s	Ljava/lang/Thread;
    //   125: aload_0
    //   126: getfield 179	com/ziroom/ziroomcustomer/widget/CircleWaveView:s	Ljava/lang/Thread;
    //   129: invokevirtual 226	java/lang/Thread:start	()V
    //   132: goto -42 -> 90
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	CircleWaveView
    //   135	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	90	135	finally
    //   90	97	135	finally
    //   100	132	135	finally
  }
  
  public void startAnimat()
  {
    if (this.s != null) {
      start();
    }
  }
  
  public void stop()
  {
    try
    {
      this.h = false;
      this.s.interrupt();
      System.out.println("当前的线程stop:" + this.s);
      d.e("CircleImageView", "断开一个线程");
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void stopAnimat()
  {
    if (this.s != null) {
      stop();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/CircleWaveView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */