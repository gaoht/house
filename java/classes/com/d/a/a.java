package com.d.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class a
  implements Cloneable
{
  ArrayList<a> a = null;
  
  public void addListener(a parama)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(parama);
  }
  
  public void cancel() {}
  
  public a clone()
  {
    try
    {
      a locala = (a)super.clone();
      if (this.a != null)
      {
        ArrayList localArrayList = this.a;
        locala.a = new ArrayList();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          locala.a.add(localArrayList.get(i));
          i += 1;
        }
      }
      return localCloneNotSupportedException;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  public void end() {}
  
  public abstract long getDuration();
  
  public ArrayList<a> getListeners()
  {
    return this.a;
  }
  
  public abstract long getStartDelay();
  
  public abstract boolean isRunning();
  
  public boolean isStarted()
  {
    return isRunning();
  }
  
  public void removeAllListeners()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public void removeListener(a parama)
  {
    if (this.a == null) {}
    do
    {
      return;
      this.a.remove(parama);
    } while (this.a.size() != 0);
    this.a = null;
  }
  
  public abstract a setDuration(long paramLong);
  
  public abstract void setInterpolator(Interpolator paramInterpolator);
  
  public abstract void setStartDelay(long paramLong);
  
  public void setTarget(Object paramObject) {}
  
  public void setupEndValues() {}
  
  public void setupStartValues() {}
  
  public void start() {}
  
  public static abstract interface a
  {
    public abstract void onAnimationCancel(a parama);
    
    public abstract void onAnimationEnd(a parama);
    
    public abstract void onAnimationRepeat(a parama);
    
    public abstract void onAnimationStart(a parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */