package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class i
{
  private static final int[] a = { 16843067, 16843068 };
  private final ProgressBar b;
  private Bitmap c;
  
  i(ProgressBar paramProgressBar)
  {
    this.b = paramProgressBar;
  }
  
  private Drawable a(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if ((paramDrawable instanceof AnimationDrawable))
    {
      paramDrawable = (AnimationDrawable)paramDrawable;
      int j = paramDrawable.getNumberOfFrames();
      localObject = new AnimationDrawable();
      ((AnimationDrawable)localObject).setOneShot(paramDrawable.isOneShot());
      int i = 0;
      while (i < j)
      {
        Drawable localDrawable = a(paramDrawable.getFrame(i), true);
        localDrawable.setLevel(10000);
        ((AnimationDrawable)localObject).addFrame(localDrawable, paramDrawable.getDuration(i));
        i += 1;
      }
      ((AnimationDrawable)localObject).setLevel(10000);
    }
    return (Drawable)localObject;
  }
  
  private Drawable a(Drawable paramDrawable, boolean paramBoolean)
  {
    int j = 0;
    if ((paramDrawable instanceof DrawableWrapper))
    {
      localObject1 = ((DrawableWrapper)paramDrawable).getWrappedDrawable();
      if (localObject1 != null)
      {
        localObject1 = a((Drawable)localObject1, paramBoolean);
        ((DrawableWrapper)paramDrawable).setWrappedDrawable((Drawable)localObject1);
      }
    }
    do
    {
      return paramDrawable;
      if ((paramDrawable instanceof LayerDrawable))
      {
        localObject2 = (LayerDrawable)paramDrawable;
        int k = ((LayerDrawable)localObject2).getNumberOfLayers();
        paramDrawable = new Drawable[k];
        int i = 0;
        if (i < k)
        {
          int m = ((LayerDrawable)localObject2).getId(i);
          localObject1 = ((LayerDrawable)localObject2).getDrawable(i);
          if ((m == 16908301) || (m == 16908303)) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            paramDrawable[i] = a((Drawable)localObject1, paramBoolean);
            i += 1;
            break;
          }
        }
        localObject1 = new LayerDrawable(paramDrawable);
        i = j;
        for (;;)
        {
          paramDrawable = (Drawable)localObject1;
          if (i >= k) {
            break;
          }
          ((LayerDrawable)localObject1).setId(i, ((LayerDrawable)localObject2).getId(i));
          i += 1;
        }
      }
    } while (!(paramDrawable instanceof BitmapDrawable));
    paramDrawable = (BitmapDrawable)paramDrawable;
    Object localObject2 = paramDrawable.getBitmap();
    if (this.c == null) {
      this.c = ((Bitmap)localObject2);
    }
    Object localObject1 = new ShapeDrawable(b());
    localObject2 = new BitmapShader((Bitmap)localObject2, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
    ((ShapeDrawable)localObject1).getPaint().setShader((Shader)localObject2);
    ((ShapeDrawable)localObject1).getPaint().setColorFilter(paramDrawable.getPaint().getColorFilter());
    if (paramBoolean) {
      return new ClipDrawable((Drawable)localObject1, 3, 1);
    }
    return (Drawable)localObject1;
  }
  
  private Shape b()
  {
    return new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null);
  }
  
  Bitmap a()
  {
    return this.c;
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = at.obtainStyledAttributes(this.b.getContext(), paramAttributeSet, a, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.getDrawableIfKnown(0);
    if (localDrawable != null) {
      this.b.setIndeterminateDrawable(a(localDrawable));
    }
    localDrawable = paramAttributeSet.getDrawableIfKnown(1);
    if (localDrawable != null) {
      this.b.setProgressDrawable(a(localDrawable, false));
    }
    paramAttributeSet.recycle();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */