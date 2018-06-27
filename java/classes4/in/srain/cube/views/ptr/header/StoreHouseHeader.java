package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Transformation;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.a.a;
import java.util.ArrayList;

public class StoreHouseHeader
  extends View
  implements in.srain.cube.views.ptr.b
{
  public ArrayList<b> a = new ArrayList();
  private int b = -1;
  private float c = 1.0F;
  private int d = -1;
  private float e = 0.7F;
  private int f = -1;
  private float g = 0.0F;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private float l = 0.4F;
  private float m = 1.0F;
  private float n = 0.4F;
  private int o = 1000;
  private int p = 1000;
  private int q = 400;
  private Transformation r = new Transformation();
  private boolean s = false;
  private a t = new a(null);
  private int u = -1;
  
  public StoreHouseHeader(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StoreHouseHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public StoreHouseHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    in.srain.cube.views.ptr.b.b.init(getContext());
    this.b = in.srain.cube.views.ptr.b.b.dp2px(1.0F);
    this.d = in.srain.cube.views.ptr.b.b.dp2px(40.0F);
    this.f = (in.srain.cube.views.ptr.b.b.a / 2);
  }
  
  private void b()
  {
    this.s = true;
    a.a(this.t);
    invalidate();
  }
  
  private void c()
  {
    this.s = false;
    a.b(this.t);
  }
  
  private int getBottomOffset()
  {
    return getPaddingBottom() + in.srain.cube.views.ptr.b.b.dp2px(10.0F);
  }
  
  private int getTopOffset()
  {
    return getPaddingTop() + in.srain.cube.views.ptr.b.b.dp2px(10.0F);
  }
  
  private void setProgress(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public int getLoadingAniDuration()
  {
    return this.o;
  }
  
  public float getScale()
  {
    return this.c;
  }
  
  public void initWithPointList(ArrayList<float[]> paramArrayList)
  {
    if (this.a.size() > 0) {}
    float f1;
    float f2;
    for (int i1 = 1;; i1 = 0)
    {
      this.a.clear();
      int i2 = 0;
      f1 = 0.0F;
      f2 = 0.0F;
      while (i2 < paramArrayList.size())
      {
        Object localObject2 = (float[])paramArrayList.get(i2);
        Object localObject1 = new PointF(in.srain.cube.views.ptr.b.b.dp2px(localObject2[0]) * this.c, in.srain.cube.views.ptr.b.b.dp2px(localObject2[1]) * this.c);
        localObject2 = new PointF(in.srain.cube.views.ptr.b.b.dp2px(localObject2[2]) * this.c, in.srain.cube.views.ptr.b.b.dp2px(localObject2[3]) * this.c);
        f2 = Math.max(Math.max(f2, ((PointF)localObject1).x), ((PointF)localObject2).x);
        f1 = Math.max(Math.max(f1, ((PointF)localObject1).y), ((PointF)localObject2).y);
        localObject1 = new b(i2, (PointF)localObject1, (PointF)localObject2, this.u, this.b);
        ((b)localObject1).resetPosition(this.f);
        this.a.add(localObject1);
        i2 += 1;
      }
    }
    this.h = ((int)Math.ceil(f2));
    this.i = ((int)Math.ceil(f1));
    if (i1 != 0) {
      requestLayout();
    }
  }
  
  public void initWithString(String paramString)
  {
    initWithString(paramString, 25);
  }
  
  public void initWithString(String paramString, int paramInt)
  {
    initWithPointList(c.getPath(paramString, paramInt * 0.01F, 14));
  }
  
  public void initWithStringArray(int paramInt)
  {
    String[] arrayOfString1 = getResources().getStringArray(paramInt);
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    while (paramInt < arrayOfString1.length)
    {
      String[] arrayOfString2 = arrayOfString1[paramInt].split(",");
      float[] arrayOfFloat = new float[4];
      int i1 = 0;
      while (i1 < 4)
      {
        arrayOfFloat[i1] = Float.parseFloat(arrayOfString2[i1]);
        i1 += 1;
      }
      localArrayList.add(arrayOfFloat);
      paramInt += 1;
    }
    initWithPointList(localArrayList);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f2 = this.g;
    int i2 = paramCanvas.save();
    int i3 = this.a.size();
    int i1 = 0;
    if (i1 < i3)
    {
      paramCanvas.save();
      b localb = (b)this.a.get(i1);
      float f1 = this.j;
      float f3 = localb.a.x + f1;
      f1 = this.k;
      float f4 = localb.a.y + f1;
      if (this.s)
      {
        localb.getTransformation(getDrawingTime(), this.r);
        paramCanvas.translate(f3, f4);
      }
      label156:
      float f5;
      for (;;)
      {
        localb.draw(paramCanvas);
        paramCanvas.restore();
        for (;;)
        {
          i1 += 1;
          break;
          if (f2 != 0.0F) {
            break label156;
          }
          localb.resetPosition(this.f);
        }
        f1 = (1.0F - this.e) * i1 / i3;
        f5 = this.e;
        if ((f2 != 1.0F) && (f2 < 1.0F - (1.0F - f5 - f1))) {
          break label216;
        }
        paramCanvas.translate(f3, f4);
        localb.setAlpha(this.l);
      }
      label216:
      if (f2 <= f1) {}
      for (f1 = 0.0F;; f1 = Math.min(1.0F, (f2 - f1) / this.e))
      {
        f5 = localb.b;
        float f6 = -this.d;
        Matrix localMatrix = new Matrix();
        localMatrix.postRotate(360.0F * f1);
        localMatrix.postScale(f1, f1);
        localMatrix.postTranslate(f3 + f5 * (1.0F - f1), f4 + f6 * (1.0F - f1));
        localb.setAlpha(f1 * this.l);
        paramCanvas.concat(localMatrix);
        break;
      }
    }
    if (this.s) {
      invalidate();
    }
    paramCanvas.restoreToCount(i2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getTopOffset() + this.i + getBottomOffset(), 1073741824));
    this.j = ((getMeasuredWidth() - this.h) / 2);
    this.k = getTopOffset();
    this.d = getTopOffset();
  }
  
  public void onUIPositionChange(PtrFrameLayout paramPtrFrameLayout, boolean paramBoolean, byte paramByte, a parama)
  {
    setProgress(Math.min(1.0F, parama.getCurrentPercent()));
    invalidate();
  }
  
  public void onUIRefreshBegin(PtrFrameLayout paramPtrFrameLayout)
  {
    b();
  }
  
  public void onUIRefreshComplete(PtrFrameLayout paramPtrFrameLayout)
  {
    c();
  }
  
  public void onUIRefreshPrepare(PtrFrameLayout paramPtrFrameLayout) {}
  
  public void onUIReset(PtrFrameLayout paramPtrFrameLayout)
  {
    c();
    int i1 = 0;
    while (i1 < this.a.size())
    {
      ((b)this.a.get(i1)).resetPosition(this.f);
      i1 += 1;
    }
  }
  
  public StoreHouseHeader setDropHeight(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public StoreHouseHeader setLineWidth(int paramInt)
  {
    this.b = paramInt;
    int i1 = 0;
    while (i1 < this.a.size())
    {
      ((b)this.a.get(i1)).setLineWidth(paramInt);
      i1 += 1;
    }
    return this;
  }
  
  public void setLoadingAniDuration(int paramInt)
  {
    this.o = paramInt;
    this.p = paramInt;
  }
  
  public void setScale(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public StoreHouseHeader setTextColor(int paramInt)
  {
    this.u = paramInt;
    int i1 = 0;
    while (i1 < this.a.size())
    {
      ((b)this.a.get(i1)).setColor(paramInt);
      i1 += 1;
    }
    return this;
  }
  
  private class a
    implements Runnable
  {
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private boolean f = true;
    
    private a() {}
    
    private void a()
    {
      this.f = true;
      this.b = 0;
      this.e = (StoreHouseHeader.a(StoreHouseHeader.this) / StoreHouseHeader.this.a.size());
      this.c = (StoreHouseHeader.b(StoreHouseHeader.this) / this.e);
      this.d = (StoreHouseHeader.this.a.size() / this.c + 1);
      run();
    }
    
    private void b()
    {
      this.f = false;
      StoreHouseHeader.this.removeCallbacks(this);
    }
    
    public void run()
    {
      int j = this.b;
      int k = this.c;
      int i = 0;
      if (i < this.d)
      {
        int m = this.c * i + j % k;
        if (m > this.b) {}
        for (;;)
        {
          i += 1;
          break;
          int n = StoreHouseHeader.this.a.size();
          b localb = (b)StoreHouseHeader.this.a.get(m % n);
          localb.setFillAfter(false);
          localb.setFillEnabled(true);
          localb.setFillBefore(false);
          localb.setDuration(StoreHouseHeader.c(StoreHouseHeader.this));
          localb.start(StoreHouseHeader.d(StoreHouseHeader.this), StoreHouseHeader.e(StoreHouseHeader.this));
        }
      }
      this.b += 1;
      if (this.f) {
        StoreHouseHeader.this.postDelayed(this, this.e);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/in/srain/cube/views/ptr/header/StoreHouseHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */