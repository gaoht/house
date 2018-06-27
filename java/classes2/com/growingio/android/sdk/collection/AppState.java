package com.growingio.android.sdk.collection;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import com.growingio.android.sdk.a.a;
import com.growingio.android.sdk.a.e;
import com.growingio.android.sdk.circle.c;
import com.growingio.android.sdk.models.k;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.ExclusiveIOManager;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.growingio.android.sdk.utils.PersistUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

@TargetApi(14)
public class AppState
  implements Application.ActivityLifecycleCallbacks
{
  @SuppressLint({"StaticFieldLeak"})
  private static AppState b;
  private long a = 0L;
  private Context c;
  private DeviceUUIDFactory d;
  private final Object e = new Object();
  private boolean f = false;
  private int g = -1;
  private SparseArray<String> h = new SparseArray(10);
  private Double i;
  private Double j;
  private boolean k = false;
  private boolean l = false;
  private String m;
  private boolean n = false;
  private GConfig o;
  private String p;
  private ArrayList<WeakReference<EditText>> q = new ArrayList();
  private WeakHashMap<Object, SparseArray<String>> r = new WeakHashMap();
  private WeakReference<Activity> s = new WeakReference(null);
  private WeakReference<Object> t = new WeakReference(null);
  private WeakHashMap<Activity, List<Integer>> u = new WeakHashMap();
  private WeakHashMap<Activity, List<Integer>> v = new WeakHashMap();
  private WeakHashMap<Object, String> w = new WeakHashMap();
  private ArrayList<ActivityStateListener> x;
  private Runnable y = new Runnable()
  {
    public void run()
    {
      if (AppState.a(AppState.this) != null) {
        AppState.a(AppState.this).clear();
      }
    }
  };
  
  public AppState(Configuration paramConfiguration)
  {
    this.c = paramConfiguration.a.getApplicationContext();
    PersistUtil.a(this.c);
    GrowingIO.sPackageName = this.c.getPackageName();
    GrowingIO.sProjectId = paramConfiguration.b;
    this.d = new DeviceUUIDFactory(paramConfiguration.a);
    if (TextUtils.isEmpty(paramConfiguration.d)) {
      paramConfiguration.d = this.d.a();
    }
    for (;;)
    {
      this.x = new ArrayList(2);
      PersistUtil.a(this.h);
      return;
      this.d.a(paramConfiguration.d);
    }
  }
  
  private int A()
  {
    this.p = "UNKNOWN";
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.c.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting()))
      {
        int i1 = localNetworkInfo.getType();
        if (i1 != 1) {}
      }
      return 0;
    }
    catch (Exception localException1)
    {
      try
      {
        this.p = "WIFI";
        return 2;
      }
      catch (Exception localException2)
      {
        return 2;
      }
      try
      {
        this.p = NetworkUtil.a(localNetworkInfo.getSubtype(), localNetworkInfo.getSubtypeName());
        return 1;
      }
      catch (Exception localException3)
      {
        return 1;
      }
      localException1 = localException1;
      return 0;
    }
  }
  
  private void a(Activity paramActivity, int paramInt)
  {
    List localList = (List)this.v.get(paramActivity);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList(1);
      this.v.put(paramActivity, localObject);
    }
    ((List)localObject).add(Integer.valueOf(paramInt));
  }
  
  static void a(Configuration paramConfiguration)
  {
    if (b == null) {
      b = new AppState(paramConfiguration);
    }
  }
  
  private boolean a(Activity paramActivity, Object paramObject)
  {
    GConfig localGConfig = n();
    if (!a(paramObject, paramActivity)) {}
    int i1;
    do
    {
      return false;
      localObject = (List)this.v.get(paramActivity);
      i1 = paramObject.hashCode();
    } while ((localObject != null) && (((List)localObject).contains(Integer.valueOf(i1))));
    Object localObject = null;
    if ((paramObject instanceof android.app.Fragment)) {
      localObject = ((android.app.Fragment)paramObject).getView();
    }
    for (;;)
    {
      if ((localObject == null) || (!(localObject instanceof View))) {
        break label132;
      }
      if (((View)localObject).getTag(84159247) != null) {
        break;
      }
      localObject = ((View)localObject).getParent();
      continue;
      if (ClassExistHelper.instanceOfSupportFragment(paramObject)) {
        localObject = ((android.support.v4.app.Fragment)paramObject).getView();
      }
    }
    label132:
    if (localGConfig.e()) {
      return true;
    }
    paramActivity = (List)this.u.get(paramActivity);
    if ((paramActivity != null) && (paramActivity.contains(Integer.valueOf(i1)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(Object paramObject)
  {
    Activity localActivity = (Activity)this.s.get();
    return (localActivity != null) && (a(localActivity, paramObject));
  }
  
  private boolean a(Object paramObject, Activity paramActivity)
  {
    return (paramObject != null) && ((((paramObject instanceof android.app.Fragment)) && (((android.app.Fragment)paramObject).getActivity() == paramActivity)) || ((ClassExistHelper.instanceOfSupportFragment(paramObject)) && (((android.support.v4.app.Fragment)paramObject).getActivity() == paramActivity)));
  }
  
  private void b(Activity paramActivity, int paramInt)
  {
    List localList = (List)this.u.get(paramActivity);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList(1);
      this.u.put(paramActivity, localObject);
    }
    ((List)localObject).add(Integer.valueOf(paramInt));
  }
  
  public static AppState l()
  {
    return b;
  }
  
  private e z()
  {
    return e.a();
  }
  
  public WeakHashMap<Object, SparseArray<String>> a()
  {
    return this.r;
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    long l1 = System.currentTimeMillis();
    if ((this.i == null) || (this.j == null) || (Util.a(paramDouble1, paramDouble2, this.i.doubleValue(), this.j.doubleValue(), l1, this.a)))
    {
      this.i = Double.valueOf(paramDouble1);
      this.j = Double.valueOf(paramDouble2);
      this.a = l1;
      k localk = k.d();
      if (localk != null) {
        MessageProcessor.e().a(localk);
      }
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2)
  {
    boolean bool1 = true;
    boolean bool2 = TextUtils.isEmpty(paramString2);
    int i1;
    if (!TextUtils.isEmpty((CharSequence)this.h.get(paramInt)))
    {
      i1 = 1;
      paramString1 = paramString1 + ":" + paramString2;
      if (!bool2) {
        break label131;
      }
      this.h.remove(paramInt);
      PersistUtil.a(paramInt);
      label71:
      if (paramInt == 0)
      {
        if ((this.k) && (!TextUtils.equals(this.m, paramString2))) {
          this.l = true;
        }
        if (bool2) {
          break label148;
        }
        label103:
        this.k = bool1;
        this.m = paramString2;
      }
      if (n().b()) {
        break label154;
      }
    }
    label131:
    label148:
    label154:
    while ((i1 != 0) || (bool2))
    {
      return;
      i1 = 0;
      break;
      this.h.put(paramInt, paramString1);
      PersistUtil.a(paramInt, paramString1);
      break label71;
      bool1 = false;
      break label103;
    }
    MessageProcessor.e().a(false, false);
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      ThreadUtils.b(this.y);
      return;
    }
    ThreadUtils.c(this.y);
    this.s = new WeakReference(paramActivity);
  }
  
  void a(Activity paramActivity, android.app.Fragment paramFragment)
  {
    b(paramActivity, paramFragment.hashCode());
  }
  
  void a(Activity paramActivity, android.support.v4.app.Fragment paramFragment)
  {
    b(paramActivity, paramFragment.hashCode());
  }
  
  public void a(android.app.Fragment paramFragment)
  {
    if (a(paramFragment))
    {
      this.t = new WeakReference(paramFragment);
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext()) {
        ((ActivityStateListener)localIterator.next()).a(paramFragment);
      }
    }
  }
  
  public void a(android.support.v4.app.Fragment paramFragment)
  {
    if (a(paramFragment))
    {
      this.t = new WeakReference(paramFragment);
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext()) {
        ((ActivityStateListener)localIterator.next()).a(paramFragment);
      }
    }
  }
  
  public void a(EditText paramEditText)
  {
    Iterator localIterator = this.q.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == paramEditText) {
        this.q.remove(localWeakReference);
      }
    }
    this.q.add(new WeakReference(paramEditText));
  }
  
  void a(Object paramObject, String paramString)
  {
    this.w.put(paramObject, paramString);
  }
  
  void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean a(ActivityStateListener paramActivityStateListener)
  {
    if ((paramActivityStateListener == null) || (this.x.contains(paramActivityStateListener))) {
      return false;
    }
    this.x.add(paramActivityStateListener);
    return true;
  }
  
  public String b()
  {
    return GrowingIO.sPackageName;
  }
  
  public String b(Activity paramActivity)
  {
    Object localObject2 = this.t.get();
    Object localObject1;
    if (a(localObject2, paramActivity))
    {
      localObject1 = (String)this.w.get(localObject2);
      if (localObject1 == null) {}
    }
    do
    {
      return (String)localObject1;
      return Util.a(localObject2.getClass());
      localObject2 = (String)this.w.get(paramActivity);
      localObject1 = localObject2;
    } while (localObject2 != null);
    return Util.a(paramActivity.getClass());
  }
  
  void b(Activity paramActivity, android.app.Fragment paramFragment)
  {
    a(paramActivity, paramFragment.hashCode());
  }
  
  void b(Activity paramActivity, android.support.v4.app.Fragment paramFragment)
  {
    a(paramActivity, paramFragment.hashCode());
  }
  
  public void b(android.app.Fragment paramFragment)
  {
    if (a(paramFragment))
    {
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext()) {
        ((ActivityStateListener)localIterator.next()).b(paramFragment);
      }
    }
    if (paramFragment == this.t.get()) {
      this.t.clear();
    }
  }
  
  public void b(android.support.v4.app.Fragment paramFragment)
  {
    if (a(paramFragment))
    {
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext()) {
        ((ActivityStateListener)localIterator.next()).b(paramFragment);
      }
    }
    if (paramFragment == this.t.get()) {
      this.t.clear();
    }
  }
  
  void b(boolean paramBoolean)
  {
    synchronized (this.e)
    {
      this.f = paramBoolean;
      return;
    }
  }
  
  public boolean b(ActivityStateListener paramActivityStateListener)
  {
    if (paramActivityStateListener == null) {}
    int i1;
    do
    {
      return false;
      i1 = this.x.indexOf(paramActivityStateListener);
    } while (i1 == -1);
    this.x.remove(i1);
    return true;
  }
  
  public String c()
  {
    return GrowingIO.sProjectId;
  }
  
  String d()
  {
    return "47f566eaec0a47f9b48e9530fe4a4680";
  }
  
  public Double e()
  {
    return this.i;
  }
  
  public Double f()
  {
    return this.j;
  }
  
  public void g()
  {
    this.i = null;
    this.j = null;
  }
  
  public Object h()
  {
    return this.t.get();
  }
  
  public Activity i()
  {
    return (Activity)this.s.get();
  }
  
  public SparseArray<String> j()
  {
    Object localObject2 = h();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = i();
      localObject1 = localObject2;
      if (localObject2 == null) {
        return null;
      }
    }
    return (SparseArray)a().get(localObject1);
  }
  
  public Context k()
  {
    return this.c;
  }
  
  public DeviceUUIDFactory m()
  {
    return this.d;
  }
  
  GConfig n()
  {
    if (this.o == null) {
      this.o = GConfig.s();
    }
    return this.o;
  }
  
  boolean o()
  {
    return this.l;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    LogUtil.d("GIO.AppState", new Object[] { "onActivityCreated ", paramActivity });
    a(paramActivity);
    c.e().a(paramActivity.getIntent(), paramActivity);
    this.q.clear();
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    LogUtil.d("GIO.AppState", new Object[] { "onActivityDestroyed ", paramActivity });
    a().remove(paramActivity);
    this.u.remove(paramActivity);
    this.v.remove(paramActivity);
    if (i() == null) {
      ExclusiveIOManager.a();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    LogUtil.d("GIO.AppState", new Object[] { "onActivityPaused ", paramActivity });
    Object localObject = this.x.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ActivityStateListener)((Iterator)localObject).next()).b(paramActivity);
    }
    if (this.q.size() > 0)
    {
      paramActivity = this.q.iterator();
      while (paramActivity.hasNext())
      {
        localObject = (EditText)((WeakReference)paramActivity.next()).get();
        if ((localObject != null) && (((EditText)localObject).isFocused())) {
          ViewHelper.b((View)localObject);
        }
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    LogUtil.d("GIO.AppState", new Object[] { "onActivityResumed ", paramActivity });
    a(paramActivity);
    this.t.clear();
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext()) {
      ((ActivityStateListener)localIterator.next()).a(paramActivity);
    }
    if (!this.n)
    {
      this.n = true;
      LogUtil.d("T_SEND", new Object[] { "mFirstActivityResumed:true" });
      if (!n().D())
      {
        LogUtil.d("T_SEND", new Object[] { "isDeviceActivated:false" });
        new a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      }
    }
    else
    {
      return;
    }
    LogUtil.d("T_SEND", new Object[] { "isDeviceActivated:true" });
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    LogUtil.d("GIO.AppState", new Object[] { "onActivitySaveInstanceState ", paramActivity });
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    LogUtil.d("GIO.AppState", new Object[] { "onActivityStarted ", paramActivity });
    c.e().a(paramActivity.getIntent(), paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    LogUtil.d("GIO.AppState", new Object[] { "onActivityStopped ", paramActivity });
    if (paramActivity == i())
    {
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext()) {
        ((ActivityStateListener)localIterator.next()).c(paramActivity);
      }
      a(null);
    }
  }
  
  int p()
  {
    synchronized (this.e)
    {
      if ((!this.f) || (this.g == -1)) {
        this.g = A();
      }
      int i1 = this.g;
      return i1;
    }
  }
  
  public String q()
  {
    return this.p;
  }
  
  public String r()
  {
    return this.d.d();
  }
  
  public String s()
  {
    return this.d.c();
  }
  
  public String t()
  {
    return this.d.e();
  }
  
  public String u()
  {
    return this.d.f();
  }
  
  void v()
  {
    synchronized (this.e)
    {
      this.g = -1;
      return;
    }
  }
  
  public SparseArray w()
  {
    return this.h;
  }
  
  public SparseArray x()
  {
    if (c.e().a())
    {
      SparseArray localSparseArray = new SparseArray(10);
      localSparseArray.put(0, "user:" + z().e());
      localSparseArray.put(1, "ai:" + c());
      return localSparseArray;
    }
    return this.h;
  }
  
  public String y()
  {
    if (this.s.get() == null) {
      return null;
    }
    return b((Activity)this.s.get());
  }
  
  public static abstract interface ActivityStateListener
  {
    public abstract void a(Activity paramActivity);
    
    public abstract void a(android.app.Fragment paramFragment);
    
    public abstract void a(android.support.v4.app.Fragment paramFragment);
    
    public abstract void b(Activity paramActivity);
    
    public abstract void b(android.app.Fragment paramFragment);
    
    public abstract void b(android.support.v4.app.Fragment paramFragment);
    
    public abstract void c(Activity paramActivity);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/AppState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */