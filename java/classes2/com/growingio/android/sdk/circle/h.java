package com.growingio.android.sdk.circle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.utils.HttpService;
import com.growingio.android.sdk.utils.HttpService.Builder;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class h
{
  @SuppressLint({"StaticFieldLeak"})
  private static h a;
  private String b = this.e.getFilesDir().toString();
  private boolean c = false;
  private AsyncTask<Void, Integer, Void> d;
  private Context e = AppState.l().k();
  
  public static h a()
  {
    if (a == null) {
      a = new h();
    }
    return a;
  }
  
  @TargetApi(11)
  public void a(final String paramString)
  {
    if (this.d == null)
    {
      this.d = new AsyncTask()
      {
        private void b(File paramAnonymousFile, boolean paramAnonymousBoolean)
        {
          DexClassLoader localDexClassLoader = new DexClassLoader(paramAnonymousFile.toString(), h.a(h.this), null, Object.class.getClassLoader());
          try
          {
            h.a.a(localDexClassLoader.loadClass("com.growingio.android.sdk.java_websocket.WebCircleSocket"));
            h.a(h.this, true);
            a(new Integer[] { Integer.valueOf(100) });
            return;
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
            try
            {
              Log.i("GIO.ClassLoadTask", "loadPluginClasses: try to load built-in plugins");
              h.a.a(h.b(h.this).getClassLoader().loadClass("com.growingio.android.sdk.java_websocket.WebCircleSocket"));
              h.a(h.this, true);
              a(new Integer[] { Integer.valueOf(100) });
              return;
            }
            catch (Exception localException)
            {
              Log.i("GIO.ClassLoadTask", "loadPluginClasses: still failing");
              localException.printStackTrace();
            }
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException) {}finally
          {
            if (paramAnonymousBoolean) {
              a(paramAnonymousFile, true);
            }
          }
        }
        
        protected Void a(Void... paramAnonymousVarArgs)
        {
          paramAnonymousVarArgs = new File(h.a(h.this) + "/" + "vds_circle_plugin.zip");
          if (paramAnonymousVarArgs.exists()) {
            b(paramAnonymousVarArgs, true);
          }
          for (;;)
          {
            h.a(h.this, null);
            return null;
            ThreadUtils.b(new Runnable()
            {
              public void run()
              {
                Toast.makeText(h.b(h.this), "开始准备圈选", 1).show();
              }
            });
            a(paramAnonymousVarArgs, false);
          }
        }
        
        void a(File paramAnonymousFile, boolean paramAnonymousBoolean)
        {
          long l = GConfig.s().z();
          Object localObject = "https://assets.growingio.com/android/sdk/vds-plugin-v2.zip";
          if (!TextUtils.isEmpty(paramString)) {
            localObject = "https://assets.growingio.com/android/sdk/vds-plugin-v2.zip".replace("https://assets.growingio.com", paramString);
          }
          localObject = new HttpService.Builder().a((String)localObject);
          if (paramAnonymousBoolean) {
            ((HttpService.Builder)localObject).a(l);
          }
          localObject = ((HttpService.Builder)localObject).a();
          Pair localPair = ((HttpService)localObject).b();
          String str;
          if (((Integer)localPair.first).intValue() == 200) {
            str = paramAnonymousFile + ".download";
          }
          try
          {
            Util.a((byte[])localPair.second, str);
            if (new File(str).renameTo(paramAnonymousFile))
            {
              GConfig.s().a(((HttpService)localObject).c());
              if (!paramAnonymousBoolean) {
                b(paramAnonymousFile, false);
              }
            }
            return;
          }
          catch (IOException paramAnonymousFile)
          {
            paramAnonymousFile.printStackTrace();
          }
        }
        
        protected void a(Void paramAnonymousVoid)
        {
          if (!h.c(h.this)) {
            ThreadUtils.b(new Runnable()
            {
              public void run()
              {
                Toast.makeText(h.b(h.this), "下载圈选插件失败，请稍后重试", 1).show();
              }
            });
          }
        }
        
        protected void a(Integer... paramAnonymousVarArgs)
        {
          if (h.c(h.this))
          {
            h.a(h.this, null);
            ThreadUtils.b(new Runnable()
            {
              public void run()
              {
                LogUtil.d("GIO.ClassLoadTask", new Object[] { "PluginManager onProgressUpdate()-->launchCircle()" });
                c.e().o();
              }
            });
          }
        }
      };
      this.d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  static class a
  {
    static Constructor a;
    private static Method b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static Method f;
    private static Method g;
    private Object h;
    
    public a(String paramString1, String paramString2, Runnable paramRunnable1, Runnable paramRunnable2, Runnable paramRunnable3)
    {
      AppState localAppState = AppState.l();
      try
      {
        this.h = a.newInstance(new Object[] { paramString1, localAppState.b(), localAppState.c(), paramString2, paramRunnable1, paramRunnable2, paramRunnable3 });
        e.invoke(this.h, new Object[] { "1.1.2_dcb91e54", GConfig.sAppVersion });
        return;
      }
      catch (InvocationTargetException paramString1) {}catch (IllegalAccessException paramString1) {}catch (InstantiationException paramString1) {}
    }
    
    static void a(Class paramClass)
    {
      a = paramClass.getDeclaredConstructor(new Class[] { String.class, String.class, String.class, String.class, Runnable.class, Runnable.class, Runnable.class });
      a.setAccessible(true);
      b = paramClass.getDeclaredMethod("isInEditMode", new Class[0]);
      c = paramClass.getDeclaredMethod("isOpen", new Class[0]);
      d = paramClass.getDeclaredMethod("sendMessage", new Class[] { String.class });
      f = paramClass.getDeclaredMethod("start", new Class[0]);
      g = paramClass.getDeclaredMethod("stop", new Class[0]);
      e = paramClass.getDeclaredMethod("setVersionInfo", new Class[] { String.class, String.class });
    }
    
    public void a(String paramString)
    {
      try
      {
        if (GConfig.DEBUG) {
          Log.i("WebSocketProxy", "sendMessage: " + paramString);
        }
        d.invoke(this.h, new Object[] { paramString });
        return;
      }
      catch (InvocationTargetException paramString) {}catch (IllegalAccessException paramString) {}
    }
    
    public boolean a()
    {
      try
      {
        boolean bool = ((Boolean)c.invoke(this.h, new Object[0])).booleanValue();
        return bool;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;) {}
      }
    }
    
    public boolean b()
    {
      try
      {
        boolean bool = ((Boolean)b.invoke(this.h, new Object[0])).booleanValue();
        return bool;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;) {}
      }
    }
    
    public void c()
    {
      try
      {
        f.invoke(this.h, new Object[0]);
        return;
      }
      catch (InvocationTargetException localInvocationTargetException) {}catch (IllegalAccessException localIllegalAccessException) {}
    }
    
    public void d()
    {
      try
      {
        g.invoke(this.h, new Object[0]);
        return;
      }
      catch (InvocationTargetException localInvocationTargetException) {}catch (IllegalAccessException localIllegalAccessException) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */