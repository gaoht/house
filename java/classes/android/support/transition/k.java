package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class k
  implements m
{
  public void animateTransform(ImageView paramImageView, Matrix paramMatrix)
  {
    paramImageView.setImageMatrix(paramMatrix);
  }
  
  public void reserveEndAnimateTransform(final ImageView paramImageView, Animator paramAnimator)
  {
    paramAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ImageView.ScaleType localScaleType = (ImageView.ScaleType)paramImageView.getTag(R.id.save_scale_type);
        paramImageView.setScaleType(localScaleType);
        paramImageView.setTag(R.id.save_scale_type, null);
        if (localScaleType == ImageView.ScaleType.MATRIX)
        {
          paramImageView.setImageMatrix((Matrix)paramImageView.getTag(R.id.save_image_matrix));
          paramImageView.setTag(R.id.save_image_matrix, null);
        }
        paramAnonymousAnimator.removeListener(this);
      }
    });
  }
  
  public void startAnimateTransform(ImageView paramImageView)
  {
    ImageView.ScaleType localScaleType = paramImageView.getScaleType();
    paramImageView.setTag(R.id.save_scale_type, localScaleType);
    if (localScaleType == ImageView.ScaleType.MATRIX) {
      paramImageView.setTag(R.id.save_image_matrix, paramImageView.getImageMatrix());
    }
    for (;;)
    {
      paramImageView.setImageMatrix(n.a);
      return;
      paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */