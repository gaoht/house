package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

class as
{
  static final Property<View, Float> a;
  static final Property<View, Rect> b;
  private static final ay c;
  private static Field d;
  private static boolean e;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22) {
      c = new ax();
    }
    for (;;)
    {
      a = new Property(Float.class, "translationAlpha")
      {
        public Float get(View paramAnonymousView)
        {
          return Float.valueOf(as.c(paramAnonymousView));
        }
        
        public void set(View paramAnonymousView, Float paramAnonymousFloat)
        {
          as.a(paramAnonymousView, paramAnonymousFloat.floatValue());
        }
      };
      b = new Property(Rect.class, "clipBounds")
      {
        public Rect get(View paramAnonymousView)
        {
          return ViewCompat.getClipBounds(paramAnonymousView);
        }
        
        public void set(View paramAnonymousView, Rect paramAnonymousRect)
        {
          ViewCompat.setClipBounds(paramAnonymousView, paramAnonymousRect);
        }
      };
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        c = new aw();
      } else if (Build.VERSION.SDK_INT >= 19) {
        c = new av();
      } else if (Build.VERSION.SDK_INT >= 18) {
        c = new au();
      } else {
        c = new at();
      }
    }
  }
  
  static ar a(View paramView)
  {
    return c.getOverlay(paramView);
  }
  
  private static void a()
  {
    if (!e) {}
    try
    {
      d = View.class.getDeclaredField("mViewFlags");
      d.setAccessible(true);
      e = true;
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Log.i("ViewUtils", "fetchViewFlagsField: ");
      }
    }
  }
  
  static void a(View paramView, float paramFloat)
  {
    c.setTransitionAlpha(paramView, paramFloat);
  }
  
  static void a(View paramView, int paramInt)
  {
    
    if (d != null) {}
    try
    {
      int i = d.getInt(paramView);
      d.setInt(paramView, i & 0xFFFFFFF3 | paramInt);
      return;
    }
    catch (IllegalAccessException paramView) {}
  }
  
  static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c.setLeftTopRightBottom(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void a(View paramView, Matrix paramMatrix)
  {
    c.transformMatrixToGlobal(paramView, paramMatrix);
  }
  
  static bc b(View paramView)
  {
    return c.getWindowId(paramView);
  }
  
  static void b(View paramView, Matrix paramMatrix)
  {
    c.transformMatrixToLocal(paramView, paramMatrix);
  }
  
  static float c(View paramView)
  {
    return c.getTransitionAlpha(paramView);
  }
  
  static void c(View paramView, Matrix paramMatrix)
  {
    c.setAnimationMatrix(paramView, paramMatrix);
  }
  
  static void d(View paramView)
  {
    c.saveNonTransitionAlpha(paramView);
  }
  
  static void e(View paramView)
  {
    c.clearNonTransitionAlpha(paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */