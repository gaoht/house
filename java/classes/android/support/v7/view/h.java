package android.support.v7.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class h
{
  final ArrayList<ViewPropertyAnimatorCompat> a = new ArrayList();
  ViewPropertyAnimatorListener b;
  private long c = -1L;
  private Interpolator d;
  private boolean e;
  private final ViewPropertyAnimatorListenerAdapter f = new ViewPropertyAnimatorListenerAdapter()
  {
    private boolean b = false;
    private int c = 0;
    
    void a()
    {
      this.c = 0;
      this.b = false;
      h.this.a();
    }
    
    public void onAnimationEnd(View paramAnonymousView)
    {
      int i = this.c + 1;
      this.c = i;
      if (i == h.this.a.size())
      {
        if (h.this.b != null) {
          h.this.b.onAnimationEnd(null);
        }
        a();
      }
    }
    
    public void onAnimationStart(View paramAnonymousView)
    {
      if (this.b) {}
      do
      {
        return;
        this.b = true;
      } while (h.this.b == null);
      h.this.b.onAnimationStart(null);
    }
  };
  
  void a()
  {
    this.e = false;
  }
  
  public void cancel()
  {
    if (!this.e) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ViewPropertyAnimatorCompat)localIterator.next()).cancel();
    }
    this.e = false;
  }
  
  public h play(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    if (!this.e) {
      this.a.add(paramViewPropertyAnimatorCompat);
    }
    return this;
  }
  
  public h playSequentially(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat1, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat2)
  {
    this.a.add(paramViewPropertyAnimatorCompat1);
    paramViewPropertyAnimatorCompat2.setStartDelay(paramViewPropertyAnimatorCompat1.getDuration());
    this.a.add(paramViewPropertyAnimatorCompat2);
    return this;
  }
  
  public h setDuration(long paramLong)
  {
    if (!this.e) {
      this.c = paramLong;
    }
    return this;
  }
  
  public h setInterpolator(Interpolator paramInterpolator)
  {
    if (!this.e) {
      this.d = paramInterpolator;
    }
    return this;
  }
  
  public h setListener(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    if (!this.e) {
      this.b = paramViewPropertyAnimatorListener;
    }
    return this;
  }
  
  public void start()
  {
    if (this.e) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat)localIterator.next();
      if (this.c >= 0L) {
        localViewPropertyAnimatorCompat.setDuration(this.c);
      }
      if (this.d != null) {
        localViewPropertyAnimatorCompat.setInterpolator(this.d);
      }
      if (this.b != null) {
        localViewPropertyAnimatorCompat.setListener(this.f);
      }
      localViewPropertyAnimatorCompat.start();
    }
    this.e = true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */