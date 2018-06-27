package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class n
{
  private static Field a;
  private static boolean b;
  private static Class c;
  private static boolean d;
  private static Field e;
  private static boolean f;
  private static Field g;
  private static boolean h;
  
  static boolean a(Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return d(paramResources);
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return c(paramResources);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return b(paramResources);
    }
    return false;
  }
  
  private static boolean a(Object paramObject)
  {
    if (!d) {}
    try
    {
      c = Class.forName("android.content.res.ThemedResourceCache");
      d = true;
      if (c == null) {
        return false;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", localClassNotFoundException);
      }
      if (!f) {}
      try
      {
        e = c.getDeclaredField("mUnthemedEntries");
        e.setAccessible(true);
        f = true;
        if (e == null) {
          return false;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", localNoSuchFieldException);
        }
        try
        {
          paramObject = (LongSparseArray)e.get(paramObject);
          if (paramObject != null)
          {
            ((LongSparseArray)paramObject).clear();
            return true;
          }
        }
        catch (IllegalAccessException paramObject)
        {
          for (;;)
          {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", (Throwable)paramObject);
            paramObject = null;
          }
        }
      }
    }
    return false;
  }
  
  private static boolean b(Resources paramResources)
  {
    if (!b) {}
    try
    {
      a = Resources.class.getDeclaredField("mDrawableCache");
      a.setAccessible(true);
      b = true;
      if (a == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      try
      {
        paramResources = (Map)a.get(paramResources);
        if (paramResources != null)
        {
          paramResources.clear();
          return true;
          localNoSuchFieldException = localNoSuchFieldException;
          Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
        }
      }
      catch (IllegalAccessException paramResources)
      {
        for (;;)
        {
          Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", paramResources);
          paramResources = null;
        }
      }
    }
    return false;
  }
  
  private static boolean c(Resources paramResources)
  {
    boolean bool = true;
    if (!b) {}
    try
    {
      a = Resources.class.getDeclaredField("mDrawableCache");
      a.setAccessible(true);
      b = true;
      if (a == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          paramResources = a.get(paramResources);
          if (paramResources != null) {
            break;
          }
          return false;
        }
        catch (IllegalAccessException paramResources)
        {
          Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", paramResources);
        }
        localNoSuchFieldException = localNoSuchFieldException;
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
        continue;
        paramResources = null;
      }
      if (paramResources == null) {
        break label90;
      }
    }
    if (a(paramResources)) {}
    for (;;)
    {
      return bool;
      label90:
      bool = false;
    }
  }
  
  private static boolean d(Resources paramResources)
  {
    boolean bool = true;
    if (!h) {}
    for (;;)
    {
      try
      {
        g = Resources.class.getDeclaredField("mResourcesImpl");
        g.setAccessible(true);
        h = true;
        if (g == null) {
          return false;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", localNoSuchFieldException1);
        continue;
      }
      try
      {
        paramResources = g.get(paramResources);
        if (paramResources == null) {
          continue;
        }
        if (b) {}
      }
      catch (IllegalAccessException paramResources)
      {
        try
        {
          a = paramResources.getClass().getDeclaredField("mDrawableCache");
          a.setAccessible(true);
          b = true;
          if (a != null)
          {
            try
            {
              paramResources = a.get(paramResources);
              if ((paramResources == null) || (!a(paramResources))) {
                break label161;
              }
              return bool;
            }
            catch (IllegalAccessException paramResources)
            {
              Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", paramResources);
            }
            paramResources = paramResources;
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", paramResources);
            paramResources = null;
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException2)
        {
          for (;;)
          {
            Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", localNoSuchFieldException2);
            continue;
            paramResources = null;
            continue;
            label161:
            bool = false;
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */