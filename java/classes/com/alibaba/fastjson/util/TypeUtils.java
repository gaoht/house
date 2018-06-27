package com.alibaba.fastjson.util;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.e;
import com.alibaba.fastjson.l;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TypeUtils
{
  public static boolean compatibleWithFieldName;
  public static boolean compatibleWithJavaBean = false;
  private static ConcurrentMap<String, Class<?>> mappings;
  private static Class<?> optionalClass;
  private static boolean optionalClassInited;
  private static Method oracleDateMethod;
  private static boolean oracleDateMethodInited;
  private static Method oracleTimestampMethod;
  private static boolean oracleTimestampMethodInited;
  private static Class<?> pathClass;
  private static boolean pathClass_error = false;
  private static boolean setAccessibleEnable;
  private static Class<? extends Annotation> transientClass;
  private static boolean transientClassInited;
  
  static
  {
    compatibleWithFieldName = false;
    setAccessibleEnable = true;
    oracleTimestampMethodInited = false;
    oracleDateMethodInited = false;
    optionalClassInited = false;
    transientClassInited = false;
    mappings = new ConcurrentHashMap();
    addBaseClassMappings();
  }
  
  private static void addBaseClassMappings()
  {
    mappings.put("byte", Byte.TYPE);
    mappings.put("short", Short.TYPE);
    mappings.put("int", Integer.TYPE);
    mappings.put("long", Long.TYPE);
    mappings.put("float", Float.TYPE);
    mappings.put("double", Double.TYPE);
    mappings.put("boolean", Boolean.TYPE);
    mappings.put("char", Character.TYPE);
    mappings.put("[byte", byte[].class);
    mappings.put("[short", short[].class);
    mappings.put("[int", int[].class);
    mappings.put("[long", long[].class);
    mappings.put("[float", float[].class);
    mappings.put("[double", double[].class);
    mappings.put("[boolean", boolean[].class);
    mappings.put("[char", char[].class);
    mappings.put("[B", byte[].class);
    mappings.put("[S", short[].class);
    mappings.put("[I", int[].class);
    mappings.put("[J", long[].class);
    mappings.put("[F", float[].class);
    mappings.put("[D", double[].class);
    mappings.put("[C", char[].class);
    mappings.put("[Z", boolean[].class);
    mappings.put(HashMap.class.getName(), HashMap.class);
  }
  
  public static SerializeBeanInfo buildBeanInfo(Class<?> paramClass, Map<String, String> paramMap, l paraml)
  {
    JSONType localJSONType = (JSONType)paramClass.getAnnotation(JSONType.class);
    HashMap localHashMap = new HashMap();
    ParserConfig.parserAllFieldToCache(paramClass, localHashMap);
    List localList = computeGetters(paramClass, localJSONType, paramMap, localHashMap, false, paraml);
    FieldInfo[] arrayOfFieldInfo = new FieldInfo[localList.size()];
    localList.toArray(arrayOfFieldInfo);
    String[] arrayOfString;
    String str1;
    int i;
    if (localJSONType != null)
    {
      arrayOfString = localJSONType.orders();
      String str2 = localJSONType.typeName();
      str1 = str2;
      if (str2.length() == 0) {
        str1 = null;
      }
      i = SerializerFeature.of(localJSONType.serialzeFeatures());
      if ((arrayOfString == null) || (arrayOfString.length == 0)) {
        break label193;
      }
      paramMap = computeGetters(paramClass, localJSONType, paramMap, localHashMap, true, paraml);
    }
    for (;;)
    {
      paraml = new FieldInfo[paramMap.size()];
      paramMap.toArray(paraml);
      paramMap = paraml;
      if (Arrays.equals(paraml, arrayOfFieldInfo)) {
        paramMap = arrayOfFieldInfo;
      }
      return new SerializeBeanInfo(paramClass, localJSONType, str1, i, arrayOfFieldInfo, paramMap);
      str1 = null;
      arrayOfString = null;
      i = 0;
      break;
      label193:
      paramMap = new ArrayList(localList);
      Collections.sort(paramMap);
    }
  }
  
  public static <T> T cast(Object paramObject, Class<T> paramClass, ParserConfig paramParserConfig)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = null;
    }
    do
    {
      Map localMap;
      do
      {
        do
        {
          do
          {
            return (T)localObject;
            if (paramClass == null) {
              throw new IllegalArgumentException("clazz is null");
            }
            localObject = paramObject;
          } while (paramClass == paramObject.getClass());
          if (!(paramObject instanceof Map)) {
            break;
          }
          localObject = paramObject;
        } while (paramClass == Map.class);
        localMap = (Map)paramObject;
        if (paramClass != Object.class) {
          break;
        }
        localObject = paramObject;
      } while (!localMap.containsKey(a.c));
      return (T)castToJavaBean((Map)paramObject, paramClass, paramParserConfig);
      if (paramClass.isArray())
      {
        if ((paramObject instanceof Collection))
        {
          localObject = (Collection)paramObject;
          int i = 0;
          paramObject = Array.newInstance(paramClass.getComponentType(), ((Collection)localObject).size());
          localObject = ((Collection)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Array.set(paramObject, i, cast(((Iterator)localObject).next(), paramClass.getComponentType(), paramParserConfig));
            i += 1;
          }
          return (T)paramObject;
        }
        if (paramClass == byte[].class) {
          return castToBytes(paramObject);
        }
      }
      localObject = paramObject;
    } while (paramClass.isAssignableFrom(paramObject.getClass()));
    if ((paramClass == Boolean.TYPE) || (paramClass == Boolean.class)) {
      return castToBoolean(paramObject);
    }
    if ((paramClass == Byte.TYPE) || (paramClass == Byte.class)) {
      return castToByte(paramObject);
    }
    if ((paramClass == Short.TYPE) || (paramClass == Short.class)) {
      return castToShort(paramObject);
    }
    if ((paramClass == Integer.TYPE) || (paramClass == Integer.class)) {
      return castToInt(paramObject);
    }
    if ((paramClass == Long.TYPE) || (paramClass == Long.class)) {
      return castToLong(paramObject);
    }
    if ((paramClass == Float.TYPE) || (paramClass == Float.class)) {
      return castToFloat(paramObject);
    }
    if ((paramClass == Double.TYPE) || (paramClass == Double.class)) {
      return castToDouble(paramObject);
    }
    if (paramClass == String.class) {
      return castToString(paramObject);
    }
    if (paramClass == BigDecimal.class) {
      return castToBigDecimal(paramObject);
    }
    if (paramClass == BigInteger.class) {
      return castToBigInteger(paramObject);
    }
    if (paramClass == java.util.Date.class) {
      return castToDate(paramObject);
    }
    if (paramClass == java.sql.Date.class) {
      return castToSqlDate(paramObject);
    }
    if (paramClass == Timestamp.class) {
      return castToTimestamp(paramObject);
    }
    if (paramClass.isEnum()) {
      return (T)castToEnum(paramObject, paramClass, paramParserConfig);
    }
    if (Calendar.class.isAssignableFrom(paramClass))
    {
      paramParserConfig = castToDate(paramObject);
      if (paramClass == Calendar.class) {
        paramObject = Calendar.getInstance(a.a, a.b);
      }
      for (;;)
      {
        ((Calendar)paramObject).setTime(paramParserConfig);
        return (T)paramObject;
        try
        {
          paramObject = (Calendar)paramClass.newInstance();
        }
        catch (Exception paramObject)
        {
          throw new d("can not cast to : " + paramClass.getName(), (Throwable)paramObject);
        }
      }
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ((((String)paramObject).length() == 0) || ("null".equals(paramObject)) || ("NULL".equals(paramObject))) {
        return null;
      }
      if (paramClass == Currency.class) {
        return Currency.getInstance((String)paramObject);
      }
    }
    throw new d("can not cast to : " + paramClass.getName());
  }
  
  public static <T> T cast(Object paramObject, ParameterizedType paramParameterizedType, ParserConfig paramParserConfig)
  {
    Object localObject2 = paramParameterizedType.getRawType();
    Type localType;
    Object localObject1;
    if ((localObject2 == Set.class) || (localObject2 == HashSet.class) || (localObject2 == TreeSet.class) || (localObject2 == List.class) || (localObject2 == ArrayList.class))
    {
      localType = paramParameterizedType.getActualTypeArguments()[0];
      if ((paramObject instanceof Iterable))
      {
        if ((localObject2 == Set.class) || (localObject2 == HashSet.class)) {
          paramParameterizedType = new HashSet();
        }
        for (;;)
        {
          localObject1 = ((Iterable)paramObject).iterator();
          for (;;)
          {
            paramObject = paramParameterizedType;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            paramParameterizedType.add(cast(((Iterator)localObject1).next(), localType, paramParserConfig));
          }
          if (localObject2 == TreeSet.class) {
            paramParameterizedType = new TreeSet();
          } else {
            paramParameterizedType = new ArrayList();
          }
        }
      }
    }
    if ((localObject2 == Map.class) || (localObject2 == HashMap.class))
    {
      localType = paramParameterizedType.getActualTypeArguments()[0];
      localObject1 = paramParameterizedType.getActualTypeArguments()[1];
      if ((paramObject instanceof Map))
      {
        paramParameterizedType = new HashMap();
        paramObject = ((Map)paramObject).entrySet().iterator();
        while (((Iterator)paramObject).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)paramObject).next();
          paramParameterizedType.put(cast(((Map.Entry)localObject2).getKey(), localType, paramParserConfig), cast(((Map.Entry)localObject2).getValue(), (Type)localObject1, paramParserConfig));
        }
        paramObject = paramParameterizedType;
        return (T)paramObject;
      }
    }
    if (((paramObject instanceof String)) && (((String)paramObject).length() == 0)) {
      return null;
    }
    if ((paramParameterizedType.getActualTypeArguments().length == 1) && ((paramParameterizedType.getActualTypeArguments()[0] instanceof WildcardType))) {
      return (T)cast(paramObject, (Type)localObject2, paramParserConfig);
    }
    throw new d("can not cast to : " + paramParameterizedType);
  }
  
  public static <T> T cast(Object paramObject, Type paramType, ParserConfig paramParserConfig)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    do
    {
      return (T)paramObject;
      if ((paramType instanceof Class)) {
        return (T)cast(paramObject, (Class)paramType, paramParserConfig);
      }
      if ((paramType instanceof ParameterizedType)) {
        return (T)cast(paramObject, (ParameterizedType)paramType, paramParserConfig);
      }
      if ((paramObject instanceof String))
      {
        paramParserConfig = (String)paramObject;
        if ((paramParserConfig.length() == 0) || ("null".equals(paramParserConfig)) || ("NULL".equals(paramParserConfig))) {
          return null;
        }
      }
    } while ((paramType instanceof TypeVariable));
    throw new d("can not cast to : " + paramType);
  }
  
  public static BigDecimal castToBigDecimal(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof BigDecimal)) {
      return (BigDecimal)paramObject;
    }
    if ((paramObject instanceof BigInteger)) {
      return new BigDecimal((BigInteger)paramObject);
    }
    paramObject = paramObject.toString();
    if (((String)paramObject).length() == 0) {
      return null;
    }
    return new BigDecimal((String)paramObject);
  }
  
  public static BigInteger castToBigInteger(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof BigInteger)) {
      return (BigInteger)paramObject;
    }
    if (((paramObject instanceof Float)) || ((paramObject instanceof Double))) {
      return BigInteger.valueOf(((Number)paramObject).longValue());
    }
    paramObject = paramObject.toString();
    if ((((String)paramObject).length() == 0) || ("null".equals(paramObject)) || ("NULL".equals(paramObject))) {
      return null;
    }
    return new BigInteger((String)paramObject);
  }
  
  public static Boolean castToBoolean(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    if ((paramObject instanceof Number))
    {
      if (((Number)paramObject).intValue() == 1) {}
      for (;;)
      {
        return Boolean.valueOf(bool);
        bool = false;
      }
    }
    if ((paramObject instanceof String))
    {
      String str = (String)paramObject;
      if ((str.length() == 0) || ("null".equals(str)) || ("NULL".equals(str))) {
        return null;
      }
      if (("true".equalsIgnoreCase(str)) || ("1".equals(str))) {
        return Boolean.TRUE;
      }
      if (("false".equalsIgnoreCase(str)) || ("0".equals(str))) {
        return Boolean.FALSE;
      }
    }
    throw new d("can not cast to boolean, value : " + paramObject);
  }
  
  public static Byte castToByte(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Byte.valueOf(((Number)paramObject).byteValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      paramObject = (String)paramObject;
    } while ((((String)paramObject).length() == 0) || ("null".equals(paramObject)) || ("NULL".equals(paramObject)));
    return Byte.valueOf(Byte.parseByte((String)paramObject));
    throw new d("can not cast to byte, value : " + paramObject);
  }
  
  public static byte[] castToBytes(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return (byte[])paramObject;
    }
    if ((paramObject instanceof String)) {
      return IOUtils.decodeBase64((String)paramObject);
    }
    throw new d("can not cast to int, value : " + paramObject);
  }
  
  public static Character castToChar(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Character)) {
      return (Character)paramObject;
    }
    if ((paramObject instanceof String))
    {
      String str = (String)paramObject;
      if (str.length() == 0) {
        return null;
      }
      if (str.length() != 1) {
        throw new d("can not cast to char, value : " + paramObject);
      }
      return Character.valueOf(str.charAt(0));
    }
    throw new d("can not cast to char, value : " + paramObject);
  }
  
  public static java.util.Date castToDate(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof java.util.Date)) {
      return (java.util.Date)paramObject;
    }
    if ((paramObject instanceof Calendar)) {
      return ((Calendar)paramObject).getTime();
    }
    long l = -1L;
    if ((paramObject instanceof Number)) {
      return new java.util.Date(((Number)paramObject).longValue());
    }
    Object localObject;
    if ((paramObject instanceof String))
    {
      String str = (String)paramObject;
      localObject = new JSONScanner(str);
      for (;;)
      {
        try
        {
          if (((JSONScanner)localObject).scanISO8601DateIfMatch(false))
          {
            paramObject = ((JSONScanner)localObject).getCalendar().getTime();
            ((JSONScanner)localObject).close();
            return (java.util.Date)paramObject;
          }
          ((JSONScanner)localObject).close();
          localObject = str;
          if (str.startsWith("/Date("))
          {
            localObject = str;
            if (str.endsWith(")/")) {
              localObject = str.substring(6, str.length() - 2);
            }
          }
          if (((String)localObject).indexOf('-') == -1) {
            break;
          }
          if (((String)localObject).length() == a.e.length())
          {
            paramObject = a.e;
            paramObject = new SimpleDateFormat((String)paramObject, a.b);
            ((SimpleDateFormat)paramObject).setTimeZone(a.a);
          }
          if (((String)localObject).length() != 10) {
            break label228;
          }
        }
        finally
        {
          try
          {
            paramObject = ((SimpleDateFormat)paramObject).parse((String)localObject);
            return (java.util.Date)paramObject;
          }
          catch (ParseException paramObject)
          {
            throw new d("can not cast to Date, value : " + (String)localObject);
          }
          paramObject = finally;
          ((JSONScanner)localObject).close();
        }
        paramObject = "yyyy-MM-dd";
        continue;
        label228:
        if (((String)localObject).length() == "yyyy-MM-dd HH:mm:ss".length()) {
          paramObject = "yyyy-MM-dd HH:mm:ss";
        } else {
          paramObject = "yyyy-MM-dd HH:mm:ss.SSS";
        }
      }
      if (((String)localObject).length() == 0) {
        return null;
      }
      l = Long.parseLong((String)localObject);
    }
    if (l < 0L)
    {
      localObject = paramObject.getClass();
      if ("oracle.sql.TIMESTAMP".equals(((Class)localObject).getName()))
      {
        if ((oracleTimestampMethod == null) && (!oracleTimestampMethodInited)) {}
        try
        {
          oracleTimestampMethod = ((Class)localObject).getMethod("toJdbc", new Class[0]);
          oracleTimestampMethodInited = true;
          if (!"oracle.sql.DATE".equals(localNoSuchMethodException1.getName())) {
            break label485;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException1)
        {
          for (;;)
          {
            try
            {
              paramObject = oracleTimestampMethod.invoke(paramObject, new Object[0]);
              return (java.util.Date)paramObject;
            }
            catch (Exception paramObject)
            {
              throw new d("can not cast oracle.sql.TIMESTAMP to Date", (Throwable)paramObject);
            }
            localNoSuchMethodException1 = localNoSuchMethodException1;
            oracleTimestampMethodInited = true;
          }
        }
        finally
        {
          paramObject = finally;
          oracleTimestampMethodInited = true;
          throw ((Throwable)paramObject);
        }
      }
      if ((oracleDateMethod == null) && (!oracleDateMethodInited)) {}
      try
      {
        oracleDateMethod = localNoSuchMethodException1.getMethod("toJdbc", new Class[0]);
        oracleDateMethodInited = true;
        throw new d("can not cast to Date, value : " + paramObject);
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        for (;;)
        {
          try
          {
            paramObject = oracleDateMethod.invoke(paramObject, new Object[0]);
            return (java.util.Date)paramObject;
          }
          catch (Exception paramObject)
          {
            throw new d("can not cast oracle.sql.DATE to Date", (Throwable)paramObject);
          }
          localNoSuchMethodException2 = localNoSuchMethodException2;
          oracleDateMethodInited = true;
        }
      }
      finally
      {
        paramObject = finally;
        oracleDateMethodInited = true;
        throw ((Throwable)paramObject);
      }
    }
    label485:
    return new java.util.Date(l);
  }
  
  public static Double castToDouble(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Number)) {
      return Double.valueOf(((Number)paramObject).doubleValue());
    }
    if ((paramObject instanceof String))
    {
      String str = paramObject.toString();
      if ((str.length() == 0) || ("null".equals(str)) || ("NULL".equals(str))) {
        return null;
      }
      paramObject = str;
      if (str.indexOf(',') != 0) {
        paramObject = str.replaceAll(",", "");
      }
      return Double.valueOf(Double.parseDouble((String)paramObject));
    }
    throw new d("can not cast to double, value : " + paramObject);
  }
  
  public static <T> T castToEnum(Object paramObject, Class<T> paramClass, ParserConfig paramParserConfig)
  {
    try
    {
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
        if (((String)paramObject).length() == 0) {
          return null;
        }
        return Enum.valueOf(paramClass, (String)paramObject);
      }
      if ((paramObject instanceof Number))
      {
        int i = ((Number)paramObject).intValue();
        paramObject = paramClass.getEnumConstants();
        if (i < paramObject.length)
        {
          paramObject = paramObject[i];
          return (T)paramObject;
        }
      }
    }
    catch (Exception paramObject)
    {
      throw new d("can not cast to : " + paramClass.getName(), (Throwable)paramObject);
    }
    throw new d("can not cast to : " + paramClass.getName());
  }
  
  public static Float castToFloat(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Number)) {
      return Float.valueOf(((Number)paramObject).floatValue());
    }
    if ((paramObject instanceof String))
    {
      String str = paramObject.toString();
      if ((str.length() == 0) || ("null".equals(str)) || ("NULL".equals(str))) {
        return null;
      }
      paramObject = str;
      if (str.indexOf(',') != 0) {
        paramObject = str.replaceAll(",", "");
      }
      return Float.valueOf(Float.parseFloat((String)paramObject));
    }
    throw new d("can not cast to float, value : " + paramObject);
  }
  
  public static Integer castToInt(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Integer)) {
      return (Integer)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Integer.valueOf(((Number)paramObject).intValue());
    }
    if ((paramObject instanceof String))
    {
      String str = (String)paramObject;
      if ((str.length() == 0) || ("null".equals(str)) || ("NULL".equals(str))) {
        return null;
      }
      paramObject = str;
      if (str.indexOf(',') != 0) {
        paramObject = str.replaceAll(",", "");
      }
      return Integer.valueOf(Integer.parseInt((String)paramObject));
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue()) {}
      for (int i = 1;; i = 0) {
        return Integer.valueOf(i);
      }
    }
    throw new d("can not cast to int, value : " + paramObject);
  }
  
  public static <T> T castToJavaBean(Object paramObject, Class<T> paramClass)
  {
    return (T)cast(paramObject, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public static <T> T castToJavaBean(Map<String, Object> paramMap, Class<T> paramClass, ParserConfig paramParserConfig)
  {
    int i = 0;
    if (paramClass == StackTraceElement.class) {}
    Class localClass;
    try
    {
      paramClass = (String)paramMap.get("className");
      paramParserConfig = (String)paramMap.get("methodName");
      localObject = (String)paramMap.get("fileName");
      paramMap = (Number)paramMap.get("lineNumber");
      if (paramMap == null) {}
      for (;;)
      {
        return new StackTraceElement(paramClass, paramParserConfig, (String)localObject, i);
        i = paramMap.intValue();
      }
      localObject = paramMap.get(a.c);
      if (!(localObject instanceof String)) {
        break label185;
      }
      localObject = (String)localObject;
      localClass = loadClass((String)localObject);
      if (localClass == null) {
        throw new ClassNotFoundException((String)localObject + " not found");
      }
    }
    catch (Exception paramMap)
    {
      throw new d(paramMap.getMessage(), paramMap);
    }
    if (!localClass.equals(paramClass)) {
      return (T)castToJavaBean(paramMap, localClass, paramParserConfig);
    }
    label185:
    if (paramClass.isInterface())
    {
      if ((paramMap instanceof e)) {}
      for (paramMap = (e)paramMap;; paramMap = new e(paramMap)) {
        return (T)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] { paramClass }, paramMap);
      }
    }
    Object localObject = paramParserConfig;
    if (paramParserConfig == null) {
      localObject = ParserConfig.getGlobalInstance();
    }
    paramClass = ((ParserConfig)localObject).getDeserializer(paramClass);
    if ((paramClass instanceof JavaBeanDeserializer)) {}
    for (paramClass = (JavaBeanDeserializer)paramClass;; paramClass = null)
    {
      if (paramClass == null) {
        throw new d("can not get javaBeanDeserializer");
      }
      paramMap = paramClass.createInstance(paramMap, (ParserConfig)localObject);
      return paramMap;
    }
  }
  
  public static Long castToLong(Object paramObject)
  {
    if (paramObject == null) {}
    String str;
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Long.valueOf(((Number)paramObject).longValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      str = (String)paramObject;
    } while ((str.length() == 0) || ("null".equals(str)) || ("NULL".equals(str)));
    Object localObject = str;
    if (str.indexOf(',') != 0) {
      localObject = str.replaceAll(",", "");
    }
    JSONScanner localJSONScanner;
    try
    {
      long l = Long.parseLong((String)localObject);
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localJSONScanner = new JSONScanner((String)localObject);
      if (!localJSONScanner.scanISO8601DateIfMatch(false)) {}
    }
    for (localObject = localJSONScanner.getCalendar();; localObject = null)
    {
      localJSONScanner.close();
      if (localObject != null) {
        return Long.valueOf(((Calendar)localObject).getTimeInMillis());
      }
      throw new d("can not cast to long, value : " + paramObject);
    }
  }
  
  public static Short castToShort(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Short.valueOf(((Number)paramObject).shortValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      paramObject = (String)paramObject;
    } while ((((String)paramObject).length() == 0) || ("null".equals(paramObject)) || ("NULL".equals(paramObject)));
    return Short.valueOf(Short.parseShort((String)paramObject));
    throw new d("can not cast to short, value : " + paramObject);
  }
  
  public static java.sql.Date castToSqlDate(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof java.sql.Date)) {
      return (java.sql.Date)paramObject;
    }
    if ((paramObject instanceof java.util.Date)) {
      return new java.sql.Date(((java.util.Date)paramObject).getTime());
    }
    if ((paramObject instanceof Calendar)) {
      return new java.sql.Date(((Calendar)paramObject).getTimeInMillis());
    }
    if ((paramObject instanceof Number)) {}
    for (long l = ((Number)paramObject).longValue();; l = 0L)
    {
      if ((paramObject instanceof String))
      {
        String str = (String)paramObject;
        if ((str.length() == 0) || ("null".equals(str)) || ("NULL".equals(str))) {
          return null;
        }
        l = Long.parseLong(str);
      }
      if (l <= 0L) {
        throw new d("can not cast to Date, value : " + paramObject);
      }
      return new java.sql.Date(l);
    }
  }
  
  public static String castToString(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return paramObject.toString();
  }
  
  public static Timestamp castToTimestamp(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Calendar)) {
      return new Timestamp(((Calendar)paramObject).getTimeInMillis());
    }
    if ((paramObject instanceof Timestamp)) {
      return (Timestamp)paramObject;
    }
    if ((paramObject instanceof java.util.Date)) {
      return new Timestamp(((java.util.Date)paramObject).getTime());
    }
    if ((paramObject instanceof Number)) {}
    for (long l = ((Number)paramObject).longValue();; l = 0L)
    {
      if ((paramObject instanceof String))
      {
        String str = (String)paramObject;
        if ((str.length() == 0) || ("null".equals(str)) || ("NULL".equals(str))) {
          return null;
        }
        l = Long.parseLong(str);
      }
      if (l <= 0L) {
        throw new d("can not cast to Date, value : " + paramObject);
      }
      return new Timestamp(l);
    }
  }
  
  public static void clearClassMapping()
  {
    mappings.clear();
    addBaseClassMappings();
  }
  
  public static List<FieldInfo> computeGetters(Class<?> paramClass, JSONType paramJSONType, Map<String, String> paramMap, Map<String, Field> paramMap1, boolean paramBoolean, l paraml)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Method[] arrayOfMethod = paramClass.getMethods();
    int i3 = arrayOfMethod.length;
    int i2 = 0;
    Method localMethod;
    String str;
    int k;
    int j;
    int i;
    JSONField localJSONField;
    if (i2 < i3)
    {
      localMethod = arrayOfMethod[i2];
      str = localMethod.getName();
      k = 0;
      j = 0;
      i = 0;
      paramJSONType = null;
      if (Modifier.isStatic(localMethod.getModifiers())) {}
      while ((localMethod.getReturnType().equals(Void.TYPE)) || (localMethod.getParameterTypes().length != 0) || (localMethod.getReturnType() == ClassLoader.class) || ((localMethod.getName().equals("getMetaClass")) && (localMethod.getReturnType().getName().equals("groovy.lang.MetaClass"))))
      {
        i2 += 1;
        break;
      }
      localJSONField = (JSONField)localMethod.getAnnotation(JSONField.class);
      if (localJSONField != null) {
        break label1868;
      }
      localJSONField = getSuperMethodAnnotation(paramClass, localMethod);
    }
    label451:
    label460:
    label871:
    label880:
    label1164:
    label1199:
    label1265:
    label1748:
    label1823:
    label1828:
    label1842:
    label1852:
    label1862:
    label1868:
    for (;;)
    {
      Object localObject1 = paramJSONType;
      if (localJSONField != null)
      {
        if (!localJSONField.serialize()) {
          break;
        }
        m = localJSONField.ordinal();
        n = SerializerFeature.of(localJSONField.serialzeFeatures());
        i1 = Feature.of(localJSONField.parseFeatures());
        if (localJSONField.name().length() != 0)
        {
          localObject1 = localJSONField.name();
          paramJSONType = (JSONType)localObject1;
          if (paramMap != null)
          {
            paramJSONType = (String)paramMap.get(localObject1);
            if (paramJSONType == null) {
              break;
            }
          }
          localLinkedHashMap.put(paramJSONType, new FieldInfo(paramJSONType, localMethod, null, paramClass, null, m, n, i1, localJSONField, null, null));
          break;
        }
        k = m;
        j = n;
        i = i1;
        localObject1 = paramJSONType;
        if (localJSONField.label().length() != 0)
        {
          localObject1 = localJSONField.label();
          i = i1;
          j = n;
          k = m;
        }
      }
      int i1 = k;
      int n = j;
      int m = i;
      Object localObject2 = localObject1;
      char c;
      Object localObject4;
      Object localObject3;
      if (str.startsWith("get"))
      {
        if ((str.length() < 4) || (str.equals("getClass")) || ((str.equals("getDeclaringClass")) && (paramClass.isEnum()))) {
          break;
        }
        c = str.charAt(3);
        if ((!Character.isUpperCase(c)) && (c <= 'Ȁ')) {
          break label1199;
        }
        if (!compatibleWithJavaBean) {
          break label1164;
        }
        paramJSONType = decapitalize(str.substring(3));
        paramJSONType = getPropertyNameByCompatibleFieldName(paramMap1, str, paramJSONType, 3);
        if (isJSONTypeIgnore(paramClass, paramJSONType)) {
          break label1265;
        }
        localObject2 = ParserConfig.getFieldFromCache(paramJSONType, paramMap1);
        localObject4 = localObject2;
        if (localObject2 == null)
        {
          localObject4 = localObject2;
          if (paramJSONType.length() > 1)
          {
            m = paramJSONType.charAt(1);
            localObject4 = localObject2;
            if (m >= 65)
            {
              localObject4 = localObject2;
              if (m <= 90) {
                localObject4 = ParserConfig.getFieldFromCache(decapitalize(str.substring(3)), paramMap1);
              }
            }
          }
        }
        if (localObject4 == null) {
          break label1862;
        }
        localObject3 = (JSONField)((Field)localObject4).getAnnotation(JSONField.class);
        localObject2 = paramJSONType;
        if (localObject3 == null) {
          break label1852;
        }
        if (!((JSONField)localObject3).serialize()) {
          break;
        }
        m = ((JSONField)localObject3).ordinal();
        n = SerializerFeature.of(((JSONField)localObject3).serialzeFeatures());
        i1 = Feature.of(((JSONField)localObject3).parseFeatures());
        if (((JSONField)localObject3).name().length() != 0)
        {
          localObject2 = ((JSONField)localObject3).name();
          paramJSONType = (JSONType)localObject2;
          if (paramMap != null)
          {
            paramJSONType = (String)paramMap.get(localObject2);
            if (paramJSONType == null) {
              break;
            }
          }
        }
        localObject2 = paramJSONType;
        k = m;
        j = n;
        i = i1;
        if (((JSONField)localObject3).label().length() == 0) {
          break label1852;
        }
        localObject1 = ((JSONField)localObject3).label();
        localObject2 = localObject3;
        i = i1;
        j = n;
        k = m;
      }
      for (;;)
      {
        localObject3 = paramJSONType;
        if (paramMap != null)
        {
          localObject3 = (String)paramMap.get(paramJSONType);
          if (localObject3 == null) {
            break;
          }
        }
        paramJSONType = (JSONType)localObject3;
        if (paraml != null) {
          paramJSONType = paraml.translate((String)localObject3);
        }
        localLinkedHashMap.put(paramJSONType, new FieldInfo(paramJSONType, localMethod, (Field)localObject4, paramClass, null, k, j, i, localJSONField, (JSONField)localObject2, (String)localObject1));
        localObject2 = localObject1;
        m = i;
        n = j;
        i1 = k;
        if ((!str.startsWith("is")) || (str.length() < 3) || ((localMethod.getReturnType() != Boolean.TYPE) && (localMethod.getReturnType() != Boolean.class))) {
          break;
        }
        c = str.charAt(2);
        if (Character.isUpperCase(c)) {
          if (compatibleWithJavaBean)
          {
            paramJSONType = decapitalize(str.substring(2));
            paramJSONType = getPropertyNameByCompatibleFieldName(paramMap1, str, paramJSONType, 2);
            localObject1 = ParserConfig.getFieldFromCache(paramJSONType, paramMap1);
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = ParserConfig.getFieldFromCache(str, paramMap1);
            }
            if (localObject3 == null) {
              break label1842;
            }
            localObject4 = (JSONField)((Field)localObject3).getAnnotation(JSONField.class);
            localObject1 = paramJSONType;
            if (localObject4 == null) {
              break label1828;
            }
            if (!((JSONField)localObject4).serialize()) {
              break;
            }
            i = ((JSONField)localObject4).ordinal();
            j = SerializerFeature.of(((JSONField)localObject4).serialzeFeatures());
            k = Feature.of(((JSONField)localObject4).parseFeatures());
            if (((JSONField)localObject4).name().length() != 0)
            {
              localObject1 = ((JSONField)localObject4).name();
              paramJSONType = (JSONType)localObject1;
              if (paramMap != null)
              {
                paramJSONType = (String)paramMap.get(localObject1);
                if (paramJSONType == null) {
                  break;
                }
              }
            }
            localObject1 = paramJSONType;
            i1 = i;
            n = j;
            m = k;
            if (((JSONField)localObject4).label().length() == 0) {
              break label1828;
            }
            localObject2 = ((JSONField)localObject4).label();
            localObject1 = localObject4;
            localObject4 = localObject2;
            m = k;
            n = j;
            i1 = i;
          }
        }
        for (;;)
        {
          localObject2 = paramJSONType;
          if (paramMap != null)
          {
            localObject2 = (String)paramMap.get(paramJSONType);
            if (localObject2 == null) {
              break;
            }
          }
          paramJSONType = (JSONType)localObject2;
          if (paraml != null) {
            paramJSONType = paraml.translate((String)localObject2);
          }
          if (localLinkedHashMap.containsKey(paramJSONType)) {
            break;
          }
          localLinkedHashMap.put(paramJSONType, new FieldInfo(paramJSONType, localMethod, (Field)localObject3, paramClass, null, i1, n, m, localJSONField, (JSONField)localObject1, (String)localObject4));
          break;
          paramJSONType = Character.toLowerCase(str.charAt(3)) + str.substring(4);
          break label451;
          if (c == '_')
          {
            paramJSONType = str.substring(4);
            break label460;
          }
          if (c == 'f')
          {
            paramJSONType = str.substring(3);
            break label460;
          }
          if ((str.length() < 5) || (!Character.isUpperCase(str.charAt(4)))) {
            break;
          }
          paramJSONType = decapitalize(str.substring(3));
          break label460;
          break;
          paramJSONType = Character.toLowerCase(str.charAt(2)) + str.substring(3);
          break label871;
          if (c == '_')
          {
            paramJSONType = str.substring(3);
            break label880;
          }
          if (c != 'f') {
            break;
          }
          paramJSONType = str.substring(2);
          break label880;
          localObject2 = paramClass.getFields();
          i3 = localObject2.length;
          m = 0;
          if (m < i3)
          {
            localObject3 = localObject2[m];
            if (Modifier.isStatic(((Field)localObject3).getModifiers())) {}
            do
            {
              m += 1;
              break;
              localJSONField = (JSONField)((Field)localObject3).getAnnotation(JSONField.class);
              i = 0;
              j = 0;
              k = 0;
              paramJSONType = ((Field)localObject3).getName();
              localObject1 = null;
              paramMap1 = paramJSONType;
              if (localJSONField == null) {
                break label1823;
              }
            } while (!localJSONField.serialize());
            n = localJSONField.ordinal();
            i1 = SerializerFeature.of(localJSONField.serialzeFeatures());
            i2 = Feature.of(localJSONField.parseFeatures());
            if (localJSONField.name().length() != 0) {
              paramJSONType = localJSONField.name();
            }
            paramMap1 = paramJSONType;
            i = n;
            j = i1;
            k = i2;
            if (localJSONField.label().length() == 0) {
              break label1823;
            }
            localObject1 = localJSONField.label();
            k = i2;
            j = i1;
            i = n;
          }
          for (;;)
          {
            paramMap1 = paramJSONType;
            if (paramMap != null)
            {
              paramMap1 = (String)paramMap.get(paramJSONType);
              if (paramMap1 == null) {
                break;
              }
            }
            paramJSONType = paramMap1;
            if (paraml != null) {
              paramJSONType = paraml.translate(paramMap1);
            }
            if (localLinkedHashMap.containsKey(paramJSONType)) {
              break;
            }
            localLinkedHashMap.put(paramJSONType, new FieldInfo(paramJSONType, null, (Field)localObject3, paramClass, null, i, j, k, null, localJSONField, (String)localObject1));
            break;
            paramJSONType = new ArrayList();
            paramClass = (JSONType)paramClass.getAnnotation(JSONType.class);
            if (paramClass != null)
            {
              paramClass = paramClass.orders();
              if ((paramClass != null) && (paramClass.length == localLinkedHashMap.size()))
              {
                k = 1;
                m = paramClass.length;
                j = 0;
                i = k;
                if (j < m)
                {
                  if (localLinkedHashMap.containsKey(paramClass[j])) {
                    break label1748;
                  }
                  i = 0;
                }
              }
            }
            for (;;)
            {
              if (i != 0)
              {
                j = paramClass.length;
                i = 0;
                while (i < j)
                {
                  paramJSONType.add((FieldInfo)localLinkedHashMap.get(paramClass[i]));
                  i += 1;
                }
                j += 1;
                break;
                i = 0;
                continue;
              }
              paramClass = localLinkedHashMap.values().iterator();
              while (paramClass.hasNext()) {
                paramJSONType.add((FieldInfo)paramClass.next());
              }
              if (paramBoolean) {
                Collections.sort(paramJSONType);
              }
              return paramJSONType;
              i = 0;
              paramClass = null;
            }
            paramJSONType = paramMap1;
          }
          paramJSONType = (JSONType)localObject1;
          localObject1 = localObject4;
          localObject4 = localObject2;
          continue;
          localObject1 = null;
          localObject4 = localObject2;
        }
        paramJSONType = (JSONType)localObject2;
        localObject2 = localObject3;
        continue;
        localObject2 = null;
      }
    }
  }
  
  public static Collection createCollection(Type paramType)
  {
    Class localClass = getRawClass(paramType);
    if ((localClass == AbstractCollection.class) || (localClass == Collection.class)) {
      return new ArrayList();
    }
    if (localClass.isAssignableFrom(HashSet.class)) {
      return new HashSet();
    }
    if (localClass.isAssignableFrom(LinkedHashSet.class)) {
      return new LinkedHashSet();
    }
    if (localClass.isAssignableFrom(TreeSet.class)) {
      return new TreeSet();
    }
    if (localClass.isAssignableFrom(ArrayList.class)) {
      return new ArrayList();
    }
    if (localClass.isAssignableFrom(EnumSet.class))
    {
      if ((paramType instanceof ParameterizedType)) {}
      for (paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];; paramType = Object.class) {
        return EnumSet.noneOf((Class)paramType);
      }
    }
    try
    {
      paramType = (Collection)localClass.newInstance();
      return paramType;
    }
    catch (Exception paramType)
    {
      throw new d("create instance error, class " + localClass.getName());
    }
  }
  
  public static String decapitalize(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((paramString.length() > 1) && (Character.isUpperCase(paramString.charAt(1))) && (Character.isUpperCase(paramString.charAt(0)))) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    paramString[0] = Character.toLowerCase(paramString[0]);
    return new String(paramString);
  }
  
  public static Class<?> getClass(Type paramType)
  {
    if (paramType.getClass() == Class.class) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType)) {
      return getClass(((ParameterizedType)paramType).getRawType());
    }
    if ((paramType instanceof TypeVariable)) {
      return (Class)((TypeVariable)paramType).getBounds()[0];
    }
    return Object.class;
  }
  
  public static Class<?> getCollectionItemClass(Type paramType)
  {
    Object localObject;
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      if (!(paramType instanceof WildcardType)) {
        break label97;
      }
      localObject = ((WildcardType)paramType).getUpperBounds();
      if (localObject.length != 1) {
        break label97;
      }
      paramType = localObject[0];
    }
    label97:
    for (;;)
    {
      if ((paramType instanceof Class))
      {
        localObject = (Class)paramType;
        paramType = (Type)localObject;
        if (!Modifier.isPublic(((Class)localObject).getModifiers())) {
          throw new d("can not create ASMParser");
        }
      }
      else
      {
        throw new d("can not create ASMParser");
        paramType = Object.class;
      }
      return paramType;
    }
  }
  
  public static Type getCollectionItemType(Type paramType)
  {
    Type[] arrayOfType = null;
    Object localObject;
    if ((paramType instanceof ParameterizedType))
    {
      localObject = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      paramType = (Type)localObject;
      if ((localObject instanceof WildcardType))
      {
        arrayOfType = ((WildcardType)localObject).getUpperBounds();
        paramType = (Type)localObject;
        if (arrayOfType.length == 1) {
          paramType = arrayOfType[0];
        }
      }
      localObject = paramType;
    }
    for (;;)
    {
      paramType = (Type)localObject;
      if (localObject == null) {
        paramType = Object.class;
      }
      return paramType;
      localObject = arrayOfType;
      if ((paramType instanceof Class))
      {
        paramType = (Class)paramType;
        localObject = arrayOfType;
        if (!paramType.getName().startsWith("java.")) {
          localObject = getCollectionItemType(paramType.getGenericSuperclass());
        }
      }
    }
  }
  
  public static Field getField(Class<?> paramClass, String paramString, Field[] paramArrayOfField)
  {
    int j = paramArrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = paramArrayOfField[i];
      if (paramString.equals(localField.getName())) {
        return localField;
      }
      i += 1;
    }
    paramClass = paramClass.getSuperclass();
    if ((paramClass != null) && (paramClass != Object.class)) {
      return getField(paramClass, paramString, paramClass.getDeclaredFields());
    }
    return null;
  }
  
  public static Type getGenericParamType(Type paramType)
  {
    if ((paramType instanceof ParameterizedType)) {}
    while (!(paramType instanceof Class)) {
      return paramType;
    }
    return getGenericParamType(((Class)paramType).getGenericSuperclass());
  }
  
  public static int getParserFeatures(Class<?> paramClass)
  {
    paramClass = (JSONType)paramClass.getAnnotation(JSONType.class);
    if (paramClass == null) {
      return 0;
    }
    return Feature.of(paramClass.parseFeatures());
  }
  
  private static String getPropertyNameByCompatibleFieldName(Map<String, Field> paramMap, String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (compatibleWithFieldName)
    {
      str = paramString2;
      if (!paramMap.containsKey(paramString2))
      {
        paramString1 = paramString1.substring(paramInt);
        str = paramString2;
        if (paramMap.containsKey(paramString1)) {
          str = paramString1;
        }
      }
    }
    return str;
  }
  
  public static Class<?> getRawClass(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType)) {
      return getRawClass(((ParameterizedType)paramType).getRawType());
    }
    throw new d("TODO");
  }
  
  public static int getSerializeFeatures(Class<?> paramClass)
  {
    paramClass = (JSONType)paramClass.getAnnotation(JSONType.class);
    if (paramClass == null) {
      return 0;
    }
    return SerializerFeature.of(paramClass.serialzeFeatures());
  }
  
  public static JSONField getSuperMethodAnnotation(Class<?> paramClass, Method paramMethod)
  {
    Object localObject1 = paramClass.getInterfaces();
    Object localObject2;
    int i;
    Object localObject3;
    int j;
    label47:
    JSONField localJSONField;
    Class[] arrayOfClass;
    if (localObject1.length > 0)
    {
      localObject2 = paramMethod.getParameterTypes();
      int m = localObject1.length;
      i = 0;
      if (i < m)
      {
        localObject3 = localObject1[i].getMethods();
        int n = localObject3.length;
        j = 0;
        if (j < n)
        {
          localJSONField = localObject3[j];
          arrayOfClass = localJSONField.getParameterTypes();
          if (arrayOfClass.length == localObject2.length) {}
        }
      }
    }
    label75:
    label100:
    label263:
    label321:
    label327:
    for (;;)
    {
      j += 1;
      break label47;
      if (localJSONField.getName().equals(paramMethod.getName()))
      {
        int k = 0;
        if (k < localObject2.length) {
          if (arrayOfClass[k].equals(localObject2[k])) {}
        }
        for (k = 0;; k = 1)
        {
          if (k == 0) {
            break label327;
          }
          localJSONField = (JSONField)localJSONField.getAnnotation(JSONField.class);
          if (localJSONField == null) {
            break label75;
          }
          return localJSONField;
          k += 1;
          break label100;
          i += 1;
          break;
          localObject1 = paramClass.getSuperclass();
          if (localObject1 == null) {
            return null;
          }
          if (Modifier.isAbstract(((Class)localObject1).getModifiers()))
          {
            paramClass = paramMethod.getParameterTypes();
            localObject1 = ((Class)localObject1).getMethods();
            k = localObject1.length;
            i = 0;
            if (i < k)
            {
              localObject2 = localObject1[i];
              localObject3 = ((Method)localObject2).getParameterTypes();
              if (localObject3.length == paramClass.length) {}
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if (((Method)localObject2).getName().equals(paramMethod.getName()))
            {
              j = 0;
              if (j < paramClass.length) {
                if (localObject3[j].equals(paramClass[j])) {}
              }
              for (j = 0;; j = 1)
              {
                if (j == 0) {
                  break label321;
                }
                localObject2 = (JSONField)((Method)localObject2).getAnnotation(JSONField.class);
                if (localObject2 == null) {
                  break;
                }
                return (JSONField)localObject2;
                j += 1;
                break label263;
                return null;
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean isGenericParamType(Type paramType)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramType instanceof ParameterizedType)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramType instanceof Class));
      paramType = ((Class)paramType).getGenericSuperclass();
      bool1 = bool2;
    } while (paramType == Object.class);
    return isGenericParamType(paramType);
  }
  
  private static boolean isJSONTypeIgnore(Class<?> paramClass, String paramString)
  {
    Object localObject = (JSONType)paramClass.getAnnotation(JSONType.class);
    if (localObject != null)
    {
      arrayOfString = ((JSONType)localObject).includes();
      if (arrayOfString.length > 0)
      {
        i = 0;
        if (i < arrayOfString.length) {
          if (!paramString.equals(arrayOfString[i])) {}
        }
      }
    }
    while ((paramClass.getSuperclass() == Object.class) || (paramClass.getSuperclass() == null) || (!isJSONTypeIgnore(paramClass.getSuperclass(), paramString)))
    {
      for (;;)
      {
        String[] arrayOfString;
        return false;
        i += 1;
      }
      return true;
      localObject = ((JSONType)localObject).ignores();
      int i = 0;
      while (i < localObject.length)
      {
        if (paramString.equals(localObject[i])) {
          return true;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static boolean isPath(Class<?> paramClass)
  {
    if ((pathClass == null) && (!pathClass_error)) {}
    try
    {
      pathClass = Class.forName("java.nio.file.Path");
      if (pathClass != null) {
        return pathClass.isAssignableFrom(paramClass);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        pathClass_error = true;
      }
    }
    return false;
  }
  
  public static boolean isProxy(Class<?> paramClass)
  {
    paramClass = paramClass.getInterfaces();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      String str = paramClass[i].getName();
      if ((str.equals("net.sf.cglib.proxy.Factory")) || (str.equals("org.springframework.cglib.proxy.Factory"))) {}
      while ((str.equals("javassist.util.proxy.ProxyObject")) || (str.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject"))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isTransient(Method paramMethod)
  {
    boolean bool = true;
    if (paramMethod == null) {}
    do
    {
      return false;
      if (!transientClassInited) {}
      try
      {
        transientClass = Class.forName("java.beans.Transient");
        transientClassInited = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException = localException;
          transientClassInited = true;
        }
      }
      finally
      {
        paramMethod = finally;
        transientClassInited = true;
        throw paramMethod;
      }
    } while (transientClass == null);
    if (paramMethod.getAnnotation(transientClass) != null) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static Class<?> loadClass(String paramString)
  {
    return loadClass(paramString, null);
  }
  
  public static Class<?> loadClass(String paramString, ClassLoader paramClassLoader)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      return (Class<?>)localObject1;
      localObject2 = (Class)mappings.get(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    if (paramString.charAt(0) == '[') {
      return Array.newInstance(loadClass(paramString.substring(1), paramClassLoader), 0).getClass();
    }
    if ((paramString.startsWith("L")) && (paramString.endsWith(";"))) {
      return loadClass(paramString.substring(1, paramString.length() - 1), paramClassLoader);
    }
    Object localObject1 = localObject2;
    if (paramClassLoader != null) {
      try
      {
        paramClassLoader = paramClassLoader.loadClass(paramString);
        localObject2 = paramClassLoader;
        mappings.put(paramString, paramClassLoader);
        return paramClassLoader;
      }
      catch (Throwable paramClassLoader)
      {
        paramClassLoader.printStackTrace();
        localObject1 = localObject2;
      }
    }
    paramClassLoader = (ClassLoader)localObject1;
    try
    {
      localObject2 = Thread.currentThread().getContextClassLoader();
      paramClassLoader = (ClassLoader)localObject1;
      if (localObject2 != null)
      {
        paramClassLoader = (ClassLoader)localObject1;
        localObject1 = ((ClassLoader)localObject2).loadClass(paramString);
        paramClassLoader = (ClassLoader)localObject1;
        mappings.put(paramString, localObject1);
        return (Class<?>)localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        Class localClass = Class.forName(paramString);
        paramClassLoader = localClass;
        mappings.put(paramString, localClass);
        return localClass;
      }
      catch (Throwable paramString) {}
    }
    return paramClassLoader;
  }
  
  static void setAccessible(AccessibleObject paramAccessibleObject)
  {
    if (!setAccessibleEnable) {}
    while (paramAccessibleObject.isAccessible()) {
      return;
    }
    try
    {
      paramAccessibleObject.setAccessible(true);
      return;
    }
    catch (AccessControlException paramAccessibleObject)
    {
      setAccessibleEnable = false;
    }
  }
  
  public static Type unwrapOptional(Type paramType)
  {
    if (!optionalClassInited) {}
    try
    {
      optionalClass = Class.forName("java.util.Optional");
      optionalClassInited = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Type localType;
        ParameterizedType localParameterizedType;
        localException = localException;
        optionalClassInited = true;
      }
    }
    finally
    {
      paramType = finally;
      optionalClassInited = true;
      throw paramType;
    }
    localType = paramType;
    if ((paramType instanceof ParameterizedType))
    {
      localParameterizedType = (ParameterizedType)paramType;
      localType = paramType;
      if (localParameterizedType.getRawType() == optionalClass) {
        localType = localParameterizedType.getActualTypeArguments()[0];
      }
    }
    return localType;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/util/TypeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */