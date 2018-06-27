package android.support.transition;

import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ad
{
  private static Transition a = new AutoTransition();
  private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> d = new ThreadLocal();
  private static ArrayList<ViewGroup> e = new ArrayList();
  private ArrayMap<z, Transition> b = new ArrayMap();
  private ArrayMap<z, ArrayMap<z, Transition>> c = new ArrayMap();
  
  private Transition a(z paramz)
  {
    Object localObject = paramz.getSceneRoot();
    if (localObject != null)
    {
      localObject = z.a((View)localObject);
      if (localObject != null)
      {
        ArrayMap localArrayMap = (ArrayMap)this.c.get(paramz);
        if (localArrayMap != null)
        {
          localObject = (Transition)localArrayMap.get(localObject);
          if (localObject != null) {
            paramz = (z)localObject;
          }
        }
      }
    }
    do
    {
      return paramz;
      localObject = (Transition)this.b.get(paramz);
      paramz = (z)localObject;
    } while (localObject != null);
    return a;
  }
  
  static ArrayMap<ViewGroup, ArrayList<Transition>> a()
  {
    WeakReference localWeakReference2 = (WeakReference)d.get();
    WeakReference localWeakReference1;
    if (localWeakReference2 != null)
    {
      localWeakReference1 = localWeakReference2;
      if (localWeakReference2.get() != null) {}
    }
    else
    {
      localWeakReference1 = new WeakReference(new ArrayMap());
      d.set(localWeakReference1);
    }
    return (ArrayMap)localWeakReference1.get();
  }
  
  private static void a(z paramz, Transition paramTransition)
  {
    ViewGroup localViewGroup = paramz.getSceneRoot();
    if (!e.contains(localViewGroup))
    {
      if (paramTransition == null) {
        paramz.enter();
      }
    }
    else {
      return;
    }
    e.add(localViewGroup);
    paramTransition = paramTransition.clone();
    paramTransition.setSceneRoot(localViewGroup);
    z localz = z.a(localViewGroup);
    if ((localz != null) && (localz.a())) {
      paramTransition.setCanRemoveViews(true);
    }
    b(localViewGroup, paramTransition);
    paramz.enter();
    a(localViewGroup, paramTransition);
  }
  
  private static void a(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((paramTransition != null) && (paramViewGroup != null))
    {
      paramTransition = new a(paramTransition, paramViewGroup);
      paramViewGroup.addOnAttachStateChangeListener(paramTransition);
      paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramTransition);
    }
  }
  
  private static void b(ViewGroup paramViewGroup, Transition paramTransition)
  {
    Object localObject = (ArrayList)a().get(paramViewGroup);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).pause(paramViewGroup);
      }
    }
    if (paramTransition != null) {
      paramTransition.captureValues(paramViewGroup, true);
    }
    paramViewGroup = z.a(paramViewGroup);
    if (paramViewGroup != null) {
      paramViewGroup.exit();
    }
  }
  
  public static void beginDelayedTransition(ViewGroup paramViewGroup)
  {
    beginDelayedTransition(paramViewGroup, null);
  }
  
  public static void beginDelayedTransition(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((!e.contains(paramViewGroup)) && (ViewCompat.isLaidOut(paramViewGroup)))
    {
      e.add(paramViewGroup);
      Transition localTransition = paramTransition;
      if (paramTransition == null) {
        localTransition = a;
      }
      paramTransition = localTransition.clone();
      b(paramViewGroup, paramTransition);
      z.a(paramViewGroup, null);
      a(paramViewGroup, paramTransition);
    }
  }
  
  public static void endTransitions(ViewGroup paramViewGroup)
  {
    e.remove(paramViewGroup);
    ArrayList localArrayList = (ArrayList)a().get(paramViewGroup);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      localArrayList = new ArrayList(localArrayList);
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((Transition)localArrayList.get(i)).forceToEnd(paramViewGroup);
        i -= 1;
      }
    }
  }
  
  public static void go(z paramz)
  {
    a(paramz, a);
  }
  
  public static void go(z paramz, Transition paramTransition)
  {
    a(paramz, paramTransition);
  }
  
  public void setTransition(z paramz, Transition paramTransition)
  {
    this.b.put(paramz, paramTransition);
  }
  
  public void setTransition(z paramz1, z paramz2, Transition paramTransition)
  {
    ArrayMap localArrayMap2 = (ArrayMap)this.c.get(paramz2);
    ArrayMap localArrayMap1 = localArrayMap2;
    if (localArrayMap2 == null)
    {
      localArrayMap1 = new ArrayMap();
      this.c.put(paramz2, localArrayMap1);
    }
    localArrayMap1.put(paramz1, paramTransition);
  }
  
  public void transitionTo(z paramz)
  {
    a(paramz, a(paramz));
  }
  
  private static class a
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
  {
    Transition a;
    ViewGroup b;
    
    a(Transition paramTransition, ViewGroup paramViewGroup)
    {
      this.a = paramTransition;
      this.b = paramViewGroup;
    }
    
    private void a()
    {
      this.b.getViewTreeObserver().removeOnPreDrawListener(this);
      this.b.removeOnAttachStateChangeListener(this);
    }
    
    public boolean onPreDraw()
    {
      a();
      if (!ad.b().remove(this.b)) {
        return true;
      }
      final ArrayMap localArrayMap = ad.a();
      ArrayList localArrayList = (ArrayList)localArrayMap.get(this.b);
      Object localObject;
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayMap.put(this.b, localArrayList);
        localObject = null;
      }
      for (;;)
      {
        localArrayList.add(this.a);
        this.a.addListener(new ac()
        {
          public void onTransitionEnd(Transition paramAnonymousTransition)
          {
            ((ArrayList)localArrayMap.get(ad.a.this.b)).remove(paramAnonymousTransition);
          }
        });
        this.a.captureValues(this.b, false);
        if (localObject != null)
        {
          localObject = ((ArrayList)localObject).iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              ((Transition)((Iterator)localObject).next()).resume(this.b);
              continue;
              if (localArrayList.size() <= 0) {
                break label166;
              }
              localObject = new ArrayList(localArrayList);
              break;
            }
          }
        }
        this.a.playTransition(this.b);
        return true;
        label166:
        localObject = null;
      }
    }
    
    public void onViewAttachedToWindow(View paramView) {}
    
    public void onViewDetachedFromWindow(View paramView)
    {
      a();
      ad.b().remove(this.b);
      paramView = (ArrayList)ad.a().get(this.b);
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext()) {
          ((Transition)paramView.next()).resume(this.b);
        }
      }
      this.a.clearValues(true);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */