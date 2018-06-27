package android.support.transition;

import android.view.View;
import java.util.Map;

public abstract class az
  extends ae
{
  private static final String[] a = { "android:visibilityPropagation:visibility", "android:visibilityPropagation:center" };
  
  private static int a(ag paramag, int paramInt)
  {
    if (paramag == null) {
      return -1;
    }
    paramag = (int[])paramag.a.get("android:visibilityPropagation:center");
    if (paramag == null) {
      return -1;
    }
    return paramag[paramInt];
  }
  
  public void captureValues(ag paramag)
  {
    View localView = paramag.b;
    Integer localInteger = (Integer)paramag.a.get("android:visibility:visibility");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(localView.getVisibility());
    }
    paramag.a.put("android:visibilityPropagation:visibility", localObject);
    localObject = new int[2];
    localView.getLocationOnScreen((int[])localObject);
    localObject[0] += Math.round(localView.getTranslationX());
    localObject[0] += localView.getWidth() / 2;
    localObject[1] += Math.round(localView.getTranslationY());
    int i = localObject[1];
    localObject[1] = (localView.getHeight() / 2 + i);
    paramag.a.put("android:visibilityPropagation:center", localObject);
  }
  
  public String[] getPropagationProperties()
  {
    return a;
  }
  
  public int getViewVisibility(ag paramag)
  {
    if (paramag == null) {
      return 8;
    }
    paramag = (Integer)paramag.a.get("android:visibilityPropagation:visibility");
    if (paramag == null) {
      return 8;
    }
    return paramag.intValue();
  }
  
  public int getViewX(ag paramag)
  {
    return a(paramag, 0);
  }
  
  public int getViewY(ag paramag)
  {
    return a(paramag, 1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */