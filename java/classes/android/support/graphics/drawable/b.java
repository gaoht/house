package android.support.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2.AnimationCallback;
import android.graphics.drawable.Drawable;

public abstract interface b
  extends Animatable
{
  public abstract void clearAnimationCallbacks();
  
  public abstract void registerAnimationCallback(a parama);
  
  public abstract boolean unregisterAnimationCallback(a parama);
  
  public static abstract class a
  {
    Animatable2.AnimationCallback a;
    
    Animatable2.AnimationCallback a()
    {
      if (this.a == null) {
        this.a = new Animatable2.AnimationCallback()
        {
          public void onAnimationEnd(Drawable paramAnonymousDrawable)
          {
            b.a.this.onAnimationEnd(paramAnonymousDrawable);
          }
          
          public void onAnimationStart(Drawable paramAnonymousDrawable)
          {
            b.a.this.onAnimationStart(paramAnonymousDrawable);
          }
        };
      }
      return this.a;
    }
    
    public void onAnimationEnd(Drawable paramDrawable) {}
    
    public void onAnimationStart(Drawable paramDrawable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/graphics/drawable/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */