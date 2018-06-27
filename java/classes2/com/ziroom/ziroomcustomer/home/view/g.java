package com.ziroom.ziroomcustomer.home.view;

import android.os.Build.VERSION;
import android.view.View;

public class g
{
  static final d.d a = new d.d()
  {
    public d createAnimator()
    {
      if (Build.VERSION.SDK_INT >= 12) {}
      for (Object localObject = new f();; localObject = new e()) {
        return new d((d.e)localObject);
      }
    }
  };
  private static final a b = new b(null);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      b = new c(null);
      return;
    }
  }
  
  static d a()
  {
    return a.createAnimator();
  }
  
  private static abstract interface a
  {
    public abstract void setBoundsViewOutlineProvider(View paramView);
  }
  
  private static class b
    implements g.a
  {
    public void setBoundsViewOutlineProvider(View paramView) {}
  }
  
  private static class c
    implements g.a
  {
    public void setBoundsViewOutlineProvider(View paramView)
    {
      h.a(paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */