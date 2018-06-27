package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class JavaBeanInfo
{
  public final Method buildMethod;
  public final Class<?> builderClass;
  public final Class<?> clazz;
  public final Constructor<?> creatorConstructor;
  public final Constructor<?> defaultConstructor;
  public final int defaultConstructorParameterSize;
  public final Method factoryMethod;
  public final FieldInfo[] fields;
  public final JSONType jsonType;
  public final int parserFeatures;
  public final FieldInfo[] sortedFields;
  public final String typeName;
  
  public JavaBeanInfo(Class<?> paramClass1, Class<?> paramClass2, Constructor<?> paramConstructor1, Constructor<?> paramConstructor2, Method paramMethod1, Method paramMethod2, JSONType paramJSONType, List<FieldInfo> paramList)
  {
    this.clazz = paramClass1;
    this.builderClass = paramClass2;
    this.defaultConstructor = paramConstructor1;
    this.creatorConstructor = paramConstructor2;
    this.factoryMethod = paramMethod1;
    this.parserFeatures = TypeUtils.getParserFeatures(paramClass1);
    this.buildMethod = paramMethod2;
    this.jsonType = paramJSONType;
    if (paramJSONType != null)
    {
      paramClass2 = paramJSONType.typeName();
      if (paramClass2.length() != 0)
      {
        this.typeName = paramClass2;
        this.fields = new FieldInfo[paramList.size()];
        paramList.toArray(this.fields);
        paramClass2 = new FieldInfo[this.fields.length];
        System.arraycopy(this.fields, 0, paramClass2, 0, this.fields.length);
        Arrays.sort(paramClass2);
        paramClass1 = paramClass2;
        if (Arrays.equals(this.fields, paramClass2)) {
          paramClass1 = this.fields;
        }
        this.sortedFields = paramClass1;
        if (paramConstructor1 == null) {
          break label193;
        }
      }
    }
    label193:
    for (int i = paramConstructor1.getParameterTypes().length;; i = 0)
    {
      this.defaultConstructorParameterSize = i;
      return;
      this.typeName = paramClass1.getName();
      break;
      this.typeName = paramClass1.getName();
      break;
    }
  }
  
  static boolean add(List<FieldInfo> paramList, FieldInfo paramFieldInfo)
  {
    int i = paramList.size() - 1;
    FieldInfo localFieldInfo;
    while (i >= 0)
    {
      localFieldInfo = (FieldInfo)paramList.get(i);
      if ((!localFieldInfo.name.equals(paramFieldInfo.name)) || ((localFieldInfo.getOnly) && (!paramFieldInfo.getOnly)))
      {
        i -= 1;
      }
      else
      {
        if (!localFieldInfo.fieldClass.isAssignableFrom(paramFieldInfo.fieldClass)) {
          break label91;
        }
        paramList.remove(i);
      }
    }
    for (;;)
    {
      paramList.add(paramFieldInfo);
      return true;
      label91:
      if (localFieldInfo.compareTo(paramFieldInfo) >= 0) {
        break;
      }
      paramList.remove(i);
    }
    return false;
  }
  
  /* Error */
  public static JavaBeanInfo build(Class<?> paramClass, java.lang.reflect.Type paramType, com.alibaba.fastjson.l paraml)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 54
    //   3: invokevirtual 155	java/lang/Class:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   6: checkcast 54	com/alibaba/fastjson/annotation/JSONType
    //   9: astore 19
    //   11: aload 19
    //   13: invokestatic 159	com/alibaba/fastjson/util/JavaBeanInfo:getBuilderClass	(Lcom/alibaba/fastjson/annotation/JSONType;)Ljava/lang/Class;
    //   16: astore 17
    //   18: aload_0
    //   19: invokevirtual 163	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   22: astore 21
    //   24: aload_0
    //   25: invokevirtual 167	java/lang/Class:getMethods	()[Ljava/lang/reflect/Method;
    //   28: astore 23
    //   30: aload 17
    //   32: ifnonnull +149 -> 181
    //   35: aload_0
    //   36: astore 12
    //   38: aload 12
    //   40: invokestatic 171	com/alibaba/fastjson/util/JavaBeanInfo:getDefaultConstructor	(Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   43: astore 22
    //   45: new 173	java/util/ArrayList
    //   48: dup
    //   49: invokespecial 174	java/util/ArrayList:<init>	()V
    //   52: astore 20
    //   54: aload 22
    //   56: ifnonnull +525 -> 581
    //   59: aload_0
    //   60: invokevirtual 178	java/lang/Class:isInterface	()Z
    //   63: ifne +518 -> 581
    //   66: aload_0
    //   67: invokevirtual 181	java/lang/Class:getModifiers	()I
    //   70: invokestatic 187	java/lang/reflect/Modifier:isAbstract	(I)Z
    //   73: ifne +508 -> 581
    //   76: aload_0
    //   77: invokestatic 190	com/alibaba/fastjson/util/JavaBeanInfo:getCreatorConstructor	(Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   80: astore 12
    //   82: aload 12
    //   84: ifnull +233 -> 317
    //   87: aload 12
    //   89: invokestatic 194	com/alibaba/fastjson/util/TypeUtils:setAccessible	(Ljava/lang/reflect/AccessibleObject;)V
    //   92: aload 12
    //   94: invokevirtual 102	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   97: astore 13
    //   99: aload 13
    //   101: arraylength
    //   102: ifle +195 -> 297
    //   105: aload 12
    //   107: invokevirtual 198	java/lang/reflect/Constructor:getParameterAnnotations	()[[Ljava/lang/annotation/Annotation;
    //   110: astore 14
    //   112: iconst_0
    //   113: istore 4
    //   115: iload 4
    //   117: aload 13
    //   119: arraylength
    //   120: if_icmpge +177 -> 297
    //   123: aload 14
    //   125: iload 4
    //   127: aaload
    //   128: astore 15
    //   130: aconst_null
    //   131: astore_2
    //   132: aload 15
    //   134: arraylength
    //   135: istore 6
    //   137: iconst_0
    //   138: istore 5
    //   140: aload_2
    //   141: astore_1
    //   142: iload 5
    //   144: iload 6
    //   146: if_icmpge +21 -> 167
    //   149: aload 15
    //   151: iload 5
    //   153: aaload
    //   154: astore_1
    //   155: aload_1
    //   156: instanceof 200
    //   159: ifeq +29 -> 188
    //   162: aload_1
    //   163: checkcast 200	com/alibaba/fastjson/annotation/JSONField
    //   166: astore_1
    //   167: aload_1
    //   168: ifnonnull +29 -> 197
    //   171: new 202	com/alibaba/fastjson/d
    //   174: dup
    //   175: ldc -52
    //   177: invokespecial 207	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;)V
    //   180: athrow
    //   181: aload 17
    //   183: astore 12
    //   185: goto -147 -> 38
    //   188: iload 5
    //   190: iconst_1
    //   191: iadd
    //   192: istore 5
    //   194: goto -54 -> 140
    //   197: aload 13
    //   199: iload 4
    //   201: aaload
    //   202: astore_2
    //   203: aload 12
    //   205: invokevirtual 211	java/lang/reflect/Constructor:getGenericParameterTypes	()[Ljava/lang/reflect/Type;
    //   208: iload 4
    //   210: aaload
    //   211: astore 15
    //   213: aload_0
    //   214: aload_1
    //   215: invokeinterface 213 1 0
    //   220: aload 21
    //   222: invokestatic 217	com/alibaba/fastjson/util/TypeUtils:getField	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   225: astore 16
    //   227: aload_1
    //   228: invokeinterface 220 1 0
    //   233: istore 5
    //   235: aload_1
    //   236: invokeinterface 224 1 0
    //   241: invokestatic 230	com/alibaba/fastjson/serializer/SerializerFeature:of	([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   244: istore 6
    //   246: aload_1
    //   247: invokeinterface 234 1 0
    //   252: invokestatic 239	com/alibaba/fastjson/parser/Feature:of	([Lcom/alibaba/fastjson/parser/Feature;)I
    //   255: istore 7
    //   257: aload 20
    //   259: new 72	com/alibaba/fastjson/util/FieldInfo
    //   262: dup
    //   263: aload_1
    //   264: invokeinterface 213 1 0
    //   269: aload_0
    //   270: aload_2
    //   271: aload 15
    //   273: aload 16
    //   275: iload 5
    //   277: iload 6
    //   279: iload 7
    //   281: invokespecial 242	com/alibaba/fastjson/util/FieldInfo:<init>	(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/lang/reflect/Field;III)V
    //   284: invokestatic 244	com/alibaba/fastjson/util/JavaBeanInfo:add	(Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   287: pop
    //   288: iload 4
    //   290: iconst_1
    //   291: iadd
    //   292: istore 4
    //   294: goto -179 -> 115
    //   297: new 2	com/alibaba/fastjson/util/JavaBeanInfo
    //   300: dup
    //   301: aload_0
    //   302: aload 17
    //   304: aconst_null
    //   305: aload 12
    //   307: aconst_null
    //   308: aconst_null
    //   309: aload 19
    //   311: aload 20
    //   313: invokespecial 246	com/alibaba/fastjson/util/JavaBeanInfo:<init>	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/alibaba/fastjson/annotation/JSONType;Ljava/util/List;)V
    //   316: areturn
    //   317: aload_0
    //   318: aload 23
    //   320: invokestatic 250	com/alibaba/fastjson/util/JavaBeanInfo:getFactoryMethod	(Ljava/lang/Class;[Ljava/lang/reflect/Method;)Ljava/lang/reflect/Method;
    //   323: astore 12
    //   325: aload 12
    //   327: ifnull +226 -> 553
    //   330: aload 12
    //   332: invokestatic 194	com/alibaba/fastjson/util/TypeUtils:setAccessible	(Ljava/lang/reflect/AccessibleObject;)V
    //   335: aload 12
    //   337: invokevirtual 253	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   340: astore 13
    //   342: aload 13
    //   344: arraylength
    //   345: ifle +188 -> 533
    //   348: aload 12
    //   350: invokevirtual 254	java/lang/reflect/Method:getParameterAnnotations	()[[Ljava/lang/annotation/Annotation;
    //   353: astore 14
    //   355: iconst_0
    //   356: istore 4
    //   358: iload 4
    //   360: aload 13
    //   362: arraylength
    //   363: if_icmpge +170 -> 533
    //   366: aload 14
    //   368: iload 4
    //   370: aaload
    //   371: astore 15
    //   373: aconst_null
    //   374: astore_2
    //   375: aload 15
    //   377: arraylength
    //   378: istore 6
    //   380: iconst_0
    //   381: istore 5
    //   383: aload_2
    //   384: astore_1
    //   385: iload 5
    //   387: iload 6
    //   389: if_icmpge +21 -> 410
    //   392: aload 15
    //   394: iload 5
    //   396: aaload
    //   397: astore_1
    //   398: aload_1
    //   399: instanceof 200
    //   402: ifeq +22 -> 424
    //   405: aload_1
    //   406: checkcast 200	com/alibaba/fastjson/annotation/JSONField
    //   409: astore_1
    //   410: aload_1
    //   411: ifnonnull +22 -> 433
    //   414: new 202	com/alibaba/fastjson/d
    //   417: dup
    //   418: ldc -52
    //   420: invokespecial 207	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;)V
    //   423: athrow
    //   424: iload 5
    //   426: iconst_1
    //   427: iadd
    //   428: istore 5
    //   430: goto -47 -> 383
    //   433: aload 13
    //   435: iload 4
    //   437: aaload
    //   438: astore_2
    //   439: aload 12
    //   441: invokevirtual 255	java/lang/reflect/Method:getGenericParameterTypes	()[Ljava/lang/reflect/Type;
    //   444: iload 4
    //   446: aaload
    //   447: astore 15
    //   449: aload_0
    //   450: aload_1
    //   451: invokeinterface 213 1 0
    //   456: aload 21
    //   458: invokestatic 217	com/alibaba/fastjson/util/TypeUtils:getField	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   461: astore 16
    //   463: aload_1
    //   464: invokeinterface 220 1 0
    //   469: istore 5
    //   471: aload_1
    //   472: invokeinterface 224 1 0
    //   477: invokestatic 230	com/alibaba/fastjson/serializer/SerializerFeature:of	([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   480: istore 6
    //   482: aload_1
    //   483: invokeinterface 234 1 0
    //   488: invokestatic 239	com/alibaba/fastjson/parser/Feature:of	([Lcom/alibaba/fastjson/parser/Feature;)I
    //   491: istore 7
    //   493: aload 20
    //   495: new 72	com/alibaba/fastjson/util/FieldInfo
    //   498: dup
    //   499: aload_1
    //   500: invokeinterface 213 1 0
    //   505: aload_0
    //   506: aload_2
    //   507: aload 15
    //   509: aload 16
    //   511: iload 5
    //   513: iload 6
    //   515: iload 7
    //   517: invokespecial 242	com/alibaba/fastjson/util/FieldInfo:<init>	(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/lang/reflect/Field;III)V
    //   520: invokestatic 244	com/alibaba/fastjson/util/JavaBeanInfo:add	(Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   523: pop
    //   524: iload 4
    //   526: iconst_1
    //   527: iadd
    //   528: istore 4
    //   530: goto -172 -> 358
    //   533: new 2	com/alibaba/fastjson/util/JavaBeanInfo
    //   536: dup
    //   537: aload_0
    //   538: aload 17
    //   540: aconst_null
    //   541: aconst_null
    //   542: aload 12
    //   544: aconst_null
    //   545: aload 19
    //   547: aload 20
    //   549: invokespecial 246	com/alibaba/fastjson/util/JavaBeanInfo:<init>	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/alibaba/fastjson/annotation/JSONType;Ljava/util/List;)V
    //   552: areturn
    //   553: new 202	com/alibaba/fastjson/d
    //   556: dup
    //   557: new 257	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   564: ldc_w 260
    //   567: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload_0
    //   571: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokespecial 207	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;)V
    //   580: athrow
    //   581: aload 22
    //   583: ifnull +8 -> 591
    //   586: aload 22
    //   588: invokestatic 194	com/alibaba/fastjson/util/TypeUtils:setAccessible	(Ljava/lang/reflect/AccessibleObject;)V
    //   591: aload 17
    //   593: ifnull +1911 -> 2504
    //   596: aload 17
    //   598: ldc_w 272
    //   601: invokevirtual 155	java/lang/Class:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   604: checkcast 272	com/alibaba/fastjson/annotation/JSONPOJOBuilder
    //   607: astore 12
    //   609: aload 12
    //   611: ifnull +1905 -> 2516
    //   614: aload 12
    //   616: invokeinterface 275 1 0
    //   621: astore 12
    //   623: aload 12
    //   625: ifnull +11 -> 636
    //   628: aload 12
    //   630: invokevirtual 63	java/lang/String:length	()I
    //   633: ifne +1880 -> 2513
    //   636: ldc_w 277
    //   639: astore 12
    //   641: aload 17
    //   643: invokevirtual 167	java/lang/Class:getMethods	()[Ljava/lang/reflect/Method;
    //   646: astore 14
    //   648: aload 14
    //   650: arraylength
    //   651: istore 11
    //   653: iconst_0
    //   654: istore 4
    //   656: iload 4
    //   658: iload 11
    //   660: if_icmpge +301 -> 961
    //   663: aload 14
    //   665: iload 4
    //   667: aaload
    //   668: astore 15
    //   670: aload 15
    //   672: invokevirtual 278	java/lang/reflect/Method:getModifiers	()I
    //   675: invokestatic 281	java/lang/reflect/Modifier:isStatic	(I)Z
    //   678: ifeq +12 -> 690
    //   681: iload 4
    //   683: iconst_1
    //   684: iadd
    //   685: istore 4
    //   687: goto -31 -> 656
    //   690: aload 15
    //   692: invokevirtual 285	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   695: aload 17
    //   697: invokevirtual 286	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   700: ifeq -19 -> 681
    //   703: iconst_0
    //   704: istore 5
    //   706: iconst_0
    //   707: istore 6
    //   709: iconst_0
    //   710: istore 7
    //   712: aload 15
    //   714: ldc -56
    //   716: invokevirtual 287	java/lang/reflect/Method:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   719: checkcast 200	com/alibaba/fastjson/annotation/JSONField
    //   722: astore 13
    //   724: aload 13
    //   726: ifnonnull +1784 -> 2510
    //   729: aload_0
    //   730: aload 15
    //   732: invokestatic 291	com/alibaba/fastjson/util/TypeUtils:getSuperMethodAnnotation	(Ljava/lang/Class;Ljava/lang/reflect/Method;)Lcom/alibaba/fastjson/annotation/JSONField;
    //   735: astore 13
    //   737: aload 13
    //   739: ifnull +109 -> 848
    //   742: aload 13
    //   744: invokeinterface 294 1 0
    //   749: ifeq -68 -> 681
    //   752: aload 13
    //   754: invokeinterface 220 1 0
    //   759: istore 8
    //   761: aload 13
    //   763: invokeinterface 224 1 0
    //   768: invokestatic 230	com/alibaba/fastjson/serializer/SerializerFeature:of	([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   771: istore 9
    //   773: aload 13
    //   775: invokeinterface 234 1 0
    //   780: invokestatic 239	com/alibaba/fastjson/parser/Feature:of	([Lcom/alibaba/fastjson/parser/Feature;)I
    //   783: istore 10
    //   785: iload 8
    //   787: istore 5
    //   789: iload 9
    //   791: istore 6
    //   793: iload 10
    //   795: istore 7
    //   797: aload 13
    //   799: invokeinterface 213 1 0
    //   804: invokevirtual 63	java/lang/String:length	()I
    //   807: ifeq +41 -> 848
    //   810: aload 20
    //   812: new 72	com/alibaba/fastjson/util/FieldInfo
    //   815: dup
    //   816: aload 13
    //   818: invokeinterface 213 1 0
    //   823: aload 15
    //   825: aconst_null
    //   826: aload_0
    //   827: aload_1
    //   828: iload 8
    //   830: iload 9
    //   832: iload 10
    //   834: aload 13
    //   836: aconst_null
    //   837: aconst_null
    //   838: invokespecial 297	com/alibaba/fastjson/util/FieldInfo:<init>	(Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   841: invokestatic 244	com/alibaba/fastjson/util/JavaBeanInfo:add	(Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   844: pop
    //   845: goto -164 -> 681
    //   848: aload 15
    //   850: invokevirtual 298	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   853: astore 16
    //   855: aload 16
    //   857: aload 12
    //   859: invokevirtual 302	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   862: ifeq -181 -> 681
    //   865: aload 16
    //   867: invokevirtual 63	java/lang/String:length	()I
    //   870: aload 12
    //   872: invokevirtual 63	java/lang/String:length	()I
    //   875: if_icmple -194 -> 681
    //   878: aload 16
    //   880: aload 12
    //   882: invokevirtual 63	java/lang/String:length	()I
    //   885: invokevirtual 306	java/lang/String:charAt	(I)C
    //   888: istore_3
    //   889: iload_3
    //   890: invokestatic 312	java/lang/Character:isUpperCase	(C)Z
    //   893: ifeq -212 -> 681
    //   896: new 257	java/lang/StringBuilder
    //   899: dup
    //   900: aload 16
    //   902: aload 12
    //   904: invokevirtual 63	java/lang/String:length	()I
    //   907: invokevirtual 316	java/lang/String:substring	(I)Ljava/lang/String;
    //   910: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   913: astore 16
    //   915: aload 16
    //   917: iconst_0
    //   918: iload_3
    //   919: invokestatic 321	java/lang/Character:toLowerCase	(C)C
    //   922: invokevirtual 325	java/lang/StringBuilder:setCharAt	(IC)V
    //   925: aload 20
    //   927: new 72	com/alibaba/fastjson/util/FieldInfo
    //   930: dup
    //   931: aload 16
    //   933: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   936: aload 15
    //   938: aconst_null
    //   939: aload_0
    //   940: aload_1
    //   941: iload 5
    //   943: iload 6
    //   945: iload 7
    //   947: aload 13
    //   949: aconst_null
    //   950: aconst_null
    //   951: invokespecial 297	com/alibaba/fastjson/util/FieldInfo:<init>	(Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   954: invokestatic 244	com/alibaba/fastjson/util/JavaBeanInfo:add	(Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   957: pop
    //   958: goto -277 -> 681
    //   961: aload 17
    //   963: ifnull +1541 -> 2504
    //   966: aload 17
    //   968: ldc_w 272
    //   971: invokevirtual 155	java/lang/Class:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   974: checkcast 272	com/alibaba/fastjson/annotation/JSONPOJOBuilder
    //   977: astore 12
    //   979: aload 12
    //   981: ifnull +1517 -> 2498
    //   984: aload 12
    //   986: invokeinterface 327 1 0
    //   991: astore 12
    //   993: aload 12
    //   995: ifnull +15 -> 1010
    //   998: aload 12
    //   1000: astore 13
    //   1002: aload 12
    //   1004: invokevirtual 63	java/lang/String:length	()I
    //   1007: ifne +8 -> 1015
    //   1010: ldc_w 328
    //   1013: astore 13
    //   1015: aload 17
    //   1017: aload 13
    //   1019: iconst_0
    //   1020: anewarray 106	java/lang/Class
    //   1023: invokevirtual 332	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1026: astore 12
    //   1028: aload 12
    //   1030: astore 13
    //   1032: aload 12
    //   1034: ifnonnull +17 -> 1051
    //   1037: aload 17
    //   1039: ldc_w 334
    //   1042: iconst_0
    //   1043: anewarray 106	java/lang/Class
    //   1046: invokevirtual 332	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1049: astore 13
    //   1051: aload 13
    //   1053: ifnonnull +30 -> 1083
    //   1056: new 202	com/alibaba/fastjson/d
    //   1059: dup
    //   1060: ldc_w 336
    //   1063: invokespecial 207	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;)V
    //   1066: athrow
    //   1067: astore 12
    //   1069: aconst_null
    //   1070: astore 12
    //   1072: goto -44 -> 1028
    //   1075: astore 12
    //   1077: aconst_null
    //   1078: astore 12
    //   1080: goto -52 -> 1028
    //   1083: aload 13
    //   1085: invokestatic 194	com/alibaba/fastjson/util/TypeUtils:setAccessible	(Ljava/lang/reflect/AccessibleObject;)V
    //   1088: aload 23
    //   1090: arraylength
    //   1091: istore 11
    //   1093: iconst_0
    //   1094: istore 7
    //   1096: iload 7
    //   1098: iload 11
    //   1100: if_icmpge +679 -> 1779
    //   1103: aload 23
    //   1105: iload 7
    //   1107: aaload
    //   1108: astore 24
    //   1110: iconst_0
    //   1111: istore 4
    //   1113: iconst_0
    //   1114: istore 5
    //   1116: iconst_0
    //   1117: istore 6
    //   1119: aload 24
    //   1121: invokevirtual 298	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   1124: astore 12
    //   1126: aload 12
    //   1128: invokevirtual 63	java/lang/String:length	()I
    //   1131: iconst_4
    //   1132: if_icmpge +12 -> 1144
    //   1135: iload 7
    //   1137: iconst_1
    //   1138: iadd
    //   1139: istore 7
    //   1141: goto -45 -> 1096
    //   1144: aload 24
    //   1146: invokevirtual 278	java/lang/reflect/Method:getModifiers	()I
    //   1149: invokestatic 281	java/lang/reflect/Modifier:isStatic	(I)Z
    //   1152: ifne -17 -> 1135
    //   1155: aload 24
    //   1157: invokevirtual 285	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   1160: getstatic 341	java/lang/Void:TYPE	Ljava/lang/Class;
    //   1163: invokevirtual 286	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1166: ifne +19 -> 1185
    //   1169: aload 24
    //   1171: invokevirtual 285	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   1174: aload 24
    //   1176: invokevirtual 344	java/lang/reflect/Method:getDeclaringClass	()Ljava/lang/Class;
    //   1179: invokevirtual 286	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1182: ifeq -47 -> 1135
    //   1185: aload 24
    //   1187: invokevirtual 253	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   1190: astore 18
    //   1192: aload 18
    //   1194: arraylength
    //   1195: iconst_1
    //   1196: if_icmpne -61 -> 1135
    //   1199: aload 24
    //   1201: ldc -56
    //   1203: invokevirtual 287	java/lang/reflect/Method:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1206: checkcast 200	com/alibaba/fastjson/annotation/JSONField
    //   1209: astore 14
    //   1211: aload 14
    //   1213: ifnonnull +1282 -> 2495
    //   1216: aload_0
    //   1217: aload 24
    //   1219: invokestatic 291	com/alibaba/fastjson/util/TypeUtils:getSuperMethodAnnotation	(Ljava/lang/Class;Ljava/lang/reflect/Method;)Lcom/alibaba/fastjson/annotation/JSONField;
    //   1222: astore 14
    //   1224: aload 14
    //   1226: ifnull +109 -> 1335
    //   1229: aload 14
    //   1231: invokeinterface 294 1 0
    //   1236: ifeq -101 -> 1135
    //   1239: aload 14
    //   1241: invokeinterface 220 1 0
    //   1246: istore 8
    //   1248: aload 14
    //   1250: invokeinterface 224 1 0
    //   1255: invokestatic 230	com/alibaba/fastjson/serializer/SerializerFeature:of	([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   1258: istore 9
    //   1260: aload 14
    //   1262: invokeinterface 234 1 0
    //   1267: invokestatic 239	com/alibaba/fastjson/parser/Feature:of	([Lcom/alibaba/fastjson/parser/Feature;)I
    //   1270: istore 10
    //   1272: iload 8
    //   1274: istore 4
    //   1276: iload 9
    //   1278: istore 5
    //   1280: iload 10
    //   1282: istore 6
    //   1284: aload 14
    //   1286: invokeinterface 213 1 0
    //   1291: invokevirtual 63	java/lang/String:length	()I
    //   1294: ifeq +41 -> 1335
    //   1297: aload 20
    //   1299: new 72	com/alibaba/fastjson/util/FieldInfo
    //   1302: dup
    //   1303: aload 14
    //   1305: invokeinterface 213 1 0
    //   1310: aload 24
    //   1312: aconst_null
    //   1313: aload_0
    //   1314: aload_1
    //   1315: iload 8
    //   1317: iload 9
    //   1319: iload 10
    //   1321: aload 14
    //   1323: aconst_null
    //   1324: aconst_null
    //   1325: invokespecial 297	com/alibaba/fastjson/util/FieldInfo:<init>	(Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1328: invokestatic 244	com/alibaba/fastjson/util/JavaBeanInfo:add	(Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   1331: pop
    //   1332: goto -197 -> 1135
    //   1335: aload 12
    //   1337: ldc_w 346
    //   1340: invokevirtual 302	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1343: ifeq -208 -> 1135
    //   1346: aload 12
    //   1348: iconst_3
    //   1349: invokevirtual 306	java/lang/String:charAt	(I)C
    //   1352: istore_3
    //   1353: iload_3
    //   1354: invokestatic 312	java/lang/Character:isUpperCase	(C)Z
    //   1357: ifne +10 -> 1367
    //   1360: iload_3
    //   1361: sipush 512
    //   1364: if_icmple +299 -> 1663
    //   1367: getstatic 349	com/alibaba/fastjson/util/TypeUtils:compatibleWithJavaBean	Z
    //   1370: ifeq +257 -> 1627
    //   1373: aload 12
    //   1375: iconst_3
    //   1376: invokevirtual 316	java/lang/String:substring	(I)Ljava/lang/String;
    //   1379: invokestatic 353	com/alibaba/fastjson/util/TypeUtils:decapitalize	(Ljava/lang/String;)Ljava/lang/String;
    //   1382: astore 12
    //   1384: aload_0
    //   1385: aload 12
    //   1387: aload 21
    //   1389: invokestatic 217	com/alibaba/fastjson/util/TypeUtils:getField	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   1392: astore 16
    //   1394: aload 16
    //   1396: astore 15
    //   1398: aload 16
    //   1400: ifnonnull +62 -> 1462
    //   1403: aload 16
    //   1405: astore 15
    //   1407: aload 18
    //   1409: iconst_0
    //   1410: aaload
    //   1411: getstatic 356	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   1414: if_acmpne +48 -> 1462
    //   1417: aload_0
    //   1418: new 257	java/lang/StringBuilder
    //   1421: dup
    //   1422: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1425: ldc_w 358
    //   1428: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: aload 12
    //   1433: iconst_0
    //   1434: invokevirtual 306	java/lang/String:charAt	(I)C
    //   1437: invokestatic 361	java/lang/Character:toUpperCase	(C)C
    //   1440: invokevirtual 364	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1443: aload 12
    //   1445: iconst_1
    //   1446: invokevirtual 316	java/lang/String:substring	(I)Ljava/lang/String;
    //   1449: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1455: aload 21
    //   1457: invokestatic 217	com/alibaba/fastjson/util/TypeUtils:getField	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   1460: astore 15
    //   1462: aconst_null
    //   1463: astore 16
    //   1465: iload 4
    //   1467: istore 8
    //   1469: iload 5
    //   1471: istore 9
    //   1473: iload 6
    //   1475: istore 10
    //   1477: aload 15
    //   1479: ifnull +253 -> 1732
    //   1482: aload 15
    //   1484: ldc -56
    //   1486: invokevirtual 367	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1489: checkcast 200	com/alibaba/fastjson/annotation/JSONField
    //   1492: astore 18
    //   1494: iload 4
    //   1496: istore 8
    //   1498: iload 5
    //   1500: istore 9
    //   1502: iload 6
    //   1504: istore 10
    //   1506: aload 18
    //   1508: astore 16
    //   1510: aload 18
    //   1512: ifnull +220 -> 1732
    //   1515: aload 18
    //   1517: invokeinterface 294 1 0
    //   1522: ifeq -387 -> 1135
    //   1525: aload 18
    //   1527: invokeinterface 220 1 0
    //   1532: istore 4
    //   1534: aload 18
    //   1536: invokeinterface 224 1 0
    //   1541: invokestatic 230	com/alibaba/fastjson/serializer/SerializerFeature:of	([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   1544: istore 5
    //   1546: aload 18
    //   1548: invokeinterface 234 1 0
    //   1553: invokestatic 239	com/alibaba/fastjson/parser/Feature:of	([Lcom/alibaba/fastjson/parser/Feature;)I
    //   1556: istore 6
    //   1558: iload 4
    //   1560: istore 8
    //   1562: iload 5
    //   1564: istore 9
    //   1566: iload 6
    //   1568: istore 10
    //   1570: aload 18
    //   1572: astore 16
    //   1574: aload 18
    //   1576: invokeinterface 213 1 0
    //   1581: invokevirtual 63	java/lang/String:length	()I
    //   1584: ifeq +148 -> 1732
    //   1587: aload 20
    //   1589: new 72	com/alibaba/fastjson/util/FieldInfo
    //   1592: dup
    //   1593: aload 18
    //   1595: invokeinterface 213 1 0
    //   1600: aload 24
    //   1602: aload 15
    //   1604: aload_0
    //   1605: aload_1
    //   1606: iload 4
    //   1608: iload 5
    //   1610: iload 6
    //   1612: aload 14
    //   1614: aload 18
    //   1616: aconst_null
    //   1617: invokespecial 297	com/alibaba/fastjson/util/FieldInfo:<init>	(Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1620: invokestatic 244	com/alibaba/fastjson/util/JavaBeanInfo:add	(Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   1623: pop
    //   1624: goto -489 -> 1135
    //   1627: new 257	java/lang/StringBuilder
    //   1630: dup
    //   1631: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1634: aload 12
    //   1636: iconst_3
    //   1637: invokevirtual 306	java/lang/String:charAt	(I)C
    //   1640: invokestatic 321	java/lang/Character:toLowerCase	(C)C
    //   1643: invokevirtual 364	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1646: aload 12
    //   1648: iconst_4
    //   1649: invokevirtual 316	java/lang/String:substring	(I)Ljava/lang/String;
    //   1652: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1655: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1658: astore 12
    //   1660: goto -276 -> 1384
    //   1663: iload_3
    //   1664: bipush 95
    //   1666: if_icmpne +14 -> 1680
    //   1669: aload 12
    //   1671: iconst_4
    //   1672: invokevirtual 316	java/lang/String:substring	(I)Ljava/lang/String;
    //   1675: astore 12
    //   1677: goto -293 -> 1384
    //   1680: iload_3
    //   1681: bipush 102
    //   1683: if_icmpne +14 -> 1697
    //   1686: aload 12
    //   1688: iconst_3
    //   1689: invokevirtual 316	java/lang/String:substring	(I)Ljava/lang/String;
    //   1692: astore 12
    //   1694: goto -310 -> 1384
    //   1697: aload 12
    //   1699: invokevirtual 63	java/lang/String:length	()I
    //   1702: iconst_5
    //   1703: if_icmplt -568 -> 1135
    //   1706: aload 12
    //   1708: iconst_4
    //   1709: invokevirtual 306	java/lang/String:charAt	(I)C
    //   1712: invokestatic 312	java/lang/Character:isUpperCase	(C)Z
    //   1715: ifeq -580 -> 1135
    //   1718: aload 12
    //   1720: iconst_3
    //   1721: invokevirtual 316	java/lang/String:substring	(I)Ljava/lang/String;
    //   1724: invokestatic 353	com/alibaba/fastjson/util/TypeUtils:decapitalize	(Ljava/lang/String;)Ljava/lang/String;
    //   1727: astore 12
    //   1729: goto -345 -> 1384
    //   1732: aload_2
    //   1733: ifnull +759 -> 2492
    //   1736: aload_2
    //   1737: aload 12
    //   1739: invokevirtual 372	com/alibaba/fastjson/l:translate	(Ljava/lang/String;)Ljava/lang/String;
    //   1742: astore 12
    //   1744: aload 20
    //   1746: new 72	com/alibaba/fastjson/util/FieldInfo
    //   1749: dup
    //   1750: aload 12
    //   1752: aload 24
    //   1754: aload 15
    //   1756: aload_0
    //   1757: aload_1
    //   1758: iload 8
    //   1760: iload 9
    //   1762: iload 10
    //   1764: aload 14
    //   1766: aload 16
    //   1768: aconst_null
    //   1769: invokespecial 297	com/alibaba/fastjson/util/FieldInfo:<init>	(Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1772: invokestatic 244	com/alibaba/fastjson/util/JavaBeanInfo:add	(Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   1775: pop
    //   1776: goto -641 -> 1135
    //   1779: aload_0
    //   1780: invokevirtual 375	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   1783: astore 15
    //   1785: aload 15
    //   1787: arraylength
    //   1788: istore 11
    //   1790: iconst_0
    //   1791: istore 4
    //   1793: iload 4
    //   1795: iload 11
    //   1797: if_icmpge +348 -> 2145
    //   1800: aload 15
    //   1802: iload 4
    //   1804: aaload
    //   1805: astore 16
    //   1807: aload 16
    //   1809: invokevirtual 376	java/lang/reflect/Field:getModifiers	()I
    //   1812: istore 5
    //   1814: iload 5
    //   1816: bipush 8
    //   1818: iand
    //   1819: ifeq +12 -> 1831
    //   1822: iload 4
    //   1824: iconst_1
    //   1825: iadd
    //   1826: istore 4
    //   1828: goto -35 -> 1793
    //   1831: iload 5
    //   1833: bipush 16
    //   1835: iand
    //   1836: ifeq +73 -> 1909
    //   1839: aload 16
    //   1841: invokevirtual 379	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   1844: astore 12
    //   1846: ldc_w 381
    //   1849: aload 12
    //   1851: invokevirtual 135	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   1854: ifne +47 -> 1901
    //   1857: ldc_w 383
    //   1860: aload 12
    //   1862: invokevirtual 135	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   1865: ifne +36 -> 1901
    //   1868: ldc_w 385
    //   1871: aload 12
    //   1873: invokevirtual 286	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1876: ifne +25 -> 1901
    //   1879: ldc_w 387
    //   1882: aload 12
    //   1884: invokevirtual 286	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1887: ifne +14 -> 1901
    //   1890: ldc_w 389
    //   1893: aload 12
    //   1895: invokevirtual 286	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1898: ifeq +241 -> 2139
    //   1901: iconst_1
    //   1902: istore 5
    //   1904: iload 5
    //   1906: ifeq -84 -> 1822
    //   1909: aload 20
    //   1911: invokeinterface 393 1 0
    //   1916: astore 12
    //   1918: aload 12
    //   1920: invokeinterface 398 1 0
    //   1925: ifeq +561 -> 2486
    //   1928: aload 12
    //   1930: invokeinterface 402 1 0
    //   1935: checkcast 72	com/alibaba/fastjson/util/FieldInfo
    //   1938: getfield 121	com/alibaba/fastjson/util/FieldInfo:name	Ljava/lang/String;
    //   1941: aload 16
    //   1943: invokevirtual 403	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   1946: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1949: ifeq -31 -> 1918
    //   1952: iconst_1
    //   1953: istore 5
    //   1955: iload 5
    //   1957: ifne -135 -> 1822
    //   1960: iconst_0
    //   1961: istore 5
    //   1963: iconst_0
    //   1964: istore 6
    //   1966: iconst_0
    //   1967: istore 7
    //   1969: aload 16
    //   1971: invokevirtual 403	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   1974: astore 14
    //   1976: aload 16
    //   1978: ldc -56
    //   1980: invokevirtual 367	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1983: checkcast 200	com/alibaba/fastjson/annotation/JSONField
    //   1986: astore 18
    //   1988: aload 14
    //   1990: astore 12
    //   1992: aload 18
    //   1994: ifnull +96 -> 2090
    //   1997: aload 18
    //   1999: invokeinterface 294 1 0
    //   2004: ifeq -182 -> 1822
    //   2007: aload 18
    //   2009: invokeinterface 220 1 0
    //   2014: istore 8
    //   2016: aload 18
    //   2018: invokeinterface 224 1 0
    //   2023: invokestatic 230	com/alibaba/fastjson/serializer/SerializerFeature:of	([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   2026: istore 9
    //   2028: aload 18
    //   2030: invokeinterface 234 1 0
    //   2035: invokestatic 239	com/alibaba/fastjson/parser/Feature:of	([Lcom/alibaba/fastjson/parser/Feature;)I
    //   2038: istore 10
    //   2040: aload 14
    //   2042: astore 12
    //   2044: iload 8
    //   2046: istore 5
    //   2048: iload 9
    //   2050: istore 6
    //   2052: iload 10
    //   2054: istore 7
    //   2056: aload 18
    //   2058: invokeinterface 213 1 0
    //   2063: invokevirtual 63	java/lang/String:length	()I
    //   2066: ifeq +24 -> 2090
    //   2069: aload 18
    //   2071: invokeinterface 213 1 0
    //   2076: astore 12
    //   2078: iload 10
    //   2080: istore 7
    //   2082: iload 9
    //   2084: istore 6
    //   2086: iload 8
    //   2088: istore 5
    //   2090: aload 12
    //   2092: astore 14
    //   2094: aload_2
    //   2095: ifnull +11 -> 2106
    //   2098: aload_2
    //   2099: aload 12
    //   2101: invokevirtual 372	com/alibaba/fastjson/l:translate	(Ljava/lang/String;)Ljava/lang/String;
    //   2104: astore 14
    //   2106: aload 20
    //   2108: new 72	com/alibaba/fastjson/util/FieldInfo
    //   2111: dup
    //   2112: aload 14
    //   2114: aconst_null
    //   2115: aload 16
    //   2117: aload_0
    //   2118: aload_1
    //   2119: iload 5
    //   2121: iload 6
    //   2123: iload 7
    //   2125: aconst_null
    //   2126: aload 18
    //   2128: aconst_null
    //   2129: invokespecial 297	com/alibaba/fastjson/util/FieldInfo:<init>	(Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   2132: invokestatic 244	com/alibaba/fastjson/util/JavaBeanInfo:add	(Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   2135: pop
    //   2136: goto -314 -> 1822
    //   2139: iconst_0
    //   2140: istore 5
    //   2142: goto -238 -> 1904
    //   2145: aload_0
    //   2146: invokevirtual 167	java/lang/Class:getMethods	()[Ljava/lang/reflect/Method;
    //   2149: astore 14
    //   2151: aload 14
    //   2153: arraylength
    //   2154: istore 5
    //   2156: iconst_0
    //   2157: istore 4
    //   2159: iload 4
    //   2161: iload 5
    //   2163: if_icmpge +281 -> 2444
    //   2166: aload 14
    //   2168: iload 4
    //   2170: aaload
    //   2171: astore 15
    //   2173: aload 15
    //   2175: invokevirtual 298	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   2178: astore 12
    //   2180: aload 12
    //   2182: invokevirtual 63	java/lang/String:length	()I
    //   2185: iconst_4
    //   2186: if_icmpge +12 -> 2198
    //   2189: iload 4
    //   2191: iconst_1
    //   2192: iadd
    //   2193: istore 4
    //   2195: goto -36 -> 2159
    //   2198: aload 15
    //   2200: invokevirtual 278	java/lang/reflect/Method:getModifiers	()I
    //   2203: invokestatic 281	java/lang/reflect/Modifier:isStatic	(I)Z
    //   2206: ifne -17 -> 2189
    //   2209: aload 12
    //   2211: ldc_w 404
    //   2214: invokevirtual 302	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2217: ifeq -28 -> 2189
    //   2220: aload 12
    //   2222: iconst_3
    //   2223: invokevirtual 306	java/lang/String:charAt	(I)C
    //   2226: invokestatic 312	java/lang/Character:isUpperCase	(C)Z
    //   2229: ifeq -40 -> 2189
    //   2232: aload 15
    //   2234: invokevirtual 253	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   2237: arraylength
    //   2238: ifne -49 -> 2189
    //   2241: ldc_w 383
    //   2244: aload 15
    //   2246: invokevirtual 285	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   2249: invokevirtual 135	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   2252: ifne +50 -> 2302
    //   2255: ldc_w 381
    //   2258: aload 15
    //   2260: invokevirtual 285	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   2263: invokevirtual 135	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   2266: ifne +36 -> 2302
    //   2269: ldc_w 389
    //   2272: aload 15
    //   2274: invokevirtual 285	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   2277: if_acmpeq +25 -> 2302
    //   2280: ldc_w 387
    //   2283: aload 15
    //   2285: invokevirtual 285	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   2288: if_acmpeq +14 -> 2302
    //   2291: ldc_w 385
    //   2294: aload 15
    //   2296: invokevirtual 285	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   2299: if_acmpne -110 -> 2189
    //   2302: aload 15
    //   2304: ldc -56
    //   2306: invokevirtual 287	java/lang/reflect/Method:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   2309: checkcast 200	com/alibaba/fastjson/annotation/JSONField
    //   2312: astore 16
    //   2314: aload 16
    //   2316: ifnull +13 -> 2329
    //   2319: aload 16
    //   2321: invokeinterface 294 1 0
    //   2326: ifne -137 -> 2189
    //   2329: aload 16
    //   2331: ifnull +77 -> 2408
    //   2334: aload 16
    //   2336: invokeinterface 213 1 0
    //   2341: invokevirtual 63	java/lang/String:length	()I
    //   2344: ifle +64 -> 2408
    //   2347: aload 16
    //   2349: invokeinterface 213 1 0
    //   2354: astore 12
    //   2356: aload 20
    //   2358: aload 12
    //   2360: invokestatic 407	com/alibaba/fastjson/util/JavaBeanInfo:getField	(Ljava/util/List;Ljava/lang/String;)Lcom/alibaba/fastjson/util/FieldInfo;
    //   2363: ifnonnull -174 -> 2189
    //   2366: aload_2
    //   2367: ifnull +116 -> 2483
    //   2370: aload_2
    //   2371: aload 12
    //   2373: invokevirtual 372	com/alibaba/fastjson/l:translate	(Ljava/lang/String;)Ljava/lang/String;
    //   2376: astore 12
    //   2378: aload 20
    //   2380: new 72	com/alibaba/fastjson/util/FieldInfo
    //   2383: dup
    //   2384: aload 12
    //   2386: aload 15
    //   2388: aconst_null
    //   2389: aload_0
    //   2390: aload_1
    //   2391: iconst_0
    //   2392: iconst_0
    //   2393: iconst_0
    //   2394: aload 16
    //   2396: aconst_null
    //   2397: aconst_null
    //   2398: invokespecial 297	com/alibaba/fastjson/util/FieldInfo:<init>	(Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IIILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   2401: invokestatic 244	com/alibaba/fastjson/util/JavaBeanInfo:add	(Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   2404: pop
    //   2405: goto -216 -> 2189
    //   2408: new 257	java/lang/StringBuilder
    //   2411: dup
    //   2412: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   2415: aload 12
    //   2417: iconst_3
    //   2418: invokevirtual 306	java/lang/String:charAt	(I)C
    //   2421: invokestatic 321	java/lang/Character:toLowerCase	(C)C
    //   2424: invokevirtual 364	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2427: aload 12
    //   2429: iconst_4
    //   2430: invokevirtual 316	java/lang/String:substring	(I)Ljava/lang/String;
    //   2433: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2436: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2439: astore 12
    //   2441: goto -85 -> 2356
    //   2444: new 2	com/alibaba/fastjson/util/JavaBeanInfo
    //   2447: dup
    //   2448: aload_0
    //   2449: aload 17
    //   2451: aload 22
    //   2453: aconst_null
    //   2454: aconst_null
    //   2455: aload 13
    //   2457: aload 19
    //   2459: aload 20
    //   2461: invokespecial 246	com/alibaba/fastjson/util/JavaBeanInfo:<init>	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/alibaba/fastjson/annotation/JSONType;Ljava/util/List;)V
    //   2464: areturn
    //   2465: astore 13
    //   2467: aload 12
    //   2469: astore 13
    //   2471: goto -1420 -> 1051
    //   2474: astore 13
    //   2476: aload 12
    //   2478: astore 13
    //   2480: goto -1429 -> 1051
    //   2483: goto -105 -> 2378
    //   2486: iconst_0
    //   2487: istore 5
    //   2489: goto -534 -> 1955
    //   2492: goto -748 -> 1744
    //   2495: goto -1271 -> 1224
    //   2498: aconst_null
    //   2499: astore 12
    //   2501: goto -1508 -> 993
    //   2504: aconst_null
    //   2505: astore 13
    //   2507: goto -1419 -> 1088
    //   2510: goto -1773 -> 737
    //   2513: goto -1872 -> 641
    //   2516: aconst_null
    //   2517: astore 12
    //   2519: goto -1896 -> 623
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2522	0	paramClass	Class<?>
    //   0	2522	1	paramType	java.lang.reflect.Type
    //   0	2522	2	paraml	com.alibaba.fastjson.l
    //   888	796	3	c	char
    //   113	2081	4	i	int
    //   138	2350	5	j	int
    //   135	1987	6	k	int
    //   255	1869	7	m	int
    //   759	1328	8	n	int
    //   771	1312	9	i1	int
    //   783	1296	10	i2	int
    //   651	1147	11	i3	int
    //   36	997	12	localObject1	Object
    //   1067	1	12	localNoSuchMethodException1	NoSuchMethodException
    //   1070	1	12	localObject2	Object
    //   1075	1	12	localSecurityException1	SecurityException
    //   1078	1440	12	localObject3	Object
    //   97	2359	13	localObject4	Object
    //   2465	1	13	localSecurityException2	SecurityException
    //   2469	1	13	localObject5	Object
    //   2474	1	13	localNoSuchMethodException2	NoSuchMethodException
    //   2478	28	13	localObject6	Object
    //   110	2057	14	localObject7	Object
    //   128	2259	15	localObject8	Object
    //   225	2170	16	localObject9	Object
    //   16	2434	17	localClass	Class
    //   1190	937	18	localObject10	Object
    //   9	2449	19	localJSONType	JSONType
    //   52	2408	20	localArrayList	java.util.ArrayList
    //   22	1434	21	arrayOfField	java.lang.reflect.Field[]
    //   43	2409	22	localConstructor	Constructor
    //   28	1076	23	arrayOfMethod	Method[]
    //   1108	645	24	localMethod	Method
    // Exception table:
    //   from	to	target	type
    //   1015	1028	1067	java/lang/NoSuchMethodException
    //   1015	1028	1075	java/lang/SecurityException
    //   1037	1051	2465	java/lang/SecurityException
    //   1037	1051	2474	java/lang/NoSuchMethodException
  }
  
  public static Class<?> getBuilderClass(JSONType paramJSONType)
  {
    if (paramJSONType == null) {}
    do
    {
      return null;
      paramJSONType = paramJSONType.builder();
    } while (paramJSONType == Void.class);
    return paramJSONType;
  }
  
  public static Constructor<?> getCreatorConstructor(Class<?> paramClass)
  {
    Object localObject = null;
    Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
    int j = arrayOfConstructor.length;
    int i = 0;
    paramClass = (Class<?>)localObject;
    if (i < j)
    {
      localObject = arrayOfConstructor[i];
      if ((JSONCreator)((Constructor)localObject).getAnnotation(JSONCreator.class) == null) {
        break label65;
      }
      if (paramClass != null) {
        throw new d("multi-JSONCreator");
      }
      paramClass = (Class<?>)localObject;
    }
    label65:
    for (;;)
    {
      i += 1;
      break;
      return paramClass;
    }
  }
  
  static Constructor<?> getDefaultConstructor(Class<?> paramClass)
  {
    Constructor<?> localConstructor1 = null;
    if (Modifier.isAbstract(paramClass.getModifiers())) {
      return localConstructor1;
    }
    Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
    int j = arrayOfConstructor.length;
    int i = 0;
    label28:
    Constructor localConstructor;
    if (i < j)
    {
      localConstructor = arrayOfConstructor[i];
      if (localConstructor.getParameterTypes().length != 0) {}
    }
    for (;;)
    {
      if ((localConstructor == null) && (paramClass.isMemberClass()) && (!Modifier.isStatic(paramClass.getModifiers())))
      {
        j = arrayOfConstructor.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localConstructor1 = arrayOfConstructor[i];
            Class[] arrayOfClass = localConstructor1.getParameterTypes();
            if ((arrayOfClass.length == 1) && (arrayOfClass[0].equals(paramClass.getDeclaringClass()))) {
              break;
            }
            i += 1;
            continue;
            i += 1;
            break label28;
          }
        }
      }
      return localConstructor;
      localConstructor = null;
    }
  }
  
  private static Method getFactoryMethod(Class<?> paramClass, Method[] paramArrayOfMethod)
  {
    Object localObject = null;
    int j = paramArrayOfMethod.length;
    int i = 0;
    Method localMethod;
    if (i < j)
    {
      localMethod = paramArrayOfMethod[i];
      if (Modifier.isStatic(localMethod.getModifiers())) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (paramClass.isAssignableFrom(localMethod.getReturnType())) {
        if ((JSONCreator)localMethod.getAnnotation(JSONCreator.class) != null)
        {
          if (localObject != null) {
            throw new d("multi-JSONCreator");
          }
          localObject = localMethod;
          continue;
          return (Method)localObject;
        }
      }
    }
  }
  
  private static FieldInfo getField(List<FieldInfo> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FieldInfo localFieldInfo = (FieldInfo)paramList.next();
      if (localFieldInfo.name.equals(paramString)) {
        return localFieldInfo;
      }
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/util/JavaBeanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */