package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.IOUtils;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f
  implements c
{
  private static int a = 1024;
  private static ConcurrentMap<String, f> b = new ConcurrentHashMap(128, 0.75F, 1);
  private final String c;
  private s[] d;
  private SerializeConfig e;
  private ParserConfig f;
  
  public f(String paramString)
  {
    this(paramString, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
  }
  
  public f(String paramString, SerializeConfig paramSerializeConfig, ParserConfig paramParserConfig)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new g("json-path can not be null or empty");
    }
    this.c = paramString;
    this.e = paramSerializeConfig;
    this.f = paramParserConfig;
  }
  
  private static void a(Map<Object, String> paramMap, String paramString, Object paramObject, SerializeConfig paramSerializeConfig)
  {
    int i = 0;
    if (paramObject == null) {}
    label50:
    Object localObject2;
    label132:
    label177:
    label243:
    label294:
    label358:
    do
    {
      do
      {
        return;
        if (!paramMap.containsKey(paramObject))
        {
          paramMap.put(paramObject, paramString);
          if ((paramObject instanceof Map))
          {
            localObject1 = ((Map)paramObject).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (Map.Entry)((Iterator)localObject1).next();
              paramObject = ((Map.Entry)localObject2).getKey();
              if ((paramObject instanceof String)) {
                if (!paramString.equals("/")) {
                  break label132;
                }
              }
            }
            for (paramObject = "/" + paramObject;; paramObject = paramString + "/" + paramObject)
            {
              a(paramMap, (String)paramObject, ((Map.Entry)localObject2).getValue(), paramSerializeConfig);
              break label50;
              break;
            }
          }
          if ((paramObject instanceof Collection))
          {
            localObject1 = ((Collection)paramObject).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = ((Iterator)localObject1).next();
              if (!paramString.equals("/")) {
                break label243;
              }
            }
            for (paramObject = "/" + i;; paramObject = paramString + "/" + i)
            {
              a(paramMap, (String)paramObject, localObject2, paramSerializeConfig);
              i += 1;
              break label177;
              break;
            }
          }
          localObject1 = paramObject.getClass();
          if (!((Class)localObject1).isArray()) {
            continue;
          }
          int j = Array.getLength(paramObject);
          i = 0;
          if (i < j)
          {
            localObject2 = Array.get(paramObject, i);
            if (!paramString.equals("/")) {
              break label358;
            }
          }
        }
        for (localObject1 = "/" + i;; localObject1 = paramString + "/" + i)
        {
          a(paramMap, (String)localObject1, localObject2, paramSerializeConfig);
          i += 1;
          break label294;
          break;
          break;
        }
      } while ((ParserConfig.isPrimitive((Class)localObject1)) || (((Class)localObject1).isEnum()));
      localObject1 = paramSerializeConfig.getObjectWriter((Class)localObject1);
    } while (!(localObject1 instanceof JavaBeanSerializer));
    Object localObject1 = (JavaBeanSerializer)localObject1;
    for (;;)
    {
      try
      {
        localObject1 = ((JavaBeanSerializer)localObject1).getFieldValuesMap(paramObject).entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        paramObject = (String)((Map.Entry)localObject2).getKey();
        if ((paramObject instanceof String)) {
          if (paramString.equals("/"))
          {
            paramObject = "/" + (String)paramObject;
            a(paramMap, (String)paramObject, ((Map.Entry)localObject2).getValue(), paramSerializeConfig);
          }
          else
          {
            paramObject = paramString + "/" + (String)paramObject;
          }
        }
      }
      catch (Exception paramMap)
      {
        throw new d("toJSON error", paramMap);
      }
    }
  }
  
  protected static boolean a(Class<?> paramClass)
  {
    return (paramClass == Float.class) || (paramClass == Double.class);
  }
  
  static boolean a(Number paramNumber1, Number paramNumber2)
  {
    boolean bool1 = true;
    Class localClass1 = paramNumber1.getClass();
    boolean bool2 = b(localClass1);
    Class localClass2 = paramNumber2.getClass();
    boolean bool3 = b(localClass2);
    if ((paramNumber1 instanceof BigDecimal))
    {
      BigDecimal localBigDecimal = (BigDecimal)paramNumber1;
      if (bool3) {
        return localBigDecimal.equals(BigDecimal.valueOf(paramNumber2.longValue()));
      }
    }
    if (bool2)
    {
      if (bool3) {
        return paramNumber1.longValue() == paramNumber2.longValue();
      }
      if ((paramNumber2 instanceof BigInteger))
      {
        paramNumber2 = (BigInteger)paramNumber1;
        return BigInteger.valueOf(paramNumber1.longValue()).equals(paramNumber2);
      }
    }
    if ((bool3) && ((paramNumber1 instanceof BigInteger))) {
      return ((BigInteger)paramNumber1).equals(BigInteger.valueOf(paramNumber2.longValue()));
    }
    boolean bool4 = a(localClass1);
    boolean bool5 = a(localClass2);
    if (((bool4) && (bool5)) || ((bool4) && (bool3)) || ((bool5) && (bool2)))
    {
      if (paramNumber1.doubleValue() == paramNumber2.doubleValue()) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
    }
    return false;
  }
  
  static boolean a(Object paramObject1, Object paramObject2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject1 == paramObject2) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject1 == null);
        bool1 = bool2;
      } while (paramObject2 == null);
      if (paramObject1.getClass() == paramObject2.getClass()) {
        return paramObject1.equals(paramObject2);
      }
      if (!(paramObject1 instanceof Number)) {
        break;
      }
      bool1 = bool2;
    } while (!(paramObject2 instanceof Number));
    return a((Number)paramObject1, (Number)paramObject2);
    return paramObject1.equals(paramObject2);
  }
  
  public static void arrayAdd(Object paramObject, String paramString, Object... paramVarArgs)
  {
    compile(paramString).arrayAdd(paramObject, paramVarArgs);
  }
  
  protected static boolean b(Class<?> paramClass)
  {
    return (paramClass == Byte.class) || (paramClass == Short.class) || (paramClass == Integer.class) || (paramClass == Long.class);
  }
  
  public static f compile(String paramString)
  {
    if (paramString == null) {
      throw new g("jsonpath can not be null");
    }
    f localf2 = (f)b.get(paramString);
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf2 = new f(paramString);
      localf1 = localf2;
      if (b.size() < a)
      {
        b.putIfAbsent(paramString, localf2);
        localf1 = (f)b.get(paramString);
      }
    }
    return localf1;
  }
  
  public static boolean contains(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return false;
    }
    return compile(paramString).contains(paramObject);
  }
  
  public static boolean containsValue(Object paramObject1, String paramString, Object paramObject2)
  {
    return compile(paramString).containsValue(paramObject1, paramObject2);
  }
  
  public static Object eval(Object paramObject, String paramString)
  {
    return compile(paramString).eval(paramObject);
  }
  
  public static Map<String, Object> paths(Object paramObject)
  {
    return paths(paramObject, SerializeConfig.globalInstance);
  }
  
  public static Map<String, Object> paths(Object paramObject, SerializeConfig paramSerializeConfig)
  {
    Object localObject = new IdentityHashMap();
    a((Map)localObject, "/", paramObject, paramSerializeConfig);
    paramObject = new HashMap();
    paramSerializeConfig = ((Map)localObject).entrySet().iterator();
    while (paramSerializeConfig.hasNext())
    {
      localObject = (Map.Entry)paramSerializeConfig.next();
      ((Map)paramObject).put(((Map.Entry)localObject).getValue(), ((Map.Entry)localObject).getKey());
    }
    return (Map<String, Object>)paramObject;
  }
  
  public static Object read(String paramString1, String paramString2)
  {
    paramString1 = a.parse(paramString1);
    return compile(paramString2).eval(paramString1);
  }
  
  public static boolean remove(Object paramObject, String paramString)
  {
    return compile(paramString).remove(paramObject);
  }
  
  public static boolean set(Object paramObject1, String paramString, Object paramObject2)
  {
    return compile(paramString).set(paramObject1, paramObject2);
  }
  
  public static int size(Object paramObject, String paramString)
  {
    paramString = compile(paramString);
    return paramString.b(paramString.eval(paramObject));
  }
  
  protected Object a(Object paramObject, int paramInt)
  {
    if (paramObject == null) {}
    label68:
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
            if (!(paramObject instanceof List)) {
              break label68;
            }
            paramObject = (List)paramObject;
            if (paramInt < 0) {
              break;
            }
          } while (paramInt >= ((List)paramObject).size());
          return ((List)paramObject).get(paramInt);
        } while (Math.abs(paramInt) > ((List)paramObject).size());
        return ((List)paramObject).get(((List)paramObject).size() + paramInt);
        if (!paramObject.getClass().isArray()) {
          break label114;
        }
        i = Array.getLength(paramObject);
        if (paramInt < 0) {
          break;
        }
      } while (paramInt >= i);
      return Array.get(paramObject, paramInt);
    } while (Math.abs(paramInt) > i);
    return Array.get(paramObject, i + paramInt);
    label114:
    throw new UnsupportedOperationException();
  }
  
  protected Object a(Object paramObject, String paramString, boolean paramBoolean)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    Map localMap;
    do
    {
      do
      {
        return paramObject;
        if (!(paramObject instanceof Map)) {
          break;
        }
        localMap = (Map)paramObject;
        localObject = localMap.get(paramString);
        paramObject = localObject;
      } while (localObject != null);
      paramObject = localObject;
    } while (!"size".equals(paramString));
    return Integer.valueOf(localMap.size());
    Object localObject = c(paramObject.getClass());
    if (localObject != null) {
      try
      {
        paramObject = ((JavaBeanSerializer)localObject).getFieldValue(paramObject, paramString);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        throw new g("jsonpath error, path " + this.c + ", segement " + paramString, (Throwable)paramObject);
      }
    }
    if ((paramObject instanceof List))
    {
      paramObject = (List)paramObject;
      if ("size".equals(paramString)) {
        return Integer.valueOf(((List)paramObject).size());
      }
      localObject = new b(((List)paramObject).size());
      int i = 0;
      while (i < ((List)paramObject).size())
      {
        ((List)localObject).add(a(((List)paramObject).get(i), paramString, paramBoolean));
        i += 1;
      }
      return localObject;
    }
    if ((paramObject instanceof Enum))
    {
      localObject = (Enum)paramObject;
      if ("name".equals(paramString)) {
        return ((Enum)localObject).name();
      }
      if ("ordinal".equals(paramString)) {
        return Integer.valueOf(((Enum)localObject).ordinal());
      }
    }
    if ((paramObject instanceof Calendar))
    {
      paramObject = (Calendar)paramObject;
      if ("year".equals(paramString)) {
        return Integer.valueOf(((Calendar)paramObject).get(1));
      }
      if ("month".equals(paramString)) {
        return Integer.valueOf(((Calendar)paramObject).get(2));
      }
      if ("day".equals(paramString)) {
        return Integer.valueOf(((Calendar)paramObject).get(5));
      }
      if ("hour".equals(paramString)) {
        return Integer.valueOf(((Calendar)paramObject).get(11));
      }
      if ("minute".equals(paramString)) {
        return Integer.valueOf(((Calendar)paramObject).get(12));
      }
      if ("second".equals(paramString)) {
        return Integer.valueOf(((Calendar)paramObject).get(13));
      }
    }
    throw new g("jsonpath error, path " + this.c + ", segement " + paramString);
  }
  
  protected Collection<Object> a(Object paramObject)
  {
    JavaBeanSerializer localJavaBeanSerializer = c(paramObject.getClass());
    if (localJavaBeanSerializer != null) {
      try
      {
        paramObject = localJavaBeanSerializer.getFieldValues(paramObject);
        return (Collection<Object>)paramObject;
      }
      catch (Exception paramObject)
      {
        throw new g("jsonpath error, path " + this.c, (Throwable)paramObject);
      }
    }
    if ((paramObject instanceof Map)) {
      return ((Map)paramObject).values();
    }
    throw new UnsupportedOperationException();
  }
  
  protected void a()
  {
    if (this.d != null) {
      return;
    }
    if ("*".equals(this.c))
    {
      this.d = new s[] { x.a };
      return;
    }
    this.d = new i(this.c).explain();
  }
  
  /* Error */
  protected void a(Object paramObject, String paramString, List<Object> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: instanceof 139
    //   9: ifeq +69 -> 78
    //   12: aload_1
    //   13: checkcast 139	java/util/Map
    //   16: astore_1
    //   17: aload_1
    //   18: aload_2
    //   19: invokeinterface 143 2 0
    //   24: ifeq +18 -> 42
    //   27: aload_3
    //   28: aload_1
    //   29: aload_2
    //   30: invokeinterface 376 2 0
    //   35: invokeinterface 402 2 0
    //   40: pop
    //   41: return
    //   42: aload_1
    //   43: invokeinterface 437 1 0
    //   48: invokeinterface 199 1 0
    //   53: astore_1
    //   54: aload_1
    //   55: invokeinterface 163 1 0
    //   60: ifeq -56 -> 4
    //   63: aload_0
    //   64: aload_1
    //   65: invokeinterface 167 1 0
    //   70: aload_2
    //   71: aload_3
    //   72: invokevirtual 457	com/alibaba/fastjson/f:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/util/List;)V
    //   75: goto -21 -> 54
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 206	java/lang/Object:getClass	()Ljava/lang/Class;
    //   83: invokevirtual 384	com/alibaba/fastjson/f:c	(Ljava/lang/Class;)Lcom/alibaba/fastjson/serializer/JavaBeanSerializer;
    //   86: astore 5
    //   88: aload 5
    //   90: ifnull +169 -> 259
    //   93: aload 5
    //   95: aload_2
    //   96: invokevirtual 461	com/alibaba/fastjson/serializer/JavaBeanSerializer:getFieldSerializer	(Ljava/lang/String;)Lcom/alibaba/fastjson/serializer/FieldSerializer;
    //   99: astore 6
    //   101: aload 6
    //   103: ifnull +120 -> 223
    //   106: aload_3
    //   107: aload 6
    //   109: aload_1
    //   110: invokevirtual 466	com/alibaba/fastjson/serializer/FieldSerializer:getPropertyValueDirect	(Ljava/lang/Object;)Ljava/lang/Object;
    //   113: invokeinterface 402 2 0
    //   118: pop
    //   119: return
    //   120: astore_1
    //   121: new 240	com/alibaba/fastjson/d
    //   124: dup
    //   125: new 179	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 468
    //   135: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_2
    //   139: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: aload_1
    //   146: invokespecial 245	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: athrow
    //   150: astore_1
    //   151: new 124	com/alibaba/fastjson/g
    //   154: dup
    //   155: new 179	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 389
    //   165: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: getfield 130	com/alibaba/fastjson/f:c	Ljava/lang/String;
    //   172: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc_w 391
    //   178: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_2
    //   182: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: aload_1
    //   189: invokespecial 392	com/alibaba/fastjson/g:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   192: athrow
    //   193: astore_1
    //   194: new 240	com/alibaba/fastjson/d
    //   197: dup
    //   198: new 179	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 468
    //   208: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_2
    //   212: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: aload_1
    //   219: invokespecial 245	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: athrow
    //   223: aload 5
    //   225: aload_1
    //   226: invokevirtual 433	com/alibaba/fastjson/serializer/JavaBeanSerializer:getFieldValues	(Ljava/lang/Object;)Ljava/util/List;
    //   229: invokeinterface 469 1 0
    //   234: astore_1
    //   235: aload_1
    //   236: invokeinterface 163 1 0
    //   241: ifeq -237 -> 4
    //   244: aload_0
    //   245: aload_1
    //   246: invokeinterface 167 1 0
    //   251: aload_2
    //   252: aload_3
    //   253: invokevirtual 457	com/alibaba/fastjson/f:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/util/List;)V
    //   256: goto -21 -> 235
    //   259: aload_1
    //   260: instanceof 361
    //   263: ifeq -259 -> 4
    //   266: aload_1
    //   267: checkcast 361	java/util/List
    //   270: astore_1
    //   271: iconst_0
    //   272: istore 4
    //   274: iload 4
    //   276: aload_1
    //   277: invokeinterface 362 1 0
    //   282: if_icmpge -278 -> 4
    //   285: aload_0
    //   286: aload_1
    //   287: iload 4
    //   289: invokeinterface 365 2 0
    //   294: aload_2
    //   295: aload_3
    //   296: invokevirtual 457	com/alibaba/fastjson/f:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/util/List;)V
    //   299: iload 4
    //   301: iconst_1
    //   302: iadd
    //   303: istore 4
    //   305: goto -31 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	f
    //   0	308	1	paramObject	Object
    //   0	308	2	paramString	String
    //   0	308	3	paramList	List<Object>
    //   272	32	4	i	int
    //   86	138	5	localJavaBeanSerializer	JavaBeanSerializer
    //   99	9	6	localFieldSerializer	com.alibaba.fastjson.serializer.FieldSerializer
    // Exception table:
    //   from	to	target	type
    //   106	119	120	java/lang/reflect/InvocationTargetException
    //   93	101	150	java/lang/Exception
    //   106	119	150	java/lang/Exception
    //   121	150	150	java/lang/Exception
    //   194	223	150	java/lang/Exception
    //   223	235	150	java/lang/Exception
    //   235	256	150	java/lang/Exception
    //   106	119	193	java/lang/IllegalAccessException
  }
  
  protected boolean a(Object paramObject, String paramString)
  {
    if ((paramObject instanceof Map)) {
      return ((Map)paramObject).remove(paramString) != null;
    }
    Object localObject = this.f.getDeserializer(paramObject.getClass());
    if ((localObject instanceof JavaBeanDeserializer)) {}
    for (localObject = (JavaBeanDeserializer)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        paramString = ((JavaBeanDeserializer)localObject).getFieldDeserializer(paramString);
        if (paramString == null) {
          return false;
        }
        paramString.setValue(paramObject, null);
        return true;
      }
      throw new UnsupportedOperationException();
    }
  }
  
  protected boolean a(Object paramObject1, String paramString, Object paramObject2)
  {
    if ((paramObject1 instanceof Map))
    {
      ((Map)paramObject1).put(paramString, paramObject2);
      return true;
    }
    if ((paramObject1 instanceof List))
    {
      paramObject1 = ((List)paramObject1).iterator();
      while (((Iterator)paramObject1).hasNext())
      {
        localObject = ((Iterator)paramObject1).next();
        if (localObject != null) {
          a(localObject, paramString, paramObject2);
        }
      }
      return true;
    }
    Object localObject = this.f.getDeserializer(paramObject1.getClass());
    if ((localObject instanceof JavaBeanDeserializer)) {}
    for (localObject = (JavaBeanDeserializer)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        paramString = ((JavaBeanDeserializer)localObject).getFieldDeserializer(paramString);
        if (paramString == null) {
          return false;
        }
        paramString.setValue(paramObject1, paramObject2);
        return true;
      }
      throw new UnsupportedOperationException();
    }
  }
  
  public void arrayAdd(Object paramObject, Object... paramVarArgs)
  {
    int k = 0;
    int j = 0;
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    Object localObject2;
    int i;
    Object localObject1;
    for (;;)
    {
      return;
      if (paramObject != null)
      {
        a();
        localObject2 = null;
        i = 0;
        localObject1 = paramObject;
        while (i < this.d.length)
        {
          if (i == this.d.length - 1) {
            localObject2 = localObject1;
          }
          localObject1 = this.d[i].eval(this, paramObject, localObject1);
          i += 1;
        }
        if (localObject1 == null) {
          throw new g("value not found in path " + this.c);
        }
        if (!(localObject1 instanceof Collection)) {
          break;
        }
        paramObject = (Collection)localObject1;
        k = paramVarArgs.length;
        i = j;
        while (i < k)
        {
          ((Collection)paramObject).add(paramVarArgs[i]);
          i += 1;
        }
      }
    }
    paramObject = localObject1.getClass();
    if (((Class)paramObject).isArray())
    {
      j = Array.getLength(localObject1);
      paramObject = Array.newInstance(((Class)paramObject).getComponentType(), paramVarArgs.length + j);
      System.arraycopy(localObject1, 0, paramObject, 0, j);
      i = k;
      while (i < paramVarArgs.length)
      {
        Array.set(paramObject, j + i, paramVarArgs[i]);
        i += 1;
      }
    }
    throw new d("unsupported array put operation. " + paramObject);
    paramVarArgs = this.d[(this.d.length - 1)];
    if ((paramVarArgs instanceof p))
    {
      ((p)paramVarArgs).setValue(this, localObject2, paramObject);
      return;
    }
    if ((paramVarArgs instanceof a))
    {
      ((a)paramVarArgs).setValue(this, localObject2, paramObject);
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  int b(Object paramObject)
  {
    int j = -1;
    if (paramObject == null) {}
    int i;
    JavaBeanSerializer localJavaBeanSerializer;
    do
    {
      return j;
      if ((paramObject instanceof Collection)) {
        return ((Collection)paramObject).size();
      }
      if ((paramObject instanceof Object[])) {
        return ((Object[])paramObject).length;
      }
      if (paramObject.getClass().isArray()) {
        return Array.getLength(paramObject);
      }
      if ((paramObject instanceof Map))
      {
        i = 0;
        paramObject = ((Map)paramObject).values().iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)paramObject).hasNext()) {
            break;
          }
          if (((Iterator)paramObject).next() != null) {
            i += 1;
          }
        }
      }
      localJavaBeanSerializer = c(paramObject.getClass());
    } while (localJavaBeanSerializer == null);
    try
    {
      i = localJavaBeanSerializer.getSize(paramObject);
      return i;
    }
    catch (Exception paramObject)
    {
      throw new g("evalSize error : " + this.c, (Throwable)paramObject);
    }
  }
  
  protected JavaBeanSerializer c(Class<?> paramClass)
  {
    paramClass = this.e.getObjectWriter(paramClass);
    if ((paramClass instanceof JavaBeanSerializer)) {
      return (JavaBeanSerializer)paramClass;
    }
    return null;
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    a();
    int i = 0;
    Object localObject = paramObject;
    for (;;)
    {
      if (i >= this.d.length) {
        break label49;
      }
      localObject = this.d[i].eval(this, paramObject, localObject);
      if (localObject == null) {
        break;
      }
      i += 1;
    }
    label49:
    return true;
  }
  
  public boolean containsValue(Object paramObject1, Object paramObject2)
  {
    paramObject1 = eval(paramObject1);
    if (paramObject1 == paramObject2) {
      return true;
    }
    if (paramObject1 == null) {
      return false;
    }
    if ((paramObject1 instanceof Iterable))
    {
      paramObject1 = ((Iterable)paramObject1).iterator();
      while (((Iterator)paramObject1).hasNext()) {
        if (a(((Iterator)paramObject1).next(), paramObject2)) {
          return true;
        }
      }
      return false;
    }
    return a(paramObject1, paramObject2);
  }
  
  public Object eval(Object paramObject)
  {
    Object localObject2;
    if (paramObject == null)
    {
      localObject2 = null;
      return localObject2;
    }
    a();
    int i = 0;
    Object localObject1 = paramObject;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= this.d.length) {
        break;
      }
      localObject1 = this.d[i].eval(this, paramObject, localObject1);
      i += 1;
    }
  }
  
  public String getPath()
  {
    return this.c;
  }
  
  public boolean remove(Object paramObject)
  {
    if (paramObject == null) {}
    label127:
    for (;;)
    {
      return false;
      a();
      int i = 0;
      Object localObject = paramObject;
      if (i < this.d.length) {
        if (i != this.d.length - 1) {}
      }
      for (;;)
      {
        if (localObject == null) {
          break label127;
        }
        paramObject = this.d[(this.d.length - 1)];
        if ((paramObject instanceof p))
        {
          return ((p)paramObject).remove(this, localObject);
          localObject = this.d[i].eval(this, paramObject, localObject);
          if (localObject == null)
          {
            localObject = null;
            continue;
          }
          i += 1;
          break;
        }
        if ((paramObject instanceof a)) {
          return ((a)paramObject).remove(this, localObject);
        }
        throw new UnsupportedOperationException();
        localObject = null;
      }
    }
  }
  
  public boolean removeArrayItem(f paramf, Object paramObject, int paramInt)
  {
    if ((paramObject instanceof List))
    {
      paramf = (List)paramObject;
      if (paramInt >= 0)
      {
        if (paramInt >= paramf.size()) {
          return false;
        }
        paramf.remove(paramInt);
      }
      for (;;)
      {
        return true;
        paramInt = paramf.size() + paramInt;
        if (paramInt < 0) {
          break;
        }
        paramf.remove(paramInt);
      }
    }
    paramf = paramObject.getClass();
    throw new g("unsupported set operation." + paramf);
  }
  
  public boolean set(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {}
    int i;
    Object localObject2;
    label18:
    s locals;
    label74:
    do
    {
      return false;
      a();
      i = 0;
      localObject1 = null;
      localObject2 = paramObject1;
      if (i >= this.d.length) {
        break label201;
      }
      locals = this.d[i];
      localObject1 = locals.eval(this, paramObject1, localObject2);
      if (localObject1 != null) {
        break label282;
      }
      if (i >= this.d.length - 1) {
        break label276;
      }
      localObject1 = this.d[(i + 1)];
      if (!(localObject1 instanceof p)) {
        break;
      }
    } while (c(localObject2.getClass()) != null);
    Object localObject1 = new e();
    label103:
    Object localObject3 = localObject2;
    if (localObject1 != null) {
      if ((locals instanceof p)) {
        ((p)locals).setValue(this, localObject2, localObject1);
      }
    }
    label201:
    label276:
    label282:
    for (;;)
    {
      i += 1;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break label18;
      if ((localObject1 instanceof a))
      {
        localObject1 = new b();
        break label103;
        localObject3 = localObject2;
        if ((locals instanceof a))
        {
          ((a)locals).setValue(this, localObject2, localObject1);
          continue;
          localObject3 = localObject1;
        }
        if (localObject3 == null) {
          break;
        }
        paramObject1 = this.d[(this.d.length - 1)];
        if ((paramObject1 instanceof p))
        {
          ((p)paramObject1).setValue(this, localObject3, paramObject2);
          return true;
        }
        if ((paramObject1 instanceof a)) {
          return ((a)paramObject1).setValue(this, localObject3, paramObject2);
        }
        throw new UnsupportedOperationException();
      }
      localObject1 = null;
      break label103;
      localObject1 = null;
      break label74;
    }
  }
  
  public boolean setArrayItem(f paramf, Object paramObject1, int paramInt, Object paramObject2)
  {
    if ((paramObject1 instanceof List))
    {
      paramf = (List)paramObject1;
      if (paramInt >= 0) {
        paramf.set(paramInt, paramObject2);
      }
    }
    int i;
    do
    {
      do
      {
        return true;
        paramf.set(paramf.size() + paramInt, paramObject2);
        return true;
        paramf = paramObject1.getClass();
        if (!paramf.isArray()) {
          break label105;
        }
        i = Array.getLength(paramObject1);
        if (paramInt < 0) {
          break;
        }
      } while (paramInt >= i);
      Array.set(paramObject1, paramInt, paramObject2);
      return true;
    } while (Math.abs(paramInt) > i);
    Array.set(paramObject1, i + paramInt, paramObject2);
    return true;
    label105:
    throw new g("unsupported set operation." + paramf);
  }
  
  public int size(Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    a();
    int i = 0;
    Object localObject = paramObject;
    while (i < this.d.length)
    {
      localObject = this.d[i].eval(this, paramObject, localObject);
      i += 1;
    }
    return b(localObject);
  }
  
  public String toJSONString()
  {
    return a.toJSONString(this.c);
  }
  
  static class a
    implements f.s
  {
    private final int a;
    
    public a(int paramInt)
    {
      this.a = paramInt;
    }
    
    public Object eval(f paramf, Object paramObject1, Object paramObject2)
    {
      return paramf.a(paramObject2, this.a);
    }
    
    public boolean remove(f paramf, Object paramObject)
    {
      return paramf.removeArrayItem(paramf, paramObject, this.a);
    }
    
    public boolean setValue(f paramf, Object paramObject1, Object paramObject2)
    {
      return paramf.setArrayItem(paramf, paramObject1, this.a, paramObject2);
    }
  }
  
  static class b
    implements f.c
  {
    private final String a;
    private final double b;
    private final f.o c;
    
    public b(String paramString, double paramDouble, f.o paramo)
    {
      this.a = paramString;
      this.b = paramDouble;
      this.c = paramo;
    }
    
    public boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      boolean bool = true;
      paramf = paramf.a(paramObject3, this.a, false);
      if (paramf == null) {
        bool = false;
      }
      double d;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool;
                if (!(paramf instanceof Number)) {
                  return false;
                }
                d = ((Number)paramf).doubleValue();
                if (this.c == f.o.a)
                {
                  if (d == this.b) {}
                  for (bool = true;; bool = false) {
                    return bool;
                  }
                }
                if (this.c != f.o.b) {
                  break;
                }
              } while (d != this.b);
              return false;
              if (this.c != f.o.d) {
                break;
              }
            } while (d >= this.b);
            return false;
            if (this.c != f.o.c) {
              break;
            }
          } while (d > this.b);
          return false;
          if (this.c != f.o.f) {
            break;
          }
        } while (d <= this.b);
        return false;
        if (this.c != f.o.e) {
          break;
        }
      } while (d < this.b);
      return false;
      return false;
    }
  }
  
  static abstract interface c
  {
    public abstract boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3);
  }
  
  public static class d
    implements f.s
  {
    private final f.c a;
    
    public d(f.c paramc)
    {
      this.a = paramc;
    }
    
    public Object eval(f paramf, Object paramObject1, Object paramObject2)
    {
      Object localObject1;
      if (paramObject2 == null) {
        localObject1 = null;
      }
      do
      {
        return localObject1;
        localObject1 = new b();
        if ((paramObject2 instanceof Iterable))
        {
          Iterator localIterator = ((Iterable)paramObject2).iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = localIterator.next();
            if (this.a.apply(paramf, paramObject1, paramObject2, localObject2)) {
              ((List)localObject1).add(localObject2);
            }
          }
          return localObject1;
        }
        localObject1 = paramObject2;
      } while (this.a.apply(paramf, paramObject1, paramObject2, paramObject2));
      return null;
    }
  }
  
  static class e
    implements f.c
  {
    private final String a;
    private final long b;
    private final long c;
    private final boolean d;
    
    public e(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramBoolean;
    }
    
    public boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      paramf = paramf.a(paramObject3, this.a, false);
      if (paramf == null) {
        return false;
      }
      if ((paramf instanceof Number))
      {
        long l = ((Number)paramf).longValue();
        if ((l >= this.b) && (l <= this.c))
        {
          if (!this.d) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
      }
      return this.d;
    }
  }
  
  static class f
    implements f.c
  {
    private final String a;
    private final long[] b;
    private final boolean c;
    
    public f(String paramString, long[] paramArrayOfLong, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramArrayOfLong;
      this.c = paramBoolean;
    }
    
    public boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      paramf = paramf.a(paramObject3, this.a, false);
      if (paramf == null) {
        return false;
      }
      if ((paramf instanceof Number))
      {
        long l = ((Number)paramf).longValue();
        paramf = this.b;
        int j = paramf.length;
        int i = 0;
        while (i < j)
        {
          if (paramf[i] == l)
          {
            if (!this.c) {}
            for (boolean bool = true;; bool = false) {
              return bool;
            }
          }
          i += 1;
        }
      }
      return this.c;
    }
  }
  
  static class g
    implements f.c
  {
    private final String a;
    private final Long[] b;
    private final boolean c;
    
    public g(String paramString, Long[] paramArrayOfLong, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramArrayOfLong;
      this.c = paramBoolean;
    }
    
    public boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      boolean bool = true;
      paramf = paramf.a(paramObject3, this.a, false);
      int j;
      int i;
      if (paramf == null)
      {
        paramf = this.b;
        j = paramf.length;
        i = 0;
        while (i < j)
        {
          if (paramf[i] == null) {
            return !this.c;
          }
          i += 1;
        }
        return this.c;
      }
      if ((paramf instanceof Number))
      {
        long l = ((Number)paramf).longValue();
        paramf = this.b;
        j = paramf.length;
        i = 0;
        if (i < j)
        {
          paramObject1 = paramf[i];
          if (paramObject1 == null) {}
          while (((Long)paramObject1).longValue() != l)
          {
            i += 1;
            break;
          }
          if (!this.c) {}
          for (;;)
          {
            return bool;
            bool = false;
          }
        }
      }
      return this.c;
    }
  }
  
  static class h
    implements f.c
  {
    private final String a;
    private final long b;
    private final f.o c;
    
    public h(String paramString, long paramLong, f.o paramo)
    {
      this.a = paramString;
      this.b = paramLong;
      this.c = paramo;
    }
    
    public boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      boolean bool = true;
      paramf = paramf.a(paramObject3, this.a, false);
      if (paramf == null) {
        bool = false;
      }
      long l;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool;
                if (!(paramf instanceof Number)) {
                  return false;
                }
                l = ((Number)paramf).longValue();
                if (this.c == f.o.a)
                {
                  if (l == this.b) {}
                  for (bool = true;; bool = false) {
                    return bool;
                  }
                }
                if (this.c != f.o.b) {
                  break;
                }
              } while (l != this.b);
              return false;
              if (this.c != f.o.d) {
                break;
              }
            } while (l >= this.b);
            return false;
            if (this.c != f.o.c) {
              break;
            }
          } while (l > this.b);
          return false;
          if (this.c != f.o.f) {
            break;
          }
        } while (l <= this.b);
        return false;
        if (this.c != f.o.e) {
          break;
        }
      } while (l < this.b);
      return false;
      return false;
    }
  }
  
  static class i
  {
    private final String a;
    private int b;
    private char c;
    private int d;
    
    public i(String paramString)
    {
      this.a = paramString;
      a();
    }
    
    static boolean a(char paramChar)
    {
      return (paramChar == '-') || (paramChar == '+') || ((paramChar >= '0') && (paramChar <= '9'));
    }
    
    protected double a(long paramLong)
    {
      int i = this.b;
      a();
      while ((this.c >= '0') && (this.c <= '9')) {
        a();
      }
      int j = this.b;
      return Double.parseDouble(this.a.substring(i - 1, j - 1)) + paramLong;
    }
    
    f.s a(String paramString)
    {
      int i = 0;
      int j = 0;
      int m = paramString.length();
      int n = paramString.charAt(0);
      int i1 = paramString.charAt(m - 1);
      int k = paramString.indexOf(',');
      Object localObject;
      String str;
      if ((paramString.length() > 2) && (n == 39) && (i1 == 39))
      {
        if (k == -1) {
          return new f.p(paramString.substring(1, m - 1), false);
        }
        paramString = paramString.split(",");
        localObject = new String[paramString.length];
        i = j;
        while (i < paramString.length)
        {
          str = paramString[i];
          localObject[i] = str.substring(1, str.length() - 1);
          i += 1;
        }
        return new f.l((String[])localObject);
      }
      j = paramString.indexOf(':');
      if ((k == -1) && (j == -1)) {
        return new f.a(Integer.parseInt(paramString));
      }
      if (k != -1)
      {
        paramString = paramString.split(",");
        localObject = new int[paramString.length];
        while (i < paramString.length)
        {
          localObject[i] = Integer.parseInt(paramString[i]);
          i += 1;
        }
        return new f.k((int[])localObject);
      }
      if (j != -1)
      {
        paramString = paramString.split(":");
        localObject = new int[paramString.length];
        i = 0;
        if (i < paramString.length)
        {
          str = paramString[i];
          if (str.length() == 0) {
            if (i == 0) {
              localObject[i] = 0;
            }
          }
          for (;;)
          {
            i += 1;
            break;
            throw new UnsupportedOperationException();
            localObject[i] = Integer.parseInt(str);
          }
        }
        k = localObject[0];
        if (localObject.length > 1)
        {
          i = localObject[1];
          if (localObject.length != 3) {
            break label381;
          }
        }
        label381:
        for (j = localObject[2];; j = 1)
        {
          if ((i < 0) || (i >= k)) {
            break label386;
          }
          throw new UnsupportedOperationException("end must greater than or equals start. start " + k + ",  end " + i);
          i = -1;
          break;
        }
        label386:
        if (j <= 0) {
          throw new UnsupportedOperationException("step must greater than zero : " + j);
        }
        return new f.q(k, i, j);
      }
      throw new UnsupportedOperationException();
    }
    
    f.s a(boolean paramBoolean)
    {
      boolean bool = true;
      if (paramBoolean) {
        b('[');
      }
      if (this.c == '?')
      {
        a();
        b('(');
        if (this.c == '@')
        {
          a();
          b('.');
        }
      }
      for (int i = 1;; i = 0)
      {
        String str;
        Object localObject1;
        Object localObject2;
        label384:
        int j;
        Object localObject3;
        label483:
        label630:
        long l;
        if ((i != 0) || (IOUtils.firstIdentifier(this.c)))
        {
          str = g();
          skipWhitespace();
          if ((i != 0) && (this.c == ')'))
          {
            a();
            if (paramBoolean) {
              b(']');
            }
            localObject1 = new f.d(new f.m(str));
            return (f.s)localObject1;
          }
          if ((paramBoolean) && (this.c == ']'))
          {
            a();
            return new f.d(new f.m(str));
          }
          localObject2 = f();
          skipWhitespace();
          if ((localObject2 == f.o.m) || (localObject2 == f.o.n))
          {
            if (localObject2 == f.o.n) {}
            for (paramBoolean = bool;; paramBoolean = false)
            {
              localObject1 = e();
              if ("and".equalsIgnoreCase(g())) {
                break;
              }
              throw new g(this.a);
            }
            localObject2 = e();
            if ((localObject1 == null) || (localObject2 == null)) {
              throw new g(this.a);
            }
            if ((f.b(localObject1.getClass())) && (f.b(localObject2.getClass()))) {
              return new f.d(new f.e(str, ((Number)localObject1).longValue(), ((Number)localObject2).longValue(), paramBoolean));
            }
            throw new g(this.a);
          }
          if ((localObject2 == f.o.k) || (localObject2 == f.o.l))
          {
            int k;
            if (localObject2 == f.o.l)
            {
              bool = true;
              b('(');
              localObject1 = new b();
              ((List)localObject1).add(e());
              skipWhitespace();
              if (this.c == ',') {
                break label483;
              }
              b(')');
              if (i != 0) {
                b(')');
              }
              if (paramBoolean) {
                b(']');
              }
              localObject2 = ((List)localObject1).iterator();
              j = 1;
              k = 1;
              i = 1;
            }
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label630;
              }
              localObject3 = ((Iterator)localObject2).next();
              if (localObject3 == null)
              {
                if (i == 0) {
                  continue;
                }
                i = 0;
                continue;
                bool = false;
                break;
                a();
                ((List)localObject1).add(e());
                break label384;
              }
              localObject3 = localObject3.getClass();
              int n = k;
              int m = i;
              if (i != 0)
              {
                n = k;
                m = i;
                if (localObject3 != Byte.class)
                {
                  n = k;
                  m = i;
                  if (localObject3 != Short.class)
                  {
                    n = k;
                    m = i;
                    if (localObject3 != Integer.class)
                    {
                      n = k;
                      m = i;
                      if (localObject3 != Long.class)
                      {
                        n = 0;
                        m = 0;
                      }
                    }
                  }
                }
              }
              k = n;
              i = m;
              if (j != 0)
              {
                k = n;
                i = m;
                if (localObject3 != String.class)
                {
                  j = 0;
                  k = n;
                  i = m;
                }
              }
            }
            if ((((List)localObject1).size() == 1) && (((List)localObject1).get(0) == null))
            {
              if (bool) {
                return new f.d(new f.m(str));
              }
              return new f.d(new f.n(str));
            }
            if (i != 0)
            {
              if (((List)localObject1).size() == 1)
              {
                l = ((Number)((List)localObject1).get(0)).longValue();
                if (bool) {}
                for (localObject1 = f.o.b;; localObject1 = f.o.a) {
                  return new f.d(new f.h(str, l, (f.o)localObject1));
                }
              }
              localObject2 = new long[((List)localObject1).size()];
              i = 0;
              while (i < localObject2.length)
              {
                localObject2[i] = ((Number)((List)localObject1).get(i)).longValue();
                i += 1;
              }
              return new f.d(new f.f(str, (long[])localObject2, bool));
            }
            if (j != 0)
            {
              if (((List)localObject1).size() == 1)
              {
                localObject2 = (String)((List)localObject1).get(0);
                if (bool) {}
                for (localObject1 = f.o.b;; localObject1 = f.o.a) {
                  return new f.d(new f.v(str, (String)localObject2, (f.o)localObject1));
                }
              }
              localObject2 = new String[((List)localObject1).size()];
              ((List)localObject1).toArray((Object[])localObject2);
              return new f.d(new f.u(str, (String[])localObject2, bool));
            }
            if (k != 0)
            {
              localObject2 = new Long[((List)localObject1).size()];
              i = 0;
              while (i < localObject2.length)
              {
                localObject3 = (Number)((List)localObject1).get(i);
                if (localObject3 != null) {
                  localObject2[i] = Long.valueOf(((Number)localObject3).longValue());
                }
                i += 1;
              }
              return new f.d(new f.g(str, (Long[])localObject2, bool));
            }
            throw new UnsupportedOperationException();
          }
          if ((this.c == '\'') || (this.c == '"'))
          {
            localObject3 = h();
            if (i != 0) {
              b(')');
            }
            if (paramBoolean) {
              b(']');
            }
            if (localObject2 == f.o.i) {
              return new f.d(new f.r(str, (String)localObject3, false));
            }
            if (localObject2 == f.o.j) {
              return new f.d(new f.r(str, (String)localObject3, true));
            }
            localObject1 = localObject3;
            if (localObject2 != f.o.g) {
              if (localObject2 != f.o.h) {
                break label2150;
              }
            }
            for (localObject1 = localObject3; ((String)localObject1).indexOf("%%") != -1; localObject1 = ((String)localObject1).replaceAll("%%", "%")) {}
            if (localObject2 == f.o.h)
            {
              paramBoolean = true;
              label1206:
              i = ((String)localObject1).indexOf('%');
              if (i != -1) {
                break label1268;
              }
              if (localObject2 != f.o.g) {
                break label1260;
              }
              localObject2 = f.o.a;
            }
          }
        }
        for (;;)
        {
          return new f.d(new f.v(str, (String)localObject1, (f.o)localObject2));
          paramBoolean = false;
          break label1206;
          label1260:
          localObject2 = f.o.b;
          continue;
          label1268:
          localObject2 = ((String)localObject1).split("%");
          localObject3 = null;
          if (i == 0) {
            if (((String)localObject1).charAt(((String)localObject1).length() - 1) == '%')
            {
              localObject3 = new String[localObject2.length - 1];
              System.arraycopy(localObject2, 1, localObject3, 0, localObject3.length);
              localObject2 = null;
              localObject1 = null;
            }
          }
          for (;;)
          {
            return new f.d(new f.j(str, (String)localObject1, (String)localObject2, (String[])localObject3, paramBoolean));
            localObject1 = localObject2[(localObject2.length - 1)];
            if (localObject2.length > 2)
            {
              localObject3 = new String[localObject2.length - 2];
              System.arraycopy(localObject2, 1, localObject3, 0, localObject3.length);
              localObject2 = localObject1;
              localObject1 = null;
              continue;
              if (((String)localObject1).charAt(((String)localObject1).length() - 1) == '%')
              {
                localObject3 = localObject2;
                localObject1 = null;
                localObject2 = null;
                continue;
              }
              if (localObject2.length == 1)
              {
                localObject1 = localObject2[0];
                localObject2 = null;
                continue;
              }
              if (localObject2.length == 2)
              {
                localObject1 = localObject2[0];
                localObject2 = localObject2[1];
                continue;
              }
              localObject1 = localObject2[0];
              Object localObject4 = localObject2[(localObject2.length - 1)];
              localObject3 = new String[localObject2.length - 2];
              System.arraycopy(localObject2, 1, localObject3, 0, localObject3.length);
              localObject2 = localObject4;
              continue;
              if (a(this.c))
              {
                l = d();
                double d1 = 0.0D;
                if (this.c == '.') {
                  d1 = a(l);
                }
                if (i != 0) {
                  b(')');
                }
                if (paramBoolean) {
                  b(']');
                }
                if (d1 == 0.0D) {
                  return new f.d(new f.h(str, l, (f.o)localObject2));
                }
                return new f.d(new f.b(str, d1, (f.o)localObject2));
              }
              if (this.c == 'n')
              {
                if ("null".equals(g()))
                {
                  if (i != 0) {
                    b(')');
                  }
                  b(']');
                  if (localObject2 == f.o.a) {
                    return new f.d(new f.n(str));
                  }
                  if (localObject2 == f.o.b) {
                    return new f.d(new f.m(str));
                  }
                  throw new UnsupportedOperationException();
                }
              }
              else if (this.c == 't')
              {
                if ("true".equals(g()))
                {
                  if (i != 0) {
                    b(')');
                  }
                  b(']');
                  if (localObject2 == f.o.a) {
                    return new f.d(new f.w(str, Boolean.TRUE, true));
                  }
                  if (localObject2 == f.o.b) {
                    return new f.d(new f.w(str, Boolean.TRUE, false));
                  }
                  throw new UnsupportedOperationException();
                }
              }
              else if ((this.c == 'f') && ("false".equals(g())))
              {
                if (i != 0) {
                  b(')');
                }
                b(']');
                if (localObject2 == f.o.a) {
                  return new f.d(new f.w(str, Boolean.FALSE, true));
                }
                if (localObject2 == f.o.b) {
                  return new f.d(new f.w(str, Boolean.FALSE, false));
                }
                throw new UnsupportedOperationException();
              }
              throw new UnsupportedOperationException();
              j = this.b;
              if ((this.c == ']') || (this.c == '/') || (b()) || ((this.c == '.') && (i == 0) && (i == 0)))
              {
                if (!paramBoolean) {
                  break label2066;
                }
                i = this.b - 1;
              }
              for (;;)
              {
                localObject1 = this.a.substring(j - 1, i);
                if (((String)localObject1).indexOf("\\.") == -1) {
                  break label2104;
                }
                return new f.p(((String)localObject1).replaceAll("\\\\\\.", "\\."), false);
                if (this.c == '\\') {
                  a();
                }
                a();
                break;
                label2066:
                if ((this.c == '/') || (this.c == '.')) {
                  i = this.b - 1;
                } else {
                  i = this.b;
                }
              }
              label2104:
              localObject2 = a((String)localObject1);
              localObject1 = localObject2;
              if (!paramBoolean) {
                break;
              }
              localObject1 = localObject2;
              if (b()) {
                break;
              }
              b(']');
              return (f.s)localObject2;
            }
            localObject2 = localObject1;
            localObject1 = null;
          }
          label2150:
          localObject1 = localObject3;
        }
      }
    }
    
    void a()
    {
      String str = this.a;
      int i = this.b;
      this.b = (i + 1);
      this.c = str.charAt(i);
    }
    
    void b(char paramChar)
    {
      if (this.c != paramChar) {
        throw new g("expect '" + paramChar + ", but '" + this.c + "'");
      }
      if (!b()) {
        a();
      }
    }
    
    boolean b()
    {
      return this.b >= this.a.length();
    }
    
    f.s c()
    {
      boolean bool = true;
      if ((this.d == 0) && (this.a.length() == 1))
      {
        if (a(this.c)) {
          return new f.a(this.c - '0');
        }
        if (((this.c >= 'a') && (this.c <= 'z')) || ((this.c >= 'A') && (this.c <= 'Z'))) {
          return new f.p(Character.toString(this.c), false);
        }
      }
      for (;;)
      {
        if (!b())
        {
          skipWhitespace();
          if (this.c == '$')
          {
            a();
          }
          else if ((this.c == '.') || (this.c == '/'))
          {
            int i = this.c;
            a();
            if ((i != 46) || (this.c != '.')) {
              break label333;
            }
            a();
          }
        }
      }
      for (;;)
      {
        if (this.c == '*')
        {
          if (!b()) {
            a();
          }
          return f.x.a;
        }
        if (a(this.c)) {
          return a(false);
        }
        String str = g();
        if (this.c == '(')
        {
          a();
          if (this.c == ')')
          {
            if (!b()) {
              a();
            }
            if ("size".equals(str)) {
              return f.t.a;
            }
            throw new UnsupportedOperationException();
          }
          throw new UnsupportedOperationException();
        }
        return new f.p(str, bool);
        if (this.c == '[') {
          return a(true);
        }
        if (this.d == 0) {
          return new f.p(g(), false);
        }
        throw new UnsupportedOperationException();
        return null;
        label333:
        bool = false;
      }
    }
    
    protected long d()
    {
      int i = this.b;
      if ((this.c == '+') || (this.c == '-')) {
        a();
      }
      while ((this.c >= '0') && (this.c <= '9')) {
        a();
      }
      int j = this.b;
      return Long.parseLong(this.a.substring(i - 1, j - 1));
    }
    
    protected Object e()
    {
      skipWhitespace();
      if (a(this.c)) {
        return Long.valueOf(d());
      }
      if ((this.c == '"') || (this.c == '\'')) {
        return h();
      }
      if (this.c == 'n')
      {
        if ("null".equals(g())) {
          return null;
        }
        throw new g(this.a);
      }
      throw new UnsupportedOperationException();
    }
    
    public f.s[] explain()
    {
      if ((this.a == null) || (this.a.length() == 0)) {
        throw new IllegalArgumentException();
      }
      for (Object localObject1 = new f.s[8];; localObject1 = localObject2)
      {
        f.s locals = c();
        if (locals == null)
        {
          if (this.d != localObject1.length) {
            break;
          }
          return (f.s[])localObject1;
        }
        localObject2 = localObject1;
        if (this.d == localObject1.length)
        {
          localObject2 = new f.s[this.d * 3 / 2];
          System.arraycopy(localObject1, 0, localObject2, 0, this.d);
        }
        int i = this.d;
        this.d = (i + 1);
        localObject2[i] = locals;
      }
      Object localObject2 = new f.s[this.d];
      System.arraycopy(localObject1, 0, localObject2, 0, this.d);
      return (f.s[])localObject2;
    }
    
    protected f.o f()
    {
      Object localObject1 = null;
      if (this.c == '=')
      {
        a();
        localObject1 = f.o.a;
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = g();
          if (!"not".equalsIgnoreCase((String)localObject1)) {
            break label221;
          }
          skipWhitespace();
          localObject1 = g();
          if (!"like".equalsIgnoreCase((String)localObject1)) {
            break;
          }
          localObject2 = f.o.h;
        }
        return (f.o)localObject2;
        if (this.c == '!')
        {
          a();
          b('=');
          localObject1 = f.o.b;
        }
        else if (this.c == '<')
        {
          a();
          if (this.c == '=')
          {
            a();
            localObject1 = f.o.f;
          }
          else
          {
            localObject1 = f.o.e;
          }
        }
        else if (this.c == '>')
        {
          a();
          if (this.c == '=')
          {
            a();
            localObject1 = f.o.d;
          }
          else
          {
            localObject1 = f.o.c;
          }
        }
      }
      if ("rlike".equalsIgnoreCase((String)localObject1)) {
        return f.o.j;
      }
      if ("in".equalsIgnoreCase((String)localObject1)) {
        return f.o.l;
      }
      if ("between".equalsIgnoreCase((String)localObject1)) {
        return f.o.n;
      }
      throw new UnsupportedOperationException();
      label221:
      if ("like".equalsIgnoreCase((String)localObject1)) {
        return f.o.g;
      }
      if ("rlike".equalsIgnoreCase((String)localObject1)) {
        return f.o.i;
      }
      if ("in".equalsIgnoreCase((String)localObject1)) {
        return f.o.k;
      }
      if ("between".equalsIgnoreCase((String)localObject1)) {
        return f.o.m;
      }
      throw new UnsupportedOperationException();
    }
    
    String g()
    {
      skipWhitespace();
      if ((this.c != '\\') && (!IOUtils.firstIdentifier(this.c))) {
        throw new g("illeal jsonpath syntax. " + this.a);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        if (!b())
        {
          if (this.c != '\\') {
            break label136;
          }
          a();
          localStringBuilder.append(this.c);
          if (!b()) {
            break label129;
          }
        }
        label129:
        label136:
        while (!IOUtils.isIdent(this.c))
        {
          if ((b()) && (IOUtils.isIdent(this.c))) {
            localStringBuilder.append(this.c);
          }
          return localStringBuilder.toString();
          a();
          break;
        }
        localStringBuilder.append(this.c);
        a();
      }
    }
    
    String h()
    {
      char c1 = this.c;
      a();
      int j = this.b;
      while ((this.c != c1) && (!b())) {
        a();
      }
      String str = this.a;
      if (b()) {}
      for (int i = this.b;; i = this.b - 1)
      {
        str = str.substring(j - 1, i);
        b(c1);
        return str;
      }
    }
    
    public final void skipWhitespace()
    {
      while ((this.c <= ' ') && ((this.c == ' ') || (this.c == '\r') || (this.c == '\n') || (this.c == '\t') || (this.c == '\f') || (this.c == '\b'))) {
        a();
      }
    }
  }
  
  static class j
    implements f.c
  {
    private final String a;
    private final String b;
    private final String c;
    private final String[] d;
    private final int e;
    private final boolean f;
    
    public j(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, boolean paramBoolean)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramArrayOfString;
      this.f = paramBoolean;
      if (paramString2 != null) {}
      for (int j = paramString2.length() + 0;; j = 0)
      {
        int i = j;
        if (paramString3 != null) {
          i = j + paramString3.length();
        }
        int k = i;
        if (paramArrayOfString != null)
        {
          int n = paramArrayOfString.length;
          j = m;
          for (;;)
          {
            k = i;
            if (j >= n) {
              break;
            }
            k = paramArrayOfString[j].length();
            j += 1;
            i = k + i;
          }
        }
        this.e = k;
        return;
      }
    }
    
    public boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      paramf = paramf.a(paramObject3, this.a, false);
      if (paramf == null) {
        return false;
      }
      paramf = paramf.toString();
      if (paramf.length() < this.e) {
        return this.f;
      }
      if (this.b != null) {
        if (!paramf.startsWith(this.b)) {
          return this.f;
        }
      }
      for (int i = this.b.length() + 0;; i = 0)
      {
        if (this.d != null)
        {
          paramObject1 = this.d;
          int m = paramObject1.length;
          int k = 0;
          int j = i;
          i = k;
          while (i < m)
          {
            paramObject2 = paramObject1[i];
            j = paramf.indexOf((String)paramObject2, j);
            if (j == -1) {
              return this.f;
            }
            j += ((String)paramObject2).length();
            i += 1;
          }
        }
        if ((this.c != null) && (!paramf.endsWith(this.c))) {
          return this.f;
        }
        if (this.f) {
          break;
        }
        return true;
      }
    }
  }
  
  static class k
    implements f.s
  {
    private final int[] a;
    
    public k(int[] paramArrayOfInt)
    {
      this.a = paramArrayOfInt;
    }
    
    public Object eval(f paramf, Object paramObject1, Object paramObject2)
    {
      paramObject1 = new ArrayList(this.a.length);
      int i = 0;
      while (i < this.a.length)
      {
        ((List)paramObject1).add(paramf.a(paramObject2, this.a[i]));
        i += 1;
      }
      return paramObject1;
    }
  }
  
  static class l
    implements f.s
  {
    private final String[] a;
    
    public l(String[] paramArrayOfString)
    {
      this.a = paramArrayOfString;
    }
    
    public Object eval(f paramf, Object paramObject1, Object paramObject2)
    {
      paramObject1 = new ArrayList(this.a.length);
      String[] arrayOfString = this.a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        ((List)paramObject1).add(paramf.a(paramObject2, arrayOfString[i], true));
        i += 1;
      }
      return paramObject1;
    }
  }
  
  static class m
    implements f.c
  {
    private final String a;
    
    public m(String paramString)
    {
      this.a = paramString;
    }
    
    public boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      boolean bool = false;
      if (paramf.a(paramObject3, this.a, false) != null) {
        bool = true;
      }
      return bool;
    }
  }
  
  static class n
    implements f.c
  {
    private final String a;
    
    public n(String paramString)
    {
      this.a = paramString;
    }
    
    public boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      boolean bool = false;
      if (paramf.a(paramObject3, this.a, false) == null) {
        bool = true;
      }
      return bool;
    }
  }
  
  static enum o
  {
    private o() {}
  }
  
  static class p
    implements f.s
  {
    private final String a;
    private final boolean b;
    
    public p(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }
    
    public Object eval(f paramf, Object paramObject1, Object paramObject2)
    {
      if (this.b)
      {
        paramObject1 = new ArrayList();
        paramf.a(paramObject2, this.a, (List)paramObject1);
        return paramObject1;
      }
      return paramf.a(paramObject2, this.a, true);
    }
    
    public boolean remove(f paramf, Object paramObject)
    {
      return paramf.a(paramObject, this.a);
    }
    
    public void setValue(f paramf, Object paramObject1, Object paramObject2)
    {
      paramf.a(paramObject1, this.a, paramObject2);
    }
  }
  
  static class q
    implements f.s
  {
    private final int a;
    private final int b;
    private final int c;
    
    public q(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }
    
    public Object eval(f paramf, Object paramObject1, Object paramObject2)
    {
      int k = f.t.a.eval(paramf, paramObject1, paramObject2).intValue();
      int i;
      if (this.a >= 0)
      {
        i = this.a;
        if (this.b < 0) {
          break label74;
        }
      }
      int m;
      label74:
      for (int j = this.b;; j = this.b + k)
      {
        m = (j - i) / this.c + 1;
        if (m != -1) {
          break label86;
        }
        return null;
        i = this.a + k;
        break;
      }
      label86:
      paramObject1 = new ArrayList(m);
      while ((i <= j) && (i < k))
      {
        ((List)paramObject1).add(paramf.a(paramObject2, i));
        i += this.c;
      }
      return paramObject1;
    }
  }
  
  static class r
    implements f.c
  {
    private final String a;
    private final Pattern b;
    private final boolean c;
    
    public r(String paramString1, String paramString2, boolean paramBoolean)
    {
      this.a = paramString1;
      this.b = Pattern.compile(paramString2);
      this.c = paramBoolean;
    }
    
    public boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      paramf = paramf.a(paramObject3, this.a, false);
      if (paramf == null) {}
      boolean bool;
      do
      {
        return false;
        paramf = paramf.toString();
        bool = this.b.matcher(paramf).matches();
        if (!this.c) {
          break;
        }
      } while (bool);
      return true;
      return bool;
    }
  }
  
  static abstract interface s
  {
    public abstract Object eval(f paramf, Object paramObject1, Object paramObject2);
  }
  
  static class t
    implements f.s
  {
    public static final t a = new t();
    
    public Integer eval(f paramf, Object paramObject1, Object paramObject2)
    {
      return Integer.valueOf(paramf.b(paramObject2));
    }
  }
  
  static class u
    implements f.c
  {
    private final String a;
    private final String[] b;
    private final boolean c;
    
    public u(String paramString, String[] paramArrayOfString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramArrayOfString;
      this.c = paramBoolean;
    }
    
    public boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      paramf = paramf.a(paramObject3, this.a, false);
      paramObject1 = this.b;
      int j = paramObject1.length;
      int i = 0;
      while (i < j)
      {
        paramObject2 = paramObject1[i];
        if (paramObject2 == paramf) {
          if (this.c) {}
        }
        do
        {
          return true;
          return false;
          if ((paramObject2 == null) || (!((String)paramObject2).equals(paramf))) {
            break;
          }
        } while (!this.c);
        return false;
        i += 1;
      }
      return this.c;
    }
  }
  
  static class v
    implements f.c
  {
    private final String a;
    private final String b;
    private final f.o c;
    
    public v(String paramString1, String paramString2, f.o paramo)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramo;
    }
    
    public boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      boolean bool = true;
      paramf = paramf.a(paramObject3, this.a, false);
      if (this.c == f.o.a) {
        bool = this.b.equals(paramf);
      }
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool;
                if (this.c != f.o.b) {
                  break;
                }
              } while (!this.b.equals(paramf));
              return false;
              if (paramf == null) {
                return false;
              }
              i = this.b.compareTo(paramf.toString());
              if (this.c != f.o.d) {
                break;
              }
            } while (i <= 0);
            return false;
            if (this.c != f.o.c) {
              break;
            }
          } while (i < 0);
          return false;
          if (this.c != f.o.f) {
            break;
          }
        } while (i >= 0);
        return false;
        if (this.c != f.o.e) {
          break;
        }
      } while (i > 0);
      return false;
      return false;
    }
  }
  
  static class w
    implements f.c
  {
    private final String a;
    private final Object b;
    private boolean c = true;
    
    public w(String paramString, Object paramObject, boolean paramBoolean)
    {
      if (paramObject == null) {
        throw new IllegalArgumentException("value is null");
      }
      this.a = paramString;
      this.b = paramObject;
      this.c = paramBoolean;
    }
    
    public boolean apply(f paramf, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      boolean bool1 = false;
      paramf = paramf.a(paramObject3, this.a, false);
      boolean bool2 = this.b.equals(paramf);
      if (!this.c)
      {
        if (!bool2) {
          bool1 = true;
        }
        return bool1;
      }
      return bool2;
    }
  }
  
  static class x
    implements f.s
  {
    public static x a = new x();
    
    public Object eval(f paramf, Object paramObject1, Object paramObject2)
    {
      return paramf.a(paramObject2);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */