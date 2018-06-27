package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet
  extends Transition
{
  private ArrayList<Transition> a = new ArrayList();
  private boolean b = true;
  private int c;
  private boolean d = false;
  
  public TransitionSet() {}
  
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ab.i);
    setOrdering(TypedArrayUtils.getNamedInt(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
  }
  
  private void a()
  {
    a locala = new a(this);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((Transition)localIterator.next()).addListener(locala);
    }
    this.c = this.a.size();
  }
  
  TransitionSet a(ViewGroup paramViewGroup)
  {
    super.setSceneRoot(paramViewGroup);
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.a.get(i)).setSceneRoot(paramViewGroup);
      i += 1;
    }
    return this;
  }
  
  public TransitionSet addListener(Transition.d paramd)
  {
    return (TransitionSet)super.addListener(paramd);
  }
  
  public TransitionSet addTarget(int paramInt)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).addTarget(paramInt);
      i += 1;
    }
    return (TransitionSet)super.addTarget(paramInt);
  }
  
  public TransitionSet addTarget(View paramView)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).addTarget(paramView);
      i += 1;
    }
    return (TransitionSet)super.addTarget(paramView);
  }
  
  public TransitionSet addTarget(Class paramClass)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).addTarget(paramClass);
      i += 1;
    }
    return (TransitionSet)super.addTarget(paramClass);
  }
  
  public TransitionSet addTarget(String paramString)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).addTarget(paramString);
      i += 1;
    }
    return (TransitionSet)super.addTarget(paramString);
  }
  
  public TransitionSet addTransition(Transition paramTransition)
  {
    this.a.add(paramTransition);
    paramTransition.mParent = this;
    if (this.mDuration >= 0L) {
      paramTransition.setDuration(this.mDuration);
    }
    return this;
  }
  
  protected void cancel()
  {
    super.cancel();
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.a.get(i)).cancel();
      i += 1;
    }
  }
  
  public void captureEndValues(ag paramag)
  {
    if (isValidTarget(paramag.b))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.isValidTarget(paramag.b))
        {
          localTransition.captureEndValues(paramag);
          paramag.c.add(localTransition);
        }
      }
    }
  }
  
  void capturePropagationValues(ag paramag)
  {
    super.capturePropagationValues(paramag);
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.a.get(i)).capturePropagationValues(paramag);
      i += 1;
    }
  }
  
  public void captureStartValues(ag paramag)
  {
    if (isValidTarget(paramag.b))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.isValidTarget(paramag.b))
        {
          localTransition.captureStartValues(paramag);
          paramag.c.add(localTransition);
        }
      }
    }
  }
  
  public Transition clone()
  {
    TransitionSet localTransitionSet = (TransitionSet)super.clone();
    localTransitionSet.a = new ArrayList();
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.addTransition(((Transition)this.a.get(i)).clone());
      i += 1;
    }
    return localTransitionSet;
  }
  
  protected void createAnimators(ViewGroup paramViewGroup, ah paramah1, ah paramah2, ArrayList<ag> paramArrayList1, ArrayList<ag> paramArrayList2)
  {
    long l1 = getStartDelay();
    int j = this.a.size();
    int i = 0;
    if (i < j)
    {
      Transition localTransition = (Transition)this.a.get(i);
      if ((l1 > 0L) && ((this.b) || (i == 0)))
      {
        long l2 = localTransition.getStartDelay();
        if (l2 <= 0L) {
          break label104;
        }
        localTransition.setStartDelay(l2 + l1);
      }
      for (;;)
      {
        localTransition.createAnimators(paramViewGroup, paramah1, paramah2, paramArrayList1, paramArrayList2);
        i += 1;
        break;
        label104:
        localTransition.setStartDelay(l1);
      }
    }
  }
  
  public Transition excludeTarget(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).excludeTarget(paramInt, paramBoolean);
      i += 1;
    }
    return super.excludeTarget(paramInt, paramBoolean);
  }
  
  public Transition excludeTarget(View paramView, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).excludeTarget(paramView, paramBoolean);
      i += 1;
    }
    return super.excludeTarget(paramView, paramBoolean);
  }
  
  public Transition excludeTarget(Class paramClass, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).excludeTarget(paramClass, paramBoolean);
      i += 1;
    }
    return super.excludeTarget(paramClass, paramBoolean);
  }
  
  public Transition excludeTarget(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).excludeTarget(paramString, paramBoolean);
      i += 1;
    }
    return super.excludeTarget(paramString, paramBoolean);
  }
  
  void forceToEnd(ViewGroup paramViewGroup)
  {
    super.forceToEnd(paramViewGroup);
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.a.get(i)).forceToEnd(paramViewGroup);
      i += 1;
    }
  }
  
  public int getOrdering()
  {
    if (this.b) {
      return 0;
    }
    return 1;
  }
  
  public Transition getTransitionAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a.size())) {
      return null;
    }
    return (Transition)this.a.get(paramInt);
  }
  
  public int getTransitionCount()
  {
    return this.a.size();
  }
  
  public void pause(View paramView)
  {
    super.pause(paramView);
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.a.get(i)).pause(paramView);
      i += 1;
    }
  }
  
  public TransitionSet removeListener(Transition.d paramd)
  {
    return (TransitionSet)super.removeListener(paramd);
  }
  
  public TransitionSet removeTarget(int paramInt)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).removeTarget(paramInt);
      i += 1;
    }
    return (TransitionSet)super.removeTarget(paramInt);
  }
  
  public TransitionSet removeTarget(View paramView)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).removeTarget(paramView);
      i += 1;
    }
    return (TransitionSet)super.removeTarget(paramView);
  }
  
  public TransitionSet removeTarget(Class paramClass)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).removeTarget(paramClass);
      i += 1;
    }
    return (TransitionSet)super.removeTarget(paramClass);
  }
  
  public TransitionSet removeTarget(String paramString)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).removeTarget(paramString);
      i += 1;
    }
    return (TransitionSet)super.removeTarget(paramString);
  }
  
  public TransitionSet removeTransition(Transition paramTransition)
  {
    this.a.remove(paramTransition);
    paramTransition.mParent = null;
    return this;
  }
  
  public void resume(View paramView)
  {
    super.resume(paramView);
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.a.get(i)).resume(paramView);
      i += 1;
    }
  }
  
  protected void runAnimators()
  {
    if (this.a.isEmpty())
    {
      start();
      end();
    }
    for (;;)
    {
      return;
      a();
      Object localObject;
      if (!this.b)
      {
        int i = 1;
        while (i < this.a.size())
        {
          ((Transition)this.a.get(i - 1)).addListener(new ac()
          {
            public void onTransitionEnd(Transition paramAnonymousTransition)
            {
              this.a.runAnimators();
              paramAnonymousTransition.removeListener(this);
            }
          });
          i += 1;
        }
        localObject = (Transition)this.a.get(0);
        if (localObject != null) {
          ((Transition)localObject).runAnimators();
        }
      }
      else
      {
        localObject = this.a.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).runAnimators();
        }
      }
    }
  }
  
  void setCanRemoveViews(boolean paramBoolean)
  {
    super.setCanRemoveViews(paramBoolean);
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.a.get(i)).setCanRemoveViews(paramBoolean);
      i += 1;
    }
  }
  
  public TransitionSet setDuration(long paramLong)
  {
    super.setDuration(paramLong);
    if (this.mDuration >= 0L)
    {
      int j = this.a.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.a.get(i)).setDuration(paramLong);
        i += 1;
      }
    }
    return this;
  }
  
  public void setEpicenterCallback(Transition.c paramc)
  {
    super.setEpicenterCallback(paramc);
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.a.get(i)).setEpicenterCallback(paramc);
      i += 1;
    }
  }
  
  public TransitionSet setInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    return (TransitionSet)super.setInterpolator(paramTimeInterpolator);
  }
  
  public TransitionSet setOrdering(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + paramInt);
    case 1: 
      this.b = false;
      return this;
    }
    this.b = true;
    return this;
  }
  
  public void setPathMotion(PathMotion paramPathMotion)
  {
    super.setPathMotion(paramPathMotion);
    int i = 0;
    while (i < this.a.size())
    {
      ((Transition)this.a.get(i)).setPathMotion(paramPathMotion);
      i += 1;
    }
  }
  
  public TransitionSet setStartDelay(long paramLong)
  {
    return (TransitionSet)super.setStartDelay(paramLong);
  }
  
  String toString(String paramString)
  {
    String str = super.toString(paramString);
    int i = 0;
    while (i < this.a.size())
    {
      str = str + "\n" + ((Transition)this.a.get(i)).toString(new StringBuilder().append(paramString).append("  ").toString());
      i += 1;
    }
    return str;
  }
  
  static class a
    extends ac
  {
    TransitionSet a;
    
    a(TransitionSet paramTransitionSet)
    {
      this.a = paramTransitionSet;
    }
    
    public void onTransitionEnd(Transition paramTransition)
    {
      TransitionSet.b(this.a);
      if (TransitionSet.c(this.a) == 0)
      {
        TransitionSet.a(this.a, false);
        this.a.end();
      }
      paramTransition.removeListener(this);
    }
    
    public void onTransitionStart(Transition paramTransition)
    {
      if (!TransitionSet.a(this.a))
      {
        this.a.start();
        TransitionSet.a(this.a, true);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/TransitionSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */