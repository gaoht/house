package com.baidu.trace;

public final class r
{
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: new 10	org/json/JSONArray
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 13	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: bipush 15
    //   11: istore_1
    //   12: bipush 30
    //   14: istore_2
    //   15: iconst_0
    //   16: istore 6
    //   18: iconst_5
    //   19: istore 4
    //   21: iload 6
    //   23: aload_0
    //   24: invokevirtual 17	org/json/JSONArray:length	()I
    //   27: if_icmpge +152 -> 179
    //   30: aload_0
    //   31: iload 6
    //   33: invokevirtual 21	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   36: astore 8
    //   38: aload 8
    //   40: ldc 23
    //   42: invokevirtual 29	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   45: istore 7
    //   47: aload 8
    //   49: ldc 31
    //   51: invokevirtual 29	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   54: i2b
    //   55: istore_3
    //   56: iload 7
    //   58: tableswitch	default:+176->234, 1:+197->255, 2:+209->267, 3:+62->120, 4:+87->145, 5:+221->279, 6:+230->288, 7:+239->297, 8:+248->306, 9:+257->315, 10:+266->324, 11:+275->333, 12:+100->158
    //   120: iload_3
    //   121: iconst_5
    //   122: if_icmplt +112 -> 234
    //   125: iload_3
    //   126: sipush 128
    //   129: if_icmpgt +105 -> 234
    //   132: iload_3
    //   133: putstatic 37	com/baidu/trace/z:r	B
    //   136: iload_1
    //   137: istore_3
    //   138: iload_2
    //   139: istore_1
    //   140: iload_3
    //   141: istore_2
    //   142: goto +98 -> 240
    //   145: iload_3
    //   146: putstatic 40	com/baidu/trace/z:s	B
    //   149: iload_1
    //   150: istore_3
    //   151: iload_2
    //   152: istore_1
    //   153: iload_3
    //   154: istore_2
    //   155: goto +85 -> 240
    //   158: iload_3
    //   159: getstatic 46	com/baidu/trace/ar:c	I
    //   162: if_icmplt +72 -> 234
    //   165: iload_1
    //   166: istore 5
    //   168: iload_3
    //   169: istore 4
    //   171: iload_2
    //   172: istore_1
    //   173: iload 5
    //   175: istore_2
    //   176: goto +64 -> 240
    //   179: iload_1
    //   180: putstatic 49	com/baidu/trace/z:p	B
    //   183: iload 4
    //   185: ifeq +43 -> 228
    //   188: iload_2
    //   189: ifeq +39 -> 228
    //   192: iload_2
    //   193: iload 4
    //   195: irem
    //   196: ifne +32 -> 228
    //   199: iload 4
    //   201: sipush 1000
    //   204: imul
    //   205: putstatic 52	com/baidu/trace/ar:b	I
    //   208: iload 4
    //   210: putstatic 55	com/baidu/trace/z:w	B
    //   213: iload_2
    //   214: sipush 1000
    //   217: imul
    //   218: putstatic 60	com/baidu/trace/bd:i	I
    //   221: iload_2
    //   222: putstatic 63	com/baidu/trace/z:q	B
    //   225: invokestatic 67	com/baidu/trace/bd:d	()V
    //   228: return
    //   229: astore_0
    //   230: aload_0
    //   231: athrow
    //   232: astore_0
    //   233: return
    //   234: iload_2
    //   235: istore_3
    //   236: iload_1
    //   237: istore_2
    //   238: iload_3
    //   239: istore_1
    //   240: iload 6
    //   242: iconst_1
    //   243: iadd
    //   244: istore 6
    //   246: iload_2
    //   247: istore_3
    //   248: iload_1
    //   249: istore_2
    //   250: iload_3
    //   251: istore_1
    //   252: goto -231 -> 21
    //   255: iload_3
    //   256: iconst_5
    //   257: if_icmplt -23 -> 234
    //   260: iload_2
    //   261: istore_1
    //   262: iload_3
    //   263: istore_2
    //   264: goto -24 -> 240
    //   267: iload_3
    //   268: iconst_2
    //   269: if_icmplt -35 -> 234
    //   272: iload_1
    //   273: istore_2
    //   274: iload_3
    //   275: istore_1
    //   276: goto -36 -> 240
    //   279: iload_1
    //   280: istore_3
    //   281: iload_2
    //   282: istore_1
    //   283: iload_3
    //   284: istore_2
    //   285: goto -45 -> 240
    //   288: iload_1
    //   289: istore_3
    //   290: iload_2
    //   291: istore_1
    //   292: iload_3
    //   293: istore_2
    //   294: goto -54 -> 240
    //   297: iload_1
    //   298: istore_3
    //   299: iload_2
    //   300: istore_1
    //   301: iload_3
    //   302: istore_2
    //   303: goto -63 -> 240
    //   306: iload_1
    //   307: istore_3
    //   308: iload_2
    //   309: istore_1
    //   310: iload_3
    //   311: istore_2
    //   312: goto -72 -> 240
    //   315: iload_1
    //   316: istore_3
    //   317: iload_2
    //   318: istore_1
    //   319: iload_3
    //   320: istore_2
    //   321: goto -81 -> 240
    //   324: iload_1
    //   325: istore_3
    //   326: iload_2
    //   327: istore_1
    //   328: iload_3
    //   329: istore_2
    //   330: goto -90 -> 240
    //   333: iload_1
    //   334: istore_3
    //   335: iload_2
    //   336: istore_1
    //   337: iload_3
    //   338: istore_2
    //   339: goto -99 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	paramString	String
    //   11	326	1	i	int
    //   14	325	2	j	int
    //   55	283	3	k	int
    //   19	190	4	m	int
    //   166	8	5	n	int
    //   16	229	6	i1	int
    //   45	12	7	i2	int
    //   36	12	8	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	9	229	finally
    //   21	56	229	finally
    //   132	136	229	finally
    //   145	149	229	finally
    //   158	165	229	finally
    //   179	183	229	finally
    //   199	228	229	finally
    //   0	9	232	org/json/JSONException
    //   21	56	232	org/json/JSONException
    //   132	136	232	org/json/JSONException
    //   145	149	232	org/json/JSONException
    //   158	165	232	org/json/JSONException
    //   179	183	232	org/json/JSONException
    //   199	228	232	org/json/JSONException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */