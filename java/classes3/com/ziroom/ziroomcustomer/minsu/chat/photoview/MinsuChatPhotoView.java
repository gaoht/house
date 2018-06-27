package com.ziroom.ziroomcustomer.minsu.chat.photoview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

@SuppressLint({"AppCompatCustomView"})
public class MinsuChatPhotoView
  extends ImageView
{
  private final b a;
  private ImageView.ScaleType b;
  
  public MinsuChatPhotoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MinsuChatPhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MinsuChatPhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    this.a = new b(this);
    if (this.b != null)
    {
      setScaleType(this.b);
      this.b = null;
    }
  }
  
  public boolean canZoom()
  {
    return this.a.canZoom();
  }
  
  public RectF getDisplayRect()
  {
    return this.a.getDisplayRect();
  }
  
  public float getMaxScale()
  {
    return this.a.getMaxScale();
  }
  
  public float getMidScale()
  {
    return this.a.getMidScale();
  }
  
  public float getMinScale()
  {
    return this.a.getMinScale();
  }
  
  public float getScale()
  {
    return this.a.getScale();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.a.getScaleType();
  }
  
  protected void onDetachedFromWindow()
  {
    this.a.cleanup();
    super.onDetachedFromWindow();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.a.setAllowParentInterceptOnEdge(paramBoolean);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.a != null) {
      this.a.update();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    if (this.a != null) {
      this.a.update();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (this.a != null) {
      this.a.update();
    }
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.a.setMaxScale(paramFloat);
  }
  
  public void setMidScale(float paramFloat)
  {
    this.a.setMidScale(paramFloat);
  }
  
  public void setMinScale(float paramFloat)
  {
    this.a.setMinScale(paramFloat);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.a.setOnLongClickListener(paramOnLongClickListener);
  }
  
  public void setOnMatrixChangeListener(b.c paramc)
  {
    this.a.setOnMatrixChangeListener(paramc);
  }
  
  public void setOnPhotoTapListener(b.d paramd)
  {
    this.a.setOnPhotoTapListener(paramd);
  }
  
  public void setOnViewTapListener(b.e parame)
  {
    this.a.setOnViewTapListener(parame);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (this.a != null)
    {
      this.a.setScaleType(paramScaleType);
      return;
    }
    this.b = paramScaleType;
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.a.setZoomable(paramBoolean);
  }
  
  public void zoomTo(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a.zoomTo(paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/photoview/MinsuChatPhotoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */