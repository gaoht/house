package com.freelxl.baselibrary.widget.frescoview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;

public class ZoomableDraweeView
  extends DraweeView<GenericDraweeHierarchy>
{
  private static final Class<?> a = ZoomableDraweeView.class;
  private final RectF b = new RectF();
  private final RectF c = new RectF();
  private DraweeController d;
  private g e;
  private GestureDetector f;
  private final ControllerListener g = new BaseControllerListener()
  {
    public void onFinalImageSet(String paramAnonymousString, Object paramAnonymousObject, Animatable paramAnonymousAnimatable)
    {
      ZoomableDraweeView.a(ZoomableDraweeView.this);
    }
    
    public void onRelease(String paramAnonymousString)
    {
      ZoomableDraweeView.b(ZoomableDraweeView.this);
    }
  };
  private final g.a h = new g.a()
  {
    public void onTransformChanged(Matrix paramAnonymousMatrix)
    {
      ZoomableDraweeView.this.a(paramAnonymousMatrix);
    }
  };
  private final d i = new d();
  
  public ZoomableDraweeView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
    c();
  }
  
  public ZoomableDraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    c();
  }
  
  public ZoomableDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
    c();
  }
  
  public ZoomableDraweeView(Context paramContext, GenericDraweeHierarchy paramGenericDraweeHierarchy)
  {
    super(paramContext);
    setHierarchy(paramGenericDraweeHierarchy);
    c();
  }
  
  private void a(DraweeController paramDraweeController)
  {
    if ((paramDraweeController instanceof AbstractDraweeController)) {
      ((AbstractDraweeController)paramDraweeController).removeControllerListener(this.g);
    }
  }
  
  private void a(DraweeController paramDraweeController1, DraweeController paramDraweeController2)
  {
    a(getController());
    b(paramDraweeController1);
    this.d = paramDraweeController2;
    super.setController(paramDraweeController1);
  }
  
  private void b(DraweeController paramDraweeController)
  {
    if ((paramDraweeController instanceof AbstractDraweeController)) {
      ((AbstractDraweeController)paramDraweeController).addControllerListener(this.g);
    }
  }
  
  private void c()
  {
    this.e = b();
    this.e.setListener(this.h);
    this.f = new GestureDetector(getContext(), this.i);
  }
  
  private void d()
  {
    if ((this.d != null) && (this.e.getScaleFactor() > 1.1F)) {
      a(this.d, null);
    }
  }
  
  private void e()
  {
    FLog.v(getLogTag(), "onFinalImageSet: view %x", Integer.valueOf(hashCode()));
    if (!this.e.isEnabled())
    {
      a();
      this.e.setEnabled(true);
    }
  }
  
  private void f()
  {
    FLog.v(getLogTag(), "onRelease: view %x", Integer.valueOf(hashCode()));
    this.e.setEnabled(false);
  }
  
  protected void a()
  {
    a(this.b);
    b(this.c);
    this.e.setImageBounds(this.b);
    this.e.setViewBounds(this.c);
    FLog.v(getLogTag(), "updateZoomableControllerBounds: view %x, view bounds: %s, image bounds: %s", Integer.valueOf(hashCode()), this.c, this.b);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    GenericDraweeHierarchyBuilder localGenericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(paramContext.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    GenericDraweeHierarchyInflater.updateBuilder(localGenericDraweeHierarchyBuilder, paramContext, paramAttributeSet);
    setAspectRatio(localGenericDraweeHierarchyBuilder.getDesiredAspectRatio());
    setHierarchy(localGenericDraweeHierarchyBuilder.build());
  }
  
  protected void a(Matrix paramMatrix)
  {
    FLog.v(getLogTag(), "onTransformChanged: view %x, transform: %s", Integer.valueOf(hashCode()), paramMatrix);
    d();
    invalidate();
  }
  
  protected void a(RectF paramRectF)
  {
    ((GenericDraweeHierarchy)getHierarchy()).getActualImageBounds(paramRectF);
  }
  
  protected g b()
  {
    return b.newInstance();
  }
  
  protected void b(RectF paramRectF)
  {
    paramRectF.set(0.0F, 0.0F, getWidth(), getHeight());
  }
  
  protected Class<?> getLogTag()
  {
    return a;
  }
  
  public g getZoomableController()
  {
    return this.e;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = paramCanvas.save();
    paramCanvas.concat(this.e.getTransform());
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(j);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FLog.v(getLogTag(), "onLayout: view %x", Integer.valueOf(hashCode()));
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getActionMasked();
    FLog.v(getLogTag(), "onTouchEvent: %d, view %x, received", Integer.valueOf(j), Integer.valueOf(hashCode()));
    if (this.f.onTouchEvent(paramMotionEvent))
    {
      FLog.v(getLogTag(), "onTouchEvent: %d, view %x, handled by tap gesture detector", Integer.valueOf(j), Integer.valueOf(hashCode()));
      return true;
    }
    if (this.e.onTouchEvent(paramMotionEvent))
    {
      if (!this.e.isIdentity()) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      FLog.v(getLogTag(), "onTouchEvent: %d, view %x, handled by zoomable controller", Integer.valueOf(j), Integer.valueOf(hashCode()));
      return true;
    }
    if (super.onTouchEvent(paramMotionEvent))
    {
      FLog.v(getLogTag(), "onTouchEvent: %d, view %x, handled by the super", Integer.valueOf(j), Integer.valueOf(hashCode()));
      return true;
    }
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(3);
    this.f.onTouchEvent(paramMotionEvent);
    this.e.onTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
    return false;
  }
  
  public void setController(DraweeController paramDraweeController)
  {
    setControllers(paramDraweeController, null);
  }
  
  public void setControllers(DraweeController paramDraweeController1, DraweeController paramDraweeController2)
  {
    a(null, null);
    this.e.setEnabled(false);
    a(paramDraweeController1, paramDraweeController2);
  }
  
  public void setIsLongpressEnabled(boolean paramBoolean)
  {
    this.f.setIsLongpressEnabled(paramBoolean);
  }
  
  public void setTapListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    this.i.setListener(paramSimpleOnGestureListener);
  }
  
  public void setZoomableController(g paramg)
  {
    Preconditions.checkNotNull(paramg);
    this.e.setListener(null);
    this.e = paramg;
    this.e.setListener(this.h);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/frescoview/ZoomableDraweeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */