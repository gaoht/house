package com.mob.commons.logcollector;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public class b
{
  private static b b = null;
  private a a = new a();
  
  public static b a()
  {
    try
    {
      if (b == null) {
        b = new b();
      }
      b localb = b;
      return localb;
    }
    finally {}
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/mob/commons/logcollector/b:a	Lcom/mob/commons/logcollector/a;
    //   4: invokevirtual 30	com/mob/commons/logcollector/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 36	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_3
    //   20: aload_3
    //   21: ifnonnull +17 -> 38
    //   24: iconst_0
    //   25: istore_2
    //   26: aload_3
    //   27: ifnull +9 -> 36
    //   30: aload_3
    //   31: invokeinterface 41 1 0
    //   36: iload_2
    //   37: ireturn
    //   38: aload_3
    //   39: astore_1
    //   40: aload_3
    //   41: invokeinterface 45 1 0
    //   46: istore_2
    //   47: goto -21 -> 26
    //   50: astore 4
    //   52: aconst_null
    //   53: astore_3
    //   54: aload_3
    //   55: astore_1
    //   56: invokestatic 51	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   59: aload 4
    //   61: invokevirtual 57	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   64: pop
    //   65: aload_3
    //   66: ifnull +35 -> 101
    //   69: aload_3
    //   70: invokeinterface 41 1 0
    //   75: iconst_0
    //   76: ireturn
    //   77: astore_3
    //   78: aconst_null
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +9 -> 90
    //   84: aload_1
    //   85: invokeinterface 41 1 0
    //   90: aload_3
    //   91: athrow
    //   92: astore_3
    //   93: goto -13 -> 80
    //   96: astore 4
    //   98: goto -44 -> 54
    //   101: iconst_0
    //   102: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	b
    //   0	103	1	paramString	String
    //   25	22	2	i	int
    //   7	63	3	localObject1	Object
    //   77	14	3	localObject2	Object
    //   92	1	3	localObject3	Object
    //   50	10	4	localThrowable1	Throwable
    //   96	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	20	50	java/lang/Throwable
    //   8	20	77	finally
    //   40	47	92	finally
    //   56	65	92	finally
    //   40	47	96	java/lang/Throwable
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    try
    {
      i = localSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
    }
    catch (Exception paramString2)
    {
      try
      {
        MobLog.getInstance().d("Deleted %d rows from table: %s", new Object[] { Integer.valueOf(i), paramString1 });
        return i;
      }
      catch (Exception paramString2)
      {
        int i;
        for (;;) {}
      }
      paramString2 = paramString2;
      i = 0;
    }
    tmp61_58[0] = paramString1;
    MobLog.getInstance().w(paramString2, "when delete database occur error table:%s,", tmp61_58);
    return i;
  }
  
  public long a(String paramString, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    try
    {
      long l = localSQLiteDatabase.replace(paramString, null, paramContentValues);
      return l;
    }
    catch (Exception paramContentValues)
    {
      MobLog.getInstance().w(paramContentValues, "when insert database occur error table:%s,", new Object[] { paramString });
    }
    return -1L;
  }
  
  public Cursor a(String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    try
    {
      paramString = localSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      return paramString;
    }
    catch (Exception paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/logcollector/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */