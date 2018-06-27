package com.growingio.android.sdk.collection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.webkit.WebView;
import com.growingio.android.sdk.circle.c;
import com.growingio.android.sdk.models.d;
import com.growingio.android.sdk.models.g;
import com.growingio.android.sdk.models.i;
import com.growingio.android.sdk.models.j;
import com.growingio.android.sdk.models.k;
import com.growingio.android.sdk.models.l;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class MessageProcessor
  implements AppState.ActivityStateListener
{
  private static boolean b = true;
  private static int d = 0;
  private static MessageProcessor s;
  private static final Object t = new Object();
  public int a;
  private final IntentFilter c = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
  private AsyncTask<Void, Void, Pair<Integer, byte[]>> e;
  private String f;
  private Pair<WeakReference<Object>, d> g;
  private Pair<WeakReference<Object>, d> h;
  private Runnable i;
  private boolean j = false;
  private NetworkReceiver k = new NetworkReceiver();
  private Handler l;
  private GConfig m;
  private MessageUploader n;
  private Map<WeakReference<View>, ActionCalculator> o = new LinkedHashMap();
  private long p;
  private String q;
  private long r;
  private ViewTreeObserver.OnGlobalLayoutListener u = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      MessageProcessor.this.f();
      c.e().f();
      com.growingio.android.sdk.circle.a.a.b().f();
      LogUtil.d("GIO.MessageProcessor", new Object[] { "onGlobalLayout: saveAllWindowImpressionDelayed" });
    }
  };
  private ViewTreeObserver.OnScrollChangedListener v = new ViewTreeObserver.OnScrollChangedListener()
  {
    public void onScrollChanged()
    {
      MessageProcessor.this.f();
      c.e().f();
      com.growingio.android.sdk.circle.a.a.b().f();
      LogUtil.d("GIO.MessageProcessor", new Object[] { "onScrollChanged: saveAllWindowImpressionDelayed" });
    }
  };
  private ViewTreeObserver.OnGlobalFocusChangeListener w = new ViewTreeObserver.OnGlobalFocusChangeListener()
  {
    public void onGlobalFocusChanged(View paramAnonymousView1, View paramAnonymousView2)
    {
      if (paramAnonymousView1 == null) {}
      while ((paramAnonymousView1.getTag(84159246) == null) && (paramAnonymousView1.getTag(84159250) == null)) {
        return;
      }
      ViewHelper.b(paramAnonymousView1);
    }
  };
  private Runnable x = new Runnable()
  {
    public void run()
    {
      MessageProcessor.a(MessageProcessor.this);
      MessageProcessor.b(MessageProcessor.this);
    }
  };
  
  private MessageProcessor(Context paramContext)
  {
    HandlerThread localHandlerThread = new HandlerThread("GIO.MessageProcessor", 1);
    localHandlerThread.start();
    this.l = new MessageProcessorHandler(localHandlerThread.getLooper());
    this.m = GConfig.s();
    this.n = new MessageUploader(paramContext);
  }
  
  private MessageProcessor(Context paramContext, boolean paramBoolean)
  {
    HandlerThread localHandlerThread = new HandlerThread("GIO.MessageProcessor", 1);
    localHandlerThread.start();
    b = paramBoolean;
    this.l = new MessageProcessorHandler(localHandlerThread.getLooper());
    this.m = GConfig.s();
    this.n = new MessageUploader(paramContext);
  }
  
  static void a(Context paramContext)
  {
    synchronized (t)
    {
      if (s == null) {
        s = new MessageProcessor(paramContext);
      }
      return;
    }
  }
  
  static void a(Context paramContext, boolean paramBoolean)
  {
    synchronized (t)
    {
      if (s == null) {
        s = new MessageProcessor(paramContext, paramBoolean);
      }
      return;
    }
  }
  
  private void a(ActionCalculator paramActionCalculator)
  {
    if (paramActionCalculator != null)
    {
      paramActionCalculator = paramActionCalculator.a();
      if (paramActionCalculator != null) {
        break label14;
      }
    }
    for (;;)
    {
      return;
      label14:
      paramActionCalculator = paramActionCalculator.iterator();
      while (paramActionCalculator.hasNext()) {
        a((com.growingio.android.sdk.models.a)paramActionCalculator.next());
      }
    }
  }
  
  private void a(com.growingio.android.sdk.models.a parama)
  {
    if (this.q == null) {
      a("CirclePage", null);
    }
    parama.f = this.q;
    parama.b = this.p;
    a(parama);
  }
  
  private void a(String paramString)
  {
    a(k.a(paramString));
  }
  
  private void b(View paramView)
  {
    if (paramView.getTag(84159245) == null)
    {
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(this.u);
      paramView.getViewTreeObserver().addOnScrollChangedListener(this.v);
      paramView.getViewTreeObserver().addOnGlobalFocusChangeListener(this.w);
      paramView.setTag(84159245, Boolean.valueOf(true));
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    Activity localActivity = l().i();
    if (localActivity != null)
    {
      ThreadUtils.c(this.i);
      if (paramBoolean2) {
        this.p = System.currentTimeMillis();
      }
      if (!paramBoolean1) {
        break label109;
      }
      this.g = new Pair(null, new d(l().y(), this.f, this.p));
      this.o.clear();
      ThreadUtils.c(this.x);
      LogUtil.d("GIO.MessageProcessor", new Object[] { "forceRefresh: saveAllWindowImpression" });
      this.x.run();
    }
    label109:
    while (this.h == null) {
      return;
    }
    a(new d(l().y(), ((d)this.h.second).e(), this.p));
    ViewHelper.a(localActivity.getWindow().getDecorView(), "", new j()
    {
      public void b(i paramAnonymousi)
      {
        if (((paramAnonymousi.c instanceof WebView)) || (ClassExistHelper.instanceOfX5WebView(paramAnonymousi.c)))
        {
          LogUtil.d("GIO.MessageProcessor", new Object[] { "resend page event for ", paramAnonymousi.c });
          if (VdsJsBridgeManager.isWebViewHooked(paramAnonymousi.c)) {
            Util.a(paramAnonymousi.c, "_vds_hybrid.resendPage", new Object[] { Boolean.valueOf(false) });
          }
        }
      }
    });
  }
  
  private ActionCalculator c(View paramView)
  {
    Iterator localIterator = this.o.keySet().iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == paramView) {
        return (ActionCalculator)this.o.get(localWeakReference);
      }
    }
    return null;
  }
  
  private void c(android.app.Fragment paramFragment)
  {
    this.p = System.currentTimeMillis();
    ThreadUtils.c(this.i);
    this.g = new Pair(new WeakReference(paramFragment), new d(paramFragment, this.f, this.p));
  }
  
  private void c(android.support.v4.app.Fragment paramFragment)
  {
    this.p = System.currentTimeMillis();
    ThreadUtils.c(this.i);
    this.g = new Pair(new WeakReference(paramFragment), new d(paramFragment, this.f, this.p));
  }
  
  private void d(Activity paramActivity)
  {
    this.p = System.currentTimeMillis();
    ThreadUtils.c(this.i);
    this.g = new Pair(new WeakReference(paramActivity), new d(paramActivity, this.f, this.p));
  }
  
  public static MessageProcessor e()
  {
    return s;
  }
  
  private c k()
  {
    return c.e();
  }
  
  private AppState l()
  {
    return AppState.l();
  }
  
  private void m()
  {
    a(false);
  }
  
  private void n()
  {
    if (this.g != null)
    {
      if (SessionManager.c()) {
        a(((d)this.g.second).f);
      }
      a((g)this.g.second);
      this.h = this.g;
      this.g = null;
    }
  }
  
  public String a(View paramView)
  {
    if (Util.b(paramView)) {
      return "/Ignored";
    }
    if (paramView.hashCode() == this.a) {
      return WindowHelper.d();
    }
    return WindowHelper.a(paramView);
  }
  
  public void a(Activity paramActivity)
  {
    this.a = paramActivity.getWindow().getDecorView().hashCode();
    if (!this.m.b()) {
      return;
    }
    try
    {
      paramActivity.getApplicationContext().registerReceiver(this.k, this.c);
      l().b(true);
      d(paramActivity);
      this.o.clear();
      f();
      LogUtil.d("GIO.MessageProcessor", new Object[] { "Activity.onResumed: saveAllWindowImpressionDelayed" });
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void a(android.app.Fragment paramFragment)
  {
    if (!this.m.b()) {
      return;
    }
    c(paramFragment);
    this.o.clear();
    f();
    LogUtil.d("GIO.MessageProcessor", new Object[] { "Fragment.onResumed: saveAllWindowImpressionDelayed" });
  }
  
  public void a(android.support.v4.app.Fragment paramFragment)
  {
    if (!this.m.b()) {
      return;
    }
    c(paramFragment);
    this.o.clear();
    f();
    LogUtil.d("GIO.MessageProcessor", new Object[] { "Fragment.onResumed: saveAllWindowImpressionDelayed" });
  }
  
  void a(CustomEvent paramCustomEvent)
  {
    if (l().i() == null) {
      return;
    }
    if (!paramCustomEvent.b()) {
      paramCustomEvent.d = this.p;
    }
    this.l.obtainMessage(0, paramCustomEvent).sendToTarget();
  }
  
  public void a(final g paramg)
  {
    this.l.obtainMessage(0, paramg).sendToTarget();
    if ((paramg instanceof d)) {
      this.f = paramg.f;
    }
    final c localc = k();
    if ((localc != null) && (localc.c()) && ((paramg instanceof d))) {
      ThreadUtils.a(new Runnable()
      {
        public void run()
        {
          localc.a("page", null, paramg);
        }
      }, 200L);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.p = System.currentTimeMillis();
    this.q = paramString1;
    this.l.obtainMessage(0, new d(paramString1, this.f, this.p)).sendToTarget();
    LogUtil.d("GIO.MessageProcessor", new Object[] { "saveCustomPage: saveAllWindowImpression" });
    m();
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    com.growingio.android.sdk.models.b localb = new com.growingio.android.sdk.models.b();
    localb.a = paramString1;
    localb.b = System.currentTimeMillis();
    localb.d = paramString2;
    paramString2 = Collections.singletonList(localb);
    if (paramBoolean) {}
    for (paramString1 = com.growingio.android.sdk.models.a.e();; paramString1 = com.growingio.android.sdk.models.a.d())
    {
      paramString1.a = paramString2;
      a(paramString1);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = GConfig.s();
    if ((localObject1 == null) || (!((GConfig)localObject1).d())) {}
    do
    {
      return;
      localObject1 = l().i();
    } while (localObject1 == null);
    WindowHelper.a();
    View[] arrayOfView = WindowHelper.b();
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    int i1;
    label68:
    View localView;
    if (ViewHelper.a(arrayOfView) > 1)
    {
      bool = true;
      int i2 = arrayOfView.length;
      i1 = 0;
      if (i1 >= i2) {
        break label201;
      }
      localView = arrayOfView[i1];
      if (localView != null) {
        break label97;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label68;
      bool = false;
      break;
      label97:
      Object localObject2 = a(localView);
      if ((!"/Ignored".equals(localObject2)) && (ViewHelper.a(localView, (String)localObject2, bool)) && (c(localView) == null))
      {
        localObject2 = new ActionCalculator(l().b((Activity)localObject1), this.p, localView, (String)localObject2);
        this.o.put(new WeakReference(localView), localObject2);
        localArrayList.add(localObject2);
        b(localView);
      }
    }
    label201:
    if (paramBoolean) {}
    for (localObject1 = localArrayList;; localObject1 = this.o.values())
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((ActionCalculator)((Iterator)localObject1).next());
      }
    }
    if (localArrayList.size() > 0) {
      c.e().f();
    }
    c.e().n();
  }
  
  void a(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    if ((this.j) && (!paramBoolean1)) {
      return;
    }
    if ((paramBoolean1) && (paramBoolean2)) {}
    for (boolean bool = true;; bool = false)
    {
      this.j = bool;
      ThreadUtils.c(this.i);
      this.i = new Runnable()
      {
        public void run()
        {
          MessageProcessor.a(MessageProcessor.this, false);
          MessageProcessor.a(MessageProcessor.this, paramBoolean1, paramBoolean2);
        }
      };
      ThreadUtils.a(this.i, 200L);
      return;
    }
  }
  
  public boolean a()
  {
    return this.o.size() > 0;
  }
  
  public long b()
  {
    return this.p;
  }
  
  public void b(Activity paramActivity)
  {
    this.a = -1;
    this.o.clear();
    ThreadUtils.c(this.x);
    l().b(false);
    try
    {
      paramActivity.getApplicationContext().unregisterReceiver(this.k);
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public void b(android.app.Fragment paramFragment)
  {
    this.o.clear();
    ThreadUtils.c(this.x);
  }
  
  public void b(android.support.v4.app.Fragment paramFragment)
  {
    this.o.clear();
    ThreadUtils.c(this.x);
  }
  
  Handler c()
  {
    return this.l;
  }
  
  public void c(Activity paramActivity)
  {
    this.n.b();
    SessionManager.d();
  }
  
  public int d()
  {
    return this.a;
  }
  
  public void f()
  {
    ThreadUtils.c(this.x);
    ThreadUtils.a(this.x, 200L);
  }
  
  public void g()
  {
    ThreadUtils.a(new Runnable()
    {
      public void run()
      {
        MessageProcessor.this.a(true);
      }
    }, 500L);
  }
  
  private class MessageProcessorHandler
    extends Handler
  {
    MessageProcessorHandler(Looper paramLooper)
    {
      super();
    }
    
    private List<JSONObject> a(ArrayList<CustomEvent> paramArrayList)
    {
      int j = paramArrayList.size();
      ArrayList localArrayList = new ArrayList(j);
      Pair localPair = MessageProcessor.d(MessageProcessor.this).a("cstm", paramArrayList.size());
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          JSONObject localJSONObject = ((CustomEvent)paramArrayList.get(i)).c();
          try
          {
            localJSONObject.put("gesid", ((Integer)localPair.first).intValue() + i);
            localJSONObject.put("esid", ((Integer)localPair.second).intValue() + i);
            localArrayList.add(localJSONObject);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
      return localArrayList;
    }
    
    private void a()
    {
      if (b()) {}
      while (MessageProcessor.f(MessageProcessor.this) != null) {
        return;
      }
      MessageProcessor.a(MessageProcessor.this, new com.growingio.android.sdk.a.b()
      {
        protected void a(Pair<Integer, byte[]> paramAnonymousPair)
        {
          if ((((Integer)paramAnonymousPair.first).intValue() != 200) && (((Integer)paramAnonymousPair.first).intValue() != 304) && (MessageProcessor.i() < 1)) {
            MessageProcessor.g(MessageProcessor.this).postDelayed(new Runnable()
            {
              public void run()
              {
                MessageProcessor.j();
                MessageProcessor.MessageProcessorHandler.a(MessageProcessor.MessageProcessorHandler.this);
              }
            }, 5000L);
          }
          for (;;)
          {
            MessageProcessor.a(MessageProcessor.this, null);
            return;
            MessageProcessor.a(MessageProcessor.this, System.currentTimeMillis());
          }
        }
      });
      MessageProcessor.f(MessageProcessor.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
    
    private void a(g paramg)
    {
      int k = 0;
      boolean bool3 = false;
      boolean bool1;
      try
      {
        if (!(paramg instanceof com.growingio.android.sdk.models.a)) {
          break label483;
        }
        if (!((com.growingio.android.sdk.models.a)paramg).h()) {
          break label490;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          boolean bool2;
          int i;
          DBAdapter localDBAdapter;
          Object localObject;
          DiagnoseLog.a("oomw");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          DiagnoseLog.a("jsonw");
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          DiagnoseLog.a(localException1.getClass().getSimpleName());
          if (GConfig.DEBUG)
          {
            localException1.printStackTrace();
            continue;
            continue;
            bool1 = true;
          }
        }
      }
      bool2 = bool1;
      if ((paramg instanceof l))
      {
        if (((l)paramg).c().getString("t").equals("imp")) {
          break label496;
        }
        i = 1;
        label58:
        bool1 &= i;
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (!GConfig.s().d()) {
            return;
          }
        }
      }
      localDBAdapter = DBAdapter.a();
      if (localDBAdapter == null)
      {
        DBAdapter.a(MessageProcessor.c(MessageProcessor.this).k());
        localDBAdapter = DBAdapter.a();
        bool1 = bool2;
        if (!bool2)
        {
          bool1 = bool2;
          if (!MessageProcessor.d(MessageProcessor.this).i())
          {
            bool1 = bool2;
            if (!MessageProcessor.d(MessageProcessor.this).C()) {
              bool1 = true;
            }
          }
        }
        if ((!bool1) && (MessageProcessor.d(MessageProcessor.this).x()))
        {
          localObject = b(paramg);
          if (((Pair)localObject).first != null)
          {
            bool1 = bool3;
            if (!MessageProcessor.d(MessageProcessor.this).i()) {
              bool1 = true;
            }
            localDBAdapter.a("imp", bool1, (String)((Pair)localObject).first);
            bool1 = true;
          }
          if ((((Pair)localObject).second == null) || (MessageProcessor.d(MessageProcessor.this).C())) {
            break label501;
          }
          localDBAdapter.a("imp", false, (String)((Pair)localObject).second);
          break label501;
        }
      }
      label483:
      label490:
      label496:
      label501:
      for (;;)
      {
        MessageProcessor.e(MessageProcessor.this).a(bool1, paramg.i());
        int j;
        if (paramg.i() > 0)
        {
          DiagnoseLog.a("events", paramg.i());
          DiagnoseLog.a(paramg.a_(), paramg.i());
          a();
          return;
          if ((paramg instanceof CustomEvent))
          {
            localObject = a(CustomEvent.a((CustomEvent)paramg));
            int m = ((List)localObject).size();
            i = k;
            while (i < m)
            {
              localDBAdapter.a("cstm", true, ((JSONObject)((List)localObject).get(i)).toString());
              i += 1;
            }
          }
          localObject = paramg.c();
          try
          {
            a(paramg, (JSONObject)localObject);
            localDBAdapter.a(((JSONObject)localObject).getString("t"), bool1, ((JSONObject)localObject).toString());
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
        }
        else
        {
          return;
          bool1 = false;
          break;
          j = 0;
          break label58;
        }
      }
    }
    
    private void a(g paramg, JSONObject paramJSONObject)
    {
      int i = paramg.i();
      try
      {
        if (!paramg.a().equals("imp"))
        {
          Pair localPair = MessageProcessor.d(MessageProcessor.this).a(paramg.a(), i);
          if ((paramg instanceof com.growingio.android.sdk.models.a))
          {
            paramg = paramJSONObject.getJSONArray("e");
            int j = paramg.length();
            i = 0;
            while (i < j)
            {
              paramJSONObject = paramg.getJSONObject(i);
              paramJSONObject.put("gesid", ((Integer)localPair.first).intValue() + i);
              paramJSONObject.put("esid", ((Integer)localPair.second).intValue() + i);
              i += 1;
            }
          }
          paramJSONObject.put("gesid", localPair.first);
          paramJSONObject.put("esid", localPair.second);
        }
        return;
      }
      catch (JSONException paramg)
      {
        paramg.printStackTrace();
      }
    }
    
    private Pair<String, String> b(g paramg)
    {
      int m = 0;
      int j = 0;
      Object localObject1 = null;
      Object localObject2 = MessageProcessor.d(MessageProcessor.this).j();
      ArrayList localArrayList = (ArrayList)((HashMap)localObject2).get(null);
      Object localObject3;
      Object localObject4;
      Object localObject5;
      if ((paramg instanceof com.growingio.android.sdk.models.a))
      {
        localObject3 = (ArrayList)((HashMap)localObject2).get(paramg.f);
        if (localObject3 != null) {}
        for (i = ((ArrayList)localObject3).size();; i = 0)
        {
          if (localArrayList != null) {
            j = localArrayList.size();
          }
          if (i + j != 0) {
            break;
          }
          return new Pair(null, paramg.c().toString());
        }
        localObject4 = ((com.growingio.android.sdk.models.a)paramg).g();
        localObject2 = ((com.growingio.android.sdk.models.a)paramg).g();
        paramg = ((com.growingio.android.sdk.models.a)paramg).a.iterator();
        while (paramg.hasNext())
        {
          localObject5 = (com.growingio.android.sdk.models.b)paramg.next();
          if (((localArrayList != null) && (Util.a((com.growingio.android.sdk.models.b)localObject5, localArrayList))) || ((localObject3 != null) && (Util.a((com.growingio.android.sdk.models.b)localObject5, (ArrayList)localObject3)))) {
            ((com.growingio.android.sdk.models.a)localObject4).a.add(localObject5);
          } else {
            ((com.growingio.android.sdk.models.a)localObject2).a.add(localObject5);
          }
        }
        if (((com.growingio.android.sdk.models.a)localObject4).i() > 0) {}
        for (paramg = ((com.growingio.android.sdk.models.a)localObject4).c().toString();; paramg = null)
        {
          if (((com.growingio.android.sdk.models.a)localObject2).i() > 0) {
            localObject1 = ((com.growingio.android.sdk.models.a)localObject2).c().toString();
          }
          return new Pair(paramg, localObject1);
        }
      }
      if ((paramg instanceof l)) {
        localObject1 = ((l)paramg).c();
      }
      for (;;)
      {
        try
        {
          localObject3 = ((JSONObject)localObject1).getString("d");
          localObject4 = (ArrayList)((HashMap)localObject2).get(((JSONObject)localObject1).getString("p"));
          localObject5 = (ArrayList)((HashMap)localObject2).get(paramg.f + "::" + '*');
          if (localObject4 == null) {
            break label423;
          }
          i = ((ArrayList)localObject4).size();
          if (localArrayList == null) {
            break label428;
          }
          j = localArrayList.size();
          if (localObject5 == null) {
            break label433;
          }
          k = ((ArrayList)localObject5).size();
          if (k + (i + j) != 0) {
            break;
          }
          paramg = new Pair(null, paramg.c().toString());
          return paramg;
        }
        catch (JSONException paramg)
        {
          paramg.printStackTrace();
        }
        return new Pair(null, null);
        label423:
        i = 0;
        continue;
        label428:
        j = 0;
        continue;
        label433:
        int k = 0;
      }
      paramg = ((JSONObject)localObject1).getJSONArray("e");
      JSONArray localJSONArray = new JSONArray();
      localObject2 = new JSONArray();
      j = paramg.length();
      int i = m;
      for (;;)
      {
        if (i < j)
        {
          JSONObject localJSONObject = paramg.getJSONObject(i);
          if (((localArrayList != null) && (Util.a(localJSONObject, localArrayList, (String)localObject3))) || ((localObject5 != null) && (Util.a(localJSONObject, (ArrayList)localObject5, (String)localObject3))) || ((localObject4 != null) && (Util.a(localJSONObject, (ArrayList)localObject4, (String)localObject3)))) {
            localJSONArray.put(localJSONObject);
          } else {
            ((JSONArray)localObject2).put(localJSONObject);
          }
        }
        else
        {
          if (localJSONArray.length() > 0)
          {
            paramg = ((JSONObject)localObject1).put("e", localJSONArray).toString();
            if (((JSONArray)localObject2).length() <= 0) {
              break label619;
            }
          }
          label619:
          for (localObject1 = ((JSONObject)localObject1).put("e", localObject2).toString();; localObject1 = null)
          {
            paramg = new Pair(paramg, localObject1);
            return paramg;
            paramg = null;
            break;
          }
        }
        i += 1;
      }
    }
    
    private boolean b()
    {
      return System.currentTimeMillis() - MessageProcessor.h(MessageProcessor.this) > 86400000L;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if (GrowingIO.testHandler != null) {
          Util.a(GrowingIO.testHandler, 1048576, new Object[] { ((g)paramMessage.obj).c() });
        }
        if (MessageProcessor.h()) {
          a((g)paramMessage.obj);
        } else {
          LogUtil.d("GIO.MessageProcessor", new Object[] { "shouldn't collect information of this device" });
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/MessageProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */