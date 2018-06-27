package com.growingio.android.sdk.a;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.models.h;
import com.growingio.android.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
{
  public static g a = new g();
  private final Object b = new Object();
  private b c;
  private boolean d = false;
  private boolean e = false;
  private List<com.growingio.android.sdk.models.f> f = new ArrayList();
  
  public static g c()
  {
    return a;
  }
  
  public void a(b paramb)
  {
    this.c = paramb;
  }
  
  public boolean a()
  {
    LogUtil.d("GrowingIO.TagStore", new Object[] { "TagStore isTagsReady():" + this.d });
    return this.d;
  }
  
  public boolean b()
  {
    LogUtil.d("GrowingIO.TagStore", new Object[] { "TagStore isLoading():" + this.e });
    return this.e;
  }
  
  public List<com.growingio.android.sdk.models.f> d()
  {
    return this.f;
  }
  
  @TargetApi(11)
  public void e()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    new a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  public List<com.growingio.android.sdk.models.f> f()
  {
    ArrayList localArrayList = new ArrayList();
    String str = AppState.l().b() + "::";
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      com.growingio.android.sdk.models.f localf = (com.growingio.android.sdk.models.f)localIterator.next();
      if (localf.f.d.startsWith(str))
      {
        localf = localf.a();
        int i = str.length();
        localf.f.d = localf.f.d.substring(i);
        if ((!TextUtils.isEmpty(localf.g.d)) && (localf.g.d.length() >= i)) {
          localf.g.d = localf.g.d.substring(i);
        }
        i = localf.f.b.indexOf("::");
        if (i > 0)
        {
          i += "::".length();
          localf.f.b = localf.f.b.substring(i);
          if ((!TextUtils.isEmpty(localf.g.b)) && (localf.g.b.length() > i)) {
            localf.g.b = localf.g.b.substring(i);
          }
        }
        if (!TextUtils.isEmpty(localf.f.a))
        {
          i = localf.f.a.indexOf("::") + "::".length();
          if (i > 0)
          {
            localf.f.a = localf.f.a.substring(i);
            if ((!TextUtils.isEmpty(localf.g.a)) && (localf.g.a.length() > i)) {
              localf.g.a = localf.g.a.substring(i);
            }
          }
        }
        localArrayList.add(localf);
      }
    }
    return localArrayList;
  }
  
  class a
    extends AsyncTask<Void, Void, List<com.growingio.android.sdk.models.f>>
  {
    a() {}
    
    protected List<com.growingio.android.sdk.models.f> a(Void... paramVarArgs)
    {
      LogUtil.d("GrowingIO.TagStore", new Object[] { "FetchTagsTask() -> doInBackground() 开始加载tag" });
      paramVarArgs = new f().b();
      LogUtil.i("GrowingIO.TagStore", "doInBackground ... tags " + paramVarArgs);
      return paramVarArgs;
    }
    
    protected void a(List<com.growingio.android.sdk.models.f> paramList)
    {
      super.onPostExecute(paramList);
      g.a(g.this).clear();
      g.a(g.this).addAll(paramList);
      g.a(g.this, true);
      g.b(g.this, false);
      LogUtil.d("GrowingIO.TagStore", new Object[] { "FetchTagsTask() -> onPostExecute tag加载完成" });
      if (g.b(g.this) != null)
      {
        LogUtil.d("GrowingIO.TagStore", new Object[] { "FetchTagsTask() -> onPostExecute  initSuccess()" });
        g.b(g.this).a();
        g.a(g.this, null);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */