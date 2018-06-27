package com.d.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class n
  extends a
{
  private static ThreadLocal<a> h = new ThreadLocal();
  private static final ThreadLocal<ArrayList<n>> i = new ThreadLocal()
  {
    protected ArrayList<n> a()
    {
      return new ArrayList();
    }
  };
  private static final ThreadLocal<ArrayList<n>> j = new ThreadLocal()
  {
    protected ArrayList<n> a()
    {
      return new ArrayList();
    }
  };
  private static final ThreadLocal<ArrayList<n>> k = new ThreadLocal()
  {
    protected ArrayList<n> a()
    {
      return new ArrayList();
    }
  };
  private static final ThreadLocal<ArrayList<n>> l = new ThreadLocal()
  {
    protected ArrayList<n> a()
    {
      return new ArrayList();
    }
  };
  private static final ThreadLocal<ArrayList<n>> m = new ThreadLocal()
  {
    protected ArrayList<n> a()
    {
      return new ArrayList();
    }
  };
  private static final Interpolator n = new AccelerateDecelerateInterpolator();
  private static final m o = new f();
  private static final m p = new d();
  private static long z = 10L;
  private int A = 0;
  private int B = 1;
  private Interpolator C = n;
  private ArrayList<b> D = null;
  long b;
  long c = -1L;
  int d = 0;
  boolean e = false;
  l[] f;
  HashMap<String, l> g;
  private boolean q = false;
  private int r = 0;
  private float s = 0.0F;
  private boolean t = false;
  private long u;
  private boolean v = false;
  private boolean w = false;
  private long x = 300L;
  private long y = 0L;
  
  private void a(boolean paramBoolean)
  {
    if (Looper.myLooper() == null) {
      throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }
    this.q = paramBoolean;
    this.r = 0;
    this.d = 0;
    this.w = true;
    this.t = false;
    ((ArrayList)j.get()).add(this);
    if (this.y == 0L)
    {
      setCurrentPlayTime(getCurrentPlayTime());
      this.d = 0;
      this.v = true;
      if (this.a != null)
      {
        localObject = (ArrayList)this.a.clone();
        int i2 = ((ArrayList)localObject).size();
        int i1 = 0;
        while (i1 < i2)
        {
          ((a.a)((ArrayList)localObject).get(i1)).onAnimationStart(this);
          i1 += 1;
        }
      }
    }
    a locala = (a)h.get();
    Object localObject = locala;
    if (locala == null)
    {
      localObject = new a(null);
      h.set(localObject);
    }
    ((a)localObject).sendEmptyMessage(0);
  }
  
  private boolean b(long paramLong)
  {
    if (!this.t)
    {
      this.t = true;
      this.u = paramLong;
    }
    long l1;
    do
    {
      return false;
      l1 = paramLong - this.u;
    } while (l1 <= this.y);
    this.b = (paramLong - (l1 - this.y));
    this.d = 1;
    return true;
  }
  
  public static void clearAllAnimations()
  {
    ((ArrayList)i.get()).clear();
    ((ArrayList)j.get()).clear();
    ((ArrayList)k.get()).clear();
  }
  
  public static int getCurrentAnimationsCount()
  {
    return ((ArrayList)i.get()).size();
  }
  
  public static long getFrameDelay()
  {
    return z;
  }
  
  private void h()
  {
    ((ArrayList)i.get()).remove(this);
    ((ArrayList)j.get()).remove(this);
    ((ArrayList)k.get()).remove(this);
    this.d = 0;
    if ((this.v) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((a.a)localArrayList.get(i1)).onAnimationEnd(this);
        i1 += 1;
      }
    }
    this.v = false;
    this.w = false;
  }
  
  private void i()
  {
    a();
    ((ArrayList)i.get()).add(this);
    if ((this.y > 0L) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((a.a)localArrayList.get(i1)).onAnimationStart(this);
        i1 += 1;
      }
    }
  }
  
  public static n ofFloat(float... paramVarArgs)
  {
    n localn = new n();
    localn.setFloatValues(paramVarArgs);
    return localn;
  }
  
  public static n ofInt(int... paramVarArgs)
  {
    n localn = new n();
    localn.setIntValues(paramVarArgs);
    return localn;
  }
  
  public static n ofObject(m paramm, Object... paramVarArgs)
  {
    n localn = new n();
    localn.setObjectValues(paramVarArgs);
    localn.setEvaluator(paramm);
    return localn;
  }
  
  public static n ofPropertyValuesHolder(l... paramVarArgs)
  {
    n localn = new n();
    localn.setValues(paramVarArgs);
    return localn;
  }
  
  public static void setFrameDelay(long paramLong)
  {
    z = paramLong;
  }
  
  void a()
  {
    if (!this.e)
    {
      int i2 = this.f.length;
      int i1 = 0;
      while (i1 < i2)
      {
        this.f[i1].a();
        i1 += 1;
      }
      this.e = true;
    }
  }
  
  void a(float paramFloat)
  {
    paramFloat = this.C.getInterpolation(paramFloat);
    this.s = paramFloat;
    int i2 = this.f.length;
    int i1 = 0;
    while (i1 < i2)
    {
      this.f[i1].a(paramFloat);
      i1 += 1;
    }
    if (this.D != null)
    {
      i2 = this.D.size();
      i1 = 0;
      while (i1 < i2)
      {
        ((b)this.D.get(i1)).onAnimationUpdate(this);
        i1 += 1;
      }
    }
  }
  
  boolean a(long paramLong)
  {
    boolean bool2 = false;
    if (this.d == 0)
    {
      this.d = 1;
      if (this.c >= 0L) {
        break label58;
      }
      this.b = paramLong;
    }
    for (;;)
    {
      switch (this.d)
      {
      default: 
        return false;
        label58:
        this.b = (paramLong - this.c);
        this.c = -1L;
      }
    }
    float f1;
    if (this.x > 0L) {
      f1 = (float)(paramLong - this.b) / (float)this.x;
    }
    boolean bool1;
    for (;;)
    {
      if (f1 >= 1.0F) {
        if ((this.r < this.A) || (this.A == -1))
        {
          if (this.a != null)
          {
            int i2 = this.a.size();
            int i1 = 0;
            for (;;)
            {
              if (i1 < i2)
              {
                ((a.a)this.a.get(i1)).onAnimationRepeat(this);
                i1 += 1;
                continue;
                f1 = 1.0F;
                break;
              }
            }
          }
          if (this.B == 2)
          {
            if (this.q)
            {
              bool1 = false;
              this.q = bool1;
            }
          }
          else
          {
            this.r += (int)f1;
            f1 %= 1.0F;
            this.b += this.x;
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      float f2 = f1;
      if (this.q) {
        f2 = 1.0F - f1;
      }
      a(f2);
      return bool1;
      bool1 = true;
      break;
      f1 = Math.min(f1, 1.0F);
      bool1 = true;
      continue;
      bool1 = bool2;
    }
  }
  
  public void addUpdateListener(b paramb)
  {
    if (this.D == null) {
      this.D = new ArrayList();
    }
    this.D.add(paramb);
  }
  
  public void cancel()
  {
    if ((this.d != 0) || (((ArrayList)j.get()).contains(this)) || (((ArrayList)k.get()).contains(this)))
    {
      if ((this.v) && (this.a != null))
      {
        Iterator localIterator = ((ArrayList)this.a.clone()).iterator();
        while (localIterator.hasNext()) {
          ((a.a)localIterator.next()).onAnimationCancel(this);
        }
      }
      h();
    }
  }
  
  public n clone()
  {
    int i2 = 0;
    n localn = (n)super.clone();
    int i3;
    int i1;
    if (this.D != null)
    {
      localObject = this.D;
      localn.D = new ArrayList();
      i3 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i3)
      {
        localn.D.add(((ArrayList)localObject).get(i1));
        i1 += 1;
      }
    }
    localn.c = -1L;
    localn.q = false;
    localn.r = 0;
    localn.e = false;
    localn.d = 0;
    localn.t = false;
    Object localObject = this.f;
    if (localObject != null)
    {
      i3 = localObject.length;
      localn.f = new l[i3];
      localn.g = new HashMap(i3);
      i1 = i2;
      while (i1 < i3)
      {
        l locall = localObject[i1].clone();
        localn.f[i1] = locall;
        localn.g.put(locall.getPropertyName(), locall);
        i1 += 1;
      }
    }
    return localn;
  }
  
  public void end()
  {
    if ((!((ArrayList)i.get()).contains(this)) && (!((ArrayList)j.get()).contains(this)))
    {
      this.t = false;
      i();
      if ((this.A <= 0) || ((this.A & 0x1) != 1)) {
        break label82;
      }
      a(0.0F);
    }
    for (;;)
    {
      h();
      return;
      if (this.e) {
        break;
      }
      a();
      break;
      label82:
      a(1.0F);
    }
  }
  
  public float getAnimatedFraction()
  {
    return this.s;
  }
  
  public Object getAnimatedValue()
  {
    if ((this.f != null) && (this.f.length > 0)) {
      return this.f[0].b();
    }
    return null;
  }
  
  public Object getAnimatedValue(String paramString)
  {
    paramString = (l)this.g.get(paramString);
    if (paramString != null) {
      return paramString.b();
    }
    return null;
  }
  
  public long getCurrentPlayTime()
  {
    if ((!this.e) || (this.d == 0)) {
      return 0L;
    }
    return AnimationUtils.currentAnimationTimeMillis() - this.b;
  }
  
  public long getDuration()
  {
    return this.x;
  }
  
  public Interpolator getInterpolator()
  {
    return this.C;
  }
  
  public int getRepeatCount()
  {
    return this.A;
  }
  
  public int getRepeatMode()
  {
    return this.B;
  }
  
  public long getStartDelay()
  {
    return this.y;
  }
  
  public l[] getValues()
  {
    return this.f;
  }
  
  public boolean isRunning()
  {
    return (this.d == 1) || (this.v);
  }
  
  public boolean isStarted()
  {
    return this.w;
  }
  
  public void removeAllUpdateListeners()
  {
    if (this.D == null) {
      return;
    }
    this.D.clear();
    this.D = null;
  }
  
  public void removeUpdateListener(b paramb)
  {
    if (this.D == null) {}
    do
    {
      return;
      this.D.remove(paramb);
    } while (this.D.size() != 0);
    this.D = null;
  }
  
  public void reverse()
  {
    if (!this.q) {}
    for (boolean bool = true;; bool = false)
    {
      this.q = bool;
      if (this.d != 1) {
        break;
      }
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.b;
      this.b = (l1 - (this.x - (l1 - l2)));
      return;
    }
    a(true);
  }
  
  public void setCurrentPlayTime(long paramLong)
  {
    a();
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    if (this.d != 1)
    {
      this.c = paramLong;
      this.d = 2;
    }
    this.b = (l1 - paramLong);
    a(l1);
  }
  
  public n setDuration(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    }
    this.x = paramLong;
    return this;
  }
  
  public void setEvaluator(m paramm)
  {
    if ((paramm != null) && (this.f != null) && (this.f.length > 0)) {
      this.f[0].setEvaluator(paramm);
    }
  }
  
  public void setFloatValues(float... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.f == null) || (this.f.length == 0)) {
      setValues(new l[] { l.ofFloat("", paramVarArgs) });
    }
    for (;;)
    {
      this.e = false;
      return;
      this.f[0].setFloatValues(paramVarArgs);
    }
  }
  
  public void setIntValues(int... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.f == null) || (this.f.length == 0)) {
      setValues(new l[] { l.ofInt("", paramVarArgs) });
    }
    for (;;)
    {
      this.e = false;
      return;
      this.f[0].setIntValues(paramVarArgs);
    }
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    if (paramInterpolator != null)
    {
      this.C = paramInterpolator;
      return;
    }
    this.C = new LinearInterpolator();
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.f == null) || (this.f.length == 0)) {
      setValues(new l[] { l.ofObject("", (m)null, paramVarArgs) });
    }
    for (;;)
    {
      this.e = false;
      return;
      this.f[0].setObjectValues(paramVarArgs);
    }
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.A = paramInt;
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.B = paramInt;
  }
  
  public void setStartDelay(long paramLong)
  {
    this.y = paramLong;
  }
  
  public void setValues(l... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    this.f = paramVarArgs;
    this.g = new HashMap(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      l locall = paramVarArgs[i1];
      this.g.put(locall.getPropertyName(), locall);
      i1 += 1;
    }
    this.e = false;
  }
  
  public void start()
  {
    a(false);
  }
  
  public String toString()
  {
    String str1 = "ValueAnimator@" + Integer.toHexString(hashCode());
    String str2 = str1;
    if (this.f != null)
    {
      int i1 = 0;
      for (;;)
      {
        str2 = str1;
        if (i1 >= this.f.length) {
          break;
        }
        str1 = str1 + "\n    " + this.f[i1].toString();
        i1 += 1;
      }
    }
    return str2;
  }
  
  private static class a
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      ArrayList localArrayList1 = (ArrayList)n.b().get();
      ArrayList localArrayList2 = (ArrayList)n.c().get();
      int i;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        paramMessage = (ArrayList)n.d().get();
        if ((localArrayList1.size() > 0) || (localArrayList2.size() > 0)) {
          i = 0;
        }
        break;
      }
      for (;;)
      {
        int k = i;
        Object localObject;
        int j;
        n localn;
        if (paramMessage.size() > 0)
        {
          localObject = (ArrayList)paramMessage.clone();
          paramMessage.clear();
          k = ((ArrayList)localObject).size();
          j = 0;
          if (j < k)
          {
            localn = (n)((ArrayList)localObject).get(j);
            if (n.a(localn) == 0L) {
              n.b(localn);
            }
            for (;;)
            {
              j += 1;
              break;
              localArrayList2.add(localn);
            }
            k = 1;
          }
        }
        else
        {
          long l = AnimationUtils.currentAnimationTimeMillis();
          localObject = (ArrayList)n.e().get();
          paramMessage = (ArrayList)n.f().get();
          j = localArrayList2.size();
          i = 0;
          while (i < j)
          {
            localn = (n)localArrayList2.get(i);
            if (n.a(localn, l)) {
              ((ArrayList)localObject).add(localn);
            }
            i += 1;
          }
          j = ((ArrayList)localObject).size();
          if (j > 0)
          {
            i = 0;
            while (i < j)
            {
              localn = (n)((ArrayList)localObject).get(i);
              n.b(localn);
              n.a(localn, true);
              localArrayList2.remove(localn);
              i += 1;
            }
            ((ArrayList)localObject).clear();
          }
          i = localArrayList1.size();
          j = 0;
          if (j < i)
          {
            localObject = (n)localArrayList1.get(j);
            if (((n)localObject).a(l)) {
              paramMessage.add(localObject);
            }
            int m;
            if (localArrayList1.size() == i)
            {
              m = j + 1;
              j = i;
              i = m;
            }
            for (;;)
            {
              m = j;
              j = i;
              i = m;
              break;
              paramMessage.remove(localObject);
              m = i - 1;
              i = j;
              j = m;
            }
          }
          if (paramMessage.size() > 0)
          {
            i = 0;
            while (i < paramMessage.size())
            {
              n.c((n)paramMessage.get(i));
              i += 1;
            }
            paramMessage.clear();
          }
          if ((k == 0) || ((localArrayList1.isEmpty()) && (localArrayList2.isEmpty()))) {
            break;
          }
          sendEmptyMessageDelayed(1, Math.max(0L, n.g() - (AnimationUtils.currentAnimationTimeMillis() - l)));
          return;
          i = 1;
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onAnimationUpdate(n paramn);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */