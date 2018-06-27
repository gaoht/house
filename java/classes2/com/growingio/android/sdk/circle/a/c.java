package com.growingio.android.sdk.circle.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.models.c.a;
import com.growingio.android.sdk.models.i;
import com.growingio.android.sdk.models.j;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class c
  extends j
{
  private final String a = "GIO.HeatMapNodeTraveler";
  private boolean b = false;
  private final int c = 1000;
  private final int d = 50;
  private int e;
  private e f;
  private com.growingio.android.sdk.models.c[] g;
  private ArrayList<b> h;
  private HashMap<View, b> i;
  private Runnable j = new Runnable()
  {
    public void run()
    {
      c.a(c.this);
    }
  };
  
  public c(e parame)
  {
    this.f = parame;
    this.h = new ArrayList();
    this.i = new HashMap();
  }
  
  private b a(i parami, c.a parama)
  {
    boolean bool = d(parami);
    if (parama == null)
    {
      if (!bool) {
        parami = (b)this.i.get(parami.c);
      }
    }
    else
    {
      b localb;
      do
      {
        do
        {
          return parami;
          if (!bool) {
            break;
          }
          localb = (b)this.i.get(parami.c);
          parami = localb;
        } while (localb == null);
        parami = localb;
      } while (localb.a == parama.a());
      return null;
    }
    return null;
  }
  
  private c.a a(i parami, c.a[] paramArrayOfa)
  {
    int m = paramArrayOfa.length;
    Object localObject;
    if ((m == 1) && (!d(parami)))
    {
      localObject = paramArrayOfa[0];
      return (c.a)localObject;
    }
    int k = 0;
    for (;;)
    {
      if (k >= m) {
        break label62;
      }
      c.a locala = paramArrayOfa[k];
      localObject = locala;
      if (locala.a() == parami.e) {
        break;
      }
      k += 1;
    }
    label62:
    return null;
  }
  
  private void a(b paramb)
  {
    paramb.a();
    this.h.add(paramb);
  }
  
  private boolean a(View paramView)
  {
    return ((paramView instanceof Spinner)) || ((paramView instanceof RadioGroup));
  }
  
  private boolean a(i parami, com.growingio.android.sdk.models.c paramc)
  {
    paramc = paramc.a();
    if (paramc.startsWith("#")) {
      if (GConfig.USE_ID) {}
    }
    while (!paramc.equals(parami.j))
    {
      do
      {
        return false;
      } while (!parami.j.endsWith(paramc));
      return true;
    }
    return true;
  }
  
  private boolean a(i parami, com.growingio.android.sdk.models.c paramc, boolean paramBoolean)
  {
    paramc = a(parami, paramc.c());
    if (paramc == null) {}
    for (;;)
    {
      return false;
      b localb = a(parami, paramc);
      if (localb == null) {
        b(parami, paramc);
      }
      while (!paramBoolean)
      {
        return true;
        a(localb);
      }
    }
  }
  
  private i b(i parami, com.growingio.android.sdk.models.c paramc)
  {
    parami = (ViewGroup)parami.c;
    int m = parami.getChildCount();
    int k = 0;
    while (k < m)
    {
      i locali = ViewHelper.a(parami.getChildAt(k), null);
      if (locali.k.equals(paramc.b())) {
        return locali;
      }
      k += 1;
    }
    return null;
  }
  
  private void b(i parami, c.a parama)
  {
    parama = new b(parami, parama);
    this.h.add(parama);
    this.i.put(parami.c, parama);
  }
  
  private void c(i parami)
  {
    if (!Util.c(parami.c)) {
      return;
    }
    Object localObject = a(parami, null);
    if (localObject != null)
    {
      a((b)localObject);
      return;
    }
    boolean bool2 = a(parami.c);
    int k = 0;
    label43:
    i locali;
    if (k < this.e)
    {
      localObject = this.g[k];
      if (a(parami, (com.growingio.android.sdk.models.c)localObject))
      {
        if (!bool2) {
          break label110;
        }
        locali = b(parami, (com.growingio.android.sdk.models.c)localObject);
        if (locali != null) {
          break label95;
        }
      }
    }
    for (;;)
    {
      k += 1;
      break label43;
      break;
      label95:
      label110:
      for (boolean bool1 = a(locali, (com.growingio.android.sdk.models.c)localObject, true); bool1; bool1 = a(parami, (com.growingio.android.sdk.models.c)localObject, false)) {
        return;
      }
    }
  }
  
  private void d()
  {
    this.h.clear();
    ViewHelper.a(WindowHelper.b(), this);
    this.f.a(this.h);
    this.b = false;
    ThreadUtils.a(this.j, 1000L);
  }
  
  private boolean d(i parami)
  {
    return parami.e != -1;
  }
  
  public void a()
  {
    this.i.clear();
    this.g = new com.growingio.android.sdk.models.c[0];
    this.e = 0;
    b();
  }
  
  public void a(com.growingio.android.sdk.models.c[] paramArrayOfc)
  {
    if (paramArrayOfc == null) {
      return;
    }
    this.g = paramArrayOfc;
    this.e = paramArrayOfc.length;
    c();
  }
  
  public void b()
  {
    this.b = false;
    ThreadUtils.c(this.j);
  }
  
  public void b(i parami)
  {
    c(parami);
  }
  
  public void c()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    ThreadUtils.c(this.j);
    ThreadUtils.a(this.j, 50L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */