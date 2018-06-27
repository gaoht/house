package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class FieldInfo
  implements Comparable<FieldInfo>
{
  private final String[] alternateNames;
  public final Class<?> declaringClass;
  public final Field field;
  public final boolean fieldAccess;
  private final JSONField fieldAnnotation;
  public final Class<?> fieldClass;
  public final boolean fieldTransient;
  public final Type fieldType;
  public final String format;
  public final boolean getOnly;
  public final boolean isEnum;
  public final boolean jsonDirect;
  public final String label;
  public final Method method;
  private final JSONField methodAnnotation;
  public final String name;
  public final char[] name_chars;
  private int ordinal = 0;
  public final int parserFeatures;
  public final int serialzeFeatures;
  
  public FieldInfo(String paramString, Class<?> paramClass1, Class<?> paramClass2, Type paramType, Field paramField, int paramInt1, int paramInt2, int paramInt3)
  {
    this.name = paramString;
    this.declaringClass = paramClass1;
    this.fieldClass = paramClass2;
    this.fieldType = paramType;
    this.method = null;
    this.field = paramField;
    this.ordinal = paramInt1;
    this.serialzeFeatures = paramInt2;
    this.parserFeatures = 0;
    this.isEnum = paramClass2.isEnum();
    boolean bool;
    if (paramField != null)
    {
      paramInt1 = paramField.getModifiers();
      if (((paramInt1 & 0x1) != 0) || (this.method == null))
      {
        bool = true;
        this.fieldAccess = bool;
        this.fieldTransient = Modifier.isTransient(paramInt1);
      }
    }
    for (;;)
    {
      this.name_chars = genFieldNameChars();
      if (paramField != null) {
        TypeUtils.setAccessible(paramField);
      }
      this.label = "";
      this.fieldAnnotation = null;
      this.methodAnnotation = null;
      this.getOnly = false;
      this.jsonDirect = false;
      this.format = null;
      this.alternateNames = new String[0];
      return;
      bool = false;
      break;
      this.fieldTransient = false;
      this.fieldAccess = false;
    }
  }
  
  public FieldInfo(String paramString1, Method paramMethod, Field paramField, Class<?> paramClass, Type paramType, int paramInt1, int paramInt2, int paramInt3, JSONField paramJSONField1, JSONField paramJSONField2, String paramString2)
  {
    Object localObject = paramString1;
    if (paramField != null)
    {
      String str = paramField.getName();
      localObject = paramString1;
      if (str.equals(paramString1)) {
        localObject = str;
      }
    }
    this.name = ((String)localObject);
    this.method = paramMethod;
    this.field = paramField;
    this.ordinal = paramInt1;
    this.serialzeFeatures = paramInt2;
    this.parserFeatures = paramInt3;
    this.fieldAnnotation = paramJSONField1;
    this.methodAnnotation = paramJSONField2;
    label132:
    label138:
    label157:
    boolean bool2;
    if (paramField != null)
    {
      paramInt1 = paramField.getModifiers();
      if (((paramInt1 & 0x1) != 0) || (paramMethod == null))
      {
        bool1 = true;
        this.fieldAccess = bool1;
        if ((!Modifier.isTransient(paramInt1)) && (!TypeUtils.isTransient(paramMethod))) {
          break label369;
        }
        bool1 = true;
        this.fieldTransient = bool1;
        if ((paramString2 == null) || (paramString2.length() <= 0)) {
          break label388;
        }
        this.label = paramString2;
        paramString1 = null;
        paramJSONField2 = getAnnotation();
        if (paramJSONField2 == null) {
          break label397;
        }
        paramJSONField1 = paramJSONField2.format();
        paramString1 = paramJSONField1;
        if (paramJSONField1.trim().length() == 0) {
          paramString1 = null;
        }
        bool2 = paramJSONField2.jsonDirect();
        this.alternateNames = paramJSONField2.alternateNames();
        label215:
        this.format = paramString1;
        this.name_chars = genFieldNameChars();
        if (paramMethod != null) {
          TypeUtils.setAccessible(paramMethod);
        }
        if (paramField != null) {
          TypeUtils.setAccessible(paramField);
        }
        bool1 = false;
        if (paramMethod == null) {
          break label427;
        }
        paramString1 = paramMethod.getParameterTypes();
        if (paramString1.length != 1) {
          break label411;
        }
        paramString1 = paramString1[0];
        paramField = paramMethod.getGenericParameterTypes()[0];
        label273:
        this.declaringClass = paramMethod.getDeclaringClass();
        paramMethod = paramString1;
        label283:
        this.getOnly = bool1;
        if ((!bool2) || (paramMethod != String.class)) {
          break label459;
        }
      }
    }
    label369:
    label388:
    label397:
    label411:
    label427:
    label459:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jsonDirect = bool1;
      if ((paramClass == null) || (paramMethod != Object.class) || (!(paramField instanceof TypeVariable))) {
        break label465;
      }
      paramString1 = getInheritGenericType(paramClass, (TypeVariable)paramField);
      if (paramString1 == null) {
        break label465;
      }
      this.fieldClass = TypeUtils.getClass(paramString1);
      this.fieldType = paramString1;
      this.isEnum = paramMethod.isEnum();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label132;
      this.fieldAccess = false;
      this.fieldTransient = false;
      break label138;
      this.label = "";
      break label157;
      bool2 = false;
      this.alternateNames = new String[0];
      break label215;
      paramString1 = paramMethod.getReturnType();
      paramField = paramMethod.getGenericReturnType();
      bool1 = true;
      break label273;
      paramMethod = paramField.getType();
      paramString1 = paramField.getGenericType();
      this.declaringClass = paramField.getDeclaringClass();
      bool1 = Modifier.isFinal(paramField.getModifiers());
      paramField = paramString1;
      break label283;
    }
    label465:
    paramString1 = paramField;
    paramJSONField1 = paramMethod;
    if (!(paramField instanceof Class))
    {
      if (paramType == null) {
        break label530;
      }
      paramString1 = getFieldType(paramClass, paramType, paramField);
      if (paramString1 == paramField) {
        break label553;
      }
      if (!(paramString1 instanceof ParameterizedType)) {
        break label537;
      }
      paramJSONField1 = TypeUtils.getClass(paramString1);
    }
    for (;;)
    {
      this.fieldType = paramString1;
      this.fieldClass = paramJSONField1;
      this.isEnum = paramJSONField1.isEnum();
      return;
      label530:
      paramType = paramClass;
      break;
      label537:
      if ((paramString1 instanceof Class)) {
        paramJSONField1 = TypeUtils.getClass(paramString1);
      } else {
        label553:
        paramJSONField1 = paramMethod;
      }
    }
  }
  
  public static Type getFieldType(Class<?> paramClass, Type paramType1, Type paramType2)
  {
    Object localObject2 = null;
    if ((paramClass == null) || (paramType1 == null)) {}
    Object localObject1;
    int i;
    do
    {
      do
      {
        do
        {
          return paramType2;
          if (!(paramType2 instanceof GenericArrayType)) {
            break;
          }
          localObject1 = ((GenericArrayType)paramType2).getGenericComponentType();
          paramClass = getFieldType(paramClass, paramType1, (Type)localObject1);
        } while (localObject1 == paramClass);
        return Array.newInstance(TypeUtils.getClass(paramClass), 0).getClass();
      } while (!TypeUtils.isGenericParamType(paramType1));
      if ((paramType2 instanceof TypeVariable))
      {
        localObject1 = (ParameterizedType)TypeUtils.getGenericParamType(paramType1);
        localObject4 = TypeUtils.getClass((Type)localObject1);
        localObject3 = (TypeVariable)paramType2;
        localObject4 = ((Class)localObject4).getTypeParameters();
        i = 0;
        while (i < localObject4.length)
        {
          if (localObject4[i].getName().equals(((TypeVariable)localObject3).getName())) {
            return localObject1.getActualTypeArguments()[i];
          }
          i += 1;
        }
      }
    } while (!(paramType2 instanceof ParameterizedType));
    Object localObject3 = (ParameterizedType)paramType2;
    Object localObject4 = ((ParameterizedType)localObject3).getActualTypeArguments();
    if ((paramType1 instanceof ParameterizedType))
    {
      localObject1 = (ParameterizedType)paramType1;
      paramType1 = paramClass.getTypeParameters();
    }
    for (;;)
    {
      int j = 0;
      i = 0;
      paramClass = (Class<?>)localObject2;
      for (;;)
      {
        if ((j >= localObject4.length) || (localObject1 == null)) {
          break label363;
        }
        TypeVariable localTypeVariable = localObject4[j];
        localObject2 = paramClass;
        int m = i;
        if ((localTypeVariable instanceof TypeVariable))
        {
          localTypeVariable = (TypeVariable)localTypeVariable;
          int k = 0;
          for (;;)
          {
            localObject2 = paramClass;
            m = i;
            if (k >= paramType1.length) {
              break;
            }
            localObject2 = paramClass;
            if (paramType1[k].getName().equals(localTypeVariable.getName()))
            {
              localObject2 = paramClass;
              if (paramClass == null) {
                localObject2 = ((ParameterizedType)localObject1).getActualTypeArguments();
              }
              localObject4[j] = localObject2[k];
              i = 1;
            }
            k += 1;
            paramClass = (Class<?>)localObject2;
          }
          if (!(paramClass.getGenericSuperclass() instanceof ParameterizedType)) {
            break label391;
          }
          localObject1 = (ParameterizedType)paramClass.getGenericSuperclass();
          paramType1 = paramClass.getSuperclass().getTypeParameters();
          break;
        }
        j += 1;
        paramClass = (Class<?>)localObject2;
        i = m;
      }
      label363:
      if (i == 0) {
        break;
      }
      return new ParameterizedTypeImpl((Type[])localObject4, ((ParameterizedType)localObject3).getOwnerType(), ((ParameterizedType)localObject3).getRawType());
      label391:
      localObject1 = null;
      paramType1 = null;
    }
  }
  
  public static Type getInheritGenericType(Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Object localObject = paramTypeVariable.getGenericDeclaration();
    paramClass.getGenericSuperclass();
    Type localType1;
    label140:
    do
    {
      localType1 = paramClass.getGenericSuperclass();
      if (localType1 == null) {
        return null;
      }
      if ((localType1 instanceof ParameterizedType))
      {
        paramClass = (ParameterizedType)localType1;
        Type localType2 = paramClass.getRawType();
        int i;
        if ((localObject.equals(localType2)) || (((localObject instanceof Class)) && ((localType2 instanceof Class)) && (((Class)localObject).isAssignableFrom((Class)localType2))))
        {
          i = 1;
          if (i != 0)
          {
            localObject = ((GenericDeclaration)localObject).getTypeParameters();
            paramClass = paramClass.getActualTypeArguments();
            i = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (i >= localObject.length) {
              break label140;
            }
            if (paramTypeVariable.equals(localObject[i]))
            {
              return paramClass[i];
              i = 0;
              break;
            }
            i += 1;
          }
          return null;
        }
      }
      paramClass = TypeUtils.getClass(localType1);
    } while (localType1 != null);
    return null;
  }
  
  public boolean alternateName(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = this.alternateNames;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public int compareTo(FieldInfo paramFieldInfo)
  {
    int n = 0;
    int m = 1;
    int j;
    if (this.ordinal < paramFieldInfo.ordinal) {
      j = -1;
    }
    label190:
    do
    {
      do
      {
        Class localClass1;
        Class localClass2;
        do
        {
          do
          {
            return j;
            j = m;
          } while (this.ordinal > paramFieldInfo.ordinal);
          i = this.name.compareTo(paramFieldInfo.name);
          if (i != 0) {
            return i;
          }
          localClass1 = getDeclaredClass();
          localClass2 = paramFieldInfo.getDeclaredClass();
          if ((localClass1 == null) || (localClass2 == null) || (localClass1 == localClass2)) {
            break;
          }
          if (localClass1.isAssignableFrom(localClass2)) {
            return -1;
          }
          j = m;
        } while (localClass2.isAssignableFrom(localClass1));
        if ((this.field != null) && (this.field.getType() == this.fieldClass)) {}
        for (int i = 1;; i = 0)
        {
          int k = n;
          if (paramFieldInfo.field != null)
          {
            k = n;
            if (paramFieldInfo.field.getType() == paramFieldInfo.fieldClass) {
              k = 1;
            }
          }
          if (i != 0)
          {
            j = m;
            if (k == 0) {
              break;
            }
          }
          if ((k == 0) || (i != 0)) {
            break label190;
          }
          return -1;
        }
        if (!paramFieldInfo.fieldClass.isPrimitive()) {
          break;
        }
        j = m;
      } while (!this.fieldClass.isPrimitive());
      if ((this.fieldClass.isPrimitive()) && (!paramFieldInfo.fieldClass.isPrimitive())) {
        return -1;
      }
      if (!paramFieldInfo.fieldClass.getName().startsWith("java.")) {
        break;
      }
      j = m;
    } while (!this.fieldClass.getName().startsWith("java."));
    if ((this.fieldClass.getName().startsWith("java.")) && (!paramFieldInfo.fieldClass.getName().startsWith("java."))) {
      return -1;
    }
    return this.fieldClass.getName().compareTo(paramFieldInfo.fieldClass.getName());
  }
  
  protected char[] genFieldNameChars()
  {
    int i = this.name.length();
    char[] arrayOfChar = new char[i + 3];
    this.name.getChars(0, this.name.length(), arrayOfChar, 1);
    arrayOfChar[0] = '"';
    arrayOfChar[(i + 1)] = '"';
    arrayOfChar[(i + 2)] = ':';
    return arrayOfChar;
  }
  
  public Object get(Object paramObject)
    throws IllegalAccessException, InvocationTargetException
  {
    if (this.method != null) {
      return this.method.invoke(paramObject, new Object[0]);
    }
    return this.field.get(paramObject);
  }
  
  public <T extends Annotation> T getAnnation(Class<T> paramClass)
  {
    Object localObject;
    if (paramClass == JSONField.class) {
      localObject = getAnnotation();
    }
    do
    {
      Annotation localAnnotation;
      do
      {
        return (T)localObject;
        localAnnotation = null;
        if (this.method != null) {
          localAnnotation = this.method.getAnnotation(paramClass);
        }
        localObject = localAnnotation;
      } while (localAnnotation != null);
      localObject = localAnnotation;
    } while (this.field == null);
    return this.field.getAnnotation(paramClass);
  }
  
  public JSONField getAnnotation()
  {
    if (this.fieldAnnotation != null) {
      return this.fieldAnnotation;
    }
    return this.methodAnnotation;
  }
  
  protected Class<?> getDeclaredClass()
  {
    if (this.method != null) {
      return this.method.getDeclaringClass();
    }
    if (this.field != null) {
      return this.field.getDeclaringClass();
    }
    return null;
  }
  
  public String getFormat()
  {
    return this.format;
  }
  
  public Member getMember()
  {
    if (this.method != null) {
      return this.method;
    }
    return this.field;
  }
  
  public void set(Object paramObject1, Object paramObject2)
    throws IllegalAccessException, InvocationTargetException
  {
    if (this.method != null)
    {
      this.method.invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    this.field.set(paramObject1, paramObject2);
  }
  
  public void setAccessible()
    throws SecurityException
  {
    if (this.method != null)
    {
      TypeUtils.setAccessible(this.method);
      return;
    }
    TypeUtils.setAccessible(this.field);
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/util/FieldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */