package cn.jiguang.e;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static Map<String, Method> a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[2];
    Object localObject2 = "NqMMIF7\017HB\005,W\002";
    int k = -1;
    int m = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int j = localObject2.length;
    int i;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (j <= 1)
    {
      i = 0;
      localObject3 = localObject1;
      n = m;
      localObject1 = localObject2;
      i1 = k;
      m = i;
      for (k = i;; k = j)
      {
        localObject2 = localObject1;
        i2 = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 39;
          localObject2[k] = ((char)(i ^ i2));
          m += 1;
          if (j != 0) {
            break label121;
          }
        }
      }
      k = j;
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
      j = k;
      i = m;
      if (k > m) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = "(7MQR\0050MCD\005=\036QN\0044\b\002J\003,\005MC\\x";
        m = 1;
        k = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        a = new HashMap();
        return;
        i = 102;
        break label99;
        i = 88;
        break label99;
        i = 109;
        break label99;
        i = 34;
        break label99;
        i = 0;
        i2 = k;
        i3 = m;
        localObject4 = localObject1;
        k = j;
        m = i;
      }
    }
  }
  
  public static Object a(Class paramClass, String paramString, Object... paramVarArgs)
  {
    Object[] arrayOfObject = d.b(paramVarArgs);
    paramVarArgs = d.a(d.a(arrayOfObject));
    arrayOfObject = d.b(arrayOfObject);
    paramVarArgs = c(paramClass, paramString, paramVarArgs);
    if (paramVarArgs == null) {
      throw new NoSuchMethodException(z[1] + paramString + z[0] + paramClass.getName());
    }
    return paramVarArgs.invoke(null, arrayOfObject);
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    Object localObject2 = null;
    for (paramClass = paramClass.getSuperclass();; paramClass = paramClass.getSuperclass())
    {
      Object localObject1 = localObject2;
      if ((paramClass == null) || (Modifier.isPublic(paramClass.getModifiers()))) {}
      try
      {
        localObject1 = paramClass.getMethod(paramString, paramVarArgs);
        return (Method)localObject1;
      }
      catch (NoSuchMethodException paramClass) {}
    }
    return null;
  }
  
  private static Method b(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    while (paramClass != null)
    {
      Class[] arrayOfClass = paramClass.getInterfaces();
      int i = 0;
      while (i < arrayOfClass.length)
      {
        if (Modifier.isPublic(arrayOfClass[i].getModifiers())) {
          try
          {
            Method localMethod1 = arrayOfClass[i].getDeclaredMethod(paramString, paramVarArgs);
            return localMethod1;
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            Method localMethod2 = b(arrayOfClass[i], paramString, paramVarArgs);
            if (localMethod2 != null) {
              return localMethod2;
            }
          }
        }
        i += 1;
      }
      paramClass = paramClass.getSuperclass();
    }
    return null;
  }
  
  /* Error */
  private static Method c(Class<?> arg0, String paramString, Class<?>... paramVarArgs)
  {
    // Byte code:
    //   0: new 59	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_0
    //   12: invokevirtual 112	java/lang/Class:toString	()Ljava/lang/String;
    //   15: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 114
    //   20: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ifnull +44 -> 73
    //   32: aload_2
    //   33: arraylength
    //   34: ifle +39 -> 73
    //   37: aload_2
    //   38: arraylength
    //   39: istore 4
    //   41: iconst_0
    //   42: istore_3
    //   43: iload_3
    //   44: iload 4
    //   46: if_icmpge +38 -> 84
    //   49: aload 5
    //   51: aload_2
    //   52: iload_3
    //   53: aaload
    //   54: invokevirtual 112	java/lang/Class:toString	()Ljava/lang/String;
    //   57: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 114
    //   62: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: iload_3
    //   67: iconst_1
    //   68: iadd
    //   69: istore_3
    //   70: goto -27 -> 43
    //   73: aload 5
    //   75: ldc 116
    //   77: invokevirtual 112	java/lang/Class:toString	()Ljava/lang/String;
    //   80: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 5
    //   86: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore 8
    //   91: getstatic 37	cn/jiguang/e/c:a	Ljava/util/Map;
    //   94: astore 5
    //   96: aload 5
    //   98: monitorenter
    //   99: getstatic 37	cn/jiguang/e/c:a	Ljava/util/Map;
    //   102: aload 8
    //   104: invokeinterface 122 2 0
    //   109: checkcast 77	java/lang/reflect/Method
    //   112: astore 6
    //   114: aload 5
    //   116: monitorexit
    //   117: aload 6
    //   119: ifnull +26 -> 145
    //   122: aload 6
    //   124: invokevirtual 126	java/lang/reflect/Method:isAccessible	()Z
    //   127: ifne +9 -> 136
    //   130: aload 6
    //   132: iconst_1
    //   133: invokevirtual 130	java/lang/reflect/Method:setAccessible	(Z)V
    //   136: aload 6
    //   138: areturn
    //   139: astore_0
    //   140: aload 5
    //   142: monitorexit
    //   143: aload_0
    //   144: athrow
    //   145: aload_0
    //   146: aload_1
    //   147: aload_2
    //   148: invokevirtual 99	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   151: astore 6
    //   153: aload 6
    //   155: invokestatic 135	cn/jiguang/e/b:a	(Ljava/lang/reflect/AccessibleObject;)Z
    //   158: pop
    //   159: getstatic 37	cn/jiguang/e/c:a	Ljava/util/Map;
    //   162: astore 5
    //   164: aload 5
    //   166: monitorenter
    //   167: getstatic 37	cn/jiguang/e/c:a	Ljava/util/Map;
    //   170: aload 8
    //   172: aload 6
    //   174: invokeinterface 139 3 0
    //   179: pop
    //   180: aload 5
    //   182: monitorexit
    //   183: aload 6
    //   185: areturn
    //   186: astore 6
    //   188: aload 5
    //   190: monitorexit
    //   191: aload 6
    //   193: athrow
    //   194: astore 5
    //   196: aload_0
    //   197: invokevirtual 143	java/lang/Class:getMethods	()[Ljava/lang/reflect/Method;
    //   200: astore 9
    //   202: aload 9
    //   204: arraylength
    //   205: istore 4
    //   207: aconst_null
    //   208: astore 5
    //   210: iconst_0
    //   211: istore_3
    //   212: iload_3
    //   213: iload 4
    //   215: if_icmpge +166 -> 381
    //   218: aload 9
    //   220: iload_3
    //   221: aaload
    //   222: astore 7
    //   224: aload 5
    //   226: astore 6
    //   228: aload 7
    //   230: invokevirtual 144	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   233: aload_1
    //   234: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   237: ifeq +66 -> 303
    //   240: aload 5
    //   242: astore 6
    //   244: aload_2
    //   245: aload 7
    //   247: invokevirtual 151	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   250: iconst_1
    //   251: invokestatic 154	cn/jiguang/e/b:a	([Ljava/lang/Class;[Ljava/lang/Class;Z)Z
    //   254: ifeq +49 -> 303
    //   257: aload 7
    //   259: invokestatic 157	cn/jiguang/e/b:a	(Ljava/lang/reflect/Member;)Z
    //   262: ifne +52 -> 314
    //   265: aconst_null
    //   266: astore_0
    //   267: aload 5
    //   269: astore 6
    //   271: aload_0
    //   272: ifnull +31 -> 303
    //   275: aload 5
    //   277: ifnull +23 -> 300
    //   280: aload 5
    //   282: astore 6
    //   284: aload_0
    //   285: invokevirtual 151	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   288: aload 5
    //   290: invokevirtual 151	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   293: aload_2
    //   294: invokestatic 160	cn/jiguang/e/b:a	([Ljava/lang/Class;[Ljava/lang/Class;[Ljava/lang/Class;)I
    //   297: ifge +6 -> 303
    //   300: aload_0
    //   301: astore 6
    //   303: iload_3
    //   304: iconst_1
    //   305: iadd
    //   306: istore_3
    //   307: aload 6
    //   309: astore 5
    //   311: goto -99 -> 212
    //   314: aload 7
    //   316: invokevirtual 163	java/lang/reflect/Method:getDeclaringClass	()Ljava/lang/Class;
    //   319: astore 10
    //   321: aload 7
    //   323: astore_0
    //   324: aload 10
    //   326: invokevirtual 89	java/lang/Class:getModifiers	()I
    //   329: invokestatic 95	java/lang/reflect/Modifier:isPublic	(I)Z
    //   332: ifne -65 -> 267
    //   335: aload 7
    //   337: invokevirtual 144	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   340: astore 11
    //   342: aload 7
    //   344: invokevirtual 151	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   347: astore 7
    //   349: aload 10
    //   351: aload 11
    //   353: aload 7
    //   355: invokestatic 110	cn/jiguang/e/c:b	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   358: astore 6
    //   360: aload 6
    //   362: astore_0
    //   363: aload 6
    //   365: ifnonnull -98 -> 267
    //   368: aload 10
    //   370: aload 11
    //   372: aload 7
    //   374: invokestatic 165	cn/jiguang/e/c:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   377: astore_0
    //   378: goto -111 -> 267
    //   381: aload 5
    //   383: ifnull +9 -> 392
    //   386: aload 5
    //   388: invokestatic 135	cn/jiguang/e/b:a	(Ljava/lang/reflect/AccessibleObject;)Z
    //   391: pop
    //   392: getstatic 37	cn/jiguang/e/c:a	Ljava/util/Map;
    //   395: astore_0
    //   396: aload_0
    //   397: monitorenter
    //   398: getstatic 37	cn/jiguang/e/c:a	Ljava/util/Map;
    //   401: aload 8
    //   403: aload 5
    //   405: invokeinterface 139 3 0
    //   410: pop
    //   411: aload_0
    //   412: monitorexit
    //   413: aload 5
    //   415: areturn
    //   416: astore_1
    //   417: aload_0
    //   418: monitorexit
    //   419: aload_1
    //   420: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	1	paramString	String
    //   0	421	2	paramVarArgs	Class<?>[]
    //   42	265	3	i	int
    //   39	177	4	j	int
    //   194	1	5	localNoSuchMethodException	NoSuchMethodException
    //   208	206	5	localObject2	Object
    //   112	72	6	localMethod	Method
    //   186	6	6	localObject3	Object
    //   226	138	6	localObject4	Object
    //   222	151	7	localObject5	Object
    //   89	313	8	str1	String
    //   200	19	9	arrayOfMethod	Method[]
    //   319	50	10	localClass	Class
    //   340	31	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   99	117	139	finally
    //   140	143	139	finally
    //   167	183	186	finally
    //   188	191	186	finally
    //   145	167	194	java/lang/NoSuchMethodException
    //   191	194	194	java/lang/NoSuchMethodException
    //   398	413	416	finally
    //   417	419	416	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */