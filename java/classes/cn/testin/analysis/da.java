package cn.testin.analysis;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class da
  extends cz
{
  protected Class<?> c;
  private Class<?> d;
  private Method e;
  private final String f = "CommonCaller";
  
  public da(Class<?> paramClass1, String paramString, Object[] paramArrayOfObject, Class<?> paramClass2)
  {
    super(paramString, paramArrayOfObject);
    this.d = paramClass2;
    this.e = b(paramClass1);
    if (this.e == null) {
      throw new NoSuchMethodException("Method " + paramClass1.getName() + "." + this.a + " doesn't exit");
    }
    this.c = this.e.getDeclaringClass();
  }
  
  private static Class<?> a(Class<?> paramClass)
  {
    Object localObject;
    if (paramClass == Byte.class) {
      localObject = Byte.TYPE;
    }
    do
    {
      return (Class<?>)localObject;
      if (paramClass == Short.class) {
        return Short.TYPE;
      }
      if (paramClass == Integer.class) {
        return Integer.TYPE;
      }
      if (paramClass == Long.class) {
        return Long.TYPE;
      }
      if (paramClass == Float.class) {
        return Float.TYPE;
      }
      if (paramClass == Double.class) {
        return Double.TYPE;
      }
      if (paramClass == Boolean.class) {
        return Boolean.TYPE;
      }
      localObject = paramClass;
    } while (paramClass != Character.class);
    return Character.TYPE;
  }
  
  private Method b(Class<?> paramClass)
  {
    Class[] arrayOfClass1 = new Class[this.b.length];
    int i = 0;
    while (i < this.b.length)
    {
      arrayOfClass1[i] = this.b[i].getClass();
      i += 1;
    }
    paramClass = paramClass.getMethods();
    int k = paramClass.length;
    i = 0;
    if (i < k)
    {
      Method localMethod = paramClass[i];
      Object localObject = localMethod.getName();
      Class[] arrayOfClass2 = localMethod.getParameterTypes();
      if ((!((String)localObject).equals(this.a)) || (arrayOfClass2.length != this.b.length)) {}
      boolean bool;
      do
      {
        do
        {
          i += 1;
          break;
        } while (!a(this.d).isAssignableFrom(a(localMethod.getReturnType())));
        bool = true;
        int j = 0;
        while ((j < arrayOfClass2.length) && (bool))
        {
          localObject = a(arrayOfClass1[j]);
          bool = a(arrayOfClass2[j]).isAssignableFrom((Class)localObject);
          j += 1;
        }
      } while (!bool);
      return localMethod;
    }
    return null;
  }
  
  public Object a(View paramView, Object... paramVarArgs)
  {
    Class localClass = paramView.getClass();
    if (this.c.isAssignableFrom(localClass)) {}
    try
    {
      paramView = this.e.invoke(paramView, paramVarArgs);
      return paramView;
    }
    catch (IllegalAccessException paramView)
    {
      Log.e("CommonCaller", "Method " + this.e.getName() + " appears not to be public", paramView);
      throw new df("Method " + this.e.getName() + "apply error");
    }
    catch (IllegalArgumentException paramView)
    {
      for (;;)
      {
        Log.e("CommonCaller", "Method " + this.e.getName() + " called with arguments of the wrong type", paramView);
      }
    }
    catch (InvocationTargetException paramView)
    {
      for (;;)
      {
        Log.e("CommonCaller", "Method " + this.e.getName() + " threw an exception", paramView);
      }
    }
  }
  
  public boolean a(Object... paramVarArgs)
  {
    Class[] arrayOfClass = this.e.getParameterTypes();
    if (paramVarArgs.length != arrayOfClass.length) {}
    int i;
    Class localClass;
    do
    {
      return false;
      i = 0;
      if (i >= paramVarArgs.length) {
        break label129;
      }
      localClass = a(arrayOfClass[i]);
      if (paramVarArgs[i] != null) {
        break;
      }
    } while ((localClass == Byte.TYPE) || (localClass == Short.TYPE) || (localClass == Integer.TYPE) || (localClass == Long.TYPE) || (localClass == Float.TYPE) || (localClass == Double.TYPE) || (localClass == Boolean.TYPE) || (localClass == Character.TYPE));
    while (localClass.isAssignableFrom(a(paramVarArgs[i].getClass())))
    {
      i += 1;
      break;
    }
    return false;
    label129:
    return true;
  }
  
  public Object b(View paramView)
  {
    try
    {
      paramView = a(paramView);
      return paramView;
    }
    catch (df paramView)
    {
      paramView.printStackTrace();
    }
    return null;
  }
  
  public void b(View paramView, Object... paramVarArgs)
  {
    a(paramView, paramVarArgs);
  }
  
  public String toString()
  {
    return "[CommonCaller " + this.a + "(" + this.b + ")]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */