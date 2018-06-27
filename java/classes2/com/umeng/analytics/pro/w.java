package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class w
{
  public static final int a = 2049;
  public static final int b = 2050;
  private static Context c = null;
  private static String d = null;
  private static final String e = "umeng+";
  private static final String f = "ek__id";
  private static final String g = "ek_key";
  private List<String> h = new ArrayList();
  
  private w()
  {
    if (c != null)
    {
      b();
      this.h.clear();
    }
  }
  
  public static final w a(Context paramContext)
  {
    c = paramContext;
    return b.a();
  }
  
  /* Error */
  private void a(String paramString1, JSONObject paramJSONObject, SQLiteDatabase paramSQLiteDatabase, String paramString2)
    throws org.json.JSONException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_3
    //   7: new 66	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   14: ldc 69
    //   16: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload 4
    //   21: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 75
    //   26: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 77
    //   31: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 79
    //   36: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 81
    //   41: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 83
    //   46: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 85
    //   55: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: aconst_null
    //   62: invokevirtual 95	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 7
    //   67: aload 7
    //   69: astore 5
    //   71: aload 5
    //   73: ifnull +200 -> 273
    //   76: aload 5
    //   78: invokeinterface 101 1 0
    //   83: ifeq +196 -> 279
    //   86: aload_0
    //   87: aload 5
    //   89: aload 5
    //   91: aload 4
    //   93: invokeinterface 105 2 0
    //   98: invokeinterface 109 2 0
    //   103: invokevirtual 112	com/umeng/analytics/pro/w:b	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 6
    //   108: goto -32 -> 76
    //   111: new 114	org/json/JSONArray
    //   114: dup
    //   115: invokespecial 115	org/json/JSONArray:<init>	()V
    //   118: astore 7
    //   120: aload 6
    //   122: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne +14 -> 139
    //   128: new 114	org/json/JSONArray
    //   131: dup
    //   132: aload 6
    //   134: invokespecial 124	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   137: astore 7
    //   139: aload 7
    //   141: aload_2
    //   142: invokevirtual 128	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   145: pop
    //   146: aload_0
    //   147: aload 7
    //   149: invokevirtual 129	org/json/JSONArray:toString	()Ljava/lang/String;
    //   152: invokevirtual 131	com/umeng/analytics/pro/w:a	(Ljava/lang/String;)Ljava/lang/String;
    //   155: astore_2
    //   156: aload_2
    //   157: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   160: ifne +60 -> 220
    //   163: aload_3
    //   164: new 66	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   171: ldc -123
    //   173: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 4
    //   178: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc 83
    //   183: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_2
    //   187: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc -121
    //   192: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc 81
    //   197: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc 83
    //   202: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 85
    //   211: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokevirtual 138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   220: aload 5
    //   222: ifnull +10 -> 232
    //   225: aload 5
    //   227: invokeinterface 141 1 0
    //   232: return
    //   233: astore_1
    //   234: aconst_null
    //   235: astore 5
    //   237: aload 5
    //   239: ifnull -7 -> 232
    //   242: aload 5
    //   244: invokeinterface 141 1 0
    //   249: return
    //   250: astore_1
    //   251: aload 5
    //   253: ifnull +10 -> 263
    //   256: aload 5
    //   258: invokeinterface 141 1 0
    //   263: aload_1
    //   264: athrow
    //   265: astore_1
    //   266: goto -15 -> 251
    //   269: astore_1
    //   270: goto -33 -> 237
    //   273: aconst_null
    //   274: astore 6
    //   276: goto -165 -> 111
    //   279: goto -168 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	w
    //   0	282	1	paramString1	String
    //   0	282	2	paramJSONObject	JSONObject
    //   0	282	3	paramSQLiteDatabase	SQLiteDatabase
    //   0	282	4	paramString2	String
    //   1	256	5	localObject1	Object
    //   4	271	6	str	String
    //   65	83	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	67	233	java/lang/Throwable
    //   6	67	250	finally
    //   76	108	265	finally
    //   111	120	265	finally
    //   120	139	265	finally
    //   139	220	265	finally
    //   76	108	269	java/lang/Throwable
    //   111	120	269	java/lang/Throwable
    //   120	139	269	java/lang/Throwable
    //   139	220	269	java/lang/Throwable
  }
  
  /* Error */
  private void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   6: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   9: invokevirtual 151	com/umeng/analytics/pro/u:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 154	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   17: aload_3
    //   18: ldc -100
    //   20: aconst_null
    //   21: invokevirtual 95	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore 5
    //   26: aload 5
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +539 -> 571
    //   35: new 158	org/json/JSONObject
    //   38: dup
    //   39: invokespecial 159	org/json/JSONObject:<init>	()V
    //   42: astore 8
    //   44: new 158	org/json/JSONObject
    //   47: dup
    //   48: invokespecial 159	org/json/JSONObject:<init>	()V
    //   51: astore 7
    //   53: aload 4
    //   55: invokeinterface 101 1 0
    //   60: ifeq +285 -> 345
    //   63: aload 4
    //   65: aload 4
    //   67: ldc -95
    //   69: invokeinterface 105 2 0
    //   74: invokeinterface 165 2 0
    //   79: istore_2
    //   80: aload 4
    //   82: aload 4
    //   84: ldc -89
    //   86: invokeinterface 105 2 0
    //   91: invokeinterface 109 2 0
    //   96: astore 6
    //   98: aload 4
    //   100: aload 4
    //   102: ldc -87
    //   104: invokeinterface 105 2 0
    //   109: invokeinterface 109 2 0
    //   114: astore 9
    //   116: aload 6
    //   118: astore 5
    //   120: ldc -85
    //   122: aload 6
    //   124: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifeq +502 -> 629
    //   130: invokestatic 181	com/umeng/analytics/pro/bd:a	()Ljava/lang/String;
    //   133: astore 5
    //   135: goto +494 -> 629
    //   138: aload 9
    //   140: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifne -90 -> 53
    //   146: new 158	org/json/JSONObject
    //   149: dup
    //   150: aload_0
    //   151: aload 9
    //   153: invokevirtual 112	com/umeng/analytics/pro/w:b	(Ljava/lang/String;)Ljava/lang/String;
    //   156: invokespecial 182	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   159: astore 9
    //   161: aload 8
    //   163: aload 5
    //   165: invokevirtual 186	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   168: ifeq +62 -> 230
    //   171: aload 8
    //   173: aload 5
    //   175: invokevirtual 190	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   178: astore 6
    //   180: aload 6
    //   182: aload 9
    //   184: invokevirtual 128	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   187: pop
    //   188: aload 8
    //   190: aload 5
    //   192: aload 6
    //   194: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   197: pop
    //   198: goto -145 -> 53
    //   201: astore_1
    //   202: aload_3
    //   203: astore_1
    //   204: aload 4
    //   206: ifnull +10 -> 216
    //   209: aload 4
    //   211: invokeinterface 141 1 0
    //   216: aload_1
    //   217: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   220: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   223: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   226: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   229: return
    //   230: new 114	org/json/JSONArray
    //   233: dup
    //   234: invokespecial 115	org/json/JSONArray:<init>	()V
    //   237: astore 6
    //   239: goto -59 -> 180
    //   242: astore_1
    //   243: aload 4
    //   245: ifnull +10 -> 255
    //   248: aload 4
    //   250: invokeinterface 141 1 0
    //   255: aload_3
    //   256: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   259: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   262: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   265: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   268: aload_1
    //   269: athrow
    //   270: aload 9
    //   272: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   275: ifne -222 -> 53
    //   278: new 158	org/json/JSONObject
    //   281: dup
    //   282: aload_0
    //   283: aload 9
    //   285: invokevirtual 112	com/umeng/analytics/pro/w:b	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokespecial 182	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   291: astore 9
    //   293: aload 7
    //   295: aload 5
    //   297: invokevirtual 186	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   300: ifeq +33 -> 333
    //   303: aload 7
    //   305: aload 5
    //   307: invokevirtual 190	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   310: astore 6
    //   312: aload 6
    //   314: aload 9
    //   316: invokevirtual 128	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   319: pop
    //   320: aload 7
    //   322: aload 5
    //   324: aload 6
    //   326: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   329: pop
    //   330: goto -277 -> 53
    //   333: new 114	org/json/JSONArray
    //   336: dup
    //   337: invokespecial 115	org/json/JSONArray:<init>	()V
    //   340: astore 6
    //   342: goto -30 -> 312
    //   345: aload 8
    //   347: invokevirtual 201	org/json/JSONObject:length	()I
    //   350: ifle +108 -> 458
    //   353: new 114	org/json/JSONArray
    //   356: dup
    //   357: invokespecial 115	org/json/JSONArray:<init>	()V
    //   360: astore 5
    //   362: aload 8
    //   364: invokevirtual 205	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   367: astore 6
    //   369: aload 6
    //   371: invokeinterface 210 1 0
    //   376: ifeq +65 -> 441
    //   379: new 158	org/json/JSONObject
    //   382: dup
    //   383: invokespecial 159	org/json/JSONObject:<init>	()V
    //   386: astore 9
    //   388: aload 6
    //   390: invokeinterface 214 1 0
    //   395: checkcast 173	java/lang/String
    //   398: astore 10
    //   400: aload 9
    //   402: aload 10
    //   404: new 114	org/json/JSONArray
    //   407: dup
    //   408: aload 8
    //   410: aload 10
    //   412: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   415: invokespecial 124	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   418: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   421: pop
    //   422: aload 9
    //   424: invokevirtual 201	org/json/JSONObject:length	()I
    //   427: ifle -58 -> 369
    //   430: aload 5
    //   432: aload 9
    //   434: invokevirtual 128	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   437: pop
    //   438: goto -69 -> 369
    //   441: aload 5
    //   443: invokevirtual 218	org/json/JSONArray:length	()I
    //   446: ifle +12 -> 458
    //   449: aload_1
    //   450: ldc -36
    //   452: aload 5
    //   454: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   457: pop
    //   458: aload 7
    //   460: invokevirtual 201	org/json/JSONObject:length	()I
    //   463: ifle +108 -> 571
    //   466: new 114	org/json/JSONArray
    //   469: dup
    //   470: invokespecial 115	org/json/JSONArray:<init>	()V
    //   473: astore 5
    //   475: aload 7
    //   477: invokevirtual 205	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   480: astore 6
    //   482: aload 6
    //   484: invokeinterface 210 1 0
    //   489: ifeq +65 -> 554
    //   492: new 158	org/json/JSONObject
    //   495: dup
    //   496: invokespecial 159	org/json/JSONObject:<init>	()V
    //   499: astore 8
    //   501: aload 6
    //   503: invokeinterface 214 1 0
    //   508: checkcast 173	java/lang/String
    //   511: astore 9
    //   513: aload 8
    //   515: aload 9
    //   517: new 114	org/json/JSONArray
    //   520: dup
    //   521: aload 7
    //   523: aload 9
    //   525: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   528: invokespecial 124	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   531: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   534: pop
    //   535: aload 8
    //   537: invokevirtual 201	org/json/JSONObject:length	()I
    //   540: ifle -58 -> 482
    //   543: aload 5
    //   545: aload 8
    //   547: invokevirtual 128	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   550: pop
    //   551: goto -69 -> 482
    //   554: aload 5
    //   556: invokevirtual 218	org/json/JSONArray:length	()I
    //   559: ifle +12 -> 571
    //   562: aload_1
    //   563: ldc -34
    //   565: aload 5
    //   567: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   570: pop
    //   571: aload_3
    //   572: invokevirtual 225	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   575: aload 4
    //   577: ifnull +10 -> 587
    //   580: aload 4
    //   582: invokeinterface 141 1 0
    //   587: aload_3
    //   588: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   591: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   594: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   597: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   600: return
    //   601: astore_1
    //   602: aconst_null
    //   603: astore_3
    //   604: aconst_null
    //   605: astore 4
    //   607: goto -364 -> 243
    //   610: astore_1
    //   611: aconst_null
    //   612: astore 4
    //   614: goto -371 -> 243
    //   617: astore_1
    //   618: aconst_null
    //   619: astore_1
    //   620: goto -416 -> 204
    //   623: astore_1
    //   624: aload_3
    //   625: astore_1
    //   626: goto -422 -> 204
    //   629: iload_2
    //   630: tableswitch	default:+22->652, 2049:+-492->138, 2050:+-360->270
    //   652: goto -599 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	655	0	this	w
    //   0	655	1	paramJSONObject	JSONObject
    //   79	551	2	i	int
    //   12	613	3	localSQLiteDatabase	SQLiteDatabase
    //   1	612	4	localObject1	Object
    //   24	542	5	localObject2	Object
    //   96	406	6	localObject3	Object
    //   51	471	7	localJSONObject1	JSONObject
    //   42	504	8	localJSONObject2	JSONObject
    //   114	410	9	localObject4	Object
    //   398	13	10	str	String
    // Exception table:
    //   from	to	target	type
    //   35	53	201	java/lang/Throwable
    //   53	116	201	java/lang/Throwable
    //   120	135	201	java/lang/Throwable
    //   138	180	201	java/lang/Throwable
    //   180	198	201	java/lang/Throwable
    //   230	239	201	java/lang/Throwable
    //   270	312	201	java/lang/Throwable
    //   312	330	201	java/lang/Throwable
    //   333	342	201	java/lang/Throwable
    //   345	369	201	java/lang/Throwable
    //   369	438	201	java/lang/Throwable
    //   441	458	201	java/lang/Throwable
    //   458	482	201	java/lang/Throwable
    //   482	551	201	java/lang/Throwable
    //   554	571	201	java/lang/Throwable
    //   571	575	201	java/lang/Throwable
    //   35	53	242	finally
    //   53	116	242	finally
    //   120	135	242	finally
    //   138	180	242	finally
    //   180	198	242	finally
    //   230	239	242	finally
    //   270	312	242	finally
    //   312	330	242	finally
    //   333	342	242	finally
    //   345	369	242	finally
    //   369	438	242	finally
    //   441	458	242	finally
    //   458	482	242	finally
    //   482	551	242	finally
    //   554	571	242	finally
    //   571	575	242	finally
    //   3	13	601	finally
    //   13	26	610	finally
    //   3	13	617	java/lang/Throwable
    //   13	26	623	java/lang/Throwable
  }
  
  private void b()
  {
    int i = 0;
    try
    {
      if (TextUtils.isEmpty(d))
      {
        SharedPreferences localSharedPreferences = ba.a(c);
        Object localObject2 = localSharedPreferences.getString("ek__id", null);
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = bv.A(c);
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localSharedPreferences.edit().putString("ek__id", (String)localObject2).commit();
            localObject1 = localObject2;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = ((String)localObject1).substring(1, 9);
          localObject2 = new StringBuilder();
        }
        for (;;)
        {
          if (i < ((String)localObject1).length())
          {
            char c1 = ((String)localObject1).charAt(i);
            if (Character.isDigit(c1))
            {
              if (Integer.parseInt(Character.toString(c1)) == 0) {
                ((StringBuilder)localObject2).append(0);
              } else {
                ((StringBuilder)localObject2).append(10 - Integer.parseInt(Character.toString(c1)));
              }
            }
            else {
              ((StringBuilder)localObject2).append(c1);
            }
          }
          else
          {
            d = ((StringBuilder)localObject2).toString();
            if (TextUtils.isEmpty(d)) {
              break;
            }
            d += new StringBuilder(d).reverse().toString();
            localObject1 = localSharedPreferences.getString("ek_key", null);
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localSharedPreferences.edit().putString("ek_key", a("umeng+")).commit();
              return;
            }
            if ("umeng+".equals(b((String)localObject1))) {
              break;
            }
            a(true, false);
            return;
          }
          i += 1;
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  /* Error */
  private void b(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   8: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   11: invokevirtual 151	com/umeng/analytics/pro/u:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore_2
    //   15: aload 4
    //   17: astore_3
    //   18: aload_2
    //   19: invokevirtual 154	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   22: aload 4
    //   24: astore_3
    //   25: aload_2
    //   26: ldc_w 293
    //   29: aconst_null
    //   30: invokevirtual 95	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 4
    //   35: aload 4
    //   37: ifnull +135 -> 172
    //   40: aload 4
    //   42: astore_3
    //   43: new 114	org/json/JSONArray
    //   46: dup
    //   47: invokespecial 115	org/json/JSONArray:<init>	()V
    //   50: astore 5
    //   52: aload 4
    //   54: astore_3
    //   55: aload 4
    //   57: invokeinterface 101 1 0
    //   62: ifeq +86 -> 148
    //   65: aload 4
    //   67: astore_3
    //   68: aload 4
    //   70: aload 4
    //   72: ldc_w 295
    //   75: invokeinterface 105 2 0
    //   80: invokeinterface 109 2 0
    //   85: astore 6
    //   87: aload 4
    //   89: astore_3
    //   90: aload 6
    //   92: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifne -43 -> 52
    //   98: aload 4
    //   100: astore_3
    //   101: aload 5
    //   103: new 158	org/json/JSONObject
    //   106: dup
    //   107: aload_0
    //   108: aload 6
    //   110: invokevirtual 112	com/umeng/analytics/pro/w:b	(Ljava/lang/String;)Ljava/lang/String;
    //   113: invokespecial 182	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   116: invokevirtual 128	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   119: pop
    //   120: goto -68 -> 52
    //   123: astore_1
    //   124: aload_3
    //   125: ifnull +9 -> 134
    //   128: aload_3
    //   129: invokeinterface 141 1 0
    //   134: aload_2
    //   135: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   138: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   141: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   144: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   147: return
    //   148: aload 4
    //   150: astore_3
    //   151: aload 5
    //   153: invokevirtual 218	org/json/JSONArray:length	()I
    //   156: ifle +16 -> 172
    //   159: aload 4
    //   161: astore_3
    //   162: aload_1
    //   163: ldc_w 297
    //   166: aload 5
    //   168: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: aload 4
    //   174: astore_3
    //   175: aload_2
    //   176: invokevirtual 225	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   179: aload 4
    //   181: ifnull +10 -> 191
    //   184: aload 4
    //   186: invokeinterface 141 1 0
    //   191: aload_2
    //   192: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   195: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   198: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   201: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   204: return
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_2
    //   210: aload_2
    //   211: ifnull +9 -> 220
    //   214: aload_2
    //   215: invokeinterface 141 1 0
    //   220: aload_3
    //   221: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   224: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   227: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   230: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   233: aload_1
    //   234: athrow
    //   235: astore_1
    //   236: aload_2
    //   237: astore_3
    //   238: aconst_null
    //   239: astore_2
    //   240: goto -30 -> 210
    //   243: astore_1
    //   244: aload_2
    //   245: astore_3
    //   246: aload 4
    //   248: astore_2
    //   249: goto -39 -> 210
    //   252: astore_1
    //   253: aconst_null
    //   254: astore_2
    //   255: goto -131 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	w
    //   0	258	1	paramJSONObject	JSONObject
    //   14	241	2	localObject1	Object
    //   1	245	3	localObject2	Object
    //   3	244	4	localCursor	android.database.Cursor
    //   50	117	5	localJSONArray	JSONArray
    //   85	24	6	str	String
    // Exception table:
    //   from	to	target	type
    //   18	22	123	java/lang/Throwable
    //   25	35	123	java/lang/Throwable
    //   43	52	123	java/lang/Throwable
    //   55	65	123	java/lang/Throwable
    //   68	87	123	java/lang/Throwable
    //   90	98	123	java/lang/Throwable
    //   101	120	123	java/lang/Throwable
    //   151	159	123	java/lang/Throwable
    //   162	172	123	java/lang/Throwable
    //   175	179	123	java/lang/Throwable
    //   5	15	205	finally
    //   18	22	235	finally
    //   25	35	235	finally
    //   43	52	243	finally
    //   55	65	243	finally
    //   68	87	243	finally
    //   90	98	243	finally
    //   101	120	243	finally
    //   151	159	243	finally
    //   162	172	243	finally
    //   175	179	243	finally
    //   5	15	252	java/lang/Throwable
  }
  
  /* Error */
  private void c(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore 4
    //   8: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   11: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   14: invokevirtual 151	com/umeng/analytics/pro/u:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore_2
    //   18: aload_3
    //   19: astore 4
    //   21: aload_2
    //   22: astore 5
    //   24: aload_2
    //   25: invokevirtual 154	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   28: aload_3
    //   29: astore 4
    //   31: aload_2
    //   32: astore 5
    //   34: aload_2
    //   35: ldc_w 299
    //   38: aconst_null
    //   39: invokevirtual 95	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +625 -> 669
    //   47: aload_3
    //   48: astore 4
    //   50: aload_2
    //   51: astore 5
    //   53: new 114	org/json/JSONArray
    //   56: dup
    //   57: invokespecial 115	org/json/JSONArray:<init>	()V
    //   60: astore 6
    //   62: aload_3
    //   63: astore 4
    //   65: aload_2
    //   66: astore 5
    //   68: aload_0
    //   69: getfield 46	com/umeng/analytics/pro/w:h	Ljava/util/List;
    //   72: invokeinterface 53 1 0
    //   77: aload_3
    //   78: astore 4
    //   80: aload_2
    //   81: astore 5
    //   83: aload_3
    //   84: invokeinterface 101 1 0
    //   89: ifeq +550 -> 639
    //   92: aload_3
    //   93: astore 4
    //   95: aload_2
    //   96: astore 5
    //   98: new 158	org/json/JSONObject
    //   101: dup
    //   102: invokespecial 159	org/json/JSONObject:<init>	()V
    //   105: astore 7
    //   107: aload_3
    //   108: astore 4
    //   110: aload_2
    //   111: astore 5
    //   113: aload_3
    //   114: aload_3
    //   115: ldc_w 301
    //   118: invokeinterface 105 2 0
    //   123: invokeinterface 109 2 0
    //   128: astore 8
    //   130: aload_3
    //   131: astore 4
    //   133: aload_2
    //   134: astore 5
    //   136: aload_3
    //   137: aload_3
    //   138: ldc_w 303
    //   141: invokeinterface 105 2 0
    //   146: invokeinterface 109 2 0
    //   151: astore 9
    //   153: aload_3
    //   154: astore 4
    //   156: aload_2
    //   157: astore 5
    //   159: aload 8
    //   161: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifne -87 -> 77
    //   167: aload_3
    //   168: astore 4
    //   170: aload_2
    //   171: astore 5
    //   173: aload 9
    //   175: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   178: ifne -101 -> 77
    //   181: aload_3
    //   182: astore 4
    //   184: aload_2
    //   185: astore 5
    //   187: aload 8
    //   189: invokestatic 309	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   192: aload 9
    //   194: invokestatic 309	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   197: lsub
    //   198: lconst_0
    //   199: lcmp
    //   200: ifle -123 -> 77
    //   203: aload_3
    //   204: astore 4
    //   206: aload_2
    //   207: astore 5
    //   209: aload_3
    //   210: aload_3
    //   211: ldc_w 295
    //   214: invokeinterface 105 2 0
    //   219: invokeinterface 109 2 0
    //   224: astore 10
    //   226: aload_3
    //   227: astore 4
    //   229: aload_2
    //   230: astore 5
    //   232: aload_3
    //   233: aload_3
    //   234: ldc_w 311
    //   237: invokeinterface 105 2 0
    //   242: invokeinterface 109 2 0
    //   247: astore 11
    //   249: aload_3
    //   250: astore 4
    //   252: aload_2
    //   253: astore 5
    //   255: aload_3
    //   256: aload_3
    //   257: ldc_w 313
    //   260: invokeinterface 105 2 0
    //   265: invokeinterface 109 2 0
    //   270: astore 12
    //   272: aload_3
    //   273: astore 4
    //   275: aload_2
    //   276: astore 5
    //   278: aload_3
    //   279: aload_3
    //   280: ldc_w 315
    //   283: invokeinterface 105 2 0
    //   288: invokeinterface 109 2 0
    //   293: astore 13
    //   295: aload_3
    //   296: astore 4
    //   298: aload_2
    //   299: astore 5
    //   301: aload_3
    //   302: aload_3
    //   303: ldc 81
    //   305: invokeinterface 105 2 0
    //   310: invokeinterface 109 2 0
    //   315: astore 14
    //   317: aload_3
    //   318: astore 4
    //   320: aload_2
    //   321: astore 5
    //   323: aload_0
    //   324: getfield 46	com/umeng/analytics/pro/w:h	Ljava/util/List;
    //   327: aload 14
    //   329: invokeinterface 318 2 0
    //   334: pop
    //   335: aload_3
    //   336: astore 4
    //   338: aload_2
    //   339: astore 5
    //   341: aload 7
    //   343: ldc_w 320
    //   346: aload 14
    //   348: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   351: pop
    //   352: aload_3
    //   353: astore 4
    //   355: aload_2
    //   356: astore 5
    //   358: aload 7
    //   360: ldc_w 322
    //   363: aload 9
    //   365: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   368: pop
    //   369: aload_3
    //   370: astore 4
    //   372: aload_2
    //   373: astore 5
    //   375: aload 7
    //   377: ldc_w 324
    //   380: aload 8
    //   382: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   385: pop
    //   386: aload_3
    //   387: astore 4
    //   389: aload_2
    //   390: astore 5
    //   392: aload 7
    //   394: ldc_w 326
    //   397: aload 8
    //   399: invokestatic 309	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   402: aload 9
    //   404: invokestatic 309	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   407: lsub
    //   408: invokevirtual 329	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   411: pop
    //   412: aload_3
    //   413: astore 4
    //   415: aload_2
    //   416: astore 5
    //   418: aload 10
    //   420: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   423: ifne +31 -> 454
    //   426: aload_3
    //   427: astore 4
    //   429: aload_2
    //   430: astore 5
    //   432: aload 7
    //   434: ldc_w 331
    //   437: new 114	org/json/JSONArray
    //   440: dup
    //   441: aload_0
    //   442: aload 10
    //   444: invokevirtual 112	com/umeng/analytics/pro/w:b	(Ljava/lang/String;)Ljava/lang/String;
    //   447: invokespecial 124	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   450: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   453: pop
    //   454: aload_3
    //   455: astore 4
    //   457: aload_2
    //   458: astore 5
    //   460: aload 11
    //   462: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   465: ifne +31 -> 496
    //   468: aload_3
    //   469: astore 4
    //   471: aload_2
    //   472: astore 5
    //   474: aload 7
    //   476: ldc_w 333
    //   479: new 114	org/json/JSONArray
    //   482: dup
    //   483: aload_0
    //   484: aload 11
    //   486: invokevirtual 112	com/umeng/analytics/pro/w:b	(Ljava/lang/String;)Ljava/lang/String;
    //   489: invokespecial 124	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   492: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   495: pop
    //   496: aload_3
    //   497: astore 4
    //   499: aload_2
    //   500: astore 5
    //   502: aload 12
    //   504: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   507: ifne +31 -> 538
    //   510: aload_3
    //   511: astore 4
    //   513: aload_2
    //   514: astore 5
    //   516: aload 7
    //   518: ldc_w 335
    //   521: new 158	org/json/JSONObject
    //   524: dup
    //   525: aload_0
    //   526: aload 12
    //   528: invokevirtual 112	com/umeng/analytics/pro/w:b	(Ljava/lang/String;)Ljava/lang/String;
    //   531: invokespecial 182	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   534: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   537: pop
    //   538: aload_3
    //   539: astore 4
    //   541: aload_2
    //   542: astore 5
    //   544: aload 13
    //   546: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   549: ifne +31 -> 580
    //   552: aload_3
    //   553: astore 4
    //   555: aload_2
    //   556: astore 5
    //   558: aload 7
    //   560: ldc_w 337
    //   563: new 114	org/json/JSONArray
    //   566: dup
    //   567: aload_0
    //   568: aload 13
    //   570: invokevirtual 112	com/umeng/analytics/pro/w:b	(Ljava/lang/String;)Ljava/lang/String;
    //   573: invokespecial 124	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   576: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   579: pop
    //   580: aload_3
    //   581: astore 4
    //   583: aload_2
    //   584: astore 5
    //   586: aload 7
    //   588: invokevirtual 201	org/json/JSONObject:length	()I
    //   591: ifle -514 -> 77
    //   594: aload_3
    //   595: astore 4
    //   597: aload_2
    //   598: astore 5
    //   600: aload 6
    //   602: aload 7
    //   604: invokevirtual 128	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   607: pop
    //   608: goto -531 -> 77
    //   611: astore_1
    //   612: aload 4
    //   614: ifnull +10 -> 624
    //   617: aload 4
    //   619: invokeinterface 141 1 0
    //   624: aload 5
    //   626: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   629: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   632: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   635: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   638: return
    //   639: aload_3
    //   640: astore 4
    //   642: aload_2
    //   643: astore 5
    //   645: aload 6
    //   647: invokevirtual 218	org/json/JSONArray:length	()I
    //   650: ifle +19 -> 669
    //   653: aload_3
    //   654: astore 4
    //   656: aload_2
    //   657: astore 5
    //   659: aload_1
    //   660: ldc_w 339
    //   663: aload 6
    //   665: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   668: pop
    //   669: aload_3
    //   670: astore 4
    //   672: aload_2
    //   673: astore 5
    //   675: aload_2
    //   676: invokevirtual 225	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   679: aload_3
    //   680: ifnull +9 -> 689
    //   683: aload_3
    //   684: invokeinterface 141 1 0
    //   689: aload_2
    //   690: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   693: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   696: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   699: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   702: return
    //   703: astore_1
    //   704: aconst_null
    //   705: astore_3
    //   706: aconst_null
    //   707: astore_2
    //   708: aload_2
    //   709: ifnull +9 -> 718
    //   712: aload_2
    //   713: invokeinterface 141 1 0
    //   718: aload_3
    //   719: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   722: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   725: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   728: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   731: aload_1
    //   732: athrow
    //   733: astore_1
    //   734: aload_2
    //   735: astore_3
    //   736: aconst_null
    //   737: astore_2
    //   738: goto -30 -> 708
    //   741: astore_1
    //   742: aload_2
    //   743: astore 4
    //   745: aload_3
    //   746: astore_2
    //   747: aload 4
    //   749: astore_3
    //   750: goto -42 -> 708
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	753	0	this	w
    //   0	753	1	paramJSONObject	JSONObject
    //   17	730	2	localObject1	Object
    //   4	746	3	localObject2	Object
    //   6	742	4	localObject3	Object
    //   1	673	5	localObject4	Object
    //   60	604	6	localJSONArray	JSONArray
    //   105	498	7	localJSONObject	JSONObject
    //   128	270	8	str1	String
    //   151	252	9	str2	String
    //   224	219	10	str3	String
    //   247	238	11	str4	String
    //   270	257	12	str5	String
    //   293	276	13	str6	String
    //   315	32	14	str7	String
    // Exception table:
    //   from	to	target	type
    //   8	18	611	java/lang/Throwable
    //   24	28	611	java/lang/Throwable
    //   34	43	611	java/lang/Throwable
    //   53	62	611	java/lang/Throwable
    //   68	77	611	java/lang/Throwable
    //   83	92	611	java/lang/Throwable
    //   98	107	611	java/lang/Throwable
    //   113	130	611	java/lang/Throwable
    //   136	153	611	java/lang/Throwable
    //   159	167	611	java/lang/Throwable
    //   173	181	611	java/lang/Throwable
    //   187	203	611	java/lang/Throwable
    //   209	226	611	java/lang/Throwable
    //   232	249	611	java/lang/Throwable
    //   255	272	611	java/lang/Throwable
    //   278	295	611	java/lang/Throwable
    //   301	317	611	java/lang/Throwable
    //   323	335	611	java/lang/Throwable
    //   341	352	611	java/lang/Throwable
    //   358	369	611	java/lang/Throwable
    //   375	386	611	java/lang/Throwable
    //   392	412	611	java/lang/Throwable
    //   418	426	611	java/lang/Throwable
    //   432	454	611	java/lang/Throwable
    //   460	468	611	java/lang/Throwable
    //   474	496	611	java/lang/Throwable
    //   502	510	611	java/lang/Throwable
    //   516	538	611	java/lang/Throwable
    //   544	552	611	java/lang/Throwable
    //   558	580	611	java/lang/Throwable
    //   586	594	611	java/lang/Throwable
    //   600	608	611	java/lang/Throwable
    //   645	653	611	java/lang/Throwable
    //   659	669	611	java/lang/Throwable
    //   675	679	611	java/lang/Throwable
    //   8	18	703	finally
    //   24	28	733	finally
    //   34	43	733	finally
    //   53	62	741	finally
    //   68	77	741	finally
    //   83	92	741	finally
    //   98	107	741	finally
    //   113	130	741	finally
    //   136	153	741	finally
    //   159	167	741	finally
    //   173	181	741	finally
    //   187	203	741	finally
    //   209	226	741	finally
    //   232	249	741	finally
    //   255	272	741	finally
    //   278	295	741	finally
    //   301	317	741	finally
    //   323	335	741	finally
    //   341	352	741	finally
    //   358	369	741	finally
    //   375	386	741	finally
    //   392	412	741	finally
    //   418	426	741	finally
    //   432	454	741	finally
    //   460	468	741	finally
    //   474	496	741	finally
    //   502	510	741	finally
    //   516	538	741	finally
    //   544	552	741	finally
    //   558	580	741	finally
    //   586	594	741	finally
    //   600	608	741	finally
    //   645	653	741	finally
    //   659	669	741	finally
    //   675	679	741	finally
  }
  
  public String a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(d)) {
        return paramString;
      }
      paramString = Base64.encodeToString(bt.a(paramString.getBytes(), d.getBytes()), 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    c(localJSONObject2);
    b(localJSONObject2);
    a(localJSONObject2);
    try
    {
      if (localJSONObject2.length() > 0) {
        localJSONObject1.put("body", localJSONObject2);
      }
      return localJSONObject1;
    }
    catch (Throwable localThrowable) {}
    return localJSONObject1;
  }
  
  public void a(JSONArray paramJSONArray)
  {
    localObject = null;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = u.a(c).a();
        localObject = localSQLiteDatabase;
      }
      catch (Throwable paramJSONArray)
      {
        int i;
        int j;
        JSONObject localJSONObject;
        ContentValues localContentValues;
        String str2;
        String str1;
        paramJSONArray = paramJSONArray;
        ((SQLiteDatabase)localObject).endTransaction();
        u.a(c).b();
        return;
      }
      finally
      {
        paramJSONArray = finally;
        SQLiteDatabase localSQLiteDatabase = null;
        localSQLiteDatabase.endTransaction();
        u.a(c).b();
        throw paramJSONArray;
      }
      try
      {
        localSQLiteDatabase.beginTransaction();
        i = 0;
        localObject = localSQLiteDatabase;
        j = paramJSONArray.length();
        if (i < j) {
          localObject = localSQLiteDatabase;
        }
      }
      finally
      {
        continue;
      }
      try
      {
        localJSONObject = paramJSONArray.getJSONObject(i);
        localObject = localSQLiteDatabase;
        localContentValues = new ContentValues();
        localObject = localSQLiteDatabase;
        str2 = localJSONObject.optString("__i");
        str1 = str2;
        localObject = localSQLiteDatabase;
        if (TextUtils.isEmpty(str2))
        {
          localObject = localSQLiteDatabase;
          str2 = bd.g(c);
          str1 = str2;
          localObject = localSQLiteDatabase;
          if (TextUtils.isEmpty(str2)) {
            str1 = "";
          }
        }
        localObject = localSQLiteDatabase;
        localContentValues.put("__i", str1);
        localObject = localSQLiteDatabase;
        localContentValues.put("__e", localJSONObject.optString("id"));
        localObject = localSQLiteDatabase;
        localContentValues.put("__t", Integer.valueOf(localJSONObject.optInt("__t")));
        localObject = localSQLiteDatabase;
        localJSONObject.remove("__i");
        localObject = localSQLiteDatabase;
        localJSONObject.remove("__t");
        localObject = localSQLiteDatabase;
        localContentValues.put("__s", a(localJSONObject.toString()));
        localObject = localSQLiteDatabase;
        localSQLiteDatabase.insert("__et", null, localContentValues);
      }
      catch (Exception localException)
      {
        continue;
      }
      i += 1;
    }
    localObject = localSQLiteDatabase;
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
    u.a(c).b();
  }
  
  /* Error */
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   6: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   9: invokevirtual 151	com/umeng/analytics/pro/u:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 5
    //   14: aload 5
    //   16: astore 4
    //   18: aload 4
    //   20: invokevirtual 154	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   23: aload 4
    //   25: ldc_w 401
    //   28: invokevirtual 138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   31: aload 4
    //   33: ldc_w 403
    //   36: invokevirtual 138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   39: iload_2
    //   40: ifeq +35 -> 75
    //   43: iload_1
    //   44: ifeq +11 -> 55
    //   47: aload 4
    //   49: ldc_w 405
    //   52: invokevirtual 138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   55: aload 4
    //   57: invokevirtual 225	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   60: aload 4
    //   62: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   65: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   68: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   71: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   74: return
    //   75: aload_0
    //   76: getfield 46	com/umeng/analytics/pro/w:h	Ljava/util/List;
    //   79: invokeinterface 408 1 0
    //   84: ifle +67 -> 151
    //   87: iconst_0
    //   88: istore_3
    //   89: iload_3
    //   90: aload_0
    //   91: getfield 46	com/umeng/analytics/pro/w:h	Ljava/util/List;
    //   94: invokeinterface 408 1 0
    //   99: if_icmpge +52 -> 151
    //   102: aload 4
    //   104: new 66	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 410
    //   114: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_0
    //   118: getfield 46	com/umeng/analytics/pro/w:h	Ljava/util/List;
    //   121: iload_3
    //   122: invokeinterface 414 2 0
    //   127: checkcast 173	java/lang/String
    //   130: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 85
    //   135: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokevirtual 138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   144: iload_3
    //   145: iconst_1
    //   146: iadd
    //   147: istore_3
    //   148: goto -59 -> 89
    //   151: aload_0
    //   152: getfield 46	com/umeng/analytics/pro/w:h	Ljava/util/List;
    //   155: invokeinterface 53 1 0
    //   160: goto -105 -> 55
    //   163: astore 5
    //   165: aload 4
    //   167: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   170: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   173: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   176: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   179: return
    //   180: astore 4
    //   182: aconst_null
    //   183: astore 6
    //   185: aload 4
    //   187: astore 5
    //   189: aload 6
    //   191: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   194: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   197: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   200: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   203: aload 5
    //   205: athrow
    //   206: astore 5
    //   208: aload 4
    //   210: astore 6
    //   212: goto -23 -> 189
    //   215: astore 5
    //   217: goto -52 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	w
    //   0	220	1	paramBoolean1	boolean
    //   0	220	2	paramBoolean2	boolean
    //   88	60	3	i	int
    //   1	165	4	localObject1	Object
    //   180	29	4	localObject2	Object
    //   12	3	5	localSQLiteDatabase	SQLiteDatabase
    //   163	1	5	localThrowable1	Throwable
    //   187	17	5	localObject3	Object
    //   206	1	5	localObject4	Object
    //   215	1	5	localThrowable2	Throwable
    //   183	28	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   18	39	163	java/lang/Throwable
    //   47	55	163	java/lang/Throwable
    //   55	60	163	java/lang/Throwable
    //   75	87	163	java/lang/Throwable
    //   89	144	163	java/lang/Throwable
    //   151	160	163	java/lang/Throwable
    //   3	14	180	finally
    //   18	39	206	finally
    //   47	55	206	finally
    //   55	60	206	finally
    //   75	87	206	finally
    //   89	144	206	finally
    //   151	160	206	finally
    //   3	14	215	java/lang/Throwable
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = u.a(c).a();
      localObject = localSQLiteDatabase;
      ContentValues localContentValues;
      localSQLiteDatabase.endTransaction();
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        try
        {
          localSQLiteDatabase.beginTransaction();
          localObject = localSQLiteDatabase;
          localContentValues = new ContentValues();
          localObject = localSQLiteDatabase;
          localContentValues.put("__i", paramString1);
          localObject = localSQLiteDatabase;
          paramString1 = a(paramString2);
          localObject = localSQLiteDatabase;
          if (!TextUtils.isEmpty(paramString1))
          {
            localObject = localSQLiteDatabase;
            localContentValues.put("__a", paramString1);
            localObject = localSQLiteDatabase;
            localContentValues.put("__t", Integer.valueOf(paramInt));
            localObject = localSQLiteDatabase;
            localSQLiteDatabase.insert("__er", null, localContentValues);
          }
          localObject = localSQLiteDatabase;
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          u.a(c).b();
          return false;
        }
        finally
        {
          continue;
        }
        paramString1 = paramString1;
        ((SQLiteDatabase)localObject).endTransaction();
        u.a(c).b();
      }
    }
    finally
    {
      paramString1 = finally;
      localSQLiteDatabase = null;
    }
    u.a(c).b();
    throw paramString1;
  }
  
  /* Error */
  public boolean a(String paramString, JSONObject paramJSONObject, a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 9
    //   9: aload_2
    //   10: ifnonnull +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   18: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   21: invokevirtual 151	com/umeng/analytics/pro/u:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore 8
    //   26: aload 8
    //   28: astore 6
    //   30: aload 6
    //   32: invokevirtual 154	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   35: aload_3
    //   36: getstatic 421	com/umeng/analytics/pro/w$a:c	Lcom/umeng/analytics/pro/w$a;
    //   39: if_acmpne +94 -> 133
    //   42: aload_2
    //   43: ldc_w 303
    //   46: invokevirtual 423	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   49: checkcast 305	java/lang/Long
    //   52: invokevirtual 427	java/lang/Long:longValue	()J
    //   55: lstore 4
    //   57: new 372	android/content/ContentValues
    //   60: dup
    //   61: invokespecial 373	android/content/ContentValues:<init>	()V
    //   64: astore_2
    //   65: aload_2
    //   66: ldc 81
    //   68: aload_1
    //   69: invokevirtual 378	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_2
    //   73: ldc_w 303
    //   76: lload 4
    //   78: invokestatic 430	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   81: invokevirtual 378	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload 6
    //   86: ldc 77
    //   88: aconst_null
    //   89: aload_2
    //   90: invokevirtual 399	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   93: pop2
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: astore 8
    //   99: aload_1
    //   100: astore 7
    //   102: aload 6
    //   104: invokevirtual 225	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   107: aload_1
    //   108: ifnull +9 -> 117
    //   111: aload_1
    //   112: invokeinterface 141 1 0
    //   117: aload 6
    //   119: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   122: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   125: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   128: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   131: iconst_0
    //   132: ireturn
    //   133: aload_3
    //   134: getstatic 432	com/umeng/analytics/pro/w$a:d	Lcom/umeng/analytics/pro/w$a;
    //   137: if_acmpne +73 -> 210
    //   140: aload_2
    //   141: ldc_w 301
    //   144: invokevirtual 423	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   147: checkcast 305	java/lang/Long
    //   150: invokevirtual 427	java/lang/Long:longValue	()J
    //   153: lstore 4
    //   155: aload 6
    //   157: new 66	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   164: ldc_w 434
    //   167: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: lload 4
    //   172: invokevirtual 437	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   175: ldc -121
    //   177: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc 81
    //   182: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 83
    //   187: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_1
    //   191: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc 85
    //   196: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokevirtual 138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   205: aconst_null
    //   206: astore_1
    //   207: goto -111 -> 96
    //   210: aload_3
    //   211: getstatic 439	com/umeng/analytics/pro/w$a:b	Lcom/umeng/analytics/pro/w$a;
    //   214: if_acmpne +19 -> 233
    //   217: aload_0
    //   218: aload_1
    //   219: aload_2
    //   220: aload 6
    //   222: ldc_w 295
    //   225: invokespecial 441	com/umeng/analytics/pro/w:a	(Ljava/lang/String;Lorg/json/JSONObject;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   228: aconst_null
    //   229: astore_1
    //   230: goto -134 -> 96
    //   233: aload_3
    //   234: getstatic 443	com/umeng/analytics/pro/w$a:a	Lcom/umeng/analytics/pro/w$a;
    //   237: if_acmpne +19 -> 256
    //   240: aload_0
    //   241: aload_1
    //   242: aload_2
    //   243: aload 6
    //   245: ldc_w 311
    //   248: invokespecial 441	com/umeng/analytics/pro/w:a	(Ljava/lang/String;Lorg/json/JSONObject;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   251: aconst_null
    //   252: astore_1
    //   253: goto -157 -> 96
    //   256: getstatic 445	com/umeng/analytics/pro/w$a:e	Lcom/umeng/analytics/pro/w$a;
    //   259: astore 8
    //   261: aload_3
    //   262: aload 8
    //   264: if_acmpne +571 -> 835
    //   267: aload_2
    //   268: ldc_w 315
    //   271: invokevirtual 448	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   274: astore 10
    //   276: aload 10
    //   278: ifnull +549 -> 827
    //   281: aload 6
    //   283: new 66	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   290: ldc_w 450
    //   293: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_1
    //   297: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc 85
    //   302: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: aconst_null
    //   309: invokevirtual 95	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   312: astore_3
    //   313: aload_3
    //   314: ifnull +507 -> 821
    //   317: aload_3
    //   318: astore 8
    //   320: aload_3
    //   321: astore 7
    //   323: aload_3
    //   324: invokeinterface 101 1 0
    //   329: ifeq +40 -> 369
    //   332: aload_3
    //   333: astore 8
    //   335: aload_3
    //   336: astore 7
    //   338: aload_0
    //   339: aload_3
    //   340: aload_3
    //   341: ldc_w 315
    //   344: invokeinterface 105 2 0
    //   349: invokeinterface 109 2 0
    //   354: invokevirtual 112	com/umeng/analytics/pro/w:b	(Ljava/lang/String;)Ljava/lang/String;
    //   357: astore 9
    //   359: goto -42 -> 317
    //   362: astore_3
    //   363: aconst_null
    //   364: astore 10
    //   366: goto -90 -> 276
    //   369: aload 10
    //   371: ifnull +150 -> 521
    //   374: aload_3
    //   375: astore 8
    //   377: aload_3
    //   378: astore 7
    //   380: new 114	org/json/JSONArray
    //   383: dup
    //   384: invokespecial 115	org/json/JSONArray:<init>	()V
    //   387: astore 11
    //   389: aload_3
    //   390: astore 8
    //   392: aload_3
    //   393: astore 7
    //   395: aload 9
    //   397: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   400: ifne +20 -> 420
    //   403: aload_3
    //   404: astore 8
    //   406: aload_3
    //   407: astore 7
    //   409: new 114	org/json/JSONArray
    //   412: dup
    //   413: aload 9
    //   415: invokespecial 124	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   418: astore 11
    //   420: aload_3
    //   421: astore 8
    //   423: aload_3
    //   424: astore 7
    //   426: aload 11
    //   428: aload 10
    //   430: invokevirtual 128	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   433: pop
    //   434: aload_3
    //   435: astore 8
    //   437: aload_3
    //   438: astore 7
    //   440: aload_0
    //   441: aload 11
    //   443: invokevirtual 129	org/json/JSONArray:toString	()Ljava/lang/String;
    //   446: invokevirtual 131	com/umeng/analytics/pro/w:a	(Ljava/lang/String;)Ljava/lang/String;
    //   449: astore 9
    //   451: aload_3
    //   452: astore 8
    //   454: aload_3
    //   455: astore 7
    //   457: aload 9
    //   459: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   462: ifne +59 -> 521
    //   465: aload_3
    //   466: astore 8
    //   468: aload_3
    //   469: astore 7
    //   471: aload 6
    //   473: new 66	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   480: ldc_w 452
    //   483: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 9
    //   488: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc -121
    //   493: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc 81
    //   498: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: ldc 83
    //   503: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: aload_1
    //   507: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: ldc 85
    //   512: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokevirtual 138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   521: aload_3
    //   522: astore 8
    //   524: aload_3
    //   525: astore 7
    //   527: aload_2
    //   528: ldc_w 313
    //   531: invokevirtual 448	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   534: astore 9
    //   536: aload 9
    //   538: ifnull +90 -> 628
    //   541: aload_3
    //   542: astore 8
    //   544: aload_3
    //   545: astore 7
    //   547: aload_0
    //   548: aload 9
    //   550: invokevirtual 393	org/json/JSONObject:toString	()Ljava/lang/String;
    //   553: invokevirtual 131	com/umeng/analytics/pro/w:a	(Ljava/lang/String;)Ljava/lang/String;
    //   556: astore 9
    //   558: aload_3
    //   559: astore 8
    //   561: aload_3
    //   562: astore 7
    //   564: aload 9
    //   566: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   569: ifne +59 -> 628
    //   572: aload_3
    //   573: astore 8
    //   575: aload_3
    //   576: astore 7
    //   578: aload 6
    //   580: new 66	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 454
    //   590: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload 9
    //   595: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: ldc -121
    //   600: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: ldc 81
    //   605: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: ldc 83
    //   610: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload_1
    //   614: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: ldc 85
    //   619: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokevirtual 138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   628: aload_3
    //   629: astore 8
    //   631: aload_3
    //   632: astore 7
    //   634: aload_2
    //   635: ldc_w 301
    //   638: invokevirtual 457	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   641: lstore 4
    //   643: aload_3
    //   644: astore 8
    //   646: aload_3
    //   647: astore 7
    //   649: aload 6
    //   651: new 66	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   658: ldc_w 459
    //   661: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: lload 4
    //   666: invokestatic 430	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   669: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: ldc -121
    //   674: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: ldc 81
    //   679: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: ldc 83
    //   684: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload_1
    //   688: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: ldc 85
    //   693: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokevirtual 138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   702: aload_3
    //   703: astore_1
    //   704: goto -608 -> 96
    //   707: astore_1
    //   708: aload_3
    //   709: astore_1
    //   710: goto -614 -> 96
    //   713: astore_1
    //   714: aconst_null
    //   715: astore 7
    //   717: aload 6
    //   719: astore_1
    //   720: aload 7
    //   722: ifnull +10 -> 732
    //   725: aload 7
    //   727: invokeinterface 141 1 0
    //   732: aload_1
    //   733: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   736: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   739: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   742: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   745: iconst_0
    //   746: ireturn
    //   747: astore_1
    //   748: aconst_null
    //   749: astore 6
    //   751: aload 7
    //   753: astore_2
    //   754: aload_2
    //   755: ifnull +9 -> 764
    //   758: aload_2
    //   759: invokeinterface 141 1 0
    //   764: aload 6
    //   766: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   769: getstatic 35	com/umeng/analytics/pro/w:c	Landroid/content/Context;
    //   772: invokestatic 148	com/umeng/analytics/pro/u:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/u;
    //   775: invokevirtual 197	com/umeng/analytics/pro/u:b	()V
    //   778: aload_1
    //   779: athrow
    //   780: astore_1
    //   781: aload 7
    //   783: astore_2
    //   784: goto -30 -> 754
    //   787: astore_1
    //   788: aload 8
    //   790: astore_2
    //   791: goto -37 -> 754
    //   794: astore_1
    //   795: aconst_null
    //   796: astore 7
    //   798: aload 6
    //   800: astore_1
    //   801: goto -81 -> 720
    //   804: astore_1
    //   805: aload 6
    //   807: astore_1
    //   808: goto -88 -> 720
    //   811: astore 7
    //   813: goto -185 -> 628
    //   816: astore 7
    //   818: goto -297 -> 521
    //   821: aconst_null
    //   822: astore 9
    //   824: goto -455 -> 369
    //   827: aconst_null
    //   828: astore 9
    //   830: aconst_null
    //   831: astore_3
    //   832: goto -463 -> 369
    //   835: aconst_null
    //   836: astore_1
    //   837: goto -741 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	840	0	this	w
    //   0	840	1	paramString	String
    //   0	840	2	paramJSONObject	JSONObject
    //   0	840	3	parama	a
    //   55	610	4	l	long
    //   1	805	6	localObject1	Object
    //   4	793	7	localObject2	Object
    //   811	1	7	localException1	Exception
    //   816	1	7	localException2	Exception
    //   24	765	8	localObject3	Object
    //   7	822	9	localObject4	Object
    //   274	155	10	localJSONObject	JSONObject
    //   387	55	11	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   267	276	362	java/lang/Exception
    //   634	643	707	java/lang/Exception
    //   649	702	707	java/lang/Exception
    //   15	26	713	java/lang/Throwable
    //   15	26	747	finally
    //   30	94	780	finally
    //   133	205	780	finally
    //   210	228	780	finally
    //   233	251	780	finally
    //   256	261	780	finally
    //   267	276	780	finally
    //   281	313	780	finally
    //   102	107	787	finally
    //   323	332	787	finally
    //   338	359	787	finally
    //   380	389	787	finally
    //   395	403	787	finally
    //   409	420	787	finally
    //   426	434	787	finally
    //   440	451	787	finally
    //   457	465	787	finally
    //   471	521	787	finally
    //   527	536	787	finally
    //   547	558	787	finally
    //   564	572	787	finally
    //   578	628	787	finally
    //   634	643	787	finally
    //   649	702	787	finally
    //   30	94	794	java/lang/Throwable
    //   133	205	794	java/lang/Throwable
    //   210	228	794	java/lang/Throwable
    //   233	251	794	java/lang/Throwable
    //   256	261	794	java/lang/Throwable
    //   267	276	794	java/lang/Throwable
    //   281	313	794	java/lang/Throwable
    //   102	107	804	java/lang/Throwable
    //   323	332	804	java/lang/Throwable
    //   338	359	804	java/lang/Throwable
    //   380	389	804	java/lang/Throwable
    //   395	403	804	java/lang/Throwable
    //   409	420	804	java/lang/Throwable
    //   426	434	804	java/lang/Throwable
    //   440	451	804	java/lang/Throwable
    //   457	465	804	java/lang/Throwable
    //   471	521	804	java/lang/Throwable
    //   527	536	804	java/lang/Throwable
    //   547	558	804	java/lang/Throwable
    //   564	572	804	java/lang/Throwable
    //   578	628	804	java/lang/Throwable
    //   634	643	804	java/lang/Throwable
    //   649	702	804	java/lang/Throwable
    //   527	536	811	java/lang/Exception
    //   547	558	811	java/lang/Exception
    //   564	572	811	java/lang/Exception
    //   578	628	811	java/lang/Exception
    //   380	389	816	java/lang/Exception
    //   395	403	816	java/lang/Exception
    //   409	420	816	java/lang/Exception
    //   426	434	816	java/lang/Exception
    //   440	451	816	java/lang/Exception
    //   457	465	816	java/lang/Exception
    //   471	521	816	java/lang/Exception
  }
  
  public String b(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(d)) {
        return paramString;
      }
      paramString = new String(bt.b(Base64.decode(paramString.getBytes(), 0), d.getBytes()));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static enum a
  {
    private a() {}
  }
  
  private static class b
  {
    private static final w a = new w(null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */