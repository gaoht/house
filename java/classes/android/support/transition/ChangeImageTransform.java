package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

public class ChangeImageTransform
  extends Transition
{
  private static final String[] a = { "android:changeImageTransform:matrix", "android:changeImageTransform:bounds" };
  private static final TypeEvaluator<Matrix> b = new TypeEvaluator()
  {
    public Matrix evaluate(float paramAnonymousFloat, Matrix paramAnonymousMatrix1, Matrix paramAnonymousMatrix2)
    {
      return null;
    }
  };
  private static final Property<ImageView, Matrix> c = new Property(Matrix.class, "animatedTransform")
  {
    public Matrix get(ImageView paramAnonymousImageView)
    {
      return null;
    }
    
    public void set(ImageView paramAnonymousImageView, Matrix paramAnonymousMatrix)
    {
      j.a(paramAnonymousImageView, paramAnonymousMatrix);
    }
  };
  
  public ChangeImageTransform() {}
  
  public ChangeImageTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private ObjectAnimator a(ImageView paramImageView)
  {
    return ObjectAnimator.ofObject(paramImageView, c, b, new Matrix[] { null, null });
  }
  
  private ObjectAnimator a(ImageView paramImageView, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    return ObjectAnimator.ofObject(paramImageView, c, new af.a(), new Matrix[] { paramMatrix1, paramMatrix2 });
  }
  
  private void a(ag paramag)
  {
    View localView = paramag.b;
    if ((!(localView instanceof ImageView)) || (localView.getVisibility() != 0)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)localView;
    } while (localImageView.getDrawable() == null);
    paramag = paramag.a;
    paramag.put("android:changeImageTransform:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
    paramag.put("android:changeImageTransform:matrix", b(localImageView));
  }
  
  private static Matrix b(ImageView paramImageView)
  {
    switch (3.a[paramImageView.getScaleType().ordinal()])
    {
    default: 
      return new Matrix(paramImageView.getImageMatrix());
    case 1: 
      return c(paramImageView);
    }
    return d(paramImageView);
  }
  
  private static Matrix c(ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramImageView.getWidth() / localDrawable.getIntrinsicWidth(), paramImageView.getHeight() / localDrawable.getIntrinsicHeight());
    return localMatrix;
  }
  
  private static Matrix d(ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    int j = localDrawable.getIntrinsicWidth();
    int k = paramImageView.getWidth();
    float f1 = k / j;
    int m = localDrawable.getIntrinsicHeight();
    int i = paramImageView.getHeight();
    f1 = Math.max(f1, i / m);
    float f2 = j;
    float f3 = m;
    j = Math.round((k - f2 * f1) / 2.0F);
    i = Math.round((i - f3 * f1) / 2.0F);
    paramImageView = new Matrix();
    paramImageView.postScale(f1, f1);
    paramImageView.postTranslate(j, i);
    return paramImageView;
  }
  
  public void captureEndValues(ag paramag)
  {
    a(paramag);
  }
  
  public void captureStartValues(ag paramag)
  {
    a(paramag);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, ag paramag1, ag paramag2)
  {
    if ((paramag1 == null) || (paramag2 == null)) {
      return null;
    }
    paramViewGroup = (Rect)paramag1.a.get("android:changeImageTransform:bounds");
    Rect localRect = (Rect)paramag2.a.get("android:changeImageTransform:bounds");
    if ((paramViewGroup == null) || (localRect == null)) {
      return null;
    }
    paramag1 = (Matrix)paramag1.a.get("android:changeImageTransform:matrix");
    Matrix localMatrix = (Matrix)paramag2.a.get("android:changeImageTransform:matrix");
    if (((paramag1 == null) && (localMatrix == null)) || ((paramag1 != null) && (paramag1.equals(localMatrix)))) {}
    for (int i = 1; (paramViewGroup.equals(localRect)) && (i != 0); i = 0) {
      return null;
    }
    paramag2 = (ImageView)paramag2.b;
    paramViewGroup = paramag2.getDrawable();
    i = paramViewGroup.getIntrinsicWidth();
    int j = paramViewGroup.getIntrinsicHeight();
    j.a(paramag2);
    if ((i == 0) || (j == 0)) {}
    for (paramViewGroup = a(paramag2);; paramViewGroup = a(paramag2, paramViewGroup, paramag1))
    {
      j.a(paramag2, paramViewGroup);
      return paramViewGroup;
      paramViewGroup = paramag1;
      if (paramag1 == null) {
        paramViewGroup = n.a;
      }
      paramag1 = localMatrix;
      if (localMatrix == null) {
        paramag1 = n.a;
      }
      c.set(paramag2, paramViewGroup);
    }
  }
  
  public String[] getTransitionProperties()
  {
    return a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ChangeImageTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */