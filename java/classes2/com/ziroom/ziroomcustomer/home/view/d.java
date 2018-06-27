package com.ziroom.ziroomcustomer.home.view;

import android.view.animation.Interpolator;

public class d
{
  private final e a;
  
  d(e parame)
  {
    this.a = parame;
  }
  
  public void cancel()
  {
    this.a.cancel();
  }
  
  public void end()
  {
    this.a.end();
  }
  
  public float getAnimatedFloatValue()
  {
    return this.a.getAnimatedFloatValue();
  }
  
  public float getAnimatedFraction()
  {
    return this.a.getAnimatedFraction();
  }
  
  public int getAnimatedIntValue()
  {
    return this.a.getAnimatedIntValue();
  }
  
  public boolean isRunning()
  {
    return this.a.isRunning();
  }
  
  public void setDuration(int paramInt)
  {
    this.a.setDuration(paramInt);
  }
  
  public void setFloatValues(float paramFloat1, float paramFloat2)
  {
    this.a.setFloatValues(paramFloat1, paramFloat2);
  }
  
  public void setIntValues(int paramInt1, int paramInt2)
  {
    this.a.setIntValues(paramInt1, paramInt2);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.a.setInterpolator(paramInterpolator);
  }
  
  public void setListener(final a parama)
  {
    if (parama != null)
    {
      this.a.setListener(new d.e.a()
      {
        public void onAnimationCancel()
        {
          parama.onAnimationCancel(d.this);
        }
        
        public void onAnimationEnd()
        {
          parama.onAnimationEnd(d.this);
        }
        
        public void onAnimationStart()
        {
          parama.onAnimationStart(d.this);
        }
      });
      return;
    }
    this.a.setListener(null);
  }
  
  public void setUpdateListener(final c paramc)
  {
    if (paramc != null)
    {
      this.a.setUpdateListener(new d.e.b()
      {
        public void onAnimationUpdate()
        {
          paramc.onAnimationUpdate(d.this);
        }
      });
      return;
    }
    this.a.setUpdateListener(null);
  }
  
  public void start()
  {
    this.a.start();
  }
  
  static abstract interface a
  {
    public abstract void onAnimationCancel(d paramd);
    
    public abstract void onAnimationEnd(d paramd);
    
    public abstract void onAnimationStart(d paramd);
  }
  
  static class b
    implements d.a
  {
    public void onAnimationCancel(d paramd) {}
    
    public void onAnimationEnd(d paramd) {}
    
    public void onAnimationStart(d paramd) {}
  }
  
  static abstract interface c
  {
    public abstract void onAnimationUpdate(d paramd);
  }
  
  static abstract interface d
  {
    public abstract d createAnimator();
  }
  
  static abstract class e
  {
    abstract void cancel();
    
    abstract void end();
    
    abstract float getAnimatedFloatValue();
    
    abstract float getAnimatedFraction();
    
    abstract int getAnimatedIntValue();
    
    abstract boolean isRunning();
    
    abstract void setDuration(int paramInt);
    
    abstract void setFloatValues(float paramFloat1, float paramFloat2);
    
    abstract void setIntValues(int paramInt1, int paramInt2);
    
    abstract void setInterpolator(Interpolator paramInterpolator);
    
    abstract void setListener(a parama);
    
    abstract void setUpdateListener(b paramb);
    
    abstract void start();
    
    static abstract interface a
    {
      public abstract void onAnimationCancel();
      
      public abstract void onAnimationEnd();
      
      public abstract void onAnimationStart();
    }
    
    static abstract interface b
    {
      public abstract void onAnimationUpdate();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */