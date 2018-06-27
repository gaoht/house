package com.g.a;

import org.json.JSONObject;

public class ce
{
  private static bp a = null;
  private static bs b = null;
  private static bx c = null;
  private static bt d = null;
  private static volatile ce e = null;
  
  public static ce a()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new ce();
      }
      return e;
    }
    finally {}
  }
  
  public JSONObject a(bo parambo, boolean paramBoolean)
  {
    try
    {
      parambo = a(parambo, paramBoolean, null);
      return parambo;
    }
    finally
    {
      parambo = finally;
      throw parambo;
    }
  }
  
  /* Error */
  public JSONObject a(bo parambo, boolean paramBoolean, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +14 -> 17
    //   6: aload_1
    //   7: invokevirtual 44	com/g/a/bo:a_	()Ljava/lang/Object;
    //   10: astore 6
    //   12: aload 6
    //   14: ifnonnull +9 -> 23
    //   17: aconst_null
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: getstatic 18	com/g/a/ce:a	Lcom/g/a/bp;
    //   26: ifnonnull +47 -> 73
    //   29: invokestatic 49	com/g/a/bp:b	()Lcom/g/a/bp;
    //   32: putstatic 18	com/g/a/ce:a	Lcom/g/a/bp;
    //   35: getstatic 54	com/g/a/c:e	Landroid/content/Context;
    //   38: invokevirtual 60	android/content/Context:getPackageName	()Ljava/lang/String;
    //   41: astore 6
    //   43: getstatic 54	com/g/a/c:e	Landroid/content/Context;
    //   46: aload 6
    //   48: invokestatic 65	com/g/a/cd:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 6
    //   53: getstatic 18	com/g/a/ce:a	Lcom/g/a/bp;
    //   56: aload 6
    //   58: invokevirtual 69	com/g/a/bp:setUniqueId	(Ljava/lang/String;)V
    //   61: getstatic 18	com/g/a/ce:a	Lcom/g/a/bp;
    //   64: getstatic 54	com/g/a/c:e	Landroid/content/Context;
    //   67: invokestatic 72	com/g/a/c:a	(Landroid/content/Context;)Ljava/lang/String;
    //   70: invokevirtual 75	com/g/a/bp:setAppChannel	(Ljava/lang/String;)V
    //   73: getstatic 18	com/g/a/ce:a	Lcom/g/a/bp;
    //   76: aload_3
    //   77: invokevirtual 79	com/g/a/bp:setSubmitAppId	(Lcom/g/a/a;)V
    //   80: getstatic 22	com/g/a/ce:c	Lcom/g/a/bx;
    //   83: ifnonnull +352 -> 435
    //   86: new 81	com/g/a/bx
    //   89: dup
    //   90: invokespecial 82	com/g/a/bx:<init>	()V
    //   93: putstatic 22	com/g/a/ce:c	Lcom/g/a/bx;
    //   96: getstatic 20	com/g/a/ce:b	Lcom/g/a/bs;
    //   99: ifnonnull +13 -> 112
    //   102: new 84	com/g/a/bs
    //   105: dup
    //   106: invokespecial 85	com/g/a/bs:<init>	()V
    //   109: putstatic 20	com/g/a/ce:b	Lcom/g/a/bs;
    //   112: getstatic 24	com/g/a/ce:d	Lcom/g/a/bt;
    //   115: ifnonnull +31 -> 146
    //   118: new 87	com/g/a/bt
    //   121: dup
    //   122: invokespecial 88	com/g/a/bt:<init>	()V
    //   125: putstatic 24	com/g/a/ce:d	Lcom/g/a/bt;
    //   128: getstatic 24	com/g/a/ce:d	Lcom/g/a/bt;
    //   131: invokevirtual 90	com/g/a/bt:b	()V
    //   134: getstatic 22	com/g/a/ce:c	Lcom/g/a/bx;
    //   137: invokevirtual 93	com/g/a/bx:c	()Lcom/g/a/bu;
    //   140: getstatic 98	com/g/a/y:a	I
    //   143: invokevirtual 104	com/g/a/bu:setSlots	(I)V
    //   146: new 106	org/json/JSONObject
    //   149: dup
    //   150: invokespecial 107	org/json/JSONObject:<init>	()V
    //   153: astore_3
    //   154: aload_3
    //   155: ldc 109
    //   157: ldc 111
    //   159: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   162: pop
    //   163: aload_3
    //   164: ldc 117
    //   166: aload_1
    //   167: invokevirtual 44	com/g/a/bo:a_	()Ljava/lang/Object;
    //   170: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: pop
    //   174: aload_3
    //   175: ldc 119
    //   177: getstatic 22	com/g/a/ce:c	Lcom/g/a/bx;
    //   180: invokevirtual 120	com/g/a/bx:a_	()Ljava/lang/Object;
    //   183: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   186: pop
    //   187: aload_3
    //   188: ldc 122
    //   190: getstatic 18	com/g/a/ce:a	Lcom/g/a/bp;
    //   193: invokevirtual 123	com/g/a/bp:a_	()Ljava/lang/Object;
    //   196: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   199: pop
    //   200: aload_3
    //   201: ldc 125
    //   203: getstatic 20	com/g/a/ce:b	Lcom/g/a/bs;
    //   206: invokevirtual 126	com/g/a/bs:a_	()Ljava/lang/Object;
    //   209: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   212: pop
    //   213: aload_3
    //   214: ldc -128
    //   216: invokestatic 133	com/g/a/bm:a	()Lcom/g/a/bm;
    //   219: invokevirtual 134	com/g/a/bm:a_	()Ljava/lang/Object;
    //   222: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   225: pop
    //   226: aload_3
    //   227: ldc -120
    //   229: getstatic 24	com/g/a/ce:d	Lcom/g/a/bt;
    //   232: invokevirtual 137	com/g/a/bt:a_	()Ljava/lang/Object;
    //   235: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   238: pop
    //   239: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   242: lstore 4
    //   244: aload_3
    //   245: ldc -111
    //   247: lload 4
    //   249: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   252: pop
    //   253: aload_3
    //   254: ldc -106
    //   256: new 152	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   263: lload 4
    //   265: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   268: getstatic 54	com/g/a/c:e	Landroid/content/Context;
    //   271: invokestatic 158	com/g/a/cd:a	(Landroid/content/Context;)Ljava/lang/String;
    //   274: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: getstatic 22	com/g/a/ce:c	Lcom/g/a/bx;
    //   280: invokevirtual 164	com/g/a/bx:b	()Lcom/g/a/by;
    //   283: invokevirtual 168	com/g/a/by:b	()Ljava/lang/String;
    //   286: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: getstatic 22	com/g/a/ce:c	Lcom/g/a/bx;
    //   292: invokevirtual 164	com/g/a/bx:b	()Lcom/g/a/by;
    //   295: invokevirtual 170	com/g/a/by:c	()Ljava/lang/String;
    //   298: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 178	com/g/a/z:c	(Ljava/lang/String;)Ljava/lang/String;
    //   307: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   310: pop
    //   311: aload_3
    //   312: astore_1
    //   313: iload_2
    //   314: ifeq -295 -> 19
    //   317: new 180	org/json/JSONArray
    //   320: dup
    //   321: invokespecial 181	org/json/JSONArray:<init>	()V
    //   324: astore_1
    //   325: aload_1
    //   326: new 183	com/g/a/ca
    //   329: dup
    //   330: getstatic 188	com/g/a/cc:a	Lcom/g/a/cc;
    //   333: invokespecial 191	com/g/a/ca:<init>	(Lcom/g/a/cc;)V
    //   336: invokevirtual 192	com/g/a/ca:a_	()Ljava/lang/Object;
    //   339: invokevirtual 195	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   342: pop
    //   343: aload_1
    //   344: new 183	com/g/a/ca
    //   347: dup
    //   348: getstatic 197	com/g/a/cc:b	Lcom/g/a/cc;
    //   351: invokespecial 191	com/g/a/ca:<init>	(Lcom/g/a/cc;)V
    //   354: invokevirtual 192	com/g/a/ca:a_	()Ljava/lang/Object;
    //   357: invokevirtual 195	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   360: pop
    //   361: getstatic 54	com/g/a/c:e	Landroid/content/Context;
    //   364: ldc -57
    //   366: invokestatic 202	com/g/a/z:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   369: ifeq +21 -> 390
    //   372: aload_1
    //   373: new 183	com/g/a/ca
    //   376: dup
    //   377: getstatic 204	com/g/a/cc:c	Lcom/g/a/cc;
    //   380: invokespecial 191	com/g/a/ca:<init>	(Lcom/g/a/cc;)V
    //   383: invokevirtual 192	com/g/a/ca:a_	()Ljava/lang/Object;
    //   386: invokevirtual 195	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   389: pop
    //   390: aload_3
    //   391: ldc -50
    //   393: aload_1
    //   394: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   397: pop
    //   398: aload_3
    //   399: ldc -48
    //   401: new 210	com/g/a/bq
    //   404: dup
    //   405: invokespecial 211	com/g/a/bq:<init>	()V
    //   408: invokevirtual 212	com/g/a/bq:a_	()Ljava/lang/Object;
    //   411: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   414: pop
    //   415: aload_3
    //   416: astore_1
    //   417: goto -398 -> 19
    //   420: astore_1
    //   421: aload_1
    //   422: invokestatic 218	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   425: aload_3
    //   426: astore_1
    //   427: goto -408 -> 19
    //   430: astore_1
    //   431: aload_0
    //   432: monitorexit
    //   433: aload_1
    //   434: athrow
    //   435: getstatic 22	com/g/a/ce:c	Lcom/g/a/bx;
    //   438: astore_3
    //   439: getstatic 221	com/g/a/bx:a	Lcom/g/a/bw;
    //   442: invokevirtual 224	com/g/a/bw:b	()V
    //   445: goto -349 -> 96
    //   448: astore 6
    //   450: goto -60 -> 390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	this	ce
    //   0	453	1	parambo	bo
    //   0	453	2	paramBoolean	boolean
    //   0	453	3	parama	a
    //   242	22	4	l	long
    //   10	47	6	localObject	Object
    //   448	1	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   154	311	420	java/lang/Throwable
    //   317	361	420	java/lang/Throwable
    //   390	415	420	java/lang/Throwable
    //   6	12	430	finally
    //   23	73	430	finally
    //   73	96	430	finally
    //   96	112	430	finally
    //   112	146	430	finally
    //   146	154	430	finally
    //   154	311	430	finally
    //   317	361	430	finally
    //   361	390	430	finally
    //   390	415	430	finally
    //   421	425	430	finally
    //   435	445	430	finally
    //   361	390	448	java/lang/Throwable
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */