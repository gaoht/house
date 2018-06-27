package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c
  extends h
  implements b
{
  b a;
  final Drawable.Callback b = new Drawable.Callback()
  {
    public void invalidateDrawable(Drawable paramAnonymousDrawable)
    {
      c.this.invalidateSelf();
    }
    
    public void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
    {
      c.this.scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
    }
    
    public void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
    {
      c.this.unscheduleSelf(paramAnonymousRunnable);
    }
  };
  private a d;
  private Context e;
  private ArgbEvaluator f = null;
  private Animator.AnimatorListener g = null;
  private ArrayList<b.a> h = null;
  
  c()
  {
    this(null, null, null);
  }
  
  private c(Context paramContext)
  {
    this(paramContext, null, null);
  }
  
  private c(Context paramContext, a parama, Resources paramResources)
  {
    this.e = paramContext;
    if (parama != null)
    {
      this.d = parama;
      return;
    }
    this.d = new a(paramContext, parama, this.b, paramResources);
  }
  
  private void a()
  {
    if (this.g != null)
    {
      this.d.c.removeListener(this.g);
      this.g = null;
    }
  }
  
  private void a(Animator paramAnimator)
  {
    Object localObject;
    if ((paramAnimator instanceof AnimatorSet))
    {
      localObject = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          a((Animator)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      localObject = paramAnimator.getPropertyName();
      if (("fillColor".equals(localObject)) || ("strokeColor".equals(localObject)))
      {
        if (this.f == null) {
          this.f = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(this.f);
      }
    }
  }
  
  private void a(String paramString, Animator paramAnimator)
  {
    paramAnimator.setTarget(this.d.b.a(paramString));
    if (Build.VERSION.SDK_INT < 21) {
      a(paramAnimator);
    }
    if (a.a(this.d) == null)
    {
      a.a(this.d, new ArrayList());
      this.d.d = new ArrayMap();
    }
    a.a(this.d).add(paramAnimator);
    this.d.d.put(paramAnimator, paramString);
  }
  
  private static boolean a(AnimatedVectorDrawable paramAnimatedVectorDrawable, b.a parama)
  {
    return paramAnimatedVectorDrawable.unregisterAnimationCallback(parama.a());
  }
  
  private static void b(AnimatedVectorDrawable paramAnimatedVectorDrawable, b.a parama)
  {
    paramAnimatedVectorDrawable.registerAnimationCallback(parama.a());
  }
  
  public static void clearAnimationCallbacks(Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (!(paramDrawable instanceof Animatable))) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      ((AnimatedVectorDrawable)paramDrawable).clearAnimationCallbacks();
      return;
    }
    ((c)paramDrawable).clearAnimationCallbacks();
  }
  
  public static c create(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new c(paramContext);
      ((c)localObject).c = ResourcesCompat.getDrawable(paramContext.getResources(), paramInt, paramContext.getTheme());
      ((c)localObject).c.setCallback(((c)localObject).b);
      ((c)localObject).a = new b(((c)localObject).c.getConstantState());
      return (c)localObject;
    }
    Object localObject = paramContext.getResources();
    try
    {
      localObject = ((Resources)localObject).getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2) {
        throw new XmlPullParserException("No start tag found");
      }
    }
    catch (XmlPullParserException paramContext)
    {
      AttributeSet localAttributeSet;
      Log.e("AnimatedVDCompat", "parser error", paramContext);
      return null;
      paramContext = createFromXmlInner(paramContext, paramContext.getResources(), (XmlPullParser)localObject, localAttributeSet, paramContext.getTheme());
      return paramContext;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        Log.e("AnimatedVDCompat", "parser error", paramContext);
      }
    }
  }
  
  public static c createFromXmlInner(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    paramContext = new c(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return paramContext;
  }
  
  public static void registerAnimationCallback(Drawable paramDrawable, b.a parama)
  {
    if ((paramDrawable == null) || (parama == null)) {}
    while (!(paramDrawable instanceof Animatable)) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      b((AnimatedVectorDrawable)paramDrawable, parama);
      return;
    }
    ((c)paramDrawable).registerAnimationCallback(parama);
  }
  
  public static boolean unregisterAnimationCallback(Drawable paramDrawable, b.a parama)
  {
    if ((paramDrawable == null) || (parama == null)) {}
    while (!(paramDrawable instanceof Animatable)) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 24) {
      return a((AnimatedVectorDrawable)paramDrawable, parama);
    }
    return ((c)paramDrawable).unregisterAnimationCallback(parama);
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    if (this.c != null) {
      DrawableCompat.applyTheme(this.c, paramTheme);
    }
  }
  
  public boolean canApplyTheme()
  {
    if (this.c != null) {
      return DrawableCompat.canApplyTheme(this.c);
    }
    return false;
  }
  
  public void clearAnimationCallbacks()
  {
    if (this.c != null) {
      ((AnimatedVectorDrawable)this.c).clearAnimationCallbacks();
    }
    do
    {
      return;
      a();
    } while (this.h == null);
    this.h.clear();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.c != null) {
      this.c.draw(paramCanvas);
    }
    do
    {
      return;
      this.d.b.draw(paramCanvas);
    } while (!this.d.c.isStarted());
    invalidateSelf();
  }
  
  public int getAlpha()
  {
    if (this.c != null) {
      return DrawableCompat.getAlpha(this.c);
    }
    return this.d.b.getAlpha();
  }
  
  public int getChangingConfigurations()
  {
    if (this.c != null) {
      return this.c.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.d.a;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if ((this.c != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new b(this.c.getConstantState());
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.c != null) {
      return this.c.getIntrinsicHeight();
    }
    return this.d.b.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.c != null) {
      return this.c.getIntrinsicWidth();
    }
    return this.d.b.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    if (this.c != null) {
      return this.c.getOpacity();
    }
    return this.d.b.getOpacity();
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    if (this.c != null)
    {
      DrawableCompat.inflate(this.c, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    int i = paramXmlPullParser.getEventType();
    int j = paramXmlPullParser.getDepth();
    if ((i != 1) && ((paramXmlPullParser.getDepth() >= j + 1) || (i != 3)))
    {
      Object localObject1;
      Object localObject2;
      if (i == 2)
      {
        localObject1 = paramXmlPullParser.getName();
        if (!"animated-vector".equals(localObject1)) {
          break label183;
        }
        localObject1 = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, a.e);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = i.create(paramResources, i, paramTheme);
          ((i)localObject2).a(false);
          ((i)localObject2).setCallback(this.b);
          if (this.d.b != null) {
            this.d.b.setCallback(null);
          }
          this.d.b = ((i)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
      for (;;)
      {
        i = paramXmlPullParser.next();
        break;
        label183:
        if ("target".equals(localObject1))
        {
          localObject1 = paramResources.obtainAttributes(paramAttributeSet, a.f);
          localObject2 = ((TypedArray)localObject1).getString(0);
          i = ((TypedArray)localObject1).getResourceId(1, 0);
          if (i != 0)
          {
            if (this.e == null) {
              break label256;
            }
            a((String)localObject2, e.loadAnimator(this.e, i));
          }
          ((TypedArray)localObject1).recycle();
        }
      }
      label256:
      ((TypedArray)localObject1).recycle();
      throw new IllegalStateException("Context can't be null when inflating animators");
    }
    this.d.setupAnimatorSet();
  }
  
  public boolean isAutoMirrored()
  {
    if (this.c != null) {
      return DrawableCompat.isAutoMirrored(this.c);
    }
    return this.d.b.isAutoMirrored();
  }
  
  public boolean isRunning()
  {
    if (this.c != null) {
      return ((AnimatedVectorDrawable)this.c).isRunning();
    }
    return this.d.c.isRunning();
  }
  
  public boolean isStateful()
  {
    if (this.c != null) {
      return this.c.isStateful();
    }
    return this.d.b.isStateful();
  }
  
  public Drawable mutate()
  {
    if (this.c != null) {
      this.c.mutate();
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.c != null)
    {
      this.c.setBounds(paramRect);
      return;
    }
    this.d.b.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.c != null) {
      return this.c.setLevel(paramInt);
    }
    return this.d.b.setLevel(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.c != null) {
      return this.c.setState(paramArrayOfInt);
    }
    return this.d.b.setState(paramArrayOfInt);
  }
  
  public void registerAnimationCallback(b.a parama)
  {
    if (this.c != null) {
      b((AnimatedVectorDrawable)this.c, parama);
    }
    do
    {
      do
      {
        return;
      } while (parama == null);
      if (this.h == null) {
        this.h = new ArrayList();
      }
    } while (this.h.contains(parama));
    this.h.add(parama);
    if (this.g == null) {
      this.g = new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramAnonymousAnimator = new ArrayList(c.a(c.this));
          int j = paramAnonymousAnimator.size();
          int i = 0;
          while (i < j)
          {
            ((b.a)paramAnonymousAnimator.get(i)).onAnimationEnd(c.this);
            i += 1;
          }
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          paramAnonymousAnimator = new ArrayList(c.a(c.this));
          int j = paramAnonymousAnimator.size();
          int i = 0;
          while (i < j)
          {
            ((b.a)paramAnonymousAnimator.get(i)).onAnimationStart(c.this);
            i += 1;
          }
        }
      };
    }
    this.d.c.addListener(this.g);
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.c != null)
    {
      this.c.setAlpha(paramInt);
      return;
    }
    this.d.b.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.c != null)
    {
      DrawableCompat.setAutoMirrored(this.c, paramBoolean);
      return;
    }
    this.d.b.setAutoMirrored(paramBoolean);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.c != null)
    {
      this.c.setColorFilter(paramColorFilter);
      return;
    }
    this.d.b.setColorFilter(paramColorFilter);
  }
  
  public void setTint(int paramInt)
  {
    if (this.c != null)
    {
      DrawableCompat.setTint(this.c, paramInt);
      return;
    }
    this.d.b.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    if (this.c != null)
    {
      DrawableCompat.setTintList(this.c, paramColorStateList);
      return;
    }
    this.d.b.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.c != null)
    {
      DrawableCompat.setTintMode(this.c, paramMode);
      return;
    }
    this.d.b.setTintMode(paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c != null) {
      return this.c.setVisible(paramBoolean1, paramBoolean2);
    }
    this.d.b.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start()
  {
    if (this.c != null) {
      ((AnimatedVectorDrawable)this.c).start();
    }
    while (this.d.c.isStarted()) {
      return;
    }
    this.d.c.start();
    invalidateSelf();
  }
  
  public void stop()
  {
    if (this.c != null)
    {
      ((AnimatedVectorDrawable)this.c).stop();
      return;
    }
    this.d.c.end();
  }
  
  public boolean unregisterAnimationCallback(b.a parama)
  {
    if (this.c != null) {
      a((AnimatedVectorDrawable)this.c, parama);
    }
    boolean bool1;
    if ((this.h == null) || (parama == null)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.h.remove(parama);
      bool1 = bool2;
    } while (this.h.size() != 0);
    a();
    return bool2;
  }
  
  private static class a
    extends Drawable.ConstantState
  {
    int a;
    i b;
    AnimatorSet c;
    ArrayMap<Animator, String> d;
    private ArrayList<Animator> e;
    
    public a(Context paramContext, a parama, Drawable.Callback paramCallback, Resources paramResources)
    {
      if (parama != null)
      {
        this.a = parama.a;
        if (parama.b != null)
        {
          paramContext = parama.b.getConstantState();
          if (paramResources == null) {
            break label215;
          }
        }
        label215:
        for (this.b = ((i)paramContext.newDrawable(paramResources));; this.b = ((i)paramContext.newDrawable()))
        {
          this.b = ((i)this.b.mutate());
          this.b.setCallback(paramCallback);
          this.b.setBounds(parama.b.getBounds());
          this.b.a(false);
          if (parama.e == null) {
            return;
          }
          int j = parama.e.size();
          this.e = new ArrayList(j);
          this.d = new ArrayMap(j);
          while (i < j)
          {
            paramCallback = (Animator)parama.e.get(i);
            paramContext = paramCallback.clone();
            paramCallback = (String)parama.d.get(paramCallback);
            paramContext.setTarget(this.b.a(paramCallback));
            this.e.add(paramContext);
            this.d.put(paramContext, paramCallback);
            i += 1;
          }
        }
        setupAnimatorSet();
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.a;
    }
    
    public Drawable newDrawable()
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public void setupAnimatorSet()
    {
      if (this.c == null) {
        this.c = new AnimatorSet();
      }
      this.c.playTogether(this.e);
    }
  }
  
  private static class b
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState a;
    
    public b(Drawable.ConstantState paramConstantState)
    {
      this.a = paramConstantState;
    }
    
    public boolean canApplyTheme()
    {
      return this.a.canApplyTheme();
    }
    
    public int getChangingConfigurations()
    {
      return this.a.getChangingConfigurations();
    }
    
    public Drawable newDrawable()
    {
      c localc = new c();
      localc.c = this.a.newDrawable();
      localc.c.setCallback(localc.b);
      return localc;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      c localc = new c();
      localc.c = this.a.newDrawable(paramResources);
      localc.c.setCallback(localc.b);
      return localc;
    }
    
    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      c localc = new c();
      localc.c = this.a.newDrawable(paramResources, paramTheme);
      localc.c.setCallback(localc.b);
      return localc;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/graphics/drawable/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */