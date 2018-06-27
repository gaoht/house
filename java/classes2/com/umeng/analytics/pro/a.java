package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.Map;

public class a
{
  private static ContentValues a(i parami)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", parami.a());
    localContentValues.put("label", parami.c());
    localContentValues.put("count", Long.valueOf(parami.g()));
    localContentValues.put("value", Long.valueOf(parami.f()));
    localContentValues.put("totalTimestamp", Long.valueOf(parami.e()));
    localContentValues.put("timeWindowNum", parami.h());
    return localContentValues;
  }
  
  /* Error */
  public static String a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 68	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   4: aload_0
    //   5: ldc 70
    //   7: invokestatic 73	com/umeng/analytics/pro/a:c	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   10: ifgt +24 -> 34
    //   13: iconst_0
    //   14: ifeq +11 -> 25
    //   17: new 75	java/lang/NullPointerException
    //   20: dup
    //   21: invokespecial 76	java/lang/NullPointerException:<init>	()V
    //   24: athrow
    //   25: aload_0
    //   26: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   29: iconst_0
    //   30: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   33: areturn
    //   34: aload_0
    //   35: ldc 86
    //   37: aconst_null
    //   38: invokevirtual 90	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore_1
    //   42: aload_1
    //   43: astore_2
    //   44: aload_1
    //   45: invokeinterface 96 1 0
    //   50: ifeq +127 -> 177
    //   53: aload_1
    //   54: astore_2
    //   55: aload_1
    //   56: aload_1
    //   57: ldc 57
    //   59: invokeinterface 100 2 0
    //   64: invokeinterface 103 2 0
    //   69: astore_3
    //   70: aload_1
    //   71: astore_2
    //   72: aload_0
    //   73: invokevirtual 106	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   76: aload_1
    //   77: ifnull +9 -> 86
    //   80: aload_1
    //   81: invokeinterface 109 1 0
    //   86: aload_0
    //   87: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   90: aload_3
    //   91: areturn
    //   92: astore 4
    //   94: aconst_null
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_1
    //   99: astore_2
    //   100: new 111	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   107: ldc 114
    //   109: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 4
    //   114: invokevirtual 121	android/database/SQLException:toString	()Ljava/lang/String;
    //   117: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 127	com/umeng/analytics/pro/by:e	(Ljava/lang/String;)V
    //   126: aload_1
    //   127: ifnull +9 -> 136
    //   130: aload_1
    //   131: invokeinterface 109 1 0
    //   136: aload_0
    //   137: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   140: aload_3
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 109 1 0
    //   155: aload_0
    //   156: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_1
    //   162: goto -17 -> 145
    //   165: astore 4
    //   167: aconst_null
    //   168: astore_3
    //   169: goto -71 -> 98
    //   172: astore 4
    //   174: goto -76 -> 98
    //   177: aconst_null
    //   178: astore_3
    //   179: goto -109 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramSQLiteDatabase	SQLiteDatabase
    //   41	90	1	localCursor1	Cursor
    //   142	18	1	localObject1	Object
    //   161	1	1	localObject2	Object
    //   43	107	2	localCursor2	Cursor
    //   69	110	3	str	String
    //   92	21	4	localSQLException1	SQLException
    //   165	1	4	localSQLException2	SQLException
    //   172	1	4	localSQLException3	SQLException
    // Exception table:
    //   from	to	target	type
    //   0	13	92	android/database/SQLException
    //   34	42	92	android/database/SQLException
    //   0	13	142	finally
    //   34	42	142	finally
    //   44	53	161	finally
    //   55	70	161	finally
    //   72	76	161	finally
    //   100	126	161	finally
    //   44	53	165	android/database/SQLException
    //   55	70	165	android/database/SQLException
    //   72	76	172	android/database/SQLException
  }
  
  /* Error */
  public static org.json.JSONObject a(f paramf, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: new 132	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 133	org/json/JSONObject:<init>	()V
    //   7: astore 4
    //   9: aload_1
    //   10: ldc -121
    //   12: invokestatic 73	com/umeng/analytics/pro/a:c	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   15: ifle +194 -> 209
    //   18: aload_1
    //   19: ldc -119
    //   21: aconst_null
    //   22: invokevirtual 90	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_1
    //   26: aload_1
    //   27: invokeinterface 140 1 0
    //   32: istore_2
    //   33: aload_1
    //   34: astore_3
    //   35: iload_2
    //   36: ifeq +175 -> 211
    //   39: aload_1
    //   40: aload_1
    //   41: ldc 16
    //   43: invokeinterface 100 2 0
    //   48: invokeinterface 103 2 0
    //   53: astore 5
    //   55: aload 4
    //   57: aload 5
    //   59: invokevirtual 144	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   62: ifeq +91 -> 153
    //   65: aload 4
    //   67: aload 5
    //   69: invokevirtual 148	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   72: astore_3
    //   73: aload 4
    //   75: aload 5
    //   77: invokevirtual 152	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   80: pop
    //   81: new 132	org/json/JSONObject
    //   84: dup
    //   85: invokespecial 133	org/json/JSONObject:<init>	()V
    //   88: astore 6
    //   90: aload 6
    //   92: ldc 47
    //   94: aload_1
    //   95: aload_1
    //   96: ldc 32
    //   98: invokeinterface 100 2 0
    //   103: invokeinterface 156 2 0
    //   108: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload 6
    //   114: ldc -95
    //   116: aload_1
    //   117: aload_1
    //   118: ldc -93
    //   120: invokeinterface 100 2 0
    //   125: invokeinterface 167 2 0
    //   130: invokevirtual 170	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   133: pop
    //   134: aload_3
    //   135: aload 6
    //   137: invokevirtual 175	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   140: pop
    //   141: aload 4
    //   143: aload 5
    //   145: aload_3
    //   146: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   149: pop
    //   150: goto -124 -> 26
    //   153: new 172	org/json/JSONArray
    //   156: dup
    //   157: invokespecial 179	org/json/JSONArray:<init>	()V
    //   160: astore_3
    //   161: goto -80 -> 81
    //   164: astore_3
    //   165: aload_0
    //   166: ldc -75
    //   168: iconst_0
    //   169: invokevirtual 186	com/umeng/analytics/pro/f:a	(Ljava/lang/Object;Z)V
    //   172: new 111	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   179: ldc -68
    //   181: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_3
    //   185: invokevirtual 121	android/database/SQLException:toString	()Ljava/lang/String;
    //   188: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 127	com/umeng/analytics/pro/by:e	(Ljava/lang/String;)V
    //   197: aload_1
    //   198: ifnull +9 -> 207
    //   201: aload_1
    //   202: invokeinterface 109 1 0
    //   207: aconst_null
    //   208: areturn
    //   209: aconst_null
    //   210: astore_3
    //   211: aload_3
    //   212: ifnull +9 -> 221
    //   215: aload_3
    //   216: invokeinterface 109 1 0
    //   221: aload 4
    //   223: areturn
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_1
    //   227: aload_1
    //   228: ifnull +9 -> 237
    //   231: aload_1
    //   232: invokeinterface 109 1 0
    //   237: aload_0
    //   238: athrow
    //   239: astore_0
    //   240: goto -13 -> 227
    //   243: astore_0
    //   244: goto -17 -> 227
    //   247: astore_3
    //   248: aconst_null
    //   249: astore_1
    //   250: goto -85 -> 165
    //   253: astore_3
    //   254: goto -228 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramf	f
    //   0	257	1	paramSQLiteDatabase	SQLiteDatabase
    //   32	4	2	bool	boolean
    //   34	127	3	localObject1	Object
    //   164	21	3	localSQLException1	SQLException
    //   210	6	3	localObject2	Object
    //   247	1	3	localSQLException2	SQLException
    //   253	1	3	localException	Exception
    //   7	215	4	localJSONObject1	org.json.JSONObject
    //   53	91	5	str	String
    //   88	48	6	localJSONObject2	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   26	33	164	android/database/SQLException
    //   39	81	164	android/database/SQLException
    //   81	150	164	android/database/SQLException
    //   153	161	164	android/database/SQLException
    //   0	26	224	finally
    //   26	33	239	finally
    //   39	81	239	finally
    //   81	150	239	finally
    //   153	161	239	finally
    //   165	197	243	finally
    //   0	26	247	android/database/SQLException
    //   39	81	253	java/lang/Exception
    //   81	150	253	java/lang/Exception
    //   153	161	253	java/lang/Exception
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      int i = c(paramSQLiteDatabase, "system");
      int j = n.a().c();
      if (i < j)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("key", paramString);
        localContentValues.put("timeStamp", Long.valueOf(paramLong2));
        localContentValues.put("count", Long.valueOf(paramLong1));
        paramSQLiteDatabase.insert("system", null, localContentValues);
        return;
      }
      if (i == j)
      {
        paramString = new ContentValues();
        paramString.put("key", "__meta_ve_of");
        paramString.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        paramString.put("count", Integer.valueOf(1));
        paramSQLiteDatabase.insert("system", null, paramString);
        return;
      }
      d(paramSQLiteDatabase, "__meta_ve_of");
      return;
    }
    catch (SQLException paramSQLiteDatabase) {}
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, Map<String, k> paramMap, f paramf)
  {
    i = 0;
    localContentValues = null;
    Object localObject3 = null;
    localObject2 = localObject3;
    localObject1 = localContentValues;
    try
    {
      localk = (k)paramMap.get("__ag_of");
      if (localk != null) {
        break label47;
      }
      if (0 != 0) {
        throw new NullPointerException();
      }
    }
    catch (SQLException paramSQLiteDatabase)
    {
      k localk;
      long l1;
      localObject1 = localObject2;
      by.e("save to system table error " + paramSQLiteDatabase.toString());
      return;
      localObject2 = paramMap;
      localObject1 = paramMap;
      localContentValues = new ContentValues();
      localObject2 = paramMap;
      localObject1 = paramMap;
      localContentValues.put("key", localk.c());
      if (i != 0) {
        break label410;
      }
      localObject2 = paramMap;
      localObject1 = paramMap;
      long l3;
      for (long l2 = localk.e();; l2 = l3 + l2)
      {
        localObject2 = paramMap;
        localObject1 = paramMap;
        localContentValues.put("count", Long.valueOf(l2));
        l2 = l1;
        if (l1 == 0L)
        {
          localObject2 = paramMap;
          localObject1 = paramMap;
          l2 = localk.d();
        }
        localObject2 = paramMap;
        localObject1 = paramMap;
        localContentValues.put("timeStamp", Long.valueOf(l2));
        localObject2 = paramMap;
        localObject1 = paramMap;
        paramSQLiteDatabase.insert("system", null, localContentValues);
        localObject2 = paramMap;
        localObject1 = paramMap;
        paramf.a("success", false);
        if (paramMap == null) {
          break;
        }
        paramMap.close();
        return;
        l3 = i;
        localObject2 = paramMap;
        localObject1 = paramMap;
        l2 = localk.e();
      }
    }
    finally
    {
      if (localObject1 == null) {
        break label450;
      }
      ((Cursor)localObject1).close();
    }
    return;
    label47:
    localObject2 = localObject3;
    localObject1 = localContentValues;
    paramMap = paramSQLiteDatabase.rawQuery("select * from " + "system where key=\"__ag_of\"", null);
    localObject2 = paramMap;
    localObject1 = paramMap;
    paramMap.moveToFirst();
    l1 = 0L;
    for (;;)
    {
      localObject2 = paramMap;
      localObject1 = paramMap;
      if (paramMap.isAfterLast()) {
        break;
      }
      localObject2 = paramMap;
      localObject1 = paramMap;
      if (paramMap.getCount() > 0)
      {
        localObject2 = paramMap;
        localObject1 = paramMap;
        i = paramMap.getInt(paramMap.getColumnIndex("count"));
        localObject2 = paramMap;
        localObject1 = paramMap;
        l1 = paramMap.getLong(paramMap.getColumnIndex("timeStamp"));
        localObject2 = paramMap;
        localObject1 = paramMap;
        paramSQLiteDatabase.execSQL("delete from " + "system where key=\"__ag_of\"");
      }
      localObject2 = paramMap;
      localObject1 = paramMap;
      paramMap.moveToNext();
    }
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, f paramf)
  {
    b(paramSQLiteDatabase, "system");
    b(paramSQLiteDatabase, "aggregated");
    if (!paramBoolean)
    {
      b(paramSQLiteDatabase, "limitedck");
      paramf.a("success", false);
    }
  }
  
  /* Error */
  public static void a(f paramf, SQLiteDatabase paramSQLiteDatabase, java.util.List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 68	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   4: aload_1
    //   5: ldc_w 268
    //   8: invokestatic 73	com/umeng/analytics/pro/a:c	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   11: ifle +11 -> 22
    //   14: aload_1
    //   15: ldc_w 268
    //   18: invokestatic 264	com/umeng/analytics/pro/a:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   21: pop
    //   22: aload_2
    //   23: invokeinterface 275 1 0
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 280 1 0
    //   35: ifeq +77 -> 112
    //   38: aload_2
    //   39: invokeinterface 284 1 0
    //   44: checkcast 81	java/lang/String
    //   47: astore_3
    //   48: new 13	android/content/ContentValues
    //   51: dup
    //   52: invokespecial 14	android/content/ContentValues:<init>	()V
    //   55: astore 4
    //   57: aload 4
    //   59: ldc_w 286
    //   62: aload_3
    //   63: invokevirtual 25	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_1
    //   67: ldc_w 268
    //   70: aconst_null
    //   71: aload 4
    //   73: invokevirtual 201	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   76: pop2
    //   77: goto -48 -> 29
    //   80: astore_0
    //   81: new 111	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 288
    //   91: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: invokevirtual 121	android/database/SQLException:toString	()Ljava/lang/String;
    //   98: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 127	com/umeng/analytics/pro/by:e	(Ljava/lang/String;)V
    //   107: aload_1
    //   108: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   111: return
    //   112: aload_1
    //   113: invokevirtual 106	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   116: aload_0
    //   117: ldc_w 257
    //   120: iconst_0
    //   121: invokevirtual 186	com/umeng/analytics/pro/f:a	(Ljava/lang/Object;Z)V
    //   124: aload_1
    //   125: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   128: return
    //   129: astore_0
    //   130: aload_1
    //   131: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   134: aload_0
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramf	f
    //   0	136	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	136	2	paramList	java.util.List<String>
    //   47	16	3	str	String
    //   55	17	4	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   0	22	80	android/database/SQLException
    //   22	29	80	android/database/SQLException
    //   29	77	80	android/database/SQLException
    //   112	124	80	android/database/SQLException
    //   0	22	129	finally
    //   22	29	129	finally
    //   29	77	129	finally
    //   81	107	129	finally
    //   112	124	129	finally
  }
  
  public static boolean a(SQLiteDatabase paramSQLiteDatabase, f paramf)
  {
    try
    {
      paramSQLiteDatabase.beginTransaction();
      if (c(paramSQLiteDatabase, "aggregated_cache") <= 0)
      {
        paramf.a("faild", false);
        return false;
      }
      paramSQLiteDatabase.execSQL("insert into aggregated(key, count, value, totalTimestamp, timeWindowNum, label) select key, count, value, totalTimestamp, timeWindowNum, label from aggregated_cache");
      paramSQLiteDatabase.setTransactionSuccessful();
      b(paramSQLiteDatabase, "aggregated_cache");
      paramf.a("success", false);
      return true;
    }
    catch (SQLException localSQLException)
    {
      paramf.a(Boolean.valueOf(false), false);
      by.e("cacheToAggregatedTable happen " + localSQLException.toString());
      return false;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public static boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      paramSQLiteDatabase.execSQL("drop table if exists " + paramString);
      return true;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      by.e("delete table faild!");
      paramSQLiteDatabase.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static boolean a(SQLiteDatabase paramSQLiteDatabase, java.util.Collection<i> paramCollection)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 68	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   4: aload_0
    //   5: ldc 70
    //   7: invokestatic 73	com/umeng/analytics/pro/a:c	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   10: ifle +10 -> 20
    //   13: aload_0
    //   14: ldc 70
    //   16: invokestatic 264	com/umeng/analytics/pro/a:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   19: pop
    //   20: aload_1
    //   21: invokeinterface 310 1 0
    //   26: astore_1
    //   27: aload_1
    //   28: invokeinterface 280 1 0
    //   33: ifeq +39 -> 72
    //   36: aload_0
    //   37: ldc 70
    //   39: aconst_null
    //   40: aload_1
    //   41: invokeinterface 284 1 0
    //   46: checkcast 18	com/umeng/analytics/pro/i
    //   49: invokestatic 312	com/umeng/analytics/pro/a:a	(Lcom/umeng/analytics/pro/i;)Landroid/content/ContentValues;
    //   52: invokevirtual 201	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   55: pop2
    //   56: goto -29 -> 27
    //   59: astore_1
    //   60: ldc_w 314
    //   63: invokestatic 127	com/umeng/analytics/pro/by:e	(Ljava/lang/String;)V
    //   66: aload_0
    //   67: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   70: iconst_0
    //   71: ireturn
    //   72: aload_0
    //   73: invokevirtual 106	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   76: aload_0
    //   77: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   80: iconst_1
    //   81: ireturn
    //   82: astore_1
    //   83: aload_0
    //   84: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	89	1	paramCollection	java.util.Collection<i>
    // Exception table:
    //   from	to	target	type
    //   0	20	59	android/database/SQLException
    //   20	27	59	android/database/SQLException
    //   27	56	59	android/database/SQLException
    //   72	76	59	android/database/SQLException
    //   0	20	82	finally
    //   20	27	82	finally
    //   27	56	82	finally
    //   60	66	82	finally
    //   72	76	82	finally
  }
  
  /* Error */
  public static boolean a(f paramf, SQLiteDatabase paramSQLiteDatabase, java.util.Collection<i> paramCollection)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 68	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   4: aload_2
    //   5: invokeinterface 310 1 0
    //   10: astore_2
    //   11: aload_2
    //   12: invokeinterface 280 1 0
    //   17: ifeq +40 -> 57
    //   20: aload_1
    //   21: ldc_w 266
    //   24: aconst_null
    //   25: aload_2
    //   26: invokeinterface 284 1 0
    //   31: checkcast 18	com/umeng/analytics/pro/i
    //   34: invokestatic 312	com/umeng/analytics/pro/a:a	(Lcom/umeng/analytics/pro/i;)Landroid/content/ContentValues;
    //   37: invokevirtual 201	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   40: pop2
    //   41: goto -30 -> 11
    //   44: astore_0
    //   45: ldc_w 314
    //   48: invokestatic 127	com/umeng/analytics/pro/by:e	(Ljava/lang/String;)V
    //   51: aload_1
    //   52: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   55: iconst_0
    //   56: ireturn
    //   57: aload_1
    //   58: invokevirtual 106	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   61: aload_1
    //   62: ldc 70
    //   64: invokestatic 264	com/umeng/analytics/pro/a:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   67: pop
    //   68: aload_0
    //   69: ldc_w 257
    //   72: iconst_0
    //   73: invokevirtual 186	com/umeng/analytics/pro/f:a	(Ljava/lang/Object;Z)V
    //   76: aload_1
    //   77: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   80: iconst_1
    //   81: ireturn
    //   82: astore_0
    //   83: aload_1
    //   84: invokevirtual 79	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   87: aload_0
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramf	f
    //   0	89	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	89	2	paramCollection	java.util.Collection<i>
    // Exception table:
    //   from	to	target	type
    //   0	11	44	android/database/SQLException
    //   11	41	44	android/database/SQLException
    //   57	76	44	android/database/SQLException
    //   0	11	82	finally
    //   11	41	82	finally
    //   45	51	82	finally
    //   57	76	82	finally
  }
  
  /* Error */
  public static org.json.JSONObject b(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 266
    //   4: invokestatic 73	com/umeng/analytics/pro/a:c	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   7: ifle +322 -> 329
    //   10: aload_0
    //   11: ldc_w 320
    //   14: aconst_null
    //   15: invokevirtual 90	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore_2
    //   19: aload_2
    //   20: astore_0
    //   21: new 132	org/json/JSONObject
    //   24: dup
    //   25: invokespecial 133	org/json/JSONObject:<init>	()V
    //   28: astore 4
    //   30: aload_2
    //   31: astore_0
    //   32: aload_2
    //   33: invokeinterface 140 1 0
    //   38: istore_1
    //   39: iload_1
    //   40: ifeq +273 -> 313
    //   43: aload_2
    //   44: astore_0
    //   45: aload_2
    //   46: aload_2
    //   47: ldc 16
    //   49: invokeinterface 100 2 0
    //   54: invokeinterface 103 2 0
    //   59: astore 5
    //   61: aload_2
    //   62: astore_0
    //   63: aload 4
    //   65: aload 5
    //   67: invokevirtual 144	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   70: ifeq +187 -> 257
    //   73: aload_2
    //   74: astore_0
    //   75: aload 4
    //   77: aload 5
    //   79: invokevirtual 148	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   82: astore_3
    //   83: aload_2
    //   84: astore_0
    //   85: aload 4
    //   87: aload 5
    //   89: invokevirtual 152	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   92: pop
    //   93: aload_2
    //   94: astore_0
    //   95: new 132	org/json/JSONObject
    //   98: dup
    //   99: invokespecial 133	org/json/JSONObject:<init>	()V
    //   102: astore 6
    //   104: aload_2
    //   105: astore_0
    //   106: aload 6
    //   108: ldc_w 322
    //   111: aload_2
    //   112: aload_2
    //   113: ldc 47
    //   115: invokeinterface 100 2 0
    //   120: invokeinterface 167 2 0
    //   125: invokevirtual 170	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   128: pop
    //   129: aload_2
    //   130: astore_0
    //   131: aload 6
    //   133: ldc_w 324
    //   136: aload_2
    //   137: aload_2
    //   138: ldc 52
    //   140: invokeinterface 100 2 0
    //   145: invokeinterface 167 2 0
    //   150: invokevirtual 170	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   153: pop
    //   154: aload_2
    //   155: astore_0
    //   156: aload 6
    //   158: ldc_w 326
    //   161: aload_2
    //   162: aload_2
    //   163: ldc 57
    //   165: invokeinterface 100 2 0
    //   170: invokeinterface 103 2 0
    //   175: invokestatic 329	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   178: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   181: pop
    //   182: aload_2
    //   183: astore_0
    //   184: aload 6
    //   186: ldc 32
    //   188: aload_2
    //   189: aload_2
    //   190: ldc 32
    //   192: invokeinterface 100 2 0
    //   197: invokeinterface 156 2 0
    //   202: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   205: pop
    //   206: aload_2
    //   207: astore_0
    //   208: aload 6
    //   210: ldc_w 331
    //   213: aload_2
    //   214: aload_2
    //   215: ldc 27
    //   217: invokeinterface 100 2 0
    //   222: invokeinterface 103 2 0
    //   227: invokestatic 335	com/umeng/analytics/pro/d:a	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   230: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   233: pop
    //   234: aload_2
    //   235: astore_0
    //   236: aload_3
    //   237: aload 6
    //   239: invokevirtual 175	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   242: pop
    //   243: aload_2
    //   244: astore_0
    //   245: aload 4
    //   247: aload 5
    //   249: aload_3
    //   250: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   253: pop
    //   254: goto -224 -> 30
    //   257: aload_2
    //   258: astore_0
    //   259: new 172	org/json/JSONArray
    //   262: dup
    //   263: invokespecial 179	org/json/JSONArray:<init>	()V
    //   266: astore_3
    //   267: goto -174 -> 93
    //   270: astore_3
    //   271: aload_2
    //   272: astore_0
    //   273: new 111	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 337
    //   283: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_3
    //   287: invokevirtual 121	android/database/SQLException:toString	()Ljava/lang/String;
    //   290: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 127	com/umeng/analytics/pro/by:e	(Ljava/lang/String;)V
    //   299: aload_2
    //   300: ifnull +9 -> 309
    //   303: aload_2
    //   304: invokeinterface 109 1 0
    //   309: aconst_null
    //   310: astore_0
    //   311: aload_0
    //   312: areturn
    //   313: aload 4
    //   315: astore_0
    //   316: aload_2
    //   317: ifnull -6 -> 311
    //   320: aload_2
    //   321: invokeinterface 109 1 0
    //   326: aload 4
    //   328: areturn
    //   329: iconst_0
    //   330: ifeq -21 -> 309
    //   333: new 75	java/lang/NullPointerException
    //   336: dup
    //   337: invokespecial 76	java/lang/NullPointerException:<init>	()V
    //   340: athrow
    //   341: astore_2
    //   342: aconst_null
    //   343: astore_0
    //   344: aload_0
    //   345: ifnull +9 -> 354
    //   348: aload_0
    //   349: invokeinterface 109 1 0
    //   354: aload_2
    //   355: athrow
    //   356: astore_2
    //   357: goto -13 -> 344
    //   360: astore_3
    //   361: aconst_null
    //   362: astore_2
    //   363: goto -92 -> 271
    //   366: astore_0
    //   367: goto -337 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramSQLiteDatabase	SQLiteDatabase
    //   38	2	1	bool	boolean
    //   18	303	2	localCursor	Cursor
    //   341	14	2	localObject1	Object
    //   356	1	2	localObject2	Object
    //   362	1	2	localObject3	Object
    //   82	185	3	localJSONArray	org.json.JSONArray
    //   270	17	3	localSQLException1	SQLException
    //   360	1	3	localSQLException2	SQLException
    //   28	299	4	localJSONObject1	org.json.JSONObject
    //   59	189	5	str	String
    //   102	136	6	localJSONObject2	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   21	30	270	android/database/SQLException
    //   32	39	270	android/database/SQLException
    //   45	61	270	android/database/SQLException
    //   63	73	270	android/database/SQLException
    //   75	83	270	android/database/SQLException
    //   85	93	270	android/database/SQLException
    //   95	104	270	android/database/SQLException
    //   106	129	270	android/database/SQLException
    //   131	154	270	android/database/SQLException
    //   156	182	270	android/database/SQLException
    //   184	206	270	android/database/SQLException
    //   208	234	270	android/database/SQLException
    //   236	243	270	android/database/SQLException
    //   245	254	270	android/database/SQLException
    //   259	267	270	android/database/SQLException
    //   0	19	341	finally
    //   21	30	356	finally
    //   32	39	356	finally
    //   45	61	356	finally
    //   63	73	356	finally
    //   75	83	356	finally
    //   85	93	356	finally
    //   95	104	356	finally
    //   106	129	356	finally
    //   131	154	356	finally
    //   156	182	356	finally
    //   184	206	356	finally
    //   208	234	356	finally
    //   236	243	356	finally
    //   245	254	356	finally
    //   259	267	356	finally
    //   273	299	356	finally
    //   0	19	360	android/database/SQLException
    //   45	61	366	java/lang/Exception
    //   63	73	366	java/lang/Exception
    //   75	83	366	java/lang/Exception
    //   85	93	366	java/lang/Exception
    //   95	104	366	java/lang/Exception
    //   106	129	366	java/lang/Exception
    //   131	154	366	java/lang/Exception
    //   156	182	366	java/lang/Exception
    //   184	206	366	java/lang/Exception
    //   208	234	366	java/lang/Exception
    //   236	243	366	java/lang/Exception
    //   245	254	366	java/lang/Exception
    //   259	267	366	java/lang/Exception
  }
  
  /* Error */
  public static boolean b(SQLiteDatabase paramSQLiteDatabase, f paramf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_3
    //   9: aload 5
    //   11: astore_2
    //   12: new 339	java/util/HashMap
    //   15: dup
    //   16: invokespecial 340	java/util/HashMap:<init>	()V
    //   19: astore 6
    //   21: aload 4
    //   23: astore_3
    //   24: aload 5
    //   26: astore_2
    //   27: aload_0
    //   28: ldc 86
    //   30: aconst_null
    //   31: invokevirtual 90	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_0
    //   35: aload_0
    //   36: astore_3
    //   37: aload_0
    //   38: astore_2
    //   39: aload_0
    //   40: invokeinterface 140 1 0
    //   45: ifeq +251 -> 296
    //   48: aload_0
    //   49: astore_3
    //   50: aload_0
    //   51: astore_2
    //   52: new 18	com/umeng/analytics/pro/i
    //   55: dup
    //   56: invokespecial 341	com/umeng/analytics/pro/i:<init>	()V
    //   59: astore 4
    //   61: aload_0
    //   62: astore_3
    //   63: aload_0
    //   64: astore_2
    //   65: aload 4
    //   67: aload_0
    //   68: aload_0
    //   69: ldc 16
    //   71: invokeinterface 100 2 0
    //   76: invokeinterface 103 2 0
    //   81: invokestatic 344	com/umeng/analytics/pro/d:b	(Ljava/lang/String;)Ljava/util/List;
    //   84: invokevirtual 347	com/umeng/analytics/pro/i:a	(Ljava/util/List;)V
    //   87: aload_0
    //   88: astore_3
    //   89: aload_0
    //   90: astore_2
    //   91: aload 4
    //   93: aload_0
    //   94: aload_0
    //   95: ldc 27
    //   97: invokeinterface 100 2 0
    //   102: invokeinterface 103 2 0
    //   107: invokestatic 344	com/umeng/analytics/pro/d:b	(Ljava/lang/String;)Ljava/util/List;
    //   110: invokevirtual 349	com/umeng/analytics/pro/i:b	(Ljava/util/List;)V
    //   113: aload_0
    //   114: astore_3
    //   115: aload_0
    //   116: astore_2
    //   117: aload 4
    //   119: aload_0
    //   120: aload_0
    //   121: ldc 32
    //   123: invokeinterface 100 2 0
    //   128: invokeinterface 156 2 0
    //   133: i2l
    //   134: invokevirtual 352	com/umeng/analytics/pro/i:c	(J)V
    //   137: aload_0
    //   138: astore_3
    //   139: aload_0
    //   140: astore_2
    //   141: aload 4
    //   143: aload_0
    //   144: aload_0
    //   145: ldc 47
    //   147: invokeinterface 100 2 0
    //   152: invokeinterface 156 2 0
    //   157: i2l
    //   158: invokevirtual 354	com/umeng/analytics/pro/i:b	(J)V
    //   161: aload_0
    //   162: astore_3
    //   163: aload_0
    //   164: astore_2
    //   165: aload 4
    //   167: aload_0
    //   168: aload_0
    //   169: ldc 57
    //   171: invokeinterface 100 2 0
    //   176: invokeinterface 103 2 0
    //   181: invokevirtual 356	com/umeng/analytics/pro/i:b	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: astore_3
    //   186: aload_0
    //   187: astore_2
    //   188: aload 4
    //   190: aload_0
    //   191: aload_0
    //   192: ldc 52
    //   194: invokeinterface 100 2 0
    //   199: invokeinterface 103 2 0
    //   204: invokestatic 360	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   207: invokevirtual 362	com/umeng/analytics/pro/i:a	(J)V
    //   210: aload_0
    //   211: astore_3
    //   212: aload_0
    //   213: astore_2
    //   214: aload 6
    //   216: aload_0
    //   217: aload_0
    //   218: ldc 16
    //   220: invokeinterface 100 2 0
    //   225: invokeinterface 103 2 0
    //   230: invokestatic 344	com/umeng/analytics/pro/d:b	(Ljava/lang/String;)Ljava/util/List;
    //   233: aload 4
    //   235: invokeinterface 365 3 0
    //   240: pop
    //   241: goto -206 -> 35
    //   244: astore_0
    //   245: aload_3
    //   246: astore_2
    //   247: aload_1
    //   248: iconst_0
    //   249: invokestatic 297	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   252: iconst_0
    //   253: invokevirtual 186	com/umeng/analytics/pro/f:a	(Ljava/lang/Object;Z)V
    //   256: aload_3
    //   257: astore_2
    //   258: new 111	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 367
    //   268: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_0
    //   272: invokevirtual 121	android/database/SQLException:toString	()Ljava/lang/String;
    //   275: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 127	com/umeng/analytics/pro/by:e	(Ljava/lang/String;)V
    //   284: aload_3
    //   285: ifnull +9 -> 294
    //   288: aload_3
    //   289: invokeinterface 109 1 0
    //   294: iconst_0
    //   295: ireturn
    //   296: aload_0
    //   297: astore_3
    //   298: aload_0
    //   299: astore_2
    //   300: aload 6
    //   302: invokeinterface 370 1 0
    //   307: ifle +26 -> 333
    //   310: aload_0
    //   311: astore_3
    //   312: aload_0
    //   313: astore_2
    //   314: aload_1
    //   315: aload 6
    //   317: iconst_0
    //   318: invokevirtual 186	com/umeng/analytics/pro/f:a	(Ljava/lang/Object;Z)V
    //   321: aload_0
    //   322: ifnull -28 -> 294
    //   325: aload_0
    //   326: invokeinterface 109 1 0
    //   331: iconst_0
    //   332: ireturn
    //   333: aload_0
    //   334: astore_3
    //   335: aload_0
    //   336: astore_2
    //   337: aload_1
    //   338: ldc -75
    //   340: iconst_0
    //   341: invokevirtual 186	com/umeng/analytics/pro/f:a	(Ljava/lang/Object;Z)V
    //   344: goto -23 -> 321
    //   347: astore_0
    //   348: aload_2
    //   349: ifnull +9 -> 358
    //   352: aload_2
    //   353: invokeinterface 109 1 0
    //   358: aload_0
    //   359: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	360	1	paramf	f
    //   11	342	2	localObject1	Object
    //   8	327	3	localObject2	Object
    //   4	230	4	locali	i
    //   1	24	5	localObject3	Object
    //   19	297	6	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   12	21	244	android/database/SQLException
    //   27	35	244	android/database/SQLException
    //   39	48	244	android/database/SQLException
    //   52	61	244	android/database/SQLException
    //   65	87	244	android/database/SQLException
    //   91	113	244	android/database/SQLException
    //   117	137	244	android/database/SQLException
    //   141	161	244	android/database/SQLException
    //   165	184	244	android/database/SQLException
    //   188	210	244	android/database/SQLException
    //   214	241	244	android/database/SQLException
    //   300	310	244	android/database/SQLException
    //   314	321	244	android/database/SQLException
    //   337	344	244	android/database/SQLException
    //   12	21	347	finally
    //   27	35	347	finally
    //   39	48	347	finally
    //   52	61	347	finally
    //   65	87	347	finally
    //   91	113	347	finally
    //   117	137	347	finally
    //   141	161	347	finally
    //   165	184	347	finally
    //   188	210	347	finally
    //   214	241	347	finally
    //   247	256	347	finally
    //   258	284	347	finally
    //   300	310	347	finally
    //   314	321	347	finally
    //   337	344	347	finally
  }
  
  public static boolean b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      if (c(paramSQLiteDatabase, paramString) >= 0) {
        paramSQLiteDatabase.execSQL("delete from " + paramString);
      }
      return true;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      by.e("cleanTableData faild!" + paramSQLiteDatabase.toString());
    }
    return false;
  }
  
  public static int c(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    localObject = null;
    localSQLiteDatabase = null;
    int j = 0;
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from " + paramString, null);
      localSQLiteDatabase = paramSQLiteDatabase;
      localObject = paramSQLiteDatabase;
      int i = paramSQLiteDatabase.getCount();
      j = i;
      if (paramSQLiteDatabase != null)
      {
        paramSQLiteDatabase.close();
        j = i;
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      do
      {
        localObject = localSQLiteDatabase;
        by.e("count error " + paramSQLiteDatabase.toString());
      } while (localSQLiteDatabase == null);
      localSQLiteDatabase.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label120;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  /* Error */
  public static java.util.List<String> c(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 268
    //   4: invokestatic 73	com/umeng/analytics/pro/a:c	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   7: ifle +117 -> 124
    //   10: aload_0
    //   11: ldc_w 378
    //   14: aconst_null
    //   15: invokevirtual 90	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore_1
    //   19: aload_1
    //   20: astore_0
    //   21: new 380	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 381	java/util/ArrayList:<init>	()V
    //   28: astore_2
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: invokeinterface 140 1 0
    //   37: ifeq +73 -> 110
    //   40: aload_1
    //   41: astore_0
    //   42: aload_2
    //   43: aload_1
    //   44: aload_1
    //   45: ldc_w 286
    //   48: invokeinterface 100 2 0
    //   53: invokeinterface 103 2 0
    //   58: invokeinterface 385 2 0
    //   63: pop
    //   64: goto -35 -> 29
    //   67: astore_2
    //   68: aload_1
    //   69: astore_0
    //   70: new 111	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 387
    //   80: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_2
    //   84: invokevirtual 121	android/database/SQLException:toString	()Ljava/lang/String;
    //   87: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 127	com/umeng/analytics/pro/by:e	(Ljava/lang/String;)V
    //   96: aload_1
    //   97: ifnull +9 -> 106
    //   100: aload_1
    //   101: invokeinterface 109 1 0
    //   106: aconst_null
    //   107: astore_0
    //   108: aload_0
    //   109: areturn
    //   110: aload_2
    //   111: astore_0
    //   112: aload_1
    //   113: ifnull -5 -> 108
    //   116: aload_1
    //   117: invokeinterface 109 1 0
    //   122: aload_2
    //   123: areturn
    //   124: iconst_0
    //   125: ifeq -19 -> 106
    //   128: new 75	java/lang/NullPointerException
    //   131: dup
    //   132: invokespecial 76	java/lang/NullPointerException:<init>	()V
    //   135: athrow
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_0
    //   140: ifnull +9 -> 149
    //   143: aload_0
    //   144: invokeinterface 109 1 0
    //   149: aload_1
    //   150: athrow
    //   151: astore_1
    //   152: goto -13 -> 139
    //   155: astore_2
    //   156: aconst_null
    //   157: astore_1
    //   158: goto -90 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramSQLiteDatabase	SQLiteDatabase
    //   18	99	1	localCursor	Cursor
    //   136	14	1	localObject1	Object
    //   151	1	1	localObject2	Object
    //   157	1	1	localObject3	Object
    //   28	15	2	localArrayList	java.util.ArrayList
    //   67	56	2	localSQLException1	SQLException
    //   155	1	2	localSQLException2	SQLException
    // Exception table:
    //   from	to	target	type
    //   21	29	67	android/database/SQLException
    //   31	40	67	android/database/SQLException
    //   42	64	67	android/database/SQLException
    //   0	19	136	finally
    //   21	29	151	finally
    //   31	40	151	finally
    //   42	64	151	finally
    //   70	96	151	finally
    //   0	19	155	android/database/SQLException
  }
  
  private static void d(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("update system set count=count+1 where key like '" + paramString + "'");
      paramSQLiteDatabase.setTransactionSuccessful();
      if (paramSQLiteDatabase != null) {
        paramSQLiteDatabase.endTransaction();
      }
      return;
    }
    catch (SQLException paramString)
    {
      do
      {
        paramString = paramString;
      } while (paramSQLiteDatabase == null);
      paramSQLiteDatabase.endTransaction();
      return;
    }
    finally
    {
      paramString = finally;
      if (paramSQLiteDatabase != null) {
        paramSQLiteDatabase.endTransaction();
      }
      throw paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */