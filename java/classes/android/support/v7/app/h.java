package android.support.v7.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;

class h
  extends AppCompatDelegateImplV9
{
  h(Context paramContext, Window paramWindow, d paramd)
  {
    super(paramContext, paramWindow, paramd);
  }
  
  View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return null;
  }
  
  public boolean hasWindowFeature(int paramInt)
  {
    return (super.hasWindowFeature(paramInt)) || (this.b.hasFeature(paramInt));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */