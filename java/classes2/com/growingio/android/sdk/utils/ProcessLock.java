package com.growingio.android.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

public class ProcessLock
  extends SQLiteOpenHelper
{
  private SQLiteDatabase a;
  
  public ProcessLock(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  public void a()
  {
    if (this.a != null) {}
    try
    {
      this.a.endTransaction();
      this.a = null;
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
  
  @TargetApi(11)
  public boolean a(int paramInt)
  {
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        this.a = getWritableDatabase();
        this.a.beginTransaction();
        return true;
      }
      catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
      {
        if (System.currentTimeMillis() - l >= paramInt) {
          return false;
        }
        try
        {
          Thread.sleep(100L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/ProcessLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */