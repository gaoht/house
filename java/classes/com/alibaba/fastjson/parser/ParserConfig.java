package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.e;
import com.alibaba.fastjson.f;
import com.alibaba.fastjson.l;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.AwtCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.ServiceLoader;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;

public class ParserConfig
{
  public static final String[] DENYS = ;
  public static final String DENY_PROPERTY = "fastjson.parser.deny";
  private static boolean awtError = false;
  public static ParserConfig global = new ParserConfig();
  private static boolean jdk8Error = false;
  private boolean asmEnable;
  protected ASMDeserializerFactory asmFactory;
  protected ClassLoader defaultClassLoader;
  private String[] denyList;
  private final IdentityHashMap<Type, ObjectDeserializer> derializers = new IdentityHashMap();
  public l propertyNamingStrategy;
  public final SymbolTable symbolTable;
  
  public ParserConfig()
  {
    this(null, null);
  }
  
  public ParserConfig(ASMDeserializerFactory paramASMDeserializerFactory)
  {
    this(paramASMDeserializerFactory, null);
  }
  
  private ParserConfig(ASMDeserializerFactory paramASMDeserializerFactory, ClassLoader paramClassLoader)
  {
    boolean bool;
    if (!ASMUtils.IS_ANDROID)
    {
      bool = true;
      this.asmEnable = bool;
      this.symbolTable = new SymbolTable(4096);
      this.denyList = new String[] { "java.lang.Thread" };
      localASMDeserializerFactory = paramASMDeserializerFactory;
      if (paramASMDeserializerFactory == null)
      {
        localASMDeserializerFactory = paramASMDeserializerFactory;
        if ((!ASMUtils.IS_ANDROID) && (paramClassLoader != null)) {
          break label1082;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramClassLoader = new ASMDeserializerFactory(new ASMClassLoader());
        paramASMDeserializerFactory = paramClassLoader;
        localASMDeserializerFactory = paramASMDeserializerFactory;
      }
      catch (ExceptionInInitializerError paramClassLoader)
      {
        localASMDeserializerFactory = paramASMDeserializerFactory;
        continue;
      }
      catch (NoClassDefFoundError paramClassLoader)
      {
        localASMDeserializerFactory = paramASMDeserializerFactory;
        continue;
      }
      catch (AccessControlException paramClassLoader)
      {
        label1082:
        localASMDeserializerFactory = paramASMDeserializerFactory;
        continue;
      }
      this.asmFactory = localASMDeserializerFactory;
      if (localASMDeserializerFactory == null) {
        this.asmEnable = false;
      }
      this.derializers.put(SimpleDateFormat.class, MiscCodec.instance);
      this.derializers.put(Timestamp.class, SqlDateDeserializer.instance_timestamp);
      this.derializers.put(java.sql.Date.class, SqlDateDeserializer.instance);
      this.derializers.put(Time.class, TimeDeserializer.instance);
      this.derializers.put(java.util.Date.class, DateCodec.instance);
      this.derializers.put(Calendar.class, CalendarCodec.instance);
      this.derializers.put(XMLGregorianCalendar.class, CalendarCodec.instance);
      this.derializers.put(e.class, MapDeserializer.instance);
      this.derializers.put(b.class, CollectionCodec.instance);
      this.derializers.put(Map.class, MapDeserializer.instance);
      this.derializers.put(HashMap.class, MapDeserializer.instance);
      this.derializers.put(LinkedHashMap.class, MapDeserializer.instance);
      this.derializers.put(TreeMap.class, MapDeserializer.instance);
      this.derializers.put(ConcurrentMap.class, MapDeserializer.instance);
      this.derializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
      this.derializers.put(Collection.class, CollectionCodec.instance);
      this.derializers.put(List.class, CollectionCodec.instance);
      this.derializers.put(ArrayList.class, CollectionCodec.instance);
      this.derializers.put(Object.class, JavaObjectDeserializer.instance);
      this.derializers.put(String.class, StringCodec.instance);
      this.derializers.put(StringBuffer.class, StringCodec.instance);
      this.derializers.put(StringBuilder.class, StringCodec.instance);
      this.derializers.put(Character.TYPE, CharacterCodec.instance);
      this.derializers.put(Character.class, CharacterCodec.instance);
      this.derializers.put(Byte.TYPE, NumberDeserializer.instance);
      this.derializers.put(Byte.class, NumberDeserializer.instance);
      this.derializers.put(Short.TYPE, NumberDeserializer.instance);
      this.derializers.put(Short.class, NumberDeserializer.instance);
      this.derializers.put(Integer.TYPE, IntegerCodec.instance);
      this.derializers.put(Integer.class, IntegerCodec.instance);
      this.derializers.put(Long.TYPE, LongCodec.instance);
      this.derializers.put(Long.class, LongCodec.instance);
      this.derializers.put(BigInteger.class, BigIntegerCodec.instance);
      this.derializers.put(BigDecimal.class, BigDecimalCodec.instance);
      this.derializers.put(Float.TYPE, FloatCodec.instance);
      this.derializers.put(Float.class, FloatCodec.instance);
      this.derializers.put(Double.TYPE, NumberDeserializer.instance);
      this.derializers.put(Double.class, NumberDeserializer.instance);
      this.derializers.put(Boolean.TYPE, BooleanCodec.instance);
      this.derializers.put(Boolean.class, BooleanCodec.instance);
      this.derializers.put(Class.class, MiscCodec.instance);
      this.derializers.put(char[].class, new CharArrayCodec());
      this.derializers.put(AtomicBoolean.class, BooleanCodec.instance);
      this.derializers.put(AtomicInteger.class, IntegerCodec.instance);
      this.derializers.put(AtomicLong.class, LongCodec.instance);
      this.derializers.put(AtomicReference.class, ReferenceCodec.instance);
      this.derializers.put(WeakReference.class, ReferenceCodec.instance);
      this.derializers.put(SoftReference.class, ReferenceCodec.instance);
      this.derializers.put(UUID.class, MiscCodec.instance);
      this.derializers.put(TimeZone.class, MiscCodec.instance);
      this.derializers.put(Locale.class, MiscCodec.instance);
      this.derializers.put(Currency.class, MiscCodec.instance);
      this.derializers.put(InetAddress.class, MiscCodec.instance);
      this.derializers.put(Inet4Address.class, MiscCodec.instance);
      this.derializers.put(Inet6Address.class, MiscCodec.instance);
      this.derializers.put(InetSocketAddress.class, MiscCodec.instance);
      this.derializers.put(File.class, MiscCodec.instance);
      this.derializers.put(URI.class, MiscCodec.instance);
      this.derializers.put(URL.class, MiscCodec.instance);
      this.derializers.put(Pattern.class, MiscCodec.instance);
      this.derializers.put(Charset.class, MiscCodec.instance);
      this.derializers.put(f.class, MiscCodec.instance);
      this.derializers.put(Number.class, NumberDeserializer.instance);
      this.derializers.put(AtomicIntegerArray.class, AtomicCodec.instance);
      this.derializers.put(AtomicLongArray.class, AtomicCodec.instance);
      this.derializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
      this.derializers.put(Serializable.class, JavaObjectDeserializer.instance);
      this.derializers.put(Cloneable.class, JavaObjectDeserializer.instance);
      this.derializers.put(Comparable.class, JavaObjectDeserializer.instance);
      this.derializers.put(Closeable.class, JavaObjectDeserializer.instance);
      addDeny("java.lang.Thread");
      addItemsToDeny(DENYS);
      return;
      bool = false;
      break;
      paramClassLoader = new ASMDeserializerFactory(paramClassLoader);
      paramASMDeserializerFactory = paramClassLoader;
    }
  }
  
  public ParserConfig(ClassLoader paramClassLoader)
  {
    this(null, paramClassLoader);
  }
  
  private void addItemsToDeny(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        addDeny(paramArrayOfString[i]);
        i += 1;
      }
    }
  }
  
  public static Field getFieldFromCache(String paramString, Map<String, Field> paramMap)
  {
    Object localObject2 = (Field)paramMap.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (Field)paramMap.get("_" + paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = (Field)paramMap.get("m_" + paramString);
    }
    return (Field)localObject2;
  }
  
  public static ParserConfig getGlobalInstance()
  {
    return global;
  }
  
  public static boolean isPrimitive(Class<?> paramClass)
  {
    return (paramClass.isPrimitive()) || (paramClass == Boolean.class) || (paramClass == Character.class) || (paramClass == Byte.class) || (paramClass == Short.class) || (paramClass == Integer.class) || (paramClass == Long.class) || (paramClass == Float.class) || (paramClass == Double.class) || (paramClass == BigInteger.class) || (paramClass == BigDecimal.class) || (paramClass == String.class) || (paramClass == java.util.Date.class) || (paramClass == java.sql.Date.class) || (paramClass == Time.class) || (paramClass == Timestamp.class) || (paramClass.isEnum());
  }
  
  public static void parserAllFieldToCache(Class<?> paramClass, Map<String, Field> paramMap)
  {
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      String str = localField.getName();
      if (!paramMap.containsKey(str)) {
        paramMap.put(str, localField);
      }
      i += 1;
    }
    if ((paramClass.getSuperclass() != null) && (paramClass.getSuperclass() != Object.class)) {
      parserAllFieldToCache(paramClass.getSuperclass(), paramMap);
    }
  }
  
  public static String[] readSystemDenyPropety()
  {
    return splitItemsFormProperty(IOUtils.getStringProperty("fastjson.parser.deny"));
  }
  
  private static String[] splitItemsFormProperty(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString.split(",");
    }
    return null;
  }
  
  public void addDeny(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String[] arrayOfString = new String[this.denyList.length + 1];
    System.arraycopy(this.denyList, 0, arrayOfString, 0, this.denyList.length);
    arrayOfString[(arrayOfString.length - 1)] = paramString;
    this.denyList = arrayOfString;
  }
  
  public void configFromPropety(Properties paramProperties)
  {
    addItemsToDeny(splitItemsFormProperty(paramProperties.getProperty("fastjson.parser.deny")));
  }
  
  public FieldDeserializer createFieldDeserializer(ParserConfig paramParserConfig, JavaBeanInfo paramJavaBeanInfo, FieldInfo paramFieldInfo)
  {
    Object localObject = null;
    Class localClass1 = paramJavaBeanInfo.clazz;
    Class localClass2 = paramFieldInfo.fieldClass;
    JSONField localJSONField = paramFieldInfo.getAnnotation();
    paramJavaBeanInfo = (JavaBeanInfo)localObject;
    if (localJSONField != null)
    {
      paramJavaBeanInfo = localJSONField.deserializeUsing();
      if (paramJavaBeanInfo != Void.class) {
        break label89;
      }
      paramJavaBeanInfo = (JavaBeanInfo)localObject;
    }
    label89:
    for (;;)
    {
      if ((paramJavaBeanInfo == null) && ((localClass2 == List.class) || (localClass2 == ArrayList.class))) {
        return new ArrayListTypeFieldDeserializer(paramParserConfig, localClass1, paramFieldInfo);
      }
      return new DefaultFieldDeserializer(paramParserConfig, localClass1, paramFieldInfo);
    }
  }
  
  public ObjectDeserializer createJavaBeanDeserializer(Class<?> paramClass, Type paramType)
  {
    boolean bool3 = false;
    boolean bool1 = this.asmEnable;
    boolean bool2 = bool1;
    Object localObject1;
    Object localObject3;
    if (bool1)
    {
      localObject1 = (JSONType)paramClass.getAnnotation(JSONType.class);
      if (localObject1 != null)
      {
        Object localObject2 = ((JSONType)localObject1).deserializer();
        if (localObject2 != Void.class) {
          try
          {
            localObject2 = ((Class)localObject2).newInstance();
            if ((localObject2 instanceof ObjectDeserializer))
            {
              localObject2 = (ObjectDeserializer)localObject2;
              return (ObjectDeserializer)localObject2;
            }
          }
          catch (Throwable localThrowable) {}
        }
        bool1 = ((JSONType)localObject1).asm();
      }
      bool2 = bool1;
      if (bool1)
      {
        localObject3 = JavaBeanInfo.getBuilderClass((JSONType)localObject1);
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = paramClass;
        }
        if (!Modifier.isPublic(((Class)localObject1).getModifiers())) {
          bool1 = false;
        }
      }
    }
    for (;;)
    {
      label130:
      bool2 = bool1;
      if (paramClass.getTypeParameters().length != 0) {
        bool2 = false;
      }
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (this.asmFactory != null)
        {
          bool1 = bool2;
          if (this.asmFactory.classLoader.isExternalClass(paramClass)) {
            bool1 = false;
          }
        }
      }
      bool2 = bool1;
      if (bool1) {
        bool2 = ASMUtils.checkName(paramClass.getSimpleName());
      }
      bool1 = bool2;
      int i;
      label315:
      JSONField localJSONField;
      if (bool2)
      {
        if (paramClass.isInterface()) {
          bool2 = false;
        }
        localObject1 = JavaBeanInfo.build(paramClass, paramType, this.propertyNamingStrategy);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (((JavaBeanInfo)localObject1).fields.length > 200) {
            bool1 = false;
          }
        }
        localObject3 = ((JavaBeanInfo)localObject1).defaultConstructor;
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (localObject3 == null)
          {
            bool2 = bool1;
            if (!paramClass.isInterface()) {
              bool2 = false;
            }
          }
        }
        localObject1 = ((JavaBeanInfo)localObject1).fields;
        int j = localObject1.length;
        i = 0;
        bool1 = bool2;
        if (i < j)
        {
          localJSONField = localObject1[i];
          if (!localJSONField.getOnly) {
            break label414;
          }
          bool1 = false;
        }
      }
      label342:
      if ((bool1) && (paramClass.isMemberClass()) && (!Modifier.isStatic(paramClass.getModifiers()))) {
        bool1 = bool3;
      }
      for (;;)
      {
        if (!bool1)
        {
          return new JavaBeanDeserializer(this, paramClass, paramType);
          localObject3 = ((Class)localObject1).getSuperclass();
          bool2 = bool1;
          if (localObject3 == Object.class) {
            break label670;
          }
          localObject1 = localObject3;
          if (localObject3 != null) {
            break;
          }
          break label130;
          label414:
          localObject3 = localJSONField.fieldClass;
          if (!Modifier.isPublic(((Class)localObject3).getModifiers()))
          {
            bool1 = false;
            break label342;
          }
          if ((((Class)localObject3).isMemberClass()) && (!Modifier.isStatic(((Class)localObject3).getModifiers())))
          {
            bool1 = false;
            break label342;
          }
          if ((localJSONField.getMember() != null) && (!ASMUtils.checkName(localJSONField.getMember().getName())))
          {
            bool1 = false;
            break label342;
          }
          localJSONField = localJSONField.getAnnotation();
          if ((localJSONField != null) && ((!ASMUtils.checkName(localJSONField.name())) || (localJSONField.format().length() != 0) || (localJSONField.deserializeUsing() != Void.class)))
          {
            bool1 = false;
            break label342;
          }
          if ((((Class)localObject3).isEnum()) && (!(getDeserializer((Type)localObject3) instanceof EnumDeserializer)))
          {
            bool1 = false;
            break label342;
          }
          i += 1;
          break label315;
        }
        localObject1 = JavaBeanInfo.build(paramClass, paramType, this.propertyNamingStrategy);
        try
        {
          localObject3 = this.asmFactory.createJavaBeanDeserializer(this, (JavaBeanInfo)localObject1);
          return (ObjectDeserializer)localObject3;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          return new JavaBeanDeserializer(this, paramClass, paramType);
        }
        catch (d paramClass)
        {
          return new JavaBeanDeserializer(this, localNoSuchMethodException);
        }
        catch (Exception paramType)
        {
          throw new d("create asm deserializer error, " + paramClass.getName(), paramType);
        }
      }
      label670:
      bool1 = bool2;
    }
  }
  
  public ClassLoader getDefaultClassLoader()
  {
    return this.defaultClassLoader;
  }
  
  public IdentityHashMap<Type, ObjectDeserializer> getDerializers()
  {
    return this.derializers;
  }
  
  public ObjectDeserializer getDeserializer(FieldInfo paramFieldInfo)
  {
    return getDeserializer(paramFieldInfo.fieldClass, paramFieldInfo.fieldType);
  }
  
  public ObjectDeserializer getDeserializer(Class<?> paramClass, Type paramType)
  {
    Object localObject1 = (ObjectDeserializer)this.derializers.get(paramType);
    if (localObject1 != null) {
      paramType = (Type)localObject1;
    }
    Object localObject2;
    do
    {
      return paramType;
      localObject2 = paramType;
      if (paramType == null) {
        localObject2 = paramClass;
      }
      localObject1 = (ObjectDeserializer)this.derializers.get(localObject2);
      paramType = (Type)localObject1;
    } while (localObject1 != null);
    paramType = (JSONType)paramClass.getAnnotation(JSONType.class);
    if (paramType != null)
    {
      paramType = paramType.mappingTo();
      if (paramType != Void.class) {
        return getDeserializer(paramType, paramType);
      }
    }
    if (((localObject2 instanceof WildcardType)) || ((localObject2 instanceof TypeVariable)) || ((localObject2 instanceof ParameterizedType))) {
      localObject1 = (ObjectDeserializer)this.derializers.get(paramClass);
    }
    for (;;)
    {
      if (localObject1 != null) {
        return (ObjectDeserializer)localObject1;
      }
      Object localObject3 = paramClass.getName().replace('$', '.');
      int i = 0;
      while (i < this.denyList.length)
      {
        if (((String)localObject3).startsWith(this.denyList[i])) {
          throw new d("parser deny : " + (String)localObject3);
        }
        i += 1;
      }
      paramType = (Type)localObject1;
      if (((String)localObject3).startsWith("java.awt."))
      {
        paramType = (Type)localObject1;
        if (AwtCodec.support(paramClass))
        {
          paramType = (Type)localObject1;
          if (awtError) {}
        }
      }
      try
      {
        this.derializers.put(Class.forName("java.awt.Point"), AwtCodec.instance);
        this.derializers.put(Class.forName("java.awt.Font"), AwtCodec.instance);
        this.derializers.put(Class.forName("java.awt.Rectangle"), AwtCodec.instance);
        this.derializers.put(Class.forName("java.awt.Color"), AwtCodec.instance);
        paramType = AwtCodec.instance;
        if (jdk8Error) {}
      }
      catch (Throwable paramType)
      {
        label858:
        label977:
        label983:
        for (;;)
        {
          try
          {
            if (((String)localObject3).startsWith("java.time."))
            {
              this.derializers.put(Class.forName("java.time.LocalDateTime"), Jdk8DateCodec.instance);
              this.derializers.put(Class.forName("java.time.LocalDate"), Jdk8DateCodec.instance);
              this.derializers.put(Class.forName("java.time.LocalTime"), Jdk8DateCodec.instance);
              this.derializers.put(Class.forName("java.time.ZonedDateTime"), Jdk8DateCodec.instance);
              this.derializers.put(Class.forName("java.time.OffsetDateTime"), Jdk8DateCodec.instance);
              this.derializers.put(Class.forName("java.time.OffsetTime"), Jdk8DateCodec.instance);
              this.derializers.put(Class.forName("java.time.ZoneOffset"), Jdk8DateCodec.instance);
              this.derializers.put(Class.forName("java.time.ZoneRegion"), Jdk8DateCodec.instance);
              this.derializers.put(Class.forName("java.time.ZoneId"), Jdk8DateCodec.instance);
              this.derializers.put(Class.forName("java.time.Period"), Jdk8DateCodec.instance);
              this.derializers.put(Class.forName("java.time.Duration"), Jdk8DateCodec.instance);
              this.derializers.put(Class.forName("java.time.Instant"), Jdk8DateCodec.instance);
              localObject1 = (ObjectDeserializer)this.derializers.get(paramClass);
              paramType = (Type)localObject1;
              if (((String)localObject3).equals("java.nio.file.Path")) {
                this.derializers.put(paramClass, MiscCodec.instance);
              }
              if (paramClass == Map.Entry.class) {
                this.derializers.put(paramClass, MiscCodec.instance);
              }
              localObject1 = Thread.currentThread().getContextClassLoader();
              try
              {
                localObject1 = ServiceLoader.load(AutowiredObjectDeserializer.class, (ClassLoader)localObject1).iterator();
                if (((Iterator)localObject1).hasNext())
                {
                  localObject3 = (AutowiredObjectDeserializer)((Iterator)localObject1).next();
                  Iterator localIterator = ((AutowiredObjectDeserializer)localObject3).getAutowiredFor().iterator();
                  if (localIterator.hasNext())
                  {
                    Type localType2 = (Type)localIterator.next();
                    this.derializers.put(localType2, localObject3);
                    continue;
                  }
                  continue;
                }
                if (paramType != null) {
                  break label977;
                }
              }
              catch (Exception localException) {}
              localObjectDeserializer = (ObjectDeserializer)this.derializers.get(localObject2);
              paramType = localObjectDeserializer;
              if (localObjectDeserializer != null) {
                break;
              }
              if (!paramClass.isEnum()) {
                break label858;
              }
              paramClass = new EnumDeserializer(paramClass);
              putDeserializer((Type)localObject2, paramClass);
              return paramClass;
              paramType = paramType;
              awtError = true;
              continue;
            }
            if (!((String)localObject3).startsWith("java.util.Optional")) {
              break label983;
            }
            this.derializers.put(Class.forName("java.util.Optional"), OptionalCodec.instance);
            this.derializers.put(Class.forName("java.util.OptionalDouble"), OptionalCodec.instance);
            this.derializers.put(Class.forName("java.util.OptionalInt"), OptionalCodec.instance);
            this.derializers.put(Class.forName("java.util.OptionalLong"), OptionalCodec.instance);
            ObjectDeserializer localObjectDeserializer = (ObjectDeserializer)this.derializers.get(paramClass);
            paramType = localObjectDeserializer;
            continue;
            continue;
          }
          catch (Throwable localThrowable)
          {
            jdk8Error = true;
          }
          if (paramClass.isArray())
          {
            paramClass = ObjectArrayCodec.instance;
          }
          else if ((paramClass == Set.class) || (paramClass == HashSet.class) || (paramClass == Collection.class) || (paramClass == List.class) || (paramClass == ArrayList.class))
          {
            paramClass = CollectionCodec.instance;
          }
          else if (Collection.class.isAssignableFrom(paramClass))
          {
            paramClass = CollectionCodec.instance;
          }
          else if (Map.class.isAssignableFrom(paramClass))
          {
            paramClass = MapDeserializer.instance;
          }
          else if (Throwable.class.isAssignableFrom(paramClass))
          {
            paramClass = new ThrowableDeserializer(this, paramClass);
          }
          else
          {
            paramClass = createJavaBeanDeserializer(paramClass, (Type)localObject2);
            continue;
            Type localType1 = paramType;
          }
        }
      }
    }
  }
  
  public ObjectDeserializer getDeserializer(Type paramType)
  {
    Object localObject = (ObjectDeserializer)this.derializers.get(paramType);
    if (localObject != null) {
      return (ObjectDeserializer)localObject;
    }
    if ((paramType instanceof Class)) {
      return getDeserializer((Class)paramType, paramType);
    }
    if ((paramType instanceof ParameterizedType))
    {
      localObject = ((ParameterizedType)paramType).getRawType();
      if ((localObject instanceof Class)) {
        return getDeserializer((Class)localObject, paramType);
      }
      return getDeserializer((Type)localObject);
    }
    return JavaObjectDeserializer.instance;
  }
  
  public boolean isAsmEnable()
  {
    return this.asmEnable;
  }
  
  public void putDeserializer(Type paramType, ObjectDeserializer paramObjectDeserializer)
  {
    this.derializers.put(paramType, paramObjectDeserializer);
  }
  
  public void setAsmEnable(boolean paramBoolean)
  {
    this.asmEnable = paramBoolean;
  }
  
  public void setDefaultClassLoader(ClassLoader paramClassLoader)
  {
    this.defaultClassLoader = paramClassLoader;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/ParserConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */