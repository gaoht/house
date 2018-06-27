package android.support.v7.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.g;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class b
{
  private static final ThreadLocal<TypedValue> a = new ThreadLocal();
  private static final WeakHashMap<Context, SparseArray<a>> b = new WeakHashMap(0);
  private static final Object c = new Object();
  
  private static ColorStateList a(Context paramContext, int paramInt)
  {
    if (c(paramContext, paramInt)) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    XmlResourceParser localXmlResourceParser = localResources.getXml(paramInt);
    try
    {
      paramContext = a.createFromXml(localResources, localXmlResourceParser, paramContext.getTheme());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", paramContext);
    }
    return null;
  }
  
  private static TypedValue a()
  {
    TypedValue localTypedValue2 = (TypedValue)a.get();
    TypedValue localTypedValue1 = localTypedValue2;
    if (localTypedValue2 == null)
    {
      localTypedValue1 = new TypedValue();
      a.set(localTypedValue1);
    }
    return localTypedValue1;
  }
  
  private static void a(Context paramContext, int paramInt, ColorStateList paramColorStateList)
  {
    synchronized (c)
    {
      SparseArray localSparseArray2 = (SparseArray)b.get(paramContext);
      SparseArray localSparseArray1 = localSparseArray2;
      if (localSparseArray2 == null)
      {
        localSparseArray1 = new SparseArray();
        b.put(paramContext, localSparseArray1);
      }
      localSparseArray1.append(paramInt, new a(paramColorStateList, paramContext.getResources().getConfiguration()));
      return;
    }
  }
  
  private static ColorStateList b(Context paramContext, int paramInt)
  {
    synchronized (c)
    {
      SparseArray localSparseArray = (SparseArray)b.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        a locala = (a)localSparseArray.get(paramInt);
        if (locala != null)
        {
          if (locala.b.equals(paramContext.getResources().getConfiguration()))
          {
            paramContext = locala.a;
            return paramContext;
          }
          localSparseArray.remove(paramInt);
        }
      }
      return null;
    }
  }
  
  private static boolean c(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    TypedValue localTypedValue = a();
    paramContext.getValue(paramInt, localTypedValue, true);
    return (localTypedValue.type >= 28) && (localTypedValue.type <= 31);
  }
  
  public static ColorStateList getColorStateList(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      localObject = paramContext.getColorStateList(paramInt);
    }
    ColorStateList localColorStateList;
    do
    {
      return (ColorStateList)localObject;
      localColorStateList = b(paramContext, paramInt);
      localObject = localColorStateList;
    } while (localColorStateList != null);
    Object localObject = a(paramContext, paramInt);
    if (localObject != null)
    {
      a(paramContext, paramInt, (ColorStateList)localObject);
      return (ColorStateList)localObject;
    }
    return ContextCompat.getColorStateList(paramContext, paramInt);
  }
  
  public static Drawable getDrawable(Context paramContext, int paramInt)
  {
    return g.get().getDrawable(paramContext, paramInt);
  }
  
  private static class a
  {
    final ColorStateList a;
    final Configuration b;
    
    a(ColorStateList paramColorStateList, Configuration paramConfiguration)
    {
      this.a = paramColorStateList;
      this.b = paramConfiguration;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */