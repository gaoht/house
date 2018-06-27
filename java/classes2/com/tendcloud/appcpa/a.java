package com.tendcloud.appcpa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends JSONObject
{
  JSONArray a = null;
  
  private a() {}
  
  private a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      put("keyOrderId", paramString1);
      put("keyTotalPrice", paramInt);
      put("keyCurrencyType", paramString2);
      return;
    }
    catch (JSONException paramString1) {}
  }
  
  public static a createOrder(String paramString1, int paramInt, String paramString2)
  {
    return new a(paramString1, paramInt, paramString2);
  }
  
  /* Error */
  public a addItem(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 12	com/tendcloud/appcpa/a:a	Lorg/json/JSONArray;
    //   6: ifnonnull +25 -> 31
    //   9: aload_0
    //   10: new 37	org/json/JSONArray
    //   13: dup
    //   14: invokespecial 38	org/json/JSONArray:<init>	()V
    //   17: putfield 12	com/tendcloud/appcpa/a:a	Lorg/json/JSONArray;
    //   20: aload_0
    //   21: ldc 40
    //   23: aload_0
    //   24: getfield 12	com/tendcloud/appcpa/a:a	Lorg/json/JSONArray;
    //   27: invokevirtual 22	com/tendcloud/appcpa/a:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   30: pop
    //   31: new 4	org/json/JSONObject
    //   34: dup
    //   35: invokespecial 10	org/json/JSONObject:<init>	()V
    //   38: astore 5
    //   40: aload 5
    //   42: ldc 42
    //   44: aload_2
    //   45: invokevirtual 43	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   48: pop
    //   49: aload 5
    //   51: ldc 45
    //   53: iload_3
    //   54: invokevirtual 46	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload 5
    //   60: ldc 48
    //   62: iload 4
    //   64: invokevirtual 46	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload 5
    //   70: ldc 50
    //   72: aload_1
    //   73: invokevirtual 43	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload_0
    //   78: getfield 12	com/tendcloud/appcpa/a:a	Lorg/json/JSONArray;
    //   81: aload 5
    //   83: invokevirtual 53	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   86: pop
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_0
    //   90: areturn
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: goto -10 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	a
    //   0	100	1	paramString1	String
    //   0	100	2	paramString2	String
    //   0	100	3	paramInt1	int
    //   0	100	4	paramInt2	int
    //   38	44	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   2	31	91	finally
    //   31	87	91	finally
    //   2	31	96	org/json/JSONException
    //   31	87	96	org/json/JSONException
  }
  
  /* Error */
  public a addItem(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 12	com/tendcloud/appcpa/a:a	Lorg/json/JSONArray;
    //   6: ifnonnull +25 -> 31
    //   9: aload_0
    //   10: new 37	org/json/JSONArray
    //   13: dup
    //   14: invokespecial 38	org/json/JSONArray:<init>	()V
    //   17: putfield 12	com/tendcloud/appcpa/a:a	Lorg/json/JSONArray;
    //   20: aload_0
    //   21: ldc 40
    //   23: aload_0
    //   24: getfield 12	com/tendcloud/appcpa/a:a	Lorg/json/JSONArray;
    //   27: invokevirtual 22	com/tendcloud/appcpa/a:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   30: pop
    //   31: new 4	org/json/JSONObject
    //   34: dup
    //   35: invokespecial 10	org/json/JSONObject:<init>	()V
    //   38: astore 6
    //   40: aload 6
    //   42: ldc 56
    //   44: aload_1
    //   45: invokevirtual 43	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   48: pop
    //   49: aload 6
    //   51: ldc 42
    //   53: aload_3
    //   54: invokevirtual 43	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload 6
    //   60: ldc 45
    //   62: iload 4
    //   64: invokevirtual 46	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload 6
    //   70: ldc 48
    //   72: iload 5
    //   74: invokevirtual 46	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   77: pop
    //   78: aload 6
    //   80: ldc 50
    //   82: aload_2
    //   83: invokevirtual 43	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: pop
    //   87: aload_0
    //   88: getfield 12	com/tendcloud/appcpa/a:a	Lorg/json/JSONArray;
    //   91: aload 6
    //   93: invokevirtual 53	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   96: pop
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_0
    //   100: areturn
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: goto -10 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	a
    //   0	110	1	paramString1	String
    //   0	110	2	paramString2	String
    //   0	110	3	paramString3	String
    //   0	110	4	paramInt1	int
    //   0	110	5	paramInt2	int
    //   38	54	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   2	31	101	finally
    //   31	97	101	finally
    //   2	31	106	org/json/JSONException
    //   31	97	106	org/json/JSONException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tendcloud/appcpa/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */