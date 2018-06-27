package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v
  extends am
{
  private static TimeInterpolator i;
  ArrayList<ArrayList<RecyclerView.u>> a = new ArrayList();
  ArrayList<ArrayList<b>> b = new ArrayList();
  ArrayList<ArrayList<a>> c = new ArrayList();
  ArrayList<RecyclerView.u> d = new ArrayList();
  ArrayList<RecyclerView.u> e = new ArrayList();
  ArrayList<RecyclerView.u> f = new ArrayList();
  ArrayList<RecyclerView.u> g = new ArrayList();
  private ArrayList<RecyclerView.u> j = new ArrayList();
  private ArrayList<RecyclerView.u> k = new ArrayList();
  private ArrayList<b> l = new ArrayList();
  private ArrayList<a> m = new ArrayList();
  
  private void a(List<a> paramList, RecyclerView.u paramu)
  {
    int n = paramList.size() - 1;
    while (n >= 0)
    {
      a locala = (a)paramList.get(n);
      if ((a(locala, paramu)) && (locala.a == null) && (locala.b == null)) {
        paramList.remove(locala);
      }
      n -= 1;
    }
  }
  
  private boolean a(a parama, RecyclerView.u paramu)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (parama.b == paramu) {
      parama.b = null;
    }
    for (;;)
    {
      paramu.itemView.setAlpha(1.0F);
      paramu.itemView.setTranslationX(0.0F);
      paramu.itemView.setTranslationY(0.0F);
      dispatchChangeFinished(paramu, bool1);
      bool1 = true;
      do
      {
        return bool1;
        bool1 = bool2;
      } while (parama.a != paramu);
      parama.a = null;
      bool1 = true;
    }
  }
  
  private void b(a parama)
  {
    if (parama.a != null) {
      a(parama, parama.a);
    }
    if (parama.b != null) {
      a(parama, parama.b);
    }
  }
  
  private void c(final RecyclerView.u paramu)
  {
    final View localView = paramu.itemView;
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.f.add(paramu);
    localViewPropertyAnimator.setDuration(getRemoveDuration()).alpha(0.0F).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localViewPropertyAnimator.setListener(null);
        localView.setAlpha(1.0F);
        v.this.dispatchRemoveFinished(paramu);
        v.this.f.remove(paramu);
        v.this.a();
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        v.this.dispatchRemoveStarting(paramu);
      }
    }).start();
  }
  
  private void d(RecyclerView.u paramu)
  {
    if (i == null) {
      i = new ValueAnimator().getInterpolator();
    }
    paramu.itemView.animate().setInterpolator(i);
    endAnimation(paramu);
  }
  
  void a()
  {
    if (!isRunning()) {
      dispatchAnimationsFinished();
    }
  }
  
  void a(final RecyclerView.u paramu)
  {
    final View localView = paramu.itemView;
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.d.add(paramu);
    localViewPropertyAnimator.alpha(1.0F).setDuration(getAddDuration()).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        localView.setAlpha(1.0F);
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localViewPropertyAnimator.setListener(null);
        v.this.dispatchAddFinished(paramu);
        v.this.d.remove(paramu);
        v.this.a();
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        v.this.dispatchAddStarting(paramu);
      }
    }).start();
  }
  
  void a(final RecyclerView.u paramu, final int paramInt1, final int paramInt2, int paramInt3, int paramInt4)
  {
    final View localView = paramu.itemView;
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if (paramInt1 != 0) {
      localView.animate().translationX(0.0F);
    }
    if (paramInt2 != 0) {
      localView.animate().translationY(0.0F);
    }
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.e.add(paramu);
    localViewPropertyAnimator.setDuration(getMoveDuration()).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        if (paramInt1 != 0) {
          localView.setTranslationX(0.0F);
        }
        if (paramInt2 != 0) {
          localView.setTranslationY(0.0F);
        }
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localViewPropertyAnimator.setListener(null);
        v.this.dispatchMoveFinished(paramu);
        v.this.e.remove(paramu);
        v.this.a();
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        v.this.dispatchMoveStarting(paramu);
      }
    }).start();
  }
  
  void a(final a parama)
  {
    final View localView = null;
    final Object localObject1 = parama.a;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((RecyclerView.u)localObject1).itemView)
    {
      final Object localObject2 = parama.b;
      if (localObject2 != null) {
        localView = ((RecyclerView.u)localObject2).itemView;
      }
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).animate().setDuration(getChangeDuration());
        this.g.add(parama.a);
        ((ViewPropertyAnimator)localObject2).translationX(parama.e - parama.c);
        ((ViewPropertyAnimator)localObject2).translationY(parama.f - parama.d);
        ((ViewPropertyAnimator)localObject2).alpha(0.0F).setListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            localObject2.setListener(null);
            localObject1.setAlpha(1.0F);
            localObject1.setTranslationX(0.0F);
            localObject1.setTranslationY(0.0F);
            v.this.dispatchChangeFinished(parama.a, true);
            v.this.g.remove(parama.a);
            v.this.a();
          }
          
          public void onAnimationStart(Animator paramAnonymousAnimator)
          {
            v.this.dispatchChangeStarting(parama.a, true);
          }
        }).start();
      }
      if (localView != null)
      {
        localObject1 = localView.animate();
        this.g.add(parama.b);
        ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(getChangeDuration()).alpha(1.0F).setListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            localObject1.setListener(null);
            localView.setAlpha(1.0F);
            localView.setTranslationX(0.0F);
            localView.setTranslationY(0.0F);
            v.this.dispatchChangeFinished(parama.b, false);
            v.this.g.remove(parama.b);
            v.this.a();
          }
          
          public void onAnimationStart(Animator paramAnonymousAnimator)
          {
            v.this.dispatchChangeStarting(parama.b, false);
          }
        }).start();
      }
      return;
    }
  }
  
  void a(List<RecyclerView.u> paramList)
  {
    int n = paramList.size() - 1;
    while (n >= 0)
    {
      ((RecyclerView.u)paramList.get(n)).itemView.animate().cancel();
      n -= 1;
    }
  }
  
  public boolean animateAdd(RecyclerView.u paramu)
  {
    d(paramu);
    paramu.itemView.setAlpha(0.0F);
    this.k.add(paramu);
    return true;
  }
  
  public boolean animateChange(RecyclerView.u paramu1, RecyclerView.u paramu2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramu1 == paramu2) {
      return animateMove(paramu1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = paramu1.itemView.getTranslationX();
    float f2 = paramu1.itemView.getTranslationY();
    float f3 = paramu1.itemView.getAlpha();
    d(paramu1);
    int n = (int)(paramInt3 - paramInt1 - f1);
    int i1 = (int)(paramInt4 - paramInt2 - f2);
    paramu1.itemView.setTranslationX(f1);
    paramu1.itemView.setTranslationY(f2);
    paramu1.itemView.setAlpha(f3);
    if (paramu2 != null)
    {
      d(paramu2);
      paramu2.itemView.setTranslationX(-n);
      paramu2.itemView.setTranslationY(-i1);
      paramu2.itemView.setAlpha(0.0F);
    }
    this.m.add(new a(paramu1, paramu2, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean animateMove(RecyclerView.u paramu, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramu.itemView;
    paramInt1 += (int)paramu.itemView.getTranslationX();
    paramInt2 += (int)paramu.itemView.getTranslationY();
    d(paramu);
    int n = paramInt3 - paramInt1;
    int i1 = paramInt4 - paramInt2;
    if ((n == 0) && (i1 == 0))
    {
      dispatchMoveFinished(paramu);
      return false;
    }
    if (n != 0) {
      localView.setTranslationX(-n);
    }
    if (i1 != 0) {
      localView.setTranslationY(-i1);
    }
    this.l.add(new b(paramu, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean animateRemove(RecyclerView.u paramu)
  {
    d(paramu);
    this.j.add(paramu);
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(RecyclerView.u paramu, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.canReuseUpdatedViewHolder(paramu, paramList));
  }
  
  public void endAnimation(RecyclerView.u paramu)
  {
    View localView = paramu.itemView;
    localView.animate().cancel();
    int n = this.l.size() - 1;
    while (n >= 0)
    {
      if (((b)this.l.get(n)).a == paramu)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        dispatchMoveFinished(paramu);
        this.l.remove(n);
      }
      n -= 1;
    }
    a(this.m, paramu);
    if (this.j.remove(paramu))
    {
      localView.setAlpha(1.0F);
      dispatchRemoveFinished(paramu);
    }
    if (this.k.remove(paramu))
    {
      localView.setAlpha(1.0F);
      dispatchAddFinished(paramu);
    }
    n = this.c.size() - 1;
    ArrayList localArrayList;
    while (n >= 0)
    {
      localArrayList = (ArrayList)this.c.get(n);
      a(localArrayList, paramu);
      if (localArrayList.isEmpty()) {
        this.c.remove(n);
      }
      n -= 1;
    }
    n = this.b.size() - 1;
    if (n >= 0)
    {
      localArrayList = (ArrayList)this.b.get(n);
      int i1 = localArrayList.size() - 1;
      for (;;)
      {
        if (i1 >= 0)
        {
          if (((b)localArrayList.get(i1)).a != paramu) {
            break label293;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          dispatchMoveFinished(paramu);
          localArrayList.remove(i1);
          if (localArrayList.isEmpty()) {
            this.b.remove(n);
          }
        }
        n -= 1;
        break;
        label293:
        i1 -= 1;
      }
    }
    n = this.a.size() - 1;
    while (n >= 0)
    {
      localArrayList = (ArrayList)this.a.get(n);
      if (localArrayList.remove(paramu))
      {
        localView.setAlpha(1.0F);
        dispatchAddFinished(paramu);
        if (localArrayList.isEmpty()) {
          this.a.remove(n);
        }
      }
      n -= 1;
    }
    if ((!this.f.remove(paramu)) || ((!this.d.remove(paramu)) || ((!this.g.remove(paramu)) || (this.e.remove(paramu))))) {}
    a();
  }
  
  public void endAnimations()
  {
    int n = this.l.size() - 1;
    Object localObject1;
    Object localObject2;
    while (n >= 0)
    {
      localObject1 = (b)this.l.get(n);
      localObject2 = ((b)localObject1).a.itemView;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      dispatchMoveFinished(((b)localObject1).a);
      this.l.remove(n);
      n -= 1;
    }
    n = this.j.size() - 1;
    while (n >= 0)
    {
      dispatchRemoveFinished((RecyclerView.u)this.j.get(n));
      this.j.remove(n);
      n -= 1;
    }
    n = this.k.size() - 1;
    while (n >= 0)
    {
      localObject1 = (RecyclerView.u)this.k.get(n);
      ((RecyclerView.u)localObject1).itemView.setAlpha(1.0F);
      dispatchAddFinished((RecyclerView.u)localObject1);
      this.k.remove(n);
      n -= 1;
    }
    n = this.m.size() - 1;
    while (n >= 0)
    {
      b((a)this.m.get(n));
      n -= 1;
    }
    this.m.clear();
    if (!isRunning()) {
      return;
    }
    n = this.b.size() - 1;
    int i1;
    while (n >= 0)
    {
      localObject1 = (ArrayList)this.b.get(n);
      i1 = ((ArrayList)localObject1).size() - 1;
      while (i1 >= 0)
      {
        localObject2 = (b)((ArrayList)localObject1).get(i1);
        View localView = ((b)localObject2).a.itemView;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        dispatchMoveFinished(((b)localObject2).a);
        ((ArrayList)localObject1).remove(i1);
        if (((ArrayList)localObject1).isEmpty()) {
          this.b.remove(localObject1);
        }
        i1 -= 1;
      }
      n -= 1;
    }
    n = this.a.size() - 1;
    while (n >= 0)
    {
      localObject1 = (ArrayList)this.a.get(n);
      i1 = ((ArrayList)localObject1).size() - 1;
      while (i1 >= 0)
      {
        localObject2 = (RecyclerView.u)((ArrayList)localObject1).get(i1);
        ((RecyclerView.u)localObject2).itemView.setAlpha(1.0F);
        dispatchAddFinished((RecyclerView.u)localObject2);
        ((ArrayList)localObject1).remove(i1);
        if (((ArrayList)localObject1).isEmpty()) {
          this.a.remove(localObject1);
        }
        i1 -= 1;
      }
      n -= 1;
    }
    n = this.c.size() - 1;
    while (n >= 0)
    {
      localObject1 = (ArrayList)this.c.get(n);
      i1 = ((ArrayList)localObject1).size() - 1;
      while (i1 >= 0)
      {
        b((a)((ArrayList)localObject1).get(i1));
        if (((ArrayList)localObject1).isEmpty()) {
          this.c.remove(localObject1);
        }
        i1 -= 1;
      }
      n -= 1;
    }
    a(this.f);
    a(this.e);
    a(this.d);
    a(this.g);
    dispatchAnimationsFinished();
  }
  
  public boolean isRunning()
  {
    return (!this.k.isEmpty()) || (!this.m.isEmpty()) || (!this.l.isEmpty()) || (!this.j.isEmpty()) || (!this.e.isEmpty()) || (!this.f.isEmpty()) || (!this.d.isEmpty()) || (!this.g.isEmpty()) || (!this.b.isEmpty()) || (!this.a.isEmpty()) || (!this.c.isEmpty());
  }
  
  public void runPendingAnimations()
  {
    int n;
    int i1;
    label24:
    int i2;
    if (!this.j.isEmpty())
    {
      n = 1;
      if (this.l.isEmpty()) {
        break label72;
      }
      i1 = 1;
      if (this.m.isEmpty()) {
        break label77;
      }
      i2 = 1;
      label36:
      if (this.k.isEmpty()) {
        break label82;
      }
    }
    label72:
    label77:
    label82:
    for (int i3 = 1;; i3 = 0)
    {
      if ((n != 0) || (i1 != 0) || (i3 != 0) || (i2 != 0)) {
        break label88;
      }
      return;
      n = 0;
      break;
      i1 = 0;
      break label24;
      i2 = 0;
      break label36;
    }
    label88:
    final Object localObject1 = this.j.iterator();
    while (((Iterator)localObject1).hasNext()) {
      c((RecyclerView.u)((Iterator)localObject1).next());
    }
    this.j.clear();
    Object localObject2;
    label211:
    label291:
    long l1;
    label366:
    long l2;
    if (i1 != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.l);
      this.b.add(localObject1);
      this.l.clear();
      localObject2 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = localObject1.iterator();
          while (localIterator.hasNext())
          {
            v.b localb = (v.b)localIterator.next();
            v.this.a(localb.a, localb.b, localb.c, localb.d, localb.e);
          }
          localObject1.clear();
          v.this.b.remove(localObject1);
        }
      };
      if (n != 0) {
        ViewCompat.postOnAnimationDelayed(((b)((ArrayList)localObject1).get(0)).a.itemView, (Runnable)localObject2, getRemoveDuration());
      }
    }
    else
    {
      if (i2 != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.m);
        this.c.add(localObject1);
        this.m.clear();
        localObject2 = new Runnable()
        {
          public void run()
          {
            Iterator localIterator = localObject1.iterator();
            while (localIterator.hasNext())
            {
              v.a locala = (v.a)localIterator.next();
              v.this.a(locala);
            }
            localObject1.clear();
            v.this.c.remove(localObject1);
          }
        };
        if (n == 0) {
          break label428;
        }
        ViewCompat.postOnAnimationDelayed(((a)((ArrayList)localObject1).get(0)).a.itemView, (Runnable)localObject2, getRemoveDuration());
      }
      if (i3 == 0) {
        break label436;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.k);
      this.a.add(localObject1);
      this.k.clear();
      localObject2 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = localObject1.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.u localu = (RecyclerView.u)localIterator.next();
            v.this.a(localu);
          }
          localObject1.clear();
          localObject1.remove(localObject1);
        }
      };
      if ((n == 0) && (i1 == 0) && (i2 == 0)) {
        break label456;
      }
      if (n == 0) {
        break label438;
      }
      l1 = getRemoveDuration();
      if (i1 == 0) {
        break label444;
      }
      l2 = getMoveDuration();
      label376:
      if (i2 == 0) {
        break label450;
      }
    }
    label428:
    label436:
    label438:
    label444:
    label450:
    for (long l3 = getChangeDuration();; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      ViewCompat.postOnAnimationDelayed(((RecyclerView.u)((ArrayList)localObject1).get(0)).itemView, (Runnable)localObject2, l1 + l2);
      return;
      ((Runnable)localObject2).run();
      break label211;
      ((Runnable)localObject2).run();
      break label291;
      break;
      l1 = 0L;
      break label366;
      l2 = 0L;
      break label376;
    }
    label456:
    ((Runnable)localObject2).run();
  }
  
  private static class a
  {
    public RecyclerView.u a;
    public RecyclerView.u b;
    public int c;
    public int d;
    public int e;
    public int f;
    
    private a(RecyclerView.u paramu1, RecyclerView.u paramu2)
    {
      this.a = paramu1;
      this.b = paramu2;
    }
    
    a(RecyclerView.u paramu1, RecyclerView.u paramu2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramu1, paramu2);
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramInt3;
      this.f = paramInt4;
    }
    
    public String toString()
    {
      return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
    }
  }
  
  private static class b
  {
    public RecyclerView.u a;
    public int b;
    public int c;
    public int d;
    public int e;
    
    b(RecyclerView.u paramu, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramu;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */