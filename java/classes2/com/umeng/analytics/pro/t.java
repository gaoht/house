package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

class t
  extends SQLiteOpenHelper
{
  private static Context b = null;
  private String a = null;
  
  private t(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, str, paramCursorFactory, paramInt);
    b();
  }
  
  private t(Context paramContext, String paramString1, String paramString2, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    this(new r(paramContext, paramString1), paramString2, paramCursorFactory, paramInt);
  }
  
  public static t a(Context paramContext)
  {
    try
    {
      b = paramContext;
      paramContext = a.a();
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      this.a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER)";
      paramSQLiteDatabase.execSQL(this.a);
      return;
    }
    catch (SQLException paramSQLiteDatabase) {}
  }
  
  private void b()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      if (!v.a("__sd", localSQLiteDatabase)) {
        c(localSQLiteDatabase);
      }
      if (!v.a("__et", localSQLiteDatabase)) {
        b(localSQLiteDatabase);
      }
      if (!v.a("__er", localSQLiteDatabase)) {
        a(localSQLiteDatabase);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      this.a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER)";
      paramSQLiteDatabase.execSQL(this.a);
      return;
    }
    catch (SQLException paramSQLiteDatabase) {}
  }
  
  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      this.a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT)";
      paramSQLiteDatabase.execSQL(this.a);
      return;
    }
    catch (SQLException paramSQLiteDatabase) {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.beginTransaction();
      c(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
      a(paramSQLiteDatabase);
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  private static class a
  {
    private static final t a = new t(t.a(), v.a(t.a()), "ua.db", null, 1, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */