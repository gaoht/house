package android.support.v7.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class av
{
  private static final c a = new b(null);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      a = new a(null);
      return;
    }
  }
  
  public static void setTooltipText(View paramView, CharSequence paramCharSequence)
  {
    a.setTooltipText(paramView, paramCharSequence);
  }
  
  @TargetApi(26)
  private static class a
    implements av.c
  {
    public void setTooltipText(View paramView, CharSequence paramCharSequence)
    {
      paramView.setTooltipText(paramCharSequence);
    }
  }
  
  private static class b
    implements av.c
  {
    public void setTooltipText(View paramView, CharSequence paramCharSequence)
    {
      aw.setTooltipText(paramView, paramCharSequence);
    }
  }
  
  private static abstract interface c
  {
    public abstract void setTooltipText(View paramView, CharSequence paramCharSequence);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */