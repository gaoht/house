package com.mob.tools.utils;

import android.text.TextUtils;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class Hashon
{
  private ArrayList<?> arrayToList(Object paramObject)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i = 0;
    ArrayList localArrayList;
    Object localObject;
    if ((paramObject instanceof byte[]))
    {
      localArrayList = new ArrayList();
      localObject = (byte[])paramObject;
      j = localObject.length;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Byte.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof short[]))
    {
      localArrayList = new ArrayList();
      localObject = (short[])paramObject;
      k = localObject.length;
      i = j;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= k) {
          break;
        }
        localArrayList.add(Short.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof int[]))
    {
      localArrayList = new ArrayList();
      localObject = (int[])paramObject;
      j = localObject.length;
      i = k;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Integer.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof long[]))
    {
      localArrayList = new ArrayList();
      localObject = (long[])paramObject;
      j = localObject.length;
      i = m;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Long.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof float[]))
    {
      localArrayList = new ArrayList();
      localObject = (float[])paramObject;
      j = localObject.length;
      i = n;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Float.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof double[]))
    {
      localArrayList = new ArrayList();
      localObject = (double[])paramObject;
      j = localObject.length;
      i = i1;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Double.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof char[]))
    {
      localArrayList = new ArrayList();
      localObject = (char[])paramObject;
      j = localObject.length;
      i = i2;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Character.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof boolean[]))
    {
      localArrayList = new ArrayList();
      localObject = (boolean[])paramObject;
      j = localObject.length;
      i = i3;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Boolean.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof String[]))
    {
      paramObject = new ArrayList(Arrays.asList((String[])paramObject));
      return (ArrayList<?>)paramObject;
    }
    return null;
  }
  
  private String format(String paramString, ArrayList<Object> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[\n");
    String str = paramString + "\t";
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    if (paramArrayList.hasNext())
    {
      Object localObject = paramArrayList.next();
      if (i > 0) {
        localStringBuilder.append(",\n");
      }
      localStringBuilder.append(str);
      if ((localObject instanceof HashMap)) {
        localStringBuilder.append(format(str, (HashMap)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof ArrayList)) {
          localStringBuilder.append(format(str, (ArrayList)localObject));
        } else if ((localObject instanceof String)) {
          localStringBuilder.append('"').append(localObject).append('"');
        } else {
          localStringBuilder.append(localObject);
        }
      }
    }
    localStringBuilder.append('\n').append(paramString).append(']');
    return localStringBuilder.toString();
  }
  
  private String format(String paramString, HashMap<String, Object> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    String str = paramString + "\t";
    paramHashMap = paramHashMap.entrySet().iterator();
    int i = 0;
    if (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      if (i > 0) {
        localStringBuilder.append(",\n");
      }
      localStringBuilder.append(str).append('"').append((String)((Map.Entry)localObject).getKey()).append("\":");
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject instanceof HashMap)) {
        localStringBuilder.append(format(str, (HashMap)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof ArrayList)) {
          localStringBuilder.append(format(str, (ArrayList)localObject));
        } else if ((localObject instanceof String)) {
          localStringBuilder.append('"').append(localObject).append('"');
        } else {
          localStringBuilder.append(localObject);
        }
      }
    }
    localStringBuilder.append('\n').append(paramString).append('}');
    return localStringBuilder.toString();
  }
  
  private ArrayList<Object> fromJson(JSONArray paramJSONArray)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONArray.length();
    int i = 0;
    if (i < j)
    {
      Object localObject2 = paramJSONArray.opt(i);
      Object localObject1;
      if ((localObject2 instanceof JSONObject)) {
        localObject1 = fromJson((JSONObject)localObject2);
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONArray)) {
          localObject1 = fromJson((JSONArray)localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  private <T> HashMap<String, T> fromJson(JSONObject paramJSONObject)
    throws Throwable
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramJSONObject.opt(str);
      Object localObject1 = localObject2;
      if (JSONObject.NULL.equals(localObject2)) {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        if ((localObject1 instanceof JSONObject)) {
          localObject2 = fromJson((JSONObject)localObject1);
        }
        for (;;)
        {
          localHashMap.put(str, localObject2);
          break;
          localObject2 = localObject1;
          if ((localObject1 instanceof JSONArray)) {
            localObject2 = fromJson((JSONArray)localObject1);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private JSONArray getJSONArray(ArrayList<Object> paramArrayList)
    throws Throwable
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof HashMap)) {
        paramArrayList = getJSONObject((HashMap)localObject);
      }
      for (;;)
      {
        localJSONArray.put(paramArrayList);
        break;
        paramArrayList = (ArrayList<Object>)localObject;
        if ((localObject instanceof ArrayList)) {
          paramArrayList = getJSONArray((ArrayList)localObject);
        }
      }
    }
    return localJSONArray;
  }
  
  private <T> JSONObject getJSONObject(HashMap<String, T> paramHashMap)
    throws Throwable
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof HashMap)) {
        paramHashMap = getJSONObject((HashMap)localObject);
      }
      for (;;)
      {
        localJSONObject.put((String)localEntry.getKey(), paramHashMap);
        break;
        if ((localObject instanceof ArrayList))
        {
          paramHashMap = getJSONArray((ArrayList)localObject);
        }
        else
        {
          paramHashMap = (HashMap<String, T>)localObject;
          if (isBasicArray(localObject)) {
            paramHashMap = getJSONArray(arrayToList(localObject));
          }
        }
      }
    }
    return localJSONObject;
  }
  
  private boolean isBasicArray(Object paramObject)
  {
    return ((paramObject instanceof byte[])) || ((paramObject instanceof short[])) || ((paramObject instanceof int[])) || ((paramObject instanceof long[])) || ((paramObject instanceof float[])) || ((paramObject instanceof double[])) || ((paramObject instanceof char[])) || ((paramObject instanceof boolean[])) || ((paramObject instanceof String[]));
  }
  
  private Object tabulate(Object paramObject)
    throws Throwable
  {
    int i = 0;
    if ((paramObject == null) || (paramObject.getClass().isPrimitive()) || ((paramObject instanceof String)) || ((paramObject instanceof Number)) || ((paramObject instanceof Character)) || ((paramObject instanceof Boolean))) {
      return paramObject;
    }
    if ((paramObject instanceof TabulateAdapter)) {
      return tabulate(((TabulateAdapter)paramObject).tabulate());
    }
    if ((paramObject instanceof Enum))
    {
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("enum", ((Enum)paramObject).name());
      return localObject1;
    }
    int j;
    if (paramObject.getClass().isArray())
    {
      localObject1 = new ArrayList();
      j = Array.getLength(paramObject);
      while (i < j)
      {
        ((ArrayList)localObject1).add(tabulate(Array.get(paramObject, i)));
        i += 1;
      }
      return localObject1;
    }
    if ((paramObject instanceof Collection))
    {
      localObject1 = new ArrayList();
      paramObject = ((Collection)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        ((ArrayList)localObject1).add(tabulate(((Iterator)paramObject).next()));
      }
      return localObject1;
    }
    Object localObject3;
    if ((paramObject instanceof Map))
    {
      localObject1 = new HashMap();
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (((Iterator)paramObject).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)paramObject).next();
        localObject2 = ((Map.Entry)localObject3).getKey();
        if ((localObject2 instanceof String))
        {
          localObject3 = ((Map.Entry)localObject3).getValue();
          ((HashMap)localObject1).put((String)localObject2, tabulate(localObject3));
        }
      }
      return localObject1;
    }
    Object localObject1 = paramObject.getClass();
    Object localObject2 = new ArrayList();
    while (!localObject1.equals(Object.class))
    {
      ((ArrayList)localObject2).add(0, localObject1);
      localObject1 = ((Class)localObject1).getSuperclass();
    }
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Class)((Iterator)localObject2).next()).getDeclaredFields();
      j = localObject3.length;
      i = 0;
      while (i < j)
      {
        localObject4 = localObject3[i];
        if ((!Modifier.isStatic(((Field)localObject4).getModifiers())) && (!((Field)localObject4).getName().contains("$"))) {
          ((ArrayList)localObject1).add(localObject4);
        }
        i += 1;
      }
    }
    localObject2 = new HashMap();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Field)((Iterator)localObject1).next();
      ((Field)localObject3).setAccessible(true);
      localObject4 = ((Field)localObject3).get(paramObject);
      ((HashMap)localObject2).put(((Field)localObject3).getName(), tabulate(localObject4));
    }
    return localObject2;
  }
  
  private <T> T tabulate(Object paramObject, Class<T> paramClass, Type[] paramArrayOfType)
    throws Throwable
  {
    int j = 0;
    int i = 0;
    if ((paramClass.isPrimitive()) || (Number.class.isAssignableFrom(paramClass)) || (paramClass.equals(Character.class)))
    {
      if (paramClass.equals(Boolean.TYPE)) {
        return (T)paramObject;
      }
      if ((paramClass.equals(Character.TYPE)) || (paramClass.equals(Character.class))) {
        return Character.valueOf(String.valueOf(paramObject).charAt(0));
      }
      if ((paramClass.equals(Byte.TYPE)) || (paramClass.equals(Byte.class))) {
        return Byte.valueOf(String.valueOf(paramObject));
      }
      if ((paramClass.equals(Short.TYPE)) || (paramClass.equals(Short.class))) {
        return Short.valueOf(String.valueOf(paramObject));
      }
      if ((paramClass.equals(Integer.TYPE)) || (paramClass.equals(Integer.class))) {
        return Integer.valueOf(String.valueOf(paramObject));
      }
      if ((paramClass.equals(Long.TYPE)) || (paramClass.equals(Long.class))) {
        return Long.valueOf(String.valueOf(paramObject));
      }
      if ((paramClass.equals(Float.TYPE)) || (paramClass.equals(Float.class))) {
        return Float.valueOf(String.valueOf(paramObject));
      }
      return Double.valueOf(String.valueOf(paramObject));
    }
    if (TabulateAdapter.class.isAssignableFrom(paramClass)) {
      try
      {
        paramObject = ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(paramClass.getName()), "valueOf", new Object[] { paramObject });
        return (T)paramObject;
      }
      catch (Throwable paramObject)
      {
        return null;
      }
    }
    if ((paramClass.equals(String.class)) || (paramClass.equals(Boolean.class))) {
      return (T)paramObject;
    }
    if (paramClass.isEnum()) {
      return Enum.valueOf(paramClass, String.valueOf(((HashMap)paramObject).get("enum")));
    }
    Object localObject1;
    if (paramClass.isArray())
    {
      paramArrayOfType = (ArrayList)paramObject;
      localObject1 = paramClass.getComponentType();
      paramClass = Array.newInstance((Class)localObject1, paramArrayOfType.size());
      j = paramArrayOfType.size();
      for (;;)
      {
        paramObject = paramClass;
        if (i >= j) {
          break;
        }
        Array.set(paramClass, i, tabulate(paramArrayOfType.get(i), (Class)localObject1, null));
        i += 1;
      }
    }
    if (Collection.class.isAssignableFrom(paramClass))
    {
      localObject1 = (Collection)paramClass.newInstance();
      if ((paramArrayOfType == null) || (paramArrayOfType.length <= 0)) {
        break label1117;
      }
    }
    label666:
    label768:
    label935:
    label1104:
    label1109:
    label1117:
    for (paramClass = paramArrayOfType[0];; paramClass = null)
    {
      paramArrayOfType = (ArrayList)paramObject;
      int k = paramArrayOfType.size();
      i = j;
      paramObject = localObject1;
      if (i >= k) {
        break;
      }
      if ((paramClass != null) && ((paramClass instanceof Class)) && (!paramClass.equals(Object.class))) {
        ((Collection)localObject1).add(tabulate(paramArrayOfType.get(i), (Class)paramClass, null));
      }
      Object localObject2;
      for (;;)
      {
        i += 1;
        break;
        if ((paramClass != null) && ((paramClass instanceof ParameterizedType)))
        {
          localObject2 = (ParameterizedType)paramClass;
          paramObject = ((ParameterizedType)localObject2).getActualTypeArguments();
          localObject2 = (Class)((ParameterizedType)localObject2).getRawType();
          ((Collection)localObject1).add(tabulate(paramArrayOfType.get(i), (Class)localObject2, (Type[])paramObject));
        }
        else
        {
          ((Collection)localObject1).add(paramArrayOfType.get(i));
        }
      }
      if (Map.class.isAssignableFrom(paramClass))
      {
        localObject2 = (Map)paramClass.newInstance();
        if ((paramArrayOfType == null) || (paramArrayOfType.length <= 1)) {
          break label1109;
        }
        paramClass = paramArrayOfType[0];
        localObject1 = paramArrayOfType[1];
      }
      for (paramArrayOfType = paramClass;; paramArrayOfType = null)
      {
        Object localObject3 = (HashMap)paramObject;
        Object localObject4 = ((HashMap)localObject3).keySet().iterator();
        paramObject = localObject2;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        paramClass = ((Iterator)localObject4).next();
        if ((paramArrayOfType != null) && ((paramArrayOfType instanceof Class)) && (!localObject1.equals(Object.class)))
        {
          paramObject = tabulate(paramClass, (Class)paramArrayOfType, null);
          if ((localObject1 == null) || (!(localObject1 instanceof Class)) || (localObject1.equals(Object.class))) {
            break label768;
          }
          paramClass = tabulate(((HashMap)localObject3).get(paramClass), (Class)localObject1, null);
        }
        Object localObject5;
        for (;;)
        {
          ((Map)localObject2).put(paramObject, paramClass);
          break;
          if ((paramArrayOfType != null) && ((paramArrayOfType instanceof ParameterizedType)))
          {
            paramObject = (ParameterizedType)paramArrayOfType;
            localObject5 = ((ParameterizedType)paramObject).getActualTypeArguments();
            paramObject = tabulate(paramClass, (Class)((ParameterizedType)paramObject).getRawType(), (Type[])localObject5);
            break label666;
          }
          paramObject = paramClass;
          break label666;
          if ((localObject1 != null) && ((localObject1 instanceof ParameterizedType)))
          {
            Object localObject6 = (ParameterizedType)localObject1;
            localObject5 = ((ParameterizedType)localObject6).getActualTypeArguments();
            localObject6 = (Class)((ParameterizedType)localObject6).getRawType();
            paramClass = tabulate(((HashMap)localObject3).get(paramClass), (Class)localObject6, (Type[])localObject5);
          }
          else
          {
            paramClass = ((HashMap)localObject3).get(paramClass);
          }
        }
        localObject2 = new ArrayList();
        for (paramArrayOfType = paramClass; !paramArrayOfType.equals(Object.class); paramArrayOfType = paramArrayOfType.getSuperclass()) {
          ((ArrayList)localObject2).add(paramArrayOfType);
        }
        paramArrayOfType = (HashMap)paramObject;
        localObject1 = new HashMap();
        localObject3 = paramArrayOfType.keySet().iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            if (paramArrayOfType.get(localObject4) == null) {
              continue;
            }
            localObject5 = ((ArrayList)localObject2).iterator();
            if (!((Iterator)localObject5).hasNext()) {
              continue;
            }
            paramObject = (Class)((Iterator)localObject5).next();
            try
            {
              paramObject = ((Class)paramObject).getDeclaredField((String)localObject4);
              if (paramObject == null) {
                break label935;
              }
              ((HashMap)localObject1).put(localObject4, paramObject);
            }
            catch (Throwable paramObject)
            {
              for (;;)
              {
                paramObject = null;
              }
            }
          }
        }
        paramClass = ReflectHelper.newInstance(ReflectHelper.getName(paramClass), new Object[0]);
        localObject2 = ((HashMap)localObject1).keySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          paramObject = (String)((Iterator)localObject2).next();
          localObject3 = paramArrayOfType.get(paramObject);
          localObject4 = (Field)((HashMap)localObject1).get(paramObject);
          localObject5 = ((Field)localObject4).getType();
          paramObject = ((Field)localObject4).getGenericType();
          if (!(paramObject instanceof ParameterizedType)) {
            break label1104;
          }
        }
        for (paramObject = ((ParameterizedType)paramObject).getActualTypeArguments();; paramObject = null)
        {
          ((Field)localObject4).setAccessible(true);
          ((Field)localObject4).set(paramClass, tabulate(localObject3, (Class)localObject5, (Type[])paramObject));
          break;
          return paramClass;
        }
        localObject1 = null;
      }
    }
  }
  
  public String format(String paramString)
  {
    try
    {
      paramString = format("", fromJson(paramString));
      return paramString;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return "";
  }
  
  public <T> String fromHashMap(HashMap<String, T> paramHashMap)
  {
    try
    {
      paramHashMap = getJSONObject(paramHashMap);
      if (paramHashMap == null) {
        return "";
      }
      paramHashMap = paramHashMap.toString();
      return paramHashMap;
    }
    catch (Throwable paramHashMap)
    {
      MobLog.getInstance().w(paramHashMap);
    }
    return "";
  }
  
  public <T> T fromJson(String paramString, Class<T> paramClass)
  {
    Object localObject = fromJson(paramString);
    if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {}
    for (paramString = ((HashMap)localObject).get("fakelist");; paramString = (String)localObject) {
      for (;;)
      {
        try
        {
          localObject = paramClass.getGenericSuperclass();
          if ((localObject instanceof ParameterizedType))
          {
            localObject = ((ParameterizedType)localObject).getActualTypeArguments();
            paramString = tabulate(paramString, paramClass, (Type[])localObject);
            return paramString;
          }
        }
        catch (Throwable paramString)
        {
          MobLog.getInstance().w(paramString);
          return null;
        }
        localObject = null;
      }
    }
  }
  
  public <T> HashMap<String, T> fromJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new HashMap();
    }
    String str1 = paramString;
    String str2 = paramString;
    try
    {
      if (paramString.startsWith("["))
      {
        str1 = paramString;
        str2 = paramString;
        if (paramString.endsWith("]"))
        {
          str2 = paramString;
          str1 = "{\"fakelist\":" + paramString + "}";
        }
      }
      str2 = str1;
      paramString = fromJson(new JSONObject(str1));
      return paramString;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(str2);
      MobLog.getInstance().w(paramString);
    }
    return new HashMap();
  }
  
  public String fromObject(Object paramObject)
  {
    HashMap localHashMap = null;
    try
    {
      paramObject = tabulate(paramObject);
      if (paramObject == null) {
        return "";
      }
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        MobLog.getInstance().w((Throwable)paramObject);
        paramObject = localHashMap;
      }
      if ((paramObject instanceof ArrayList))
      {
        localHashMap = new HashMap();
        localHashMap.put("list", paramObject);
        paramObject = fromHashMap(localHashMap);
        return ((String)paramObject).substring("{\"list\":".length(), ((String)paramObject).length() - 1).trim();
      }
    }
    return fromHashMap((HashMap)paramObject);
  }
  
  public static abstract interface TabulateAdapter
  {
    public abstract Object tabulate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/Hashon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */