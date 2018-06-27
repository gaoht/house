package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class ChangeClipBounds
  extends Transition
{
  private static final String[] a = { "android:clipBounds:clip" };
  
  public ChangeClipBounds() {}
  
  public ChangeClipBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(ag paramag)
  {
    Object localObject = paramag.b;
    if (((View)localObject).getVisibility() == 8) {}
    Rect localRect;
    do
    {
      return;
      localRect = ViewCompat.getClipBounds((View)localObject);
      paramag.a.put("android:clipBounds:clip", localRect);
    } while (localRect != null);
    localObject = new Rect(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
    paramag.a.put("android:clipBounds:bounds", localObject);
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
    if ((paramag1 == null) || (paramag2 == null) || (!paramag1.a.containsKey("android:clipBounds:clip")) || (!paramag2.a.containsKey("android:clipBounds:clip"))) {
      paramViewGroup = null;
    }
    int i;
    do
    {
      return paramViewGroup;
      Object localObject = (Rect)paramag1.a.get("android:clipBounds:clip");
      Rect localRect = (Rect)paramag2.a.get("android:clipBounds:clip");
      if (localRect == null) {}
      for (i = 1; (localObject == null) && (localRect == null); i = 0) {
        return null;
      }
      if (localObject == null)
      {
        paramViewGroup = (Rect)paramag1.a.get("android:clipBounds:bounds");
        paramag1 = localRect;
      }
      while (paramViewGroup.equals(paramag1))
      {
        return null;
        paramViewGroup = (ViewGroup)localObject;
        paramag1 = localRect;
        if (localRect == null)
        {
          paramag1 = (Rect)paramag2.a.get("android:clipBounds:bounds");
          paramViewGroup = (ViewGroup)localObject;
        }
      }
      ViewCompat.setClipBounds(paramag2.b, paramViewGroup);
      localObject = new y(new Rect());
      paramag1 = ObjectAnimator.ofObject(paramag2.b, as.b, (TypeEvaluator)localObject, new Rect[] { paramViewGroup, paramag1 });
      paramViewGroup = paramag1;
    } while (i == 0);
    paramag1.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ViewCompat.setClipBounds(this.a, null);
      }
    });
    return paramag1;
  }
  
  public String[] getTransitionProperties()
  {
    return a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ChangeClipBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */