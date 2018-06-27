package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.l;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class SerializeConfig
{
  private static boolean awtError;
  public static final SerializeConfig globalInstance = new SerializeConfig();
  private static boolean guavaError = false;
  private static boolean jdk8Error;
  private static boolean oracleJdbcError;
  private static boolean springfoxError;
  private boolean asm;
  private ASMSerializerFactory asmFactory;
  public l propertyNamingStrategy;
  private final IdentityHashMap<Type, ObjectSerializer> serializers;
  protected String typeKey;
  
  static
  {
    awtError = false;
    jdk8Error = false;
    oracleJdbcError = false;
    springfoxError = false;
  }
  
  public SerializeConfig()
  {
    this(1024);
  }
  
  public SerializeConfig(int paramInt)
  {
    boolean bool;
    if (!ASMUtils.IS_ANDROID) {
      bool = true;
    }
    for (;;)
    {
      this.asm = bool;
      this.typeKey = a.c;
      this.serializers = new IdentityHashMap(1024);
      try
      {
        if (this.asm) {
          this.asmFactory = new ASMSerializerFactory();
        }
        put(Boolean.class, BooleanCodec.instance);
        put(Character.class, CharacterCodec.instance);
        put(Byte.class, IntegerCodec.instance);
        put(Short.class, IntegerCodec.instance);
        put(Integer.class, IntegerCodec.instance);
        put(Long.class, LongCodec.instance);
        put(Float.class, FloatCodec.instance);
        put(Double.class, DoubleSerializer.instance);
        put(BigDecimal.class, BigDecimalCodec.instance);
        put(BigInteger.class, BigIntegerCodec.instance);
        put(String.class, StringCodec.instance);
        put(byte[].class, PrimitiveArraySerializer.instance);
        put(short[].class, PrimitiveArraySerializer.instance);
        put(int[].class, PrimitiveArraySerializer.instance);
        put(long[].class, PrimitiveArraySerializer.instance);
        put(float[].class, PrimitiveArraySerializer.instance);
        put(double[].class, PrimitiveArraySerializer.instance);
        put(boolean[].class, PrimitiveArraySerializer.instance);
        put(char[].class, PrimitiveArraySerializer.instance);
        put(Object[].class, ObjectArrayCodec.instance);
        put(Class.class, MiscCodec.instance);
        put(SimpleDateFormat.class, MiscCodec.instance);
        put(Currency.class, new MiscCodec());
        put(TimeZone.class, MiscCodec.instance);
        put(InetAddress.class, MiscCodec.instance);
        put(Inet4Address.class, MiscCodec.instance);
        put(Inet6Address.class, MiscCodec.instance);
        put(InetSocketAddress.class, MiscCodec.instance);
        put(File.class, MiscCodec.instance);
        put(Appendable.class, AppendableSerializer.instance);
        put(StringBuffer.class, AppendableSerializer.instance);
        put(StringBuilder.class, AppendableSerializer.instance);
        put(Charset.class, ToStringSerializer.instance);
        put(Pattern.class, ToStringSerializer.instance);
        put(Locale.class, ToStringSerializer.instance);
        put(URI.class, ToStringSerializer.instance);
        put(URL.class, ToStringSerializer.instance);
        put(UUID.class, ToStringSerializer.instance);
        put(AtomicBoolean.class, AtomicCodec.instance);
        put(AtomicInteger.class, AtomicCodec.instance);
        put(AtomicLong.class, AtomicCodec.instance);
        put(AtomicReference.class, ReferenceCodec.instance);
        put(AtomicIntegerArray.class, AtomicCodec.instance);
        put(AtomicLongArray.class, AtomicCodec.instance);
        put(WeakReference.class, ReferenceCodec.instance);
        put(SoftReference.class, ReferenceCodec.instance);
        return;
        bool = false;
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        for (;;)
        {
          this.asm = false;
        }
      }
      catch (ExceptionInInitializerError localExceptionInInitializerError)
      {
        for (;;)
        {
          this.asm = false;
        }
      }
    }
  }
  
  private final JavaBeanSerializer createASMSerializer(SerializeBeanInfo paramSerializeBeanInfo)
    throws Exception
  {
    paramSerializeBeanInfo = this.asmFactory.createJavaBeanSerializer(paramSerializeBeanInfo);
    int i = 0;
    while (i < paramSerializeBeanInfo.sortedGetters.length)
    {
      Class localClass = paramSerializeBeanInfo.sortedGetters[i].fieldInfo.fieldClass;
      if ((localClass.isEnum()) && (!(getObjectWriter(localClass) instanceof EnumSerializer))) {
        paramSerializeBeanInfo.writeDirect = false;
      }
      i += 1;
    }
    return paramSerializeBeanInfo;
  }
  
  private final ObjectSerializer createJavaBeanSerializer(Class<?> paramClass)
  {
    SerializeBeanInfo localSerializeBeanInfo = TypeUtils.buildBeanInfo(paramClass, null, this.propertyNamingStrategy);
    if ((localSerializeBeanInfo.fields.length == 0) && (Iterable.class.isAssignableFrom(paramClass))) {
      return MiscCodec.instance;
    }
    return createJavaBeanSerializer(localSerializeBeanInfo);
  }
  
  public static SerializeConfig getGlobalInstance()
  {
    return globalInstance;
  }
  
  /* Error */
  private ObjectSerializer getObjectWriter(Class<?> paramClass, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/alibaba/fastjson/serializer/SerializeConfig:serializers	Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   4: aload_1
    //   5: invokevirtual 327	com/alibaba/fastjson/util/IdentityHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast 329	com/alibaba/fastjson/serializer/ObjectSerializer
    //   11: astore 4
    //   13: aload 4
    //   15: astore_3
    //   16: aload 4
    //   18: ifnonnull +110 -> 128
    //   21: ldc_w 331
    //   24: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   27: invokevirtual 341	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   30: invokestatic 347	com/alibaba/fastjson/util/ServiceLoader:load	(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/Set;
    //   33: invokeinterface 353 1 0
    //   38: astore_3
    //   39: aload_3
    //   40: invokeinterface 358 1 0
    //   45: ifeq +71 -> 116
    //   48: aload_3
    //   49: invokeinterface 362 1 0
    //   54: astore 4
    //   56: aload 4
    //   58: instanceof 331
    //   61: ifeq -22 -> 39
    //   64: aload 4
    //   66: checkcast 331	com/alibaba/fastjson/serializer/AutowiredObjectSerializer
    //   69: astore 4
    //   71: aload 4
    //   73: invokeinterface 366 1 0
    //   78: invokeinterface 353 1 0
    //   83: astore 5
    //   85: aload 5
    //   87: invokeinterface 358 1 0
    //   92: ifeq -53 -> 39
    //   95: aload_0
    //   96: aload 5
    //   98: invokeinterface 362 1 0
    //   103: checkcast 368	java/lang/reflect/Type
    //   106: aload 4
    //   108: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   111: pop
    //   112: goto -27 -> 85
    //   115: astore_3
    //   116: aload_0
    //   117: getfield 67	com/alibaba/fastjson/serializer/SerializeConfig:serializers	Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   120: aload_1
    //   121: invokevirtual 327	com/alibaba/fastjson/util/IdentityHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast 329	com/alibaba/fastjson/serializer/ObjectSerializer
    //   127: astore_3
    //   128: aload_3
    //   129: astore 4
    //   131: aload_3
    //   132: ifnonnull +128 -> 260
    //   135: ldc 57
    //   137: invokevirtual 371	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   140: astore 5
    //   142: aload_3
    //   143: astore 4
    //   145: aload 5
    //   147: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   150: invokevirtual 341	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   153: if_acmpeq +107 -> 260
    //   156: ldc_w 331
    //   159: aload 5
    //   161: invokestatic 347	com/alibaba/fastjson/util/ServiceLoader:load	(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/Set;
    //   164: invokeinterface 353 1 0
    //   169: astore_3
    //   170: aload_3
    //   171: invokeinterface 358 1 0
    //   176: ifeq +71 -> 247
    //   179: aload_3
    //   180: invokeinterface 362 1 0
    //   185: astore 4
    //   187: aload 4
    //   189: instanceof 331
    //   192: ifeq -22 -> 170
    //   195: aload 4
    //   197: checkcast 331	com/alibaba/fastjson/serializer/AutowiredObjectSerializer
    //   200: astore 4
    //   202: aload 4
    //   204: invokeinterface 366 1 0
    //   209: invokeinterface 353 1 0
    //   214: astore 5
    //   216: aload 5
    //   218: invokeinterface 358 1 0
    //   223: ifeq -53 -> 170
    //   226: aload_0
    //   227: aload 5
    //   229: invokeinterface 362 1 0
    //   234: checkcast 368	java/lang/reflect/Type
    //   237: aload 4
    //   239: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   242: pop
    //   243: goto -27 -> 216
    //   246: astore_3
    //   247: aload_0
    //   248: getfield 67	com/alibaba/fastjson/serializer/SerializeConfig:serializers	Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   251: aload_1
    //   252: invokevirtual 327	com/alibaba/fastjson/util/IdentityHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   255: checkcast 329	com/alibaba/fastjson/serializer/ObjectSerializer
    //   258: astore 4
    //   260: aload 4
    //   262: astore_3
    //   263: aload 4
    //   265: ifnonnull +34 -> 299
    //   268: ldc_w 373
    //   271: aload_1
    //   272: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   275: ifeq +26 -> 301
    //   278: aload_0
    //   279: aload_1
    //   280: getstatic 378	com/alibaba/fastjson/serializer/MapSerializer:instance	Lcom/alibaba/fastjson/serializer/MapSerializer;
    //   283: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   286: pop
    //   287: aload_0
    //   288: getfield 67	com/alibaba/fastjson/serializer/SerializeConfig:serializers	Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   291: aload_1
    //   292: invokevirtual 327	com/alibaba/fastjson/util/IdentityHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   295: checkcast 329	com/alibaba/fastjson/serializer/ObjectSerializer
    //   298: astore_3
    //   299: aload_3
    //   300: areturn
    //   301: ldc_w 380
    //   304: aload_1
    //   305: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   308: ifeq +15 -> 323
    //   311: aload_0
    //   312: aload_1
    //   313: getstatic 385	com/alibaba/fastjson/serializer/ListSerializer:instance	Lcom/alibaba/fastjson/serializer/ListSerializer;
    //   316: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   319: pop
    //   320: goto -33 -> 287
    //   323: ldc_w 387
    //   326: aload_1
    //   327: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   330: ifeq +15 -> 345
    //   333: aload_0
    //   334: aload_1
    //   335: getstatic 392	com/alibaba/fastjson/serializer/CollectionCodec:instance	Lcom/alibaba/fastjson/serializer/CollectionCodec;
    //   338: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   341: pop
    //   342: goto -55 -> 287
    //   345: ldc_w 394
    //   348: aload_1
    //   349: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   352: ifeq +15 -> 367
    //   355: aload_0
    //   356: aload_1
    //   357: getstatic 399	com/alibaba/fastjson/serializer/DateCodec:instance	Lcom/alibaba/fastjson/serializer/DateCodec;
    //   360: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   363: pop
    //   364: goto -77 -> 287
    //   367: ldc_w 401
    //   370: aload_1
    //   371: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   374: ifeq +15 -> 389
    //   377: aload_0
    //   378: aload_1
    //   379: getstatic 406	com/alibaba/fastjson/serializer/JSONAwareSerializer:instance	Lcom/alibaba/fastjson/serializer/JSONAwareSerializer;
    //   382: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   385: pop
    //   386: goto -99 -> 287
    //   389: ldc_w 408
    //   392: aload_1
    //   393: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   396: ifeq +15 -> 411
    //   399: aload_0
    //   400: aload_1
    //   401: getstatic 413	com/alibaba/fastjson/serializer/JSONSerializableSerializer:instance	Lcom/alibaba/fastjson/serializer/JSONSerializableSerializer;
    //   404: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   407: pop
    //   408: goto -121 -> 287
    //   411: ldc_w 415
    //   414: aload_1
    //   415: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   418: ifeq +15 -> 433
    //   421: aload_0
    //   422: aload_1
    //   423: getstatic 179	com/alibaba/fastjson/serializer/MiscCodec:instance	Lcom/alibaba/fastjson/serializer/MiscCodec;
    //   426: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   429: pop
    //   430: goto -143 -> 287
    //   433: aload_1
    //   434: invokevirtual 279	java/lang/Class:isEnum	()Z
    //   437: ifne +20 -> 457
    //   440: aload_1
    //   441: invokevirtual 419	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   444: ifnull +63 -> 507
    //   447: aload_1
    //   448: invokevirtual 419	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   451: invokevirtual 279	java/lang/Class:isEnum	()Z
    //   454: ifeq +53 -> 507
    //   457: aload_1
    //   458: ldc_w 421
    //   461: invokevirtual 425	java/lang/Class:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   464: checkcast 421	com/alibaba/fastjson/annotation/JSONType
    //   467: astore_3
    //   468: aload_3
    //   469: ifnull +26 -> 495
    //   472: aload_3
    //   473: invokeinterface 428 1 0
    //   478: ifeq +17 -> 495
    //   481: aload_0
    //   482: aload_1
    //   483: aload_0
    //   484: aload_1
    //   485: invokespecial 430	com/alibaba/fastjson/serializer/SerializeConfig:createJavaBeanSerializer	(Ljava/lang/Class;)Lcom/alibaba/fastjson/serializer/ObjectSerializer;
    //   488: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   491: pop
    //   492: goto -205 -> 287
    //   495: aload_0
    //   496: aload_1
    //   497: getstatic 433	com/alibaba/fastjson/serializer/EnumSerializer:instance	Lcom/alibaba/fastjson/serializer/EnumSerializer;
    //   500: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   503: pop
    //   504: goto -217 -> 287
    //   507: aload_1
    //   508: invokevirtual 436	java/lang/Class:isArray	()Z
    //   511: ifeq +30 -> 541
    //   514: aload_1
    //   515: invokevirtual 439	java/lang/Class:getComponentType	()Ljava/lang/Class;
    //   518: astore_3
    //   519: aload_0
    //   520: aload_1
    //   521: new 441	com/alibaba/fastjson/serializer/ArraySerializer
    //   524: dup
    //   525: aload_3
    //   526: aload_0
    //   527: aload_3
    //   528: invokevirtual 283	com/alibaba/fastjson/serializer/SerializeConfig:getObjectWriter	(Ljava/lang/Class;)Lcom/alibaba/fastjson/serializer/ObjectSerializer;
    //   531: invokespecial 444	com/alibaba/fastjson/serializer/ArraySerializer:<init>	(Ljava/lang/Class;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)V
    //   534: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   537: pop
    //   538: goto -251 -> 287
    //   541: ldc_w 321
    //   544: aload_1
    //   545: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   548: ifeq +45 -> 593
    //   551: aload_1
    //   552: aconst_null
    //   553: aload_0
    //   554: getfield 291	com/alibaba/fastjson/serializer/SerializeConfig:propertyNamingStrategy	Lcom/alibaba/fastjson/l;
    //   557: invokestatic 297	com/alibaba/fastjson/util/TypeUtils:buildBeanInfo	(Ljava/lang/Class;Ljava/util/Map;Lcom/alibaba/fastjson/l;)Lcom/alibaba/fastjson/serializer/SerializeBeanInfo;
    //   560: astore_3
    //   561: aload_3
    //   562: aload_3
    //   563: getfield 448	com/alibaba/fastjson/serializer/SerializeBeanInfo:features	I
    //   566: getstatic 454	com/alibaba/fastjson/serializer/SerializerFeature:WriteClassName	Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   569: getfield 457	com/alibaba/fastjson/serializer/SerializerFeature:mask	I
    //   572: ior
    //   573: putfield 448	com/alibaba/fastjson/serializer/SerializeBeanInfo:features	I
    //   576: aload_0
    //   577: aload_1
    //   578: new 259	com/alibaba/fastjson/serializer/JavaBeanSerializer
    //   581: dup
    //   582: aload_3
    //   583: invokespecial 460	com/alibaba/fastjson/serializer/JavaBeanSerializer:<init>	(Lcom/alibaba/fastjson/serializer/SerializeBeanInfo;)V
    //   586: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   589: pop
    //   590: goto -303 -> 287
    //   593: ldc -70
    //   595: aload_1
    //   596: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   599: ifne +13 -> 612
    //   602: ldc_w 462
    //   605: aload_1
    //   606: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   609: ifeq +15 -> 624
    //   612: aload_0
    //   613: aload_1
    //   614: getstatic 179	com/alibaba/fastjson/serializer/MiscCodec:instance	Lcom/alibaba/fastjson/serializer/MiscCodec;
    //   617: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   620: pop
    //   621: goto -334 -> 287
    //   624: ldc -58
    //   626: aload_1
    //   627: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   630: ifeq +15 -> 645
    //   633: aload_0
    //   634: aload_1
    //   635: getstatic 203	com/alibaba/fastjson/serializer/AppendableSerializer:instance	Lcom/alibaba/fastjson/serializer/AppendableSerializer;
    //   638: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   641: pop
    //   642: goto -355 -> 287
    //   645: ldc -47
    //   647: aload_1
    //   648: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   651: ifeq +15 -> 666
    //   654: aload_0
    //   655: aload_1
    //   656: getstatic 214	com/alibaba/fastjson/serializer/ToStringSerializer:instance	Lcom/alibaba/fastjson/serializer/ToStringSerializer;
    //   659: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   662: pop
    //   663: goto -376 -> 287
    //   666: ldc_w 464
    //   669: aload_1
    //   670: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   673: ifeq +15 -> 688
    //   676: aload_0
    //   677: aload_1
    //   678: getstatic 469	com/alibaba/fastjson/serializer/EnumerationSerializer:instance	Lcom/alibaba/fastjson/serializer/EnumerationSerializer;
    //   681: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   684: pop
    //   685: goto -398 -> 287
    //   688: ldc_w 471
    //   691: aload_1
    //   692: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   695: ifne +13 -> 708
    //   698: ldc_w 473
    //   701: aload_1
    //   702: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   705: ifeq +15 -> 720
    //   708: aload_0
    //   709: aload_1
    //   710: getstatic 478	com/alibaba/fastjson/serializer/CalendarCodec:instance	Lcom/alibaba/fastjson/serializer/CalendarCodec;
    //   713: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   716: pop
    //   717: goto -430 -> 287
    //   720: ldc_w 480
    //   723: aload_1
    //   724: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   727: ifeq +15 -> 742
    //   730: aload_0
    //   731: aload_1
    //   732: getstatic 485	com/alibaba/fastjson/serializer/ClobSeriliazer:instance	Lcom/alibaba/fastjson/serializer/ClobSeriliazer;
    //   735: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   738: pop
    //   739: goto -452 -> 287
    //   742: aload_1
    //   743: invokestatic 488	com/alibaba/fastjson/util/TypeUtils:isPath	(Ljava/lang/Class;)Z
    //   746: ifeq +15 -> 761
    //   749: aload_0
    //   750: aload_1
    //   751: getstatic 214	com/alibaba/fastjson/serializer/ToStringSerializer:instance	Lcom/alibaba/fastjson/serializer/ToStringSerializer;
    //   754: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   757: pop
    //   758: goto -471 -> 287
    //   761: ldc_w 355
    //   764: aload_1
    //   765: invokevirtual 309	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   768: ifeq +15 -> 783
    //   771: aload_0
    //   772: aload_1
    //   773: getstatic 179	com/alibaba/fastjson/serializer/MiscCodec:instance	Lcom/alibaba/fastjson/serializer/MiscCodec;
    //   776: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   779: pop
    //   780: goto -493 -> 287
    //   783: aload_1
    //   784: invokevirtual 492	java/lang/Class:getName	()Ljava/lang/String;
    //   787: astore 5
    //   789: aload 5
    //   791: ldc_w 494
    //   794: invokevirtual 498	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   797: ifeq +84 -> 881
    //   800: aload_1
    //   801: invokestatic 503	com/alibaba/fastjson/serializer/AwtCodec:support	(Ljava/lang/Class;)Z
    //   804: ifeq +77 -> 881
    //   807: getstatic 31	com/alibaba/fastjson/serializer/SerializeConfig:awtError	Z
    //   810: ifne +59 -> 869
    //   813: aload_0
    //   814: ldc_w 505
    //   817: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   820: getstatic 512	com/alibaba/fastjson/serializer/AwtCodec:instance	Lcom/alibaba/fastjson/serializer/AwtCodec;
    //   823: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   826: pop
    //   827: aload_0
    //   828: ldc_w 514
    //   831: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   834: getstatic 512	com/alibaba/fastjson/serializer/AwtCodec:instance	Lcom/alibaba/fastjson/serializer/AwtCodec;
    //   837: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   840: pop
    //   841: aload_0
    //   842: ldc_w 516
    //   845: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   848: getstatic 512	com/alibaba/fastjson/serializer/AwtCodec:instance	Lcom/alibaba/fastjson/serializer/AwtCodec;
    //   851: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   854: pop
    //   855: aload_0
    //   856: ldc_w 518
    //   859: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   862: getstatic 512	com/alibaba/fastjson/serializer/AwtCodec:instance	Lcom/alibaba/fastjson/serializer/AwtCodec;
    //   865: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   868: pop
    //   869: getstatic 512	com/alibaba/fastjson/serializer/AwtCodec:instance	Lcom/alibaba/fastjson/serializer/AwtCodec;
    //   872: areturn
    //   873: astore_1
    //   874: iconst_1
    //   875: putstatic 31	com/alibaba/fastjson/serializer/SerializeConfig:awtError	Z
    //   878: goto -9 -> 869
    //   881: getstatic 33	com/alibaba/fastjson/serializer/SerializeConfig:jdk8Error	Z
    //   884: ifne +256 -> 1140
    //   887: aload 5
    //   889: ldc_w 520
    //   892: invokevirtual 498	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   895: ifne +14 -> 909
    //   898: aload 5
    //   900: ldc_w 522
    //   903: invokevirtual 498	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   906: ifeq +234 -> 1140
    //   909: aload_0
    //   910: ldc_w 524
    //   913: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   916: getstatic 529	com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/Jdk8DateCodec;
    //   919: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   922: pop
    //   923: aload_0
    //   924: ldc_w 531
    //   927: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   930: getstatic 529	com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/Jdk8DateCodec;
    //   933: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   936: pop
    //   937: aload_0
    //   938: ldc_w 533
    //   941: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   944: getstatic 529	com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/Jdk8DateCodec;
    //   947: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   950: pop
    //   951: aload_0
    //   952: ldc_w 535
    //   955: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   958: getstatic 529	com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/Jdk8DateCodec;
    //   961: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   964: pop
    //   965: aload_0
    //   966: ldc_w 537
    //   969: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   972: getstatic 529	com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/Jdk8DateCodec;
    //   975: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   978: pop
    //   979: aload_0
    //   980: ldc_w 539
    //   983: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   986: getstatic 529	com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/Jdk8DateCodec;
    //   989: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   992: pop
    //   993: aload_0
    //   994: ldc_w 541
    //   997: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1000: getstatic 529	com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/Jdk8DateCodec;
    //   1003: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1006: pop
    //   1007: aload_0
    //   1008: ldc_w 543
    //   1011: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1014: getstatic 529	com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/Jdk8DateCodec;
    //   1017: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1020: pop
    //   1021: aload_0
    //   1022: ldc_w 545
    //   1025: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1028: getstatic 529	com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/Jdk8DateCodec;
    //   1031: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1034: pop
    //   1035: aload_0
    //   1036: ldc_w 547
    //   1039: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1042: getstatic 529	com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/Jdk8DateCodec;
    //   1045: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1048: pop
    //   1049: aload_0
    //   1050: ldc_w 549
    //   1053: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1056: getstatic 529	com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/Jdk8DateCodec;
    //   1059: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1062: pop
    //   1063: aload_0
    //   1064: ldc_w 522
    //   1067: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1070: getstatic 554	com/alibaba/fastjson/parser/deserializer/OptionalCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/OptionalCodec;
    //   1073: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1076: pop
    //   1077: aload_0
    //   1078: ldc_w 556
    //   1081: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1084: getstatic 554	com/alibaba/fastjson/parser/deserializer/OptionalCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/OptionalCodec;
    //   1087: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1090: pop
    //   1091: aload_0
    //   1092: ldc_w 558
    //   1095: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1098: getstatic 554	com/alibaba/fastjson/parser/deserializer/OptionalCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/OptionalCodec;
    //   1101: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1104: pop
    //   1105: aload_0
    //   1106: ldc_w 560
    //   1109: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1112: getstatic 554	com/alibaba/fastjson/parser/deserializer/OptionalCodec:instance	Lcom/alibaba/fastjson/parser/deserializer/OptionalCodec;
    //   1115: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1118: pop
    //   1119: aload_0
    //   1120: getfield 67	com/alibaba/fastjson/serializer/SerializeConfig:serializers	Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   1123: aload_1
    //   1124: invokevirtual 327	com/alibaba/fastjson/util/IdentityHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1127: checkcast 329	com/alibaba/fastjson/serializer/ObjectSerializer
    //   1130: astore 4
    //   1132: aload 4
    //   1134: astore_3
    //   1135: aload 4
    //   1137: ifnonnull -838 -> 299
    //   1140: getstatic 35	com/alibaba/fastjson/serializer/SerializeConfig:oracleJdbcError	Z
    //   1143: ifne +63 -> 1206
    //   1146: aload 5
    //   1148: ldc_w 562
    //   1151: invokevirtual 498	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1154: ifeq +52 -> 1206
    //   1157: aload_0
    //   1158: ldc_w 564
    //   1161: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1164: getstatic 399	com/alibaba/fastjson/serializer/DateCodec:instance	Lcom/alibaba/fastjson/serializer/DateCodec;
    //   1167: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1170: pop
    //   1171: aload_0
    //   1172: ldc_w 566
    //   1175: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1178: getstatic 399	com/alibaba/fastjson/serializer/DateCodec:instance	Lcom/alibaba/fastjson/serializer/DateCodec;
    //   1181: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1184: pop
    //   1185: aload_0
    //   1186: getfield 67	com/alibaba/fastjson/serializer/SerializeConfig:serializers	Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   1189: aload_1
    //   1190: invokevirtual 327	com/alibaba/fastjson/util/IdentityHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1193: checkcast 329	com/alibaba/fastjson/serializer/ObjectSerializer
    //   1196: astore 4
    //   1198: aload 4
    //   1200: astore_3
    //   1201: aload 4
    //   1203: ifnonnull -904 -> 299
    //   1206: getstatic 37	com/alibaba/fastjson/serializer/SerializeConfig:springfoxError	Z
    //   1209: ifne +49 -> 1258
    //   1212: aload 5
    //   1214: ldc_w 568
    //   1217: invokevirtual 572	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1220: ifeq +38 -> 1258
    //   1223: aload_0
    //   1224: ldc_w 568
    //   1227: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1230: getstatic 577	com/alibaba/fastjson/support/springfox/SwaggerJsonSerializer:instance	Lcom/alibaba/fastjson/support/springfox/SwaggerJsonSerializer;
    //   1233: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1236: pop
    //   1237: aload_0
    //   1238: getfield 67	com/alibaba/fastjson/serializer/SerializeConfig:serializers	Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   1241: aload_1
    //   1242: invokevirtual 327	com/alibaba/fastjson/util/IdentityHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1245: checkcast 329	com/alibaba/fastjson/serializer/ObjectSerializer
    //   1248: astore 4
    //   1250: aload 4
    //   1252: astore_3
    //   1253: aload 4
    //   1255: ifnonnull -956 -> 299
    //   1258: getstatic 39	com/alibaba/fastjson/serializer/SerializeConfig:guavaError	Z
    //   1261: ifne +91 -> 1352
    //   1264: aload 5
    //   1266: ldc_w 579
    //   1269: invokevirtual 498	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1272: ifeq +80 -> 1352
    //   1275: aload_0
    //   1276: ldc_w 581
    //   1279: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1282: getstatic 586	com/alibaba/fastjson/serializer/GuavaCodec:instance	Lcom/alibaba/fastjson/serializer/GuavaCodec;
    //   1285: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1288: pop
    //   1289: aload_0
    //   1290: ldc_w 588
    //   1293: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1296: getstatic 586	com/alibaba/fastjson/serializer/GuavaCodec:instance	Lcom/alibaba/fastjson/serializer/GuavaCodec;
    //   1299: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1302: pop
    //   1303: aload_0
    //   1304: ldc_w 590
    //   1307: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1310: getstatic 586	com/alibaba/fastjson/serializer/GuavaCodec:instance	Lcom/alibaba/fastjson/serializer/GuavaCodec;
    //   1313: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1316: pop
    //   1317: aload_0
    //   1318: ldc_w 592
    //   1321: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1324: getstatic 586	com/alibaba/fastjson/serializer/GuavaCodec:instance	Lcom/alibaba/fastjson/serializer/GuavaCodec;
    //   1327: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1330: pop
    //   1331: aload_0
    //   1332: getfield 67	com/alibaba/fastjson/serializer/SerializeConfig:serializers	Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   1335: aload_1
    //   1336: invokevirtual 327	com/alibaba/fastjson/util/IdentityHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1339: checkcast 329	com/alibaba/fastjson/serializer/ObjectSerializer
    //   1342: astore 4
    //   1344: aload 4
    //   1346: astore_3
    //   1347: aload 4
    //   1349: ifnonnull -1050 -> 299
    //   1352: aload 5
    //   1354: ldc_w 594
    //   1357: invokevirtual 572	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1360: ifeq +38 -> 1398
    //   1363: aload_0
    //   1364: ldc_w 594
    //   1367: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1370: getstatic 179	com/alibaba/fastjson/serializer/MiscCodec:instance	Lcom/alibaba/fastjson/serializer/MiscCodec;
    //   1373: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1376: pop
    //   1377: aload_0
    //   1378: getfield 67	com/alibaba/fastjson/serializer/SerializeConfig:serializers	Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   1381: aload_1
    //   1382: invokevirtual 327	com/alibaba/fastjson/util/IdentityHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1385: checkcast 329	com/alibaba/fastjson/serializer/ObjectSerializer
    //   1388: astore 4
    //   1390: aload 4
    //   1392: astore_3
    //   1393: aload 4
    //   1395: ifnonnull -1096 -> 299
    //   1398: aload_1
    //   1399: invokestatic 597	com/alibaba/fastjson/util/TypeUtils:isProxy	(Ljava/lang/Class;)Z
    //   1402: ifeq +53 -> 1455
    //   1405: aload_0
    //   1406: aload_1
    //   1407: invokevirtual 419	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   1410: invokevirtual 283	com/alibaba/fastjson/serializer/SerializeConfig:getObjectWriter	(Ljava/lang/Class;)Lcom/alibaba/fastjson/serializer/ObjectSerializer;
    //   1413: astore_3
    //   1414: aload_0
    //   1415: aload_1
    //   1416: aload_3
    //   1417: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1420: pop
    //   1421: aload_3
    //   1422: areturn
    //   1423: astore_3
    //   1424: iconst_1
    //   1425: putstatic 33	com/alibaba/fastjson/serializer/SerializeConfig:jdk8Error	Z
    //   1428: goto -288 -> 1140
    //   1431: astore_3
    //   1432: iconst_1
    //   1433: putstatic 35	com/alibaba/fastjson/serializer/SerializeConfig:oracleJdbcError	Z
    //   1436: goto -230 -> 1206
    //   1439: astore_3
    //   1440: iconst_1
    //   1441: putstatic 37	com/alibaba/fastjson/serializer/SerializeConfig:springfoxError	Z
    //   1444: goto -186 -> 1258
    //   1447: astore_3
    //   1448: iconst_1
    //   1449: putstatic 39	com/alibaba/fastjson/serializer/SerializeConfig:guavaError	Z
    //   1452: goto -100 -> 1352
    //   1455: iload_2
    //   1456: ifeq -1169 -> 287
    //   1459: aload_0
    //   1460: aload_1
    //   1461: aload_0
    //   1462: aload_1
    //   1463: invokespecial 430	com/alibaba/fastjson/serializer/SerializeConfig:createJavaBeanSerializer	(Ljava/lang/Class;)Lcom/alibaba/fastjson/serializer/ObjectSerializer;
    //   1466: invokevirtual 84	com/alibaba/fastjson/serializer/SerializeConfig:put	(Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/serializer/ObjectSerializer;)Z
    //   1469: pop
    //   1470: goto -1183 -> 287
    //   1473: astore_3
    //   1474: goto -97 -> 1377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1477	0	this	SerializeConfig
    //   0	1477	1	paramClass	Class<?>
    //   0	1477	2	paramBoolean	boolean
    //   15	34	3	localObject1	Object
    //   115	1	3	localClassCastException1	ClassCastException
    //   127	53	3	localObject2	Object
    //   246	1	3	localClassCastException2	ClassCastException
    //   262	1160	3	localObject3	Object
    //   1423	1	3	localThrowable1	Throwable
    //   1431	1	3	localThrowable2	Throwable
    //   1439	1	3	localClassNotFoundException1	ClassNotFoundException
    //   1447	1	3	localClassNotFoundException2	ClassNotFoundException
    //   1473	1	3	localClassNotFoundException3	ClassNotFoundException
    //   11	1383	4	localObject4	Object
    //   83	1270	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   21	39	115	java/lang/ClassCastException
    //   39	85	115	java/lang/ClassCastException
    //   85	112	115	java/lang/ClassCastException
    //   156	170	246	java/lang/ClassCastException
    //   170	216	246	java/lang/ClassCastException
    //   216	243	246	java/lang/ClassCastException
    //   813	869	873	java/lang/Throwable
    //   909	1132	1423	java/lang/Throwable
    //   1157	1198	1431	java/lang/Throwable
    //   1223	1250	1439	java/lang/ClassNotFoundException
    //   1275	1344	1447	java/lang/ClassNotFoundException
    //   1363	1377	1473	java/lang/ClassNotFoundException
  }
  
  public void addFilter(Class<?> paramClass, SerializeFilter paramSerializeFilter)
  {
    Object localObject = getObjectWriter(paramClass);
    if ((localObject instanceof SerializeFilterable))
    {
      localObject = (SerializeFilterable)localObject;
      if ((this != globalInstance) && (localObject == MapSerializer.instance))
      {
        localObject = new MapSerializer();
        put(paramClass, (ObjectSerializer)localObject);
        ((MapSerializer)localObject).addFilter(paramSerializeFilter);
      }
    }
    else
    {
      return;
    }
    ((SerializeFilterable)localObject).addFilter(paramSerializeFilter);
  }
  
  public void config(Class<?> paramClass, SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    Object localObject = getObjectWriter(paramClass, false);
    if (localObject == null)
    {
      localObject = TypeUtils.buildBeanInfo(paramClass, null, this.propertyNamingStrategy);
      if (paramBoolean)
      {
        ((SerializeBeanInfo)localObject).features |= paramSerializerFeature.mask;
        put(paramClass, createJavaBeanSerializer((SerializeBeanInfo)localObject));
      }
    }
    for (;;)
    {
      return;
      ((SerializeBeanInfo)localObject).features &= (paramSerializerFeature.mask ^ 0xFFFFFFFF);
      break;
      if ((localObject instanceof JavaBeanSerializer))
      {
        SerializeBeanInfo localSerializeBeanInfo = ((JavaBeanSerializer)localObject).beanInfo;
        int i = localSerializeBeanInfo.features;
        if (paramBoolean) {}
        for (localSerializeBeanInfo.features |= paramSerializerFeature.mask; (i != localSerializeBeanInfo.features) && (localObject.getClass() != JavaBeanSerializer.class); localSerializeBeanInfo.features &= (paramSerializerFeature.mask ^ 0xFFFFFFFF))
        {
          put(paramClass, createJavaBeanSerializer(localSerializeBeanInfo));
          return;
        }
      }
    }
  }
  
  public void configEnumAsJavaBean(Class<? extends Enum>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Class<? extends Enum> localClass = paramVarArgs[i];
      put(localClass, createJavaBeanSerializer(localClass));
      i += 1;
    }
  }
  
  public ObjectSerializer createJavaBeanSerializer(SerializeBeanInfo paramSerializeBeanInfo)
  {
    Object localObject3 = paramSerializeBeanInfo.jsonType;
    Object localObject1;
    if (localObject3 != null)
    {
      localObject1 = ((JSONType)localObject3).serializer();
      if (localObject1 == Void.class) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Class)localObject1).newInstance();
        if ((localObject1 instanceof ObjectSerializer))
        {
          localObject1 = (ObjectSerializer)localObject1;
          return (ObjectSerializer)localObject1;
        }
      }
      catch (Throwable localThrowable) {}
      if (!((JSONType)localObject3).asm()) {
        this.asm = false;
      }
      Object localObject2 = paramSerializeBeanInfo.beanType;
      if (!Modifier.isPublic(paramSerializeBeanInfo.beanType.getModifiers())) {
        return new JavaBeanSerializer(paramSerializeBeanInfo);
      }
      boolean bool2 = this.asm;
      if (((bool2) && (this.asmFactory.classLoader.isExternalClass((Class)localObject2))) || (localObject2 == Serializable.class) || (localObject2 == Object.class)) {
        bool2 = false;
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!ASMUtils.checkName(((Class)localObject2).getSimpleName())) {
          bool1 = false;
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        localObject3 = paramSerializeBeanInfo.fields;
        int j = localObject3.length;
        int i = 0;
        bool2 = bool1;
        if (i < j)
        {
          JSONField localJSONField = localObject3[i].getAnnotation();
          if (localJSONField == null) {}
          while ((ASMUtils.checkName(localJSONField.name())) && (localJSONField.format().length() == 0) && (!localJSONField.jsonDirect()) && (localJSONField.serializeUsing() == Void.class))
          {
            i += 1;
            break;
          }
          bool2 = false;
        }
      }
      if (bool2) {}
      try
      {
        localObject3 = createASMSerializer(paramSerializeBeanInfo);
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      catch (Throwable paramSerializeBeanInfo)
      {
        throw new d("create asm serializer error, class " + localObject2, paramSerializeBeanInfo);
      }
      catch (ClassFormatError localClassFormatError)
      {
        for (;;) {}
      }
      catch (ClassCastException localClassCastException)
      {
        for (;;) {}
      }
    }
    return new JavaBeanSerializer(paramSerializeBeanInfo);
  }
  
  public final ObjectSerializer get(Type paramType)
  {
    return (ObjectSerializer)this.serializers.get(paramType);
  }
  
  public ObjectSerializer getObjectWriter(Class<?> paramClass)
  {
    return getObjectWriter(paramClass, true);
  }
  
  public String getTypeKey()
  {
    return this.typeKey;
  }
  
  public boolean isAsmEnable()
  {
    return this.asm;
  }
  
  public boolean put(Object paramObject1, Object paramObject2)
  {
    return put((Type)paramObject1, (ObjectSerializer)paramObject2);
  }
  
  public boolean put(Type paramType, ObjectSerializer paramObjectSerializer)
  {
    return this.serializers.put(paramType, paramObjectSerializer);
  }
  
  public void setAsmEnable(boolean paramBoolean)
  {
    if (ASMUtils.IS_ANDROID) {
      return;
    }
    this.asm = paramBoolean;
  }
  
  public void setTypeKey(String paramString)
  {
    this.typeKey = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/SerializeConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */