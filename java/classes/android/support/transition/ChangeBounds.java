package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class ChangeBounds
  extends Transition
{
  private static final String[] a = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  private static final Property<Drawable, PointF> b = new Property(PointF.class, "boundsOrigin")
  {
    private Rect a = new Rect();
    
    public PointF get(Drawable paramAnonymousDrawable)
    {
      paramAnonymousDrawable.copyBounds(this.a);
      return new PointF(this.a.left, this.a.top);
    }
    
    public void set(Drawable paramAnonymousDrawable, PointF paramAnonymousPointF)
    {
      paramAnonymousDrawable.copyBounds(this.a);
      this.a.offsetTo(Math.round(paramAnonymousPointF.x), Math.round(paramAnonymousPointF.y));
      paramAnonymousDrawable.setBounds(this.a);
    }
  };
  private static final Property<a, PointF> c = new Property(PointF.class, "topLeft")
  {
    public PointF get(ChangeBounds.a paramAnonymousa)
    {
      return null;
    }
    
    public void set(ChangeBounds.a paramAnonymousa, PointF paramAnonymousPointF)
    {
      paramAnonymousa.a(paramAnonymousPointF);
    }
  };
  private static final Property<a, PointF> d = new Property(PointF.class, "bottomRight")
  {
    public PointF get(ChangeBounds.a paramAnonymousa)
    {
      return null;
    }
    
    public void set(ChangeBounds.a paramAnonymousa, PointF paramAnonymousPointF)
    {
      paramAnonymousa.b(paramAnonymousPointF);
    }
  };
  private static final Property<View, PointF> e = new Property(PointF.class, "bottomRight")
  {
    public PointF get(View paramAnonymousView)
    {
      return null;
    }
    
    public void set(View paramAnonymousView, PointF paramAnonymousPointF)
    {
      as.a(paramAnonymousView, paramAnonymousView.getLeft(), paramAnonymousView.getTop(), Math.round(paramAnonymousPointF.x), Math.round(paramAnonymousPointF.y));
    }
  };
  private static final Property<View, PointF> f = new Property(PointF.class, "topLeft")
  {
    public PointF get(View paramAnonymousView)
    {
      return null;
    }
    
    public void set(View paramAnonymousView, PointF paramAnonymousPointF)
    {
      as.a(paramAnonymousView, Math.round(paramAnonymousPointF.x), Math.round(paramAnonymousPointF.y), paramAnonymousView.getRight(), paramAnonymousView.getBottom());
    }
  };
  private static final Property<View, PointF> g = new Property(PointF.class, "position")
  {
    public PointF get(View paramAnonymousView)
    {
      return null;
    }
    
    public void set(View paramAnonymousView, PointF paramAnonymousPointF)
    {
      int i = Math.round(paramAnonymousPointF.x);
      int j = Math.round(paramAnonymousPointF.y);
      as.a(paramAnonymousView, i, j, paramAnonymousView.getWidth() + i, paramAnonymousView.getHeight() + j);
    }
  };
  private static y k = new y();
  private int[] h = new int[2];
  private boolean i = false;
  private boolean j = false;
  
  public ChangeBounds() {}
  
  public ChangeBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ab.d);
    boolean bool = TypedArrayUtils.getNamedBoolean(paramContext, (XmlResourceParser)paramAttributeSet, "resizeClip", 0, false);
    paramContext.recycle();
    setResizeClip(bool);
  }
  
  private void a(ag paramag)
  {
    View localView = paramag.b;
    if ((ViewCompat.isLaidOut(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      paramag.a.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramag.a.put("android:changeBounds:parent", paramag.b.getParent());
      if (this.j)
      {
        paramag.b.getLocationInWindow(this.h);
        paramag.a.put("android:changeBounds:windowX", Integer.valueOf(this.h[0]));
        paramag.a.put("android:changeBounds:windowY", Integer.valueOf(this.h[1]));
      }
      if (this.i) {
        paramag.a.put("android:changeBounds:clip", ViewCompat.getClipBounds(localView));
      }
    }
  }
  
  private boolean a(View paramView1, View paramView2)
  {
    ag localag;
    if (this.j)
    {
      localag = getMatchedTransitionValues(paramView1, true);
      if (localag != null) {
        break label27;
      }
      if (paramView1 != paramView2) {
        break label25;
      }
    }
    label25:
    label27:
    while (paramView2 == localag.b)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void captureEndValues(ag paramag)
  {
    a(paramag);
  }
  
  public void captureStartValues(ag paramag)
  {
    a(paramag);
  }
  
  public Animator createAnimator(final ViewGroup paramViewGroup, final ag paramag1, ag paramag2)
  {
    if ((paramag1 == null) || (paramag2 == null))
    {
      paramag1 = null;
      return paramag1;
    }
    final Object localObject1 = paramag1.a;
    final Object localObject2 = paramag2.a;
    localObject1 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
    ViewGroup localViewGroup = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
    if ((localObject1 == null) || (localViewGroup == null)) {
      return null;
    }
    localObject2 = paramag2.b;
    int i2;
    final int i3;
    final int i5;
    final int i7;
    final int i9;
    int i10;
    int i11;
    int i12;
    int i13;
    int i1;
    int n;
    int m;
    if (a((View)localObject1, localViewGroup))
    {
      paramViewGroup = (Rect)paramag1.a.get("android:changeBounds:bounds");
      localObject1 = (Rect)paramag2.a.get("android:changeBounds:bounds");
      i2 = paramViewGroup.left;
      i3 = ((Rect)localObject1).left;
      int i4 = paramViewGroup.top;
      i5 = ((Rect)localObject1).top;
      int i6 = paramViewGroup.right;
      i7 = ((Rect)localObject1).right;
      int i8 = paramViewGroup.bottom;
      i9 = ((Rect)localObject1).bottom;
      i10 = i6 - i2;
      i11 = i8 - i4;
      i12 = i7 - i3;
      i13 = i9 - i5;
      paramag1 = (Rect)paramag1.a.get("android:changeBounds:clip");
      localObject1 = (Rect)paramag2.a.get("android:changeBounds:clip");
      i1 = 0;
      n = 0;
      if ((i10 == 0) || (i11 == 0))
      {
        m = i1;
        if (i12 != 0)
        {
          m = i1;
          if (i13 == 0) {}
        }
      }
      else
      {
        if ((i2 != i3) || (i4 != i5)) {
          n = 1;
        }
        if (i6 == i7)
        {
          m = n;
          if (i8 == i9) {}
        }
        else
        {
          m = n + 1;
        }
      }
      if ((paramag1 == null) || (paramag1.equals(localObject1)))
      {
        n = m;
        if (paramag1 == null)
        {
          n = m;
          if (localObject1 == null) {}
        }
      }
      else
      {
        n = m + 1;
      }
      if (n <= 0) {
        break label1070;
      }
      if (!this.i)
      {
        as.a((View)localObject2, i2, i4, i6, i8);
        if (n == 2) {
          if ((i10 == i12) && (i11 == i13))
          {
            paramViewGroup = getPathMotion().getPath(i2, i4, i3, i5);
            paramViewGroup = o.a(localObject2, g, paramViewGroup);
          }
        }
        for (;;)
        {
          paramag1 = paramViewGroup;
          if (!(((View)localObject2).getParent() instanceof ViewGroup)) {
            break;
          }
          paramag1 = (ViewGroup)((View)localObject2).getParent();
          am.a(paramag1, true);
          addListener(new ac()
          {
            boolean a = false;
            
            public void onTransitionCancel(Transition paramAnonymousTransition)
            {
              am.a(paramag1, false);
              this.a = true;
            }
            
            public void onTransitionEnd(Transition paramAnonymousTransition)
            {
              if (!this.a) {
                am.a(paramag1, false);
              }
              paramAnonymousTransition.removeListener(this);
            }
            
            public void onTransitionPause(Transition paramAnonymousTransition)
            {
              am.a(paramag1, false);
            }
            
            public void onTransitionResume(Transition paramAnonymousTransition)
            {
              am.a(paramag1, true);
            }
          });
          return paramViewGroup;
          paramag1 = new a((View)localObject2);
          paramViewGroup = getPathMotion().getPath(i2, i4, i3, i5);
          paramag2 = o.a(paramag1, c, paramViewGroup);
          paramViewGroup = getPathMotion().getPath(i6, i8, i7, i9);
          localObject1 = o.a(paramag1, d, paramViewGroup);
          paramViewGroup = new AnimatorSet();
          paramViewGroup.playTogether(new Animator[] { paramag2, localObject1 });
          paramViewGroup.addListener(new AnimatorListenerAdapter()
          {
            private ChangeBounds.a c = paramag1;
          });
          continue;
          if ((i2 != i3) || (i4 != i5))
          {
            paramViewGroup = getPathMotion().getPath(i2, i4, i3, i5);
            paramViewGroup = o.a(localObject2, f, paramViewGroup);
          }
          else
          {
            paramViewGroup = getPathMotion().getPath(i6, i8, i7, i9);
            paramViewGroup = o.a(localObject2, e, paramViewGroup);
          }
        }
      }
      as.a((View)localObject2, i2, i4, Math.max(i10, i12) + i2, Math.max(i11, i13) + i4);
      if ((i2 == i3) && (i4 == i5)) {
        break label1086;
      }
      paramViewGroup = getPathMotion().getPath(i2, i4, i3, i5);
    }
    label1070:
    label1086:
    for (paramViewGroup = o.a(localObject2, g, paramViewGroup);; paramViewGroup = null)
    {
      if (paramag1 == null) {
        paramag1 = new Rect(0, 0, i10, i11);
      }
      for (;;)
      {
        if (localObject1 == null) {}
        for (paramag2 = new Rect(0, 0, i12, i13);; paramag2 = (ag)localObject1)
        {
          if (!paramag1.equals(paramag2))
          {
            ViewCompat.setClipBounds((View)localObject2, paramag1);
            paramag1 = ObjectAnimator.ofObject(localObject2, "clipBounds", k, new Object[] { paramag1, paramag2 });
            paramag1.addListener(new AnimatorListenerAdapter()
            {
              private boolean h;
              
              public void onAnimationCancel(Animator paramAnonymousAnimator)
              {
                this.h = true;
              }
              
              public void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                if (!this.h)
                {
                  ViewCompat.setClipBounds(localObject2, localObject1);
                  as.a(localObject2, i3, i5, i7, i9);
                }
              }
            });
          }
          for (;;)
          {
            paramViewGroup = af.a(paramViewGroup, paramag1);
            break;
            m = ((Integer)paramag1.a.get("android:changeBounds:windowX")).intValue();
            n = ((Integer)paramag1.a.get("android:changeBounds:windowY")).intValue();
            i1 = ((Integer)paramag2.a.get("android:changeBounds:windowX")).intValue();
            i2 = ((Integer)paramag2.a.get("android:changeBounds:windowY")).intValue();
            if ((m != i1) || (n != i2))
            {
              paramViewGroup.getLocationInWindow(this.h);
              paramag1 = Bitmap.createBitmap(((View)localObject2).getWidth(), ((View)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
              ((View)localObject2).draw(new Canvas(paramag1));
              paramag1 = new BitmapDrawable(paramag1);
              final float f1 = as.c((View)localObject2);
              as.a((View)localObject2, 0.0F);
              as.a(paramViewGroup).add(paramag1);
              paramag2 = getPathMotion().getPath(m - this.h[0], n - this.h[1], i1 - this.h[0], i2 - this.h[1]);
              paramag2 = ObjectAnimator.ofPropertyValuesHolder(paramag1, new PropertyValuesHolder[] { u.a(b, paramag2) });
              paramag2.addListener(new AnimatorListenerAdapter()
              {
                public void onAnimationEnd(Animator paramAnonymousAnimator)
                {
                  as.a(paramViewGroup).remove(paramag1);
                  as.a(localObject2, f1);
                }
              });
              return paramag2;
            }
            return null;
            paramag1 = null;
          }
        }
      }
    }
  }
  
  public boolean getResizeClip()
  {
    return this.i;
  }
  
  public String[] getTransitionProperties()
  {
    return a;
  }
  
  public void setResizeClip(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  private static class a
  {
    private int a;
    private int b;
    private int c;
    private int d;
    private View e;
    private int f;
    private int g;
    
    a(View paramView)
    {
      this.e = paramView;
    }
    
    private void a()
    {
      as.a(this.e, this.a, this.b, this.c, this.d);
      this.f = 0;
      this.g = 0;
    }
    
    void a(PointF paramPointF)
    {
      this.a = Math.round(paramPointF.x);
      this.b = Math.round(paramPointF.y);
      this.f += 1;
      if (this.f == this.g) {
        a();
      }
    }
    
    void b(PointF paramPointF)
    {
      this.c = Math.round(paramPointF.x);
      this.d = Math.round(paramPointF.y);
      this.g += 1;
      if (this.f == this.g) {
        a();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ChangeBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */