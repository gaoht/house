package cn.testin.analysis;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class o
{
  private n a = n.a(a.d);
  
  /* Error */
  public int a(ContentValues paramContentValues)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 24	cn/testin/analysis/o:a	Lcn/testin/analysis/n;
    //   9: astore 6
    //   11: aload 6
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 24	cn/testin/analysis/o:a	Lcn/testin/analysis/n;
    //   18: invokevirtual 32	cn/testin/analysis/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore 5
    //   23: aload 5
    //   25: astore_3
    //   26: aload 5
    //   28: astore 4
    //   30: aload_0
    //   31: aload 5
    //   33: aload_1
    //   34: invokevirtual 35	cn/testin/analysis/o:a	(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/ContentValues;)J
    //   37: pop2
    //   38: aload 5
    //   40: astore_3
    //   41: aload 5
    //   43: astore 4
    //   45: aload_0
    //   46: getfield 24	cn/testin/analysis/o:a	Lcn/testin/analysis/n;
    //   49: aload 5
    //   51: ldc 37
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 41	cn/testin/analysis/n:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   58: istore_2
    //   59: aload 5
    //   61: ifnull +12 -> 73
    //   64: aload_0
    //   65: getfield 24	cn/testin/analysis/o:a	Lcn/testin/analysis/n;
    //   68: aload 5
    //   70: invokevirtual 44	cn/testin/analysis/n:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   73: aload 6
    //   75: monitorexit
    //   76: iload_2
    //   77: ireturn
    //   78: astore_1
    //   79: aload_3
    //   80: astore 4
    //   82: aload_1
    //   83: invokestatic 49	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   86: aload_3
    //   87: ifnull +11 -> 98
    //   90: aload_0
    //   91: getfield 24	cn/testin/analysis/o:a	Lcn/testin/analysis/n;
    //   94: aload_3
    //   95: invokevirtual 44	cn/testin/analysis/n:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   98: aload 6
    //   100: monitorexit
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_1
    //   104: aload 4
    //   106: ifnull +12 -> 118
    //   109: aload_0
    //   110: getfield 24	cn/testin/analysis/o:a	Lcn/testin/analysis/n;
    //   113: aload 4
    //   115: invokevirtual 44	cn/testin/analysis/n:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: aload 6
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	o
    //   0	126	1	paramContentValues	ContentValues
    //   58	19	2	i	int
    //   4	91	3	localObject1	Object
    //   1	113	4	localObject2	Object
    //   21	48	5	localSQLiteDatabase	SQLiteDatabase
    //   9	113	6	localn	n
    // Exception table:
    //   from	to	target	type
    //   14	23	78	java/lang/Exception
    //   30	38	78	java/lang/Exception
    //   45	59	78	java/lang/Exception
    //   14	23	103	finally
    //   30	38	103	finally
    //   45	59	103	finally
    //   82	86	103	finally
    //   64	73	120	finally
    //   73	76	120	finally
    //   90	98	120	finally
    //   98	101	120	finally
    //   109	118	120	finally
    //   118	120	120	finally
    //   121	124	120	finally
  }
  
  public long a()
  {
    return a(null);
  }
  
  public long a(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues)
  {
    return this.a.a(paramSQLiteDatabase, "track", paramContentValues);
  }
  
  public long a(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    return this.a.a(paramSQLiteDatabase, "track", paramString, paramArrayOfString);
  }
  
  public long a(String paramString)
  {
    String str = null;
    Object localObject;
    label99:
    for (;;)
    {
      synchronized (this.a)
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramString = null;
          break label99;
          localObject = this.a.getWritableDatabase();
        }
        try
        {
          long l = a((SQLiteDatabase)localObject, str, paramString);
          this.a.a((SQLiteDatabase)localObject);
          return l;
        }
        finally
        {
          this.a.a((SQLiteDatabase)localObject);
        }
        localObject = new String[1];
        localObject[0] = paramString;
        paramString = (String)localObject;
      }
      str = "_id <= ?";
    }
  }
  
  /* Error */
  public List<h> b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 24	cn/testin/analysis/o:a	Lcn/testin/analysis/n;
    //   7: astore 5
    //   9: aload 5
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 24	cn/testin/analysis/o:a	Lcn/testin/analysis/n;
    //   16: invokevirtual 32	cn/testin/analysis/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_1
    //   22: aload_0
    //   23: aload_2
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 75	cn/testin/analysis/o:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   29: astore_3
    //   30: aload_3
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 24	cn/testin/analysis/o:a	Lcn/testin/analysis/n;
    //   36: aload_2
    //   37: invokevirtual 44	cn/testin/analysis/n:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   40: aload 5
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: astore_3
    //   46: aconst_null
    //   47: astore_2
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: invokestatic 49	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   54: aload_0
    //   55: getfield 24	cn/testin/analysis/o:a	Lcn/testin/analysis/n;
    //   58: aload_2
    //   59: invokevirtual 44	cn/testin/analysis/n:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   62: aload 4
    //   64: astore_1
    //   65: goto -25 -> 40
    //   68: astore_1
    //   69: aload 5
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 24	cn/testin/analysis/o:a	Lcn/testin/analysis/n;
    //   81: aload_1
    //   82: invokevirtual 44	cn/testin/analysis/n:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   85: aload_2
    //   86: athrow
    //   87: astore_2
    //   88: goto -11 -> 77
    //   91: astore_3
    //   92: goto -44 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	o
    //   21	44	1	localObject1	Object
    //   68	5	1	localObject2	Object
    //   76	6	1	localSQLiteDatabase1	SQLiteDatabase
    //   19	40	2	localSQLiteDatabase2	SQLiteDatabase
    //   74	12	2	localObject3	Object
    //   87	1	2	localObject4	Object
    //   29	2	3	localList	List
    //   45	6	3	localException1	Exception
    //   91	1	3	localException2	Exception
    //   1	62	4	localObject5	Object
    //   7	63	5	localn	n
    // Exception table:
    //   from	to	target	type
    //   12	20	45	java/lang/Exception
    //   32	40	68	finally
    //   40	43	68	finally
    //   54	62	68	finally
    //   69	72	68	finally
    //   77	87	68	finally
    //   12	20	74	finally
    //   22	30	87	finally
    //   50	54	87	finally
    //   22	30	91	java/lang/Exception
  }
  
  public List<h> b(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    Object localObject = null;
    paramArrayOfString = this.a.a(paramSQLiteDatabase, "track", null, paramString, paramArrayOfString, null, null, "_id ASC LIMIT " + String.valueOf(50));
    paramSQLiteDatabase = (SQLiteDatabase)localObject;
    if (paramArrayOfString != null)
    {
      paramString = new ArrayList();
      while (paramArrayOfString.moveToNext())
      {
        paramSQLiteDatabase = new h();
        paramSQLiteDatabase.a = paramArrayOfString.getString(paramArrayOfString.getColumnIndex("_id"));
        paramSQLiteDatabase.b = paramArrayOfString.getString(paramArrayOfString.getColumnIndex("name"));
        paramSQLiteDatabase.e = paramArrayOfString.getDouble(paramArrayOfString.getColumnIndex("value"));
        paramSQLiteDatabase.c = paramArrayOfString.getString(paramArrayOfString.getColumnIndex("expId"));
        paramSQLiteDatabase.d = paramArrayOfString.getString(paramArrayOfString.getColumnIndex("componentsKey"));
        paramSQLiteDatabase.f = paramArrayOfString.getLong(paramArrayOfString.getColumnIndex("timestamp"));
        paramString.add(paramSQLiteDatabase);
      }
      paramSQLiteDatabase = paramString;
      if (!paramArrayOfString.isClosed())
      {
        paramArrayOfString.close();
        paramSQLiteDatabase = paramString;
      }
    }
    return paramSQLiteDatabase;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */