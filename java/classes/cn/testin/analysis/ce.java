package cn.testin.analysis;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ce
  implements cd
{
  private final Context a;
  private final Map<String, Integer> b;
  private final SparseArray<String> c;
  
  protected ce(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HashMap();
    this.c = new SparseArray();
  }
  
  private static void a(Class<?> paramClass, String paramString, Map<String, Integer> paramMap)
  {
    for (;;)
    {
      int i;
      try
      {
        Field[] arrayOfField = paramClass.getFields();
        i = 0;
        if (i < arrayOfField.length)
        {
          Field localField = arrayOfField[i];
          if ((Modifier.isStatic(localField.getModifiers())) && (localField.getType() == Integer.TYPE))
          {
            String str = localField.getName();
            int j = localField.getInt(null);
            if (paramString == null)
            {
              paramMap.put(str, Integer.valueOf(j));
            }
            else
            {
              str = paramString + ":" + str;
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (IllegalAccessException paramString)
      {
        Log.e("ResourceReader", "Can't read built-in id names from " + paramClass.getName(), paramString);
      }
      i += 1;
    }
  }
  
  protected abstract Class<?> a();
  
  public String a(int paramInt)
  {
    return (String)this.c.get(paramInt);
  }
  
  protected abstract String a(Context paramContext);
  
  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public int b(String paramString)
  {
    return ((Integer)this.b.get(paramString)).intValue();
  }
  
  protected void b()
  {
    this.b.clear();
    this.c.clear();
    a(a(), "android", this.b);
    Object localObject = a(this.a);
    try
    {
      a(Class.forName((String)localObject), null, this.b);
      localObject = this.b.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        this.c.put(((Integer)localEntry.getValue()).intValue(), localEntry.getKey());
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Log.w("ResourceReader", "Can't load names for Android view ids from '" + (String)localObject + "', ids by name will not be available in the events editor.");
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */