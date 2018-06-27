package com.growingio.android.sdk.circle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.models.h;
import com.growingio.android.sdk.models.j;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l
  extends f
{
  private int a;
  private List<com.growingio.android.sdk.models.i> b = new ArrayList();
  private com.growingio.android.sdk.models.i c;
  private int d = 0;
  private j e = new j()
  {
    float a = Util.a(l.this.getContext(), 3.0F);
    ShapeDrawable b = new ShapeDrawable(new RoundRectShape(new float[] { this.a, this.a, this.a, this.a, this.a, this.a, this.a, this.a }, null, null));
    ShapeDrawable c = new ShapeDrawable(new RoundRectShape(new float[] { this.a, this.a, this.a, this.a, this.a, this.a, this.a, this.a }, null, null));
    
    boolean a(com.growingio.android.sdk.models.i paramAnonymousi1, com.growingio.android.sdk.models.i paramAnonymousi2)
    {
      return (Util.a(paramAnonymousi1.j, paramAnonymousi2.j)) && ((paramAnonymousi1.k == null) || (paramAnonymousi1.k.equals(paramAnonymousi2.k))) && ((paramAnonymousi1.e == -2) || (paramAnonymousi1.e == paramAnonymousi2.e));
    }
    
    public void b(com.growingio.android.sdk.models.i paramAnonymousi)
    {
      if (l.a(l.this) != null) {
        if (TextUtils.equals(l.a(l.this).j, paramAnonymousi.j)) {
          c(paramAnonymousi);
        }
      }
      for (;;)
      {
        return;
        Iterator localIterator = l.b(l.this).iterator();
        while (localIterator.hasNext()) {
          if (a((com.growingio.android.sdk.models.i)localIterator.next(), paramAnonymousi)) {
            c(paramAnonymousi);
          }
        }
      }
    }
    
    void c(com.growingio.android.sdk.models.i paramAnonymousi)
    {
      k localk = new k(l.this.getContext());
      if (l.a(l.this) != null) {}
      for (Object localObject = this.b;; localObject = this.c)
      {
        localk.setBackgroundDrawable((Drawable)localObject);
        l.this.addView(localk);
        localObject = new Rect();
        Util.a(paramAnonymousi.c, (Rect)localObject, paramAnonymousi.f);
        localk.a((Rect)localObject);
        if (l.a(l.this) != null)
        {
          paramAnonymousi = new AlphaAnimation(0.0F, 1.0F);
          paramAnonymousi.setDuration(150L);
          paramAnonymousi.setStartOffset(l.c(l.this) * 30);
          localk.startAnimation(paramAnonymousi);
        }
        return;
      }
    }
  };
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  @SuppressLint({"RtlHardcoded"})
  public void a()
  {
    if (getParent() != null)
    {
      setVisibility(0);
      return;
    }
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(i.b(), i.d(), this.a, 312, -3);
    localLayoutParams.gravity = 51;
    localLayoutParams.setTitle("TagsWindow:" + getContext().getPackageName());
    ((WindowManager)getContext().getApplicationContext().getSystemService("window")).addView(this, localLayoutParams);
  }
  
  public void a(com.growingio.android.sdk.models.f paramf)
  {
    Object localObject = c.e().d();
    boolean bool;
    if (localObject != null)
    {
      localObject = AppState.l().b((Activity)localObject);
      if ((paramf.g.b == null) || (paramf.g.b.equals(localObject)))
      {
        localObject = new com.growingio.android.sdk.models.i();
        if (!TextUtils.isEmpty(paramf.g.c)) {
          ((com.growingio.android.sdk.models.i)localObject).k = paramf.g.c;
        }
        if (TextUtils.isEmpty(paramf.g.e)) {
          break label142;
        }
        bool = true;
        ((com.growingio.android.sdk.models.i)localObject).m = bool;
        if (!((com.growingio.android.sdk.models.i)localObject).m) {
          break label158;
        }
      }
    }
    for (;;)
    {
      try
      {
        ((com.growingio.android.sdk.models.i)localObject).e = Integer.valueOf(paramf.g.e).intValue();
        ((com.growingio.android.sdk.models.i)localObject).j = paramf.g.a;
        this.b.add(localObject);
        return;
        label142:
        bool = false;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ((com.growingio.android.sdk.models.i)localObject).e = -2;
        continue;
      }
      label158:
      ((com.growingio.android.sdk.models.i)localObject).e = -2;
    }
  }
  
  public void b()
  {
    this.b.clear();
    removeAllViews();
  }
  
  public void setFloatType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setTags(List<com.growingio.android.sdk.models.f> paramList)
  {
    b();
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      String str = AppState.l().b();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.growingio.android.sdk.models.f localf = (com.growingio.android.sdk.models.f)paramList.next();
        if ((localf.d.equals("elem")) && (str.equals(localf.g.d))) {
          a(localf);
        }
      }
    } while (this.b.size() <= 0);
    ViewHelper.a(WindowHelper.b(), this.e);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */