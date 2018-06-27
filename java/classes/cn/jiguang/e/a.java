package cn.jiguang.e;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  private static Map<String, Field> a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "C\013o-[~\006fi\035z\026yy\035y\f~-_rCdxQ{";
    int i = -1;
    int j = 0;
    Object localObject3 = arrayOfString;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int m;
    int n;
    int i1;
    label42:
    Object localObject2;
    int i2;
    label91:
    label113:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      n = j;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 61;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label113;
          }
          m = k;
        }
      }
      i = k;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      k = i;
      m = j;
      if (i > j) {
        break label42;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject1 = "E\006lhOr\rih\035c\f*kTr\017n-\030dCc~\035v\016hdZb\f~\035e\006flI~\025o-IxC/~\0067\002*`\\c\000bdSpCldX{\007*hE~\020~~\035x\r*yJxCe\035z\fxh\035~\016zaXz\006dyXsCccIr\021ll^r\020$";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "C\013o-^{\002y~\035z\026yy\035y\f~-_rCdxQ{";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = "C\013o-[~\006fi\035y\002gh\035z\026yy\035y\f~-_rCha\\y\b%hPg\027s";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        a = new HashMap();
        return;
        i = 23;
        break label91;
        i = 99;
        break label91;
        i = 10;
        break label91;
        i = 13;
        break label91;
        m = 0;
        i2 = i;
        localObject2 = localObject1;
        i3 = j;
        localObject4 = localObject3;
        i = k;
        j = m;
      }
    }
  }
  
  public static Object a(Field paramField, Object paramObject)
  {
    boolean bool;
    if (paramField != null)
    {
      bool = true;
      e.a(bool, z[0], new Object[0]);
      if (paramField.isAccessible()) {
        break label42;
      }
      paramField.setAccessible(true);
    }
    for (;;)
    {
      return paramField.get(paramObject);
      bool = false;
      break;
      label42:
      b.a(paramField);
    }
  }
  
  public static Field a(Class<?> paramClass, String paramString)
  {
    return a(paramClass, paramString, true);
  }
  
  private static Field a(Class<?> arg0, String paramString, boolean paramBoolean)
  {
    if (??? != null) {
      paramBoolean = true;
    }
    String str;
    for (;;)
    {
      e.a(paramBoolean, z[2], new Object[0]);
      if (!TextUtils.isEmpty(paramString))
      {
        paramBoolean = true;
        e.a(paramBoolean, z[3], new Object[0]);
        ??? = new StringBuilder();
        ((StringBuilder)???).append(???.toString()).append("#").append(paramString);
        str = ((StringBuilder)???).toString();
      }
      synchronized (a)
      {
        ??? = (Field)a.get(str);
        if (??? != null)
        {
          if (!((Field)???).isAccessible()) {
            ((Field)???).setAccessible(true);
          }
          return (Field)???;
          paramBoolean = false;
          continue;
          paramBoolean = false;
        }
      }
    }
    ??? = ???;
    for (;;)
    {
      if (??? != null) {
        try
        {
          Field localField = ((Class)???).getDeclaredField(paramString);
          if (!Modifier.isPublic(localField.getModifiers())) {
            localField.setAccessible(true);
          }
          synchronized (a)
          {
            a.put(str, localField);
            return localField;
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException1)
        {
          ??? = ((Class)???).getSuperclass();
        }
      }
    }
    Iterator localIterator = d.a(???).iterator();
    ??? = null;
    for (;;)
    {
      Object localObject3;
      if (localIterator.hasNext()) {
        localObject3 = (Class)localIterator.next();
      }
      try
      {
        localObject3 = ((Class)localObject3).getField(paramString);
        if (??? == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          e.a(paramBoolean, z[1], new Object[] { paramString, ??? });
          ??? = localObject3;
          break;
        }
        synchronized (a)
        {
          a.put(str, ???);
          return (Field)???;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException2) {}
    }
  }
  
  public static void a(Field paramField, Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if (paramField != null)
    {
      bool = true;
      e.a(bool, z[0], new Object[0]);
      if (paramField.isAccessible()) {
        break label43;
      }
      paramField.setAccessible(true);
    }
    for (;;)
    {
      paramField.set(paramObject1, paramObject2);
      return;
      bool = false;
      break;
      label43:
      b.a(paramField);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */