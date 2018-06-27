package com.growingio.android.sdk.circle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.DialogFragment;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import android.widget.AdapterView;
import com.growingio.android.sdk.a.g;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.MessageProcessor;
import com.growingio.android.sdk.models.j;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@TargetApi(15)
public class a
  extends f
{
  static int a;
  private static Method y;
  private Comparator<com.growingio.android.sdk.models.i> A = new Comparator()
  {
    public int a(com.growingio.android.sdk.models.i paramAnonymousi1, com.growingio.android.sdk.models.i paramAnonymousi2)
    {
      int j = -1;
      int i;
      if ((paramAnonymousi1.c instanceof AdapterView))
      {
        i = -1;
        if (!(paramAnonymousi2.c instanceof AdapterView)) {
          break label35;
        }
      }
      for (;;)
      {
        return j - i;
        i = 1;
        break;
        label35:
        j = 1;
      }
    }
  };
  private j B = new j()
  {
    public boolean a(com.growingio.android.sdk.models.i paramAnonymousi)
    {
      if (a.b(paramAnonymousi.c))
      {
        Util.a(paramAnonymousi.c, a.d(a.this), paramAnonymousi.f);
        return a.d(a.this).contains(a.e(a.this).x, a.e(a.this).y);
      }
      return false;
    }
    
    public void b(com.growingio.android.sdk.models.i paramAnonymousi)
    {
      boolean bool = Util.c(paramAnonymousi.c);
      if ((!bool) && ((paramAnonymousi.n) || (TextUtils.isEmpty(paramAnonymousi.k)))) {}
      do
      {
        return;
        if ((!a.f(a.this)) && (bool)) {
          a.a(a.this, true);
        }
      } while ((a.f(a.this)) && (!bool));
      a.g(a.this).add(0, paramAnonymousi);
    }
  };
  private j C = new j()
  {
    public void b(com.growingio.android.sdk.models.i paramAnonymousi)
    {
      if ((!Util.c(paramAnonymousi.c)) && ((paramAnonymousi.n) || (TextUtils.isEmpty(paramAnonymousi.k)))) {}
      do
      {
        return;
        Util.a(paramAnonymousi.c, a.d(a.this), paramAnonymousi.f);
      } while (!a.a(a.this, a.h(a.this), a.d(a.this)));
      double d = i.f();
      com.growingio.android.sdk.models.e locale = new com.growingio.android.sdk.models.e();
      locale.a = String.valueOf((int)(a.d(a.this).left * d));
      locale.b = String.valueOf((int)(a.d(a.this).top * d));
      locale.c = String.valueOf((int)(a.d(a.this).width() * d));
      locale.d = String.valueOf((int)(d * a.d(a.this).height()));
      paramAnonymousi.g = locale;
      a.g(a.this).add(0, paramAnonymousi);
    }
  };
  private final int b = 10;
  private final int c = 20000;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private boolean j = false;
  private View k;
  private Point l = null;
  private b m;
  private f n;
  private l o;
  private e p;
  private Rect q;
  private com.growingio.android.sdk.models.i r;
  private Rect s = new Rect();
  private List<com.growingio.android.sdk.models.i> t = new ArrayList();
  private boolean u = false;
  private WindowManager v;
  private View[] w;
  private int x;
  private Runnable z = new Runnable()
  {
    public void run()
    {
      g.c().e();
    }
  };
  
  public a(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a(DialogFragment paramDialogFragment, String paramString)
  {
    getCircleManager().a(paramDialogFragment, paramString);
  }
  
  private void a(final String paramString, List<com.growingio.android.sdk.models.i> paramList)
  {
    setVisibility(8);
    paramString = new HybridEventEditDialog();
    String str = getAppState().y();
    paramString.a(getAppState().i(), paramList, str, getAppState().b(), new Runnable()
    {
      public void run()
      {
        a.a(a.this, paramString, HybridEventEditDialog.class.getName());
      }
    });
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 1)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayOfObject.length / 2)
      {
        Object localObject = paramArrayOfObject[i1];
        paramArrayOfObject[i1] = paramArrayOfObject[(paramArrayOfObject.length - i1 - 1)];
        paramArrayOfObject[(paramArrayOfObject.length - i1 - 1)] = localObject;
        i1 += 1;
      }
    }
  }
  
  private boolean a(Rect paramRect1, Rect paramRect2)
  {
    return (paramRect1.contains(paramRect2)) && (paramRect1.width() - paramRect2.width() < 10) && (paramRect1.height() - paramRect2.height() < 10);
  }
  
  private static boolean c(View paramView)
  {
    try
    {
      if (y == null)
      {
        y = Class.forName("android.view.View").getDeclaredMethod("isVisibleToUser", new Class[0]);
        y.setAccessible(true);
      }
      boolean bool = ((Boolean)y.invoke(paramView, new Object[0])).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramView)
    {
      return false;
    }
    catch (ClassNotFoundException paramView)
    {
      return false;
    }
    catch (NoSuchMethodException paramView)
    {
      return false;
    }
    catch (InvocationTargetException paramView) {}
    return false;
  }
  
  @SuppressLint({"RtlHardcoded"})
  private void f()
  {
    this.n = new f(getContext());
    float f1 = Util.a(getContext(), 3.0F);
    Object localObject = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null));
    ((ShapeDrawable)localObject).getPaint().setColor(1291798564);
    ((ShapeDrawable)localObject).getPaint().setStrokeWidth(Util.a(getContext(), 1.0F));
    ((ShapeDrawable)localObject).getPaint().setAntiAlias(true);
    this.n.setBackgroundDrawable((Drawable)localObject);
    localObject = new WindowManager.LayoutParams(0, 0, c.a, 312, -3);
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    ((WindowManager.LayoutParams)localObject).setTitle("MaskWindow:" + getContext().getPackageName());
    this.v.addView(this.n, (ViewGroup.LayoutParams)localObject);
    this.o = new l(getContext());
    this.o.setFloatType(c.a);
    this.o.a();
    if (GConfig.s().u()) {
      this.o.setTags(g.c().d());
    }
  }
  
  private void g()
  {
    ThreadUtils.c(this.z);
    ThreadUtils.a(this.z, 20000L);
  }
  
  @SuppressLint({"RtlHardcoded"})
  private void h()
  {
    if (GConfig.s().t())
    {
      if (this.p == null)
      {
        this.p = new e(getContext());
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1, c.a, 296, -3);
        localLayoutParams.gravity = 51;
        localLayoutParams.setTitle("CircleTipWindow:" + getContext().getPackageName());
        this.p.setLayoutParams(localLayoutParams);
        this.p.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            a.c(a.this);
          }
        });
      }
      if (this.p.getParent() == null)
      {
        this.v.addView(this.p, this.p.getLayoutParams());
        bringToFront();
      }
    }
  }
  
  private void i()
  {
    int i5 = 1;
    int i8 = 0;
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    int i1 = (int)(this.d - this.h);
    int i3 = (int)(this.e - this.i);
    int i2 = i1;
    if (i1 < 0) {
      i2 = 0;
    }
    i1 = i3;
    if (i3 < 0) {
      i1 = 0;
    }
    int i6;
    int i7;
    if (getContext().getResources().getConfiguration().orientation == 1)
    {
      i6 = i.b() - getWidth();
      i7 = i.d() - getHeight();
      if (i5 == 0) {
        break label162;
      }
      i3 = i6;
      label98:
      if (i2 <= i3) {
        break label179;
      }
    }
    label114:
    label162:
    label174:
    label179:
    for (int i4 = i3;; i4 = i2)
    {
      if (i5 != 0)
      {
        i2 = i7;
        i3 = i1;
        if (i1 > i2) {
          i3 = i2;
        }
        if (i3 >= 0) {
          break label174;
        }
      }
      for (i1 = i8;; i1 = i3)
      {
        localLayoutParams.x = i4;
        localLayoutParams.y = i1;
        this.v.updateViewLayout(this, localLayoutParams);
        return;
        i5 = 0;
        break;
        i3 = i7;
        break label98;
        i2 = i6;
        break label114;
      }
    }
  }
  
  private void j()
  {
    this.r = null;
    this.q = null;
    this.t.clear();
    this.u = false;
    ViewHelper.a(this.w, this.B);
    k();
  }
  
  private void k()
  {
    if (this.t.size() > 0)
    {
      this.r = ((com.growingio.android.sdk.models.i)this.t.get(0));
      this.q = new Rect();
      Util.a(this.r.c, this.q, this.r.f);
      if (((this.r.c instanceof WebView)) || (ClassExistHelper.instanceOfX5WebView(this.r.c)))
      {
        this.n.setVisibility(8);
        this.m.setVisibility(8);
        localObject = new int[2];
        this.r.c.getLocationOnScreen((int[])localObject);
        a(this.r.c, this.d - localObject[0], this.e - localObject[1]);
        this.k = this.r.c;
        return;
      }
      Object localObject = (WindowManager.LayoutParams)this.n.getLayoutParams();
      this.n.setVisibility(0);
      if ((this.q.left != ((WindowManager.LayoutParams)localObject).x) || (this.q.top != ((WindowManager.LayoutParams)localObject).y) || (this.q.width() != ((WindowManager.LayoutParams)localObject).width) || (this.q.height() != ((WindowManager.LayoutParams)localObject).height))
      {
        ((WindowManager.LayoutParams)localObject).width = this.q.width();
        ((WindowManager.LayoutParams)localObject).height = this.q.height();
        ((WindowManager.LayoutParams)localObject).x = this.q.left;
        ((WindowManager.LayoutParams)localObject).y = this.q.top;
        this.v.removeView(this.n);
        this.v.addView(this.n, (ViewGroup.LayoutParams)localObject);
      }
      this.m.a(this.q, (int)(this.d - this.h + a / 2), (int)(this.e - this.i + a / 2));
      return;
    }
    this.n.setVisibility(8);
    this.n.getLayoutParams().width = 0;
    this.m.setVisibility(8);
    c();
  }
  
  private void l()
  {
    if (this.p != null)
    {
      if (this.p.getParent() != null) {
        this.v.removeView(this.p);
      }
      this.p = null;
      GConfig.s().a(false);
    }
  }
  
  public void a()
  {
    a = Util.a(getContext(), 48.0F);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(new RoundRectShape(new float[] { a / 2.0F, a / 2.0F, a / 2.0F, a / 2.0F, a / 2.0F, a / 2.0F, a / 2.0F, a / 2.0F }, null, null));
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-436254684);
    localShapeDrawable.getPaint().setAntiAlias(true);
    setBackgroundDrawable(localShapeDrawable);
    this.v = ((WindowManager)getContext().getApplicationContext().getSystemService("window"));
    this.x = Util.a(getContext(), 4.0F);
    f();
    this.m = new b(getContext());
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        a.this.getCircleManager().l();
        a.this.setVisibility(8);
        a.a(a.this).setVisibility(8);
        a.b(a.this).setVisibility(8);
        MessageProcessor.e().a("CircleModeChooserDialog", null);
        a.c(a.this);
      }
    });
  }
  
  public void a(View paramView)
  {
    Util.a(paramView, "_vds_hybrid.findElementAtPoint", new Object[0]);
    this.k = paramView;
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    Util.a(paramView, "_vds_hybrid.hoverOn", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
  }
  
  @SuppressLint({"RtlHardcoded"})
  public void b()
  {
    if (GConfig.s().u()) {
      g();
    }
    h();
    if (getParent() == null)
    {
      Object localObject = GConfig.s().v();
      Activity localActivity = c.e().d();
      if (GConfig.s().t())
      {
        ((Point)localObject).x = ((i.b() - a) / 2);
        ((Point)localObject).y = ((i.d() - a) / 2);
      }
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(a, a, c.a, 296, -3);
      localLayoutParams.gravity = 51;
      localLayoutParams.x = ((Point)localObject).x;
      localLayoutParams.y = ((Point)localObject).y;
      localObject = (WindowManager)localActivity.getApplication().getSystemService("window");
      localLayoutParams.setTitle("AnchorWindow:" + getContext().getPackageName());
      ((WindowManager)localObject).addView(this, localLayoutParams);
      this.m.b();
      return;
    }
    setVisibility(0);
    this.o.setVisibility(0);
    bringToFront();
  }
  
  public void c()
  {
    if (this.k != null)
    {
      Util.a(this.k, "_vds_hybrid.cancelHover", new Object[0]);
      this.k = null;
    }
  }
  
  public void d()
  {
    this.v.removeView(this);
    this.v.removeView(this.n);
    if (this.m != null) {
      this.m.c();
    }
    if ((this.p != null) && (this.p.getParent() != null)) {
      this.v.removeView(this.p);
    }
    if (this.o != null)
    {
      this.o.b();
      this.v.removeView(this.o);
    }
  }
  
  public boolean e()
  {
    return this.j;
  }
  
  AppState getAppState()
  {
    return AppState.l();
  }
  
  c getCircleManager()
  {
    return c.e();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 8;
    boolean bool = false;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return false;
          this.h = paramMotionEvent.getX();
          this.i = paramMotionEvent.getY();
          this.f = paramMotionEvent.getRawX();
          this.g = paramMotionEvent.getRawY();
          this.d = paramMotionEvent.getRawX();
          this.e = paramMotionEvent.getRawY();
          this.j = true;
          this.w = WindowHelper.c();
          this.o.b();
          return false;
        } while (!this.j);
        this.d = paramMotionEvent.getRawX();
        this.e = paramMotionEvent.getRawY();
      } while ((Math.abs(this.d - this.f) < this.x) && (Math.abs(this.e - this.g) < this.x));
      if (this.p != null) {
        l();
      }
      i();
      paramMotionEvent = new Rect();
      getGlobalVisibleRect(paramMotionEvent);
      if (!paramMotionEvent.contains((int)this.f, (int)this.g))
      {
        this.l = new Point((int)this.d, (int)this.e);
        j();
      }
      for (;;)
      {
        return true;
        this.m.setVisibility(8);
      }
    }
    this.j = false;
    this.n.setVisibility(8);
    this.m.setVisibility(8);
    this.n.getLayoutParams().width = 0;
    c();
    if (this.q != null)
    {
      this.t.clear();
      a(this.w);
      ViewHelper.a(this.w, this.C);
      if (this.t.size() > 0)
      {
        paramMotionEvent = ((com.growingio.android.sdk.models.i)this.t.get(0)).c;
        if (((paramMotionEvent instanceof WebView)) || (ClassExistHelper.instanceOfX5WebView(paramMotionEvent)))
        {
          a(paramMotionEvent);
          this.q = null;
          bool = true;
        }
      }
    }
    for (;;)
    {
      this.w = null;
      return bool;
      Collections.sort(this.t, this.A);
      a("elem", this.t);
      break;
      c.e().n();
      break;
      if ((Math.abs(this.d - this.f) < this.x) && (Math.abs(this.e - this.g) < this.x))
      {
        performClick();
      }
      else
      {
        paramMotionEvent = this.o;
        if (GConfig.s().u()) {
          i1 = 0;
        }
        paramMotionEvent.setVisibility(i1);
        c.e().n();
      }
    }
  }
  
  public void setTags(List<com.growingio.android.sdk.models.f> paramList)
  {
    this.o.setTags(paramList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */