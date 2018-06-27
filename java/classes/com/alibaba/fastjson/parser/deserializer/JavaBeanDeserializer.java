package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class JavaBeanDeserializer
  implements ObjectDeserializer
{
  public final JavaBeanInfo beanInfo;
  protected final Class<?> clazz;
  private ConcurrentMap<String, Object> extraFieldDeserializers;
  private final FieldDeserializer[] fieldDeserializers;
  protected final FieldDeserializer[] sortedFieldDeserializers;
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, JavaBeanInfo paramJavaBeanInfo)
  {
    this.clazz = paramJavaBeanInfo.clazz;
    this.beanInfo = paramJavaBeanInfo;
    this.sortedFieldDeserializers = new FieldDeserializer[paramJavaBeanInfo.sortedFields.length];
    int k = paramJavaBeanInfo.sortedFields.length;
    int i = 0;
    while (i < k)
    {
      FieldDeserializer localFieldDeserializer = paramParserConfig.createFieldDeserializer(paramParserConfig, paramJavaBeanInfo, paramJavaBeanInfo.sortedFields[i]);
      this.sortedFieldDeserializers[i] = localFieldDeserializer;
      i += 1;
    }
    this.fieldDeserializers = new FieldDeserializer[paramJavaBeanInfo.fields.length];
    k = paramJavaBeanInfo.fields.length;
    i = j;
    while (i < k)
    {
      paramParserConfig = getFieldDeserializer(paramJavaBeanInfo.fields[i].name);
      this.fieldDeserializers[i] = paramParserConfig;
      i += 1;
    }
  }
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass)
  {
    this(paramParserConfig, paramClass, paramClass);
  }
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, Type paramType)
  {
    this(paramParserConfig, JavaBeanInfo.build(paramClass, paramType, paramParserConfig.propertyNamingStrategy));
  }
  
  protected static void parseArray(Collection paramCollection, ObjectDeserializer paramObjectDeserializer, DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramObject = (JSONLexerBase)paramDefaultJSONParser.lexer;
    int i = ((JSONLexerBase)paramObject).token();
    if (i == 8)
    {
      ((JSONLexerBase)paramObject).nextToken(16);
      ((JSONLexerBase)paramObject).token();
      return;
    }
    if (i != 14) {
      paramDefaultJSONParser.throwException(i);
    }
    if (((JSONLexerBase)paramObject).getCurrent() == '[')
    {
      ((JSONLexerBase)paramObject).next();
      ((JSONLexerBase)paramObject).setToken(14);
    }
    while (((JSONLexerBase)paramObject).token() == 15)
    {
      ((JSONLexerBase)paramObject).nextToken();
      return;
      ((JSONLexerBase)paramObject).nextToken(14);
    }
    i = 0;
    for (;;)
    {
      paramCollection.add(paramObjectDeserializer.deserialze(paramDefaultJSONParser, paramType, Integer.valueOf(i)));
      i += 1;
      if (((JSONLexerBase)paramObject).token() != 16) {
        break;
      }
      if (((JSONLexerBase)paramObject).getCurrent() == '[')
      {
        ((JSONLexerBase)paramObject).next();
        ((JSONLexerBase)paramObject).setToken(14);
      }
      else
      {
        ((JSONLexerBase)paramObject).nextToken(14);
      }
    }
    i = ((JSONLexerBase)paramObject).token();
    if (i != 15) {
      paramDefaultJSONParser.throwException(i);
    }
    if (((JSONLexerBase)paramObject).getCurrent() == ',')
    {
      ((JSONLexerBase)paramObject).next();
      ((JSONLexerBase)paramObject).setToken(16);
      return;
    }
    ((JSONLexerBase)paramObject).nextToken(16);
  }
  
  protected void check(JSONLexer paramJSONLexer, int paramInt)
  {
    if (paramJSONLexer.token() != paramInt) {
      throw new d("syntax error");
    }
  }
  
  /* Error */
  public Object createInstance(DefaultJSONParser paramDefaultJSONParser, Type paramType)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 153
    //   4: ifeq +53 -> 57
    //   7: aload_0
    //   8: getfield 27	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:clazz	Ljava/lang/Class;
    //   11: invokevirtual 157	java/lang/Class:isInterface	()Z
    //   14: ifeq +43 -> 57
    //   17: aload_2
    //   18: checkcast 153	java/lang/Class
    //   21: astore_1
    //   22: invokestatic 163	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   25: invokevirtual 167	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   28: astore_2
    //   29: new 169	com/alibaba/fastjson/e
    //   32: dup
    //   33: invokespecial 170	com/alibaba/fastjson/e:<init>	()V
    //   36: astore 6
    //   38: aload_2
    //   39: iconst_1
    //   40: anewarray 153	java/lang/Class
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: aload 6
    //   49: invokestatic 176	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   52: astore 6
    //   54: aload 6
    //   56: areturn
    //   57: aload_0
    //   58: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   61: getfield 180	com/alibaba/fastjson/util/JavaBeanInfo:defaultConstructor	Ljava/lang/reflect/Constructor;
    //   64: ifnonnull +5 -> 69
    //   67: aconst_null
    //   68: areturn
    //   69: aload_0
    //   70: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   73: getfield 180	com/alibaba/fastjson/util/JavaBeanInfo:defaultConstructor	Ljava/lang/reflect/Constructor;
    //   76: astore 8
    //   78: aload_0
    //   79: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   82: getfield 184	com/alibaba/fastjson/util/JavaBeanInfo:defaultConstructorParameterSize	I
    //   85: ifne +96 -> 181
    //   88: aload 8
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokevirtual 190	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   97: astore_2
    //   98: aload_2
    //   99: astore 6
    //   101: aload_1
    //   102: ifnull -48 -> 54
    //   105: aload_2
    //   106: astore 6
    //   108: aload_1
    //   109: getfield 84	com/alibaba/fastjson/parser/DefaultJSONParser:lexer	Lcom/alibaba/fastjson/parser/JSONLexer;
    //   112: getstatic 196	com/alibaba/fastjson/parser/Feature:InitStringFieldAsEmpty	Lcom/alibaba/fastjson/parser/Feature;
    //   115: invokeinterface 200 2 0
    //   120: ifeq -66 -> 54
    //   123: aload_0
    //   124: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   127: getfield 46	com/alibaba/fastjson/util/JavaBeanInfo:fields	[Lcom/alibaba/fastjson/util/FieldInfo;
    //   130: astore_1
    //   131: aload_1
    //   132: arraylength
    //   133: istore 5
    //   135: iconst_0
    //   136: istore 4
    //   138: aload_2
    //   139: astore 6
    //   141: iload 4
    //   143: iload 5
    //   145: if_icmpge -91 -> 54
    //   148: aload_1
    //   149: iload 4
    //   151: aaload
    //   152: astore 6
    //   154: aload 6
    //   156: getfield 203	com/alibaba/fastjson/util/FieldInfo:fieldClass	Ljava/lang/Class;
    //   159: ldc -51
    //   161: if_acmpne +11 -> 172
    //   164: aload 6
    //   166: aload_2
    //   167: ldc -49
    //   169: invokevirtual 211	com/alibaba/fastjson/util/FieldInfo:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   172: iload 4
    //   174: iconst_1
    //   175: iadd
    //   176: istore 4
    //   178: goto -40 -> 138
    //   181: aload_1
    //   182: invokevirtual 215	com/alibaba/fastjson/parser/DefaultJSONParser:getContext	()Lcom/alibaba/fastjson/parser/ParseContext;
    //   185: astore 12
    //   187: aload 12
    //   189: getfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   192: invokevirtual 225	java/lang/Object:getClass	()Ljava/lang/Class;
    //   195: invokevirtual 229	java/lang/Class:getName	()Ljava/lang/String;
    //   198: astore 7
    //   200: aload_2
    //   201: instanceof 153
    //   204: ifeq +431 -> 635
    //   207: aload_2
    //   208: checkcast 153	java/lang/Class
    //   211: invokevirtual 229	java/lang/Class:getName	()Ljava/lang/String;
    //   214: astore 6
    //   216: aload 7
    //   218: invokevirtual 232	java/lang/String:length	()I
    //   221: aload 6
    //   223: bipush 36
    //   225: invokevirtual 236	java/lang/String:lastIndexOf	(I)I
    //   228: iconst_1
    //   229: isub
    //   230: if_icmpeq +345 -> 575
    //   233: aload 6
    //   235: invokevirtual 240	java/lang/String:toCharArray	()[C
    //   238: astore 9
    //   240: new 242	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   247: astore 10
    //   249: aload 10
    //   251: aload 7
    //   253: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc -7
    //   258: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: new 251	java/util/HashMap
    //   265: dup
    //   266: invokespecial 252	java/util/HashMap:<init>	()V
    //   269: astore 11
    //   271: aload 11
    //   273: aload 7
    //   275: aload 12
    //   277: getfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   280: invokeinterface 258 3 0
    //   285: pop
    //   286: aload 7
    //   288: invokevirtual 232	java/lang/String:length	()I
    //   291: iconst_1
    //   292: iadd
    //   293: istore 4
    //   295: aload 7
    //   297: astore_2
    //   298: iload 4
    //   300: aload 6
    //   302: bipush 36
    //   304: invokevirtual 236	java/lang/String:lastIndexOf	(I)I
    //   307: if_icmpgt +244 -> 551
    //   310: aload 9
    //   312: iload 4
    //   314: caload
    //   315: istore_3
    //   316: iload_3
    //   317: bipush 36
    //   319: if_icmpne +313 -> 632
    //   322: aload 10
    //   324: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: astore 7
    //   329: aload 11
    //   331: aload_2
    //   332: invokeinterface 265 2 0
    //   337: astore 12
    //   339: aload_2
    //   340: invokestatic 269	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   343: astore 13
    //   345: aload 12
    //   347: ifnull +285 -> 632
    //   350: aload 7
    //   352: invokestatic 269	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   355: iconst_1
    //   356: anewarray 153	java/lang/Class
    //   359: dup
    //   360: iconst_0
    //   361: aload 13
    //   363: aastore
    //   364: invokevirtual 273	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   367: astore 13
    //   369: aload 13
    //   371: invokevirtual 276	java/lang/reflect/Constructor:isAccessible	()Z
    //   374: ifne +9 -> 383
    //   377: aload 13
    //   379: iconst_1
    //   380: invokevirtual 280	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   383: aload 11
    //   385: aload 7
    //   387: aload 13
    //   389: iconst_1
    //   390: anewarray 4	java/lang/Object
    //   393: dup
    //   394: iconst_0
    //   395: aload 12
    //   397: aastore
    //   398: invokevirtual 190	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   401: invokeinterface 258 3 0
    //   406: pop
    //   407: aload 7
    //   409: astore_2
    //   410: aload 10
    //   412: iload_3
    //   413: invokevirtual 283	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: iload 4
    //   419: iconst_1
    //   420: iadd
    //   421: istore 4
    //   423: goto -125 -> 298
    //   426: astore_1
    //   427: new 132	com/alibaba/fastjson/d
    //   430: dup
    //   431: new 242	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 285
    //   441: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload_2
    //   445: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokespecial 137	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;)V
    //   454: athrow
    //   455: astore_1
    //   456: new 132	com/alibaba/fastjson/d
    //   459: dup
    //   460: new 242	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   467: ldc_w 287
    //   470: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_0
    //   474: getfield 27	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:clazz	Ljava/lang/Class;
    //   477: invokevirtual 229	java/lang/Class:getName	()Ljava/lang/String;
    //   480: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: aload_1
    //   487: invokespecial 290	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   490: athrow
    //   491: astore_1
    //   492: new 292	java/lang/RuntimeException
    //   495: dup
    //   496: aload_1
    //   497: invokespecial 295	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   500: athrow
    //   501: astore_1
    //   502: new 292	java/lang/RuntimeException
    //   505: dup
    //   506: new 242	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   513: ldc_w 297
    //   516: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload 7
    //   521: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokespecial 298	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   530: athrow
    //   531: astore_1
    //   532: new 292	java/lang/RuntimeException
    //   535: dup
    //   536: aload_1
    //   537: invokespecial 295	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   540: athrow
    //   541: astore_1
    //   542: new 292	java/lang/RuntimeException
    //   545: dup
    //   546: aload_1
    //   547: invokespecial 295	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   550: athrow
    //   551: aload 8
    //   553: iconst_1
    //   554: anewarray 4	java/lang/Object
    //   557: dup
    //   558: iconst_0
    //   559: aload 11
    //   561: aload_2
    //   562: invokeinterface 265 2 0
    //   567: aastore
    //   568: invokevirtual 190	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   571: astore_2
    //   572: goto -474 -> 98
    //   575: aload 8
    //   577: iconst_1
    //   578: anewarray 4	java/lang/Object
    //   581: dup
    //   582: iconst_0
    //   583: aload 12
    //   585: getfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   588: aastore
    //   589: invokevirtual 190	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   592: astore_2
    //   593: goto -495 -> 98
    //   596: astore_1
    //   597: new 132	com/alibaba/fastjson/d
    //   600: dup
    //   601: new 242	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   608: ldc_w 287
    //   611: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload_0
    //   615: getfield 27	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:clazz	Ljava/lang/Class;
    //   618: invokevirtual 229	java/lang/Class:getName	()Ljava/lang/String;
    //   621: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: aload_1
    //   628: invokespecial 290	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   631: athrow
    //   632: goto -222 -> 410
    //   635: ldc -49
    //   637: astore 6
    //   639: goto -423 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	this	JavaBeanDeserializer
    //   0	642	1	paramDefaultJSONParser	DefaultJSONParser
    //   0	642	2	paramType	Type
    //   315	98	3	c	char
    //   136	286	4	i	int
    //   133	13	5	j	int
    //   36	602	6	localObject1	Object
    //   198	322	7	str	String
    //   76	500	8	localConstructor	Constructor
    //   238	73	9	arrayOfChar	char[]
    //   247	164	10	localStringBuilder	StringBuilder
    //   269	291	11	localHashMap	java.util.HashMap
    //   185	399	12	localObject2	Object
    //   343	45	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   339	345	426	java/lang/ClassNotFoundException
    //   350	383	426	java/lang/ClassNotFoundException
    //   383	407	426	java/lang/ClassNotFoundException
    //   69	98	455	java/lang/Exception
    //   181	216	455	java/lang/Exception
    //   216	295	455	java/lang/Exception
    //   298	310	455	java/lang/Exception
    //   322	339	455	java/lang/Exception
    //   339	345	455	java/lang/Exception
    //   350	383	455	java/lang/Exception
    //   383	407	455	java/lang/Exception
    //   410	417	455	java/lang/Exception
    //   427	455	455	java/lang/Exception
    //   492	501	455	java/lang/Exception
    //   502	531	455	java/lang/Exception
    //   532	541	455	java/lang/Exception
    //   542	551	455	java/lang/Exception
    //   551	572	455	java/lang/Exception
    //   575	593	455	java/lang/Exception
    //   339	345	491	java/lang/NoSuchMethodException
    //   350	383	491	java/lang/NoSuchMethodException
    //   383	407	491	java/lang/NoSuchMethodException
    //   339	345	501	java/lang/reflect/InvocationTargetException
    //   350	383	501	java/lang/reflect/InvocationTargetException
    //   383	407	501	java/lang/reflect/InvocationTargetException
    //   339	345	531	java/lang/IllegalAccessException
    //   350	383	531	java/lang/IllegalAccessException
    //   383	407	531	java/lang/IllegalAccessException
    //   339	345	541	java/lang/InstantiationException
    //   350	383	541	java/lang/InstantiationException
    //   383	407	541	java/lang/InstantiationException
    //   164	172	596	java/lang/Exception
  }
  
  public Object createInstance(Map<String, Object> paramMap, ParserConfig paramParserConfig)
    throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    if ((this.beanInfo.creatorConstructor == null) && (this.beanInfo.factoryMethod == null))
    {
      localObject1 = createInstance(null, this.clazz);
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject3 = (Map.Entry)paramMap.next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = ((Map.Entry)localObject3).getValue();
        localObject2 = smartMatch((String)localObject2);
        if (localObject2 != null) {
          ((FieldDeserializer)localObject2).setValue(localObject1, TypeUtils.cast(localObject3, ((FieldDeserializer)localObject2).fieldInfo.fieldType, paramParserConfig));
        }
      }
      if (this.beanInfo.buildMethod == null) {}
    }
    do
    {
      try
      {
        paramMap = this.beanInfo.buildMethod.invoke(localObject1, new Object[0]);
        return paramMap;
      }
      catch (Exception paramMap)
      {
        throw new d("build object error", paramMap);
      }
      return localObject1;
      localObject2 = this.beanInfo.fields;
      int j = localObject2.length;
      paramParserConfig = new Object[j];
      while (i < j)
      {
        paramParserConfig[i] = paramMap.get(localObject2[i].name);
        i += 1;
      }
      if (this.beanInfo.creatorConstructor != null) {
        try
        {
          paramMap = this.beanInfo.creatorConstructor.newInstance(paramParserConfig);
          return paramMap;
        }
        catch (Exception paramMap)
        {
          throw new d("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), paramMap);
        }
      }
      paramMap = (Map<String, Object>)localObject1;
    } while (this.beanInfo.factoryMethod == null);
    try
    {
      paramMap = this.beanInfo.factoryMethod.invoke(null, paramParserConfig);
      return paramMap;
    }
    catch (Exception paramMap)
    {
      throw new d("create factory method error, " + this.beanInfo.factoryMethod.toString(), paramMap);
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return (T)deserialze(paramDefaultJSONParser, paramType, paramObject, 0);
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject, int paramInt)
  {
    return (T)deserialze(paramDefaultJSONParser, paramType, paramObject, null, paramInt);
  }
  
  /* Error */
  protected <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 387
    //   4: if_acmpeq +9 -> 13
    //   7: aload_2
    //   8: ldc -87
    //   10: if_acmpne +8 -> 18
    //   13: aload_1
    //   14: invokevirtual 390	com/alibaba/fastjson/parser/DefaultJSONParser:parse	()Ljava/lang/Object;
    //   17: areturn
    //   18: aload_1
    //   19: getfield 84	com/alibaba/fastjson/parser/DefaultJSONParser:lexer	Lcom/alibaba/fastjson/parser/JSONLexer;
    //   22: checkcast 86	com/alibaba/fastjson/parser/JSONLexerBase
    //   25: astore 21
    //   27: aload 21
    //   29: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   32: istore 6
    //   34: iload 6
    //   36: bipush 8
    //   38: if_icmpne +12 -> 50
    //   41: aload 21
    //   43: bipush 16
    //   45: invokevirtual 94	com/alibaba/fastjson/parser/JSONLexerBase:nextToken	(I)V
    //   48: aconst_null
    //   49: areturn
    //   50: aload_1
    //   51: invokevirtual 215	com/alibaba/fastjson/parser/DefaultJSONParser:getContext	()Lcom/alibaba/fastjson/parser/ParseContext;
    //   54: astore 14
    //   56: aload 4
    //   58: ifnull +2991 -> 3049
    //   61: aload 14
    //   63: ifnull +2986 -> 3049
    //   66: aload 14
    //   68: getfield 394	com/alibaba/fastjson/parser/ParseContext:parent	Lcom/alibaba/fastjson/parser/ParseContext;
    //   71: astore 14
    //   73: aconst_null
    //   74: astore 11
    //   76: aconst_null
    //   77: astore 10
    //   79: aconst_null
    //   80: astore 12
    //   82: iload 6
    //   84: bipush 13
    //   86: if_icmpne +37 -> 123
    //   89: aload 21
    //   91: bipush 16
    //   93: invokevirtual 94	com/alibaba/fastjson/parser/JSONLexerBase:nextToken	(I)V
    //   96: aload 4
    //   98: astore_3
    //   99: aload 4
    //   101: ifnonnull +10 -> 111
    //   104: aload_0
    //   105: aload_1
    //   106: aload_2
    //   107: invokevirtual 310	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:createInstance	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   110: astore_3
    //   111: iconst_0
    //   112: ifeq +3 -> 115
    //   115: aload_1
    //   116: aload 14
    //   118: invokevirtual 398	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   121: aload_3
    //   122: areturn
    //   123: iload 6
    //   125: bipush 14
    //   127: if_icmpne +79 -> 206
    //   130: getstatic 401	com/alibaba/fastjson/parser/Feature:SupportArrayToBean	Lcom/alibaba/fastjson/parser/Feature;
    //   133: getfield 404	com/alibaba/fastjson/parser/Feature:mask	I
    //   136: istore 7
    //   138: aload_0
    //   139: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   142: getfield 407	com/alibaba/fastjson/util/JavaBeanInfo:parserFeatures	I
    //   145: iload 7
    //   147: iand
    //   148: ifne +2904 -> 3052
    //   151: aload 21
    //   153: getstatic 401	com/alibaba/fastjson/parser/Feature:SupportArrayToBean	Lcom/alibaba/fastjson/parser/Feature;
    //   156: invokevirtual 408	com/alibaba/fastjson/parser/JSONLexerBase:isEnabled	(Lcom/alibaba/fastjson/parser/Feature;)Z
    //   159: ifne +2893 -> 3052
    //   162: iload 7
    //   164: iload 5
    //   166: iand
    //   167: ifeq +33 -> 200
    //   170: goto +2882 -> 3052
    //   173: iload 5
    //   175: ifeq +31 -> 206
    //   178: aload_0
    //   179: aload_1
    //   180: aload_2
    //   181: aload_3
    //   182: aload 4
    //   184: invokevirtual 412	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:deserialzeArrayMapping	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: astore_2
    //   188: iconst_0
    //   189: ifeq +3 -> 192
    //   192: aload_1
    //   193: aload 14
    //   195: invokevirtual 398	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   198: aload_2
    //   199: areturn
    //   200: iconst_0
    //   201: istore 5
    //   203: goto -30 -> 173
    //   206: iload 6
    //   208: bipush 12
    //   210: if_icmpeq +196 -> 406
    //   213: iload 6
    //   215: bipush 16
    //   217: if_icmpeq +189 -> 406
    //   220: aload 21
    //   222: invokevirtual 415	com/alibaba/fastjson/parser/JSONLexerBase:isBlankInput	()Z
    //   225: istore 9
    //   227: iload 9
    //   229: ifeq +15 -> 244
    //   232: iconst_0
    //   233: ifeq +3 -> 236
    //   236: aload_1
    //   237: aload 14
    //   239: invokevirtual 398	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   242: aconst_null
    //   243: areturn
    //   244: iload 6
    //   246: iconst_4
    //   247: if_icmpne +31 -> 278
    //   250: aload 21
    //   252: invokevirtual 418	com/alibaba/fastjson/parser/JSONLexerBase:stringVal	()Ljava/lang/String;
    //   255: invokevirtual 232	java/lang/String:length	()I
    //   258: ifne +20 -> 278
    //   261: aload 21
    //   263: invokevirtual 109	com/alibaba/fastjson/parser/JSONLexerBase:nextToken	()V
    //   266: iconst_0
    //   267: ifeq +3 -> 270
    //   270: aload_1
    //   271: aload 14
    //   273: invokevirtual 398	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   276: aconst_null
    //   277: areturn
    //   278: iload 6
    //   280: bipush 14
    //   282: if_icmpne +36 -> 318
    //   285: aload 21
    //   287: invokevirtual 101	com/alibaba/fastjson/parser/JSONLexerBase:getCurrent	()C
    //   290: bipush 93
    //   292: if_icmpne +26 -> 318
    //   295: aload 21
    //   297: invokevirtual 104	com/alibaba/fastjson/parser/JSONLexerBase:next	()C
    //   300: pop
    //   301: aload 21
    //   303: invokevirtual 109	com/alibaba/fastjson/parser/JSONLexerBase:nextToken	()V
    //   306: iconst_0
    //   307: ifeq +3 -> 310
    //   310: aload_1
    //   311: aload 14
    //   313: invokevirtual 398	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   316: aconst_null
    //   317: areturn
    //   318: new 420	java/lang/StringBuffer
    //   321: dup
    //   322: invokespecial 421	java/lang/StringBuffer:<init>	()V
    //   325: ldc_w 423
    //   328: invokevirtual 426	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   331: aload 21
    //   333: invokevirtual 429	com/alibaba/fastjson/parser/JSONLexerBase:tokenName	()Ljava/lang/String;
    //   336: invokevirtual 426	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   339: ldc_w 431
    //   342: invokevirtual 426	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   345: aload 21
    //   347: invokevirtual 434	com/alibaba/fastjson/parser/JSONLexerBase:pos	()I
    //   350: invokevirtual 437	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   353: astore_2
    //   354: aload_3
    //   355: instanceof 205
    //   358: ifeq +15 -> 373
    //   361: aload_2
    //   362: ldc_w 439
    //   365: invokevirtual 426	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   368: aload_3
    //   369: invokevirtual 442	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   372: pop
    //   373: new 132	com/alibaba/fastjson/d
    //   376: dup
    //   377: aload_2
    //   378: invokevirtual 443	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   381: invokespecial 137	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;)V
    //   384: athrow
    //   385: astore_2
    //   386: aload 10
    //   388: ifnull +10 -> 398
    //   391: aload 10
    //   393: aload 4
    //   395: putfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   398: aload_1
    //   399: aload 14
    //   401: invokevirtual 398	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   404: aload_2
    //   405: athrow
    //   406: aload_1
    //   407: getfield 446	com/alibaba/fastjson/parser/DefaultJSONParser:resolveStatus	I
    //   410: iconst_2
    //   411: if_icmpne +8 -> 419
    //   414: aload_1
    //   415: iconst_0
    //   416: putfield 446	com/alibaba/fastjson/parser/DefaultJSONParser:resolveStatus	I
    //   419: iconst_0
    //   420: istore 7
    //   422: aload 11
    //   424: astore 10
    //   426: aload 4
    //   428: astore 13
    //   430: iload 7
    //   432: aload_0
    //   433: getfield 37	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:sortedFieldDeserializers	[Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   436: arraylength
    //   437: if_icmpge +2594 -> 3031
    //   440: aload 4
    //   442: astore 13
    //   444: aload_0
    //   445: getfield 37	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:sortedFieldDeserializers	[Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   448: iload 7
    //   450: aaload
    //   451: astore 17
    //   453: aload 4
    //   455: astore 13
    //   457: aload 17
    //   459: getfield 343	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:fieldInfo	Lcom/alibaba/fastjson/util/FieldInfo;
    //   462: astore 15
    //   464: aload 4
    //   466: astore 13
    //   468: aload 15
    //   470: getfield 203	com/alibaba/fastjson/util/FieldInfo:fieldClass	Ljava/lang/Class;
    //   473: astore 16
    //   475: aload 4
    //   477: astore 13
    //   479: aload 15
    //   481: invokevirtual 450	com/alibaba/fastjson/util/FieldInfo:getAnnotation	()Lcom/alibaba/fastjson/annotation/JSONField;
    //   484: astore 18
    //   486: aconst_null
    //   487: astore 20
    //   489: aconst_null
    //   490: astore 19
    //   492: aload 20
    //   494: astore 11
    //   496: aload 17
    //   498: ifnull +2515 -> 3013
    //   501: aload 4
    //   503: astore 13
    //   505: aload 15
    //   507: getfield 454	com/alibaba/fastjson/util/FieldInfo:name_chars	[C
    //   510: astore 22
    //   512: aload 4
    //   514: astore 13
    //   516: aload 16
    //   518: getstatic 457	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   521: if_acmpeq +10 -> 531
    //   524: aload 16
    //   526: ldc 111
    //   528: if_acmpne +180 -> 708
    //   531: aload 4
    //   533: astore 13
    //   535: aload 21
    //   537: aload 22
    //   539: invokevirtual 461	com/alibaba/fastjson/parser/JSONLexerBase:scanFieldInt	([C)I
    //   542: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   545: astore 11
    //   547: aload 4
    //   549: astore 13
    //   551: aload 21
    //   553: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   556: ifle +123 -> 679
    //   559: iconst_1
    //   560: istore 5
    //   562: iconst_1
    //   563: istore 6
    //   565: iload 6
    //   567: ifne +2523 -> 3090
    //   570: aload 4
    //   572: astore 13
    //   574: aload 21
    //   576: aload_1
    //   577: getfield 468	com/alibaba/fastjson/parser/DefaultJSONParser:symbolTable	Lcom/alibaba/fastjson/parser/SymbolTable;
    //   580: invokevirtual 472	com/alibaba/fastjson/parser/JSONLexerBase:scanSymbol	(Lcom/alibaba/fastjson/parser/SymbolTable;)Ljava/lang/String;
    //   583: astore 19
    //   585: aload 19
    //   587: ifnonnull +953 -> 1540
    //   590: aload 4
    //   592: astore 13
    //   594: aload 21
    //   596: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   599: istore 8
    //   601: iload 8
    //   603: bipush 13
    //   605: if_icmpne +898 -> 1503
    //   608: aload 4
    //   610: astore 13
    //   612: aload 21
    //   614: bipush 16
    //   616: invokevirtual 94	com/alibaba/fastjson/parser/JSONLexerBase:nextToken	(I)V
    //   619: aload 4
    //   621: ifnonnull +2356 -> 2977
    //   624: aload 12
    //   626: ifnonnull +1956 -> 2582
    //   629: aload_0
    //   630: aload_1
    //   631: aload_2
    //   632: invokevirtual 310	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:createInstance	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   635: astore_2
    //   636: aload 10
    //   638: astore 4
    //   640: aload 10
    //   642: ifnonnull +18 -> 660
    //   645: aload_2
    //   646: astore 4
    //   648: aload_1
    //   649: aload 14
    //   651: aload_2
    //   652: aload_3
    //   653: invokevirtual 475	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   656: astore_3
    //   657: aload_3
    //   658: astore 4
    //   660: aload 4
    //   662: ifnull +9 -> 671
    //   665: aload 4
    //   667: aload_2
    //   668: putfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   671: aload_1
    //   672: aload 14
    //   674: invokevirtual 398	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   677: aload_2
    //   678: areturn
    //   679: aload 4
    //   681: astore 13
    //   683: aload 21
    //   685: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   688: bipush -2
    //   690: if_icmpne +2323 -> 3013
    //   693: aload 4
    //   695: astore 11
    //   697: aload 10
    //   699: astore 4
    //   701: aload 11
    //   703: astore 10
    //   705: goto +2353 -> 3058
    //   708: aload 4
    //   710: astore 13
    //   712: aload 16
    //   714: getstatic 478	java/lang/Long:TYPE	Ljava/lang/Class;
    //   717: if_acmpeq +11 -> 728
    //   720: aload 16
    //   722: ldc_w 477
    //   725: if_acmpne +69 -> 794
    //   728: aload 4
    //   730: astore 13
    //   732: aload 21
    //   734: aload 22
    //   736: invokevirtual 482	com/alibaba/fastjson/parser/JSONLexerBase:scanFieldLong	([C)J
    //   739: invokestatic 485	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   742: astore 11
    //   744: aload 4
    //   746: astore 13
    //   748: aload 21
    //   750: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   753: ifle +12 -> 765
    //   756: iconst_1
    //   757: istore 5
    //   759: iconst_1
    //   760: istore 6
    //   762: goto -197 -> 565
    //   765: aload 4
    //   767: astore 13
    //   769: aload 21
    //   771: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   774: bipush -2
    //   776: if_icmpne +2237 -> 3013
    //   779: aload 10
    //   781: astore 11
    //   783: aload 4
    //   785: astore 10
    //   787: aload 11
    //   789: astore 4
    //   791: goto +2267 -> 3058
    //   794: aload 16
    //   796: ldc -51
    //   798: if_acmpne +66 -> 864
    //   801: aload 4
    //   803: astore 13
    //   805: aload 21
    //   807: aload 22
    //   809: invokevirtual 489	com/alibaba/fastjson/parser/JSONLexerBase:scanFieldString	([C)Ljava/lang/String;
    //   812: astore 11
    //   814: aload 4
    //   816: astore 13
    //   818: aload 21
    //   820: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   823: ifle +12 -> 835
    //   826: iconst_1
    //   827: istore 5
    //   829: iconst_1
    //   830: istore 6
    //   832: goto -267 -> 565
    //   835: aload 4
    //   837: astore 13
    //   839: aload 21
    //   841: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   844: bipush -2
    //   846: if_icmpne +2167 -> 3013
    //   849: aload 10
    //   851: astore 11
    //   853: aload 4
    //   855: astore 10
    //   857: aload 11
    //   859: astore 4
    //   861: goto +2197 -> 3058
    //   864: aload 4
    //   866: astore 13
    //   868: aload 16
    //   870: getstatic 492	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   873: if_acmpeq +11 -> 884
    //   876: aload 16
    //   878: ldc_w 491
    //   881: if_acmpne +69 -> 950
    //   884: aload 4
    //   886: astore 13
    //   888: aload 21
    //   890: aload 22
    //   892: invokevirtual 496	com/alibaba/fastjson/parser/JSONLexerBase:scanFieldBoolean	([C)Z
    //   895: invokestatic 499	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   898: astore 11
    //   900: aload 4
    //   902: astore 13
    //   904: aload 21
    //   906: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   909: ifle +12 -> 921
    //   912: iconst_1
    //   913: istore 5
    //   915: iconst_1
    //   916: istore 6
    //   918: goto -353 -> 565
    //   921: aload 4
    //   923: astore 13
    //   925: aload 21
    //   927: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   930: bipush -2
    //   932: if_icmpne +2081 -> 3013
    //   935: aload 10
    //   937: astore 11
    //   939: aload 4
    //   941: astore 10
    //   943: aload 11
    //   945: astore 4
    //   947: goto +2111 -> 3058
    //   950: aload 4
    //   952: astore 13
    //   954: aload 16
    //   956: getstatic 502	java/lang/Float:TYPE	Ljava/lang/Class;
    //   959: if_acmpeq +11 -> 970
    //   962: aload 16
    //   964: ldc_w 501
    //   967: if_acmpne +69 -> 1036
    //   970: aload 4
    //   972: astore 13
    //   974: aload 21
    //   976: aload 22
    //   978: invokevirtual 506	com/alibaba/fastjson/parser/JSONLexerBase:scanFieldFloat	([C)F
    //   981: invokestatic 509	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   984: astore 11
    //   986: aload 4
    //   988: astore 13
    //   990: aload 21
    //   992: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   995: ifle +12 -> 1007
    //   998: iconst_1
    //   999: istore 5
    //   1001: iconst_1
    //   1002: istore 6
    //   1004: goto -439 -> 565
    //   1007: aload 4
    //   1009: astore 13
    //   1011: aload 21
    //   1013: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   1016: bipush -2
    //   1018: if_icmpne +1995 -> 3013
    //   1021: aload 10
    //   1023: astore 11
    //   1025: aload 4
    //   1027: astore 10
    //   1029: aload 11
    //   1031: astore 4
    //   1033: goto +2025 -> 3058
    //   1036: aload 4
    //   1038: astore 13
    //   1040: aload 16
    //   1042: getstatic 512	java/lang/Double:TYPE	Ljava/lang/Class;
    //   1045: if_acmpeq +11 -> 1056
    //   1048: aload 16
    //   1050: ldc_w 511
    //   1053: if_acmpne +69 -> 1122
    //   1056: aload 4
    //   1058: astore 13
    //   1060: aload 21
    //   1062: aload 22
    //   1064: invokevirtual 516	com/alibaba/fastjson/parser/JSONLexerBase:scanFieldDouble	([C)D
    //   1067: invokestatic 519	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1070: astore 11
    //   1072: aload 4
    //   1074: astore 13
    //   1076: aload 21
    //   1078: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   1081: ifle +12 -> 1093
    //   1084: iconst_1
    //   1085: istore 5
    //   1087: iconst_1
    //   1088: istore 6
    //   1090: goto -525 -> 565
    //   1093: aload 4
    //   1095: astore 13
    //   1097: aload 21
    //   1099: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   1102: bipush -2
    //   1104: if_icmpne +1909 -> 3013
    //   1107: aload 10
    //   1109: astore 11
    //   1111: aload 4
    //   1113: astore 10
    //   1115: aload 11
    //   1117: astore 4
    //   1119: goto +1939 -> 3058
    //   1122: aload 4
    //   1124: astore 13
    //   1126: aload 16
    //   1128: invokevirtual 522	java/lang/Class:isEnum	()Z
    //   1131: ifeq +132 -> 1263
    //   1134: aload 4
    //   1136: astore 13
    //   1138: aload_1
    //   1139: invokevirtual 526	com/alibaba/fastjson/parser/DefaultJSONParser:getConfig	()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   1142: aload 16
    //   1144: invokevirtual 530	com/alibaba/fastjson/parser/ParserConfig:getDeserializer	(Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   1147: instanceof 532
    //   1150: ifeq +113 -> 1263
    //   1153: aload 18
    //   1155: ifnull +20 -> 1175
    //   1158: aload 4
    //   1160: astore 13
    //   1162: aload 18
    //   1164: invokeinterface 537 1 0
    //   1169: ldc_w 539
    //   1172: if_acmpne +91 -> 1263
    //   1175: aload 20
    //   1177: astore 11
    //   1179: aload 4
    //   1181: astore 13
    //   1183: aload 17
    //   1185: instanceof 541
    //   1188: ifeq +1825 -> 3013
    //   1191: aload 4
    //   1193: astore 13
    //   1195: aload_0
    //   1196: aload 21
    //   1198: aload 22
    //   1200: aload 17
    //   1202: checkcast 541	com/alibaba/fastjson/parser/deserializer/DefaultFieldDeserializer
    //   1205: getfield 545	com/alibaba/fastjson/parser/deserializer/DefaultFieldDeserializer:fieldValueDeserilizer	Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   1208: invokevirtual 549	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:scanEnum	(Lcom/alibaba/fastjson/parser/JSONLexerBase;[CLcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;)Ljava/lang/Enum;
    //   1211: astore 11
    //   1213: aload 4
    //   1215: astore 13
    //   1217: aload 21
    //   1219: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   1222: ifle +12 -> 1234
    //   1225: iconst_1
    //   1226: istore 6
    //   1228: iconst_1
    //   1229: istore 5
    //   1231: goto +1848 -> 3079
    //   1234: aload 4
    //   1236: astore 13
    //   1238: aload 21
    //   1240: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   1243: bipush -2
    //   1245: if_icmpne +1777 -> 3022
    //   1248: aload 4
    //   1250: astore 11
    //   1252: aload 10
    //   1254: astore 4
    //   1256: aload 11
    //   1258: astore 10
    //   1260: goto +1798 -> 3058
    //   1263: aload 16
    //   1265: ldc_w 551
    //   1268: if_acmpne +66 -> 1334
    //   1271: aload 4
    //   1273: astore 13
    //   1275: aload 21
    //   1277: aload 22
    //   1279: invokevirtual 555	com/alibaba/fastjson/parser/JSONLexerBase:scanFieldIntArray	([C)[I
    //   1282: astore 11
    //   1284: aload 4
    //   1286: astore 13
    //   1288: aload 21
    //   1290: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   1293: ifle +12 -> 1305
    //   1296: iconst_1
    //   1297: istore 5
    //   1299: iconst_1
    //   1300: istore 6
    //   1302: goto -737 -> 565
    //   1305: aload 4
    //   1307: astore 13
    //   1309: aload 21
    //   1311: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   1314: bipush -2
    //   1316: if_icmpne +1697 -> 3013
    //   1319: aload 4
    //   1321: astore 11
    //   1323: aload 10
    //   1325: astore 4
    //   1327: aload 11
    //   1329: astore 10
    //   1331: goto +1727 -> 3058
    //   1334: aload 16
    //   1336: ldc_w 557
    //   1339: if_acmpne +66 -> 1405
    //   1342: aload 4
    //   1344: astore 13
    //   1346: aload 21
    //   1348: aload 22
    //   1350: invokevirtual 561	com/alibaba/fastjson/parser/JSONLexerBase:scanFieldFloatArray	([C)[F
    //   1353: astore 11
    //   1355: aload 4
    //   1357: astore 13
    //   1359: aload 21
    //   1361: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   1364: ifle +12 -> 1376
    //   1367: iconst_1
    //   1368: istore 5
    //   1370: iconst_1
    //   1371: istore 6
    //   1373: goto -808 -> 565
    //   1376: aload 4
    //   1378: astore 13
    //   1380: aload 21
    //   1382: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   1385: bipush -2
    //   1387: if_icmpne +1626 -> 3013
    //   1390: aload 4
    //   1392: astore 11
    //   1394: aload 10
    //   1396: astore 4
    //   1398: aload 11
    //   1400: astore 10
    //   1402: goto +1656 -> 3058
    //   1405: aload 16
    //   1407: ldc_w 563
    //   1410: if_acmpne +66 -> 1476
    //   1413: aload 4
    //   1415: astore 13
    //   1417: aload 21
    //   1419: aload 22
    //   1421: invokevirtual 567	com/alibaba/fastjson/parser/JSONLexerBase:scanFieldFloatArray2	([C)[[F
    //   1424: astore 11
    //   1426: aload 4
    //   1428: astore 13
    //   1430: aload 21
    //   1432: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   1435: ifle +12 -> 1447
    //   1438: iconst_1
    //   1439: istore 5
    //   1441: iconst_1
    //   1442: istore 6
    //   1444: goto -879 -> 565
    //   1447: aload 4
    //   1449: astore 13
    //   1451: aload 21
    //   1453: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   1456: bipush -2
    //   1458: if_icmpne +1555 -> 3013
    //   1461: aload 4
    //   1463: astore 11
    //   1465: aload 10
    //   1467: astore 4
    //   1469: aload 11
    //   1471: astore 10
    //   1473: goto +1585 -> 3058
    //   1476: aload 4
    //   1478: astore 13
    //   1480: aload 21
    //   1482: aload 22
    //   1484: invokevirtual 570	com/alibaba/fastjson/parser/JSONLexerBase:matchField	([C)Z
    //   1487: ifeq +1511 -> 2998
    //   1490: iconst_0
    //   1491: istore 5
    //   1493: iconst_1
    //   1494: istore 6
    //   1496: aload 19
    //   1498: astore 11
    //   1500: goto -935 -> 565
    //   1503: iload 8
    //   1505: bipush 16
    //   1507: if_icmpne +33 -> 1540
    //   1510: aload 4
    //   1512: astore 13
    //   1514: aload 21
    //   1516: getstatic 573	com/alibaba/fastjson/parser/Feature:AllowArbitraryCommas	Lcom/alibaba/fastjson/parser/Feature;
    //   1519: invokevirtual 408	com/alibaba/fastjson/parser/JSONLexerBase:isEnabled	(Lcom/alibaba/fastjson/parser/Feature;)Z
    //   1522: ifeq +18 -> 1540
    //   1525: aload 4
    //   1527: astore 11
    //   1529: aload 10
    //   1531: astore 4
    //   1533: aload 11
    //   1535: astore 10
    //   1537: goto +1521 -> 3058
    //   1540: ldc_w 575
    //   1543: aload 19
    //   1545: if_acmpne +393 -> 1938
    //   1548: aload 4
    //   1550: astore 13
    //   1552: aload 21
    //   1554: iconst_4
    //   1555: invokevirtual 578	com/alibaba/fastjson/parser/JSONLexerBase:nextTokenWithColon	(I)V
    //   1558: aload 4
    //   1560: astore 13
    //   1562: aload 21
    //   1564: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   1567: istore 5
    //   1569: iload 5
    //   1571: iconst_4
    //   1572: if_icmpne +284 -> 1856
    //   1575: aload 4
    //   1577: astore 13
    //   1579: aload 21
    //   1581: invokevirtual 418	com/alibaba/fastjson/parser/JSONLexerBase:stringVal	()Ljava/lang/String;
    //   1584: astore 11
    //   1586: aload 4
    //   1588: astore 13
    //   1590: ldc_w 580
    //   1593: aload 11
    //   1595: invokevirtual 583	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1598: ifeq +54 -> 1652
    //   1601: aload 4
    //   1603: astore 13
    //   1605: aload 14
    //   1607: getfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   1610: astore 4
    //   1612: aload 4
    //   1614: astore 13
    //   1616: aload 21
    //   1618: bipush 13
    //   1620: invokevirtual 94	com/alibaba/fastjson/parser/JSONLexerBase:nextToken	(I)V
    //   1623: aload 4
    //   1625: astore 13
    //   1627: aload 21
    //   1629: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   1632: bipush 13
    //   1634: if_icmpeq +258 -> 1892
    //   1637: aload 4
    //   1639: astore 13
    //   1641: new 132	com/alibaba/fastjson/d
    //   1644: dup
    //   1645: ldc_w 585
    //   1648: invokespecial 137	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;)V
    //   1651: athrow
    //   1652: aload 4
    //   1654: astore 13
    //   1656: ldc_w 587
    //   1659: aload 11
    //   1661: invokevirtual 583	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1664: ifeq +67 -> 1731
    //   1667: aload 4
    //   1669: astore 13
    //   1671: aload 14
    //   1673: getfield 394	com/alibaba/fastjson/parser/ParseContext:parent	Lcom/alibaba/fastjson/parser/ParseContext;
    //   1676: astore_2
    //   1677: aload 4
    //   1679: astore 13
    //   1681: aload_2
    //   1682: getfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   1685: ifnull +16 -> 1701
    //   1688: aload 4
    //   1690: astore 13
    //   1692: aload_2
    //   1693: getfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   1696: astore 4
    //   1698: goto -86 -> 1612
    //   1701: aload 4
    //   1703: astore 13
    //   1705: aload_1
    //   1706: new 589	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1709: dup
    //   1710: aload_2
    //   1711: aload 11
    //   1713: invokespecial 592	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask:<init>	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1716: invokevirtual 596	com/alibaba/fastjson/parser/DefaultJSONParser:addResolveTask	(Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1719: aload 4
    //   1721: astore 13
    //   1723: aload_1
    //   1724: iconst_1
    //   1725: putfield 446	com/alibaba/fastjson/parser/DefaultJSONParser:resolveStatus	I
    //   1728: goto -116 -> 1612
    //   1731: aload 4
    //   1733: astore 13
    //   1735: ldc -7
    //   1737: aload 11
    //   1739: invokevirtual 583	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1742: ifeq +83 -> 1825
    //   1745: aload 14
    //   1747: astore_2
    //   1748: aload 4
    //   1750: astore 13
    //   1752: aload_2
    //   1753: getfield 394	com/alibaba/fastjson/parser/ParseContext:parent	Lcom/alibaba/fastjson/parser/ParseContext;
    //   1756: ifnull +15 -> 1771
    //   1759: aload 4
    //   1761: astore 13
    //   1763: aload_2
    //   1764: getfield 394	com/alibaba/fastjson/parser/ParseContext:parent	Lcom/alibaba/fastjson/parser/ParseContext;
    //   1767: astore_2
    //   1768: goto -20 -> 1748
    //   1771: aload 4
    //   1773: astore 13
    //   1775: aload_2
    //   1776: getfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   1779: ifnull +16 -> 1795
    //   1782: aload 4
    //   1784: astore 13
    //   1786: aload_2
    //   1787: getfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   1790: astore 4
    //   1792: goto -180 -> 1612
    //   1795: aload 4
    //   1797: astore 13
    //   1799: aload_1
    //   1800: new 589	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1803: dup
    //   1804: aload_2
    //   1805: aload 11
    //   1807: invokespecial 592	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask:<init>	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1810: invokevirtual 596	com/alibaba/fastjson/parser/DefaultJSONParser:addResolveTask	(Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1813: aload 4
    //   1815: astore 13
    //   1817: aload_1
    //   1818: iconst_1
    //   1819: putfield 446	com/alibaba/fastjson/parser/DefaultJSONParser:resolveStatus	I
    //   1822: goto -210 -> 1612
    //   1825: aload 4
    //   1827: astore 13
    //   1829: aload_1
    //   1830: new 589	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1833: dup
    //   1834: aload 14
    //   1836: aload 11
    //   1838: invokespecial 592	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask:<init>	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1841: invokevirtual 596	com/alibaba/fastjson/parser/DefaultJSONParser:addResolveTask	(Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1844: aload 4
    //   1846: astore 13
    //   1848: aload_1
    //   1849: iconst_1
    //   1850: putfield 446	com/alibaba/fastjson/parser/DefaultJSONParser:resolveStatus	I
    //   1853: goto -241 -> 1612
    //   1856: aload 4
    //   1858: astore 13
    //   1860: new 132	com/alibaba/fastjson/d
    //   1863: dup
    //   1864: new 242	java/lang/StringBuilder
    //   1867: dup
    //   1868: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1871: ldc_w 598
    //   1874: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1877: iload 5
    //   1879: invokestatic 603	com/alibaba/fastjson/parser/JSONToken:name	(I)Ljava/lang/String;
    //   1882: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1885: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1888: invokespecial 137	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;)V
    //   1891: athrow
    //   1892: aload 4
    //   1894: astore 13
    //   1896: aload 21
    //   1898: bipush 16
    //   1900: invokevirtual 94	com/alibaba/fastjson/parser/JSONLexerBase:nextToken	(I)V
    //   1903: aload 4
    //   1905: astore 13
    //   1907: aload_1
    //   1908: aload 14
    //   1910: aload 4
    //   1912: aload_3
    //   1913: invokevirtual 475	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   1916: pop
    //   1917: aload 10
    //   1919: ifnull +10 -> 1929
    //   1922: aload 10
    //   1924: aload 4
    //   1926: putfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   1929: aload_1
    //   1930: aload 14
    //   1932: invokevirtual 398	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   1935: aload 4
    //   1937: areturn
    //   1938: aload 19
    //   1940: astore 18
    //   1942: aload 4
    //   1944: astore 13
    //   1946: getstatic 606	com/alibaba/fastjson/a:c	Ljava/lang/String;
    //   1949: aload 19
    //   1951: if_acmpne +260 -> 2211
    //   1954: aload 4
    //   1956: astore 13
    //   1958: aload 21
    //   1960: iconst_4
    //   1961: invokevirtual 578	com/alibaba/fastjson/parser/JSONLexerBase:nextTokenWithColon	(I)V
    //   1964: aload 4
    //   1966: astore 13
    //   1968: aload 21
    //   1970: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   1973: iconst_4
    //   1974: if_icmpne +223 -> 2197
    //   1977: aload 4
    //   1979: astore 13
    //   1981: aload 21
    //   1983: invokevirtual 418	com/alibaba/fastjson/parser/JSONLexerBase:stringVal	()Ljava/lang/String;
    //   1986: astore 16
    //   1988: aload 4
    //   1990: astore 13
    //   1992: aload 21
    //   1994: bipush 16
    //   1996: invokevirtual 94	com/alibaba/fastjson/parser/JSONLexerBase:nextToken	(I)V
    //   1999: aload 4
    //   2001: astore 13
    //   2003: aload 16
    //   2005: aload_0
    //   2006: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2009: getfield 609	com/alibaba/fastjson/util/JavaBeanInfo:typeName	Ljava/lang/String;
    //   2012: invokevirtual 583	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2015: ifeq +29 -> 2044
    //   2018: aload 4
    //   2020: astore 13
    //   2022: aload 21
    //   2024: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   2027: bipush 13
    //   2029: if_icmpne +969 -> 2998
    //   2032: aload 4
    //   2034: astore 13
    //   2036: aload 21
    //   2038: invokevirtual 109	com/alibaba/fastjson/parser/JSONLexerBase:nextToken	()V
    //   2041: goto -1422 -> 619
    //   2044: aload 4
    //   2046: astore 13
    //   2048: aload_1
    //   2049: invokevirtual 526	com/alibaba/fastjson/parser/DefaultJSONParser:getConfig	()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   2052: astore 17
    //   2054: aload 4
    //   2056: astore 13
    //   2058: aload_0
    //   2059: aload 17
    //   2061: aload_0
    //   2062: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2065: aload 16
    //   2067: invokevirtual 613	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:getSeeAlso	(Lcom/alibaba/fastjson/parser/ParserConfig;Lcom/alibaba/fastjson/util/JavaBeanInfo;Ljava/lang/String;)Lcom/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer;
    //   2070: astore 15
    //   2072: aconst_null
    //   2073: astore 12
    //   2075: aload 15
    //   2077: astore 11
    //   2079: aload 15
    //   2081: ifnonnull +65 -> 2146
    //   2084: aload 4
    //   2086: astore 13
    //   2088: aload 16
    //   2090: aload 17
    //   2092: invokevirtual 616	com/alibaba/fastjson/parser/ParserConfig:getDefaultClassLoader	()Ljava/lang/ClassLoader;
    //   2095: invokestatic 620	com/alibaba/fastjson/util/TypeUtils:loadClass	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Class;
    //   2098: astore 12
    //   2100: aload 4
    //   2102: astore 13
    //   2104: aload_2
    //   2105: invokestatic 623	com/alibaba/fastjson/util/TypeUtils:getClass	(Ljava/lang/reflect/Type;)Ljava/lang/Class;
    //   2108: astore_2
    //   2109: aload_2
    //   2110: ifnull +21 -> 2131
    //   2113: aload 12
    //   2115: ifnull +67 -> 2182
    //   2118: aload 4
    //   2120: astore 13
    //   2122: aload_2
    //   2123: aload 12
    //   2125: invokevirtual 627	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   2128: ifeq +54 -> 2182
    //   2131: aload 4
    //   2133: astore 13
    //   2135: aload_1
    //   2136: invokevirtual 526	com/alibaba/fastjson/parser/DefaultJSONParser:getConfig	()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   2139: aload 12
    //   2141: invokevirtual 530	com/alibaba/fastjson/parser/ParserConfig:getDeserializer	(Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   2144: astore 11
    //   2146: aload 4
    //   2148: astore 13
    //   2150: aload 11
    //   2152: aload_1
    //   2153: aload 12
    //   2155: aload_3
    //   2156: invokeinterface 119 4 0
    //   2161: astore_2
    //   2162: aload 10
    //   2164: ifnull +10 -> 2174
    //   2167: aload 10
    //   2169: aload 4
    //   2171: putfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   2174: aload_1
    //   2175: aload 14
    //   2177: invokevirtual 398	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2180: aload_2
    //   2181: areturn
    //   2182: aload 4
    //   2184: astore 13
    //   2186: new 132	com/alibaba/fastjson/d
    //   2189: dup
    //   2190: ldc_w 629
    //   2193: invokespecial 137	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;)V
    //   2196: athrow
    //   2197: aload 4
    //   2199: astore 13
    //   2201: new 132	com/alibaba/fastjson/d
    //   2204: dup
    //   2205: ldc -122
    //   2207: invokespecial 137	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;)V
    //   2210: athrow
    //   2211: aload 4
    //   2213: ifnonnull +770 -> 2983
    //   2216: aload 12
    //   2218: ifnonnull +765 -> 2983
    //   2221: aload 4
    //   2223: astore 13
    //   2225: aload_0
    //   2226: aload_1
    //   2227: aload_2
    //   2228: invokevirtual 310	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:createInstance	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   2231: astore 4
    //   2233: aload 4
    //   2235: ifnonnull +21 -> 2256
    //   2238: aload 4
    //   2240: astore 13
    //   2242: new 251	java/util/HashMap
    //   2245: dup
    //   2246: aload_0
    //   2247: getfield 48	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:fieldDeserializers	[Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   2250: arraylength
    //   2251: invokespecial 631	java/util/HashMap:<init>	(I)V
    //   2254: astore 12
    //   2256: aload 4
    //   2258: astore 13
    //   2260: aload_1
    //   2261: aload 14
    //   2263: aload 4
    //   2265: aload_3
    //   2266: invokevirtual 475	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   2269: astore 19
    //   2271: aload 19
    //   2273: astore 13
    //   2275: aload 4
    //   2277: astore 10
    //   2279: aload 13
    //   2281: astore 4
    //   2283: iload 6
    //   2285: ifeq +145 -> 2430
    //   2288: iload 5
    //   2290: ifne +27 -> 2317
    //   2293: aload 17
    //   2295: aload_1
    //   2296: aload 10
    //   2298: aload_2
    //   2299: aload 12
    //   2301: invokevirtual 635	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:parseField	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/util/Map;)V
    //   2304: aload 21
    //   2306: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   2309: bipush 16
    //   2311: if_icmpne +185 -> 2496
    //   2314: goto +744 -> 3058
    //   2317: aload 10
    //   2319: ifnonnull +42 -> 2361
    //   2322: aload 12
    //   2324: aload 15
    //   2326: getfield 54	com/alibaba/fastjson/util/FieldInfo:name	Ljava/lang/String;
    //   2329: aload 11
    //   2331: invokeinterface 258 3 0
    //   2336: pop
    //   2337: aload 21
    //   2339: getfield 464	com/alibaba/fastjson/parser/JSONLexerBase:matchStat	I
    //   2342: iconst_4
    //   2343: if_icmpne -39 -> 2304
    //   2346: aload 4
    //   2348: astore 11
    //   2350: aload 10
    //   2352: astore 4
    //   2354: aload 11
    //   2356: astore 10
    //   2358: goto -1739 -> 619
    //   2361: aload 11
    //   2363: ifnonnull +55 -> 2418
    //   2366: aload 16
    //   2368: getstatic 457	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   2371: if_acmpeq -34 -> 2337
    //   2374: aload 16
    //   2376: getstatic 478	java/lang/Long:TYPE	Ljava/lang/Class;
    //   2379: if_acmpeq -42 -> 2337
    //   2382: aload 16
    //   2384: getstatic 502	java/lang/Float:TYPE	Ljava/lang/Class;
    //   2387: if_acmpeq -50 -> 2337
    //   2390: aload 16
    //   2392: getstatic 512	java/lang/Double:TYPE	Ljava/lang/Class;
    //   2395: if_acmpeq -58 -> 2337
    //   2398: aload 16
    //   2400: getstatic 492	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   2403: if_acmpeq -66 -> 2337
    //   2406: aload 17
    //   2408: aload 10
    //   2410: aload 11
    //   2412: invokevirtual 356	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:setValue	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   2415: goto -78 -> 2337
    //   2418: aload 17
    //   2420: aload 10
    //   2422: aload 11
    //   2424: invokevirtual 356	com/alibaba/fastjson/parser/deserializer/FieldDeserializer:setValue	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   2427: goto -90 -> 2337
    //   2430: aload_0
    //   2431: aload_1
    //   2432: aload 18
    //   2434: aload 10
    //   2436: aload_2
    //   2437: aload 12
    //   2439: invokevirtual 638	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:parseField	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/util/Map;)Z
    //   2442: ifne +33 -> 2475
    //   2445: aload 21
    //   2447: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   2450: bipush 13
    //   2452: if_icmpne +594 -> 3046
    //   2455: aload 21
    //   2457: invokevirtual 109	com/alibaba/fastjson/parser/JSONLexerBase:nextToken	()V
    //   2460: aload 4
    //   2462: astore 11
    //   2464: aload 10
    //   2466: astore 4
    //   2468: aload 11
    //   2470: astore 10
    //   2472: goto -1853 -> 619
    //   2475: aload 21
    //   2477: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   2480: bipush 17
    //   2482: if_icmpne -178 -> 2304
    //   2485: new 132	com/alibaba/fastjson/d
    //   2488: dup
    //   2489: ldc_w 640
    //   2492: invokespecial 137	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;)V
    //   2495: athrow
    //   2496: aload 21
    //   2498: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   2501: bipush 13
    //   2503: if_icmpne +25 -> 2528
    //   2506: aload 21
    //   2508: bipush 16
    //   2510: invokevirtual 94	com/alibaba/fastjson/parser/JSONLexerBase:nextToken	(I)V
    //   2513: aload 10
    //   2515: astore 11
    //   2517: aload 4
    //   2519: astore 10
    //   2521: aload 11
    //   2523: astore 4
    //   2525: goto -1906 -> 619
    //   2528: aload 21
    //   2530: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   2533: bipush 18
    //   2535: if_icmpeq +12 -> 2547
    //   2538: aload 21
    //   2540: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   2543: iconst_1
    //   2544: if_icmpne +502 -> 3046
    //   2547: new 132	com/alibaba/fastjson/d
    //   2550: dup
    //   2551: new 242	java/lang/StringBuilder
    //   2554: dup
    //   2555: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   2558: ldc_w 642
    //   2561: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2564: aload 21
    //   2566: invokevirtual 90	com/alibaba/fastjson/parser/JSONLexerBase:token	()I
    //   2569: invokestatic 603	com/alibaba/fastjson/parser/JSONToken:name	(I)Ljava/lang/String;
    //   2572: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2575: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2578: invokespecial 137	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;)V
    //   2581: athrow
    //   2582: aload_0
    //   2583: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2586: getfield 46	com/alibaba/fastjson/util/JavaBeanInfo:fields	[Lcom/alibaba/fastjson/util/FieldInfo;
    //   2589: astore 13
    //   2591: aload 13
    //   2593: arraylength
    //   2594: istore 6
    //   2596: iload 6
    //   2598: anewarray 4	java/lang/Object
    //   2601: astore 11
    //   2603: iconst_0
    //   2604: istore 5
    //   2606: iload 5
    //   2608: iload 6
    //   2610: if_icmpge +149 -> 2759
    //   2613: aload 13
    //   2615: iload 5
    //   2617: aaload
    //   2618: astore 15
    //   2620: aload 12
    //   2622: aload 15
    //   2624: getfield 54	com/alibaba/fastjson/util/FieldInfo:name	Ljava/lang/String;
    //   2627: invokeinterface 265 2 0
    //   2632: astore_3
    //   2633: aload_3
    //   2634: astore_2
    //   2635: aload_3
    //   2636: ifnonnull +474 -> 3110
    //   2639: aload 15
    //   2641: getfield 347	com/alibaba/fastjson/util/FieldInfo:fieldType	Ljava/lang/reflect/Type;
    //   2644: astore 15
    //   2646: aload 15
    //   2648: getstatic 645	java/lang/Byte:TYPE	Ljava/lang/Class;
    //   2651: if_acmpne +11 -> 2662
    //   2654: iconst_0
    //   2655: invokestatic 648	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   2658: astore_2
    //   2659: goto +451 -> 3110
    //   2662: aload 15
    //   2664: getstatic 651	java/lang/Short:TYPE	Ljava/lang/Class;
    //   2667: if_acmpne +11 -> 2678
    //   2670: iconst_0
    //   2671: invokestatic 654	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   2674: astore_2
    //   2675: goto +435 -> 3110
    //   2678: aload 15
    //   2680: getstatic 457	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   2683: if_acmpne +11 -> 2694
    //   2686: iconst_0
    //   2687: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2690: astore_2
    //   2691: goto +419 -> 3110
    //   2694: aload 15
    //   2696: getstatic 478	java/lang/Long:TYPE	Ljava/lang/Class;
    //   2699: if_acmpne +11 -> 2710
    //   2702: lconst_0
    //   2703: invokestatic 485	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2706: astore_2
    //   2707: goto +403 -> 3110
    //   2710: aload 15
    //   2712: getstatic 502	java/lang/Float:TYPE	Ljava/lang/Class;
    //   2715: if_acmpne +11 -> 2726
    //   2718: fconst_0
    //   2719: invokestatic 509	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   2722: astore_2
    //   2723: goto +387 -> 3110
    //   2726: aload 15
    //   2728: getstatic 512	java/lang/Double:TYPE	Ljava/lang/Class;
    //   2731: if_acmpne +11 -> 2742
    //   2734: dconst_0
    //   2735: invokestatic 519	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   2738: astore_2
    //   2739: goto +371 -> 3110
    //   2742: aload_3
    //   2743: astore_2
    //   2744: aload 15
    //   2746: getstatic 492	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   2749: if_acmpne +361 -> 3110
    //   2752: getstatic 658	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2755: astore_2
    //   2756: goto +354 -> 3110
    //   2759: aload_0
    //   2760: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2763: getfield 304	com/alibaba/fastjson/util/JavaBeanInfo:creatorConstructor	Ljava/lang/reflect/Constructor;
    //   2766: astore_2
    //   2767: aload_2
    //   2768: ifnull +89 -> 2857
    //   2771: aload_0
    //   2772: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2775: getfield 304	com/alibaba/fastjson/util/JavaBeanInfo:creatorConstructor	Ljava/lang/reflect/Constructor;
    //   2778: aload 11
    //   2780: invokevirtual 190	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   2783: astore_2
    //   2784: aload_2
    //   2785: astore 4
    //   2787: aload_0
    //   2788: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2791: getfield 359	com/alibaba/fastjson/util/JavaBeanInfo:buildMethod	Ljava/lang/reflect/Method;
    //   2794: astore_3
    //   2795: aload_3
    //   2796: ifnonnull +129 -> 2925
    //   2799: aload 10
    //   2801: ifnull +9 -> 2810
    //   2804: aload 10
    //   2806: aload_2
    //   2807: putfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   2810: aload_1
    //   2811: aload 14
    //   2813: invokevirtual 398	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2816: aload_2
    //   2817: areturn
    //   2818: astore_2
    //   2819: new 132	com/alibaba/fastjson/d
    //   2822: dup
    //   2823: new 242	java/lang/StringBuilder
    //   2826: dup
    //   2827: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   2830: ldc_w 369
    //   2833: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2836: aload_0
    //   2837: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2840: getfield 304	com/alibaba/fastjson/util/JavaBeanInfo:creatorConstructor	Ljava/lang/reflect/Constructor;
    //   2843: invokevirtual 372	java/lang/reflect/Constructor:toGenericString	()Ljava/lang/String;
    //   2846: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2849: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2852: aload_2
    //   2853: invokespecial 290	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2856: athrow
    //   2857: aload_0
    //   2858: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2861: getfield 308	com/alibaba/fastjson/util/JavaBeanInfo:factoryMethod	Ljava/lang/reflect/Method;
    //   2864: astore_2
    //   2865: aload_2
    //   2866: ifnull +111 -> 2977
    //   2869: aload_0
    //   2870: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2873: getfield 308	com/alibaba/fastjson/util/JavaBeanInfo:factoryMethod	Ljava/lang/reflect/Method;
    //   2876: aconst_null
    //   2877: aload 11
    //   2879: invokevirtual 365	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2882: astore_2
    //   2883: goto -99 -> 2784
    //   2886: astore_2
    //   2887: new 132	com/alibaba/fastjson/d
    //   2890: dup
    //   2891: new 242	java/lang/StringBuilder
    //   2894: dup
    //   2895: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   2898: ldc_w 374
    //   2901: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2904: aload_0
    //   2905: getfield 29	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2908: getfield 308	com/alibaba/fastjson/util/JavaBeanInfo:factoryMethod	Ljava/lang/reflect/Method;
    //   2911: invokevirtual 375	java/lang/reflect/Method:toString	()Ljava/lang/String;
    //   2914: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2917: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2920: aload_2
    //   2921: invokespecial 290	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2924: athrow
    //   2925: aload_2
    //   2926: astore 4
    //   2928: aload_3
    //   2929: aload_2
    //   2930: iconst_0
    //   2931: anewarray 4	java/lang/Object
    //   2934: invokevirtual 365	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2937: astore_3
    //   2938: aload 10
    //   2940: ifnull +9 -> 2949
    //   2943: aload 10
    //   2945: aload_2
    //   2946: putfield 221	com/alibaba/fastjson/parser/ParseContext:object	Ljava/lang/Object;
    //   2949: aload_1
    //   2950: aload 14
    //   2952: invokevirtual 398	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2955: aload_3
    //   2956: areturn
    //   2957: astore_3
    //   2958: aload_2
    //   2959: astore 4
    //   2961: new 132	com/alibaba/fastjson/d
    //   2964: dup
    //   2965: ldc_w 367
    //   2968: aload_3
    //   2969: invokespecial 290	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2972: athrow
    //   2973: astore_2
    //   2974: goto -2588 -> 386
    //   2977: aload 4
    //   2979: astore_2
    //   2980: goto -196 -> 2784
    //   2983: aload 10
    //   2985: astore 13
    //   2987: aload 4
    //   2989: astore 10
    //   2991: aload 13
    //   2993: astore 4
    //   2995: goto -712 -> 2283
    //   2998: aload 10
    //   3000: astore 11
    //   3002: aload 4
    //   3004: astore 10
    //   3006: aload 11
    //   3008: astore 4
    //   3010: goto +48 -> 3058
    //   3013: iconst_0
    //   3014: istore 5
    //   3016: iconst_0
    //   3017: istore 6
    //   3019: goto -2454 -> 565
    //   3022: iconst_0
    //   3023: istore 5
    //   3025: iconst_0
    //   3026: istore 6
    //   3028: goto +51 -> 3079
    //   3031: aconst_null
    //   3032: astore 18
    //   3034: aconst_null
    //   3035: astore 16
    //   3037: aconst_null
    //   3038: astore 15
    //   3040: aconst_null
    //   3041: astore 17
    //   3043: goto -2557 -> 486
    //   3046: goto +12 -> 3058
    //   3049: goto -2976 -> 73
    //   3052: iconst_1
    //   3053: istore 5
    //   3055: goto -2882 -> 173
    //   3058: iload 7
    //   3060: iconst_1
    //   3061: iadd
    //   3062: istore 7
    //   3064: aload 10
    //   3066: astore 11
    //   3068: aload 4
    //   3070: astore 10
    //   3072: aload 11
    //   3074: astore 4
    //   3076: goto -2650 -> 426
    //   3079: goto -2514 -> 565
    //   3082: astore_2
    //   3083: aload 13
    //   3085: astore 4
    //   3087: goto -2701 -> 386
    //   3090: aconst_null
    //   3091: astore 18
    //   3093: goto -882 -> 2211
    //   3096: astore_2
    //   3097: aload 10
    //   3099: astore_3
    //   3100: aload 4
    //   3102: astore 10
    //   3104: aload_3
    //   3105: astore 4
    //   3107: goto -2721 -> 386
    //   3110: aload 11
    //   3112: iload 5
    //   3114: aload_2
    //   3115: aastore
    //   3116: iload 5
    //   3118: iconst_1
    //   3119: iadd
    //   3120: istore 5
    //   3122: goto -516 -> 2606
    //   3125: astore_2
    //   3126: goto -2740 -> 386
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3129	0	this	JavaBeanDeserializer
    //   0	3129	1	paramDefaultJSONParser	DefaultJSONParser
    //   0	3129	2	paramType	Type
    //   0	3129	3	paramObject1	Object
    //   0	3129	4	paramObject2	Object
    //   0	3129	5	paramInt	int
    //   32	2995	6	i	int
    //   136	2927	7	j	int
    //   599	909	8	k	int
    //   225	3	9	bool	boolean
    //   77	3026	10	localObject1	Object
    //   74	3037	11	localObject2	Object
    //   80	2541	12	localObject3	Object
    //   428	2656	13	localObject4	Object
    //   54	2897	14	localParseContext	com.alibaba.fastjson.parser.ParseContext
    //   462	2577	15	localObject5	Object
    //   473	2563	16	localObject6	Object
    //   451	2591	17	localObject7	Object
    //   484	2608	18	localObject8	Object
    //   490	1782	19	localObject9	Object
    //   487	689	20	localObject10	Object
    //   25	2540	21	localJSONLexerBase	JSONLexerBase
    //   510	973	22	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   89	96	385	finally
    //   104	111	385	finally
    //   130	162	385	finally
    //   178	188	385	finally
    //   220	227	385	finally
    //   250	266	385	finally
    //   285	306	385	finally
    //   318	373	385	finally
    //   373	385	385	finally
    //   406	419	385	finally
    //   2771	2784	2818	java/lang/Exception
    //   2869	2883	2886	java/lang/Exception
    //   2928	2938	2957	java/lang/Exception
    //   648	657	2973	finally
    //   2787	2795	2973	finally
    //   2928	2938	2973	finally
    //   2961	2973	2973	finally
    //   430	440	3082	finally
    //   444	453	3082	finally
    //   457	464	3082	finally
    //   468	475	3082	finally
    //   479	486	3082	finally
    //   505	512	3082	finally
    //   516	524	3082	finally
    //   535	547	3082	finally
    //   551	559	3082	finally
    //   574	585	3082	finally
    //   594	601	3082	finally
    //   612	619	3082	finally
    //   683	693	3082	finally
    //   712	720	3082	finally
    //   732	744	3082	finally
    //   748	756	3082	finally
    //   769	779	3082	finally
    //   805	814	3082	finally
    //   818	826	3082	finally
    //   839	849	3082	finally
    //   868	876	3082	finally
    //   888	900	3082	finally
    //   904	912	3082	finally
    //   925	935	3082	finally
    //   954	962	3082	finally
    //   974	986	3082	finally
    //   990	998	3082	finally
    //   1011	1021	3082	finally
    //   1040	1048	3082	finally
    //   1060	1072	3082	finally
    //   1076	1084	3082	finally
    //   1097	1107	3082	finally
    //   1126	1134	3082	finally
    //   1138	1153	3082	finally
    //   1162	1175	3082	finally
    //   1183	1191	3082	finally
    //   1195	1213	3082	finally
    //   1217	1225	3082	finally
    //   1238	1248	3082	finally
    //   1275	1284	3082	finally
    //   1288	1296	3082	finally
    //   1309	1319	3082	finally
    //   1346	1355	3082	finally
    //   1359	1367	3082	finally
    //   1380	1390	3082	finally
    //   1417	1426	3082	finally
    //   1430	1438	3082	finally
    //   1451	1461	3082	finally
    //   1480	1490	3082	finally
    //   1514	1525	3082	finally
    //   1552	1558	3082	finally
    //   1562	1569	3082	finally
    //   1579	1586	3082	finally
    //   1590	1601	3082	finally
    //   1605	1612	3082	finally
    //   1616	1623	3082	finally
    //   1627	1637	3082	finally
    //   1641	1652	3082	finally
    //   1656	1667	3082	finally
    //   1671	1677	3082	finally
    //   1681	1688	3082	finally
    //   1692	1698	3082	finally
    //   1705	1719	3082	finally
    //   1723	1728	3082	finally
    //   1735	1745	3082	finally
    //   1752	1759	3082	finally
    //   1763	1768	3082	finally
    //   1775	1782	3082	finally
    //   1786	1792	3082	finally
    //   1799	1813	3082	finally
    //   1817	1822	3082	finally
    //   1829	1844	3082	finally
    //   1848	1853	3082	finally
    //   1860	1892	3082	finally
    //   1896	1903	3082	finally
    //   1907	1917	3082	finally
    //   1946	1954	3082	finally
    //   1958	1964	3082	finally
    //   1968	1977	3082	finally
    //   1981	1988	3082	finally
    //   1992	1999	3082	finally
    //   2003	2018	3082	finally
    //   2022	2032	3082	finally
    //   2036	2041	3082	finally
    //   2048	2054	3082	finally
    //   2058	2072	3082	finally
    //   2088	2100	3082	finally
    //   2104	2109	3082	finally
    //   2122	2131	3082	finally
    //   2135	2146	3082	finally
    //   2150	2162	3082	finally
    //   2186	2197	3082	finally
    //   2201	2211	3082	finally
    //   2225	2233	3082	finally
    //   2242	2256	3082	finally
    //   2260	2271	3082	finally
    //   2293	2304	3096	finally
    //   2304	2314	3096	finally
    //   2322	2337	3096	finally
    //   2337	2346	3096	finally
    //   2366	2415	3096	finally
    //   2418	2427	3096	finally
    //   2430	2460	3096	finally
    //   2475	2496	3096	finally
    //   2496	2513	3096	finally
    //   2528	2547	3096	finally
    //   2547	2582	3096	finally
    //   629	636	3125	finally
    //   2582	2603	3125	finally
    //   2620	2633	3125	finally
    //   2639	2659	3125	finally
    //   2662	2675	3125	finally
    //   2678	2691	3125	finally
    //   2694	2707	3125	finally
    //   2710	2723	3125	finally
    //   2726	2739	3125	finally
    //   2744	2756	3125	finally
    //   2759	2767	3125	finally
    //   2771	2784	3125	finally
    //   2819	2857	3125	finally
    //   2857	2865	3125	finally
    //   2869	2883	3125	finally
    //   2887	2925	3125	finally
  }
  
  public <T> T deserialzeArrayMapping(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    paramObject1 = paramDefaultJSONParser.lexer;
    if (((JSONLexer)paramObject1).token() != 14) {
      throw new d("error");
    }
    paramObject2 = createInstance(paramDefaultJSONParser, paramType);
    int k = this.sortedFieldDeserializers.length;
    int i = 0;
    if (i < k)
    {
      char c;
      label65:
      FieldDeserializer localFieldDeserializer;
      if (i == k - 1)
      {
        c = ']';
        localFieldDeserializer = this.sortedFieldDeserializers[i];
        paramType = localFieldDeserializer.fieldInfo.fieldClass;
        if (paramType != Integer.TYPE) {
          break label121;
        }
        localFieldDeserializer.setValue(paramObject2, ((JSONLexer)paramObject1).scanInt(c));
      }
      for (;;)
      {
        i += 1;
        break;
        c = ',';
        break label65;
        label121:
        if (paramType == String.class)
        {
          localFieldDeserializer.setValue(paramObject2, ((JSONLexer)paramObject1).scanString(c));
        }
        else if (paramType == Long.TYPE)
        {
          localFieldDeserializer.setValue(paramObject2, ((JSONLexer)paramObject1).scanLong(c));
        }
        else
        {
          if (paramType.isEnum())
          {
            j = ((JSONLexer)paramObject1).getCurrent();
            if ((j == 34) || (j == 110)) {
              paramType = ((JSONLexer)paramObject1).scanEnum(paramType, paramDefaultJSONParser.getSymbolTable(), c);
            }
            for (;;)
            {
              localFieldDeserializer.setValue(paramObject2, paramType);
              break;
              if ((j >= 48) && (j <= 57))
              {
                j = ((JSONLexer)paramObject1).scanInt(c);
                paramType = ((EnumDeserializer)((DefaultFieldDeserializer)localFieldDeserializer).getFieldValueDeserilizer(paramDefaultJSONParser.getConfig())).valueOf(j);
              }
              else
              {
                paramType = scanEnum((JSONLexer)paramObject1, c);
              }
            }
          }
          if (paramType == Boolean.TYPE)
          {
            localFieldDeserializer.setValue(paramObject2, ((JSONLexer)paramObject1).scanBoolean(c));
          }
          else if (paramType == Float.TYPE)
          {
            localFieldDeserializer.setValue(paramObject2, Float.valueOf(((JSONLexer)paramObject1).scanFloat(c)));
          }
          else if (paramType == Double.TYPE)
          {
            localFieldDeserializer.setValue(paramObject2, Double.valueOf(((JSONLexer)paramObject1).scanDouble(c)));
          }
          else
          {
            if ((paramType != Date.class) || (((JSONLexer)paramObject1).getCurrent() != '1')) {
              break label407;
            }
            localFieldDeserializer.setValue(paramObject2, new Date(((JSONLexer)paramObject1).scanLong(c)));
          }
        }
      }
      label407:
      ((JSONLexer)paramObject1).nextToken(14);
      localFieldDeserializer.setValue(paramObject2, paramDefaultJSONParser.parseObject(localFieldDeserializer.fieldInfo.fieldType));
      if (c == ']') {}
      for (int j = 15;; j = 16)
      {
        check((JSONLexer)paramObject1, j);
        break;
      }
    }
    ((JSONLexer)paramObject1).nextToken(16);
    return (T)paramObject2;
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
  
  public FieldDeserializer getFieldDeserializer(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = 0;
    int j = this.sortedFieldDeserializers.length - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.sortedFieldDeserializers[k].fieldInfo.name.compareTo(paramString);
      if (m < 0) {
        i = k + 1;
      } else if (m > 0) {
        j = k - 1;
      } else {
        return this.sortedFieldDeserializers[k];
      }
    }
    return null;
  }
  
  public Type getFieldType(int paramInt)
  {
    return this.sortedFieldDeserializers[paramInt].fieldInfo.fieldType;
  }
  
  protected JavaBeanDeserializer getSeeAlso(ParserConfig paramParserConfig, JavaBeanInfo paramJavaBeanInfo, String paramString)
  {
    if (paramJavaBeanInfo.jsonType == null)
    {
      paramJavaBeanInfo = null;
      return paramJavaBeanInfo;
    }
    Class[] arrayOfClass = paramJavaBeanInfo.jsonType.seeAlso();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label104;
      }
      paramJavaBeanInfo = paramParserConfig.getDeserializer(arrayOfClass[i]);
      if ((paramJavaBeanInfo instanceof JavaBeanDeserializer))
      {
        paramJavaBeanInfo = (JavaBeanDeserializer)paramJavaBeanInfo;
        Object localObject = paramJavaBeanInfo.beanInfo;
        if (((JavaBeanInfo)localObject).typeName.equals(paramString)) {
          break;
        }
        localObject = getSeeAlso(paramParserConfig, (JavaBeanInfo)localObject, paramString);
        paramJavaBeanInfo = (JavaBeanInfo)localObject;
        if (localObject != null) {
          break;
        }
      }
      i += 1;
    }
    label104:
    return null;
  }
  
  public boolean parseField(DefaultJSONParser paramDefaultJSONParser, String paramString, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    Object localObject1 = smartMatch(paramString);
    int i = Feature.SupportNonPublicField.mask;
    Object localObject2;
    if ((localObject1 == null) && ((paramDefaultJSONParser.lexer.isEnabled(i)) || ((i & this.beanInfo.parserFeatures) != 0)))
    {
      if (this.extraFieldDeserializers == null)
      {
        localObject2 = new ConcurrentHashMap(1, 0.75F, 1);
        Field[] arrayOfField = this.clazz.getDeclaredFields();
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          Field localField = arrayOfField[i];
          String str = localField.getName();
          if (getFieldDeserializer(str) != null) {}
          for (;;)
          {
            i += 1;
            break;
            int k = localField.getModifiers();
            if (((k & 0x10) == 0) && ((k & 0x8) == 0)) {
              ((ConcurrentHashMap)localObject2).put(str, localField);
            }
          }
        }
        this.extraFieldDeserializers = ((ConcurrentMap)localObject2);
      }
      localObject2 = this.extraFieldDeserializers.get(paramString);
      if (localObject2 != null) {
        if ((localObject2 instanceof FieldDeserializer)) {
          localObject1 = (FieldDeserializer)localObject2;
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        if (!localJSONLexer.isEnabled(Feature.IgnoreNotMatch))
        {
          throw new d("setter not found, class " + this.clazz.getName() + ", property " + paramString);
          localObject1 = (Field)localObject2;
          ((Field)localObject1).setAccessible(true);
          localObject1 = new FieldInfo(paramString, ((Field)localObject1).getDeclaringClass(), ((Field)localObject1).getType(), ((Field)localObject1).getGenericType(), (Field)localObject1, 0, 0, 0);
          localObject1 = new DefaultFieldDeserializer(paramDefaultJSONParser.getConfig(), this.clazz, (FieldInfo)localObject1);
          this.extraFieldDeserializers.put(paramString, localObject1);
        }
        else
        {
          paramDefaultJSONParser.parseExtra(paramObject, paramString);
          return false;
        }
      }
      else
      {
        localJSONLexer.nextTokenWithColon(((FieldDeserializer)localObject1).getFastMatchToken());
        ((FieldDeserializer)localObject1).parseField(paramDefaultJSONParser, paramObject, paramType, paramMap);
        return true;
      }
    }
  }
  
  protected Object parseRest(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2, int paramInt)
  {
    return deserialze(paramDefaultJSONParser, paramType, paramObject1, paramObject2, paramInt);
  }
  
  protected Enum<?> scanEnum(JSONLexer paramJSONLexer, char paramChar)
  {
    throw new d("illegal enum. " + paramJSONLexer.info());
  }
  
  protected Enum scanEnum(JSONLexerBase paramJSONLexerBase, char[] paramArrayOfChar, ObjectDeserializer paramObjectDeserializer)
  {
    if ((paramObjectDeserializer instanceof EnumDeserializer)) {}
    for (paramObjectDeserializer = (EnumDeserializer)paramObjectDeserializer;; paramObjectDeserializer = null)
    {
      if (paramObjectDeserializer == null) {
        paramJSONLexerBase.matchStat = -1;
      }
      long l;
      do
      {
        return null;
        l = paramJSONLexerBase.scanFieldSymbol(paramArrayOfChar);
      } while (paramJSONLexerBase.matchStat <= 0);
      return paramObjectDeserializer.getEnumByHashCode(l);
    }
  }
  
  public FieldDeserializer smartMatch(String paramString)
  {
    int j = 0;
    if (paramString == null)
    {
      localObject2 = null;
      return (FieldDeserializer)localObject2;
    }
    Object localObject2 = getFieldDeserializer(paramString);
    boolean bool;
    FieldDeserializer[] arrayOfFieldDeserializer;
    int k;
    int i;
    label46:
    Object localObject1;
    Object localObject4;
    Object localObject3;
    if (localObject2 == null)
    {
      bool = paramString.startsWith("is");
      arrayOfFieldDeserializer = this.sortedFieldDeserializers;
      k = arrayOfFieldDeserializer.length;
      i = 0;
      if (i < k)
      {
        localObject1 = arrayOfFieldDeserializer[i];
        localObject4 = ((FieldDeserializer)localObject1).fieldInfo;
        localObject3 = ((FieldInfo)localObject4).fieldClass;
        localObject4 = ((FieldInfo)localObject4).name;
        if (!((String)localObject4).equalsIgnoreCase(paramString)) {}
      }
    }
    for (;;)
    {
      label88:
      if (localObject1 == null)
      {
        i = 0;
        label95:
        if (i >= paramString.length()) {
          break label332;
        }
        k = paramString.charAt(i);
        if (k == 95)
        {
          localObject2 = paramString.replaceAll("_", "");
          i = 1;
        }
      }
      for (;;)
      {
        label130:
        if (i != 0)
        {
          localObject1 = getFieldDeserializer((String)localObject2);
          if (localObject1 == null)
          {
            localObject3 = this.sortedFieldDeserializers;
            k = localObject3.length;
            i = 0;
            label160:
            if (i < k)
            {
              arrayOfFieldDeserializer = localObject3[i];
              if (arrayOfFieldDeserializer.fieldInfo.name.equalsIgnoreCase((String)localObject2)) {
                localObject1 = arrayOfFieldDeserializer;
              }
            }
          }
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            localObject3 = this.sortedFieldDeserializers;
            k = localObject3.length;
            i = j;
            for (;;)
            {
              if (i < k)
              {
                arrayOfFieldDeserializer = localObject3[i];
                localObject2 = arrayOfFieldDeserializer;
                if (arrayOfFieldDeserializer.fieldInfo.alternateName(paramString)) {
                  break;
                }
                i += 1;
                continue;
                if ((bool) && ((localObject3 == Boolean.TYPE) || (localObject3 == Boolean.class)) && (((String)localObject4).equalsIgnoreCase(paramString.substring(2)))) {
                  break label88;
                }
                i += 1;
                break label46;
                if (k == 45)
                {
                  localObject2 = paramString.replaceAll("-", "");
                  i = 1;
                  break label130;
                }
                i += 1;
                break label95;
                i += 1;
                break label160;
              }
            }
          }
          return (FieldDeserializer)localObject1;
        }
        label332:
        localObject2 = null;
        i = 0;
      }
      localObject1 = localObject2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */