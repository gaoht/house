package android.support.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class z
{
  private Context a;
  private int b = -1;
  private ViewGroup c;
  private View d;
  private Runnable e;
  private Runnable f;
  
  public z(ViewGroup paramViewGroup)
  {
    this.c = paramViewGroup;
  }
  
  private z(ViewGroup paramViewGroup, int paramInt, Context paramContext)
  {
    this.a = paramContext;
    this.c = paramViewGroup;
    this.b = paramInt;
  }
  
  public z(ViewGroup paramViewGroup, View paramView)
  {
    this.c = paramViewGroup;
    this.d = paramView;
  }
  
  static z a(View paramView)
  {
    return (z)paramView.getTag(R.id.transition_current_scene);
  }
  
  static void a(View paramView, z paramz)
  {
    paramView.setTag(R.id.transition_current_scene, paramz);
  }
  
  public static z getSceneForLayout(ViewGroup paramViewGroup, int paramInt, Context paramContext)
  {
    SparseArray localSparseArray = (SparseArray)paramViewGroup.getTag(R.id.transition_scene_layoutid_cache);
    if (localSparseArray == null)
    {
      localSparseArray = new SparseArray();
      paramViewGroup.setTag(R.id.transition_scene_layoutid_cache, localSparseArray);
    }
    for (;;)
    {
      z localz = (z)localSparseArray.get(paramInt);
      if (localz != null) {
        return localz;
      }
      paramViewGroup = new z(paramViewGroup, paramInt, paramContext);
      localSparseArray.put(paramInt, paramViewGroup);
      return paramViewGroup;
    }
  }
  
  boolean a()
  {
    return this.b > 0;
  }
  
  public void enter()
  {
    if ((this.b > 0) || (this.d != null))
    {
      getSceneRoot().removeAllViews();
      if (this.b <= 0) {
        break label72;
      }
      LayoutInflater.from(this.a).inflate(this.b, this.c);
    }
    for (;;)
    {
      if (this.e != null) {
        this.e.run();
      }
      a(this.c, this);
      return;
      label72:
      this.c.addView(this.d);
    }
  }
  
  public void exit()
  {
    if ((a(this.c) == this) && (this.f != null)) {
      this.f.run();
    }
  }
  
  public ViewGroup getSceneRoot()
  {
    return this.c;
  }
  
  public void setEnterAction(Runnable paramRunnable)
  {
    this.e = paramRunnable;
  }
  
  public void setExitAction(Runnable paramRunnable)
  {
    this.f = paramRunnable;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */