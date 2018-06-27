package android.support.v7.widget;

import android.view.View;

class al
{
  static int a(RecyclerView.r paramr, af paramaf, View paramView1, View paramView2, RecyclerView.h paramh, boolean paramBoolean)
  {
    if ((paramh.getChildCount() == 0) || (paramr.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return Math.abs(paramh.getPosition(paramView1) - paramh.getPosition(paramView2)) + 1;
    }
    int i = paramaf.getDecoratedEnd(paramView2);
    int j = paramaf.getDecoratedStart(paramView1);
    return Math.min(paramaf.getTotalSpace(), i - j);
  }
  
  static int a(RecyclerView.r paramr, af paramaf, View paramView1, View paramView2, RecyclerView.h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int j = i;
    if (paramh.getChildCount() != 0)
    {
      j = i;
      if (paramr.getItemCount() != 0)
      {
        j = i;
        if (paramView1 != null)
        {
          if (paramView2 != null) {
            break label45;
          }
          j = i;
        }
      }
    }
    return j;
    label45:
    i = Math.min(paramh.getPosition(paramView1), paramh.getPosition(paramView2));
    j = Math.max(paramh.getPosition(paramView1), paramh.getPosition(paramView2));
    if (paramBoolean2) {}
    for (i = Math.max(0, paramr.getItemCount() - j - 1);; i = Math.max(0, i))
    {
      j = i;
      if (!paramBoolean1) {
        break;
      }
      j = Math.abs(paramaf.getDecoratedEnd(paramView2) - paramaf.getDecoratedStart(paramView1));
      int k = Math.abs(paramh.getPosition(paramView1) - paramh.getPosition(paramView2));
      float f = j / (k + 1);
      return Math.round(i * f + (paramaf.getStartAfterPadding() - paramaf.getDecoratedStart(paramView1)));
    }
  }
  
  static int b(RecyclerView.r paramr, af paramaf, View paramView1, View paramView2, RecyclerView.h paramh, boolean paramBoolean)
  {
    if ((paramh.getChildCount() == 0) || (paramr.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return paramr.getItemCount();
    }
    int i = paramaf.getDecoratedEnd(paramView2);
    int j = paramaf.getDecoratedStart(paramView1);
    int k = Math.abs(paramh.getPosition(paramView1) - paramh.getPosition(paramView2));
    return (int)((i - j) / (k + 1) * paramr.getItemCount());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */