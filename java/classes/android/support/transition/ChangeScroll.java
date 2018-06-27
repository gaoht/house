package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class ChangeScroll
  extends Transition
{
  private static final String[] a = { "android:changeScroll:x", "android:changeScroll:y" };
  
  public ChangeScroll() {}
  
  public ChangeScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(ag paramag)
  {
    paramag.a.put("android:changeScroll:x", Integer.valueOf(paramag.b.getScrollX()));
    paramag.a.put("android:changeScroll:y", Integer.valueOf(paramag.b.getScrollY()));
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
    View localView = paramag2.b;
    int i = ((Integer)paramag1.a.get("android:changeScroll:x")).intValue();
    int j = ((Integer)paramag2.a.get("android:changeScroll:x")).intValue();
    int k = ((Integer)paramag1.a.get("android:changeScroll:y")).intValue();
    int m = ((Integer)paramag2.a.get("android:changeScroll:y")).intValue();
    if (i != j) {
      localView.setScrollX(i);
    }
    for (paramViewGroup = ObjectAnimator.ofInt(localView, "scrollX", new int[] { i, j });; paramViewGroup = null)
    {
      if (k != m) {
        localView.setScrollY(k);
      }
      for (paramag1 = ObjectAnimator.ofInt(localView, "scrollY", new int[] { k, m });; paramag1 = null) {
        return af.a(paramViewGroup, paramag1);
      }
    }
  }
  
  public String[] getTransitionProperties()
  {
    return a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ChangeScroll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */