package android.support.constraint.a.a;

import android.support.constraint.a.e;
import java.util.ArrayList;

public class d
  extends b
{
  protected float aa = -1.0F;
  protected int ab = -1;
  protected int ac = -1;
  private a ad = this.j;
  private int ae = 0;
  private boolean af = false;
  private int ag = 0;
  private f ah = new f();
  private int ai = 8;
  
  public d()
  {
    this.q.clear();
    this.q.add(this.ad);
  }
  
  public void addToSolver(e parame, int paramInt)
  {
    c localc = (c)getParent();
    if (localc == null) {
      return;
    }
    a locala2 = localc.getAnchor(a.c.b);
    a locala1 = localc.getAnchor(a.c.d);
    if (this.ae == 0)
    {
      locala2 = localc.getAnchor(a.c.c);
      locala1 = localc.getAnchor(a.c.e);
    }
    for (;;)
    {
      if (this.ab != -1)
      {
        parame.addConstraint(e.createRowEquals(parame, parame.createObjectVariable(this.ad), parame.createObjectVariable(locala2), this.ab, false));
        return;
      }
      if (this.ac != -1)
      {
        parame.addConstraint(e.createRowEquals(parame, parame.createObjectVariable(this.ad), parame.createObjectVariable(locala1), -this.ac, false));
        return;
      }
      if (this.aa == -1.0F) {
        break;
      }
      parame.addConstraint(e.createRowDimensionPercent(parame, parame.createObjectVariable(this.ad), parame.createObjectVariable(locala2), parame.createObjectVariable(locala1), this.aa, this.af));
      return;
    }
  }
  
  void c()
  {
    float f = getX() / getParent().getWidth();
    if (this.ae == 0) {
      f = getY() / getParent().getHeight();
    }
    setGuidePercent(f);
  }
  
  public void cyclePosition()
  {
    if (this.ab != -1) {
      c();
    }
    do
    {
      return;
      if (this.aa != -1.0F)
      {
        e();
        return;
      }
    } while (this.ac == -1);
    d();
  }
  
  void d()
  {
    int i = getX();
    if (this.ae == 0) {
      i = getY();
    }
    setGuideBegin(i);
  }
  
  void e()
  {
    int i = getParent().getWidth() - getX();
    if (this.ae == 0) {
      i = getParent().getHeight() - getY();
    }
    setGuideEnd(i);
  }
  
  public a getAnchor()
  {
    return this.ad;
  }
  
  public a getAnchor(a.c paramc)
  {
    switch (1.a[paramc.ordinal()])
    {
    }
    do
    {
      do
      {
        return null;
      } while (this.ae != 1);
      return this.ad;
    } while (this.ae != 0);
    return this.ad;
  }
  
  public ArrayList<a> getAnchors()
  {
    return this.q;
  }
  
  public f getHead()
  {
    this.ah.setBounds(getDrawX() - this.ai, getDrawY() - this.ai * 2, this.ai * 2, this.ai * 2);
    if (getOrientation() == 0) {
      this.ah.setBounds(getDrawX() - this.ai * 2, getDrawY() - this.ai, this.ai * 2, this.ai * 2);
    }
    return this.ah;
  }
  
  public int getOrientation()
  {
    return this.ae;
  }
  
  public int getRelativeBegin()
  {
    return this.ab;
  }
  
  public int getRelativeBehaviour()
  {
    int i = -1;
    if (this.aa != -1.0F) {
      i = 0;
    }
    do
    {
      return i;
      if (this.ab != -1) {
        return 1;
      }
    } while (this.ac == -1);
    return 2;
  }
  
  public int getRelativeEnd()
  {
    return this.ac;
  }
  
  public float getRelativePercent()
  {
    return this.aa;
  }
  
  public String getType()
  {
    return "Guideline";
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2)
  {
    if (this.ae == 1)
    {
      paramInt1 -= this.y;
      if (this.ab != -1) {
        setGuideBegin(paramInt1);
      }
    }
    do
    {
      do
      {
        return;
        if (this.ac != -1)
        {
          setGuideEnd(getParent().getWidth() - paramInt1);
          return;
        }
      } while (this.aa == -1.0F);
      setGuidePercent(paramInt1 / getParent().getWidth());
      return;
      paramInt1 = paramInt2 - this.z;
      if (this.ab != -1)
      {
        setGuideBegin(paramInt1);
        return;
      }
      if (this.ac != -1)
      {
        setGuideEnd(getParent().getHeight() - paramInt1);
        return;
      }
    } while (this.aa == -1.0F);
    setGuidePercent(paramInt1 / getParent().getHeight());
  }
  
  public void setGuideBegin(int paramInt)
  {
    if (paramInt > -1)
    {
      this.aa = -1.0F;
      this.ab = paramInt;
      this.ac = -1;
    }
  }
  
  public void setGuideEnd(int paramInt)
  {
    if (paramInt > -1)
    {
      this.aa = -1.0F;
      this.ab = -1;
      this.ac = paramInt;
    }
  }
  
  public void setGuidePercent(float paramFloat)
  {
    if (paramFloat > -1.0F)
    {
      this.aa = paramFloat;
      this.ab = -1;
      this.ac = -1;
    }
  }
  
  public void setGuidePercent(int paramInt)
  {
    setGuidePercent(paramInt / 100.0F);
  }
  
  public void setMinimumPosition(int paramInt)
  {
    this.ag = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.ae == paramInt) {
      return;
    }
    this.ae = paramInt;
    this.q.clear();
    if (this.ae == 1) {}
    for (this.ad = this.i;; this.ad = this.j)
    {
      this.q.add(this.ad);
      return;
    }
  }
  
  public void setPositionRelaxed(boolean paramBoolean)
  {
    if (this.af == paramBoolean) {
      return;
    }
    this.af = paramBoolean;
  }
  
  public void updateFromSolver(e parame, int paramInt)
  {
    if (getParent() == null) {
      return;
    }
    paramInt = parame.getObjectVariableValue(this.ad);
    if (this.ae == 1)
    {
      setX(paramInt);
      setY(0);
      setHeight(getParent().getHeight());
      setWidth(0);
      return;
    }
    setX(0);
    setY(paramInt);
    setWidth(getParent().getWidth());
    setHeight(0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */