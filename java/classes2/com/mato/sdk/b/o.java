package com.mato.sdk.b;

import android.os.Build.VERSION;
import com.mato.sdk.g.f;
import com.mato.sdk.g.i;
import com.mato.sdk.proxy.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public final class o
  implements InvocationHandler
{
  private static o c = new o();
  private Object a;
  private boolean b = false;
  
  public static boolean a()
  {
    for (;;)
    {
      try
      {
        o localo = c;
        if ((Build.VERSION.SDK_INT >= 19) && (!localo.b))
        {
          localo.a = e.n();
          Class localClass = localo.a.getClass();
          Object localObject = i.a(localClass);
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            break label117;
          }
          i = 1;
          if (i != 0)
          {
            localObject = (Class[])((List)localObject).toArray(new Class[((List)localObject).size()]);
            localObject = Proxy.newProxyInstance(localClass.getClassLoader(), (Class[])localObject, localo);
            f.a(e.m(), "sProviderInstance", localObject);
            localo.b = true;
          }
          else
          {
            localObject = new Class[0];
            continue;
          }
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
      label117:
      int i = 0;
    }
  }
  
  private void b()
    throws Throwable
  {
    if (Build.VERSION.SDK_INT < 19) {}
    while (this.b) {
      return;
    }
    this.a = e.n();
    Class localClass = this.a.getClass();
    Object localObject = i.a(localClass);
    int i;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      i = 1;
      if (i == 0) {
        break label104;
      }
    }
    label104:
    for (localObject = (Class[])((List)localObject).toArray(new Class[((List)localObject).size()]);; localObject = new Class[0])
    {
      localObject = Proxy.newProxyInstance(localClass.getClassLoader(), (Class[])localObject, this);
      f.a(e.m(), "sProviderInstance", localObject);
      this.b = true;
      return;
      i = 0;
      break;
    }
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    paramObject = paramMethod.invoke(this.a, paramArrayOfObject);
    if (paramMethod.getName().contains("createWebView")) {
      a.b().f();
    }
    return paramObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */