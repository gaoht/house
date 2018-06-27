package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform
  extends Transition
{
  private static final String[] a;
  private static final Property<b, float[]> b;
  private static final Property<b, PointF> c;
  private static final boolean d;
  private boolean e = true;
  private boolean f = true;
  private Matrix g = new Matrix();
  
  static
  {
    boolean bool = true;
    a = new String[] { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
    b = new Property(float[].class, "nonTranslations")
    {
      public float[] get(ChangeTransform.b paramAnonymousb)
      {
        return null;
      }
      
      public void set(ChangeTransform.b paramAnonymousb, float[] paramAnonymousArrayOfFloat)
      {
        paramAnonymousb.a(paramAnonymousArrayOfFloat);
      }
    };
    c = new Property(PointF.class, "translations")
    {
      public PointF get(ChangeTransform.b paramAnonymousb)
      {
        return null;
      }
      
      public void set(ChangeTransform.b paramAnonymousb, PointF paramAnonymousPointF)
      {
        paramAnonymousb.a(paramAnonymousPointF);
      }
    };
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      d = bool;
      return;
      bool = false;
    }
  }
  
  public ChangeTransform() {}
  
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ab.g);
    this.e = TypedArrayUtils.getNamedBoolean(paramContext, (XmlPullParser)paramAttributeSet, "reparentWithOverlay", 1, true);
    this.f = TypedArrayUtils.getNamedBoolean(paramContext, (XmlPullParser)paramAttributeSet, "reparent", 0, true);
    paramContext.recycle();
  }
  
  private ObjectAnimator a(final ag paramag1, final ag paramag2, final boolean paramBoolean)
  {
    final Object localObject2 = (Matrix)paramag1.a.get("android:changeTransform:matrix");
    paramag1 = (Matrix)paramag2.a.get("android:changeTransform:matrix");
    final Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = n.a;
    }
    if (paramag1 == null) {
      paramag1 = n.a;
    }
    for (;;)
    {
      if (((Matrix)localObject1).equals(paramag1)) {
        return null;
      }
      localObject2 = (c)paramag2.a.get("android:changeTransform:transforms");
      paramag2 = paramag2.b;
      b(paramag2);
      Object localObject3 = new float[9];
      ((Matrix)localObject1).getValues((float[])localObject3);
      float[] arrayOfFloat = new float[9];
      paramag1.getValues(arrayOfFloat);
      localObject1 = new b(paramag2, (float[])localObject3);
      PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofObject(b, new f(new float[9]), new float[][] { localObject3, arrayOfFloat });
      localObject3 = getPathMotion().getPath(localObject3[2], localObject3[5], arrayOfFloat[2], arrayOfFloat[5]);
      localObject3 = ObjectAnimator.ofPropertyValuesHolder(localObject1, new PropertyValuesHolder[] { localPropertyValuesHolder, u.a(c, (Path)localObject3) });
      paramag1 = new AnimatorListenerAdapter()
      {
        private boolean g;
        private Matrix h = new Matrix();
        
        private void a(Matrix paramAnonymousMatrix)
        {
          this.h.set(paramAnonymousMatrix);
          paramag2.setTag(R.id.transition_transform, this.h);
          localObject2.restore(paramag2);
        }
        
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          this.g = true;
        }
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (!this.g)
          {
            if ((!paramBoolean) || (!ChangeTransform.a(ChangeTransform.this))) {
              break label52;
            }
            a(paramag1);
          }
          for (;;)
          {
            as.c(paramag2, null);
            localObject2.restore(paramag2);
            return;
            label52:
            paramag2.setTag(R.id.transition_transform, null);
            paramag2.setTag(R.id.parent_matrix, null);
          }
        }
        
        public void onAnimationPause(Animator paramAnonymousAnimator)
        {
          a(localObject1.a());
        }
        
        public void onAnimationResume(Animator paramAnonymousAnimator)
        {
          ChangeTransform.a(paramag2);
        }
      };
      ((ObjectAnimator)localObject3).addListener(paramag1);
      a.a((Animator)localObject3, paramag1);
      return (ObjectAnimator)localObject3;
    }
  }
  
  private void a(ag paramag)
  {
    View localView = paramag.b;
    if (localView.getVisibility() == 8) {
      return;
    }
    paramag.a.put("android:changeTransform:parent", localView.getParent());
    Object localObject = new c(localView);
    paramag.a.put("android:changeTransform:transforms", localObject);
    localObject = localView.getMatrix();
    if ((localObject == null) || (((Matrix)localObject).isIdentity())) {}
    for (localObject = null;; localObject = new Matrix((Matrix)localObject))
    {
      paramag.a.put("android:changeTransform:matrix", localObject);
      if (!this.f) {
        break;
      }
      localObject = new Matrix();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      as.a(localViewGroup, (Matrix)localObject);
      ((Matrix)localObject).preTranslate(-localViewGroup.getScrollX(), -localViewGroup.getScrollY());
      paramag.a.put("android:changeTransform:parentMatrix", localObject);
      paramag.a.put("android:changeTransform:intermediateMatrix", localView.getTag(R.id.transition_transform));
      paramag.a.put("android:changeTransform:intermediateParentMatrix", localView.getTag(R.id.parent_matrix));
      return;
    }
  }
  
  private void a(ag paramag1, ag paramag2)
  {
    Matrix localMatrix2 = (Matrix)paramag2.a.get("android:changeTransform:parentMatrix");
    paramag2.b.setTag(R.id.parent_matrix, localMatrix2);
    Matrix localMatrix1 = this.g;
    localMatrix1.reset();
    localMatrix2.invert(localMatrix1);
    paramag2 = (Matrix)paramag1.a.get("android:changeTransform:matrix");
    if (paramag2 == null)
    {
      paramag2 = new Matrix();
      paramag1.a.put("android:changeTransform:matrix", paramag2);
    }
    for (;;)
    {
      paramag2.postConcat((Matrix)paramag1.a.get("android:changeTransform:parentMatrix"));
      paramag2.postConcat(localMatrix1);
      return;
    }
  }
  
  private void a(ViewGroup paramViewGroup, ag paramag1, ag paramag2)
  {
    View localView = paramag2.b;
    Object localObject = new Matrix((Matrix)paramag2.a.get("android:changeTransform:parentMatrix"));
    as.b(paramViewGroup, (Matrix)localObject);
    localObject = i.a(localView, paramViewGroup, (Matrix)localObject);
    if (localObject == null) {}
    do
    {
      return;
      ((h)localObject).reserveEndViewTransition((ViewGroup)paramag1.a.get("android:changeTransform:parent"), paramag1.b);
      for (paramViewGroup = this; paramViewGroup.mParent != null; paramViewGroup = paramViewGroup.mParent) {}
      paramViewGroup.addListener(new a(localView, (h)localObject));
    } while (!d);
    if (paramag1.b != paramag2.b) {
      as.a(paramag1.b, 0.0F);
    }
    as.a(localView, 1.0F);
  }
  
  private boolean a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    if ((!isValidTarget(paramViewGroup1)) || (!isValidTarget(paramViewGroup2))) {
      if (paramViewGroup1 != paramViewGroup2) {}
    }
    do
    {
      return true;
      return false;
      paramViewGroup1 = getMatchedTransitionValues(paramViewGroup1, true);
      if (paramViewGroup1 == null) {
        break;
      }
    } while (paramViewGroup2 == paramViewGroup1.b);
    return false;
    return false;
  }
  
  private static void b(View paramView)
  {
    b(paramView, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
  }
  
  private static void b(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    ViewCompat.setTranslationZ(paramView, paramFloat3);
    paramView.setScaleX(paramFloat4);
    paramView.setScaleY(paramFloat5);
    paramView.setRotationX(paramFloat6);
    paramView.setRotationY(paramFloat7);
    paramView.setRotation(paramFloat8);
  }
  
  public void captureEndValues(ag paramag)
  {
    a(paramag);
  }
  
  public void captureStartValues(ag paramag)
  {
    a(paramag);
    if (!d) {
      ((ViewGroup)paramag.b.getParent()).startViewTransition(paramag.b);
    }
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, ag paramag1, ag paramag2)
  {
    if ((paramag1 == null) || (paramag2 == null) || (!paramag1.a.containsKey("android:changeTransform:parent")) || (!paramag2.a.containsKey("android:changeTransform:parent"))) {
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)paramag1.a.get("android:changeTransform:parent");
    Object localObject = (ViewGroup)paramag2.a.get("android:changeTransform:parent");
    boolean bool;
    if ((this.f) && (!a(localViewGroup, (ViewGroup)localObject)))
    {
      bool = true;
      localObject = (Matrix)paramag1.a.get("android:changeTransform:intermediateMatrix");
      if (localObject != null) {
        paramag1.a.put("android:changeTransform:matrix", localObject);
      }
      localObject = (Matrix)paramag1.a.get("android:changeTransform:intermediateParentMatrix");
      if (localObject != null) {
        paramag1.a.put("android:changeTransform:parentMatrix", localObject);
      }
      if (bool) {
        a(paramag1, paramag2);
      }
      localObject = a(paramag1, paramag2, bool);
      if ((!bool) || (localObject == null) || (!this.e)) {
        break label215;
      }
      a(paramViewGroup, paramag1, paramag2);
    }
    for (;;)
    {
      return (Animator)localObject;
      bool = false;
      break;
      label215:
      if (!d) {
        localViewGroup.endViewTransition(paramag1.b);
      }
    }
  }
  
  public boolean getReparent()
  {
    return this.f;
  }
  
  public boolean getReparentWithOverlay()
  {
    return this.e;
  }
  
  public String[] getTransitionProperties()
  {
    return a;
  }
  
  public void setReparent(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setReparentWithOverlay(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  private static class a
    extends ac
  {
    private View a;
    private h b;
    
    a(View paramView, h paramh)
    {
      this.a = paramView;
      this.b = paramh;
    }
    
    public void onTransitionEnd(Transition paramTransition)
    {
      paramTransition.removeListener(this);
      i.a(this.a);
      this.a.setTag(R.id.transition_transform, null);
      this.a.setTag(R.id.parent_matrix, null);
    }
    
    public void onTransitionPause(Transition paramTransition)
    {
      this.b.setVisibility(4);
    }
    
    public void onTransitionResume(Transition paramTransition)
    {
      this.b.setVisibility(0);
    }
  }
  
  private static class b
  {
    private final Matrix a = new Matrix();
    private final View b;
    private final float[] c;
    private float d;
    private float e;
    
    b(View paramView, float[] paramArrayOfFloat)
    {
      this.b = paramView;
      this.c = ((float[])paramArrayOfFloat.clone());
      this.d = this.c[2];
      this.e = this.c[5];
      b();
    }
    
    private void b()
    {
      this.c[2] = this.d;
      this.c[5] = this.e;
      this.a.setValues(this.c);
      as.c(this.b, this.a);
    }
    
    Matrix a()
    {
      return this.a;
    }
    
    void a(PointF paramPointF)
    {
      this.d = paramPointF.x;
      this.e = paramPointF.y;
      b();
    }
    
    void a(float[] paramArrayOfFloat)
    {
      System.arraycopy(paramArrayOfFloat, 0, this.c, 0, paramArrayOfFloat.length);
      b();
    }
  }
  
  private static class c
  {
    final float a;
    final float b;
    final float c;
    final float d;
    final float e;
    final float f;
    final float g;
    final float h;
    
    c(View paramView)
    {
      this.a = paramView.getTranslationX();
      this.b = paramView.getTranslationY();
      this.c = ViewCompat.getTranslationZ(paramView);
      this.d = paramView.getScaleX();
      this.e = paramView.getScaleY();
      this.f = paramView.getRotationX();
      this.g = paramView.getRotationY();
      this.h = paramView.getRotation();
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c)) {}
      do
      {
        return false;
        paramObject = (c)paramObject;
      } while ((((c)paramObject).a != this.a) || (((c)paramObject).b != this.b) || (((c)paramObject).c != this.c) || (((c)paramObject).d != this.d) || (((c)paramObject).e != this.e) || (((c)paramObject).f != this.f) || (((c)paramObject).g != this.g) || (((c)paramObject).h != this.h));
      return true;
    }
    
    public int hashCode()
    {
      int i3 = 0;
      int i;
      int j;
      label37:
      int k;
      label54:
      int m;
      label72:
      int n;
      label90:
      int i1;
      if (this.a != 0.0F)
      {
        i = Float.floatToIntBits(this.a);
        if (this.b == 0.0F) {
          break label191;
        }
        j = Float.floatToIntBits(this.b);
        if (this.c == 0.0F) {
          break label196;
        }
        k = Float.floatToIntBits(this.c);
        if (this.d == 0.0F) {
          break label201;
        }
        m = Float.floatToIntBits(this.d);
        if (this.e == 0.0F) {
          break label207;
        }
        n = Float.floatToIntBits(this.e);
        if (this.f == 0.0F) {
          break label213;
        }
        i1 = Float.floatToIntBits(this.f);
        label108:
        if (this.g == 0.0F) {
          break label219;
        }
      }
      label191:
      label196:
      label201:
      label207:
      label213:
      label219:
      for (int i2 = Float.floatToIntBits(this.g);; i2 = 0)
      {
        if (this.h != 0.0F) {
          i3 = Float.floatToIntBits(this.h);
        }
        return (i2 + (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
        i = 0;
        break;
        j = 0;
        break label37;
        k = 0;
        break label54;
        m = 0;
        break label72;
        n = 0;
        break label90;
        i1 = 0;
        break label108;
      }
    }
    
    public void restore(View paramView)
    {
      ChangeTransform.a(paramView, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ChangeTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */