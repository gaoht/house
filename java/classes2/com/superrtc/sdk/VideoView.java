package com.superrtc.sdk;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class VideoView
  extends GLSurfaceView
{
  protected g a = new g(this, "CallView");
  private boolean b = false;
  private boolean c = true;
  private boolean d = false;
  private float e = 0.0F;
  private float f = 0.0F;
  private int g;
  private int h;
  private float i;
  private a j;
  private b k = b.a;
  
  public VideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void a()
  {
    this.g = getWidth();
    this.h = getHeight();
    if (this.j != null) {
      this.j.onFocus(this.e, this.f, this.g, this.h);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (this.j != null) {
      this.j.onZoom(paramBoolean, paramInt);
    }
  }
  
  public g getRenderer()
  {
    return this.a;
  }
  
  public b getScaleMode()
  {
    try
    {
      b localb = this.k;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.b) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          switch (paramMotionEvent.getAction() & 0xFF)
          {
          case 3: 
          case 4: 
          default: 
            return true;
          case 0: 
            this.c = true;
            return true;
          case 5: 
            this.c = false;
            this.d = true;
            this.i = a(paramMotionEvent);
            return true;
          case 2: 
            bool1 = bool2;
          }
        } while (this.c);
        bool1 = bool2;
      } while (!this.d);
      float f1 = a(paramMotionEvent);
      int m = (int)Math.abs((f1 - this.i) / 3.0F);
      if (f1 > this.i) {
        a(true, m);
      }
      for (;;)
      {
        this.i = f1;
        return true;
        a(false, m);
      }
      this.d = false;
      return true;
      bool1 = bool2;
    } while (!this.c);
    this.e = paramMotionEvent.getX();
    this.f = paramMotionEvent.getY();
    a();
    return true;
  }
  
  public void release()
  {
    if (this.a != null)
    {
      this.a.dispose();
      this.a = null;
    }
  }
  
  public void setCallViewListener(a parama)
  {
    this.j = parama;
  }
  
  public void setGestureEnable(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setScaleMode(b paramb)
  {
    try
    {
      if (this.k != paramb) {
        this.k = paramb;
      }
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onFocus(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
    
    public abstract void onZoom(boolean paramBoolean, int paramInt);
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/sdk/VideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */