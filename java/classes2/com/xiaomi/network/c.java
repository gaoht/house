package com.xiaomi.network;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

class c
  implements Comparable<c>
{
  String a;
  protected int b;
  private final LinkedList<AccessHistory> c = new LinkedList();
  private long d = 0L;
  
  public c()
  {
    this(null, 0);
  }
  
  public c(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public int a(c paramc)
  {
    if (paramc == null) {
      return 1;
    }
    return paramc.b - this.b;
  }
  
  public c a(JSONObject paramJSONObject)
  {
    try
    {
      this.d = paramJSONObject.getLong("tt");
      this.b = paramJSONObject.getInt("wt");
      this.a = paramJSONObject.getString("host");
      paramJSONObject = paramJSONObject.getJSONArray("ah");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        this.c.add(new AccessHistory().a(localJSONObject));
        i += 1;
      }
      return this;
    }
    finally {}
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("tt", this.d);
      localJSONObject1.put("wt", this.b);
      localJSONObject1.put("host", this.a);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((AccessHistory)localIterator.next()).b());
      }
      localJSONObject2.put("ah", localJSONArray);
    }
    finally {}
    return localJSONObject2;
  }
  
  /* Error */
  protected void a(AccessHistory paramAccessHistory)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +72 -> 75
    //   6: aload_0
    //   7: getfield 29	com/xiaomi/network/c:c	Ljava/util/LinkedList;
    //   10: aload_1
    //   11: invokevirtual 83	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   14: pop
    //   15: aload_1
    //   16: invokevirtual 118	com/xiaomi/network/AccessHistory:a	()I
    //   19: istore 4
    //   21: iload 4
    //   23: ifle +55 -> 78
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 35	com/xiaomi/network/c:b	I
    //   31: aload_1
    //   32: invokevirtual 118	com/xiaomi/network/AccessHistory:a	()I
    //   35: iadd
    //   36: putfield 35	com/xiaomi/network/c:b	I
    //   39: aload_0
    //   40: getfield 29	com/xiaomi/network/c:c	Ljava/util/LinkedList;
    //   43: invokevirtual 121	java/util/LinkedList:size	()I
    //   46: bipush 30
    //   48: if_icmple +27 -> 75
    //   51: aload_0
    //   52: getfield 29	com/xiaomi/network/c:c	Ljava/util/LinkedList;
    //   55: invokevirtual 124	java/util/LinkedList:remove	()Ljava/lang/Object;
    //   58: checkcast 75	com/xiaomi/network/AccessHistory
    //   61: astore_1
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 35	com/xiaomi/network/c:b	I
    //   67: aload_1
    //   68: invokevirtual 118	com/xiaomi/network/AccessHistory:a	()I
    //   71: isub
    //   72: putfield 35	com/xiaomi/network/c:b	I
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: aload_0
    //   79: getfield 29	com/xiaomi/network/c:c	Ljava/util/LinkedList;
    //   82: invokevirtual 121	java/util/LinkedList:size	()I
    //   85: istore_2
    //   86: iconst_0
    //   87: istore_3
    //   88: iload_2
    //   89: iconst_1
    //   90: isub
    //   91: istore_2
    //   92: iload_2
    //   93: iflt +31 -> 124
    //   96: aload_0
    //   97: getfield 29	com/xiaomi/network/c:c	Ljava/util/LinkedList;
    //   100: iload_2
    //   101: invokevirtual 128	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   104: checkcast 75	com/xiaomi/network/AccessHistory
    //   107: invokevirtual 118	com/xiaomi/network/AccessHistory:a	()I
    //   110: ifge +14 -> 124
    //   113: iload_3
    //   114: iconst_1
    //   115: iadd
    //   116: istore_3
    //   117: iload_2
    //   118: iconst_1
    //   119: isub
    //   120: istore_2
    //   121: goto -29 -> 92
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 35	com/xiaomi/network/c:b	I
    //   129: iload 4
    //   131: iload_3
    //   132: imul
    //   133: iadd
    //   134: putfield 35	com/xiaomi/network/c:b	I
    //   137: goto -98 -> 39
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	c
    //   0	145	1	paramAccessHistory	AccessHistory
    //   85	36	2	i	int
    //   87	46	3	j	int
    //   19	114	4	k	int
    // Exception table:
    //   from	to	target	type
    //   6	21	140	finally
    //   26	39	140	finally
    //   39	75	140	finally
    //   78	86	140	finally
    //   96	113	140	finally
    //   124	137	140	finally
  }
  
  public String toString()
  {
    return this.a + ":" + this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/network/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */