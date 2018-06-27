package com.mato.sdk.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.Log;
import com.mato.sdk.b.g;
import com.mato.sdk.g.f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class n
{
  private static final String a = g.b("");
  private static int b = 193;
  
  public static void a(Context paramContext)
  {
    boolean bool = true;
    int i = Build.VERSION.SDK_INT;
    if (i >= 20) {}
    try
    {
      bool = d(paramContext, null, 0);
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder("webview reset proxy ");
      if (bool) {}
      for (paramContext = "success";; paramContext = "failure")
      {
        Log.i(str, paramContext);
        return;
        if (i >= 19)
        {
          bool = c(paramContext, null, 0);
          break;
        }
        if (i >= 14)
        {
          paramContext = Class.forName("android.webkit.WebViewCore");
          if (paramContext == null) {
            break label177;
          }
          paramContext = paramContext.getDeclaredMethod("sendStaticMessage", new Class[] { Integer.TYPE, Object.class });
          paramContext.setAccessible(true);
          paramContext.invoke(null, new Object[] { Integer.valueOf(193), null });
          break;
        }
        paramContext = c(paramContext);
        if (paramContext != null)
        {
          f.a(paramContext, "mProxyHost", null);
          break;
        }
        bool = false;
        break;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        bool = false;
        continue;
        label177:
        bool = false;
      }
    }
  }
  
  private static boolean a()
    throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
  {
    Object localObject = Class.forName("android.webkit.WebViewCore");
    if (localObject != null)
    {
      localObject = ((Class)localObject).getDeclaredMethod("sendStaticMessage", new Class[] { Integer.TYPE, Object.class });
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(null, new Object[] { Integer.valueOf(193), null });
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    boolean bool = true;
    int i = Build.VERSION.SDK_INT;
    if (i >= 20) {}
    try
    {
      bool = d(paramContext, paramString, paramInt);
      paramString = a;
      Object localObject = new StringBuilder("webview set proxy ");
      if (bool) {}
      for (paramContext = "success";; paramContext = "failure")
      {
        Log.i(paramString, paramContext);
        return bool;
        if (i >= 19)
        {
          bool = c(paramContext, paramString, paramInt);
          break;
        }
        if (i >= 14)
        {
          localObject = Class.forName("android.webkit.WebViewCore");
          paramContext = Class.forName("android.net.ProxyProperties");
          if ((localObject == null) || (paramContext == null)) {
            break label317;
          }
          localObject = ((Class)localObject).getDeclaredMethod("sendStaticMessage", new Class[] { Integer.TYPE, Object.class });
          paramContext = paramContext.getConstructor(new Class[] { String.class, Integer.TYPE, String.class });
          ((Method)localObject).setAccessible(true);
          paramContext.setAccessible(true);
          ((Method)localObject).invoke(null, new Object[] { Integer.valueOf(193), paramContext.newInstance(new Object[] { paramString, Integer.valueOf(paramInt), null }) });
          break;
        }
        paramContext = c(paramContext);
        if (paramContext != null)
        {
          localObject = Integer.TYPE;
          localObject = Class.forName("org.apache.http.HttpHost").getDeclaredConstructor(new Class[] { String.class, localObject, String.class });
          ((Constructor)localObject).setAccessible(true);
          f.a(paramContext, "mProxyHost", ((Constructor)localObject).newInstance(new Object[] { paramString, Integer.valueOf(paramInt), "http" }));
          break;
        }
        bool = false;
        break;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        bool = false;
        continue;
        label317:
        bool = false;
      }
    }
  }
  
  private static boolean a(String paramString, int paramInt)
    throws ClassNotFoundException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
  {
    Object localObject2 = Class.forName("android.webkit.WebViewCore");
    Object localObject1 = Class.forName("android.net.ProxyProperties");
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ((Class)localObject2).getDeclaredMethod("sendStaticMessage", new Class[] { Integer.TYPE, Object.class });
      localObject1 = ((Class)localObject1).getConstructor(new Class[] { String.class, Integer.TYPE, String.class });
      ((Method)localObject2).setAccessible(true);
      ((Constructor)localObject1).setAccessible(true);
      ((Method)localObject2).invoke(null, new Object[] { Integer.valueOf(193), ((Constructor)localObject1).newInstance(new Object[] { paramString, Integer.valueOf(paramInt), null }) });
      return true;
    }
    return false;
  }
  
  private static boolean b(Context paramContext)
    throws Exception
  {
    paramContext = c(paramContext);
    if (paramContext != null)
    {
      f.a(paramContext, "mProxyHost", null);
      return true;
    }
    return false;
  }
  
  private static boolean b(Context paramContext, String paramString, int paramInt)
    throws Exception
  {
    paramContext = c(paramContext);
    if (paramContext != null)
    {
      Object localObject = Integer.TYPE;
      localObject = Class.forName("org.apache.http.HttpHost").getDeclaredConstructor(new Class[] { String.class, localObject, String.class });
      ((Constructor)localObject).setAccessible(true);
      f.a(paramContext, "mProxyHost", ((Constructor)localObject).newInstance(new Object[] { paramString, Integer.valueOf(paramInt), "http" }));
      return true;
    }
    return false;
  }
  
  private static Object c(Context paramContext)
    throws Exception
  {
    Object localObject2 = null;
    Class localClass = Class.forName("android.webkit.Network");
    Object localObject1 = localObject2;
    if (localClass != null)
    {
      paramContext = f.a(localClass, "getInstance", new Object[] { paramContext }, new Class[] { Context.class });
      localObject1 = localObject2;
      if (paramContext != null) {
        localObject1 = f.b(paramContext, "mRequestQueue");
      }
    }
    return localObject1;
  }
  
  private static boolean c(Context paramContext, String paramString, int paramInt)
    throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
  {
    Object localObject1 = Class.forName("android.app.Application").getDeclaredField("mLoadedApk");
    ((Field)localObject1).setAccessible(true);
    localObject1 = ((Field)localObject1).get(paramContext);
    Object localObject2 = Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers");
    ((Field)localObject2).setAccessible(true);
    localObject2 = ((Map)((Field)localObject2).get(localObject1)).values().iterator();
    boolean bool = false;
    while (((Iterator)localObject2).hasNext())
    {
      Iterator localIterator = ((Map)((Iterator)localObject2).next()).keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        localObject1 = localObject3.getClass();
        Object localObject4 = ((Class)localObject1).getName();
        if (((String)localObject4).contains("ProxyChangeListener"))
        {
          Log.i(a, "found ProxyChangeListener: " + (String)localObject4);
          localObject4 = ((Class)localObject1).getDeclaredMethod("onReceive", new Class[] { Context.class, Intent.class });
          Intent localIntent = new Intent("android.intent.action.PROXY_CHANGE");
          Constructor localConstructor = Class.forName("android.net.ProxyProperties").getConstructor(new Class[] { String.class, Integer.TYPE, String.class });
          localConstructor.setAccessible(true);
          if (paramString != null) {}
          for (localObject1 = paramString;; localObject1 = "")
          {
            localIntent.putExtra("proxy", (Parcelable)localConstructor.newInstance(new Object[] { localObject1, Integer.valueOf(paramInt), null }));
            if (paramString != null) {
              d.2.a(paramString, paramInt);
            }
            ((Method)localObject4).invoke(localObject3, new Object[] { paramContext, localIntent });
            if (paramString != null) {
              d.2.b();
            }
            bool = true;
            break;
          }
        }
      }
    }
    return bool;
  }
  
  private static boolean d(Context paramContext)
    throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
  {
    return c(paramContext, null, 0);
  }
  
  private static boolean d(Context paramContext, String paramString, int paramInt)
    throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
  {
    Object localObject1 = Class.forName("android.app.Application").getDeclaredField("mLoadedApk");
    ((Field)localObject1).setAccessible(true);
    localObject1 = ((Field)localObject1).get(paramContext);
    Object localObject2 = Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers");
    ((Field)localObject2).setAccessible(true);
    localObject2 = ((Map)((Field)localObject2).get(localObject1)).values().iterator();
    boolean bool = false;
    while (((Iterator)localObject2).hasNext())
    {
      Iterator localIterator = ((Map)((Iterator)localObject2).next()).keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        localObject1 = localObject3.getClass();
        Object localObject4 = ((Class)localObject1).getName();
        if (((String)localObject4).contains("ProxyChangeListener"))
        {
          Log.i(a, "found ProxyChangeListener: " + (String)localObject4);
          localObject4 = ((Class)localObject1).getDeclaredMethod("onReceive", new Class[] { Context.class, Intent.class });
          Intent localIntent = new Intent("android.intent.action.PROXY_CHANGE");
          Class localClass = Class.forName("android.net.ProxyInfo");
          Method localMethod = localClass.getMethod("buildDirectProxy", new Class[] { String.class, Integer.TYPE });
          if (paramString != null) {}
          for (localObject1 = paramString;; localObject1 = "")
          {
            localIntent.putExtra("android.intent.extra.PROXY_INFO", (Parcelable)localMethod.invoke(localClass, new Object[] { localObject1, Integer.valueOf(paramInt) }));
            ((Method)localObject4).invoke(localObject3, new Object[] { paramContext, localIntent });
            bool = true;
            break;
          }
        }
      }
    }
    return bool;
  }
  
  private static boolean e(Context paramContext)
    throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
  {
    return d(paramContext, null, 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */