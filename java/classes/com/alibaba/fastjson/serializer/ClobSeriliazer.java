package com.alibaba.fastjson.serializer;

public class ClobSeriliazer
  implements ObjectSerializer
{
  public static final ClobSeriliazer instance = new ClobSeriliazer();
  
  /* Error */
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, java.lang.reflect.Type paramType, int paramInt)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +8 -> 9
    //   4: aload_1
    //   5: invokevirtual 30	com/alibaba/fastjson/serializer/JSONSerializer:writeNull	()V
    //   8: return
    //   9: aload_2
    //   10: checkcast 32	java/sql/Clob
    //   13: invokeinterface 36 1 0
    //   18: astore_2
    //   19: new 38	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   26: astore_3
    //   27: sipush 2048
    //   30: newarray <illegal type>
    //   32: astore 4
    //   34: aload_2
    //   35: aload 4
    //   37: iconst_0
    //   38: aload 4
    //   40: arraylength
    //   41: invokevirtual 45	java/io/Reader:read	([CII)I
    //   44: istore 5
    //   46: iload 5
    //   48: ifge +30 -> 78
    //   51: aload_3
    //   52: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_3
    //   56: aload_2
    //   57: invokevirtual 52	java/io/Reader:close	()V
    //   60: aload_1
    //   61: aload_3
    //   62: invokevirtual 55	com/alibaba/fastjson/serializer/JSONSerializer:write	(Ljava/lang/String;)V
    //   65: return
    //   66: astore_1
    //   67: new 21	java/io/IOException
    //   70: dup
    //   71: ldc 57
    //   73: aload_1
    //   74: invokespecial 60	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: athrow
    //   78: aload_3
    //   79: aload 4
    //   81: iconst_0
    //   82: iload 5
    //   84: invokevirtual 64	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: goto -54 -> 34
    //   91: astore_1
    //   92: new 66	com/alibaba/fastjson/d
    //   95: dup
    //   96: ldc 68
    //   98: aload_1
    //   99: invokespecial 69	com/alibaba/fastjson/d:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	ClobSeriliazer
    //   0	103	1	paramJSONSerializer	JSONSerializer
    //   0	103	2	paramObject1	Object
    //   0	103	3	paramObject2	Object
    //   0	103	4	paramType	java.lang.reflect.Type
    //   0	103	5	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   4	8	66	java/sql/SQLException
    //   9	27	66	java/sql/SQLException
    //   27	34	66	java/sql/SQLException
    //   34	46	66	java/sql/SQLException
    //   51	65	66	java/sql/SQLException
    //   78	88	66	java/sql/SQLException
    //   92	103	66	java/sql/SQLException
    //   27	34	91	java/lang/Exception
    //   34	46	91	java/lang/Exception
    //   78	88	91	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/ClobSeriliazer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */