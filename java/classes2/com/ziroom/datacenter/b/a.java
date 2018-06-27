package com.ziroom.datacenter.b;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class a
{
  private void a(Class paramClass, StringBuilder paramStringBuilder)
  {
    Object localObject1 = paramClass.getDeclaredFields();
    int j = localObject1.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        try
        {
          if ((Modifier.isFinal(((Field)localObject2).getModifiers())) || (((Field)localObject2).isAnnotationPresent(com.ziroom.datacenter.a.a.class))) {
            break label154;
          }
          ((Field)localObject2).setAccessible(true);
          Object localObject3 = ((Field)localObject2).get(this);
          paramStringBuilder.append(((Field)localObject2).getName() + " = " + localObject3 + ", ");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      localObject1 = a.class.getName();
      if (paramClass.getName().equals(localObject1)) {
        return;
      }
      a(paramClass.getSuperclass(), paramStringBuilder);
      return;
      label154:
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName() + " [ ");
    a(getClass(), localStringBuilder);
    localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    localStringBuilder.append(" ]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */