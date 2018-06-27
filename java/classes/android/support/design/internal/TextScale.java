package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.transition.Transition;
import android.support.transition.ag;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

public class TextScale
  extends Transition
{
  private static final String PROPNAME_SCALE = "android:textscale:scale";
  
  private void captureValues(ag paramag)
  {
    if ((paramag.b instanceof TextView))
    {
      TextView localTextView = (TextView)paramag.b;
      paramag.a.put("android:textscale:scale", Float.valueOf(localTextView.getScaleX()));
    }
  }
  
  public void captureEndValues(ag paramag)
  {
    captureValues(paramag);
  }
  
  public void captureStartValues(ag paramag)
  {
    captureValues(paramag);
  }
  
  public Animator createAnimator(final ViewGroup paramViewGroup, ag paramag1, ag paramag2)
  {
    float f2 = 1.0F;
    if ((paramag1 == null) || (paramag2 == null) || (!(paramag1.b instanceof TextView)) || (!(paramag2.b instanceof TextView))) {
      return null;
    }
    paramViewGroup = (TextView)paramag2.b;
    paramag1 = paramag1.a;
    paramag2 = paramag2.a;
    if (paramag1.get("android:textscale:scale") != null) {}
    for (float f1 = ((Float)paramag1.get("android:textscale:scale")).floatValue();; f1 = 1.0F)
    {
      if (paramag2.get("android:textscale:scale") != null) {
        f2 = ((Float)paramag2.get("android:textscale:scale")).floatValue();
      }
      if (f1 != f2) {
        break;
      }
      return null;
    }
    paramag1 = ValueAnimator.ofFloat(new float[] { f1, f2 });
    paramag1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramViewGroup.setScaleX(f);
        paramViewGroup.setScaleY(f);
      }
    });
    return paramag1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/design/internal/TextScale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */