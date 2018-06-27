package in.srain.cube.views.ptr.a;

import android.graphics.PointF;

public class a
{
  protected int a = 0;
  private PointF b = new PointF();
  private float c;
  private float d;
  private int e = 0;
  private int f = 0;
  private int g;
  private int h = 0;
  private float i = 1.2F;
  private float j = 1.7F;
  private boolean k = false;
  private int l = -1;
  private int m = 0;
  
  protected void a()
  {
    this.a = ((int)(this.i * this.g));
  }
  
  protected void a(float paramFloat1, float paramFloat2)
  {
    this.c = paramFloat1;
    this.d = paramFloat2;
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a(paramFloat3, paramFloat4 / this.j);
  }
  
  protected void a(int paramInt1, int paramInt2) {}
  
  public void convertFrom(a parama)
  {
    this.e = parama.e;
    this.f = parama.f;
    this.g = parama.g;
  }
  
  public boolean crossRefreshLineFromTopToBottom()
  {
    return (this.f < getOffsetToRefresh()) && (this.e >= getOffsetToRefresh());
  }
  
  public float getCurrentPercent()
  {
    if (this.g == 0) {
      return 0.0F;
    }
    return this.e * 1.0F / this.g;
  }
  
  public int getCurrentPosY()
  {
    return this.e;
  }
  
  public int getHeaderHeight()
  {
    return this.g;
  }
  
  public float getLastPercent()
  {
    if (this.g == 0) {
      return 0.0F;
    }
    return this.f * 1.0F / this.g;
  }
  
  public int getLastPosY()
  {
    return this.f;
  }
  
  public int getOffsetToKeepHeaderWhileLoading()
  {
    if (this.l >= 0) {
      return this.l;
    }
    return this.g;
  }
  
  public int getOffsetToRefresh()
  {
    return this.a;
  }
  
  public float getOffsetX()
  {
    return this.c;
  }
  
  public float getOffsetY()
  {
    return this.d;
  }
  
  public float getRatioOfHeaderToHeightRefresh()
  {
    return this.i;
  }
  
  public float getResistance()
  {
    return this.j;
  }
  
  public boolean goDownCrossFinishPosition()
  {
    return this.e >= this.m;
  }
  
  public boolean hasJustBackToStartPosition()
  {
    return (this.f != 0) && (isInStartPosition());
  }
  
  public boolean hasJustLeftStartPosition()
  {
    return (this.f == 0) && (hasLeftStartPosition());
  }
  
  public boolean hasJustReachedHeaderHeightFromTopToBottom()
  {
    return (this.f < this.g) && (this.e >= this.g);
  }
  
  public boolean hasLeftStartPosition()
  {
    return this.e > 0;
  }
  
  public boolean hasMovedAfterPressedDown()
  {
    return this.e != this.h;
  }
  
  public boolean isAlreadyHere(int paramInt)
  {
    return this.e == paramInt;
  }
  
  public boolean isInStartPosition()
  {
    return this.e == 0;
  }
  
  public boolean isOverOffsetToKeepHeaderWhileLoading()
  {
    return this.e > getOffsetToKeepHeaderWhileLoading();
  }
  
  public boolean isOverOffsetToRefresh()
  {
    return this.e >= getOffsetToRefresh();
  }
  
  public boolean isUnderTouch()
  {
    return this.k;
  }
  
  public final void onMove(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2, paramFloat1 - this.b.x, paramFloat2 - this.b.y);
    this.b.set(paramFloat1, paramFloat2);
  }
  
  public void onPressDown(float paramFloat1, float paramFloat2)
  {
    this.k = true;
    this.h = this.e;
    this.b.set(paramFloat1, paramFloat2);
  }
  
  public void onRelease()
  {
    this.k = false;
  }
  
  public void onUIRefreshComplete()
  {
    this.m = this.e;
  }
  
  public final void setCurrentPos(int paramInt)
  {
    this.f = this.e;
    this.e = paramInt;
    a(paramInt, this.f);
  }
  
  public void setHeaderHeight(int paramInt)
  {
    this.g = paramInt;
    a();
  }
  
  public void setOffsetToKeepHeaderWhileLoading(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setOffsetToRefresh(int paramInt)
  {
    this.i = (this.g * 1.0F / paramInt);
    this.a = paramInt;
  }
  
  public void setRatioOfHeaderHeightToRefresh(float paramFloat)
  {
    this.i = paramFloat;
    this.a = ((int)(this.g * paramFloat));
  }
  
  public void setResistance(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public boolean willOverTop(int paramInt)
  {
    return paramInt < 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/in/srain/cube/views/ptr/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */