package com.d.a;

import android.view.animation.Interpolator;

public abstract class h
  implements Cloneable
{
  float a;
  Class b;
  boolean c = false;
  private Interpolator d = null;
  
  public static h ofFloat(float paramFloat)
  {
    return new a(paramFloat);
  }
  
  public static h ofFloat(float paramFloat1, float paramFloat2)
  {
    return new a(paramFloat1, paramFloat2);
  }
  
  public static h ofInt(float paramFloat)
  {
    return new b(paramFloat);
  }
  
  public static h ofInt(float paramFloat, int paramInt)
  {
    return new b(paramFloat, paramInt);
  }
  
  public static h ofObject(float paramFloat)
  {
    return new c(paramFloat, null);
  }
  
  public static h ofObject(float paramFloat, Object paramObject)
  {
    return new c(paramFloat, paramObject);
  }
  
  public abstract h clone();
  
  public float getFraction()
  {
    return this.a;
  }
  
  public Interpolator getInterpolator()
  {
    return this.d;
  }
  
  public Class getType()
  {
    return this.b;
  }
  
  public abstract Object getValue();
  
  public boolean hasValue()
  {
    return this.c;
  }
  
  public void setFraction(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.d = paramInterpolator;
  }
  
  public abstract void setValue(Object paramObject);
  
  static class a
    extends h
  {
    float d;
    
    a(float paramFloat)
    {
      this.a = paramFloat;
      this.b = Float.TYPE;
    }
    
    a(float paramFloat1, float paramFloat2)
    {
      this.a = paramFloat1;
      this.d = paramFloat2;
      this.b = Float.TYPE;
      this.c = true;
    }
    
    public a clone()
    {
      a locala = new a(getFraction(), this.d);
      locala.setInterpolator(getInterpolator());
      return locala;
    }
    
    public float getFloatValue()
    {
      return this.d;
    }
    
    public Object getValue()
    {
      return Float.valueOf(this.d);
    }
    
    public void setValue(Object paramObject)
    {
      if ((paramObject != null) && (paramObject.getClass() == Float.class))
      {
        this.d = ((Float)paramObject).floatValue();
        this.c = true;
      }
    }
  }
  
  static class b
    extends h
  {
    int d;
    
    b(float paramFloat)
    {
      this.a = paramFloat;
      this.b = Integer.TYPE;
    }
    
    b(float paramFloat, int paramInt)
    {
      this.a = paramFloat;
      this.d = paramInt;
      this.b = Integer.TYPE;
      this.c = true;
    }
    
    public b clone()
    {
      b localb = new b(getFraction(), this.d);
      localb.setInterpolator(getInterpolator());
      return localb;
    }
    
    public int getIntValue()
    {
      return this.d;
    }
    
    public Object getValue()
    {
      return Integer.valueOf(this.d);
    }
    
    public void setValue(Object paramObject)
    {
      if ((paramObject != null) && (paramObject.getClass() == Integer.class))
      {
        this.d = ((Integer)paramObject).intValue();
        this.c = true;
      }
    }
  }
  
  static class c
    extends h
  {
    Object d;
    
    c(float paramFloat, Object paramObject)
    {
      this.a = paramFloat;
      this.d = paramObject;
      boolean bool;
      if (paramObject != null)
      {
        bool = true;
        this.c = bool;
        if (!this.c) {
          break label48;
        }
      }
      label48:
      for (paramObject = paramObject.getClass();; paramObject = Object.class)
      {
        this.b = ((Class)paramObject);
        return;
        bool = false;
        break;
      }
    }
    
    public c clone()
    {
      c localc = new c(getFraction(), this.d);
      localc.setInterpolator(getInterpolator());
      return localc;
    }
    
    public Object getValue()
    {
      return this.d;
    }
    
    public void setValue(Object paramObject)
    {
      this.d = paramObject;
      if (paramObject != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.c = bool;
        return;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */