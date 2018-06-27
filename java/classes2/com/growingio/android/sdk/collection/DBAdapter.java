package com.growingio.android.sdk.collection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.growingio.android.sdk.utils.Util;
import java.util.LinkedList;
import java.util.List;

class DBAdapter
{
  private static DBAdapter b = null;
  private static final Object c = new Object();
  private static final String d = "CREATE TABLE " + Table.a.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "eventType" + " STRING NOT NULL," + "data" + " STRING NOT NULL," + "createdAt" + " INTEGER NOT NULL," + "instant" + " INTEGER NOT NULL DEFAULT 0);CREATE INDEX IF NOT EXISTS instant_idx ON " + Table.a.a() + " (" + "instant" + ");CREATE INDEX IF NOT EXISTS time_idx ON " + Table.a.a() + " (" + "createdAt" + ");";
  private static final String e = "ALTER TABLE " + Table.a.a() + " ADD COLUMN " + "instant" + " BOOLEAN DEFAULT 0;CREATE INDEX IF NOT EXISTS instant_idx ON " + Table.a + " (" + "instant" + ");DROP INDEX time_idx;";
  private static final String f = "UPDATE " + Table.a + " SET " + "instant" + " = 1 WHERE " + "eventType" + " != 'imp';";
  private static final String g = "DROP TABLE IF EXISTS " + Table.a.a();
  private final DBHelper a;
  private Runnable h = new Runnable()
  {
    public void run()
    {
      try
      {
        DBAdapter.a(DBAdapter.this).getReadableDatabase().close();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  };
  
  DBAdapter(Context paramContext)
  {
    this.a = new DBHelper(paramContext);
    AppState.l().p();
  }
  
  static DBAdapter a()
  {
    return b;
  }
  
  static void a(Context paramContext)
  {
    if (b != null) {
      return;
    }
    synchronized (c)
    {
      b = new DBAdapter(paramContext);
      return;
    }
  }
  
  private Pair<String, List<String>> b(String paramString, String[] paramArrayOfString)
  {
    LinkedList localLinkedList;
    synchronized (c)
    {
      paramArrayOfString = this.a.getReadableDatabase().rawQuery(paramString, paramArrayOfString);
      localLinkedList = new LinkedList();
      paramString = null;
      if (paramArrayOfString.moveToNext())
      {
        if (paramArrayOfString.isLast()) {
          paramString = paramArrayOfString.getString(paramArrayOfString.getColumnIndex("_id"));
        }
        localLinkedList.add(paramArrayOfString.getString(paramArrayOfString.getColumnIndex("data")));
      }
    }
    paramArrayOfString.close();
    f();
    if ((localLinkedList.size() > 0) && (paramString != null))
    {
      paramString = new Pair(paramString, localLinkedList);
      return paramString;
    }
    return null;
  }
  
  private void f()
  {
    MessageProcessor localMessageProcessor = MessageProcessor.e();
    if (localMessageProcessor != null)
    {
      localMessageProcessor.c().removeCallbacks(this.h);
      localMessageProcessor.c().postDelayed(this.h, 20000L);
    }
  }
  
  long a(MessageUploader.UPLOAD_TYPE paramUPLOAD_TYPE, String paramString)
  {
    if (GrowingIO.testHandler != null) {
      Util.a(GrowingIO.testHandler, 2097156, new Object[] { paramUPLOAD_TYPE.name(), paramString });
    }
    switch (2.a[paramUPLOAD_TYPE.ordinal()])
    {
    default: 
      return 0L;
    case 1: 
      return a(String.format("_id <= ? AND %s = ?", new Object[] { "eventType" }), new String[] { paramString, "cstm" });
    case 2: 
      return a(String.format("_id <= ? AND (%s = ? OR %s = ?)", new Object[] { "eventType", "eventType" }), new String[] { paramString, "page", "vst" });
    case 3: 
      return a(String.format("_id <= ? AND %s = 1 AND (%s = ? OR %s = ? OR %s = ?)", new Object[] { "instant", "eventType", "eventType", "eventType" }), new String[] { paramString, "imp", "clck", "chng" });
    }
    return a(String.format("_id <= ? AND %s = 0 AND (%s = ? OR %s = ? OR %s = ?)", new Object[] { "instant", "eventType", "eventType", "eventType" }), new String[] { paramString, "imp", "clck", "chng" });
  }
  
  /* Error */
  long a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: getstatic 212	com/growingio/android/sdk/collection/GrowingIO:testHandler	Landroid/os/Handler;
    //   3: ifnull +23 -> 26
    //   6: getstatic 212	com/growingio/android/sdk/collection/GrowingIO:testHandler	Landroid/os/Handler;
    //   9: ldc -43
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_2
    //   22: aastore
    //   23: invokestatic 223	com/growingio/android/sdk/utils/Util:a	(Landroid/os/Handler;I[Ljava/lang/Object;)V
    //   26: getstatic 36	com/growingio/android/sdk/collection/DBAdapter:c	Ljava/lang/Object;
    //   29: astore 10
    //   31: aload 10
    //   33: monitorenter
    //   34: aconst_null
    //   35: astore 9
    //   37: aconst_null
    //   38: astore 8
    //   40: aload_0
    //   41: getfield 117	com/growingio/android/sdk/collection/DBAdapter:a	Lcom/growingio/android/sdk/collection/DBAdapter$DBHelper;
    //   44: invokevirtual 267	com/growingio/android/sdk/collection/DBAdapter$DBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   47: astore 6
    //   49: aload 6
    //   51: astore 8
    //   53: aload 6
    //   55: astore 9
    //   57: aload 6
    //   59: astore 7
    //   61: aload 6
    //   63: getstatic 48	com/growingio/android/sdk/collection/DBAdapter$Table:a	Lcom/growingio/android/sdk/collection/DBAdapter$Table;
    //   66: invokevirtual 51	com/growingio/android/sdk/collection/DBAdapter$Table:a	()Ljava/lang/String;
    //   69: aload_1
    //   70: aload_2
    //   71: invokevirtual 271	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   74: istore_3
    //   75: aload 6
    //   77: ifnull +142 -> 219
    //   80: aload_0
    //   81: invokespecial 175	com/growingio/android/sdk/collection/DBAdapter:f	()V
    //   84: iload_3
    //   85: i2l
    //   86: lstore 4
    //   88: aload 10
    //   90: monitorexit
    //   91: lload 4
    //   93: lreturn
    //   94: astore_1
    //   95: aload 8
    //   97: astore 7
    //   99: ldc_w 273
    //   102: invokestatic 278	com/growingio/android/sdk/collection/DiagnoseLog:a	(Ljava/lang/String;)V
    //   105: aload 8
    //   107: ifnull +107 -> 214
    //   110: aload_0
    //   111: invokespecial 175	com/growingio/android/sdk/collection/DBAdapter:f	()V
    //   114: iconst_0
    //   115: istore_3
    //   116: goto -32 -> 84
    //   119: astore_1
    //   120: aload 9
    //   122: astore 7
    //   124: ldc_w 280
    //   127: invokestatic 278	com/growingio/android/sdk/collection/DiagnoseLog:a	(Ljava/lang/String;)V
    //   130: aload 9
    //   132: ifnull +82 -> 214
    //   135: aload_0
    //   136: invokespecial 175	com/growingio/android/sdk/collection/DBAdapter:f	()V
    //   139: iconst_0
    //   140: istore_3
    //   141: goto -57 -> 84
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_2
    //   148: invokevirtual 284	java/lang/Object:getClass	()Ljava/lang/Class;
    //   151: invokevirtual 289	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   154: invokestatic 278	com/growingio/android/sdk/collection/DiagnoseLog:a	(Ljava/lang/String;)V
    //   157: getstatic 295	com/growingio/android/sdk/collection/GConfig:DEBUG	Z
    //   160: ifeq +7 -> 167
    //   163: aload_2
    //   164: invokevirtual 298	java/lang/Exception:printStackTrace	()V
    //   167: aload_1
    //   168: ifnull +46 -> 214
    //   171: aload_0
    //   172: invokespecial 175	com/growingio/android/sdk/collection/DBAdapter:f	()V
    //   175: iconst_0
    //   176: istore_3
    //   177: goto -93 -> 84
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_0
    //   185: invokespecial 175	com/growingio/android/sdk/collection/DBAdapter:f	()V
    //   188: aload_2
    //   189: athrow
    //   190: astore_1
    //   191: aload 10
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    //   196: astore_2
    //   197: aload 7
    //   199: astore_1
    //   200: goto -20 -> 180
    //   203: astore_2
    //   204: goto -24 -> 180
    //   207: astore_2
    //   208: aload 6
    //   210: astore_1
    //   211: goto -64 -> 147
    //   214: iconst_0
    //   215: istore_3
    //   216: goto -132 -> 84
    //   219: goto -135 -> 84
    //   222: astore_2
    //   223: aconst_null
    //   224: astore_1
    //   225: goto -45 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	DBAdapter
    //   0	228	1	paramString	String
    //   0	228	2	paramArrayOfString	String[]
    //   74	142	3	i	int
    //   86	6	4	l	long
    //   47	162	6	localSQLiteDatabase	SQLiteDatabase
    //   59	139	7	localObject1	Object
    //   38	68	8	localObject2	Object
    //   35	96	9	localObject3	Object
    //   29	163	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   40	49	94	android/database/sqlite/SQLiteDiskIOException
    //   61	75	94	android/database/sqlite/SQLiteDiskIOException
    //   40	49	119	android/database/SQLException
    //   61	75	119	android/database/SQLException
    //   40	49	144	java/lang/Exception
    //   80	84	190	finally
    //   88	91	190	finally
    //   110	114	190	finally
    //   135	139	190	finally
    //   171	175	190	finally
    //   184	188	190	finally
    //   188	190	190	finally
    //   191	194	190	finally
    //   61	75	196	finally
    //   99	105	196	finally
    //   124	130	196	finally
    //   147	167	203	finally
    //   61	75	207	java/lang/Exception
    //   40	49	222	finally
  }
  
  Pair<String, List<String>> a(MessageUploader.UPLOAD_TYPE paramUPLOAD_TYPE)
  {
    if (GrowingIO.testHandler != null) {
      Util.a(GrowingIO.testHandler, 2097157, new Object[] { paramUPLOAD_TYPE.name() });
    }
    switch (2.a[paramUPLOAD_TYPE.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return b(String.format("SELECT _id, %s FROM %s WHERE %s = '%s' ORDER BY _id LIMIT 50 ", new Object[] { "data", Table.a, "eventType", "cstm" }), null);
    case 2: 
      return b(String.format("SELECT _id, %s FROM %s WHERE %s = '%s' OR %s = '%s' ORDER BY _id LIMIT 50 ", new Object[] { "data", Table.a, "eventType", "page", "eventType", "vst" }), null);
    case 3: 
      return b(String.format("SELECT _id, %s FROM %s WHERE %s = 1 AND ( %s = '%s' OR %s = '%s' OR %s = '%s') ORDER BY _id LIMIT 50 ", new Object[] { "data", Table.a, "instant", "eventType", "clck", "eventType", "imp", "eventType", "chng" }), null);
    }
    return b(String.format("SELECT _id, %s FROM %s WHERE %s = 0 AND ( %s = '%s' OR %s = '%s' OR %s = '%s') ORDER BY _id LIMIT 50 ", new Object[] { "data", Table.a, "instant", "eventType", "clck", "eventType", "imp", "eventType", "chng" }), null);
  }
  
  /* Error */
  void a(long paramLong)
  {
    // Byte code:
    //   0: getstatic 212	com/growingio/android/sdk/collection/GrowingIO:testHandler	Landroid/os/Handler;
    //   3: ifnull +22 -> 25
    //   6: getstatic 212	com/growingio/android/sdk/collection/GrowingIO:testHandler	Landroid/os/Handler;
    //   9: ldc -43
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: lload_1
    //   18: invokestatic 318	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   21: aastore
    //   22: invokestatic 223	com/growingio/android/sdk/utils/Util:a	(Landroid/os/Handler;I[Ljava/lang/Object;)V
    //   25: getstatic 36	com/growingio/android/sdk/collection/DBAdapter:c	Ljava/lang/Object;
    //   28: astore 7
    //   30: aload 7
    //   32: monitorenter
    //   33: aconst_null
    //   34: astore 6
    //   36: aconst_null
    //   37: astore 5
    //   39: aload_0
    //   40: getfield 117	com/growingio/android/sdk/collection/DBAdapter:a	Lcom/growingio/android/sdk/collection/DBAdapter$DBHelper;
    //   43: invokevirtual 267	com/growingio/android/sdk/collection/DBAdapter$DBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   46: astore 4
    //   48: aload 4
    //   50: astore 5
    //   52: aload 4
    //   54: astore 6
    //   56: aload 4
    //   58: astore_3
    //   59: ldc_w 319
    //   62: aload 4
    //   64: getstatic 48	com/growingio/android/sdk/collection/DBAdapter$Table:a	Lcom/growingio/android/sdk/collection/DBAdapter$Table;
    //   67: invokevirtual 51	com/growingio/android/sdk/collection/DBAdapter$Table:a	()Ljava/lang/String;
    //   70: ldc_w 321
    //   73: iconst_1
    //   74: anewarray 233	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: lload_1
    //   80: invokestatic 324	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   83: aastore
    //   84: invokevirtual 271	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   87: invokestatic 327	com/growingio/android/sdk/collection/DiagnoseLog:a	(Ljava/lang/String;I)V
    //   90: aload 4
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokespecial 175	com/growingio/android/sdk/collection/DBAdapter:f	()V
    //   99: aload 7
    //   101: monitorexit
    //   102: return
    //   103: astore_3
    //   104: aload 5
    //   106: astore_3
    //   107: ldc_w 273
    //   110: invokestatic 278	com/growingio/android/sdk/collection/DiagnoseLog:a	(Ljava/lang/String;)V
    //   113: aload 5
    //   115: ifnull -16 -> 99
    //   118: aload_0
    //   119: invokespecial 175	com/growingio/android/sdk/collection/DBAdapter:f	()V
    //   122: goto -23 -> 99
    //   125: astore_3
    //   126: aload 7
    //   128: monitorexit
    //   129: aload_3
    //   130: athrow
    //   131: astore_3
    //   132: aload 6
    //   134: astore_3
    //   135: ldc_w 329
    //   138: invokestatic 278	com/growingio/android/sdk/collection/DiagnoseLog:a	(Ljava/lang/String;)V
    //   141: aload 6
    //   143: ifnull -44 -> 99
    //   146: aload_0
    //   147: invokespecial 175	com/growingio/android/sdk/collection/DBAdapter:f	()V
    //   150: goto -51 -> 99
    //   153: aload 4
    //   155: ifnull +7 -> 162
    //   158: aload_0
    //   159: invokespecial 175	com/growingio/android/sdk/collection/DBAdapter:f	()V
    //   162: aload_3
    //   163: athrow
    //   164: astore 5
    //   166: aload_3
    //   167: astore 4
    //   169: aload 5
    //   171: astore_3
    //   172: goto -19 -> 153
    //   175: astore_3
    //   176: aconst_null
    //   177: astore 4
    //   179: goto -26 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	DBAdapter
    //   0	182	1	paramLong	long
    //   58	1	3	localObject1	Object
    //   103	1	3	localSQLiteDiskIOException	android.database.sqlite.SQLiteDiskIOException
    //   106	1	3	localObject2	Object
    //   125	5	3	localObject3	Object
    //   131	1	3	localSQLException	android.database.SQLException
    //   134	38	3	localObject4	Object
    //   175	1	3	localObject5	Object
    //   46	132	4	localObject6	Object
    //   37	77	5	localObject7	Object
    //   164	6	5	localObject8	Object
    //   34	108	6	localObject9	Object
    //   28	99	7	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   39	48	103	android/database/sqlite/SQLiteDiskIOException
    //   59	90	103	android/database/sqlite/SQLiteDiskIOException
    //   95	99	125	finally
    //   99	102	125	finally
    //   118	122	125	finally
    //   126	129	125	finally
    //   146	150	125	finally
    //   158	162	125	finally
    //   162	164	125	finally
    //   39	48	131	android/database/SQLException
    //   59	90	131	android/database/SQLException
    //   59	90	164	finally
    //   107	113	164	finally
    //   135	141	164	finally
    //   39	48	175	finally
  }
  
  /* Error */
  void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: getstatic 295	com/growingio/android/sdk/collection/GConfig:DEBUG	Z
    //   6: ifeq +53 -> 59
    //   9: new 38	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 332
    //   19: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: astore 6
    //   24: iload_2
    //   25: ifeq +236 -> 261
    //   28: ldc 65
    //   30: astore 4
    //   32: ldc_w 334
    //   35: aload 6
    //   37: aload 4
    //   39: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 336
    //   45: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_3
    //   49: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 342	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   58: pop
    //   59: invokestatic 346	com/growingio/android/sdk/collection/GConfig:s	()Lcom/growingio/android/sdk/collection/GConfig;
    //   62: invokevirtual 349	com/growingio/android/sdk/collection/GConfig:m	()Z
    //   65: ifeq +24 -> 89
    //   68: new 351	com/growingio/android/sdk/utils/FileOutUtil
    //   71: dup
    //   72: invokestatic 123	com/growingio/android/sdk/collection/AppState:l	()Lcom/growingio/android/sdk/collection/AppState;
    //   75: invokevirtual 355	com/growingio/android/sdk/collection/AppState:k	()Landroid/content/Context;
    //   78: ldc_w 357
    //   81: invokespecial 360	com/growingio/android/sdk/utils/FileOutUtil:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   84: aload_3
    //   85: invokevirtual 363	com/growingio/android/sdk/utils/FileOutUtil:a	(Ljava/lang/String;)Z
    //   88: pop
    //   89: getstatic 212	com/growingio/android/sdk/collection/GrowingIO:testHandler	Landroid/os/Handler;
    //   92: ifnull +31 -> 123
    //   95: getstatic 212	com/growingio/android/sdk/collection/GrowingIO:testHandler	Landroid/os/Handler;
    //   98: ldc_w 364
    //   101: iconst_3
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload_1
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: iload_2
    //   112: invokestatic 367	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   115: aastore
    //   116: dup
    //   117: iconst_2
    //   118: aload_3
    //   119: aastore
    //   120: invokestatic 223	com/growingio/android/sdk/utils/Util:a	(Landroid/os/Handler;I[Ljava/lang/Object;)V
    //   123: getstatic 36	com/growingio/android/sdk/collection/DBAdapter:c	Ljava/lang/Object;
    //   126: astore 6
    //   128: aload 6
    //   130: monitorenter
    //   131: aload_0
    //   132: getfield 117	com/growingio/android/sdk/collection/DBAdapter:a	Lcom/growingio/android/sdk/collection/DBAdapter$DBHelper;
    //   135: invokevirtual 267	com/growingio/android/sdk/collection/DBAdapter$DBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   138: astore 4
    //   140: aload 4
    //   142: astore 5
    //   144: aload 5
    //   146: astore 4
    //   148: new 369	android/content/ContentValues
    //   151: dup
    //   152: invokespecial 370	android/content/ContentValues:<init>	()V
    //   155: astore 7
    //   157: aload 5
    //   159: astore 4
    //   161: aload 7
    //   163: ldc 55
    //   165: aload_1
    //   166: invokevirtual 374	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload 5
    //   171: astore 4
    //   173: aload 7
    //   175: ldc 59
    //   177: aload_3
    //   178: invokevirtual 374	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload 5
    //   183: astore 4
    //   185: aload 7
    //   187: ldc 61
    //   189: invokestatic 380	java/lang/System:currentTimeMillis	()J
    //   192: invokestatic 318	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   195: invokevirtual 383	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   198: aload 5
    //   200: astore 4
    //   202: aload 7
    //   204: ldc 65
    //   206: iload_2
    //   207: invokestatic 388	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   210: invokevirtual 391	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Boolean;)V
    //   213: aload 5
    //   215: astore 4
    //   217: ldc2_w 392
    //   220: aload 5
    //   222: getstatic 48	com/growingio/android/sdk/collection/DBAdapter$Table:a	Lcom/growingio/android/sdk/collection/DBAdapter$Table;
    //   225: invokevirtual 51	com/growingio/android/sdk/collection/DBAdapter$Table:a	()Ljava/lang/String;
    //   228: aconst_null
    //   229: aload 7
    //   231: invokevirtual 397	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   234: lcmp
    //   235: ifne +13 -> 248
    //   238: aload 5
    //   240: astore 4
    //   242: ldc_w 399
    //   245: invokestatic 278	com/growingio/android/sdk/collection/DiagnoseLog:a	(Ljava/lang/String;)V
    //   248: aload 5
    //   250: ifnull +7 -> 257
    //   253: aload_0
    //   254: invokespecial 175	com/growingio/android/sdk/collection/DBAdapter:f	()V
    //   257: aload 6
    //   259: monitorexit
    //   260: return
    //   261: ldc_w 401
    //   264: astore 4
    //   266: goto -234 -> 32
    //   269: astore_1
    //   270: aconst_null
    //   271: astore 5
    //   273: aload 5
    //   275: astore 4
    //   277: ldc_w 329
    //   280: invokestatic 278	com/growingio/android/sdk/collection/DiagnoseLog:a	(Ljava/lang/String;)V
    //   283: aload 5
    //   285: ifnull -28 -> 257
    //   288: aload_0
    //   289: invokespecial 175	com/growingio/android/sdk/collection/DBAdapter:f	()V
    //   292: goto -35 -> 257
    //   295: astore_1
    //   296: aload 6
    //   298: monitorexit
    //   299: aload_1
    //   300: athrow
    //   301: astore_1
    //   302: aload 5
    //   304: astore 4
    //   306: aload 4
    //   308: ifnull +7 -> 315
    //   311: aload_0
    //   312: invokespecial 175	com/growingio/android/sdk/collection/DBAdapter:f	()V
    //   315: aload_1
    //   316: athrow
    //   317: astore_1
    //   318: goto -12 -> 306
    //   321: astore_1
    //   322: goto -49 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	DBAdapter
    //   0	325	1	paramString1	String
    //   0	325	2	paramBoolean	boolean
    //   0	325	3	paramString2	String
    //   30	277	4	localObject1	Object
    //   1	302	5	localObject2	Object
    //   22	275	6	localObject3	Object
    //   155	75	7	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   131	140	269	java/lang/Exception
    //   253	257	295	finally
    //   257	260	295	finally
    //   288	292	295	finally
    //   296	299	295	finally
    //   311	315	295	finally
    //   315	317	295	finally
    //   131	140	301	finally
    //   148	157	317	finally
    //   161	169	317	finally
    //   173	181	317	finally
    //   185	198	317	finally
    //   202	213	317	finally
    //   217	238	317	finally
    //   242	248	317	finally
    //   277	283	317	finally
    //   148	157	321	java/lang/Exception
    //   161	169	321	java/lang/Exception
    //   173	181	321	java/lang/Exception
    //   185	198	321	java/lang/Exception
    //   202	213	321	java/lang/Exception
    //   217	238	321	java/lang/Exception
    //   242	248	321	java/lang/Exception
  }
  
  private class DBHelper
    extends SQLiteOpenHelper
  {
    DBHelper(Context paramContext)
    {
      super(Util.b(paramContext) + "growing.db", null, 3);
    }
    
    @SuppressLint({"SQLiteString"})
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL(DBAdapter.b());
      if (GrowingIO.testHandler != null) {
        GrowingIO.testHandler.obtainMessage(2097153).sendToTarget();
      }
    }
    
    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      if (paramInt1 == 2)
      {
        paramSQLiteDatabase.execSQL(DBAdapter.c());
        paramSQLiteDatabase.execSQL(DBAdapter.d());
        if (GrowingIO.testHandler != null) {
          Util.a(GrowingIO.testHandler, 2097154, new Object[0]);
        }
        return;
      }
      paramSQLiteDatabase.execSQL(DBAdapter.e());
      onCreate(paramSQLiteDatabase);
    }
  }
  
  private static enum Table
  {
    private String b;
    
    private Table(String paramString)
    {
      this.b = paramString;
    }
    
    public String a()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/DBAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */