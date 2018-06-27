package com.unionpay.mobile.android.pro.pboc.engine;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.samsung.f.a;
import com.unionpay.mobile.android.plugin.BaseActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class b
  implements Handler.Callback, f.a
{
  private a A = null;
  private boolean B = false;
  private final int a = 0;
  private final int b = 1;
  private final int c = 2;
  private final int d = 4;
  private final int e = 8;
  private int f = 0;
  private Context g = null;
  private Handler h = null;
  private ArrayList<com.unionpay.mobile.android.model.c> i = null;
  private ArrayList<com.unionpay.mobile.android.model.c> j = null;
  private ArrayList<com.unionpay.mobile.android.model.c> k = null;
  private ArrayList<com.unionpay.mobile.android.model.c> l = null;
  private ArrayList<com.unionpay.mobile.android.model.c> m = null;
  private com.unionpay.mobile.android.pboctransaction.d n = null;
  private com.unionpay.mobile.android.pboctransaction.c o = null;
  private final com.unionpay.mobile.android.pboctransaction.b p = new c(this);
  private com.unionpay.mobile.android.pboctransaction.d q = null;
  private com.unionpay.mobile.android.pboctransaction.remoteapdu.a r = null;
  private final com.unionpay.mobile.android.pboctransaction.b s = new d(this);
  private com.unionpay.mobile.android.pboctransaction.d t = null;
  private com.unionpay.mobile.android.pboctransaction.simapdu.b u = null;
  private final com.unionpay.mobile.android.pboctransaction.b v = new e(this);
  private com.unionpay.mobile.android.pboctransaction.d w = null;
  private com.unionpay.mobile.android.pboctransaction.samsung.b x = null;
  private com.unionpay.mobile.android.pboctransaction.samsung.f y = null;
  private final com.unionpay.mobile.android.pboctransaction.b z = new f(this);
  
  public b(Context paramContext, String paramString)
  {
    this.g = paramContext;
    this.h = new Handler(this);
    this.i = new ArrayList(1);
    paramContext = (com.unionpay.mobile.android.fully.a)((BaseActivity)paramContext).a(UPPayEngine.class.toString());
    if (a("cn.gov.pbc.tsm.client.mobile.andorid", 1)) {
      this.o = new com.unionpay.mobile.android.pboctransaction.icfcc.a();
    }
    for (;;)
    {
      this.n = new com.unionpay.mobile.android.pboctransaction.d(this.o, paramContext, paramString);
      try
      {
        Class.forName("org.simalliance.openmobileapi.SEService");
        this.r = new com.unionpay.mobile.android.pboctransaction.remoteapdu.a();
        this.q = new com.unionpay.mobile.android.pboctransaction.d(this.r, paramContext, paramString);
        this.u = com.unionpay.mobile.android.pboctransaction.simapdu.b.e();
        this.t = new com.unionpay.mobile.android.pboctransaction.d(this.u, paramContext, paramString);
        if (a("com.unionpay.tsmservice", 5))
        {
          this.y = new com.unionpay.mobile.android.pboctransaction.samsung.f(this);
          this.y.a(this.h);
          this.w = new com.unionpay.mobile.android.pboctransaction.d(this.y, paramContext, paramString);
          return;
          this.o = new com.unionpay.mobile.android.pboctransaction.sdapdu.a();
        }
        else
        {
          com.unionpay.mobile.android.model.b.aB = false;
          this.x = new com.unionpay.mobile.android.pboctransaction.samsung.b();
          this.w = new com.unionpay.mobile.android.pboctransaction.d(this.x, paramContext, paramString);
          return;
        }
      }
      catch (ClassNotFoundException paramContext)
      {
        this.s.b();
        this.v.b();
        this.z.b();
        return;
      }
      catch (Exception paramContext)
      {
        this.s.b();
        this.v.b();
        this.z.b();
      }
    }
  }
  
  private final void a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      com.unionpay.mobile.android.utils.j.c("UPCardEngine", "sd");
      if (this.o != null) {
        this.o.a(this.p, this.g);
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          return;
          com.unionpay.mobile.android.utils.j.c("UPCardEngine", "cmcc");
          if (!a("com.unionpay.mobile.tsm", 12)) {
            break;
          }
        } while (this.r == null);
        this.r.a(this.B);
        this.r.a(this.s, this.g);
        return;
        this.s.b();
        return;
        com.unionpay.mobile.android.utils.j.c("UPCardEngine", "ic");
      } while (this.u == null);
      if (b().contains("ZTE"))
      {
        this.u.a(this.v, this.g);
        return;
      }
      this.v.b();
      return;
      com.unionpay.mobile.android.utils.j.c("UPCardEngine", "se");
      if ((a("com.unionpay.tsmservice", 5)) && (this.y != null))
      {
        Log.e("uppay-spay", "type se  start init");
        this.y.a(this.z, this.g);
        return;
      }
    } while (this.x == null);
    this.x.a(this.z, this.g);
  }
  
  private boolean a(String paramString, int paramInt)
  {
    Object localObject = null;
    boolean bool2 = false;
    try
    {
      paramString = this.g.getPackageManager().getPackageInfo(paramString, 0);
      boolean bool1 = bool2;
      if (paramString != null)
      {
        com.unionpay.mobile.android.utils.j.a("tsm-client", "tsm version code=" + paramString.versionCode);
        bool1 = bool2;
        if (paramString.versionCode >= paramInt) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = (String)localObject;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        paramString = (String)localObject;
      }
    }
  }
  
  private static String b()
  {
    return Build.BRAND + "_" + Build.MODEL;
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 1) {
      new Thread(new g(this)).start();
    }
    do
    {
      do
      {
        return;
        if (paramInt == 2)
        {
          new Thread(new h(this)).start();
          return;
        }
        if (paramInt != 4) {
          break;
        }
      } while (!b().contains("ZTE"));
      new Thread(new i(this)).start();
      return;
    } while (paramInt != 8);
    new Thread(new j(this)).start();
  }
  
  public final Bundle a(com.unionpay.mobile.android.model.c paramc, String paramString1, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString2)
  {
    if (paramc == null) {}
    int i2;
    do
    {
      int i1;
      AppIdentification localAppIdentification;
      do
      {
        return null;
        i1 = paramc.c();
        i2 = paramc.d();
        if (i2 != 1) {
          break;
        }
        localAppIdentification = new AppIdentification(paramc.a(), null);
        if (paramc.d() == 1) {}
        for (paramc = "2"; i1 == 8; paramc = "1") {
          return this.n.a(localAppIdentification, paramString1, paramc, paramHashMap1, paramHashMap2, paramString2);
        }
        if (i1 == 4) {
          return this.q.a(localAppIdentification, paramString1, paramc, paramHashMap1, paramHashMap2, paramString2);
        }
        if (i1 == 16) {
          return this.t.a(localAppIdentification, paramString1, paramc, paramHashMap1, paramHashMap2, paramString2);
        }
        if (i1 == 1) {
          return this.w.a(localAppIdentification, paramString1, paramc, paramHashMap1, paramHashMap2, paramString2);
        }
      } while (i1 != 32);
      return this.w.a(localAppIdentification, paramString1, "10", paramHashMap1, paramHashMap2, paramString2);
    } while (i2 != 2);
    paramc = paramc.a();
    return this.n.a(Integer.parseInt(paramc), paramString1, paramHashMap2, paramString2);
  }
  
  public final void a()
  {
    if (this.r != null)
    {
      this.r.a();
      this.r = null;
    }
    if (this.o != null)
    {
      this.o.a();
      this.o = null;
    }
    if (this.u != null)
    {
      this.u.a();
      this.u = null;
    }
    if (this.x != null)
    {
      this.x.a();
      this.x = null;
    }
    if (this.y != null)
    {
      this.y.a();
      this.y = null;
    }
    this.g = null;
    this.A = null;
    this.h.removeCallbacksAndMessages(null);
    this.h = null;
    this.w = null;
    this.n = null;
    this.q = null;
    this.t = null;
    this.f = 0;
  }
  
  public final void a(Handler paramHandler, String paramString1, String paramString2)
  {
    if ((com.unionpay.mobile.android.model.b.aA) && (com.unionpay.mobile.android.model.b.aB))
    {
      com.unionpay.mobile.android.model.b.bn = true;
      if ((this.y != null) && (this.w != null))
      {
        this.y.a(paramHandler);
        this.y.b(paramString1);
        this.y.c(paramString2);
        Log.e("uppay-spay", "tsmservice  get spay card list");
        this.w.b();
      }
    }
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    this.B = paramBoolean;
    this.A = parama;
    this.f = 0;
    a(0);
  }
  
  public final void a(boolean paramBoolean)
  {
    com.unionpay.mobile.android.utils.j.c("uppay", "startReadList  spay");
    com.unionpay.mobile.android.model.b.aB = paramBoolean;
    b(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    com.unionpay.mobile.android.utils.j.c("UPCardEngine", " msg.what = " + paramMessage.what);
    if ((paramMessage.what == 1) || (paramMessage.what == 2) || (paramMessage.what == 4) || (paramMessage.what == 8))
    {
      this.f ^= paramMessage.what;
      com.unionpay.mobile.android.utils.j.c("UPCardEngine", " mTag = " + this.f);
      if (paramMessage.obj != null)
      {
        if (paramMessage.what != 1) {
          break label279;
        }
        this.j = ((ArrayList)paramMessage.obj);
      }
    }
    for (;;)
    {
      a(paramMessage.what);
      if ((this.f == 15) && (this.A != null))
      {
        if ((this.j != null) && (this.j.size() > 0)) {
          this.i.addAll(this.j);
        }
        if ((this.k != null) && (this.k.size() > 0)) {
          this.i.addAll(this.k);
        }
        if ((this.l != null) && (this.l.size() > 0)) {
          this.i.addAll(this.l);
        }
        if ((this.m != null) && (this.m.size() > 0)) {
          this.i.addAll(this.m);
        }
        this.A.a(this.i);
      }
      return true;
      label279:
      if (paramMessage.what == 2) {
        this.k = ((ArrayList)paramMessage.obj);
      } else if (paramMessage.what == 4) {
        this.l = ((ArrayList)paramMessage.obj);
      } else if (paramMessage.what == 8) {
        this.m = ((ArrayList)paramMessage.obj);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/pboc/engine/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */