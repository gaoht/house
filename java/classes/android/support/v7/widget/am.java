package android.support.v7.widget;

import android.view.View;

public abstract class am
  extends RecyclerView.e
{
  boolean h = true;
  
  public abstract boolean animateAdd(RecyclerView.u paramu);
  
  public boolean animateAppearance(RecyclerView.u paramu, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2)
  {
    if ((paramc1 != null) && ((paramc1.a != paramc2.a) || (paramc1.b != paramc2.b))) {
      return animateMove(paramu, paramc1.a, paramc1.b, paramc2.a, paramc2.b);
    }
    return animateAdd(paramu);
  }
  
  public abstract boolean animateChange(RecyclerView.u paramu1, RecyclerView.u paramu2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean animateChange(RecyclerView.u paramu1, RecyclerView.u paramu2, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2)
  {
    int k = paramc1.a;
    int m = paramc1.b;
    int i;
    if (paramu2.shouldIgnore()) {
      i = paramc1.a;
    }
    for (int j = paramc1.b;; j = paramc2.b)
    {
      return animateChange(paramu1, paramu2, k, m, i, j);
      i = paramc2.a;
    }
  }
  
  public boolean animateDisappearance(RecyclerView.u paramu, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2)
  {
    int k = paramc1.a;
    int m = paramc1.b;
    paramc1 = paramu.itemView;
    int i;
    if (paramc2 == null)
    {
      i = paramc1.getLeft();
      if (paramc2 != null) {
        break label103;
      }
    }
    label103:
    for (int j = paramc1.getTop();; j = paramc2.b)
    {
      if ((paramu.isRemoved()) || ((k == i) && (m == j))) {
        break label112;
      }
      paramc1.layout(i, j, paramc1.getWidth() + i, paramc1.getHeight() + j);
      return animateMove(paramu, k, m, i, j);
      i = paramc2.a;
      break;
    }
    label112:
    return animateRemove(paramu);
  }
  
  public abstract boolean animateMove(RecyclerView.u paramu, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean animatePersistence(RecyclerView.u paramu, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2)
  {
    if ((paramc1.a != paramc2.a) || (paramc1.b != paramc2.b)) {
      return animateMove(paramu, paramc1.a, paramc1.b, paramc2.a, paramc2.b);
    }
    dispatchMoveFinished(paramu);
    return false;
  }
  
  public abstract boolean animateRemove(RecyclerView.u paramu);
  
  public boolean canReuseUpdatedViewHolder(RecyclerView.u paramu)
  {
    return (!this.h) || (paramu.isInvalid());
  }
  
  public final void dispatchAddFinished(RecyclerView.u paramu)
  {
    onAddFinished(paramu);
    dispatchAnimationFinished(paramu);
  }
  
  public final void dispatchAddStarting(RecyclerView.u paramu)
  {
    onAddStarting(paramu);
  }
  
  public final void dispatchChangeFinished(RecyclerView.u paramu, boolean paramBoolean)
  {
    onChangeFinished(paramu, paramBoolean);
    dispatchAnimationFinished(paramu);
  }
  
  public final void dispatchChangeStarting(RecyclerView.u paramu, boolean paramBoolean)
  {
    onChangeStarting(paramu, paramBoolean);
  }
  
  public final void dispatchMoveFinished(RecyclerView.u paramu)
  {
    onMoveFinished(paramu);
    dispatchAnimationFinished(paramu);
  }
  
  public final void dispatchMoveStarting(RecyclerView.u paramu)
  {
    onMoveStarting(paramu);
  }
  
  public final void dispatchRemoveFinished(RecyclerView.u paramu)
  {
    onRemoveFinished(paramu);
    dispatchAnimationFinished(paramu);
  }
  
  public final void dispatchRemoveStarting(RecyclerView.u paramu)
  {
    onRemoveStarting(paramu);
  }
  
  public boolean getSupportsChangeAnimations()
  {
    return this.h;
  }
  
  public void onAddFinished(RecyclerView.u paramu) {}
  
  public void onAddStarting(RecyclerView.u paramu) {}
  
  public void onChangeFinished(RecyclerView.u paramu, boolean paramBoolean) {}
  
  public void onChangeStarting(RecyclerView.u paramu, boolean paramBoolean) {}
  
  public void onMoveFinished(RecyclerView.u paramu) {}
  
  public void onMoveStarting(RecyclerView.u paramu) {}
  
  public void onRemoveFinished(RecyclerView.u paramu) {}
  
  public void onRemoveStarting(RecyclerView.u paramu) {}
  
  public void setSupportsChangeAnimations(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */