package com.growingio.android.sdk.collection;

import android.util.SparseArray;
import android.view.View;
import android.webkit.WebView;
import com.growingio.android.sdk.models.a;
import com.growingio.android.sdk.models.b;
import com.growingio.android.sdk.models.i;
import com.growingio.android.sdk.models.j;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.ViewHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionCalculator
{
  private final String a;
  private SparseArray<b> b = new SparseArray();
  private List<b> c;
  private WeakReference<View> d;
  private List<WeakReference<View>> e = new ArrayList();
  private long f;
  private String g;
  private j h = new j()
  {
    public void b(i paramAnonymousi)
    {
      boolean bool2 = false;
      Object localObject;
      if (ActionCalculator.a(ActionCalculator.this).get(paramAnonymousi.hashCode()) == null)
      {
        localObject = ActionCalculator.a(ActionCalculator.this, paramAnonymousi);
        ActionCalculator.a(ActionCalculator.this).put(paramAnonymousi.hashCode(), localObject);
        ActionCalculator.b(ActionCalculator.this).add(localObject);
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        if (((paramAnonymousi.c instanceof WebView)) || (ClassExistHelper.instanceOfX5WebView(paramAnonymousi.c)))
        {
          localObject = ActionCalculator.c(ActionCalculator.this).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((WeakReference)((Iterator)localObject).next()).get() == paramAnonymousi.c) {
              bool1 = bool2;
            }
          }
        }
        for (;;)
        {
          if (bool1) {
            ActionCalculator.c(ActionCalculator.this).add(new WeakReference(paramAnonymousi.c));
          }
          VdsJsBridgeManager.updateViewNodeIfNeeded(paramAnonymousi.c, paramAnonymousi, bool1);
          return;
        }
      }
    }
  };
  
  public ActionCalculator(String paramString1, long paramLong, View paramView, String paramString2)
  {
    this.f = paramLong;
    this.d = new WeakReference(paramView);
    this.g = paramString1;
    this.a = paramString2;
  }
  
  private b a(i parami)
  {
    b localb = new b();
    localb.a = parami.j;
    localb.b = System.currentTimeMillis();
    localb.c = parami.e;
    localb.d = parami.k;
    localb.e = parami.l;
    return localb;
  }
  
  public List<a> a()
  {
    GConfig localGConfig = GConfig.s();
    ArrayList localArrayList = null;
    Object localObject = localArrayList;
    if (localGConfig != null)
    {
      localObject = localArrayList;
      if (localGConfig.d())
      {
        this.c = new ArrayList();
        if ((this.d != null) && (this.d.get() != null)) {
          ViewHelper.a((View)this.d.get(), this.a, this.h);
        }
        localArrayList = new ArrayList(2);
        localObject = localArrayList;
        if (this.c.size() > 0)
        {
          localObject = a.d();
          ((a)localObject).a = this.c;
          ((a)localObject).b = this.f;
          ((a)localObject).f = this.g;
          localArrayList.add(localObject);
          localObject = localArrayList;
        }
      }
    }
    return (List<a>)localObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/ActionCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */