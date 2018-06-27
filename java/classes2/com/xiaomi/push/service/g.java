package com.xiaomi.push.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.k;
import java.util.ArrayList;
import java.util.Iterator;

public class g
{
  private static volatile g a;
  private f b;
  
  private g(Context paramContext)
  {
    this.b = new f(paramContext);
  }
  
  /* Error */
  private android.database.Cursor a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: iconst_0
    //   5: invokestatic 28	com/xiaomi/channel/commonutils/misc/k:a	(Z)V
    //   8: aload_1
    //   9: ldc 30
    //   11: aconst_null
    //   12: invokevirtual 36	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 40	java/lang/Exception:toString	()Ljava/lang/String;
    //   25: invokestatic 46	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   28: aload_2
    //   29: astore_1
    //   30: goto -14 -> 16
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	g
    //   0	38	1	paramSQLiteDatabase	SQLiteDatabase
    //   1	28	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	16	20	java/lang/Exception
    //   4	8	33	finally
    //   8	16	33	finally
    //   21	28	33	finally
  }
  
  public static g a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new g(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: iconst_0
    //   5: invokestatic 28	com/xiaomi/channel/commonutils/misc/k:a	(Z)V
    //   8: aload_1
    //   9: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: istore 4
    //   14: iload 4
    //   16: ifeq +7 -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: aload_0
    //   24: getfield 19	com/xiaomi/push/service/g:b	Lcom/xiaomi/push/service/f;
    //   27: invokevirtual 61	com/xiaomi/push/service/f:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore 5
    //   32: aload 5
    //   34: ldc 63
    //   36: ldc 65
    //   38: iconst_1
    //   39: anewarray 67	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: aload_1
    //   45: aastore
    //   46: invokevirtual 71	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   49: istore_3
    //   50: aload 5
    //   52: invokevirtual 74	android/database/sqlite/SQLiteDatabase:close	()V
    //   55: iload_3
    //   56: istore_2
    //   57: goto -38 -> 19
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 40	java/lang/Exception:toString	()Ljava/lang/String;
    //   65: invokestatic 46	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   68: goto -49 -> 19
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	g
    //   0	76	1	paramString	String
    //   1	56	2	i	int
    //   49	7	3	j	int
    //   12	3	4	bool	boolean
    //   30	21	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   23	55	60	java/lang/Exception
    //   4	14	71	finally
    //   23	55	71	finally
    //   61	68	71	finally
  }
  
  /* Error */
  public ArrayList<com.xiaomi.push.service.module.b> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: invokestatic 28	com/xiaomi/channel/commonutils/misc/k:a	(Z)V
    //   6: aload_0
    //   7: getfield 19	com/xiaomi/push/service/g:b	Lcom/xiaomi/push/service/f;
    //   10: invokevirtual 61	com/xiaomi/push/service/f:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: astore_2
    //   14: aload_0
    //   15: aload_2
    //   16: invokespecial 77	com/xiaomi/push/service/g:a	(Landroid/database/sqlite/SQLiteDatabase;)Landroid/database/Cursor;
    //   19: astore_3
    //   20: new 79	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 80	java/util/ArrayList:<init>	()V
    //   27: astore_1
    //   28: aload_3
    //   29: ifnull +146 -> 175
    //   32: aload_3
    //   33: invokeinterface 86 1 0
    //   38: ifeq +131 -> 169
    //   41: new 88	com/xiaomi/push/service/module/b
    //   44: dup
    //   45: invokespecial 89	com/xiaomi/push/service/module/b:<init>	()V
    //   48: astore 4
    //   50: aload 4
    //   52: aload_3
    //   53: aload_3
    //   54: ldc 91
    //   56: invokeinterface 94 2 0
    //   61: invokeinterface 98 2 0
    //   66: invokevirtual 100	com/xiaomi/push/service/module/b:a	(Ljava/lang/String;)V
    //   69: aload 4
    //   71: aload_3
    //   72: aload_3
    //   73: ldc 102
    //   75: invokeinterface 94 2 0
    //   80: invokeinterface 98 2 0
    //   85: invokevirtual 104	com/xiaomi/push/service/module/b:b	(Ljava/lang/String;)V
    //   88: aload 4
    //   90: aload_3
    //   91: aload_3
    //   92: ldc 106
    //   94: invokeinterface 94 2 0
    //   99: invokeinterface 110 2 0
    //   104: invokevirtual 113	com/xiaomi/push/service/module/b:a	([B)V
    //   107: aload 4
    //   109: aload_3
    //   110: aload_3
    //   111: ldc 115
    //   113: invokeinterface 94 2 0
    //   118: invokeinterface 119 2 0
    //   123: invokevirtual 122	com/xiaomi/push/service/module/b:a	(I)V
    //   126: aload 4
    //   128: aload_3
    //   129: aload_3
    //   130: ldc 124
    //   132: invokeinterface 94 2 0
    //   137: invokeinterface 128 2 0
    //   142: invokevirtual 131	com/xiaomi/push/service/module/b:a	(J)V
    //   145: aload_1
    //   146: aload 4
    //   148: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   151: pop
    //   152: goto -120 -> 32
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 40	java/lang/Exception:toString	()Ljava/lang/String;
    //   160: invokestatic 46	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   163: aconst_null
    //   164: astore_1
    //   165: aload_0
    //   166: monitorexit
    //   167: aload_1
    //   168: areturn
    //   169: aload_3
    //   170: invokeinterface 136 1 0
    //   175: aload_2
    //   176: invokevirtual 74	android/database/sqlite/SQLiteDatabase:close	()V
    //   179: goto -14 -> 165
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	g
    //   27	119	1	localArrayList	ArrayList
    //   155	2	1	localException	Exception
    //   164	4	1	localArrayList1	ArrayList<com.xiaomi.push.service.module.b>
    //   182	4	1	localObject	Object
    //   13	163	2	localSQLiteDatabase	SQLiteDatabase
    //   19	151	3	localCursor	android.database.Cursor
    //   48	99	4	localb	com.xiaomi.push.service.module.b
    // Exception table:
    //   from	to	target	type
    //   6	28	155	java/lang/Exception
    //   32	152	155	java/lang/Exception
    //   169	175	155	java/lang/Exception
    //   175	179	155	java/lang/Exception
    //   2	6	182	finally
    //   6	28	182	finally
    //   32	152	182	finally
    //   156	163	182	finally
    //   169	175	182	finally
    //   175	179	182	finally
  }
  
  public boolean a(ArrayList<ContentValues> paramArrayList)
  {
    label119:
    for (;;)
    {
      try
      {
        k.a(false);
        if (paramArrayList != null)
        {
          int i = paramArrayList.size();
          if (i > 0) {}
        }
        else
        {
          bool = false;
          return bool;
        }
        try
        {
          SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
          localSQLiteDatabase.beginTransaction();
          paramArrayList = paramArrayList.iterator();
          if (!paramArrayList.hasNext()) {
            break label119;
          }
          if (-1L != localSQLiteDatabase.insert("geoMessage", null, (ContentValues)paramArrayList.next())) {
            continue;
          }
          bool = false;
          if (bool) {
            localSQLiteDatabase.setTransactionSuccessful();
          }
          localSQLiteDatabase.endTransaction();
          localSQLiteDatabase.close();
        }
        catch (Exception paramArrayList)
        {
          b.d(paramArrayList.toString());
          bool = false;
        }
        continue;
        boolean bool = true;
      }
      finally {}
    }
  }
  
  /* Error */
  public int b(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: iconst_0
    //   5: invokestatic 28	com/xiaomi/channel/commonutils/misc/k:a	(Z)V
    //   8: aload_1
    //   9: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: istore 4
    //   14: iload 4
    //   16: ifeq +7 -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: aload_0
    //   24: getfield 19	com/xiaomi/push/service/g:b	Lcom/xiaomi/push/service/f;
    //   27: invokevirtual 61	com/xiaomi/push/service/f:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore 5
    //   32: aload 5
    //   34: ldc 63
    //   36: ldc -80
    //   38: iconst_1
    //   39: anewarray 67	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: aload_1
    //   45: aastore
    //   46: invokevirtual 71	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   49: istore_3
    //   50: aload 5
    //   52: invokevirtual 74	android/database/sqlite/SQLiteDatabase:close	()V
    //   55: iload_3
    //   56: istore_2
    //   57: goto -38 -> 19
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 40	java/lang/Exception:toString	()Ljava/lang/String;
    //   65: invokestatic 46	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   68: goto -49 -> 19
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	g
    //   0	76	1	paramString	String
    //   1	56	2	i	int
    //   49	7	3	j	int
    //   12	3	4	bool	boolean
    //   30	21	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   23	55	60	java/lang/Exception
    //   4	14	71	finally
    //   23	55	71	finally
    //   61	68	71	finally
  }
  
  /* Error */
  public ArrayList<com.xiaomi.push.service.module.b> c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: invokestatic 28	com/xiaomi/channel/commonutils/misc/k:a	(Z)V
    //   6: aload_1
    //   7: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifeq +9 -> 21
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aload_0
    //   22: invokevirtual 180	com/xiaomi/push/service/g:a	()Ljava/util/ArrayList;
    //   25: astore 4
    //   27: new 79	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 80	java/util/ArrayList:<init>	()V
    //   34: astore_3
    //   35: aload 4
    //   37: invokevirtual 150	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   40: astore 4
    //   42: aload 4
    //   44: invokeinterface 155 1 0
    //   49: ifeq +50 -> 99
    //   52: aload 4
    //   54: invokeinterface 161 1 0
    //   59: checkcast 88	com/xiaomi/push/service/module/b
    //   62: astore 5
    //   64: aload 5
    //   66: invokevirtual 182	com/xiaomi/push/service/module/b:c	()Ljava/lang/String;
    //   69: aload_1
    //   70: invokestatic 186	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   73: ifeq -31 -> 42
    //   76: aload_3
    //   77: aload 5
    //   79: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: goto -41 -> 42
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 40	java/lang/Exception:toString	()Ljava/lang/String;
    //   91: invokestatic 46	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   94: aconst_null
    //   95: astore_1
    //   96: goto -79 -> 17
    //   99: aload_3
    //   100: astore_1
    //   101: goto -84 -> 17
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	g
    //   0	109	1	paramString	String
    //   10	2	2	bool	boolean
    //   34	66	3	localArrayList	ArrayList
    //   25	28	4	localObject	Object
    //   62	16	5	localb	com.xiaomi.push.service.module.b
    // Exception table:
    //   from	to	target	type
    //   21	42	86	java/lang/Exception
    //   42	83	86	java/lang/Exception
    //   2	11	104	finally
    //   21	42	104	finally
    //   42	83	104	finally
    //   87	94	104	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */