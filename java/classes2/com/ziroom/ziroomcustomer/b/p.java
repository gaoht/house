package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class p
{
  public static void createTable(com.freelxl.baselibrary.c.b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_search_history(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("search_item\tvarchar,");
    localStringBuffer.append("city_id    varchar");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static void delete(Context paramContext)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_search_history", new Object[0]);
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private static void delete(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    localb.delete("t_search_history", "search_item=?", new String[] { paramString });
    paramContext.releaseSession(localb);
  }
  
  public static void delete(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM t_search_history", new Object[0]);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  /* Error */
  public static long getCount(Context paramContext)
  {
    // Byte code:
    //   0: new 44	com/ziroom/ziroomcustomer/b/e
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 46	com/ziroom/ziroomcustomer/b/e:<init>	(Landroid/content/Context;)V
    //   8: astore 6
    //   10: aload 6
    //   12: invokevirtual 50	com/ziroom/ziroomcustomer/b/e:getSession	()Lcom/freelxl/baselibrary/c/b;
    //   15: astore 7
    //   17: aconst_null
    //   18: astore_0
    //   19: aconst_null
    //   20: astore 5
    //   22: aload 7
    //   24: ldc 79
    //   26: iconst_1
    //   27: anewarray 68	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: getstatic 85	com/ziroom/ziroomcustomer/base/b:d	Ljava/lang/String;
    //   35: aastore
    //   36: invokevirtual 89	com/freelxl/baselibrary/c/b:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore 4
    //   41: aload 4
    //   43: ifnull +23 -> 66
    //   46: aload 4
    //   48: invokeinterface 94 1 0
    //   53: istore_1
    //   54: iload_1
    //   55: i2l
    //   56: lstore_2
    //   57: aload 4
    //   59: invokeinterface 97 1 0
    //   64: lload_2
    //   65: lreturn
    //   66: aload 4
    //   68: invokeinterface 97 1 0
    //   73: aload 6
    //   75: aload 7
    //   77: invokevirtual 58	com/ziroom/ziroomcustomer/b/e:releaseSession	(Lcom/freelxl/baselibrary/c/b;)V
    //   80: lconst_0
    //   81: lreturn
    //   82: astore_0
    //   83: aload 5
    //   85: astore 4
    //   87: aload_0
    //   88: astore 5
    //   90: aload 4
    //   92: astore_0
    //   93: aload 5
    //   95: invokevirtual 61	java/lang/Exception:printStackTrace	()V
    //   98: aload 4
    //   100: invokeinterface 97 1 0
    //   105: goto -32 -> 73
    //   108: astore 5
    //   110: aload_0
    //   111: astore 4
    //   113: aload 5
    //   115: astore_0
    //   116: aload 4
    //   118: invokeinterface 97 1 0
    //   123: aload_0
    //   124: athrow
    //   125: astore_0
    //   126: goto -10 -> 116
    //   129: astore 5
    //   131: goto -41 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramContext	Context
    //   53	2	1	i	int
    //   56	9	2	l	long
    //   39	78	4	localObject1	Object
    //   20	74	5	localContext	Context
    //   108	6	5	localObject2	Object
    //   129	1	5	localException	Exception
    //   8	66	6	locale	e
    //   15	61	7	localb	com.freelxl.baselibrary.c.b
    // Exception table:
    //   from	to	target	type
    //   22	41	82	java/lang/Exception
    //   22	41	108	finally
    //   93	98	108	finally
    //   46	54	125	finally
    //   46	54	129	java/lang/Exception
  }
  
  public static List<String> query(Context paramContext)
  {
    e locale = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = locale.getSession();
    for (;;)
    {
      try
      {
        localArrayList1 = new ArrayList();
      }
      catch (Exception localException2)
      {
        Context localContext;
        ArrayList localArrayList3;
        ArrayList localArrayList1 = null;
        paramContext = null;
        continue;
      }
      try
      {
        paramContext = localb.rawQuery("SELECT * FROM t_search_history WHERE city_id = ?  order by id desc limit 0,5", new String[] { com.ziroom.ziroomcustomer.base.b.d });
        try
        {
          paramContext.moveToFirst();
          localContext = paramContext;
          ArrayList localArrayList2 = localArrayList1;
          if (paramContext.isAfterLast()) {
            continue;
          }
          localArrayList1.add(paramContext.getString(paramContext.getColumnIndex("search_item")));
          paramContext.moveToNext();
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException3)
      {
        paramContext = null;
      }
    }
    localArrayList3 = localArrayList1;
    localContext = paramContext;
    locale.releaseSession(localb);
    localContext.close();
    return localArrayList3;
  }
  
  public static List<String> query(SQLiteDatabase paramSQLiteDatabase)
  {
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList();
      }
      catch (Exception localException2)
      {
        ArrayList localArrayList = null;
        paramSQLiteDatabase = null;
        continue;
      }
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.query("t_search_history", null, null, null, null, null, null);
        try
        {
          paramSQLiteDatabase.moveToFirst();
          if (paramSQLiteDatabase.isAfterLast()) {
            continue;
          }
          localArrayList.add(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("search_item")));
          paramSQLiteDatabase.moveToNext();
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException3)
      {
        paramSQLiteDatabase = null;
        continue;
      }
      paramSQLiteDatabase.close();
      return localArrayList;
    }
  }
  
  public static void save(Context paramContext, String paramString)
  {
    save(paramContext, paramString, null);
  }
  
  public static void save(Context paramContext, String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    paramContext = new e(paramContext);
    paramSQLiteDatabase = paramContext.getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("search_item", paramString);
      localContentValues.put("city_Id", com.ziroom.ziroomcustomer.base.b.d);
      paramSQLiteDatabase.delete("t_search_history", "search_item=?", new String[] { paramString });
      paramSQLiteDatabase.insert("t_search_history", null, localContentValues);
      if (paramContext != null) {
        paramContext.releaseSession(paramSQLiteDatabase);
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void deleteTable(Context paramContext)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      localb.execSQL("drop table t_search_history");
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */