package butterknife;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ButterKnife
{
  static final Map<Class<?>, Constructor<? extends Unbinder>> BINDINGS = new LinkedHashMap();
  private static final String TAG = "ButterKnife";
  private static boolean debug = false;
  
  private ButterKnife()
  {
    throw new AssertionError("No instances.");
  }
  
  @TargetApi(14)
  public static <T extends View, V> void apply(T paramT, Property<? super T, V> paramProperty, V paramV)
  {
    paramProperty.set(paramT, paramV);
  }
  
  public static <T extends View> void apply(T paramT, Action<? super T> paramAction)
  {
    paramAction.apply(paramT, 0);
  }
  
  public static <T extends View, V> void apply(T paramT, Setter<? super T, V> paramSetter, V paramV)
  {
    paramSetter.set(paramT, paramV, 0);
  }
  
  @SafeVarargs
  public static <T extends View> void apply(T paramT, Action<? super T>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].apply(paramT, 0);
      i += 1;
    }
  }
  
  @TargetApi(14)
  public static <T extends View, V> void apply(List<T> paramList, Property<? super T, V> paramProperty, V paramV)
  {
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      paramProperty.set(paramList.get(i), paramV);
      i += 1;
    }
  }
  
  public static <T extends View> void apply(List<T> paramList, Action<? super T> paramAction)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      paramAction.apply((View)paramList.get(i), i);
      i += 1;
    }
  }
  
  public static <T extends View, V> void apply(List<T> paramList, Setter<? super T, V> paramSetter, V paramV)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      paramSetter.set((View)paramList.get(i), paramV, i);
      i += 1;
    }
  }
  
  @SafeVarargs
  public static <T extends View> void apply(List<T> paramList, Action<? super T>... paramVarArgs)
  {
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      int m = paramVarArgs.length;
      int j = 0;
      while (j < m)
      {
        paramVarArgs[j].apply((View)paramList.get(i), i);
        j += 1;
      }
      i += 1;
    }
  }
  
  @TargetApi(14)
  public static <T extends View, V> void apply(T[] paramArrayOfT, Property<? super T, V> paramProperty, V paramV)
  {
    int i = 0;
    int j = paramArrayOfT.length;
    while (i < j)
    {
      paramProperty.set(paramArrayOfT[i], paramV);
      i += 1;
    }
  }
  
  public static <T extends View> void apply(T[] paramArrayOfT, Action<? super T> paramAction)
  {
    int i = 0;
    int j = paramArrayOfT.length;
    while (i < j)
    {
      paramAction.apply(paramArrayOfT[i], i);
      i += 1;
    }
  }
  
  public static <T extends View, V> void apply(T[] paramArrayOfT, Setter<? super T, V> paramSetter, V paramV)
  {
    int i = 0;
    int j = paramArrayOfT.length;
    while (i < j)
    {
      paramSetter.set(paramArrayOfT[i], paramV, i);
      i += 1;
    }
  }
  
  @SafeVarargs
  public static <T extends View> void apply(T[] paramArrayOfT, Action<? super T>... paramVarArgs)
  {
    int k = paramArrayOfT.length;
    int i = 0;
    while (i < k)
    {
      int m = paramVarArgs.length;
      int j = 0;
      while (j < m)
      {
        paramVarArgs[j].apply(paramArrayOfT[i], i);
        j += 1;
      }
      i += 1;
    }
  }
  
  public static Unbinder bind(Activity paramActivity)
  {
    return createBinding(paramActivity, paramActivity.getWindow().getDecorView());
  }
  
  public static Unbinder bind(Dialog paramDialog)
  {
    return createBinding(paramDialog, paramDialog.getWindow().getDecorView());
  }
  
  public static Unbinder bind(View paramView)
  {
    return createBinding(paramView, paramView);
  }
  
  public static Unbinder bind(Object paramObject, Activity paramActivity)
  {
    return createBinding(paramObject, paramActivity.getWindow().getDecorView());
  }
  
  public static Unbinder bind(Object paramObject, Dialog paramDialog)
  {
    return createBinding(paramObject, paramDialog.getWindow().getDecorView());
  }
  
  public static Unbinder bind(Object paramObject, View paramView)
  {
    return createBinding(paramObject, paramView);
  }
  
  private static Unbinder createBinding(Object paramObject, View paramView)
  {
    Object localObject = paramObject.getClass();
    if (debug) {
      Log.d("ButterKnife", "Looking up binding for " + ((Class)localObject).getName());
    }
    localObject = findBindingConstructorForClass((Class)localObject);
    if (localObject == null) {
      return Unbinder.EMPTY;
    }
    try
    {
      paramObject = (Unbinder)((Constructor)localObject).newInstance(new Object[] { paramObject, paramView });
      return (Unbinder)paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException("Unable to invoke " + localObject, (Throwable)paramObject);
    }
    catch (InstantiationException paramObject)
    {
      throw new RuntimeException("Unable to invoke " + localObject, (Throwable)paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      paramObject = ((InvocationTargetException)paramObject).getCause();
      if ((paramObject instanceof RuntimeException)) {
        throw ((RuntimeException)paramObject);
      }
      if ((paramObject instanceof Error)) {
        throw ((Error)paramObject);
      }
      throw new RuntimeException("Unable to create binding instance.", (Throwable)paramObject);
    }
  }
  
  private static Constructor<? extends Unbinder> findBindingConstructorForClass(Class<?> paramClass)
  {
    Object localObject = (Constructor)BINDINGS.get(paramClass);
    if (localObject != null)
    {
      if (debug) {
        Log.d("ButterKnife", "HIT: Cached in binding map.");
      }
      return (Constructor<? extends Unbinder>)localObject;
    }
    str = paramClass.getName();
    if ((str.startsWith("android.")) || (str.startsWith("java.")))
    {
      if (debug) {
        Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
      }
      return null;
    }
    try
    {
      Constructor localConstructor2 = Class.forName(str + "_ViewBinding").getConstructor(new Class[] { paramClass, View.class });
      localObject = localConstructor2;
      if (debug)
      {
        Log.d("ButterKnife", "HIT: Loaded binding class and constructor.");
        localObject = localConstructor2;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        if (debug) {
          Log.d("ButterKnife", "Not found. Trying superclass " + paramClass.getSuperclass().getName());
        }
        Constructor localConstructor1 = findBindingConstructorForClass(paramClass.getSuperclass());
      }
    }
    catch (NoSuchMethodException paramClass)
    {
      throw new RuntimeException("Unable to find binding constructor for " + str, paramClass);
    }
    BINDINGS.put(paramClass, localObject);
    return (Constructor<? extends Unbinder>)localObject;
  }
  
  public static <T extends View> T findById(Activity paramActivity, int paramInt)
  {
    return paramActivity.findViewById(paramInt);
  }
  
  public static <T extends View> T findById(Dialog paramDialog, int paramInt)
  {
    return paramDialog.findViewById(paramInt);
  }
  
  public static <T extends View> T findById(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public static void setDebug(boolean paramBoolean)
  {
    debug = paramBoolean;
  }
  
  public static abstract interface Action<T extends View>
  {
    public abstract void apply(T paramT, int paramInt);
  }
  
  public static abstract interface Setter<T extends View, V>
  {
    public abstract void set(T paramT, V paramV, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/butterknife/ButterKnife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */