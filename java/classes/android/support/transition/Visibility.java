package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public abstract class Visibility
  extends Transition
{
  private static final String[] a = { "android:visibility:visibility", "android:visibility:parent" };
  private int b = 3;
  
  public Visibility() {}
  
  public Visibility(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ab.e);
    int i = TypedArrayUtils.getNamedInt(paramContext, (XmlResourceParser)paramAttributeSet, "transitionVisibilityMode", 0, 0);
    paramContext.recycle();
    if (i != 0) {
      setMode(i);
    }
  }
  
  private b a(ag paramag1, ag paramag2)
  {
    b localb = new b(null);
    localb.a = false;
    localb.b = false;
    if ((paramag1 != null) && (paramag1.a.containsKey("android:visibility:visibility")))
    {
      localb.c = ((Integer)paramag1.a.get("android:visibility:visibility")).intValue();
      localb.e = ((ViewGroup)paramag1.a.get("android:visibility:parent"));
      if ((paramag2 == null) || (!paramag2.a.containsKey("android:visibility:visibility"))) {
        break label178;
      }
      localb.d = ((Integer)paramag2.a.get("android:visibility:visibility")).intValue();
      localb.f = ((ViewGroup)paramag2.a.get("android:visibility:parent"));
    }
    for (;;)
    {
      if ((paramag1 != null) && (paramag2 != null))
      {
        if ((localb.c == localb.d) && (localb.e == localb.f))
        {
          return localb;
          localb.c = -1;
          localb.e = null;
          break;
          label178:
          localb.d = -1;
          localb.f = null;
          continue;
        }
        if (localb.c != localb.d) {
          if (localb.c == 0)
          {
            localb.b = false;
            localb.a = true;
          }
        }
      }
    }
    for (;;)
    {
      return localb;
      if (localb.d == 0)
      {
        localb.b = true;
        localb.a = true;
        continue;
        if (localb.f == null)
        {
          localb.b = false;
          localb.a = true;
        }
        else if (localb.e == null)
        {
          localb.b = true;
          localb.a = true;
          continue;
          if ((paramag1 == null) && (localb.d == 0))
          {
            localb.b = true;
            localb.a = true;
          }
          else if ((paramag2 == null) && (localb.c == 0))
          {
            localb.b = false;
            localb.a = true;
          }
        }
      }
    }
  }
  
  private void a(ag paramag)
  {
    int i = paramag.b.getVisibility();
    paramag.a.put("android:visibility:visibility", Integer.valueOf(i));
    paramag.a.put("android:visibility:parent", paramag.b.getParent());
    int[] arrayOfInt = new int[2];
    paramag.b.getLocationOnScreen(arrayOfInt);
    paramag.a.put("android:visibility:screenLocation", arrayOfInt);
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
    b localb = a(paramag1, paramag2);
    if ((localb.a) && ((localb.e != null) || (localb.f != null)))
    {
      if (localb.b) {
        return onAppear(paramViewGroup, paramag1, localb.c, paramag2, localb.d);
      }
      return onDisappear(paramViewGroup, paramag1, localb.c, paramag2, localb.d);
    }
    return null;
  }
  
  public int getMode()
  {
    return this.b;
  }
  
  public String[] getTransitionProperties()
  {
    return a;
  }
  
  public boolean isTransitionRequired(ag paramag1, ag paramag2)
  {
    if ((paramag1 == null) && (paramag2 == null)) {}
    do
    {
      do
      {
        return false;
      } while ((paramag1 != null) && (paramag2 != null) && (paramag2.a.containsKey("android:visibility:visibility") != paramag1.a.containsKey("android:visibility:visibility")));
      paramag1 = a(paramag1, paramag2);
    } while ((!paramag1.a) || ((paramag1.c != 0) && (paramag1.d != 0)));
    return true;
  }
  
  public boolean isVisible(ag paramag)
  {
    if (paramag == null) {
      return false;
    }
    int i = ((Integer)paramag.a.get("android:visibility:visibility")).intValue();
    paramag = (View)paramag.a.get("android:visibility:parent");
    if ((i == 0) && (paramag != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, ag paramag1, int paramInt1, ag paramag2, int paramInt2)
  {
    if (((this.b & 0x1) != 1) || (paramag2 == null)) {
      return null;
    }
    if (paramag1 == null)
    {
      View localView = (View)paramag2.b.getParent();
      if (a(getMatchedTransitionValues(localView, false), getTransitionValues(localView, false)).a) {
        return null;
      }
    }
    return onAppear(paramViewGroup, paramag2.b, paramag1, paramag2);
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, ag paramag1, ag paramag2)
  {
    return null;
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, ag paramag1, int paramInt1, ag paramag2, int paramInt2)
  {
    if ((this.b & 0x2) != 2) {
      return null;
    }
    final Object localObject2;
    label22:
    final Object localObject1;
    if (paramag1 != null)
    {
      localObject2 = paramag1.b;
      if (paramag2 == null) {
        break label195;
      }
      localObject1 = paramag2.b;
      label34:
      if ((localObject1 != null) && (((View)localObject1).getParent() != null)) {
        break label326;
      }
      if (localObject1 == null) {
        break label201;
      }
      Object localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      label63:
      if ((localObject2 != null) && (paramag1 != null))
      {
        localObject1 = (int[])paramag1.a.get("android:visibility:screenLocation");
        paramInt1 = localObject1[0];
        paramInt2 = localObject1[1];
        localObject1 = new int[2];
        paramViewGroup.getLocationOnScreen((int[])localObject1);
        ((View)localObject2).offsetLeftAndRight(paramInt1 - localObject1[0] - ((View)localObject2).getLeft());
        ((View)localObject2).offsetTopAndBottom(paramInt2 - localObject1[1] - ((View)localObject2).getTop());
        localObject1 = am.a(paramViewGroup);
        ((al)localObject1).add((View)localObject2);
        paramViewGroup = onDisappear(paramViewGroup, (View)localObject2, paramag1, paramag2);
        if (paramViewGroup == null)
        {
          ((al)localObject1).remove((View)localObject2);
          return paramViewGroup;
          localObject2 = null;
          break label22;
          label195:
          localObject1 = null;
          break label34;
          label201:
          if (localObject2 == null) {
            break label452;
          }
          if (((View)localObject2).getParent() == null)
          {
            localObject1 = null;
            continue;
          }
          if (!(((View)localObject2).getParent() instanceof View)) {
            break label452;
          }
          localObject1 = (View)((View)localObject2).getParent();
          if (!a(getTransitionValues((View)localObject1, true), getMatchedTransitionValues((View)localObject1, true)).a) {
            localObject1 = af.a(paramViewGroup, (View)localObject2, (View)localObject1);
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        localObject1 = null;
        break label63;
        if (((View)localObject1).getParent() == null)
        {
          paramInt1 = ((View)localObject1).getId();
          if ((paramInt1 != -1) && (paramViewGroup.findViewById(paramInt1) != null) && (this.mCanRemoveViews))
          {
            localObject1 = localObject2;
            continue;
            label326:
            if (paramInt2 == 4)
            {
              localObject2 = null;
              break label63;
            }
            if (localObject2 == localObject1)
            {
              localObject2 = null;
              break label63;
            }
            localObject1 = null;
            break label63;
            paramViewGroup.addListener(new AnimatorListenerAdapter()
            {
              public void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                localObject1.remove(localObject2);
              }
            });
            return paramViewGroup;
            if (localObject1 == null) {
              break;
            }
            paramInt1 = ((View)localObject1).getVisibility();
            as.a((View)localObject1, 0);
            paramViewGroup = onDisappear(paramViewGroup, (View)localObject1, paramag1, paramag2);
            if (paramViewGroup != null)
            {
              paramag1 = new a((View)localObject1, paramInt2, true);
              paramViewGroup.addListener(paramag1);
              a.a(paramViewGroup, paramag1);
              addListener(paramag1);
              return paramViewGroup;
            }
            as.a((View)localObject1, paramInt1);
            return paramViewGroup;
          }
        }
        localObject1 = null;
      }
      label452:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, ag paramag1, ag paramag2)
  {
    return null;
  }
  
  public void setMode(int paramInt)
  {
    if ((paramInt & 0xFFFFFFFC) != 0) {
      throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
    this.b = paramInt;
  }
  
  private static class a
    extends AnimatorListenerAdapter
    implements Transition.d, b.a
  {
    boolean a = false;
    private final View b;
    private final int c;
    private final ViewGroup d;
    private final boolean e;
    private boolean f;
    
    a(View paramView, int paramInt, boolean paramBoolean)
    {
      this.b = paramView;
      this.c = paramInt;
      this.d = ((ViewGroup)paramView.getParent());
      this.e = paramBoolean;
      a(true);
    }
    
    private void a()
    {
      if (!this.a)
      {
        as.a(this.b, this.c);
        if (this.d != null) {
          this.d.invalidate();
        }
      }
      a(false);
    }
    
    private void a(boolean paramBoolean)
    {
      if ((this.e) && (this.f != paramBoolean) && (this.d != null))
      {
        this.f = paramBoolean;
        am.a(this.d, paramBoolean);
      }
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.a = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      a();
    }
    
    public void onAnimationPause(Animator paramAnimator)
    {
      if (!this.a) {
        as.a(this.b, this.c);
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationResume(Animator paramAnimator)
    {
      if (!this.a) {
        as.a(this.b, 0);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator) {}
    
    public void onTransitionCancel(Transition paramTransition) {}
    
    public void onTransitionEnd(Transition paramTransition)
    {
      a();
      paramTransition.removeListener(this);
    }
    
    public void onTransitionPause(Transition paramTransition)
    {
      a(false);
    }
    
    public void onTransitionResume(Transition paramTransition)
    {
      a(true);
    }
    
    public void onTransitionStart(Transition paramTransition) {}
  }
  
  private static class b
  {
    boolean a;
    boolean b;
    int c;
    int d;
    ViewGroup e;
    ViewGroup f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/Visibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */